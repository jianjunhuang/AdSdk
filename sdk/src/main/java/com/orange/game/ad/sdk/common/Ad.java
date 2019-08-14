package com.orange.game.ad.sdk.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

interface Ad {

  void setAdListener(@NonNull AdListener adListener);

  @Nullable
  AdListener getAdListener();

  void load(@NonNull AdRequest adRequest);

  void show();

  void destroy();

}
