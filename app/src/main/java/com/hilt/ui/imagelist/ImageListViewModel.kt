package com.hilt.ui.imagelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilt.ui.repo.imglist.ImageLocalRepo
import com.hilt.ui.repo.imglist.ImageNetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val nwRepo: ImageNetworkRepository,
    private val localRepo: ImageLocalRepo
) : ViewModel() {
    val progressBarStatus = MutableLiveData<Boolean>()

    fun fetchAllMovies() {
        progressBarStatus.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = nwRepo.getAllImages()
            if (response.isSuccessful) {
                response.body()?.let {
                    localRepo.insertAll(it.subList(0, 9))
                }
            }
        }
        progressBarStatus.value = false
    }

    fun getAllMoviesListFromDb() = localRepo.getAllImages()


}