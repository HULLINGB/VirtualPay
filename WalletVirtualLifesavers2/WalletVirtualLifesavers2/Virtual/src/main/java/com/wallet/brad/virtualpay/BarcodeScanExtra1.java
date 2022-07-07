package com.wallet.brad.virtualpay;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

import java.io.FileNotFoundException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class BarcodeScanExtra1 extends Activity implements ZXingScannerView.ResultHandler {



    private static final String LOG_TAG = "Barcode Scanner API";
    private static final int PHOTO_REQUEST = 10;
    private TextView scanResults;
    private BarcodeDetector detector;
    private Uri imageUri;
    private static final int REQUEST_WRITE_PERMISSION = 20;
    private static final String SAVED_INSTANCE_URI = "uri";
    private static final String SAVED_INSTANCE_RESULT = "result";
    Button scanBtn;
    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;
    private static int camId = Camera.CameraInfo.CAMERA_FACING_BACK;
    public String resultMessage = "";
    DatabaseOpenHelper4 db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scan2);
        final DatabaseOpenHelper4 myDb;
        myDb = new DatabaseOpenHelper4(this);
        db = myDb;


        scanCode();

    }

    private void scanCode()
    {

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null)
        {
            if(result.getContents() != null)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Scanning Result");
            }
            else{
                Toast.makeText(this, "No results", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void handleResult(Result result) {

        try {

            final String myResult = result.getText();
            Log.d("QRCodeScanner", result.getText().toString());
            Log.d("QRCodeScanner", result.getBarcodeFormat().toString());
            resultMessage = myResult;
            scannerView.resumeCameraPreview(BarcodeScanExtra1.this);

            //scannerView.resumeCameraPreview(QRScan.this);
                    db.insertData2(resultMessage.toString());

                    db.close();

                    Intent intent = new Intent(BarcodeScanExtra1.this, Menu.class);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    startActivity(intent);






            } catch (Exception e) {


        }
    }


}



