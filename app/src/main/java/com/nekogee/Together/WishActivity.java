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

    private void createWish() {
        Log.d("WishActivity" , "aaaaa") ;
        if(wishList.isEmpty()) {
            for (int i = 0; i < 1; ++i) {
                Wish wish1 = new Wish(R.drawable.user_img4, "Jane", "I am Jane", "找人一起合租！！", R.drawable.wish_pic1, "找人一起合租啦，一个月四千，最好是女生~");
                wishList.add(wish1);
                Wish wish2 = new Wish(R.drawable.user_img2, "Bobby", "I am Bobby", "有人想领养小猫吗", R.drawable.wish_pic2, "捡到一只橘猫，有没有好心人想要领养的？");
                wishList.add(wish2);

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
