package com.hilt.ui.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(
    tableName = "image"
)
data class ImageEntity (
    @PrimaryKey
    @SerializedName("id") val id : Int,
    @SerializedName("thumbnailUrl") val url : String?,
    @SerializedName("download_url") val downloadUrl : String?
    )