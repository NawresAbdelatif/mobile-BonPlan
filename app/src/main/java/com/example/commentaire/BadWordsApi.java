
package com.example.commentaire;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BadWordsApi {
    @GET("check")
    Call<ProfanityResponse> checkProfanity(@Query("text") String text);
}
