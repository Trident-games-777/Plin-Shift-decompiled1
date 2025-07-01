package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
final class zzal extends zznr {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzat zzl = new zzat(this, zza(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zznl zzm = new zznl(zzb());

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzgo.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        try {
            return (long) e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbh.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgo.zza(str), e);
            return 0;
        }
    }

    public final long b_() {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zza(zzfy.zzk zzk2) throws IOException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzk2);
        Preconditions.checkNotEmpty(zzk2.zzz());
        byte[] zzca = zzk2.zzca();
        long zza2 = g_().zza(zzca);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzk2.zzz());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put("metadata", zzca);
        try {
            e_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgo.zza(zzk2.zzz()), e);
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        long j = 0;
        try {
            long zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1);
            if (zza2 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (e_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert column (got -1). appId", zzgo.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                zza2 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza2));
                if (((long) e_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzgo.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                e_.setTransactionSuccessful();
                e_.endTransaction();
                return zza2;
            } catch (SQLiteException e) {
                e = e;
                j = zza2;
                try {
                    zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
                    return j;
                } finally {
                    e_.endTransaction();
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
            return j;
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1);
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzd(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzt()
            r5.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch:{ SQLiteException -> 0x0073, all -> 0x0071 }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0071 }
            r4 = 0
            r3[r4] = r6     // Catch:{ SQLiteException -> 0x0073, all -> 0x0071 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0071 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006f }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgo r6 = r5.zzj()     // Catch:{ SQLiteException -> 0x006f }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch:{ SQLiteException -> 0x006f }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x006f }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r3 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzoo.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch:{ IOException -> 0x0057 }
            r5.g_()     // Catch:{ SQLiteException -> 0x006f }
            java.util.List r6 = r2.zzh()     // Catch:{ SQLiteException -> 0x006f }
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzoo.zza((java.util.List<com.google.android.gms.internal.measurement.zzfy.zzh>) r6)     // Catch:{ SQLiteException -> 0x006f }
            if (r1 == 0) goto L_0x0056
            r1.close()
        L_0x0056:
            return r6
        L_0x0057:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r5.zzj()     // Catch:{ SQLiteException -> 0x006f }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x006f }
            r3.zza(r4, r6, r2)     // Catch:{ SQLiteException -> 0x006f }
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            return r0
        L_0x006f:
            r6 = move-exception
            goto L_0x0075
        L_0x0071:
            r6 = move-exception
            goto L_0x008a
        L_0x0073:
            r6 = move-exception
            r1 = r0
        L_0x0075:
            com.google.android.gms.measurement.internal.zzgo r2 = r5.zzj()     // Catch:{ all -> 0x0088 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            return r0
        L_0x0088:
            r6 = move-exception
            r0 = r1
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfy.zzf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzt()
            r7.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzgo r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzp()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0077 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzoo.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch:{ IOException -> 0x005f }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            return r8
        L_0x005f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r7.zzj()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0077 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            return r0
        L_0x0077:
            r8 = move-exception
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            goto L_0x0092
        L_0x007b:
            r8 = move-exception
            r1 = r0
        L_0x007d:
            com.google.android.gms.measurement.internal.zzgo r9 = r7.zzj()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzg()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            r1.close()
        L_0x008f:
            return r0
        L_0x0090:
            r8 = move-exception
            r0 = r1
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: com.google.android.gms.measurement.internal.zzg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03fa A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0227 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x022b A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x025f A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x027d A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0280 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x028f A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02e5 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x035b A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x035d A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0369 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x036c A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0394 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0397 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03b0 A[Catch:{ SQLiteException -> 0x0411 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zze(java.lang.String r28) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            r1.zzt()
            r1.zzal()
            android.database.sqlite.SQLiteDatabase r4 = r1.e_()     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r5 = "apps"
            r0 = 44
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "app_instance_id"
            r12 = 0
            r6[r12] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "gmp_app_id"
            r13 = 1
            r6[r13] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "resettable_device_id_hash"
            r14 = 2
            r6[r14] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "last_bundle_index"
            r15 = 3
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r7 = 4
            r6[r7] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r8 = 5
            r6[r8] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "app_version"
            r9 = 6
            r6[r9] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "app_store"
            r10 = 7
            r6[r10] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "gmp_version"
            r11 = 8
            r6[r11] = r0     // Catch:{ SQLiteException -> 0x041d, all -> 0x0417 }
            java.lang.String r0 = "dev_cert_hash"
            r16 = 0
            r3 = 9
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "measurement_enabled"
            r3 = 10
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "day"
            r17 = 11
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_public_events_count"
            r17 = 12
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_events_count"
            r17 = 13
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_conversions_count"
            r17 = 14
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "config_fetched_time"
            r17 = 15
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "failed_config_fetch_time"
            r17 = 16
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "app_version_int"
            r3 = 17
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "firebase_instance_id"
            r18 = 18
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_error_events_count"
            r18 = 19
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_realtime_events_count"
            r18 = 20
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "health_monitor_sample"
            r18 = 21
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "android_id"
            r18 = 22
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "adid_reporting_enabled"
            r3 = 23
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "admob_app_id"
            r19 = 24
            r6[r19] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "dynamite_version"
            r3 = 25
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "safelisted_events"
            r3 = 26
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "ga_app_id"
            r20 = 27
            r6[r20] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "session_stitching_token"
            r20 = 28
            r6[r20] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "sgtm_upload_enabled"
            r3 = 29
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "target_os_version"
            r21 = 30
            r6[r21] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "session_stitching_token_hash"
            r21 = 31
            r6[r21] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "ad_services_version"
            r21 = 32
            r6[r21] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "unmatched_first_open_without_ad_id"
            r3 = 33
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "npa_metadata_value"
            r3 = 34
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "attribution_eligibility_status"
            r22 = 35
            r6[r22] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "sgtm_preview_key"
            r22 = 36
            r6[r22] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "dma_consent_state"
            r22 = 37
            r6[r22] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "daily_realtime_dcu_count"
            r22 = 38
            r6[r22] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "bundle_delivery_index"
            r22 = 39
            r6[r22] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "serialized_npa_metadata"
            r3 = 40
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "unmatched_pfo"
            r3 = 41
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "unmatched_uwa"
            r3 = 42
            r6[r3] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            java.lang.String r0 = "ad_campaign_info"
            r23 = 43
            r6[r23] = r0     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            r0 = r7
            java.lang.String r7 = "app_id=?"
            r23 = r8
            java.lang.String[] r8 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            r24 = r10
            r10 = 0
            r25 = r11
            r11 = 0
            r26 = r9
            r9 = 0
            r3 = r0
            r0 = r25
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0415, all -> 0x0413 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0411 }
            if (r5 != 0) goto L_0x013e
            if (r4 == 0) goto L_0x013d
            r4.close()
        L_0x013d:
            return r16
        L_0x013e:
            com.google.android.gms.measurement.internal.zzg r5 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zznv r6 = r1.zzg     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzhy r6 = r6.zzk()     // Catch:{ SQLiteException -> 0x0411 }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.zzag r6 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcy     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.zznv r6 = r1.zzg     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje r6 = r6.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje$zza r7 = com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzje.zza) r7)     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x0170
        L_0x0169:
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x0170:
            java.lang.String r6 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x0197
            com.google.android.gms.measurement.internal.zzag r6 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcy     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x0197
            com.google.android.gms.measurement.internal.zznv r6 = r1.zzg     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje r6 = r6.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje$zza r7 = com.google.android.gms.measurement.internal.zzje.zza.AD_STORAGE     // Catch:{ SQLiteException -> 0x0411 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzje.zza) r7)     // Catch:{ SQLiteException -> 0x0411 }
            if (r6 == 0) goto L_0x019e
        L_0x0197:
            java.lang.String r6 = r4.getString(r14)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x019e:
            long r6 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzq(r6)     // Catch:{ SQLiteException -> 0x0411 }
            long r6 = r4.getLong(r3)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzr(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r3 = 5
            long r6 = r4.getLong(r3)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzp(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r3 = 6
            java.lang.String r3 = r4.getString(r3)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzd((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0411 }
            r3 = 7
            java.lang.String r3 = r4.getString(r3)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzc((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0411 }
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzn(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 9
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzk((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 10
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x01e5
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r0 = r12
            goto L_0x01e6
        L_0x01e5:
            r0 = r13
        L_0x01e6:
            r5.zzb((boolean) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 11
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzj((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 12
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzh((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 13
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzg((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 14
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zze((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 15
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzd((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 16
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzm(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 17
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 == 0) goto L_0x022b
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0230
        L_0x022b:
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x0411 }
        L_0x0230:
            r5.zzb((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 18
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zze((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 19
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzf((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 20
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzi((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 21
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzg((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 23
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x0268
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0266
            goto L_0x0268
        L_0x0266:
            r0 = r12
            goto L_0x0269
        L_0x0268:
            r0 = r13
        L_0x0269:
            r5.zza((boolean) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 24
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zza((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 25
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 == 0) goto L_0x0280
            r6 = 0
            goto L_0x0284
        L_0x0280:
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x0284:
            r5.zzl(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 26
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x02a1
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.String r3 = ","
            r6 = -1
            java.lang.String[] r0 = r0.split(r3, r6)     // Catch:{ SQLiteException -> 0x0411 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x02a1:
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzcy     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zznv r0 = r1.zzg     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje r0 = r0.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzje$zza r3 = com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzje.zza) r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x02ca
        L_0x02c1:
            r0 = 28
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzj((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x02ca:
            boolean r0 = com.google.android.gms.internal.measurement.zzpu.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0317
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzbx     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0317
            r1.zzq()     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = com.google.android.gms.measurement.internal.zzos.zzf(r2)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0317
            r0 = 29
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x02f5
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x02f5
            r0 = r13
            goto L_0x02f6
        L_0x02f5:
            r0 = r12
        L_0x02f6:
            r5.zzc((boolean) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 39
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzo(r6)     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzby     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0317
            r0 = 36
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzk((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x0317:
            r0 = 30
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzt(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 31
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzs(r6)     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x034d
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzch     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zze(r2, r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x034d
            r0 = 32
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zza((int) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 35
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzc((long) r6)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x034d:
            r0 = 33
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x035d
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x035d
            r0 = r13
            goto L_0x035e
        L_0x035d:
            r0 = r12
        L_0x035e:
            r5.zzd((boolean) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 34
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 == 0) goto L_0x036c
            r0 = r16
            goto L_0x0377
        L_0x036c:
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x0373
            r12 = r13
        L_0x0373:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r12)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x0377:
            r5.zza((java.lang.Boolean) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 37
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzc((int) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 38
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzb((int) r0)     // Catch:{ SQLiteException -> 0x0411 }
            r0 = 40
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 == 0) goto L_0x0397
            java.lang.String r0 = ""
            goto L_0x03a1
        L_0x0397:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SQLiteException -> 0x0411 }
        L_0x03a1:
            r5.zzi((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzcw     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x03d6
            r0 = 41
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x03c3
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zza((java.lang.Long) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x03c3:
            r0 = 42
            boolean r3 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0411 }
            if (r3 != 0) goto L_0x03d6
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zzb((java.lang.Long) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x03d6:
            boolean r0 = com.google.android.gms.internal.measurement.zzov.zza()     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzcu     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r0.zze(r2, r3)     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x03f1
            r0 = 43
            byte[] r0 = r4.getBlob(r0)     // Catch:{ SQLiteException -> 0x0411 }
            r5.zza((byte[]) r0)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x03f1:
            r5.zzao()     // Catch:{ SQLiteException -> 0x0411 }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0411 }
            if (r0 == 0) goto L_0x040b
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ SQLiteException -> 0x0411 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0411 }
            java.lang.String r3 = "Got multiple records for app, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0411 }
            r0.zza(r3, r6)     // Catch:{ SQLiteException -> 0x0411 }
        L_0x040b:
            if (r4 == 0) goto L_0x0410
            r4.close()
        L_0x0410:
            return r5
        L_0x0411:
            r0 = move-exception
            goto L_0x0422
        L_0x0413:
            r0 = move-exception
            goto L_0x041a
        L_0x0415:
            r0 = move-exception
            goto L_0x0420
        L_0x0417:
            r0 = move-exception
            r16 = 0
        L_0x041a:
            r3 = r16
            goto L_0x043b
        L_0x041d:
            r0 = move-exception
            r16 = 0
        L_0x0420:
            r4 = r16
        L_0x0422:
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj()     // Catch:{ all -> 0x0439 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x0439 }
            java.lang.String r5 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ all -> 0x0439 }
            r3.zza(r5, r2, r0)     // Catch:{ all -> 0x0439 }
            if (r4 == 0) goto L_0x0438
            r4.close()
        L_0x0438:
            return r16
        L_0x0439:
            r0 = move-exception
            r3 = r4
        L_0x043b:
            if (r3 == 0) goto L_0x0440
            r3.close()
        L_0x0440:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: com.google.android.gms.measurement.internal.zzae} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r16v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r33, java.lang.String r34) {
        /*
            r32 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r33)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r32.zzt()
            r32.zzal()
            android.database.sqlite.SQLiteDatabase r7 = r32.e_()     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r8 = "conditional_properties"
            r0 = 11
            java.lang.String[] r9 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "origin"
            r1 = 0
            r9[r1] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "value"
            r2 = 1
            r9[r2] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "active"
            r3 = 2
            r9[r3] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "trigger_event_name"
            r4 = 3
            r9[r4] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "trigger_timeout"
            r5 = 4
            r9[r5] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "timed_out_event"
            r15 = 5
            r9[r15] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "creation_timestamp"
            r10 = 6
            r9[r10] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "triggered_event"
            r11 = 7
            r9[r11] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "triggered_timestamp"
            r12 = 8
            r9[r12] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "time_to_live"
            r13 = 9
            r9[r13] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            java.lang.String r0 = "expired_event"
            r14 = 10
            r9[r14] = r0     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            r0 = r10
            java.lang.String r10 = "app_id=? and name=?"
            r16 = r11
            java.lang.String[] r11 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            r11[r1] = r33     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            r11[r2] = r34     // Catch:{ SQLiteException -> 0x013a, all -> 0x0132 }
            r17 = r13
            r13 = 0
            r18 = r14
            r14 = 0
            r19 = r12
            r12 = 0
            r6 = r16
            r16 = 0
            android.database.Cursor r7 = r7.query(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            boolean r8 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0122, all -> 0x011e }
            if (r8 != 0) goto L_0x0078
            if (r7 == 0) goto L_0x0077
            r7.close()
        L_0x0077:
            return r16
        L_0x0078:
            java.lang.String r8 = r7.getString(r1)     // Catch:{ SQLiteException -> 0x0122, all -> 0x011e }
            if (r8 != 0) goto L_0x0080
            java.lang.String r8 = ""
        L_0x0080:
            r9 = r32
            java.lang.Object r10 = r9.zza((android.database.Cursor) r7, (int) r2)     // Catch:{ SQLiteException -> 0x011c }
            int r3 = r7.getInt(r3)     // Catch:{ SQLiteException -> 0x011c }
            if (r3 == 0) goto L_0x008f
            r23 = r2
            goto L_0x0091
        L_0x008f:
            r23 = r1
        L_0x0091:
            java.lang.String r24 = r7.getString(r4)     // Catch:{ SQLiteException -> 0x011c }
            long r26 = r7.getLong(r5)     // Catch:{ SQLiteException -> 0x011c }
            com.google.android.gms.measurement.internal.zzoo r1 = r9.g_()     // Catch:{ SQLiteException -> 0x011c }
            byte[] r2 = r7.getBlob(r15)     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r3 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable r1 = r1.zza((byte[]) r2, r3)     // Catch:{ SQLiteException -> 0x011c }
            r25 = r1
            com.google.android.gms.measurement.internal.zzbf r25 = (com.google.android.gms.measurement.internal.zzbf) r25     // Catch:{ SQLiteException -> 0x011c }
            long r21 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x011c }
            com.google.android.gms.measurement.internal.zzoo r0 = r9.g_()     // Catch:{ SQLiteException -> 0x011c }
            byte[] r1 = r7.getBlob(r6)     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r2 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x011c }
            r28 = r0
            com.google.android.gms.measurement.internal.zzbf r28 = (com.google.android.gms.measurement.internal.zzbf) r28     // Catch:{ SQLiteException -> 0x011c }
            r0 = 8
            long r2 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x011c }
            r0 = 9
            long r29 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x011c }
            com.google.android.gms.measurement.internal.zzoo r0 = r9.g_()     // Catch:{ SQLiteException -> 0x011c }
            r1 = 10
            byte[] r1 = r7.getBlob(r1)     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r4 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x011c }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r4)     // Catch:{ SQLiteException -> 0x011c }
            r31 = r0
            com.google.android.gms.measurement.internal.zzbf r31 = (com.google.android.gms.measurement.internal.zzbf) r31     // Catch:{ SQLiteException -> 0x011c }
            com.google.android.gms.measurement.internal.zzon r0 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ SQLiteException -> 0x011c }
            r1 = r34
            r5 = r8
            r4 = r10
            r0.<init>(r1, r2, r4, r5)     // Catch:{ SQLiteException -> 0x011a }
            r19 = r5
            com.google.android.gms.measurement.internal.zzae r17 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ SQLiteException -> 0x011a }
            r18 = r33
            r20 = r0
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r31)     // Catch:{ SQLiteException -> 0x011a }
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x011a }
            if (r0 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzgo r0 = r9.zzj()     // Catch:{ SQLiteException -> 0x011a }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x011a }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r33)     // Catch:{ SQLiteException -> 0x011a }
            com.google.android.gms.measurement.internal.zzgh r4 = r9.zzi()     // Catch:{ SQLiteException -> 0x011a }
            java.lang.String r4 = r4.zzc(r1)     // Catch:{ SQLiteException -> 0x011a }
            r0.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x011a }
        L_0x0114:
            if (r7 == 0) goto L_0x0119
            r7.close()
        L_0x0119:
            return r17
        L_0x011a:
            r0 = move-exception
            goto L_0x0143
        L_0x011c:
            r0 = move-exception
            goto L_0x0125
        L_0x011e:
            r0 = move-exception
            r9 = r32
            goto L_0x0163
        L_0x0122:
            r0 = move-exception
            r9 = r32
        L_0x0125:
            r1 = r34
            goto L_0x0143
        L_0x0128:
            r0 = move-exception
            r9 = r32
            goto L_0x0137
        L_0x012c:
            r0 = move-exception
            r9 = r32
            r1 = r34
            goto L_0x0141
        L_0x0132:
            r0 = move-exception
            r9 = r32
            r16 = 0
        L_0x0137:
            r6 = r16
            goto L_0x0164
        L_0x013a:
            r0 = move-exception
            r9 = r32
            r1 = r34
            r16 = 0
        L_0x0141:
            r7 = r16
        L_0x0143:
            com.google.android.gms.measurement.internal.zzgo r2 = r9.zzj()     // Catch:{ all -> 0x0162 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0162 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r33)     // Catch:{ all -> 0x0162 }
            com.google.android.gms.measurement.internal.zzgh r5 = r9.zzi()     // Catch:{ all -> 0x0162 }
            java.lang.String r1 = r5.zzc(r1)     // Catch:{ all -> 0x0162 }
            r2.zza(r3, r4, r1, r0)     // Catch:{ all -> 0x0162 }
            if (r7 == 0) goto L_0x0161
            r7.close()
        L_0x0161:
            return r16
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            r6 = r7
        L_0x0164:
            if (r6 == 0) goto L_0x0169
            r6.close()
        L_0x0169:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzan zzf(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzt()
            r13.zzal()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.e_()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            java.lang.String r3 = "apps"
            r0 = 3
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            java.lang.String r0 = "remote_config"
            r10 = 0
            r4[r10] = r0     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            java.lang.String r0 = "config_last_modified_time"
            r11 = 1
            r4[r11] = r0     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            java.lang.String r0 = "e_tag"
            r12 = 2
            r4[r12] = r0     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            r6[r10] = r14     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0073 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0071 }
            if (r0 != 0) goto L_0x003b
            if (r2 == 0) goto L_0x003a
            r2.close()
        L_0x003a:
            return r1
        L_0x003b:
            byte[] r0 = r2.getBlob(r10)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r4 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0071 }
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0071 }
            if (r5 == 0) goto L_0x005e
            com.google.android.gms.measurement.internal.zzgo r5 = r13.zzj()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r14)     // Catch:{ SQLiteException -> 0x0071 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0071 }
        L_0x005e:
            if (r0 != 0) goto L_0x0066
            if (r2 == 0) goto L_0x0065
            r2.close()
        L_0x0065:
            return r1
        L_0x0066:
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ SQLiteException -> 0x0071 }
            r5.<init>(r0, r3, r4)     // Catch:{ SQLiteException -> 0x0071 }
            if (r2 == 0) goto L_0x0070
            r2.close()
        L_0x0070:
            return r5
        L_0x0071:
            r0 = move-exception
            goto L_0x0078
        L_0x0073:
            r0 = move-exception
            r14 = r0
            goto L_0x0092
        L_0x0076:
            r0 = move-exception
            r2 = r1
        L_0x0078:
            com.google.android.gms.measurement.internal.zzgo r3 = r13.zzj()     // Catch:{ all -> 0x008f }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r14)     // Catch:{ all -> 0x008f }
            r3.zza(r4, r14, r0)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x008e
            r2.close()
        L_0x008e:
            return r1
        L_0x008f:
            r0 = move-exception
            r14 = r0
            r1 = r2
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    public final zzaq zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zza(j, str, 1, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaq zza(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            r21 = this;
            java.lang.String r0 = "daily_registered_triggers_count"
            java.lang.String r1 = "daily_realtime_dcu_count"
            java.lang.String r2 = "daily_realtime_events_count"
            java.lang.String r3 = "daily_error_events_count"
            java.lang.String r4 = "daily_conversions_count"
            java.lang.String r5 = "daily_public_events_count"
            java.lang.String r6 = "daily_events_count"
            java.lang.String r7 = "day"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r21.zzt()
            r21.zzal()
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]
            r10 = 0
            r9[r10] = r24
            com.google.android.gms.measurement.internal.zzaq r11 = new com.google.android.gms.measurement.internal.zzaq
            r11.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r21.e_()     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            java.lang.String r14 = "apps"
            r15 = 8
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r15[r10] = r7     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r15[r8] = r6     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 2
            r15[r12] = r5     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 3
            r15[r12] = r4     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 4
            r15[r12] = r3     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 5
            r15[r12] = r2     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 6
            r15[r12] = r1     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12 = 7
            r15[r12] = r0     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r12[r10] = r24     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            r19 = 0
            r20 = 0
            r18 = 0
            r17 = r12
            android.database.Cursor r12 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0140, all -> 0x013d }
            boolean r14 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x013b }
            if (r14 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzgo r0 = r21.zzj()     // Catch:{ SQLiteException -> 0x013b }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r1 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r24)     // Catch:{ SQLiteException -> 0x013b }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x013b }
            if (r12 == 0) goto L_0x0158
            r12.close()
            return r11
        L_0x0073:
            long r14 = r12.getLong(r10)     // Catch:{ SQLiteException -> 0x013b }
            int r10 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r10 != 0) goto L_0x00ab
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zzb = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 2
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zza = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 3
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zzc = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 4
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zzd = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 5
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zze = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 6
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zzf = r14     // Catch:{ SQLiteException -> 0x013b }
            r8 = 7
            long r14 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x013b }
            r11.zzg = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00ab:
            if (r27 == 0) goto L_0x00b3
            long r14 = r11.zzb     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zzb = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00b3:
            if (r28 == 0) goto L_0x00bb
            long r14 = r11.zza     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zza = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00bb:
            if (r29 == 0) goto L_0x00c3
            long r14 = r11.zzc     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zzc = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00c3:
            if (r30 == 0) goto L_0x00cb
            long r14 = r11.zzd     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zzd = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00cb:
            if (r31 == 0) goto L_0x00d3
            long r14 = r11.zze     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zze = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00d3:
            if (r32 == 0) goto L_0x00db
            long r14 = r11.zzf     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zzf = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00db:
            if (r33 == 0) goto L_0x00e3
            long r14 = r11.zzg     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r14 + r25
            r11.zzg = r14     // Catch:{ SQLiteException -> 0x013b }
        L_0x00e3:
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x013b }
            r8.<init>()     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r10 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r7, r10)     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r11.zza     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r5, r7)     // Catch:{ SQLiteException -> 0x013b }
            long r14 = r11.zzb     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r6, r5)     // Catch:{ SQLiteException -> 0x013b }
            long r5 = r11.zzc     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r4, r5)     // Catch:{ SQLiteException -> 0x013b }
            long r4 = r11.zzd     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            long r3 = r11.zze     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r2, r3)     // Catch:{ SQLiteException -> 0x013b }
            long r2 = r11.zzf     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r1, r2)     // Catch:{ SQLiteException -> 0x013b }
            long r1 = r11.zzg     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x013b }
            r8.put(r0, r1)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r0 = "apps"
            java.lang.String r1 = "app_id=?"
            r13.update(r0, r8, r1, r9)     // Catch:{ SQLiteException -> 0x013b }
            if (r12 == 0) goto L_0x0158
            r12.close()
            return r11
        L_0x013b:
            r0 = move-exception
            goto L_0x0142
        L_0x013d:
            r0 = move-exception
            r12 = 0
            goto L_0x015a
        L_0x0140:
            r0 = move-exception
            r12 = 0
        L_0x0142:
            com.google.android.gms.measurement.internal.zzgo r1 = r21.zzj()     // Catch:{ all -> 0x0159 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch:{ all -> 0x0159 }
            java.lang.String r2 = "Error updating daily counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r24)     // Catch:{ all -> 0x0159 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x0159 }
            if (r12 == 0) goto L_0x0158
            r12.close()
        L_0x0158:
            return r11
        L_0x0159:
            r0 = move-exception
        L_0x015a:
            if (r12 == 0) goto L_0x015f
            r12.close()
        L_0x015f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzaq");
    }

    public final zzax zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzax.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzbb zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzbb zzc(java.lang.String r27, java.lang.String r28, java.lang.String r29) {
        /*
            r26 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r26.zzt()
            r26.zzal()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 9
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = "lifetime_count"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "current_bundle_count"
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "last_fire_timestamp"
            r5 = 2
            r1[r5] = r2
            java.lang.String r2 = "last_bundled_timestamp"
            r6 = 3
            r1[r6] = r2
            java.lang.String r2 = "last_bundled_day"
            r7 = 4
            r1[r7] = r2
            java.lang.String r2 = "last_sampled_complex_event_id"
            r8 = 5
            r1[r8] = r2
            java.lang.String r2 = "last_sampling_rate"
            r9 = 6
            r1[r9] = r2
            java.lang.String r2 = "last_exempt_from_sampling"
            r10 = 7
            r1[r10] = r2
            java.lang.String r2 = "current_session_count"
            r11 = 8
            r1[r11] = r2
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r17 = 0
            android.database.sqlite.SQLiteDatabase r18 = r26.e_()     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            java.lang.String[] r1 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            r20 = r0
            java.lang.String[] r20 = (java.lang.String[]) r20     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            java.lang.String r21 = "app_id=? and name=?"
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            r0[r3] = r28     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            r0[r4] = r29     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            r24 = 0
            r25 = 0
            r23 = 0
            r19 = r27
            r22 = r0
            android.database.Cursor r1 = r18.query(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ SQLiteException -> 0x0137, all -> 0x0135 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r0 != 0) goto L_0x0079
            if (r1 == 0) goto L_0x0078
            r1.close()
        L_0x0078:
            return r17
        L_0x0079:
            long r12 = r1.getLong(r3)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            long r14 = r1.getLong(r4)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            long r18 = r1.getLong(r5)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            boolean r0 = r1.isNull(r6)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            r20 = 0
            if (r0 == 0) goto L_0x0090
            r5 = r20
            goto L_0x0094
        L_0x0090:
            long r5 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
        L_0x0094:
            boolean r0 = r1.isNull(r7)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r0 == 0) goto L_0x009d
            r0 = r17
            goto L_0x00a5
        L_0x009d:
            long r22 = r1.getLong(r7)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
        L_0x00a5:
            boolean r2 = r1.isNull(r8)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r2 == 0) goto L_0x00ae
            r2 = r17
            goto L_0x00b6
        L_0x00ae:
            long r7 = r1.getLong(r8)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
        L_0x00b6:
            boolean r7 = r1.isNull(r9)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r7 == 0) goto L_0x00bf
            r7 = r17
            goto L_0x00c7
        L_0x00bf:
            long r7 = r1.getLong(r9)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
        L_0x00c7:
            boolean r8 = r1.isNull(r10)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r8 != 0) goto L_0x00e4
            long r8 = r1.getLong(r10)     // Catch:{ SQLiteException -> 0x00df }
            r22 = 1
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x00d8
            r3 = r4
        L_0x00d8:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ SQLiteException -> 0x00df }
            r16 = r3
            goto L_0x00e6
        L_0x00df:
            r0 = move-exception
            r2 = r29
            goto L_0x013c
        L_0x00e4:
            r16 = r17
        L_0x00e6:
            boolean r3 = r1.isNull(r11)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            if (r3 == 0) goto L_0x00ed
            goto L_0x00f1
        L_0x00ed:
            long r20 = r1.getLong(r11)     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
        L_0x00f1:
            r3 = r12
            r13 = r0
            com.google.android.gms.measurement.internal.zzbb r0 = new com.google.android.gms.measurement.internal.zzbb     // Catch:{ SQLiteException -> 0x012f, all -> 0x0129 }
            r11 = r5
            r5 = r14
            r9 = r18
            r18 = r1
            r14 = r2
            r15 = r7
            r7 = r20
            r1 = r28
            r2 = r29
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
            boolean r1 = r18.moveToNext()     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
            if (r1 == 0) goto L_0x011d
            com.google.android.gms.measurement.internal.zzgo r1 = r26.zzj()     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r28)     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
            r1.zza(r3, r4)     // Catch:{ SQLiteException -> 0x0125, all -> 0x0123 }
        L_0x011d:
            if (r18 == 0) goto L_0x0122
            r18.close()
        L_0x0122:
            return r0
        L_0x0123:
            r0 = move-exception
            goto L_0x012c
        L_0x0125:
            r0 = move-exception
            r1 = r18
            goto L_0x013c
        L_0x0129:
            r0 = move-exception
            r18 = r1
        L_0x012c:
            r17 = r18
            goto L_0x015e
        L_0x012f:
            r0 = move-exception
            r2 = r29
            r18 = r1
            goto L_0x013c
        L_0x0135:
            r0 = move-exception
            goto L_0x015e
        L_0x0137:
            r0 = move-exception
            r2 = r29
            r1 = r17
        L_0x013c:
            com.google.android.gms.measurement.internal.zzgo r3 = r26.zzj()     // Catch:{ all -> 0x015b }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x015b }
            java.lang.String r4 = "Error querying events. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r28)     // Catch:{ all -> 0x015b }
            com.google.android.gms.measurement.internal.zzgh r6 = r26.zzi()     // Catch:{ all -> 0x015b }
            java.lang.String r2 = r6.zza((java.lang.String) r2)     // Catch:{ all -> 0x015b }
            r3.zza(r4, r5, r2, r0)     // Catch:{ all -> 0x015b }
            if (r1 == 0) goto L_0x015a
            r1.close()
        L_0x015a:
            return r17
        L_0x015b:
            r0 = move-exception
            r17 = r1
        L_0x015e:
            if (r17 == 0) goto L_0x0163
            r17.close()
        L_0x0163:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbb");
    }

    public final zzje zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzje.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzje zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        zzje zzje = (zzje) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzao());
        return zzje == null ? zzje.zza : zzje;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: com.google.android.gms.measurement.internal.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: com.google.android.gms.measurement.internal.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: com.google.android.gms.measurement.internal.zzoj} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzoj zzj(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            r19.zzt()
            r19.zzal()
            boolean r0 = com.google.android.gms.internal.measurement.zzpu.zza()
            r2 = 0
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.measurement.internal.zzag r0 = r19.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzcb
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r0 != 0) goto L_0x001f
            return r2
        L_0x001f:
            android.database.sqlite.SQLiteDatabase r3 = r19.e_()     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r4 = "upload_queue"
            r0 = 7
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "rowId"
            r12 = 0
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "app_id"
            r13 = 1
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "measurement_batch"
            r14 = 2
            r5[r14] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "upload_uri"
            r15 = 3
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "upload_headers"
            r6 = 4
            r5[r6] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "upload_type"
            r7 = 5
            r5[r7] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = "retry_count"
            r8 = 6
            r5[r8] = r0     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = r19.zzao()     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r10 = "app_id=? AND NOT "
            r9.<init>(r10)     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.StringBuilder r0 = r9.append(r0)     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            r9 = r7
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            r7[r12] = r1     // Catch:{ SQLiteException -> 0x0195, all -> 0x0191 }
            java.lang.String r10 = "creation_timestamp ASC"
            java.lang.String r11 = "1"
            r16 = r8
            r8 = 0
            r17 = r9
            r9 = 0
            r18 = r6
            r6 = r0
            r0 = r17
            r17 = r13
            r13 = r16
            r16 = r2
            r2 = r18
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x018f, all -> 0x018b }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0189 }
            if (r4 != 0) goto L_0x008a
            if (r3 == 0) goto L_0x0089
            r3.close()
        L_0x0089:
            return r16
        L_0x008a:
            java.lang.String r4 = r3.getString(r15)     // Catch:{ SQLiteException -> 0x0189 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x0189 }
            if (r5 == 0) goto L_0x00a7
            com.google.android.gms.measurement.internal.zzgo r0 = r19.zzj()     // Catch:{ SQLiteException -> 0x0189 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()     // Catch:{ SQLiteException -> 0x0189 }
            java.lang.String r2 = "Upload uri is null or empty. Destination is unknown. Dropping batch. "
            r0.zza(r2)     // Catch:{ SQLiteException -> 0x0189 }
            if (r3 == 0) goto L_0x00a6
            r3.close()
        L_0x00a6:
            return r16
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r5 = com.google.android.gms.internal.measurement.zzfy.zzj.zzb()     // Catch:{ IOException -> 0x0175 }
            byte[] r6 = r3.getBlob(r14)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzlb r5 = com.google.android.gms.measurement.internal.zzoo.zza(r5, (byte[]) r6)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r5 = (com.google.android.gms.internal.measurement.zzfy.zzj.zza) r5     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zznt[] r6 = com.google.android.gms.measurement.internal.zznt.values()     // Catch:{ IOException -> 0x0175 }
            int r0 = r3.getInt(r0)     // Catch:{ IOException -> 0x0175 }
            r0 = r6[r0]     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zznt r6 = com.google.android.gms.measurement.internal.zznt.SGTM     // Catch:{ IOException -> 0x0175 }
            if (r0 == r6) goto L_0x00c7
            com.google.android.gms.measurement.internal.zznt r6 = com.google.android.gms.measurement.internal.zznt.GOOGLE_ANALYTICS     // Catch:{ IOException -> 0x0175 }
            if (r0 != r6) goto L_0x0108
        L_0x00c7:
            int r6 = r3.getInt(r13)     // Catch:{ IOException -> 0x0175 }
            if (r6 <= 0) goto L_0x0108
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ IOException -> 0x0175 }
            r6.<init>()     // Catch:{ IOException -> 0x0175 }
            java.util.List r7 = r5.zzd()     // Catch:{ IOException -> 0x0175 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x0175 }
        L_0x00da:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x0175 }
            if (r8 == 0) goto L_0x0102
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = (com.google.android.gms.internal.measurement.zzfy.zzk) r8     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzjt$zzb r8 = r8.zzcd()     // Catch:{ IOException -> 0x0175 }
            r9 = r8
            com.google.android.gms.internal.measurement.zzjt$zzb r9 = (com.google.android.gms.internal.measurement.zzjt.zzb) r9     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r8 = (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r8     // Catch:{ IOException -> 0x0175 }
            int r9 = r3.getInt(r13)     // Catch:{ IOException -> 0x0175 }
            r8.zzi((int) r9)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzlc r8 = r8.zzai()     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzjt r8 = (com.google.android.gms.internal.measurement.zzjt) r8     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = (com.google.android.gms.internal.measurement.zzfy.zzk) r8     // Catch:{ IOException -> 0x0175 }
            r6.add(r8)     // Catch:{ IOException -> 0x0175 }
            goto L_0x00da
        L_0x0102:
            r5.zzb()     // Catch:{ IOException -> 0x0175 }
            r5.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzk>) r6)     // Catch:{ IOException -> 0x0175 }
        L_0x0108:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ IOException -> 0x0175 }
            r6.<init>()     // Catch:{ IOException -> 0x0175 }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ IOException -> 0x0175 }
            if (r2 == 0) goto L_0x0146
            java.lang.String r7 = "\r\n"
            java.lang.String[] r2 = r2.split(r7)     // Catch:{ IOException -> 0x0175 }
            int r7 = r2.length     // Catch:{ IOException -> 0x0175 }
            r8 = r12
        L_0x011b:
            if (r8 >= r7) goto L_0x0146
            r9 = r2[r8]     // Catch:{ IOException -> 0x0175 }
            boolean r10 = r9.isEmpty()     // Catch:{ IOException -> 0x0175 }
            if (r10 != 0) goto L_0x0146
            java.lang.String r10 = "="
            java.lang.String[] r10 = r9.split(r10, r14)     // Catch:{ IOException -> 0x0175 }
            int r11 = r10.length     // Catch:{ IOException -> 0x0175 }
            if (r11 == r14) goto L_0x013c
            com.google.android.gms.measurement.internal.zzgo r2 = r19.zzj()     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ IOException -> 0x0175 }
            java.lang.String r7 = "Invalid upload header: "
            r2.zza(r7, r9)     // Catch:{ IOException -> 0x0175 }
            goto L_0x0146
        L_0x013c:
            r9 = r10[r12]     // Catch:{ IOException -> 0x0175 }
            r10 = r10[r17]     // Catch:{ IOException -> 0x0175 }
            r6.put(r9, r10)     // Catch:{ IOException -> 0x0175 }
            int r8 = r8 + 1
            goto L_0x011b
        L_0x0146:
            com.google.android.gms.measurement.internal.zzom r2 = new com.google.android.gms.measurement.internal.zzom     // Catch:{ IOException -> 0x0175 }
            r2.<init>()     // Catch:{ IOException -> 0x0175 }
            long r7 = r3.getLong(r12)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzom r2 = r2.zza((long) r7)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzlc r5 = r5.zzai()     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzjt r5 = (com.google.android.gms.internal.measurement.zzjt) r5     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfy$zzj r5 = (com.google.android.gms.internal.measurement.zzfy.zzj) r5     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzom r2 = r2.zza((com.google.android.gms.internal.measurement.zzfy.zzj) r5)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzom r2 = r2.zza((java.lang.String) r4)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzom r2 = r2.zza((java.util.Map<java.lang.String, java.lang.String>) r6)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzom r0 = r2.zza((com.google.android.gms.measurement.internal.zznt) r0)     // Catch:{ IOException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzoj r0 = r0.zza()     // Catch:{ IOException -> 0x0175 }
            if (r3 == 0) goto L_0x0174
            r3.close()
        L_0x0174:
            return r0
        L_0x0175:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r19.zzj()     // Catch:{ SQLiteException -> 0x0189 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x0189 }
            java.lang.String r4 = "Failed to queued MeasurementBatch from upload_queue. appId"
            r2.zza(r4, r1, r0)     // Catch:{ SQLiteException -> 0x0189 }
            if (r3 == 0) goto L_0x0188
            r3.close()
        L_0x0188:
            return r16
        L_0x0189:
            r0 = move-exception
            goto L_0x019a
        L_0x018b:
            r0 = move-exception
            r2 = r16
            goto L_0x01af
        L_0x018f:
            r0 = move-exception
            goto L_0x0198
        L_0x0191:
            r0 = move-exception
            r16 = r2
            goto L_0x01af
        L_0x0195:
            r0 = move-exception
            r16 = r2
        L_0x0198:
            r3 = r16
        L_0x019a:
            com.google.android.gms.measurement.internal.zzgo r2 = r19.zzj()     // Catch:{ all -> 0x01ad }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x01ad }
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r2.zza(r4, r1, r0)     // Catch:{ all -> 0x01ad }
            if (r3 == 0) goto L_0x01ac
            r3.close()
        L_0x01ac:
            return r16
        L_0x01ad:
            r0 = move-exception
            r2 = r3
        L_0x01af:
            if (r2 == 0) goto L_0x01b4
            r2.close()
        L_0x01b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzoj");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzop zze(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            r13.zzt()
            r13.zzal()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.e_()     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            java.lang.String r3 = "user_attributes"
            r0 = 3
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            java.lang.String r0 = "set_timestamp"
            r10 = 0
            r4[r10] = r0     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            java.lang.String r0 = "value"
            r11 = 1
            r4[r11] = r0     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            java.lang.String r0 = "origin"
            r12 = 2
            r4[r12] = r0     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            r6[r10] = r14     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0082, all -> 0x007f }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007a }
            if (r0 != 0) goto L_0x0040
            if (r2 == 0) goto L_0x003f
            r2.close()
        L_0x003f:
            return r1
        L_0x0040:
            long r7 = r2.getLong(r10)     // Catch:{ SQLiteException -> 0x007a }
            java.lang.Object r9 = r13.zza((android.database.Cursor) r2, (int) r11)     // Catch:{ SQLiteException -> 0x007a }
            if (r9 != 0) goto L_0x0050
            if (r2 == 0) goto L_0x004f
            r2.close()
        L_0x004f:
            return r1
        L_0x0050:
            java.lang.String r5 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x007a }
            com.google.android.gms.measurement.internal.zzop r3 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ SQLiteException -> 0x007a }
            r4 = r14
            r6 = r15
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0078 }
            boolean r14 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0078 }
            if (r14 == 0) goto L_0x0072
            com.google.android.gms.measurement.internal.zzgo r14 = r13.zzj()     // Catch:{ SQLiteException -> 0x0078 }
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzg()     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r15 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r4)     // Catch:{ SQLiteException -> 0x0078 }
            r14.zza(r15, r0)     // Catch:{ SQLiteException -> 0x0078 }
        L_0x0072:
            if (r2 == 0) goto L_0x0077
            r2.close()
        L_0x0077:
            return r3
        L_0x0078:
            r0 = move-exception
            goto L_0x007d
        L_0x007a:
            r0 = move-exception
            r4 = r14
            r6 = r15
        L_0x007d:
            r14 = r0
            goto L_0x0087
        L_0x007f:
            r0 = move-exception
            r14 = r0
            goto L_0x00a9
        L_0x0082:
            r0 = move-exception
            r4 = r14
            r6 = r15
            r14 = r0
            r2 = r1
        L_0x0087:
            com.google.android.gms.measurement.internal.zzgo r15 = r13.zzj()     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzgq r15 = r15.zzg()     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r4)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzgh r4 = r13.zzi()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = r4.zzc(r6)     // Catch:{ all -> 0x00a6 }
            r15.zza(r0, r3, r4, r14)     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x00a5
            r2.close()
        L_0x00a5:
            return r1
        L_0x00a6:
            r0 = move-exception
            r14 = r0
            r1 = r2
        L_0x00a9:
            if (r1 == 0) goto L_0x00ae
            r1.close()
        L_0x00ae:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzop");
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzau<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x002c }
            if (r4 != 0) goto L_0x0022
            com.google.android.gms.measurement.internal.zzgo r4 = r2.zzj()     // Catch:{ SQLiteException -> 0x002c }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzp()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch:{ SQLiteException -> 0x002c }
            if (r3 == 0) goto L_0x0021
            r3.close()
        L_0x0021:
            return r0
        L_0x0022:
            java.lang.Object r4 = r5.zza(r3)     // Catch:{ SQLiteException -> 0x002c }
            if (r3 == 0) goto L_0x002b
            r3.close()
        L_0x002b:
            return r4
        L_0x002c:
            r4 = move-exception
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            goto L_0x0047
        L_0x0030:
            r4 = move-exception
            r3 = r0
        L_0x0032:
            com.google.android.gms.measurement.internal.zzgo r5 = r2.zzj()     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0044
            r3.close()
        L_0x0044:
            return r0
        L_0x0045:
            r4 = move-exception
            r0 = r3
        L_0x0047:
            if (r0 == 0) goto L_0x004c
            r0.close()
        L_0x004c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzau):java.lang.Object");
    }

    private final String zzao() {
        long currentTimeMillis = zzb().currentTimeMillis();
        String str = "(upload_type = " + zznt.GOOGLE_SIGNAL.zza() + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + zzbh.zzaf.zza(null).longValue() + " AS INTEGER)))";
        int zza2 = zznt.GOOGLE_SIGNAL.zza();
        return "(" + str + " OR " + ("(upload_type != " + zza2 + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + zzag.zzm() + " AS INTEGER)))") + ")";
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzt()
            r4.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e_()     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzgo r6 = r4.zzj()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0044
        L_0x0040:
            r6 = move-exception
            goto L_0x0059
        L_0x0042:
            r6 = move-exception
            r5 = r0
        L_0x0044:
            com.google.android.gms.measurement.internal.zzgo r1 = r4.zzj()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0056
            r5.close()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
            r0 = r5
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            r0.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzgo r3 = r6.zzj()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.f_():java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<Pair<zzfy.zzk, Long>> zza(String str, int i, int i2) {
        long j;
        long j2;
        int i3 = i2;
        zzt();
        zzal();
        int i4 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = e_().query("queue", new String[]{"rowid", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzfy.zzk, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (true) {
                long j3 = cursor.getLong(0);
                try {
                    byte[] zzc2 = g_().zzc(cursor.getBlob(i4));
                    if (!arrayList.isEmpty() && zzc2.length + i5 > i3) {
                        break;
                    }
                    try {
                        zzfy.zzk.zza zza2 = (zzfy.zzk.zza) zzoo.zza(zzfy.zzk.zzw(), zzc2);
                        if (!arrayList.isEmpty()) {
                            zzfy.zzk zzk2 = (zzfy.zzk) ((Pair) arrayList.get(0)).first;
                            zzfy.zzk zzk3 = (zzfy.zzk) ((zzjt) zza2.zzai());
                            if (!zzk2.zzae().equals(zzk3.zzae()) || !zzk2.zzad().equals(zzk3.zzad()) || zzk2.zzau() != zzk3.zzau() || !zzk2.zzaf().equals(zzk3.zzaf())) {
                                break;
                            }
                            Iterator<zzfy.zzo> it = zzk2.zzas().iterator();
                            while (true) {
                                j = -1;
                                if (!it.hasNext()) {
                                    j2 = -1;
                                    break;
                                }
                                zzfy.zzo next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    j2 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzfy.zzo> it2 = zzk3.zzas().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzfy.zzo next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    j = next2.zzc();
                                    break;
                                }
                            }
                            if (j2 != j) {
                                break;
                            }
                        }
                        if (!cursor.isNull(2)) {
                            zza2.zzi(cursor.getInt(2));
                        }
                        i5 += zzc2.length;
                        arrayList.add(Pair.create((zzfy.zzk) ((zzjt) zza2.zzai()), Long.valueOf(j3)));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzgo.zza(str), e);
                    }
                    if (!cursor.moveToNext() || i5 > i3) {
                        break;
                    }
                    i4 = 1;
                } catch (IOException e2) {
                    zzj().zzg().zza("Failed to unzip queued bundle. appId", zzgo.zza(str), e2);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzj().zzg().zza("Error querying bundles. appId", zzgo.zza(str), e3);
            List<Pair<zzfy.zzk, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + ProxyConfig.MATCH_ALL_SCHEMES);
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzae> zza(java.lang.String r33, java.lang.String[] r34) {
        /*
            r32 = this;
            r32.zzt()
            r32.zzal()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r32.e_()     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "app_id"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "name"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "active"
            r15 = 4
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "trigger_event_name"
            r6 = 5
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "trigger_timeout"
            r7 = 6
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "timed_out_event"
            r8 = 7
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "creation_timestamp"
            r9 = 8
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "triggered_event"
            r10 = 9
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "triggered_timestamp"
            r1 = 10
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "time_to_live"
            r1 = 11
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            java.lang.String r5 = "expired_event"
            r1 = 12
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            r5 = r9
            java.lang.String r9 = "rowid"
            r19 = r10
            java.lang.String r10 = "1001"
            r20 = r7
            r7 = 0
            r21 = r8
            r8 = 0
            r5 = r33
            r1 = r6
            r6 = r34
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0153, all -> 0x014e }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            if (r3 != 0) goto L_0x0081
            if (r2 == 0) goto L_0x007d
            r2.close()
            return r0
        L_0x007d:
            r10 = r32
            goto L_0x013c
        L_0x0081:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x009e
            com.google.android.gms.measurement.internal.zzgo r1 = r32.zzj()     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            r1.zza(r3, r4)     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            r10 = r32
            goto L_0x0137
        L_0x009e:
            r3 = 10
            java.lang.String r17 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            java.lang.String r9 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            java.lang.String r5 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x0149, all -> 0x0144 }
            r10 = r32
            java.lang.Object r8 = r10.zza((android.database.Cursor) r2, (int) r14)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            int r4 = r2.getInt(r15)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            if (r4 == 0) goto L_0x00bb
            r22 = r12
            goto L_0x00bd
        L_0x00bb:
            r22 = r11
        L_0x00bd:
            r4 = 12
            r6 = 6
            java.lang.String r23 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            long r25 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzoo r7 = r10.g_()     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r1 = 7
            byte[] r3 = r2.getBlob(r1)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r1 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable r1 = r7.zza((byte[]) r3, r1)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r24 = r1
            com.google.android.gms.measurement.internal.zzbf r24 = (com.google.android.gms.measurement.internal.zzbf) r24     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r1 = 8
            long r20 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzoo r3 = r10.g_()     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r7 = 9
            byte[] r1 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r4 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable r1 = r3.zza((byte[]) r1, r4)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r27 = r1
            com.google.android.gms.measurement.internal.zzbf r27 = (com.google.android.gms.measurement.internal.zzbf) r27     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r1 = r6
            r19 = r7
            r3 = 10
            long r6 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r4 = 11
            long r28 = r2.getLong(r4)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzoo r1 = r10.g_()     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r3 = 12
            byte[] r4 = r2.getBlob(r3)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbf> r3 = com.google.android.gms.measurement.internal.zzbf.CREATOR     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            android.os.Parcelable r1 = r1.zza((byte[]) r4, r3)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r30 = r1
            com.google.android.gms.measurement.internal.zzbf r30 = (com.google.android.gms.measurement.internal.zzbf) r30     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzon r4 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r3 = r19
            r1 = 11
            r31 = 6
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r19 = r4
            r18 = r9
            com.google.android.gms.measurement.internal.zzae r16 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r4 = r16
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            if (r4 != 0) goto L_0x013d
        L_0x0137:
            if (r2 == 0) goto L_0x013c
            r2.close()
        L_0x013c:
            return r0
        L_0x013d:
            r1 = 5
            goto L_0x0081
        L_0x0140:
            r0 = move-exception
            goto L_0x0147
        L_0x0142:
            r0 = move-exception
            goto L_0x014c
        L_0x0144:
            r0 = move-exception
            r10 = r32
        L_0x0147:
            r1 = r2
            goto L_0x016f
        L_0x0149:
            r0 = move-exception
            r10 = r32
        L_0x014c:
            r1 = r2
            goto L_0x0157
        L_0x014e:
            r0 = move-exception
            r10 = r32
            r1 = 0
            goto L_0x016f
        L_0x0153:
            r0 = move-exception
            r10 = r32
            r1 = 0
        L_0x0157:
            com.google.android.gms.measurement.internal.zzgo r2 = r10.zzj()     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.zza(r3, r0)     // Catch:{ all -> 0x016e }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x016e }
            if (r1 == 0) goto L_0x016d
            r1.close()
        L_0x016d:
            return r0
        L_0x016e:
            r0 = move-exception
        L_0x016f:
            if (r1 == 0) goto L_0x0174
            r1.close()
        L_0x0174:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List<zzno> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", (String) null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzno(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
                return arrayList;
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying trigger uris. appId", zzgo.zza(str), e);
            List<zzno> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List<zzop> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursor.getLong(2);
                    Object zza2 = zza(cursor, 3);
                    if (zza2 == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgo.zza(str));
                    } else {
                        arrayList.add(new zzop(str, str2, string, j, zza2));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
                return arrayList;
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying user properties. appId", zzgo.zza(str), e);
            List<zzop> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011e, code lost:
        r13 = r18;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0122, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0123, code lost:
        r13 = r18;
        r7 = r20;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzop> zzb(java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r18 = this;
            r0 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            r18.zzt()
            r18.zzal()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            r4 = 3
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            r6 = r19
            r3.add(r6)     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            java.lang.String r7 = "app_id=?"
            r5.<init>(r7)     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            boolean r7 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x0122, all -> 0x011d }
            if (r7 != 0) goto L_0x003f
            r7 = r20
            r3.add(r7)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            java.lang.String r8 = " and origin=?"
            r5.append(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            goto L_0x0041
        L_0x0033:
            r0 = move-exception
            r2 = 0
            r13 = r18
            goto L_0x0144
        L_0x0039:
            r0 = move-exception
            r2 = 0
            r13 = r18
            goto L_0x0128
        L_0x003f:
            r7 = r20
        L_0x0041:
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            if (r8 != 0) goto L_0x0062
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            r8.<init>()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            java.lang.String r9 = "*"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            java.lang.String r8 = r8.toString()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            r3.add(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
            java.lang.String r8 = " and name glob ?"
            r5.append(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0033 }
        L_0x0062:
            int r8 = r3.size()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.Object[] r3 = r3.toArray(r8)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r12 = r3
            java.lang.String[] r12 = (java.lang.String[]) r12     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            android.database.sqlite.SQLiteDatabase r8 = r18.e_()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r9 = "user_attributes"
            r3 = 4
            java.lang.String[] r10 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r3 = "name"
            r11 = 0
            r10[r11] = r3     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r3 = "set_timestamp"
            r13 = 1
            r10[r13] = r3     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r3 = "value"
            r14 = 2
            r10[r14] = r3     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r3 = "origin"
            r10[r4] = r3     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r3 = r5.toString()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r15 = "rowid"
            java.lang.String r16 = "1001"
            r5 = r13
            r13 = 0
            r17 = r14
            r14 = 0
            r2 = r11
            r11 = r3
            r3 = r17
            android.database.Cursor r12 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            boolean r8 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            if (r8 != 0) goto L_0x00af
            if (r12 == 0) goto L_0x00ac
            r12.close()
            return r1
        L_0x00ac:
            r13 = r18
            goto L_0x0106
        L_0x00af:
            int r8 = r1.size()     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r8 < r9) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzgo r0 = r18.zzj()     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            java.lang.String r2 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            r0.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            r13 = r18
            goto L_0x0101
        L_0x00cb:
            java.lang.String r8 = r12.getString(r2)     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            long r9 = r12.getLong(r5)     // Catch:{ SQLiteException -> 0x0114, all -> 0x010f }
            r13 = r18
            java.lang.Object r11 = r13.zza((android.database.Cursor) r12, (int) r3)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            java.lang.String r7 = r12.getString(r4)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            if (r11 != 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.zzgo r8 = r13.zzj()     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            java.lang.String r9 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            r8.zza(r9, r10, r7, r0)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            r14 = r5
            goto L_0x00fb
        L_0x00f2:
            r14 = r5
            com.google.android.gms.measurement.internal.zzop r5 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            r5.<init>(r6, r7, r8, r9, r11)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            r1.add(r5)     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
        L_0x00fb:
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x010d, all -> 0x010b }
            if (r5 != 0) goto L_0x0107
        L_0x0101:
            if (r12 == 0) goto L_0x0106
            r12.close()
        L_0x0106:
            return r1
        L_0x0107:
            r6 = r19
            r5 = r14
            goto L_0x00af
        L_0x010b:
            r0 = move-exception
            goto L_0x0112
        L_0x010d:
            r0 = move-exception
            goto L_0x0117
        L_0x010f:
            r0 = move-exception
            r13 = r18
        L_0x0112:
            r2 = r12
            goto L_0x0144
        L_0x0114:
            r0 = move-exception
            r13 = r18
        L_0x0117:
            r2 = r12
            goto L_0x0128
        L_0x0119:
            r0 = move-exception
            r13 = r18
            goto L_0x0127
        L_0x011d:
            r0 = move-exception
            r13 = r18
            r2 = 0
            goto L_0x0144
        L_0x0122:
            r0 = move-exception
            r13 = r18
            r7 = r20
        L_0x0127:
            r2 = 0
        L_0x0128:
            com.google.android.gms.measurement.internal.zzgo r1 = r13.zzj()     // Catch:{ all -> 0x0143 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch:{ all -> 0x0143 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r19)     // Catch:{ all -> 0x0143 }
            r1.zza(r3, r4, r7, r0)     // Catch:{ all -> 0x0143 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0143 }
            if (r2 == 0) goto L_0x0142
            r2.close()
        L_0x0142:
            return r0
        L_0x0143:
            r0 = move-exception
        L_0x0144:
            if (r2 == 0) goto L_0x0149
            r2.close()
        L_0x0149:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, zzfy.zzm> zzm(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, zzfy.zzm> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            ArrayMap arrayMap = new ArrayMap();
            do {
                int i = cursor.getInt(0);
                try {
                    arrayMap.put(Integer.valueOf(i), (zzfy.zzm) ((zzjt) ((zzfy.zzm.zza) zzoo.zza(zzfy.zzm.zze(), cursor.getBlob(1))).zzai()));
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgo.zza(str), Integer.valueOf(i), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filter results. appId", zzgo.zza(str), e2);
            Map<Integer, zzfy.zzm> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zzb>> zzn(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase e_ = e_();
        Cursor cursor = null;
        try {
            cursor = e_.query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzfo.zzb zzb2 = (zzfo.zzb) ((zzjt) ((zzfo.zzb.zza) zzoo.zza(zzfo.zzb.zzc(), cursor.getBlob(1))).zzai());
                    if (zzb2.zzk()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
            Map<Integer, List<zzfo.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zzb>> zzf(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase e_ = e_();
        Cursor cursor = null;
        try {
            cursor = e_.query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND event_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzfo.zzb zzb2 = (zzfo.zzb) ((zzjt) ((zzfo.zzb.zza) zzoo.zza(zzfo.zzb.zzc(), cursor.getBlob(1))).zzai());
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zzb2);
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
            Map<Integer, List<zzfo.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzfo.zze>> zzg(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase e_ = e_();
        Cursor cursor = null;
        try {
            cursor = e_.query("property_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND property_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzfo.zze>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzfo.zze zze2 = (zzfo.zze) ((zzjt) ((zzfo.zze.zza) zzoo.zza(zzfo.zze.zzc(), cursor.getBlob(1))).zzai());
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zze2);
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter", zzgo.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
            Map<Integer, List<zzfo.zze>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<Integer>> zzo(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            if (!cursor.moveToFirst()) {
                Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                int i = cursor.getInt(0);
                List list = (List) arrayMap.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList();
                    arrayMap.put(Integer.valueOf(i), list);
                }
                list.add(Integer.valueOf(cursor.getInt(1)));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying scoped filters. appId", zzgo.zza(str), e);
            Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    zzal(zznv zznv) {
        super(zznv);
    }

    public final void zza(String str, Bundle bundle) {
        zzal zzal = this;
        Preconditions.checkNotNull(bundle);
        zzal.zzt();
        zzal.zzal();
        String str2 = str;
        zzar zzar = new zzar(zzal, str2);
        List<zzap> zza2 = zzar.zza();
        while (!zza2.isEmpty()) {
            for (zzap next : zza2) {
                zzoo g_ = zzal.g_();
                zzfy.zzf zzf2 = next.zzd;
                Bundle bundle2 = new Bundle();
                for (zzfy.zzh next2 : zzf2.zzh()) {
                    if (next2.zzj()) {
                        bundle2.putDouble(next2.zzg(), next2.zza());
                    } else if (next2.zzk()) {
                        bundle2.putFloat(next2.zzg(), next2.zzb());
                    } else if (next2.zzl()) {
                        bundle2.putLong(next2.zzg(), next2.zzd());
                    } else if (next2.zzn()) {
                        bundle2.putString(next2.zzg(), next2.zzh());
                    } else if (!next2.zzi().isEmpty()) {
                        bundle2.putParcelableArray(next2.zzg(), zzoo.zzb(next2.zzi()));
                    } else {
                        g_.zzj().zzg().zza("Unexpected parameter type for parameter", next2);
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzg = zzf2.zzg();
                if (string == null) {
                    string = "";
                }
                zzgs zzgs = new zzgs(zzg, string, bundle2, zzf2.zzd());
                zzal.zzq().zza(zzgs.zzc, bundle);
                zzal.zza(next.zza, new zzbc(zzal.zzu, zzgs.zzb, str2, next.zzd.zzg(), next.zzd.zzd(), next.zzd.zzc(), zzgs.zzc), next.zzb, next.zzc);
                zzal = this;
                str2 = str;
            }
            zza2 = zzar.zza();
            zzal = this;
            str2 = str;
        }
    }

    public final void zzp() {
        zzal();
        e_().beginTransaction();
    }

    public final void zzp(String str) {
        zzt();
        zzal();
        try {
            e_().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error clearing default event params", e);
        }
    }

    private final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzgo.zza(str2), e);
        }
    }

    public final void zzq(String str) {
        zzbb zzd2;
        zzi("events_snapshot", str);
        Cursor cursor = null;
        try {
            cursor = e_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (!(string == null || (zzd2 = zzd(str, string)) == null)) {
                        zza("events_snapshot", zzd2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error creating snapshot. appId", zzgo.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void zzu() {
        zzal();
        e_().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzt();
        zzal();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzaa()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Long l) {
        zzt();
        zzal();
        Preconditions.checkNotNull(l);
        if ((!zzpu.zza() || zze().zza(zzbh.zzcb)) && zzaa()) {
            if (zzb("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        int delete;
        zzt();
        zzal();
        if (zzaa()) {
            long zza2 = zzn().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzag.zzn()) {
                zzn().zza.zza(elapsedRealtime);
                zzt();
                zzal();
                if (zzaa() && (delete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) > 0) {
                    zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzgo.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if ("_v".equals(r0) != false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0107 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzr(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "events_snapshot"
            java.util.ArrayList r0 = new java.util.ArrayList
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r5 = "name"
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "lifetime_count"
            r7 = 1
            r4[r7] = r5
            java.util.List r4 = java.util.Arrays.asList(r4)
            r0.<init>(r4)
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzbb r5 = r1.zzd(r2, r4)
            java.lang.String r8 = "_v"
            com.google.android.gms.measurement.internal.zzbb r9 = r1.zzd(r2, r8)
            java.lang.String r10 = "events"
            r1.zzi(r10, r2)
            r11 = 0
            android.database.sqlite.SQLiteDatabase r12 = r1.e_()     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            java.lang.String r13 = "events_snapshot"
            java.lang.String[] r14 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            java.lang.Object[] r0 = r0.toArray(r14)     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            r14 = r0
            java.lang.String[] r14 = (java.lang.String[]) r14     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            java.lang.String r15 = "app_id=?"
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            r0[r6] = r2     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            r18 = 0
            r19 = 0
            r17 = 0
            r16 = r0
            android.database.Cursor r11 = r12.query(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00d4, all -> 0x00d1 }
            if (r0 != 0) goto L_0x0069
            if (r11 == 0) goto L_0x005a
            r11.close()
        L_0x005a:
            if (r5 == 0) goto L_0x0060
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r5)
            goto L_0x0065
        L_0x0060:
            if (r9 == 0) goto L_0x0065
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r9)
        L_0x0065:
            r1.zzi(r3, r2)
            return
        L_0x0069:
            r12 = r6
            r13 = r12
        L_0x006b:
            java.lang.String r0 = r11.getString(r6)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzag r14 = r1.zze()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzbh.zzda     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            boolean r14 = r14.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r15)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r14 == 0) goto L_0x0093
            long r14 = r11.getLong(r7)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            r16 = 1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 < 0) goto L_0x00a2
            boolean r14 = r4.equals(r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r14 == 0) goto L_0x008c
            goto L_0x0099
        L_0x008c:
            boolean r14 = r8.equals(r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r14 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x0093:
            boolean r14 = r4.equals(r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r14 == 0) goto L_0x009b
        L_0x0099:
            r12 = r7
            goto L_0x00a2
        L_0x009b:
            boolean r14 = r8.equals(r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r14 == 0) goto L_0x00a2
        L_0x00a1:
            r13 = r7
        L_0x00a2:
            if (r0 == 0) goto L_0x00ad
            com.google.android.gms.measurement.internal.zzbb r0 = r1.zzc(r3, r2, r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r0 == 0) goto L_0x00ad
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r0)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
        L_0x00ad:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cb }
            if (r0 != 0) goto L_0x006b
            if (r11 == 0) goto L_0x00b8
            r11.close()
        L_0x00b8:
            if (r12 != 0) goto L_0x00c0
            if (r5 == 0) goto L_0x00c0
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r5)
            goto L_0x00c7
        L_0x00c0:
            if (r13 != 0) goto L_0x00c7
            if (r9 == 0) goto L_0x00c7
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r9)
        L_0x00c7:
            r1.zzi(r3, r2)
            return
        L_0x00cb:
            r0 = move-exception
            r6 = r12
            goto L_0x0100
        L_0x00ce:
            r0 = move-exception
            r6 = r12
            goto L_0x00d6
        L_0x00d1:
            r0 = move-exception
            r13 = r6
            goto L_0x0100
        L_0x00d4:
            r0 = move-exception
            r13 = r6
        L_0x00d6:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj()     // Catch:{ all -> 0x00ff }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()     // Catch:{ all -> 0x00ff }
            java.lang.String r7 = "Error querying snapshot. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ all -> 0x00ff }
            r4.zza(r7, r8, r0)     // Catch:{ all -> 0x00ff }
            if (r11 == 0) goto L_0x00ec
            r11.close()
        L_0x00ec:
            if (r6 != 0) goto L_0x00f4
            if (r5 == 0) goto L_0x00f4
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r5)
            goto L_0x00fb
        L_0x00f4:
            if (r13 != 0) goto L_0x00fb
            if (r9 == 0) goto L_0x00fb
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r9)
        L_0x00fb:
            r1.zzi(r3, r2)
            return
        L_0x00ff:
            r0 = move-exception
        L_0x0100:
            if (r11 == 0) goto L_0x0105
            r11.close()
        L_0x0105:
            if (r6 != 0) goto L_0x010e
            if (r5 != 0) goto L_0x010a
            goto L_0x010e
        L_0x010a:
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r5)
            goto L_0x0115
        L_0x010e:
            if (r13 != 0) goto L_0x0115
            if (r9 == 0) goto L_0x0115
            r1.zza((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzbb) r9)
        L_0x0115:
            r1.zzi(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzr(java.lang.String):void");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, List<zzfo.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzfo.zza> list2 = list;
        Preconditions.checkNotNull(list2);
        for (int i = 0; i < list2.size(); i++) {
            zzjt.zzb zzcd = list2.get(i).zzcd();
            zzjt.zzb zzb2 = zzcd;
            zzfo.zza.C0006zza zza2 = (zzfo.zza.C0006zza) zzcd;
            if (zza2.zza() != 0) {
                for (int i2 = 0; i2 < zza2.zza(); i2++) {
                    zzjt.zzb zzcd2 = zza2.zza(i2).zzcd();
                    zzjt.zzb zzb3 = zzcd2;
                    zzfo.zzb.zza zza3 = (zzfo.zzb.zza) zzcd2;
                    zzfo.zzb.zza zza4 = (zzfo.zzb.zza) ((zzjt.zzb) zza3.clone());
                    String zzb4 = zzji.zzb(zza3.zzb());
                    if (zzb4 != null) {
                        zza4.zza(zzb4);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza3.zza(); i3++) {
                        zzfo.zzc zza5 = zza3.zza(i3);
                        String zza6 = zzjk.zza(zza5.zze());
                        if (zza6 != null) {
                            zzjt.zzb zzcd3 = zza5.zzcd();
                            zzjt.zzb zzb5 = zzcd3;
                            zza4.zza(i3, (zzfo.zzc) ((zzjt) ((zzfo.zzc.zza) zzcd3).zza(zza6).zzai()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza2 = zza2.zza(i2, zza4);
                        list2.set(i, (zzfo.zza) ((zzjt) zza2.zzai()));
                    }
                }
            }
            if (zza2.zzb() != 0) {
                for (int i4 = 0; i4 < zza2.zzb(); i4++) {
                    zzfo.zze zzb6 = zza2.zzb(i4);
                    String zza7 = zzjj.zza(zzb6.zze());
                    if (zza7 != null) {
                        zzjt.zzb zzcd4 = zzb6.zzcd();
                        zzjt.zzb zzb7 = zzcd4;
                        zza2 = zza2.zza(i4, ((zzfo.zze.zza) zzcd4).zza(zza7));
                        list2.set(i, (zzfo.zza) ((zzjt) zza2.zzai()));
                    }
                }
            }
        }
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(list2);
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        try {
            zzal();
            zzt();
            Preconditions.checkNotEmpty(str2);
            SQLiteDatabase e_2 = e_();
            e_2.delete("property_filters", "app_id=?", new String[]{str2});
            e_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzfo.zza next : list2) {
                zzal();
                zzt();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotNull(next);
                if (!next.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzgo.zza(str2));
                } else {
                    int zza8 = next.zza();
                    Iterator<zzfo.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str2), Integer.valueOf(zza8));
                                break;
                            }
                        } else {
                            Iterator<zzfo.zze> it2 = next.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str2), Integer.valueOf(zza8));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfo.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zza8, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzfo.zze> it4 = next.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zza8, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzal();
                                        zzt();
                                        Preconditions.checkNotEmpty(str2);
                                        SQLiteDatabase e_3 = e_();
                                        e_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                        e_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfo.zza next2 : list2) {
                arrayList.add(next2.zzg() ? Integer.valueOf(next2.zza()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            e_.setTransactionSuccessful();
        } finally {
            e_.endTransaction();
        }
    }

    public final void zzw() {
        zzal();
        e_().setTransactionSuccessful();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        if (r7.zzg.zzb(r0).zza(com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE) != false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0328 A[Catch:{ SQLiteException -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzg r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r10 = "apps"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            r7.zzt()
            r7.zzal()
            java.lang.String r0 = r8.zzac()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "app_id"
            r1.put(r2, r0)
            boolean r2 = com.google.android.gms.internal.measurement.zznm.zza()
            java.lang.String r3 = "app_instance_id"
            r4 = 0
            if (r2 == 0) goto L_0x0045
            com.google.android.gms.measurement.internal.zzag r2 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzcy
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)
            if (r2 == 0) goto L_0x0045
            if (r9 == 0) goto L_0x0037
            r1.put(r3, r4)
            goto L_0x004c
        L_0x0037:
            com.google.android.gms.measurement.internal.zznv r9 = r7.zzg
            com.google.android.gms.measurement.internal.zzje r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzje$zza r2 = com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzje.zza) r2)
            if (r9 == 0) goto L_0x004c
        L_0x0045:
            java.lang.String r9 = r8.zzad()
            r1.put(r3, r9)
        L_0x004c:
            java.lang.String r9 = "gmp_app_id"
            java.lang.String r2 = r8.zzah()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzcy
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zznv r9 = r7.zzg
            com.google.android.gms.measurement.internal.zzje r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzje$zza r2 = com.google.android.gms.measurement.internal.zzje.zza.AD_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzje.zza) r2)
            if (r9 == 0) goto L_0x007e
        L_0x0075:
            java.lang.String r9 = "resettable_device_id_hash"
            java.lang.String r2 = r8.zzaj()
            r1.put(r9, r2)
        L_0x007e:
            long r2 = r8.zzt()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_index"
            r1.put(r2, r9)
            long r2 = r8.zzu()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_start_timestamp"
            r1.put(r2, r9)
            long r2 = r8.zzs()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_end_timestamp"
            r1.put(r2, r9)
            java.lang.String r9 = "app_version"
            java.lang.String r2 = r8.zzaf()
            r1.put(r9, r2)
            java.lang.String r9 = "app_store"
            java.lang.String r2 = r8.zzae()
            r1.put(r9, r2)
            long r2 = r8.zzq()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "gmp_version"
            r1.put(r2, r9)
            long r2 = r8.zzn()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dev_cert_hash"
            r1.put(r2, r9)
            boolean r9 = r8.zzar()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "measurement_enabled"
            r1.put(r2, r9)
            long r2 = r8.zzm()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "day"
            r1.put(r2, r9)
            long r2 = r8.zzk()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_public_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzj()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzh()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_conversions_count"
            r1.put(r2, r9)
            long r2 = r8.zzg()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "config_fetched_time"
            r1.put(r2, r9)
            long r2 = r8.zzp()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "failed_config_fetch_time"
            r1.put(r2, r9)
            long r2 = r8.zze()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "app_version_int"
            r1.put(r2, r9)
            java.lang.String r9 = "firebase_instance_id"
            java.lang.String r2 = r8.zzag()
            r1.put(r9, r2)
            long r2 = r8.zzi()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_error_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzl()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_realtime_events_count"
            r1.put(r2, r9)
            java.lang.String r9 = "health_monitor_sample"
            java.lang.String r2 = r8.zzai()
            r1.put(r9, r2)
            long r2 = r8.zzd()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "android_id"
            r1.put(r2, r9)
            boolean r9 = r8.zzaq()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "adid_reporting_enabled"
            r1.put(r2, r9)
            java.lang.String r9 = "admob_app_id"
            java.lang.String r2 = r8.zzaa()
            r1.put(r9, r2)
            long r2 = r8.zzo()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dynamite_version"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzcy
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.zznv r9 = r7.zzg
            com.google.android.gms.measurement.internal.zzje r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzje$zza r2 = com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzje.zza) r2)
            if (r9 == 0) goto L_0x01be
        L_0x01b5:
            java.lang.String r9 = "session_stitching_token"
            java.lang.String r2 = r8.zzal()
            r1.put(r9, r2)
        L_0x01be:
            boolean r9 = r8.zzat()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "sgtm_upload_enabled"
            r1.put(r2, r9)
            long r2 = r8.zzw()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "target_os_version"
            r1.put(r2, r9)
            long r2 = r8.zzv()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "session_stitching_token_hash"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r9 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzch
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x0211
            int r9 = r8.zza()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "ad_services_version"
            r1.put(r2, r9)
            long r2 = r8.zzf()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "attribution_eligibility_status"
            r1.put(r2, r9)
        L_0x0211:
            boolean r9 = r8.zzau()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "unmatched_first_open_without_ad_id"
            r1.put(r2, r9)
            java.lang.String r9 = "npa_metadata_value"
            java.lang.Boolean r2 = r8.zzx()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.zzpu.zza()
            if (r9 == 0) goto L_0x024f
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzbx
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x024f
            r7.zzq()
            boolean r9 = com.google.android.gms.measurement.internal.zzos.zzf(r0)
            if (r9 == 0) goto L_0x024f
            long r2 = r8.zzr()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "bundle_delivery_index"
            r1.put(r2, r9)
        L_0x024f:
            boolean r9 = com.google.android.gms.internal.measurement.zzpu.zza()
            if (r9 == 0) goto L_0x026a
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzby
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x026a
            java.lang.String r9 = "sgtm_preview_key"
            java.lang.String r2 = r8.zzam()
            r1.put(r9, r2)
        L_0x026a:
            int r9 = r8.zzc()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "dma_consent_state"
            r1.put(r2, r9)
            int r9 = r8.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "daily_realtime_dcu_count"
            r1.put(r2, r9)
            java.lang.String r9 = "serialized_npa_metadata"
            java.lang.String r2 = r8.zzak()
            r1.put(r9, r2)
            java.util.List r9 = r8.zzan()
            java.lang.String r2 = "safelisted_events"
            if (r9 == 0) goto L_0x02b2
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x02a9
            com.google.android.gms.measurement.internal.zzgo r9 = r7.zzj()
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzu()
            java.lang.String r3 = "Safelisted events should not be an empty list. appId"
            r9.zza(r3, r0)
            goto L_0x02b2
        L_0x02a9:
            java.lang.String r3 = ","
            java.lang.String r9 = android.text.TextUtils.join(r3, r9)
            r1.put(r2, r9)
        L_0x02b2:
            boolean r9 = com.google.android.gms.internal.measurement.zzny.zza()
            if (r9 == 0) goto L_0x02cd
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzbu
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r9 == 0) goto L_0x02cd
            boolean r9 = r1.containsKey(r2)
            if (r9 != 0) goto L_0x02cd
            r1.put(r2, r4)
        L_0x02cd:
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzcw
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x02eb
            java.lang.String r9 = "unmatched_pfo"
            java.lang.Long r2 = r8.zzy()
            r1.put(r9, r2)
            java.lang.String r9 = "unmatched_uwa"
            java.lang.Long r2 = r8.zzz()
            r1.put(r9, r2)
        L_0x02eb:
            boolean r9 = com.google.android.gms.internal.measurement.zzov.zza()
            if (r9 == 0) goto L_0x0306
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzcu
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x0306
            java.lang.String r9 = "ad_campaign_info"
            byte[] r8 = r8.zzav()
            r1.put(r9, r8)
        L_0x0306:
            android.database.sqlite.SQLiteDatabase r8 = r7.e_()     // Catch:{ SQLiteException -> 0x033a }
            java.lang.String r9 = "app_id = ?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x033a }
            r3 = 0
            r2[r3] = r0     // Catch:{ SQLiteException -> 0x033a }
            int r9 = r8.update(r10, r1, r9, r2)     // Catch:{ SQLiteException -> 0x033a }
            long r2 = (long) r9     // Catch:{ SQLiteException -> 0x033a }
            r5 = 0
            int r9 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0339
            r9 = 5
            long r8 = r8.insertWithOnConflict(r10, r4, r1, r9)     // Catch:{ SQLiteException -> 0x033a }
            r1 = -1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0339
            com.google.android.gms.measurement.internal.zzgo r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x033a }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()     // Catch:{ SQLiteException -> 0x033a }
            java.lang.String r9 = "Failed to insert/update app (got -1). appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x033a }
            r8.zza(r9, r10)     // Catch:{ SQLiteException -> 0x033a }
        L_0x0339:
            return
        L_0x033a:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzgo r9 = r7.zzj()
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzg()
            java.lang.String r10 = "Error storing app. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)
            r9.zza(r10, r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(com.google.android.gms.measurement.internal.zzg, boolean, boolean):void");
    }

    public final void zza(String str, zzax zzax) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzax);
        zzt();
        zzal();
        if (zze().zza(zzbh.zzcr) && zzi(str) == zzje.zza) {
            zzb(str, zzje.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzax.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbb zzbb) {
        zza("events", zzbb);
    }

    private final void zza(String str, zzbb zzbb) {
        Preconditions.checkNotNull(zzbb);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbb.zza);
        contentValues.put("name", zzbb.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbb.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbb.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbb.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbb.zzg));
        contentValues.put("last_bundled_day", zzbb.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbb.zzi);
        contentValues.put("last_sampling_rate", zzbb.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbb.zze));
        contentValues.put("last_exempt_from_sampling", (zzbb.zzk == null || !zzbb.zzk.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgo.zza(zzbb.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgo.zza(zzbb.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase e_ = e_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzm().zza("Value of the primary key is not set.", zzgo.zza(str2));
                return;
            }
            if (((long) e_.update(str, contentValues, str2 + " = ?", new String[]{asString})) == 0 && e_.insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgo.zza(str), zzgo.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzgo.zza(str), zzgo.zza(str2), e);
        }
    }

    public final void zza(String str, zzje zzje) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzje);
        zzt();
        zzal();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzje.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzje zzje) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzje);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzje.zzf());
        contentValues.put("consent_source", Integer.valueOf(zzje.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzal();
        zzt();
        SQLiteDatabase e_ = e_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbh.zzah)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            if (e_.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(max)}) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzs(String str) {
        if (zzpu.zza() && !zze().zza(zzbh.zzcb)) {
            return false;
        }
        if (zzb("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT " + zzao(), new String[]{str}) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zza(zzfy.zzk zzk2, boolean z) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzk2);
        Preconditions.checkNotEmpty(zzk2.zzz());
        Preconditions.checkState(zzk2.zzbj());
        zzv();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzk2.zzm() < currentTimeMillis - zzag.zzm() || zzk2.zzm() > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgo.zza(zzk2.zzz()), Long.valueOf(currentTimeMillis), Long.valueOf(zzk2.zzm()));
        }
        try {
            byte[] zzb2 = g_().zzb(zzk2.zzca());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzk2.zzz());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzk2.zzm()));
            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzk2.zzbq()) {
                contentValues.put("retry_count", Integer.valueOf(zzk2.zzg()));
            }
            try {
                if (e_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgo.zza(zzk2.zzz()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzgo.zza(zzk2.zzz()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgo.zza(zzk2.zzz()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfo.zzb zzb2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (zzb2.zzf().isEmpty()) {
            zzgq zzu = zzj().zzu();
            Object zza2 = zzgo.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zzl()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzu.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzca = zzb2.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zzl() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzf());
        contentValues.put("session_scoped", zzb2.zzm() ? Boolean.valueOf(zzb2.zzj()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzca);
        try {
            if (e_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgo.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfo.zze zze2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (zze2.zze().isEmpty()) {
            zzgq zzu = zzj().zzu();
            Object zza2 = zzgo.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zzi()) {
                num = Integer.valueOf(zze2.zza());
            }
            zzu.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzca = zze2.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zzi() ? Integer.valueOf(zze2.zza()) : null);
        contentValues.put("property_name", zze2.zze());
        contentValues.put("session_scoped", zze2.zzj() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzca);
        try {
            if (e_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzbc zzbc, long j, boolean z) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbc);
        Preconditions.checkNotEmpty(zzbc.zza);
        byte[] zzca = g_().zza(zzbc).zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbc.zza);
        contentValues.put("name", zzbc.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbc.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzca);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgo.zza(zzbc.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzgo.zza(zzbc.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzno zzno) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzno);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzno.zzb < currentTimeMillis - zzbh.zzbh.zza(null).longValue() || zzno.zzb > zzbh.zzbh.zza(null).longValue() + currentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgo.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzno.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzno.zza);
        contentValues.put("source", Integer.valueOf(zzno.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzno.zzb));
        try {
            if (e_().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zza(String str, zzfy.zzj zzj2, String str2, Map<String, String> map, zznt zznt) {
        int delete;
        zzt();
        zzal();
        Preconditions.checkNotNull(zzj2);
        Preconditions.checkNotEmpty(str);
        if (zzpu.zza() && !zze().zza(zzbh.zzcb)) {
            return false;
        }
        zzt();
        zzal();
        if (zzaa()) {
            long zza2 = zzn().zzb.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzag.zzn()) {
                zzn().zzb.zza(elapsedRealtime);
                zzt();
                zzal();
                if (zzaa() && (delete = e_().delete("upload_queue", zzao(), new String[0])) > 0) {
                    zzj().zzp().zza("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(((String) next.getKey()) + "=" + ((String) next.getValue()));
        }
        byte[] zzca = zzj2.zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzca);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList.size();
        if (size > 0) {
            sb.append((CharSequence) arrayList.get(0));
            int i = 1;
            while (i < size) {
                sb.append("\r\n");
                Object obj = arrayList.get(i);
                i++;
                sb.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(zznt.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzb().currentTimeMillis()));
        contentValues.put("retry_count", 0);
        try {
            if (e_().insert("upload_queue", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing MeasurementBatch to upload_queue. appId", str, e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzaa() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzfy.zzf zzf2) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzf2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzca = zzf2.zzca();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzca.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzca);
        try {
            if (e_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgo.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r9.e_()     // Catch:{ SQLiteException -> 0x0050 }
            java.lang.String r4 = "select timestamp from raw_events where app_id=? and name = '_f' limit 1;"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0050 }
            r5[r1] = r10     // Catch:{ SQLiteException -> 0x0050 }
            android.database.Cursor r2 = r3.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x0050 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0050 }
            if (r3 != 0) goto L_0x001d
            if (r2 == 0) goto L_0x001c
            r2.close()
        L_0x001c:
            return r1
        L_0x001d:
            long r3 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x0050 }
            com.google.android.gms.common.util.Clock r5 = r9.zzb()     // Catch:{ SQLiteException -> 0x0050 }
            long r5 = r5.currentTimeMillis()     // Catch:{ SQLiteException -> 0x0050 }
            r7 = 15000(0x3a98, double:7.411E-320)
            long r3 = r3 + r7
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0032
            r3 = r0
            goto L_0x0033
        L_0x0032:
            r3 = r1
        L_0x0033:
            java.lang.String r4 = "select count(*) from raw_events where app_id=? and name not like '!_%' escape '!' limit 1;"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x004c }
            r5[r1] = r10     // Catch:{ SQLiteException -> 0x004c }
            r6 = 0
            long r4 = r9.zza((java.lang.String) r4, (java.lang.String[]) r5, (long) r6)     // Catch:{ SQLiteException -> 0x004c }
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0045
            r10 = r0
            goto L_0x0046
        L_0x0045:
            r10 = r1
        L_0x0046:
            if (r2 == 0) goto L_0x0065
            r2.close()
            goto L_0x0065
        L_0x004c:
            r10 = move-exception
            goto L_0x0052
        L_0x004e:
            r10 = move-exception
            goto L_0x006b
        L_0x0050:
            r10 = move-exception
            r3 = r1
        L_0x0052:
            com.google.android.gms.measurement.internal.zzgo r4 = r9.zzj()     // Catch:{ all -> 0x004e }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()     // Catch:{ all -> 0x004e }
            java.lang.String r5 = "Error checking backfill conditions"
            r4.zza(r5, r10)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0064
            r2.close()
        L_0x0064:
            r10 = r1
        L_0x0065:
            if (r3 == 0) goto L_0x006a
            if (r10 != 0) goto L_0x006a
            return r0
        L_0x006a:
            return r1
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.close()
        L_0x0070:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzt(java.lang.String):boolean");
    }

    public final boolean zza(zzae zzae) {
        Preconditions.checkNotNull(zzae);
        zzt();
        zzal();
        String str = zzae.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzae.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzae.zzb);
        contentValues.put("name", zzae.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzae.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzae.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzae.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzae.zzh));
        zzq();
        contentValues.put("timed_out_event", zzos.zza((Parcelable) zzae.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzae.zzd));
        zzq();
        contentValues.put("triggered_event", zzos.zza((Parcelable) zzae.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzae.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzae.zzj));
        zzq();
        contentValues.put("expired_event", zzos.zza((Parcelable) zzae.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgo.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzgo.zza(str), e);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, Bundle bundle) {
        zzt();
        zzal();
        String str2 = str;
        byte[] zzca = g_().zza(new zzbc(this.zzu, "", str2, "dep", 0, 0, bundle)).zzca();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str2), Integer.valueOf(zzca.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("parameters", zzca);
        try {
            if (e_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgo.zza(str2));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgo.zza(str2), e);
            return false;
        }
    }

    private final boolean zza(long j, zzbc zzbc, long j2, boolean z) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbc);
        Preconditions.checkNotEmpty(zzbc.zza);
        byte[] zzca = g_().zza(zzbc).zzca();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbc.zza);
        contentValues.put("name", zzbc.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbc.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzca);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            long update = (long) e_().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
            if (update == 1) {
                return true;
            }
            zzj().zzg().zza("Failed to update raw event. appId, updatedRows", zzgo.zza(zzbc.zza), Long.valueOf(update));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error updating raw event. appId", zzgo.zza(zzbc.zza), e);
            return false;
        }
    }

    public final boolean zza(zzop zzop) {
        Preconditions.checkNotNull(zzop);
        zzt();
        zzal();
        if (zze(zzop.zza, zzop.zzc) == null) {
            if (zzos.zzh(zzop.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzop.zza}) >= ((long) zze().zza(zzop.zza, zzbh.zzai, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzop.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzop.zza, zzop.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzop.zza);
        contentValues.put("origin", zzop.zzb);
        contentValues.put("name", zzop.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzop.zzd));
        zza(contentValues, "value", zzop.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgo.zza(zzop.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzgo.zza(zzop.zza), e);
        }
        return true;
    }
}
