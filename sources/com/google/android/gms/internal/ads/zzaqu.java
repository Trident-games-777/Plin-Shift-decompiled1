package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzaqu extends zzapp {
    private final Object zza = new Object();
    private final zzapu zzb;

    public zzaqu(int i, String str, zzapu zzapu, zzapt zzapt) {
        super(i, str, zzapt);
        this.zzb = zzapu;
    }

    /* access modifiers changed from: protected */
    public final zzapv zzh(zzapl zzapl) {
        String str;
        try {
            byte[] bArr = zzapl.zzb;
            Map map = zzapl.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get("Content-Type");
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapl.zzb);
        }
        return zzapv.zzb(str, zzaqm.zzb(zzapl));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzz */
    public void zzo(String str) {
        zzapu zzapu;
        synchronized (this.zza) {
            zzapu = this.zzb;
        }
        zzapu.zza(str);
    }
}
