package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzblo implements zzapi {
    /* access modifiers changed from: private */
    public volatile zzblb zza;
    private final Context zzb;

    public zzblo(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzblo zzblo) {
        if (zzblo.zza != null) {
            zzblo.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzapl zza(zzapp zzapp) throws zzapy {
        Parcelable.Creator<zzblc> creator = zzblc.CREATOR;
        Map zzl = zzapp.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzblc zzblc = new zzblc(zzapp.zzk(), strArr, strArr2);
        long elapsedRealtime = zzv.zzC().elapsedRealtime();
        try {
            zzcao zzcao = new zzcao();
            this.zza = new zzblb(this.zzb, zzv.zzu().zzb(), new zzblm(this, zzcao), new zzbln(this, zzcao));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture zzo = zzgei.zzo(zzgei.zzn(zzcao, new zzblk(this, zzblc), zzcaj.zza), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzex)).intValue(), TimeUnit.MILLISECONDS, zzcaj.zzd);
            zzo.addListener(new zzbll(this), zzcaj.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            zze.zza("Http assets remote cache took " + (zzv.zzC().elapsedRealtime() - elapsedRealtime) + "ms");
            zzble zzble = (zzble) new zzbvv(parcelFileDescriptor).zza(zzble.CREATOR);
            if (zzble == null) {
                return null;
            }
            if (!zzble.zza) {
                if (zzble.zze.length != zzble.zzf.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzble.zze;
                    if (i >= strArr3.length) {
                        return new zzapl(zzble.zzc, zzble.zzd, (Map) hashMap, zzble.zzg, zzble.zzh);
                    }
                    hashMap.put(strArr3[i], zzble.zzf[i]);
                    i++;
                }
            } else {
                throw new zzapy(zzble.zzb);
            }
        } catch (InterruptedException | ExecutionException unused) {
            zze.zza("Http assets remote cache took " + (zzv.zzC().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            zze.zza("Http assets remote cache took " + (zzv.zzC().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th2;
        }
    }
}
