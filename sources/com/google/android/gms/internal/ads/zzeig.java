package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeig {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final zzgfa zzc;
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private zzeiw zzf;
    private int zzg = Integer.MAX_VALUE;
    private final String zzh;
    private final int zzi;
    private final zzeiv zzj;
    private zzfet zzk;
    private boolean zzl;

    zzeig(zzfff zzfff, zzeiv zzeiv, zzgfa zzgfa) {
        this.zzl = false;
        this.zzi = zzfff.zzb.zzb.zzr;
        this.zzj = zzeiv;
        this.zzc = zzgfa;
        this.zzh = zzejc.zzc(zzfff);
        List list = zzfff.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfet) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzeiw zzeiw = this.zzf;
        if (zzeiw != null) {
            this.zzc.zzc(zzeiw);
        } else {
            this.zzc.zzd(new zzeiz(3, this.zzh));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List r0 = r4.zzb     // Catch:{ all -> 0x004b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004b }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x004b }
            com.google.android.gms.internal.ads.zzfet r1 = (com.google.android.gms.internal.ads.zzfet) r1     // Catch:{ all -> 0x004b }
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0022
            int r2 = r2.intValue()     // Catch:{ all -> 0x004b }
            goto L_0x0025
        L_0x0022:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x0025:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0035
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x004b }
            java.lang.String r1 = r1.zzat     // Catch:{ all -> 0x004b }
            boolean r1 = r3.contains(r1)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0007
        L_0x0035:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r3 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 >= r3) goto L_0x0040
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0040:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r2 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 <= r2) goto L_0x0007
        L_0x0048:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x004b:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeig.zzf(boolean):boolean");
    }

    private final synchronized boolean zzg() {
        for (zzfet zzfet : this.zzd) {
            Integer num = (Integer) this.zza.get(zzfet);
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzh() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            boolean r1 = r2.zzf(r0)     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0012
            boolean r1 = r2.zzg()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0012:
            monitor-exit(r2)
            return r0
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeig.zzh():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzi() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzl     // Catch:{ all -> 0x0042 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0027
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfet r0 = (com.google.android.gms.internal.ads.zzfet) r0     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.zzav     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0027
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            monitor-exit(r3)
            return r1
        L_0x0027:
            boolean r0 = r3.zzd()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0040
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0042 }
            int r2 = r3.zzi     // Catch:{ all -> 0x0042 }
            int r0 = r0.size()     // Catch:{ all -> 0x0042 }
            if (r0 >= r2) goto L_0x0040
            boolean r0 = r3.zzf(r1)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0040
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0040:
            monitor-exit(r3)
            return r1
        L_0x0042:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeig.zzi():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        return null;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfet zza() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzi()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0046
            r0 = 0
        L_0x0008:
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            int r1 = r1.size()     // Catch:{ all -> 0x0049 }
            if (r0 >= r1) goto L_0x0046
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfet r1 = (com.google.android.gms.internal.ads.zzfet) r1     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r1.zzat     // Catch:{ all -> 0x0049 }
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.contains(r2)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0025
            int r0 = r0 + 1
            goto L_0x0008
        L_0x0025:
            boolean r3 = r1.zzav     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x002c
            r3 = 1
            r4.zzl = r3     // Catch:{ all -> 0x0049 }
        L_0x002c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x0037
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            r3.add(r2)     // Catch:{ all -> 0x0049 }
        L_0x0037:
            java.util.List r2 = r4.zzd     // Catch:{ all -> 0x0049 }
            r2.add(r1)     // Catch:{ all -> 0x0049 }
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r0 = r1.remove(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfet r0 = (com.google.android.gms.internal.ads.zzfet) r0     // Catch:{ all -> 0x0049 }
            monitor-exit(r4)
            return r0
        L_0x0046:
            monitor-exit(r4)
            r0 = 0
            return r0
        L_0x0049:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0049 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeig.zza():com.google.android.gms.internal.ads.zzfet");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(java.lang.Throwable r1, com.google.android.gms.internal.ads.zzfet r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            r1 = 0
            r0.zzl = r1     // Catch:{ all -> 0x0023 }
            java.util.List r1 = r0.zzd     // Catch:{ all -> 0x0023 }
            r1.remove(r2)     // Catch:{ all -> 0x0023 }
            java.util.Set r1 = r0.zze     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.zzat     // Catch:{ all -> 0x0023 }
            r1.remove(r2)     // Catch:{ all -> 0x0023 }
            boolean r1 = r0.zzd()     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            boolean r1 = r0.zzh()     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            r0.zze()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return
        L_0x0021:
            monitor-exit(r0)
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeig.zzb(java.lang.Throwable, com.google.android.gms.internal.ads.zzfet):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(zzeiw zzeiw, zzfet zzfet) {
        this.zzl = false;
        this.zzd.remove(zzfet);
        if (zzd()) {
            zzeiw.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfet);
        Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (valueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfet);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = valueOf.intValue();
        this.zzf = zzeiw;
        this.zzk = zzfet;
        if (!zzh()) {
            zze();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
