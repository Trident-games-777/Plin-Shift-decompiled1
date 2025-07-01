package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfxd {
    private final zzfxc zza;

    private zzfxd(zzfxc zzfxc) {
        int i = zzfwe.zzb;
        this.zza = zzfxc;
    }

    public static zzfxd zza(int i) {
        return new zzfxd(new zzfwz(4000));
    }

    public static zzfxd zzb(zzfwf zzfwf) {
        return new zzfxd(new zzfwx(zzfwf));
    }

    /* access modifiers changed from: private */
    public final Iterator zzf(CharSequence charSequence) {
        return this.zza.zza(this, charSequence);
    }

    public final Iterable zzc(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfxa(this, charSequence);
    }

    public final List zze(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzf = zzf(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzf.hasNext()) {
            arrayList.add((String) zzf.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
