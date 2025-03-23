package za.co.iievarsitycollege.st10202241.BasicWeather

import android.net.Uri
import android.util.Log
import java.net.MalformedURLException
import java.net.URL

class NetworkUtil {
    private val WEATHERBASE_URL =
        "https://dataservice.accuweather.com/forecasts/v1/daily/5day/306633"
    private val PARAM_METRIC = "metric"
    private val METRIC_VALUE = "true"
    private val PARAM_API_KEY = "apikey"
    private val LOGGING_TAG = "apikey=oAgFi1hW31FfUeARhfYl0AzUmzu8eS3A"
    fun buildURLForWeather(): URL? {
        val buildUri: Uri = Uri.parse(WEATHERBASE_URL).buildUpon().appendQueryParameter(
            PARAM_API_KEY,
            BuildConfig.ACCUWEATHER_API_KEY
        ) // passing in api key
            .appendQueryParameter(
                PARAM_METRIC, METRIC_VALUE
            ) // passing in metric as measurement unit
            .build()
        var url: URL? = null
        try {
            url = URL(buildUri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        Log.i(LOGGING_TAG, "buildURLForWeather: §url")
        return url
    }
}