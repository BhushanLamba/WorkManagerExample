package it.services.workmanagertesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpWorker()
    }

    private fun setUpWorker()
    {
        val constraints=androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val workerRequest=PeriodicWorkRequest.Builder(MyWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(workerRequest)
    }
}