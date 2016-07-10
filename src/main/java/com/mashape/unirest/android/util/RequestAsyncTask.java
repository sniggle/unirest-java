package com.mashape.unirest.android.util;

import android.os.AsyncTask;
import com.mashape.unirest.android.http.HttpClientHelper;
import com.mashape.unirest.android.http.HttpResponse;
import com.mashape.unirest.android.request.HttpRequest;
import com.mashape.unirest.android.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by iulius on 10/07/16.
 */
public class RequestAsyncTask<Result> extends AsyncTask<HttpRequest, Void, HttpResponse<Result>> {

	private final Class<Result> responseClass;
	private final Callback<Result> callback;

	public RequestAsyncTask(Class<Result> responseClass, Callback<Result> callback) {
		this.responseClass = responseClass;
		this.callback = callback;
	}


	protected HttpResponse<Result> doInBackground(HttpRequest... params) {
		try {
			return HttpClientHelper.request(params[0], responseClass);
		} catch (UnirestException e) {
			return null;
		}
	}

	@Override
	protected void onPostExecute(HttpResponse<Result> resultHttpResponse) {
		if( resultHttpResponse != null ) {
			callback.completed(resultHttpResponse);
		}
	}
}
