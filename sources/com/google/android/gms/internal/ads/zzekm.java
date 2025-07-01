package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzekm implements zzcxv {
    boolean zza = false;
    final /* synthetic */ zzefe zzb;
    final /* synthetic */ zzcao zzc;

    zzekm(zzekn zzekn, zzefe zzefe, zzcao zzcao) {
        this.zzb = zzefe;
        this.zzc = zzcao;
    }

    private final synchronized void zze(zze zze) {
        int i = 1;
        if (true == ((Boolean) zzbe.zzc().zza(zzbcn.zzft)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzeff(i, zze));
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void zza(int i) {
        try {
            if (!this.zza) {
                this.zza = true;
                zze(new zze(i, zzekn.zze(this.zzb.zza, i), AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void zzb(zze zze) {
        if (!this.zza) {
            this.zza = true;
            zze(zze);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void zzc(int i, String str) {
        try {
            if (!this.zza) {
                this.zza = true;
                if (str == null) {
                    str = zzekn.zze(this.zzb.zza, i);
                }
                zze(new zze(i, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void zzd() {
        this.zzc.zzc((Object) null);
    }
}
