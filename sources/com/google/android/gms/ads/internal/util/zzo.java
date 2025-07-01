package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbdo;
import com.google.android.gms.internal.ads.zzhgq;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzo implements zzbdn {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzo(zzs zzs, zzbdo zzbdo, Context context, Uri uri) {
        this.zza = zzbdo;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zza.zza()).build();
        build.intent.setPackage(zzhgq.zza(this.zzb));
        build.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
