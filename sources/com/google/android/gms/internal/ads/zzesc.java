package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesc implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzesc(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzt zzfzt;
        zzesz zza2 = ((zzetb) this.zza).zzb();
        zzesz zzesz = zza2;
        Context zza3 = ((zzchq) this.zzb).zza();
        Context context = zza3;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkZ)).booleanValue()) {
            zzv.zzq();
            if (zzs.zzB(zza3)) {
                zzfzt = zzfzt.zzo(zza2);
                zzhgf.zzb(zzfzt);
                return zzfzt;
            }
        }
        zzfzt = zzfzt.zzn();
        zzhgf.zzb(zzfzt);
        return zzfzt;
    }
}
