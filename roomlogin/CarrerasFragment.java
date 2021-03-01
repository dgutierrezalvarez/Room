package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.company.roomlogin.databinding.FragmentCarrerasBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;


public class CarrerasFragment extends Fragment {

    private FragmentCarrerasBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return (binding = FragmentCarrerasBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.montblanc.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡CONSULTA EL CALENDARIO!", Toast.LENGTH_SHORT).show();
        });
        binding.elbesos.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡VES A LA CARRERA!", Toast.LENGTH_SHORT).show();
        });
        binding.prehistoria.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡CONSULTA EL CALENDARIO!", Toast.LENGTH_SHORT).show();
        });
        binding.paseo.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡CONSULTA EL CALENDARIO!", Toast.LENGTH_SHORT).show();
        });
        binding.comus.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡CONSULTA EL CALENDARIO!", Toast.LENGTH_SHORT).show();
        });
        binding.proximamente.setOnClickListener(v -> {
            Toast.makeText(getContext(), "¡PROXIMAMENTE!", Toast.LENGTH_SHORT).show();
        });



    }

}