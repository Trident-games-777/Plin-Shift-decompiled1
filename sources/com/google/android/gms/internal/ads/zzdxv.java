package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxv implements zzdyv {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwv zzb;
    private final zzges zzc;
    private final zzffo zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzecl zzf;
    private final zzfkl zzg;
    private final Context zzh;

    zzdxv(Context context, zzffo zzffo, zzdwv zzdwv, zzges zzges, ScheduledExecutorService scheduledExecutorService, zzecl zzecl, zzfkl zzfkl) {
        this.zzh = context;
        this.zzd = zzffo;
        this.zzb = zzdwv;
        this.zzc = zzges;
        this.zze = scheduledExecutorService;
        this.zzf = zzecl;
        this.zzg = zzfkl;
    }

    public final ListenableFuture zzb(zzbvx zzbvx) {
        Context context = this.zzh;
        ListenableFuture zzc2 = this.zzb.zzc(zzbvx);
        zzfka zza2 = zzfjz.zza(context, 11);
        zzfkk.zzd(zzc2, zza2);
        ListenableFuture zzn = zzgei.zzn(zzc2, new zzdxs(this), this.zzc);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfw)).booleanValue()) {
            zzbce zzbce = zzbcn.zzfx;
            Class<TimeoutException> cls = TimeoutException.class;
            zzn = zzgei.zzf(zzgei.zzo(zzn, (long) ((Integer) zzbe.zzc().zza(zzbce)).intValue(), TimeUnit.SECONDS, this.zze), cls, new zzdxt(), zzcaj.zzf);
        }
        zzfkk.zza(zzn, this.zzg, zza2);
        zzgei.zzr(zzn, new zzdxu(this), zzcaj.zzf);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzdyx zzdyx) throws Exception {
        return zzgei.zzh(new zzfff(new zzffc(this.zzd), zzffe.zza(new InputStreamReader(zzdyx.zzb()), zzdyx.zza())));
    }
}
