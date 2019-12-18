package com.example.abc.girishsharma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SocialFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_social,container,false);
        view.findViewById(R.id.button_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFB(view);
            }
        });
        view.findViewById(R.id.button_insta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToIG(view);
            }
        });
        return view;
    }
    public void goToFB (View view) {
        goToUrl ( "https://www.facebook.com/aadeshmahule");
    }

    public void goToIG (View view) {
        goToUrl ( "https://in.linkedin.com/in/aadesh-mahule-92473a155");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
