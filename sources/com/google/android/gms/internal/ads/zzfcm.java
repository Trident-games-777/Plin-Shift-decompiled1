package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfcm implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzfcm(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    /* renamed from: zza */
    public final zzfck zzb() {
        zzbzt zzbzt;
        zzfck zzfck;
        Context context = (Context) this.zza.zzb();
        zzfgy zzfgy = (zzfgy) this.zzb.zzb();
        zzfhq zzfhq = (zzfhq) this.zzc.zzb();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgh)).booleanValue()) {
            zzbzt = zzv.zzp().zzi().zzg();
        } else {
            zzbzt = zzv.zzp().zzi().zzh();
        }
        boolean z = false;
        if (zzbzt != null && zzbzt.zzh()) {
            z = true;
        }
        if (((Integer) zzbe.zzc().zza(zzbcn.zzgx)).intValue() > 0) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzgg)).booleanValue() || z) {
                zzfhp zza2 = zzfhq.zza(zzfhg.AppOpen, context, zzfgy, new zzfbo(new zzfbl()));
                zzfck = new zzfbq(new zzfca(new zzfbz()), new zzfbw(zza2.zza, zzcaj.zza), zza2.zzb, zza2.zza.zza().zzf, zzcaj.zza);
                return zzfck;
            }
        }
        zzfck = new zzfbz();
        return zzfck;
    }
}
