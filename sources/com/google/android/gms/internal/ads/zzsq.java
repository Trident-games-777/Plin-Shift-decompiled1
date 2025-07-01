package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzsq {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    private final boolean zzi;

    public static zzsq zzc(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        MediaCodecInfo.CodecCapabilities codecCapabilities2;
        String str4;
        String str5;
        String str6;
        boolean z10 = codecCapabilities != null && codecCapabilities.isFeatureSupported("adaptive-playback") && (zzen.zza > 22 || ((!"ODROID-XU3".equals(zzen.zzd) && !"Nexus 10".equals(zzen.zzd)) || (!"OMX.Exynos.AVC.Decoder".equals(str) && !"OMX.Exynos.AVC.Decoder.secure".equals(str))));
        boolean z11 = codecCapabilities != null && codecCapabilities.isFeatureSupported("tunneled-playback");
        boolean z12 = z5 || (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback"));
        if (zzen.zza < 35 || codecCapabilities == null || !codecCapabilities.isFeatureSupported("detached-surface")) {
            str6 = str;
            str4 = str3;
            codecCapabilities2 = codecCapabilities;
            z9 = z;
            z8 = z2;
            z7 = z3;
            z6 = false;
            str5 = str2;
        } else {
            str5 = str2;
            str4 = str3;
            codecCapabilities2 = codecCapabilities;
            z9 = z;
            z8 = z2;
            z7 = z3;
            z6 = true;
            str6 = str;
        }
        return new zzsq(str6, str5, str4, codecCapabilities2, z9, z8, z7, z10, z11, z12, z6);
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzen.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = zzen.zze;
        zzdt.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + str2 + "]");
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point zzi2 = zzi(videoCapabilities, i, i2);
        int i3 = zzi2.x;
        int i4 = zzi2.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r4 = r4.getVideoCapabilities();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzl(com.google.android.gms.internal.ads.zzad r12, boolean r13) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.internal.ads.zztl.zza
            android.util.Pair r0 = com.google.android.gms.internal.ads.zzdd.zza(r12)
            java.lang.String r1 = r12.zzo
            java.lang.String r2 = "video/hevc"
            if (r1 == 0) goto L_0x0039
            java.lang.String r3 = "video/mv-hevc"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = r11.zzc
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0039
            java.util.List r0 = r12.zzr
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfp.zzg(r0)
            if (r0 != 0) goto L_0x0026
            r0 = 0
            goto L_0x0039
        L_0x0026:
            java.lang.String r1 = r0.trim()
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            java.lang.String r3 = "\\."
            r4 = -1
            java.lang.String[] r1 = r1.split(r3, r4)
            com.google.android.gms.internal.ads.zzm r3 = r12.zzB
            android.util.Pair r0 = com.google.android.gms.internal.ads.zzdd.zzb(r0, r1, r3)
        L_0x0039:
            r1 = 1
            if (r0 != 0) goto L_0x003e
            goto L_0x0137
        L_0x003e:
            java.lang.Object r3 = r0.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r4 = r12.zzo
            java.lang.String r5 = "video/dolby-vision"
            boolean r4 = r5.equals(r4)
            r5 = 8
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = r11.zzb
            java.lang.String r8 = "video/avc"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0069
            r3 = r5
        L_0x0067:
            r0 = r7
            goto L_0x0073
        L_0x0069:
            java.lang.String r4 = r11.zzb
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0073
            r3 = r6
            goto L_0x0067
        L_0x0073:
            boolean r4 = r11.zzi
            if (r4 != 0) goto L_0x007c
            r4 = 42
            if (r3 != r4) goto L_0x0137
            r3 = r4
        L_0x007c:
            android.media.MediaCodecInfo$CodecProfileLevel[] r4 = r11.zzh()
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            r9 = 23
            if (r8 > r9) goto L_0x0108
            java.lang.String r8 = r11.zzb
            java.lang.String r9 = "video/x-vnd.on2.vp9"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x0108
            int r8 = r4.length
            if (r8 != 0) goto L_0x0108
            android.media.MediaCodecInfo$CodecCapabilities r4 = r11.zzd
            if (r4 == 0) goto L_0x00ac
            android.media.MediaCodecInfo$VideoCapabilities r4 = r4.getVideoCapabilities()
            if (r4 == 0) goto L_0x00ac
            android.util.Range r4 = r4.getBitrateRange()
            java.lang.Comparable r4 = r4.getUpper()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            goto L_0x00ad
        L_0x00ac:
            r4 = r7
        L_0x00ad:
            r8 = 180000000(0xaba9500, float:1.7967196E-32)
            if (r4 < r8) goto L_0x00b5
            r5 = 1024(0x400, float:1.435E-42)
            goto L_0x00fa
        L_0x00b5:
            r8 = 120000000(0x7270e00, float:1.2567798E-34)
            if (r4 < r8) goto L_0x00bd
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x00fa
        L_0x00bd:
            r8 = 60000000(0x3938700, float:8.670878E-37)
            if (r4 < r8) goto L_0x00c5
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x00fa
        L_0x00c5:
            r8 = 30000000(0x1c9c380, float:7.411627E-38)
            if (r4 < r8) goto L_0x00cd
            r5 = 128(0x80, float:1.794E-43)
            goto L_0x00fa
        L_0x00cd:
            r8 = 18000000(0x112a880, float:2.6936858E-38)
            if (r4 < r8) goto L_0x00d5
            r5 = 64
            goto L_0x00fa
        L_0x00d5:
            r8 = 12000000(0xb71b00, float:1.6815582E-38)
            if (r4 < r8) goto L_0x00dd
            r5 = 32
            goto L_0x00fa
        L_0x00dd:
            r8 = 7200000(0x6ddd00, float:1.0089349E-38)
            if (r4 < r8) goto L_0x00e5
            r5 = 16
            goto L_0x00fa
        L_0x00e5:
            r8 = 3600000(0x36ee80, float:5.044674E-39)
            if (r4 < r8) goto L_0x00eb
            goto L_0x00fa
        L_0x00eb:
            r5 = 1800000(0x1b7740, float:2.522337E-39)
            if (r4 < r5) goto L_0x00f2
            r5 = 4
            goto L_0x00fa
        L_0x00f2:
            r5 = 800000(0xc3500, float:1.121039E-39)
            if (r4 < r5) goto L_0x00f9
            r5 = r6
            goto L_0x00fa
        L_0x00f9:
            r5 = r1
        L_0x00fa:
            android.media.MediaCodecInfo$CodecProfileLevel r4 = new android.media.MediaCodecInfo$CodecProfileLevel
            r4.<init>()
            r4.profile = r1
            r4.level = r5
            android.media.MediaCodecInfo$CodecProfileLevel[] r5 = new android.media.MediaCodecInfo.CodecProfileLevel[r1]
            r5[r7] = r4
            r4 = r5
        L_0x0108:
            int r5 = r4.length
            r8 = r7
        L_0x010a:
            if (r8 >= r5) goto L_0x013b
            r9 = r4[r8]
            int r10 = r9.profile
            if (r10 != r3) goto L_0x0138
            int r9 = r9.level
            if (r9 >= r0) goto L_0x0118
            if (r13 != 0) goto L_0x0138
        L_0x0118:
            java.lang.String r9 = r11.zzb
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L_0x0137
            if (r3 != r6) goto L_0x0137
            java.lang.String r9 = "sailfish"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0138
            java.lang.String r9 = "marlin"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            return r1
        L_0x0138:
            int r8 = r8 + 1
            goto L_0x010a
        L_0x013b:
            java.lang.String r12 = r12.zzk
            java.lang.String r13 = r11.zzc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "codec.profileLevel, "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = ", "
            r0.append(r12)
            r0.append(r13)
            java.lang.String r12 = r0.toString()
            r11.zzj(r12)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsq.zzl(com.google.android.gms.internal.ads.zzad, boolean):boolean");
    }

    private final boolean zzm(zzad zzad) {
        return this.zzb.equals(zzad.zzo) || this.zzb.equals(zztl.zzb(zzad));
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zzhy zzb(zzad zzad, zzad zzad2) {
        zzad zzad3;
        zzad zzad4;
        int i = true != Objects.equals(zzad.zzo, zzad2.zzo) ? 8 : 0;
        if (this.zzi) {
            if (zzad.zzx != zzad2.zzx) {
                i |= 1024;
            }
            if (!this.zze && !(zzad.zzu == zzad2.zzu && zzad.zzv == zzad2.zzv)) {
                i |= 512;
            }
            if ((!zzm.zzg(zzad.zzB) || !zzm.zzg(zzad2.zzB)) && !Objects.equals(zzad.zzB, zzad2.zzB)) {
                i |= 2048;
            }
            String str = this.zza;
            if (zzen.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzad.zzd(zzad2)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzhy(this.zza, zzad, zzad2, true != zzad.zzd(zzad2) ? 2 : 3, 0);
            }
            zzad3 = zzad;
            zzad4 = zzad2;
        } else {
            zzad3 = zzad;
            zzad4 = zzad2;
            if (zzad3.zzC != zzad4.zzC) {
                i |= 4096;
            }
            if (zzad3.zzD != zzad4.zzD) {
                i |= 8192;
            }
            if (zzad3.zzE != zzad4.zzE) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                int i2 = zztl.zza;
                Pair zza2 = zzdd.zza(zzad3);
                Pair zza3 = zzdd.zza(zzad4);
                if (!(zza2 == null || zza3 == null)) {
                    int intValue = ((Integer) zza2.first).intValue();
                    int intValue2 = ((Integer) zza3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzhy(this.zza, zzad3, zzad4, 3, 0);
                    }
                }
            }
            if (!zzad3.zzd(zzad4)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzhy(this.zza, zzad3, zzad4, 1, 0);
            }
        }
        return new zzhy(this.zza, zzad3, zzad4, 0, i);
    }

    public final boolean zzd(zzad zzad) {
        if (!zzm(zzad) || !zzl(zzad, false)) {
            return false;
        }
        return true;
    }

    public final boolean zze(zzad zzad) throws zztf {
        int i;
        int i2;
        if (!zzm(zzad) || !zzl(zzad, true)) {
            return false;
        }
        if (this.zzi) {
            int i3 = zzad.zzu;
            if (i3 <= 0 || (i2 = zzad.zzv) <= 0) {
                return true;
            }
            return zzg(i3, i2, (double) zzad.zzw);
        }
        int i4 = zzad.zzD;
        if (i4 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            } else if (!audioCapabilities.isSampleRateSupported(i4)) {
                zzj("sampleRate.support, " + i4);
                return false;
            }
        }
        int i5 = zzad.zzC;
        if (i5 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
            if (audioCapabilities2 == null) {
                zzj("channelCount.aCaps");
                return false;
            }
            String str = this.zza;
            String str2 = this.zzb;
            int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
            if (maxInputChannelCount <= 1 && ((zzen.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                if ("audio/ac3".equals(str2)) {
                    i = 6;
                } else {
                    i = "audio/eac3".equals(str2) ? 16 : 30;
                }
                zzdt.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + "]");
                maxInputChannelCount = i;
            }
            if (maxInputChannelCount < i5) {
                zzj("channelCount.support, " + i5);
                return false;
            }
        }
        return true;
    }

    public final boolean zzf(zzad zzad) {
        if (this.zzi) {
            return this.zze;
        }
        int i = zztl.zza;
        Pair zza2 = zzdd.zza(zzad);
        return zza2 != null && ((Integer) zza2.first).intValue() == 42;
    }

    public final boolean zzg(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzen.zza >= 29) {
            int zza2 = zzss.zza(videoCapabilities, i, i2, d);
            if (zza2 != 2) {
                if (zza2 == 1) {
                    zzj("sizeAndRate.cover, " + i + "x" + i2 + "@" + d);
                    return false;
                }
            }
            return true;
        }
        if (!zzk(videoCapabilities, i, i2, d)) {
            if (i >= i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzen.zzb)) || !zzk(videoCapabilities, i2, i, d))) {
                zzj("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                return false;
            }
            zzdt.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "@" + d) + "] [" + this.zza + ", " + this.zzb + "] [" + zzen.zze + "]");
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.zzd.profileLevels;
    }

    zzsq(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        str.getClass();
        String str4 = str;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = z7;
        this.zzi = zzbg.zzi(str2);
    }
}
