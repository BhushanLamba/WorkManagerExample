package it.services.workmanagertesting

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(private val context: Context,private val params:WorkerParameters): Worker(context,params)
{
    override fun doWork(): Result {
        Log.d("my_worker", "doWork: Worker Called")

        return Result.success()
    }

}