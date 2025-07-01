package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbbs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzecr implements zzfiv {
    public final /* synthetic */ zzecs zza;
    public final /* synthetic */ ArrayList zzb;
    public final /* synthetic */ zzbbs.zzab zzc;
    public final /* synthetic */ zzbbs.zzaf.zzd zzd;

    public /* synthetic */ zzecr(zzecs zzecs, ArrayList arrayList, zzbbs.zzab zzab, zzbbs.zzaf.zzd zzd2) {
        this.zza = zzecs;
        this.zzb = arrayList;
        this.zzc = zzab;
        this.zzd = zzd2;
    }

    public final Object zza(Object obj) {
        zzecs zzecs = this.zza;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzecs.zzb.zzf()) {
            return null;
        }
        zzbbs.zzaf.zzd zzd2 = this.zzd;
        zzbbs.zzab zzab = this.zzc;
        ArrayList arrayList = this.zzb;
        zzect zzect = zzecs.zzb;
        boolean z = zzecs.zza;
        byte[] zze = zzect.zze(zzect, z, arrayList, zzab, zzd2);
        zzecw.zzf(sQLiteDatabase, z, true);
        zzecw.zzc(sQLiteDatabase, zzecs.zzb.zzf.zzd(), zze);
        return null;
    }
}
