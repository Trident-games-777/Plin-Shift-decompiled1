package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbmx implements zzbmp, zzbmo {
    private final zzcfk zza;

    public zzbmx(Context context, VersionInfoParcel versionInfoParcel, zzavc zzavc, zza zza2) throws zzcfw {
        zzv.zzA();
        zzcfk zza3 = zzcfx.zza(context, zzche.zza(), "", false, false, (zzavc) null, (zzbdu) null, versionInfoParcel, (zzbdc) null, (zzn) null, (zza) null, zzbbl.zza(), (zzfet) null, (zzfew) null, (zzeea) null, (zzffs) null);
        this.zza = zza3;
        zza3.zzF().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzbc.zzb();
        if (zzf.zzv()) {
            zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
            return;
        }
        zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
        if (!zzs.zza.post(runnable)) {
            zzm.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    public final void zza(String str) {
        zze.zza("invokeJavascript on adWebView from js");
        zzs(new zzbmt(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbmn.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbmn.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbmn.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zze.zza("loadHtml on adWebView from html");
        zzs(new zzbmu(this, str));
    }

    public final void zzg(String str) {
        zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzbmr(this, str));
    }

    public final void zzh(String str) {
        zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzbmv(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaE();
    }

    public final zzbnw zzj() {
        return new zzbnw(this);
    }

    public final void zzk(zzbnd zzbnd) {
        zzchc zzN = this.zza.zzN();
        Objects.requireNonNull(zzbnd);
        zzN.zzI(new zzbms(zzbnd));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbmn.zzd(this, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final void zzq(String str, zzbjr zzbjr) {
        this.zza.zzag(str, new zzbmw(this, zzbjr));
    }

    public final void zzr(String str, zzbjr zzbjr) {
        this.zza.zzaA(str, new zzbmq(zzbjr));
    }
}
