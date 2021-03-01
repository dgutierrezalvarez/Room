package com.company.roomlogin;

        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;

        import com.company.roomlogin.databinding.FragmentPaseoBinding;
        import com.company.roomlogin.viewmodel.AutenticacionViewModel;

public class PaseoFragment extends Fragment {
    private FragmentPaseoBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPaseoBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.iniciarCarrera.setIndeterminateProgressMode(true); // turn on indeterminate progress
        binding.iniciarCarrera.setText("Registrar");
        binding.iniciarCarrera.setCompleteText("Completado");
        binding.iniciarCarrera.setBackgroundColor(Color.TRANSPARENT);
        binding.iniciarCarrera.setStrokeColor(Color.WHITE);
        binding.iniciarCarrera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 100; i++) {

                    binding.iniciarCarrera.setProgress(i); // set progress > 0 & < 100 to display indeterminate progress
                }

            }
        });
        //circularProgressButton.setProgress(100); // set progress to 100 or -1 to indicate complete or error state
        //circularProgressButton.setProgress(0); // set progress to 0 to switch back to normal state
    }
}




