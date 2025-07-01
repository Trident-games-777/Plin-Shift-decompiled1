package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbux;
import com.google.android.gms.internal.ads.zzbyh;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbyh zzc;
    private final zzbux zzd = new zzbux(false, Collections.emptyList());

    public zzb(Context context, zzbyh zzbyh, zzbux zzbux) {
        this.zza = context;
        this.zzc = zzbyh;
    }

    private final boolean zzd() {
        zzbyh zzbyh = this.zzc;
        return (zzbyh != null && zzbyh.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbyh zzbyh = this.zzc;
            if (zzbyh != null) {
                zzbyh.zzd(str, (Map) null, 3);
                return;
            }
            zzbux zzbux = this.zzd;
            if (zzbux.zza && (list = zzbux.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        Context context = this.zza;
                        zzv.zzq();
                        zzs.zzL(context, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
