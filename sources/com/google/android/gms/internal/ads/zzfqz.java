package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfqz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfqz> CREATOR = new zzfra();
    public final int zza;
    private zzata zzb = null;
    private byte[] zzc;

    zzfqz(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzaV();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzata zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzata.zzd(this.zzc, zzgyh.zza());
                this.zzc = null;
            } catch (zzgzm | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }

    private final void zzb() {
        zzata zzata = this.zzb;
        if (zzata == null && this.zzc != null) {
            return;
        }
        if (zzata != null && this.zzc == null) {
            return;
        }
        if (zzata != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzata == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
