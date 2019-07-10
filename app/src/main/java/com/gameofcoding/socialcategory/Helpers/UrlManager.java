package com.gameofcoding.socialcategory.Helpers;

import android.content.Context;
import android.widget.Toast;
import android.webkit.URLUtil;
import java.net.URL;
import java.net.MalformedURLException;

public class UrlManager {
	private Context context;

	private String URL;
	private String mobileSiteURL;
	private String desktopSiteURL;

	public UrlManager(Context context, int URLOf) {
		this.context = context;
		URLS URLs = new URLS();
		URL = URLs.get(URLOf, URLS.URL);
		mobileSiteURL = URLs.get(URLOf, URLS.MOBILE_SITE_URL);
		desktopSiteURL = URLs.get(URLOf, URLS.DESKTOP_SITE_URL);
	}

	public String getUrl() {
		return URL;
	}

	public String getUrl(int type) {
		if (type == URLS.URL)
			return URL;
		else if (type == URLS.MOBILE_SITE_URL) 
			return getMobileSiteURL();
		else
			return getDesktopSiteURL();
	}

	public String getDesktopSiteURL() {
		return desktopSiteURL;
	}

	public String getMobileSiteURL() {
		return mobileSiteURL;
	}

	public boolean hasTwoSeparateSites() {
		return !mobileSiteURL.replaceFirst(URLS.SOCKET, "").isEmpty();
	}

	public void getOptimization() {}

	public String getAuthority() throws MalformedURLException {
		return new URL(URL).getAuthority();
	}
}
