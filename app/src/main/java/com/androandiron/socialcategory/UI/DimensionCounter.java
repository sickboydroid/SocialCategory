package com.androandiron.socialcategory.UI;

import android.content.Context;
import com.androandiron.socialcategory.R;

public class DimensionCounter {
	Context context;

	public DimensionCounter (Context context) {
		this.context = context;
	}

	// calculates how 
	public float calculateSizeInDp (float size) {
		// choosing best way of calculation
		float sizeInDp = 0f;
		float suitableDp = 0f;
		if (size % 5 == 0)
			suitableDp = context.getResources().getDimension(R.dimen._5dp);
		else if (size % 10 == 0) 
			suitableDp = context.getResources().getDimension(R.dimen._10dp);
		else if (size % 2 == 0) 
			suitableDp = context.getResources().getDimension(R.dimen._2dp);
		else 
			suitableDp = context.getResources().getDimension(R.dimen._1dp);

		while (sizeInDp != size)
			sizeInDp = sizeInDp + suitableDp;
		return sizeInDp;
	}
}
