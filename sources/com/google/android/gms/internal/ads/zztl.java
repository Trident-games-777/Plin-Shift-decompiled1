package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zztl {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzsq zza() throws zztf {
        List zzd = zzd("audio/raw", false, false);
        if (zzd.isEmpty()) {
            return null;
        }
        return (zzsq) zzd.get(0);
    }

    public static String zzb(zzad zzad) {
        Pair zza2;
        if ("audio/eac3-joc".equals(zzad.zzo)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(zzad.zzo) && (zza2 = zzdd.zza(zzad)) != null) {
            int intValue = ((Integer) zza2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                return "video/hevc";
            }
            if (intValue == 512) {
                return "video/avc";
            }
            if (intValue == 1024) {
                return "video/av01";
            }
        }
        if (!"video/mv-hevc".equals(zzad.zzo)) {
            return null;
        }
        return "video/hevc";
    }

    public static List zzc(zzta zzta, zzad zzad, boolean z, boolean z2) throws zztf {
        String zzb2 = zzb(zzad);
        if (zzb2 == null) {
            return zzfzo.zzn();
        }
        return zzta.zza(zzb2, z, z2);
    }

    public static synchronized List zzd(String str, boolean z, boolean z2) throws zztf {
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (zztl.class) {
            zzte zzte = new zzte(str2, z3, z4);
            HashMap hashMap = zzb;
            List list = (List) hashMap.get(zzte);
            if (list != null) {
                return list;
            }
            ArrayList zzg = zzg(zzte, new zzti(z3, z4));
            if (z3 && zzg.isEmpty() && zzen.zza <= 23) {
                zzg = zzg(zzte, new zzth((zztk) null));
                if (!zzg.isEmpty()) {
                    String str3 = ((zzsq) zzg.get(0)).zza;
                    zzdt.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str2 + ". Assuming: " + str3);
                }
            }
            if ("audio/raw".equals(str2)) {
                if (zzen.zza < 26 && zzen.zzb.equals("R9") && zzg.size() == 1 && ((zzsq) zzg.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzg.add(zzsq.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzh(zzg, new zztc());
            }
            if (zzen.zza < 32 && zzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsq) zzg.get(0)).zza)) {
                zzg.add((zzsq) zzg.remove(0));
            }
            zzfzo zzl = zzfzo.zzl(zzg);
            hashMap.put(zzte, zzl);
            return zzl;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zze(zzta zzta, zzad zzad, boolean z, boolean z2) throws zztf {
        List zza2 = zzta.zza(zzad.zzo, z, z2);
        List zzc = zzc(zzta, zzad, z, z2);
        zzfzl zzfzl = new zzfzl();
        zzfzl.zzh(zza2);
        zzfzl.zzh(zzc);
        return zzfzl.zzi();
    }

    public static List zzf(List list, zzad zzad) {
        ArrayList arrayList = new ArrayList(list);
        zzh(arrayList, new zztd(zzad));
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: int} */
    /* JADX WARNING: type inference failed for: r5v37 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01e0, code lost:
        if (r1.zzb == false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r7.endsWith(".secure") == false) goto L_0x0046;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x018d A[Catch:{ Exception -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0193 A[Catch:{ Exception -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ab A[Catch:{ Exception -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b0 A[Catch:{ Exception -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01de A[SYNTHETIC, Splitter:B:122:0x01de] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x023e A[SYNTHETIC, Splitter:B:147:0x023e] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0180 A[Catch:{ Exception -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0183 A[Catch:{ Exception -> 0x022f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzg(com.google.android.gms.internal.ads.zzte r22, com.google.android.gms.internal.ads.zztg r23) throws com.google.android.gms.internal.ads.zztf {
        /*
            r1 = r22
            r2 = r23
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0290 }
            r6.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r8 = r1.zza     // Catch:{ Exception -> 0x0290 }
            int r7 = r2.zza()     // Catch:{ Exception -> 0x0290 }
            boolean r16 = r2.zze()     // Catch:{ Exception -> 0x0290 }
            r17 = 0
            r9 = r17
        L_0x001b:
            if (r9 >= r7) goto L_0x028f
            android.media.MediaCodecInfo r0 = r2.zzb(r9)     // Catch:{ Exception -> 0x0290 }
            int r10 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0290 }
            r11 = 29
            if (r10 < r11) goto L_0x0031
            boolean r10 = r0.isAlias()     // Catch:{ Exception -> 0x0290 }
            if (r10 == 0) goto L_0x0031
            r2 = r7
            r5 = r9
            goto L_0x0286
        L_0x0031:
            r10 = r7
            java.lang.String r7 = r0.getName()     // Catch:{ Exception -> 0x0290 }
            boolean r12 = r0.isEncoder()     // Catch:{ Exception -> 0x0290 }
            if (r12 != 0) goto L_0x0284
            java.lang.String r12 = ".secure"
            if (r16 != 0) goto L_0x0046
            boolean r13 = r7.endsWith(r12)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
        L_0x0046:
            int r13 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0290 }
            r14 = 24
            if (r13 >= r14) goto L_0x00b6
            java.lang.String r13 = "OMX.SEC.aac.dec"
            boolean r13 = r13.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x005c
            java.lang.String r13 = "OMX.Exynos.AAC.Decoder"
            boolean r13 = r13.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r13 == 0) goto L_0x00b6
        L_0x005c:
            java.lang.String r13 = "samsung"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 == 0) goto L_0x00b6
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "zeroflte"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "zerolte"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "zenlte"
            boolean r13 = r13.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = "SC-05G"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = "marinelteatt"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = "404SC"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = "SC-04G"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
            java.lang.String r13 = "SCV31"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
        L_0x00b6:
            int r13 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0290 }
            r14 = 23
            if (r13 > r14) goto L_0x00cc
            java.lang.String r13 = "audio/eac3-joc"
            boolean r13 = r13.equals(r8)     // Catch:{ Exception -> 0x0290 }
            if (r13 == 0) goto L_0x00cc
            java.lang.String r13 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r13 = r13.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r13 != 0) goto L_0x0284
        L_0x00cc:
            java.lang.String[] r13 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x0290 }
            int r15 = r13.length     // Catch:{ Exception -> 0x0290 }
            r14 = r17
        L_0x00d3:
            if (r14 >= r15) goto L_0x00e2
            r5 = r13[r14]     // Catch:{ Exception -> 0x0290 }
            boolean r18 = r5.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0290 }
            if (r18 == 0) goto L_0x00df
            goto L_0x0155
        L_0x00df:
            int r14 = r14 + 1
            goto L_0x00d3
        L_0x00e2:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x0108
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x00f5
            java.lang.String r5 = "video/hevcdv"
            goto L_0x0155
        L_0x00f5:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 != 0) goto L_0x0105
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x011b
        L_0x0105:
            java.lang.String r5 = "video/dv_hevc"
            goto L_0x0155
        L_0x0108:
            java.lang.String r5 = "video/mv-hevc"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x011d
            java.lang.String r5 = "c2.qti.mvhevc.decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x011b
            java.lang.String r5 = "video/x-mvhevc"
            goto L_0x0155
        L_0x011b:
            r5 = 0
            goto L_0x0155
        L_0x011d:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x0130
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x0130
            java.lang.String r5 = "audio/x-lg-alac"
            goto L_0x0155
        L_0x0130:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x0143
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x0143
            java.lang.String r5 = "audio/x-lg-flac"
            goto L_0x0155
        L_0x0143:
            java.lang.String r5 = "audio/ac3"
            boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x011b
            java.lang.String r5 = "OMX.lge.ac3.decoder"
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x0290 }
            if (r5 == 0) goto L_0x011b
            java.lang.String r5 = "audio/lg-ac3"
        L_0x0155:
            if (r5 == 0) goto L_0x0284
            r13 = r10
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x022f }
            boolean r14 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x022f }
            boolean r15 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x022f }
            boolean r11 = r1.zzc     // Catch:{ Exception -> 0x022f }
            if (r11 != 0) goto L_0x016f
            if (r15 != 0) goto L_0x016b
            goto L_0x0172
        L_0x016b:
            r5 = r9
            r2 = r13
            goto L_0x0286
        L_0x016f:
            if (r14 != 0) goto L_0x0172
            goto L_0x016b
        L_0x0172:
            boolean r11 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x022f }
            boolean r14 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x022f }
            boolean r15 = r1.zzb     // Catch:{ Exception -> 0x022f }
            r19 = 1
            if (r15 != 0) goto L_0x0183
            if (r14 != 0) goto L_0x016b
            goto L_0x0187
        L_0x0183:
            if (r11 == 0) goto L_0x016b
            r11 = r19
        L_0x0187:
            int r14 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x022f }
            r15 = 29
            if (r14 < r15) goto L_0x0193
            boolean r14 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x022f }
            r15 = r12
            goto L_0x019f
        L_0x0193:
            boolean r14 = zzi(r0, r8)     // Catch:{ Exception -> 0x022f }
            r15 = r12
            if (r14 != 0) goto L_0x019d
            r14 = r19
            goto L_0x019f
        L_0x019d:
            r14 = r17
        L_0x019f:
            boolean r12 = zzi(r0, r8)     // Catch:{ Exception -> 0x022f }
            r20 = r0
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x022f }
            r2 = 29
            if (r0 < r2) goto L_0x01b0
            boolean r19 = r20.isVendor()     // Catch:{ Exception -> 0x022f }
            goto L_0x01d3
        L_0x01b0:
            java.lang.String r0 = r20.getName()     // Catch:{ Exception -> 0x022f }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfwa.zza(r0)     // Catch:{ Exception -> 0x022f }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x022f }
            if (r2 != 0) goto L_0x01d1
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x022f }
            if (r2 != 0) goto L_0x01d1
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x022f }
            if (r0 != 0) goto L_0x01d1
            goto L_0x01d3
        L_0x01d1:
            r19 = r17
        L_0x01d3:
            if (r16 == 0) goto L_0x01dc
            boolean r0 = r1.zzb     // Catch:{ Exception -> 0x022f }
            if (r0 == r11) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r11 = r14
            goto L_0x01e3
        L_0x01dc:
            if (r16 != 0) goto L_0x0202
            boolean r0 = r1.zzb     // Catch:{ Exception -> 0x01f8 }
            if (r0 != 0) goto L_0x0202
            goto L_0x01da
        L_0x01e3:
            r14 = 0
            r15 = 0
            r1 = r9
            r9 = r5
            r5 = r1
            r2 = r13
            r13 = r19
            r1 = 23
            com.google.android.gms.internal.ads.zzsq r0 = com.google.android.gms.internal.ads.zzsq.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x01f6 }
            r6.add(r0)     // Catch:{ Exception -> 0x01f6 }
            goto L_0x0286
        L_0x01f6:
            r0 = move-exception
            goto L_0x01ff
        L_0x01f8:
            r0 = move-exception
            r1 = r9
            r9 = r5
            r5 = r1
            r2 = r13
            r1 = 23
        L_0x01ff:
            r21 = r7
            goto L_0x0238
        L_0x0202:
            r1 = r9
            r9 = r5
            r5 = r1
            r2 = r13
            r13 = r19
            r1 = 23
            r19 = r11
            r11 = r14
            if (r16 != 0) goto L_0x0286
            if (r19 == 0) goto L_0x0286
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f6 }
            r0.<init>()     // Catch:{ Exception -> 0x01f6 }
            r0.append(r7)     // Catch:{ Exception -> 0x01f6 }
            r0.append(r15)     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01f6 }
            r14 = 0
            r15 = 1
            r21 = r7
            r7 = r0
            com.google.android.gms.internal.ads.zzsq r0 = com.google.android.gms.internal.ads.zzsq.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x022d }
            r6.add(r0)     // Catch:{ Exception -> 0x022d }
            goto L_0x028f
        L_0x022d:
            r0 = move-exception
            goto L_0x0238
        L_0x022f:
            r0 = move-exception
            r1 = r9
            r9 = r5
            r5 = r1
            r21 = r7
            r2 = r13
            r1 = 23
        L_0x0238:
            int r7 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0290 }
            java.lang.String r10 = "MediaCodecUtil"
            if (r7 > r1) goto L_0x0260
            boolean r1 = r6.isEmpty()     // Catch:{ Exception -> 0x0290 }
            if (r1 != 0) goto L_0x0260
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0290 }
            r0.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r1 = "Skipping codec "
            r0.append(r1)     // Catch:{ Exception -> 0x0290 }
            r7 = r21
            r0.append(r7)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0290 }
            com.google.android.gms.internal.ads.zzdt.zzc(r10, r0)     // Catch:{ Exception -> 0x0290 }
            goto L_0x0286
        L_0x0260:
            r7 = r21
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0290 }
            r1.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = "Failed to query codec "
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            r1.append(r7)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = " ("
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            r1.append(r9)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0290 }
            com.google.android.gms.internal.ads.zzdt.zzc(r10, r1)     // Catch:{ Exception -> 0x0290 }
            throw r0     // Catch:{ Exception -> 0x0290 }
        L_0x0284:
            r5 = r9
            r2 = r10
        L_0x0286:
            int r9 = r5 + 1
            r1 = r22
            r7 = r2
            r2 = r23
            goto L_0x001b
        L_0x028f:
            return r6
        L_0x0290:
            r0 = move-exception
            com.google.android.gms.internal.ads.zztf r1 = new com.google.android.gms.internal.ads.zztf
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztl.zzg(com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zztg):java.util.ArrayList");
    }

    private static void zzh(List list, zztj zztj) {
        Collections.sort(list, new zztb(zztj));
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzen.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbg.zzg(str)) {
            return true;
        }
        String zza2 = zzfwa.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.") || ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google."))) {
            return true;
        }
        if (zza2.startsWith("omx.") || zza2.startsWith("c2.")) {
            return false;
        }
        return true;
    }
}
