package br.com.byu.guidebook.domain.repository;

import br.com.byu.guidebook.domain.aggregation.GuideAggregation;
import rx.Observable;

public interface GuideRepository {

    Observable<GuideAggregation> getCompanies();
}
