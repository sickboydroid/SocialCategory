package com.androandiron.socialcategory.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.androandiron.socialcategory.R;
import com.androandiron.socialcategory.UI.BaseActivity;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import android.view.animation.AnimationUtils;

public class MainActivity extends BaseActivity {
	final Context context = this;
	boolean mHasMainLayout = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Setting crash view if app crashed last time
		if (hasCrashedLastTime()) {
			super.onCreate(savedInstanceState);
			getActionBar().hide();
			setHasMainLayout(true);
			setContentView(R.layout.layout_crash);
			File file = new File(getLogFilePath());
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				String fullFile = "";
				while ((line = br.readLine()) != null)
					fullFile += line + "\n";
				br.close();
				TextView tv = findViewById(R.id.layout_crashTextView);
				tv.setText(fullFile);
			} catch (FileNotFoundException e) {} catch (IOException e) {}
			return;
		}

		super.onCreate(savedInstanceState);

		// Setting content view
		setHasMainLayout(true);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId , MenuItem item) {
		if (item.getItemId() == R.id.about) {
			getActionBar().hide();
			TextView tvAbout = new TextView(context);
			tvAbout.setLayoutParams(getMatchParentLayoutParams());
			tvAbout.setGravity(Gravity.CENTER);
			tvAbout.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
			tvAbout.setText(R.string.about);
			tvAbout.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
			// Setting content view
			setHasMainLayout(false);
			setContentView(tvAbout);
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onBackPressed() {
		if (hasMainLayout()) // finish activity
			super.onBackPressed();
		else { // User is in about layout, changing layout to main
			getActionBar().show();
			View view = getLayoutInflater().inflate(R.layout.activity_main, null);
			view.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
			setContentView(view);
			setHasMainLayout(true);
		}
	}
	// Setter for variable mHasMainLayout
	public void setHasMainLayout(boolean hasMainLayout) {
		mHasMainLayout = hasMainLayout;
	}

	// Returns true if main layout is as layout else sets false
	public boolean hasMainLayout() {
		return mHasMainLayout;
	}

	// OnClickListeners for Main Activity views

	// Popular Social Media
	public void facebook(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.facebook_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "m.facebook.com");
		startActivity(intent);
	}

	public void netflix(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.netflix_red);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.netflix.com");
		startActivity(intent);
	}

	public void youtube(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.youtube_red);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "m.youtube.com");
		startActivity(intent);
	}

	public void snapchat(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.snapchat_yellow);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.snapchat.com");
		startActivity(intent);
	}

	public void googlePlus(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.google_plus_pink);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.googleplus.com");
		startActivity(intent);
	}

	public void twitter(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.twitter_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.twitter.com");
		startActivity(intent);
	}

	public void instagram(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.instagram_light_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.instagram.com");
		startActivity(intent);
	}

	public void quora(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.quora_red);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.quora.com");
		startActivity(intent);
	}

	public void stackoverflow(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.stackoverflow_orange);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.stackoverflow.com");
		startActivity(intent);
	}

	public void pinterest(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.pinterest_red);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.pinterest.com");
		startActivity(intent);
	}

	public void reddit(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.reddit_orange);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.reddit.com");
		startActivity(intent);
	}

	public void github(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.github_black);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.github.com");
		startActivity(intent);
	}

	public void tumblr(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.tumblr_dark_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.tumblr.com");
		startActivity(intent);

	}

	// Other Social Media
	public void ninegag(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.nine_gag_black);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.9gag.com");
		startActivity(intent);
	}

	public void badoo(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.badoo_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.badoo.com");
		startActivity(intent);
	}

	public void dailymotion(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.dailymotion_light_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.dailymotion.com");
		startActivity(intent);
	}

	public void digg(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.digg_black);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.digg.com");
		startActivity(intent);
	}

	public void flickr(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.flickr_black_brown);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.flickr.com");
		startActivity(intent);
	}

	public void linkedin(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.linkedin_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.linkedin.com");
		startActivity(intent);
	}

	public void meetup(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.meetup_rose_red);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.meetup.com");
		startActivity(intent);
	}

	public void myLife(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.mylife_green);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.mylife.com");
		startActivity(intent);
	}

	public void mySpace(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.myspace_sky_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.myspace.com");
		startActivity(intent);
	}

	public void qzone(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.qzone_blue);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.qzone.com");
		startActivity(intent);
	}

	public void stumbleupon(View view) {
		Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.stumbleupon_orange);
		intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.stumbleupon.com");
		startActivity(intent);
	}
}
