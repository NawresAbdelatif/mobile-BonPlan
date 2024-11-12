package com.example.commentaire;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SentimentApi {
    @Headers("Api-Key: fca62817-7ab3-43de-9543-e8b65cc38317")  // Votre clé API ici
    @POST("text/sentiment")
    Call<SentimentResponse> analyzeSentiment(@Body RequestBody body);
}


