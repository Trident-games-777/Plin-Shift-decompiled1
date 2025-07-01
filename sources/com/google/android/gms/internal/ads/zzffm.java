package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzffm {
    /* access modifiers changed from: private */
    public zzm zza;
    /* access modifiers changed from: private */
    public zzs zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzga zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList zzf;
    /* access modifiers changed from: private */
    public ArrayList zzg;
    /* access modifiers changed from: private */
    public zzbfn zzh;
    /* access modifiers changed from: private */
    public zzy zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzcm zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzbmb zzn;
    /* access modifiers changed from: private */
    public final zzfez zzo = new zzfez();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public boolean zzq = false;
    /* access modifiers changed from: private */
    public zzems zzr;
    /* access modifiers changed from: private */
    public boolean zzs = false;
    /* access modifiers changed from: private */
    public Bundle zzt;
    /* access modifiers changed from: private */
    public zzcq zzu;

    public final zzffm zzA(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzffm zzB(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzffm zzC(int i) {
        this.zzm = i;
        return this;
    }

    public final zzffm zzD(zzbfn zzbfn) {
        this.zzh = zzbfn;
        return this;
    }

    public final zzffm zzE(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzffm zzF(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzffm zzG(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzffm zzH(zzm zzm2) {
        this.zza = zzm2;
        return this;
    }

    public final zzffm zzI(zzga zzga) {
        this.zzd = zzga;
        return this;
    }

    public final zzffo zzJ() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzffo(this, (zzffn) null);
    }

    public final String zzL() {
        return this.zzc;
    }

    public final boolean zzS() {
        return this.zzp;
    }

    public final boolean zzT() {
        return this.zzq;
    }

    public final zzffm zzV(zzcq zzcq) {
        this.zzu = zzcq;
        return this;
    }

    public final zzm zzf() {
        return this.zza;
    }

    public final zzs zzh() {
        return this.zzb;
    }

    public final zzfez zzp() {
        return this.zzo;
    }

    public final zzffm zzq(zzffo zzffo) {
        this.zzo.zza(zzffo.zzo.zza);
        this.zza = zzffo.zzd;
        this.zzb = zzffo.zze;
        this.zzu = zzffo.zzt;
        this.zzc = zzffo.zzf;
        this.zzd = zzffo.zza;
        this.zzf = zzffo.zzg;
        this.zzg = zzffo.zzh;
        this.zzh = zzffo.zzi;
        this.zzi = zzffo.zzj;
        zzr(zzffo.zzl);
        zzG(zzffo.zzm);
        this.zzp = zzffo.zzp;
        this.zzq = zzffo.zzq;
        this.zzr = zzffo.zzc;
        this.zzs = zzffo.zzr;
        this.zzt = zzffo.zzs;
        return this;
    }

    public final zzffm zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzffm zzs(zzs zzs2) {
        this.zzb = zzs2;
        return this;
    }

    public final zzffm zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzffm zzu(zzy zzy) {
        this.zzi = zzy;
        return this;
    }

    public final zzffm zzv(zzems zzems) {
        this.zzr = zzems;
        return this;
    }

    public final zzffm zzw(zzbmb zzbmb) {
        this.zzn = zzbmb;
        this.zzd = new zzga(false, true, false);
        return this;
    }

    public final zzffm zzx(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzffm zzy(boolean z) {
        this.zzq = z;
        return this;
    }

    public final zzffm zzz(boolean z) {
        this.zzs = true;
        return this;
    }
}
