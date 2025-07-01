package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxq extends zzaxt {
    private final View zzh;

    public zzaxq(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, View view) {
        super(zzawf, "gU8TtHMsoUkPWKRp4pchlMiybbWQk/XZmErfUYdY8xYZMhv+DT5EJrcXuMdR9TAB", "MCymTm++OZPusG19DHbi/CZ9AvqE5ZBPeRnjpDHc8+4=", zzasf, i, 57);
        this.zzh = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            Boolean bool = (Boolean) zzbe.zzc().zza(zzbcn.zzdx);
            Boolean bool2 = (Boolean) zzbe.zzc().zza(zzbcn.zzkE);
            zzawj zzawj = new zzawj((String) this.zze.invoke((Object) null, new Object[]{this.zzh, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2}));
            zzasy zza = zzasz.zza();
            zza.zzb(zzawj.zza.longValue());
            zza.zzd(zzawj.zzb.longValue());
            zza.zze(zzawj.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzawj.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzawj.zzd.longValue());
            }
            this.zzd.zzY((zzasz) zza.zzbr());
        }
    }
}
