package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.ComposerKt;
import androidx.core.location.LocationRequestCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzen {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf = new byte[0];
    private static final Pattern zzg = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
    private static HashMap zzh;
    private static final String[] zzi = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] zzj = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] zzk = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] zzl = {0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
    private static final int[] zzm = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, WebSocketProtocol.PAYLOAD_SHORT, 121, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, ComposerKt.compositionLocalMapKey, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, ComposerKt.providerKey, ComposerKt.referenceKey, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, LocationRequestCompat.QUALITY_LOW_POWER, 97, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, ComposerKt.reuseKey, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, MenuKt.InTransitionDuration, 127, 106, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, ComposerKt.providerMapsKey, ComposerKt.providerValuesKey, 230, 225, 232, 239, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 253, 244, 243};

    static {
        int i = Build.VERSION.SDK_INT;
        zza = i;
        String str = Build.DEVICE;
        zzb = str;
        String str2 = Build.MANUFACTURER;
        zzc = str2;
        String str3 = Build.MODEL;
        zzd = str3;
        zze = str + ", " + str3 + ", " + str2 + ", " + i;
    }

    public static zzad zzA(int i, int i2, int i3) {
        zzab zzab = new zzab();
        zzab.zzZ("audio/raw");
        zzab.zzz(i2);
        zzab.zzaa(i3);
        zzab.zzT(i);
        return zzab.zzaf();
    }

    public static String zzB(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String zzC(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, StandardCharsets.UTF_8);
    }

    public static String zzD(int i) {
        switch (i) {
            case -2:
                return "none";
            case -1:
                return EnvironmentCompat.MEDIA_UNKNOWN;
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            default:
                return "camera motion";
        }
    }

    public static String zzE(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String zza2 = zzfwa.zza(str);
        int i = 0;
        String str2 = zza2.split("-", 2)[0];
        if (zzh == null) {
            zzh = zzS();
        }
        String str3 = (String) zzh.get(str2);
        if (str3 != null) {
            zza2 = str3.concat(String.valueOf(zza2.substring(str2.length())));
            str2 = str3;
        }
        if ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) {
            while (true) {
                String[] strArr = zzj;
                int length = strArr.length;
                if (i >= 18) {
                    break;
                } else if (zza2.startsWith(strArr[i])) {
                    return String.valueOf(strArr[i + 1]).concat(String.valueOf(zza2.substring(strArr[i].length())));
                } else {
                    i += 2;
                }
            }
        }
        return zza2;
    }

    public static boolean zzG(SparseArray sparseArray, int i) {
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static boolean zzH(zzed zzed, zzed zzed2, Inflater inflater) {
        boolean z = false;
        if (zzed.zzb() <= 0) {
            return false;
        }
        if (zzed2.zzc() < zzed.zzb()) {
            int zzb2 = zzed.zzb();
            zzed2.zzF(zzb2 + zzb2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(zzed.zzN(), zzed.zzd(), zzed.zzb());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(zzed2.zzN(), i, zzed2.zzc() - i);
                if (inflater.finished()) {
                    zzed2.zzK(i);
                    z = true;
                    break;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i == zzed2.zzc()) {
                    int zzc2 = zzed2.zzc();
                    zzed2.zzF(zzc2 + zzc2);
                }
            } catch (DataFormatException unused) {
            } catch (Throwable th) {
                inflater.reset();
                throw th;
            }
        }
        inflater.reset();
        return z;
    }

    public static boolean zzI(Context context) {
        return zza >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static boolean zzJ(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4;
    }

    public static boolean zzK(Context context) {
        int i = zza;
        if (i < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i == 30) {
            String str = zzd;
            if (zzfwa.zzc(str, "moto g(20)") || zzfwa.zzc(str, "rmx3231")) {
                return true;
            }
        }
        if (i != 34 || !zzfwa.zzc(zzd, "sm-x200")) {
            return false;
        }
        return true;
    }

    public static boolean zzL(int i) {
        return i == 10 || i == 13;
    }

    public static boolean zzM(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean zzN(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Object[] zzO(Object[] objArr, int i) {
        zzdb.zzd(i <= objArr.length);
        return Arrays.copyOf(objArr, i);
    }

    private static int zzP(int i, int i2) {
        return (char) (zzl[i ^ (i2 >> 12)] ^ ((char) (i2 << 4)));
    }

    private static long zzQ(long j, long j2, long j3, RoundingMode roundingMode) {
        long zzd2 = zzgcm.zzd(j, j2);
        if (zzd2 != Long.MAX_VALUE && zzd2 != Long.MIN_VALUE) {
            return zzgcm.zzb(zzd2, j3, roundingMode);
        }
        long zzc2 = zzgcm.zzc(Math.abs(j2), Math.abs(j3));
        long zzb2 = zzgcm.zzb(j2, zzc2, RoundingMode.UNNECESSARY);
        long zzb3 = zzgcm.zzb(j3, zzc2, RoundingMode.UNNECESSARY);
        long zzc3 = zzgcm.zzc(Math.abs(j), Math.abs(zzb3));
        long zzb4 = zzgcm.zzb(j, zzc3, RoundingMode.UNNECESSARY);
        long zzb5 = zzgcm.zzb(zzb3, zzc3, RoundingMode.UNNECESSARY);
        long zzd3 = zzgcm.zzd(zzb4, zzb2);
        if (zzd3 != Long.MAX_VALUE && zzd3 != Long.MIN_VALUE) {
            return zzgcm.zzb(zzd3, zzb5, roundingMode);
        }
        double d = ((double) zzb4) * (((double) zzb2) / ((double) zzb5));
        if (d > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return zzgch.zzb(d, roundingMode);
    }

    private static String zzR(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            zzdt.zzd("Util", "Failed to read system property ".concat(str), e);
            return null;
        }
    }

    private static HashMap zzS() {
        int length = zzi.length;
        HashMap hashMap = new HashMap(r2 + 88);
        int i = 0;
        for (String str : Locale.getISOLanguages()) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zzi;
            int length2 = strArr.length;
            if (i >= 88) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r7 = java.util.Arrays.binarySearch(r3, r4)
            if (r7 >= 0) goto L_0x0008
            int r3 = ~r7
            return r3
        L_0x0008:
            int r0 = r7 + 1
            int r1 = r3.length
            if (r0 >= r1) goto L_0x0016
            r1 = r3[r0]
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r7 = r0
            goto L_0x0008
        L_0x0016:
            if (r6 != 0) goto L_0x0019
            return r0
        L_0x0019:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zza(long[], long, boolean, boolean):int");
    }

    public static int zzb(zzdu zzdu, long j, boolean z, boolean z2) {
        int zza2 = zzdu.zza() - 1;
        int i = 0;
        while (i <= zza2) {
            int i2 = (i + zza2) >>> 1;
            if (zzdu.zzb(i2) < j) {
                i = i2 + 1;
            } else {
                zza2 = i2 - 1;
            }
        }
        int i3 = zza2 + 1;
        if (i3 < zzdu.zza() && zzdu.zzb(i3) == j) {
            return i3;
        }
        if (zza2 == -1) {
            return 0;
        }
        return zza2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzc(int[] r3, int r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x001a
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x0015
            r2 = r3[r1]
            if (r2 == r4) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x000a
        L_0x0015:
            if (r5 == 0) goto L_0x0019
            r3 = r0
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            if (r6 == 0) goto L_0x0021
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0021:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzc(int[], int, boolean, boolean):int");
    }

    public static int zzd(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            while (true) {
                int i2 = binarySearch - 1;
                if (i2 < 0 || jArr[i2] != j) {
                    i = binarySearch;
                } else {
                    binarySearch = i2;
                }
            }
            i = binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = 65535;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = bArr[i5];
            i4 = zzP(b & Ascii.SI, zzP((b & 255) >> 4, i4));
        }
        return i4;
    }

    public static int zzf(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = zzk[(i3 >>> 24) ^ (bArr[i] & 255)] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static int zzg(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i < i2) {
            i4 = zzm[i4 ^ (bArr[i] & 255)];
            i++;
        }
        return i4;
    }

    public static int zzh(int i) {
        if (i == 20) {
            return 30;
        }
        if (i == 22) {
            return 31;
        }
        if (i == 30) {
            return 34;
        }
        switch (i) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Integer.MAX_VALUE;
                }
        }
    }

    public static int zzi(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return ComposerKt.providerMapsKey;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                break;
            case 10:
                if (zza >= 32) {
                    return 737532;
                }
                break;
            case 12:
                return 743676;
            default:
                return 0;
        }
        return 6396;
    }

    public static int zzj(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static int zzk(int i) {
        if (i != 2) {
            if (i == 3) {
                return 1;
            }
            if (i != 4) {
                if (i != 21) {
                    if (i != 22) {
                        if (i != 268435456) {
                            if (i != 1342177280) {
                                if (i != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static int zzl(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return 6003;
        }
        switch (i) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int zzm(String str) {
        String[] split;
        int length;
        if (str == null || (length = split.length) < 2) {
            return 0;
        }
        String str2 = (split = str.split("_", -1))[length - 1];
        boolean z = length >= 3 && "neg".equals(split[length + -2]);
        if (str2 != null) {
            try {
                String str3 = str2;
                int parseInt = Integer.parseInt(str2);
                return z ? -parseInt : parseInt;
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else {
            throw null;
        }
    }

    public static int zzn(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 22;
        }
        return 21;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzo(android.net.Uri r7) {
        /*
            java.lang.String r0 = r7.getScheme()
            r1 = 3
            if (r0 == 0) goto L_0x0011
            java.lang.String r2 = "rtsp"
            boolean r0 = com.google.android.gms.internal.ads.zzfwa.zzc(r2, r0)
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            return r1
        L_0x0011:
            java.lang.String r0 = r7.getLastPathSegment()
            r2 = 4
            if (r0 != 0) goto L_0x0019
            return r2
        L_0x0019:
            r3 = 46
            int r3 = r0.lastIndexOf(r3)
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 < 0) goto L_0x0071
            int r3 = r3 + r6
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfwa.zza(r0)
            int r3 = r0.hashCode()
            switch(r3) {
                case 104579: goto L_0x0053;
                case 108321: goto L_0x0049;
                case 3242057: goto L_0x003f;
                case 3299913: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x005d
        L_0x0035:
            java.lang.String r3 = "m3u8"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r6
            goto L_0x005e
        L_0x003f:
            java.lang.String r3 = "isml"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r1
            goto L_0x005e
        L_0x0049:
            java.lang.String r3 = "mpd"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r4
            goto L_0x005e
        L_0x0053:
            java.lang.String r3 = "ism"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r5
            goto L_0x005e
        L_0x005d:
            r0 = -1
        L_0x005e:
            if (r0 == 0) goto L_0x006c
            if (r0 == r6) goto L_0x006a
            if (r0 == r5) goto L_0x0068
            if (r0 == r1) goto L_0x0068
            r0 = r2
            goto L_0x006d
        L_0x0068:
            r0 = r6
            goto L_0x006d
        L_0x006a:
            r0 = r5
            goto L_0x006d
        L_0x006c:
            r0 = r4
        L_0x006d:
            if (r0 != r2) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            return r0
        L_0x0071:
            java.util.regex.Pattern r0 = zzg
            java.lang.String r7 = r7.getPath()
            r7.getClass()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.util.regex.Matcher r7 = r0.matcher(r7)
            boolean r0 = r7.matches()
            if (r0 == 0) goto L_0x009f
            java.lang.String r7 = r7.group(r5)
            if (r7 == 0) goto L_0x009e
            java.lang.String r0 = "format=mpd-time-csf"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0095
            return r4
        L_0x0095:
            java.lang.String r0 = "format=m3u8-aapl"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x009e
            return r5
        L_0x009e:
            return r6
        L_0x009f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzo(android.net.Uri):int");
    }

    public static long zzp(long j, int i) {
        return zzu(j, (long) i, AnimationKt.MillisToNanos, RoundingMode.CEILING);
    }

    public static long zzq(long j, float f) {
        return f == 1.0f ? j : Math.round(((double) j) * ((double) f));
    }

    public static long zzr(long j, float f) {
        return f == 1.0f ? j : Math.round(((double) j) / ((double) f));
    }

    public static long zzs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long zzt(long j, int i) {
        return zzu(j, AnimationKt.MillisToNanos, (long) i, RoundingMode.FLOOR);
    }

    public static long zzu(long j, long j2, long j3, RoundingMode roundingMode) {
        if (j == 0 || j2 == 0) {
            return 0;
        }
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i >= 0 && j3 % j2 == 0) {
            return zzgcm.zzb(j, zzgcm.zzb(j3, j2, RoundingMode.UNNECESSARY), roundingMode);
        }
        if (i < 0 && j2 % j3 == 0) {
            return zzgcm.zzd(j, zzgcm.zzb(j2, j3, RoundingMode.UNNECESSARY));
        }
        int i2 = (j3 > j ? 1 : (j3 == j ? 0 : -1));
        if (i2 >= 0 && j3 % j == 0) {
            return zzgcm.zzb(j2, zzgcm.zzb(j3, j, RoundingMode.UNNECESSARY), roundingMode);
        }
        if (i2 >= 0 || j % j3 != 0) {
            return zzQ(j, j2, j3, roundingMode);
        }
        return zzgcm.zzd(j2, zzgcm.zzb(j, j3, RoundingMode.UNNECESSARY));
    }

    public static long zzv(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static Point zzw(Context context) {
        String str;
        DisplayManager displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            WindowManager windowManager2 = windowManager;
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzM(context)) {
            if (zza < 28) {
                str = zzR("sys.display-size");
            } else {
                str = zzR("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzdt.zzc("Util", "Invalid display size: ".concat(String.valueOf(str)));
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        if (zza >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        }
        display.getRealSize(point);
        return point;
    }

    public static AudioFormat zzx(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public static Handler zzy(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzdb.zzb(myLooper);
        Looper looper = myLooper;
        return new Handler(myLooper, (Handler.Callback) null);
    }

    public static Looper zzz() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static void zzF(long[] jArr, long j, long j2) {
        long j3;
        int i = (j2 > AnimationKt.MillisToNanos ? 1 : (j2 == AnimationKt.MillisToNanos ? 0 : -1));
        RoundingMode roundingMode = RoundingMode.FLOOR;
        int i2 = 0;
        if (i >= 0 && j2 % AnimationKt.MillisToNanos == 0) {
            long zzb2 = zzgcm.zzb(j2, AnimationKt.MillisToNanos, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = zzgcm.zzb(jArr[i2], zzb2, roundingMode);
                i2++;
            }
        } else if (i >= 0 || AnimationKt.MillisToNanos % j2 != 0) {
            int i3 = 0;
            while (i3 < jArr.length) {
                long j4 = jArr[i3];
                if (j4 != 0) {
                    int i4 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                    if (i4 >= 0 && j2 % j4 == 0) {
                        jArr[i3] = zzgcm.zzb(AnimationKt.MillisToNanos, zzgcm.zzb(j2, j4, RoundingMode.UNNECESSARY), roundingMode);
                    } else if (i4 >= 0 || j4 % j2 != 0) {
                        j3 = j2;
                        jArr[i3] = zzQ(j4, AnimationKt.MillisToNanos, j3, roundingMode);
                        i3++;
                        j2 = j3;
                    } else {
                        jArr[i3] = zzgcm.zzd(AnimationKt.MillisToNanos, zzgcm.zzb(j4, j2, RoundingMode.UNNECESSARY));
                    }
                }
                j3 = j2;
                i3++;
                j2 = j3;
            }
        } else {
            long zzb3 = zzgcm.zzb(AnimationKt.MillisToNanos, j2, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = zzgcm.zzd(jArr[i2], zzb3);
                i2++;
            }
        }
    }
}
