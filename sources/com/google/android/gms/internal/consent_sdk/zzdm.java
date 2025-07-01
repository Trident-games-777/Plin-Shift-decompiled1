package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzdm implements zzdq {
    private static final Object zza = new Object();
    private volatile zzdq zzb;
    private volatile Object zzc = zza;

    private zzdm(zzdq zzdq) {
        this.zzb = zzdq;
    }

    public static zzdq zzb(zzdq zzdq) {
        return zzdq instanceof zzdm ? zzdq : new zzdm(zzdq);
    }

    public final Object zza() {
        Object obj;
        Object obj2 = this.zzc;
        Object obj3 = zza;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            obj = this.zzc;
            if (obj == obj3) {
                obj = this.zzb.zza();
                Object obj4 = this.zzc;
                if (obj4 != obj3) {
                    if (obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                }
                this.zzc = obj;
                this.zzb = null;
            }
        }
        return obj;
    }
}
