package com.geometry.vegapp.g_volley_manager;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Rijoy on 3/19/2017.
 */

public class volley_connection_class
{


    private static volley_connection_class iPermanent=null;
    private RequestQueue iRequestQueue=null;
    private static Context icontext;

    public volley_connection_class(Context ctx)
    {
        icontext = ctx;
        iRequestQueue = getiRequestQueue();
    }
    public RequestQueue getiRequestQueue()
    {
        if(iRequestQueue==null)
        {
            iRequestQueue = Volley.newRequestQueue(icontext.getApplicationContext());


        }

        return iRequestQueue;
    }

    /*

    In simple words a static synchronized method will lock the class instead of the object,
    and it will lock the class because the keyword static means: "class instead of instance".
     The keyword synchronized means that only one thread can access the method at a time.
     And together they mean: "Only one can access the class at one time".
     */

    public static synchronized volley_connection_class getInstance(Context ctx)
    {
        if(iPermanent==null)
        {
            iPermanent = new volley_connection_class(ctx);

        }

        return  iPermanent;
    }

    public<T> void addToRequestQueue(Request<T> request)
    {
        iRequestQueue.add(request);
    }


}
