package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbt extends zzayd implements zzbu {
    public zzbt() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.ads.internal.client.zzcq} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.ads.internal.client.zzbl] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x011c;
                case 2: goto L_0x00f9;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00d5;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00a4;
                case 7: goto L_0x0080;
                case 8: goto L_0x0065;
                case 9: goto L_0x0052;
                case 10: goto L_0x003f;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x002c;
                case 14: goto L_0x0019;
                case 15: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.AdManagerAdViewOptions> r2 = com.google.android.gms.ads.formats.AdManagerAdViewOptions.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            com.google.android.gms.ads.formats.AdManagerAdViewOptions r2 = (com.google.android.gms.ads.formats.AdManagerAdViewOptions) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x0019:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbmk r2 = com.google.android.gms.internal.ads.zzbmj.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzi(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbmb> r2 = com.google.android.gms.internal.ads.zzbmb.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbmb r2 = (com.google.android.gms.internal.ads.zzbmb) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzn(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x003f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbhm r2 = com.google.android.gms.internal.ads.zzbhl.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzk(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x0052:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r2 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r2 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzp(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x0065:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbhj r2 = com.google.android.gms.internal.ads.zzbhi.zzb(r2)
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzs> r5 = com.google.android.gms.ads.internal.client.zzs.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.ads.zzaye.zza(r3, r5)
            com.google.android.gms.ads.internal.client.zzs r5 = (com.google.android.gms.ads.internal.client.zzs) r5
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzj(r2, r5)
            r4.writeNoException()
            goto L_0x0126
        L_0x0080:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0087
            goto L_0x0099
        L_0x0087:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.ads.internal.client.zzcq
            if (r0 == 0) goto L_0x0094
            com.google.android.gms.ads.internal.client.zzcq r5 = (com.google.android.gms.ads.internal.client.zzcq) r5
            goto L_0x0099
        L_0x0094:
            com.google.android.gms.ads.internal.client.zzcq r5 = new com.google.android.gms.ads.internal.client.zzcq
            r5.<init>(r2)
        L_0x0099:
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzq(r5)
            r4.writeNoException()
            goto L_0x0126
        L_0x00a4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbfn> r2 = com.google.android.gms.internal.ads.zzbfn.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzaye.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbfn r2 = (com.google.android.gms.internal.ads.zzbfn) r2
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzo(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x00b7:
            java.lang.String r2 = r3.readString()
            android.os.IBinder r5 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbhf r5 = com.google.android.gms.internal.ads.zzbhe.zzb(r5)
            android.os.IBinder r0 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbhc r0 = com.google.android.gms.internal.ads.zzbhb.zzb(r0)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzh(r2, r5, r0)
            r4.writeNoException()
            goto L_0x0126
        L_0x00d5:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbgz r2 = com.google.android.gms.internal.ads.zzbgy.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzg(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x00e7:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbgw r2 = com.google.android.gms.internal.ads.zzbgv.zzb(r2)
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzf(r2)
            r4.writeNoException()
            goto L_0x0126
        L_0x00f9:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0100
            goto L_0x0112
        L_0x0100:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.ads.internal.client.zzbl
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.ads.internal.client.zzbl r5 = (com.google.android.gms.ads.internal.client.zzbl) r5
            goto L_0x0112
        L_0x010d:
            com.google.android.gms.ads.internal.client.zzbj r5 = new com.google.android.gms.ads.internal.client.zzbj
            r5.<init>(r2)
        L_0x0112:
            com.google.android.gms.internal.ads.zzaye.zzc(r3)
            r1.zzl(r5)
            r4.writeNoException()
            goto L_0x0126
        L_0x011c:
            com.google.android.gms.ads.internal.client.zzbr r2 = r1.zze()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r4, r2)
        L_0x0126:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbt.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
