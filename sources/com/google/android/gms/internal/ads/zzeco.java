package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeco implements zzfiv {
    public final /* synthetic */ zzecp zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzeco(zzecp zzecp, long j) {
        this.zza = zzecp;
        this.zzb = j;
    }

    public final Object zza(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (this.zza.zzf()) {
            return null;
        }
        long j = this.zzb;
        zzbbs.zzaf.zza.C0002zza zzn = zzbbs.zzaf.zza.zzn();
        zzn.zzP(j);
        byte[] zzaV = ((zzbbs.zzaf.zza) zzn.zzbr()).zzaV();
        zzecw.zzf(sQLiteDatabase, false, false);
        zzecw.zzc(sQLiteDatabase, j, zzaV);
        return null;
    }
}
