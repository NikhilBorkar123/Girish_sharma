package com.example.abc.girishsharma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SamuhikVivah.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SamuhikVivah#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SamuhikVivah extends Fragment {
    TextView textView1,textView2,textView3;
    ImageView imageView1;
    String title, date, imgpath, description;
    int position;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SamuhikVivah() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BhumiPujan.
     */
    // TODO: Rename and change types and number of parameters
    public static SamuhikVivah newInstance(String param1, String param2) {
        SamuhikVivah fragment = new SamuhikVivah();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            position=getArguments().getInt("position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_samuhik_vivah, container, false);

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        final Call<Example> call4 = apiService.getimage();
        call4.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call4, Response<Example> response) {
                assert response.body() != null;
                Message message = response.body().getMessage();
                List<Dataimg> imgData = message.getDataimg();
                Log.e("image path", String.valueOf(imgData));
                title = imgData.get(position).getClientMediaTitle();
                Log.e("Title", title);
                date = imgData.get(position).getUploadedDate();
                imgpath = "http://iamapp.incubatorsdwnmt.com/docs/clientmgallery/" + imgData.get(position).getClientMediaPath();
                description = imgData.get(position).getLongDescription();
                textView1 = (TextView) view.findViewById(R.id.event1_header);
                textView1.setText(title);
                textView2 = (TextView) view.findViewById(R.id.event1_subheader);
                textView2.setText(date);
                String encodedHtml= Base64.encodeToString(description.getBytes(),Base64.NO_PADDING);
                WebView webView;
                webView = view.findViewById(R.id.eventdesc);
                webView.loadData(encodedHtml,"text/html", "base64");
                imageView1 = (ImageView) view.findViewById(R.id.appCompatImageView);
                Picasso.with(getContext()).load(imgpath).into(imageView1);
            }

            @Override
            public void onFailure(Call<Example> call4, Throwable t) {
                // Log error here since request failed
                Log.e("image path error", t.toString());
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}