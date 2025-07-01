package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgff extends zzgeq {
    final /* synthetic */ zzgfh zza;
    private final zzgdo zzb;

    zzgff(zzgfh zzgfh, zzgdo zzgdo) {
        this.zza = zzgfh;
        zzgdo zzgdo2 = zzgdo;
        this.zzb = zzgdo;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgdo zzgdo = this.zzb;
        ListenableFuture zza2 = zzgdo.zza();
        zzfwq.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdo);
        ListenableFuture listenableFuture = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((ListenableFuture) obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
