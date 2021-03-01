package com.company.roomlogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.company.roomlogin.databinding.FragmentInsertarBinding;
import com.company.roomlogin.viewmodel.PersonasViewModel;

public class InsertarFragment extends Fragment{

        private FragmentInsertarBinding binding;
        private NavController navController;
        private PersonasViewModel personasViewModel;

        private Uri imagenSeleccionada;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return (binding = FragmentInsertarBinding.inflate(inflater, container, false)).getRoot();
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personasViewModel = new ViewModelProvider(requireActivity()).get(PersonasViewModel.class);
        navController = Navigation.findNavController(view);

        binding.insertar.setOnClickListener(v -> {
            if (imagenSeleccionada == null) {
                Toast.makeText(requireContext(), "Seleccione una imagen", Toast.LENGTH_SHORT).show();
                return;
            } else if (binding.nombre.getText().toString().isEmpty()) {
                binding.nombre.setError("Introduzca el titulo");
                return;
            }
            String nombre = binding.nombre.getText().toString();


            personasViewModel.insertarPersonas(nombre, imagenSeleccionada.toString());

            personasViewModel.establecerImagenSeleccionada(null);
            navController.popBackStack();

        });



        binding.portada.setOnClickListener(v -> {
            lanzadorGaleria.launch(new String[]{"image/*"});
        });

        personasViewModel.imagenSeleccionada.observe(getViewLifecycleOwner(), uri -> {
            if (uri != null) {
                imagenSeleccionada = uri;
                Glide.with(requireView()).load(uri).into(binding.portada);
            }
        });
    }

    private final ActivityResultLauncher<String[]> lanzadorGaleria = registerForActivityResult(new ActivityResultContracts.OpenDocument(), uri -> {
        requireContext().getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        personasViewModel.establecerImagenSeleccionada(uri);
    });
}


