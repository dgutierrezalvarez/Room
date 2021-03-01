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

import com.company.roomlogin.databinding.FragmentPremioBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class PremioFragment extends Fragment {

    private FragmentPremioBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPremioBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area2));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area3));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area4));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area5));
        YoYo.with(Techniques.FadeIn)
                .duration(1200)
                .repeat(6)
                .playOn(view.findViewById(R.id.edit_area6));



        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);


        binding.reclamar.setOnClickListener(v -> navController.navigate(R.id.action_premioFragment_to_homeFragment));



    }
}
