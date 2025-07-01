package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzw implements Comparator<zzv>, Parcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzt();
    public final String zza;
    public final int zzb;
    private final zzv[] zzc;
    private int zzd;

    zzw(Parcel parcel) {
        this.zza = parcel.readString();
        int i = zzen.zza;
        zzv[] zzvArr = (zzv[]) parcel.createTypedArray(zzv.CREATOR);
        this.zzc = zzvArr;
        this.zzb = zzvArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzv zzv = (zzv) obj;
        zzv zzv2 = (zzv) obj2;
        if (zzj.zza.equals(zzv.zza)) {
            return !zzj.zza.equals(zzv2.zza) ? 1 : 0;
        }
        return zzv.zza.compareTo(zzv2.zza);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzw zzw = (zzw) obj;
            return Objects.equals(this.zza, zzw.zza) && Arrays.equals(this.zzc, zzw.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzc, 0);
    }

    public final zzv zza(int i) {
        return this.zzc[i];
    }

    public final zzw zzb(String str) {
        if (Objects.equals(this.zza, str)) {
            return this;
        }
        return new zzw(str, false, this.zzc);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode = (i * 31) + Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzv[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzw(java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzv... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzv[] r3 = (com.google.android.gms.internal.ads.zzv[]) r3
        L_0x000e:
            r0.zzc = r3
            int r1 = r3.length
            r0.zzb = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzw.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzv[]):void");
    }

    public zzw(String str, zzv... zzvArr) {
        this((String) null, true, zzvArr);
    }

    public zzw(List list) {
        this((String) null, false, (zzv[]) list.toArray(new zzv[0]));
    }
}
