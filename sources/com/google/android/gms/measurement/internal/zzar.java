package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
public final class zzar {
    private final String zza;
    private long zzb = -1;
    private final /* synthetic */ zzal zzc;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzap> zza() {
        /*
            r20 = this;
            r1 = r20
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r6 = "app_id = ? and rowid > ?"
            r12 = 2
            java.lang.String[] r7 = new java.lang.String[r12]
            java.lang.String r0 = r1.zza
            r13 = 0
            r7[r13] = r0
            long r3 = r1.zzb
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r14 = 1
            r7[r14] = r0
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzc     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            android.database.sqlite.SQLiteDatabase r3 = r0.e_()     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r4 = "raw_events"
            r0 = 6
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "rowid"
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "name"
            r5[r14] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "timestamp"
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "metadata_fingerprint"
            r8 = 3
            r5[r8] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "data"
            r9 = 4
            r5[r9] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r0 = "realtime"
            r10 = 5
            r5[r10] = r0     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            r11 = r10
            java.lang.String r10 = "rowid"
            r16 = r11
            java.lang.String r11 = "1000"
            r17 = r8
            r8 = 0
            r18 = r9
            r9 = 0
            r15 = r16
            r14 = r17
            r12 = r18
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0067
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            if (r3 == 0) goto L_0x0066
            r3.close()
        L_0x0066:
            return r0
        L_0x0067:
            long r5 = r3.getLong(r13)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            long r7 = r3.getLong(r14)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            long r9 = r3.getLong(r15)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r18 = 1
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x007b
            r9 = 1
            goto L_0x007c
        L_0x007b:
            r9 = r13
        L_0x007c:
            byte[] r0 = r3.getBlob(r12)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            long r10 = r1.zzb     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0088
            r1.zzb = r5     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
        L_0x0088:
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch:{ IOException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzoo.zza(r4, (byte[]) r0)     // Catch:{ IOException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r0 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r0     // Catch:{ IOException -> 0x00bc }
            r11 = 1
            java.lang.String r4 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            if (r4 == 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            java.lang.String r4 = ""
        L_0x009c:
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = r0.zza((java.lang.String) r4)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r10 = 2
            long r11 = r3.getLong(r10)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r4.zzb((long) r11)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzap r4 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.internal.measurement.zzlc r0 = r0.zzai()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.internal.measurement.zzfy$zzf r0 = (com.google.android.gms.internal.measurement.zzfy.zzf) r0     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r16 = r10
            r10 = r0
            r4.<init>(r5, r7, r9, r10)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r2.add(r4)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            goto L_0x00d4
        L_0x00bc:
            r0 = move-exception
            r16 = 2
            com.google.android.gms.measurement.internal.zzal r4 = r1.zzc     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzgo r4 = r4.zzj()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            java.lang.String r5 = "Data loss. Failed to merge raw event. appId"
            java.lang.String r6 = r1.zza     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            r4.zza(r5, r6, r0)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
        L_0x00d4:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            if (r0 != 0) goto L_0x00e0
            if (r3 == 0) goto L_0x0107
            r3.close()
            goto L_0x0107
        L_0x00e0:
            r12 = 4
            goto L_0x0067
        L_0x00e2:
            r0 = move-exception
            r15 = r3
            goto L_0x0109
        L_0x00e5:
            r0 = move-exception
            r15 = r3
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r15 = 0
            goto L_0x0109
        L_0x00eb:
            r0 = move-exception
            r15 = 0
        L_0x00ed:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzc     // Catch:{ all -> 0x0108 }
            com.google.android.gms.measurement.internal.zzgo r3 = r3.zzj()     // Catch:{ all -> 0x0108 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "Data loss. Error querying raw events batch. appId"
            java.lang.String r5 = r1.zza     // Catch:{ all -> 0x0108 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)     // Catch:{ all -> 0x0108 }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x0108 }
            if (r15 == 0) goto L_0x0107
            r15.close()
        L_0x0107:
            return r2
        L_0x0108:
            r0 = move-exception
        L_0x0109:
            if (r15 == 0) goto L_0x010e
            r15.close()
        L_0x010e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza():java.util.List");
    }

    public zzar(zzal zzal, String str) {
        this.zzc = zzal;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }
}
