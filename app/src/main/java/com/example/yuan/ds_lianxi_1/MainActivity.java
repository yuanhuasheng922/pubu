package com.example.yuan.ds_lianxi_1;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private int mPage;
    private List<String> list;
    private TextView title;
    private TextView you;
    private TextView yuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner=findViewById(R.id.banner);
        title = findViewById(R.id.title);
        you = findViewById(R.id.you);
        yuan = findViewById(R.id.yuan);
        mPage=1;

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                // UsersBean.DataBean dataBean= (UsersBean.DataBean) path;
                com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path,imageView);

            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });

        loadData();


    }

    String dataUrl="http://www.zhaoapi.cn/product/getProductDetail?pid=%d";

    private void loadData() {
        NetUtil.getInstance().reQuest(String.format(dataUrl,mPage),ImaBean.class, new NetUtil.Callback<ImaBean>() {
            @Override
            public void onSuccess(ImaBean o) {
                list=new ArrayList<>();
                String images = o.getData().getImages();
                sub(images);
                banner.setImages(list);
                banner.start();
            title.setText(o.getData().getTitle());
            yuan.setText("原价为:"+o.getData().getPrice());
            yuan.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            you.setText("优惠为:"+o.getData().getBargainPrice());

            }
        });

    }

    public void sub(String str){
        int i = str.indexOf("|");
        if(i>=0){
            String substring = str.substring(0, i);
            list.add(substring);
            sub(str.substring(i+1,str.length()));
        }else{
            list.add(str);
        }
    }



}
