package com.gameofcoding.socialcategory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.gameofcoding.socialcategory.Activities.WebViewActivity;
import com.gameofcoding.socialcategory.Helpers.UrlManager;

public class MainActivity extends Activity {
	Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
	}

	/*
	 * OnClickListeners for views
	 */
	// MOST POPULAR
	public void facebook(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.facebook);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_FACEBOOK);
		startActivity(intent);
	}

	public void messenger(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.messenger);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_MESSENGER);
		startActivity(intent);
	}

	public void twitter(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.twitter);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_TWITTER);
		startActivity(intent);
	}

	public void youtube(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.youtube);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_YOUTUBE);
		startActivity(intent);
	}

	public void snapchat(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.snapchat);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_SNAPCHAT);
		startActivity(intent);
	}

	public void instagram(View view) {
		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.instagram);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_INSTAGRAM);
		startActivity(intent);
	}

	public void gmail(View view) {

		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.gmail);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_GMAIL);
		startActivity(intent);
	}

	public void outlook(View view) {

		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.outlook);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_OUTLOOK);
		startActivity(intent);
	}

	public void yahooMail(View view) {

		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.yahoomail);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_YAHOO_MAIL);
		startActivity(intent);
	}

	public void tikTok(View view) {

		Intent intent = new Intent(context, 
								   WebViewActivity.class);
		intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
						R.color.tik_tok);
		intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
						UrlManager.URL_OF_TIK_TOK);
		startActivity(intent);
	}
}
