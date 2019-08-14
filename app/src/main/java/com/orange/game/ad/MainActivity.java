package com.orange.game.ad;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.orange.game.ad.sdk.common.AdListener;
import com.orange.game.ad.sdk.common.AdRequest;
import com.orange.game.ad.sdk.common.BannerAd;
import com.orange.game.ad.sdk.common.Channel;
import com.orange.game.ad.sdk.common.InterstitialAd;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BannerAd bannerAd = findViewById(R.id.banner);
    bannerAd.load(new AdRequest.Builder().setChannel(Channel.ADMOB)
        .setPid("ca-app-pub-3940256099942544/6300978111")
        .setTestDeviceId("CD02891ED9532C59A20E2C956AACD09C").build());
    bannerAd.show();

    findViewById(R.id.interstitial).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        final InterstitialAd interstitialAd = new InterstitialAd(MainActivity.this);
        interstitialAd.setAdListener(new AdListener() {
          @Override
          public void onAdLoaded() {
            super.onAdLoaded();
            interstitialAd.show();
          }
        });
        interstitialAd.load(new AdRequest.Builder().setChannel(Channel.ADMOB)
            .setPid("ca-app-pub-3940256099942544/1033173712")
            .setTestDeviceId("CD02891ED9532C59A20E2C956AACD09C").build());

      }
    });
  }
}
