package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzedm implements Runnable {
    public final /* synthetic */ SQLiteDatabase zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzr zzc;

    public /* synthetic */ zzedm(SQLiteDatabase sQLiteDatabase, String str, zzr zzr) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzr;
    }

    public final void run() {
        zzedp.zzf(this.zza, this.zzb, this.zzc);
    }
}
