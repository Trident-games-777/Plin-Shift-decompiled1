package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcbu {
    private final Context zza;
    private final zzccf zzb;
    private final ViewGroup zzc;
    private zzcbt zzd;

    public zzcbu(Context context, ViewGroup viewGroup, zzcfk zzcfk) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcfk;
        this.zzd = null;
    }

    public final zzcbt zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcbt zzcbt = this.zzd;
        if (zzcbt != null) {
            return zzcbt.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcbt zzcbt = this.zzd;
        if (zzcbt != null) {
            zzcbt.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcce zzcce) {
        if (this.zzd == null) {
            zzbcu.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
            Context context = this.zza;
            zzccf zzccf = this.zzb;
            zzcbt zzcbt = new zzcbt(context, zzccf, i5, z, zzccf.zzm().zza(), zzcce);
            this.zzd = zzcbt;
            this.zzc.addView(zzcbt, 0, new ViewGroup.LayoutParams(-1, -1));
            this.zzd.zzF(i, i2, i3, i4);
            this.zzb.zzz(false);
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcbt zzcbt = this.zzd;
        if (zzcbt != null) {
            zzcbt.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcbt zzcbt = this.zzd;
        if (zzcbt != null) {
            zzcbt.zzu();
        }
    }

    public final void zzg(int i) {
        zzcbt zzcbt = this.zzd;
        if (zzcbt != null) {
            zzcbt.zzC(i);
        }
    }
}
