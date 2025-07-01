package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfzv extends zzfxp {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfwr zzb;

    zzfzv(Iterator it, zzfwr zzfwr) {
        this.zza = it;
        this.zzb = zzfwr;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            zzfwr zzfwr = this.zzb;
            Object next = it.next();
            if (zzfwr.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
