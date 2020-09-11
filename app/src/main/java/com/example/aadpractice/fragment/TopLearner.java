package com.example.aadpractice.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aadpractice.Adapter.HourAdapter;
import com.example.aadpractice.R;
import com.example.aadpractice.util.Hours;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.aadpractice.util.UrlHelper.TopLearnerUrl;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopLearner extends Fragment {

private RecyclerView mRecyclerView;
private HourAdapter adapter;
private RecyclerView.Adapter mAdapter;
private RecyclerView.LayoutManager mLayoutManager;

private List<Hours>mHours;

    private StringRequest mTopLearnerStringRequest;
    private RequestQueue mTopLearnerRequestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_top_learner, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.topLernerRecycler);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mHours = new ArrayList<>();

        loadRecyclerViewData();
        return view;
    }

    private void loadRecyclerViewData() {

        mTopLearnerStringRequest = new StringRequest(Request.Method.GET, TopLearnerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    //since there is no array array name no need to initialize json object here
                    //JSONObject topLearnerJSONObject =  new JSONObject(response);
                    JSONArray topLearnerArray = new JSONArray(response);
                    for(int i=0;i<topLearnerArray.length();i++){
                        JSONObject topLearner = topLearnerArray.getJSONObject(i);
                        Hours hoursItem = new Hours(topLearner.getString("name"),
                                topLearner.getInt("hours"),
                                topLearner.getString("country"),
                                topLearner.getString("badgeUrl"));
                        mHours.add(hoursItem);
                    }
                    adapter = new HourAdapter(mHours,getContext());
                    mRecyclerView.setAdapter(adapter);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        mTopLearnerRequestQueue = Volley.newRequestQueue(getContext());
        mTopLearnerRequestQueue.add(mTopLearnerStringRequest);
    }
}
