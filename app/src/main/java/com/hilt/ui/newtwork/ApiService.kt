package com.hilt.ui.newtwork

import com.hilt.ui.db.ImageEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //https://jsonplaceholder.typicode.com/photos
    //list
    @GET("list")
    suspend fun getAllImages(): Response<List<ImageEntity>>

}