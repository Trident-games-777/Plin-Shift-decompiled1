package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbcn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zza {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final List zzc;
    private final VersionInfoParcel zzd;
    private final JSONObject zze = new JSONObject();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    zza(Context context, zzbbw zzbbw, List list, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = list;
        this.zzd = versionInfoParcel;
    }

    public final JSONObject zza() {
        if (!this.zzf.get()) {
            zzb();
        }
        return this.zze;
    }

    public final void zzb() {
        if (!this.zzf.getAndSet(true)) {
            PackageInfo packageInfo = null;
            try {
                if (this.zzb != null) {
                    packageInfo = Wrappers.packageManager(this.zza).getPackageInfo(this.zzb.packageName, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo != null) {
                try {
                    this.zze.put("vc", packageInfo.versionCode);
                    this.zze.put("vnm", packageInfo.versionName);
                } catch (JSONException e) {
                    zzv.zzp().zzw(e, "PawAppSignalGenerator.initialize");
                    return;
                }
            }
            ApplicationInfo applicationInfo = this.zzb;
            if (applicationInfo != null) {
                this.zze.put("pn", applicationInfo.packageName);
            }
            JSONObject jSONObject = this.zze;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            for (String str : ((String) zzbe.zzc().zza(zzbcn.zzjs)).split(",", -1)) {
                if (list.contains(str)) {
                    arrayList.add(str);
                }
            }
            jSONObject.put("eid", arrayList);
            this.zze.put("js", this.zzd.afmaVersion);
            Iterator<String> keys = this.zze.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = this.zze.get(next);
                if (obj != null) {
                    this.zze.put(next, Base64.encodeToString(obj.toString().getBytes(), 2));
                }
            }
        }
    }
}
