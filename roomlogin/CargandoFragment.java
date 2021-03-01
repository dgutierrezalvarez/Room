package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.company.roomlogin.databinding.FragmentCargandoBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class CargandoFragment extends Fragment {
    private FragmentCargandoBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;
    Executor executor = Executors.newSingleThreadExecutor();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCargandoBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        // esta variable deberia estar en un ViewModel
        MutableLiveData<Boolean> finishedLoading = new MutableLiveData<>();



        finishedLoading.observe(getViewLifecycleOwner(), aBoolean -> navController.navigate(R.id.action_cargandoFragment_to_premioFragment));

        // esto deberia estar en el Model y llamarlo a traves del ViewModel
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // simular la carga de recursos
                    Thread.sleep(3000);
                    finishedLoading.postValue(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


