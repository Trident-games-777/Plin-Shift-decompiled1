package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxp extends zzaxt {
    public zzaxp(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "88ETcPLh1JYg+nQ5zdwp+6acsWFKzCMthjLOw7XatJOMkLvYw0fl0jJT3ig1Ktkw", "AW0WUdAlySbPNJG5w1IgQqYKXV7WN2hB/EQpNB2ZwfA=", zzasf, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzag(3);
        boolean booleanValue = ((Boolean) this.zze.invoke((Object) null, new Object[]{this.zza.zzb()})).booleanValue();
        synchronized (this.zzd) {
            if (booleanValue) {
                this.zzd.zzag(2);
            } else {
                this.zzd.zzag(1);
            }
        }
    }
}
