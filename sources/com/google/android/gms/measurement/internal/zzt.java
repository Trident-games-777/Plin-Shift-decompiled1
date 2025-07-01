package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zzoe;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
final class zzt extends zznr {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzv> zzc;
    private Long zzd;
    private Long zze;

    private final zzv zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzv zzv = new zzv(this, this.zza);
        this.zzc.put(num, zzv);
        return zzv;
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    /* access modifiers changed from: package-private */
    public final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        HashSet hashSet;
        ArrayMap arrayMap;
        List<zzfo.zzb> list3;
        boolean z5;
        Iterator it;
        Map<Integer, zzfy.zzm> map;
        Iterator<zzfy.zzn> it2;
        zzfy.zzm zzm;
        boolean z6;
        Iterator<Integer> it3;
        Map<Integer, List<Integer>> map2;
        HashSet hashSet2;
        List<zzfy.zzf> list4 = list;
        List<zzfy.zzo> list5 = list2;
        boolean z7 = z;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list4);
        Preconditions.checkNotNull(list5);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfy.zzf> it4 = list4.iterator();
        while (true) {
            z2 = true;
            if (it4.hasNext()) {
                if ("_s".equals(it4.next().zzg())) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        boolean z8 = zzoe.zza() && zze().zzf(this.zza, zzbh.zzbp);
        boolean z9 = zzoe.zza() && zze().zzf(this.zza, zzbh.zzbo);
        if (z3) {
            zzal zzh = zzh();
            String str2 = this.zza;
            zzh.zzal();
            zzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", 0);
            try {
                zzh.e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzgo.zza(str2), e);
            }
        }
        Map<Integer, List<zzfo.zzb>> emptyMap = Collections.emptyMap();
        if (z9 && z8) {
            emptyMap = zzh().zzn(this.zza);
        }
        Map<Integer, zzfy.zzm> zzm2 = zzh().zzm(this.zza);
        if (!zzm2.isEmpty()) {
            HashSet hashSet3 = new HashSet(zzm2.keySet());
            if (z3) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> zzo = zzh().zzo(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(zzm2);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!zzm2.isEmpty()) {
                    Iterator<Integer> it5 = zzm2.keySet().iterator();
                    while (it5.hasNext()) {
                        int intValue = it5.next().intValue();
                        zzfy.zzm zzm3 = zzm2.get(Integer.valueOf(intValue));
                        List list6 = zzo.get(Integer.valueOf(intValue));
                        if (list6 == null || list6.isEmpty()) {
                            hashSet2 = hashSet3;
                            map2 = zzo;
                            it3 = it5;
                            z6 = z2;
                            arrayMap2.put(Integer.valueOf(intValue), zzm3);
                        } else {
                            z6 = z2;
                            hashSet2 = hashSet3;
                            List<Long> zza2 = g_().zza(zzm3.zzi(), (List<Integer>) list6);
                            if (!zza2.isEmpty()) {
                                zzjt.zzb zzcd = zzm3.zzcd();
                                zzjt.zzb zzb2 = zzcd;
                                zzfy.zzm.zza zzb3 = ((zzfy.zzm.zza) zzcd).zzb().zzb(zza2);
                                zzb3.zzd().zzd(g_().zza(zzm3.zzk(), (List<Integer>) list6));
                                ArrayList arrayList = new ArrayList();
                                for (zzfy.zze next : zzm3.zzh()) {
                                    Map<Integer, List<Integer>> map3 = zzo;
                                    Iterator<Integer> it6 = it5;
                                    if (!list6.contains(Integer.valueOf(next.zza()))) {
                                        arrayList.add(next);
                                    }
                                    zzo = map3;
                                    it5 = it6;
                                }
                                map2 = zzo;
                                it3 = it5;
                                zzb3.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfy.zzn next2 : zzm3.zzj()) {
                                    if (!list6.contains(Integer.valueOf(next2.zzb()))) {
                                        arrayList2.add(next2);
                                    }
                                }
                                zzb3.zzc().zzc(arrayList2);
                                arrayMap2.put(Integer.valueOf(intValue), (zzfy.zzm) ((zzjt) zzb3.zzai()));
                            } else {
                                z2 = z6;
                                hashSet3 = hashSet2;
                            }
                        }
                        z2 = z6;
                        hashSet3 = hashSet2;
                        zzo = map2;
                        it5 = it3;
                    }
                }
                hashSet = hashSet3;
                z4 = z2;
                arrayMap = arrayMap2;
            } else {
                hashSet = hashSet3;
                z4 = true;
                arrayMap = zzm2;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                int intValue2 = ((Integer) it7.next()).intValue();
                zzfy.zzm zzm4 = arrayMap.get(Integer.valueOf(intValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap3 = new ArrayMap();
                if (!(zzm4 == null || zzm4.zza() == 0)) {
                    for (zzfy.zze next3 : zzm4.zzh()) {
                        if (next3.zzf()) {
                            zzm = zzm4;
                            arrayMap3.put(Integer.valueOf(next3.zza()), next3.zze() ? Long.valueOf(next3.zzb()) : null);
                        } else {
                            zzm = zzm4;
                        }
                        zzm4 = zzm;
                    }
                }
                zzfy.zzm zzm5 = zzm4;
                ArrayMap arrayMap4 = new ArrayMap();
                if (!(zzm5 == null || zzm5.zzc() == 0)) {
                    Iterator<zzfy.zzn> it8 = zzm5.zzj().iterator();
                    while (it8.hasNext()) {
                        zzfy.zzn next4 = it8.next();
                        if (!next4.zzf() || next4.zza() <= 0) {
                            it2 = it8;
                            map = arrayMap;
                        } else {
                            it2 = it8;
                            map = arrayMap;
                            arrayMap4.put(Integer.valueOf(next4.zzb()), Long.valueOf(next4.zza(next4.zza() - 1)));
                        }
                        it8 = it2;
                        arrayMap = map;
                    }
                }
                Map<Integer, zzfy.zzm> map4 = arrayMap;
                if (zzm5 != null) {
                    int i = 0;
                    while (i < (zzm5.zzd() << 6)) {
                        if (zzoo.zza(zzm5.zzk(), i)) {
                            it = it7;
                            z5 = z8;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zzoo.zza(zzm5.zzi(), i)) {
                                bitSet.set(i);
                                i++;
                                it7 = it;
                                z8 = z5;
                            }
                        } else {
                            it = it7;
                            z5 = z8;
                        }
                        arrayMap3.remove(Integer.valueOf(i));
                        i++;
                        it7 = it;
                        z8 = z5;
                    }
                }
                Iterator it9 = it7;
                boolean z10 = z8;
                zzfy.zzm zzm6 = zzm2.get(Integer.valueOf(intValue2));
                if (!(!z9 || !z10 || (list3 = emptyMap.get(Integer.valueOf(intValue2))) == null || this.zze == null || this.zzd == null)) {
                    for (zzfo.zzb zzb4 : list3) {
                        int zzb5 = zzb4.zzb();
                        long longValue = this.zze.longValue() / 1000;
                        if (zzb4.zzi()) {
                            longValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(zzb5))) {
                            arrayMap3.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                        }
                        if (arrayMap4.containsKey(Integer.valueOf(zzb5))) {
                            arrayMap4.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                        }
                    }
                }
                this.zzc.put(Integer.valueOf(intValue2), new zzv(this, this.zza, zzm6, bitSet, bitSet2, arrayMap3, arrayMap4));
                zzm2 = zzm2;
                emptyMap = emptyMap;
                it7 = it9;
                z8 = z10;
                arrayMap = map4;
            }
        } else {
            z4 = true;
        }
        if (!zznm.zza() || !zze().zzf((String) null, zzbh.zzcy)) {
            zza(list4, z4);
            zza(list5);
            return zzu();
        }
        zza(list4, z7);
        if (z7) {
            return new ArrayList();
        }
        zza(list5);
        return zzu();
    }

    private final List<zzfy.zzd> zzu() {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = this.zzc.keySet();
        keySet.removeAll(this.zzb);
        for (Integer intValue : keySet) {
            int intValue2 = intValue.intValue();
            zzv zzv = this.zzc.get(Integer.valueOf(intValue2));
            Preconditions.checkNotNull(zzv);
            zzfy.zzd zza2 = zzv.zza(intValue2);
            arrayList.add(zza2);
            zzal zzh = zzh();
            String str = this.zza;
            zzfy.zzm zzd2 = zza2.zzd();
            zzh.zzal();
            zzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzd2);
            byte[] zzca = zzd2.zzca();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(intValue2));
            contentValues.put("current_results", zzca);
            try {
                if (zzh.e_().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    zzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzgo.zza(str));
                }
            } catch (SQLiteException e) {
                zzh.zzj().zzg().zza("Error storing filter results. appId", zzgo.zza(str), e);
            }
        }
        return arrayList;
    }

    zzt(zznv zznv) {
        super(zznv);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.List<com.google.android.gms.internal.measurement.zzfy.zzf> r33, boolean r34) {
        /*
            r32 = this;
            r0 = r32
            boolean r1 = r33.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x0195
        L_0x000a:
            com.google.android.gms.measurement.internal.zzy r1 = new com.google.android.gms.measurement.internal.zzy
            r2 = 0
            r1.<init>(r0)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r33.iterator()
        L_0x0019:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0195
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.measurement.zzfy$zzf r5 = (com.google.android.gms.internal.measurement.zzfy.zzf) r5
            java.lang.String r6 = r0.zza
            com.google.android.gms.internal.measurement.zzfy$zzf r10 = r1.zza(r6, r5)
            if (r10 == 0) goto L_0x0189
            com.google.android.gms.measurement.internal.zzal r6 = r0.zzh()
            java.lang.String r12 = r0.zza
            java.lang.String r7 = r10.zzg()
            java.lang.String r8 = r5.zzg()
            com.google.android.gms.measurement.internal.zzbb r8 = r6.zzd(r12, r8)
            if (r8 != 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzu()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r12)
            com.google.android.gms.measurement.internal.zzgh r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r7)
            java.lang.String r7 = "Event aggregate wasn't created during raw event logging. appId, event"
            r8.zza(r7, r9, r6)
            com.google.android.gms.measurement.internal.zzbb r11 = new com.google.android.gms.measurement.internal.zzbb
            java.lang.String r13 = r5.zzg()
            long r20 = r5.zzd()
            r26 = 0
            r27 = 0
            r14 = 1
            r16 = 1
            r18 = 1
            r22 = 0
            r24 = 0
            r25 = 0
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)
            r30 = r1
            r29 = r3
            r13 = r11
            goto L_0x00b1
        L_0x007d:
            com.google.android.gms.measurement.internal.zzbb r12 = new com.google.android.gms.measurement.internal.zzbb
            java.lang.String r13 = r8.zza
            java.lang.String r14 = r8.zzb
            long r5 = r8.zzc
            r15 = 1
            long r5 = r5 + r15
            r29 = r3
            long r2 = r8.zzd
            long r17 = r2 + r15
            long r2 = r8.zze
            long r19 = r2 + r15
            long r2 = r8.zzf
            r30 = r1
            r21 = r2
            long r1 = r8.zzg
            java.lang.Long r3 = r8.zzh
            java.lang.Long r7 = r8.zzi
            java.lang.Long r9 = r8.zzj
            java.lang.Boolean r8 = r8.zzk
            r23 = r1
            r25 = r3
            r15 = r5
            r26 = r7
            r28 = r8
            r27 = r9
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            r13 = r12
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzh()
            r1.zza((com.google.android.gms.measurement.internal.zzbb) r13)
            boolean r1 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r1 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzag r1 = r0.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbh.zzcy
            r3 = 0
            boolean r1 = r1.zzf(r3, r2)
            if (r1 == 0) goto L_0x00d6
            if (r34 != 0) goto L_0x00ce
            goto L_0x00d6
        L_0x00ce:
            r2 = r3
            r3 = r29
        L_0x00d1:
            r1 = r30
            goto L_0x0019
        L_0x00d5:
            r3 = 0
        L_0x00d6:
            long r11 = r13.zzc
            java.lang.String r1 = r10.zzg()
            r2 = r29
            java.lang.Object r5 = r2.get(r1)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzal r5 = r0.zzh()
            java.lang.String r6 = r0.zza
            java.util.Map r5 = r5.zzf(r6, r1)
            r2.put(r1, r5)
        L_0x00f3:
            java.util.Set r1 = r5.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00fb:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0184
            java.lang.Object r6 = r1.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set<java.lang.Integer> r7 = r0.zzb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzgo r7 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            java.lang.String r8 = "Skipping failed audience ID"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.zza(r8, r6)
            goto L_0x00fb
        L_0x0129:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r5.get(r7)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r15 = r7.iterator()
            r7 = 1
        L_0x0138:
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto L_0x0177
            java.lang.Object r7 = r15.next()
            com.google.android.gms.internal.measurement.zzfo$zzb r7 = (com.google.android.gms.internal.measurement.zzfo.zzb) r7
            com.google.android.gms.measurement.internal.zzx r8 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r9 = r0.zza
            r8.<init>(r0, r9, r6, r7)
            r9 = r7
            r7 = r8
            java.lang.Long r8 = r0.zzd
            r14 = r9
            java.lang.Long r9 = r0.zze
            int r14 = r14.zzb()
            boolean r14 = r0.zza((int) r6, (int) r14)
            boolean r8 = r7.zza(r8, r9, r10, r11, r13, r14)
            if (r8 == 0) goto L_0x016d
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.measurement.internal.zzv r9 = r0.zza((java.lang.Integer) r9)
            r9.zza((com.google.android.gms.measurement.internal.zzaa) r7)
            r7 = r8
            goto L_0x0138
        L_0x016d:
            java.util.Set<java.lang.Integer> r7 = r0.zzb
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            r7 = r8
        L_0x0177:
            if (r7 != 0) goto L_0x00fb
            java.util.Set<java.lang.Integer> r7 = r0.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
            goto L_0x00fb
        L_0x0184:
            r1 = r3
            r3 = r2
            r2 = r1
            goto L_0x00d1
        L_0x0189:
            r31 = r3
            r3 = r2
            r2 = r31
            r31 = r3
            r3 = r2
            r2 = r31
            goto L_0x0019
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.util.List, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0126, code lost:
        if (r6.zzi() == false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0128, code lost:
        r8 = java.lang.Integer.valueOf(r6.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0130, code lost:
        r5.zza("Invalid property filter ID. appId, id", r7, java.lang.String.valueOf(r8));
        r6 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.List<com.google.android.gms.internal.measurement.zzfy.zzo> r14) {
        /*
            r13 = this;
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0008
            goto L_0x0147
        L_0x0008:
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x0011:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0147
            java.lang.Object r1 = r14.next()
            com.google.android.gms.internal.measurement.zzfy$zzo r1 = (com.google.android.gms.internal.measurement.zzfy.zzo) r1
            java.lang.String r2 = r1.zzg()
            java.lang.Object r3 = r0.get(r2)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzal r3 = r13.zzh()
            java.lang.String r4 = r13.zza
            java.util.Map r3 = r3.zzg(r4, r2)
            r0.put(r2, r3)
        L_0x0036:
            java.util.Set r2 = r3.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0011
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.util.Set<java.lang.Integer> r5 = r13.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzgo r1 = r13.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzp()
            java.lang.String r2 = "Skipping failed audience ID"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r1.zza(r2, r3)
            goto L_0x0011
        L_0x006c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = 1
        L_0x007b:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x013a
            java.lang.Object r6 = r5.next()
            com.google.android.gms.internal.measurement.zzfo$zze r6 = (com.google.android.gms.internal.measurement.zzfo.zze) r6
            com.google.android.gms.measurement.internal.zzgo r7 = r13.zzj()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            r8 = 0
            if (r7 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzgo r7 = r13.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            boolean r10 = r6.zzi()
            if (r10 == 0) goto L_0x00ae
            int r10 = r6.zza()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x00af
        L_0x00ae:
            r10 = r8
        L_0x00af:
            com.google.android.gms.measurement.internal.zzgh r11 = r13.zzi()
            java.lang.String r12 = r6.zze()
            java.lang.String r11 = r11.zzc(r12)
            java.lang.String r12 = "Evaluating filter. audience, filter, property"
            r7.zza(r12, r9, r10, r11)
            com.google.android.gms.measurement.internal.zzgo r7 = r13.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            com.google.android.gms.measurement.internal.zzoo r9 = r13.g_()
            java.lang.String r9 = r9.zza((com.google.android.gms.internal.measurement.zzfo.zze) r6)
            java.lang.String r10 = "Filter definition"
            r7.zza(r10, r9)
        L_0x00d5:
            boolean r7 = r6.zzi()
            if (r7 == 0) goto L_0x0114
            int r7 = r6.zza()
            r9 = 256(0x100, float:3.59E-43)
            if (r7 <= r9) goto L_0x00e4
            goto L_0x0114
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzz r7 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r8 = r13.zza
            r7.<init>(r13, r8, r4, r6)
            java.lang.Long r8 = r13.zzd
            java.lang.Long r9 = r13.zze
            int r6 = r6.zza()
            boolean r6 = r13.zza((int) r4, (int) r6)
            boolean r6 = r7.zza(r8, r9, r1, r6)
            if (r6 == 0) goto L_0x010a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.measurement.internal.zzv r8 = r13.zza((java.lang.Integer) r8)
            r8.zza((com.google.android.gms.measurement.internal.zzaa) r7)
            goto L_0x007b
        L_0x010a:
            java.util.Set<java.lang.Integer> r5 = r13.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r5.add(r7)
            goto L_0x013a
        L_0x0114:
            com.google.android.gms.measurement.internal.zzgo r5 = r13.zzj()
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzu()
            java.lang.String r7 = r13.zza
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r7)
            boolean r9 = r6.zzi()
            if (r9 == 0) goto L_0x0130
            int r6 = r6.zza()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
        L_0x0130:
            java.lang.String r6 = java.lang.String.valueOf(r8)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r5.zza(r8, r7, r6)
            r6 = 0
        L_0x013a:
            if (r6 != 0) goto L_0x003e
            java.util.Set<java.lang.Integer> r5 = r13.zzb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5.add(r4)
            goto L_0x003e
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.util.List):void");
    }

    private final boolean zza(int i, int i2) {
        zzv zzv = this.zzc.get(Integer.valueOf(i));
        if (zzv == null) {
            return false;
        }
        return zzv.zzd.get(i2);
    }
}
