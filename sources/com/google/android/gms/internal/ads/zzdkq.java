package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdkq implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzcfk zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ WindowManager.LayoutParams zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ WindowManager zzf;

    public /* synthetic */ zzdkq(View view, zzcfk zzcfk, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcfk;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        Rect rect = new Rect();
        if (this.zza.getGlobalVisibleRect(rect)) {
            zzcfk zzcfk = this.zzb;
            if (zzcfk.zzF().getWindowToken() != null) {
                int i = this.zze;
                WindowManager.LayoutParams layoutParams = this.zzd;
                String str = this.zzc;
                if (DiskLruCache.VERSION.equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    layoutParams.y = rect.bottom - i;
                } else {
                    layoutParams.y = rect.top - i;
                }
                this.zzf.updateViewLayout(zzcfk.zzF(), layoutParams);
            }
        }
    }
}
