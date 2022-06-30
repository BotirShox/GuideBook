package br.com.byu.guidebook.dagger;

import br.com.byu.guidebook.dagger.module.presentation.PresenterModule;
import br.com.byu.guidebook.dagger.scope.PerActivity;
import br.com.byu.guidebook.presentation.ui.guidelist.GuideListActivity;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {PresenterModule.class})
public interface UiComponent {
    void inject(GuideListActivity activity);
}
