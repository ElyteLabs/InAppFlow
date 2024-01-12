package com.elytelabs.inappflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val inAppUpdateManager by lazy { InAppUpdateManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Show Rating Dialog With Default Params
        showDefaultRatingDialog(this)

        // or customise the dialog

//        InAppReviewManager.with(this)
//            .setInstallDays(2)
//            .setLaunchTimes(3)
//            .setRemindInterval(2)
//            .monitor()
//        // Show a dialog if meets conditions
//        InAppReviewManager.showRateDialogIfNeeded(this)

        inAppUpdateManager.setupInAppUpdate()
    }

    override fun onDestroy() {
        super.onDestroy()
        inAppUpdateManager.onDestroy()
    }
}