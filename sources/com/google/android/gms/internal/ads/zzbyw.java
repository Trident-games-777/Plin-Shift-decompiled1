package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzbyw {
    static zzbyw zza;

    public static synchronized zzbyw zzd(Context context) {
        synchronized (zzbyw.class) {
            zzbyw zzbyw = zza;
            if (zzbyw != null) {
                return zzbyw;
            }
            Context applicationContext = context.getApplicationContext();
            zzbcn.zza(applicationContext);
            zzg zzi = zzv.zzp().zzi();
            zzi.zzp(applicationContext);
            zzbyo zzbyo = new zzbyo((zzbyq) null);
            zzbyo.zzb(applicationContext);
            zzbyo.zzc(zzv.zzC());
            zzbyo.zza(zzi);
            zzbyo.zzd(zzv.zzo());
            zzbyw zze = zzbyo.zze();
            zza = zze;
            zze.zza().zza();
            zzbza zzc = zza.zzc();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzaB)).booleanValue()) {
                zzv.zzq();
                Map zzv = zzs.zzv((String) zzbe.zzc().zza(zzbcn.zzaC));
                for (String zzc2 : zzv.keySet()) {
                    zzc.zzc(zzc2);
                }
                zzc.zzd(new zzbyy(zzc, zzv));
            }
            zzbyw zzbyw2 = zza;
            return zzbyw2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzbyi zza();

    /* access modifiers changed from: package-private */
    public abstract zzbym zzb();

    /* access modifiers changed from: package-private */
    public abstract zzbza zzc();
}
