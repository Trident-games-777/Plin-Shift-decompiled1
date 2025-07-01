package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadf {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = zzen.zza;
            String str2 = group;
            int parseInt = Integer.parseInt(group, 16);
            String group2 = matcher.group(2);
            String str3 = group2;
            int parseInt2 = Integer.parseInt(group2, 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzbd zzbd) {
        for (int i = 0; i < zzbd.zza(); i++) {
            zzbc zzb2 = zzbd.zzb(i);
            if (zzb2 instanceof zzagf) {
                zzagf zzagf = (zzagf) zzb2;
                if ("iTunSMPB".equals(zzagf.zzb) && zzc(zzagf.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzago) {
                zzago zzago = (zzago) zzb2;
                if ("com.apple.iTunes".equals(zzago.zza) && "iTunSMPB".equals(zzago.zzb) && zzc(zzago.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
