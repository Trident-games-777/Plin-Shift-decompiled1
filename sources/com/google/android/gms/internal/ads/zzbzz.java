package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbzz {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb;
    private final zzcad zzc;
    private boolean zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public VersionInfoParcel zzf;
    private String zzg;
    /* access modifiers changed from: private */
    public zzbcs zzh;
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzbzx zzl;
    private final Object zzm;
    private ListenableFuture zzn;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzo;

    public zzbzz() {
        zzj zzj2 = new zzj();
        this.zzb = zzj2;
        this.zzc = new zzcad(zzbc.zzd(), zzj2);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzbzx((zzbzy) null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public final boolean zzA(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzib)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    public final Context zzd() {
        return this.zze;
    }

    public final Resources zze() {
        if (this.zzf.isClientJar) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkA)).booleanValue()) {
                return zzq.zza(this.zze).getResources();
            }
            zzq.zza(this.zze).getResources();
            return null;
        } catch (zzp e) {
            zzm.zzk("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final zzbcs zzg() {
        zzbcs zzbcs;
        synchronized (this.zza) {
            zzbcs = this.zzh;
        }
        return zzbcs;
    }

    public final zzcad zzh() {
        return this.zzc;
    }

    public final zzg zzi() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final ListenableFuture zzk() {
        if (this.zze != null) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzcV)).booleanValue()) {
                synchronized (this.zzm) {
                    ListenableFuture listenableFuture = this.zzn;
                    if (listenableFuture != null) {
                        return listenableFuture;
                    }
                    ListenableFuture zzb2 = zzcaj.zza.zzb(new zzbzu(this));
                    this.zzn = zzb2;
                    return zzb2;
                }
            }
        }
        return zzgei.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzo() throws Exception {
        Context zza2 = zzbwh.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    public final void zzu(Context context, VersionInfoParcel versionInfoParcel) {
        zzbcs zzbcs;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = versionInfoParcel;
                zzv.zzb().zzc(this.zzc);
                this.zzb.zzp(this.zze);
                zzbuj.zzb(this.zze, this.zzf);
                zzv.zze();
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzcd)).booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbcs = null;
                } else {
                    zzbcs = new zzbcs();
                }
                this.zzh = zzbcs;
                if (zzbcs != null) {
                    zzcam.zza(new zzbzv(this).zzb(), "AppState.registerCsiReporter");
                }
                Context context2 = this.zze;
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzib)).booleanValue()) {
                        try {
                            ((ConnectivityManager) context2.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzbzw(this));
                        } catch (RuntimeException e) {
                            zzm.zzk("Failed to register network callback", e);
                            this.zzo.set(true);
                        }
                    }
                }
                this.zzd = true;
                zzk();
            }
        }
        zzv.zzq().zzc(context, versionInfoParcel.afmaVersion);
    }

    public final void zzv(Throwable th, String str) {
        zzbuj.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbew.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbuj.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzx(Throwable th, String str) {
        zzbuj.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzy(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzz(String str) {
        this.zzg = str;
    }
}
