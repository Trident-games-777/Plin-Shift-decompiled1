package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzalz implements zzaki {
    private final zzed zza = new zzed();
    private final zzalp zzb = new zzalp();

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        this.zza.zzJ(bArr, i2 + i);
        this.zza.zzL(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzed zzed = this.zza;
            int zzd = zzed.zzd();
            String zzz = zzed.zzz(StandardCharsets.UTF_8);
            if (zzz == null || !zzz.startsWith("WEBVTT")) {
                zzed.zzL(zzd);
                throw zzbh.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzed.zzz(StandardCharsets.UTF_8))), (Throwable) null);
            }
            do {
            } while (!TextUtils.isEmpty(this.zza.zzz(StandardCharsets.UTF_8)));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzed zzed2 = this.zza;
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzed2.zzd();
                    String zzz2 = zzed2.zzz(StandardCharsets.UTF_8);
                    if (zzz2 == null) {
                        c = 0;
                    } else if ("STYLE".equals(zzz2)) {
                        c = 2;
                    } else {
                        c = zzz2.startsWith("NOTE") ? (char) 1 : 3;
                    }
                }
                zzed2.zzL(i3);
                if (c == 0) {
                    zzakc.zza(new zzamc(arrayList2), zzakh, zzdg);
                    return;
                } else if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.zza.zzz(StandardCharsets.UTF_8)));
                } else if (c != 2) {
                    zzalr zzc = zzaly.zzc(this.zza, arrayList);
                    if (zzc != null) {
                        arrayList2.add(zzc);
                    }
                } else if (arrayList2.isEmpty()) {
                    this.zza.zzz(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                } else {
                    throw new IllegalArgumentException("A style block was found after the first cue.");
                }
            }
        } catch (zzbh e) {
            throw new IllegalArgumentException(e);
        }
    }
}
