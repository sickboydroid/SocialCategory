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
import com.gameofcoding.socialcategory.Helpers.UrlManager;
import com.gameofcoding.socialcategory.R;
import com.gameofcoding.socialcategory.Helpers.URLS;

public class WebViewActivity extends Activity {
	final Context context = this;
	private String URL;
	private int webpageThemeColor;
	
	// Web browser User agents
	private final String PHONE_UA = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";

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

	// Gets Intents for activity startup
	public void manageIntents() {
		// Getting url
		int URLOf = getIntent().getIntExtra(KEY_URL_OF_SOCIAL_MEDIA, 0);
		setURL(new UrlManager(context, URLOf)
			   .getUrl(getURLType(URLOf)));

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
		settings.setUserAgentString("Mozilla/5.0 (Linux; Android 6.0.0; ikall n4 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");

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

	// INCOMPLETE METHODS
	// Return Url Type for specific website
	public int getURLType(int of) {
		return new URLS().URL;
	}
}
