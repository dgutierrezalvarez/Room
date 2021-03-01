package com.company.roomlogin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.company.roomlogin.databinding.FragmentCalendarioBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.ArrayList;


public class CalendarioFragment extends Fragment {

    private FragmentCalendarioBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;
    private ArrayList<String> names;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCalendarioBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);

        binding.calendarView.setOnDateLongClickListener((widget, date) -> {
            Log.d("LA FECHAAA longclick>>>> ", date.toString());
        });


        binding.calendarView.setOnDateChangedListener((widget, date, selected) -> {
            actualizarInfo(date);
        });

        binding.calendarView.setSelectedDate(CalendarDay.today());
        binding.calendarView.setCurrentDate(CalendarDay.today());
        binding.calendarView.setDateSelected(CalendarDay.today(), true);

        actualizarInfo(CalendarDay.today());
    }





    void actualizarInfo(CalendarDay date){
        String texto = "Nada en este dia";
        if(date.getDay() == 2) {
            texto = "EL BESÒS";
            binding.buttoninfo.setOnClickListener(v -> navController.navigate(R.id.action_calendarioFragment_to_rutaFragment));

        } else if(date.getDay() == 9) {
            texto = "MONTBLANC";
            binding.buttoninfo.setOnClickListener(v -> navController.navigate(R.id.action_calendarioFragment_to_montblancFragment));

        } else if(date.getDay() == 16) {
            texto = "PREHISTORIA";
            binding.buttoninfo.setOnClickListener(v -> navController.navigate(R.id.action_calendarioFragment_to_prehistoriaFragment));

        } else if(date.getDay() == 23) {
            texto = "PASEO MARITIMO";
            binding.buttoninfo.setOnClickListener(v -> navController.navigate(R.id.action_calendarioFragment_to_paseoFragment));

        } else if(date.getDay() == 30) {
            texto = "LAS COMUS";
            binding.buttoninfo.setOnClickListener(v -> navController.navigate(R.id.action_calendarioFragment_to_comusFragment));

        }

        if(texto.equals("Nada en este dia")){
            binding.buttoninfo.setVisibility(View.GONE);
        }else {
            binding.buttoninfo.setVisibility(View.VISIBLE);
        }

        binding.info.setText(texto);
    }
}


