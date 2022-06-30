package br.com.byu.guidebook.dagger.module.presentation;

import br.com.byu.guidebook.dagger.scope.PerActivity;
import br.com.byu.guidebook.domain.repository.GuideRepository;
import br.com.byu.guidebook.presentation.ui.guidelist.GuideListContract;
import br.com.byu.guidebook.presentation.ui.guidelist.GuideListPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @PerActivity
    @Provides
    GuideListContract.Presenter provideMainPresenter(GuideRepository guideRepository) {
        return new GuideListPresenter(guideRepository);
    }
}
