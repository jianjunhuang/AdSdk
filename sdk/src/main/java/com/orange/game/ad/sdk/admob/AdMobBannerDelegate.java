package com.orange.game.ad.sdk.admob;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.orange.game.ad.sdk.common.AdDelegate;

public class AdMobBannerDelegate extends AdDelegate {

  private AdView mAdView;

  @Override
  public void loadAd(Context context, com.orange.game.ad.sdk.common.AdRequest request) {
    mAdView = new AdView(context);
    mAdView.setAdSize(AdSize.BANNER);
    mAdView.setAdUnitId(request.getPid());
    AdRequest.Builder builder = new AdRequest.Builder();
    if (!TextUtils.isEmpty(request.getTestDeviceId())) {
      builder.addTestDevice(request.getTestDeviceId());
    }
    AdRequest adRequest = builder.build();
    mAdView.setAdListener(new AdListener() {
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
    mAdView.loadAd(adRequest);

  }

  @Override
  public void showAd() {

  }

  @Override
  public void showAd(ViewGroup viewGroup) {
    viewGroup.addView(mAdView);
    if (adListener() != null) {
      adListener().onAdShowed();
    }
  }

  @Override
  public void destroyAd() {

  }
}
