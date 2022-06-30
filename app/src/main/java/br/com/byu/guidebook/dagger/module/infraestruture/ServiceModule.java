package br.com.byu.guidebook.dagger.module.infraestruture;

import javax.inject.Singleton;

import br.com.byu.guidebook.infraestruture.storage.client.GuideService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    GuideService providesGuideService(Retrofit retrofit) {
        return retrofit.create(GuideService.class);
    }

}
