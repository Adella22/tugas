package com.tugas2.training.activity.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tugas2.training.activity.R;

public class TrainingFragment extends Fragment {

    private static final android.R.attr R = ;
    private TrainingViewModel TrainingViewModel;

    public TrainingFragment(com.tugas2.training.activity.ui.training.TrainingViewModel trainingViewModel) {
        TrainingViewModel = trainingViewModel;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrainingViewModel =
                ViewModelProviders.of(this).get(TrainingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_training, container, false);
        final TextView textView = root.findViewById(R.id.text_training);
        TrainingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
