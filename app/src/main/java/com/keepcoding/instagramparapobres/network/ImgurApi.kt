package com.keepcoding.instagramparapobres.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurApi {

    @Headers("Authorization: Client-ID b9ecaa31b1e2702")
    @GET("gallery/hot")
    suspend fun getHotGallery(): NetworkGallery

    @Headers("Authorization: Client-ID b9ecaa31b1e2702")
    @GET("gallery/top")
    suspend fun getTopGallery(): NetworkGallery

    @GET("account/me/images")
    suspend fun getMyGallery(): NetworkGallery

}