package br.com.byu.guidebook.infraestruture.operator;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WorkerOperator<T> implements Observable.Transformer<T, T> {

    @Override
    public Observable<T> call(Observable<T> rObservable) {
        return rObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
