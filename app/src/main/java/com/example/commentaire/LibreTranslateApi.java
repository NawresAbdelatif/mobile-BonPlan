package com.example.commentaire;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LibreTranslateApi {
    @FormUrlEncoded
    @POST("translate")
    Call<TranslationResponse> translate(
            @Field("q") String text,
            @Field("source") String sourceLang,
            @Field("target") String targetLang
    );
}
