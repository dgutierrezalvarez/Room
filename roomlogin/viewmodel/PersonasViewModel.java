package com.company.roomlogin.viewmodel;


import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.company.roomlogin.model.Personas;
import com.company.roomlogin.model.PersonasRepository;

import java.util.List;

public class PersonasViewModel extends AndroidViewModel {

    PersonasRepository personasRepository;

    public MutableLiveData<Uri> imagenSeleccionada = new MutableLiveData<>();

    public PersonasViewModel(@NonNull Application application) {
        super(application);

        personasRepository = new PersonasRepository(application);
    }


    public LiveData<List<Personas>> obtenerPersonas() {
        return personasRepository.obtenerPersonas();
    }

    public void insertarPersonas(String nombre, String portada) {
        personasRepository.insertarPersonas(nombre, portada);
    }

    public void establecerImagenSeleccionada(Uri uri){
        imagenSeleccionada.setValue(uri);
    }
}