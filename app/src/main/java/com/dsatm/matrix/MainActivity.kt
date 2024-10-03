package com.dsatm.matrix

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.OnBackPressedCallback


class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed for your website
        webView.settings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
        webView.webViewClient = WebViewClient()   // Ensures links open inside WebView
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        val url = "https://karthik419914.github.io/project-matrix--new-/" // Replace this with your actual URL
        webView.loadUrl(url)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack() // Go back to the previous page if available
                } else {
                    finish() // Close the activity when no pages left
                }
            }
        }
        // Add the callback to the dispatcher
        onBackPressedDispatcher.addCallback(this, callback)
    }
}
