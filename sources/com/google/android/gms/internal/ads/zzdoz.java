package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdoz implements zzhfx {
    private final zzhgp zza;

    public zzdoz(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbs.zza.C0000zza zza2;
        zzffo zza3 = ((zzcwd) this.zza).zza();
        zzffo zzffo = zza3;
        if (zza3.zzo.zza == 3) {
            zza2 = zzbbs.zza.C0000zza.REWARDED_INTERSTITIAL;
        } else {
            zza2 = zzbbs.zza.C0000zza.REWARD_BASED_VIDEO_AD;
        }
        zzhgf.zzb(zza2);
        zzbbs.zza.C0000zza zza4 = zza2;
        return zza2;
    }
}
