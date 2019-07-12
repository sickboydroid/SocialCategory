package com.gameofcoding.socialcategory.Helpers;

import android.content.Context;
import android.widget.Toast;
import android.webkit.URLUtil;
import java.net.URL;
import java.net.MalformedURLException;

public class UrlManager {
	private Context context;
	public static final String SOCKET = "https://";
	
	public static final int URL_OF_FACEBOOK = 101;
	public static final int URL_OF_MESSENGER = 102;
	public static final int URL_OF_TWITTER = 103;
	public static final int URL_OF_YOUTUBE = 104;
	public static final int URL_OF_SNAPCHAT = 105;
	public static final int URL_OF_INSTAGRAM = 106;
	public static final int URL_OF_GMAIL = 107;
	public static final int URL_OF_OUTLOOK = 108;
	public static final int URL_OF_YAHOO_MAIL = 109;
	public static final int URL_OF_TIK_TOK = 110;

	private String URL;

	public UrlManager(Context context, int URLOf) {
		this.context = context;
		switch (URLOf) {
			// Most Popular Social Media
			case URL_OF_FACEBOOK:
				URL = SOCKET + "www.facebook.com";
				break;
			case URL_OF_MESSENGER:
				URL = SOCKET + "www.facebook.com/messages";
				break;
			case URL_OF_TWITTER:
				URL = SOCKET + "www.twitter.com";
				break;
			case URL_OF_YOUTUBE:
				URL = SOCKET + "www.youtube.com";
				break;
			case URL_OF_SNAPCHAT:
				URL = SOCKET + "accounts.snapchat.com";
				break;
			case URL_OF_INSTAGRAM:
				URL = SOCKET + "www.instagram.com";
				break;
			case URL_OF_GMAIL:
				URL = SOCKET + "mail.google.com";
				break;
			case URL_OF_OUTLOOK:
				URL = SOCKET + "www.outlook.com";
				break;
			case URL_OF_YAHOO_MAIL:
				URL = SOCKET + "mail.yahoo.com";
				break;
				// Popular Social Media
			case URL_OF_TIK_TOK:
				URL = SOCKET + "www.tiktok.com";
				break;
				// Other Popular Social Media
				// Others
		}
	}

	public String getUrl() {
		return URL;
	}

	public void getOptimization() {}

	public String getAuthority() throws MalformedURLException {
		return new URL(URL).getAuthority();
	}
}
