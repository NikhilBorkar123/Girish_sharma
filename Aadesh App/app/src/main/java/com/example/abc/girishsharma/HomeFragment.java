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
import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Message;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    CarouselPicker carouselPicker;
    ViewPager viewPager;
    SliderLayout sliderLayout;
    Message message;
    List<Dataimg> imgData;
    HashMap<String, String> Hash_file_maps;
    List<String> url;
    TextView textView;

    private UserSes userSes;
    String AppUserID;


    int images[] = {R.drawable.download1, R.drawable.download2, R.drawable.download3, R.drawable.download4};
    MyCustomPagerAdapter myCustomPagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
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

        userSes = new UserSes(getContext());


        viewPager = view.findViewById(R.id.viewpager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(getActivity(), images);
        viewPager.setAdapter(myCustomPagerAdapter);

        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call3 = apiService.getimage();
        Log.e("call3 is", "" + call3);
        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call3, Response<Example> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                imgData = message.getDataimg();
                Log.e("image path", String.valueOf(imgData));
                int size=imgData.size();
                if(size>8){
                    size=8;
                }
                for (int i = 0; i < size; i++) {
                    Log.e("Image" + " " + i + "path: is", "http://iamapp.incubatorsdwnmt.com/docs/clientmgallery/" + imgData.get(i).getClientMediaPath());
                    Hash_file_maps.put("Image" + " " + i, "http://iamapp.incubatorsdwnmt.com/docs/clientmgallery/" + imgData.get(i).getClientMediaPath());

                }
                for (String name : Hash_file_maps.keySet()) {

                    TextSliderView textSliderView = new TextSliderView(getContext());
                    textSliderView
                            .description(name)
                            .image(Hash_file_maps.get(name))
                            .setScaleType(BaseSliderView.ScaleType.Fit)
                            .setOnSliderClickListener(HomeFragment.this);
                    textSliderView.bundle(new Bundle());
                    textSliderView.getBundle()
                            .putString("extra", name);
                    sliderLayout.addSlider(textSliderView);
                }
                sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
                sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                sliderLayout.setCustomAnimation(new DescriptionAnimation());
                sliderLayout.setDuration(3000);
                sliderLayout.addOnPageChangeListener(HomeFragment.this);
            }

            @Override
            public void onFailure(Call<Example> call3, Throwable t) {
                // Log error here since request failed
                Log.e("image path error", t.toString());
            }
        });


//        final com.ldealmei.libs.carousel.CarouselPicker carouselPicker1= (com.ldealmei.libs.carousel.CarouselPicker) view.findViewById(R.id.carousel_picker);
//        List<ItemPicker> items = new ArrayList<>();
//        items.add(new ItemPicker(R.drawable.background,"Event 1"));
//        items.add(new ItemPicker(R.drawable.background,"Event 2"));
//        items.add(new ItemPicker(R.drawable.background,"Event 3"));
//        carouselPicker1.addList(items).build(getActivity());


        Call<JsonObject> call = apiService.getClientCode();
        Log.e("call is", "" + call);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject object = response.body();
                Log.e("clientCode response", "" + object);
                String ClientQuoteText = object.get("message").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("ClientQuoteText").getAsString();
                Log.e("ClientQuoteText", ClientQuoteText);

                textView = (TextView) view.findViewById(R.id.quotes_text);
                textView.setText(ClientQuoteText);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                // Log error here since request failed
                Log.e("clientCode error", t.toString());
            }
        });

        Call<JsonObject> call2 = apiService.getLatestEvents();
        Log.e("call is", "" + call2);
        call2.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call2, Response<JsonObject> response) {
                JsonObject object1 = response.body();
                Log.e("event response", "" + object1);
                int count_event = object1.get("message").getAsJsonObject().get("data").getAsJsonArray().size();
                Log.e("size is", "" + count_event);
            }

            @Override
            public void onFailure(Call<JsonObject> call2, Throwable t) {
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
