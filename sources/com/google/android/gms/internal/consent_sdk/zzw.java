package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
final class zzw {
    private final zzx zza;
    private final zzck zzb;
    private int zzc = 0;
    private ConsentInformation.PrivacyOptionsRequirementStatus zzd = ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN;

    zzw(zzx zzx, zzck zzck) {
        this.zza = zzx;
        this.zzb = zzck;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.consent_sdk.zzz zza() throws com.google.android.gms.internal.consent_sdk.zzg {
        /*
            r11 = this;
            com.google.android.gms.internal.consent_sdk.zzck r0 = r11.zzb
            int r0 = r0.zzf
            r1 = 8
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x000c
            r1 = r3
            goto L_0x000d
        L_0x000c:
            r1 = r2
        L_0x000d:
            com.google.android.gms.internal.consent_sdk.zzx r4 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzap r4 = r4.zzc
            r4.zzh(r1)
            int r1 = r0 + -1
            r4 = 0
            if (r0 == 0) goto L_0x00dc
            java.lang.String r0 = "Invalid response from server."
            r5 = 3
            r6 = 2
            switch(r1) {
                case 1: goto L_0x0056;
                case 2: goto L_0x0056;
                case 3: goto L_0x0056;
                case 4: goto L_0x0053;
                case 5: goto L_0x0050;
                case 6: goto L_0x003c;
                case 7: goto L_0x0028;
                default: goto L_0x0022;
            }
        L_0x0022:
            com.google.android.gms.internal.consent_sdk.zzg r1 = new com.google.android.gms.internal.consent_sdk.zzg
            r1.<init>(r3, r0)
            throw r1
        L_0x0028:
            com.google.android.gms.internal.consent_sdk.zzck r0 = r11.zzb
            com.google.android.gms.internal.consent_sdk.zzg r1 = new com.google.android.gms.internal.consent_sdk.zzg
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Publisher misconfiguration: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r5, r0)
            throw r1
        L_0x003c:
            com.google.android.gms.internal.consent_sdk.zzck r0 = r11.zzb
            com.google.android.gms.internal.consent_sdk.zzg r1 = new com.google.android.gms.internal.consent_sdk.zzg
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Invalid response from server: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r3, r0)
            throw r1
        L_0x0050:
            r11.zzc = r3
            goto L_0x0058
        L_0x0053:
            r11.zzc = r6
            goto L_0x0058
        L_0x0056:
            r11.zzc = r5
        L_0x0058:
            com.google.android.gms.internal.consent_sdk.zzck r1 = r11.zzb
            int r1 = r1.zzg
            int r5 = r1 + -1
            if (r1 == 0) goto L_0x00db
            if (r5 == r3) goto L_0x006f
            if (r5 != r6) goto L_0x0069
            com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r0 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED
            r11.zzd = r0
            goto L_0x0073
        L_0x0069:
            com.google.android.gms.internal.consent_sdk.zzg r1 = new com.google.android.gms.internal.consent_sdk.zzg
            r1.<init>(r3, r0)
            throw r1
        L_0x006f:
            com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r0 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED
            r11.zzd = r0
        L_0x0073:
            com.google.android.gms.internal.consent_sdk.zzck r0 = r11.zzb
            java.lang.String r1 = r0.zza
            if (r1 != 0) goto L_0x007b
            r5 = r4
            goto L_0x0082
        L_0x007b:
            com.google.android.gms.internal.consent_sdk.zzbp r5 = new com.google.android.gms.internal.consent_sdk.zzbp
            java.lang.String r7 = r0.zzb
            r5.<init>(r7, r1)
        L_0x0082:
            com.google.android.gms.internal.consent_sdk.zzx r1 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzap r1 = r1.zzc
            java.util.HashSet r7 = new java.util.HashSet
            java.util.List r0 = r0.zzd
            r7.<init>(r0)
            r1.zzj(r7)
            com.google.android.gms.internal.consent_sdk.zzck r0 = r11.zzb
            java.util.List r0 = r0.zze
            java.util.Iterator r0 = r0.iterator()
        L_0x009a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d1
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.consent_sdk.zzcj r1 = (com.google.android.gms.internal.consent_sdk.zzcj) r1
            int r7 = r1.zzb
            int r8 = r7 + -1
            if (r7 == 0) goto L_0x00d0
            if (r8 == 0) goto L_0x00b9
            if (r8 == r3) goto L_0x00b6
            if (r8 == r6) goto L_0x00b3
            goto L_0x00b9
        L_0x00b3:
            java.lang.String r7 = "clear"
            goto L_0x00ba
        L_0x00b6:
            java.lang.String r7 = "write"
            goto L_0x00ba
        L_0x00b9:
            r7 = r4
        L_0x00ba:
            if (r7 == 0) goto L_0x009a
            com.google.android.gms.internal.consent_sdk.zzx r8 = r11.zza
            com.google.android.gms.internal.consent_sdk.zze r9 = r8.zza
            java.lang.String r1 = r1.zza
            com.google.android.gms.internal.consent_sdk.zzd[] r10 = new com.google.android.gms.internal.consent_sdk.zzd[r3]
            com.google.android.gms.internal.consent_sdk.zzan r8 = r8.zzb
            r10[r2] = r8
            r9.zzb(r7, r1, r10)
            goto L_0x009a
        L_0x00d0:
            throw r4
        L_0x00d1:
            com.google.android.gms.internal.consent_sdk.zzz r0 = new com.google.android.gms.internal.consent_sdk.zzz
            int r1 = r11.zzc
            com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r2 = r11.zzd
            r0.<init>(r1, r2, r5, r4)
            return r0
        L_0x00db:
            throw r4
        L_0x00dc:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzw.zza():com.google.android.gms.internal.consent_sdk.zzz");
    }
}
