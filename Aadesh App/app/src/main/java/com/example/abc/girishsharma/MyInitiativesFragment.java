package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abc.girishsharma.Modal.Datum1;
import com.example.abc.girishsharma.Modal.Example3;
import com.example.abc.girishsharma.Modal.Message3;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInitiativesFragment extends Fragment {
    Message3 message;
    List<Datum1> data;
    private RecyclerAdapterInit adapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_initiatives,container,false);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Example3> call4 = apiService.getInitiatives();
        Log.e("call4 is", "" + call4);
        call4.enqueue(new Callback<Example3>() {
            @Override
            public void onResponse(Call<Example3> call4, Response<Example3> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                data = message.getData();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                adapter = new RecyclerAdapterInit(getActivity(), data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Example3> call4, Throwable t) {
                // Log error here since request failed
                Log.e("Initiative error", t.toString());
            }
        });
        recyclerView = view.findViewById(R.id.recycler);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        } );
        return view;
    }
}
