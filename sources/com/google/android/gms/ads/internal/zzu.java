package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzcc;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzct;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzavd;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzcaj;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzu extends zzbx {
    /* access modifiers changed from: private */
    public final VersionInfoParcel zza;
    private final zzs zzb;
    /* access modifiers changed from: private */
    public final Future zzc = zzcaj.zza.zzb(new zzq(this));
    /* access modifiers changed from: private */
    public final Context zzd;
    private final zzs zze;
    /* access modifiers changed from: private */
    public WebView zzf;
    /* access modifiers changed from: private */
    public zzbl zzg;
    /* access modifiers changed from: private */
    public zzavc zzh;
    private AsyncTask zzi;

    public zzu(Context context, zzs zzs, String str, VersionInfoParcel versionInfoParcel) {
        this.zzd = context;
        this.zza = versionInfoParcel;
        this.zzb = zzs;
        this.zzf = new WebView(context);
        this.zze = new zzs(context, str);
        zzV(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzo(this));
        this.zzf.setOnTouchListener(new zzp(this));
    }

    static /* bridge */ /* synthetic */ String zzo(zzu zzu, String str) {
        if (zzu.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzu.zzh.zza(parse, zzu.zzd, (View) null, (Activity) null);
        } catch (zzavd e) {
            zzm.zzk("Unable to process ad data", e);
        }
        return parse.toString();
    }

    static /* bridge */ /* synthetic */ void zzw(zzu zzu, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzu.zzd.startActivity(intent);
    }

    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbi zzbi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(zzbl zzbl) throws RemoteException {
        this.zzg = zzbl;
    }

    public final void zzE(zzcc zzcc) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzF(zzs zzs) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzG(zzcm zzcm) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzbai zzbai) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzy zzy) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(zzct zzct) {
    }

    public final void zzK(zzef zzef) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzL(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzM(zzbtp zzbtp) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzN(boolean z) throws RemoteException {
    }

    public final void zzO(zzbdi zzbdi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzP(zzdr zzdr) {
    }

    public final void zzQ(zzbts zzbts, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzS(zzbwp zzbwp) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzT(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzU(zzga zzga) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final void zzV(int i) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa() throws RemoteException {
        return false;
    }

    public final boolean zzab(com.google.android.gms.ads.internal.client.zzm zzm) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzm, this.zza);
        this.zzi = new zzr(this, (zzt) null).execute(new Void[0]);
        return true;
    }

    public final void zzac(zzcq zzcq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzbc.zzb();
            return zzf.zzy(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    public final zzs zzg() throws RemoteException {
        return this.zzb;
    }

    public final zzbl zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final zzcm zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzdy zzk() {
        return null;
    }

    public final zzeb zzl() {
        return null;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final String zzp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbdz.zzd.zze());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zze.zzd());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        builder.appendQueryParameter("mappver", this.zze.zza());
        Map zze2 = this.zze.zze();
        for (String str : zze2.keySet()) {
            builder.appendQueryParameter(str, (String) zze2.get(str));
        }
        Uri build = builder.build();
        zzavc zzavc = this.zzh;
        if (zzavc != null) {
            try {
                build = zzavc.zzb(build, this.zzd);
            } catch (zzavd e) {
                zzm.zzk("Unable to process ad data", e);
            }
        }
        String zzq = zzq();
        String encodedQuery = build.getEncodedQuery();
        return zzq + "#" + encodedQuery;
    }

    /* access modifiers changed from: package-private */
    public final String zzq() {
        String zzb2 = this.zze.zzb();
        if (true == TextUtils.isEmpty(zzb2)) {
            zzb2 = "www.google.com";
        }
        return "https://" + zzb2 + ((String) zzbdz.zzd.zze());
    }

    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final String zzs() throws RemoteException {
        return null;
    }

    public final String zzt() throws RemoteException {
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(false);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final void zzy(com.google.android.gms.ads.internal.client.zzm zzm, zzbo zzbo) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
