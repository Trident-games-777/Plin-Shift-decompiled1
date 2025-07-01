package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.core.app.NotificationManagerCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzip {
    final Context zza;
    zzdc zzb = zzdc.zza;
    zzfxg zzc;
    zzfxg zzd;
    zzfxg zze;
    zzfxg zzf;
    zzfxg zzg;
    zzfwh zzh;
    Looper zzi = zzen.zzz();
    int zzj = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    zzg zzk = zzg.zza;
    int zzl = 1;
    boolean zzm = true;
    zzls zzn = zzls.zzb;
    long zzo = 500;
    long zzp = 2000;
    boolean zzq = true;
    boolean zzr;
    String zzs = "";
    zzia zzt = new zzia(0.97f, 1.03f, 1000, 1.0E-7f, zzen.zzs(20), zzen.zzs(500), 0.999f, (zzhz) null);

    static /* synthetic */ zzuq zza(Context context) {
        return new zzue(context, new zzacl());
    }

    public zzip(Context context, zzcep zzcep) {
        Context context2 = context;
        zzii zzii = new zzii(zzcep);
        zzij zzij = new zzij(context2);
        zzik zzik = new zzik(context2);
        zzil zzil = new zzil();
        zzim zzim = new zzim(context2);
        zzin zzin = new zzin();
        context2.getClass();
        Context context3 = context2;
        this.zza = context2;
        this.zzc = zzii;
        this.zzd = zzij;
        this.zze = zzik;
        this.zzf = zzil;
        this.zzg = zzim;
        this.zzh = zzin;
    }
}
