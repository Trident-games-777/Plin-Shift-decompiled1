package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzn {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = 60000;
    private final int zzl = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.getValue();
    private long zzm = 0;

    public final zzm zza() {
        Bundle bundle = this.zze;
        Bundle bundle2 = this.zza;
        Bundle bundle3 = this.zzf;
        List list = this.zzb;
        boolean z = this.zzc;
        int i = this.zzd;
        int i2 = this.zzh;
        String str = this.zzi;
        List list2 = this.zzj;
        int i3 = this.zzl;
        List list3 = this.zzg;
        return new zzm(8, -1, bundle2, -1, list, z, i, false, (String) null, (zzfx) null, (Location) null, (String) null, bundle, bundle3, list3, (String) null, (String) null, false, (zzc) null, i2, str, list2, this.zzk, (String) null, i3, this.zzm);
    }

    public final zzn zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzn zzc(int i) {
        this.zzk = i;
        return this;
    }

    public final zzn zzd(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzn zze(List list) {
        this.zzb = list;
        return this;
    }

    public final zzn zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final zzn zzg(long j) {
        this.zzm = j;
        return this;
    }

    public final zzn zzh(int i) {
        this.zzd = i;
        return this;
    }

    public final zzn zzi(int i) {
        this.zzh = i;
        return this;
    }
}
