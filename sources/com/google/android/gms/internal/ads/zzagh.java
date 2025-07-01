package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzagh extends zzagl {
    public static final Parcelable.Creator<zzagh> CREATOR = new zzagg();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    zzagh(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i = zzen.zza;
        String str = readString;
        this.zza = readString;
        String readString2 = parcel.readString();
        String str2 = readString2;
        this.zzb = readString2;
        String readString3 = parcel.readString();
        String str3 = readString3;
        this.zzc = readString3;
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagh zzagh = (zzagh) obj;
            return Objects.equals(this.zza, zzagh.zza) && Objects.equals(this.zzb, zzagh.zzb) && Objects.equals(this.zzc, zzagh.zzc) && Arrays.equals(this.zzd, zzagh.zzd);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.zzb;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = hashCode + 527;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return (((((i2 * 31) + hashCode2) * 31) + i) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", filename=" + this.zzb + ", description=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzagh(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
