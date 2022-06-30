package br.com.byu.guidebook.presentation.ui.guidelist;

import java.util.List;

import br.com.byu.guidebook.domain.entity.Guide;

public interface GuideListContract {

    interface View {
        void setupGuideList(List<Guide> companies);

        void showLoadingLayout();

        void showErrorLayout();

        void showSuccessLayout();

        void showEmptyLayout();
    }

    interface Presenter {
        br.com.byu.guidebook.domain.aggregation.GuideAggregation onSaveInstanceState();

        void onLoadInstanceState(br.com.byu.guidebook.domain.aggregation.GuideAggregation aggregation);

        void loadGuides();

        void refreshUi();

        void retryButtonClick();

        void setView(GuideListContract.View view);
    }
}
