package com.androandiron.socialcategory.Activities;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
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

public class SocialMediaWebSiteOpener extends BaseActivity {
	Context context = this;

	WebView mWebView = null;

	// Keys
	public static final String KEY_RES_ID_STATUS_BAR_COLOR = "ksjd34kj3k4jk4jkj3_keyStatusBarColor";
	public static final String KEY_URL_OF_SOCIAL_MEDIA = "j3k2j33kj32k3j2_keyURLOfWebpage";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (isNetworkAvailable()) {
			showSmallToast("yes");
			new AlertDialog.Builder(context)
				.setTitle("Delete entry")
				.setMessage("Are you sure you want to delete this entry?")

				// Specifying a listener allows you to take an action before dismissing the dialog.
				// The dialog is automatically dismissed when a dialog button is clicked.
				.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) { 
						// Continue with delete operation
					}
				})

				// A null listener allows the button to dismiss the dialog and take no further action.
				.setNegativeButton(android.R.string.no, null)
				.show();		
		} else {
			showLongToast("no");
			super.finish();
		}
		// Getting and setting data
		String url = getIntent().getStringExtra(KEY_URL_OF_SOCIAL_MEDIA);
		if (!url.startsWith("http://"))
			url = "http://" + url;
		int color = getResources().getColor(getIntent().getIntExtra(KEY_RES_ID_STATUS_BAR_COLOR,
																	R.color.primaryDarkColor));
		setStatusBarColor(color);

		// Setting layout
		setContentView(R.layout.activity_social_media_website_opener);

		// Setting up webview for first time
		setWebView(setUpWebView((ProgressBar) findViewById(R.id.activity_social_media_website_openerProgressBar), color));
		getWebView().loadUrl(url);
	}

	// Sets webView for first time
	public WebView setUpWebView(final ProgressBar progressBar, int color) {
//		progressBar.setVisibility(View.GONE);

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

		// Adjusting webView
//		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		webView.setFocusable(true);
		webView.setFocusableInTouchMode(true);

		// Some optimal settings for android webview
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		settings.setDatabaseEnabled(true);
		settings.setDatabasePath("/data/data/" + getPackageName() + "/databases/");
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
//		settings.setSupportMultipleWindows(true);
//		settings.setBuiltInZoomControls(true);
		settings.setSaveFormData(false);
		settings.setSavePassword(false);
//		settings.setRenderPriority(WebSettings.RenderPriority.HIGH);

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

		// Setting webclient for loading all links inside app
		webView.setWebViewClient(new WebViewClient());

		// Setting chrome client for getting to know progress of page in numeric
		webView.setWebChromeClient(new WebChromeClient(){

				@Override
				public void onProgressChanged(WebView view, int progress) {
					if (progress >= 100) {
						// Page finished
						progressBar.setVisibility(View.GONE);
						view.invalidate();
					} else {
						// Page is loading
						if (progressBar.getVisibility() == View.GONE) {
							//progressBar.setVisibility(View.VISIBLE);
							view.invalidate();
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

}
