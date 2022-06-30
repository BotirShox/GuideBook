package br.com.byu.guidebook.presentation.ui.guidelist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import javax.inject.Inject;

import br.com.byu.guidebook.R;
import br.com.byu.guidebook.domain.entity.GuideAggregation;
import br.com.byu.guidebook.presentation.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideListActivity extends BaseActivity implements GuideListContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView guideList;

    @BindView(R.id.successContainer)
    LinearLayout successContainer;

    @BindView(R.id.errorContainer)
    LinearLayout errorContainer;

    @BindView(R.id.loadingContainer)
    LinearLayout loadingContainer;

    @BindView(R.id.emptyContainer)
    LinearLayout emptyContainer;

    @Inject
    GuideListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getUiComponent().inject(this);
        initialize();
    }

    private void initialize() {
        presenter.setView(this);
        presenter.loadGuides();
    }

    @OnClick(R.id.retryButton)
    void retryGetCompanies() {
        presenter.retryButtonClick();
    }

    @Override
    public void setupGuideList(List<GuideAggregation> guides) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        GuideListAdapter companyListAdapter = new GuideListAdapter(this, guides);
        guideList.setLayoutManager(manager);
        guideList.setAdapter(companyListAdapter);
    }

    @Override
    public void showLoadingLayout() {
        successContainer.setVisibility(View.GONE);
        errorContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.VISIBLE);
        emptyContainer.setVisibility(View.GONE);
    }

    @Override
    public void showErrorLayout() {
        successContainer.setVisibility(View.GONE);
        errorContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.GONE);
    }

    @Override
    public void showSuccessLayout() {
        successContainer.setVisibility(View.VISIBLE);
        errorContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyLayout() {
        successContainer.setVisibility(View.GONE);
        errorContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.VISIBLE);
    }

}
