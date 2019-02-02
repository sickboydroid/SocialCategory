package com.androandiron.socialcategory.UI;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class BaseActivity extends Activity {

	public Context getContext () {
		return getApplicationContext();
	}

	public int getDimen (int resId) {
		return (int) getContext().getResources().getDimension(resId);
	}

	public String[] getStringArray (int resId) {
		return getContext().getResources().getStringArray(resId);
	}

	@Deprecated
	public void showDumyToast (String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void showSmallToast (String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
	}

	public void showLongToast (String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}

	public boolean isInLandscapemode () {
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE) 
			return true;
		else 
			return false;
	}

	public LayoutParams setLayoutParamsToMatchParent () {
		return new LayoutParams(LayoutParams.MATCH_PARENT,
								LayoutParams.MATCH_PARENT);
	}
	
	public LayoutParams setLayoutParamsToWrapContent () {
		return new LayoutParams(LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT);
	}
}
