package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.gson.JsonObject;

import java.util.HashMap;

import in.goodiebag.carouselpicker.CarouselPicker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    CarouselPicker carouselPicker;
    ViewPager viewPager;
    SliderLayout sliderLayout;
    HashMap<String, Integer> Hash_file_maps ;
    TextView textView;

    int images[] = {R.drawable.download1, R.drawable.download2, R.drawable.download3, R.drawable.download4};
    MyCustomPagerAdapter myCustomPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home,container,false);
//        carouselPicker=(CarouselPicker)view.findViewById(R.id.event_carousel);
//        List<CarouselPicker.PickerItem> itemImages= new ArrayList<>();
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.background));
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.background2));
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.background3));
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.download4));
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.download2));
//        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.download3));
//        CarouselPicker.CarouselViewAdapter imageAdapter =new CarouselPicker.CarouselViewAdapter(getActivity(),itemImages,0);
//        carouselPicker.setAdapter(imageAdapter);


        viewPager = (ViewPager)view.findViewById(R.id.viewpager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(getActivity(), images);
        viewPager.setAdapter(myCustomPagerAdapter);

        Hash_file_maps = new HashMap<String, Integer>();

        sliderLayout = (SliderLayout)view.findViewById(R.id.slider);

        Hash_file_maps.put("Image 1",R.drawable.background);
        Hash_file_maps.put("Image 2", R.drawable.background2);
        Hash_file_maps.put("Image 3",R.drawable.background3);
        Hash_file_maps.put("Image 4", R.drawable.download1);
        Hash_file_maps.put("Image 5", R.drawable.download2);

        for(String name : Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);


//        final com.ldealmei.libs.carousel.CarouselPicker carouselPicker1= (com.ldealmei.libs.carousel.CarouselPicker) view.findViewById(R.id.carousel_picker);
//        List<ItemPicker> items = new ArrayList<>();
//        items.add(new ItemPicker(R.drawable.background,"Event 1"));
//        items.add(new ItemPicker(R.drawable.background,"Event 2"));
//        items.add(new ItemPicker(R.drawable.background,"Event 3"));
//        carouselPicker1.addList(items).build(getActivity());


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<JsonObject> call = apiService.getClientCode();
        Log.e("call is",""+call);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject>call, Response<JsonObject> response) {
//                List<Movie> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.size());
                JsonObject object = response.body();
                Log.e("clientCode response","" + object);
                String ClientQuoteText = object.get("message").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("ClientQuoteText").getAsString();
                Log.e("ClientQuoteText",ClientQuoteText);

                textView=(TextView)view.findViewById(R.id.quotes_text);
                textView.setText(ClientQuoteText);
            }

            @Override
            public void onFailure(Call<JsonObject>call, Throwable t) {
                // Log error here since request failed
                Log.e("clientCode error", t.toString());
            }
        });

        Call<JsonObject> call2 = apiService.getLatestEvents();
        Log.e("call is",""+call2);
        call2.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject>call2, Response<JsonObject> response) {
//                List<Movie> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.size());
                JsonObject object1 = response.body();
                Log.e("event response","" + object1);
                int count_event=object1.get("message").getAsJsonObject().get("data").getAsJsonArray().size();
                Log.e("size is",""+count_event);
            }

            @Override
            public void onFailure(Call<JsonObject>call2, Throwable t) {
                // Log error here since request failed
                Log.e("clientCode error", t.toString());
            }
        });

        return view;
    }

    @Override
    public void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
