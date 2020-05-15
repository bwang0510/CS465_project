package edu.illinois.cs465.fweestuff;

import android.app.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.illinois.cs465.fweestuff.data.Event;

public class CreateEvent extends AppCompatActivity {

    private Spinner spinner1, spinner2, spinner3;
    private Button button;
    private Button choose, upload, create;
    private ImageView image;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pop);
        create = findViewById(R.id.button);

        addItemsOnSpinners();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        sendDataToEventsPage();
    }

    private void sendDataToEventsPage() {
        EditText eventName = findViewById(R.id.editText);
        EditText eventLocation = findViewById(R.id.editText2);
        EditText eventDate = findViewById(R.id.editText3);
        EditText eventStartTime = findViewById(R.id.editText4);
        EditText eventEndTime = findViewById(R.id.editText5);
        EditText eventDescription = findViewById(R.id.editText6);


        Event event = new Event(eventName.getText().toString(), eventLocation.getText().toString(), eventDate.getText().toString(), eventStartTime.getText().toString(), eventEndTime.getText().toString(),
                "", "", eventDescription.getText().toString(), null);
        ArrayList<Event> myList = new ArrayList<Event>();
        myList.add(event);
        Intent intent = new Intent(CreateEvent.this.getApplication(), EventPage.class);
        intent.putExtra("mylist", myList);
    }


    public void addItemsOnSpinners() {
        //spinner1 = findViewById(R.id.spinner);
        //spinner2 = findViewById(R.id.spinner2);
//        List<String> list = new ArrayList<>();
//        list.add("AM");
//        list.add("PM");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(dataAdapter);
//        spinner2.setAdapter(dataAdapter);

//        spinner3 = findViewById(R.id.spinner3);
//        List<String> orgs = new ArrayList<>();
//        orgs.add("Society of Women Engineers");
//        orgs.add("ASCE");
//        orgs.add("Illini Union");
//        orgs.add("SHPE");
//        orgs.add("ARC");
//        orgs.add("WIE");
//        orgs.add("CS Department");
//        orgs.add("Engineering Department");
//        orgs.add("IPENG");
//        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner3.setAdapter(dataAdapter2);

    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {
//
//        spinner1 = findViewById(R.id.spinner);
//        spinner2 = findViewById(R.id.spinner2);
//        spinner3 = findViewById(R.id.spinner3);
//        button = findViewById(R.id.button);
//
//        button.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(CreateEvent.this,
//                        "OnClickListener : " +
//                                "\nSpinner 1 : "+ spinner1.getSelectedItem() +
//                                "\nSpinner 2 : "+ spinner2.getSelectedItem() +
//                                "\nSpinner 3 : "+ spinner3.getSelectedItem(),
//                        Toast.LENGTH_SHORT).show();
//            }
//
//        });

        //choose = (Button) findViewById(R.id.btnChoose);
        //upload = (Button) findViewById(R.id.btnUpload);
        //image = (ImageView) findViewById(R.id.icon);
        /*choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });*/

        /*upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });*/

        Button next_page = (Button)findViewById(R.id.button);

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateEvent.this, EventPage.class));
            }
        });


    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                image.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(CreateEvent.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(CreateEvent.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }


    public void selectImage(View view) {
    }
}
