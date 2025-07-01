package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdsp implements zzfjs {
    private final Map zza = new HashMap();
    private final zzdsh zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzdsp(zzdsh zzdsh, Set set, Clock clock) {
        this.zzb = zzdsh;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdso zzdso = (zzdso) it.next();
            this.zzd.put(zzdso.zzc, zzdso);
        }
        this.zzc = clock;
    }

    private final void zze(zzfjl zzfjl, boolean z) {
        String str;
        zzfjl zzb2 = ((zzdso) this.zzd.get(zzfjl)).zzb;
        if (this.zza.containsKey(zzb2)) {
            if (true != z) {
                str = "f.";
            } else {
                str = "s.";
            }
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue();
            zzdsh zzdsh = this.zzb;
            Map map = this.zzd;
            zzdsh.zzb().put("label.".concat(((zzdso) map.get(zzfjl)).zza), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    public final void zzd(zzfjl zzfjl, String str) {
        if (this.zza.containsKey(zzfjl)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfjl)).longValue();
            zzdsh zzdsh = this.zzb;
            String valueOf = String.valueOf(str);
            zzdsh.zzb().put("task.".concat(valueOf), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjl)) {
            zze(zzfjl, true);
        }
    }

    public final void zzdC(zzfjl zzfjl, String str) {
    }

    public final void zzdD(zzfjl zzfjl, String str, Throwable th) {
        if (this.zza.containsKey(zzfjl)) {
            Clock clock = this.zzc;
            Map map = this.zza;
            zzdsh zzdsh = this.zzb;
            String valueOf = String.valueOf(str);
            zzdsh.zzb().put("task.".concat(valueOf), "f.".concat(String.valueOf(Long.toString(clock.elapsedRealtime() - ((Long) map.get(zzfjl)).longValue()))));
        }
        if (this.zzd.containsKey(zzfjl)) {
            zze(zzfjl, false);
        }
    }

    public final void zzdE(zzfjl zzfjl, String str) {
        this.zza.put(zzfjl, Long.valueOf(this.zzc.elapsedRealtime()));
    }
}
