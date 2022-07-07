package com.wallet.brad.virtualpay;



import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.text.format.Formatter;
import android.util.Log;
import android.app.IntentService;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import java.lang.String;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;



//date changed: 5/17/2020
public class Service extends IntentService implements Collection {
    private static String mmDeviceName;
    private static InputStream mmInputStream;
    private static OutputStream mmOutputStream;
    private static IntentFilter mIntentFilter;
    private static Intent mDiscoverableIntent;
    private static Intent mBroadcastIntent;
    public static String IPAddress;
    public static String IPAddress1;
    public static String IPAddress2;
    public static char[] IPAddressArray = new char[13];
    public static String[] IPAddressArrayStrings = new String[13];
    private static int[] IP;
    private static int[] IP2;
    private static Object List;
    private boolean timeOption;
    private double time1;
    private double time2;
    private static boolean enableBTle;
    private static boolean mScanning;
    private static Handler mHandler;
    private static final long SCAN_PERIOD = 250;
    private static int numberOfPairedDevices;
    private static String randomNumber;
    private static String finalUrl;
    private static final String Tag = "BluetoothService";
    private static String fullCreditCardNum;
    public static String creditCardNum;
    public static String expiration;
    public static String cVV;
    private static String SERVERIP;
    private static String StoreIP;
    private static String serverStatus;
    private static final int SERVERPORT = 443; //tcp https port
    private Handler handler = new Handler();
    private static Socket client;
    private ServerSocket serverSocket;
    private static long currentTimeOfDay;
    private static String finalMessage;
    private static String line;
    private static BufferedReader in;
    private static String fullName;
    private static String bankName;
    private static String bankIPAddress;
    private static String currencyType;
    private static String transactionAmount;
    private static String currentCountry;
    private static String siteReference;
    private static String accountType;
    private String cardChoice;
    private static char [] bankIp;
    private static char[]messageInChar;
    private static double latitude;
    private static double longitude;
    private static double latitude2;
    private static double longitude2;
    //private GoogleMap mMap;
    //private GoogleApiClient mGoogleApiClient;
    //private Location mLastLocation;
    //LocationRequest mLocationRequest;
    //private LatLng latLng;
    //private Location location;
    private static char[] transaction = new char[10000000];
    public static int length;
    private static int length2;
    private static int x;
    private static String response;
    private int lengthOfStoreIP;
    private double dBm = -90;
    //private static boolean validNumber;
    private int[] cardArray = new int[16];
    public int[] cardArray2 = new int[40];
    private int card;
    private int card2;
    private int card3;
    private int card4;
    private int card5;
    private int card6;
    private int card7;
    private int card8;
    private int card9;
    private int card10;
    private int card11;
    private int card12;
    private int card13;
    private int card14;
    private int card15;
    private int card16;
    public String finalCardString = "";
    private int cardGenerated;
    private int finalCard;
    public String fullCreditCardNumber;
    private char[] IPAddressArray2 = new char[20];
    int exp;

    boolean validNumber;

    long lengthOfCard1 = 1000;
    long lengthOfCard2 = 1000;
    long lengthOfCard3 = 1000;
    long lengthOfCard4 = 1000;
    long lengthOfCard = lengthOfCard1 * lengthOfCard2 * lengthOfCard3 * lengthOfCard4;
    long lengthOfCard6 = 9999;
    long lengthOfCard7 = 9999;
    long lengthOfCard8 = 9999;
    long lengthOfCard9 = 9999;
    long lengthOfCardMax = lengthOfCard6 * lengthOfCard7 * lengthOfCard8 * lengthOfCard9;

    static int lengthOfExp = 0420;
    static int lengthOfCVV = 001;
    static int lengthOfExp2 = 1250;
    static int lengthOfCVV2 = 999;



    int step1;
    int step2;
    int step3;
    int step4;
    int step5;
    int step6;
    int step7;
    int step8;
    int IPChecker;
    //covert to string to we can get length for the loop
    Random number = new Random();
    double s;

