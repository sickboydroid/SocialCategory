package com.androandiron.socialcategory.Activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.androandiron.socialcategory.R;
import com.androandiron.socialcategory.UI.BaseActivity;

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
		R.drawable.img_tumler
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
		R.string.tumler
	};

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createBlock(IMAGES_OF_POPULAR_SOCIAL_MEDIA, NAMES_OF_POPULAR_SOCIAL_MEDIA));
    }

	// Creates single block with title
	public View createBlock (final int[] RES_ID_OF_IMAGES, final int[] RES_ID_OF_NAMES) {
		int noOfViewsInRow = 2; // Stores no. of views that should be created in row (Based on device and orientation)
		int noOfViewsCreated = 0; // Stores no. of views created in rows

		// Checking for device (Tablet or Smartphone) for setting no of rows in one column
		if (isTablet()) {
			// It is tablet
			
			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 5;

			else
			// It is in Potrait mode
				noOfViewsInRow = 4;
		} else {
			// It is SmartPhone
			
			if (isInLandscapemode())
			// It is in Landscape mode
				noOfViewsInRow = 4;

			else
			// It is in Potrait mode
				noOfViewsInRow = 3;
		}

		/* 
		 * Creating main layout (ScrollView)
		 */
		ScrollView mainLayoutScrollView = new ScrollView(context);
		
		/* 
		 * Creating LinearLayout for single column (OneColumn = LinearLayout + RelativeLayout)
		 */
		LinearLayout mainColumnHandlerLinearLayout = new LinearLayout(context);

		// Setting layout params
		mainLayoutScrollView.setLayoutParams(setLayoutParamsToMatchParent());
		mainColumnHandlerLinearLayout.setLayoutParams(setLayoutParamsToMatchParent());

		// Setting orientation of LinearLayout
		mainColumnHandlerLinearLayout.setOrientation(LinearLayout.VERTICAL);

		// Setting title of block
		mainColumnHandlerLinearLayout.addView(getTitleOfBlock(getString(R.string.popular_social_media)));

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

		// Adding main linearlayout root layout (Scrollview)
		mainLayoutScrollView.addView(mainColumnHandlerLinearLayout);

		// Return rootView
		return mainLayoutScrollView;
	}

	// Returns title of block (Styled)
	public View getTitleOfBlock (String title) {
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
		blockTitleTextView.setLayoutParams(setLayoutParamsToWrapContent());
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
		blockTitleTextView.setTextColor(getColor(R.color.black));
		blockTitleTextView.setTypeface(blockTitleTextView.getTypeface(), Typeface.BOLD);

		// Setting title to textView
		blockTitleTextView.setText(title);

		// Adding views to layout
		blockTitleLinearLayout.addView(firstHalf);
		blockTitleLinearLayout.addView(blockTitleTextView);
		blockTitleLinearLayout.addView(secondHalf);

		return blockTitleLinearLayout;
	}

	// Checks device (Tablet =< 600dp && Smartphone => 600dp)
	private boolean isTablet () {
		return context.getResources().getBoolean(R.bool.isTablet);
	}

}
