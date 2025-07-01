package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrr implements zzdbg, zza, zzcxg, zzcwq {
    private final Context zza;
    private final zzfgg zzb;
    private final zzdsm zzc;
    private final zzfff zzd;
    private final zzfet zze;
    private final zzedp zzf;
    private final String zzg;
    private Boolean zzh;
    private final boolean zzi = ((Boolean) zzbe.zzc().zza(zzbcn.zzgH)).booleanValue();

    public zzdrr(Context context, zzfgg zzfgg, zzdsm zzdsm, zzfff zzfff, zzfet zzfet, zzedp zzedp, String str) {
        this.zza = context;
        this.zzb = zzfgg;
        this.zzc = zzdsm;
        this.zzd = zzfff;
        this.zze = zzfet;
        this.zzf = zzedp;
        this.zzg = str;
    }

    private final zzdsl zzd(String str) {
        String str2;
        zzffe zzffe = this.zzd.zzb;
        zzdsl zza2 = this.zzc.zza();
        zza2.zzd(zzffe.zzb);
        zza2.zzc(this.zze);
        zza2.zzb("action", str);
        zza2.zzb(FirebaseAnalytics.Param.AD_FORMAT, this.zzg.toUpperCase(Locale.ROOT));
        boolean z = false;
        if (!this.zze.zzt.isEmpty()) {
            zza2.zzb("ancn", (String) this.zze.zzt.get(0));
        }
        if (this.zze.zzai) {
            if (true != zzv.zzp().zzA(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str2);
            zza2.zzb("event_timestamp", String.valueOf(zzv.zzC().currentTimeMillis()));
            zza2.zzb("offline_ad", DiskLruCache.VERSION);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgO)).booleanValue()) {
            if (com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzf(this.zzd.zza.zza) != 1) {
                z = true;
            }
            zza2.zzb("scar", String.valueOf(z));
            if (z) {
                zzm zzm = this.zzd.zza.zza.zzd;
                zza2.zzb("ragent", zzm.zzp);
                zza2.zzb("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzc(zzm)));
            }
        }
        return zza2;
    }

    private final void zze(zzdsl zzdsl) {
        if (this.zze.zzai) {
            this.zzf.zzd(new zzedr(zzv.zzC().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdsl.zze(), 2));
            return;
        }
        zzdsl.zzf();
    }

    private final boolean zzf() {
        String str;
        if (this.zzh == null) {
            synchronized (this) {
                if (this.zzh == null) {
                    String str2 = (String) zzbe.zzc().zza(zzbcn.zzbz);
                    zzv.zzq();
                    try {
                        str = zzs.zzp(this.zza);
                    } catch (RemoteException unused) {
                        str = null;
                    }
                    boolean z = false;
                    if (!(str2 == null || str == null)) {
                        try {
                            z = Pattern.matches(str2, str);
                        } catch (RuntimeException e) {
                            zzv.zzp().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzh = Boolean.valueOf(z);
                }
            }
        }
        return this.zzh.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzai) {
            zze(zzd("click"));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzi) {
            zzdsl zzd2 = zzd("ifts");
            zzd2.zzb("reason", "adapter");
            int i = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i = zze4.zza;
                str = zze4.zzb;
            }
            if (i >= 0) {
                zzd2.zzb("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzd2.zzb("areec", zza2);
            }
            zzd2.zzf();
        }
    }

    public final void zzb() {
        if (this.zzi) {
            zzdsl zzd2 = zzd("ifts");
            zzd2.zzb("reason", "blocked");
            zzd2.zzf();
        }
    }

    public final void zzc(zzdgu zzdgu) {
        if (this.zzi) {
            zzdsl zzd2 = zzd("ifts");
            zzd2.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgu.getMessage())) {
                zzd2.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdgu.getMessage());
            }
            zzd2.zzf();
        }
    }

    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzf();
        }
    }

    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzf();
        }
    }

    public final void zzr() {
        if (zzf() || this.zze.zzai) {
            zze(zzd("impression"));
        }
    }
}
