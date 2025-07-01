package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzei {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final Map zze;
    private final String zzf;
    private final String zzg;
    @NotOnlyInitialized
    private final SearchAdRequest zzh;
    private final int zzi;
    private final Set zzj;
    private final Bundle zzk;
    private final Set zzl;
    private final boolean zzm;
    private final String zzn;
    private final int zzo;
    private long zzp = 0;

    public zzei(zzeh zzeh, SearchAdRequest searchAdRequest) {
        this.zza = zzeh.zzg;
        this.zzb = zzeh.zzh;
        this.zzc = Collections.unmodifiableSet(zzeh.zza);
        this.zzd = zzeh.zzb;
        this.zze = Collections.unmodifiableMap(zzeh.zzc);
        this.zzf = zzeh.zzi;
        this.zzg = zzeh.zzj;
        this.zzh = searchAdRequest;
        this.zzi = zzeh.zzk;
        this.zzj = Collections.unmodifiableSet(zzeh.zzd);
        this.zzk = zzeh.zze;
        this.zzl = Collections.unmodifiableSet(zzeh.zzf);
        this.zzm = zzeh.zzl;
        this.zzn = zzeh.zzm;
        this.zzo = zzeh.zzn;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzi;
    }

    public final long zzc() {
        return this.zzp;
    }

    public final Bundle zzd(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.zzk;
    }

    public final Bundle zzf(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.zzd;
    }

    @Deprecated
    public final NetworkExtras zzh(Class cls) {
        return (NetworkExtras) this.zze.get(cls);
    }

    public final SearchAdRequest zzi() {
        return this.zzh;
    }

    public final String zzj() {
        return this.zzn;
    }

    public final String zzk() {
        return this.zza;
    }

    public final String zzl() {
        return this.zzf;
    }

    public final String zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return new ArrayList(this.zzb);
    }

    public final Set zzo() {
        return this.zzl;
    }

    public final Set zzp() {
        return this.zzc;
    }

    public final void zzq(long j) {
        this.zzp = j;
    }

    @Deprecated
    public final boolean zzr() {
        return this.zzm;
    }

    public final boolean zzs(Context context) {
        RequestConfiguration zzc2 = zzex.zzf().zzc();
        zzbc.zzb();
        Set set = this.zzj;
        String zzz = zzf.zzz(context);
        return set.contains(zzz) || zzc2.getTestDeviceIds().contains(zzz);
    }
}
