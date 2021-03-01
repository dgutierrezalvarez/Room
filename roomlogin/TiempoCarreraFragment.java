package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.company.roomlogin.databinding.FragmentTiempoCarreraBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;

public class TiempoCarreraFragment extends Fragment {

    private FragmentTiempoCarreraBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTiempoCarreraBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);

        binding.buttonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_tiempoCarreraFragment_to_carreraFragment);
            }

        });

        binding.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_tiempoCarreraFragment_to_cargandoFragment);
            }

        });


    }

}


