package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcrd implements zzcya, zzcxg {
    private final Context zza;
    private final zzcfk zzb;
    private final zzfet zzc;
    private final VersionInfoParcel zzd;
    private zzeew zze;
    private boolean zzf;
    private final zzeeu zzg;

    public zzcrd(Context context, zzcfk zzcfk, zzfet zzfet, VersionInfoParcel versionInfoParcel, zzeeu zzeeu) {
        this.zza = context;
        this.zzb = zzcfk;
        this.zzc = zzfet;
        this.zzd = versionInfoParcel;
        this.zzg = zzeeu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza() {
        /*
            r12 = this;
            monitor-enter(r12)
            com.google.android.gms.internal.ads.zzfet r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            boolean r0 = r0.zzT     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x0009
            goto L_0x00e0
        L_0x0009:
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x00e0
            android.content.Context r0 = r12.zza     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeer r1 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            boolean r0 = r1.zzl(r0)     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x00e0
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r12.zzd     // Catch:{ all -> 0x00e2 }
            int r1 = r0.buddyApkVersion     // Catch:{ all -> 0x00e2 }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r2.<init>()     // Catch:{ all -> 0x00e2 }
            r2.append(r1)     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ all -> 0x00e2 }
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzfet r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzffr r0 = r0.zzV     // Catch:{ all -> 0x00e2 }
            java.lang.String r8 = r0.zza()     // Catch:{ all -> 0x00e2 }
            int r0 = r0.zzc()     // Catch:{ all -> 0x00e2 }
            r1 = 1
            if (r0 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzees r0 = com.google.android.gms.internal.ads.zzees.VIDEO     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeet r2 = com.google.android.gms.internal.ads.zzeet.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00e2 }
            r10 = r0
            r9 = r2
            goto L_0x0058
        L_0x0049:
            com.google.android.gms.internal.ads.zzfet r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzees r2 = com.google.android.gms.internal.ads.zzees.HTML_DISPLAY     // Catch:{ all -> 0x00e2 }
            int r0 = r0.zze     // Catch:{ all -> 0x00e2 }
            if (r0 != r1) goto L_0x0054
            com.google.android.gms.internal.ads.zzeet r0 = com.google.android.gms.internal.ads.zzeet.ONE_PIXEL     // Catch:{ all -> 0x00e2 }
            goto L_0x0056
        L_0x0054:
            com.google.android.gms.internal.ads.zzeet r0 = com.google.android.gms.internal.ads.zzeet.BEGIN_TO_RENDER     // Catch:{ all -> 0x00e2 }
        L_0x0056:
            r9 = r0
            r10 = r2
        L_0x0058:
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzfet r2 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeer r3 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00e2 }
            java.lang.String r11 = r2.zzal     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.internal.ads.zzeew r0 = r3.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00e2 }
            r12.zze = r0     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            android.view.View r0 = r0.zzF()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeew r2 = r12.zze     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzfmw r2 = r2.zza()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzfd     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00e2 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00bb
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeer r3 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            android.webkit.WebView r0 = r0.zzG()     // Catch:{ all -> 0x00e2 }
            r3.zzj(r2, r0)     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            java.util.List r0 = r0.zzV()     // Catch:{ all -> 0x00e2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00e2 }
        L_0x00a7:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00e2 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeer r4 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            r4.zzg(r2, r3)     // Catch:{ all -> 0x00e2 }
            goto L_0x00a7
        L_0x00bb:
            com.google.android.gms.internal.ads.zzeer r3 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            r3.zzj(r2, r0)     // Catch:{ all -> 0x00e2 }
        L_0x00c2:
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeew r3 = r12.zze     // Catch:{ all -> 0x00e2 }
            r0.zzat(r3)     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzeer r0 = com.google.android.gms.ads.internal.zzv.zzB()     // Catch:{ all -> 0x00e2 }
            r0.zzk(r2)     // Catch:{ all -> 0x00e2 }
            r12.zzf = r1     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzcfk r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00e2 }
            r1.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = "onSdkLoaded"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x00e2 }
            monitor-exit(r12)
            return
        L_0x00e0:
            monitor-exit(r12)
            return
        L_0x00e2:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00e2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrd.zza():void");
    }

    private final boolean zzb() {
        return ((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && this.zzg.zzd();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzb()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzeeu r0 = r3.zzg     // Catch:{ all -> 0x0031 }
            r0.zzb()     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0015
            r3.zza()     // Catch:{ all -> 0x0031 }
        L_0x0015:
            com.google.android.gms.internal.ads.zzfet r0 = r3.zzc     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.zzT     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzeew r0 = r3.zze     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcfk r0 = r3.zzb     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0031 }
            r1.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrd.zzr():void");
    }

    public final synchronized void zzs() {
        if (zzb()) {
            this.zzg.zzc();
        } else if (!this.zzf) {
            zza();
        }
    }
}
