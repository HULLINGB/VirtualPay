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


	public static FeedReaderDbHelper2 DBHelper2;
	public static DatabaseOpenHelper0 DBHelper3;
    static String creditCardNumber;
			static String expirationDate;
			static String cvv;
			static String creditCardNumber2;
			static String expirationDate2;
			static String cvv2;
			static String creditCardNumber3;
			static String expirationDate3;
			static String cvv3;
			static String creditCardNumber4;
			static String expirationDate4;
			static String cvv4;
			static String creditCardNumber5;
			static String expirationDate5;
			static String cvv5;
			static String creditCardNumber6;
			static String expirationDate6;
			static String cvv6;
			static String creditCardNumber7;
			static String expirationDate7;
			static String cvv7;
			static String creditCardNumber8;
			static String expirationDate8;
			static String cvv8;
			static String creditCardNumber9;
			static String expirationDate9;
			static String cvv9;
			static String creditCardNumber10;
			static String expirationDate10;
			static String cvv10;
			static String creditCardNumber11;
			static String expirationDate11;
			static String cvv11;
			static String creditCardNumber12;
			static String expirationDate12;
			static String cvv12;
			static String country1;
			static String country2;
			static String country3;
			static String country4;
			static String country5;
			static String country6;
			static String country7;
			static String country8;
			static String country9;
			static String country10;
			static String country11;
			static String country12;
			int pin;
			static double accBalance;
			static int bankNumber;
			static long currentTimeOfDay;
			static String firstName;
			static String lastName;
			static String middleInitial;
			static String password;
			static boolean timeOption = false;
			static long time1;
			static long time2;
			boolean amORpm = false;
			boolean amORpm2 = true;
			static String accountNumber;
			static int routingNum;
			ArrayList list;
			final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
			Button mLogin, mRegistration;
			public static String phoneNumber = "";
			public static String fakeCard = "";








	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		try{

			final DatabaseOpenHelper myDb;
			myDb = new DatabaseOpenHelper(getBaseContext());



			mLogin = (Button) findViewById(R.id.login);
			mRegistration = (Button) findViewById(R.id.registration);






			/**
			 Welcome Message
			 **/
			Context context = getApplicationContext();
			String text = "Welcome";
			int duration = Toast.LENGTH_LONG;

			if(firstName != null)
			{
				text = "Welcome" + "  " + firstName;

			}

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();


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




			mLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {




					startActivity(intent);
					//finish();
					//return;



				}
			});

			mRegistration.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {





					startActivity(intent2);
					//finish();
					//return;

				}
			});












		}catch(Exception e)
		{









		}

	}










		/**
		 Enter user routing num
		 **/
		/**
		LayoutInflater inflater6 = getLayoutInflater();
		View layout6 = inflater6.inflate(R.layout.custom_toast,
				(ViewGroup) findViewById(R.id.custom_toast_container));

		TextView text6 = (TextView) layout.findViewById(R.id.text6);
		text6.setText("Please enter your routing number");

		Toast toast6 = new Toast(getApplicationContext());
		toast6.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast6.setDuration(Toast.LENGTH_LONG);
		toast6.setView(layout);
		toast6.show();


		editText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					handled = true;
					Log.v("EditText", mEdit.getText().toString());
					routingNum = Integer.valueOf(mEdit.getText().toString());
					MainActivity.setRouting(routingNum);
				}
				return handled;

			}
		});

		toast6.cancel();


**/


		/**
		 Change time option to "on" or "off"
		 **/

		/**
		String autoDeclineMessage = "Set auto-decline time-frame";
		LayoutInflater inflater8 = getLayoutInflater();
		View layout8 = inflater8.inflate(R.layout.custom_toast,
				(ViewGroup) findViewById(R.id.custom_toast_container));

		TextView text8 = (TextView) layout.findViewById(R.id.text8);
		text8.setText(autoDeclineMessage);

		Toast toast8 = new Toast(getApplicationContext());
		toast8.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast8.setDuration(Toast.LENGTH_LONG);
		toast8.setView(layout);
		toast8.show();


		editText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					handled = true;
					Log.v("EditText", mEdit.getText().toString());
					timeOption = Boolean.valueOf(mEdit.getText().toString());
					MainActivity.setTimeSetting(timeOption);
				}
				return handled;

			}
		});

		toast8.cancel();

		 **/

		/**
		 * Voice authenticator setup
		 *
		 */
