package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzer implements zzbc {
    public static final Parcelable.Creator<zzer> CREATOR = new zzep();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzer(Parcel parcel, zzeq zzeq) {
        String readString = parcel.readString();
        int i = zzen.zza;
        String str = readString;
        this.zza = readString;
        byte[] createByteArray = parcel.createByteArray();
        this.zzb = createByteArray;
        this.zzc = parcel.readInt();
        int readInt = parcel.readInt();
        this.zzd = readInt;
        zzb(readString, createByteArray, readInt);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzb(java.lang.String r6, byte[] r7, int r8) {
        /*
            int r0 = r6.hashCode()
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 1
            r5 = 0
            switch(r0) {
                case -1949883051: goto L_0x0035;
                case -1555642602: goto L_0x002b;
                case 101820674: goto L_0x0021;
                case 188404399: goto L_0x0017;
                case 1805012160: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003f
        L_0x000d:
            java.lang.String r0 = "editable.tracks.map"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = r1
            goto L_0x0040
        L_0x0017:
            java.lang.String r0 = "editable.tracks.offset"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = r4
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "editable.tracks.length"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = r2
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "editable.tracks.samples.location"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = r3
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "com.android.capture.fps"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = r5
            goto L_0x0040
        L_0x003f:
            r6 = -1
        L_0x0040:
            if (r6 == 0) goto L_0x0075
            if (r6 == r4) goto L_0x0066
            if (r6 == r2) goto L_0x0066
            if (r6 == r1) goto L_0x005e
            if (r6 == r3) goto L_0x004b
            return
        L_0x004b:
            r6 = 75
            if (r8 != r6) goto L_0x0059
            int r6 = r7.length
            if (r6 != r4) goto L_0x0059
            byte r6 = r7[r5]
            if (r6 == 0) goto L_0x005a
            if (r6 != r4) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r4 = r5
        L_0x005a:
            com.google.android.gms.internal.ads.zzdb.zzd(r4)
            return
        L_0x005e:
            if (r8 != 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = r5
        L_0x0062:
            com.google.android.gms.internal.ads.zzdb.zzd(r4)
            return
        L_0x0066:
            r6 = 78
            if (r8 != r6) goto L_0x0070
            int r6 = r7.length
            r7 = 8
            if (r6 != r7) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r4 = r5
        L_0x0071:
            com.google.android.gms.internal.ads.zzdb.zzd(r4)
            return
        L_0x0075:
            r6 = 23
            if (r8 != r6) goto L_0x007d
            int r6 = r7.length
            if (r6 != r3) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r4 = r5
        L_0x007e:
            com.google.android.gms.internal.ads.zzdb.zzd(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzer.zzb(java.lang.String, byte[], int):void");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzer zzer = (zzer) obj;
            return this.zza.equals(zzer.zza) && Arrays.equals(this.zzb, zzer.zzb) && this.zzc == zzer.zzc && this.zzd == zzer.zzd;
        }
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final /* synthetic */ void zza(zzay zzay) {
    }

    public zzer(String str, byte[] bArr, int i, int i2) {
        zzb(str, bArr, i2);
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final String toString() {
        String str;
        int i = this.zzd;
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                str = zzen.zzB(this.zzb);
            } else if (i == 23) {
                str = String.valueOf(Float.intBitsToFloat(zzgcr.zzd(this.zzb)));
            } else if (i == 67) {
                str = String.valueOf(zzgcr.zzd(this.zzb));
            } else if (i == 75) {
                str = String.valueOf(this.zzb[0] & 255);
            } else if (i == 78) {
                str = String.valueOf(new zzed(this.zzb).zzw());
            }
            String str2 = this.zza;
            return "mdta: key=" + str2 + ", value=" + str;
        } else if (this.zza.equals("editable.tracks.map")) {
            zzdb.zzg(this.zza.equals("editable.tracks.map"), "Metadata is not an editable tracks map");
            byte b = this.zzb[1];
            ArrayList arrayList = new ArrayList();
            while (i2 < b) {
                arrayList.add(Integer.valueOf(this.zzb[i2 + 2]));
                i2++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("track types = ");
            String str3 = ",";
            zzfwi.zzb(sb, arrayList, ",");
            str = sb.toString();
            String str22 = this.zza;
            return "mdta: key=" + str22 + ", value=" + str;
        }
        byte[] bArr = this.zzb;
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length + length);
        while (i2 < bArr.length) {
            sb2.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb2.append(Character.forDigit(bArr[i2] & Ascii.SI, 16));
            i2++;
        }
        str = sb2.toString();
        String str222 = this.zza;
        return "mdta: key=" + str222 + ", value=" + str;
    }
}
