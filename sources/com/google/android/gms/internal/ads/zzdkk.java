package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdkk {
    private final zzdpn zza;
    private final zzdoc zzb;
    private final zzcoi zzc;
    private final zzdjg zzd;

    public zzdkk(zzdpn zzdpn, zzdoc zzdoc, zzcoi zzcoi, zzdjg zzdjg) {
        this.zza = zzdpn;
        this.zzb = zzdoc;
        this.zzc = zzcoi;
        this.zzd = zzdjg;
    }

    public final View zza() throws zzcfw {
        zzcfk zza2 = this.zza.zza(zzs.zzc(), (zzfet) null, (zzfew) null);
        zza2.zzF().setVisibility(8);
        zza2.zzag("/sendMessageToSdk", new zzdkf(this));
        zza2.zzag("/adMuted", new zzdkg(this));
        this.zzb.zzm(new WeakReference(zza2), "/loadHtml", new zzdkh(this));
        this.zzb.zzm(new WeakReference(zza2), "/showOverlay", new zzdki(this));
        this.zzb.zzm(new WeakReference(zza2), "/hideOverlay", new zzdkj(this));
        return zza2.zzF();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcfk zzcfk, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcfk zzcfk, Map map) {
        this.zzd.zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzcfk zzcfk, Map map) {
        zzm.zzi("Showing native ads overlay.");
        zzcfk.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcfk zzcfk, Map map) {
        zzm.zzi("Hiding native ads overlay.");
        zzcfk.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
