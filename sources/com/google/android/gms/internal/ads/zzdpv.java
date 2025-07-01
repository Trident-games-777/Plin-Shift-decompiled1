package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdpv implements zzcxh {
    private final zzcfk zza;

    zzdpv(zzcfk zzcfk) {
        this.zza = zzcfk;
    }

    public final void zzdj(Context context) {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.destroy();
        }
    }

    public final void zzdl(Context context) {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.onPause();
        }
    }

    public final void zzdm(Context context) {
        zzcfk zzcfk = this.zza;
        if (zzcfk != null) {
            zzcfk.onResume();
        }
    }
}
