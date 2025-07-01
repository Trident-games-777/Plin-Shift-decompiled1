package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzevk implements zzevz {
    private final zzbyv zza;
    private final zzges zzb;
    private final Context zzc;

    public zzevk(zzbyv zzbyv, zzges zzges, Context context) {
        this.zza = zzbyv;
        this.zzb = zzges;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzevj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzevl zzc() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        if (!this.zza.zzp(this.zzc)) {
            return new zzevl((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzd = this.zza.zzd(this.zzc);
        String str5 = zzd == null ? "" : zzd;
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str = "";
        } else {
            str = zzb2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str2 = "";
        } else {
            str2 = zza2;
        }
        Long l = null;
        if (true != this.zza.zzp(this.zzc)) {
            str3 = null;
        } else {
            str3 = "fa";
        }
        if ("TIME_OUT".equals(str)) {
            l = (Long) zzbe.zzc().zza(zzbcn.zzaq);
        }
        Long l2 = l;
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        return new zzevl(str5, str, str2, str4, l2);
    }
}
