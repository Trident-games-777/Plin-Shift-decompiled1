package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzfkl;
import com.google.android.gms.internal.ads.zzgee;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzam implements zzgee {
    final /* synthetic */ zzbtv zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzap zzc;

    zzam(zzap zzap, zzbtv zzbtv, boolean z) {
        this.zza = zzbtv;
        this.zzb = z;
        this.zzc = zzap;
    }

    public final void zza(Throwable th) {
        try {
            zzbtv zzbtv = this.zza;
            String message = th.getMessage();
            zzbtv.zze("Internal error: " + message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzr || this.zzb) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (this.zzc.zzP(uri)) {
                        zzap zzap = this.zzc;
                        this.zzc.zzq.zzc(zzap.zzZ(uri, zzap.zzA, DiskLruCache.VERSION).toString(), (zzfkl) null);
                    } else {
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhh)).booleanValue()) {
                            this.zzc.zzq.zzc(uri.toString(), (zzfkl) null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
