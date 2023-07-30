package com.example.ugest;

import static com.example.ugest.R.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ugest.model.entity.User;

public class ActivityDetailedFragment extends Fragment {
    private static final String ARG_USER = "arg_user";

    private User user;

    public static ActivityDetailedFragment newInstance(User user) {
        ActivityDetailedFragment fragment = new ActivityDetailedFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(ARG_USER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.activity_detailed, container, false);

        TextView nameTextView = rootView.findViewById(id.detailCours);
        TextView prenomTextView = rootView.findViewById(id.detailPrenom);
        TextView coursTextView = rootView.findViewById(id.detailNom);
    if (getArguments()!=null){
        user = getArguments().getParcelable(ARG_USER);
        if (user !=null){
            nameTextView.setText(user.getNom());
            prenomTextView.setText(user.getPrenom());
            coursTextView.setText(user.getCours());

        }
    }

        return rootView;
    }
}
