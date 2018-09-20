package example.code.leastfm.model;






import example.code.leastfm.model.apipojos.Model;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("2.0/")
    Single<Model> findAlbum(@Query("method") String method,
                            @Query("album") String album,
                            @Query("api_key") String apiKey,
                            @Query("format") String format);


}