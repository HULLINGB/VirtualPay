package com.wallet.brad.virtualpay;



import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
public class Service extends IntentService {
    //stuff for bluetooth
    private static String mmDeviceName;
    private static InputStream mmInputStream;
    private static OutputStream mmOutputStream;
    private static IntentFilter mIntentFilter;
    private static Intent mDiscoverableIntent;
    private static Intent mBroadcastIntent;
    //stuff for returning current IP address
    public static String IPAddress1;
    public static char[] IPAddressArray = new char[13];
    public static String[] IPAddressArrayStrings = new String[13];
    private static int numberOfPairedDevices;
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
    private static String line;
    private static BufferedReader in;
    //stuff for request
    private static String fullName;
    private static String bankName;
    private static String bankIPAddress;
    private static String currencyType;
    private static String transactionAmount;
    private static String currentCountry;
    private static String siteReference;
    private static String accountType;
    private static char[]messageInChar;
    private static double latitude;
    private static double longitude;
    //private GoogleMap mMap;
    //private GoogleApiClient mGoogleApiClient;
    //private Location mLastLocation;
    //LocationRequest mLocationRequest;
    //private LatLng latLng;
    //private Location location;
    private static String response;
    private int[] cardArray = new int[16];
    public int[] cardArray2 = new int[40];
    private char[] IPAddressArray2 = new char[20];
    int exp;
    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    String chosenCard;
    int cvv;
    String mobileCreditCardNumber;
    String mobileIPAddress;
    static String mobileIPAddress2;
    static String mobileIPAddress3 = null;

    boolean isIPv4 = true;
    public static boolean conditionMatch = false;
    //public WifiManager wifiManager;
    //WifiConfigManager wifiConfigManager = new WifiConfigManager();

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

                //OnReceive
                messageInChar = line.toCharArray();
                if (messageInChar != null) {
                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.CARD_NUMBER + " FROM card_user", null);

                    if (c != null) {
                        if (c.moveToFirst()) {
                            do {
                                creditCardNum = c.getString(c.getColumnIndex("cardnumber"));
                            } while (c.moveToNext());
                        }
                        c.close();
                        fullCreditCardNum = creditCardNum;
                    }


                    Log.d("ServerActivity", line);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            currentTimeOfDay = Calendar.getInstance().getTimeInMillis();
                            if (MainActivity.timeOption = true) {
                                //checks if time is between the set times
                                //based on 24hour time clock
                                if (currentTimeOfDay > MainActivity.time1 && currentTimeOfDay < MainActivity.time2) {
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

/**
    
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
**/

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



    private void sendAccountRequestBankingObjectFunction() throws IOException
    {

        //send simple request in xml
        sendRequest();
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




}



















