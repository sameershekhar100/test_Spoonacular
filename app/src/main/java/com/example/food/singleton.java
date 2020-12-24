package com.example.food;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class singleton {
    @SuppressLint("StaticFieldLeak")
    private static singleton instance;
    private RequestQueue requestQueue;

    @SuppressLint("StaticFieldLeak")
    private static Context ctx;

    private singleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();


    }

    public static synchronized singleton getInstance(Context context) {
        if (instance == null) {
            instance = new singleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
