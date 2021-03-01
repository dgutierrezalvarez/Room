package com.company.roomlogin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.company.roomlogin.databinding.ActivityMainBinding;
import com.company.roomlogin.databinding.DrawerHeaderBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DrawerHeaderBinding drawerHeaderBinding;


    AutenticacionViewModel autenticacionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());


        drawerHeaderBinding = DrawerHeaderBinding.bind(binding.navView.getHeaderView(0));

        autenticacionViewModel = new ViewModelProvider(this).get(AutenticacionViewModel.class);

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.homeFragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            Log.e("Navegando hacia: ", (String) destination.getLabel());

            if (destination.getId() == R.id.iniciarSesionFragment
            || destination.getId() == R.id.registroFragment
            || destination.getId() == R.id.splashFragment) {
                binding.toolbar.setVisibility(View.GONE);
                binding.navView.setVisibility(View.GONE);
            } else {
                binding.toolbar.setVisibility(View.VISIBLE);
                binding.navView.setVisibility(View.VISIBLE);
            }
        });

        autenticacionViewModel.usuarioAutenticado.observe(this, usuario -> {
            if (usuario != null){
                drawerHeaderBinding.username.setText(usuario.username);
            }
        });

    }

}



