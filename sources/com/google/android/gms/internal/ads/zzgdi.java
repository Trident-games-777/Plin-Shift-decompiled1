package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzgdi extends zzgdn {
    private static final zzger zza = new zzger(zzgdi.class);
    @CheckForNull
    private zzfzj zzb;
    private final boolean zzc;
    private final boolean zzf;

    zzgdi(zzfzj zzfzj, boolean z, boolean z2) {
        super(zzfzj.size());
        zzfzj.getClass();
        zzfzj zzfzj2 = zzfzj;
        this.zzb = zzfzj;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgfj.zza(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzH */
    public final void zzx(@CheckForNull zzfzj zzfzj) {
        int zzA = zzA();
        int i = 0;
        zzfwq.zzl(zzA >= 0, "Less than 0 remaining futures");
        if (zzA == 0) {
            if (zzfzj != null) {
                zzgbu zze = zzfzj.iterator();
                while (zze.hasNext()) {
                    Future future = (Future) zze.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private static void zzJ(Throwable th) {
        String str;
        if (true != (th instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        } else {
            str = "Input Future failed with Error";
        }
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", str, th);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzK */
    public final void zzw(int i, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx((zzfzj) null);
        }
    }

    private static boolean zzL(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzfzj zzfzj = this.zzb;
        if (zzfzj != null) {
            return "futures=".concat(zzfzj.toString());
        }
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfzj zzfzj = this.zzb;
        boolean z = true;
        zzy(1);
        boolean isCancelled = isCancelled();
        if (zzfzj == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzt = zzt();
            zzgbu zze = zzfzj.iterator();
            while (zze.hasNext()) {
                ((Future) zze.next()).cancel(zzt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzf(int i, Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzu();

    /* access modifiers changed from: package-private */
    public final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
        } else if (this.zzc) {
            zzgbu zze = this.zzb.iterator();
            int i = 0;
            while (zze.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) zze.next();
                int i2 = i + 1;
                if (listenableFuture.isDone()) {
                    zzw(i, listenableFuture);
                } else {
                    listenableFuture.addListener(new zzgdg(this, i, listenableFuture), zzgdw.INSTANCE);
                }
                i = i2;
            }
        } else {
            zzfzj zzfzj = this.zzf ? this.zzb : null;
            zzgdh zzgdh = new zzgdh(this, zzfzj);
            zzgbu zze2 = this.zzb.iterator();
            while (zze2.hasNext()) {
                ListenableFuture listenableFuture2 = (ListenableFuture) zze2.next();
                if (listenableFuture2.isDone()) {
                    zzx(zzfzj);
                } else {
                    listenableFuture2.addListener(zzgdh, zzgdw.INSTANCE);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzy(int i) {
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Set set) {
        set.getClass();
        if (!isCancelled()) {
            zzL(set, (Throwable) Objects.requireNonNull(zzl()));
        }
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzL(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }
}
