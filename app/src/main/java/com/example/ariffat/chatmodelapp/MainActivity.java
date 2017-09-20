package com.example.ariffat.chatmodelapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.util.Util;

import java.io.File;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private static final int IMAGE_GALLERY_REQUEST = 1;
    private static final int IMAGE_CAMERA_REQUEST = 2;
    private static final int PLACE_PICKER_REQUEST = 3;

    static final String TAG = MainActivity.class.getSimpleName();
    static final String CHAT_REFERENCE = "chatmodel";


    //CLass Model
    private UserModel userModel;

    //Views UI
    private RecyclerView rvListMessage;
    private LinearLayoutManager mLinearLayoutManager;
    private ImageView btSendMessage,btEmoji;
    private EmojiconEditText edMessage;
    private View contentRoot;
    private EmojIconActions emojIcon;

    //File
    private File filePathImageCamera;

    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            bindViews();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == IMAGE_GALLERY_REQUEST){
            if (resultCode == RESULT_OK){
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null){
//                    sendFileFirebase(storageRef,selectedImageUri);
                }else{
                    //URI IS NULL
                }
            }
        }else if (requestCode == IMAGE_CAMERA_REQUEST){
            if (resultCode == RESULT_OK){
                if (filePathImageCamera != null && filePathImageCamera.exists()){
//                     sendFileFirebase(imageCameraRef,filePathImageCamera);
                }else{
                    //IS NULL
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sendPhoto:
                verifyStoragePermissions();
//                photoCameraIntent();
                break;
            case R.id.sendPhotoGallery:
//                photoGalleryIntent();
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonMessage:
//                sendMessageFirebase();
                break;
        }
    }





    /**
     * Envia o arvquivo para o firebase
     */
//    private void sendFileFirebase(StorageReference storageReference, final Uri file){
//        if (storageReference != null){
//            final String name = DateFormat.format("yyyy-MM-dd_hhmmss", new Date()).toString();
//            StorageReference imageGalleryRef = storageReference.child(name+"_gallery");
//            UploadTask uploadTask = imageGalleryRef.putFile(file);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.e(TAG,"onFailure sendFileFirebase "+e.getMessage());
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Log.i(TAG,"onSuccess sendFileFirebase");
//                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
//                    FileModel fileModel = new FileModel("img",downloadUrl.toString(),name,"");
//                    ChatModel chatModel = new ChatModel(userModel,"",Calendar.getInstance().getTime().getTime()+"",fileModel);
//                    mFirebaseDatabaseReference.child(CHAT_REFERENCE).push().setValue(chatModel);
//                }
//            });
//        }else{
//            //IS NULL
//        }
//
//    }

    /**
     * Envia o arvquivo para o firebase
     */
//    private void sendFileFirebase(StorageReference storageReference, final File file){
//        if (storageReference != null){
//            Uri photoURI = FileProvider.getUriForFile(MainActivity.this,
//                    BuildConfig.APPLICATION_ID + ".provider",
//                    file);
//            UploadTask uploadTask = storageReference.putFile(photoURI);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.e(TAG,"onFailure sendFileFirebase "+e.getMessage());
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Log.i(TAG,"onSuccess sendFileFirebase");
//                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
//                    FileModel fileModel = new FileModel("img",downloadUrl.toString(),file.getName(),file.length()+"");
//                    ChatModel chatModel = new ChatModel(userModel,"",Calendar.getInstance().getTime().getTime()+"",fileModel);
//                    mFirebaseDatabaseReference.child(CHAT_REFERENCE).push().setValue(chatModel);
//                }
//            });
//        }else{
//            //IS NULL
//        }
//
//    }


    /**
     * Enviar foto tirada pela camera
     */
//    private void photoCameraIntent(){
//        String nomeFoto = DateFormat.format("yyyy-MM-dd_hhmmss", new Date()).toString();
//        filePathImageCamera = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), nomeFoto+"camera.jpg");
//        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        Uri photoURI = FileProvider.getUriForFile(MainActivity.this,
//                BuildConfig.APPLICATION_ID + ".provider",
//                filePathImageCamera);
//        it.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
//        startActivityForResult(it, IMAGE_CAMERA_REQUEST);
//    }
//
//    /**
//     * Enviar foto pela galeria
//     */
//    private void photoGalleryIntent(){
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture_title)), IMAGE_GALLERY_REQUEST);
//    }

    /**
     * Enviar msg de texto simples para chat
     */
//    private void sendMessageFirebase(){
//        ChatModel model = new ChatModel(userModel,edMessage.getText().toString(), Calendar.getInstance().getTime().getTime()+"",null);
//        mFirebaseDatabaseReference.child(CHAT_REFERENCE).push().setValue(model);
//        edMessage.setText(null);
//    }

    /**
     * Ler collections chatmodel Firebase
     */
//    private void lerMessagensFirebase(){
//        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        final ChatFirebaseAdapter firebaseAdapter = new ChatFirebaseAdapter(mFirebaseDatabaseReference.child(CHAT_REFERENCE),userModel.getName(),this);
//        firebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onItemRangeInserted(int positionStart, int itemCount) {
//                super.onItemRangeInserted(positionStart, itemCount);
//                int friendlyMessageCount = firebaseAdapter.getItemCount();
//                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
//                if (lastVisiblePosition == -1 ||
//                        (positionStart >= (friendlyMessageCount - 1) &&
//                                lastVisiblePosition == (positionStart - 1))) {
//                    rvListMessage.scrollToPosition(positionStart);
//                }
//            }
//        });
//        rvListMessage.setLayoutManager(mLinearLayoutManager);
//        rvListMessage.setAdapter(firebaseAdapter);
//    }



    /**
     * Vincular views com Java API
     */
    private void bindViews(){
        contentRoot = findViewById(R.id.contentRoot);
        edMessage = (EmojiconEditText)findViewById(R.id.editTextMessage);
        btSendMessage = (ImageView)findViewById(R.id.buttonMessage);
        btSendMessage.setOnClickListener(this);
        btEmoji = (ImageView)findViewById(R.id.buttonEmoji);
        emojIcon = new EmojIconActions(this,contentRoot,edMessage,btEmoji);
        emojIcon.ShowEmojIcon();
        rvListMessage = (RecyclerView)findViewById(R.id.messageRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
    }



    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     */
    public void verifyStoragePermissions() {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }else{
            // we already have permission, lets go ahead and call camera intent
//            photoCameraIntent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case REQUEST_EXTERNAL_STORAGE:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
//                    photoCameraIntent();
                }
                break;
        }
    }
}