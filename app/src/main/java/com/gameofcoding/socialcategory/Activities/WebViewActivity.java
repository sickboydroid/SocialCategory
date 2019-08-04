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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gameofcoding.socialcategory.Helpers.UrlManager;
import com.gameofcoding.socialcategory.R;
import android.view.animation.AnimationSet;

public class WebViewActivity extends Activity {
	final Context context = this;
	private String URL;
	private int webpageThemeColor;

	// Keys
	public static final String KEY_RESID_STATUS_BAR_COLOR = "ksjd_keyStatusBarColor";
	public static final String KEY_URL_OF_SOCIAL_MEDIA = "j3j2_keyURLOfWebpage";

	// Views
	private WebView webView;
	private ProgressBar progressBar;
	private View mainLayout;
	private View errorLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mainLayout = getLayoutInflater().inflate(R.layout.layout_webview, null);
		errorLayout = getLayoutInflater().inflate(R.layout.layout_error_webview, null);

		setContentView(getMainLayout());

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
	public void setStatusBarColor(int colorResID) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(colorResID);
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
		getWebView().setWebViewClient(new WebViewClient(){
				@SuppressWarnings("Deprecation")
				@Override	
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
					switch (errorCode) {
						case ERROR_AUTHENTICATION:
							break;
						case ERROR_BAD_URL:
							break;
						case  ERROR_CONNECT:
							break;
						case ERROR_FAILED_SSL_HANDSHAKE:
							break;
						case ERROR_FILE:
							break;
						case ERROR_FILE_NOT_FOUND:
							break;
						case ERROR_HOST_LOOKUP:
							break;
						case ERROR_IO:
							break;
						case ERROR_PROXY_AUTHENTICATION:
							break;
						case ERROR_REDIRECT_LOOP:
							break;
						case ERROR_TIMEOUT:
							break;
						case ERROR_TOO_MANY_REQUESTS:
							break;
						case ERROR_UNKNOWN:
							break;
						case ERROR_UNSUPPORTED_AUTH_SCHEME:
							break;
						case ERROR_UNSUPPORTED_SCHEME:
							break;
						default:
					}
				}
				@Override	
				public void onReceivedError(WebView view, final WebResourceRequest request, WebResourceError error) {
					int resIdErrorSolution = R.string.error_solution;
					int resIdErrorMessage;
					switch (error.getErrorCode()) {
						case ERROR_AUTHENTICATION:
							resIdErrorMessage = R.string.error_authentication;
							resIdErrorSolution = R.string.error_authentication_solutions;
							break;
						case ERROR_BAD_URL:
							resIdErrorMessage = R.string.error_bad_url;
							resIdErrorSolution = R.string.error_bad_url_solutions;
							break;
						case  ERROR_CONNECT:
							resIdErrorMessage = R.string.error_connect;
							resIdErrorSolution = R.string.error_connect_solutions;
							break;
						case ERROR_FAILED_SSL_HANDSHAKE:
							resIdErrorMessage = R.string.error_failed_ssl_handshake;
							resIdErrorSolution = R.string.error_failed_ssl_handshake_solutions;
							break;
						case ERROR_FILE:
							resIdErrorMessage = R.string.error_file;
							resIdErrorSolution = R.string.error_file_solutions;
							break;
						case ERROR_FILE_NOT_FOUND:
							resIdErrorMessage = R.string.error_file_not_found;
							resIdErrorSolution = R.string.error_file_not_found_solutions;
							break;
						case ERROR_HOST_LOOKUP:
							resIdErrorMessage = R.string.error_host_lookup;
							resIdErrorSolution = R.string.error_host_lookup_solutions;
							break;
						case ERROR_IO:
							resIdErrorMessage = R.string.error_io;
							resIdErrorSolution = R.string.error_io_solutions;
							break;
						case ERROR_PROXY_AUTHENTICATION:
							resIdErrorMessage = R.string.error_proxy_authentication;
							resIdErrorSolution = R.string.error_proxy_authentication_solutions;
							break;
						case ERROR_REDIRECT_LOOP:
							resIdErrorMessage = R.string.error_redirect_loop;
							resIdErrorSolution = R.string.error_redirect_loop_solutions;
							break;
						case ERROR_TIMEOUT:
							resIdErrorMessage = R.string.error_timeout;
							resIdErrorSolution = R.string.error_timeout_solutions;
							break;
						case ERROR_TOO_MANY_REQUESTS:
							resIdErrorMessage = R.string.error_too_many_requests;
							resIdErrorSolution = R.string.error_too_many_requests;
							break;
						case ERROR_UNKNOWN:
							resIdErrorMessage = R.string.error_unknown;
							resIdErrorSolution = R.string.error_unknown_solutions;
							break;
						case ERROR_UNSAFE_RESOURCE:
							resIdErrorMessage = R.string.error_unsafe_resource;
							resIdErrorSolution = R.string.error_unsafe_resource_solutions;
							break;
						case ERROR_UNSUPPORTED_AUTH_SCHEME:
							resIdErrorMessage = R.string.error_unsupported_auth_scheme;
							resIdErrorSolution = R.string.error_unsupported_auth_scheme_solutions;
							break;
						case ERROR_UNSUPPORTED_SCHEME:
							resIdErrorMessage = R.string.error_unsupported_scheme;
							resIdErrorSolution = R.string.error_unsupported_scheme_solutions;
							break;
						case SAFE_BROWSING_THREAT_MALWARE:
							resIdErrorMessage = R.string.safe_browsing_threat_malware;
							resIdErrorSolution = R.string.safe_browsing_threat_malware_solutions;
							break;
						case SAFE_BROWSING_THREAT_PHISHING:
							resIdErrorMessage = R.string.safe_browsing_threat_phishing;
							resIdErrorSolution = R.string.safe_browsing_threat_phishing_solutions;
							break;
						case SAFE_BROWSING_THREAT_UNKNOWN:
							resIdErrorMessage = R.string.safe_browsing_threat_unknown;
							resIdErrorSolution = R.string.safe_browsing_threat_unknown_solutions;
							break;
						case SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE:
							resIdErrorMessage = R.string.safe_browsing_threat_unwanted_software;
							resIdErrorSolution = R.string.safe_browsing_threat_unwanted_software_solutions;
							break;
						default:
							resIdErrorMessage = R.string.no_info;
					}
					setContentView(getErrorLayout());
					getWebView().loadUrl("about:blank");

					TextView tvErrorCause = findViewById(R.id.textViewErrorCause);
					tvErrorCause.setText(error.getDescription());

					TextView tvErrorSolution = findViewById(R.id.textViewErrorSolutions);
					tvErrorSolution.setText(resIdErrorSolution);

					TextView tvErrorMessage = findViewById(R.id.textViewErrorMessage);
					tvErrorMessage.setText("Cause: " + getResources().getString(resIdErrorMessage));

					findViewById(R.id.buttonReload).setOnClickListener(new View.OnClickListener(){
							@Override
							public void onClick(View v) {
								setContentView(getMainLayout());
								getWebView().loadUrl(request.getUrl().toString());
							}
						});
				}
			});

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

	/**
	 * Returns error layout for webview that shows which type of error occurred
	 */
	public View getErrorLayout() {
		return errorLayout;
	}

	/**
	 * Returns main layout for activity
	 */
	public View getMainLayout() {
		return mainLayout;
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
