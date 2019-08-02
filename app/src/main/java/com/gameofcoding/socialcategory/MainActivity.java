package com.gameofcoding.socialcategory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.gameofcoding.socialcategory.Activities.WebViewActivity;
import com.gameofcoding.socialcategory.Helpers.UrlManager;
import android.os.Build;
import java.io.BufferedWriter;

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
	  // MOST POPULAR SOCIAL MEDIA
	  public void facebook(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.facebook);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_FACEBOOK);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void messenger(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.messenger);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_MESSENGER);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void twitter(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.twitter);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_TWITTER);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void youtube(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.youtube);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_YOUTUBE);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void snapchat(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.snapchat);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_SNAPCHAT);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void instagram(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.instagram);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_INSTAGRAM);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void gmail(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.gmail);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_GMAIL);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void outlook(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.outlook);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_OUTLOOK);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void yahooMail(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.yahoomail);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_YAHOO_MAIL);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  // POPULAR SOCIAL MEDIA
	  public void tikTok(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.tik_tok);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_TIK_TOK);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void telegram(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.telegram);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_TELEGRAM);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void reddit(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.reddit);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_REDDIT);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void stackoverflow(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.stackoverflow);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_STACKOVERFLOW);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void netflix(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.netflix);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_NETFLIX);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void quora(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.quora);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_QUORA);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void tumblr(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.tumblr);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_TUMBLR);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void qzone(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.qzone);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_QZONE);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void skype(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.skype);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_SKYPE);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void viber(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.viber);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_VIBER);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

	  public void vk(View view) {
			Intent intent = new Intent(context, 
									   WebViewActivity.class);
			intent.putExtra(WebViewActivity.KEY_RESID_STATUS_BAR_COLOR, 
							R.color.vk);
			intent.putExtra(WebViewActivity.KEY_URL_OF_SOCIAL_MEDIA,
							UrlManager.URL_OF_VK);
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
			   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
			startActivity(intent);
		 }

   }
