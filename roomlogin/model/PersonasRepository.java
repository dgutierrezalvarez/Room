package com.company.roomlogin.model;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PersonasRepository {

    Executor executor = Executors.newSingleThreadExecutor();

    AppBaseDeDatos.PersonasDao dao;

    public PersonasRepository(Application application) {
        dao = AppBaseDeDatos.getInstance(application).obtenerPersonasDao();
    }

    public LiveData<List<Personas>> obtenerPersonas() {
        return dao.obtenerPersonas();
    }

    public void insertarPersonas(String nombre, String portada) {
        executor.execute(() -> dao.insertarPersonas(new Personas(nombre, portada)));
    }
}