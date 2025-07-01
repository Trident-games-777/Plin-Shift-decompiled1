package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyd extends zzdyh {
    private final Context zzg;
    private final Executor zzh;

    public zzdyd(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbur(context, zzv.zzu().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        zzbvp zzbvp;
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    zzbvf zzp = this.zzf.zzp();
                    zzbvx zzbvx = this.zze;
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzmD)).booleanValue()) {
                        zzbvp = new zzdyg(this.zza, this.zze);
                    } else {
                        zzbvp = new zzdyf(this);
                    }
                    zzp.zzg(zzbvx, zzbvp);
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyw(1));
                } catch (Throwable th) {
                    zzv.zzp().zzw(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzdyw(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyw(1));
    }

    public final ListenableFuture zza(zzbvx zzbvx) {
        synchronized (this.zzb) {
            if (this.zzc) {
                zzcao zzcao = this.zza;
                return zzcao;
            }
            this.zzc = true;
            this.zze = zzbvx;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new zzdyc(this), zzcaj.zzf);
            zzc(this.zzg, this.zza, this.zzh);
            zzcao zzcao2 = this.zza;
            return zzcao2;
        }
    }
}
