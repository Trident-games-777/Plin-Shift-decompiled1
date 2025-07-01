package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzdnp implements zza, zzbih, zzr, zzbij, zzac {
    private zza zza;
    private zzbih zzb;
    private zzr zzc;
    private zzbij zzd;
    private zzac zze;

    public final synchronized void onAdClicked() {
        zza zza2 = this.zza;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbih zzbih = this.zzb;
        if (zzbih != null) {
            zzbih.zza(str, bundle);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        zzbij zzbij = this.zzd;
        if (zzbij != null) {
            zzbij.zzb(str, str2);
        }
    }

    public final synchronized void zzdH() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdH();
        }
    }

    public final synchronized void zzdk() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdk();
        }
    }

    public final synchronized void zzdq() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdq();
        }
    }

    public final synchronized void zzdr() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdr();
        }
    }

    public final synchronized void zzdt() {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdt();
        }
    }

    public final synchronized void zzdu(int i) {
        zzr zzr = this.zzc;
        if (zzr != null) {
            zzr.zzdu(i);
        }
    }

    public final synchronized void zzg() {
        zzac zzac = this.zze;
        if (zzac != null) {
            zzac.zzg();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzh(zza zza2, zzbih zzbih, zzr zzr, zzbij zzbij, zzac zzac) {
        this.zza = zza2;
        this.zzb = zzbih;
        this.zzc = zzr;
        this.zzd = zzbij;
        this.zze = zzac;
    }
}
