package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.ArrayList;

public class DBUtil {
    @Deprecated
    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z) {
        return query(roomDatabase, supportSQLiteQuery, z, (CancellationSignal) null);
    }

    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, CancellationSignal cancellationSignal) {
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(abstractWindowedCursor) : query;
    }

    /* JADX INFO: finally extract failed */
    public static void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor query = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(0));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readVersion(java.io.File r10) throws java.io.IOException {
        /*
            r0 = 4
            r1 = 0
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x003b }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x003b }
            r3.<init>(r10)     // Catch:{ all -> 0x003b }
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ all -> 0x003b }
            r7 = 4
            r9 = 1
            r5 = 60
            r4.tryLock(r5, r7, r9)     // Catch:{ all -> 0x0037 }
            r5 = 60
            r4.position(r5)     // Catch:{ all -> 0x0037 }
            int r10 = r4.read(r2)     // Catch:{ all -> 0x0037 }
            if (r10 != r0) goto L_0x002f
            r2.rewind()     // Catch:{ all -> 0x0037 }
            int r10 = r2.getInt()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x002e
            r4.close()
        L_0x002e:
            return r10
        L_0x002f:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = "Bad database header, unable to read 4 bytes at offset 60"
            r10.<init>(r0)     // Catch:{ all -> 0x0037 }
            throw r10     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r0 = move-exception
            r10 = r0
            r1 = r4
            goto L_0x003d
        L_0x003b:
            r0 = move-exception
            r10 = r0
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()
        L_0x0042:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.readVersion(java.io.File):int");
    }

    public static CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    private DBUtil() {
    }
}
