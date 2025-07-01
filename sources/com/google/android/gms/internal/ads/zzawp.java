package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawp extends zzaxt {
    private final Activity zzh;
    private final View zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzawp(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, View view, Activity activity) {
        super(zzawf, "s0uE9hdlawP+tYGHYSI6i0EWhWy7Tdc9XW5A0finsHWGrmLjBRDuDmlHo7fmD8mf", "0+4i1BfON/tZfr/zJSlwHIdubE7ug8Met8dVp0E6y4I=", zzasf, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzcI)).booleanValue();
            Object[] objArr = (Object[]) this.zze.invoke((Object) null, new Object[]{this.zzi, this.zzh, Boolean.valueOf(booleanValue)});
            synchronized (this.zzd) {
                this.zzd.zzc(((Long) objArr[0]).longValue());
                this.zzd.zze(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzd.zzd((String) objArr[2]);
                }
            }
        }
    }
}
