package br.com.byu.guidebook.dagger.module.infraestruture;

import javax.inject.Singleton;

import br.com.byu.guidebook.domain.repository.GuideRepository;
import br.com.byu.guidebook.infraestruture.operator.WorkerOperator;
import br.com.byu.guidebook.infraestruture.storage.client.GuideService;
import br.com.byu.guidebook.infraestruture.storage.manager.GuideManager;
import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    GuideRepository providesGuideRepository(GuideService guideService, WorkerOperator workerOperator) {
        return new GuideManager(guideService, workerOperator);
    }

}
