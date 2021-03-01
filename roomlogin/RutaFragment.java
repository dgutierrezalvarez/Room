package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.company.roomlogin.databinding.FragmentRutaBinding;

import com.company.roomlogin.viewmodel.AutenticacionViewModel;

public class RutaFragment extends Fragment {

    private FragmentRutaBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRutaBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
