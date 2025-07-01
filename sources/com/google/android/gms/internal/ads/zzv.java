package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzv implements Parcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzu();
    public final UUID zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    private int zze;

    zzv(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i = zzen.zza;
        String str = readString;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzv)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzv zzv = (zzv) obj;
        return Objects.equals(this.zzb, zzv.zzb) && Objects.equals(this.zzc, zzv.zzc) && Objects.equals(this.zza, zzv.zza) && Arrays.equals(this.zzd, zzv.zzd);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode2 = ((((hashCode + i) * 31) + this.zzc.hashCode()) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode2;
        return hashCode2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzv(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        UUID uuid2 = uuid;
        this.zza = uuid;
        this.zzb = null;
        String str3 = str2;
        this.zzc = zzbg.zze(str2);
        this.zzd = bArr;
    }
}
