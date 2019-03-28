package com.biswatechs.biswadeepampal.toiletsnearme;


import android.app.ProgressDialog;
import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.biswatechs.biswadeepampal.toiletsnearme.prefs.UserInfo;
import com.biswatechs.biswadeepampal.toiletsnearme.prefs.UserSession;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment
{

    private static final String TAG = FragmentLogin.class.getSimpleName();
    Button btnSignup;
    private ProgressDialog progressDialog;
    private UserSession session;
    private UserInfo userInfo;
    LocationManager locationManager;
    EditText username, email, pass, conpass, address, phone;
    String caddress, cphone;
    private Spinner spinner;
    private EditText editText;

    private ArrayList <AvaterSpinnerViewHolder> mAvaterList;
    private AvaterAdapter mAdapter;

    static double clat, clng;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initList();

//        username = getActivity().findViewById(R.id.editTextUsr2);
//        email = getActivity().findViewById(R.id.editTextEmail);
//        pass = getActivity().findViewById(R.id.editTextPass);
//        conpass = getActivity().findViewById(R.id.editTextConfPass);
//        address = getActivity().findViewById(R.id.editTextAddress);
        locationManager = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);
//
        progressDialog = new ProgressDialog(getActivity());
//        session = new UserSession(getActivity());
//        userInfo = new UserInfo(getActivity());


        editText = getActivity().findViewById(R.id.editTextMobileNo);

        spinner = getActivity().findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));



        Spinner spinnerAvater = getActivity().findViewById (R.id.avaterspinner);
        mAdapter = new AvaterAdapter(getActivity(),this.mAvaterList);
        spinnerAvater.setAdapter(mAdapter);
        spinnerAvater.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvaterSpinnerViewHolder clickedItem = (AvaterSpinnerViewHolder) parent.getItemAtPosition(position);
                String clickedAvaterName = clickedItem.getmName();
                Toast.makeText(getActivity(), clickedAvaterName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSignup = getActivity().findViewById(R.id.btnRegister);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String number = editText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }
                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(getActivity(), VerifyPhoneActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }

        });
    }

    private void initList(){
        mAvaterList = new ArrayList<>();
        mAvaterList.add(new AvaterSpinnerViewHolder("Select Avatar",R.drawable.ic_add_a_photo_black_24dp));
        mAvaterList.add(new AvaterSpinnerViewHolder("Avatar 1", R.drawable.avatar_1));
        mAvaterList.add(new AvaterSpinnerViewHolder("Avatar 2", R.drawable.avatar_2));
        mAvaterList.add(new AvaterSpinnerViewHolder("Avatar 3", R.drawable.avatar_3));
        mAvaterList.add(new AvaterSpinnerViewHolder("Avatar 4", R.drawable.avatar_4));
    }


//        btnSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String cuser = username.getText().toString();
//                String cemail = email.getText().toString();
//                String cpass = pass.getText().toString();
//                caddress = address.getText().toString();
//                cphone = phone.getText().toString();
//
////                new GetCoordinates().execute(caddress.replace(" ","+"));
//
////                signup(cuser, cemail, cpass);
//
//            }
//        });
    }

//    private void signup(final String cuser, final String cemail, final String cpass){
//        // Tag used to cancel the request
//        String tag_string_req = "req_signup";
//        progressDialog.setMessage("Signing up...");
//        progressDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.POST,
//                Utils.REGISTER_URL, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, "Register Response: " + response.toString());
//
//                try {
//                    JSONObject jObj = new JSONObject(response);
//                    boolean error = jObj.getBoolean("error");
//
//
//                    // Check for error node in json
//                    if (!error) {
//                        JSONObject user = jObj.getJSONObject("user");
//                        String uName = user.getString("username");
//                        String email = user.getString("email");
//
//                        // Inserting row in users table
//                        //userInfo.setEmail(email);
//                        // userInfo.setUsername(uName);
//                        session.setLoggedin(false);
//
//                        startActivity(new Intent(getActivity(), FragmentLogin.class));
//                        toast("Account created successfully!!");
//                    } else {
//                        // Error in login. Get the error message
//                        String errorMsg = jObj.getString("error_msg");
//                        toast(errorMsg);
//
//                    }
//                } catch (JSONException e) {
//                    // JSON error
//                    e.printStackTrace();
//                    toast("Json error: " + e.getMessage());
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "Login Error: " + error.getMessage());
//                toast("Please check your Internet Connection!");
//            }
//        }) {
//
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting parameters to login url
//                Map<String, String> params = new HashMap<>();
//                params.put("name", cuser);
//                params.put("email", cemail);
//                params.put("password", cpass);
//                params.put("phone", cphone);
//                params.put("address", caddress);
//                params.put("geo_add", clat+","+clng);
//                params.put("lattitude", clat+"");
//                params.put("longitude", clng+"");
//
//                return params;
//            }
//
//        };
//
//        // Adding request to request queue
//        AndroidLoginController.getInstance().addToRequestQueue(strReq, tag_string_req);
//    }
//
//    private void toast(String x){
//        Toast.makeText(getActivity(), x, Toast.LENGTH_LONG).show();
//        progressDialog.dismiss();
//    }
//
//    class GetCoordinates extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            String response;
//            try {
//                String address = strings[0];
//
//                HttpDataHandler http = new HttpDataHandler();
//                String url = String.format("http://maps.googleapis.com/maps/api/geocode/json?address=%s", address);
//                response = http.getHTTPData(url);
//                return response;
//            }catch (Exception ex)
//            {
//
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            try
//            {
//                JSONObject jsonObject = new JSONObject(s);
//
//                String lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat").toString();
//
//                String lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng").toString();
//
//                RegisterFragment.clat = Double.parseDouble(lat);
//                RegisterFragment.clng = Double.parseDouble(lng);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }



