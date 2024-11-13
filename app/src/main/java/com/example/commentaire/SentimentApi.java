package com.example.commentaire;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SentimentApi {

    @Headers("Authorization: BGa8KMWIVqnlc2JqGCHF/dz91smBQBFuziu07U9sh63BJn450APQ6aBga7xpdsuhVtJRNc4P8k92xJPy42wnmg==")  // Remplace "YOUR_API_KEY" par ta clé API
    @POST("sentiment/")
    Call<SentimentResponse> analyzeSentiment(@Body SentimentRequest body);
}
