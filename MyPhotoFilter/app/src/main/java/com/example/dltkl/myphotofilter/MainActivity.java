package com.example.dltkl.myphotofilter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    ImageView image1;
    Drawable bora1;
    Bitmap bm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView)findViewById(R.id.image1);
        bora1 = getResources().getDrawable(R.drawable.bora1);
        bm1 = ((BitmapDrawable)bora1).getBitmap();
        Bitmap ibm1 = invertImage(bm1);

        image1.setImageBitmap(ibm1);
    }

    public static Bitmap invertImage(Bitmap bm){

        Bitmap image = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),bm.getConfig());

        int a,r,g,b;
        int pixelColor = 0;
        int h = bm.getHeight();
        int w = bm.getWidth();

        for(int y=0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixelColor = bm.getPixel(x, y);
                a = Color.alpha(pixelColor);
                r = 255 - Color.red(pixelColor);
                g = 255 - Color.green(pixelColor);
                b = 255 - Color.blue(pixelColor);
                image.setPixel(x, y, Color.argb(a, r, g, b));
            }
        }
        return image;
    }
}
