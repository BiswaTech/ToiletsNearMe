package com.biswatechs.biswadeepampal.toiletsnearme;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotFragment extends Fragment {

    EditText email, name, otp, pass, confpass;

    TextView tv1,tv2,tv3;

    AlertDialog.Builder builder;

    Button search, sendOtp, submitOtp, submitPass;

    public ForgotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot, container, false);
        
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        email = getActivity().findViewById(R.id.editText);
        name = getActivity().findViewById(R.id.editText7);
        otp = getActivity().findViewById(R.id.editText8);
        pass = getActivity().findViewById(R.id.editText9);
        confpass = getActivity().findViewById(R.id.editText10);
        tv1 = getActivity().findViewById(R.id.textView21);
        tv2 = getActivity().findViewById(R.id.textView26);
        tv3 = getActivity().findViewById(R.id.textView28);

        name.setFocusable(false);

        builder = new AlertDialog.Builder(getContext());

        search = getActivity().findViewById(R.id.button);
        sendOtp = getActivity().findViewById(R.id.button2);
        submitOtp = getActivity().findViewById(R.id.button4);
        submitPass = getActivity().findViewById(R.id.button5);

        otp.setVisibility(View.INVISIBLE);
        pass.setVisibility(View.INVISIBLE);
        confpass.setVisibility(View.INVISIBLE);
        submitOtp.setVisibility(View.INVISIBLE);
        submitPass.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = ProgressDialog.show(getActivity(), "",
                        "Searching. Please wait...", true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.cancel();
                    }
                },1500);
                if(email.getText().toString().equals("arindam@gmail.com"))
                {
                    name.setText("Arindam Paul");
                }
                else
                {
                    Toast.makeText(getContext(),"User not found",Toast.LENGTH_SHORT).show();
                }
            }
        });

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("OTP Sent");
                builder.setMessage("OTP sent to arindam@gmail.com please enter to continue.");
                builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        submitOtp.setVisibility(View.VISIBLE);
                        otp.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.VISIBLE);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        submitOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(otp.getText().toString().equals("1234"))
                {
                    otp.setVisibility(View.INVISIBLE);
                    submitOtp.setVisibility(View.INVISIBLE);
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    pass.setVisibility(View.VISIBLE);
                    confpass.setVisibility(View.VISIBLE);
                    submitPass.setVisibility(View.VISIBLE);
                    builder.setTitle("Please enter new Password");
                    builder.setMessage("Please enter new password to change the old one.");
                    builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else
                {
                    builder.setTitle("OTP Doesn't Match");
                    builder.setMessage("OTP does not match please try again.");
                    builder.setPositiveButton("Try", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            submitOtp.setVisibility(View.VISIBLE);
                            otp.setVisibility(View.VISIBLE);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        submitPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Pasword Set");
                builder.setMessage("New password set, please continue.");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().onBackPressed();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}
