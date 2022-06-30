package br.com.byu.guidebook.presentation.base;

import android.support.v4.app.Fragment;

import br.com.byu.guidebook.MainApplication;
import br.com.byu.guidebook.dagger.MainComponent;

public class BaseFragment extends Fragment {

    protected MainApplication getMainApplication() {
        return (MainApplication) getActivity().getApplication();
    }

    protected MainComponent getMainComponent() {
        return getMainApplication().getComponent();
    }
}
