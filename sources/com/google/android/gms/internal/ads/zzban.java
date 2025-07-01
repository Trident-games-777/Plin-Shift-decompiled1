package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzei;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzban {
    private zzby zza;
    private final Context zzb;
    private final String zzc;
    private final zzei zzd;
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzbpc zzg = new zzbpc();
    private final zzr zzh;

    public zzban(Context context, String str, zzei zzei, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzei;
        this.zze = i;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzr.zza;
    }

    public final void zza() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            zzby zze2 = zzbc.zza().zze(this.zzb, zzs.zzb(), this.zzc, this.zzg);
            this.zza = zze2;
            if (zze2 != null) {
                if (this.zze != 3) {
                    this.zza.zzI(new zzy(this.zze));
                }
                this.zzd.zzq(currentTimeMillis);
                this.zza.zzH(new zzbaa(this.zzf, this.zzc));
                this.zza.zzab(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
