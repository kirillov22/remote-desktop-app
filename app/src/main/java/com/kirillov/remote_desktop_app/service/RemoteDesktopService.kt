package com.kirillov.remote_desktop_app.service

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.kirillov.remote_desktop_app.model.ServerScanResult

class RemoteDesktopService constructor(baseIpAddress: String) {
    // This will turn something like 192.168.1.123 into 192.168.1.(?)
    private val urlPrefix: String = baseIpAddress.substring(0, baseIpAddress.lastIndexOf(".") + 1)
    private lateinit var baseUrl: String

    fun establishConnection(): ServerScanResult {
        for (i in 0..255) {
            val url = "http://$urlPrefix$i:$PORT/connect"
            val httpAsync = url
                .httpPost()
                .body("")
                .header("Content-Type" to "application/json")
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {

                        }
                        is Result.Success -> {
                            val data = result.get()
                            println(data)
                        }
                    }
                }
            val res = httpAsync.join()
            if (res.statusCode == 200) {
                println(res)
                return ServerScanResult.ESTABLISHED_CONNECTION_TO_SERVER
            }
        }

        return ServerScanResult.FAILED_TO_FIND_SERVER
    }

    companion object {
        val PORT = "9998"
    }
}