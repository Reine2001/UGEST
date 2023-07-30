package com.example.ugest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugest.model.entity.User;
import com.example.ugest.viewmodel.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragmentModifier#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragmentModifier extends Fragment {

    private User user;
    private UserViewModel userViewModel;

    public DetailFragmentModifier() {
        // Required empty public constructor
    }

    public static DetailFragmentModifier newInstance(User user) {
        DetailFragmentModifier fragment = new DetailFragmentModifier();
        Bundle args = new Bundle();
        args.putParcelable("user", user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detailed_modifier, container, false);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
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
        AppCompatButton btnModifierUser = rootView.findViewById(R.id.btnMod);
        btnModifierUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showEditDialog();

            }
        });

        return rootView;
    }
private void showEditDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialogviewedit,null);
        builder.setView(dialogView);


    EditText editNom = dialogView.findViewById(R.id.editTextNom);
    EditText editPrenom = dialogView.findViewById(R.id.editTextPrenom);
    EditText editCours = dialogView.findViewById(R.id.editTextCours);

    editNom.setText(user.getNom());
    editPrenom.setText(user.getPrenom());
    editCours.setText(user.getCours());

    builder.setPositiveButton("Enregistrer", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String newNom = editNom.getText().toString();
            String newPrenom = editPrenom.getText().toString();
            String newCours = editCours.getText().toString();

            userViewModel.modifierUser(user,newNom,newPrenom,newCours);


        }
    });
    builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // Annuler la modification et fermer la boîte de dialogue
            dialog.dismiss();
        }
    });

    // Afficher la boîte de dialogue
    builder.show();
}

}