/**
		String voiceAuthenticationMessage = "Now let's set up voice authenticator";
		LayoutInflater inflater9 = getLayoutInflater();
		View layout9 = inflater9.inflate(R.layout.custom_toast,
				(ViewGroup) findViewById(R.id.custom_toast_container));

		TextView text9 = (TextView) layout.findViewById(R.id.text9);
		text9.setText(voiceAuthenticationMessage);

		Toast toast9 = new Toast(getApplicationContext());
		toast9.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast9.setDuration(Toast.LENGTH_LONG);
		toast9.setView(layout);
		toast9.show();
		toast9.cancel();

		speakButton = (Button) findViewById(R.id.voiceRecorderButton);
		speakButton.setOnClickListener(this);
		mList = (ListView) findViewById(R.id.list);

		speakButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startVoiceRecognitionActivity();

			}
		});

**/

		/**
		 *
		 * Start Service
		 *
		 */



		/**
		Intent serviceIntent = new Intent(this,LocalService.class);

		startService(serviceIntent);
		 **/








/**
	private BroadcastReceiver  BReceiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			//take over user screen

			//Lock lock = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE).newKeygaurdLock(KEYGUARD_SERVICE);
			PowerManager powerManager = ((PowerManager) getSystemService(Context.POWER_SERVICE));
			PowerManager.WakeLock wake = POWER_SERVICE.(powerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");

			//lock.disableKeygaurd();
			wake.acquire();

			getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
					WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
					WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
					WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
					WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);


			//LocalService.setBluetoothSignalStrength();
			//Utils.getIP();
			//Utils.getMacAddress();




			opticalScannerButton = (Button) findViewById(R.id.opticalAuthenticatorButton);
			opticalScannerButton.setOnClickListener(null);


			opticalScannerButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					dispatchTakePictureIntent();
					try{
						String message = "unable to get image";
						createImageFile();
					}catch(IOException exception){
						exception.printStackTrace();
					}

				}
			});

			Bundle extras = data.contains();
			Bitmap imageBitmap = (Bitmap) extras.get("data");

			//mImageView.setImageBitmap(imageBitmap);
			try {
				FileOutputStream out = new FileOutputStream("opticalAuthenticationFile");
				imageBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
			}catch(IOException e){

			}



			currentTimeOfDay = Calendar.getInstance().getTimeInMillis();

			mHttpGetTask.execute(finalUrl);
			int btSignalStrengthGhz = LocalService.getBluetoothSignalStrength();


			if (timeOption = true) {
				//checks if time is between the set times
				//based on 24hour time clock
				if (currentTimeOfDay >= MainActivity.getTime1() && currentTimeOfDay <= MainActivity.getTime2()) {
					//checks blueTooth distance
					//btSignalStregnthGhz is a variable assigned the value of the distance
					//of a bluetooth device
					if (LocalService.getBluetoothSignalStrength() < btSignalStrengthGhz || LocalService.getBluetoothSignalStrength() > 0) {
						try {
							//we are sending the transaction in HTTPGetTask
							//LocalService.sendAccountRequestBankingObjectFunction();
							//myLabel.setText("Transaction Authorized");
						}catch(IOException e) {
						}
					}
				}
			} if (timeOption != true) {
				try {
					LocalService.declineTransaction();
				}catch(IOException e) {
				}
			} if (currentTimeOfDay < MainActivity.getTime1() && currentTimeOfDay > MainActivity.getTime2()) {
				try {
					LocalService.declineTransaction();
				}catch(IOException e) {
				}
			} if (LocalService.getBluetoothSignalStrength() > btSignalStrengthGhz) {
				try {
					LocalService.declineTransaction();
				}catch(IOException e) {
				}
			}







			//LocalService.declineTransaction();
			//myLabel.setText("Transaction Declined");
		}
	};

	**/










		/**
		 handleMessage();
		 **/






    public static double getTime1()
    {

        return time1;

    }

	public static double getTime2()
	{

		return time2;

	}







	public void readFromDatabase()
	{


		// Gets the data repository in write mode
		//SQLiteDatabase db = DBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();

		//firstName = values.get(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE0).toString();





		//db.close();
	}
}
