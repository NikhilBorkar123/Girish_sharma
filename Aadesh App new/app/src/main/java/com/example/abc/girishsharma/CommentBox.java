package com.example.abc.girishsharma;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abc.girishsharma.Modal.Datum2;
import com.example.abc.girishsharma.Modal.Message4;

import java.util.List;


public class CommentBox extends Fragment {
    View view;
    //private String c1,c2,c3;
    //TextInputLayout commentBy, comment, commentDate;
    Button add, clear;

    EditText edittext;


    Message4 message4;
    List<Datum2> datum;
    private RecyclerAC adapter;
    private RecyclerView recyclerViewc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate( R.layout.fragment_comment_box, container, false );
        recyclerViewc = view.findViewById( R.id.recyclerViewcomment);



        clear = (Button)view.findViewById( R.id.clearbutton);
        edittext = (EditText)view.findViewById( R.id.editText2);

        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Clear EditText
                edittext.getText().clear();

            }
        });
    return view;
    }
  /*  private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Comment> call5 = apiInterface.getComment();
        Log.e("call3 is", "" + call5);
        call5.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call5, Response<Comment> response) {
                assert response.body() != null;
                message4 = response.body().getMessage();
                datum = message4.getData();
                recyclerViewc.setHasFixedSize(true);
                recyclerViewc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                adapter = new RecyclerAC(getActivity(), datum);
                recyclerViewc.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Log.e("getData", t.toString());
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
*/

}
