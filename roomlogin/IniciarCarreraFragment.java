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

import com.company.roomlogin.databinding.FragmentIniciarCarreraBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;

public class IniciarCarreraFragment extends Fragment {

    private FragmentIniciarCarreraBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentIniciarCarreraBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);
        binding.iniciarCarrera.setOnClickListener(v -> navController.navigate(R.id.action_iniciarCarreraFragment_to_tiempoCarreraFragment));




    }
}
