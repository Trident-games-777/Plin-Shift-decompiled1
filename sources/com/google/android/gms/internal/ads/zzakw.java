package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzakw implements zzaki {
    private final zzed zza = new zzed();
    private final zzed zzb = new zzed();
    private final zzakv zzc = new zzakv();
    private Inflater zzd;

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        this.zza.zzJ(bArr, i2 + i);
        this.zza.zzL(i);
        zzed zzed = this.zza;
        if (zzed.zzb() > 0 && zzed.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzen.zzH(zzed, this.zzb, this.zzd)) {
                zzed zzed2 = this.zzb;
                zzed.zzJ(zzed2.zzN(), zzed2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzed zzed3 = this.zza;
            if (zzed3.zzb() >= 3) {
                zzakv zzakv = this.zzc;
                int zze = zzed3.zze();
                int zzm = zzed3.zzm();
                int zzq = zzed3.zzq();
                int zzd2 = zzed3.zzd() + zzq;
                zzct zzct = null;
                if (zzd2 > zze) {
                    zzed3.zzL(zze);
                } else {
                    if (zzm != 128) {
                        switch (zzm) {
                            case 20:
                                zzakv.zzd(zzakv, zzed3, zzq);
                                break;
                            case 21:
                                zzakv.zzb(zzakv, zzed3, zzq);
                                break;
                            case 22:
                                zzakv.zzc(zzakv, zzed3, zzq);
                                break;
                        }
                    } else {
                        zzct zza2 = zzakv.zza();
                        zzakv.zze();
                        zzct = zza2;
                    }
                    zzed3.zzL(zzd2);
                }
                if (zzct != null) {
                    arrayList.add(zzct);
                }
            } else {
                zzdg.zza(new zzaka(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
