package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvq {
    private final zzfjr zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhfr zzg;
    private final String zzh;
    private final zzewc zzi;
    private final zzg zzj;
    private final zzffo zzk;
    private final zzdbx zzl;

    public zzcvq(zzfjr zzfjr, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhfr zzhfr, zzg zzg2, String str2, zzewc zzewc, zzffo zzffo, zzdbx zzdbx) {
        this.zza = zzfjr;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhfr;
        this.zzh = str2;
        this.zzi = zzewc;
        this.zzj = zzg2;
        this.zzk = zzffo;
        this.zzl = zzdbx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbvx zza(ListenableFuture listenableFuture, Bundle bundle) throws Exception {
        Bundle bundle2 = (Bundle) listenableFuture.get();
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        boolean z = false;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgS)).booleanValue() && this.zzj.zzN()) {
            z = true;
        }
        boolean z2 = z;
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        String str3 = this.zzd;
        return new zzbvx(bundle2, this.zzb, this.zzc, str3, list, packageInfo, str, str2, (zzfhj) null, (String) null, z2, this.zzk.zzb(), bundle);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzl.zza();
        return zzfjb.zzc(this.zzi.zza(new Bundle(), bundle), zzfjl.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzs;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        ListenableFuture zzb2 = zzb(bundle);
        return this.zza.zza(zzfjl.REQUEST_PARCEL, zzb2, (ListenableFuture) this.zzg.zzb()).zza(new zzcvp(this, zzb2, bundle)).zza();
    }
}
