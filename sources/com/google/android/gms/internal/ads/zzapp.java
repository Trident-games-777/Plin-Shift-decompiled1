package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzapp implements Comparable {
    /* access modifiers changed from: private */
    public final zzaqa zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzapt zzf;
    private Integer zzg;
    private zzaps zzh;
    private boolean zzi;
    private zzaoy zzj;
    private zzapo zzk;
    private final zzapd zzl;

    public zzapp(int i, String str, zzapt zzapt) {
        Uri parse;
        String host;
        this.zza = zzaqa.zza ? new zzaqa() : null;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzapt;
        this.zzl = new zzapd();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzapp) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        Integer num = this.zzg;
        return "[ ] " + this.zzc + " " + "0x".concat(valueOf) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzaoy zzd() {
        return this.zzj;
    }

    public final zzapp zze(zzaoy zzaoy) {
        this.zzj = zzaoy;
        return this;
    }

    public final zzapp zzf(zzaps zzaps) {
        this.zzh = zzaps;
        return this;
    }

    public final zzapp zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzapv zzh(zzapl zzapl);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        String num = Integer.toString(1);
        return num + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaox {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaqa.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzapy zzapy) {
        zzapt zzapt;
        synchronized (this.zze) {
            zzapt = this.zzf;
        }
        zzapt.zza(zzapy);
    }

    /* access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzaps zzaps = this.zzh;
        if (zzaps != null) {
            zzaps.zzb(this);
        }
        if (zzaqa.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapn(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzapo zzapo;
        synchronized (this.zze) {
            zzapo = this.zzk;
        }
        if (zzapo != null) {
            zzapo.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs(zzapv zzapv) {
        zzapo zzapo;
        synchronized (this.zze) {
            zzapo = this.zzk;
        }
        if (zzapo != null) {
            zzapo.zzb(this, zzapv);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt(int i) {
        zzaps zzaps = this.zzh;
        if (zzaps != null) {
            zzaps.zzc(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu(zzapo zzapo) {
        synchronized (this.zze) {
            this.zzk = zzapo;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaox {
        return null;
    }

    public final zzapd zzy() {
        return this.zzl;
    }
}
