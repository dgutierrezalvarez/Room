package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.company.roomlogin.databinding.FragmentIniciarSesionBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class IniciarSesionFragment extends Fragment {


    private FragmentIniciarSesionBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentIniciarSesionBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageButton.setOnClickListener(v -> {
            YoYo.with(Techniques.Shake)
                    .duration(1200)
                    .repeat(0)
                    .playOn(view.findViewById(R.id.imageButton));
            Toast.makeText(getContext(), "NO DISPONIBLE", Toast.LENGTH_SHORT).show();
        });
        binding.imageButton2.setOnClickListener(v -> {
            YoYo.with(Techniques.Shake)
                    .duration(1200)
                    .repeat(0)
                    .playOn(view.findViewById(R.id.imageButton2));
            Toast.makeText(getContext(), "NO DISPONIBLE", Toast.LENGTH_SHORT).show();
        });

        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);

        binding.irAlRegistro.setOnClickListener(v -> navController.navigate(R.id.action_iniciarSesionFragment_to_registroFragment));


        binding.iniciarSesion.setOnClickListener(v -> {
            String username = binding.username.getText().toString();
            String password = binding.password.getText().toString();


            autenticacionViewModel.iniciarSesion(username, password);
        });

        autenticacionViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), estadoDeLaAutenticacion -> {
            switch (estadoDeLaAutenticacion){
                case AUTENTICADO:
                    navController.navigate(R.id.action_iniciarSesionFragment_to_inicioFragment);
                    break;

                case AUTENTICACION_INVALIDA:
                    Toast.makeText(getContext(), "CREDENCIALES NO VALIDAS", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}