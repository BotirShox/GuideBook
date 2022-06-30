package br.com.byu.guidebook;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import br.com.byu.guidebook.dagger.DaggerMainComponent;
import br.com.byu.guidebook.dagger.MainComponent;
import br.com.byu.guidebook.dagger.module.ApplicationModule;
import br.com.byu.guidebook.domain.aggregation.GuideAggregation;
import br.com.byu.guidebook.presentation.ui.guidelist.GuideListAdapter;
import io.paperdb.Paper;

public class MainApplication extends Application {

    private MainComponent component;
    private GuideListAdapter adapter;
    private List<GuideAggregation> guides = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initDagger();
        initPapper();
     //   initListener();
    }

   /* private void initListener(){

        adapter.setOnItemClickListener(new GuideListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainApplication.this, GuideWebViewUI.class);
                GuideAggregation guid = guides.get(position);
             //   Intent url = intent.putExtra("url", guid.getUrl());
            }
        });
    }*/

    private void initDagger() {
        component = DaggerMainComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initPapper() {
        Paper.init(this);
    }

    public MainComponent getComponent() {
        return component;
    }
}
