package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnb {
    zzbul zza;
    zzbul zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    private final zzg zzd;
    private final zzeex zze;
    private final zzdps zzf;
    /* access modifiers changed from: private */
    public final zzges zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcnb(Context context, zzg zzg2, zzeex zzeex, zzdps zzdps, zzges zzges, zzges zzges2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzg2;
        this.zze = zzeex;
        this.zzf = zzdps;
        this.zzg = zzges;
        this.zzh = zzges2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) zzbe.zzc().zza(zzbcn.zzjP));
    }

    private final ListenableFuture zzk(String str, @Nullable InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) zzbe.zzc().zza(zzbcn.zzjP)) || this.zzd.zzN()) {
                return zzgei.zzh(str);
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            long nextInt = (long) random.nextInt(Integer.MAX_VALUE);
            buildUpon.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjQ), String.valueOf(nextInt));
            if (inputEvent != null) {
                return (zzgdz) zzgei.zzf((zzgdz) zzgei.zzn(zzgdz.zzu(this.zze.zza()), new zzcmv(this, buildUpon, str, inputEvent), this.zzh), Throwable.class, new zzcmw(this, buildUpon), this.zzg);
            }
            buildUpon.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjR), "11");
            return zzgei.zzh(buildUpon.toString());
        } catch (Exception e) {
            return zzgei.zzg(e);
        }
    }

    public final ListenableFuture zzb(String str, Random random) {
        if (TextUtils.isEmpty(str)) {
            return zzgei.zzh(str);
        }
        return zzgei.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzcms(this, str), this.zzg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Throwable th) throws Exception {
        this.zzg.zza(new zzcmu(this, th));
        return zzgei.zzh(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() == 1) {
            Uri.Builder buildUpon = builder.build().buildUpon();
            buildUpon.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjS), DiskLruCache.VERSION);
            buildUpon.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjR), "12");
            if (str.contains((CharSequence) zzbe.zzc().zza(zzbcn.zzjT))) {
                buildUpon.authority((String) zzbe.zzc().zza(zzbcn.zzjU));
            }
            return (zzgdz) zzgei.zzn(zzgdz.zzu(this.zze.zzb(buildUpon.build(), inputEvent)), new zzcmx(builder), this.zzh);
        }
        builder.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjR), "10");
        return zzgei.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Uri.Builder builder, Throwable th) throws Exception {
        this.zzg.zza(new zzcmt(this, th));
        builder.appendQueryParameter((String) zzbe.zzc().zza(zzbcn.zzjR), "9");
        return zzgei.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjW)).booleanValue()) {
            zzbul zzc2 = zzbuj.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
            return;
        }
        zzbul zza2 = zzbuj.zza(this.zzc);
        this.zza = zza2;
        zza2.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjW)).booleanValue()) {
            zzbul zzc2 = zzbuj.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzh(th, "AttributionReporting");
            return;
        }
        zzbul zza2 = zzbuj.zza(this.zzc);
        this.zza = zza2;
        zza2.zzh(th, "AttributionReportingSampled");
    }

    public final void zzi(String str, zzflr zzflr, Random random) {
        if (!TextUtils.isEmpty(str)) {
            ListenableFuture zzk = zzk(str, this.zzf.zza(), random);
            zzbce zzbce = zzbcn.zzjV;
            zzgei.zzr(zzgei.zzo(zzk, (long) ((Integer) zzbe.zzc().zza(zzbce)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcna(this, zzflr, str), this.zzg);
        }
    }
}
