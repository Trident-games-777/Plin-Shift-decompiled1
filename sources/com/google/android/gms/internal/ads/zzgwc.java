package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgwc {
    public static final zzgwc zza = new zzgwc(new zzgwd());
    public static final zzgwc zzb = new zzgwc(new zzgwh());
    private final zzgwa zzc;

    static {
        new zzgwc(new zzgwj());
        new zzgwc(new zzgwi());
        new zzgwc(new zzgwe());
        new zzgwc(new zzgwg());
        new zzgwc(new zzgwf());
    }

    public zzgwc(zzgwk zzgwk) {
        this.zzc = !zzgmi.zzb() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzgvx(zzgwk, (zzgwb) null) : new zzgvy(zzgwk, (zzgwb) null) : new zzgvz(zzgwk, (zzgwb) null);
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzc.zza(str);
    }
}
