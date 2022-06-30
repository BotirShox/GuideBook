package br.com.byu.guidebook.presentation.ui.guidelist;

import javax.inject.Inject;

import br.com.byu.guidebook.domain.aggregation.GuideAggregation;
import br.com.byu.guidebook.domain.repository.GuideRepository;

public class GuideListPresenter implements GuideListContract.Presenter {

    private GuideListContract.View view;
    private GuideRepository repository;
    private GuideAggregation guideAggregation;

    @Inject
    public GuideListPresenter(GuideRepository repository) {
        this.repository = repository;
    }

    @Override
    public GuideAggregation onSaveInstanceState() {
        return guideAggregation;
    }

    @Override
    public void onLoadInstanceState(GuideAggregation aggregation) {
        this.guideAggregation = aggregation;
    }

    @Override
    public void loadGuides() {
        view.showLoadingLayout();
        repository.getCompanies().subscribe(guides -> {
            this.guideAggregation = guides;
            refreshUi();
        }, throwable -> {
            view.showErrorLayout();
        });
    }

    @Override
    public void refreshUi() {
        if (guideAggregation != null && guideAggregation.guides.isEmpty()) {
            view.showEmptyLayout();
        } else {
            view.showSuccessLayout();
            view.setupGuideList(guideAggregation.guides);
        }
    }

    @Override
    public void retryButtonClick() {
        loadGuides();
    }

    @Override
    public void setView(GuideListContract.View view) {
        this.view = view;
    }
}
