package com.example.ugest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugest.model.entity.User;
import com.example.ugest.viewmodel.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragmentSupprimer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragmentSupprimer extends Fragment {

    private User user;

    public DetailFragmentSupprimer() {
        // Required empty public constructor
    }

    public static DetailFragmentSupprimer newInstance(User user) {
        DetailFragmentSupprimer fragment = new DetailFragmentSupprimer();
        Bundle args = new Bundle();
        args.putParcelable("user", user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detailed_supprimer, container, false);

        TextView nomTextView = rootView.findViewById(R.id.detailNom);
        TextView prenomTextView = rootView.findViewById(R.id.detailPrenom);
        TextView coursTextView = rootView.findViewById(R.id.detailCours);

        if (getArguments() != null) {
            user = getArguments().getParcelable("user");
            if (user != null) {
                nomTextView.setText(user.getNom());
                prenomTextView.setText(user.getPrenom());
                coursTextView.setText(user.getCours());
            }
        }
        AppCompatButton btnSupp = rootView.findViewById(R.id.btnSupp);

        btnSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog();
            }
        });

        return rootView;
    }
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(getContext());
        confirmationDialog.setTitle("Supprimer");
        confirmationDialog.setMessage("Voulez-vous vraiment supprimer cet utilisateur ?");
        confirmationDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Supprimer l'utilisateur en appelant la méthode supprimerUser du UserViewModel
                if (user != null) {
                    UserViewModel userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
                    userViewModel.supprimerUser(user);
                    // Fermer le fragment après la suppression
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
        confirmationDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Annuler la suppression
                dialog.dismiss();
            }
        });
        confirmationDialog.show();
    }
}
