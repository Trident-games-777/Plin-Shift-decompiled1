package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefg {
    private final List zza = Collections.synchronizedList(new ArrayList());
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final String zzc;
    private zzfew zzd = null;
    private zzfet zze = null;
    private zzw zzf = null;

    public zzefg(String str) {
        this.zzc = str;
    }

    private static String zzj(zzfet zzfet) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            return zzfet.zzap;
        }
        return zzfet.zzw;
    }

    private final synchronized void zzk(zzfet zzfet, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Map map = this.zzb;
            String zzj = zzj(zzfet);
            if (!map.containsKey(zzj)) {
                Bundle bundle = new Bundle();
                Iterator<String> keys = zzfet.zzv.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        bundle.putString(next, zzfet.zzv.getString(next));
                    } catch (JSONException unused) {
                    }
                }
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzgE)).booleanValue()) {
                    str4 = zzfet.zzF;
                    str3 = zzfet.zzG;
                    str2 = zzfet.zzH;
                    str = zzfet.zzI;
                } else {
                    str4 = "";
                    str3 = "";
                    str2 = "";
                    str = "";
                }
                zzw zzw = new zzw(zzfet.zzE, 0, (zze) null, bundle, str4, str3, str2, str);
                this.zza.add(i, zzw);
                this.zzb.put(zzj, zzw);
            }
        } catch (IndexOutOfBoundsException e) {
            zzv.zzp().zzw(e, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private final void zzl(zzfet zzfet, long j, zze zze2, boolean z) {
        Map map = this.zzb;
        String zzj = zzj(zzfet);
        if (map.containsKey(zzj)) {
            if (this.zze == null) {
                this.zze = zzfet;
            }
            zzw zzw = (zzw) this.zzb.get(zzj);
            zzw.zzb = j;
            zzw.zzc = zze2;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzgF)).booleanValue() && z) {
                this.zzf = zzw;
            }
        }
    }

    public final zzw zza() {
        return this.zzf;
    }

    public final zzcwf zzb() {
        return new zzcwf(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfet zzfet) {
        zzk(zzfet, this.zza.size());
    }

    public final void zze(zzfet zzfet) {
        int indexOf = this.zza.indexOf(this.zzb.get(zzj(zzfet)));
        if (indexOf < 0 || indexOf >= this.zzb.size()) {
            indexOf = this.zza.indexOf(this.zzf);
        }
        if (indexOf >= 0 && indexOf < this.zzb.size()) {
            this.zzf = (zzw) this.zza.get(indexOf);
            while (true) {
                indexOf++;
                if (indexOf < this.zza.size()) {
                    zzw zzw = (zzw) this.zza.get(indexOf);
                    zzw.zzb = 0;
                    zzw.zzc = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzf(zzfet zzfet, long j, zze zze2) {
        zzl(zzfet, j, zze2, false);
    }

    public final void zzg(zzfet zzfet, long j, zze zze2) {
        zzl(zzfet, j, (zze) null, true);
    }

    public final synchronized void zzh(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int indexOf = this.zza.indexOf((zzw) this.zzb.get(str));
            try {
                this.zza.remove(indexOf);
            } catch (IndexOutOfBoundsException e) {
                zzv.zzp().zzw(e, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzk((zzfet) it.next(), indexOf);
                indexOf++;
            }
        }
    }

    public final void zzi(zzfew zzfew) {
        this.zzd = zzfew;
    }
}
