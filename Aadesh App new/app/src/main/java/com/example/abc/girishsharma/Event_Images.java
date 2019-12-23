package com.example.abc.girishsharma;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Event_Images.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Event_Images#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Event_Images extends Fragment {
   // int likeCount=0,commentCount;
    TextView mtitle,textView1,textView2,textView3,liketext,commenttext;
    ImageView imageView1;
    String like ;
    String title, date, imgpath, description,comment;
    int position;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Event_Images() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Event_Images.
     */
    // TODO: Rename and change types and number of parameters
    public static Event_Images newInstance(String param1, String param2) {
        Event_Images fragment = new Event_Images();
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
        final View view = inflater.inflate( R.layout.fragment_event__images,
                container, false);

        ImageButton imageButton1,imageButton2;

       // imageButton1 = view.findViewById( R.id.imageButton );
        //imageButton1.setOnClickListener( new View.OnClickListener() {
            //@Override
            //public void onClick(View view){
          //      likeCount = Integer.parseInt( liketext.getText().toString() );
              //  likeCount++;
                //liketext.setText( likeCount );
           // }
        //} );


        imageButton2 = (ImageButton) view.findViewById( R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
           @Override
                  public void onClick(View v) {
                        //commentCount = Integer.parseInt( commenttext.getText().toString() );
                         //commentCount++;
                           // commenttext.setText( commentCount );
            //                    Bundle bundle = new Bundle();

          getFragmentManager().beginTransaction().replace( R.id.fragment_container,new CommentBox()).commit();
        }
        });


        ImageButton bt = (ImageButton) view.findViewById( R.id.imageButton3);
        bt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent( Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = " Dear Voter, your representative Girish Sharma just uploaded a new item in Gallery- " ;
                String link ="http://voterfirst.in/GirishSharma/GirishSharma.php?name=gallery";
                sharingIntent.putExtra( Intent.EXTRA_SUBJECT, "Girish Sharma");
                sharingIntent.putExtra( Intent.EXTRA_TEXT, shareBody + title + ". Go to app - "+link);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }

        });

        final ApiInterface apiInterface = ApiClient.getClient().create( ApiInterface.class);
        final Call<Example> call4 = apiInterface.getGalleryList();
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
               // comment = imgData.get( position ).getCountComment();
                imgpath = "http://iamapp.incubatorsdwnmt.com/docs/clientmgallery/" + imgData.get(position).getClientMediaPath();
                description = imgData.get(position).getLongDescription();

                mtitle =(TextView) view.findViewById( R.id.texttitlem);
                mtitle.setText( title );
                textView1 = (TextView) view.findViewById( R.id.title_text1);
                textView1.setText(title);
                textView2 = (TextView) view.findViewById( R.id.title_date);
                textView2.setText(date);
                //liketext = (TextView) view.findViewById(R.id.liketext);
                //liketext.setText(like);
                //commenttext = (TextView) view.findViewById(R.id.commenttext);
                //commenttext.setText(comment);
                WebView myWebView;
                myWebView =  view.findViewById( R.id.title_desc);
                String encodedHtml= Base64.encodeToString(description.getBytes(),Base64.NO_PADDING);
                myWebView.loadData(encodedHtml,"text/html", "base64");
//                textView3.setText(description);
                imageView1 = (ImageView) view.findViewById( R.id.image1);
                Glide.with(getContext()).load(imgpath).into(imageView1);
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
