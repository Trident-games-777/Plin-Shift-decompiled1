package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzbbs;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrc implements zzczj, zzcya, zzcwp, zzcxg, zza, zzdbv {
    private final zzbbl zza;
    private boolean zzb = false;

    public zzdrc(zzbbl zzbbl, @Nullable zzfco zzfco) {
        this.zza = zzbbl;
        zzbbl.zzc(2);
        if (zzfco != null) {
            zzbbl.zzc(1101);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
            return;
        }
        this.zza.zzc(8);
    }

    public final void zzdB(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzc(101);
                return;
            case 2:
                this.zza.zzc(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(LocationRequestCompat.QUALITY_LOW_POWER);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    public final void zzdn(zzbvx zzbvx) {
    }

    public final void zzdo(zzfff zzfff) {
        this.zza.zzb(new zzdqy(zzfff));
    }

    public final void zzh() {
        this.zza.zzc(1109);
    }

    public final void zzi(zzbbs.zzb zzb2) {
        this.zza.zzb(new zzdrb(zzb2));
        this.zza.zzc(1103);
    }

    public final void zzj(zzbbs.zzb zzb2) {
        this.zza.zzb(new zzdqz(zzb2));
        this.zza.zzc(1102);
    }

    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    public final void zzm(zzbbs.zzb zzb2) {
        this.zza.zzb(new zzdra(zzb2));
        this.zza.zzc(1104);
    }

    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    public final synchronized void zzr() {
        this.zza.zzc(6);
    }

    public final void zzs() {
        this.zza.zzc(3);
    }
}
