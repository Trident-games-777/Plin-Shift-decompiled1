package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbbc implements Runnable {
    public final /* synthetic */ zzbbf zza;
    public final /* synthetic */ zzbaw zzb;

    public /* synthetic */ zzbbc(zzbbf zzbbf, zzbaw zzbaw) {
        this.zza = zzbbf;
        this.zzb = zzbaw;
    }

    public final void run() {
        zzbau zzbau;
        zzbbf zzbbf = this.zza;
        zzbaw zzbaw = this.zzb;
        try {
            zzbaz zzq = zzbaw.zzq();
            if (zzbaw.zzp()) {
                zzbau = zzq.zzg(zzbbf.zza);
            } else {
                zzbau = zzq.zzf(zzbbf.zza);
            }
            if (!zzbau.zze()) {
                zzbbf.zzb.zzd(new RuntimeException("No entry contents."));
                zzbbh.zze(zzbbf.zzc);
                return;
            }
            zzbbe zzbbe = new zzbbe(zzbbf, zzbau.zzc(), 1);
            int read = zzbbe.read();
            if (read != -1) {
                zzbbe.unread(read);
                zzbbf.zzb.zzc(zzbbj.zzb(zzbbe, zzbau.zzd(), zzbau.zzg(), zzbau.zza(), zzbau.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzm.zzh("Unable to obtain a cache service instance.", e);
            zzbbf.zzb.zzd(e);
            zzbbh.zze(zzbbf.zzc);
        }
    }
}
