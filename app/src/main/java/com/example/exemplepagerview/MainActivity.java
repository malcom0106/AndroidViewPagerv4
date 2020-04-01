package com.example.exemplepagerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exemplepagerview.Fragment.Fragment1;
import com.example.exemplepagerview.Fragment.Fragment2;
import com.example.exemplepagerview.Fragment.MainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = null;
    //On declare en Global nos fragments
    MainFragment mainFragment;
    Fragment1 fragment1;
    Fragment2 fragment2;
    //On declare en Global un tableau de Fragments
    ArrayList<Fragment> fragments = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //On instencie nos fragments
        mainFragment = new MainFragment();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        //On instencie le tableau de fragment
        fragments = new ArrayList<>();
        fragments.add(mainFragment);
        fragments.add(fragment1);
        fragments.add(fragment2);

        //On recupere notre ViewPager
        ViewPager viewPager = findViewById(R.id.vpPages);
        //On instancie un FragmentManager
        fragmentManager = getSupportFragmentManager();
        //On Instencie mon MyAdapterPager
        MyAdapterPager myAdapterPager = new MyAdapterPager(fragmentManager);
        //On lie mon pager à notre Adapter
        viewPager.setAdapter(myAdapterPager);
    }

    private class MyAdapterPager extends FragmentPagerAdapter{
        //Constructeur
        public MyAdapterPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
