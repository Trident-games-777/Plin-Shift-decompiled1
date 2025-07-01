package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzevg implements zzevz {
    final String zza;
    private final zzges zzb;
    private final ScheduledExecutorService zzc;
    private final zzelo zzd;
    private final Context zze;
    private final zzffo zzf;
    private final zzelk zzg;
    private final zzdqd zzh;
    private final zzdur zzi;

    zzevg(zzges zzges, ScheduledExecutorService scheduledExecutorService, String str, zzelo zzelo, Context context, zzffo zzffo, zzelk zzelk, zzdqd zzdqd, zzdur zzdur) {
        this.zzb = zzges;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzelo;
        this.zze = context;
        this.zzf = zzffo;
        this.zzg = zzelk;
        this.zzh = zzdqd;
        this.zzi = zzdur;
    }

    public static /* synthetic */ ListenableFuture zzc(zzevg zzevg) {
        String str;
        Bundle bundle;
        zzevg zzevg2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkB)).booleanValue()) {
            str = zzevg.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzevg.zzf.zzf;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbJ)).booleanValue()) {
            bundle = zzevg.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzbS)).booleanValue()) {
            for (Map.Entry entry : ((zzfzr) zzevg.zzd.zzb(zzevg.zza, str)).entrySet()) {
                String str2 = (String) entry.getKey();
                zzevg zzevg3 = zzevg;
                arrayList.add(zzevg3.zzg(str2, (List) entry.getValue(), zzevg.zzf(str2), true, true));
                zzevg = zzevg3;
            }
            zzevg2 = zzevg;
            zzevg2.zzi(arrayList, zzevg2.zzd.zzc());
        } else {
            zzevg2 = zzevg;
            zzevg2.zzi(arrayList, zzevg2.zzd.zza(zzevg2.zza, str));
        }
        return zzgei.zzb(arrayList).zza(new zzevb(arrayList, bundle), zzevg2.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgdz zzg(String str, List list, Bundle bundle, boolean z, boolean z2) {
        String str2 = str;
        zzgdz zzu = zzgdz.zzu(zzgei.zzk(new zzevd(this, str2, list, bundle, z, z2), this.zzb));
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzbF)).booleanValue()) {
            zzu = (zzgdz) zzgei.zzo(zzu, ((Long) zzbe.zzc().zza(zzbcn.zzby)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgdz) zzgei.zze(zzu, Throwable.class, new zzeve(str2), this.zzb);
    }

    private final void zzh(zzbrf zzbrf, Bundle bundle, List list, zzelr zzelr) throws RemoteException {
        zzbrf zzbrf2 = zzbrf;
        zzbrf2.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzelr);
    }

    private final void zzi(List list, Map map) {
        for (Map.Entry value : map.entrySet()) {
            zzels zzels = (zzels) value.getValue();
            String str = zzels.zza;
            list.add(zzg(str, Collections.singletonList(zzels.zze), zzf(str), zzels.zzb, zzels.zzc));
        }
    }

    public final int zza() {
        return 32;
    }

    public final ListenableFuture zzb() {
        zzffo zzffo = this.zzf;
        if (zzffo.zzr) {
            if (!Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzbL)).split(",")).contains(zzv.zzb(zzv.zzc(zzffo.zzd)))) {
                return zzgei.zzh(new zzevh(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgei.zzk(new zzeva(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r8, java.util.List r9, android.os.Bundle r10, boolean r11, boolean r12) throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzcao r3 = new com.google.android.gms.internal.ads.zzcao
            r3.<init>()
            r1 = 0
            if (r12 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzbce r12 = com.google.android.gms.internal.ads.zzbcn.zzbK
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r12 = r0.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzelk r12 = r7.zzg
            r12.zzb(r8)
            com.google.android.gms.internal.ads.zzelk r12 = r7.zzg
            com.google.android.gms.internal.ads.zzbrf r12 = r12.zza(r8)
        L_0x0025:
            r2 = r12
            goto L_0x0036
        L_0x0027:
            com.google.android.gms.internal.ads.zzdqd r12 = r7.zzh     // Catch:{ RemoteException -> 0x002e }
            com.google.android.gms.internal.ads.zzbrf r12 = r12.zzb(r8)     // Catch:{ RemoteException -> 0x002e }
            goto L_0x0025
        L_0x002e:
            r0 = move-exception
            r12 = r0
            java.lang.String r0 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.zzb(r0, r12)
            r2 = r1
        L_0x0036:
            if (r2 != 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzbA
            com.google.android.gms.internal.ads.zzbcl r10 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r9 = r10.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzelr.zzb(r8, r3)
            r1 = r7
            goto L_0x00c0
        L_0x0050:
            throw r1
        L_0x0051:
            com.google.android.gms.internal.ads.zzelr r0 = new com.google.android.gms.internal.ads.zzelr
            com.google.android.gms.common.util.Clock r12 = com.google.android.gms.ads.internal.zzv.zzC()
            long r4 = r12.elapsedRealtime()
            r1 = r8
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbce r8 = com.google.android.gms.internal.ads.zzbcn.zzbF
            com.google.android.gms.internal.ads.zzbcl r12 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r8 = r12.zza(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0090
            java.util.concurrent.ScheduledExecutorService r8 = r7.zzc
            java.util.Objects.requireNonNull(r0)
            com.google.android.gms.internal.ads.zzevf r12 = new com.google.android.gms.internal.ads.zzevf
            r12.<init>(r0)
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzby
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r4.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r4 = r1.longValue()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r8.schedule(r12, r4, r1)
        L_0x0090:
            if (r11 == 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzbce r8 = com.google.android.gms.internal.ads.zzbcn.zzbM
            com.google.android.gms.internal.ads.zzbcl r11 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r8 = r11.zza(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzges r8 = r7.zzb
            r5 = r0
            com.google.android.gms.internal.ads.zzevc r0 = new com.google.android.gms.internal.ads.zzevc
            r1 = r7
            r4 = r9
            r6 = r3
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r3 = r6
            r8.zza(r0)
            goto L_0x00c0
        L_0x00b5:
            r1 = r7
            r4 = r9
            r8 = r10
            r7.zzh(r2, r8, r4, r0)
            goto L_0x00c0
        L_0x00bc:
            r1 = r7
            r0.zzd()
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevg.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbrf zzbrf, Bundle bundle, List list, zzelr zzelr, zzcao zzcao) {
        try {
            zzh(zzbrf, bundle, list, zzelr);
        } catch (RemoteException e) {
            zzcao.zzd(e);
        }
    }
}
