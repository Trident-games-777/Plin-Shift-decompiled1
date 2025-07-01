package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmg {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final zzfmp zzc;
    private final zzfmd zzd;
    private final Clock zze;

    zzfmg(zzfmp zzfmp, zzfmd zzfmd, Clock clock) {
        this.zzc = zzfmp;
        this.zzd = zzfmd;
        this.zze = clock;
    }

    static String zzd(String str, AdFormat adFormat) {
        String name = adFormat == null ? "NULL" : adFormat.name();
        return str + "#" + name;
    }

    private final synchronized List zzj(List list) {
        ArrayList arrayList;
        HashSet hashSet = new HashSet();
        arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzft zzft = (zzft) it.next();
            String zzd2 = zzd(zzft.zza, AdFormat.getAdFormat(zzft.zzb));
            hashSet.add(zzd2);
            zzfmo zzfmo = (zzfmo) this.zza.get(zzd2);
            if (zzfmo == null) {
                arrayList.add(zzft);
            } else if (!zzfmo.zze.equals(zzft)) {
                this.zzb.put(zzd2, zzfmo);
                this.zza.remove(zzd2);
            }
        }
        Iterator it2 = this.zza.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (!hashSet.contains((String) entry.getKey())) {
                this.zzb.put((String) entry.getKey(), (zzfmo) entry.getValue());
                it2.remove();
            }
        }
        Iterator it3 = this.zzb.entrySet().iterator();
        while (it3.hasNext()) {
            zzfmo zzfmo2 = (zzfmo) ((Map.Entry) it3.next()).getValue();
            zzfmo2.zzk();
            if (!zzfmo2.zzl()) {
                it3.remove();
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: com.google.android.gms.internal.ads.zzfmo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized java.util.Optional zzk(java.lang.Class r2, java.lang.String r3, com.google.android.gms.ads.AdFormat r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.ConcurrentMap r0 = r1.zza     // Catch:{ all -> 0x006f }
            java.lang.String r3 = zzd(r3, r4)     // Catch:{ all -> 0x006f }
            boolean r4 = r0.containsKey(r3)     // Catch:{ all -> 0x006f }
            if (r4 != 0) goto L_0x001c
            java.util.concurrent.ConcurrentMap r4 = r1.zzb     // Catch:{ all -> 0x006f }
            boolean r4 = r4.containsKey(r3)     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            java.util.Optional r2 = java.util.Optional.empty()     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return r2
        L_0x001c:
            java.util.concurrent.ConcurrentMap r4 = r1.zza     // Catch:{ all -> 0x006f }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.ads.zzfmo r4 = (com.google.android.gms.internal.ads.zzfmo) r4     // Catch:{ all -> 0x006f }
            if (r4 != 0) goto L_0x0038
            java.util.concurrent.ConcurrentMap r4 = r1.zzb     // Catch:{ all -> 0x006f }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x006f }
            r4 = r3
            com.google.android.gms.internal.ads.zzfmo r4 = (com.google.android.gms.internal.ads.zzfmo) r4     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.util.Optional r2 = java.util.Optional.empty()     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return r2
        L_0x0038:
            java.lang.Object r3 = r4.zzd()     // Catch:{ ClassCastException -> 0x004e }
            java.util.Optional r3 = java.util.Optional.ofNullable(r3)     // Catch:{ ClassCastException -> 0x004e }
            java.util.Objects.requireNonNull(r2)     // Catch:{ ClassCastException -> 0x004e }
            com.google.android.gms.internal.ads.zzfmf r4 = new com.google.android.gms.internal.ads.zzfmf     // Catch:{ ClassCastException -> 0x004e }
            r4.<init>(r2)     // Catch:{ ClassCastException -> 0x004e }
            java.util.Optional r2 = r3.map(r4)     // Catch:{ ClassCastException -> 0x004e }
            monitor-exit(r1)
            return r2
        L_0x004e:
            r3 = move-exception
            java.lang.String r4 = "PreloadAdManager.pollAd"
            com.google.android.gms.internal.ads.zzbzz r0 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x006f }
            r0.zzw(r3, r4)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Unable to cast ad to the requested type:"
            java.lang.String r2 = r4.concat(r2)     // Catch:{ all -> 0x006f }
            com.google.android.gms.ads.internal.util.zze.zzb(r2, r3)     // Catch:{ all -> 0x006f }
            java.util.Optional r2 = java.util.Optional.empty()     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return r2
        L_0x006f:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmg.zzk(java.lang.Class, java.lang.String, com.google.android.gms.ads.AdFormat):java.util.Optional");
    }

    private final synchronized void zzl(String str, zzfmo zzfmo) {
        zzfmo.zzc();
        this.zza.put(str, zzfmo);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.google.android.gms.internal.ads.zzfmo} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        return r3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzm(java.lang.String r7, com.google.android.gms.ads.AdFormat r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.common.util.Clock r0 = r6.zze     // Catch:{ all -> 0x0069 }
            long r0 = r0.currentTimeMillis()     // Catch:{ all -> 0x0069 }
            java.util.concurrent.ConcurrentMap r2 = r6.zza     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = zzd(r7, r8)     // Catch:{ all -> 0x0069 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x0069 }
            r3 = 0
            if (r2 != 0) goto L_0x001f
            java.util.concurrent.ConcurrentMap r2 = r6.zzb     // Catch:{ all -> 0x0069 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            monitor-exit(r6)
            return r3
        L_0x001f:
            java.util.concurrent.ConcurrentMap r2 = r6.zza     // Catch:{ all -> 0x0069 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads.zzfmo r2 = (com.google.android.gms.internal.ads.zzfmo) r2     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x0032
            java.util.concurrent.ConcurrentMap r2 = r6.zzb     // Catch:{ all -> 0x0069 }
            java.lang.Object r7 = r2.get(r7)     // Catch:{ all -> 0x0069 }
            r2 = r7
            com.google.android.gms.internal.ads.zzfmo r2 = (com.google.android.gms.internal.ads.zzfmo) r2     // Catch:{ all -> 0x0069 }
        L_0x0032:
            if (r2 == 0) goto L_0x003b
            boolean r7 = r2.zzl()     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x003b
            r3 = 1
        L_0x003b:
            com.google.android.gms.internal.ads.zzbce r7 = com.google.android.gms.internal.ads.zzbcn.zzs     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0069 }
            java.lang.Object r7 = r2.zza(r7)     // Catch:{ all -> 0x0069 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0069 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x0067
            if (r3 == 0) goto L_0x005e
            com.google.android.gms.common.util.Clock r7 = r6.zze     // Catch:{ all -> 0x0069 }
            long r4 = r7.currentTimeMillis()     // Catch:{ all -> 0x0069 }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0069 }
            java.util.Optional r7 = java.util.Optional.of(r7)     // Catch:{ all -> 0x0069 }
            goto L_0x0062
        L_0x005e:
            java.util.Optional r7 = java.util.Optional.empty()     // Catch:{ all -> 0x0069 }
        L_0x0062:
            com.google.android.gms.internal.ads.zzfmd r2 = r6.zzd     // Catch:{ all -> 0x0069 }
            r2.zza(r8, r0, r7)     // Catch:{ all -> 0x0069 }
        L_0x0067:
            monitor-exit(r6)
            return r3
        L_0x0069:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0069 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmg.zzm(java.lang.String, com.google.android.gms.ads.AdFormat):boolean");
    }

    public final synchronized zzbaf zza(String str) {
        return (zzbaf) zzk(zzbaf.class, str, AdFormat.APP_OPEN_AD).orElse((Object) null);
    }

    public final synchronized zzby zzb(String str) {
        return (zzby) zzk(zzby.class, str, AdFormat.INTERSTITIAL).orElse((Object) null);
    }

    public final synchronized zzbxc zzc(String str) {
        return (zzbxc) zzk(zzbxc.class, str, AdFormat.REWARDED).orElse((Object) null);
    }

    public final void zze(zzbpg zzbpg) {
        this.zzc.zzb(zzbpg);
    }

    public final synchronized void zzf(List list, zzcf zzcf) {
        for (zzft zzft : zzj(list)) {
            String str = zzft.zza;
            AdFormat adFormat = AdFormat.getAdFormat(zzft.zzb);
            zzfmo zza2 = this.zzc.zza(zzft, zzcf);
            if (!(adFormat == null || zza2 == null)) {
                zzl(zzd(str, adFormat), zza2);
            }
        }
    }

    public final synchronized boolean zzg(String str) {
        return zzm(str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzh(String str) {
        return zzm(str, AdFormat.INTERSTITIAL);
    }

    public final synchronized boolean zzi(String str) {
        return zzm(str, AdFormat.REWARDED);
    }
}
