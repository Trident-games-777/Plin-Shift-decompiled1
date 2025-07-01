package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import coil3.util.UtilsKt;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaiv {
    public static zzbc zza(zzed zzed) {
        String str;
        zzbc zzafx;
        int zzd = zzed.zzd() + zzed.zzg();
        int zzg = zzed.zzg();
        int i = (zzg >> 24) & 255;
        zzbc zzbc = null;
        if (i == 169 || i == 253) {
            int i2 = zzg & ViewCompat.MEASURED_SIZE_MASK;
            if (i2 == 6516084) {
                int zzg2 = zzed.zzg();
                if (zzed.zzg() == 1684108385) {
                    zzed.zzM(8);
                    String zzA = zzed.zzA(zzg2 - 16);
                    zzbc = new zzagf("und", zzA, zzA);
                } else {
                    zzdt.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzev.zze(zzg)));
                }
            } else {
                if (i2 != 7233901) {
                    if (i2 != 7631467) {
                        if (i2 != 6516589) {
                            if (i2 != 7828084) {
                                if (i2 == 6578553) {
                                    zzbc = zze(zzg, "TDRC", zzed);
                                } else if (i2 == 4280916) {
                                    zzbc = zze(zzg, "TPE1", zzed);
                                } else if (i2 == 7630703) {
                                    zzbc = zze(zzg, "TSSE", zzed);
                                } else if (i2 == 6384738) {
                                    zzbc = zze(zzg, "TALB", zzed);
                                } else if (i2 == 7108978) {
                                    zzbc = zze(zzg, "USLT", zzed);
                                } else if (i2 == 6776174) {
                                    zzbc = zze(zzg, "TCON", zzed);
                                } else if (i2 == 6779504) {
                                    zzbc = zze(zzg, "TIT1", zzed);
                                }
                            }
                        }
                        zzbc = zze(zzg, "TCOM", zzed);
                    }
                }
                zzbc = zze(zzg, "TIT2", zzed);
            }
            return zzbc;
        }
        if (zzg == 1735291493) {
            try {
                String zza = zzagm.zza(zzb(zzed) - 1);
                if (zza != null) {
                    zzafx = new zzagu("TCON", (String) null, zzfzo.zzo(zza));
                } else {
                    zzdt.zzf("MetadataUtil", "Failed to parse standard genre code");
                    return zzbc;
                }
            } finally {
                zzed.zzL(zzd);
            }
        } else {
            if (zzg == 1684632427) {
                zzbc = zzd(1684632427, "TPOS", zzed);
            } else if (zzg == 1953655662) {
                zzbc = zzd(1953655662, "TRCK", zzed);
            } else if (zzg == 1953329263) {
                zzbc = zzc(1953329263, "TBPM", zzed, true, false);
            } else if (zzg == 1668311404) {
                zzbc = zzc(1668311404, "TCMP", zzed, true, true);
            } else if (zzg == 1668249202) {
                int zzg3 = zzed.zzg();
                if (zzed.zzg() == 1684108385) {
                    int zzg4 = zzed.zzg();
                    int i3 = zzain.zza;
                    int i4 = zzg4 & ViewCompat.MEASURED_SIZE_MASK;
                    if (i4 == 13) {
                        str = UtilsKt.MIME_TYPE_JPEG;
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzdt.zzf("MetadataUtil", "Unrecognized cover art flags: " + i4);
                    } else {
                        zzed.zzM(4);
                        int i5 = zzg3 - 16;
                        byte[] bArr = new byte[i5];
                        zzed.zzH(bArr, 0, i5);
                        zzafx = new zzafx(str, (String) null, 3, bArr);
                    }
                } else {
                    zzdt.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (zzg == 1631670868) {
                zzbc = zze(1631670868, "TPE2", zzed);
            } else if (zzg == 1936682605) {
                zzbc = zze(1936682605, "TSOT", zzed);
            } else if (zzg == 1936679276) {
                zzbc = zze(1936679276, "TSOA", zzed);
            } else if (zzg == 1936679282) {
                zzbc = zze(1936679282, "TSOP", zzed);
            } else if (zzg == 1936679265) {
                zzbc = zze(1936679265, "TSO2", zzed);
            } else if (zzg == 1936679791) {
                zzbc = zze(1936679791, "TSOC", zzed);
            } else if (zzg == 1920233063) {
                zzbc = zzc(1920233063, "ITUNESADVISORY", zzed, false, false);
            } else if (zzg == 1885823344) {
                zzbc = zzc(1885823344, "ITUNESGAPLESS", zzed, false, true);
            } else if (zzg == 1936683886) {
                zzbc = zze(1936683886, "TVSHOWSORT", zzed);
            } else if (zzg == 1953919848) {
                zzbc = zze(1953919848, "TVSHOW", zzed);
            } else if (zzg == 757935405) {
                int i6 = -1;
                int i7 = -1;
                String str2 = null;
                String str3 = null;
                while (zzed.zzd() < zzd) {
                    int zzd2 = zzed.zzd();
                    int zzg5 = zzed.zzg();
                    int zzg6 = zzed.zzg();
                    zzed.zzM(4);
                    if (zzg6 == 1835360622) {
                        str2 = zzed.zzA(zzg5 - 12);
                    } else {
                        int i8 = zzg5 - 12;
                        if (zzg6 == 1851878757) {
                            str3 = zzed.zzA(i8);
                        } else {
                            if (zzg6 == 1684108385) {
                                i7 = zzg5;
                            }
                            if (zzg6 == 1684108385) {
                                i6 = zzd2;
                            }
                            zzed.zzM(i8);
                        }
                    }
                }
                if (!(str2 == null || str3 == null)) {
                    if (i6 != -1) {
                        zzed.zzL(i6);
                        zzed.zzM(16);
                        zzbc = new zzago(str2, str3, zzed.zzA(i7 - 16));
                    }
                }
            }
            return zzbc;
        }
        zzbc = zzafx;
        return zzbc;
        zzdt.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzev.zze(zzg));
        return zzbc;
    }

    private static int zzb(zzed zzed) {
        int zzg = zzed.zzg();
        if (zzed.zzg() == 1684108385) {
            zzed.zzM(8);
            int i = zzg - 16;
            if (i == 1) {
                return zzed.zzm();
            }
            if (i == 2) {
                return zzed.zzq();
            }
            if (i == 3) {
                return zzed.zzo();
            }
            if (i == 4 && (zzed.zzf() & 128) == 0) {
                return zzed.zzp();
            }
        }
        zzdt.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzagl zzc(int i, String str, zzed zzed, boolean z, boolean z2) {
        int zzb = zzb(zzed);
        if (z2) {
            zzb = Math.min(1, zzb);
        }
        if (zzb < 0) {
            zzdt.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzev.zze(i)));
            return null;
        } else if (z) {
            return new zzagu(str, (String) null, zzfzo.zzo(Integer.toString(zzb)));
        } else {
            return new zzagf("und", str, Integer.toString(zzb));
        }
    }

    private static zzagu zzd(int i, String str, zzed zzed) {
        int zzg = zzed.zzg();
        if (zzed.zzg() == 1684108385 && zzg >= 22) {
            zzed.zzM(10);
            int zzq = zzed.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzed.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + RemoteSettings.FORWARD_SLASH_STRING + zzq2;
                }
                return new zzagu(str, (String) null, zzfzo.zzo(sb2));
            }
        }
        zzdt.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzev.zze(i)));
        return null;
    }

    private static zzagu zze(int i, String str, zzed zzed) {
        int zzg = zzed.zzg();
        if (zzed.zzg() == 1684108385) {
            zzed.zzM(8);
            return new zzagu(str, (String) null, zzfzo.zzo(zzed.zzA(zzg - 16)));
        }
        zzdt.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzev.zze(i)));
        return null;
    }
}
