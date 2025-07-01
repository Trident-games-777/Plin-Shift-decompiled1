package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzr {
    public static final zzr zza = new zzr();

    protected zzr() {
    }

    public final zzm zza(Context context, zzei zzei) {
        String str;
        zzei zzei2 = zzei;
        String zzk = zzei2.zzk();
        Set zzp = zzei2.zzp();
        List unmodifiableList = !zzp.isEmpty() ? Collections.unmodifiableList(new ArrayList(zzp)) : null;
        Context context2 = context;
        boolean zzs = zzei2.zzs(context2);
        Bundle zzf = zzei2.zzf(AdMobAdapter.class);
        String zzl = zzei2.zzl();
        SearchAdRequest zzi = zzei2.zzi();
        zzfx zzfx = zzi != null ? new zzfx(zzi) : null;
        Context applicationContext = context2.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzbc.zzb();
            str = zzf.zzr(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzr = zzei2.zzr();
        RequestConfiguration zzc = zzex.zzf().zzc();
        return new zzm(8, -1, zzf, -1, unmodifiableList, zzs, Math.max(zzei2.zzb(), zzc.getTagForChildDirectedTreatment()), false, zzl, zzfx, (Location) null, zzk, zzei.zzg(), zzei.zze(), Collections.unmodifiableList(new ArrayList(zzei.zzo())), zzei.zzm(), str, zzr, (zzc) null, zzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(new String[]{null, zzc.getMaxAdContentRating()}), new zzp()), zzei2.zzn(), zzei.zza(), zzei.zzj(), zzc.getPublisherPrivacyPersonalizationState().getValue(), zzei.zzc());
    }
}
