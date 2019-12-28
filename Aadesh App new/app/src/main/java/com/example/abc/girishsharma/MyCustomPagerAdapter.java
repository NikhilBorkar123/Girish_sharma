package com.example.abc.girishsharma;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCustomPagerAdapter extends PagerAdapter{
    Context context;
    int images[];
    LayoutInflater layoutInflater;


    public MyCustomPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        final View itemView = layoutInflater.inflate(R.layout.item, container, false);

        final ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        container.addView(itemView);
        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Bundle bundle=new Bundle();
                    bundle.putInt("position",0);
                    Fragment samuhik =new SamuhikVivah();
                    samuhik.setArguments(bundle);
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,samuhik).commit();
                }else if (position==1){
                    Bundle bundle=new Bundle();
                    bundle.putInt("position",1);
                    Fragment samuhik =new SamuhikVivah();
                    samuhik.setArguments(bundle);
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,samuhik).commit();
                }else if (position==2){
                    Bundle bundle=new Bundle();
                    bundle.putInt("position",2);
                    Fragment samuhik =new SamuhikVivah();
                    samuhik.setArguments(bundle);
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,samuhik).commit();
                }else if (position==3){
                    Bundle bundle=new Bundle();
                    bundle.putInt("position",3);
                    Fragment samuhik =new SamuhikVivah();
                    samuhik.setArguments(bundle);
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,samuhik).commit();
                }

            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
