package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzafo implements zzbc {
    public static final Parcelable.Creator<zzafo> CREATOR = new zzafn();
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzab zzab = new zzab();
        zzab.zzZ("application/id3");
        zzab.zzaf();
        zzab zzab2 = new zzab();
        zzab2.zzZ("application/x-scte35");
        zzab2.zzaf();
    }

    zzafo(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzen.zza;
        String str = readString;
        this.zza = readString;
        String readString2 = parcel.readString();
        String str2 = readString2;
        this.zzb = readString2;
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.createByteArray();
    }

    public zzafo(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafo zzafo = (zzafo) obj;
            return this.zzc == zzafo.zzc && this.zzd == zzafo.zzd && Objects.equals(this.zza, zzafo.zza) && Objects.equals(this.zzb, zzafo.zzb) && Arrays.equals(this.zze, zzafo.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        long j = this.zzc;
        long j2 = this.zzd;
        int hashCode2 = ((((((((hashCode + 527) * 31) + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.zze);
        this.zzf = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.zza + ", id=" + this.zzd + ", durationMs=" + this.zzc + ", value=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final /* synthetic */ void zza(zzay zzay) {
    }
}
