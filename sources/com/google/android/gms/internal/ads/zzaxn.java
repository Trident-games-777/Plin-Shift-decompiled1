package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxn extends zzaxt {
    private final zzawm zzh;
    private long zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaxn(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, zzawm zzawm) {
        super(zzawf, "Atq0HLNiKHjz80ZnAFWvUPfMlGQHg7AXdMxxDL1JZ6bmQmTFxmAmKhIDk2Jnayuk", "Su/GzywZakXq4glBT/l81JrPkq4+JC0EaqCjCuVscxM=", zzasf, i, 53);
        this.zzh = zzawm;
        if (zzawm != null) {
            this.zzi = zzawm.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzP(((Long) this.zze.invoke((Object) null, new Object[]{Long.valueOf(this.zzi)})).longValue());
        }
    }
}
