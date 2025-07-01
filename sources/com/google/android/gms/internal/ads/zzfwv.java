package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfwv extends zzfwo {
    private final Object zza;

    zzfwv(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzfwv) {
            return this.zza.equals(((zzfwv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "Optional.of(" + obj + ")";
    }

    public final zzfwo zza(zzfwh zzfwh) {
        Object apply = zzfwh.apply(this.zza);
        zzfwq.zzc(apply, "the Function passed to Optional.transform() must not return null.");
        return new zzfwv(apply);
    }

    public final Object zzb(Object obj) {
        return this.zza;
    }
}
