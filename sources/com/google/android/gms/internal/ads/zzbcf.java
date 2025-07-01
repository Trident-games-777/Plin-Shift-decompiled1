package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbcf {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbce zza2 : this.zzb) {
            String str = (String) zzbe.zzc().zza(zza2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbco.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbce zza3 : this.zzc) {
            String str = (String) zzbe.zzc().zza(zza3);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbco.zzb());
        return zza2;
    }

    public final void zzc(zzbce zzbce) {
        this.zzb.add(zzbce);
    }

    public final void zzd(zzbce zzbce) {
        this.zza.add(zzbce);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbce zzbce : this.zza) {
            if (zzbce.zze() == 1) {
                zzbce.zzd(editor, zzbce.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzm.zzg("Flag Json is null.");
        }
    }
}
