package com.example.aadpractice.fragment;

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
import com.example.aadpractice.Adapter.SkillAdapter;
import com.example.aadpractice.R;
import com.example.aadpractice.util.IQ;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.aadpractice.util.UrlHelper.TopSkillUrl;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSkill extends Fragment {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private List<IQ> mIqList;
    private SkillAdapter mSkillAdapter;
    private RequestQueue mTopIQRequestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_top_skill, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.topSkillRecycler);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mIqList = new ArrayList<>();

        loadIQdata();
        return view;
    }

    private void loadIQdata() {
        StringRequest topSkillStringRequest = new StringRequest(Request.Method.GET, TopSkillUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray topIQArray = new JSONArray(response);
                    for(int j=0;j<topIQArray.length();j++){
                        JSONObject topIQ = topIQArray.getJSONObject(j);
                        IQ iq = new IQ(topIQ.getString("name"),
                                topIQ.getInt("score"),
                                topIQ.getString("country"),
                                topIQ.getString("badgeUrl"));
                        mIqList.add(iq);
                    }
                    mSkillAdapter = new SkillAdapter(mIqList,getContext());
                    mRecyclerView.setAdapter(mSkillAdapter);

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
        mTopIQRequestQueue = Volley.newRequestQueue(getContext());
        mTopIQRequestQueue.add(topSkillStringRequest);

    }
}
