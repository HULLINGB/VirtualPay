package com.wallet.brad.virtualpay;
import android.content.ContentValues;
import android.content.Context;
import android.app.Activity;

import android.os.Bundle;
import java.util.ArrayList;
import java.lang.String;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

		static boolean timeOption = false;
			static int time1, time2;
			Button mLogin, mRegistration;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try{
			mLogin = (Button) findViewById(R.id.login);
			mRegistration = (Button) findViewById(R.id.registration);


			/**
			 Welcome Message
			 **/
			Context context = getApplicationContext();
			String text = "Welcome";
			int duration = Toast.LENGTH_LONG;

			/**
			if(firstName != null)
			{
				text = "Welcome" + "  " + firstName;

			}

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			**/
			/**
			 Login

			Context context2 = getApplicationContext();
			String text2 = "Login";
			int duration2 = Toast.LENGTH_LONG;

			Toast toast2 = Toast.makeText(context2, text2, duration2);
			toast2.show();
**/

			final Intent intent = new Intent(getApplicationContext(), Menu.class);
			intent.setAction(Intent.ACTION_SEND);

			final Intent intent2 = new Intent(getApplicationContext(), EnterFirstAndLastName.class);
			intent2.setAction(Intent.ACTION_SEND);
			intent2.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

			//button
			mLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					startActivity(intent);
					//finish();
					//return;

					/**
					 * Starting a background service
					Intent intent = new Intent(this, Service.class);
					startService(intent);
					 **/
				}
			});
			//button
			mRegistration.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(intent2);
					//finish();
					//return;

					/**
					 * Starting a background service
					 Intent intent = new Intent(this, Service.class);
					 startService(intent);
					 **/
				}
			});

		}catch(Exception e)
		{

		}

	}



}
