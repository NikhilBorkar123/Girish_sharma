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
import com.example.abc.girishsharma.Modal.ApiModelData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventFragment extends Fragment {
    View view;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private List<ApiModel> eventList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event, container, false);
        getData();
        recyclerView = view.findViewById(R.id.recycler);
        return view;
    }

    private void getData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiModelData> call = apiInterface.getDetails();
        call.enqueue(new Callback<ApiModelData>() {
            @Override
            public void onResponse(Call<ApiModelData> call, Response<ApiModelData> response) {

                eventList = response.body().getData();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                adapter = new Adapter(getActivity(), eventList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ApiModelData> call, Throwable t) {
                Log.e("getData", t.toString());
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}