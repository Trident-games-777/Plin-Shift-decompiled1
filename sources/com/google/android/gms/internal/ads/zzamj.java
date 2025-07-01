package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamj implements zzanz {
    private final List zza;

    public zzamj() {
        this(0);
    }

    public zzamj(int i, List list) {
        this.zza = list;
    }

    private final zzanq zzc(zzany zzany) {
        return new zzanq(zze(zzany));
    }

    private final zzaod zzd(zzany zzany) {
        return new zzaod(zze(zzany));
    }

    private final List zze(zzany zzany) {
        String str;
        int i;
        List list;
        zzed zzed = new zzed(zzany.zze);
        List list2 = this.zza;
        while (zzed.zzb() > 0) {
            int zzm = zzed.zzm();
            int zzd = zzed.zzd() + zzed.zzm();
            if (zzm == 134) {
                list2 = new ArrayList();
                int zzm2 = zzed.zzm() & 31;
                for (int i2 = 0; i2 < zzm2; i2++) {
                    String zzB = zzed.zzB(3, StandardCharsets.UTF_8);
                    int zzm3 = zzed.zzm();
                    boolean z = (zzm3 & 128) != 0;
                    if (z) {
                        i = zzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte zzm4 = (byte) zzed.zzm();
                    zzed.zzM(1);
                    if (z) {
                        byte b = zzm4 & SignedBytes.MAX_POWER_OF_TWO;
                        int i3 = zzdd.zza;
                        list = Collections.singletonList(b != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzab zzab = new zzab();
                    zzab.zzZ(str);
                    zzab.zzP(zzB);
                    zzab.zzx(i);
                    zzab.zzM(list);
                    list2.add(zzab.zzaf());
                }
            }
            zzed.zzL(zzd);
        }
        return list2;
    }

    public final SparseArray zza() {
        return new SparseArray();
    }

    public zzamj(int i) {
        this.zza = zzfzo.zzn();
    }

    public final zzaob zzb(int i, zzany zzany) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzang(new zzamy(zzany.zzb, zzany.zza()));
            }
            if (i == 21) {
                return new zzang(new zzamw());
            }
            if (i == 27) {
                return new zzang(new zzamt(zzc(zzany), false, false));
            }
            if (i == 36) {
                return new zzang(new zzamv(zzc(zzany)));
            }
            if (i == 45) {
                return new zzang(new zzamz());
            }
            if (i == 89) {
                return new zzang(new zzaml(zzany.zzd));
            }
            if (i == 172) {
                return new zzang(new zzamg(zzany.zzb, zzany.zza()));
            }
            if (i == 257) {
                return new zzano(new zzanf("application/vnd.dvb.ait"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzang(new zzamk(zzany.zzb, zzany.zza(), 5408));
                        }
                        switch (i) {
                            case 15:
                                return new zzang(new zzami(false, zzany.zzb, zzany.zza()));
                            case 16:
                                return new zzang(new zzamr(zzd(zzany)));
                            case 17:
                                return new zzang(new zzamx(zzany.zzb, zzany.zza()));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzano(new zzanf("application/x-scte35"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                        }
                    }
                    return new zzang(new zzamk(zzany.zzb, zzany.zza(), 4096));
                }
                return new zzang(new zzame(zzany.zzb, zzany.zza()));
            }
        }
        return new zzang(new zzamo(zzd(zzany)));
    }
}
