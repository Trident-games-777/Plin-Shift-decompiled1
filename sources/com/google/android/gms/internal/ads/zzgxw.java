package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxw implements zzhav {
    private final zzgxv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgxw(zzgxv zzgxv) {
        zzgzk.zzc(zzgxv, "input");
        zzgxv zzgxv2 = zzgxv;
        this.zza = zzgxv;
        zzgxv.zzc = this;
    }

    private final void zzO(Object obj, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhbb.zzh(obj, this, zzgyh);
            if (this.zzb != this.zzc) {
                throw new zzgzm("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzP(Object obj, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        zzgxv zzgxv = this.zza;
        int zzm = zzgxv.zzm();
        if (zzgxv.zza < zzgxv.zzb) {
            int zzd2 = zzgxv.zzd(zzm);
            this.zza.zza++;
            zzhbb.zzh(obj, this, zzgyh);
            this.zza.zzy(0);
            zzgxv zzgxv2 = this.zza;
            zzgxv2.zza--;
            zzgxv2.zzz(zzd2);
            return;
        }
        throw new zzgzm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    private final void zzQ(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzR(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzgzl("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzS(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzgzm("Failed to parse the message.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzgzm("Failed to parse the message.");
        }
    }

    public static zzgxw zzq(zzgxv zzgxv) {
        zzgxw zzgxw = zzgxv.zzc;
        if (zzgxw != null) {
            return zzgxw;
        }
        return new zzgxw(zzgxv);
    }

    public final void zzA(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgzx.zzg(this.zza.zzn());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = zzm + this.zza.zzc();
                do {
                    zzgzx.zzg(this.zza.zzn());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = zzm2 + this.zza.zzc();
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzB(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyo) {
            zzgyo zzgyo = (zzgyo) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgyo.zzh(this.zza.zzb());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgyo.zzh(this.zza.zzb());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    @Deprecated
    public final void zzC(List list, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzhbb.zze();
                zzO(zze, zzhbb, zzgyh);
                zzhbb.zzf(zze);
                list.add(zze);
                if (!this.zza.zzA() && this.zzd == 0) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == i);
            this.zzd = zzl;
            return;
        }
        throw new zzgzl("Protocol message tag had invalid wire type.");
    }

    public final void zzD(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzi(this.zza.zzg());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgyy.zzi(this.zza.zzg());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzE(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzx.zzg(this.zza.zzo());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgzx.zzg(this.zza.zzo());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzF(List list, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzhbb.zze();
                zzP(zze, zzhbb, zzgyh);
                zzhbb.zzf(zze);
                list.add(zze);
                if (!this.zza.zzA() && this.zzd == 0) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == i);
            this.zzd = zzl;
            return;
        }
        throw new zzgzl("Protocol message tag had invalid wire type.");
    }

    public final void zzG(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgyy.zzi(this.zza.zzj());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgyy.zzi(this.zza.zzj());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzH(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgzx.zzg(this.zza.zzs());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = zzm + this.zza.zzc();
                do {
                    zzgzx.zzg(this.zza.zzs());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzs()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = zzm2 + this.zza.zzc();
                do {
                    list.add(Long.valueOf(this.zza.zzs()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzI(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzi(this.zza.zzk());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgyy.zzi(this.zza.zzk());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzJ(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzx.zzg(this.zza.zzt());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgzx.zzg(this.zza.zzt());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzl;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzgzu) && !z) {
                zzgzu zzgzu = (zzgzu) list;
                do {
                    zzp();
                    zzgzu.zzb();
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzs() : zzr());
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            }
            this.zzd = i;
            return;
        }
        throw new zzgzl("Protocol message tag had invalid wire type.");
    }

    public final void zzL(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzi(this.zza.zzm());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgyy.zzi(this.zza.zzm());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzM(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgzx.zzg(this.zza.zzu());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgzx.zzg(this.zza.zzu());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final boolean zzN() throws IOException {
        zzR(0);
        return this.zza.zzB();
    }

    public final double zza() throws IOException {
        zzR(1);
        return this.zza.zza();
    }

    public final float zzb() throws IOException {
        zzR(5);
        return this.zza.zzb();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzl();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzR(0);
        return this.zza.zze();
    }

    public final int zzf() throws IOException {
        zzR(5);
        return this.zza.zzf();
    }

    public final int zzg() throws IOException {
        zzR(0);
        return this.zza.zzg();
    }

    public final int zzh() throws IOException {
        zzR(5);
        return this.zza.zzj();
    }

    public final int zzi() throws IOException {
        zzR(0);
        return this.zza.zzk();
    }

    public final int zzj() throws IOException {
        zzR(0);
        return this.zza.zzm();
    }

    public final long zzk() throws IOException {
        zzR(1);
        return this.zza.zzn();
    }

    public final long zzl() throws IOException {
        zzR(0);
        return this.zza.zzo();
    }

    public final long zzm() throws IOException {
        zzR(1);
        return this.zza.zzs();
    }

    public final long zzn() throws IOException {
        zzR(0);
        return this.zza.zzt();
    }

    public final long zzo() throws IOException {
        zzR(0);
        return this.zza.zzu();
    }

    public final zzgxp zzp() throws IOException {
        zzR(2);
        return this.zza.zzv();
    }

    public final String zzr() throws IOException {
        zzR(2);
        return this.zza.zzw();
    }

    public final String zzs() throws IOException {
        zzR(2);
        return this.zza.zzx();
    }

    public final void zzt(Object obj, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        zzR(3);
        zzO(obj, zzhbb, zzgyh);
    }

    public final void zzu(Object obj, zzhbb zzhbb, zzgyh zzgyh) throws IOException {
        zzR(2);
        zzP(obj, zzhbb, zzgyh);
    }

    public final void zzv(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxf) {
            zzgxf zzgxf = (zzgxf) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxf.zzg(this.zza.zzB());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgxf.zzg(this.zza.zzB());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzB()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzB()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzw(List list) throws IOException {
        int zzl;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzA()) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == this.zzb);
            this.zzd = zzl;
            return;
        }
        throw new zzgzl("Protocol message tag had invalid wire type.");
    }

    public final void zzx(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgye) {
            zzgye zzgye = (zzgye) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgye.zzh(this.zza.zza());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = zzm + this.zza.zzc();
                do {
                    zzgye.zzh(this.zza.zza());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = zzm2 + this.zza.zzc();
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzy(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzi(this.zza.zze());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgxv zzgxv = this.zza;
                int zzc2 = zzgxv.zzc() + zzgxv.zzm();
                do {
                    zzgyy.zzi(this.zza.zze());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgxv zzgxv2 = this.zza;
                int zzc3 = zzgxv2.zzc() + zzgxv2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }

    public final void zzz(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgyy.zzi(this.zza.zzf());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgyy.zzi(this.zza.zzf());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw new zzgzl("Protocol message tag had invalid wire type.");
            }
        }
        this.zzd = i;
    }
}
