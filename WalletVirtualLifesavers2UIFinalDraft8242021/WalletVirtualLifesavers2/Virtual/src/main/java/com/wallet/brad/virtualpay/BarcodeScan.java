package com.wallet.brad.virtualpay;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;

import java.io.FileNotFoundException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class BarcodeScan extends Activity implements ZXingScannerView.ResultHandler {



    private static final String LOG_TAG = "Barcode Scanner API";
    private static final int PHOTO_REQUEST = 10;
    private TextView scanResults;
    private BarcodeDetector detector;
    private Uri imageUri;
    private static final int REQUEST_WRITE_PERMISSION = 20;
    private static final String SAVED_INSTANCE_URI = "uri";
    private static final String SAVED_INSTANCE_RESULT = "result";
    DatabaseOpenHelper4 db = null;
    String resultFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan);

        try {
            Button button = (Button) findViewById(R.id.button);
            scanResults = (TextView) findViewById(R.id.scan_results);
            final DatabaseOpenHelper4 myDb;
            myDb = new DatabaseOpenHelper4(this);
            db = myDb;
            if (savedInstanceState != null) {
                imageUri = Uri.parse(savedInstanceState.getString(SAVED_INSTANCE_URI));
                scanResults.setText(savedInstanceState.getString(SAVED_INSTANCE_RESULT));
            }
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(BarcodeScan.this, new
                            String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
                }
            });
            detector = new BarcodeDetector.Builder(getApplicationContext())
                    .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.CODE_128)
                    .build();
            if (!detector.isOperational()) {
                scanResults.setText("Could not set up the detector!");
                return;
            }
        }catch (Exception e)
        {


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {


                    takePicture();


        }catch (Exception e)
        {

        }

    }

    @Override
    public void handleResult(Result result) {

        try {

            resultFinal = result.getText();
            Log.d("QRCodeScanner", result.getText().toString());
            Log.d("QRCodeScanner", result.getBarcodeFormat().toString());


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Scan Result");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //scannerView.resumeCameraPreview(QRScan.this);




                }

            });
            builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(resultFinal));
                    startActivity(browserIntent);
                }
            });

            try {


                builder.setMessage(result.getText());
                resultFinal = result.getText().toString();
                AlertDialog alert1 = builder.create();
                alert1.show();


                db.insertData2(result.toString());

                db.close();
            } catch (Exception e) {


            }
        } catch (Exception e) {

        }



        Intent intent = new Intent(BarcodeScan.this, Menu.class);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        startActivity(intent);

    }
    private void takePicture() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(BarcodeScan.this);
            integrator.initiateScan();
        }catch(Exception e)
        {

        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        try {


            if (imageUri != null) {
                outState.putString(SAVED_INSTANCE_URI, imageUri.toString());
                outState.putString(SAVED_INSTANCE_RESULT, scanResults.getText().toString());
            }
            super.onSaveInstanceState(outState);
        }catch (Exception e)
        {


        }
    }
    private void launchMediaScanIntent() {

        try {
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            mediaScanIntent.setData(imageUri);
            this.sendBroadcast(mediaScanIntent);
        }catch (Exception e)

        {

        }
    }
    private Bitmap decodeBitmapUri(Context ctx, Uri uri) throws FileNotFoundException {


        int targetW = 600;
        int targetH = 600;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(ctx.getContentResolver().openInputStream(uri), null, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        return BitmapFactory.decodeStream(ctx.getContentResolver()
                .openInputStream(uri), null, bmOptions);
    }
}