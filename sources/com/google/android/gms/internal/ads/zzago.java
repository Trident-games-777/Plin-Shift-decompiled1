package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzago extends zzagl {
    public static final Parcelable.Creator<zzago> CREATOR = new zzagn();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzago(Parcel parcel) {
        super("----");
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
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzago zzago = (zzago) obj;
            return Objects.equals(this.zzb, zzago.zzb) && Objects.equals(this.zza, zzago.zza) && Objects.equals(this.zzc, zzago.zzc);
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
        return (((i2 * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        return this.zzf + ": domain=" + this.zza + ", description=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzago(String str, String str2, String str3) {
        super("----");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
