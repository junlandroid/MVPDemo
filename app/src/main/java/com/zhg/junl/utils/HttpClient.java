//package com.zhg.junl.utils;
//
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;
//
//import android.os.SystemClock;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.Request.Method;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.RetryPolicy;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.RequestFuture;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.android.wellchat.UIApplication;
//
//public class HttpClient
//{
//    private static final int      DEFAULT_TIMEOUT  = 45 * 1000;
//    private static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.MILLISECONDS;
//    private static RequestQueue   requestQueue;
//    private static HttpClient     httpClient;
//
//    public static HttpClient getInstance()
//    {
//        if (null == httpClient)
//        {
//            synchronized (HttpClient.class)
//            {
//                if (null == httpClient)
//                {
//                    httpClient = new HttpClient();
//                    requestQueue = Volley.newRequestQueue(UIApplication.getInstance());
//                    requestQueue.start();
//                }
//            }
//        }
//        return httpClient;
//    }
//
//    public String execHttpPost(String url, final Map<String, String> params) throws InterruptedException,
//            ExecutionException, TimeoutException
//    {
//        long time = SystemClock.uptimeMillis();
//
//
//        RequestFuture<String> requestFuture = RequestFuture.newFuture();
//
//        Request<?> request = new StringRequest(Method.POST, url, requestFuture, requestFuture)
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError
//            {
//                return params;
//            }
//
//        };
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, 2, MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestFuture.setRequest(request);
//
//        requestQueue.add(request);
//        String result = requestFuture.get(DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
//
//        return result;
//    }
//
//    public String execHttpGet(String url, final Map<String, String> params) throws InterruptedException, ExecutionException,
//            TimeoutException
//    {
//
//        long time = SystemClock.uptimeMillis();
//
//
//        RequestFuture<String> requestFuture = RequestFuture.newFuture();
//        Request<?> request = new StringRequest(Method.GET, url, requestFuture, requestFuture)
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError
//            {
//                return params;
//            }
//
//        };
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, 2, MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestFuture.setRequest(request);
//        requestQueue.add(request);
//        String result = requestFuture.get(DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
//
//        return result;
//    }
//
//    public String execHttpPut(String url, final Map<String, String> params) throws InterruptedException, ExecutionException,
//            TimeoutException
//    {
//
//        long time = SystemClock.uptimeMillis();
//
//
//        RequestFuture<String> requestFuture = RequestFuture.newFuture();
//        final Request<?> request = new StringRequest(Method.PUT, url, requestFuture, requestFuture)
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError
//            {
//                return params;
//            }
//        };
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, 2, MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestFuture.setRequest(request);
//        requestQueue.add(request);
//
//        String result = requestFuture.get(DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
//
//        return result;
//    }
//
//    public String execHttpDelete(String url, final Map<String, String> params) throws InterruptedException,
//            ExecutionException, TimeoutException
//    {
//
//        long time = SystemClock.uptimeMillis();
//
//
//        RequestFuture<String> requestFuture = RequestFuture.newFuture();
//        Request<?> request = new StringRequest(Method.DELETE, url, requestFuture, requestFuture)
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError
//            {
//                return params;
//            }
//
//        };
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, 2, MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestFuture.setRequest(request);
//        requestQueue.add(request);
//        String result = requestFuture.get(DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
//
//        return result;
//    }
//
//    public void execHttpPost(String url, Map<String, String> params, Listener<String> listener, ErrorListener errorListener)
//    {
//        url = getUrlWithParams(url, params);
//        Request<?> request = new StringRequest(Method.POST, url, listener, errorListener);
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, MyRetryPolicy.DEFAULT_MAX_RETRIES,
//                MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.add(request);
//    }
//
//    public void execHttpGet(String url, Map<String, String> params, Listener<String> listener, ErrorListener errorListener)
//    {
//        url = getUrlWithParams(url, params);
//        Request<?> request = new StringRequest(Method.GET, url, listener, errorListener);
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, MyRetryPolicy.DEFAULT_MAX_RETRIES,
//                MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.add(request);
//    }
//
//    public void execHttpPut(String url, Map<String, String> params, Listener<String> listener, ErrorListener errorListener)
//    {
//        url = getUrlWithParams(url, params);
//        Request<?> request = new StringRequest(Method.PUT, url, listener, errorListener);
//        request.setRetryPolicy(new MyRetryPolicy(DEFAULT_TIMEOUT, MyRetryPolicy.DEFAULT_MAX_RETRIES,
//                MyRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.add(request);
//    }
//
//    /**
//     * get complete url
//     *
//     * @param shouldEncodeUrl
//     * @param url
//     * @param params
//     * @return
//     */
//    public String getUrlWithParams(String url, Map<String, String> requestParams)
//    {
//        if (null != requestParams)
//        {
//            for (Entry<String, String> entry : requestParams.entrySet())
//            {
//                if (!url.contains("?"))
//                {
//                    url += "?" + entry.getKey() + "=" + entry.getValue();
//                } else
//                {
//                    url += "&" + entry.getKey() + "=" + entry.getValue();
//                }
//            }
//        }
//        url = url.replace(" ", "%20");
//        return url;
//    }
//
//    class MyRetryPolicy implements RetryPolicy
//    {
//        /** The current timeout in milliseconds. */
//        private int               mCurrentTimeoutMs;
//
//        /** The current retry count. */
//        private int               mCurrentRetryCount;
//
//        /** The maximum number of attempts. */
//        private final int         mMaxNumRetries;
//
//        /** The backoff multiplier for for the policy. */
//        private final float       mBackoffMultiplier;
//
//        /** The default socket timeout in milliseconds */
//        public static final int   DEFAULT_TIMEOUT_MS   = 2500;
//
//        /** The default number of retries */
//        public static final int   DEFAULT_MAX_RETRIES  = 1;
//
//        /** The default backoff multiplier */
//        public static final float DEFAULT_BACKOFF_MULT = 1f;
//
//        /**
//         * Constructs a new retry policy using the default timeouts.
//         */
//        public MyRetryPolicy()
//        {
//            this(DEFAULT_TIMEOUT_MS, DEFAULT_MAX_RETRIES, DEFAULT_BACKOFF_MULT);
//        }
//
//        /**
//         * Constructs a new retry policy.
//         *
//         * @param initialTimeoutMs
//         *            The initial timeout for the policy.
//         * @param maxNumRetries
//         *            The maximum number of retries.
//         * @param backoffMultiplier
//         *            Backoff multiplier for the policy.
//         */
//        public MyRetryPolicy(int initialTimeoutMs, int maxNumRetries, float backoffMultiplier)
//        {
//            mCurrentTimeoutMs = initialTimeoutMs;
//            mMaxNumRetries = maxNumRetries;
//            mBackoffMultiplier = backoffMultiplier;
//        }
//
//        /**
//         * Returns the current timeout.
//         */
//        @Override
//        public int getCurrentTimeout()
//        {
//            return mCurrentTimeoutMs;
//        }
//
//        /**
//         * Returns the current retry count.
//         */
//        @Override
//        public int getCurrentRetryCount()
//        {
//            return mCurrentRetryCount;
//        }
//
//        /**
//         * Prepares for the next retry by applying a backoff to the timeout.
//         *
//         * @param error
//         *            The error code of the last attempt.
//         */
//        @Override
//        public void retry(VolleyError error) throws VolleyError
//        {
//            mCurrentRetryCount++;
//            mCurrentTimeoutMs += (mCurrentTimeoutMs * mBackoffMultiplier);
//            if (!hasAttemptRemaining())
//            {
//                throw error;
//            } else
//            {
//                try
//                {
//                    Thread.sleep(800);
//                } catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        /**
//         * Returns true if this policy has attempts remaining, false otherwise.
//         */
//        protected boolean hasAttemptRemaining()
//        {
//            return mCurrentRetryCount <= mMaxNumRetries;
//        }
//
//    }
//}