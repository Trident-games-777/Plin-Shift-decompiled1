package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewz implements zzevz {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbzq zzg;

    zzewz(zzbzq zzbzq, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbzq;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    public final int zza() {
        return 40;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzbb)).booleanValue()) {
            return zzgei.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return (zzgdz) zzgei.zze((zzgdz) zzgei.zzo((zzgdz) zzgei.zzm(zzgdz.zzu(this.zzg.zza(this.zza, this.zzd)), new zzewx(this), this.zzc), ((Long) zzbe.zzc().zza(zzbcn.zzbc)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzewy(this), this.zzc);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0068, code lost:
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "AdIdInfoSignalSource.getPaidV1");
        r0 = new com.google.android.gms.internal.ads.zzfth();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdi)).booleanValue() == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdj)).booleanValue() != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = com.google.android.gms.internal.ads.zzftl.zzj(r7.zza).zzi((java.lang.String) java.util.Objects.requireNonNull(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) java.util.Objects.requireNonNull(r8)).getId()), r7.zza.getPackageName(), ((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdo)).longValue(), r7.zzf);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzexa zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfth r0 = new com.google.android.gms.internal.ads.zzfth
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzdi
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0031
        L_0x001b:
            boolean r1 = r7.zze
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzdj
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0076
        L_0x0031:
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzftl r1 = com.google.android.gms.internal.ads.zzftl.zzj(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = java.util.Objects.requireNonNull(r8)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r0     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.String r0 = r0.getId()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.String r3 = r0.getPackageName()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzdo     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = r4.zza(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            long r4 = r0.longValue()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            boolean r6 = r7.zzf     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzfth r0 = r1.zzi(r2, r3, r4, r6)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            goto L_0x0076
        L_0x0065:
            r0 = move-exception
            goto L_0x0068
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()
            r2.zzw(r0, r1)
            com.google.android.gms.internal.ads.zzfth r0 = new com.google.android.gms.internal.ads.zzfth
            r0.<init>()
        L_0x0076:
            com.google.android.gms.internal.ads.zzexa r1 = new com.google.android.gms.internal.ads.zzexa
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewz.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzexa");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexa zzd(Throwable th) {
        String str;
        zzbc.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        return new zzexa((AdvertisingIdClient.Info) null, str, new zzfth());
    }
}
