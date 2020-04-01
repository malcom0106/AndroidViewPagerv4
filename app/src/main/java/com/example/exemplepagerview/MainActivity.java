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
    //On declare en Global nos fragment
    MainFragment mainFragment;
    Fragment1 fragment1;
    Fragment2 fragment2;
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


        fragmentManager = getSupportFragmentManager();
        //MainFragment mainFragment = new MainFragment();
        //ReplaceFragment(mainFragment, "mainFragment");

        MyAdapterPager myAdapterPager = new MyAdapterPager(fragmentManager);
        viewPager.setAdapter(myAdapterPager);



    }


    private void ReplaceFragment(Fragment fragment, String Nom){
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction()
                .replace(R.id.vpPages,fragment)
                .addToBackStack(Nom);
        fragmentTransaction.commit();
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
            return 3;
        }
    }
}
