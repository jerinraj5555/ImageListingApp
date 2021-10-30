package com.hilt.ui.newtwork

import com.hilt.ui.newtwork.model.ImageModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
//https://jsonplaceholder.typicode.com/photos
    @GET("movie_list")
    suspend fun getAllImages() : Response<List<ImageModel>>
}