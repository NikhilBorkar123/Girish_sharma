package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.abc.girishsharma.Modal.Datum;
import com.example.abc.girishsharma.Modal.Example2;
import com.example.abc.girishsharma.Modal.Message2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyJourneyFragment extends Fragment {

    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_journey, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        frameLayout = view.findViewById(R.id.frameLayout);
        final Fragment[] fragment = new Fragment[1];
        fragment[0] = new PersonalProfile();
        (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment[0]).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.e("tab no:", " " + position);
//                Bundle bundle = new Bundle();
//                bundle.putInt("position", position);
//                Fragment profile_selectorFragment = new Profile_selectorFragment();
//                profile_selectorFragment.setArguments(bundle);
//                (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment, profile_selectorFragment).commit();

                if (position == 0) {
                    fragment[0] = new PersonalProfile();
                    (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment[0]).commit();
                } else if (position == 1) {
                    fragment[0] = new PoliticalProfile();
                    (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment[0]).commit();
                } else {
                    fragment[0] = new SocialFragment();
                    (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment[0]).commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
