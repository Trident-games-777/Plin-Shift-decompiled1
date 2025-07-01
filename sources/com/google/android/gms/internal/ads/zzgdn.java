package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcy;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzgdn extends zzgcy.zzi {
    private static final zzgdj zzbd;
    private static final zzger zzbe;
    /* access modifiers changed from: private */
    public volatile int remaining;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzgdj zzgdj;
        Class<zzgdn> cls = zzgdn.class;
        zzbe = new zzger(cls);
        try {
            zzgdj = new zzgdk(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgdj = new zzgdl((zzgdm) null);
        }
        zzbd = zzgdj;
        if (th != null) {
            zzbe.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzgdn(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzA() {
        return zzbd.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final Set zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zze(newSetFromMap);
        zzbd.zzb(this, (Set) null, newSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    }

    /* access modifiers changed from: package-private */
    public final void zzF() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zze(Set set);
}
