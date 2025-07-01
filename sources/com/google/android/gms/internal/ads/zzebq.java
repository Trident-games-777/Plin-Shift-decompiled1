package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzebq extends zzbvi {
    private final Context zza;
    private final zzexs zzb;
    private final zzexq zzc;
    private final zzeby zzd;
    private final zzges zze;
    private final zzbwf zzf;

    zzebq(Context context, zzexs zzexs, zzexq zzexq, zzebv zzebv, zzeby zzeby, zzges zzges, zzbwf zzbwf) {
        this.zza = context;
        this.zzb = zzexs;
        this.zzc = zzexq;
        this.zzd = zzeby;
        this.zze = zzges;
        this.zzf = zzbwf;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbvm zzbvm) {
        zzgei.zzr((zzgdz) zzgei.zzn(zzgdz.zzu(listenableFuture), new zzebn(this), zzcaj.zza), new zzebp(this, zzbvm), zzcaj.zzf);
    }

    public final ListenableFuture zzb(zzbvb zzbvb, int i) {
        ListenableFuture listenableFuture;
        HashMap hashMap = new HashMap();
        Bundle bundle = zzbvb.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    hashMap.put(str, string);
                }
            }
        }
        zzebs zzebs = new zzebs(zzbvb.zza, zzbvb.zzb, hashMap, zzbvb.zzd, "", zzbvb.zze);
        zzexr zzb2 = this.zzc.zza(new zzeyo(zzbvb)).zzb();
        if (zzebs.zzf) {
            String str2 = zzbvb.zza;
            String str3 = (String) zzbeu.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                String host = Uri.parse(str2).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it = zzfxd.zzb(zzfwf.zzc(';')).zzc(str3).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (host.endsWith((String) it.next())) {
                                listenableFuture = zzgei.zzm(zzb2.zza().zza(new JSONObject(), new Bundle()), new zzebi(zzebs), this.zze);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        listenableFuture = zzgei.zzh(zzebs);
        zzfjr zzb3 = zzb2.zzb();
        return zzgei.zzn(zzb3.zzb(zzfjl.HTTP, listenableFuture).zze(new zzebu(this.zza, "", this.zzf, i)).zza(), new zzebj(), this.zze);
    }

    public final void zze(zzbvb zzbvb, zzbvm zzbvm) {
        zzc(zzb(zzbvb, Binder.getCallingUid()), zzbvm);
    }

    public final void zzf(zzbuv zzbuv, zzbvm zzbvm) {
        zzext zzb2 = this.zzb.zza(new zzexh(zzbuv, Binder.getCallingUid())).zzb();
        zzfjr zzb3 = zzb2.zzb();
        zzfix zza2 = zzb3.zzb(zzfjl.GMS_SIGNALS, zzgei.zzi()).zzf(new zzebm(zzb2)).zze(new zzebl()).zzf(new zzebk()).zza();
        zzc(zza2, zzbvm);
        if (((Boolean) zzben.zzf.zze()).booleanValue()) {
            zzeby zzeby = this.zzd;
            Objects.requireNonNull(zzeby);
            zza2.addListener(new zzebo(zzeby), this.zze);
        }
    }
}
