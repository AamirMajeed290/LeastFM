package example.code.leastfm.presenter;


import android.support.annotation.NonNull;

import java.util.List;

import example.code.leastfm.BasePresenter;
import example.code.leastfm.BaseView;
import example.code.leastfm.model.Album;
import example.code.leastfm.model.apipojos.Model;
import example.code.leastfm.model.apipojos.Results;

public interface MainActivityContract {

    interface Presenter extends BasePresenter {
        void loadAlbums(@NonNull String albumsToLoad);
       //void onDestry();  // we can write this method here id we dont want to extend BasePresenter calss
      /*  void getWifies(String d);
        void getWifies();
        void addWifi(Wifi wifi);
        void deleteWifi(String s);*/



    }



    interface view extends BaseView<Presenter>
    {

        void setResults(@NonNull Model model);

        void setErrorMessage(@NonNull String error);



    }

/*

this interface can be implemented to avoid BaseView extention
    interface view <Presenter>
    {
        void setStarWarCharacter(StarWarCharacter starWarCharacter);
        void setErrorMessage(String error);
        void setPresenter(MainActivityContract.Presenter presenter);


    }
*/

}
