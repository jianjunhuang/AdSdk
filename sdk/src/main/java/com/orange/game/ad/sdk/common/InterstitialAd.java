package com.orange.game.ad.sdk.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InterstitialAd implements Ad {

  private AdListener mAdListener;
  private Context mContext;
  private AdDelegate mAd;

  public InterstitialAd(@NonNull Context context) {
    this.mContext = context;
  }

  @Override
  public void setAdListener(@NonNull AdListener adListener) {
    this.mAdListener = adListener;
  }

  @Nullable
  @Override
  public AdListener getAdListener() {
    return mAdListener;
  }

  @Override
  public void load(@NonNull AdRequest adRequest) {
    adRequest.setType(AdType.INTERSTITIAL);
    //mAd is AdProxy ,prevent Ad is null.
    mAd = AdController.getInstance().getAd(adRequest);
    mAd.setAdListener(mAdListener);
    mAd.loadAd(mContext, adRequest);
  }

  @Override
  public void show() {
    mAd.showAd();
  }

  @Override
  public void destroy() {

  }
}
