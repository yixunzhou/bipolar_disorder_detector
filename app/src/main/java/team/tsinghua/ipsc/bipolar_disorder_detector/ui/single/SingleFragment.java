package team.tsinghua.ipsc.bipolar_disorder_detector.ui.single;

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

import team.tsinghua.ipsc.bipolar_disorder_detector.R;
import team.tsinghua.ipsc.bipolar_disorder_detector.map.PoiKeywordSearchActivity;

public class SingleFragment extends Fragment {

    private SingleViewModel singleViewModel;
//    MapView mapView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        singleViewModel =
                ViewModelProviders.of(this).get(SingleViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_discover, container, false);
        singleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        });
        return root;
    }


}