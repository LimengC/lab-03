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

public class AddCityFragment extends DialogFragment {

    public interface AddCityDialogListener { void addCity(City city); }

    public static AddCityFragment newInstance() {
        return new AddCityFragment();
    }

    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_city, null);
        EditText editCity = view.findViewById(R.id.edit_text_city_text);
        EditText editProv = view.findViewById(R.id.edit_text_province_text);

        return new AlertDialog.Builder(requireContext())
                .setTitle("Add a city")
                .setView(view)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Add", (d, w) -> {
                    City c = new City(
                            editCity.getText().toString().trim(),
                            editProv.getText().toString().trim()
                    );
                    if (getActivity() instanceof AddCityDialogListener) {
                        ((AddCityDialogListener) getActivity()).addCity(c);
                    }
                })
                .create();
    }
}


