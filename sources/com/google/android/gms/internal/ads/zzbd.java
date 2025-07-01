package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbd implements Parcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbb();
    public final long zza;
    private final zzbc[] zzb;

    public zzbd(long j, zzbc... zzbcArr) {
        this.zza = j;
        this.zzb = zzbcArr;
    }

    zzbd(Parcel parcel) {
        this.zzb = new zzbc[parcel.readInt()];
        int i = 0;
        while (true) {
            zzbc[] zzbcArr = this.zzb;
            if (i < zzbcArr.length) {
                zzbcArr[i] = (zzbc) parcel.readParcelable(zzbc.class.getClassLoader());
                i++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbd zzbd = (zzbd) obj;
            return Arrays.equals(this.zzb, zzbd.zzb) && this.zza == zzbd.zza;
        }
    }

    public final int hashCode() {
        long j = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        long j = this.zza;
        int i = (j > -9223372036854775807L ? 1 : (j == -9223372036854775807L ? 0 : -1));
        String arrays = Arrays.toString(this.zzb);
        if (i == 0) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb.length);
        for (zzbc writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbc zzb(int i) {
        return this.zzb[i];
    }

    public final zzbd zzc(zzbc... zzbcArr) {
        int length = zzbcArr.length;
        if (length == 0) {
            return this;
        }
        long j = this.zza;
        zzbc[] zzbcArr2 = this.zzb;
        int i = zzen.zza;
        int length2 = zzbcArr2.length;
        Object[] copyOf = Arrays.copyOf(zzbcArr2, length2 + length);
        System.arraycopy(zzbcArr, 0, copyOf, length2, length);
        return new zzbd(j, (zzbc[]) copyOf);
    }

    public final zzbd zzd(zzbd zzbd) {
        return zzbd == null ? this : zzc(zzbd.zzb);
    }

    public zzbd(List list) {
        this(-9223372036854775807L, (zzbc[]) list.toArray(new zzbc[0]));
    }
}
