package com.example.infs3634.plant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import com.google.zxing.Result;



import androidx.appcompat.app.AppCompatActivity;

public class QRScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this);

        setContentView(mScannerView);

        mScannerView.startCamera();
    }

    @Override
    public void onResume() {
        super.onResume();

        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        String scanResult = result.getText();
        Toast.makeText(this, "Scan Result: " + scanResult, Toast.LENGTH_SHORT).show();

        mScannerView.resumeCameraPreview(this);
    }



}