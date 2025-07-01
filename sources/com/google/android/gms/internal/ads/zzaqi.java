package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaqi {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzaqi(java.lang.String r14, com.google.android.gms.internal.ads.zzaoy r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzb
            long r3 = r15.zzc
            long r5 = r15.zzd
            long r7 = r15.zze
            long r9 = r15.zzf
            java.util.List r0 = r15.zzh
            if (r0 == 0) goto L_0x0012
        L_0x000e:
            r1 = r14
            r11 = r0
            r0 = r13
            goto L_0x0046
        L_0x0012:
            java.util.Map r15 = r15.zzg
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0025:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzaph r11 = new com.google.android.gms.internal.ads.zzaph
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0025
        L_0x0046:
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqi.<init>(java.lang.String, com.google.android.gms.internal.ads.zzaoy):void");
    }

    static zzaqi zza(zzaqj zzaqj) throws IOException {
        if (zzaql.zze(zzaqj) == 538247942) {
            String zzh2 = zzaql.zzh(zzaqj);
            String zzh3 = zzaql.zzh(zzaqj);
            long zzf2 = zzaql.zzf(zzaqj);
            long zzf3 = zzaql.zzf(zzaqj);
            long zzf4 = zzaql.zzf(zzaqj);
            long zzf5 = zzaql.zzf(zzaqj);
            int zze2 = zzaql.zze(zzaqj);
            if (zze2 >= 0) {
                List emptyList = zze2 == 0 ? Collections.emptyList() : new ArrayList();
                for (int i = 0; i < zze2; i++) {
                    emptyList.add(new zzaph(zzaql.zzh(zzaqj).intern(), zzaql.zzh(zzaqj).intern()));
                }
                return new zzaqi(zzh2, zzh3, zzf2, zzf3, zzf4, zzf5, emptyList);
            }
            throw new IOException("readHeaderList size=" + zze2);
        }
        throw new IOException();
    }

    private zzaqi(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
