package com.readboy.sample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ixiaow.multilayout.MultiLayout;

import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private MultiLayout multiLayout;

    private ViewPager viewPager;
    private Button button;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        multiLayout = findViewById(R.id.multi_layout);
        viewPager = findViewById(R.id.view_page);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiLayout.addBadge(getResources().getDrawable(R.drawable.ic_check_box_celected));
            }
        });
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void init() {
        List<String> strings = Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "");
        TestAdapter testAdapter = new TestAdapter(strings);
        viewPager.setAdapter(testAdapter);
        multiLayout.setupWithViewPager(viewPager);
    }
}
