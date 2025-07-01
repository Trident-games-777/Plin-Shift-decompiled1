package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzduf implements Runnable {
    public final /* synthetic */ zzcao zza;

    public /* synthetic */ zzduf(zzdup zzdup, zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void run() {
        String zzc = zzv.zzp().zzi().zzg().zzc();
        boolean isEmpty = TextUtils.isEmpty(zzc);
        zzcao zzcao = this.zza;
        if (!isEmpty) {
            zzcao.zzc(zzc);
        } else {
            zzcao.zzd(new Exception());
        }
    }
}
