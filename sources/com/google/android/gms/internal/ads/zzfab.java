package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfab implements zzeni {
    protected final zzchk zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzfar zzd;
    /* access modifiers changed from: private */
    public final zzfck zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    /* access modifiers changed from: private */
    public final zzfko zzh;
    private final zzffm zzi;
    /* access modifiers changed from: private */
    @Nullable
    public ListenableFuture zzj;

    protected zzfab(Context context, Executor executor, zzchk zzchk, zzfck zzfck, zzfar zzfar, zzffm zzffm, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzchk;
        this.zze = zzfck;
        this.zzd = zzfar;
        this.zzi = zzffm;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzchk.zzz();
    }

    /* access modifiers changed from: private */
    public final synchronized zzcvs zzm(zzfci zzfci) {
        zzezz zzezz = (zzezz) zzfci;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhP)).booleanValue()) {
            zzcpa zzcpa = new zzcpa(this.zzg);
            zzcvu zzcvu = new zzcvu();
            zzcvu.zze(this.zzb);
            zzcvu.zzi(zzezz.zza);
            zzcvw zzj2 = zzcvu.zzj();
            zzdcd zzdcd = new zzdcd();
            zzdcd.zzc(this.zzd, this.zzc);
            zzdcd.zzl(this.zzd, this.zzc);
            return zze(zzcpa, zzj2, zzdcd.zzn());
        }
        zzfar zzi2 = zzfar.zzi(this.zzd);
        zzdcd zzdcd2 = new zzdcd();
        zzdcd2.zzb(zzi2, this.zzc);
        zzdcd2.zzg(zzi2, this.zzc);
        zzdcd2.zzh(zzi2, this.zzc);
        zzdcd2.zzi(zzi2, this.zzc);
        zzdcd2.zzc(zzi2, this.zzc);
        zzdcd2.zzl(zzi2, this.zzc);
        zzdcd2.zzm(zzi2);
        zzcpa zzcpa2 = new zzcpa(this.zzg);
        zzcvu zzcvu2 = new zzcvu();
        zzcvu2.zze(this.zzb);
        zzcvu2.zzi(zzezz.zza);
        return zze(zzcpa2, zzcvu2.zzj(), zzdcd2.zzn());
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3 A[SYNTHETIC, Splitter:B:43:0x00b3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzm r10, java.lang.String r11, com.google.android.gms.internal.ads.zzeng r12, com.google.android.gms.internal.ads.zzenh r13) throws android.os.RemoteException {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r12 = r10.zzb()     // Catch:{ all -> 0x013a }
            r0 = 1
            r1 = 0
            if (r12 == 0) goto L_0x000a
            goto L_0x004a
        L_0x000a:
            com.google.android.gms.internal.ads.zzbdx r12 = com.google.android.gms.internal.ads.zzbel.zzd     // Catch:{ all -> 0x013a }
            java.lang.Object r12 = r12.zze()     // Catch:{ all -> 0x013a }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x013a }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x013a }
            if (r12 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzbce r12 = com.google.android.gms.internal.ads.zzbcn.zzkP     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x005d }
            java.lang.Object r12 = r2.zza(r12)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x005d }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x005d }
            if (r12 == 0) goto L_0x002c
            r12 = r0
            goto L_0x002d
        L_0x002c:
            r12 = r1
        L_0x002d:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r9.zzf     // Catch:{ all -> 0x013a }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzkQ     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x013a }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x013a }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x013a }
            int r3 = r3.intValue()     // Catch:{ all -> 0x013a }
            if (r2 < r3) goto L_0x0045
            if (r12 != 0) goto L_0x004a
        L_0x0045:
            java.lang.String r12 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r12)     // Catch:{ all -> 0x013a }
        L_0x004a:
            if (r11 != 0) goto L_0x0062
            java.lang.String r10 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r10)     // Catch:{ all -> 0x005d }
            java.util.concurrent.Executor r10 = r9.zzc     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzezv r11 = new com.google.android.gms.internal.ads.zzezv     // Catch:{ all -> 0x005d }
            r11.<init>(r9)     // Catch:{ all -> 0x005d }
            r10.execute(r11)     // Catch:{ all -> 0x005d }
            monitor-exit(r9)
            return r1
        L_0x005d:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L_0x013d
        L_0x0062:
            com.google.common.util.concurrent.ListenableFuture r12 = r9.zzj     // Catch:{ all -> 0x013a }
            if (r12 == 0) goto L_0x0068
            monitor-exit(r9)
            return r1
        L_0x0068:
            com.google.android.gms.internal.ads.zzbdx r12 = com.google.android.gms.internal.ads.zzbeg.zzc     // Catch:{ all -> 0x013a }
            java.lang.Object r12 = r12.zze()     // Catch:{ all -> 0x013a }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x013a }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x013a }
            r2 = 7
            r3 = 0
            if (r12 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzfck r12 = r9.zze     // Catch:{ all -> 0x005d }
            java.lang.Object r4 = r12.zzd()     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x0099
            java.lang.Object r12 = r12.zzd()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzcon r12 = (com.google.android.gms.internal.ads.zzcon) r12     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzfkl r12 = r12.zzh()     // Catch:{ all -> 0x005d }
            r12.zzi(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r10.zzp     // Catch:{ all -> 0x005d }
            r12.zzb(r4)     // Catch:{ all -> 0x005d }
            android.os.Bundle r4 = r10.zzm     // Catch:{ all -> 0x005d }
            r12.zzf(r4)     // Catch:{ all -> 0x005d }
            r4 = r12
            goto L_0x009a
        L_0x0099:
            r4 = r3
        L_0x009a:
            android.content.Context r12 = r9.zzb     // Catch:{ all -> 0x013a }
            boolean r5 = r10.zzf     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzfgl.zza(r12, r5)     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzbce r12 = com.google.android.gms.internal.ads.zzbcn.zziz     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x013a }
            java.lang.Object r12 = r5.zza(r12)     // Catch:{ all -> 0x013a }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x013a }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x013a }
            if (r12 == 0) goto L_0x00c0
            boolean r12 = r10.zzf     // Catch:{ all -> 0x005d }
            if (r12 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzchk r12 = r9.zza     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzdvk r12 = r12.zzl()     // Catch:{ all -> 0x005d }
            r12.zzo(r0)     // Catch:{ all -> 0x005d }
        L_0x00c0:
            r12 = 2
            android.util.Pair[] r12 = new android.util.Pair[r12]     // Catch:{ all -> 0x013a }
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzdrv r6 = com.google.android.gms.internal.ads.zzdrv.PUBLIC_API_CALL     // Catch:{ all -> 0x013a }
            java.lang.String r6 = r6.zza()     // Catch:{ all -> 0x013a }
            long r7 = r10.zzz     // Catch:{ all -> 0x013a }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x013a }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x013a }
            r12[r1] = r5     // Catch:{ all -> 0x013a }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzdrv r5 = com.google.android.gms.internal.ads.zzdrv.DYNAMITE_ENTER     // Catch:{ all -> 0x013a }
            java.lang.String r5 = r5.zza()     // Catch:{ all -> 0x013a }
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x013a }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x013a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x013a }
            r1.<init>(r5, r6)     // Catch:{ all -> 0x013a }
            r12[r0] = r1     // Catch:{ all -> 0x013a }
            android.os.Bundle r12 = com.google.android.gms.internal.ads.zzdrx.zza(r12)     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzffm r1 = r9.zzi     // Catch:{ all -> 0x013a }
            r1.zzt(r11)     // Catch:{ all -> 0x013a }
            com.google.android.gms.ads.internal.client.zzs r11 = com.google.android.gms.ads.internal.client.zzs.zzb()     // Catch:{ all -> 0x013a }
            r1.zzs(r11)     // Catch:{ all -> 0x013a }
            r1.zzH(r10)     // Catch:{ all -> 0x013a }
            r1.zzA(r12)     // Catch:{ all -> 0x013a }
            android.content.Context r11 = r9.zzb     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzffo r12 = r1.zzJ()     // Catch:{ all -> 0x013a }
            int r1 = com.google.android.gms.internal.ads.zzfkk.zzf(r12)     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzfka r5 = com.google.android.gms.internal.ads.zzfjz.zzb(r11, r1, r2, r10)     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzezz r6 = new com.google.android.gms.internal.ads.zzezz     // Catch:{ all -> 0x013a }
            r6.<init>(r3)     // Catch:{ all -> 0x013a }
            r6.zza = r12     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzfck r10 = r9.zze     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzfcl r11 = new com.google.android.gms.internal.ads.zzfcl     // Catch:{ all -> 0x013a }
            r11.<init>(r6, r3)     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzezw r12 = new com.google.android.gms.internal.ads.zzezw     // Catch:{ all -> 0x013a }
            r12.<init>(r9)     // Catch:{ all -> 0x013a }
            com.google.common.util.concurrent.ListenableFuture r10 = r10.zzc(r11, r12, r3)     // Catch:{ all -> 0x013a }
            r9.zzj = r10     // Catch:{ all -> 0x013a }
            com.google.android.gms.internal.ads.zzezy r1 = new com.google.android.gms.internal.ads.zzezy     // Catch:{ all -> 0x013a }
            r2 = r9
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x013f }
            java.util.concurrent.Executor r11 = r2.zzc     // Catch:{ all -> 0x013f }
            com.google.android.gms.internal.ads.zzgei.zzr(r10, r1, r11)     // Catch:{ all -> 0x013f }
            monitor-exit(r9)
            return r0
        L_0x013a:
            r0 = move-exception
            r2 = r9
        L_0x013c:
            r10 = r0
        L_0x013d:
            monitor-exit(r9)     // Catch:{ all -> 0x013f }
            throw r10
        L_0x013f:
            r0 = move-exception
            goto L_0x013c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfab.zzb(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzeng, com.google.android.gms.internal.ads.zzenh):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract zzcvs zze(zzcpa zzcpa, zzcvw zzcvw, zzdcf zzdcf);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(zzfgq.zzd(6, (String) null, (zze) null));
    }

    public final void zzl(zzy zzy) {
        this.zzi.zzu(zzy);
    }
}
