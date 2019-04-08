package com.androandiron.socialcategory.Activities;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.androandiron.socialcategory.R;
import com.androandiron.socialcategory.UI.BaseActivity;
import java.net.MalformedURLException;
import java.net.URL;

public class SocialMediaWebSiteOpener extends BaseActivity {
	Context context = this;

	WebView mWebView = null;

	String mHOST;

	// Keys
	public static final String KEY_RES_ID_STATUS_BAR_COLOR = "ksjd34kj3k4jk4jkj3_keyStatusBarColor";
	public static final String KEY_URL_OF_SOCIAL_MEDIA = "j3k2j33kj32k3j2_keyURLOfWebpage";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Getting and setting data
		String url = getIntent().getStringExtra(KEY_URL_OF_SOCIAL_MEDIA);
		if (!url.startsWith("http://"))
			url = "http://" + url;
		int color = getResources().getColor(getIntent().getIntExtra(KEY_RES_ID_STATUS_BAR_COLOR,
																	R.color.primaryDarkColor));
		setStatusBarColor(color);

		// Setting host
		try {
			setHOST(new URL(url).getHost());
		} catch (MalformedURLException e) {
			setHOST(null);
		}
		// Setting layout
		setContentView(R.layout.activity_social_media_website_opener);

		// Setting up webview for first time
		setWebView(setUpWebView((ProgressBar) findViewById(R.id.activity_social_media_website_openerProgressBar), color));
		getWebView().loadUrl(url);
	}

	// Sets webView for first time
	public WebView setUpWebView(final ProgressBar progressBar, int color) {
		// getting webView
		WebView webView = findViewById(R.id.activity_social_media_website_openercom_androandiron_socialcategory_Views_CustomWebViewForSocialMediaWebSites);

		// Setting up progressbar
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) 
			progressBar.setProgressTintList(ColorStateList.valueOf(color));
		else {
			Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
			progressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
			progressBar.setProgressDrawable(progressDrawable);
		}

		// Some optimal settings for android webview
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		//settings.setUserAgentString("Android");

		// Setting webclient for loading all links inside app
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url){
				try {
					if(hasHost())
						showSmallToast("yes");
					showSmallToast(new URL(url).getHost() + "\n" + getHOST());
					if (new URL(url).getHost().equals(getHOST()))
						view.loadUrl(url);
					else
						showSmallToast("iNAVLIDE URL");
				} catch (MalformedURLException e) {}
				return super.shouldOverrideUrlLoading(view, url);
			}
		});


		// Setting chrome client for getting to know progress of page in numeric
		webView.setWebChromeClient(new WebChromeClient(){

				@Override
				public void onProgressChanged(WebView view, int progress) {
					if (progress >= 100) {
						// Page finished
						progressBar.setVisibility(View.GONE);
					} else {
						// Page is loading
						if (progressBar.getVisibility() == View.GONE) {
							progressBar.setVisibility(View.VISIBLE);
						}

						progressBar.setProgress(progress);
					}
				}
			});
		return webView;
	}

	// Changes color of status bar
	public void setStatusBarColor(int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();

			// clear FLAG_TRANSLUCENT_STATUS flag:
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

			// finally change the color
			window.setStatusBarColor(color);
		}
	}

	public void setWebView(WebView mWebView) {
		this.mWebView = mWebView;
	}

	public WebView getWebView() {
		return mWebView;
	}

	// Checks for internet connection (Celluler or wifi)
	public boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager 
			= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null
			&& activeNetworkInfo.isConnected();
	}

	public boolean hasHost() {
		return mHOST != null;
	}

	public void setHOST(String HOST) {
		mHOST = HOST;
	}

	public String getHOST() {
		return mHOST;
	}

}
