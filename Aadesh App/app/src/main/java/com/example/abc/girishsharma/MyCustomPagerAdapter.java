package com.example.abc.girishsharma;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        container.addView(itemView);
        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SamuhikVivah()).commit();
                    Toast.makeText(context, "Event no 1: Samuhik Vivah " , Toast.LENGTH_LONG).show();
                }else if (position==1){
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BhumiPujan()).commit();
                    Toast.makeText(context, "Event no 2: Shram Daan " , Toast.LENGTH_LONG).show();
                }else if (position==2){
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VrukshaRopan()).commit();
                    Toast.makeText(context, "Event no 3: Vruksha Roopan " , Toast.LENGTH_LONG).show();
                }else if (position==3){
                    ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BetiBachao()).commit();
                    Toast.makeText(context, "Event no 4: Beti Bachao" , Toast.LENGTH_LONG).show();
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
