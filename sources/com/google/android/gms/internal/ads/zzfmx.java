package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmx {
    private final zzfni zza;
    private final zzfni zzb;
    private final boolean zzc;
    private final zzfnb zzd;
    private final zzfne zze;

    private zzfmx(zzfnb zzfnb, zzfne zzfne, zzfni zzfni, zzfni zzfni2, boolean z) {
        this.zzd = zzfnb;
        this.zze = zzfne;
        this.zza = zzfni;
        if (zzfni2 == null) {
            this.zzb = zzfni.NONE;
        } else {
            this.zzb = zzfni2;
        }
        this.zzc = z;
    }

    public static zzfmx zza(zzfnb zzfnb, zzfne zzfne, zzfni zzfni, zzfni zzfni2, boolean z) {
        zzfor.zzc(zzfnb, "CreativeType is null");
        zzfor.zzc(zzfne, "ImpressionType is null");
        zzfor.zzc(zzfni, "Impression owner is null");
        if (zzfni == zzfni.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfnb == zzfnb.DEFINED_BY_JAVASCRIPT && zzfni == zzfni.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfne != zzfne.DEFINED_BY_JAVASCRIPT || zzfni != zzfni.NATIVE) {
            return new zzfmx(zzfnb, zzfne, zzfni, zzfni2, z);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfon.zze(jSONObject, "impressionOwner", this.zza);
        zzfon.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfon.zze(jSONObject, "creativeType", this.zzd);
        zzfon.zze(jSONObject, "impressionType", this.zze);
        zzfon.zze(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.zzc));
        return jSONObject;
    }
}
