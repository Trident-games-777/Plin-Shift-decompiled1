package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzahd implements zzbc {
    public static final Parcelable.Creator<zzahd> CREATOR = new zzaha();
    public final List zza;

    public zzahd(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzahc) list.get(0)).zzb;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (((zzahc) list.get(i)).zza < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzahc) list.get(i)).zzb;
                    i++;
                }
            }
        }
        zzdb.zzd(!z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzahd) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.zza);
    }

    public final /* synthetic */ void zza(zzay zzay) {
    }
}
