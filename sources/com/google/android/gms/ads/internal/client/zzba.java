package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbtd;
import com.google.android.gms.internal.ads.zzbtg;
import com.google.android.gms.internal.ads.zzbul;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbxo;
import com.google.android.gms.internal.ads.zzbzh;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzba {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzfe zzc;
    /* access modifiers changed from: private */
    public final zzbhx zzd;
    /* access modifiers changed from: private */
    public final zzbtd zze;
    /* access modifiers changed from: private */
    public final zzbhy zzf;
    /* access modifiers changed from: private */
    public zzbul zzg;
    /* access modifiers changed from: private */
    public final zzl zzh;

    public zzba(zzk zzk, zzi zzi, zzfe zzfe, zzbhx zzbhx, zzbxo zzbxo, zzbtd zzbtd, zzbhy zzbhy, zzl zzl) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzfe;
        this.zzd = zzbhx;
        this.zze = zzbtd;
        this.zzf = zzbhy;
        this.zzh = zzl;
    }

    static /* bridge */ /* synthetic */ void zzv(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbc.zzb().zzo(context, zzbc.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbu zzd(Context context, String str, zzbpg zzbpg) {
        return (zzbu) new zzar(this, context, str, zzbpg).zzd(context, false);
    }

    public final zzby zze(Context context, zzs zzs, String str, zzbpg zzbpg) {
        Context context2 = context;
        return (zzby) new zzan(this, context2, zzs, str, zzbpg).zzd(context2, false);
    }

    public final zzby zzf(Context context, zzs zzs, String str, zzbpg zzbpg) {
        Context context2 = context;
        return (zzby) new zzap(this, context2, zzs, str, zzbpg).zzd(context2, false);
    }

    public final zzci zzg(Context context, zzbpg zzbpg) {
        return (zzci) new zzat(this, context, zzbpg).zzd(context, false);
    }

    public final zzdu zzh(Context context, zzbpg zzbpg) {
        return (zzdu) new zzaf(this, context, zzbpg).zzd(context, false);
    }

    public final zzbgc zzj(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbgc) new zzax(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbgi zzk(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbgi) new zzaz(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbkt zzn(Context context, zzbpg zzbpg, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbkt) new zzal(this, context, zzbpg, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbsz zzo(Context context, zzbpg zzbpg) {
        return (zzbsz) new zzaj(this, context, zzbpg).zzd(context, false);
    }

    public final zzbtg zzq(Activity activity) {
        zzad zzad = new zzad(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzm.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbtg) zzad.zzd(activity, z);
    }

    public final zzbxc zzs(Context context, String str, zzbpg zzbpg) {
        return (zzbxc) new zzab(this, context, str, zzbpg).zzd(context, false);
    }

    public final zzbzh zzt(Context context, zzbpg zzbpg) {
        return (zzbzh) new zzah(this, context, zzbpg).zzd(context, false);
    }
}
