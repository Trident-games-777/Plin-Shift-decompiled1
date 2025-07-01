package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfjb {
    public static final zzfjh zza(Callable callable, Object obj, zzfjj zzfjj) {
        return zzb(callable, zzfjj.zzb, obj, zzfjj);
    }

    public static final zzfjh zzb(Callable callable, zzges zzges, Object obj, zzfjj zzfjj) {
        return new zzfjh(zzfjj, obj, (String) null, zzfjj.zza, Collections.emptyList(), zzges.zzb(callable), (zzfji) null);
    }

    public static final zzfjh zzc(ListenableFuture listenableFuture, Object obj, zzfjj zzfjj) {
        return new zzfjh(zzfjj, obj, (String) null, zzfjj.zza, Collections.emptyList(), listenableFuture, (zzfji) null);
    }

    public static final zzfjh zzd(zzfiw zzfiw, zzges zzges, Object obj, zzfjj zzfjj) {
        return zzb(new zzfja(zzfiw), zzges, obj, zzfjj);
    }
}
