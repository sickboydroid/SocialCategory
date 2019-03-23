package com.androandiron.socialcategory.UI;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.util.Log;
import android.app.Application;
import java.util.logging.LogRecord;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;

public class BaseActivity extends Activity {

	private String CRASH_FILE_PATH;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CRASH_FILE_PATH = getFilesDir() + "crash_report";
	}

	public Context getContext() {
		return getApplicationContext();
	}

	public int getDimen(int resId) {
		return (int) getContext().getResources().getDimension(resId);
	}

	public String[] getStringArray(int resId) {
		return getContext().getResources().getStringArray(resId);
	}

	@Deprecated
	public void showDumyToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void showSmallToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
	}

	public void showLongToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}

	public boolean isInLandscapemode() {
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE) 
			return true;
		else 
			return false;
	}

	public LayoutParams setLayoutParamsToMatchParent() {
		return new LayoutParams(LayoutParams.MATCH_PARENT,
								LayoutParams.MATCH_PARENT);
	}

	public LayoutParams setLayoutParamsToWrapContent() {
		return new LayoutParams(LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT);
	}

	public boolean hasCrashedLastTime() {
		Process process;
		return new File(CRASH_FILE_PATH).exists();
	}

	public String getCrashReport() {
		if (!hasCrashedLastTime())
			return null;
		else {
			File file = new File(CRASH_FILE_PATH);
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String buffer;
				String crashReport = "";
				while ((buffer = br.readLine()) != null) {
					crashReport += "\n" + buffer;
				}
				showLongToast(crashReport);
			} catch (FileNotFoundException e) {} catch (IOException e) {}

		}
		return null;
	}
}
