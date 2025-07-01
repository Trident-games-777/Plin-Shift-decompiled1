package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkl implements Runnable {
    private final List zza = new ArrayList();
    private final zzfko zzb;
    private String zzc;
    private zzfkq zzd = zzfkq.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zze;
    private zzffe zzf;
    private zze zzg;
    private Future zzh;
    private int zzi = 2;

    zzfkl(zzfko zzfko) {
        this.zzb = zzfko;
    }

    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfkl zza(zzfka zzfka) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzfka.zzj();
            list.add(zzfka);
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            this.zzh = zzcaj.zzd.schedule(this, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzis)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzfkl zzb(String str) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue() && zzfkk.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfkl zzc(zze zze2) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            this.zzg = zze2;
        }
        return this;
    }

    public final synchronized zzfkl zzd(ArrayList arrayList) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner")) {
                if (!arrayList.contains(AdFormat.BANNER.name())) {
                    if (!arrayList.contains("interstitial")) {
                        if (!arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                            if (!arrayList.contains("native")) {
                                if (!arrayList.contains(AdFormat.NATIVE.name())) {
                                    if (!arrayList.contains("rewarded")) {
                                        if (!arrayList.contains(AdFormat.REWARDED.name())) {
                                            if (arrayList.contains("app_open_ad")) {
                                                this.zzi = 7;
                                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                                this.zzi = 6;
                                            }
                                        }
                                    }
                                    this.zzi = 5;
                                }
                            }
                            this.zzi = 8;
                        }
                    }
                    this.zzi = 4;
                }
            }
            this.zzi = 3;
        }
        return this;
    }

    public final synchronized zzfkl zze(String str) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzfkl zzf(Bundle bundle) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            this.zzd = zzv.zza(bundle);
        }
        return this;
    }

    public final synchronized zzfkl zzg(zzffe zzffe) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            this.zzf = zzffe;
        }
        return this;
    }

    public final synchronized void zzh() {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            for (zzfka zzfka : this.zza) {
                int i = this.zzi;
                if (i != 2) {
                    zzfka.zzn(i);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzfka.zze(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zze) && !zzfka.zzl()) {
                    zzfka.zzd(this.zze);
                }
                zzffe zzffe = this.zzf;
                if (zzffe != null) {
                    zzfka.zzb(zzffe);
                } else {
                    zze zze2 = this.zzg;
                    if (zze2 != null) {
                        zzfka.zza(zze2);
                    }
                }
                zzfka.zzf(this.zzd);
                this.zzb.zzb(zzfka.zzm());
            }
            this.zza.clear();
        }
    }

    public final synchronized zzfkl zzi(int i) {
        if (((Boolean) zzbeg.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
