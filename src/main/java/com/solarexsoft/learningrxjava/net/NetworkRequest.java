package com.solarexsoft.learningrxjava.net;

import com.solarexsoft.learningrxjava.model.Translation;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by houruhou on 12/03/2018.
 */
public interface NetworkRequest {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation> getCall();
}
