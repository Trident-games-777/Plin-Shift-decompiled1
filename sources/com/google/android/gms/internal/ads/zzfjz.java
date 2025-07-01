package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfjz {
    public static zzfka zza(Context context, int i) {
        boolean z;
        if (zzfko.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        z = ((Boolean) zzbeg.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        z = ((Boolean) zzbeg.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        z = ((Boolean) zzbeg.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                z = ((Boolean) zzbeg.zze.zze()).booleanValue();
            }
            if (z) {
                return new zzfkc(context, i);
            }
        }
        return new zzfle();
    }

    public static zzfka zzb(Context context, int i, int i2, zzm zzm) {
        zzfka zza = zza(context, i);
        if (zza instanceof zzfkc) {
            zza.zzi();
            zza.zzn(i2);
            zza.zzf(zzv.zza(zzm.zzm));
            if (zzfkk.zze(zzm.zzp)) {
                zza.zze(zzm.zzp);
            }
        }
        return zza;
    }
}
