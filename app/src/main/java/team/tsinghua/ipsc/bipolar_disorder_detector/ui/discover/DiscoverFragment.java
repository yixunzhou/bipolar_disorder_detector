package team.tsinghua.ipsc.bipolar_disorder_detector.ui.discover;

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


import com.amap.api.maps.MapView;

import team.tsinghua.ipsc.bipolar_disorder_detector.map.MapActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.R;
import team.tsinghua.ipsc.bipolar_disorder_detector.map.PoiKeywordSearchActivity;

public class DiscoverFragment extends Fragment {

    private DiscoverViewModel discoverViewModel;
//    MapView mapView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        discoverViewModel =
                ViewModelProviders.of(this).get(DiscoverViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_discover, container, false);
        discoverViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Intent intent = new Intent(root.getContext(), PoiKeywordSearchActivity.class);
                startActivity(intent);

            }
        });
        return root;
    }


}