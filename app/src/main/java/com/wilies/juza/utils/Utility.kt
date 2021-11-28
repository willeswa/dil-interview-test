package com.wilies.juza.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.wilies.juza.BuildConfig

object Utility {
    fun openArticleAt(it: String, activity: Activity) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
        if (activity?.startActivity(intent) != null) {
            activity.startActivity(intent)
        }
    }

    fun getApiKey(): String {
        return BuildConfig.NEWSAPIORG_API_KEY
    }
}