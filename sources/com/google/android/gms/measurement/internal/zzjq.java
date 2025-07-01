package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import coil3.disk.DiskLruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzdo;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzje;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzjq extends zzh {
    final zzu zza;
    private zzkz zzb;
    private zzjm zzc;
    private final Set<zzjl> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();
    private final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh = false;
    /* access modifiers changed from: private */
    public int zzi = 1;
    private zzav zzj;
    private PriorityQueue<zzno> zzk;
    private boolean zzl;
    private zzje zzm = zzje.zza;
    private final AtomicLong zzn = new AtomicLong(0);
    private long zzo = -1;
    private boolean zzp = true;
    /* access modifiers changed from: private */
    public zzav zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzav zzs;
    private final zzor zzt = new zzkr(this);

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final Application.ActivityLifecycleCallbacks zzaa() {
        return this.zzb;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
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

    public final zzaj zzab() {
        zzt();
        return zzo().zzaa();
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

    static /* synthetic */ int zza(zzjq zzjq, Throwable th) {
        String message = th.getMessage();
        zzjq.zzl = false;
        if (message == null) {
            return 2;
        }
        if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            if (message.contains("Background")) {
                zzjq.zzl = true;
            }
            return 1;
        } else if (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) {
            return 2;
        } else {
            return 3;
        }
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

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000, "boolean test flag value", new zzka(this, atomicReference));
    }

    public final Double zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000, "double test flag value", new zzkw(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000, "int test flag value", new zzkt(this, atomicReference));
    }

    public final Long zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000, "long test flag value", new zzku(this, atomicReference));
    }

    public final String zzag() {
        return this.zzf.get();
    }

    public final String zzah() {
        zzlk zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    public final String zzai() {
        zzlk zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    public final String zzaj() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhs(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzak() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000, "String test flag value", new zzkj(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzab.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zzhv zzl2 = this.zzu.zzl();
            AtomicReference atomicReference2 = atomicReference;
            zzkq zzkq = new zzkq(this, atomicReference2, (String) null, str, str2);
            AtomicReference atomicReference3 = atomicReference2;
            zzl2.zza(atomicReference3, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get conditional user properties", zzkq);
            List list = (List) atomicReference3.get();
            if (list != null) {
                return zzos.zzb((List<zzae>) list);
            }
            zzj().zzg().zza("Timed out waiting for get conditional user properties", (Object) null);
            return new ArrayList<>();
        }
    }

    public final List<zzon> zza(boolean z) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzab.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", new zzkk(this, atomicReference, z));
            List<zzon> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzab.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zzhv zzl2 = this.zzu.zzl();
            boolean z2 = z;
            AtomicReference atomicReference2 = atomicReference;
            zzkp zzkp = new zzkp(this, atomicReference2, (String) null, str, str2, z2);
            AtomicReference atomicReference3 = atomicReference2;
            zzl2.zza(atomicReference3, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", zzkp);
            List<zzon> list = (List) atomicReference3.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z2));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzon zzon : list) {
                Object zza2 = zzon.zza();
                if (zza2 != null) {
                    arrayMap.put(zzon.zza, zza2);
                }
            }
            return arrayMap;
        }
    }

    /* access modifiers changed from: package-private */
    public final PriorityQueue<zzno> zzal() {
        if (this.zzk == null) {
            this.zzk = new PriorityQueue<>(Comparator.comparing(new zzjp(), new zzjs()));
        }
        return this.zzk;
    }

    static /* synthetic */ void zza(zzjq zzjq, Bundle bundle) {
        Bundle bundle2 = bundle;
        zzjq.zzt();
        zzjq.zzu();
        Preconditions.checkNotNull(bundle2);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle2.getString("name"));
        zzjq zzjq2 = zzjq;
        if (!zzjq2.zzu.zzac()) {
            zzjq2.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzon zzon = new zzon(checkNotEmpty, 0, (Object) null, "");
        try {
            zzbf zza2 = zzjq2.zzq().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true);
            zzjq2.zzo().zza(new zzae(bundle2.getString("app_id"), "", zzon, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzbf) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzbf) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zzjq zzjq, zzje zzje, zzje zzje2) {
        if (!zznm.zza() || !zzjq.zze().zza(zzbh.zzcx)) {
            boolean zza2 = zzje.zza(zzje2, zzje.zza.ANALYTICS_STORAGE, zzje.zza.AD_STORAGE);
            boolean zzb2 = zzje.zzb(zzje2, zzje.zza.ANALYTICS_STORAGE, zzje.zza.AD_STORAGE);
            if (zza2 || zzb2) {
                zzjq.zzg().zzag();
            }
        }
    }

    static /* synthetic */ void zzb(zzjq zzjq, Bundle bundle) {
        Bundle bundle2 = bundle;
        zzjq.zzt();
        zzjq.zzu();
        Preconditions.checkNotNull(bundle2);
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle2.get("value"));
        zzjq zzjq2 = zzjq;
        if (!zzjq2.zzu.zzac()) {
            zzjq2.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzon zzon = new zzon(string, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), string2);
        try {
            zzbf zza2 = zzjq2.zzq().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0, true, true);
            zzbf zza3 = zzjq2.zzq().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0, true, true);
            zzbf zza4 = zzjq2.zzq().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0, true, true);
            String string3 = bundle2.getString("app_id");
            long j = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
            long j2 = j;
            String str = string2;
            long j3 = j2;
            zzbf zzbf = zza3;
            zzon zzon2 = zzon;
            zzjq.zzo().zza(new zzae(string3, str, zzon2, j3, false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzbf, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza4));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zzjq zzjq, zzje zzje, long j, boolean z, boolean z2) {
        zzjq.zzt();
        zzjq.zzu();
        zzje zzo2 = zzjq.zzk().zzo();
        if (j <= zzjq.zzo && zzje.zza(zzo2.zza(), zzje.zza())) {
            zzjq.zzj().zzo().zza("Dropped out-of-date consent setting, proposed settings", zzje);
        } else if (zzjq.zzk().zza(zzje)) {
            zzjq.zzj().zzp().zza("Setting storage consent(FE)", zzje);
            zzjq.zzo = j;
            if (zzjq.zzo().zzao()) {
                zzjq.zzo().zzb(z);
            } else {
                zzjq.zzo().zza(z);
            }
            if (z2) {
                zzjq.zzo().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zzjq.zzj().zzo().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzje.zza()));
        }
    }

    static /* synthetic */ void zzb(zzjq zzjq, int i) {
        if (zzjq.zzj == null) {
            zzjq.zzj = new zzkb(zzjq, zzjq.zzu);
        }
        zzjq.zzj.zza((long) (i * 1000));
    }

    protected zzjq(zzhy zzhy) {
        super(zzhy);
        this.zza = new zzu(zzhy);
    }

    public final void zzam() {
        zzt();
        zzu();
        if (zze().zza(zzbh.zzdd)) {
            zzls zzo2 = zzo();
            zzo2.zzt();
            zzo2.zzu();
            if (!zzo2.zzap() || zzo2.zzq().zzg() >= 242600) {
                zzo().zzac();
            }
        }
    }

    public final void zzan() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean zze2 = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (zze2 != null && zze2.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb((Runnable) new zzjv(this));
            }
            zzo().zzad();
            this.zzp = false;
            String zzw = zzk().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzf().zzac();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
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

    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb((Runnable) new zzkn(this, bundle2));
    }

    public final void zzao() {
        if ((zza().getApplicationContext() instanceof Application) && this.zzb != null) {
            ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzap() {
        if (zzpn.zza() && zze().zza(zzbh.zzci)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
            } else if (zzab.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
            } else {
                zzu();
                zzj().zzp().zza("Getting trigger URIs (FE)");
                AtomicReference atomicReference = new AtomicReference();
                zzl().zza(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get trigger URIs", new zzjr(this, atomicReference));
                List list = (List) atomicReference.get();
                if (list == null) {
                    zzj().zzg().zza("Timed out waiting for get trigger URIs");
                } else {
                    zzl().zzb((Runnable) new zzju(this, list));
                }
            }
        }
    }

    public final void zzaq() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza2);
        if (zza2 >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
            return;
        }
        if (this.zzq == null) {
            this.zzq = new zzkm(this, this.zzu);
        }
        this.zzq.zza(0);
    }

    public final void zza(zzdo zzdo) throws RemoteException {
        zzl().zzb((Runnable) new zzks(this, zzdo));
    }

    public final void zzar() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zznm zza2 = zznm.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zza2);
        if (zzk().zza(zza2)) {
            Bundle zza3 = zza2.zza();
            zzj().zzp().zza("Consent generated from Tcf", zza3);
            if (zza3 != Bundle.EMPTY) {
                zza(zza3, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zza2.zzb());
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(AtomicReference atomicReference) {
        Bundle zza2 = zzk().zzi.zza();
        zzls zzo2 = zzo();
        if (zza2 == null) {
            zza2 = new Bundle();
        }
        zzo2.zza((AtomicReference<List<zzno>>) atomicReference, zza2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(List list) {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzm2 = zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzno zzno = (zzno) it.next();
                if (!zzm2.contains(zzno.zzc) || zzm2.get(zzno.zzc).longValue() < zzno.zzb) {
                    zzal().add(zzno);
                }
            }
            zzas();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzav) Preconditions.checkNotNull(this.zzs)).zza(500);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle, long j) {
        if (TextUtils.isEmpty(zzg().zzae())) {
            zza(bundle, 0, j);
        } else {
            zzj().zzv().zza("Using developer consent only; google app id found");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = zzk().zzt.zza();
            if (zze().zza(zzbh.zzdh)) {
                bundle2 = new Bundle(bundle2);
            }
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzq();
                    if (zzos.zza(obj)) {
                        zzq();
                        zzos.zza(this.zzt, 27, (String) null, (String) null, 0);
                    }
                    zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzos.zzg(str)) {
                    zzj().zzv().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                    zzq().zza(bundle2, str, obj);
                }
            }
            zzq();
            if (zzos.zza(bundle2, zze().zzc())) {
                zzq();
                zzos.zza(this.zzt, 26, (String) null, (String) null, 0);
                zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzk().zzt.zza(bundle2);
        if (!bundle.isEmpty() || zze().zza(zzbh.zzdf)) {
            zzo().zza(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str) {
        if (zzg().zzb(str)) {
            zzg().zzag();
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzn().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzos.zzg(str2), z, (String) null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, j);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zzos.zzg(str2), true, (String) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r18, java.lang.String r19, long r20, android.os.Bundle r22, boolean r23, boolean r24, boolean r25, java.lang.String r26) {
        /*
            r17 = this;
            r1 = r17
            r7 = r18
            r8 = r19
            r9 = r22
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            r1.zzt()
            r1.zzu()
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzu
            boolean r0 = r0.zzac()
            if (r0 != 0) goto L_0x002a
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            java.lang.String r2 = "Event not sent since app measurement is disabled"
            r0.zza(r2)
            return
        L_0x002a:
            com.google.android.gms.measurement.internal.zzgg r0 = r1.zzg()
            java.util.List r0 = r0.zzaf()
            if (r0 == 0) goto L_0x0048
            boolean r0 = r0.contains(r8)
            if (r0 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            java.lang.String r2 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r2, r8, r7)
            return
        L_0x0048:
            boolean r0 = r1.zze
            r10 = 0
            r11 = 0
            r12 = 1
            if (r0 != 0) goto L_0x00a0
            r1.zze = r12
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzu     // Catch:{ ClassNotFoundException -> 0x0093 }
            boolean r0 = r0.zzag()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.String r2 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0068
            android.content.Context r0 = r1.zza()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.Class r0 = java.lang.Class.forName(r2, r12, r0)     // Catch:{ ClassNotFoundException -> 0x0093 }
            goto L_0x006c
        L_0x0068:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0093 }
        L_0x006c:
            java.lang.String r2 = "initialize"
            java.lang.Class[] r3 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x0084 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r11] = r4     // Catch:{ Exception -> 0x0084 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r3)     // Catch:{ Exception -> 0x0084 }
            android.content.Context r2 = r1.zza()     // Catch:{ Exception -> 0x0084 }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ Exception -> 0x0084 }
            r0.invoke(r10, r2)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00a0
        L_0x0084:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ ClassNotFoundException -> 0x0093 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.String r3 = "Failed to invoke Tag Manager's initialize() method"
            r2.zza(r3, r0)     // Catch:{ ClassNotFoundException -> 0x0093 }
            goto L_0x00a0
        L_0x0093:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzo()
            java.lang.String r2 = "Tag Manager is not found and thus will not be used"
            r0.zza(r2)
        L_0x00a0:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = "gclid"
            boolean r2 = r9.containsKey(r0)
            if (r2 == 0) goto L_0x00c3
            java.lang.String r4 = r9.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r1.zzb()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00c3:
            r6 = r1
            if (r23 == 0) goto L_0x00dd
            boolean r0 = com.google.android.gms.measurement.internal.zzos.zzj(r8)
            if (r0 == 0) goto L_0x00dd
            com.google.android.gms.measurement.internal.zzos r0 = r6.zzq()
            com.google.android.gms.measurement.internal.zzha r1 = r6.zzk()
            com.google.android.gms.measurement.internal.zzhc r1 = r1.zzt
            android.os.Bundle r1 = r1.zza()
            r0.zza((android.os.Bundle) r9, (android.os.Bundle) r1)
        L_0x00dd:
            r0 = 40
            r1 = 2
            if (r25 != 0) goto L_0x0142
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzhy r2 = r6.zzu
            com.google.android.gms.measurement.internal.zzos r2 = r2.zzt()
            java.lang.String r3 = "event"
            boolean r4 = r2.zzc((java.lang.String) r3, (java.lang.String) r8)
            if (r4 != 0) goto L_0x00fa
        L_0x00f8:
            r2 = r1
            goto L_0x010f
        L_0x00fa:
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzji.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzji.zzb
            boolean r4 = r2.zza((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String[]) r5, (java.lang.String) r8)
            if (r4 != 0) goto L_0x0107
            r2 = 13
            goto L_0x010f
        L_0x0107:
            boolean r2 = r2.zza((java.lang.String) r3, (int) r0, (java.lang.String) r8)
            if (r2 != 0) goto L_0x010e
            goto L_0x00f8
        L_0x010e:
            r2 = r11
        L_0x010f:
            if (r2 == 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzgh r3 = r6.zzi()
            java.lang.String r3 = r3.zza((java.lang.String) r8)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r4, r3)
            com.google.android.gms.measurement.internal.zzhy r1 = r6.zzu
            r1.zzt()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzos.zza((java.lang.String) r8, (int) r0, (boolean) r12)
            if (r8 == 0) goto L_0x0135
            int r11 = r8.length()
        L_0x0135:
            com.google.android.gms.measurement.internal.zzhy r1 = r6.zzu
            r1.zzt()
            com.google.android.gms.measurement.internal.zzor r1 = r6.zzt
            java.lang.String r3 = "_ev"
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r1, (int) r2, (java.lang.String) r3, (java.lang.String) r0, (int) r11)
            return
        L_0x0142:
            com.google.android.gms.measurement.internal.zzlj r2 = r6.zzn()
            com.google.android.gms.measurement.internal.zzlk r2 = r2.zza((boolean) r11)
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x0156
            boolean r4 = r9.containsKey(r3)
            if (r4 != 0) goto L_0x0156
            r2.zzd = r12
        L_0x0156:
            if (r23 == 0) goto L_0x015c
            if (r25 != 0) goto L_0x015c
            r4 = r12
            goto L_0x015d
        L_0x015c:
            r4 = r11
        L_0x015d:
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzlk) r2, (android.os.Bundle) r9, (boolean) r4)
            java.lang.String r2 = "am"
            boolean r13 = r2.equals(r7)
            boolean r2 = com.google.android.gms.measurement.internal.zzos.zzg(r8)
            if (r23 == 0) goto L_0x01a1
            com.google.android.gms.measurement.internal.zzjm r4 = r6.zzc
            if (r4 == 0) goto L_0x01a1
            if (r2 != 0) goto L_0x01a1
            if (r13 != 0) goto L_0x01a1
            com.google.android.gms.measurement.internal.zzgo r0 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzgh r1 = r6.zzi()
            java.lang.String r1 = r1.zza((java.lang.String) r8)
            com.google.android.gms.measurement.internal.zzgh r2 = r6.zzi()
            java.lang.String r2 = r2.zza((android.os.Bundle) r9)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzjm r0 = r6.zzc
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzjm r0 = r6.zzc
            r4 = r20
            r1 = r7
            r2 = r8
            r3 = r9
            r0.interceptEvent(r1, r2, r3, r4)
            return
        L_0x01a1:
            r2 = r8
            r8 = r20
            com.google.android.gms.measurement.internal.zzhy r4 = r6.zzu
            boolean r4 = r4.zzaf()
            if (r4 != 0) goto L_0x01ae
            goto L_0x0439
        L_0x01ae:
            com.google.android.gms.measurement.internal.zzos r4 = r6.zzq()
            int r4 = r4.zza((java.lang.String) r2)
            if (r4 == 0) goto L_0x01f3
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzgh r3 = r6.zzi()
            java.lang.String r3 = r3.zza((java.lang.String) r2)
            java.lang.String r5 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r5, r3)
            r6.zzq()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzos.zza((java.lang.String) r2, (int) r0, (boolean) r12)
            if (r2 == 0) goto L_0x01da
            int r11 = r2.length()
        L_0x01da:
            com.google.android.gms.measurement.internal.zzhy r1 = r6.zzu
            r1.zzt()
            com.google.android.gms.measurement.internal.zzor r1 = r6.zzt
            java.lang.String r2 = "_ev"
            r19 = r26
            r22 = r0
            r18 = r1
            r21 = r2
            r20 = r4
            r23 = r11
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r18, (java.lang.String) r19, (int) r20, (java.lang.String) r21, (java.lang.String) r22, (int) r23)
            return
        L_0x01f3:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r14 = "_o"
            r0[r11] = r14
            java.lang.String r4 = "_sn"
            r0[r12] = r4
            r0[r1] = r3
            r1 = 3
            java.lang.String r3 = "_si"
            r0[r1] = r3
            java.util.List r4 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzos r0 = r6.zzq()
            r3 = r22
            r5 = r25
            r1 = r26
            android.os.Bundle r0 = r0.zza((java.lang.String) r1, (java.lang.String) r2, (android.os.Bundle) r3, (java.util.List<java.lang.String>) r4, (boolean) r5)
            r15 = r2
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzlj r1 = r6.zzn()
            com.google.android.gms.measurement.internal.zzlk r1 = r1.zza((boolean) r11)
            java.lang.String r2 = "_ae"
            if (r1 == 0) goto L_0x0251
            boolean r1 = r2.equals(r15)
            if (r1 == 0) goto L_0x0251
            com.google.android.gms.measurement.internal.zznb r1 = r6.zzp()
            com.google.android.gms.measurement.internal.zznh r1 = r1.zzb
            com.google.android.gms.measurement.internal.zznb r5 = r1.zzb
            com.google.android.gms.common.util.Clock r5 = r5.zzb()
            r22 = 0
            long r3 = r5.elapsedRealtime()
            long r10 = r1.zza
            long r10 = r3 - r10
            r1.zza = r3
            int r1 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x0253
            com.google.android.gms.measurement.internal.zzos r1 = r6.zzq()
            r1.zza((android.os.Bundle) r0, (long) r10)
            goto L_0x0253
        L_0x0251:
            r22 = 0
        L_0x0253:
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r7)
            java.lang.String r3 = "_ffr"
            if (r1 != 0) goto L_0x02a4
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x02a4
            com.google.android.gms.measurement.internal.zzos r1 = r6.zzq()
            java.lang.String r3 = r0.getString(r3)
            boolean r4 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r3)
            if (r4 == 0) goto L_0x0275
            r3 = 0
            goto L_0x027b
        L_0x0275:
            if (r3 == 0) goto L_0x027b
            java.lang.String r3 = r3.trim()
        L_0x027b:
            com.google.android.gms.measurement.internal.zzha r4 = r1.zzk()
            com.google.android.gms.measurement.internal.zzhd r4 = r4.zzq
            java.lang.String r4 = r4.zza()
            boolean r4 = java.util.Objects.equals(r3, r4)
            if (r4 == 0) goto L_0x029a
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            goto L_0x0439
        L_0x029a:
            com.google.android.gms.measurement.internal.zzha r1 = r1.zzk()
            com.google.android.gms.measurement.internal.zzhd r1 = r1.zzq
            r1.zza(r3)
            goto L_0x02c1
        L_0x02a4:
            boolean r1 = r2.equals(r15)
            if (r1 == 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzos r1 = r6.zzq()
            com.google.android.gms.measurement.internal.zzha r1 = r1.zzk()
            com.google.android.gms.measurement.internal.zzhd r1 = r1.zzq
            java.lang.String r1 = r1.zza()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x02c1
            r0.putString(r3, r1)
        L_0x02c1:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r10.add(r0)
            com.google.android.gms.measurement.internal.zzag r1 = r6.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzco
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x02de
            com.google.android.gms.measurement.internal.zznb r1 = r6.zzp()
            boolean r1 = r1.zzaa()
            goto L_0x02e8
        L_0x02de:
            com.google.android.gms.measurement.internal.zzha r1 = r6.zzk()
            com.google.android.gms.measurement.internal.zzgz r1 = r1.zzn
            boolean r1 = r1.zza()
        L_0x02e8:
            com.google.android.gms.measurement.internal.zzha r3 = r6.zzk()
            com.google.android.gms.measurement.internal.zzhb r3 = r3.zzk
            long r3 = r3.zza()
            int r3 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r3 <= 0) goto L_0x0355
            com.google.android.gms.measurement.internal.zzha r3 = r6.zzk()
            boolean r3 = r3.zza((long) r8)
            if (r3 == 0) goto L_0x0355
            if (r1 == 0) goto L_0x0355
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzp()
            java.lang.String r3 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r3)
            com.google.android.gms.common.util.Clock r1 = r6.zzb()
            long r3 = r1.currentTimeMillis()
            r1 = r2
            java.lang.String r2 = "auto"
            r5 = r3
            java.lang.String r3 = "_sid"
            r4 = 0
            r11 = r1
            r16 = r13
            r1 = r17
            r12 = r22
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            com.google.android.gms.common.util.Clock r1 = r17.zzb()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r17
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            com.google.android.gms.common.util.Clock r1 = r17.zzb()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r17
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            r6 = r1
            com.google.android.gms.measurement.internal.zzha r1 = r6.zzk()
            com.google.android.gms.measurement.internal.zzhb r1 = r1.zzl
            r1.zza(r12)
            goto L_0x035a
        L_0x0355:
            r11 = r2
            r16 = r13
            r12 = r22
        L_0x035a:
            java.lang.String r1 = "extend_session"
            long r1 = r0.getLong(r1, r12)
            r3 = 1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x037f
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzp()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzhy r1 = r6.zzu
            com.google.android.gms.measurement.internal.zznb r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zznj r1 = r1.zza
            r2 = 1
            r1.zza(r8, r2)
        L_0x037f:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            r2 = r1
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r2 = r1.size()
            r3 = 0
        L_0x0393:
            if (r3 >= r2) goto L_0x03b0
            java.lang.Object r4 = r1.get(r3)
            int r3 = r3 + 1
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0393
            r6.zzq()
            java.lang.Object r5 = r0.get(r4)
            android.os.Bundle[] r5 = com.google.android.gms.measurement.internal.zzos.zzb((java.lang.Object) r5)
            if (r5 == 0) goto L_0x0393
            r0.putParcelableArray(r4, r5)
            goto L_0x0393
        L_0x03b0:
            r12 = 0
        L_0x03b1:
            int r0 = r10.size()
            if (r12 >= r0) goto L_0x0417
            java.lang.Object r0 = r10.get(r12)
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r12 == 0) goto L_0x03c2
            java.lang.String r1 = "_ep"
            goto L_0x03c3
        L_0x03c2:
            r1 = r15
        L_0x03c3:
            r0.putString(r14, r7)
            if (r24 == 0) goto L_0x03d2
            com.google.android.gms.measurement.internal.zzos r2 = r6.zzq()
            r13 = 0
            android.os.Bundle r0 = r2.zza((android.os.Bundle) r0, (java.lang.String) r13)
            goto L_0x03d3
        L_0x03d2:
            r13 = 0
        L_0x03d3:
            com.google.android.gms.measurement.internal.zzbf r2 = new com.google.android.gms.measurement.internal.zzbf
            r3 = r2
            com.google.android.gms.measurement.internal.zzbe r2 = new com.google.android.gms.measurement.internal.zzbe
            r2.<init>(r0)
            r4 = r7
            r7 = r0
            r0 = r3
            r3 = r4
            r4 = r8
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.measurement.internal.zzls r1 = r6.zzo()
            r8 = r26
            r1.zza((com.google.android.gms.measurement.internal.zzbf) r0, (java.lang.String) r8)
            if (r16 != 0) goto L_0x040e
            java.util.Set<com.google.android.gms.measurement.internal.zzjl> r0 = r6.zzd
            java.util.Iterator r9 = r0.iterator()
        L_0x03f4:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x040e
            java.lang.Object r0 = r9.next()
            com.google.android.gms.measurement.internal.zzjl r0 = (com.google.android.gms.measurement.internal.zzjl) r0
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>(r7)
            r1 = r18
            r4 = r20
            r2 = r15
            r0.onEvent(r1, r2, r3, r4)
            goto L_0x03f4
        L_0x040e:
            r2 = r15
            int r12 = r12 + 1
            r7 = r18
            r8 = r20
            r15 = r2
            goto L_0x03b1
        L_0x0417:
            r2 = r15
            com.google.android.gms.measurement.internal.zzlj r0 = r6.zzn()
            r1 = 0
            com.google.android.gms.measurement.internal.zzlk r0 = r0.zza((boolean) r1)
            if (r0 == 0) goto L_0x0439
            boolean r0 = r11.equals(r2)
            if (r0 == 0) goto L_0x0439
            com.google.android.gms.measurement.internal.zznb r0 = r6.zzp()
            com.google.android.gms.common.util.Clock r1 = r6.zzb()
            long r1 = r1.elapsedRealtime()
            r3 = 1
            r0.zza(r3, r3, r1)
        L_0x0439:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjq.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzas() {
        zzno poll;
        MeasurementManagerFutures zzo2;
        zzt();
        this.zzl = false;
        if (!zzal().isEmpty() && !this.zzh && (poll = zzal().poll()) != null && (zzo2 = zzq().zzo()) != null) {
            this.zzh = true;
            zzj().zzp().zza("Registering trigger URI", poll.zza);
            ListenableFuture<Unit> registerTriggerAsync = zzo2.registerTriggerAsync(Uri.parse(poll.zza));
            if (registerTriggerAsync == null) {
                this.zzh = false;
                zzal().add(poll);
                return;
            }
            if (!zze().zza(zzbh.zzcn)) {
                SparseArray<Long> zzm2 = zzk().zzm();
                zzm2.put(poll.zzc, Long.valueOf(poll.zzb));
                zzk().zza(zzm2);
            }
            Futures.addCallback(registerTriggerAsync, new zzkc(this, poll), new zzjz(this));
        }
    }

    public final void zza(zzjl zzjl) {
        zzu();
        Preconditions.checkNotNull(zzjl);
        if (!this.zzd.add(zzjl)) {
            zzj().zzu().zza("OnEventListener already registered");
        }
    }

    public final void zzat() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkf(this, this.zzu);
            this.zzr = new zzjy(this);
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    public final void zza(long j) {
        zzc((String) null);
        zzl().zzb((Runnable) new zzkl(this, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        zza(j, true);
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznb zzp2 = zzp();
        zzp2.zzt();
        zzp2.zzb.zza();
        zzg().zzag();
        boolean zzac = this.zzu.zzac();
        zzha zzk2 = zzk();
        zzk2.zzc.zza(j);
        if (!TextUtils.isEmpty(zzk2.zzk().zzq.zza())) {
            zzk2.zzq.zza((String) null);
        }
        zzk2.zzk.zza(0);
        zzk2.zzl.zza(0);
        if (!zzk2.zze().zzx()) {
            zzk2.zzb(!zzac);
        }
        zzk2.zzr.zza((String) null);
        zzk2.zzs.zza(0);
        zzk2.zzt.zza((Bundle) null);
        if (z) {
            zzo().zzai();
        }
        zzp().zza.zza();
        this.zzp = !zzac;
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzl().zzb((Runnable) new zzki(this, str, str2, j, zzos.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzl().zzb((Runnable) new zzkh(this, str, str2, obj, j));
    }

    public final void zzb(boolean z) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzkz(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzp().zza("Registered activity lifecycle callback");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        this.zzf.set(str);
    }

    public final void zzb(Bundle bundle) {
        zzb(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjf.zza(bundle2, "app_id", String.class, null);
        zzjf.zza(bundle2, "origin", String.class, null);
        zzjf.zza(bundle2, "name", String.class, null);
        zzjf.zza(bundle2, "value", Object.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
        } else if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
        } else {
            Object zzc2 = zzq().zzc(string, obj);
            if (zzc2 == null) {
                zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
                return;
            }
            zzjf.zza(bundle2, zzc2);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
                } else {
                    zzl().zzb((Runnable) new zzko(this, bundle2));
                }
            } else {
                zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(Bundle bundle, long j) {
        zzl().zzc((Runnable) new zzjw(this, bundle, j));
    }

    private final void zza(Bundle bundle, int i, long j) {
        String str;
        zzu();
        String zza2 = zzje.zza(bundle);
        if (zza2 != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", zza2);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzg2 = zzl().zzg();
        zzje zza3 = zzje.zza(bundle, i);
        if (zza3.zzi()) {
            zza(zza3, j, zzg2);
        }
        zzax zza4 = zzax.zza(bundle, i);
        if (zza4.zzg()) {
            zza(zza4, zzg2);
        }
        Boolean zza5 = zzax.zza(bundle);
        if (zza5 != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            String str2 = str;
            if (!zze().zza(zzbh.zzcs) || !zzg2) {
                zza(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) zza5.toString(), false, j);
                return;
            }
            zza(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) zza5.toString(), j);
        }
    }

    public final void zzd(Bundle bundle, long j) {
        zza(bundle, -20, j);
    }

    public final void zzc(boolean z) {
        zzu();
        zzl().zzb((Runnable) new zzke(this, z));
    }

    public final void zzc(Bundle bundle) {
        zzl().zzb((Runnable) new zzjt(this, bundle == null ? new Bundle() : new Bundle(bundle)));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzax zzax, boolean z) {
        zzky zzky = new zzky(this, zzax);
        if (z) {
            zzt();
            zzky.run();
            return;
        }
        zzl().zzb((Runnable) zzky);
    }

    public final void zza(zzjm zzjm) {
        zzjm zzjm2;
        zzt();
        zzu();
        if (!(zzjm == null || zzjm == (zzjm2 = this.zzc))) {
            Preconditions.checkState(zzjm2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjm;
    }

    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb((Runnable) new zzkv(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzje zzje) {
        zzt();
        boolean z = (zzje.zzh() && zzje.zzg()) || zzo().zzan();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean zzu = zzk().zzu();
            if (!z || zzu == null || zzu.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || (bool != null && !bool.booleanValue())) {
            zzav();
        }
    }

    public final void zzc(long j) {
        zzl().zzb((Runnable) new zzkg(this, j));
    }

    public final void zza(Intent intent) {
        if (zzpu.zza() && zze().zza(zzbh.zzby)) {
            Uri data = intent.getData();
            if (data == null) {
                zzj().zzo().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals(DiskLruCache.VERSION)) {
                zzj().zzo().zza("Preview Mode was not enabled.");
                zze().zzh((String) null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (!TextUtils.isEmpty(queryParameter2)) {
                zzj().zzo().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
                zze().zzh(queryParameter2);
            }
        }
    }

    public final void zza(zzje zzje, long j, boolean z) {
        zzje zzje2;
        boolean z2;
        boolean z3;
        boolean z4;
        zzje zzje3;
        zzu();
        int zza2 = zzje.zza();
        if (zza2 != -10 && zzje.zzc() == zzjh.UNINITIALIZED && zzje.zzd() == zzjh.UNINITIALIZED) {
            zzj().zzv().zza("Ignoring empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zzje2 = this.zzm;
            z2 = false;
            if (zzje.zza(zza2, zzje2.zza())) {
                z4 = zzje.zzc(this.zzm);
                if (zzje.zzh() && !this.zzm.zzh()) {
                    z2 = true;
                }
                zzje3 = zzje.zzb(this.zzm);
                this.zzm = zzje3;
                z3 = z2;
                z2 = true;
            } else {
                zzje3 = zzje;
                z4 = false;
                z3 = false;
            }
        }
        if (!z2) {
            zzj().zzo().zza("Ignoring lower-priority consent settings, proposed settings", zzje3);
            return;
        }
        long andIncrement = this.zzn.getAndIncrement();
        if (z4) {
            zzc((String) null);
            zzkx zzkx = new zzkx(this, zzje3, j, andIncrement, z3, zzje2);
            if (z) {
                zzt();
                zzkx.run();
                return;
            }
            zzl().zzc((Runnable) zzkx);
            return;
        }
        zzla zzla = new zzla(this, zzje3, andIncrement, z3, zzje2);
        if (z) {
            zzt();
            zzla.run();
        } else if (zza2 == 30 || zza2 == -10) {
            zzl().zzc((Runnable) zzla);
        } else {
            zzl().zzb((Runnable) zzla);
        }
    }

    public final void zza(String str, long j) {
        if (str == null || !TextUtils.isEmpty(str)) {
            zzl().zzb((Runnable) new zzjx(this, str));
            zza((String) null, "_id", (Object) str, true, j);
            return;
        }
        this.zzu.zzj().zzu().zza("User ID must be non-empty or null");
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 0;
        if (z) {
            i = zzq().zzb(str2);
        } else {
            zzos zzq2 = zzq();
            if (zzq2.zzc("user property", str2)) {
                if (!zzq2.zza("user property", zzjj.zza, str2)) {
                    i = 15;
                } else if (zzq2.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzq();
            String zza2 = zzos.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzu.zzt();
            zzos.zza(this.zzt, i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zza3 = zzq().zza(str2, obj);
            if (zza3 != 0) {
                zzq();
                String zza4 = zzos.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzu.zzt();
                zzos.zza(this.zzt, zza3, "_ev", zza4, i2);
                return;
            }
            Object zzc2 = zzq().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzu();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "false";
                    Long valueOf = Long.valueOf(str4.equals(str3.toLowerCase(Locale.ENGLISH)) ? 1 : 0);
                    zzhd zzhd = zzk().zzh;
                    Long l = valueOf;
                    if (valueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    zzhd.zza(str4);
                    obj = valueOf;
                    str2 = "_npa";
                    zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                zzk().zzh.zza("unset");
                str2 = "_npa";
            }
            zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str5 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzac()) {
            zzj().zzp().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzaf()) {
            zzo().zza(new zzon(str5, j, obj2, str));
        }
    }

    public final void zzb(zzjl zzjl) {
        zzu();
        Preconditions.checkNotNull(zzjl);
        if (!this.zzd.remove(zzjl)) {
            zzj().zzu().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: private */
    public final void zzav() {
        zzjq zzjq;
        zzt();
        String zza2 = zzk().zzh.zza();
        if (zza2 == null) {
            zzjq = this;
        } else if ("unset".equals(zza2)) {
            zzjq = this;
            zzjq.zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
        } else {
            zza("app", "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzb().currentTimeMillis());
            zzjq = this;
        }
        if (!zzjq.zzu.zzac() || !zzjq.zzp) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzo().zzak();
            return;
        }
        zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzan();
        zzp().zza.zza();
        zzl().zzb((Runnable) new zzkd(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzau() {
        return this.zzl;
    }
}
