package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawr extends zzaxt {
    public zzawr(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "cASF9v3LVjFjcts3pzkxEpbZ/yZ0Z6rgUJw8wYZADCZYBHbsegUqurxqMOQQnwLa", "YV8d9qma0OL6XD+53oet9uRH00OzaYnpRo+iusl6DCM=", zzasf, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzaa(3);
        try {
            boolean booleanValue = ((Boolean) this.zze.invoke((Object) null, new Object[]{this.zza.zzb()})).booleanValue();
            zzasf zzasf = this.zzd;
            int i = 1;
            if (true == booleanValue) {
                i = 2;
            }
            zzasf.zzaa(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
