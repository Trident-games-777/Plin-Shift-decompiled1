package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxg extends zzaxt {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzaxg(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        super(zzawf, "PDdqBkuC/wlZj3D1GonYQW5lEcio5HWZDbvjL/QlEgG/4K0ExN3jw7lwkOOq3/t+", "G3wZ8gDu6u4efTKrvmsEHv1YK8hQgMyBIdhh8ClIQBY=", zzasf, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzB(ExifInterface.LONGITUDE_EAST);
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (String) this.zze.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzd) {
            this.zzd.zzB(zzh);
        }
    }
}
