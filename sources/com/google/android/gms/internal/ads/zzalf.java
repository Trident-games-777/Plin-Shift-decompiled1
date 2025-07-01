package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzalf {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzall zzf;
    public final String zzg;
    public final String zzh;
    public final zzalf zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzalf zzb(String str, long j, long j2, zzall zzall, String[] strArr, String str2, String str3, zzalf zzalf) {
        return new zzalf(str, (String) null, j, j2, zzall, strArr, str2, str3, zzalf);
    }

    public static zzalf zzc(String str) {
        return new zzalf((String) null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, (zzall) null, (String[]) null, "", (String) null, (zzalf) null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcr zzcr = new zzcr();
            zzcr.zzl(new SpannableStringBuilder());
            map.put(str, zzcr);
        }
        CharSequence zzq = ((zzcr) map.get(str)).zzq();
        zzq.getClass();
        return (SpannableStringBuilder) zzq;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z || equals || (equals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzalf zzalf = (zzalf) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !equals) {
                    z2 = false;
                }
                zzalf.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (!zzg(j) || !"div".equals(this.zza) || (str2 = this.zzh) == null) {
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzk(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        Iterator it;
        zzalf zzalf;
        zzall zza2;
        int i;
        Map map4 = map;
        if (zzg(j)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            Iterator it2 = this.zzl.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str3 = (String) entry.getKey();
                int intValue = this.zzk.containsKey(str3) ? ((Integer) this.zzk.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    zzcr zzcr = (zzcr) map3.get(str3);
                    zzcr.getClass();
                    zzcr zzcr2 = zzcr;
                    zzalj zzalj = (zzalj) map2.get(str2);
                    zzalj.getClass();
                    zzalj zzalj2 = zzalj;
                    int i2 = zzalj.zzj;
                    zzall zza3 = zzalk.zza(this.zzf, this.zzj, map4);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcr.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcr.zzl(spannableStringBuilder);
                    }
                    if (zza3 != null) {
                        zzalf zzalf2 = this.zzi;
                        if (zza3.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zza3.zzh()), intValue, intValue2, 33);
                        }
                        if (zza3.zzI()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzJ()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzH()) {
                            zzcy.zzb(spannableStringBuilder, new ForegroundColorSpan(zza3.zzd()), intValue, intValue2, 33);
                        }
                        if (zza3.zzG()) {
                            zzcy.zzb(spannableStringBuilder, new BackgroundColorSpan(zza3.zzc()), intValue, intValue2, 33);
                        }
                        if (zza3.zzD() != null) {
                            zzcy.zzb(spannableStringBuilder, new TypefaceSpan(zza3.zzD()), intValue, intValue2, 33);
                        }
                        if (zza3.zzk() != null) {
                            zzale zzk2 = zza3.zzk();
                            zzk2.getClass();
                            zzale zzale = zzk2;
                            int i3 = zzk2.zza;
                            it = it2;
                            if (i3 == -1) {
                                i3 = (i2 == 2 || i2 == 1) ? 3 : 1;
                                i = 1;
                            } else {
                                i = zzk2.zzb;
                            }
                            int i4 = zzk2.zzc;
                            if (i4 == -2) {
                                i4 = 1;
                            }
                            zzcy.zzb(spannableStringBuilder, new zzcz(i3, i, i4), intValue, intValue2, 33);
                        } else {
                            it = it2;
                        }
                        int zzg2 = zza3.zzg();
                        if (zzg2 == 2) {
                            while (true) {
                                if (zzalf2 != null) {
                                    zzall zza4 = zzalk.zza(zzalf2.zzf, zzalf2.zzj, map4);
                                    if (zza4 != null && zza4.zzg() == 1) {
                                        break;
                                    }
                                    zzalf2 = zzalf2.zzi;
                                } else {
                                    zzalf2 = null;
                                    break;
                                }
                            }
                            if (zzalf2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzalf2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzalf = null;
                                        break;
                                    }
                                    zzalf zzalf3 = (zzalf) arrayDeque.pop();
                                    zzall zza5 = zzalk.zza(zzalf3.zzf, zzalf3.zzj, map4);
                                    if (zza5 != null && zza5.zzg() == 3) {
                                        zzalf = zzalf3;
                                        break;
                                    }
                                    for (int zza6 = zzalf3.zza() - 1; zza6 >= 0; zza6--) {
                                        arrayDeque.push(zzalf3.zzd(zza6));
                                    }
                                }
                                if (zzalf != null) {
                                    if (zzalf.zza() != 1 || zzalf.zzd(0).zzb == null) {
                                        zzdt.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str4 = zzalf.zzd(0).zzb;
                                        int i5 = zzen.zza;
                                        String str5 = str4;
                                        zzall zza7 = zzalk.zza(zzalf.zzf, zzalf.zzj, map4);
                                        int zzf2 = zza7 != null ? zza7.zzf() : -1;
                                        if (zzf2 == -1 && (zza2 = zzalk.zza(zzalf2.zzf, zzalf2.zzj, map4)) != null) {
                                            zzf2 = zza2.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzcx(str4, zzf2), intValue, intValue2, 33);
                                    }
                                }
                            }
                        } else if (zzg2 == 3 || zzg2 == 4) {
                            spannableStringBuilder.setSpan(new zzald(), intValue, intValue2, 33);
                        }
                        if (zza3.zzF()) {
                            zzcy.zzb(spannableStringBuilder, new zzcw(), intValue, intValue2, 33);
                        }
                        int zze2 = zza3.zze();
                        if (zze2 == 1) {
                            zzcy.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zza3.zza(), true), intValue, intValue2, 33);
                        } else if (zze2 == 2) {
                            zzcy.zzb(spannableStringBuilder, new RelativeSizeSpan(zza3.zza()), intValue, intValue2, 33);
                        } else if (zze2 == 3) {
                            zzcy.zza(spannableStringBuilder, zza3.zza() / 100.0f, intValue, intValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zza3.zzb() != Float.MAX_VALUE) {
                                zzcr.zzj((zza3.zzb() * -90.0f) / 100.0f);
                            }
                            if (zza3.zzj() != null) {
                                zzcr.zzm(zza3.zzj());
                            }
                            if (zza3.zzi() != null) {
                                zzcr.zzg(zza3.zzi());
                            }
                        }
                        it2 = it;
                    }
                } else {
                    Map map5 = map2;
                    Map map6 = map3;
                }
            }
            int i6 = 0;
            while (true) {
                Map map7 = map2;
                Map map8 = map3;
                if (i6 < zza()) {
                    zzd(i6).zzl(j, map4, map7, str2, map8);
                    i6++;
                    map4 = map;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        Map map2;
        boolean z2;
        long j2;
        this.zzk.clear();
        this.zzl.clear();
        if (!"metadata".equals(this.zza)) {
            if (!"".equals(this.zzg)) {
                str = this.zzg;
            }
            String str2 = str;
            if (this.zzc && z) {
                SpannableStringBuilder zzi2 = zzi(str2, map);
                String str3 = this.zzb;
                str3.getClass();
                zzi2.append(str3);
            } else if ("br".equals(this.zza) && z) {
                zzi(str2, map).append(10);
            } else if (zzg(j)) {
                for (Map.Entry entry : map.entrySet()) {
                    CharSequence zzq = ((zzcr) entry.getValue()).zzq();
                    zzq.getClass();
                    CharSequence charSequence = zzq;
                    this.zzk.put((String) entry.getKey(), Integer.valueOf(zzq.length()));
                }
                boolean equals = "p".equals(this.zza);
                int i = 0;
                while (i < zza()) {
                    zzalf zzd2 = zzd(i);
                    if (z || equals) {
                        map2 = map;
                        z2 = true;
                        j2 = j;
                    } else {
                        j2 = j;
                        map2 = map;
                        z2 = false;
                    }
                    zzd2.zzm(j2, z2, str2, map2);
                    i++;
                    j = j2;
                    map = map2;
                }
                Map map3 = map;
                if (equals) {
                    SpannableStringBuilder zzi3 = zzi(str2, map3);
                    int length = zzi3.length();
                    do {
                        length--;
                        if (length < 0 || zzi3.charAt(length) != ' ') {
                            if (length >= 0 && zzi3.charAt(length) != 10) {
                                zzi3.append(10);
                            }
                        }
                        length--;
                        break;
                    } while (zzi3.charAt(length) != ' ');
                    zzi3.append(10);
                }
                for (Map.Entry entry2 : map3.entrySet()) {
                    CharSequence zzq2 = ((zzcr) entry2.getValue()).zzq();
                    zzq2.getClass();
                    CharSequence charSequence2 = zzq2;
                    this.zzl.put((String) entry2.getKey(), Integer.valueOf(zzq2.length()));
                }
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzalf zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzalf) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        zzk(j, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        long j2 = j;
        zzm(j2, false, this.zzg, treeMap);
        Map map4 = map2;
        TreeMap treeMap2 = treeMap;
        zzl(j2, map, map4, this.zzg, treeMap2);
        TreeMap treeMap3 = treeMap2;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                zzalj zzalj = (zzalj) map4.get(pair.first);
                zzalj.getClass();
                zzalj zzalj2 = zzalj;
                zzcr zzcr = new zzcr();
                zzcr.zzc(decodeByteArray);
                zzcr.zzh(zzalj.zzb);
                zzcr.zzi(0);
                zzcr.zze(zzalj.zzc, 0);
                zzcr.zzf(zzalj.zze);
                zzcr.zzk(zzalj.zzf);
                zzcr.zzd(zzalj.zzg);
                zzcr.zzo(zzalj.zzj);
                arrayList2.add(zzcr.zzp());
            }
        }
        for (Map.Entry entry : treeMap3.entrySet()) {
            zzalj zzalj3 = (zzalj) map4.get(entry.getKey());
            zzalj3.getClass();
            zzalj zzalj4 = zzalj3;
            zzcr zzcr2 = (zzcr) entry.getValue();
            CharSequence zzq = zzcr2.zzq();
            zzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzq;
            for (zzald zzald : (zzald[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzald.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzald), spannableStringBuilder.getSpanEnd(zzald), "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == 10 && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == 10) {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcr2.zze(zzalj3.zzc, zzalj3.zzd);
            zzcr2.zzf(zzalj3.zze);
            zzcr2.zzh(zzalj3.zzb);
            zzcr2.zzk(zzalj3.zzf);
            zzcr2.zzn(zzalj3.zzi, zzalj3.zzh);
            zzcr2.zzo(zzalj3.zzj);
            arrayList2.add(zzcr2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzalf zzalf) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzalf);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i <= 0 && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return i <= 0 && j < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private zzalf(String str, String str2, long j, long j2, zzall zzall, String[] strArr, String str3, String str4, zzalf zzalf) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzall;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        String str5 = str3;
        this.zzg = str3;
        this.zzi = zzalf;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }
}
