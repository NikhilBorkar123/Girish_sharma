package com.example.abc.girishsharma;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.abc.girishsharma.Modal.ApiModel;
import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Example;
import com.example.abc.girishsharma.Modal.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyIssueFragment extends Fragment {
    View view;
    Message message;
    List<Dataimg> imgData;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private List<ApiModel> eventList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_issues,container,false);
        getData();
        recyclerView = view.findViewById(R.id.recycler);
        return view;
    }
    private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call3 = apiInterface.getimage();
        Log.e("call3 is", "" + call3);
        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call3, Response<Example> response) {
                assert response.body() != null;
                message = response.body().getMessage();
                imgData = message.getDataimg();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                adapter = new Adapter(getActivity(), imgData);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("getData", t.toString());
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
