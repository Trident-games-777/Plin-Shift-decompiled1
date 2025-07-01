package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzcdr implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzcdr(zzccf zzccf) {
        Context context = zzccf.getContext();
        this.zza = context;
        this.zzb = zzv.zzq().zzc(context, zzccf.zzn().afmaVersion);
        this.zzc = new WeakReference(zzccf);
    }

    static /* bridge */ /* synthetic */ void zze(zzcdr zzcdr, String str, Map map) {
        zzccf zzccf = (zzccf) zzcdr.zzc.get();
        if (zzccf != null) {
            zzccf.zzd("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract void zzf();

    public final void zzg(String str, String str2, String str3, String str4) {
        zzf.zza.post(new zzcdq(this, str, str2, str3, str4));
    }

    /* access modifiers changed from: protected */
    public final void zzh(String str, String str2, int i) {
        zzf.zza.post(new zzcdo(this, str, str2, i));
    }

    public final void zzj(String str, String str2, long j) {
        zzf.zza.post(new zzcdp(this, str, str2, j));
    }

    public final void zzn(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzf.zza.post(new zzcdn(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zzo(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        zzf.zza.post(new zzcdm(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    /* access modifiers changed from: protected */
    public void zzp(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzq(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzr(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzs(int i) {
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzcdj zzcdj) {
        return zzt(str);
    }
}
