package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.company.roomlogin.databinding.FragmentPerfilBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;
import com.google.android.material.tabs.TabLayoutMediator;


public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;
    private AutenticacionViewModel autenticacionViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPerfilBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.viewpager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new MedallasFragment();
                    case 1:
                        return new CarrerasFragment();
                }
            }

            @Override
            public int getItemCount() { return 2; }
        });

        new TabLayoutMediator(binding.tabLayout, binding.viewpager2, (tab, position) -> {
            switch (position) {
                case 0: default:
                    tab.setText("Medallas");
                    break;
                case 1:
                    tab.setText("Carreras");
                    break;
            }
        }).attach();

    }

}
