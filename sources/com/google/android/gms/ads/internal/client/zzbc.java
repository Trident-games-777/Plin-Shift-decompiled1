package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbtd;
import com.google.android.gms.internal.ads.zzbxo;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbc {
    public static final /* synthetic */ int zza = 0;
    private static final zzbc zzb = new zzbc();
    private final zzf zzc;
    private final zzba zzd;
    private final String zze;
    private final VersionInfoParcel zzf;
    private final Random zzg;

    protected zzbc() {
        zzf zzf2 = new zzf();
        zzba zzba = new zzba(new zzk(), new zzi(), new zzfe(), new zzbhx(), new zzbxo(), new zzbtd(), new zzbhy(), new zzl());
        String zze2 = zzf.zze();
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, 243799000, true);
        Random random = new Random();
        this.zzc = zzf2;
        this.zzd = zzba;
        this.zze = zze2;
        this.zzf = versionInfoParcel;
        this.zzg = random;
    }

    public static zzba zza() {
        return zzb.zzd;
    }

    public static zzf zzb() {
        return zzb.zzc;
    }

    public static VersionInfoParcel zzc() {
        return zzb.zzf;
    }

    public static String zzd() {
        return zzb.zze;
    }

    public static Random zze() {
        return zzb.zzg;
    }
}
