package com.gameofcoding.socialcategory.Helpers;

import java.util.HashMap;
import java.net.Socket;

public class URLS {
	public static final String SOCKET = "https://";

	public static final int URL = 99;
	public static final int MOBILE_SITE_URL = 98;
	public static final int DESKTOP_SITE_URL = 97;

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

	public HashMap<Integer,String> get(int of) {
		HashMap<Integer,String> URLsMap = new HashMap<Integer,String>();
		switch (of) {
			case URL_OF_FACEBOOK:
				URLsMap.put(URL, SOCKET + "www.facebook.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "m.facebook.com");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "www.facebook.com");
				break;
			case URL_OF_MESSENGER:
				URLsMap.put(URL, SOCKET + "www.facebook.com/messages");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "m.facebook.com/messages");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "www.facebook.com/messages");
				break;
			case URL_OF_TWITTER:
				URLsMap.put(URL, SOCKET + "www.twitter.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "m.twitter.com");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "www.twitter.com");
				break;
			case URL_OF_YOUTUBE:
				URLsMap.put(URL, SOCKET + "www.youtube.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "m.youtube.com");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "www.youtube.com");
				break;
			case URL_OF_SNAPCHAT:
				URLsMap.put(URL, SOCKET + "www.snapchat.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
			case URL_OF_INSTAGRAM:
				URLsMap.put(URL, SOCKET + "www.instagram.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
			case URL_OF_GMAIL:
				URLsMap.put(URL, SOCKET + "www.gmail.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
			case URL_OF_OUTLOOK:
				URLsMap.put(URL, SOCKET + "www.outlook.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
			case URL_OF_YAHOO_MAIL:
				URLsMap.put(URL, SOCKET + "www.yahoomail.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
			case URL_OF_TIK_TOK:
				URLsMap.put(URL, SOCKET + "www.tiktok.com");
				URLsMap.put(MOBILE_SITE_URL, SOCKET + "");
				URLsMap.put(DESKTOP_SITE_URL, SOCKET + "");
				break;
		}
		return URLsMap;
	}

	public String get(int of, int type) {
		return get(of).get(type);
	}
}
