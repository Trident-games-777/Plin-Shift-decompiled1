package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzedg extends zzeec {
    private final Activity zza;
    private final zzm zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzedg(Activity activity, zzm zzm, String str, String str2, zzedf zzedf) {
        this.zza = activity;
        this.zzb = zzm;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r1 = r4.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.ads.zzeec
            r2 = 0
            if (r1 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzeec r5 = (com.google.android.gms.internal.ads.zzeec) r5
            android.app.Activity r1 = r4.zza
            android.app.Activity r3 = r5.zza()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0058
            com.google.android.gms.ads.internal.overlay.zzm r1 = r4.zzb
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.zzm r1 = r5.zzb()
            if (r1 != 0) goto L_0x0058
            goto L_0x002c
        L_0x0022:
            com.google.android.gms.ads.internal.overlay.zzm r3 = r5.zzb()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0058
        L_0x002c:
            java.lang.String r1 = r4.zzc
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = r5.zzc()
            if (r1 != 0) goto L_0x0058
            goto L_0x0041
        L_0x0037:
            java.lang.String r3 = r5.zzc()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0058
        L_0x0041:
            java.lang.String r1 = r4.zzd
            if (r1 != 0) goto L_0x004c
            java.lang.String r5 = r5.zzd()
            if (r5 != 0) goto L_0x0058
            goto L_0x0057
        L_0x004c:
            java.lang.String r5 = r5.zzd()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            return r0
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedg.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzm zzm = this.zzb;
        int i3 = 0;
        if (zzm == null) {
            i = 0;
        } else {
            i = zzm.hashCode();
        }
        int i4 = ((hashCode * 1000003) ^ i) * 1000003;
        String str = this.zzc;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i5 = (i4 ^ i2) * 1000003;
        String str2 = this.zzd;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i5 ^ i3;
    }

    public final String toString() {
        zzm zzm = this.zzb;
        String obj = this.zza.toString();
        String valueOf = String.valueOf(zzm);
        return "OfflineUtilsParams{activity=" + obj + ", adOverlay=" + valueOf + ", gwsQueryId=" + this.zzc + ", uri=" + this.zzd + "}";
    }

    public final Activity zza() {
        return this.zza;
    }

    public final zzm zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
