package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzejx implements zzdgv {
    private final Context zza;
    private final zzdpn zzb;
    private final zzffo zzc;
    private final VersionInfoParcel zzd;
    private final zzfet zze;
    private final ListenableFuture zzf;
    private final zzcfk zzg;
    private final zzbju zzh;
    private final boolean zzi;
    private final zzeea zzj;
    private final zzdsh zzk;

    zzejx(Context context, zzdpn zzdpn, zzffo zzffo, VersionInfoParcel versionInfoParcel, zzfet zzfet, ListenableFuture listenableFuture, zzcfk zzcfk, zzbju zzbju, boolean z, zzeea zzeea, zzdsh zzdsh) {
        this.zza = context;
        this.zzb = zzdpn;
        this.zzc = zzffo;
        this.zzd = versionInfoParcel;
        this.zze = zzfet;
        this.zzf = listenableFuture;
        this.zzg = zzcfk;
        this.zzh = zzbju;
        this.zzi = z;
        this.zzj = zzeea;
        this.zzk = zzdsh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzcwz r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.common.util.concurrent.ListenableFuture r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgei.zzq(r0)
            com.google.android.gms.internal.ads.zzdos r0 = (com.google.android.gms.internal.ads.zzdos) r0
            com.google.android.gms.internal.ads.zzfet r2 = r1.zze     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzcfk r3 = r1.zzg     // Catch:{ zzcfw -> 0x010a }
            boolean r3 = r3.zzaG()     // Catch:{ zzcfw -> 0x010a }
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzg     // Catch:{ zzcfw -> 0x010a }
        L_0x0018:
            r11 = r2
            goto L_0x0088
        L_0x001a:
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzaU     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzcfw -> 0x010a }
            java.lang.Object r3 = r6.zza(r3)     // Catch:{ zzcfw -> 0x010a }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcfw -> 0x010a }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcfw -> 0x010a }
            if (r3 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzg     // Catch:{ zzcfw -> 0x010a }
            goto L_0x0018
        L_0x002f:
            com.google.android.gms.internal.ads.zzdpn r3 = r1.zzb     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzffo r6 = r1.zzc     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.ads.internal.client.zzs r6 = r6.zze     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzcfk r3 = r3.zza(r6, r5, r5)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzdeu r6 = r0.zzg()     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzbkj.zzb(r3, r6)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzdpr r6 = new com.google.android.gms.internal.ads.zzdpr     // Catch:{ zzcfw -> 0x010a }
            r6.<init>()     // Catch:{ zzcfw -> 0x010a }
            android.content.Context r7 = r1.zza     // Catch:{ zzcfw -> 0x010a }
            android.view.View r8 = r3.zzF()     // Catch:{ zzcfw -> 0x010a }
            r6.zza(r7, r8)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzdpm r7 = r0.zzl()     // Catch:{ zzcfw -> 0x010a }
            boolean r8 = r1.zzi     // Catch:{ zzcfw -> 0x010a }
            if (r8 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzbju r8 = r1.zzh     // Catch:{ zzcfw -> 0x010a }
            goto L_0x005a
        L_0x0059:
            r8 = r5
        L_0x005a:
            com.google.android.gms.internal.ads.zzdsh r9 = r1.zzk     // Catch:{ zzcfw -> 0x010a }
            android.os.Bundle r9 = r9.zza()     // Catch:{ zzcfw -> 0x010a }
            r7.zzi(r3, r4, r8, r9)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzchc r7 = r3.zzN()     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzejv r8 = new com.google.android.gms.internal.ads.zzejv     // Catch:{ zzcfw -> 0x010a }
            r8.<init>(r6, r3)     // Catch:{ zzcfw -> 0x010a }
            r7.zzB(r8)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzchc r6 = r3.zzN()     // Catch:{ zzcfw -> 0x010a }
            java.util.Objects.requireNonNull(r3)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzejw r7 = new com.google.android.gms.internal.ads.zzejw     // Catch:{ zzcfw -> 0x010a }
            r7.<init>(r3)     // Catch:{ zzcfw -> 0x010a }
            r6.zzI(r7)     // Catch:{ zzcfw -> 0x010a }
            com.google.android.gms.internal.ads.zzfey r2 = r2.zzs     // Catch:{ zzcfw -> 0x010a }
            java.lang.String r6 = r2.zzb     // Catch:{ zzcfw -> 0x010a }
            java.lang.String r2 = r2.zza     // Catch:{ zzcfw -> 0x010a }
            r3.zzae(r6, r2, r5)     // Catch:{ zzcfw -> 0x010a }
            r11 = r3
        L_0x0088:
            r11.zzaq(r4)
            boolean r2 = r1.zzi
            com.google.android.gms.ads.internal.zzl r12 = new com.google.android.gms.ads.internal.zzl
            r3 = 0
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzbju r2 = r1.zzh
            boolean r2 = r2.zze(r3)
            r13 = r2
            goto L_0x009b
        L_0x009a:
            r13 = r3
        L_0x009b:
            com.google.android.gms.ads.internal.zzv.zzq()
            android.content.Context r2 = r1.zza
            boolean r6 = r1.zzi
            boolean r14 = com.google.android.gms.ads.internal.util.zzs.zzI(r2)
            if (r6 == 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzbju r2 = r1.zzh
            boolean r3 = r2.zzd()
        L_0x00ae:
            r15 = r3
            boolean r2 = r1.zzi
            if (r2 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzbju r2 = r1.zzh
            float r2 = r2.zza()
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            r16 = r2
            com.google.android.gms.internal.ads.zzfet r2 = r1.zze
            boolean r3 = r2.zzO
            boolean r2 = r2.zzP
            r17 = -1
            r18 = r22
            r20 = r2
            r19 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00d3
            r24.zzf()
        L_0x00d3:
            com.google.android.gms.ads.internal.zzv.zzj()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r7 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdgk r9 = r0.zzh()
            com.google.android.gms.internal.ads.zzfet r0 = r1.zze
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r1.zzd
            r15 = r12
            int r12 = r0.zzQ
            java.lang.String r14 = r0.zzB
            com.google.android.gms.internal.ads.zzfey r2 = r0.zzs
            java.lang.String r3 = r2.zzb
            java.lang.String r2 = r2.zza
            com.google.android.gms.internal.ads.zzffo r6 = r1.zzc
            boolean r0 = r0.zzai
            if (r0 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzeea r5 = r1.zzj
        L_0x00f3:
            r20 = r5
            r10 = 0
            java.lang.String r0 = r6.zzf
            r8 = 0
            r19 = r24
            r18 = r0
            r17 = r2
            r16 = r3
            r7.<init>((com.google.android.gms.ads.internal.client.zza) r8, (com.google.android.gms.ads.internal.overlay.zzr) r9, (com.google.android.gms.ads.internal.overlay.zzac) r10, (com.google.android.gms.internal.ads.zzcfk) r11, (int) r12, (com.google.android.gms.ads.internal.util.client.VersionInfoParcel) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzl) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzcwz) r19, (com.google.android.gms.internal.ads.zzbsz) r20)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzn.zza(r0, r7, r4)
            return
        L_0x010a:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejx.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzcwz):void");
    }
}
