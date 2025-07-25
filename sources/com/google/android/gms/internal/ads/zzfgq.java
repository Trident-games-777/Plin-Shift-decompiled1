package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzaz;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfgq {
    public static zze zza(Throwable th) {
        if (th instanceof zzeff) {
            zzeff zzeff = (zzeff) th;
            return zzc(zzeff.zza(), zzeff.zzb());
        } else if (th instanceof zzdwn) {
            if (th.getMessage() == null) {
                return zzd(((zzdwn) th).zza(), (String) null, (zze) null);
            }
            return zzd(((zzdwn) th).zza(), th.getMessage(), (zze) null);
        } else if (!(th instanceof zzaz)) {
            return zzd(1, (String) null, (zze) null);
        } else {
            zzaz zzaz = (zzaz) th;
            return new zze(zzaz.zza(), zzfxf.zzc(zzaz.getMessage()), MobileAds.ERROR_DOMAIN, (zze) null, (IBinder) null);
        }
    }

    public static zze zzb(Throwable th, zzefg zzefg) {
        zze zze;
        zze zza = zza(th);
        int i = zza.zza;
        if ((i == 3 || i == 0) && (zze = zza.zzd) != null && !zze.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            zza.zzd = null;
        }
        if (zzefg != null) {
            zza.zze = zzefg.zzb();
        }
        return zza;
    }

    public static zze zzc(int i, zze zze) {
        if (i != 0) {
            if (i == 8) {
                if (((Integer) zzbe.zzc().zza(zzbcn.zzhU)).intValue() > 0) {
                    return zze;
                }
                i = 8;
            }
            return zzd(i, (String) null, zze);
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0086, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0088, code lost:
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        return new com.google.android.gms.ads.internal.client.zze(r3, r4, com.google.android.gms.ads.MobileAds.ERROR_DOMAIN, r10, (android.os.IBinder) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.client.zze zzd(int r8, java.lang.String r9, com.google.android.gms.ads.internal.client.zze r10) {
        /*
            int r0 = r8 + -1
            r1 = 0
            if (r9 != 0) goto L_0x0052
            if (r8 == 0) goto L_0x0051
            java.lang.String r9 = "No fill."
            switch(r0) {
                case 1: goto L_0x004e;
                case 2: goto L_0x0052;
                case 3: goto L_0x004b;
                case 4: goto L_0x0048;
                case 5: goto L_0x0045;
                case 6: goto L_0x0042;
                case 7: goto L_0x003f;
                case 8: goto L_0x003c;
                case 9: goto L_0x0039;
                case 10: goto L_0x0036;
                case 11: goto L_0x000c;
                case 12: goto L_0x0021;
                case 13: goto L_0x001e;
                case 14: goto L_0x001b;
                case 15: goto L_0x0018;
                case 16: goto L_0x0015;
                case 17: goto L_0x0012;
                case 18: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.String r9 = "Internal error."
            goto L_0x0052
        L_0x000f:
            java.lang.String r9 = "Ad inspector cannot be opened because it is already open."
            goto L_0x0052
        L_0x0012:
            java.lang.String r9 = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information."
            goto L_0x0052
        L_0x0015:
            java.lang.String r9 = "Ad inspector failed to load."
            goto L_0x0052
        L_0x0018:
            java.lang.String r9 = "Ad inspector had an internal error."
            goto L_0x0052
        L_0x001b:
            java.lang.String r9 = "Invalid ad string."
            goto L_0x0052
        L_0x001e:
            java.lang.String r9 = "Mismatch request IDs."
            goto L_0x0052
        L_0x0021:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzhX
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 > 0) goto L_0x0052
            java.lang.String r9 = "The mediation adapter did not return an ad."
            goto L_0x0052
        L_0x0036:
            java.lang.String r9 = "The ad can not be shown when app is not in foreground."
            goto L_0x0052
        L_0x0039:
            java.lang.String r9 = "The ad has already been shown."
            goto L_0x0052
        L_0x003c:
            java.lang.String r9 = "The ad is not ready."
            goto L_0x0052
        L_0x003f:
            java.lang.String r9 = "A mediation adapter failed to show the ad."
            goto L_0x0052
        L_0x0042:
            java.lang.String r9 = "Invalid request: Invalid ad size."
            goto L_0x0052
        L_0x0045:
            java.lang.String r9 = "Invalid request: Invalid ad unit ID."
            goto L_0x0052
        L_0x0048:
            java.lang.String r9 = "Network error."
            goto L_0x0052
        L_0x004b:
            java.lang.String r9 = "App ID missing."
            goto L_0x0052
        L_0x004e:
            java.lang.String r9 = "Invalid request."
            goto L_0x0052
        L_0x0051:
            throw r1
        L_0x0052:
            r4 = r9
            com.google.android.gms.ads.internal.client.zze r2 = new com.google.android.gms.ads.internal.client.zze
            if (r8 == 0) goto L_0x00d2
            r9 = 2
            r1 = 1
            r3 = 0
            r5 = 3
            switch(r0) {
                case 0: goto L_0x008b;
                case 1: goto L_0x008a;
                case 2: goto L_0x0088;
                case 3: goto L_0x0084;
                case 4: goto L_0x0086;
                case 5: goto L_0x008a;
                case 6: goto L_0x008a;
                case 7: goto L_0x0082;
                case 8: goto L_0x0086;
                case 9: goto L_0x008a;
                case 10: goto L_0x0088;
                case 11: goto L_0x008b;
                case 12: goto L_0x006d;
                case 13: goto L_0x006a;
                case 14: goto L_0x0067;
                case 15: goto L_0x008b;
                case 16: goto L_0x008a;
                case 17: goto L_0x0086;
                case 18: goto L_0x0088;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            switch(r8) {
                case 1: goto L_0x00c6;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00b1;
                case 9: goto L_0x00ae;
                case 10: goto L_0x00ab;
                case 11: goto L_0x00a8;
                case 12: goto L_0x00a5;
                case 13: goto L_0x00a2;
                case 14: goto L_0x009f;
                case 15: goto L_0x009c;
                case 16: goto L_0x0099;
                case 17: goto L_0x0096;
                case 18: goto L_0x0093;
                default: goto L_0x0063;
            }
        L_0x0063:
            java.lang.String r8 = "AD_INSPECTOR_ALREADY_OPEN"
            goto L_0x00c8
        L_0x0067:
            r9 = 11
            goto L_0x0086
        L_0x006a:
            r9 = 10
            goto L_0x0086
        L_0x006d:
            com.google.android.gms.internal.ads.zzbce r8 = com.google.android.gms.internal.ads.zzbcn.zzhX
            com.google.android.gms.internal.ads.zzbcl r9 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r8 = r9.zza(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 > 0) goto L_0x0088
            r9 = 9
            goto L_0x0086
        L_0x0082:
            r9 = 4
            goto L_0x0086
        L_0x0084:
            r9 = 8
        L_0x0086:
            r3 = r9
            goto L_0x008b
        L_0x0088:
            r3 = r5
            goto L_0x008b
        L_0x008a:
            r3 = r1
        L_0x008b:
            java.lang.String r5 = "com.google.android.gms.ads"
            r7 = 0
            r6 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        L_0x0093:
            java.lang.String r8 = "AD_INSPECTOR_NOT_IN_TEST_MODE"
            goto L_0x00c8
        L_0x0096:
            java.lang.String r8 = "AD_INSPECTOR_FAILED_TO_LOAD"
            goto L_0x00c8
        L_0x0099:
            java.lang.String r8 = "AD_INSPECTOR_INTERNAL_ERROR"
            goto L_0x00c8
        L_0x009c:
            java.lang.String r8 = "INVALID_AD_STRING"
            goto L_0x00c8
        L_0x009f:
            java.lang.String r8 = "REQUEST_ID_MISMATCH"
            goto L_0x00c8
        L_0x00a2:
            java.lang.String r8 = "MEDIATION_NO_FILL"
            goto L_0x00c8
        L_0x00a5:
            java.lang.String r8 = "INTERNAL_SHOW_ERROR"
            goto L_0x00c8
        L_0x00a8:
            java.lang.String r8 = "APP_NOT_FOREGROUND"
            goto L_0x00c8
        L_0x00ab:
            java.lang.String r8 = "AD_REUSED"
            goto L_0x00c8
        L_0x00ae:
            java.lang.String r8 = "NOT_READY"
            goto L_0x00c8
        L_0x00b1:
            java.lang.String r8 = "MEDIATION_SHOW_ERROR"
            goto L_0x00c8
        L_0x00b4:
            java.lang.String r8 = "INVALID_AD_SIZE"
            goto L_0x00c8
        L_0x00b7:
            java.lang.String r8 = "INVALID_AD_UNIT_ID"
            goto L_0x00c8
        L_0x00ba:
            java.lang.String r8 = "NETWORK_ERROR"
            goto L_0x00c8
        L_0x00bd:
            java.lang.String r8 = "APP_ID_MISSING"
            goto L_0x00c8
        L_0x00c0:
            java.lang.String r8 = "NO_FILL"
            goto L_0x00c8
        L_0x00c3:
            java.lang.String r8 = "INVALID_REQUEST"
            goto L_0x00c8
        L_0x00c6:
            java.lang.String r8 = "INTERNAL_ERROR"
        L_0x00c8:
            java.lang.String r10 = "Unknown SdkError: "
            java.lang.String r8 = r10.concat(r8)
            r9.<init>(r8)
            throw r9
        L_0x00d2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgq.zzd(int, java.lang.String, com.google.android.gms.ads.internal.client.zze):com.google.android.gms.ads.internal.client.zze");
    }
}
