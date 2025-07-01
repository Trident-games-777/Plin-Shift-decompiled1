package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzakl implements zzadx {
    private final zzadx zza;
    private final zzakg zzb;
    private final zzed zzc = new zzed();
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzen.zzf;
    private zzaki zzg;
    private zzad zzh;

    public zzakl(zzadx zzadx, zzakg zzakg) {
        this.zza = zzadx;
        this.zzb = zzakg;
    }

    private final void zzb(int i) {
        byte[] bArr;
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 < i) {
            int i3 = i2 - this.zzd;
            int max = Math.max(i3 + i3, i + i3);
            byte[] bArr2 = this.zzf;
            if (max <= bArr2.length) {
                bArr = bArr2;
            } else {
                bArr = new byte[max];
            }
            System.arraycopy(bArr2, this.zzd, bArr, 0, i3);
            this.zzd = 0;
            this.zze = i3;
            this.zzf = bArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(long j, int i, zzaka zzaka) {
        zzdb.zzb(this.zzh);
        zzfzo<zzct> zzfzo = zzaka.zza;
        long j2 = zzaka.zzc;
        ArrayList arrayList = new ArrayList(zzfzo.size());
        for (zzct zza2 : zzfzo) {
            Bundle zza3 = zza2.zza();
            Bundle bundle = zza3;
            arrayList.add(zza3);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("c", arrayList);
        bundle2.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle2);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        zzed zzed = this.zzc;
        int length = marshall.length;
        zzed.zzJ(marshall, length);
        this.zza.zzq(this.zzc, length);
        long j3 = zzaka.zzb;
        if (j3 == -9223372036854775807L) {
            zzdb.zzf(this.zzh.zzt == Long.MAX_VALUE);
        } else {
            long j4 = this.zzh.zzt;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        this.zza.zzs(j, i, length, 0, (zzadw) null);
    }

    public final /* synthetic */ int zzf(zzn zzn, int i, boolean z) {
        return zzadv.zza(this, zzn, i, z);
    }

    public final int zzg(zzn zzn, int i, boolean z, int i2) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzg(zzn, i, z, 0);
        }
        zzb(i);
        int zza2 = zzn.zza(this.zzf, this.zze, i);
        if (zza2 != -1) {
            this.zze += zza2;
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void zzl(zzad zzad) {
        String str = zzad.zzo;
        str.getClass();
        zzdb.zzd(zzbg.zzb(str) == 3);
        if (!zzad.equals(this.zzh)) {
            this.zzh = zzad;
            this.zzg = this.zzb.zzc(zzad) ? this.zzb.zzb(zzad) : null;
        }
        if (this.zzg == null) {
            this.zza.zzl(zzad);
            return;
        }
        zzadx zzadx = this.zza;
        zzab zzb2 = zzad.zzb();
        zzb2.zzZ("application/x-media3-cues");
        zzb2.zzA(zzad.zzo);
        zzb2.zzad(Long.MAX_VALUE);
        zzb2.zzE(this.zzb.zza(zzad));
        zzadx.zzl(zzb2.zzaf());
    }

    public final /* synthetic */ void zzq(zzed zzed, int i) {
        zzadv.zzb(this, zzed, i);
    }

    public final void zzr(zzed zzed, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzr(zzed, i, i2);
            return;
        }
        zzb(i);
        zzed.zzH(this.zzf, this.zze, i);
        this.zze += i;
    }

    public final void zzs(long j, int i, int i2, int i3, zzadw zzadw) {
        if (this.zzg == null) {
            this.zza.zzs(j, i, i2, i3, zzadw);
            return;
        }
        long j2 = j;
        int i4 = i;
        int i5 = i3;
        zzdb.zze(zzadw == null, "DRM on subtitles is not supported");
        int i6 = (this.zze - i5) - i2;
        this.zzg.zza(this.zzf, i6, i2, zzakh.zza(), new zzakk(this, j2, i4));
        int i7 = i6 + i2;
        this.zzd = i7;
        if (i7 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
