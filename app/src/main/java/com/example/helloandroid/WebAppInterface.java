package com.example.helloandroid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class WebAppInterface {
    Context context;
    WebView webView;

    WebAppInterface(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

        // 回调网页
        new Handler(Looper.getMainLooper()).post(() -> {
            webView.evaluateJavascript("javascript:fromAndroid('数据已处理: " + msg + "')", null);
        });
    }
}
