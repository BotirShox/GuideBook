package br.com.byu.guidebook.dagger;

import javax.inject.Singleton;

import br.com.byu.guidebook.dagger.module.ApplicationModule;
import br.com.byu.guidebook.dagger.module.PreferenceModule;
import br.com.byu.guidebook.dagger.module.SettingModule;
import br.com.byu.guidebook.dagger.module.domain.RepositoryModule;
import br.com.byu.guidebook.dagger.module.infraestruture.ManagerModule;
import br.com.byu.guidebook.dagger.module.infraestruture.NetworkModule;
import br.com.byu.guidebook.dagger.module.infraestruture.RxJavaModule;
import br.com.byu.guidebook.dagger.module.infraestruture.ServiceModule;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class, NetworkModule.class, PreferenceModule.class,
        RepositoryModule.class, SettingModule.class, RxJavaModule.class, ServiceModule.class,
        ManagerModule.class
})
public interface MainComponent {
    UiComponent uiComponent();
}
