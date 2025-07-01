package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.zzv;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnu implements zzbob {
    private final Context zza;
    private final zzayi zzb;
    private final PowerManager zzc;

    public zzcnu(Context context, zzayi zzayi) {
        this.zza = context;
        this.zzb = zzayi;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcnx zzcnx) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzayl zzayl = zzcnx.zzf;
        if (zzayl == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z = zzayl.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzcnx.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false);
            boolean z2 = zzcnx.zzc;
            put.put("isStopped", false).put("isPaused", zzcnx.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzv.zzs().zze()).put("appVolume", (double) zzv.zzs().zza()).put("deviceVolume", (double) zzab.zzb(this.zza.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzayl.zzb).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzayl.zzc.top).put("bottom", zzayl.zzc.bottom).put("left", zzayl.zzc.left).put("right", zzayl.zzc.right)).put("adBox", new JSONObject().put("top", zzayl.zzd.top).put("bottom", zzayl.zzd.bottom).put("left", zzayl.zzd.left).put("right", zzayl.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzayl.zze.top).put("bottom", zzayl.zze.bottom).put("left", zzayl.zze.left).put("right", zzayl.zze.right)).put("globalVisibleBoxVisible", zzayl.zzf).put("localVisibleBox", new JSONObject().put("top", zzayl.zzg.top).put("bottom", zzayl.zzg.bottom).put("left", zzayl.zzg.left).put("right", zzayl.zzg.right)).put("localVisibleBoxVisible", zzayl.zzh).put("hitBox", new JSONObject().put("top", zzayl.zzi.top).put("bottom", zzayl.zzi.bottom).put("left", zzayl.zzi.left).put("right", zzayl.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcnx.zza);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzbw)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzayl.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcnx.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
