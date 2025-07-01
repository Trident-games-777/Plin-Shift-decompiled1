package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzw implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ Activity zza;

    public /* synthetic */ zzw(zzx zzx, Activity activity) {
        this.zza = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzx.zzl(this.zza, view, windowInsets);
    }
}
