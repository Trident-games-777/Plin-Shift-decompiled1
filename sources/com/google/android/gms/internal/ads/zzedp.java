package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzedp extends zzfsf {
    private final Context zza;
    private final zzges zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzedp(android.content.Context r8, com.google.android.gms.internal.ads.zzges r9) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzhZ
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r5 = r0.intValue()
            r4 = 0
            com.google.android.gms.internal.ads.zzfsh r6 = com.google.android.gms.internal.ads.zzfsh.zza
            java.lang.String r3 = "AdMobOfflineBufferedPings.db"
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r1.zza = r2
            r1.zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedp.<init>(android.content.Context, com.google.android.gms.internal.ads.zzges):void");
    }

    static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzr zzr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzr);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzr zzr) {
        String str;
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"timestamp", ImagesContract.URL}, "event_state = 1", (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("timestamp");
                int columnIndex2 = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex2 != -1) {
                    long j = query.getLong(columnIndex);
                    String string = query.getString(columnIndex2);
                    if (string == null) {
                        str = "";
                    } else {
                        str = Uri.parse(string).buildUpon().appendQueryParameter("bd", Long.toString(zzv.zzC().currentTimeMillis() - j)).build().toString();
                    }
                    strArr[i] = str;
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzr.zza(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzedr zzedr, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzedr.zza));
        contentValues.put("gws_query_id", zzedr.zzb);
        contentValues.put(ImagesContract.URL, zzedr.zzc);
        contentValues.put("event_state", Integer.valueOf(zzedr.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzv.zzq();
        zzbq zzz = zzs.zzz(this.zza);
        if (zzz != null) {
            try {
                zzz.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e) {
                zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    public final void zzc(String str) {
        zze(new zzedn(this, str));
    }

    public final void zzd(zzedr zzedr) {
        zze(new zzedj(this, zzedr));
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfiv zzfiv) {
        zzgei.zzr(this.zzb.zzb(new zzedl(this)), new zzedo(this, zzfiv), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(SQLiteDatabase sQLiteDatabase, zzr zzr, String str) {
        this.zzb.execute(new zzedm(sQLiteDatabase, str, zzr));
    }

    public final void zzh(zzr zzr, String str) {
        zze(new zzedk(this, zzr, str));
    }
}
