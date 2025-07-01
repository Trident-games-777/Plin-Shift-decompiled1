package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zztz extends zztq {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhd zzc;

    protected zztz() {
    }

    /* access modifiers changed from: protected */
    public abstract void zzA(Object obj, zzut zzut, zzbv zzbv);

    /* access modifiers changed from: protected */
    public final void zzB(Object obj, zzut zzut) {
        zzdb.zzd(!this.zza.containsKey(obj));
        zztw zztw = new zztw(this, obj);
        zztx zztx = new zztx(this, obj);
        this.zza.put(obj, new zzty(zzut, zztw, zztx));
        Handler handler = this.zzb;
        handler.getClass();
        Handler handler2 = handler;
        zzut.zzh(handler, zztx);
        Handler handler3 = this.zzb;
        handler3.getClass();
        Handler handler4 = handler3;
        zzut.zzg(handler3, zztx);
        zzut.zzm(zztw, this.zzc, zzb());
        if (!zzu()) {
            zzut.zzi(zztw);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        for (zzty zzty : this.zza.values()) {
            zzty.zza.zzi(zzty.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl() {
        for (zzty zzty : this.zza.values()) {
            zzty.zza.zzk(zzty.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public void zzn(zzhd zzhd) {
        this.zzc = zzhd;
        this.zzb = zzen.zzy((Handler.Callback) null);
    }

    /* access modifiers changed from: protected */
    public void zzq() {
        for (zzty zzty : this.zza.values()) {
            zzty.zza.zzp(zzty.zzb);
            zzty.zza.zzs(zzty.zzc);
            zzty.zza.zzr(zzty.zzc);
        }
        this.zza.clear();
    }

    /* access modifiers changed from: protected */
    public int zzw(Object obj, int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public long zzx(Object obj, long j, zzur zzur) {
        return j;
    }

    /* access modifiers changed from: protected */
    public zzur zzy(Object obj, zzur zzur) {
        throw null;
    }

    public void zzz() throws IOException {
        for (zzty zzty : this.zza.values()) {
            zzty.zza.zzz();
        }
    }
}
