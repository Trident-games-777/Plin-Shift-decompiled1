package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzee;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcgm extends zzea {
    private final zzccf zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private zzee zzf;
    private boolean zzg;
    private boolean zzh = true;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbhg zzn;

    public zzcgm(zzccf zzccf, float f, boolean z, boolean z2) {
        this.zza = zzccf;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(int i, int i2, boolean z, boolean z2) {
        zzcaj.zze.execute(new zzcgl(this, i, i2, z, z2));
    }

    private final void zzx(String str, Map map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzcaj.zze.execute(new zzcgk(this, hashMap));
    }

    public final void zzc(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi) {
                if (f3 == this.zzk) {
                    z2 = false;
                }
            }
            this.zzi = f2;
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmw)).booleanValue()) {
                this.zzj = f;
            }
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzF().invalidate();
            }
        }
        if (z2) {
            try {
                zzbhg zzbhg = this.zzn;
                if (zzbhg != null) {
                    zzbhg.zze();
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        zzw(i2, i, z3, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        zzee zzee;
        zzee zzee2;
        zzee zzee3;
        synchronized (this.zzb) {
            boolean z5 = this.zzg;
            boolean z6 = false;
            if (z5 || i2 != 1) {
                i3 = i2;
                z3 = false;
            } else {
                i2 = 1;
                i3 = 1;
                z3 = true;
            }
            boolean z7 = i != i2;
            if (!z7 || i3 != 1) {
                z4 = false;
            } else {
                z4 = true;
                i3 = 1;
            }
            boolean z8 = z7 && i3 == 2;
            boolean z9 = z7 && i3 == 3;
            if (z5 || z3) {
                z6 = true;
            }
            this.zzg = z6;
            if (z3) {
                try {
                    zzee zzee4 = this.zzf;
                    if (zzee4 != null) {
                        zzee4.zzi();
                    }
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
            if (z4 && (zzee3 = this.zzf) != null) {
                zzee3.zzh();
            }
            if (z8 && (zzee2 = this.zzf) != null) {
                zzee2.zzg();
            }
            if (z9) {
                zzee zzee5 = this.zzf;
                if (zzee5 != null) {
                    zzee5.zze();
                }
                this.zza.zzw();
            }
            if (!(z == z2 || (zzee = this.zzf) == null)) {
                zzee.zzf(z2);
            }
        }
    }

    public final float zze() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    public final float zzf() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    public final float zzg() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    public final int zzh() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    public final zzee zzi() throws RemoteException {
        zzee zzee;
        synchronized (this.zzb) {
            zzee = this.zzf;
        }
        return zzee;
    }

    public final void zzj(boolean z) {
        zzx(true != z ? "unmute" : "mute", (Map) null);
    }

    public final void zzk() {
        zzx("pause", (Map) null);
    }

    public final void zzl() {
        zzx("play", (Map) null);
    }

    public final void zzm(zzee zzee) {
        synchronized (this.zzb) {
            this.zzf = zzee;
        }
    }

    public final void zzn() {
        zzx("stop", (Map) null);
    }

    public final boolean zzo() {
        boolean z;
        Object obj = this.zzb;
        boolean zzp = zzp();
        synchronized (obj) {
            z = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final boolean zzp() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    /* JADX INFO: finally extract failed */
    public final void zzs(zzga zzga) {
        String str;
        String str2;
        String str3;
        Object obj = this.zzb;
        boolean z = zzga.zza;
        boolean z2 = zzga.zzb;
        boolean z3 = zzga.zzc;
        synchronized (obj) {
            try {
                this.zzl = z2;
                this.zzm = z3;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (true != z) {
            str = "0";
        } else {
            str = DiskLruCache.VERSION;
        }
        String str4 = str;
        if (true != z2) {
            str2 = "0";
        } else {
            str2 = DiskLruCache.VERSION;
        }
        String str5 = str2;
        if (true != z3) {
            str3 = "0";
        } else {
            str3 = DiskLruCache.VERSION;
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", str4, "customControlsRequested", str5, "clickToExpandRequested", str3));
    }

    public final void zzt(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zzu() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzw(i, 3, z, z);
    }

    public final void zzv(zzbhg zzbhg) {
        synchronized (this.zzb) {
            this.zzn = zzbhg;
        }
    }
}
