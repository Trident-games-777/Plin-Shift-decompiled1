package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.nio.ByteBuffer;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzabr {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, LocationRequestCompat.QUALITY_LOW_POWER, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static zzad zzc(zzed zzed, String str, String str2, zzw zzw) {
        zzec zzec = new zzec();
        zzec.zzj(zzed);
        int i = zzc[zzec.zzd(2)];
        zzec.zzn(8);
        int i2 = zze[zzec.zzd(3)];
        if (zzec.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzec.zzd(5)] * 1000;
        zzec.zzf();
        zzed.zzL(zzec.zzb());
        zzab zzab = new zzab();
        zzab.zzL(str);
        zzab.zzZ("audio/ac3");
        zzab.zzz(i2);
        zzab.zzaa(i);
        zzab.zzF(zzw);
        zzab.zzP(str2);
        zzab.zzy(i3);
        zzab.zzU(i3);
        return zzab.zzaf();
    }

    public static zzad zzd(zzed zzed, String str, String str2, zzw zzw) {
        String str3;
        zzec zzec = new zzec();
        zzec.zzj(zzed);
        int zzd2 = zzec.zzd(13) * 1000;
        zzec.zzn(3);
        int i = zzc[zzec.zzd(2)];
        zzec.zzn(10);
        int i2 = zze[zzec.zzd(3)];
        if (zzec.zzd(1) != 0) {
            i2++;
        }
        zzec.zzn(3);
        int zzd3 = zzec.zzd(4);
        zzec.zzn(1);
        if (zzd3 > 0) {
            zzec.zzn(6);
            if (zzec.zzd(1) != 0) {
                i2 += 2;
            }
            zzec.zzn(1);
        }
        if (zzec.zza() > 7) {
            zzec.zzn(7);
            if (zzec.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzec.zzf();
                zzed.zzL(zzec.zzb());
                zzab zzab = new zzab();
                zzab.zzL(str);
                zzab.zzZ(str3);
                zzab.zzz(i2);
                zzab.zzaa(i);
                zzab.zzF(zzw);
                zzab.zzP(str2);
                zzab.zzU(zzd2);
                return zzab.zzaf();
            }
        }
        str3 = "audio/eac3";
        zzec.zzf();
        zzed.zzL(zzec.zzb());
        zzab zzab2 = new zzab();
        zzab2.zzL(str);
        zzab2.zzZ(str3);
        zzab2.zzz(i2);
        zzab2.zzaa(i);
        zzab2.zzF(zzw);
        zzab2.zzP(str2);
        zzab2.zzU(zzd2);
        return zzab2.zzaf();
    }

    public static zzabp zze(zzec zzec) {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        String str2;
        int i6;
        int i7;
        int i8;
        int i9;
        zzec zzec2 = zzec;
        int zzc2 = zzec2.zzc();
        zzec2.zzn(40);
        int zzd2 = zzec2.zzd(5);
        zzec2.zzl(zzc2);
        int i10 = -1;
        if (zzd2 > 10) {
            zzec2.zzn(16);
            int zzd3 = zzec2.zzd(2);
            if (zzd3 == 0) {
                i10 = 0;
            } else if (zzd3 == 1) {
                i10 = 1;
            } else if (zzd3 == 2) {
                i10 = 2;
            }
            zzec2.zzn(3);
            int zzd4 = zzec2.zzd(11) + 1;
            int zzd5 = zzec2.zzd(2);
            if (zzd5 == 3) {
                i4 = zzd[zzec2.zzd(2)];
                i6 = 6;
                i7 = 3;
            } else {
                int zzd6 = zzec2.zzd(2);
                int i11 = zzb[zzd6];
                i7 = zzd6;
                i4 = zzc[zzd5];
                i6 = i11;
            }
            i5 = zzd4 + zzd4;
            int i12 = (i5 * i4) / (i6 * 32);
            int zzd7 = zzec2.zzd(3);
            boolean zzp = zzec2.zzp();
            i2 = zze[zzd7] + (zzp ? 1 : 0);
            zzec2.zzn(10);
            if (zzec2.zzp()) {
                zzec2.zzn(8);
            }
            if (zzd7 == 0) {
                zzec2.zzn(5);
                if (zzec2.zzp()) {
                    zzec2.zzn(8);
                }
                i8 = 0;
                zzd7 = 0;
            } else {
                i8 = zzd7;
            }
            if (i10 == 1) {
                if (zzec2.zzp()) {
                    zzec2.zzn(16);
                }
                i9 = 1;
            } else {
                i9 = i10;
            }
            if (zzec2.zzp()) {
                if (i8 > 2) {
                    zzec2.zzn(2);
                }
                if ((i8 & 1) != 0 && i8 > 2) {
                    zzec2.zzn(6);
                }
                if ((i8 & 4) != 0) {
                    zzec2.zzn(6);
                }
                if (zzp && zzec2.zzp()) {
                    zzec2.zzn(5);
                }
                if (i9 == 0) {
                    if (zzec2.zzp()) {
                        zzec2.zzn(6);
                    }
                    if (i8 == 0 && zzec2.zzp()) {
                        zzec2.zzn(6);
                    }
                    if (zzec2.zzp()) {
                        zzec2.zzn(6);
                    }
                    int zzd8 = zzec2.zzd(2);
                    if (zzd8 == 1) {
                        zzec2.zzn(5);
                    } else if (zzd8 == 2) {
                        zzec2.zzn(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzec2.zzd(5);
                        if (zzec2.zzp()) {
                            zzec2.zzn(5);
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(4);
                            }
                            if (zzec2.zzp()) {
                                if (zzec2.zzp()) {
                                    zzec2.zzn(4);
                                }
                                if (zzec2.zzp()) {
                                    zzec2.zzn(4);
                                }
                            }
                        }
                        if (zzec2.zzp()) {
                            zzec2.zzn(5);
                            if (zzec2.zzp()) {
                                zzec2.zzn(7);
                                if (zzec2.zzp()) {
                                    zzec2.zzn(8);
                                }
                            }
                        }
                        zzec2.zzn((zzd9 + 2) * 8);
                        zzec2.zzf();
                    }
                    if (i8 < 2) {
                        if (zzec2.zzp()) {
                            zzec2.zzn(14);
                        }
                        if (zzd7 == 0 && zzec2.zzp()) {
                            zzec2.zzn(14);
                        }
                    }
                    if (zzec2.zzp()) {
                        if (i7 == 0) {
                            zzec2.zzn(5);
                            i9 = 0;
                            i7 = 0;
                        } else {
                            for (int i13 = 0; i13 < i6; i13++) {
                                if (zzec2.zzp()) {
                                    zzec2.zzn(5);
                                }
                            }
                        }
                    }
                    i9 = 0;
                }
            }
            if (zzec2.zzp()) {
                zzec2.zzn(5);
                if (i8 == 2) {
                    zzec2.zzn(4);
                    i8 = 2;
                }
                if (i8 >= 6) {
                    zzec2.zzn(2);
                }
                if (zzec2.zzp()) {
                    zzec2.zzn(8);
                }
                if (i8 == 0 && zzec2.zzp()) {
                    zzec2.zzn(8);
                }
                if (zzd5 < 3) {
                    zzec2.zzm();
                }
            }
            if (i9 == 0 && i7 != 3) {
                zzec2.zzm();
            }
            if (i9 == 2 && (i7 == 3 || zzec2.zzp())) {
                zzec2.zzn(6);
            }
            i3 = i6 * 256;
            str = (zzec2.zzp() && zzec2.zzd(6) == 1 && zzec2.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i = i12;
        } else {
            zzec2.zzn(32);
            int zzd10 = zzec2.zzd(2);
            if (zzd10 == 3) {
                str2 = null;
            } else {
                str2 = "audio/ac3";
            }
            int zzd11 = zzec2.zzd(6);
            int i14 = zzf[zzd11 / 2] * 1000;
            i5 = zzf(zzd10, zzd11);
            zzec2.zzn(8);
            int zzd12 = zzec2.zzd(3);
            if (!((zzd12 & 1) == 0 || zzd12 == 1)) {
                zzec2.zzn(2);
            }
            if ((zzd12 & 4) != 0) {
                zzec2.zzn(2);
            }
            if (zzd12 == 2) {
                zzec2.zzn(2);
            }
            i4 = zzd10 < 3 ? zzc[zzd10] : -1;
            i2 = zze[zzd12] + (zzec2.zzp() ? 1 : 0);
            i3 = 1536;
            str = str2;
            i = i14;
        }
        return new zzabp(str, i10, i2, i4, i5, i3, i, (zzabq) null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
