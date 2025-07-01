package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfqi {
    private final Context zza;
    private final Executor zzb;
    private final zzfpp zzc;
    private final zzfpr zzd;
    private final zzfqh zze;
    private final zzfqh zzf;
    private Task zzg;
    private Task zzh;

    zzfqi(Context context, Executor executor, zzfpp zzfpp, zzfpr zzfpr, zzfqf zzfqf, zzfqg zzfqg) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfpp;
        this.zzd = zzfpr;
        this.zze = zzfqf;
        this.zzf = zzfqg;
    }

    public static zzfqi zze(Context context, Executor executor, zzfpp zzfpp, zzfpr zzfpr) {
        zzfqi zzfqi = new zzfqi(context, executor, zzfpp, zzfpr, new zzfqf(), new zzfqg());
        if (zzfqi.zzd.zzh()) {
            zzfqi.zzg = zzfqi.zzh(new zzfqc(zzfqi));
        } else {
            zzfqi.zzg = Tasks.forResult(zzfqi.zze.zza());
        }
        zzfqi.zzh = zzfqi.zzh(new zzfqd(zzfqi));
        return zzfqi;
    }

    private static zzata zzg(Task task, zzata zzata) {
        if (!task.isSuccessful()) {
            return zzata;
        }
        return (zzata) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfqe(this));
    }

    public final zzata zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzata zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzata zzc() throws Exception {
        zzasf zza2 = zzata.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza2.zzs(id);
            zza2.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzab(6);
        }
        return (zzata) zza2.zzbr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzata zzd() throws Exception {
        Context context = this.zza;
        return zzfpx.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
