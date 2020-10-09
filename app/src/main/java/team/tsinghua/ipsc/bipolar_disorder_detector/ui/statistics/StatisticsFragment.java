package team.tsinghua.ipsc.bipolar_disorder_detector.ui.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import team.tsinghua.ipsc.bipolar_disorder_detector.ProfileActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.R;
import team.tsinghua.ipsc.bipolar_disorder_detector.StatisticsActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.map.PoiKeywordSearchActivity;

public class StatisticsFragment extends Fragment {

    private StatisticsViewModel statisticsViewModel;
//    MapView mapView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statisticsViewModel =
                ViewModelProviders.of(this).get(StatisticsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_statistics, container, false);
        statisticsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        });
        return root;
    }


}