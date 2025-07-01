package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzham implements zzhbb {
    private final zzhai zza;
    private final zzhbn zzb;
    private final boolean zzc;
    private final zzgyi zzd;

    private zzham(zzhbn zzhbn, zzgyi zzgyi, zzhai zzhai) {
        this.zzb = zzhbn;
        this.zzc = zzhai instanceof zzgyt;
        this.zzd = zzgyi;
        this.zza = zzhai;
    }

    static zzham zzc(zzhbn zzhbn, zzgyi zzgyi, zzhai zzhai) {
        return new zzham(zzhbn, zzgyi, zzhai);
    }

    public final int zza(Object obj) {
        zzhbo zzhbo = ((zzgyx) obj).zzt;
        zzhbo zzhbo2 = zzhbo;
        int zzb2 = zzhbo.zzb();
        return this.zzc ? zzb2 + ((zzgyt) obj).zza.zzd() : zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = ((zzgyx) obj).zzt.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzgyt) obj).zza.zza.hashCode() : hashCode;
    }

    public final Object zze() {
        zzhai zzhai = this.zza;
        if (zzhai instanceof zzgyx) {
            return ((zzgyx) zzhai).zzbj();
        }
        return zzhai.zzcZ().zzbs();
    }

    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzhbd.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhbd.zzp(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzhav zzhav, zzgyh zzgyh) throws IOException {
        this.zzb.zza(obj);
        zzgyt zzgyt = (zzgyt) obj;
        throw null;
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxd zzgxd) throws IOException {
        zzgyx zzgyx = (zzgyx) obj;
        if (zzgyx.zzt == zzhbo.zzc()) {
            zzgyx.zzt = zzhbo.zzf();
        }
        zzgyt zzgyt = (zzgyt) obj;
        throw null;
    }

    public final void zzj(Object obj, zzhcc zzhcc) throws IOException {
        Iterator zzf = ((zzgyt) obj).zza.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzgyl zzgyl = (zzgyl) entry.getKey();
            if (zzgyl.zzc() != zzhcb.MESSAGE || zzgyl.zze() || zzgyl.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzgzp) {
                zzhcc.zzw(zzgyl.zza(), ((zzgzp) entry).zza().zzb());
            } else {
                zzhcc.zzw(zzgyl.zza(), entry.getValue());
            }
        }
        zzhbo zzhbo = ((zzgyx) obj).zzt;
        zzhbo zzhbo2 = zzhbo;
        zzhbo.zzk(zzhcc);
    }

    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzgyx) obj).zzt.equals(((zzgyx) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgyt) obj).zza.equals(((zzgyt) obj2).zza);
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        return ((zzgyt) obj).zza.zzi();
    }
}
