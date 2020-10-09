package team.tsinghua.ipsc.bipolar_disorder_detector.ui.single;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SingleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SingleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is single fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}