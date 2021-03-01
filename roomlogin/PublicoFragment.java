 package com.company.roomlogin;

 import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.company.roomlogin.databinding.FragmentPublicoBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;


 public class PublicoFragment extends Fragment {

     private FragmentPublicoBinding binding;
     private AutenticacionViewModel autenticacionViewModel;
     private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publico, container, false);
    }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

     }
}