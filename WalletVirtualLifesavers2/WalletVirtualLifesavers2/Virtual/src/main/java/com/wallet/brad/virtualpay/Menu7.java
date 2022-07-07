package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;


public class Menu7 extends Activity {



    //private LineGraphSeries<DataPoint> series;
    public Button mPay, mPayQR, mPayBarcode, mTakePayment, mShowCards, mBack;
    public String[] transactions = new String[100000];
    public String expiration;
    public String cvv;
    Bitmap bitmap;
    static int choice = 0;

    //WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
    //Display display = manager.getDefaultDisplay();
    Point point = new Point();
    int width = point.x;
    int height = point.y;
    //int smallerDimension = width < height ? width : height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mBack = (Button) findViewById(R.id.backbutton);



        try {
            mPayQR = (Button) findViewById(R.id.payQR);
            //mPayBarcode = (Button) findViewById(R.id.payBarcode);
            mTakePayment = (Button) findViewById(R.id.takepayment);
            mShowCards = (Button) findViewById(R.id.showAllCards);
        }catch(Exception e)
        {

        }

        /**
         final Intent intent = new Intent(Menu.this, Pay.class);
         intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
         intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
         **/
        final Intent intent2 = new Intent(Menu7.this, HowMuchToPay7.class);
        intent2.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent2.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        /**
         final Intent intent3 = new Intent(Menu.this, PayBarcode.class);
         intent3.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
         intent3.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
         **/
        final Intent intent4 = new Intent(Menu7.this,QRScanTakePayment7.class);
        intent4.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent4.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent5 = new Intent(Menu7.this, Cards.class);
        intent5.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent5.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent6 = new Intent(Menu7.this, MainActivity.class);
        intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
/**
 //Doing an nfc payment
 mPay.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {




choice = 1;


startActivity(intent);
//finish();
//return;



}
});

 **/

        mPayQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                choice = 2;

                startActivity(intent2);



            }
        });

        /**
         mPayBarcode.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {




        choice = 3;

        startActivity(intent3);



        }
        });

         **/



        mTakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                choice = 4;

                startActivity(intent4);
                //finish();
                //return;




            }
        });

        mShowCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                choice = 5;


                startActivity(intent5);
                //finish();
                //return;



            }
        });


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                startActivity(intent6);





            }
        });




    }


    @Override
    protected void onResume() {
        super.onResume();
    }







    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.actions, popup.getMenu());
        popup.show();
    }

    //this one might look better
    /**
     public void showMenu(View v) {
     PopupMenu popup = new PopupMenu(this, v);

     // This activity implements OnMenuItemClickListener
     popup.setOnMenuItemClickListener(this);
     popup.inflate(R.menu.actions);
     popup.show();
     }
     **/
/**

 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 switch (item.getItemId()) {
 case R.id.AddNewCard:
 Intent intent2 = new Intent(Menu.this, AddNewCardNumber.class);
 startActivity(intent2);
 return true;
 case R.id.GenerateOnlinePurchaseNumber:
 Intent intent3 = new Intent(Menu.this, GenerateCardNumber.class);
 startActivity(intent3);
 return true;
 case R.id.CheckTransactionHistory:
 Intent intent = new Intent(Menu.this, CheckTransactionHistory.class);
 startActivity(intent);
 return true;
 default:
 return false;
 }
 }
 **/
/**
 private void readFromDatabase()
 {


 SQLiteDatabase db = MainActivity.DBHelper.getReadableDatabase();

 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract3.FeedEntry3.COLUMN_NAME_TITLE,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract3.FeedEntry3.COLUMN_NAME_TITLE + " = ?";
 String[] selectionArgs = { "My Title" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " DESC";

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
 cursor.getColumnIndexOrThrow(FeedReaderContract3.FeedEntry3.COLUMN_NAME_TITLE));
 itemIds.add(itemId);
 }

 for(int i = 0; i < itemIds.size(); i++)
 {

 transactions[i] = itemIds.get(i).toString();

 }









 cursor.close();
 db.close();
 }
 **/
}
