package com.company.roomlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.company.roomlogin.databinding.FragmentAmigosBinding;
import com.company.roomlogin.viewmodel.PersonasViewModel;

public class AmigosFragment extends Fragment {

    FragmentAmigosBinding binding;
    NavController navController;
    PersonasViewModel personasViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentAmigosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //personasViewModel = new ViewModelProvider(requireActivity()).get(PersonasViewModel.class);

        //navController = Navigation.findNavController(view);

        //binding.agregaramigos.setOnClickListener(v -> {
        //navController.navigate(R.id.action_amigos_to_insertarFragment);
        //});

        //PersonasAdapter personasAdapter = new PersonasAdapter();
        //binding.recyclerView.setAdapter(personasAdapter);

        //personasViewModel.obtenerPersonas().observe(getViewLifecycleOwner(), personas -> {
        //personasAdapter.setPersonasList(personas);
        //});
        //}


        //class PersonasAdapter extends RecyclerView.Adapter<PersonasViewHolder> {

        //List<Personas> personasListList;

        //@NonNull
        //@Override
        //public PersonasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return new AlbumViewHolder(ViewholderPersonasBinding.inflate(getLayoutInflater(), parent, false));
        //}

        //@Override
        //public void onBindViewHolder(@NonNull PersonasViewHolder holder, int position) {

        //}

        //@Override
        //public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        //Personas personas = personasListList.get(position);

        //holder.binding.nombre.setText(personas.nombre);
        //Glide.with(holder.itemView)
        //.load(personas.portada)
        //.transform(new RoundedCorners(64))
        //.into(holder.binding.portada);
        //}

        //@Override
        //public int getItemCount() {
        //return personasListList == null ? 0 : personasListList.size();
        //}

        //public void setAlbumList(List<Personas> albumList) {
        //this.personasListList = personasListList;
        // notifyDataSetChanged();
        //}
        // }

        //static class PersonasViewHolder extends RecyclerView.ViewHolder {
        //ViewholderPersonasBinding binding;

        //public PersonasViewHolder(@NonNull ViewholderPersonasBinding binding) {
        //super(binding.getRoot());
        //this.binding = binding;
        }
    }

