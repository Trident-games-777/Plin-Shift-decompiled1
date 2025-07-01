package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.net.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzebx implements zzfiv {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfka zzc;
    private final zzfkl zzd;

    public zzebx(String str, zzfkl zzfkl, zzfka zzfka) {
        this.zzb = str;
        this.zzd = zzfkl;
        this.zzc = zzfka;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdwn zzdwn;
        String str;
        zzebw zzebw = (zzebw) obj;
        int optInt = zzebw.zza.optInt("http_timeout_millis", 60000);
        zzbvz zza2 = zzebw.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzebw.zzb.zzj() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzaW)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, this.zzb);
                }
            }
            if (zzebw.zzb.zzk()) {
                zzeby.zza(hashMap, zzebw.zza);
            }
            if (zzebw.zzb != null && !TextUtils.isEmpty(zzebw.zzb.zzf())) {
                str2 = zzebw.zzb.zzf();
            }
            zzfkl zzfkl = this.zzd;
            zzfka zzfka = this.zzc;
            zzfka.zzg(true);
            zzfkl.zza(zzfka);
            return new zzebs(zzebw.zzb.zzg(), optInt, hashMap, str2.getBytes(StandardCharsets.UTF_8), "", zzebw.zzb.zzk());
        }
        if (zza2.zza() == 1) {
            if (zza2.zzh() != null) {
                str2 = TextUtils.join(", ", zza2.zzh());
                zzm.zzg(str2);
            }
            zzdwn = new zzdwn(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdwn = new zzdwn(1);
        }
        zzfkl zzfkl2 = this.zzd;
        zzfka zzfka2 = this.zzc;
        zzfka2.zzh(zzdwn);
        zzfka2.zzg(false);
        zzfkl2.zza(zzfka2);
        throw zzdwn;
    }
}
