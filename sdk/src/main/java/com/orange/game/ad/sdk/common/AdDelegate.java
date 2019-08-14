package com.orange.game.ad.sdk.common;

import android.content.Context;
import android.view.ViewGroup;

public abstract class AdDelegate {

  private AdListener mAdListener;

  public void setAdListener(AdListener adListener) {
    this.mAdListener = adListener;
  }

  protected AdListener adListener() {
    return mAdListener;
  }

  public abstract void loadAd(Context context, AdRequest request);

  public abstract void showAd();

  public abstract void showAd(ViewGroup viewGroup);

  public abstract void destroyAd();
}
