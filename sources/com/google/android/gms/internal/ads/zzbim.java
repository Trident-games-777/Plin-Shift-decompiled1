package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbim implements zzfwh {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbim(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = (String) obj;
        zzbjr zzbjr = zzbjq.zza;
        String str2 = this.zza;
        if (str != null) {
            if (((Boolean) zzbem.zzf.zze()).booleanValue()) {
                int i = 0;
                String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                String host = Uri.parse(str2).getHost();
                while (true) {
                    if (i < 3) {
                        if (host.endsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            String str3 = (String) zzbem.zza.zze();
            String str4 = (String) zzbem.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                str2 = str2.replace(str3, str);
            }
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str2);
                if (TextUtils.isEmpty(parse.getQueryParameter(str4))) {
                    return parse.buildUpon().appendQueryParameter(str4, str).toString();
                }
            }
        }
        return str2;
    }
}
