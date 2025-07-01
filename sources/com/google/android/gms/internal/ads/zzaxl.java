package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxl extends zzaxt {
    private final StackTraceElement[] zzh;

    public zzaxl(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzawf, "XiB4JwXCMuAhsrPKvk3dS2LvKyxjCmXSaJ2VZGWg6jlAdLRjKnhTMhSQBaeXXZDY", "3gV4tnMlvvkjR90RI+zlkPr5OOXNb6rIM0OBAfjFnhQ=", zzasf, i, 45);
        this.zzh = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzavw zzavw = new zzavw((String) this.zze.invoke((Object) null, new Object[]{stackTraceElementArr}));
            synchronized (this.zzd) {
                this.zzd.zzF(zzavw.zza.longValue());
                if (zzavw.zzb.booleanValue()) {
                    zzasf zzasf = this.zzd;
                    int i = 1;
                    if (true != zzavw.zzc.booleanValue()) {
                        i = 2;
                    }
                    zzasf.zzac(i);
                } else {
                    this.zzd.zzac(3);
                }
            }
        }
    }
}
