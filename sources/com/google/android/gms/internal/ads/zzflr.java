package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzflr {
    private final Context zza;
    private final Executor zzb;
    private final zzr zzc;
    private final zzfko zzd;

    zzflr(Context context, Executor executor, zzr zzr, zzfko zzfko) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzr;
        this.zzd = zzfko;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzfkl zzfkl) {
        zzfka zza2 = zzfjz.zza(this.zza, 14);
        zza2.zzi();
        zza2.zzg(this.zzc.zza(str));
        if (zzfkl == null) {
            this.zzd.zzb(zza2.zzm());
            return;
        }
        zzfkl.zza(zza2);
        zzfkl.zzh();
    }

    public final void zzc(String str, zzfkl zzfkl) {
        if (!zzfko.zza() || !((Boolean) zzbeg.zzd.zze()).booleanValue()) {
            this.zzb.execute(new zzflp(this, str));
        } else {
            this.zzb.execute(new zzflq(this, str, zzfkl));
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), (zzfkl) null);
        }
    }
}
