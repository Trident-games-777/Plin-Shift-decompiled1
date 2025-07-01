package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
final class zzli extends zznr {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    public zzli(zznv zznv) {
        super(zznv);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0357 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x037b A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03a5 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03f4 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0463 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x047a A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0485 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0489 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a6 A[Catch:{ SecurityException -> 0x01b7, all -> 0x054a }, LOOP:1: B:97:0x02a0->B:99:0x02a6, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(com.google.android.gms.measurement.internal.zzbf r27, java.lang.String r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r3 = r28
            java.lang.String r2 = "_r"
            r1.zzt()
            com.google.android.gms.measurement.internal.zzhy r4 = r1.zzu
            r4.zzy()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzbl
            boolean r4 = r4.zze(r3, r5)
            r5 = 0
            if (r4 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            java.lang.String r2 = "Generating ScionPayload disabled. packageName"
            r0.zza(r2, r3)
            byte[] r0 = new byte[r5]
            return r0
        L_0x0033:
            java.lang.String r4 = "_iap"
            java.lang.String r6 = r0.zza
            boolean r4 = r4.equals(r6)
            r6 = 0
            if (r4 != 0) goto L_0x0058
            java.lang.String r4 = "_iapx"
            java.lang.String r7 = r0.zza
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzc()
            java.lang.String r4 = "Generating a payload for this event is not available. package_name, event_name"
            java.lang.String r0 = r0.zza
            r2.zza(r4, r3, r0)
            return r6
        L_0x0058:
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r4 = com.google.android.gms.internal.measurement.zzfy.zzj.zzb()
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzh()
            r7.zzp()
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzh()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zze(r3)     // Catch:{ all -> 0x054a }
            if (r7 != 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()     // Catch:{ all -> 0x054a }
            java.lang.String r2 = "Log and bundle not available. package_name"
            r0.zza(r2, r3)     // Catch:{ all -> 0x054a }
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()
            r2.zzu()
            return r0
        L_0x0084:
            boolean r8 = r7.zzar()     // Catch:{ all -> 0x054a }
            if (r8 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()     // Catch:{ all -> 0x054a }
            java.lang.String r2 = "Log and bundle disabled. package_name"
            r0.zza(r2, r3)     // Catch:{ all -> 0x054a }
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()
            r2.zzu()
            return r0
        L_0x00a1:
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r8 = com.google.android.gms.internal.measurement.zzfy.zzk.zzw()     // Catch:{ all -> 0x054a }
            r9 = 1
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r8 = r8.zzh((int) r9)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = "android"
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r8 = r8.zzp(r9)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = r7.zzac()     // Catch:{ all -> 0x054a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x054a }
            if (r9 != 0) goto L_0x00c1
            java.lang.String r9 = r7.zzac()     // Catch:{ all -> 0x054a }
            r8.zzb((java.lang.String) r9)     // Catch:{ all -> 0x054a }
        L_0x00c1:
            java.lang.String r9 = r7.zzae()     // Catch:{ all -> 0x054a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x054a }
            if (r9 != 0) goto L_0x00d8
            java.lang.String r9 = r7.zzae()     // Catch:{ all -> 0x054a }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x054a }
            r8.zzd((java.lang.String) r9)     // Catch:{ all -> 0x054a }
        L_0x00d8:
            java.lang.String r9 = r7.zzaf()     // Catch:{ all -> 0x054a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x054a }
            if (r9 != 0) goto L_0x00ef
            java.lang.String r9 = r7.zzaf()     // Catch:{ all -> 0x054a }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x054a }
            r8.zze((java.lang.String) r9)     // Catch:{ all -> 0x054a }
        L_0x00ef:
            long r9 = r7.zze()     // Catch:{ all -> 0x054a }
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0102
            long r9 = r7.zze()     // Catch:{ all -> 0x054a }
            int r9 = (int) r9     // Catch:{ all -> 0x054a }
            r8.zze((int) r9)     // Catch:{ all -> 0x054a }
        L_0x0102:
            long r9 = r7.zzq()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r9 = r8.zzf((long) r9)     // Catch:{ all -> 0x054a }
            long r10 = r7.zzo()     // Catch:{ all -> 0x054a }
            r9.zzd((long) r10)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = r7.zzah()     // Catch:{ all -> 0x054a }
            java.lang.String r10 = r7.zzaa()     // Catch:{ all -> 0x054a }
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x054a }
            if (r11 != 0) goto L_0x0123
            r8.zzm(r9)     // Catch:{ all -> 0x054a }
            goto L_0x012c
        L_0x0123:
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x054a }
            if (r9 != 0) goto L_0x012c
            r8.zza((java.lang.String) r10)     // Catch:{ all -> 0x054a }
        L_0x012c:
            long r9 = r7.zzw()     // Catch:{ all -> 0x054a }
            r8.zzj((long) r9)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zznv r9 = r1.zzg     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzje r9 = r9.zzb((java.lang.String) r3)     // Catch:{ all -> 0x054a }
            long r10 = r7.zzn()     // Catch:{ all -> 0x054a }
            r8.zzc((long) r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzhy r10 = r1.zzu     // Catch:{ all -> 0x054a }
            boolean r10 = r10.zzac()     // Catch:{ all -> 0x054a }
            if (r10 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x054a }
            java.lang.String r11 = r8.zzt()     // Catch:{ all -> 0x054a }
            boolean r10 = r10.zzj(r11)     // Catch:{ all -> 0x054a }
            if (r10 == 0) goto L_0x0165
            boolean r10 = r9.zzg()     // Catch:{ all -> 0x054a }
            if (r10 == 0) goto L_0x0165
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x054a }
            if (r10 != 0) goto L_0x0165
            r8.zzj((java.lang.String) r6)     // Catch:{ all -> 0x054a }
        L_0x0165:
            java.lang.String r10 = r9.zze()     // Catch:{ all -> 0x054a }
            r8.zzg((java.lang.String) r10)     // Catch:{ all -> 0x054a }
            boolean r10 = r9.zzg()     // Catch:{ all -> 0x054a }
            if (r10 == 0) goto L_0x01d3
            boolean r10 = r7.zzaq()     // Catch:{ all -> 0x054a }
            if (r10 == 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzmw r10 = r1.zzn()     // Catch:{ all -> 0x054a }
            java.lang.String r11 = r7.zzac()     // Catch:{ all -> 0x054a }
            android.util.Pair r10 = r10.zza((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzje) r9)     // Catch:{ all -> 0x054a }
            boolean r11 = r7.zzaq()     // Catch:{ all -> 0x054a }
            if (r11 == 0) goto L_0x01d3
            if (r10 == 0) goto L_0x01d3
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x054a }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x054a }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x054a }
            if (r11 != 0) goto L_0x01d3
            java.lang.Object r11 = r10.first     // Catch:{ SecurityException -> 0x01b7 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ SecurityException -> 0x01b7 }
            long r12 = r0.zzd     // Catch:{ SecurityException -> 0x01b7 }
            java.lang.String r12 = java.lang.Long.toString(r12)     // Catch:{ SecurityException -> 0x01b7 }
            java.lang.String r11 = zza((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ SecurityException -> 0x01b7 }
            r8.zzq(r11)     // Catch:{ SecurityException -> 0x01b7 }
            java.lang.Object r11 = r10.second     // Catch:{ all -> 0x054a }
            if (r11 == 0) goto L_0x01d3
            java.lang.Object r10 = r10.second     // Catch:{ all -> 0x054a }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x054a }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x054a }
            r8.zzc((boolean) r10)     // Catch:{ all -> 0x054a }
            goto L_0x01d3
        L_0x01b7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzc()     // Catch:{ all -> 0x054a }
            java.lang.String r3 = "Resettable device id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x054a }
            r2.zza(r3, r0)     // Catch:{ all -> 0x054a }
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()
            r2.zzu()
            return r0
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzaz r10 = r1.zzf()     // Catch:{ all -> 0x054a }
            r10.zzac()     // Catch:{ all -> 0x054a }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r10 = r8.zzi((java.lang.String) r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzaz r11 = r1.zzf()     // Catch:{ all -> 0x054a }
            r11.zzac()     // Catch:{ all -> 0x054a }
            java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r10 = r10.zzo(r11)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzaz r11 = r1.zzf()     // Catch:{ all -> 0x054a }
            long r11 = r11.zzc()     // Catch:{ all -> 0x054a }
            int r11 = (int) r11     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r10 = r10.zzj((int) r11)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzaz r11 = r1.zzf()     // Catch:{ all -> 0x054a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x054a }
            r10.zzs(r11)     // Catch:{ all -> 0x054a }
            boolean r9 = r9.zzh()     // Catch:{ SecurityException -> 0x052d }
            if (r9 == 0) goto L_0x0228
            java.lang.String r9 = r7.zzad()     // Catch:{ SecurityException -> 0x052d }
            if (r9 == 0) goto L_0x0228
            java.lang.String r9 = r7.zzad()     // Catch:{ SecurityException -> 0x052d }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ SecurityException -> 0x052d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ SecurityException -> 0x052d }
            long r10 = r0.zzd     // Catch:{ SecurityException -> 0x052d }
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ SecurityException -> 0x052d }
            java.lang.String r9 = zza((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ SecurityException -> 0x052d }
            r8.zzc((java.lang.String) r9)     // Catch:{ SecurityException -> 0x052d }
        L_0x0228:
            java.lang.String r9 = r7.zzag()     // Catch:{ all -> 0x054a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x054a }
            if (r9 != 0) goto L_0x023f
            java.lang.String r9 = r7.zzag()     // Catch:{ all -> 0x054a }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x054a }
            r8.zzl((java.lang.String) r9)     // Catch:{ all -> 0x054a }
        L_0x023f:
            java.lang.String r10 = r7.zzac()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r9 = r1.zzh()     // Catch:{ all -> 0x054a }
            java.util.List r9 = r9.zzl(r10)     // Catch:{ all -> 0x054a }
            java.util.Iterator r11 = r9.iterator()     // Catch:{ all -> 0x054a }
        L_0x024f:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x054a }
            if (r12 == 0) goto L_0x0266
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x054a }
            java.lang.String r13 = "_lte"
            java.lang.String r14 = r12.zzc     // Catch:{ all -> 0x054a }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x054a }
            if (r13 == 0) goto L_0x024f
            goto L_0x0267
        L_0x0266:
            r12 = r6
        L_0x0267:
            r17 = 0
            if (r12 == 0) goto L_0x0272
            java.lang.Object r11 = r12.zze     // Catch:{ all -> 0x054a }
            if (r11 != 0) goto L_0x0270
            goto L_0x0272
        L_0x0270:
            r5 = r9
            goto L_0x0299
        L_0x0272:
            r11 = r9
            com.google.android.gms.measurement.internal.zzop r9 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ all -> 0x054a }
            r12 = r11
            java.lang.String r11 = "auto"
            r13 = r12
            java.lang.String r12 = "_lte"
            com.google.android.gms.common.util.Clock r14 = r1.zzb()     // Catch:{ all -> 0x054a }
            long r14 = r14.currentTimeMillis()     // Catch:{ all -> 0x054a }
            r16 = r13
            r13 = r14
            java.lang.Long r15 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x054a }
            r5 = r16
            r9.<init>(r10, r11, r12, r13, r15)     // Catch:{ all -> 0x054a }
            r5.add(r9)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzh()     // Catch:{ all -> 0x054a }
            r10.zza((com.google.android.gms.measurement.internal.zzop) r9)     // Catch:{ all -> 0x054a }
        L_0x0299:
            int r9 = r5.size()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzo[] r9 = new com.google.android.gms.internal.measurement.zzfy.zzo[r9]     // Catch:{ all -> 0x054a }
            r10 = 0
        L_0x02a0:
            int r11 = r5.size()     // Catch:{ all -> 0x054a }
            if (r10 >= r11) goto L_0x02de
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = com.google.android.gms.internal.measurement.zzfy.zzo.zze()     // Catch:{ all -> 0x054a }
            java.lang.Object r12 = r5.get(r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x054a }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x054a }
            java.lang.Object r12 = r5.get(r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x054a }
            long r12 = r12.zzd     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = r11.zzb((long) r12)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzoo r12 = r1.g_()     // Catch:{ all -> 0x054a }
            java.lang.Object r13 = r5.get(r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzop r13 = (com.google.android.gms.measurement.internal.zzop) r13     // Catch:{ all -> 0x054a }
            java.lang.Object r13 = r13.zze     // Catch:{ all -> 0x054a }
            r12.zza((com.google.android.gms.internal.measurement.zzfy.zzo.zza) r11, (java.lang.Object) r13)     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzlc r11 = r11.zzai()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzjt r11 = (com.google.android.gms.internal.measurement.zzjt) r11     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzo r11 = (com.google.android.gms.internal.measurement.zzfy.zzo) r11     // Catch:{ all -> 0x054a }
            r9[r10] = r11     // Catch:{ all -> 0x054a }
            int r10 = r10 + 1
            goto L_0x02a0
        L_0x02de:
            java.util.List r5 = java.util.Arrays.asList(r9)     // Catch:{ all -> 0x054a }
            r8.zze((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzo>) r5)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zznv r5 = r1.zzg     // Catch:{ all -> 0x054a }
            r5.zza((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r8)     // Catch:{ all -> 0x054a }
            boolean r5 = com.google.android.gms.internal.measurement.zzov.zza()     // Catch:{ all -> 0x054a }
            if (r5 == 0) goto L_0x0301
            com.google.android.gms.measurement.internal.zzag r5 = r1.zze()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbh.zzcu     // Catch:{ all -> 0x054a }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r9)     // Catch:{ all -> 0x054a }
            if (r5 == 0) goto L_0x0301
            com.google.android.gms.measurement.internal.zznv r5 = r1.zzg     // Catch:{ all -> 0x054a }
            r5.zzb((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r8)     // Catch:{ all -> 0x054a }
        L_0x0301:
            com.google.android.gms.measurement.internal.zzgs r5 = com.google.android.gms.measurement.internal.zzgs.zza(r0)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x054a }
            android.os.Bundle r10 = r5.zzc     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r11 = r1.zzh()     // Catch:{ all -> 0x054a }
            android.os.Bundle r11 = r11.zzd(r3)     // Catch:{ all -> 0x054a }
            r9.zza((android.os.Bundle) r10, (android.os.Bundle) r11)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x054a }
            int r10 = r10.zzb(r3)     // Catch:{ all -> 0x054a }
            r9.zza((com.google.android.gms.measurement.internal.zzgs) r5, (int) r10)     // Catch:{ all -> 0x054a }
            android.os.Bundle r5 = r5.zzc     // Catch:{ all -> 0x054a }
            java.lang.String r9 = "_c"
            r10 = 1
            r5.putLong(r9, r10)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzc()     // Catch:{ all -> 0x054a }
            java.lang.String r12 = "Marking in-app purchase as real-time"
            r9.zza(r12)     // Catch:{ all -> 0x054a }
            r5.putLong(r2, r10)     // Catch:{ all -> 0x054a }
            java.lang.String r9 = "_o"
            java.lang.String r12 = r0.zzc     // Catch:{ all -> 0x054a }
            r5.putString(r9, r12)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x054a }
            java.lang.String r12 = r8.zzt()     // Catch:{ all -> 0x054a }
            java.lang.String r13 = r7.zzam()     // Catch:{ all -> 0x054a }
            boolean r9 = r9.zzd(r12, r13)     // Catch:{ all -> 0x054a }
            if (r9 == 0) goto L_0x036f
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x054a }
            java.lang.String r12 = "_dbg"
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x054a }
            r9.zza((android.os.Bundle) r5, (java.lang.String) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x054a }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x054a }
            r9.zza((android.os.Bundle) r5, (java.lang.String) r2, (java.lang.Object) r10)     // Catch:{ all -> 0x054a }
        L_0x036f:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()     // Catch:{ all -> 0x054a }
            java.lang.String r9 = r0.zza     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zzd(r3, r9)     // Catch:{ all -> 0x054a }
            if (r2 != 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzbb r2 = new com.google.android.gms.measurement.internal.zzbb     // Catch:{ all -> 0x054a }
            r9 = r4
            java.lang.String r4 = r0.zza     // Catch:{ all -> 0x054a }
            r11 = r9
            long r9 = r0.zzd     // Catch:{ all -> 0x054a }
            r15 = 0
            r16 = 0
            r12 = r5
            r13 = r6
            r5 = 0
            r14 = r7
            r19 = r8
            r7 = 0
            r20 = r11
            r21 = r12
            r11 = 0
            r22 = r13
            r13 = 0
            r23 = r14
            r14 = 0
            r25 = r19
            r24 = r20
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r14, r15, r16)     // Catch:{ all -> 0x054a }
            r9 = r17
            goto L_0x03b8
        L_0x03a5:
            r24 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r25 = r8
            long r3 = r2.zzf     // Catch:{ all -> 0x054a }
            long r5 = r0.zzd     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r5)     // Catch:{ all -> 0x054a }
            r9 = r3
        L_0x03b8:
            r12 = r2
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()     // Catch:{ all -> 0x054a }
            r2.zza((com.google.android.gms.measurement.internal.zzbb) r12)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzbc r2 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzhy r3 = r1.zzu     // Catch:{ all -> 0x054a }
            java.lang.String r4 = r0.zzc     // Catch:{ all -> 0x054a }
            java.lang.String r6 = r0.zza     // Catch:{ all -> 0x054a }
            long r7 = r0.zzd     // Catch:{ all -> 0x054a }
            r5 = r28
            r11 = r21
            r2.<init>((com.google.android.gms.measurement.internal.zzhy) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)     // Catch:{ all -> 0x054a }
            r3 = r5
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch:{ all -> 0x054a }
            long r5 = r2.zzd     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = r4.zzb((long) r5)     // Catch:{ all -> 0x054a }
            java.lang.String r5 = r2.zzb     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x054a }
            long r5 = r2.zze     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = r4.zza((long) r5)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzbe r5 = r2.zzf     // Catch:{ all -> 0x054a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x054a }
        L_0x03ee:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x054a }
            if (r6 == 0) goto L_0x0415
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x054a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r7 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r7 = r7.zza((java.lang.String) r6)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzbe r8 = r2.zzf     // Catch:{ all -> 0x054a }
            java.lang.Object r6 = r8.zzc(r6)     // Catch:{ all -> 0x054a }
            if (r6 == 0) goto L_0x03ee
            com.google.android.gms.measurement.internal.zzoo r8 = r1.g_()     // Catch:{ all -> 0x054a }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh.zza) r7, (java.lang.Object) r6)     // Catch:{ all -> 0x054a }
            r4.zza((com.google.android.gms.internal.measurement.zzfy.zzh.zza) r7)     // Catch:{ all -> 0x054a }
            goto L_0x03ee
        L_0x0415:
            r2 = r25
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r5 = r2.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r4)     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzl$zza r6 = com.google.android.gms.internal.measurement.zzfy.zzl.zza()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzg$zza r7 = com.google.android.gms.internal.measurement.zzfy.zzg.zza()     // Catch:{ all -> 0x054a }
            long r8 = r12.zzc     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzg$zza r7 = r7.zza((long) r8)     // Catch:{ all -> 0x054a }
            java.lang.String r0 = r0.zza     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzg$zza r0 = r7.zza((java.lang.String) r0)     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzl$zza r0 = r6.zza(r0)     // Catch:{ all -> 0x054a }
            r5.zza((com.google.android.gms.internal.measurement.zzfy.zzl.zza) r0)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzt r6 = r1.zzg()     // Catch:{ all -> 0x054a }
            java.lang.String r7 = r23.zzac()     // Catch:{ all -> 0x054a }
            java.util.List r8 = java.util.Collections.emptyList()     // Catch:{ all -> 0x054a }
            java.util.List r9 = r2.zzab()     // Catch:{ all -> 0x054a }
            long r10 = r4.zzc()     // Catch:{ all -> 0x054a }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x054a }
            long r11 = r4.zzc()     // Catch:{ all -> 0x054a }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x054a }
            java.util.List r0 = r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x054a }
            r2.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzd>) r0)     // Catch:{ all -> 0x054a }
            boolean r0 = r4.zzg()     // Catch:{ all -> 0x054a }
            if (r0 == 0) goto L_0x0472
            long r5 = r4.zzc()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = r2.zzi((long) r5)     // Catch:{ all -> 0x054a }
            long r4 = r4.zzc()     // Catch:{ all -> 0x054a }
            r0.zze((long) r4)     // Catch:{ all -> 0x054a }
        L_0x0472:
            long r4 = r23.zzs()     // Catch:{ all -> 0x054a }
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x047d
            r2.zzg((long) r4)     // Catch:{ all -> 0x054a }
        L_0x047d:
            long r6 = r23.zzu()     // Catch:{ all -> 0x054a }
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x0489
            r2.zzh((long) r6)     // Catch:{ all -> 0x054a }
            goto L_0x048e
        L_0x0489:
            if (r0 == 0) goto L_0x048e
            r2.zzh((long) r4)     // Catch:{ all -> 0x054a }
        L_0x048e:
            java.lang.String r0 = r23.zzal()     // Catch:{ all -> 0x054a }
            boolean r4 = com.google.android.gms.internal.measurement.zzpo.zza()     // Catch:{ all -> 0x054a }
            if (r4 == 0) goto L_0x04a9
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzbw     // Catch:{ all -> 0x054a }
            boolean r4 = r4.zze(r3, r5)     // Catch:{ all -> 0x054a }
            if (r4 == 0) goto L_0x04a9
            if (r0 == 0) goto L_0x04a9
            r2.zzr(r0)     // Catch:{ all -> 0x054a }
        L_0x04a9:
            r23.zzap()     // Catch:{ all -> 0x054a }
            long r4 = r23.zzt()     // Catch:{ all -> 0x054a }
            int r0 = (int) r4     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = r2.zzf((int) r0)     // Catch:{ all -> 0x054a }
            r4 = 106000(0x19e10, double:5.2371E-319)
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = r0.zzl((long) r4)     // Catch:{ all -> 0x054a }
            com.google.android.gms.common.util.Clock r4 = r1.zzb()     // Catch:{ all -> 0x054a }
            long r4 = r4.currentTimeMillis()     // Catch:{ all -> 0x054a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = r0.zzk((long) r4)     // Catch:{ all -> 0x054a }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x054a }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x054a }
            r0.zzd((boolean) r4)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zznv r0 = r1.zzg     // Catch:{ all -> 0x054a }
            java.lang.String r4 = r2.zzt()     // Catch:{ all -> 0x054a }
            r0.zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r2)     // Catch:{ all -> 0x054a }
            r9 = r24
            r9.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r2)     // Catch:{ all -> 0x054a }
            long r4 = r2.zzf()     // Catch:{ all -> 0x054a }
            r14 = r23
            r14.zzr(r4)     // Catch:{ all -> 0x054a }
            long r4 = r2.zze()     // Catch:{ all -> 0x054a }
            r14.zzp(r4)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzh()     // Catch:{ all -> 0x054a }
            r2 = 0
            r0.zza((com.google.android.gms.measurement.internal.zzg) r14, (boolean) r2, (boolean) r2)     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzh()     // Catch:{ all -> 0x054a }
            r0.zzw()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzh()
            r0.zzu()
            com.google.android.gms.measurement.internal.zzoo r0 = r1.g_()     // Catch:{ IOException -> 0x051a }
            com.google.android.gms.internal.measurement.zzlc r2 = r9.zzai()     // Catch:{ IOException -> 0x051a }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ IOException -> 0x051a }
            com.google.android.gms.internal.measurement.zzfy$zzj r2 = (com.google.android.gms.internal.measurement.zzfy.zzj) r2     // Catch:{ IOException -> 0x051a }
            byte[] r2 = r2.zzca()     // Catch:{ IOException -> 0x051a }
            byte[] r0 = r0.zzb((byte[]) r2)     // Catch:{ IOException -> 0x051a }
            return r0
        L_0x051a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()
            java.lang.String r4 = "Data loss. Failed to bundle and serialize. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r3)
            r2.zza(r4, r3, r0)
            return r22
        L_0x052d:
            r0 = move-exception
            r2 = r5
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj()     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzc()     // Catch:{ all -> 0x054a }
            java.lang.String r4 = "app instance id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x054a }
            r3.zza(r4, r0)     // Catch:{ all -> 0x054a }
            byte[] r0 = new byte[r2]     // Catch:{ all -> 0x054a }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()
            r2.zzu()
            return r0
        L_0x054a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzh()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zza(com.google.android.gms.measurement.internal.zzbf, java.lang.String):byte[]");
    }
}
