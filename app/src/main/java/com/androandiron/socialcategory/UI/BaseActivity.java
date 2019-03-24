package com.androandiron.socialcategory.UI;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseActivity extends Activity {

	private final String KEY_CRASH_REPORT = "closedLastTimeSafely";
	private String PATH_TO_CRASH_REPORT_FILE = null;

	/*
	 * Overrided Methods
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PATH_TO_CRASH_REPORT_FILE = getFilesDir() + "crash_report";
		
		savePreferences(KEY_CRASH_REPORT, false);
	}

	@Override
	public void onUserLeaveHint() {
		savePreferences(KEY_CRASH_REPORT, true);
		super.onUserLeaveHint();
	}

	@Override
	public void onResume() {
		super.onResume();
		savePreferences(KEY_CRASH_REPORT, false);
	}

	@Override
	public void onPause() {
		super.onPause();
		savePreferences(KEY_CRASH_REPORT, true);
	}

	@Override
	public void onDestroy() {
		savePreferences(KEY_CRASH_REPORT, true);
		super.onDestroy();
	}

	/*
	 * Public Methods
	 */
	// Can be used as a terminal
	public String terminal(String ... cmd) {
		Process process = null;
		StringBuilder output = null;
		BufferedReader bufferedReader = null;
		String line = null;

		try {
			process = Runtime.getRuntime().exec(cmd);
			output = new StringBuilder();

			bufferedReader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
			while ((line = bufferedReader.readLine()) != null)
				output.append(line + "\n");
			bufferedReader.close();

			bufferedReader = new BufferedReader(
				new InputStreamReader(process.getErrorStream()));
			while ((line = bufferedReader.readLine()) != null)
				output.append("========Error=========>|  " + line + "\n");
			bufferedReader.close();

		} catch (IOException e) {} finally {
			try {
				if (process != null) process.destroy();

				if (bufferedReader != null) bufferedReader.close();

				return output.toString();
			} catch (IOException e) {
				return output.toString();
			}
		}

	}
	
	// Returns logcat file path
	public String getLogFilePath(){
		setCrashReport();
		return PATH_TO_CRASH_REPORT_FILE;
	}

	/*
	 * Protected Methods
	 */
	// Returns Context of application
	protected Context getContext() {
		return getApplicationContext();
	}

	// Returns dimension
	protected int getDimen(int resId) {
		return (int) getContext().getResources().getDimension(resId);
	}

	// Return String array
	protected String[] getStringArray(int resId) {
		return getContext().getResources().getStringArray(resId);
	}

	// Shows Quick Toast
	protected void showSmallToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
	}

	// Shows Long Toast
	protected void showLongToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}

	// Returns true if the device is in landscape mode
	protected boolean isInLandscapemode() {
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE) 
			return true;
		else 
			return false;
	}

	// Return Layoutparams which can be used to set a view to matchparent
	protected LayoutParams getMatchParentLayoutParams() {
		return new LayoutParams(LayoutParams.MATCH_PARENT,
								LayoutParams.MATCH_PARENT);
	}

	// Return Layoutparams which can be used to set a view to wrapcontent
	protected LayoutParams getWrapContentLayoutParams() {
		return new LayoutParams(LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT);
	}

	// Returns true if app has crashed last time
	protected boolean hasCrashedLastTime() {
		return !(PreferenceManager
			.getDefaultSharedPreferences(this)
			.getBoolean(KEY_CRASH_REPORT, true));
	}
	
	/*
	 *	Private Methods
	 */
	private void setCrashReport() {

		if (!hasCrashedLastTime())
			return;
		else {
			try {
				new FileOutputStream(PATH_TO_CRASH_REPORT_FILE)
					.write(terminal("logcat", "-d").getBytes());
			} catch (FileNotFoundException e) {} catch (IOException e) {}
		}
	}

	private void savePreferences(String key, boolean value) {
		PreferenceManager
			.getDefaultSharedPreferences(this)
			.edit().putBoolean(key, value)
			.commit();
	}

}
