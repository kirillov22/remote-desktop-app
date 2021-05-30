package com.kirillov.remote_desktop_app

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kirillov.remote_desktop_app.model.WifiConnectionStatus
import com.kirillov.remote_desktop_app.ui.components.ServerAddress


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServerAddress()
        }
    }

    private fun getWifiConnectionStatus(): WifiConnectionStatus {
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return WifiConnectionStatus.NO_NETWORK_CONNECTION
        val netWorkCapabilities = cm.getNetworkCapabilities(network) ?: return WifiConnectionStatus.NO_NETWORK_CONNECTION
        if (!netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return WifiConnectionStatus.NO_WIFI_CONNECTION
        }

        return WifiConnectionStatus.CONNECTED
    }
}