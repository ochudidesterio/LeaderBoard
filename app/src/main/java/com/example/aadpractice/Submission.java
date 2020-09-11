package com.example.aadpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toolbar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Submission extends AppCompatActivity implements View.OnClickListener {

    private Button mProjectSubmit;
    public static EditText mFirstName;
    public static EditText mLastName;
    public static EditText mEmailAddress;
    public static EditText mGitHub;
    private Button mYes;
    private ImageButton mClose;
    private AlertDialog mErrorDialog;
    private Retrofit mRetrofit;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        mFirstName = (EditText)findViewById(R.id.first_name);
        mLastName = (EditText)findViewById(R.id.last_name);
        mEmailAddress = (EditText)findViewById(R.id.emailAdress);
        mGitHub = (EditText)findViewById(R.id.github);




        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mProjectSubmit = (Button)findViewById(R.id.project_submit);
        mProjectSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.project_submit:
                loadAreYouSureDialog();
                break;
        }
    }

    private void loadAreYouSureDialog() {
        mLayoutInflater = LayoutInflater.from(this);

        View promptView = mLayoutInflater.inflate(R.layout.are_you_sure_dialog,null);
        mAlertDialog = new AlertDialog.Builder(this).create();
        mYes = (Button)promptView.findViewById(R.id.yes);
        mClose = (ImageButton)promptView.findViewById(R.id.close);
        mClose.setOnClickListener(v -> mAlertDialog.dismiss());
        mYes.setOnClickListener(v -> {
            if(mFirstName.getText().toString().matches("") ||
                    mLastName.getText().toString().matches("") ||
                    mEmailAddress.getText().toString().matches("") ||
                    mGitHub.getText().toString().matches("")){
              View  warningPromptView = mLayoutInflater.inflate(R.layout.warning_dialog,null);
              mErrorDialog = new AlertDialog.Builder(Submission.this).create();
              mErrorDialog.setView(warningPromptView);
              mAlertDialog.dismiss();
              mErrorDialog.show();
            }else if(!Patterns.EMAIL_ADDRESS.matcher(mEmailAddress.getText()).matches()){
                mErrorDialog.show();
            }
            else{
                submitToGADS();

            }
        });


        mAlertDialog.setView(promptView);
        mAlertDialog.show();
    }

    public void submitToGADS() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create());
        mRetrofit = builder.build();
        executeSendFeedBackForm(mFirstName.getText().toString(),
                mLastName.getText().toString(),
                mEmailAddress.getText().toString(),
                mGitHub.getText().toString());
    }

    private void executeSendFeedBackForm(String first, String last, String mail, String git) {
        UserClient userClient = mRetrofit.create(UserClient.class);
       Call<ResponseBody>call= userClient.sendUserFeedBack(first, last, mail, git);
       call.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               View successPromptView = mLayoutInflater.inflate(R.layout.success_dialog,null);
               AlertDialog successDialog = new AlertDialog.Builder(Submission.this).create();
               successDialog.setView(successPromptView);
               mAlertDialog.dismiss();
               successDialog.show();
           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {
               View  warningPromptView = mLayoutInflater.inflate(R.layout.warning_dialog,null);
               mErrorDialog = new AlertDialog.Builder(Submission.this).create();
               mErrorDialog.setView(warningPromptView);
               mAlertDialog.dismiss();
               mErrorDialog.show();
           }
       });

    }
}
