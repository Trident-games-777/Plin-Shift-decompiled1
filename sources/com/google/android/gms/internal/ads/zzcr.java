package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcr {
    private CharSequence zza;
    private Bitmap zzb;
    private Layout.Alignment zzc;
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;

    public zzcr() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    /* synthetic */ zzcr(zzct zzct, zzcs zzcs) {
        this.zza = zzct.zza;
        this.zzb = zzct.zzd;
        this.zzc = zzct.zzb;
        this.zzd = zzct.zzc;
        this.zze = zzct.zze;
        this.zzf = zzct.zzf;
        this.zzg = zzct.zzg;
        this.zzh = zzct.zzh;
        this.zzi = zzct.zzi;
        this.zzj = zzct.zzl;
        this.zzk = zzct.zzm;
        this.zzl = zzct.zzj;
        this.zzm = zzct.zzk;
        this.zzn = zzct.zzn;
        this.zzo = zzct.zzo;
    }

    @Pure
    public final int zza() {
        return this.zzg;
    }

    @Pure
    public final int zzb() {
        return this.zzi;
    }

    public final zzcr zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        return this;
    }

    public final zzcr zzd(float f) {
        this.zzm = f;
        return this;
    }

    public final zzcr zze(float f, int i) {
        this.zze = f;
        this.zzf = i;
        return this;
    }

    public final zzcr zzf(int i) {
        this.zzg = i;
        return this;
    }

    public final zzcr zzg(Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzcr zzh(float f) {
        this.zzh = f;
        return this;
    }

    public final zzcr zzi(int i) {
        this.zzi = i;
        return this;
    }

    public final zzcr zzj(float f) {
        this.zzo = f;
        return this;
    }

    public final zzcr zzk(float f) {
        this.zzl = f;
        return this;
    }

    public final zzcr zzl(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzcr zzm(Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzcr zzn(float f, int i) {
        this.zzk = f;
        this.zzj = i;
        return this;
    }

    public final zzcr zzo(int i) {
        this.zzn = i;
        return this;
    }

    public final zzct zzp() {
        return new zzct(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, ViewCompat.MEASURED_STATE_MASK, this.zzn, this.zzo, (zzcs) null);
    }

    @Pure
    public final CharSequence zzq() {
        return this.zza;
    }
}
