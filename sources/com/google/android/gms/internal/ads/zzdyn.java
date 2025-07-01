package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyn extends zzdyh {
    private String zzg;
    private int zzh = 1;

    zzdyn(Context context) {
        this.zzf = new zzbur(context, zzv.zzu().zzb(), this, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyw(1));
    }

    public final ListenableFuture zza(zzbvx zzbvx) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                ListenableFuture zzg2 = zzgei.zzg(new zzdyw(2));
                return zzg2;
            } else if (this.zzc) {
                zzcao zzcao = this.zza;
                return zzcao;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbvx;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzdyl(this), zzcaj.zzf);
                zzcao zzcao2 = this.zza;
                return zzcao2;
            }
        }
    }

    public final ListenableFuture zzd(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                ListenableFuture zzg2 = zzgei.zzg(new zzdyw(2));
                return zzg2;
            } else if (this.zzc) {
                zzcao zzcao = this.zza;
                return zzcao;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzdym(this), zzcaj.zzf);
                zzcao zzcao2 = this.zza;
                return zzcao2;
            }
        }
    }

    public final void onConnected(Bundle bundle) {
        zzbvp zzbvp;
        zzbvp zzbvp2;
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        zzbvf zzp = this.zzf.zzp();
                        zzbvx zzbvx = this.zze;
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmD)).booleanValue()) {
                            zzbvp2 = new zzdyg(this.zza, this.zze);
                        } else {
                            zzbvp2 = new zzdyf(this);
                        }
                        zzp.zze(zzbvx, zzbvp2);
                    } else if (i == 3) {
                        zzbvf zzp2 = this.zzf.zzp();
                        String str = this.zzg;
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmD)).booleanValue()) {
                            zzbvp = new zzdyg(this.zza, this.zze);
                        } else {
                            zzbvp = new zzdyf(this);
                        }
                        zzp2.zzh(str, zzbvp);
                    } else {
                        this.zza.zzd(new zzdyw(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyw(1));
                } catch (Throwable th) {
                    zzv.zzp().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzdyw(1));
                }
            }
        }
    }
}
