package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbsj extends zzbsk implements zzbjr {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcfk zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbbv zzk;
    private float zzl;
    private int zzm;

    public zzbsj(zzcfk zzcfk, Context context, zzbbv zzbbv) {
        super(zzcfk, "");
        this.zzh = zzcfk;
        this.zzi = context;
        this.zzk = zzbbv;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcfk zzcfk = (zzcfk) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzbc.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzf.zzw(displayMetrics, displayMetrics.widthPixels);
        zzbc.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzf.zzw(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzi2 = this.zzh.zzi();
        if (zzi2 == null || zzi2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzv.zzq();
            int[] zzQ = zzs.zzQ(zzi2);
            zzbc.zzb();
            this.zzd = zzf.zzw(this.zza, zzQ[0]);
            zzbc.zzb();
            this.zze = zzf.zzw(this.zza, zzQ[1]);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbsi zzbsi = new zzbsi();
        zzbbv zzbbv = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbsi.zze(zzbbv.zza(intent));
        zzbbv zzbbv2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbsi.zzc(zzbbv2.zza(intent2));
        zzbsi.zza(this.zzk.zzb());
        zzbsi.zzd(this.zzk.zzc());
        zzbsi.zzb(true);
        boolean zzh2 = zzbsi.zza;
        boolean zzj2 = zzbsi.zzb;
        boolean zzf2 = zzbsi.zzc;
        boolean zzi3 = zzbsi.zzd;
        boolean zzg2 = zzbsi.zze;
        zzcfk zzcfk2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzh2).put("tel", zzj2).put("calendar", zzf2).put("storePicture", zzi3).put("inlineVideo", zzg2);
        } catch (JSONException e) {
            zzm.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzcfk2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzbc.zzb().zzb(this.zzi, iArr[0]), zzbc.zzb().zzb(this.zzi, iArr[1]));
        if (zze.zzm(2)) {
            zzm.zzi("Dispatching Ready Event.");
        }
        zzi(this.zzh.zzn().afmaVersion);
    }

    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            zzv.zzq();
            i3 = zzs.zzR((Activity) context)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            zzcfk zzcfk = this.zzh;
            int width = zzcfk.getWidth();
            int height = zzcfk.getHeight();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzaa)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzO() != null ? this.zzh.zzO().zzb : 0;
                }
                if (height == 0) {
                    if (this.zzh.zzO() != null) {
                        i4 = this.zzh.zzO().zza;
                    }
                    this.zzf = zzbc.zzb().zzb(this.zzi, width);
                    this.zzg = zzbc.zzb().zzb(this.zzi, i4);
                }
            }
            i4 = height;
            this.zzf = zzbc.zzb().zzb(this.zzi, width);
            this.zzg = zzbc.zzb().zzb(this.zzi, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzN().zzC(i, i2);
    }
}
