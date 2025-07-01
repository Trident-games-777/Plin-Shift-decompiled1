package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkc implements zzfka {
    private final Context zza;
    /* access modifiers changed from: private */
    public long zzb = 0;
    /* access modifiers changed from: private */
    public long zzc = -1;
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public int zze = 0;
    /* access modifiers changed from: private */
    public String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    /* access modifiers changed from: private */
    public zzfkq zzj = zzfkq.SCAR_REQUEST_TYPE_UNSPECIFIED;
    /* access modifiers changed from: private */
    public String zzk = "";
    /* access modifiers changed from: private */
    public String zzl = "";
    /* access modifiers changed from: private */
    public String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;
    /* access modifiers changed from: private */
    public final int zzp;
    /* access modifiers changed from: private */
    public int zzq = 2;
    /* access modifiers changed from: private */
    public int zzr = 2;

    zzfkc(Context context, int i) {
        this.zza = context;
        this.zzp = i;
    }

    public final synchronized zzfkc zzA() {
        this.zzc = zzv.zzC().elapsedRealtime();
        return this;
    }

    public final synchronized zzfkc zzK(int i) {
        this.zzq = i;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zza(zze zze2) {
        zzr(zze2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzb(zzffe zzffe) {
        zzs(zzffe);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzc(String str) {
        zzt(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzd(String str) {
        zzu(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zze(String str) {
        zzv(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzf(zzfkq zzfkq) {
        zzw(zzfkq);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzg(boolean z) {
        zzx(z);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzh(Throwable th) {
        zzy(th);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzi() {
        zzz();
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfka zzj() {
        zzA();
        return this;
    }

    public final synchronized boolean zzk() {
        return this.zzo;
    }

    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    public final synchronized zzfke zzm() {
        if (this.zzn) {
            return null;
        }
        this.zzn = true;
        if (!this.zzo) {
            zzz();
        }
        if (this.zzc < 0) {
            zzA();
        }
        return new zzfke(this, (zzfkd) null);
    }

    public final /* bridge */ /* synthetic */ zzfka zzn(int i) {
        zzK(i);
        return this;
    }

    public final synchronized zzfkc zzr(zze zze2) {
        IBinder iBinder = zze2.zze;
        if (iBinder != null) {
            zzcwf zzcwf = (zzcwf) iBinder;
            String zzk2 = zzcwf.zzk();
            if (!TextUtils.isEmpty(zzk2)) {
                this.zzf = zzk2;
            }
            String zzi2 = zzcwf.zzi();
            if (!TextUtils.isEmpty(zzi2)) {
                this.zzg = zzi2;
            }
        }
        return this;
    }

    public final synchronized zzfkc zzs(zzffe zzffe) {
        if (!TextUtils.isEmpty(zzffe.zzb.zzb)) {
            this.zzf = zzffe.zzb.zzb;
        }
        Iterator it = zzffe.zza.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfet zzfet = (zzfet) it.next();
            if (!TextUtils.isEmpty(zzfet.zzab)) {
                this.zzg = zzfet.zzab;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfkc zzt(String str) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziu)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }

    public final synchronized zzfkc zzu(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfkc zzv(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfkc zzw(zzfkq zzfkq) {
        this.zzj = zzfkq;
        return this;
    }

    public final synchronized zzfkc zzx(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfkc zzy(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziu)).booleanValue()) {
            this.zzl = zzbuj.zzf(th);
            this.zzk = (String) zzfxd.zzb(zzfwf.zzc(10)).zzc(zzbuj.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfkc zzz() {
        this.zze = zzv.zzr().zzm(this.zza);
        Resources resources = this.zza.getResources();
        int i = 2;
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                i = configuration.orientation == 2 ? 4 : 3;
            }
        }
        this.zzr = i;
        this.zzb = zzv.zzC().elapsedRealtime();
        this.zzo = true;
        return this;
    }
}
