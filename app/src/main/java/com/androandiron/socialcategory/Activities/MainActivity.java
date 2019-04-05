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

public class MainActivity extends BaseActivity {
	final Context context = this;

	// Images Popular of social media websites
	final int[] IMAGES_OF_POPULAR_SOCIAL_MEDIA = {
		R.drawable.img_facebook,
		R.drawable.img_netflix,
		R.drawable.img_youtube,
		R.drawable.img_snapchat,
		R.drawable.img_instagram,
		R.drawable.img_google_plus,
		R.drawable.img_twitter,
		R.drawable.img_stackoverflow,
		R.drawable.img_quora,
		R.drawable.img_github,
		R.drawable.img_pinterest,
		R.drawable.img_reddit,
		R.drawable.img_tumblr
	};

	// Names of Popular social media websites
	final int[] NAMES_OF_POPULAR_SOCIAL_MEDIA = {
		R.string.facebook,
		R.string.netflix,
		R.string.youtube,
		R.string.snapchat,
		R.string.instagram,
		R.string.google_plus,
		R.string.twitter,
		R.string.stackoverflow,
		R.string.quora,
		R.string.github,
		R.string.pinterest,
		R.string.reddit,
		R.string.tumblr
	};

	// OnClickListeners for popular social media's
	final OnClickListener[] ON_CLICK_LISTENERS_FOR_POPULAR_SOCIAL_MEDIA={
		new OnClickListener(){ // Facebook

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.facebook_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.facebook.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Netflix
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.netflix_red);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.netflix.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Youtube
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.youtube_red);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.youtube.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Snapchat
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.snapchat_yellow);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.snapchat.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Instagram
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.instagram_light_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.instagram.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Google+
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.google_plus_pink);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.googleplus.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Twitter
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.twitter_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.twitter.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Stackoverflow
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.stackoverflow_orange);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.stackoverflow.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Quroa
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.quora_red);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.quora.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Github
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.github_black);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.github.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Pinterest
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.pinterest_red);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.pinterest.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Reddit
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.reddit_orange);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.reddit.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Tumler
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.tumler_dark_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.tumblr.com");
				startActivity(intent);
			}
		}

	};

	// Images Popular of social media websites
	final int[] IMAGES_OF_OTHER_SOCIAL_MEDIA = {
		R.drawable.img_nine_gag,
		R.drawable.img_badoo,
		R.drawable.img_dailymotion,
		R.drawable.img_digg,
		R.drawable.img_linkedin,
		R.drawable.img_meetup,
		R.drawable.img_my_life,
		R.drawable.img_my_space,
		R.drawable.img_qzone,
		R.drawable.img_stumbleupon
	};

	// Names Popular of social media websites
	final int[] NAMES_OF_OTHER_SOCIAL_MEDIA = {
		R.string.nine_gag,
		R.string.badoo,
		R.string.dailymotion,
		R.string.digg,
		R.string.flickr,
		R.string.linkedin,
		R.string.meetup,
		R.string.my_life,
		R.string.my_space,
		R.string.qzone,
		R.string.stumbleupon
	};

	// OnClickListeners for other social media's
	final OnClickListener[] ON_CLICK_LISTENERS_FOR_OTHER_SOCIAL_MEDIA={
		new OnClickListener(){

			@Override
			public void onClick(View view) { // Nine gag
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.nine_gag_black);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.9gag.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Badoo
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.badoo_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.badoo.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Dailymotion
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.dailymotion_light_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.dailymotion.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Digg
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.digg_black);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.digg.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Flicker
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.flickr_black_brown);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.flickr.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Linkedin
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.linkedin_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.linkedin.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Meetup
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.meetup_rose_red);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.meetup.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // MyLife
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.mylife_green);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.mylife.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // MySpace
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.myspace_sky_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.myspace.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Qzone
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.qzone_blue);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.qzone.com");
				startActivity(intent);
			}
		},

		new OnClickListener(){

			@Override
			public void onClick(View view) { // Stumbleupon
				Intent intent = new Intent(MainActivity.this, SocialMediaWebSiteOpener.class);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_RES_ID_STATUS_BAR_COLOR, R.color.stumbleupon_orange);
				intent.putExtra(SocialMediaWebSiteOpener.KEY_URL_OF_SOCIAL_MEDIA, "www.stumbleupon.com");
				startActivity(intent);
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Setting crash view if app crashed last time
		if (hasCrashedLastTime()) {
			super.onCreate(savedInstanceState);
			getActionBar().hide();
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
		setContentView(R.layout.activity_main);

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.menu_activity_main, menu);
//
//		// Changing color of menu item
//		int positionOfMenuItem = 0; // or whatever...
//		MenuItem item = menu.getItem(positionOfMenuItem);
//		SpannableString s = new SpannableString(getString(R.string.about));
//		s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s.length(), 0);
//		item.setTitle(s);
//		return super.onCreateOptionsMenu(menu);
//	}
//
//	@Override
//	public boolean onMenuItemSelected(int featureId , MenuItem item) {
//		if (item.getItemId() == R.id.about) {
//			TextView tvAbout = new TextView(context);
//			tvAbout.setLayoutParams(getMatchParentLayoutParams());
//			tvAbout.setGravity(Gravity.CENTER);
//			tvAbout.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
//			tvAbout.setText(R.string.about);
//			setContentView(tvAbout);
//		}
//		return super.onMenuItemSelected(featureId, item);
//	}
//
	// Creates single block with title
	public View createSingleBlock(LinearLayout mainColumnHandlerLinearLayout, String blockTitle, final int[] RES_ID_OF_IMAGES, final int[] RES_ID_OF_NAMES, final OnClickListener[] ON_CLICK_LISTENERS) {
		int noOfViewsInRow = 2; // Stores no. of views that should be created in row (Based on device and orientation)
		int noOfViewsCreated = 0; // Stores no. of views created in rows

		// Checking for device (Tablet or Smartphone) for setting no of rows in one column
		if (isSmallTablet()) {
			showSmallToast("small Tablet");
			// It is small (7'') tablet

			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 5;

			else
			// It is in Potrait mode
				noOfViewsInRow = 4;

		}if (isLargeTablet()) {
			showSmallToast("large Tablet");
			// It is large (10'') tablet

			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 6;

			else
			// It is in Potrait mode
				noOfViewsInRow = 5;

		} else if (isSmallSmartphone()) {
			showSmallToast("small");
			// It is small SmartPhone

			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 3;

			else
			// It is in Potrait mode
				noOfViewsInRow = 2;

		} else if (isLargeSmartphone()) {
			showSmallToast("big");
			// It is large SmartPhone

			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 4;

			else
			// It is in Potrait mode
				noOfViewsInRow = 3;
		}
//		if (isTablet()) {
//			// It is tablet
//
//			if (isInLandscapemode())
//			// It is in Landscape mode
//				noOfViewsInRow = 5;
//
//			else
//			// It is in Potrait mode
//				noOfViewsInRow = 4;
//		} else {
//			// It is SmartPhone
//
//			if (isInLandscapemode())
//			// It is in Landscape mode
//				noOfViewsInRow = 4;
//
//			else
//			// It is in Potrait mode
//				noOfViewsInRow = 3;
//		}
//

		// Setting orientation of LinearLayout
		mainColumnHandlerLinearLayout.setOrientation(LinearLayout.VERTICAL);

		// Setting title of block
		mainColumnHandlerLinearLayout.addView(getTitleOfBlock(blockTitle));

		// Creating all other views
		while (noOfViewsCreated != RES_ID_OF_IMAGES.length) {
			// Creating layout for single column
			LinearLayout singleColumnLinearLayout = new LinearLayout(context);
			singleColumnLinearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
																	  LayoutParams.WRAP_CONTENT));

			int noOfViewsCreatedInColumn = 0; // Stores no of views created in single column
			while (noOfViewsCreatedInColumn != noOfViewsInRow) {
				// Stops loop if no of views created is equal no of images
				if (noOfViewsCreated == RES_ID_OF_IMAGES.length)
					break;

				// Inflating relative layout for single view
				View singleView = getLayoutInflater().inflate(R.layout.view_blue_print_for_social_media, null);
				// Setting layout params with weight -> 1
				singleView.setLayoutParams(new LinearLayout.LayoutParams(0,
																		 LayoutParams.WRAP_CONTENT, 
																		 1.0f));

				// Setting image to imagebutton (Social Media Wbsites image)
				ImageButton iconOfSocialMedia = singleView.findViewById(R.id.view_blue_print_for_social_mediaImageButton_icon_of_social_media_website);
				iconOfSocialMedia.setImageResource(RES_ID_OF_IMAGES[noOfViewsCreated]);

				// Setting onClickListener to image button
				iconOfSocialMedia.setOnClickListener(ON_CLICK_LISTENERS[noOfViewsCreated]);

				// Setting title to TextView (Social Media Wbsites name)
				TextView iconTitleOfSocialMedia = singleView.findViewById(R.id.view_blue_print_for_social_mediaTextView_title_of_social_media_website);
				iconTitleOfSocialMedia.setText(RES_ID_OF_NAMES[noOfViewsCreated]);

				// Adding single view to single column layout
				singleColumnLinearLayout.addView(singleView);

				noOfViewsCreated++; // Increasing no of views total created
				noOfViewsCreatedInColumn++; // Inceasing no of views created in single column
			}
			// Adding single column to main linearlayout
			mainColumnHandlerLinearLayout.addView(singleColumnLinearLayout);
		}

		// Return rootView
		return mainColumnHandlerLinearLayout;
	}

	// Returns title of block (Styled)
	public View getTitleOfBlock(String title) {
		// Creating LinearLayout (Orientation = Horizontal) [One Column] for settign title of each block
		LinearLayout blockTitleLinearLayout = new LinearLayout(context);

		// Creating view for making first of line in title
		View firstHalf = new View(context);

		// Creating TextView for setting title of each block
		TextView blockTitleTextView = new TextView(context);

		// Creating view for making 2nd half of line
		View secondHalf = new View(context);

		// Setting layout params to all views of ViewGroup blockTitleLinearLayout [LinearLayout]
		blockTitleLinearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
																LayoutParams.WRAP_CONTENT));
		firstHalf.setLayoutParams(new LinearLayout.LayoutParams(0,
																getDimen(R.dimen._3dp), 1.0f));
		blockTitleTextView.setLayoutParams(getWrapContentLayoutParams());
		secondHalf.setLayoutParams(new LinearLayout.LayoutParams(0,
																 getDimen(R.dimen._3dp), 1.0f));

		// Setting padding to blockTitleLinearLayout [root view]
		blockTitleLinearLayout.setPadding(0, getDimen(R.dimen._4dp), 0, 0);

		// Setting background color to both of the views (First half and second half)
		firstHalf.setBackgroundResource(R.color.black);
		secondHalf.setBackgroundResource(R.color.black);

		// Setting up background for title of textView (Round corners [Bottom two])
		blockTitleTextView.setBackgroundResource(R.drawable.rounded_corners_bottom_right_bottom_left);

		// Styling texttive title
		blockTitleTextView.setTypeface(blockTitleTextView.getTypeface(), Typeface.BOLD);

		// Setting title to textView
		blockTitleTextView.setText(title);

		// Adding views to layout
		blockTitleLinearLayout.addView(firstHalf);
		blockTitleLinearLayout.addView(blockTitleTextView);
		blockTitleLinearLayout.addView(secondHalf);

		return blockTitleLinearLayout;
	}

	// Checks device
	private boolean isSmallTablet() {
		return context.getResources().getBoolean(R.bool.isSmallTablet);
	}

	// Checks device
	private boolean isLargeTablet() {
		return context.getResources().getBoolean(R.bool.isBigSmartphone);
	}
	// Checks device
	private boolean isSmallSmartphone() {
		return context.getResources().getBoolean(R.bool.isSmallSmartphone);
	}
	// Checks device
	private boolean isLargeSmartphone() {
		return context.getResources().getBoolean(R.bool.isBigSmartphone);
	}

	public void facebook(View view) {}

	public void netflix(View view) {}

	public void youtube(View view) {}

	public void snapchat(View view) {}

	public void twitter(View view) {}

	public void instagram(View view) {}

	public void quora(View view) {}

	public void stackoverflow(View view) {}

	public void pinterest(View view) {}

	public void reddit(View view) {}

	public void github(View view) {}

	public void tumblr(View view) {}

	public void ninegag(View view) {}

	public void badoo(View view) {}

	public void dailymotion(View view) {}

	public void digg(View view) {}

	public void flickr(View view) {}

	public void linkedin(View view) {}

	public void meetup(View view) {}

	public void myLife(View view) {}

	public void mySpace(View view) {}

	public void qzone(View view) {}

	public void stumbleupon(View view) {}
}
