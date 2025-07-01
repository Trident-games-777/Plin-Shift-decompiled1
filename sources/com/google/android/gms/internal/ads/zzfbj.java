package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfbj implements zzgdp {
    public final /* synthetic */ zzfhl zza;
    public final /* synthetic */ zzcsy zzb;

    public /* synthetic */ zzfbj(zzfbl zzfbl, zzfhl zzfhl, zzcsy zzcsy) {
        this.zza = zzfhl;
        this.zzb = zzcsy;
    }

    public final ListenableFuture zza(Object obj) {
        zzfff zzfff = (zzfff) obj;
        this.zza.zzb = zzfff;
        Iterator it = zzfff.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator it2 = ((zzfet) it.next()).zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return this.zzb.zzi(zzgei.zzh(zzfff));
            }
        }
        return zzgei.zzh((Object) null);
    }
}
