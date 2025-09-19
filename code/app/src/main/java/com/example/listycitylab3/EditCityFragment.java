package com.example.listycitylab3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class EditCityFragment extends DialogFragment {

    public interface EditCityDialogListener {
        void onCityEdited(int position, String newName, String newProvince);
    }

    private static final String ARG_CITY = "arg_city";
    private static final String ARG_POSITION = "arg_position";

    public static EditCityFragment newInstance(City city, int position) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CITY, city);
        args.putInt(ARG_POSITION, position);
        EditCityFragment fragment = new EditCityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        City city = (City) requireArguments().getSerializable(ARG_CITY);
        int position = requireArguments().getInt(ARG_POSITION);

        View view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_edit_city, null);
        EditText editCity = view.findViewById(R.id.edit_text_city_text);
        EditText editProv = view.findViewById(R.id.edit_text_province_text);

        if (city != null) {
            editCity.setText(city.getName());
            editProv.setText(city.getProvince());
        }

        return new AlertDialog.Builder(requireContext())
                .setTitle("Edit City")
                .setView(view)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", (d, w) -> {
                    String newName = editCity.getText().toString().trim();
                    String newProv = editProv.getText().toString().trim();
                    if (getActivity() instanceof EditCityDialogListener) {
                        ((EditCityDialogListener) getActivity()).onCityEdited(position, newName, newProv);
                    }
                })
                .create();
    }
}
