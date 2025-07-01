package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbnu {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    /* access modifiers changed from: private */
    public final zzfko zze;
    private final zzbc zzf;
    private final zzbc zzg;
    /* access modifiers changed from: private */
    public zzbnt zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbnu(Context context, VersionInfoParcel versionInfoParcel, String str, zzbc zzbc, zzbc zzbc2, zzfko zzfko) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfko;
        this.zzf = zzbc;
        this.zzg = zzbc2;
    }

    public final zzbno zzb(zzavc zzavc) {
        zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("getEngine: Lock acquired");
            zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                zze.zza("refreshIfDestroyed: Lock acquired");
                zzbnt zzbnt = this.zzh;
                if (zzbnt != null && this.zzi == 0) {
                    zzbnt.zzj(new zzbna(this), new zzbnb());
                }
            }
            zze.zza("refreshIfDestroyed: Lock released");
            zzbnt zzbnt2 = this.zzh;
            if (zzbnt2 != null) {
                if (zzbnt2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        zze.zza("getEngine (NO_UPDATE): Lock released");
                        zzbno zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzi = 2;
                        zzd((zzavc) null);
                        zze.zza("getEngine (PENDING_UPDATE): Lock released");
                        zzbno zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zze.zza("getEngine (UPDATING): Lock released");
                        zzbno zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            this.zzh = zzd((zzavc) null);
            zze.zza("getEngine (NULL or REJECTED): Lock released");
            zzbno zza5 = this.zzh.zza();
            return zza5;
        }
    }

    /* access modifiers changed from: protected */
    public final zzbnt zzd(zzavc zzavc) {
        zzfka zza2 = zzfjz.zza(this.zzb, 6);
        zza2.zzi();
        zzbnt zzbnt = new zzbnt(this.zzg);
        zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        zzcaj.zze.execute(new zzbne(this, (zzavc) null, zzbnt));
        zze.zza("loadNewJavascriptEngine: Promise created");
        zzbnt.zzj(new zzbnj(this, zzbnt, zza2), new zzbnk(this, zzbnt, zza2));
        return zzbnt;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzbnt zzbnt, zzbmp zzbmp, ArrayList arrayList, long j) {
        zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbnt.zze() != -1) {
                if (zzbnt.zze() != 1) {
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzhq)).booleanValue()) {
                        zzbnt.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbnt.zzg();
                    }
                    zzges zzges = zzcaj.zze;
                    Objects.requireNonNull(zzbmp);
                    zzges.execute(new zzbnc(zzbmp));
                    String valueOf = String.valueOf(zzbe.zzc().zza(zzbcn.zzb));
                    int zze2 = zzbnt.zze();
                    int i = this.zzi;
                    String valueOf2 = String.valueOf(arrayList.get(0));
                    long currentTimeMillis = zzv.zzC().currentTimeMillis() - j;
                    zze.zza("Could not receive /jsLoaded in " + valueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zze2 + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + valueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + currentTimeMillis + " ms. Rejecting.");
                    zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzavc zzavc, zzbnt zzbnt) {
        long currentTimeMillis = zzv.zzC().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbmx zzbmx = new zzbmx(this.zzb, this.zzd, (zzavc) null, (zza) null);
            zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            long j = currentTimeMillis;
            ArrayList arrayList2 = arrayList;
            zzbmx zzbmx2 = zzbmx;
            zzbnt zzbnt2 = zzbnt;
            zzbnd zzbnd = new zzbnd(this, arrayList2, j, zzbnt2, zzbmx2);
            ArrayList arrayList3 = arrayList2;
            zzbnt zzbnt3 = zzbnt2;
            zzbmx zzbmx3 = zzbmx2;
            zzbmx3.zzk(zzbnd);
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbnt zzbnt4 = zzbnt3;
            zzbnt zzbnt5 = zzbnt4;
            long j2 = j;
            zzbmx3.zzq("/jsLoaded", new zzbnf(this, j, zzbnt4, zzbmx3));
            zzbx zzbx = new zzbx();
            zzbng zzbng = new zzbng(this, (zzavc) null, zzbmx3, zzbx);
            zzbx.zzb(zzbng);
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbmx3.zzq("/requestReload", zzbng);
            zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbmx3.zzh(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbmx3.zzf(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbmx3.zzg(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            ArrayList arrayList4 = arrayList3;
            zzs.zza.postDelayed(new zzbni(this, zzbnt5, zzbmx3, arrayList4, j2), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzc)).intValue());
        } catch (Throwable th) {
            zzbnt zzbnt6 = zzbnt;
            Throwable th2 = th;
            zzm.zzh("Error creating webview.", th2);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhq)).booleanValue()) {
                zzbnt6.zzh(th2, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhs)).booleanValue()) {
                zzv.zzp().zzv(th2, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbnt6.zzg();
                return;
            }
            zzv.zzp().zzw(th2, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbnt6.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzbmp zzbmp) {
        if (zzbmp.zzi()) {
            this.zzi = 1;
        }
    }
}
