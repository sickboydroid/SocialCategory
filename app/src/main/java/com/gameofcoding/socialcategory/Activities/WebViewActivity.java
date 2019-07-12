package com.gameofcoding.socialcategory.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.gameofcoding.socialcategory.Helpers.UrlManager;
import com.gameofcoding.socialcategory.R;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import android.util.DisplayMetrics;

public class WebViewActivity extends Activity {
	final Context context = this;
	private String URL;
	private int webpageThemeColor;

	// Keys
	public static final String KEY_RESID_STATUS_BAR_COLOR = "ksjd_keyStatusBarColor";
	public static final String KEY_URL_OF_SOCIAL_MEDIA = "j3j2_keyURLOfWebpage";

	// Views
	WebView webView;
	ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_webview);
		webView = findViewById(R.id.layout_webviewWebView);
		progressBar = findViewById(R.id.layout_webviewProgressBar);
		manageIntents();
		setUpWebView();
		getWebView().loadUrl(getURL());
	}

	@Override
	public void onBackPressed() {
		if (getWebView().canGoBack())
			getWebView().goBack();
		else
			finish();
	}
	
	// Gets Intents for activity startup
	public void manageIntents() {
		// Getting url
		int URLOf = getIntent().getIntExtra(KEY_URL_OF_SOCIAL_MEDIA, 0);
		setURL(new UrlManager(context, URLOf)
			   .getUrl());

		// Getting Color
		setWebpageThemeColor(getResources()
							 .getColor(getIntent()
									   .getIntExtra(KEY_RESID_STATUS_BAR_COLOR,
													R.color.primaryDarkColor)));

		// Setting Color for status bar
		setStatusBarColor(getWebpageThemeColor());
	}

	// Changes color of status bar
	public void setStatusBarColor(int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(color);
		}
	}

	// Sets up webview
	public void setUpWebView() {
		if (getWebView() == null || getProgressBar() == null)
			return;
		// Setting up progressbar
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) 
			getProgressBar().setProgressTintList(ColorStateList.valueOf(getWebpageThemeColor()));
		else {
			Drawable progressDrawable = getProgressBar().getProgressDrawable().mutate();
			progressDrawable.setColorFilter(getWebpageThemeColor(), PorterDuff.Mode.SRC_IN);
			getProgressBar().setProgressDrawable(progressDrawable);
		}

		// Some optimal settings for android webview
		WebSettings settings = getWebView().getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setUserAgentString(getUserAgent());

		// Setting webclient for loading all links inside app
		getWebView().setWebViewClient(new WebViewClient());

		// Setting chrome client for getting to know progress of page in numeric
		getWebView().setWebChromeClient(new WebChromeClient() {
				@Override
				public void onProgressChanged(WebView view, int progress) {
					if (progress >= 100)
					// Page finished
						getProgressBar().setVisibility(View.GONE);
					else {
						// Page is loading
						if (getProgressBar().getVisibility() == View.GONE)
							getProgressBar().setVisibility(View.VISIBLE);
						getProgressBar().setProgress(progress);
					}
				}
			});
	}

	public void setWebpageThemeColor(int webpageThemeColor) {
		this.webpageThemeColor = webpageThemeColor;
	}

	public int getWebpageThemeColor() {
		return webpageThemeColor;
	}

	// Returns webview
	public WebView getWebView() {
		return webView;
	}

	// Returns ProgressBar
	public ProgressBar getProgressBar() {
		return progressBar;
	}

	// Sets Url
	public void setURL(String uRL) {
		URL = uRL;
	}

	// Returns Url
	public String getURL() {
		return URL;
	}

	// Returns Specific user agent (UA) for webview
	public String getUserAgent() {
		String UA = null;

		String deviceName = android.os.Build.MODEL.toLowerCase();
		String buildId = android.os.Build.ID;
		String androidVersion = android.os.Build.VERSION.RELEASE;

		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.KITKAT)
		// KitKat And Below
			UA = "Mozilla/5.0 (Linux; U; Android " + androidVersion + "; en-gb; Build/KLP) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";

		else if (android.os.Build.VERSION.SDK_INT == android.os.Build.VERSION_CODES.KITKAT_WATCH)
		// KitKat to lollipop
			UA = "Mozilla/5.0 (Linux; Android " + androidVersion + "; " + deviceName + " Build/" + buildId + ") AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";

		else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
		// Lollipop and above
			UA = "Mozilla/5.0 (Linux; Android " + androidVersion + "; " + deviceName + " Build/" + buildId + "; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36";
		return UA;
	}
}
