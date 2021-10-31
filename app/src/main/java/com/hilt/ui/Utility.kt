package com.hilt.ui

import android.content.Context
import android.net.ConnectivityManager

class Utility {
    companion object {
        fun hasNetworkAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.isActiveNetworkMetered
        }

    }
}