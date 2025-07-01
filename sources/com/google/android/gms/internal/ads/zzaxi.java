package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxi extends zzaxt {
    public zzaxi(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "znXH0RM1XxCTrwmP7d8xA6zmeZad4bsyeawjZRDuwEtKXTURGEnX+tv9VD8MEWrm", "W+zVAKx2eduhDPC6RoJgOXSegMcVlCiHMJF4lAq9BYw=", zzasf, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            boolean booleanValue = ((Boolean) this.zze.invoke((Object) null, new Object[]{this.zza.zzb()})).booleanValue();
            zzasf zzasf = this.zzd;
            int i = 1;
            if (true == booleanValue) {
                i = 2;
            }
            zzasf.zzaf(i);
        } catch (InvocationTargetException unused) {
            this.zzd.zzaf(3);
        }
    }
}
