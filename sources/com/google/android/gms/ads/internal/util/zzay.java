package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzaps;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzaql;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzfsb;
import com.google.android.gms.internal.ads.zzfsc;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzay extends zzaqe {
    private final Context zzb;

    private zzay(Context context, zzaqd zzaqd) {
        super(zzaqd);
        this.zzb = context;
    }

    public static zzaps zzb(Context context) {
        zzaps zzaps = new zzaps(new zzaql(new File(zzfsc.zza(zzfsb.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzay(context, new zzaqq((zzaqp) null, (SSLSocketFactory) null)), 4);
        zzaps.zzd();
        return zzaps;
    }

    public final zzapl zza(zzapp zzapp) throws zzapy {
        if (zzapp.zza() == 0) {
            if (Pattern.matches((String) zzbe.zzc().zza(zzbcn.zzew), zzapp.zzk())) {
                Context context = this.zzb;
                zzbc.zzb();
                if (zzf.zzt(context, 13400000)) {
                    zzapl zza = new zzblo(this.zzb).zza(zzapp);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzapp.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzapp.zzk())));
                }
            }
        }
        return super.zza(zzapp);
    }
}
