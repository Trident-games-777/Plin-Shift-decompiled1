package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
final class zzli<T> implements zzlu<T> {
    private final zzlc zza;
    private final zzmk<?, ?> zzb;
    private final boolean zzc;
    private final zzji<?> zzd;

    public final int zza(T t) {
        zzmk<?, ?> zzmk = this.zzb;
        int zzb2 = zzmk.zzb(zzmk.zzd(t));
        return this.zzc ? zzb2 + this.zzd.zza((Object) t).zza() : zzb2;
    }

    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    static <T> zzli<T> zza(zzmk<?, ?> zzmk, zzji<?> zzji, zzlc zzlc) {
        return new zzli<>(zzmk, zzji, zzlc);
    }

    public final T zza() {
        zzlc zzlc = this.zza;
        if (zzlc instanceof zzjt) {
            return ((zzjt) zzlc).zzce();
        }
        return zzlc.zzci().zzaj();
    }

    private zzli(zzmk<?, ?> zzmk, zzji<?> zzji, zzlc zzlc) {
        this.zzb = zzmk;
        this.zzc = zzji.zza(zzlc);
        this.zzd = zzji;
        this.zza = zzlc;
    }

    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    public final void zza(T t, T t2) {
        zzlw.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzlw.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzlr zzlr, zzjg zzjg) throws IOException {
        boolean z;
        zzmk<?, ?> zzmk = this.zzb;
        zzji<?> zzji = this.zzd;
        Object zzc2 = zzmk.zzc(t);
        zzjm<?> zzb2 = zzji.zzb(t);
        do {
            try {
                if (zzlr.zzc() == Integer.MAX_VALUE) {
                    zzmk.zzb((Object) t, zzc2);
                    return;
                }
                int zzd2 = zzlr.zzd();
                int i = 0;
                if (zzd2 == 11) {
                    Object obj = null;
                    zzik zzik = null;
                    while (zzlr.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzlr.zzd();
                        if (zzd3 == 16) {
                            i = zzlr.zzj();
                            obj = zzji.zza(zzjg, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj != null) {
                                zzji.zza(zzlr, obj, zzjg, zzb2);
                            } else {
                                zzik = zzlr.zzp();
                            }
                        } else if (!zzlr.zzt()) {
                            break;
                        }
                    }
                    if (zzlr.zzd() != 12) {
                        throw zzkb.zzb();
                    } else if (zzik != null) {
                        if (obj != null) {
                            zzji.zza(zzik, obj, zzjg, zzb2);
                        } else {
                            zzmk.zza(zzc2, i, zzik);
                        }
                    }
                } else if ((zzd2 & 7) == 2) {
                    Object zza2 = zzji.zza(zzjg, this.zza, zzd2 >>> 3);
                    if (zza2 != null) {
                        zzji.zza(zzlr, zza2, zzjg, zzb2);
                    } else {
                        z = zzmk.zza(zzc2, zzlr, 0);
                        continue;
                    }
                } else {
                    z = zzlr.zzt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzmk.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.internal.measurement.zzjt$zzf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzjt$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzij r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            com.google.android.gms.internal.measurement.zzmj r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzmj r2 = com.google.android.gms.internal.measurement.zzmj.zzc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzmj r1 = com.google.android.gms.internal.measurement.zzmj.zzd()
            r0.zzb = r1
        L_0x0011:
            r6 = r1
            com.google.android.gms.internal.measurement.zzjt$zzd r10 = (com.google.android.gms.internal.measurement.zzjt.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0019:
            if (r12 >= r13) goto L_0x00af
            int r4 = com.google.android.gms.internal.measurement.zzig.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r1 = 2
            if (r2 == r12) goto L_0x0054
            r12 = r2 & 7
            if (r12 != r1) goto L_0x004c
            com.google.android.gms.internal.measurement.zzji<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzjg r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzlc r1 = r9.zza
            int r3 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r1, r3)
            r0 = r12
            com.google.android.gms.internal.measurement.zzjt$zzf r0 = (com.google.android.gms.internal.measurement.zzjt.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzig.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzmj) r6, (com.google.android.gms.internal.measurement.zzij) r7)
            goto L_0x0019
        L_0x0043:
            com.google.android.gms.internal.measurement.zzlq.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzig.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzij) r7)
            goto L_0x0019
        L_0x0054:
            r3 = r11
            r5 = r13
            r7 = r14
            r11 = 0
            r12 = r10
        L_0x0059:
            if (r4 >= r5) goto L_0x00a0
            int r13 = com.google.android.gms.internal.measurement.zzig.zzc(r3, r4, r7)
            int r14 = r7.zza
            int r2 = r14 >>> 3
            r4 = r14 & 7
            if (r2 == r1) goto L_0x0081
            r8 = 3
            if (r2 == r8) goto L_0x006b
            goto L_0x0097
        L_0x006b:
            if (r0 != 0) goto L_0x0078
            if (r4 != r1) goto L_0x0097
            int r4 = com.google.android.gms.internal.measurement.zzig.zza(r3, r13, r7)
            java.lang.Object r12 = r7.zzc
            com.google.android.gms.internal.measurement.zzik r12 = (com.google.android.gms.internal.measurement.zzik) r12
            goto L_0x0059
        L_0x0078:
            com.google.android.gms.internal.measurement.zzlq.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x0081:
            if (r4 != 0) goto L_0x0097
            int r4 = com.google.android.gms.internal.measurement.zzig.zzc(r3, r13, r7)
            int r11 = r7.zza
            com.google.android.gms.internal.measurement.zzji<?> r13 = r9.zzd
            com.google.android.gms.internal.measurement.zzjg r14 = r7.zzd
            com.google.android.gms.internal.measurement.zzlc r0 = r9.zza
            java.lang.Object r13 = r13.zza(r14, r0, r11)
            r0 = r13
            com.google.android.gms.internal.measurement.zzjt$zzf r0 = (com.google.android.gms.internal.measurement.zzjt.zzf) r0
            goto L_0x0059
        L_0x0097:
            r2 = 12
            if (r14 == r2) goto L_0x00a1
            int r4 = com.google.android.gms.internal.measurement.zzig.zza((int) r14, (byte[]) r3, (int) r13, (int) r5, (com.google.android.gms.internal.measurement.zzij) r7)
            goto L_0x0059
        L_0x00a0:
            r13 = r4
        L_0x00a1:
            if (r12 == 0) goto L_0x00a9
            int r11 = r11 << 3
            r11 = r11 | r1
            r6.zza((int) r11, (java.lang.Object) r12)
        L_0x00a9:
            r12 = r13
            r11 = r3
            r13 = r5
            r14 = r7
            goto L_0x0019
        L_0x00af:
            r5 = r13
            if (r12 != r5) goto L_0x00b3
            return
        L_0x00b3:
            com.google.android.gms.internal.measurement.zzkb r10 = com.google.android.gms.internal.measurement.zzkb.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzli.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzij):void");
    }

    public final void zza(T t, zznb zznb) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzjo zzjo = (zzjo) next.getKey();
            if (zzjo.zzc() != zzmz.MESSAGE || zzjo.zze() || zzjo.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzkf) {
                zznb.zza(zzjo.zza(), (Object) ((zzkf) next).zza().zzb());
            } else {
                zznb.zza(zzjo.zza(), next.getValue());
            }
        }
        zzmk<?, ?> zzmk = this.zzb;
        zzmk.zza(zzmk.zzd(t), zznb);
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final boolean zze(T t) {
        return this.zzd.zza((Object) t).zzg();
    }
}
