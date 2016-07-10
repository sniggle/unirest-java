package com.mashape.unirest.android.http.utils;

import com.mashape.unirest.android.http.options.Option;
import com.mashape.unirest.android.http.options.Options;
import org.apache.http.client.HttpClient;

/**
 * Created by iulius on 11/07/16.
 */
public class ClientFactory {

	public static HttpClient getHttpClient() {
		return (HttpClient) Options.getOption(Option.HTTPCLIENT);
	}

}
