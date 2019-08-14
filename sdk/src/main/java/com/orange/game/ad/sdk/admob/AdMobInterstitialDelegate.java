package com.orange.game.ad.sdk.admob;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.orange.game.ad.sdk.common.AdRequest;
import com.orange.game.ad.sdk.common.AdDelegate;

public class AdMobInterstitialDelegate extends AdDelegate {

  private InterstitialAd mInterstitialAd;

  @Override
  public void loadAd(Context context, AdRequest request) {
    mInterstitialAd = new InterstitialAd(context);
    mInterstitialAd.setAdUnitId(request.getPid());
    com.google.android.gms.ads.AdRequest.Builder builder = new com.google.android.gms.ads.AdRequest.Builder();
    if (!TextUtils.isEmpty(request.getTestDeviceId())) {
      builder.addTestDevice(request.getTestDeviceId());
    }
    com.google.android.gms.ads.AdRequest adRequest = builder.build();
    mInterstitialAd.setAdListener(new AdListener() {

      @Override
      public void onAdLoaded() {
        super.onAdLoaded();

        if (adListener() != null) {
          adListener().onAdLoaded();
        }
      }

      @Override
      public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        if (adListener() != null) {
          adListener().onAdError("" + i);
        }
      }

      @Override
      public void onAdOpened() {
        super.onAdOpened();
        if (adListener() != null) {
          adListener().onAdOpened();
        }
      }

      @Override
      public void onAdClosed() {
        super.onAdClosed();
        if (adListener() != null) {
          adListener().onAdClosed();
        }
      }

      @Override
      public void onAdClicked() {
        super.onAdClicked();
        if (adListener() != null) {
          adListener().onAdClicked();
        }
      }

      @Override
      public void onAdImpression() {
        super.onAdImpression();
      }
    });
    mInterstitialAd.loadAd(adRequest);
  }

  @Override
  public void showAd() {
    mInterstitialAd.show();
  }

  @Override
  public void showAd(ViewGroup viewGroup) {

  }

  @Override
  public void destroyAd() {

  }


}
