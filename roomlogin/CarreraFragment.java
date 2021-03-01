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

import com.company.roomlogin.databinding.FragmentCarreraBinding;
import com.company.roomlogin.viewmodel.AutenticacionViewModel;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class CarreraFragment extends Fragment {

    private FragmentCarreraBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;

    private MapView mMapView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       return (binding = FragmentCarreraBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);

;
        MapView mMapView = (MapView) view.findViewById(R.id.mapview);
        Configuration.getInstance().setUserAgentValue("github-firefishy-map/0.1");
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setMultiTouchControls(true);
        mMapView.getController().setZoom(15);
        GeoPoint prat = new GeoPoint( 41.331088, 2.091802);
        mMapView.getController().setCenter(prat);


        binding.buttonTiempo.setOnClickListener(v -> navController.navigate(R.id.action_carreraFragment_to_tiempoCarreraFragment));

        binding.buttonStop.setOnClickListener(v -> navController.navigate(R.id.action_carreraFragment_to_cargandoFragment));
    }
}