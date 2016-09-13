package com.samset.user.viewpagertransformation;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samset.user.viewpagertransformation.adapters.MyPagerAdapter;
import com.samset.user.viewpagertransformation.transformations.NicePageTransformer;
import com.samset.user.viewpagertransformation.transformations.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewpager);
        // Set an Adapter on the ViewPager
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
        // pager.setPageTransformer(false, new NicePageTransformer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.trans_1:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View page, float position) {
                        final float normalizedposition = Math.abs(Math.abs(position) - 1);
                        page.setAlpha(normalizedposition);
                    }
                });
                return true;
            case R.id.trans_2:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View page, float position) {
                        final float normalizedposition = Math.abs(Math.abs(position) - 1);
                        page.setScaleX(normalizedposition / 2 + 0.5f);
                        page.setScaleY(normalizedposition / 2 + 0.5f);
                    }
                });
                return true;
            case R.id.trans_3:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View page, float position) {
                        final float normalizedposition = Math.abs(Math.abs(position) - 1);
                        page.setScaleX(normalizedposition / 2 + 0.5f);
                        page.setScaleY(normalizedposition / 2 + 0.5f);
                    }
                });
                return true;
            case R.id.trans_4:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View page, float position) {
                        page.setRotationY(position * -30);
                    }
                });
                return true;
            case R.id.trans_5:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View view, float position) {
                        view.setTranslationX(view.getWidth() * -position);
                        if (position <= -1.0F || position >= 1.0F) {
                            view.setAlpha(0.0F);
                        } else if (position == 0.0F) {
                            view.setAlpha(1.0F);
                        } else {
                            // position is between -1.0F & 0.0F OR 0.0F & 1.0F
                            view.setAlpha(1.0F - Math.abs(position));
                        }

                    }
                });
                return true;
            case R.id.trans_6:
                pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View view, float position) {
                        view.setTranslationX(view.getWidth() * -position);

                        if (position <= -1.0F || position >= 1.0F) {        // [-Infinity,-1) OR (1,+Infinity]
                            view.setAlpha(0.0F);
                            view.setVisibility(View.GONE);
                        } else if( position == 0.0F ) {     // [0]
                            view.setAlpha(1.0F);
                            view.setVisibility(View.VISIBLE);
                        } else {

                            // Position is between [-1,1]
                            view.setAlpha(1.0F - Math.abs(position));
                            view.setTranslationX(-position * (view.getWidth() / 2));
                            view.setVisibility(View.VISIBLE);
                        }

                    }
                });
                return true;
            case R.id.trans_7:
                pager.setPageTransformer(false, new ZoomOutPageTransformer());
                return true;
            case R.id.trans_8:
                pager.setPageTransformer(false, new NicePageTransformer());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
