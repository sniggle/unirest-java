/*
The MIT License

Copyright (c) 2013 Mashape (http://mashape.com)

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mashape.unirest.android.request;

import android.content.Context;
import com.mashape.unirest.android.util.RequestAsyncTask;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.android.http.async.Callback;

import java.io.InputStream;

public abstract class BaseRequest {

	protected static final String UTF_8 = "UTF-8";

	protected HttpRequest httpRequest;
	protected Context context;

	protected BaseRequest(HttpRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	public HttpRequest getHttpRequest() {
		return this.httpRequest;
	}

	protected BaseRequest() {
		super();
	}

	public BaseRequest with(Context context) {
		this.context = context;
		return this;
	}

	public void asString(Callback<String> result) {
		RequestAsyncTask<String> task = new RequestAsyncTask<String>(String.class, result);
		task.execute(getHttpRequest());
	}

	public void asJsonNode(Callback<JsonNode> callback) {
		RequestAsyncTask<JsonNode> task = new RequestAsyncTask<JsonNode>(JsonNode.class, callback);
		task.execute(getHttpRequest());
	}

	public <T> void asObject(Class<T> responseClass, Callback<T> callback) {
		RequestAsyncTask<T> task = new RequestAsyncTask<T>(responseClass, callback);
		task.execute(getHttpRequest());
	}

	public void asBinary(Callback<InputStream> callback) {
		RequestAsyncTask<InputStream> task = new RequestAsyncTask<InputStream>(InputStream.class, callback);
		task.execute(getHttpRequest());
	}

}
