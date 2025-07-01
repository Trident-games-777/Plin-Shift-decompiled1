package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcfk;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzi {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzi(zzcfk zzcfk) throws zzg {
        this.zzb = zzcfk.getLayoutParams();
        ViewParent parent = zzcfk.getParent();
        this.zzd = zzcfk.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcfk.zzF());
        viewGroup.removeView(zzcfk.zzF());
        zzcfk.zzaq(true);
    }
}
