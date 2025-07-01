package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaqm {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaqb.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzaqb.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static zzaoy zzb(zzapl zzapl) {
        long j;
        long j2;
        long j3;
        boolean z;
        long j4;
        long j5;
        long j6;
        long j7;
        zzapl zzapl2 = zzapl;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzapl2.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long zza = str != null ? zza(str) : 0;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j3 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            j = 0;
            i = 1;
        } else {
            j = 0;
            z = false;
            j3 = 0;
            j2 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long zza2 = str3 != null ? zza(str3) : j;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j4 = currentTimeMillis;
            j5 = zza(str4);
        } else {
            j4 = currentTimeMillis;
            j5 = j;
        }
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            long j8 = (j2 * 1000) + j4;
            j6 = z ? j8 : (j3 * 1000) + j8;
            j7 = j8;
        } else {
            j7 = (zza <= j || zza2 < zza) ? j : (zza2 - zza) + j4;
            j6 = j7;
        }
        zzaoy zzaoy = new zzaoy();
        zzaoy.zza = zzapl2.zzb;
        zzaoy.zzb = str5;
        zzaoy.zzf = j7;
        zzaoy.zze = j6;
        zzaoy.zzc = zza;
        zzaoy.zzd = j5;
        zzaoy.zzg = map;
        zzaoy.zzh = zzapl2.zzd;
        return zzaoy;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
