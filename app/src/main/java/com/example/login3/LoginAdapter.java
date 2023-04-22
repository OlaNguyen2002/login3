package com.example.login3;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class LoginAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;
    private Context context;

    public LoginAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,Context context) {
        super(fragmentManager,lifecycle);
        this.context=context;
    }


//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new login_tab_fragment();
//            case 1:
//                return new Signup_tab_fragment();
//            default:
//                return null;
//
//        }
//
//    }

//    @Override
//    public int getCount() {
//        return 2;
//    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title="";
//        switch (position){
//            case 0:
//                title = "LOGIN";
//                break;
//            case 1:
//                title = "SIGNUP";
//                break;
//        }
//        return title;
//
//    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new login_tab_fragment();
            case 1:
                return new Signup_tab_fragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }


}
