package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfxa implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfxd zzb;

    zzfxa(zzfxd zzfxd, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzfxd;
    }

    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        String str = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfwi.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
