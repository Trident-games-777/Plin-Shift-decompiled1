package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzedc {
    private final zzbbl zza;
    private final Context zzb;
    private final zzech zzc;
    private final VersionInfoParcel zzd;

    public zzedc(Context context, VersionInfoParcel versionInfoParcel, zzbbl zzbbl, zzech zzech) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbbl;
        this.zzc = zzech;
    }

    public final void zzb(boolean z) {
        try {
            this.zzc.zza(new zzecz(this, z));
        } catch (Exception e) {
            zzm.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(zzbbs.zzaf.zza.zzx(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgzm e) {
                    zzm.zzg("Unable to deserialize proto from offline signals database:");
                    zzm.zzg(e.getMessage());
                }
            }
            query.close();
            Context context = this.zzb;
            zzbbs.zzaf.zzc zzi = zzbbs.zzaf.zzi();
            zzi.zzv(context.getPackageName());
            zzi.zzy(Build.MODEL);
            zzi.zzA(zzecw.zza(sQLiteDatabase2, 0));
            zzi.zzh(arrayList);
            zzi.zzE(zzecw.zza(sQLiteDatabase2, 1));
            zzi.zzx(zzecw.zza(sQLiteDatabase2, 3));
            zzi.zzF(zzv.zzC().currentTimeMillis());
            zzi.zzB(zzecw.zzb(sQLiteDatabase2, 2));
            zzbbs.zzaf zzaf = (zzbbs.zzaf) zzi.zzbr();
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbbs.zzaf.zza zza2 = (zzbbs.zzaf.zza) arrayList.get(i2);
                if (zza2.zzk() == zzbbs.zzq.ENUM_TRUE && zza2.zze() > j) {
                    j = zza2.zze();
                }
            }
            if (j != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(j));
                sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            }
            this.zza.zzb(new zzeda(zzaf));
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbbs.zzar.zza zzd2 = zzbbs.zzar.zzd();
            zzd2.zzg(versionInfoParcel.buddyApkVersion);
            zzd2.zzi(this.zzd.clientJarVersion);
            if (true != this.zzd.isClientJar) {
                i = 2;
            }
            zzd2.zzh(i);
            this.zza.zzb(new zzedb((zzbbs.zzar) zzd2.zzbr()));
            this.zza.zzc(10004);
            zzecw.zze(sQLiteDatabase2);
        }
        return null;
    }
}
