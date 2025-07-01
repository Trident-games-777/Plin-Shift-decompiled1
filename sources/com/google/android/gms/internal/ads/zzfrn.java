package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfrn {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfro zzc;
    private final zzfpp zzd;
    private final zzfpk zze;
    private zzfrc zzf;
    private final Object zzg = new Object();

    public zzfrn(Context context, zzfro zzfro, zzfpp zzfpp, zzfpk zzfpk) {
        this.zzb = context;
        this.zzc = zzfro;
        this.zzd = zzfpp;
        this.zze = zzfpk;
    }

    private final synchronized Class zzd(zzfrd zzfrd) throws zzfrm {
        String zzk = zzfrd.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfrd.zzc())) {
                File zzb2 = zzfrd.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class loadClass = new DexClassLoader(zzfrd.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfrm(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzfrm(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzfrm(2008, e2);
        }
    }

    public final zzfps zza() {
        zzfrc zzfrc;
        synchronized (this.zzg) {
            zzfrc = this.zzf;
        }
        return zzfrc;
    }

    public final zzfrd zzb() {
        synchronized (this.zzg) {
            zzfrc zzfrc = this.zzf;
            if (zzfrc == null) {
                return null;
            }
            zzfrd zzf2 = zzfrc.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzfrd zzfrd) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzfrd);
            zzfrc zzfrc = new zzfrc(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfrd.zze(), null, new Bundle(), 2}), zzfrd, this.zzc, this.zzd);
            if (zzfrc.zzh()) {
                int zze2 = zzfrc.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfrc zzfrc2 = this.zzf;
                        if (zzfrc2 != null) {
                            try {
                                zzfrc2.zzg();
                            } catch (zzfrm e) {
                                this.zzd.zzc(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzfrc;
                    }
                    this.zzd.zzd(PathInterpolatorCompat.MAX_NUM_POINTS, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfrm(4001, "ci: " + zze2);
            }
            throw new zzfrm(4000, "init failed");
        } catch (Exception e2) {
            throw new zzfrm(2004, (Throwable) e2);
        } catch (zzfrm e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
