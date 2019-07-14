package com.gameofcoding.socialcategory.Helpers;

import android.content.Context;
import android.widget.Toast;
import android.webkit.URLUtil;
import java.net.URL;
import java.net.MalformedURLException;

public class UrlManager {
	private Context context;
	public static final String SOCKET = "https://";
	
	// Most Popular
	public static final int URL_OF_FACEBOOK = 101;
	public static final int URL_OF_MESSENGER = 102;
	public static final int URL_OF_TWITTER = 103;
	public static final int URL_OF_YOUTUBE = 104;
	public static final int URL_OF_SNAPCHAT = 105;
	public static final int URL_OF_INSTAGRAM = 106;
	public static final int URL_OF_GMAIL = 107;
	public static final int URL_OF_OUTLOOK = 108;
	public static final int URL_OF_YAHOO_MAIL = 109;
	
	// Popular
	public static final int URL_OF_TIK_TOK = 110;
	public static final int URL_OF_TELEGRAM = 111;
	public static final int URL_OF_REDDIT = 112;
	public static final int URL_OF_STACKOVERFLOW = 113;
	public static final int URL_OF_NETFLIX = 114;
	public static final int URL_OF_QUORA = 115;
	public static final int URL_OF_TUMBLR = 116;
	public static final int URL_OF_QZONE = 117;
	public static final int URL_OF_SKYPE = 118;
	public static final int URL_OF_VIBER = 119;
	public static final int URL_OF_VK = 120;
	
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
			case URL_OF_TELEGRAM:
				URL = SOCKET + "www.telegram.com";
				break;
			case URL_OF_REDDIT:
				URL = SOCKET + "www.reddit.com";
				break;
			case URL_OF_STACKOVERFLOW:
				URL = SOCKET + "www.stackoverflow.com";
				break;
			case URL_OF_NETFLIX:
				URL = SOCKET + "www.netflix.com";
				break;
			case URL_OF_QUORA:
				URL = SOCKET + "www.quora.com";
				break;
			case URL_OF_TUMBLR:
				URL = SOCKET + "www.tumblr.com";
				break;
			case URL_OF_QZONE:
				URL = SOCKET + "www.qzone.com";
				break;
			case URL_OF_SKYPE:
				URL = SOCKET + "www.skype.com";
				break;
			case URL_OF_VIBER:
				URL = SOCKET + "www.viber.com";
				break;
			case URL_OF_VK:
				URL = SOCKET + "www.vk.com";
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
