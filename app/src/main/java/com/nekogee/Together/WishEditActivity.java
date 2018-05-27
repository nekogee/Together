package com.nekogee.Together;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;*/

import java.util.ArrayList;
import java.util.List;

public class WishEditActivity extends AppCompatActivity {

 //   public LocationClient mLocationClient;
    private TextView positionText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_edit);
        Button button = (Button)findViewById(R.id.wish_submit) ;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(WishEditActivity.this , MainActivity.class) ;
                intent.putExtra("editChange" , 1) ;

                EditText et = (EditText)findViewById(R.id.wish_edit_title) ;
                String editTitle = et.getText().toString() ;
                EditText ed = (EditText)findViewById(R.id.wish_edit_description) ;
                String editDescription = ed.getText().toString() ;
                int editImage = R.id.wish_edit_image ;
                EditText ee = (EditText)findViewById(R.id.wish_edit_extra) ;
                String editExtra = ee.getText().toString() ;

                intent.putExtra("wish_extra_editTitle" , editTitle);
                intent.putExtra("wish_extra_editDescription" , editDescription) ;
                intent.putExtra("wish_extra_editImage" , editImage) ;
                intent.putExtra("wish_extra_editExtra" , editExtra) ;
                startActivity(intent) ;
                finish();
            }
        });

        ImageButton addImageButton =(ImageButton)findViewById(R.id.wish_addImage);
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从图库取图
                if (ContextCompat.checkSelfPermission(WishEditActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(WishEditActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else
                    openAlbum();
            }
        });

        positionText = (TextView)findViewById(R.id.wish_edit_addressText) ;
   /*     mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(WishEditActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(WishEditActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(WishEditActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(WishEditActivity.this, permissions, 1);
        } else {
            requestLocation();
        }*/
    }

 /*   private void requestLocation(){
        initLocation() ;
        mLocationClient.start() ;
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption() ;
        option.setScanSpan(5000);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mLocationClient.stop() ;
    }
*/
    @Override
    public void onRequestPermissionsResult(int requestCode , String[] permissions , int[] grantResults){
        switch (requestCode){
            //下面是关于location定位的
        /*    case 1:
                if(grantResults.length > 0){
                    for(int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(WishEditActivity.this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    requestLocation() ;
                }else{
                    Toast.makeText(WishEditActivity.this , "发生未知错误" , Toast.LENGTH_SHORT).show() ;
                }
                break ;*/
            //下面是关于图库取图的
            case 100:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    openAlbum();
                else
                    Toast.makeText(WishEditActivity.this,"you denied the permission",Toast.LENGTH_SHORT).show();
                break ;
            default:
        }
    }

 /*   public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location){
            runOnUiThread(new Runnable(){
                @Override
                public void run(){
                    StringBuilder currentPosition = new StringBuilder() ;
                    currentPosition.append(location.getCity()).append(location.getDirection()) ;
                    positionText.setText(currentPosition) ;
                }
            });
        }
    }
*/
    void openAlbum(){
        Intent intent=new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,10);
    }

    private String getImagePath(Uri uri, String selection) {
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,selection,null,null);
        if(cursor!=null) {
            if(cursor.moveToFirst()) {
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    void displayImage(String imagePath) {
        if(imagePath!=null) {
            Bitmap bitmap= BitmapFactory.decodeFile(imagePath);
            ImageView imageView=(ImageView)findViewById(R.id.wish_edit_image);
            imageView.setImageBitmap(bitmap);
        }
        else
            Toast.makeText(WishEditActivity.this,"failed to get image",Toast.LENGTH_SHORT).show();
    }

    @TargetApi(19)
    void handleIImageOnKitKat(Intent data){
        String imagePath=null;
        Uri uri=data.getData();
        if(DocumentsContract.isDocumentUri(WishEditActivity.this,uri)){
            String docId = DocumentsContract.getDocumentId(uri) ;
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            }else if("com.android.providers.downloads".equals(uri.getAuthority())) {
                Uri contentUri= ContentUris.withAppendedId(Uri.parse("content://downloads/ public_downloads"),Long.valueOf(docId));
                imagePath=getImagePath(contentUri,null);
            }else if("content".equalsIgnoreCase(uri.getScheme())){
                imagePath=getImagePath(uri,null);
            }else if("file".equalsIgnoreCase(uri.getScheme())) {
                imagePath = uri.getPath() ;
            }
            displayImage(imagePath);
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri=data.getData();
        String imagePath=getImagePath(uri,null);
        displayImage(imagePath);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {   case 10:
                if(resultCode==RESULT_OK) {
                    if(Build.VERSION.SDK_INT>=19)
                        handleIImageOnKitKat(data);
                    else
                        handleImageBeforeKitKat(data);
                }
                break ;
            default:
                break ;
        }
    }

}
