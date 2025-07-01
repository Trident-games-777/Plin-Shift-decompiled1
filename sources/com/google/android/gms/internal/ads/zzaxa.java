package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxa extends zzaxt {
    private final Map zzh;
    private final View zzi;
    private final Context zzj;

    public zzaxa(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, Map map, View view, Context context) {
        super(zzawf, "SSi9+bc4LjSDCw5XbM9a3o0KjM00NEx8AzpqWTmGrN6ZCy4DwzQ9YQ8F3uOviR+R", "vovSRMWoC6DyReNhMsLU/AHhR3bWlWI4SOQQixDW2Zg=", zzasf, i, 85);
        this.zzh = map;
        this.zzi = view;
        this.zzj = context;
    }

    private final long zzc(int i) {
        Map map = this.zzh;
        Integer valueOf = Integer.valueOf(i);
        if (map.containsKey(valueOf)) {
            return ((Long) this.zzh.get(valueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = {zzc(1), zzc(2)};
        Context context = this.zzj;
        if (context == null) {
            context = this.zza.zzb();
        }
        long[] jArr2 = (long[]) this.zze.invoke((Object) null, new Object[]{jArr, context, this.zzi});
        long j = jArr2[0];
        this.zzh.put(1, Long.valueOf(jArr2[1]));
        long j2 = jArr2[2];
        this.zzh.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.zzd) {
            this.zzd.zzv(j);
            this.zzd.zzu(j2);
        }
    }
}
