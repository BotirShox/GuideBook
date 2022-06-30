package br.com.byu.guidebook.infraestruture.storage.client;

import br.com.byu.guidebook.domain.aggregation.GuideAggregation;
import retrofit2.http.GET;
import rx.Observable;

public interface GuideService {

    @GET("upcomingGuides")
    Observable<GuideAggregation> getGuideAggregation();
}