package com.example.customprogressdialog;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity{
	ImageButton backButton;
	
	private static String URL_COMOPANY_NAMES="http://vagtechnologies.in/ziptryp/company_name.php";
    
    private ProgressDialog pDialog;
   JSONParser jsonParser = new JSONParser();
	private String TAG_SUCCESS ="success";
 // Connection detector class
    ConnectionDetector cd;
 // flag for Internet connection status
    Boolean isInternetPresent = false;
    CustomProgressDialog mProgressDialog;
    EditText name,mo_no,password,comapnyEmail,companyNumber;
    String full_name,mobileNo,pasword,comapny_name,company_email,company_number;
    Button createAccount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
        
		// creating connection detector class instance
        cd = new ConnectionDetector(getApplicationContext());
     // get Internet status
        isInternetPresent = cd.isConnectingToInternet();
     // check for Internet status
        if (isInternetPresent) {
        	
        new LoadCompanyNamesAysc().execute();
   		        			
        } else {
            Toast.makeText(getApplicationContext(), "Internet Connection Required", Toast.LENGTH_LONG).show();
            
        }
		
	
		
	}
	
	
	class LoadCompanyNamesAysc extends AsyncTask<String, String, String> {
		int success;
		
		// Before starting background thread Show Progress Dialog
				@Override
				protected void onPreExecute() {
					super.onPreExecute();	
					mProgressDialog = new CustomProgressDialog(
	                        MainActivity.this, R.drawable.ic_launcher);
	                mProgressDialog.show();

				}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}

		
	}
}
