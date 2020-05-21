package com.adella.training.activity.ui.training;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adella.training.R;
import com.adella.training.adapter.TrainingAdapter;
import com.adella.training.model.TrainingModel;

import java.util.ArrayList;
import java.util.List;

public class TrainingFragment extends Fragment {
    private String TAG = "mvvm";
    private RecyclerView rv;

    private TrainingAdapter trainingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_training, container, false);
        List<TrainingModel> trainingModels = new ArrayList<>();
        rv = root.findViewById(R.id.rv);
        rv.setAdapter(trainingAdapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        TrainingViewModel trainingViewModel = ViewModelProviders.of(this).get(TrainingViewModel.class);
        trainingViewModel.getTraining().observe(this, new Observer<List<TrainingModel>>() {

            @Override
            public void onChanged(List<TrainingModel> trainingModels) {
                trainingAdapter = new TrainingAdapter(getActivity(), trainingModels);
                rv.setAdapter(trainingAdapter);
            }
        });
        return root;
    }
}