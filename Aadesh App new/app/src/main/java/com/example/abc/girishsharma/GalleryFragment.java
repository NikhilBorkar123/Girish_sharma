package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GalleryFragment extends Fragment {
    public static GalleryFragment instance;
    private Photos fragmentOne;
    private Event_Videos fragmentTwo;

    private TabLayout tabLayout;
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_gallery,container,false);
        tabLayout = (TabLayout) view.findViewById( R.id.tabLayout);
            instance=this;

            bindWidgetsWithAnEvent();
            setupTabLayout();
            return view;
        }
        public static GalleryFragment getInstance() {
            return instance;
        }
       // private void getAllWidgets() {
         //   tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        //}
        private void setupTabLayout() {
            fragmentOne = new Photos();
            fragmentTwo = new Event_Videos();
            tabLayout.addTab(tabLayout.newTab().setText("Photos").setIcon( R.drawable.ic_photo_black_24dp ),true);
            tabLayout.addTab(tabLayout.newTab().setText("Videos").setIcon( R.drawable.ic_videocam_black_24dp ));
        }
        private void bindWidgetsWithAnEvent()
        {
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    setCurrentTabFragment(tab.getPosition());
                }
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }
        private void setCurrentTabFragment(int tabPosition)
        {
            switch (tabPosition)
            {
                case 0 :
                    replaceFragment(fragmentOne);
                    break;
                case 1 :
                    replaceFragment(fragmentTwo);
                    break;
            }
        }
        public void replaceFragment(Fragment fragment) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace( R.id.frameLayout, fragment);
            ft.commit();
        }
    }