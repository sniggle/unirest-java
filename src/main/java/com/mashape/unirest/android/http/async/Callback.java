package com.mashape.unirest.android.http.async;

import com.mashape.unirest.android.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by iulius on 11/07/16.
 */
public interface Callback<T> {

	void completed(HttpResponse<T> var1);

	void failed(UnirestException var1);

	void cancelled();

}
