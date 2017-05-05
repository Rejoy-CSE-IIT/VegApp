package com.geometry.vegapp.c_utility_functions;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;

import com.geometry.vegapp.b_homepage.homepage_activity;

/**
 * Created by Rijoy on 3/18/2017.
 */
public class helperFunctions_class
{




    public static void showToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void logOut_reset_flags(Context context)
    {
        homepage_activity.user_mode= null;
        homepage_activity.user_name = null;
        homepage_activity.user_id = -1;
        homepage_activity.login_status = false;
    }
    public static float getScreenWidth(Activity activity)
    {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float pxWidth = outMetrics.widthPixels;
        return pxWidth;
    }
}
