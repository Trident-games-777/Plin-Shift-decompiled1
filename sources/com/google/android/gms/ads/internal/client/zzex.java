package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzblp;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzfxf;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzex {
    public static final Set zza = new HashSet(Arrays.asList(new AdFormat[]{AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED}));
    private static zzex zzb;
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    private final Object zzd = new Object();
    private zzci zze;
    /* access modifiers changed from: private */
    public final ArrayList zzf = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzg = false;
    /* access modifiers changed from: private */
    public boolean zzh = false;
    private final Object zzi = new Object();
    private zzcz zzj;
    /* access modifiers changed from: private */
    public OnAdInspectorClosedListener zzk = null;
    private RequestConfiguration zzl = new RequestConfiguration.Builder().build();

    private zzex() {
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzA(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzblp zzblp = (zzblp) it.next();
            hashMap.put(zzblp.zza, new zzblx(zzblp.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzblp.zzd, zzblp.zzc));
        }
        return new zzbly(hashMap);
    }

    private final void zzB(Context context, String str) {
        try {
            zzboy.zza().zzb(context, (String) null);
            this.zzj.zzk();
            this.zzj.zzl((String) null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzm.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    private final void zzC(Context context) {
        if (this.zzj == null) {
            this.zzj = (zzcz) new zzav(zzbc.zza(), context).zzd(context, false);
        }
    }

    private final void zzD(RequestConfiguration requestConfiguration) {
        try {
            this.zzj.zzu(new zzfv(requestConfiguration));
        } catch (RemoteException e) {
            zzm.zzh("Unable to set request configuration parcel.", e);
        }
    }

    public static zzex zzf() {
        zzex zzex;
        synchronized (zzex.class) {
            if (zzb == null) {
                zzb = new zzex();
            }
            zzex = zzb;
        }
        return zzex;
    }

    static /* bridge */ /* synthetic */ Optional zzk(zzex zzex, zzft zzft) {
        String str = zzft.zza;
        AdFormat adFormat = AdFormat.getAdFormat(zzft.zzb);
        if (adFormat == null) {
            return Optional.empty();
        }
        zzm zzm = zzft.zzc;
        AdRequest.Builder builder = new AdRequest.Builder();
        List<String> list = zzm.zze;
        if (list != null) {
            for (String addKeyword : list) {
                builder.addKeyword(addKeyword);
            }
        }
        builder.zzc(zzm.zzm);
        for (String str2 : zzm.zzn.keySet()) {
            builder.addCustomTargeting(str2, zzm.zzn.getString(str2));
        }
        builder.setAdString(zzm.zzx);
        Optional ofNullable = Optional.ofNullable(zzm.zzl);
        Objects.requireNonNull(builder);
        ofNullable.ifPresent(new zzq(builder));
        builder.setNeighboringContentUrls(zzm.zzv);
        builder.setRequestAgent(zzm.zzp);
        AdRequest build = builder.build();
        PreloadConfiguration.Builder builder2 = new PreloadConfiguration.Builder(str, adFormat);
        builder2.setAdRequest(build);
        builder2.setBufferSize(zzft.zzd);
        return Optional.of(builder2.build());
    }

    public final RequestConfiguration zzc() {
        return this.zzl;
    }

    public final InitializationStatus zze() {
        InitializationStatus zzA;
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                zzA = zzA(this.zzj.zzg());
            } catch (RemoteException unused) {
                zzm.zzg("Unable to get Initialization status.");
                return new zzem(this);
            }
        }
        return zzA;
    }

    public final Status zzg(Context context, List list, PreloadCallback preloadCallback) {
        boolean z;
        Status status;
        int i;
        int i2;
        int i3;
        Context context2 = context;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PreloadConfiguration preloadConfiguration = (PreloadConfiguration) it.next();
            String str = String.valueOf(preloadConfiguration.getAdFormat()) + "#" + preloadConfiguration.getAdUnitId();
            hashMap.put(str, Integer.valueOf(((Integer) hashMap.getOrDefault(str, 0)).intValue() + 1));
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (((Integer) ((Map.Entry) it2.next()).getValue()).intValue() > 1) {
                    hashSet.add("Preload configurations include duplicated ad unit IDs and ad format combinations");
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        HashMap hashMap2 = new HashMap();
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            PreloadConfiguration preloadConfiguration2 = (PreloadConfiguration) it3.next();
            AdFormat adFormat = preloadConfiguration2.getAdFormat();
            if (!zza.contains(preloadConfiguration2.getAdFormat())) {
                hashSet.add("PreloadConfiguration ad format is not supported:".concat(String.valueOf(String.valueOf(preloadConfiguration2.getAdFormat()))));
            } else {
                hashMap2.compute(adFormat, new zzen());
                if (preloadConfiguration2.getBufferSize() > 15) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size exceeds the maximum limit %d for %s", new Object[]{15, adFormat.name()}));
                } else if (preloadConfiguration2.getBufferSize() < 0) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size less than 0 for %s", new Object[]{adFormat.name()}));
                }
            }
            z = true;
        }
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry(AdFormat.APP_OPEN_AD, (Integer) zzbe.zzc().zza(zzbcn.zzeA)), new AbstractMap.SimpleEntry(AdFormat.INTERSTITIAL, (Integer) zzbe.zzc().zza(zzbcn.zzey)), new AbstractMap.SimpleEntry(AdFormat.REWARDED, (Integer) zzbe.zzc().zza(zzbcn.zzez))};
        HashMap hashMap3 = new HashMap(3);
        int i4 = 0;
        while (i4 < 3) {
            Map.Entry entry = entryArr[i4];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap3.put(requireNonNull, Objects.requireNonNull(entry.getValue())) == null) {
                i4++;
            } else {
                new StringBuilder("duplicate key: ").append(requireNonNull);
                throw new IllegalArgumentException("duplicate key: ".concat(String.valueOf(requireNonNull)));
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            AdFormat adFormat2 = (AdFormat) entry2.getKey();
            int intValue = ((Integer) entry2.getValue()).intValue();
            int intValue2 = ((Integer) unmodifiableMap.getOrDefault(adFormat2, 0)).intValue();
            if (intValue > intValue2) {
                hashSet.add(String.format(Locale.US, "Preload configurations' size exceeds the maximum limit %d for %s", new Object[]{Integer.valueOf(intValue2), adFormat2.name()}));
                z = true;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                sb.append((String) it4.next());
                if (it4.hasNext()) {
                    sb.append(", ");
                }
            }
            String sb2 = sb.toString();
            zzm.zzg(sb2);
            status = new Status(13, sb2);
        } else {
            status = Status.RESULT_SUCCESS;
        }
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        Preconditions.checkArgument(status.isSuccess(), statusMessage);
        zzbcn.zza(context2);
        synchronized (this.zzd) {
            if (this.zze == null) {
                this.zze = zzbc.zza().zzg(context2, new zzbpc());
            }
            ArrayList arrayList = new ArrayList();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                PreloadConfiguration preloadConfiguration3 = (PreloadConfiguration) it5.next();
                zzm zza2 = zzr.zza.zza(context2, preloadConfiguration3.getAdRequest().zza());
                zza2.zzc.putBoolean("is_sdk_preload", true);
                if (preloadConfiguration3.getBufferSize() <= 0) {
                    int ordinal = preloadConfiguration3.getAdFormat().ordinal();
                    if (ordinal == 1) {
                        i = ((Integer) zzbe.zzc().zza(zzbcn.zzC)).intValue();
                    } else if (ordinal == 2) {
                        i = ((Integer) zzbe.zzc().zza(zzbcn.zzD)).intValue();
                    } else if (ordinal != 5) {
                        i = 1;
                    } else {
                        i = ((Integer) zzbe.zzc().zza(zzbcn.zzB)).intValue();
                    }
                } else {
                    i = preloadConfiguration3.getBufferSize();
                }
                int ordinal2 = preloadConfiguration3.getAdFormat().ordinal();
                if (ordinal2 == 1) {
                    i2 = ((Integer) zzbe.zzc().zza(zzbcn.zzz)).intValue();
                } else if (ordinal2 == 2) {
                    i2 = ((Integer) zzbe.zzc().zza(zzbcn.zzA)).intValue();
                } else if (ordinal2 != 5) {
                    i2 = 1;
                } else {
                    i2 = ((Integer) zzbe.zzc().zza(zzbcn.zzy)).intValue();
                }
                int max = Math.max(Math.min(i2, 15), 1);
                int ordinal3 = preloadConfiguration3.getAdFormat().ordinal();
                if (ordinal3 == 1) {
                    i3 = ((Integer) zzbe.zzc().zza(zzbcn.zzF)).intValue();
                } else if (ordinal3 == 2) {
                    i3 = ((Integer) zzbe.zzc().zza(zzbcn.zzG)).intValue();
                } else if (ordinal3 != 5) {
                    i3 = 1;
                } else {
                    i3 = ((Integer) zzbe.zzc().zza(zzbcn.zzE)).intValue();
                }
                arrayList.add(new zzft(preloadConfiguration3.getAdUnitId(), preloadConfiguration3.getAdFormat().getValue(), zza2, Math.max(Math.min(i, max), Math.min(i3, max))));
            }
            try {
                this.zze.zzi(arrayList, new zzes(this, preloadCallback));
            } catch (RemoteException e) {
                zzm.zzh("Unable to start preload.", e);
                return Status.RESULT_INTERNAL_ERROR;
            }
        }
        return Status.RESULT_SUCCESS;
    }

    public final String zzi() {
        String zzc2;
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc2 = zzfxf.zzc(this.zzj.zzf());
            } catch (RemoteException e) {
                zzm.zzh("Unable to get internal version.", e);
                return "";
            }
        }
        return zzc2;
    }

    public final void zzn(Context context) {
        synchronized (this.zzi) {
            zzC(context);
            try {
                this.zzj.zzi();
            } catch (RemoteException unused) {
                zzm.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r3 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r4 = r2.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        zzC(r3);
        r2.zzj.zzs(new com.google.android.gms.ads.internal.client.zzev(r2, (com.google.android.gms.ads.internal.client.zzew) null));
        r2.zzj.zzo(new com.google.android.gms.internal.ads.zzbpc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r2.zzl.getTagForChildDirectedTreatment() != -1) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r2.zzl.getTagForUnderAgeOfConsent() == -1) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        zzD(r2.zzl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzk("MobileAdsSettingManager initialization failed", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        throw new java.lang.IllegalArgumentException("Context cannot be null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo(android.content.Context r3, java.lang.String r4, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r5) {
        /*
            r2 = this;
            java.lang.Object r4 = r2.zzc
            monitor-enter(r4)
            boolean r0 = r2.zzg     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x0010
            if (r5 == 0) goto L_0x000e
            java.util.ArrayList r3 = r2.zzf     // Catch:{ all -> 0x00d8 }
            r3.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x000e:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x0010:
            boolean r0 = r2.zzh     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x001f
            if (r5 == 0) goto L_0x001d
            com.google.android.gms.ads.initialization.InitializationStatus r3 = r2.zze()     // Catch:{ all -> 0x00d8 }
            r5.onInitializationComplete(r3)     // Catch:{ all -> 0x00d8 }
        L_0x001d:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x001f:
            r0 = 1
            r2.zzg = r0     // Catch:{ all -> 0x00d8 }
            if (r5 == 0) goto L_0x0029
            java.util.ArrayList r0 = r2.zzf     // Catch:{ all -> 0x00d8 }
            r0.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            if (r3 == 0) goto L_0x00d0
            java.lang.Object r4 = r2.zzi
            monitor-enter(r4)
            r5 = 0
            r2.zzC(r3)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzcz r0 = r2.zzj     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzev r1 = new com.google.android.gms.ads.internal.client.zzev     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>(r2, r5)     // Catch:{ RemoteException -> 0x0060 }
            r0.zzs(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzcz r0 = r2.zzj     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.internal.ads.zzbpc r1 = new com.google.android.gms.internal.ads.zzbpc     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0060 }
            r0.zzo(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzl     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x0060 }
            r1 = -1
            if (r0 != r1) goto L_0x0058
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzl     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x0060 }
            if (r0 == r1) goto L_0x0066
        L_0x0058:
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzl     // Catch:{ RemoteException -> 0x0060 }
            r2.zzD(r0)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0066
        L_0x005e:
            r3 = move-exception
            goto L_0x00ce
        L_0x0060:
            r0 = move-exception
            java.lang.String r1 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r1, r0)     // Catch:{ all -> 0x005e }
        L_0x0066:
            com.google.android.gms.internal.ads.zzbcn.zza(r3)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zza     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkO     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            java.lang.String r0 = "Initializing on bg thread"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.ThreadPoolExecutor r0 = com.google.android.gms.ads.internal.util.client.zzb.zza     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzeo r1 = new com.google.android.gms.ads.internal.client.zzeo     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x0099:
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zzb     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkO     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            java.util.concurrent.ExecutorService r0 = com.google.android.gms.ads.internal.util.client.zzb.zzb     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzep r1 = new com.google.android.gms.ads.internal.client.zzep     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r0 = "Initializing on calling thread"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x005e }
            r2.zzB(r3, r5)     // Catch:{ all -> 0x005e }
        L_0x00cc:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            return
        L_0x00ce:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            throw r3
        L_0x00d0:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Context cannot be null."
            r3.<init>(r4)
            throw r3
        L_0x00d8:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzex.zzo(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Context context, String str) {
        synchronized (this.zzi) {
            zzB(context, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Context context, String str) {
        synchronized (this.zzi) {
            zzB(context, (String) null);
        }
    }

    public final void zzr(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzi) {
            zzC(context);
            this.zzk = onAdInspectorClosedListener;
            try {
                this.zzj.zzm(new zzeu((zzew) null));
            } catch (RemoteException unused) {
                zzm.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzs(Context context, String str) {
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzj.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzm.zzh("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzt(Class cls) {
        synchronized (this.zzi) {
            try {
                this.zzj.zzh(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzm.zzh("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void zzu(boolean z) {
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzj.zzp(z);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzv(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzi) {
            if (this.zzj == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzj.zzq(f);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set app volume.", e);
            }
        }
    }

    public final void zzw(String str) {
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzj.zzt(str);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set plugin.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzi
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzl     // Catch:{ all -> 0x0030 }
            r4.zzl = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.ads.internal.client.zzcz r2 = r4.zzj     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzD(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzex.zzx(com.google.android.gms.ads.RequestConfiguration):void");
    }

    public final boolean zzz(boolean z) {
        String str;
        synchronized (this.zzi) {
            Preconditions.checkState(this.zzj != null, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            try {
                this.zzj.zzj(z);
            } catch (RemoteException e) {
                if (z) {
                    str = "enable";
                } else {
                    str = "disable";
                }
                zzm.zzh("Unable to " + str + " the publisher first-party ID.", e);
                return false;
            }
        }
        return true;
    }

    public final float zza() {
        float f;
        synchronized (this.zzi) {
            zzcz zzcz = this.zzj;
            f = 1.0f;
            if (zzcz == null) {
                return 1.0f;
            }
            try {
                f = zzcz.zze();
            } catch (RemoteException e) {
                zzm.zzh("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final boolean zzy() {
        boolean z;
        synchronized (this.zzi) {
            zzcz zzcz = this.zzj;
            z = false;
            if (zzcz == null) {
                return false;
            }
            try {
                z = zzcz.zzv();
            } catch (RemoteException e) {
                zzm.zzh("Unable to get app mute state.", e);
            }
        }
        return z;
    }
}
