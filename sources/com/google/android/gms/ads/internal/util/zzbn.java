package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaox;
import com.google.android.gms.internal.ads.zzaps;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcao;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbn {
    private static zzaps zza;
    private static final Object zzb = new Object();

    public zzbn(Context context) {
        zzaps zzaps;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            if (zza == null) {
                zzbcn.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzev)).booleanValue()) {
                        zzaps = zzay.zzb(context);
                        zza = zzaps;
                    }
                }
                zzaqd zzaqd = null;
                zzaps = zzaqw.zza(context, (zzaqd) null);
                zza = zzaps;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzcao zzcao = new zzcao();
        zza.zza(new zzbl(str, (Map) null, zzcao));
        return zzcao;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbj zzbj = new zzbj((zzbm) null);
        zzbh zzbh = new zzbh(this, str, zzbj);
        zzl zzl = new zzl((String) null);
        String str2 = str;
        zzbi zzbi = new zzbi(this, i, str2, zzbj, zzbh, bArr, map, zzl);
        if (zzl.zzk()) {
            try {
                zzl.zzd(str2, "GET", zzbi.zzl(), zzbi.zzx());
            } catch (zzaox e) {
                zzm.zzj(e.getMessage());
            }
        }
        zza.zza(zzbi);
        return zzbj;
    }
}
