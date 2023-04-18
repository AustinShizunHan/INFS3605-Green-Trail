package com.example.infs3634.plant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import com.google.zxing.Result;
import android.net.Uri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

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

        if (isValidUrl(scanResult)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid URL: " + scanResult, Toast.LENGTH_SHORT).show();
            mScannerView.resumeCameraPreview(this);
        }
    }

    private boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}