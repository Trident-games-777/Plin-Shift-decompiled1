package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxs {
    private final zzawf zza;
    private final String zzb;
    private final String zzc;
    private volatile Method zzd = null;
    private final Class[] zze;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzaxs(zzawf zzawf, String str, String str2, Class... clsArr) {
        this.zza = zzawf;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzawf.zzk().submit(new zzaxr(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzaxs zzaxs) {
        try {
            zzawf zzawf = zzaxs.zza;
            Class loadClass = zzawf.zzi().loadClass(zzaxs.zzc(zzawf.zzu(), zzaxs.zzb));
            if (loadClass != null) {
                zzaxs.zzd = loadClass.getMethod(zzaxs.zzc(zzaxs.zza.zzu(), zzaxs.zzc), zzaxs.zze);
                Method method = zzaxs.zzd;
            }
        } catch (zzavj | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzaxs.zzf.countDown();
            throw th;
        }
        zzaxs.zzf.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzavj, UnsupportedEncodingException {
        return new String(this.zza.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (!this.zzf.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzd;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
