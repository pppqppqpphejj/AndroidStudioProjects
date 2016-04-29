package com.elixirgreen.starkabaddi;

/**
 * Created by abhilash on 29/4/16.
 */
import com.elixirgreen.starkabaddi.ServerRequest;
import com.elixirgreen.starkabaddi.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("starskabaddi/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}