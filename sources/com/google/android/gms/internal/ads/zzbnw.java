package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbnw implements zzbmo, zzbnv {
    private final zzbnv zza;
    private final HashSet zzb = new HashSet();

    public zzbnw(zzbnv zzbnv) {
        this.zza = zzbnv;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbmn.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbjr) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbjr) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbmn.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbmn.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbmn.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzbjr zzbjr) {
        this.zza.zzq(str, zzbjr);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbjr));
    }

    public final void zzr(String str, zzbjr zzbjr) {
        this.zza.zzr(str, zzbjr);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbjr));
    }
}
