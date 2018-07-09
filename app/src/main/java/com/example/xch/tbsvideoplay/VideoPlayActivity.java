package com.example.xch.tbsvideoplay;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xch.tbsvideoplay.tools.X5WebView;
import com.tencent.smtt.sdk.WebChromeClient;

public class VideoPlayActivity extends AppCompatActivity {
    private String videoUrl;
    private X5WebView x5webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        getIntentData();
        initView(videoUrl);
    }

    /**
     * 跳转至此页面
     *
     * @param context
     * @param videoUrl 视频地址
     */
    public static void actionStart(Context context, String videoUrl) {
        Intent intent = new Intent(context, VideoPlayActivity.class);
        intent.putExtra("videoUrl", videoUrl);
        context.startActivity(intent);
    }

    /**
     * 获取上个页面传过来的数据
     */
    private void getIntentData() {
        Intent intent = getIntent();
        videoUrl = intent.getStringExtra("videoUrl");
    }

    private void initView(String vedioUrl) {
        x5webView = findViewById(R.id.x5_webview);

        x5webView.loadUrl(vedioUrl);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        x5webView.getView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        x5webView.setWebChromeClient(new WebChromeClient());
    }
}
