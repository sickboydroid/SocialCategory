package com.androandiron.socialcategory.Activities;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup.LayoutParams;
import com.androandiron.socialcategory.R;
import com.androandiron.socialcategory.UI.BaseActivity;
import com.androandiron.socialcategory.Views.CustomWebViewForSocialMediaWebSites;

public class SocialMediaWebSiteOpener extends BaseActivity {
	Context context = this;

	WebView mWebView = null;

	public static final String KEY_RES_ID_STATUS_BAR_COLOR = "ksjd34kj3k4jk4jkj3_keyStatusBarColor";
	public static final String KEY_URL_OF_SOCIAL_MEDIA = "j3k2j33kj32k3j2_keyURLOfWebpage";

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String Url = "http://" + intent.getStringExtra(KEY_URL_OF_SOCIAL_MEDIA);
		setStatusBarColor(getResources().getColor(intent.getIntExtra(KEY_RES_ID_STATUS_BAR_COLOR, R.color.primaryDarkColor)));

		setContentView(R.layout.activity_social_media_website_opener);
		setWebView(setUpWebView((ProgressBar) findViewById(R.id.activity_social_media_website_openerProgressBar)));
		getWebView().loadUrl(Url);
	}

	// Sets webView for first time
	public CustomWebViewForSocialMediaWebSites setUpWebView (final ProgressBar progressBar) {

		// Creating webView
		CustomWebViewForSocialMediaWebSites webView = new CustomWebViewForSocialMediaWebSites(context);
		webView.setLayoutParams(setLayoutParamsToMatchParent());

		// Adjusting webView
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		webView.setFocusable(true);
		webView.setFocusableInTouchMode(true);

		// Some optimal settings for android webview
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		settings.setDatabaseEnabled(true);
		settings.setDatabasePath("/data/data/" + getPackageName() + "/databases/");
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setSupportMultipleWindows(true);
		settings.setBuiltInZoomControls(true);
		settings.setSaveFormData(false);
		settings.setSavePassword(false);
		settings.setRenderPriority(WebSettings.RenderPriority.HIGH);

		// Flash settings
		settings.setPluginState(WebSettings.PluginState.ON);

		// Geo location settings
		settings.setGeolocationEnabled(true);
		settings.setGeolocationDatabasePath("/data/data/selendroid");

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// chromium, enable hardware acceleration
			webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		} else {
			// older android version, disable hardware acceleration
			webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}

		webView.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading (WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
			});

		webView.setWebChromeClient(new WebChromeClient(){

				@Override
				public void onProgressChanged (WebView view, int progress) {
					if (progress <= 100) {
						progressBar.setVisibility(View.VISIBLE);
						progressBar.setProgress(progress);
					} else
						progressBar.setVisibility(View.GONE);
				}
			});
		return webView;
	}
	// Changes color of status bar
	public void setStatusBarColor (int color) {
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

	public void setWebView (WebView mWebView) {
		this.mWebView = mWebView;
	}

	public WebView getWebView () {
		return mWebView;
	}

}
