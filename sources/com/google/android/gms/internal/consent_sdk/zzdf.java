package com.google.android.gms.internal.consent_sdk;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
final class zzdf extends zzdj {
    private final Object zza;
    private boolean zzb;

    zzdf(Object obj) {
        this.zza = obj;
    }

    public final boolean hasNext() {
        return !this.zzb;
    }

    public final Object next() {
        if (!this.zzb) {
            this.zzb = true;
            return this.zza;
        }
        throw new NoSuchElementException();
    }
}