    Button mCard;
    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    String chosenCard;
    int cvv;

    String mobileCreditCardNumber;
    String mobileIPAddress;
    static String mobileIPAddress2;
    static String mobileIPAddress3 = null;


    int k;
    int q;

    String text = "";

    boolean isIPv4 = true;

    boolean wifiOrMobile = false;



    public static boolean conditionMatch = false;

    //public WifiManager wifiManager;
    public String ssid;
    //WifiConfigManager wifiConfigManager = new WifiConfigManager();

    DatabaseOpenHelper myDb = null;






    public Service(){

        super(Tag);

    }



    @Override
    public void onCreate() {
       Socket socket = new Socket();

        int w = 0;
        for( ; ; )
        {


            try {

                //important
                try {
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                         en.hasMoreElements();) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress()) {
                                mobileIPAddress = inetAddress.getHostAddress();
                                if(mobileIPAddress.indexOf(':')<0)
                                {
                                    isIPv4 = false;
                                }
                                if(mobileIPAddress.indexOf('%')<0)
                                {

                                    isIPv4 = false;
                                }


                                mobileIPAddress2 = mobileIPAddress;
                                mobileIPAddress = mobileIPAddress.replace(".", "");
                                //mobileIPAddress3 = mobileIPAddress;
                                mobileCreditCardNumber = mobileIPAddress;
                                int IPLength3 = mobileIPAddress.length();
                                int p = IPLength3;
                                if(IPLength3 != 0) {


                                    while (p < 16) {
                                        mobileCreditCardNumber = mobileCreditCardNumber + "0";
                                        p++;

                                    }
                                }
                                IPAddressArray2 = mobileIPAddress.toCharArray();




                                int j = 0;
                                for(int i = 0; i < IPAddressArray2.length; i++)
                                {

                                    cardArray2[i] = IPAddressArray2[i];

                                    j++;
                                }
                                int l = 0;
                                while(l < IPAddressArray2.length)
                                {

                                    cardArray2[l] = 0;
                                    l++;
                                }

                            }
                        }
                    }
                } catch (Exception ex) {
                    Log.e("IP Address", ex.toString());
                }




            }catch(Exception e)
            {


            }

            try {


            } catch (Exception e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        serverStatus = "Connection Interrupted";
                    }
                });
                e.printStackTrace();
            }

            if(line == null) {

                if (!mobileIPAddress.equals(mobileIPAddress3)) {
                    //initializeBlueToothDevice();
                    //initializeBlueToothLowEnergy();
                    //startService(mBluetoothIntent);
                    //getBondedDevices();
                    //registerReceiver(mReceiver, mIntentFilter);
                    if (numberOfPairedDevices == 0) {
                        //initializeBlueToothDiscovery();
                        //startService(mDiscoverableIntent);
                        //LocalService.initializeLogging();


                            //openBlueToothConnection();
                            //stopBlueToothDiscovery();
                            //mmBluetoothSignalStrength = mBluetoothIntent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE);





                    }

                    mobileIPAddress3 = mobileIPAddress;

                    try {
                        //mmOutputStream.write(IPAddress);
                        if(mobileIPAddress2 != null && conditionMatch == true)
                        {
                            String card = mobileCreditCardNumber;
                            String exp2 = Integer.toString(exp);
                            String cvv2 = Integer.toString(cvv);
                            mmOutputStream.write((card + exp2 + cvv).getBytes());

                        }
                        else{
                            mmOutputStream.write(fullCreditCardNum.getBytes());
                        }


                    } catch (Exception e) {

                    }


                    try {
                        //disconnectFromBlueToothDevice();
                        //turnSystemBlueToothOff();
                        //unregisterReceiver(mReceiver);
                    }catch(Exception e){


                    }


                }




            }else{

                mDB = myDb.getReadableDatabase();


                //OnReceive
                messageInChar = line.toCharArray();



                if (messageInChar != null) {


                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper.CARD_NUMBER + " FROM card_user", null);

                    if (c != null) {
                        if (c.moveToFirst()) {
                            do {
                                creditCardNum = c.getString(c.getColumnIndex("cardnumber"));
                            } while (c.moveToNext());
                        }
                        c.close();
                        fullCreditCardNum = creditCardNum;
                    }

                    c = mDB.rawQuery("SELECT " + DatabaseOpenHelper.EXPIRATION + " FROM card_user", null);

                    if (c != null) {
                        if (c.moveToFirst()) {
                            do {
                                expiration = c.getString(c.getColumnIndex("expiration"));

                            } while (c.moveToNext());
                        }
                        c.close();
                        fullCreditCardNum = fullCreditCardNum + expiration;

                    }

                    c = mDB.rawQuery("SELECT " + DatabaseOpenHelper.CVV + " FROM card_user", null);

                    if (c != null) {
                        if (c.moveToFirst()) {
                            do {
                                cVV = c.getString(c.getColumnIndex("cvv"));

                            } while (c.moveToNext());
                        }
                        c.close();
                        fullCreditCardNum = fullCreditCardNum + cVV;

                    }

                    Log.d("ServerActivity", line);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            currentTimeOfDay = Calendar.getInstance().getTimeInMillis();


                            if (MainActivity.timeOption = true) {
                                //checks if time is between the set times
                                //based on 24hour time clock
                                if (currentTimeOfDay > MainActivity.getTime1() && currentTimeOfDay < MainActivity.getTime2()) {
                                    //checks blueTooth distance
                                    //btSignalStregnthGhz is a variable assigned the value of the distance
                                    //of a bluetooth device


                                    try {

                                        JSONObject object = new JSONObject();
                                        int responseLength = object.length();
                                        //we are sending the transaction
                                        //we can also adjust to send a broadcast to MainActivity
                                        sendAccountRequestBankingObjectFunction();


                                        try {
                                            //get the response
                                            //object.getJSONArray(response[responseLength]);
                                            response = object.toString();
                                        } catch (Exception e) {
                                            //no message received
                                        }
                                        sendResponse();


                                        //myLabel.setText("Transaction Authorized");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            } else {
                                try {
                                    declineTransaction();
                                    sendBroadcast();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });

                    line = null;
                    mDB.close();

                }

            }


            w++;
            if(w == 100000)
            {
                //initializeBlueToothDevice();
                //initializeBlueToothLowEnergy();
                //startService(mBluetoothIntent);
                //getBondedDevices();
                //registerReceiver(mReceiver, mIntentFilter);

                if (numberOfPairedDevices == 0) {
                    //initializeBlueToothDiscovery();
                    //startService(mDiscoverableIntent);
                    //LocalService.initializeLogging();


                        //openBlueToothConnection();
                        //stopBlueToothDiscovery();
                        //mmBluetoothSignalStrength = mBluetoothIntent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE);




                }
                try {
                    //disconnectFromBlueToothDevice();
                    //turnSystemBlueToothOff();
                    //unregisterReceiver(mReceiver);
                }catch(Exception e){


                }
                w = 0;
            }



        }











































    }


    
    class ServerThread implements Runnable {

        public void run() {
            try {
                if (SERVERIP != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            serverStatus = "Listening on IP: " + SERVERIP;
                        }
                    });
                    try {
                        serverSocket = new ServerSocket(SERVERPORT);

                        // LISTEN FOR INCOMING CLIENTS
                        client = serverSocket.accept();
                        line = in.readLine();
                    } catch (Exception e) {

                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            serverStatus = "Connected";
                        }
                    });



                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            serverStatus = "Couldn't detect internet connection";
                        }
                    });
                }
            } catch (Exception e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        serverStatus = "Error";
                    }
                });
                e.printStackTrace();
            }

            //Intent intent = new Intent(Service.this, Service.class);
            //startActivity(intent);
        }



    }



















    public static String getMobileIP() {

        return mobileIPAddress3;
        // Don't forget to unregister the ACTION_FOUND receiver.

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.

    }

    @Override
    protected void onHandleIntent( Intent intent) {

    }


    /**
     @Override
     protected void onHandleIntent(Intent intent) {

     BufferedInputStream inputStream = new BufferedInputStream(mmInputStream);
     String infoString = intent.getDataString();
     Intent intent = new Intent ("message"); //put the same message as in the filter you used in the activity when registering the receiver
     intent.putExtra("", 0);
     mBroadcastIntent = intent;


     }

     **/




    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    public boolean getTimeSetting()
    {

        return timeOption;

    }

    public double getTime1()
    {

        return time1;

    }

    public double getTime2()
    {

        return time2;

    }

    public void setRandomNumber(String random){


        randomNumber = random;

    }





















    /**
     public static void beginListenForData()
     {
     final Handler handler = new Handler();
     final byte delimiter = 10; //This is the ASCII code for a newline character

     final boolean stopWorker = false;
     final byte[] readBuffer = new byte[1024];
     String workerThread = new Thread(new Runnable()
     {
     public void run() {
     while (!Thread.currentThread().isInterrupted() && !stopWorker) {
     boolean stopWorker2 = stopWorker;
     try {
     int bytesAvailable = mmInputStream.available();
     if (bytesAvailable > 0) {
     byte[] packetBytes = new byte[bytesAvailable];
     mmInputStream.read(packetBytes);
     for (int i = 0; i < bytesAvailable; i++) {
     byte b = packetBytes[i];
     int readBufferPosition = 0;
     if (b == delimiter) {

     int encodedBytes = readBufferPosition;

     System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes);

     data = new String(encodedBytes, "US-ASCII");


     handler.post(new Runnable() {
     public void run() {
     // myLabel.setText(data);
     }
     });
     } else {

     readBuffer[readBufferPosition++] = b;

     }
     }
     }
     } catch (IOException ex) {

     //stopWorker = true;

     break;
     }
     }
     }
     });



     }

     **/










    private void advertiseCallback()
    {



    }




    private void setSmartPhoneIPAddress() {


        //assuming we are using the wifi method

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        IPAddress1 = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());

        //remove periods
        IPAddress1 = IPAddress1.replace(".", "");
        fullCreditCardNum = IPAddress1;
        int IPLength2 = IPAddress1.length();
        for(int i = IPLength2; i < 16; i++)
        {
            fullCreditCardNum = fullCreditCardNum + "0";

        }
        IPAddressArray = IPAddress1.toCharArray();




        int j = 0;
        for(int i = 0; i < IPAddressArray.length; i++)
        {

            cardArray[i] = IPAddressArray[i];

            j++;
        }

        for(int i = j; i < 16; i++ )
        {

            cardArray[i] = 0;
        }


    }


    public void generateCardNumber() {


        if (IPAddress1 == null) {

            conditionMatch = false;
        }


        int i = 0;
        card = cardArray[i];

        i++;
        card2 = cardArray[i];

        i++;
        card3 = cardArray[i];

        i++;
        card4 = cardArray[i];

        i++;
        card5 = cardArray[i];

        i++;
        card6 = cardArray[i];

        i++;
        card7 = cardArray[i];

        i++;
        card8 = cardArray[i];

        i++;
        card9 = cardArray[i];

        i++;
        card10 = cardArray[i];

        i++;
        card11 = cardArray[i];

        i++;
        card12 = cardArray[i];

        i++;
        card13 = cardArray[i];

        i++;
        card14 = cardArray[i];

        i++;
        card15 = cardArray[i];

        i++;
        card16 = cardArray[i];


        //step 1 checker
        //double each second digit from right to left
        step1check();

        //step 2 checker
        //add all of the digits from step1
        step2check();


        //step 3 checker
        //add all of the odd digits from right to left
        int oddPlaces = card15 + card13 + card11 + card9 + card7 + card5 + card3 + card;


        double sum = IPChecker;
        double sum2 = oddPlaces;

        //step 4 checker
        //add the sums of step 2 checker and step 3 checker
        double finalSum = sum + sum2;

        double divideBy10Remainder = finalSum % 10;




        //Step 5 checker

        if(divideBy10Remainder > 0)
        {
            conditionMatch = true;
        }




    }


    public static void generateExpiration()
    {
        for (int i = 0; i < 4; i++) {


        }
/**
 exp = (int)s;
 if(exp > lengthOfExp || exp < lengthOfExp2)
 {
 generateExpiration();
 }
 **/
    }


    public  void generateCVV()
    {

    }
    /**
     cvv = (int)s;

     if(cvv > lengthOfCVV || cvv < lengthOfCVV2)
     {
     generateCVV();
     }
     **/
    static int concat(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);



        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }

    static int concat2(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);



        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }
    static int concat3(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);
        String s12 = Integer.toString(l);



        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }

    static int concat4(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);
        String s12 = Integer.toString(l);
        String s13 = Integer.toString(m);


        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }

    static int concat5(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);
        String s12 = Integer.toString(l);
        String s13 = Integer.toString(m);
        String s14 = Integer.toString(n);


        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }

    static int concat6(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);
        String s12 = Integer.toString(l);
        String s13 = Integer.toString(m);
        String s14 = Integer.toString(n);
        String s15 = Integer.toString(o);



        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }

    static int concat7(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);
        String s5 = Integer.toString(e);
        String s6 = Integer.toString(f);
        String s7 = Integer.toString(g);
        String s8 = Integer.toString(h);
        String s9 = Integer.toString(i);
        String s10 = Integer.toString(j);
        String s11 = Integer.toString(k);
        String s12 = Integer.toString(l);
        String s13 = Integer.toString(m);
        String s14 = Integer.toString(n);
        String s15 = Integer.toString(o);
        String s16 = Integer.toString(p);



        // Concatenate both strings
        String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16;

        // Convert the concatenated string
        // to integer
        int w = Integer.parseInt(s);

        // return the formed integer
        return w;
    }









    // Return true if the card number is valid
    public static boolean isValid(int number)
    {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
    }

    // Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for number
    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d
    public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }



/**
 private static void randomNumberGenerator(){


 int i;

 for( ; ; ){

 if(mmInputStream.toString().length() > 0){
 break;
 }

 Random number = new Random();
 i = number.nextInt(9);
 randomNumber = randomNumber + Integer.toString(i);

 if(randomNumber.length() > 15){

 try {
 mmOutputStream.write(randomNumber.getBytes());
 randomNumber = " ";

 }catch(IOException e){

 }
 }

 }


 }
 **/

    /**



     public void initializeLogging() {
     // Wraps Android's native log framework.
     LogWrapper logWrapper = new LogWrapper();
     // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
     Log.setLogNode(logWrapper);

     // Filter strips out everything except the message text.
     MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
     logWrapper.setNext(msgFilter);

     // On screen logging via a fragment with a TextView.
     LogFragment logFragment = (LogFragment) getSupportFragmentManager()
     .findFragmentById(R.id.log_fragment);
     msgFilter.setNext(logFragment.getLogView());

     Log.i(TAG, "Ready");
     }

     **/
















    private void sendAccountRequestBankingObjectFunction() throws IOException
    {

        //messageInChar = line.toCharArray();


        //we need to find out what numbers represent what bank
        //bankName;


        bankIp = creditCardNum.toCharArray();

        if(bankIp[0] == 4)
        {
            //Visa
            bankName = "Vis";
        }

        if(bankIp[0] == 2)
        {
            //Mastercard
            bankName = "Mas";
        }

        if(bankIp[0] == 5 && bankIp[1] == 1)
        {
            //Mastercard
            bankName = "Mas";
        }

        if(bankIp[0] == 5 && bankIp[1] == 1)
        {
            //Mastercard
            bankName = "Mas";
        }

        if(bankIp[0] == 5 && bankIp[1] == 5)
        {
            //Mastercard
            bankName = "Mas";
        }

        if(bankIp[0] == 3 && bankIp[1] == 4)
        {
            //American Express
            bankName = "Amx";
        }

        if(bankIp[0] == 6 && bankIp[1] == 5)
        {
            //Discover
            bankName = "Dis";
        }

        if(bankIp[0] == 6 && bankIp[1] == 2)
        {
            //Union Pay China
            bankName = "Unp";
        }

        if(bankIp[0] == 6 && bankIp[1] == 5)
        {
            //Union Pay China
            bankName = "Unp";
        }

        if(bankIp[0] == 3 && bankIp[1] == 0)
        {
            //Diner's club carte Blanche
            bankName = "Unp";
        }

        if(bankIp[0] == 3 && bankIp[1] == 6)
        {
            //Diner's club international
            bankName = "Unp";
        }

        if(bankIp[0] == 3 && bankIp[1] == 5)
        {
            //JCB
            bankName = "Jcb";
        }

        if(bankIp[0] == 3 && bankIp[1] == 4)
        {
            //AMEX
            bankName = "Amx";
        }

        if(bankIp[0] == 3 && bankIp[1] == 7)
        {
            //AMEX
            bankName = "Amx";
        }

        if(bankIp[0] == 5 && bankIp[1] == 5)
        {
            //Diner's club north america
            bankName = "Unp";
        }

        if(bankIp[0] == 5 && bankIp[1] == 0)
        {
            //Maestro
            bankName = "Mae";
        }

        if(bankIp[0] == 6 && bankIp[1] == 7)
        {
            //Maestro
            bankName = "Mae";
        }

        if(bankIp[0] == 6 && bankIp[1] == 3)
        {
            //InstaPayment
            bankName = "Ins";
        }


        //assuming the request uses just the IPAddress and
        //not the full card num. This can be adjusted to creditCardNumbe
        bankIPAddress = "";
        for(int i = 0; i < 6; i++)
        {


            bankIPAddress = bankIPAddress + bankIp[i];

        }


        //getCurrentLocation();
        //calculates country and currency, 5 digits


        //elimates the 0s all the way up to the first value
        //to remove the extra zeros in the front
        int q = 0;
        for(int x = 0; x < messageInChar.length; x++)
        {
            if(messageInChar[x] != 0)
            {
                break;
            }

            q++;

        }


        //eliminates the 0s all the way up to the first value
        for(x = 0 + q; x < messageInChar.length; x++)
        {


            transactionAmount = transactionAmount + messageInChar[x];
            transaction[x] = messageInChar[x];



        }







        //comes from the merchant
        //siteReference;


        accountType = "ECOM";


        //send simple request in xml
        sendRequest();
        updateTransactionHistory();

    }


    private static void sendRequest()
    {


        try {


            //String myXML = "<? xml version=1.0> <Request> <Elemtnt> <data id=\"1\">E1203</data> <data id=\"2\">E1204</data> </Element> </Request>";

            String myXML = "<?xml version='1.0' encoding='utf-8'?> <requestblock version=\"3.67\"> <alias>SECURETRADING</alias> <request type=AUTH> <billing> <payment type=\"IDEAL\"> <bankname> " + bankName + " </bankname> <ban>" + bankIPAddress + "</ban> </payment> <country>" + currentCountry + "</country> <amount currencycode=\" " + currencyType + " \"> " + transactionAmount + "</amount> </billing> <operation> <sitereference>" + siteReference + "</sitereference> <accounttypedescription>" + accountType + "</accounttypedescription></operation> </request> </requestblock>";
            //String myXML = "<?xml version='1.0' encoding='utf-8'?> <requestblock version=\"3.67\"> <alias>SECURETRADING</alias> <request type=AUTH> <billing> <payment type=\"IDEAL\"> <bankname> " + bankName + " </bankname> <ban>" + creditCardNum + expiration + cVV + "</ban> </payment> <country>" + currentCountry + "</country> <amount currencycode=\" " + currencyType + " \"> " + transactionAmount + "</amount> </billing> <operation> <sitereference>" + siteReference + "</sitereference> <accounttypedescription>" + accountType + "</accounttypedescription></operation> </request> </requestblock>";
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(bankIPAddress);


            List<NameValuePair> dataToPost = new ArrayList<NameValuePair>();

            dataToPost.add(new BasicNameValuePair("yourxml", myXML));

            httpPost.setEntity(new UrlEncodedFormEntity(dataToPost));

            httpClient.execute(httpPost, localContext);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void readFromDatabase()
    {


    }

/**
 public static void readFromDatabase2()
 {


 //SQLiteDatabase db = DBHelper.getReadableDatabase();


 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5 + " = ?";
 String[] selectionArgs = { "cardnumber" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry._ID + " DESC";

 Cursor cursor = db.query(
 FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
 null,             // The array of columns to return (pass null to get all)
 selection,              // The columns for the WHERE clause
 selectionArgs,          // The values for the WHERE clause
 null,                   // don't group the rows
 null,                   // don't filter by row groups
 sortOrder               // The sort order
 );

 List itemIds = new ArrayList<>();
 while(cursor.moveToNext()) {
 long itemId = cursor.getLong(
 cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5));
 itemIds.add(itemId);
 }

 creditCardNum = itemIds.get(0).toString();





 cursor.close();
 db.close();
 }
 **/
/**
 public static void readFromDatabase3()
 {


 SQLiteDatabase db = DBHelper.getReadableDatabase();


 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6 + " = ?";
 String[] selectionArgs = { "expirationdate" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry._ID + " DESC";

 Cursor cursor = db.query(
 FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
 null,             // The array of columns to return (pass null to get all)
 selection,              // The columns for the WHERE clause
 selectionArgs,          // The values for the WHERE clause
 null,                   // don't group the rows
 null,                   // don't filter by row groups
 sortOrder               // The sort order
 );

 List itemIds = new ArrayList<>();
 while(cursor.moveToNext()) {
 long itemId = cursor.getLong(
 cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6));
 itemIds.add(itemId);
 }


 expiration = itemIds.get(0).toString();





 cursor.close();
 db.close();
 }
 **/
    /**
     private static void readFromDatabase4()
     {


     SQLiteDatabase db = DBHelper.getReadableDatabase();


     // Define a projection that specifies which columns from the database
     // you will actually use after this query.
     String[] projection = {
     BaseColumns._ID,
     FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7,

     };

     // Filter results WHERE "title" = 'My Title'
     String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7 + " = ?";
     String[] selectionArgs = { "cvv" };

     // How you want the results sorted in the resulting Cursor
     String sortOrder =
     FeedReaderContract.FeedEntry._ID + " DESC";

     Cursor cursor = db.query(
     FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
     projection,             // The array of columns to return (pass null to get all)
     selection,              // The columns for the WHERE clause
     selectionArgs,          // The values for the WHERE clause
     null,                   // don't group the rows
     null,                   // don't filter by row groups
     sortOrder               // The sort order
     );

     List itemIds = new ArrayList<>();
     while(cursor.moveToNext()) {
     long itemId = cursor.getLong(
     cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7));

     itemIds.add(itemId);
     }


     cVV = itemIds.get(0).toString();




     cursor.close();
     db.close();
     }
     **/
    private void sendBroadcast()
    {
        mBroadcastIntent = new Intent("message");
        mBroadcastIntent.putExtra("", 0);
        LocalBroadcastManager.getInstance(this).sendBroadcast(mBroadcastIntent);
    }

    private static void declineTransaction() throws IOException
    {


    }

    private static void sendResponse()
    {

        try {

            //String myXML = "<? xml version=1.0> <Request> <Elemtnt> <data id=\"1\">E1203</data> <data id=\"2\">E1204</data> </Element> </Request>";

            String myResponse = response;
            //This may need to be changed to a URL
            String StoreIP2 = InetAddress.getByName(StoreIP).toString();
            StoreIP = client.getInetAddress().toString();



            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(StoreIP);

            List<NameValuePair> dataToPost = new ArrayList<NameValuePair>();

            dataToPost.add(new BasicNameValuePair("yourResponse", myResponse));


            httpPost.setEntity(new UrlEncodedFormEntity(dataToPost));

            httpClient.execute(httpPost, localContext);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




/**
     private void getCurrentLocation()
     {
     latLng = new LatLng(latitude, longitude);
     location = new Location("");

     location.setLatitude(latLng.latitude);
     location.setLongitude(latLng.longitude);

     latitude = location.getLatitude();
     longitude = location.getLongitude();
     if(latitude < 54 && latitude > 25)
     {
     if(longitude < -155 && longitude > -120)
     {
     //Alaska
     currentCountry = "US";
     currencyType = "DOL";
     }
     }

     if(latitude < 55 && latitude > 33)
     {
     if(longitude < -65 && longitude > -125)
     {   //United States
     currentCountry = "US";
     currencyType = "DOL";
     }
     }

     if(latitude > 10 && latitude < 86)
     {
     if(longitude < -50 && longitude > -140)
     {   //Canada
     currentCountry = "CA";
     currencyType = "CAD";
     }
     }

     if(latitude < 58 && latitude < 60)
     {
     if (longitude < 82 && longitude > 9)
     {
     if(latitude > -53 && latitude < 23.5)
     //Argentina
     currentCountry = "AR";
     currencyType = "ARS";

     }
     }

     if(latitude < 12 && latitude > -15)
     {
     if(longitude < -35 && longitude > -75)
     {   //Brazil
     currentCountry = "US";
     currencyType = "DOL";
     }
     }

     if(latitude > 0 && latitude < 30)
     {
     if(longitude < 70 && longitude > 5)
     {   //Europe
     currentCountry = "Eu";
     currencyType = "Eur";
     }
     }

     if(latitude > 10 && latitude < 30)
     {
     if(longitude < 58 && longitude > 72)
     {   //Russia
     currentCountry = "Ru";
     currencyType = "Rub";
     }

     }
     if(latitude > 10 && latitude < 30)
     {
     if(longitude < 60 && longitude > 28)
     {   //China
     currentCountry = "Ch";
     currencyType = "Yua";
     }
     }

     if(latitude > 10 && latitude < 30)
     {
     if(longitude < 70 && longitude > 5)
     {   //Australia
     currentCountry = "Au";
     currencyType = "Aud";
     }
     }

     if(latitude > 10 && latitude < 30)
     {
     if(longitude < 70 && longitude > 5)
     {   //Australia
     currentCountry = "Au";
     currencyType = "Aud";
     }
     }

     if(latitude < 33 && latitude > 15)
     {
     if(longitude < 120 && longitude > 86)
     {   //Mexico
     currentCountry = "Me";
     currencyType = "Pes";
     }

     }

     }
     **/
    private void turnOffLocation()
    {

        latitude = 0;
        longitude = 0;

    }



    private void updateTransactionHistory()
    {



        // Gets the data repository in write mode
        //SQLiteDatabase db = MainActivity.DBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        //readFromDatabase2();
        length2 = length2 + 1;







        values.put(FeedReaderContract2.FeedEntry2.COLUMN_NAME_TITLE1, length2);
        values.put(FeedReaderContract2.FeedEntry2.COLUMN_NAME_TITLE2, transactionAmount);




        //db.insert(FeedReaderContract2.FeedEntry2.TABLE_NAME, null, values);



// Insert the new row, returning the primary key value of the new row

        //db.close();

    }



    public void step1check()  {

        step1 = card2 * 2;



        step2 = card4 * 2;

        step3 = card6 * 2;

        step4 = card8 * 2;

        step5 = card10 * 2;

        step6 = card12 * 2;

        step7 = card14 * 2;

        step8 = card16 * 2;





    }


    public void step2check() {

        IPChecker = step1 + step2 + step3 + step4 + step5 + step6 + step7 + step8;
    }





}



















