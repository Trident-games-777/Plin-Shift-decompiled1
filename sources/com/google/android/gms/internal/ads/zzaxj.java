package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxj extends zzaxt {
    private List zzh = null;
    private final Context zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaxj(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, Context context) {
        super(zzawf, "p2B6bhXfJZNgZ0+I4L4c9cLXJrfGeKZvoxHbzoRookWEJhhW5Gvimq5QvTg4oqLM", "wcFaDbS//5pJ1R+WEpFF/o7BDXsIcxPrCZPKL326+18=", zzasf, i, 31);
        this.zzi = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzW(-1);
        this.zzd.zzS(-1);
        Context context = this.zzi;
        if (context == null) {
            context = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke((Object) null, new Object[]{context});
        }
        List list = this.zzh;
        if (list != null && list.size() == 2) {
            synchronized (this.zzd) {
                this.zzd.zzW(((Long) this.zzh.get(0)).longValue());
                this.zzd.zzS(((Long) this.zzh.get(1)).longValue());
            }
        }
    }
}
