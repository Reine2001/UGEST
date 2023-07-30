package com.example.ugest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ugest.model.entity.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private User user;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(User user) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("user", user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detailed, container, false);

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

        return rootView;
    }
}
