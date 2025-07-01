package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzafv implements zzbc {
    public static final Parcelable.Creator<zzafv> CREATOR = new zzafu();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzafv(int i, String str, String str2, String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        zzdb.zzd(z2);
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafv zzafv = (zzafv) obj;
            return this.zza == zzafv.zza && Objects.equals(this.zzb, zzafv.zzb) && Objects.equals(this.zzc, zzafv.zzc) && Objects.equals(this.zzd, zzafv.zzd) && this.zze == zzafv.zze && this.zzf == zzafv.zzf;
        }
    }

    public final int hashCode() {
        String str = this.zzb;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        int i2 = this.zza;
        String str2 = this.zzc;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        int i3 = ((i2 + 527) * 31) + hashCode;
        String str3 = this.zzd;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return (((((((i3 * 31) + hashCode2) * 31) + i) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.zzc + "\", genre=\"" + this.zzb + "\", bitrate=" + this.zza + ", metadataInterval=" + this.zzf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        int i2 = zzen.zza;
        parcel.writeInt(this.zze ? 1 : 0);
        parcel.writeInt(this.zzf);
    }

    public final void zza(zzay zzay) {
        String str = this.zzc;
        if (str != null) {
            zzay.zzp(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzay.zzi(str2);
        }
    }

    zzafv(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        int i = zzen.zza;
        this.zze = parcel.readInt() != 0;
        this.zzf = parcel.readInt();
    }
}
