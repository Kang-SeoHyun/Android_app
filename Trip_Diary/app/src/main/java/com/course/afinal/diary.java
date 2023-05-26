package com.course.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class diary extends AppCompatActivity {

    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;

     EditText editTextTextPersonName3,editTextTextPersonName4,editTextTextPersonName,
             editTextTextMultiLine;
     //ImageView TR_image;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

//         TR_place = (EditText) findViewById(R.id.TR_place);
//        explain = (EditText) findViewById(R.id.editTextTextMultiLine);
//         TR_image = (ImageView) findViewById(R.id.TR_image);
//         TR_latitude = (EditText) findViewById(R.id.TR_latitude);
//         TR_longitude = (EditText) findViewById(R.id.TR_longitude);

        imageview = (ImageView)findViewById(R.id.imageView);
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
    }

    public void addList(View view) {

        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.NAME,((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString ());
        addValues.put(MyContentProvider.EXPLAIN, ((EditText)findViewById(R.id.editTextTextMultiLine)).getText().toString());
        addValues.put(MyContentProvider.LATITUDE, ((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString ());
        addValues.put(MyContentProvider.LONGITUDE, ((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString ());

        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(), "저장됐습니다.", Toast.LENGTH_LONG).show();

        editTextTextPersonName.setText("");
        editTextTextMultiLine.setText("");
        editTextTextPersonName4.setText("");
        editTextTextPersonName3.setText("");

    }

//    public void onButtonClick3 (View v)
//    {
//        Intent intent = new Intent(getApplicationContext(), ShowDiary.class);
//
//        //입력된 데이터 받기
//        String place = TR_place.getText().toString();
//        String diary = TR_diary.getText().toString();
//        String latitude = TR_latitude.getText().toString();
//        String longitude = TR_longitude.getText().toString();
//        int image = TR_image.getImageAlpha();
//
//        intent.putExtra("place", place);
//        intent.putExtra("diary", diary);
//        intent.putExtra("latitude", latitude);
//        intent.putExtra("longitude", longitude);
//        intent.putExtra("image", image);
//
//        startActivity(intent);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }

    }

}