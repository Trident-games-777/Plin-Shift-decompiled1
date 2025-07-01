package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzca {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzfzo zzh;
    /* access modifiers changed from: private */
    public final zzfzo zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzfzo zzl;
    /* access modifiers changed from: private */
    public final zzbz zzm;
    /* access modifiers changed from: private */
    public zzfzo zzn;
    /* access modifiers changed from: private */
    public int zzo;
    /* access modifiers changed from: private */
    public final HashMap zzp;
    /* access modifiers changed from: private */
    public final HashSet zzq;

    @Deprecated
    public zzca() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfzo.zzn();
        this.zzi = zzfzo.zzn();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfzo.zzn();
        this.zzm = zzbz.zza;
        this.zzn = zzfzo.zzn();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzca zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzen.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzfzo.zzo(locale.toLanguageTag());
            }
        }
        return this;
    }

    public final zzca zzf(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    protected zzca(zzcb zzcb) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzcb.zzi;
        this.zzf = zzcb.zzj;
        this.zzg = zzcb.zzk;
        this.zzh = zzcb.zzl;
        this.zzi = zzcb.zzn;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzcb.zzr;
        this.zzm = zzcb.zzs;
        this.zzn = zzcb.zzt;
        this.zzo = zzcb.zzu;
        this.zzq = new HashSet(zzcb.zzB);
        this.zzp = new HashMap(zzcb.zzA);
    }
}
