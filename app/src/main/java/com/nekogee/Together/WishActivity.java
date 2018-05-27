package com.nekogee.Together;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;*/

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class WishActivity extends Fragment {
    private static List<Wish> wishList = new ArrayList<>();
    private RecyclerView recyclerView;
  //  public LocationClient mLocationClient;
    private TextView positionText ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wish, container, false);
        FloatingActionButton PresentLoc = (FloatingActionButton) view.findViewById(R.id.wishFab);
        PresentLoc.setOnClickListener(new LocationCheckedListener());
        recyclerView = (RecyclerView) view.findViewById(R.id.wish_view);
        positionText = (TextView)view.findViewById(R.id.addressText) ;
        Log.d("WishActivity" , "iii") ;
        return view;
    }


    class LocationCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), WishEditActivity.class);
            getActivity().startActivity(intent);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("WishActivity", "ppppp");
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        createWish();
        WishAdapter adapter = new WishAdapter(wishList);
        Log.d("WishActivity", "bbbb");
        recyclerView.setAdapter(adapter);
    }
   /*     mLocationClient = new LocationClient(getActivity().getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(this.getActivity(), permissions, 1);
        } else {
            requestLocation();
        }
    }

    private void requestLocation(){
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

    @Override
    public void onRequestPermissionsResult(int requestCode , String[] permissions , int[] grantResults){
            switch (requestCode){
                case 1:
                    if(grantResults.length > 0){
                        for(int result : grantResults) {
                            if (result != PackageManager.PERMISSION_GRANTED) {
                                Toast.makeText(this.getActivity(), "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        requestLocation() ;
                    }else{
                        Toast.makeText(this.getActivity() , "发生未知错误" , Toast.LENGTH_SHORT).show() ;
                    }
                    break ;
                default:
            }
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location){
            getActivity().runOnUiThread(new Runnable(){
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
    private void createWish() {
        Log.d("WishActivity" , "aaaaa") ;
        if(wishList.isEmpty()) {
            for (int i = 0; i < 1; ++i) {
                Wish wish1 = new Wish(R.drawable.user_img4, "Jane", "I am Jane", "我的心愿标题wish1hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", R.drawable.wish_pic1, "我的心愿内容wishDescription1");
                wishList.add(wish1);
                Wish wish2 = new Wish(R.drawable.user_img2, "Bobby", "I am Bobby", "我的心愿标题wish2", R.drawable.wish_pic2, "我的心愿内容wishDescription2hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                wishList.add(wish2);
                Wish wish3 = new Wish(R.drawable.user_img3, "HHHHH", "I am HHHHH", "我的心愿标题wish3", R.drawable.wish_pic3, "我的心愿内容wishDescription3");
                wishList.add(wish3);
            }
        }

        Intent intent = getActivity().getIntent() ;
        int EditImage = intent.getIntExtra("wish_extra_editImage" , -1) ;
        Log.d("WishActivity" , "wwww"+EditImage) ;
        if(EditImage == -1) {
            Log.d("WishActivity" , "uuu"+EditImage) ;
        }
        else{
            String EditTitle = intent.getStringExtra("wish_extra_editTitle");
            String EditDescription = intent.getStringExtra("wish_extra_editDescription");
            String EditExtra = intent.getStringExtra("wish_extra_editExtra");

            Wish wish_add = new Wish(R.drawable.pic2, "Nekogee", "我的个性签名", EditTitle, R.drawable.wish_pic3, EditDescription + "\n\n我的回报：\n" + EditExtra);
            wishList.add(0,wish_add);
            intent.putExtra("wish_extra_editImage" , -1) ;
        }

    }

}
