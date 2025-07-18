package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzo implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel2);
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzfx zzfx = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzc zzc = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        String str6 = null;
        while (parcel2.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel2);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    zzfx = (zzfx) SafeParcelReader.createParcelable(parcel2, readHeader, zzfx.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.createParcelable(parcel2, readHeader, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 16:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 18:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    zzc = (zzc) SafeParcelReader.createParcelable(parcel2, readHeader, zzc.CREATOR);
                    break;
                case 20:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 22:
                    arrayList3 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 23:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 24:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 26:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzm(i, j, bundle, i2, arrayList, z, i3, z2, str, zzfx, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzc, i4, str5, arrayList3, i5, str6, i6, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzm[i];
    }
}
