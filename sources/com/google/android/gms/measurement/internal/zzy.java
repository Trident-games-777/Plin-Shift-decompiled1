package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfy;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
final class zzy {
    private zzfy.zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzt zzd;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfy.zzf zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzfy.zzf r19) {
        /*
            r17 = this;
            r1 = r17
            r3 = r18
            r8 = r19
            java.lang.String r0 = r8.zzg()
            java.util.List r9 = r8.zzh()
            com.google.android.gms.measurement.internal.zzt r2 = r1.zzd
            r2.g_()
            java.lang.String r2 = "_eid"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzoo.zzb(r8, r2)
            java.lang.Long r4 = (java.lang.Long) r4
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0021
            r7 = r5
            goto L_0x0022
        L_0x0021:
            r7 = r6
        L_0x0022:
            r10 = 0
            if (r7 == 0) goto L_0x0142
            java.lang.String r12 = "_ep"
            boolean r12 = r0.equals(r12)
            if (r12 == 0) goto L_0x0142
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            r0.g_()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzoo.zzb(r8, r0)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r7 = 0
            if (r0 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzn()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zza(r2, r4)
            return r7
        L_0x0056:
            com.google.android.gms.internal.measurement.zzfy$zzf r0 = r1.zza
            if (r0 == 0) goto L_0x006c
            java.lang.Long r0 = r1.zzb
            if (r0 == 0) goto L_0x006c
            long r13 = r4.longValue()
            java.lang.Long r0 = r1.zzb
            long r15 = r0.longValue()
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x009d
        L_0x006c:
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r0 = r0.zzh()
            android.util.Pair r0 = r0.zza((java.lang.String) r3, (java.lang.Long) r4)
            if (r0 == 0) goto L_0x0132
            java.lang.Object r13 = r0.first
            if (r13 != 0) goto L_0x007e
            goto L_0x0132
        L_0x007e:
            java.lang.Object r7 = r0.first
            com.google.android.gms.internal.measurement.zzfy$zzf r7 = (com.google.android.gms.internal.measurement.zzfy.zzf) r7
            r1.zza = r7
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r13 = r0.longValue()
            r1.zzc = r13
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            r0.g_()
            com.google.android.gms.internal.measurement.zzfy$zzf r0 = r1.zza
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzoo.zzb(r0, r2)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.zzb = r0
        L_0x009d:
            long r13 = r1.zzc
            r15 = 1
            long r13 = r13 - r15
            r1.zzc = r13
            int r0 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r0.zzh()
            r2.zzt()
            com.google.android.gms.measurement.internal.zzgo r0 = r2.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r0.zza(r4, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.e_()     // Catch:{ SQLiteException -> 0x00cc }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x00cc }
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x00cc }
            r0.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x00cc }
            goto L_0x00e8
        L_0x00cc:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x00e8
        L_0x00db:
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r0.zzh()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzfy$zzf r7 = r1.zza
            r2.zza((java.lang.String) r3, (java.lang.Long) r4, (long) r5, (com.google.android.gms.internal.measurement.zzfy.zzf) r7)
        L_0x00e8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = r1.zza
            java.util.List r2 = r2.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x00f7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0116
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfy$zzh r3 = (com.google.android.gms.internal.measurement.zzfy.zzh) r3
            com.google.android.gms.measurement.internal.zzt r4 = r1.zzd
            r4.g_()
            java.lang.String r4 = r3.zzg()
            com.google.android.gms.internal.measurement.zzfy$zzh r4 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x00f7
            r0.add(r3)
            goto L_0x00f7
        L_0x0116:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0121
            r0.addAll(r9)
            r9 = r0
            goto L_0x0130
        L_0x0121:
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzn()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zza(r2, r12)
        L_0x0130:
            r0 = r12
            goto L_0x0188
        L_0x0132:
            com.google.android.gms.measurement.internal.zzt r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzn()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zza(r2, r12, r4)
            return r7
        L_0x0142:
            if (r7 == 0) goto L_0x0188
            r1.zzb = r4
            r1.zza = r8
            com.google.android.gms.measurement.internal.zzt r2 = r1.zzd
            r2.g_()
            java.lang.String r2 = "_epc"
            java.lang.Long r3 = java.lang.Long.valueOf(r10)
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r8, (java.lang.String) r2, (java.lang.Object) r3)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r1.zzc = r2
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzt r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzgo r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzn()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.zza(r3, r0)
            goto L_0x0188
        L_0x0173:
            com.google.android.gms.measurement.internal.zzt r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzal r2 = r2.zzh()
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r1.zzc
            r3 = r18
            r7 = r8
            r2.zza((java.lang.String) r3, (java.lang.Long) r4, (long) r5, (com.google.android.gms.internal.measurement.zzfy.zzf) r7)
        L_0x0188:
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = r19.zzcd()
            r3 = r2
            com.google.android.gms.internal.measurement.zzjt$zzb r3 = (com.google.android.gms.internal.measurement.zzjt.zzb) r3
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r0 = r2.zza((java.lang.String) r0)
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r0 = r0.zzd()
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r0 = r0.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzh>) r9)
            com.google.android.gms.internal.measurement.zzlc r0 = r0.zzai()
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            com.google.android.gms.internal.measurement.zzfy$zzf r0 = (com.google.android.gms.internal.measurement.zzfy.zzf) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(java.lang.String, com.google.android.gms.internal.measurement.zzfy$zzf):com.google.android.gms.internal.measurement.zzfy$zzf");
    }

    private zzy(zzt zzt) {
        this.zzd = zzt;
    }
}
