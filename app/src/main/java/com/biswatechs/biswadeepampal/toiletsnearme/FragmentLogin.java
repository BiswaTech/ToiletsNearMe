package com.biswatechs.biswadeepampal.toiletsnearme;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biswatechs.biswadeepampal.toiletsnearme.prefs.UserInfo;
import com.biswatechs.biswadeepampal.toiletsnearme.prefs.UserSession;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {

    private static final String TAG = FragmentLogin.class.getSimpleName();
    String usname = "admin",passw = "admin";
    Button btnLogin, btnSignup;
    private ProgressDialog progressDialog;
    private UserSession session;
    private UserInfo userInfo;
    EditText email, pass;
    SharedPreferences sp;
    TextView tvSkip, tvForgot;
    SharedPreferences.Editor Ed;


    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDialog  = new ProgressDialog(getActivity());
        session         = new UserSession(getActivity());
        userInfo        = new UserInfo(getActivity());

        sp= getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        Ed = sp.edit();

        btnLogin = getActivity().findViewById(R.id.btnLogin);
        btnSignup = getActivity().findViewById(R.id.btnSingup);

        email = getActivity().findViewById(R.id.editTextUsr2);
        pass = getActivity().findViewById(R.id.editTextPass);
        tvSkip = getActivity().findViewById(R.id.textView14);
        tvForgot = getActivity().findViewById(R.id.textView19);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memail = email.getText().toString().trim();
                String mpass  = pass.getText().toString().trim();
//                signin(memail, mpass);
                if(memail.equals(usname) && passw.equals(mpass))
                {
                    Ed.putString("Unm",memail );
                    Ed.putString("Psw",mpass);
                    Intent i = new Intent(getActivity(), HomeActivity.class);
                    startActivity(i);
                    Ed.commit();
                    getActivity().finish();
                }
                else
                {
                    Toast.makeText(getContext(),"Credentials do not match !",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent i = new Intent(getActivity(), MainRoot2.class);
//                startActivity(i);

                RegisterFragment fragment2 = new RegisterFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up,R.animator.slide_in_down,R.animator.slide_out_down);
                fragmentTransaction2.replace(R.id.container_splash,fragment2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();

            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                Toast.makeText(getContext(),"Login Skipped for Now",Toast.LENGTH_SHORT).show();
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotFragment fragment2 = new ForgotFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up,R.animator.slide_in_down,R.animator.slide_out_down);
                fragmentTransaction2.replace(R.id.container_splash,fragment2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });


    }


//    private void signin(final String memail, final String mpass){
//        // Tag used to cancel the request
//        String tag_string_req = "req_login";
//        progressDialog.setMessage("Logging in...");
//        progressDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.POST,
//                Utils.LOGIN_URL, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, "Login Response: " + response.toString());
//
//                try {
//                    JSONObject jObj = new JSONObject(response);
//                    boolean error = jObj.getBoolean("error");
//
//                    // Check for error node in json
//                    if (!error) {
//                        // Now store the user in SQLite
//                        JSONObject user = jObj.getJSONObject("user");
//                        String uName = user.getString("username");
//                        String email = user.getString("email");
//
//                        // Inserting row in users table
//                        userInfo.setEmail(email);
//                        userInfo.setUsername(uName);
//                        session.setLoggedin(true);
//
//                        startActivity(new Intent(getActivity(), MainRoot2.class));
//                        String disusername = userInfo.getKeyUsername();
//                        Toast.makeText(getActivity(), "Welcome "+disusername, Toast.LENGTH_LONG).show();
//                    } else {
//                        // Error in login. Get the error message
//                        String errorMsg = jObj.getString("error_msg");
//                        toast(errorMsg);
//                    }
//                    progressDialog.dismiss();
//                } catch (JSONException e) {
//                    // JSON error
//                    e.printStackTrace();
//                    toast("Json error: " + e.getMessage());
//                }
//
//            }
//        }, new Response.ErrorListener() {
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
//                params.put("email", memail);
//                params.put("password", mpass);
//
//                return params;
//            }
//
//        };
//
//        // Adding request to request queue
//        AndroidLoginController.getInstance().addToRequestQueue(strReq, tag_string_req);
//
//    }

    private void toast(String x){
        Toast.makeText(getActivity(), x, Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }

}
