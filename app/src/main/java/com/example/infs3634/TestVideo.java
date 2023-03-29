package com.example.infs3634;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class TestVideo extends AppCompatActivity{

    private static final String IFRAME_EMBED_CODE =
"<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Bz2QA3rJLEI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_video_layout);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("https://www.youtube.com", IFRAME_EMBED_CODE, "text/html", "utf-8", null);

// Reference to code in youtube videos (ChatGPT, personal communication, March 28, 2023)
    }
}