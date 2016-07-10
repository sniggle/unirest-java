package com.mashape.unirest.android.util;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.mashape.unirest.android.http.HttpClientHelper;
import com.mashape.unirest.android.request.HttpRequest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by iulius on 10/07/16.
 */
public class GetRequestAsyncLoader<D> extends AsyncTaskLoader<D> {

	private final HttpRequest request;
	private final Class<D> responseClass;

	public GetRequestAsyncLoader(Context context, HttpRequest request, Class<D> responseClass) {
		super(context);
		this.request = request;
		this.responseClass = responseClass;
	}

	public D loadInBackground() {
		try {
			return HttpClientHelper.request(request, responseClass).getBody();
		} catch (UnirestException e) {
			super.cancelLoad();
		}
		return null;
	}

}
