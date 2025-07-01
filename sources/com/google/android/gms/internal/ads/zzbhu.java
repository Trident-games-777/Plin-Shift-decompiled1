package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbhu extends zzayd implements zzbhv {
    public zzbhu() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 2: goto L_0x01b4;
                case 3: goto L_0x01a9;
                case 4: goto L_0x019e;
                case 5: goto L_0x0193;
                case 6: goto L_0x0188;
                case 7: goto L_0x017d;
                case 8: goto L_0x0172;
                case 9: goto L_0x0167;
                case 10: goto L_0x015c;
                case 11: goto L_0x0151;
                case 12: goto L_0x0145;
                case 13: goto L_0x013d;
                case 14: goto L_0x0131;
                case 15: goto L_0x011e;
                case 16: goto L_0x0107;
                case 17: goto L_0x00f4;
                case 18: goto L_0x00e8;
                case 19: goto L_0x00dc;
                case 20: goto L_0x00d0;
                case 21: goto L_0x00a9;
                case 22: goto L_0x00a1;
                case 23: goto L_0x0095;
                case 24: goto L_0x0087;
                case 25: goto L_0x0074;
                case 26: goto L_0x0061;
                case 27: goto L_0x0059;
                case 28: goto L_0x0051;
                case 29: goto L_0x0045;
                case 30: goto L_0x0037;
                case 31: goto L_0x002b;
                case 32: goto L_0x0018;
                case 33: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzB(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x0018:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdr r2 = com.google.android.gms.ads.internal.client.zzdq.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzF(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x002b:
            com.google.android.gms.ads.internal.client.zzdy r2 = r1.zzg()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x0037:
            boolean r2 = r1.zzH()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzaye.zza
            r4.writeInt(r2)
            goto L_0x01be
        L_0x0045:
            com.google.android.gms.internal.ads.zzbfv r2 = r1.zzj()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x0051:
            r1.zzA()
            r4.writeNoException()
            goto L_0x01be
        L_0x0059:
            r1.zzD()
            r4.writeNoException()
            goto L_0x01be
        L_0x0061:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdd r2 = com.google.android.gms.ads.internal.client.zzdc.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzE(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x0074:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdh r2 = com.google.android.gms.ads.internal.client.zzdg.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzy(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x0087:
            boolean r2 = r1.zzI()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzaye.zza
            r4.writeInt(r2)
            goto L_0x01be
        L_0x0095:
            java.util.List r2 = r1.zzv()
            r4.writeNoException()
            r4.writeList(r2)
            goto L_0x01be
        L_0x00a1:
            r1.zzw()
            r4.writeNoException()
            goto L_0x01be
        L_0x00a9:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00b1
            r2 = 0
            goto L_0x00c5
        L_0x00b1:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbhs
            if (r0 == 0) goto L_0x00bf
            r2 = r5
            com.google.android.gms.internal.ads.zzbhs r2 = (com.google.android.gms.internal.ads.zzbhs) r2
            goto L_0x00c5
        L_0x00bf:
            com.google.android.gms.internal.ads.zzbhq r5 = new com.google.android.gms.internal.ads.zzbhq
            r5.<init>(r2)
            r2 = r5
        L_0x00c5:
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzG(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x00d0:
            android.os.Bundle r2 = r1.zzf()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zze(r4, r2)
            goto L_0x01be
        L_0x00dc:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzl()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x00e8:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzm()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x00f4:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzC(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x0107:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            boolean r2 = r1.zzJ(r2)
            r4.writeNoException()
            r4.writeInt(r2)
            goto L_0x01be
        L_0x011e:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzz(r2)
            r4.writeNoException()
            goto L_0x01be
        L_0x0131:
            com.google.android.gms.internal.ads.zzbfr r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x013d:
            r1.zzx()
            r4.writeNoException()
            goto L_0x01be
        L_0x0145:
            java.lang.String r2 = r1.zzr()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x0151:
            com.google.android.gms.ads.internal.client.zzeb r2 = r1.zzh()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x015c:
            java.lang.String r2 = r1.zzs()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x0167:
            java.lang.String r2 = r1.zzt()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x0172:
            double r2 = r1.zze()
            r4.writeNoException()
            r4.writeDouble(r2)
            goto L_0x01be
        L_0x017d:
            java.lang.String r2 = r1.zzn()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x0188:
            java.lang.String r2 = r1.zzp()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x0193:
            com.google.android.gms.internal.ads.zzbfy r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
            goto L_0x01be
        L_0x019e:
            java.lang.String r2 = r1.zzo()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01be
        L_0x01a9:
            java.util.List r2 = r1.zzu()
            r4.writeNoException()
            r4.writeList(r2)
            goto L_0x01be
        L_0x01b4:
            java.lang.String r2 = r1.zzq()
            r4.writeNoException()
            r4.writeString(r2)
        L_0x01be:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhu.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
