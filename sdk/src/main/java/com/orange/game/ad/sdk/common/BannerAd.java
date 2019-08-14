package com.orange.game.ad.sdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BannerAd extends FrameLayout implements Ad {

  private AdListener mAdListener;

  private AdDelegate mAd;

  public BannerAd(Context context) {
    this(context, null);
  }

  public BannerAd(Context context, AttributeSet attrs) {
    this(context, attrs, -1);
  }

  public BannerAd(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setVisibility(View.GONE);
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
  public void load(@NonNull AdRequest request) {
    if (TextUtils.isEmpty(request.getPid())) {
      if (mAdListener != null) {
        mAdListener.onAdError("pid is empty!");
      }
      return;
    }
    request.setType(AdType.BANNER);
    mAd = AdController.getInstance().getAd(request);
    mAd.setAdListener(mAdListener);
    mAd.loadAd(getContext(), request);
  }

  @Override
  public void show() {
    if (mAdListener != null) {
      mAdListener.onAdShowed();
    }
    removeAllViews();
    mAd.showAd(this);
    setVisibility(View.VISIBLE);
  }

  @Override
  public void destroy() {
    mAd.destroyAd();
  }

}
