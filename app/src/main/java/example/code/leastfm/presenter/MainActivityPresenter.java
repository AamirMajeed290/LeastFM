package example.code.leastfm.presenter;

import android.content.Context;
import android.support.annotation.NonNull;


import example.code.leastfm.model.ApiClient;
import example.code.leastfm.model.ApiService;
import example.code.leastfm.model.apipojos.Model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
i


public class MainActivityPresenter implements MainActivityContract.Presenter{

    CompositeDisposable compositeDisposable=new CompositeDisposable();
    private ApiService apiService;

    private Context context;
    private MainActivityContract.view view;

    public MainActivityPresenter(Context context, MainActivityContract.view view) {
        this.view=view;
        this.context=context;
        view.setPresenter(this);
    }



    public void loadAlbums(@NonNull String albumsToLoad)
    {
        final String method = "album.search";
        final String apiKey = "06bcf45620e992c76e5c35d87b5e7260";
        final String format = "json";
        apiService= ApiClient.getClient(context).create(ApiService.class);
        compositeDisposable.add(


                apiService.findAlbum(method, albumsToLoad, apiKey, format)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Model>()

                                       {

                                           @Override
                                           public void onSuccess(Model model) {
                                           view.setResults(model);


                                           }

                                           @Override
                                           public void onError(Throwable e) {
                                               view.setErrorMessage(e.getMessage());
                                           }
                                       }
                        )



        );
    }




    @Override
    public void onDestry() {
        compositeDisposable.dispose();
    }
}
