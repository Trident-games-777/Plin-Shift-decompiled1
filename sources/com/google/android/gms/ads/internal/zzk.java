package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzarh;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzauq;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzfpp;
import com.google.android.gms.internal.ads.zzfqr;
import com.google.android.gms.internal.ads.zzfrl;
import com.google.android.gms.internal.ads.zzgei;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzk implements Runnable, zzaux {
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfpp zzi;
    private Context zzj;
    private final Context zzk;
    private VersionInfoParcel zzl;
    private final VersionInfoParcel zzm;
    private final boolean zzn;
    private int zzo;

    public zzk(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = versionInfoParcel;
        this.zzm = versionInfoParcel;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzcx)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfpp.zza(context, newCachedThreadPool, booleanValue);
        this.zzf = ((Boolean) zzbe.zzc().zza(zzbcn.zzcu)).booleanValue();
        this.zzg = ((Boolean) zzbe.zzc().zza(zzbcn.zzcy)).booleanValue();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcw)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzdz)).booleanValue()) {
            this.zza = zzi();
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdt)).booleanValue()) {
            zzcaj.zza.execute(this);
            return;
        }
        zzbc.zzb();
        if (zzf.zzv()) {
            zzcaj.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzaux zzq() {
        if (zzm() == 2) {
            return (zzaux) this.zze.get();
        }
        return (zzaux) this.zzd.get();
    }

    private final void zzr() {
        List list = this.zzc;
        zzaux zzq = zzq();
        if (!list.isEmpty() && zzq != null) {
            for (Object[] objArr : this.zzc) {
                int length = objArr.length;
                if (length == 1) {
                    zzq.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzq.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzs(boolean z) {
        String str = this.zzl.afmaVersion;
        Context zzt = zzt(this.zzj);
        zzarh zza2 = zzarj.zza();
        zza2.zza(z);
        zza2.zzb(str);
        this.zzd.set(zzavb.zzu(zzt, new zzauz((zzarj) zza2.zzbr())));
    }

    private static final Context zzt(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static final zzauu zzu(Context context, VersionInfoParcel versionInfoParcel, boolean z, boolean z2) {
        zzarh zza2 = zzarj.zza();
        zza2.zza(z);
        zza2.zzb(versionInfoParcel.afmaVersion);
        return zzauu.zza(zzt(context), (zzarj) zza2.zzbr(), z2);
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdz)).booleanValue()) {
                this.zza = zzi();
            }
            boolean z2 = this.zzl.isClientJar;
            z = false;
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzbd)).booleanValue() && z2) {
                z = true;
            }
            if (zzm() == 1) {
                zzs(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzi(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzauu zzu = zzu(this.zzj, this.zzl, z, this.zzn);
                this.zze.set(zzu);
                if (this.zzg && !zzu.zzr()) {
                    this.zzo = 1;
                    zzs(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzs(z);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    public final String zzb(Context context, byte[] bArr) {
        zzaux zzq;
        if (!zzj() || (zzq = zzq()) == null) {
            return "";
        }
        zzr();
        return zzq.zzf(zzt(context));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzu(this.zzk, this.zzm, z, this.zzn).zzp();
        } catch (NullPointerException e) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, (Activity) null);
    }

    public final String zze(Context context, String str, View view, Activity activity) {
        if (!zzj()) {
            return "";
        }
        zzaux zzq = zzq();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzko)).booleanValue()) {
            zzv.zzq();
            zzs.zzJ(view, 4, (MotionEvent) null);
        }
        if (zzq == null) {
            return "";
        }
        zzr();
        return zzq.zze(zzt(context), str, view, activity);
    }

    public final String zzf(Context context) {
        return zzb(context, (byte[]) null);
    }

    public final String zzg(Context context) {
        try {
            return (String) zzgei.zzj(new zzh(this, context), this.zzh).get((long) ((Integer) zzbe.zzc().zza(zzbcn.zzcO)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzauq.zza(context, this.zzm.afmaVersion, true);
        }
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzkn)).booleanValue()) {
            zzaux zzq = zzq();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzko)).booleanValue()) {
                zzv.zzq();
                zzs.zzJ(view, 2, (MotionEvent) null);
            }
            if (zzq != null) {
                return zzq.zzh(context, view, activity);
            }
            return "";
        } else if (!zzj()) {
            return "";
        } else {
            zzaux zzq2 = zzq();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzko)).booleanValue()) {
                zzv.zzq();
                zzs.zzJ(view, 2, (MotionEvent) null);
            }
            return zzq2 != null ? zzq2.zzh(context, view, activity) : "";
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzi() {
        Context context = this.zzj;
        zzj zzj2 = new zzj(this);
        zzfpp zzfpp = this.zzi;
        return new zzfrl(this.zzj, zzfqr.zzb(context, zzfpp), zzj2, ((Boolean) zzbe.zzc().zza(zzbcn.zzcv)).booleanValue()).zzd(1);
    }

    public final boolean zzj() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            zzm.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public final void zzk(MotionEvent motionEvent) {
        zzaux zzq = zzq();
        if (zzq != null) {
            zzr();
            zzq.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i, int i2, int i3) {
        zzaux zzq = zzq();
        if (zzq != null) {
            zzr();
            zzq.zzl(i, i2, i3);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* access modifiers changed from: protected */
    public final int zzm() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaux zzq;
        zzaux zzq2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcT)).booleanValue()) {
            if (this.zzb.getCount() == 0 && (zzq2 = zzq()) != null) {
                zzq2.zzn(stackTraceElementArr);
            }
        } else if (zzj() && (zzq = zzq()) != null) {
            zzq.zzn(stackTraceElementArr);
        }
    }

    public final void zzo(View view) {
        zzaux zzq = zzq();
        if (zzq != null) {
            zzq.zzo(view);
        }
    }

    public final int zzp() {
        return this.zzo;
    }
}
