package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzey implements zzbc {
    public static final Parcelable.Creator<zzey> CREATOR = new zzew();
    public final float zza;
    public final float zzb;

    public zzey(float f, float f2) {
        boolean z = false;
        if (f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f) {
            z = true;
        }
        zzdb.zze(z, "Invalid latitude or longitude");
        this.zza = f;
        this.zzb = f2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzey zzey = (zzey) obj;
            return this.zza == zzey.zza && this.zzb == zzey.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + Float.valueOf(this.zzb).hashCode();
    }

    public final String toString() {
        return "xyz: latitude=" + this.zza + ", longitude=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeFloat(this.zzb);
    }

    public final /* synthetic */ void zza(zzay zzay) {
    }

    /* synthetic */ zzey(Parcel parcel, zzex zzex) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readFloat();
    }
}
