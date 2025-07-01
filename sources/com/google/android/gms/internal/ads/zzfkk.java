package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkk {
    public static void zza(ListenableFuture listenableFuture, zzfkl zzfkl, zzfka zzfka) {
        zzg(listenableFuture, zzfkl, zzfka, false);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfkl zzfkl, zzfka zzfka) {
        zzg(listenableFuture, zzfkl, zzfka, true);
    }

    public static void zzc(ListenableFuture listenableFuture, zzfkl zzfkl, zzfka zzfka) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            zzgei.zzr(zzgdz.zzu(listenableFuture), new zzfkj(zzfkl, zzfka), zzcaj.zzf);
        }
    }

    public static void zzd(ListenableFuture listenableFuture, zzfka zzfka) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            zzgei.zzr(zzgdz.zzu(listenableFuture), new zzfkh(zzfka), zzcaj.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) zzbe.zzc().zza(zzbcn.zzit), str);
    }

    public static int zzf(zzffo zzffo) {
        int zzf = zzv.zzf(zzffo) - 1;
        return (zzf == 0 || zzf == 1) ? 7 : 23;
    }

    private static void zzg(ListenableFuture listenableFuture, zzfkl zzfkl, zzfka zzfka, boolean z) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            zzgei.zzr(zzgdz.zzu(listenableFuture), new zzfki(zzfkl, zzfka, z), zzcaj.zzf);
        }
    }
}
