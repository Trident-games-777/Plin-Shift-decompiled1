package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzgf extends zzh {
    private final zzgi zza = new zzgi(this, zza(), "google_app_measurement_local.db");
    private boolean zzb;

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", DiskLruCache.VERSION);
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                if (query != null) {
                    query.close();
                }
                return j;
            } else if (query == null) {
                return -1;
            } else {
                query.close();
                return -1;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final SQLiteDatabase zzad() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzgf zzh() {
        return super.zzh();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgh zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zzjq zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzlj zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zznb zzp() {
        return super.zzp();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v5, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v10, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v11, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v12, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v13, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v14, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v15, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v17, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:58|59|60|61) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:73|74|75|76) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:45|46|47|48|166) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x018e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x018f, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0194, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0199, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x019a, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ad, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01b1, code lost:
        if (r10.inTransaction() != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01b3, code lost:
        r10.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01c5, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01ca, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01db, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01e0, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0207, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0208, code lost:
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x020b, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0210, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r0 = th;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        zzj().zzg().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        zzj().zzg().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r12.recycle();
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        zzj().zzg().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r12.recycle();
        r13 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00d3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x010a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x018e A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:11:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:11:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0199 A[ExcHandler: SQLiteFullException (e android.database.sqlite.SQLiteFullException), Splitter:B:11:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ad A[SYNTHETIC, Splitter:B:116:0x01ad] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0201 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0201 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0201 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Error reading entries from local database"
            r1.zzt()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r1.zzae()
            if (r0 != 0) goto L_0x001a
            goto L_0x017a
        L_0x001a:
            r5 = 5
            r6 = 0
            r8 = r5
            r7 = r6
        L_0x001e:
            if (r7 >= r5) goto L_0x0214
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r1.zzad()     // Catch:{ SQLiteFullException -> 0x01e4, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01a5, all -> 0x019f }
            if (r10 != 0) goto L_0x0032
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x002f }
            if (r10 == 0) goto L_0x002e
            r10.close()
        L_0x002e:
            return r3
        L_0x002f:
            r0 = move-exception
            goto L_0x0209
        L_0x0032:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x0189 }
            long r11 = zza((android.database.sqlite.SQLiteDatabase) r10)     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x0189 }
            r19 = -1
            int r0 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x002f }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x002f }
            r13[r6] = r11     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x002f }
            r14 = r13
            r13 = r0
            goto L_0x004e
        L_0x004c:
            r13 = r3
            r14 = r13
        L_0x004e:
            java.lang.String r11 = "messages"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x0189 }
            java.lang.String r15 = "rowid"
            r12[r6] = r15     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x0189 }
            java.lang.String r15 = "type"
            r12[r9] = r15     // Catch:{ SQLiteFullException -> 0x0199, SQLiteDatabaseLockedException -> 0x0194, SQLiteException -> 0x018e, all -> 0x0189 }
            java.lang.String r15 = "entry"
            r22 = r3
            r3 = 2
            r12[r3] = r15     // Catch:{ SQLiteFullException -> 0x0187, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0185, all -> 0x0180 }
            java.lang.String r17 = "rowid asc"
            r15 = 100
            java.lang.String r18 = java.lang.Integer.toString(r15)     // Catch:{ SQLiteFullException -> 0x0187, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0185, all -> 0x0180 }
            r15 = 0
            r16 = 0
            android.database.Cursor r11 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x0187, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0185, all -> 0x0180 }
        L_0x0071:
            boolean r12 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            if (r12 == 0) goto L_0x0147
            long r19 = r11.getLong(r6)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r12 = r11.getInt(r9)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            byte[] r13 = r11.getBlob(r3)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            if (r12 != 0) goto L_0x00b8
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r14 = r13.length     // Catch:{ ParseException -> 0x00a3 }
            r12.unmarshall(r13, r6, r14)     // Catch:{ ParseException -> 0x00a3 }
            r12.setDataPosition(r6)     // Catch:{ ParseException -> 0x00a3 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r13 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ ParseException -> 0x00a3 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x00a3 }
            com.google.android.gms.measurement.internal.zzbf r13 = (com.google.android.gms.measurement.internal.zzbf) r13     // Catch:{ ParseException -> 0x00a3 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            if (r13 == 0) goto L_0x0071
            r4.add(r13)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x00a1:
            r0 = move-exception
            goto L_0x00b4
        L_0x00a3:
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzgq r13 = r13.zzg()     // Catch:{ all -> 0x00a1 }
            java.lang.String r14 = "Failed to load event from local database"
            r13.zza(r14)     // Catch:{ all -> 0x00a1 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x00b4:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            throw r0     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
        L_0x00b8:
            if (r12 != r9) goto L_0x00ef
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r14 = r13.length     // Catch:{ ParseException -> 0x00d3 }
            r12.unmarshall(r13, r6, r14)     // Catch:{ ParseException -> 0x00d3 }
            r12.setDataPosition(r6)     // Catch:{ ParseException -> 0x00d3 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzon> r13 = com.google.android.gms.measurement.internal.zzon.CREATOR     // Catch:{ ParseException -> 0x00d3 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x00d3 }
            com.google.android.gms.measurement.internal.zzon r13 = (com.google.android.gms.measurement.internal.zzon) r13     // Catch:{ ParseException -> 0x00d3 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x00e5
        L_0x00d1:
            r0 = move-exception
            goto L_0x00eb
        L_0x00d3:
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj()     // Catch:{ all -> 0x00d1 }
            com.google.android.gms.measurement.internal.zzgq r13 = r13.zzg()     // Catch:{ all -> 0x00d1 }
            java.lang.String r14 = "Failed to load user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x00d1 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            r13 = r22
        L_0x00e5:
            if (r13 == 0) goto L_0x0071
            r4.add(r13)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x00eb:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            throw r0     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
        L_0x00ef:
            if (r12 != r3) goto L_0x0127
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r14 = r13.length     // Catch:{ ParseException -> 0x010a }
            r12.unmarshall(r13, r6, r14)     // Catch:{ ParseException -> 0x010a }
            r12.setDataPosition(r6)     // Catch:{ ParseException -> 0x010a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzae> r13 = com.google.android.gms.measurement.internal.zzae.CREATOR     // Catch:{ ParseException -> 0x010a }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x010a }
            com.google.android.gms.measurement.internal.zzae r13 = (com.google.android.gms.measurement.internal.zzae) r13     // Catch:{ ParseException -> 0x010a }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x011c
        L_0x0108:
            r0 = move-exception
            goto L_0x0123
        L_0x010a:
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj()     // Catch:{ all -> 0x0108 }
            com.google.android.gms.measurement.internal.zzgq r13 = r13.zzg()     // Catch:{ all -> 0x0108 }
            java.lang.String r14 = "Failed to load conditional user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x0108 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            r13 = r22
        L_0x011c:
            if (r13 == 0) goto L_0x0071
            r4.add(r13)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x0123:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            throw r0     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
        L_0x0127:
            if (r12 != r0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzu()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            java.lang.String r13 = "Skipping app launch break"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x0138:
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzg()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            java.lang.String r13 = "Unknown record type in local database"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            goto L_0x0071
        L_0x0147:
            java.lang.String r0 = "messages"
            java.lang.String r3 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r0 = r10.delete(r0, r3, r12)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            int r3 = r4.size()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            if (r0 >= r3) goto L_0x016a
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            java.lang.String r3 = "Fewer entries removed from local database than expected"
            r0.zza(r3)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
        L_0x016a:
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x01d3, SQLiteException -> 0x017b }
            if (r11 == 0) goto L_0x0175
            r11.close()
        L_0x0175:
            if (r10 == 0) goto L_0x017a
            r10.close()
        L_0x017a:
            return r4
        L_0x017b:
            r0 = move-exception
            goto L_0x01ab
        L_0x017d:
            r0 = move-exception
            goto L_0x01ea
        L_0x0180:
            r0 = move-exception
            r3 = r22
            goto L_0x0209
        L_0x0185:
            r0 = move-exception
            goto L_0x0191
        L_0x0187:
            r0 = move-exception
            goto L_0x019c
        L_0x0189:
            r0 = move-exception
            r22 = r3
            goto L_0x0209
        L_0x018e:
            r0 = move-exception
            r22 = r3
        L_0x0191:
            r11 = r22
            goto L_0x01ab
        L_0x0194:
            r22 = r3
        L_0x0196:
            r11 = r22
            goto L_0x01d3
        L_0x0199:
            r0 = move-exception
            r22 = r3
        L_0x019c:
            r11 = r22
            goto L_0x01ea
        L_0x019f:
            r0 = move-exception
            r22 = r3
            r10 = r3
            goto L_0x0209
        L_0x01a5:
            r0 = move-exception
            r22 = r3
            r10 = r22
            r11 = r10
        L_0x01ab:
            if (r10 == 0) goto L_0x01b6
            boolean r3 = r10.inTransaction()     // Catch:{ all -> 0x0207 }
            if (r3 == 0) goto L_0x01b6
            r10.endTransaction()     // Catch:{ all -> 0x0207 }
        L_0x01b6:
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj()     // Catch:{ all -> 0x0207 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x0207 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0207 }
            r1.zzb = r9     // Catch:{ all -> 0x0207 }
            if (r11 == 0) goto L_0x01c8
            r11.close()
        L_0x01c8:
            if (r10 == 0) goto L_0x0201
            r10.close()
            goto L_0x0201
        L_0x01ce:
            r22 = r3
            r10 = r22
            r11 = r10
        L_0x01d3:
            long r12 = (long) r8
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x0207 }
            int r8 = r8 + 20
            if (r11 == 0) goto L_0x01de
            r11.close()
        L_0x01de:
            if (r10 == 0) goto L_0x0201
            r10.close()
            goto L_0x0201
        L_0x01e4:
            r0 = move-exception
            r22 = r3
            r10 = r22
            r11 = r10
        L_0x01ea:
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj()     // Catch:{ all -> 0x0207 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x0207 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0207 }
            r1.zzb = r9     // Catch:{ all -> 0x0207 }
            if (r11 == 0) goto L_0x01fc
            r11.close()
        L_0x01fc:
            if (r10 == 0) goto L_0x0201
            r10.close()
        L_0x0201:
            int r7 = r7 + 1
            r3 = r22
            goto L_0x001e
        L_0x0207:
            r0 = move-exception
            r3 = r11
        L_0x0209:
            if (r3 == 0) goto L_0x020e
            r3.close()
        L_0x020e:
            if (r10 == 0) goto L_0x0213
            r10.close()
        L_0x0213:
            throw r0
        L_0x0214:
            r22 = r3
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zza(int):java.util.List");
    }

    zzgf(zzhy zzhy) {
        super(zzhy);
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final void zzaa() {
        int delete;
        zzt();
        try {
            SQLiteDatabase zzad = zzad();
            if (zzad != null && (delete = zzad.delete("messages", (String) null, (String[]) null)) > 0) {
                zzj().zzp().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzab() {
        return zza(3, new byte[0]);
    }

    private final boolean zzae() {
        return zza().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzac() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzt()
            boolean r1 = r11.zzb
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = r11.zzae()
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 5
            r4 = r1
            r3 = r2
        L_0x0015:
            if (r3 >= r1) goto L_0x008f
            r5 = 1
            r6 = 0
            android.database.sqlite.SQLiteDatabase r6 = r11.zzad()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r6 != 0) goto L_0x0027
            r11.zzb = r5     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r6 == 0) goto L_0x0026
            r6.close()
        L_0x0026:
            return r2
        L_0x0027:
            r6.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r5]     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r6.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r6.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r6.endTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r6 == 0) goto L_0x0045
            r6.close()
        L_0x0045:
            return r5
        L_0x0046:
            r0 = move-exception
            goto L_0x0089
        L_0x0048:
            r7 = move-exception
            if (r6 == 0) goto L_0x0054
            boolean r8 = r6.inTransaction()     // Catch:{ all -> 0x0046 }
            if (r8 == 0) goto L_0x0054
            r6.endTransaction()     // Catch:{ all -> 0x0046 }
        L_0x0054:
            com.google.android.gms.measurement.internal.zzgo r8 = r11.zzj()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.zzb = r5     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x0086
            r6.close()
            goto L_0x0086
        L_0x0067:
            long r7 = (long) r4
            android.os.SystemClock.sleep(r7)     // Catch:{ all -> 0x0046 }
            int r4 = r4 + 20
            if (r6 == 0) goto L_0x0086
            r6.close()
            goto L_0x0086
        L_0x0073:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzgo r8 = r11.zzj()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.zzb = r5     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x0086
            r6.close()
        L_0x0086:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0089:
            if (r6 == 0) goto L_0x008e
            r6.close()
        L_0x008e:
            throw r0
        L_0x008f:
            com.google.android.gms.measurement.internal.zzgo r0 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zzac():boolean");
    }

    public final boolean zza(zzae zzae) {
        zzq();
        byte[] zza2 = zzos.zza((Parcelable) zzae);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzj().zzn().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v14, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v15, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v16, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v18, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v19, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v20, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v21, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v22, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v23, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0161, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0166, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bc, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00db, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00df, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e0, code lost:
        r16 = r2;
        r19 = 1;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e7, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00eb, code lost:
        r16 = r2;
        r19 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0100, code lost:
        if (r7.inTransaction() != false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0102, code lost:
        r7.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0118, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x011d, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0121, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0122, code lost:
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0123, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0130, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0135, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x00c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0157 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0157 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0157 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:22:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:22:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:22:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074 A[SYNTHETIC, Splitter:B:37:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), PHI: r16 r19 
      PHI: (r16v16 boolean) = (r16v2 boolean), (r16v20 boolean), (r16v20 boolean) binds: [B:37:0x0074, B:42:0x00a4, B:45:0x00aa] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v14 byte[]) = (r19v1 byte[]), (r19v1 byte[]), (r19v21 byte[]) binds: [B:37:0x0074, B:42:0x00a4, B:45:0x00aa] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:42:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fc A[SYNTHETIC, Splitter:B:77:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            r1.zzt()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            r3.put(r0, r4)
            java.lang.String r0 = "entry"
            r4 = r19
            r3.put(r0, r4)
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0023:
            if (r5 >= r4) goto L_0x016a
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r1.zzad()     // Catch:{ SQLiteFullException -> 0x0139, SQLiteDatabaseLockedException -> 0x0125, SQLiteException -> 0x00f4, all -> 0x00f0 }
            if (r9 != 0) goto L_0x0042
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00e7, SQLiteException -> 0x0035 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r0 = move-exception
            r16 = r2
            r10 = r7
        L_0x0039:
            r19 = r8
            goto L_0x00e5
        L_0x003d:
            r0 = move-exception
            r16 = r2
            goto L_0x013d
        L_0x0042:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00ea, SQLiteDatabaseLockedException -> 0x00e7, SQLiteException -> 0x00df }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00ea, SQLiteDatabaseLockedException -> 0x00e7, SQLiteException -> 0x00df }
            if (r10 == 0) goto L_0x0069
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0063, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            if (r0 == 0) goto L_0x0069
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0063, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            goto L_0x006b
        L_0x0058:
            r0 = move-exception
            goto L_0x0123
        L_0x005b:
            r0 = move-exception
            r16 = r2
            goto L_0x0039
        L_0x005f:
            r16 = r2
            goto L_0x00db
        L_0x0063:
            r0 = move-exception
            r16 = r2
        L_0x0066:
            r7 = r10
            goto L_0x013d
        L_0x0069:
            r11 = 0
        L_0x006b:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r13 = "messages"
            if (r0 < 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.String r14 = "Data loss, local db full"
            r0.zza(r14)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            r14 = 100001(0x186a1, double:4.9407E-319)
            long r14 = r14 - r11
            java.lang.String r0 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.String r12 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            r11[r2] = r12     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            int r0 = r9.delete(r13, r0, r11)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            long r11 = (long) r0     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            int r0 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x005f, SQLiteException -> 0x005b, all -> 0x0058 }
            r16 = r2
            java.lang.String r2 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r4 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00b7, all -> 0x0058 }
            r19 = r8
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            r0.zza(r2, r4, r8, r11)     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            goto L_0x00c5
        L_0x00b7:
            r0 = move-exception
            goto L_0x0039
        L_0x00b9:
            r0 = move-exception
            goto L_0x00be
        L_0x00bb:
            r0 = move-exception
            r16 = r2
        L_0x00be:
            r19 = r8
            goto L_0x0066
        L_0x00c1:
            r16 = r2
            r19 = r8
        L_0x00c5:
            r9.insertOrThrow(r13, r7, r3)     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x00dd, SQLiteDatabaseLockedException -> 0x00db, SQLiteException -> 0x00d9, all -> 0x0058 }
            if (r10 == 0) goto L_0x00d3
            r10.close()
        L_0x00d3:
            if (r9 == 0) goto L_0x00d8
            r9.close()
        L_0x00d8:
            return r19
        L_0x00d9:
            r0 = move-exception
            goto L_0x00e5
        L_0x00db:
            r7 = r10
            goto L_0x0128
        L_0x00dd:
            r0 = move-exception
            goto L_0x0066
        L_0x00df:
            r0 = move-exception
            r16 = r2
            r19 = r8
            r10 = r7
        L_0x00e5:
            r7 = r9
            goto L_0x00fa
        L_0x00e7:
            r16 = r2
            goto L_0x0128
        L_0x00ea:
            r0 = move-exception
            r16 = r2
            r19 = r8
            goto L_0x013d
        L_0x00f0:
            r0 = move-exception
            r9 = r7
            goto L_0x015f
        L_0x00f4:
            r0 = move-exception
            r16 = r2
            r19 = r8
            r10 = r7
        L_0x00fa:
            if (r7 == 0) goto L_0x0105
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x0121 }
            if (r2 == 0) goto L_0x0105
            r7.endTransaction()     // Catch:{ all -> 0x0121 }
        L_0x0105:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0121 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x0121 }
            r2 = r19
            r1.zzb = r2     // Catch:{ all -> 0x0121 }
            if (r10 == 0) goto L_0x011b
            r10.close()
        L_0x011b:
            if (r7 == 0) goto L_0x0157
            r7.close()
            goto L_0x0157
        L_0x0121:
            r0 = move-exception
            r9 = r7
        L_0x0123:
            r7 = r10
            goto L_0x015f
        L_0x0125:
            r16 = r2
            r9 = r7
        L_0x0128:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x015e }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x0133
            r7.close()
        L_0x0133:
            if (r9 == 0) goto L_0x0157
            r9.close()
            goto L_0x0157
        L_0x0139:
            r0 = move-exception
            r16 = r2
            r9 = r7
        L_0x013d:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x015e }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x015e }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x015e }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x015e }
            if (r7 == 0) goto L_0x0152
            r7.close()
        L_0x0152:
            if (r9 == 0) goto L_0x0157
            r9.close()
        L_0x0157:
            int r5 = r5 + 1
            r2 = r16
            r4 = 5
            goto L_0x0023
        L_0x015e:
            r0 = move-exception
        L_0x015f:
            if (r7 == 0) goto L_0x0164
            r7.close()
        L_0x0164:
            if (r9 == 0) goto L_0x0169
            r9.close()
        L_0x0169:
            throw r0
        L_0x016a:
            r16 = r2
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzbf zzbf) {
        Parcel obtain = Parcel.obtain();
        zzbf.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzj().zzn().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzon zzon) {
        Parcel obtain = Parcel.obtain();
        zzon.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzj().zzn().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
