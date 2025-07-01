package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaws extends zzaxt {
    private static final zzaxu zzh = new zzaxu();
    private final Context zzi;

    public zzaws(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, Context context) {
        super(zzawf, "lIDPVUPkMEk1KnSIojzWRzc28dDnPbiGtgyxpW7TpbmhRjdqd91I/FiR+wuEiwMR", "KJxrJ6uU/9eq7G+RMyslIXmSG1J2c6lM89WgXCr+3Fk=", zzasf, i, 29);
        this.zzi = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzn(ExifInterface.LONGITUDE_EAST);
        AtomicReference zza = zzh.zza(this.zzi.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zze.invoke((Object) null, new Object[]{this.zzi}));
                }
            }
        }
        String str = (String) zza.get();
        synchronized (this.zzd) {
            this.zzd.zzn(zzatt.zza(str.getBytes(), true));
        }
    }
}
