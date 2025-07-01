package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdav implements AppEventListener, OnAdMetadataChangedListener, zzcwm, zza, zzcyx, zzcxg, zzcyl, zzr, zzcxc, zzdel {
    private final zzdas zza = new zzdas(this, (zzdau) null);
    /* access modifiers changed from: private */
    @Nullable
    public zzems zzb;
    /* access modifiers changed from: private */
    @Nullable
    public zzemw zzc;
    /* access modifiers changed from: private */
    @Nullable
    public zzfar zzd;
    /* access modifiers changed from: private */
    @Nullable
    public zzfdw zze;

    private static void zzn(Object obj, zzdat zzdat) {
        if (obj != null) {
            zzdat.zza(obj);
        }
    }

    public final void onAdClicked() {
        zzn(this.zzb, new zzczl());
        zzn(this.zzc, new zzczm());
    }

    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzczr());
    }

    public final void onAppEvent(String str, String str2) {
        zzn(this.zzb, new zzczx(str, str2));
    }

    public final void zza() {
        zzn(this.zzb, new zzdaq());
        zzn(this.zze, new zzdar());
    }

    public final void zzb() {
        zzn(this.zzb, new zzdaj());
        zzn(this.zze, new zzdak());
    }

    public final void zzc() {
        zzn(this.zzb, new zzczs());
        zzn(this.zze, new zzczt());
    }

    public final void zzdG() {
        zzn(this.zzb, new zzdag());
        zzn(this.zzc, new zzdal());
        zzn(this.zze, new zzdam());
        zzn(this.zzd, new zzdan());
    }

    public final void zzdH() {
        zzn(this.zzd, new zzdae());
    }

    public final void zzdf() {
        zzn(this.zzb, new zzczy());
    }

    public final void zzdk() {
        zzn(this.zzd, new zzczq());
    }

    public final void zzdq() {
        zzn(this.zzd, new zzdad());
    }

    public final void zzdr() {
        zzn(this.zzd, new zzczz());
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
        zzn(this.zzb, new zzczu(zzbwj, str, str2));
        zzn(this.zze, new zzczw(zzbwj, str, str2));
    }

    public final void zzdt() {
        zzn(this.zzd, new zzdaf());
    }

    public final void zzdu(int i) {
        zzn(this.zzd, new zzdah(i));
    }

    public final void zze() {
        zzn(this.zzb, new zzczk());
        zzn(this.zze, new zzczv());
    }

    public final void zzf() {
        zzn(this.zzb, new zzczn());
        zzn(this.zze, new zzczo());
    }

    public final void zzg() {
        zzn(this.zzd, new zzdai());
    }

    public final void zzh(zzu zzu) {
        zzn(this.zzb, new zzdaa(zzu));
        zzn(this.zze, new zzdab(zzu));
        zzn(this.zzd, new zzdac(zzu));
    }

    public final zzdas zzi() {
        return this.zza;
    }

    public final void zzq(zze zze2) {
        zzn(this.zze, new zzdao(zze2));
        zzn(this.zzb, new zzdap(zze2));
    }

    public final void zzr() {
        zzn(this.zzb, new zzczp());
    }
}
