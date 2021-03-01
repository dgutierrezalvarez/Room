package com.company.roomlogin.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, Personas.class }, version = 2, exportSchema = false)
public abstract class  AppBaseDeDatos extends RoomDatabase {

    static Executor executor = Executors.newSingleThreadExecutor();

    public abstract PersonasDao obtenerPersonasDao();
    public abstract AppDao obtenerDao();

    private static volatile AppBaseDeDatos INSTANCE;

    public static AppBaseDeDatos getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppBaseDeDatos.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppBaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {

                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    insertarDatosIniciales(getInstance(context).obtenerPersonasDao());

                                }

                                @Override
                                public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                                    super.onDestructiveMigration(db);
                                    insertarDatosIniciales(getInstance(context).obtenerPersonasDao());
                                }

                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @Dao
    public interface AppDao {

        @Insert
        void insertarUsuario(Usuario usuario);

        @Query("SELECT * FROM Usuario WHERE username = :nombre AND password = :contrasenya")
        Usuario autenticar(String nombre, String contrasenya);

        @Query("SELECT * FROM Usuario WHERE username = :nombre")
        Usuario comprobarNombreDisponible(String nombre);
    }

    private static void insertarDatosIniciales(PersonasDao dao) {
        List<Personas> personas = Arrays.asList(
                new Personas("guti", "file:///drawable/person1.png"),
                new Personas("Dani", "file:///android_asset/2.jpg")

        );

        executor.execute(()-> {
            dao.insertarPersonas(personas);
        });
    }

    @Dao
    public interface PersonasDao {
        @Insert
        void insertarPersonas(Personas personas);

        @Insert
        void insertarPersonas(List<Personas> personas);

        @Query("SELECT * FROM Personas")
        LiveData<List<Personas>> obtenerPersonas();
    }
}
