package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzalo implements zzaki {
    private final zzed zza = new zzed();

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        zzct zzct;
        this.zza.zzJ(bArr, i2 + i);
        this.zza.zzL(i);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzed zzed = this.zza;
            if (zzed.zzb() > 0) {
                zzdb.zze(zzed.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
                zzed zzed2 = this.zza;
                int zzg = zzed2.zzg() - 8;
                if (zzed2.zzg() == 1987343459) {
                    zzed zzed3 = this.zza;
                    CharSequence charSequence = null;
                    zzcr zzcr = null;
                    while (zzg > 0) {
                        zzdb.zze(zzg >= 8, "Incomplete vtt cue box header found.");
                        int zzg2 = zzed3.zzg();
                        int zzg3 = zzed3.zzg();
                        int i3 = zzg - 8;
                        int i4 = zzg2 - 8;
                        String zzC = zzen.zzC(zzed3.zzN(), zzed3.zzd(), i4);
                        zzed3.zzM(i4);
                        if (zzg3 == 1937011815) {
                            zzcr = zzaly.zzb(zzC);
                        } else if (zzg3 == 1885436268) {
                            charSequence = zzaly.zza((String) null, zzC.trim(), Collections.emptyList());
                        }
                        zzg = i3 - i4;
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (zzcr != null) {
                        zzcr.zzl(charSequence);
                        zzct = zzcr.zzp();
                    } else {
                        zzalw zzalw = new zzalw();
                        zzalw.zzc = charSequence;
                        zzct = zzalw.zza().zzp();
                    }
                    arrayList.add(zzct);
                } else {
                    this.zza.zzM(zzg);
                }
            } else {
                zzdg.zza(new zzaka(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
