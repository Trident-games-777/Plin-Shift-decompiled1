package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzedo implements zzgee {
    final /* synthetic */ zzfiv zza;

    zzedo(zzedp zzedp, zzfiv zzfiv) {
        this.zza = zzfiv;
    }

    public final void zza(Throwable th) {
        zzm.zzg("Failed to get offline buffered ping database: ".concat(String.valueOf(th.getMessage())));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            zzm.zzg("Error executing function on offline buffered ping database: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
