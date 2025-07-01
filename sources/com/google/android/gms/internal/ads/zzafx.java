package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzafx extends zzagl {
    public static final Parcelable.Creator<zzafx> CREATOR = new zzafw();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzafx(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i = zzen.zza;
        String str = readString;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafx zzafx = (zzafx) obj;
            return this.zzc == zzafx.zzc && Objects.equals(this.zza, zzafx.zza) && Objects.equals(this.zzb, zzafx.zzb) && Arrays.equals(this.zzd, zzafx.zzd);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        int i2 = this.zzc;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((i2 + 527) * 31) + hashCode) * 31) + i) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", description=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzay zzay) {
        zzay.zza(this.zzd, this.zzc);
    }

    public zzafx(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = bArr;
    }
}
