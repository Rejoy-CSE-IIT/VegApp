package com.geometry.vegapp.i_ImageProcessing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.io.IOException;

public class PinchZoomImageView_class extends ImageView
{

    private Bitmap mBitmap;
    private int mImageWidth;
    private int mImageHeight;

    public PinchZoomImageView_class(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        //  canvas.save() is saying that I want to save the state of the current Canvas's adjustments
        // so that I can go back to it later. canvas.restore() is saying that I want to revert my
        // Canvas's adjustments back to the last time I called cavas.save() The beauty of this is
        // in its simplicity. If you already drew whatever it is you wanted to draw during the
        // save/restore block and you no longer need those adjustment's for your next drawing,
        // using this let's you throw away those unnecessary adjustments and return to the state
        // you want to start your next drawing from.

        //http://stackoverflow.com/questions/9691985/using-method-canvas-drawbitmapbitmap-src-dst-paint
        /*
        DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    int height = displaymetrics.heightPixels;
    int width = displaymetrics.widthPixels;

    int x = (int) (Math.random() * height);
    int y = (int) (Math.random() * width);

    Canvas.drawBitmap(R.drawable.sizem, x, y, paint);


         */

        canvas.save();
        canvas.drawBitmap(mBitmap, 0, 0, null);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setImageUri(Uri uri, int MODE)
    {

        try
        {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
            float aspecRatio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

            if(MODE==1)
            {
                mImageWidth = displayMetrics.widthPixels - displayMetrics.widthPixels / 3;
            }
            else
            {
                mImageWidth = displayMetrics.widthPixels;
            }
            mImageHeight = Math.round(mImageWidth * aspecRatio);
            this.getLayoutParams().height = mImageHeight;
            this.getLayoutParams().width = mImageWidth;
            mBitmap = Bitmap.createScaledBitmap(bitmap, mImageWidth, mImageHeight, false);






            //Generally, invalidate() means 'redraw on screen' and results to a call of the view's onDraw() method.
            // So if something changes and it needs to be reflected on screen, you need to call invalidate().
            // However, for built-in widgets you rarely, if ever, need to call it yourself.
            // When you change the state of a widget, internal code will call invalidate()
            // as necessary and your change will be reflected on screen. For example,
            // if you call TextView.setText(), after doing a lot of internal processing
            // (will the text fit on screen, does it need to be ellipsised, etc.),
            // TextView will call invalidate() before setText() returns. Similarly for other widgets.
            invalidate();
            //or me a call to invalidate() only refresh the view and a call to requestLayout()
            // refresh the view and compute the size of the view in the screen.
            requestLayout();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void setImageUri_bitmap(Bitmap bitmap, int MODE)
    {




        float aspecRatio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        if(MODE==1)
        {
            mImageWidth = displayMetrics.widthPixels - displayMetrics.widthPixels / 3;
        }
        else
        {
            mImageWidth = displayMetrics.widthPixels;
        }
        mImageHeight = Math.round(mImageWidth * aspecRatio);
        mBitmap = Bitmap.createScaledBitmap(bitmap, mImageWidth, mImageHeight, false);
        //Generally, invalidate() means 'redraw on screen' and results to a call of the view's onDraw() method.
        // So if something changes and it needs to be reflected on screen, you need to call invalidate().
        // However, for built-in widgets you rarely, if ever, need to call it yourself.
        // When you change the state of a widget, internal code will call invalidate()
        // as necessary and your change will be reflected on screen. For example,
        // if you call TextView.setText(), after doing a lot of internal processing
        // (will the text fit on screen, does it need to be ellipsised, etc.),
        // TextView will call invalidate() before setText() returns. Similarly for other widgets.
        invalidate();
        //or me a call to invalidate() only refresh the view and a call to requestLayout()
        // refresh the view and compute the size of the view in the screen.
        requestLayout();



    }

    public void setImagebitmap(Bitmap bitmap,int MODE)
    {



        float aspecRatio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        if(MODE==1)
        {
            mImageWidth = displayMetrics.widthPixels - displayMetrics.widthPixels / 3;
        }
        else
        {
            mImageWidth = displayMetrics.widthPixels;
        }
        mImageHeight = Math.round(mImageWidth * aspecRatio);
        mBitmap = Bitmap.createScaledBitmap(bitmap, mImageWidth, mImageHeight, false);
        //Generally, invalidate() means 'redraw on screen' and results to a call of the view's onDraw() method.
        // So if something changes and it needs to be reflected on screen, you need to call invalidate().
        // However, for built-in widgets you rarely, if ever, need to call it yourself.
        // When you change the state of a widget, internal code will call invalidate()
        // as necessary and your change will be reflected on screen. For example,
        // if you call TextView.setText(), after doing a lot of internal processing
        // (will the text fit on screen, does it need to be ellipsised, etc.),
        // TextView will call invalidate() before setText() returns. Similarly for other widgets.
        invalidate();
        //or me a call to invalidate() only refresh the view and a call to requestLayout()
        // refresh the view and compute the size of the view in the screen.
        requestLayout();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int imageWidth = MeasureSpec.getSize(widthMeasureSpec);
        int imageHeight = MeasureSpec.getSize(heightMeasureSpec);

        // This will set from full screen to correct image
        setMeasuredDimension(
                Math.min(imageWidth, mImageWidth),
                Math.min(imageHeight, mImageHeight)
        );
    }

}
