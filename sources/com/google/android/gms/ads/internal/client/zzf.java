package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzf implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r4 = r2
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004a
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1
            if (r2 == r3) goto L_0x0045
            r3 = 2
            if (r2 == r3) goto L_0x0040
            r3 = 3
            if (r2 == r3) goto L_0x003b
            r3 = 4
            if (r2 == r3) goto L_0x0031
            r3 = 5
            if (r2 == r3) goto L_0x002c
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000b
        L_0x002c:
            android.os.IBinder r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r10, r1)
            goto L_0x000b
        L_0x0031:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zze> r2 = com.google.android.gms.ads.internal.client.zze.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r7 = r1
            com.google.android.gms.ads.internal.client.zze r7 = (com.google.android.gms.ads.internal.client.zze) r7
            goto L_0x000b
        L_0x003b:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r10, r1)
            goto L_0x000b
        L_0x0040:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r10, r1)
            goto L_0x000b
        L_0x0045:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x000b
        L_0x004a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.ads.internal.client.zze r3 = new com.google.android.gms.ads.internal.client.zze
            r3.<init>(r4, r5, r6, r7, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzf.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
