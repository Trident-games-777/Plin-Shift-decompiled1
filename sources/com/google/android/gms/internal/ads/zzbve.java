package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzbve extends zzayd implements zzbvf {
    public zzbve() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: com.google.android.gms.internal.ads.zzbvq} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzbvp] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzbvp] */
    /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.internal.ads.zzbvp] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.internal.ads.zzbvp] */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r0v31 */
    /* JADX WARNING: type inference failed for: r0v32 */
    /* JADX WARNING: type inference failed for: r0v33 */
    /* JADX WARNING: type inference failed for: r0v34 */
    /* JADX WARNING: type inference failed for: r0v35 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            java.lang.String r6 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            r0 = 0
            switch(r3) {
                case 1: goto L_0x00fc;
                case 2: goto L_0x00da;
                case 3: goto L_0x0006;
                case 4: goto L_0x00b0;
                case 5: goto L_0x0086;
                case 6: goto L_0x005b;
                case 7: goto L_0x0034;
                case 8: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r3 = 0
            return r3
        L_0x0008:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbuz> r3 = com.google.android.gms.internal.ads.zzbuz.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbuz r3 = (com.google.android.gms.internal.ads.zzbuz) r3
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x0017
            goto L_0x0029
        L_0x0017:
            java.lang.String r0 = "com.google.android.gms.ads.internal.request.ITrustlessTokenListener"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbvq
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbvq r0 = (com.google.android.gms.internal.ads.zzbvq) r0
            goto L_0x0029
        L_0x0024:
            com.google.android.gms.internal.ads.zzbvq r0 = new com.google.android.gms.internal.ads.zzbvq
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzi(r3, r0)
            r5.writeNoException()
            goto L_0x010d
        L_0x0034:
            java.lang.String r3 = r4.readString()
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x003f
            goto L_0x0050
        L_0x003f:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbvp
            if (r0 == 0) goto L_0x004b
            r0 = r6
            com.google.android.gms.internal.ads.zzbvp r0 = (com.google.android.gms.internal.ads.zzbvp) r0
            goto L_0x0050
        L_0x004b:
            com.google.android.gms.internal.ads.zzbvn r0 = new com.google.android.gms.internal.ads.zzbvn
            r0.<init>(r1)
        L_0x0050:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzh(r3, r0)
            r5.writeNoException()
            goto L_0x010d
        L_0x005b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbvx> r3 = com.google.android.gms.internal.ads.zzbvx.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbvx r3 = (com.google.android.gms.internal.ads.zzbvx) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x006a
            goto L_0x007b
        L_0x006a:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbvp
            if (r0 == 0) goto L_0x0076
            r0 = r6
            com.google.android.gms.internal.ads.zzbvp r0 = (com.google.android.gms.internal.ads.zzbvp) r0
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.internal.ads.zzbvn r0 = new com.google.android.gms.internal.ads.zzbvn
            r0.<init>(r1)
        L_0x007b:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zze(r3, r0)
            r5.writeNoException()
            goto L_0x010d
        L_0x0086:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbvx> r3 = com.google.android.gms.internal.ads.zzbvx.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbvx r3 = (com.google.android.gms.internal.ads.zzbvx) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0095
            goto L_0x00a6
        L_0x0095:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbvp
            if (r0 == 0) goto L_0x00a1
            r0 = r6
            com.google.android.gms.internal.ads.zzbvp r0 = (com.google.android.gms.internal.ads.zzbvp) r0
            goto L_0x00a6
        L_0x00a1:
            com.google.android.gms.internal.ads.zzbvn r0 = new com.google.android.gms.internal.ads.zzbvn
            r0.<init>(r1)
        L_0x00a6:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzf(r3, r0)
            r5.writeNoException()
            goto L_0x010d
        L_0x00b0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbvx> r3 = com.google.android.gms.internal.ads.zzbvx.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbvx r3 = (com.google.android.gms.internal.ads.zzbvx) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x00bf
            goto L_0x00d0
        L_0x00bf:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbvp
            if (r0 == 0) goto L_0x00cb
            r0 = r6
            com.google.android.gms.internal.ads.zzbvp r0 = (com.google.android.gms.internal.ads.zzbvp) r0
            goto L_0x00d0
        L_0x00cb:
            com.google.android.gms.internal.ads.zzbvn r0 = new com.google.android.gms.internal.ads.zzbvn
            r0.<init>(r1)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzg(r3, r0)
            r5.writeNoException()
            goto L_0x010d
        L_0x00da:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbus> r3 = com.google.android.gms.internal.ads.zzbus.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbus r3 = (com.google.android.gms.internal.ads.zzbus) r3
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00e9
            goto L_0x00f5
        L_0x00e9:
            java.lang.String r6 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r3 = r3.queryLocalInterface(r6)
            boolean r6 = r3 instanceof com.google.android.gms.internal.ads.zzbvg
            if (r6 == 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzbvg r3 = (com.google.android.gms.internal.ads.zzbvg) r3
        L_0x00f5:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r5.writeNoException()
            goto L_0x010d
        L_0x00fc:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbus> r3 = com.google.android.gms.internal.ads.zzbus.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbus r3 = (com.google.android.gms.internal.ads.zzbus) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zze(r5, r0)
        L_0x010d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbve.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
