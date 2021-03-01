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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.company.roomlogin.databinding.FragmentListaPersonasBinding;
import com.company.roomlogin.databinding.ViewHolderPersonasBinding;
import com.company.roomlogin.model.Personas;
import com.company.roomlogin.viewmodel.PersonasViewModel;

import java.util.List;

public class ListaPersonasFragment extends Fragment {

    FragmentListaPersonasBinding binding;
    NavController navController;
    PersonasViewModel personasViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentListaPersonasBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personasViewModel = new ViewModelProvider(requireActivity()).get(PersonasViewModel.class);

        navController = Navigation.findNavController(view);

        binding.irAInsertarAlbum.setOnClickListener(v -> {
            navController.navigate(R.id.action_listaPersonasFragment_to_insertarFragment);
        });

        PersonasAdapter personasAdapter = new PersonasAdapter();
        binding.recyclerView.setAdapter(personasAdapter);

        personasViewModel.obtenerPersonas().observe(getViewLifecycleOwner(), personas -> {
            personasAdapter.setPersonasList(personas);
            });
        }


        class PersonasAdapter extends RecyclerView.Adapter<PersonasViewHolder> {

            List<Personas> personasList;

            @NonNull
            @Override
            public PersonasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PersonasViewHolder(ViewHolderPersonasBinding.inflate(getLayoutInflater(), parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull PersonasViewHolder holder, int position) {
                Personas personas = personasList.get(position);

                holder.binding.nombre.setText(personas.nombre);
                Glide.with(holder.itemView)
                        .load(personas.portada).transform(new RoundedCorners(64)).into(holder.binding.portada);
            }

            @Override
            public int getItemCount() {
                return personasList == null ? 0 : personasList.size();
            }

            public void setPersonasList(List<Personas> personasList) {
                this.personasList = personasList;
                notifyDataSetChanged();
            }
        }

        static class PersonasViewHolder extends RecyclerView.ViewHolder {
            ViewHolderPersonasBinding binding;

            public PersonasViewHolder(@NonNull ViewHolderPersonasBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
}


