package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdef extends zzdcc implements zzaym {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzfet zzd;

    public zzdef(Context context, Set set, zzfet zzfet) {
        super(set);
        this.zzc = context;
        this.zzd = zzfet;
    }

    public final synchronized void zza(View view) {
        zzayn zzayn = (zzayn) this.zzb.get(view);
        if (zzayn == null) {
            zzayn zzayn2 = new zzayn(this.zzc, view);
            zzayn2.zzc(this);
            this.zzb.put(view, zzayn2);
            zzayn = zzayn2;
        }
        if (this.zzd.zzX) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzbv)).booleanValue()) {
                zzayn.zzg(((Long) zzbe.zzc().zza(zzbcn.zzbu)).longValue());
                return;
            }
        }
        zzayn.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzayn) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzdp(zzayl zzayl) {
        zzq(new zzdee(zzayl));
    }
}
