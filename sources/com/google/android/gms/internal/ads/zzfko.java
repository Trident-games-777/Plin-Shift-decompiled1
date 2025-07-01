package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfko implements Runnable {
    public static final Object zza = new Object();
    public static Boolean zzb;
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzfkt zzg = zzfkx.zzb();
    private String zzh = "";
    private int zzi;
    private final zzdqa zzj;
    private final List zzk;
    private boolean zzl = false;
    private final zzbwf zzm;

    public zzfko(Context context, VersionInfoParcel versionInfoParcel, zzdqa zzdqa, zzebv zzebv, zzbwf zzbwf) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdqa;
        this.zzm = zzbwf;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziv)).booleanValue()) {
            this.zzk = zzs.zzd();
        } else {
            this.zzk = zzfzo.zzn();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        synchronized (zza) {
            if (zzb == null) {
                boolean z = false;
                if (!((Boolean) zzbeg.zzb.zze()).booleanValue()) {
                    zzb = false;
                } else {
                    if (Math.random() < ((Double) zzbeg.zza.zze()).doubleValue()) {
                        z = true;
                    }
                    zzb = Boolean.valueOf(z);
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    public final void run() {
        byte[] zzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() != 0) {
                    try {
                        synchronized (obj) {
                            zzaV = ((zzfkx) this.zzg.zzbr()).zzaV();
                            this.zzg.zzc();
                        }
                        zzebs zzebs = new zzebs((String) zzbe.zzc().zza(zzbcn.zzip), 60000, new HashMap(), zzaV, "application/x-protobuf", false);
                        zzebs zzebs2 = zzebs;
                        new zzebu(this.zze, this.zzf.afmaVersion, this.zzm, Binder.getCallingUid()).zza(zzebs);
                    } catch (Exception e) {
                        if (!(e instanceof zzdwn) || ((zzdwn) e).zza() != 3) {
                            zzv.zzp().zzv(e, "CuiMonitor.sendCuiPing");
                        }
                    }
                }
            }
        }
    }

    public final void zzb(zzfke zzfke) {
        zzcaj.zza.zza(new zzfkn(this, zzfke));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfke zzfke) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        zzv.zzq();
                        this.zzh = zzs.zzp(this.zze);
                    } catch (RemoteException | RuntimeException e) {
                        zzv.zzp().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int intValue = ((Integer) zzbe.zzc().zza(zzbcn.zziq)).intValue();
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzlB)).booleanValue()) {
                        long j = (long) intValue;
                        zzcaj.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = (long) intValue;
                        ScheduledExecutorService scheduledExecutorService = zzcaj.zzd;
                        scheduledExecutorService.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfke != null) {
            synchronized (zzc) {
                if (this.zzg.zza() < ((Integer) zzbe.zzc().zza(zzbcn.zzir)).intValue()) {
                    zzfkp zza2 = zzfks.zza();
                    zza2.zzu(zzfke.zzm());
                    zza2.zzq(zzfke.zzl());
                    zza2.zzg(zzfke.zzb());
                    zza2.zzw(3);
                    zza2.zzn(this.zzf.afmaVersion);
                    zza2.zzb(this.zzh);
                    zza2.zzk(Build.VERSION.RELEASE);
                    zza2.zzr(Build.VERSION.SDK_INT);
                    zza2.zzv(zzfke.zzo());
                    zza2.zzj(zzfke.zza());
                    zza2.zze((long) this.zzi);
                    zza2.zzt(zzfke.zzn());
                    zza2.zzc(zzfke.zze());
                    zza2.zzf(zzfke.zzg());
                    zza2.zzh(zzfke.zzh());
                    zza2.zzi(this.zzj.zzb(zzfke.zzh()));
                    zza2.zzl(zzfke.zzi());
                    zza2.zzm(zzfke.zzd());
                    zza2.zzd(zzfke.zzf());
                    zza2.zzs(zzfke.zzk());
                    zza2.zzo(zzfke.zzj());
                    zza2.zzp(zzfke.zzc());
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zziv)).booleanValue()) {
                        zza2.zza(this.zzk);
                    }
                    zzfkt zzfkt = this.zzg;
                    zzfku zza3 = zzfkv.zza();
                    zza3.zza(zza2);
                    zzfkt.zzb(zza3);
                }
            }
        }
    }
}
