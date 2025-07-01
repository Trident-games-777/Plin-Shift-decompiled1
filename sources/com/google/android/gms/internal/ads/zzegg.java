package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegg implements zzefh {
    private final Context zza;
    private final zzcqh zzb;
    private final Executor zzc;

    public zzegg(Context context, zzcqh zzcqh, Executor executor) {
        this.zza = context;
        this.zzb = zzcqh;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzfff r7, com.google.android.gms.internal.ads.zzfet r8, com.google.android.gms.internal.ads.zzefe r9) throws com.google.android.gms.internal.ads.zzffv, com.google.android.gms.internal.ads.zzeiz {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzhy
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzag
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfgm r0 = (com.google.android.gms.internal.ads.zzfgm) r0
            com.google.android.gms.internal.ads.zzbpp r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgei.zzh(r1)
            com.google.android.gms.internal.ads.zzege r3 = new com.google.android.gms.internal.ads.zzege
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzges r2 = com.google.android.gms.internal.ads.zzcaj.zze
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgei.zzn(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzffv r8 = new com.google.android.gms.internal.ads.zzffv
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzffv r7 = new com.google.android.gms.internal.ads.zzffv
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzffv r8 = new com.google.android.gms.internal.ads.zzffv
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r7)
            com.google.android.gms.internal.ads.zzffv r8 = new com.google.android.gms.internal.ads.zzffv
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfgm r0 = (com.google.android.gms.internal.ads.zzfgm) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzcqh r0 = r6.zzb
            java.lang.String r3 = r9.zza
            com.google.android.gms.internal.ads.zzcsg r4 = new com.google.android.gms.internal.ads.zzcsg
            r4.<init>(r7, r8, r3)
            java.lang.Object r7 = r9.zzb
            com.google.android.gms.internal.ads.zzcpk r3 = new com.google.android.gms.internal.ads.zzcpk
            com.google.android.gms.internal.ads.zzfgm r7 = (com.google.android.gms.internal.ads.zzfgm) r7
            java.util.Objects.requireNonNull(r7)
            com.google.android.gms.internal.ads.zzegf r5 = new com.google.android.gms.internal.ads.zzegf
            r5.<init>(r7)
            java.util.List r7 = r8.zzu
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzfeu r7 = (com.google.android.gms.internal.ads.zzfeu) r7
            r3.<init>(r2, r1, r5, r7)
            com.google.android.gms.internal.ads.zzcpe r7 = r0.zza(r4, r3)
            com.google.android.gms.internal.ads.zzdef r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzcxl r8 = r7.zzd()
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzcmr r1 = new com.google.android.gms.internal.ads.zzcmr
            com.google.android.gms.internal.ads.zzfgm r0 = (com.google.android.gms.internal.ads.zzfgm) r0
            r1.<init>(r0)
            java.util.concurrent.Executor r0 = r6.zzc
            r8.zzo(r1, r0)
            com.google.android.gms.internal.ads.zzcxw r8 = r9.zzc
            com.google.android.gms.internal.ads.zzegx r8 = (com.google.android.gms.internal.ads.zzegx) r8
            com.google.android.gms.internal.ads.zzekp r9 = r7.zzk()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcpd r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegg.zza(com.google.android.gms.internal.ads.zzfff, com.google.android.gms.internal.ads.zzfet, com.google.android.gms.internal.ads.zzefe):java.lang.Object");
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        zzs zza2;
        zzs zzs = zzfff.zza.zza.zze;
        if (zzs.zzn) {
            zza2 = new zzs(this.zza, zzb.zzd(zzs.zze, zzs.zzb));
        } else {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() || !zzfet.zzag) {
                zza2 = zzffu.zza(this.zza, zzfet.zzu);
            } else {
                zza2 = new zzs(this.zza, zzb.zze(zzs.zze, zzs.zzb));
            }
        }
        zzs zzs2 = zza2;
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() || !zzfet.zzag) {
            Object obj = zzefe.zzb;
            ((zzfgm) obj).zzm(this.zza, zzs2, zzfff.zza.zza.zzd, zzfet.zzv.toString(), zzbr.zzm(zzfet.zzs), (zzbpm) zzefe.zzc);
            return;
        }
        Object obj2 = zzefe.zzb;
        ((zzfgm) obj2).zzn(this.zza, zzs2, zzfff.zza.zza.zzd, zzfet.zzv.toString(), zzbr.zzm(zzfet.zzs), (zzbpm) zzefe.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzfet zzfet, Object obj) throws Exception {
        return zzgei.zzh(zzcrc.zza(this.zza, view, zzfet));
    }
}
