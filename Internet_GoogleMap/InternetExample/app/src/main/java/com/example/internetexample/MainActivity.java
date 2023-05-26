package com.example.internetexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog myProgressDlg;
    private Bitmap myBitmap = null;
    Button myButton;
    ImageView myImageView;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.button);
        myImageView = (ImageView) findViewById(R.id.imageView);
        myEditText = (EditText) findViewById(R.id.editText);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInternetConnection()) {
                    downloadImage(myEditText.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Internet is not connected.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void downloadImage(String urlStr) {
        myProgressDlg = ProgressDialog.show(this, "", "Downloading Image from " + urlStr);
        final String url = urlStr;

        new Thread() {
            public void run() {
                InputStream in = null;

                Message msg = Message.obtain();
                msg.what = 1;

                try {
                    in = openHttpConnection(url);
                    myBitmap = BitmapFactory.decodeStream(in);

                    if (in != null) {
                        Bundle b = new Bundle();
                        b.putParcelable("bitmap", myBitmap);
                        msg.setData(b);
                    } else {
                        Toast.makeText(getApplicationContext(), "The image is not available at the address you gave.", Toast.LENGTH_LONG).show();
                    }
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                messageHandler.sendMessage(msg);
            }
        }.start();
    }

    private InputStream openHttpConnection(String urlStr) {
        InputStream in = null;
        int resCode = -1;

        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();

            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            myImageView.setImageBitmap((Bitmap)(msg.getData().getParcelable("bitmap")));
            myProgressDlg.dismiss();
        }
    };

    private boolean checkInternetConnection() {
        ConnectivityManager connect = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED || connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING || connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING || connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED || connect.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            return false;
        }
        return false;
    }
}