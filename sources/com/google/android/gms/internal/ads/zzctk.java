package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzctk implements zzcya, zza, zzczj, zzcxg, zzcwm, zzdbv {
    private final Clock zza;
    private final zzbzs zzb;

    public zzctk(Clock clock, zzbzs zzbzs) {
        this.zza = clock;
        this.zzb = zzbzs;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zza() {
        this.zzb.zze();
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzdn(zzbvx zzbvx) {
    }

    public final void zzdo(zzfff zzfff) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    public final void zzh() {
    }

    public final void zzi(zzbbs.zzb zzb2) {
        this.zzb.zzi();
    }

    public final void zzj(zzbbs.zzb zzb2) {
    }

    public final void zzk(zzm zzm) {
        this.zzb.zzj(zzm);
    }

    public final void zzl(boolean z) {
    }

    public final void zzm(zzbbs.zzb zzb2) {
        this.zzb.zzg();
    }

    public final void zzn(boolean z) {
    }

    public final void zzr() {
        this.zzb.zzf();
    }

    public final void zzs() {
        this.zzb.zzh(true);
    }
}
