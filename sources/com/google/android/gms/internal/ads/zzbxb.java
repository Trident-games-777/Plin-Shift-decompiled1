package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbxb extends zzayd implements zzbxc {
    public zzbxb() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbxc zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return queryLocalInterface instanceof zzbxc ? (zzbxc) queryLocalInterface : new zzbxa(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzbxk} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzbxj] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzbxf] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.internal.ads.zzbxj] */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            r0 = 0
            switch(r3) {
                case 1: goto L_0x0129;
                case 2: goto L_0x0105;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00ed;
                case 5: goto L_0x00db;
                case 6: goto L_0x00b6;
                case 7: goto L_0x00a3;
                case 8: goto L_0x0090;
                case 9: goto L_0x0084;
                case 10: goto L_0x006d;
                case 11: goto L_0x0061;
                case 12: goto L_0x0055;
                case 13: goto L_0x0042;
                case 14: goto L_0x0017;
                case 15: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r3 = 0
            return r3
        L_0x0008:
            boolean r3 = com.google.android.gms.internal.ads.zzaye.zzg(r4)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzh(r3)
            r5.writeNoException()
            goto L_0x0152
        L_0x0017:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzm> r3 = com.google.android.gms.ads.internal.client.zzm.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzm r3 = (com.google.android.gms.ads.internal.client.zzm) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0026
            goto L_0x0037
        L_0x0026:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxj
            if (r0 == 0) goto L_0x0032
            r0 = r6
            com.google.android.gms.internal.ads.zzbxj r0 = (com.google.android.gms.internal.ads.zzbxj) r0
            goto L_0x0037
        L_0x0032:
            com.google.android.gms.internal.ads.zzbxh r0 = new com.google.android.gms.internal.ads.zzbxh
            r0.<init>(r1)
        L_0x0037:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzg(r3, r0)
            r5.writeNoException()
            goto L_0x0152
        L_0x0042:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdr r3 = com.google.android.gms.ads.internal.client.zzdq.zzb(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzj(r3)
            r5.writeNoException()
            goto L_0x0152
        L_0x0055:
            com.google.android.gms.ads.internal.client.zzdy r3 = r2.zzc()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0152
        L_0x0061:
            com.google.android.gms.internal.ads.zzbwz r3 = r2.zzd()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0152
        L_0x006d:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r6 = com.google.android.gms.internal.ads.zzaye.zzg(r4)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzn(r3, r6)
            r5.writeNoException()
            goto L_0x0152
        L_0x0084:
            android.os.Bundle r3 = r2.zzb()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zze(r5, r3)
            goto L_0x0152
        L_0x0090:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdo r3 = com.google.android.gms.ads.internal.client.zzdn.zzb(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzi(r3)
            r5.writeNoException()
            goto L_0x0152
        L_0x00a3:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbxq> r3 = com.google.android.gms.internal.ads.zzbxq.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbxq r3 = (com.google.android.gms.internal.ads.zzbxq) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzl(r3)
            r5.writeNoException()
            goto L_0x0152
        L_0x00b6:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00bd
            goto L_0x00d0
        L_0x00bd:
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxk
            if (r0 == 0) goto L_0x00cb
            r0 = r6
            com.google.android.gms.internal.ads.zzbxk r0 = (com.google.android.gms.internal.ads.zzbxk) r0
            goto L_0x00d0
        L_0x00cb:
            com.google.android.gms.internal.ads.zzbxk r0 = new com.google.android.gms.internal.ads.zzbxk
            r0.<init>(r3)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzp(r0)
            r5.writeNoException()
            goto L_0x0152
        L_0x00db:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzm(r3)
            r5.writeNoException()
            goto L_0x0152
        L_0x00ed:
            java.lang.String r3 = r2.zze()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0152
        L_0x00f8:
            boolean r3 = r2.zzo()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzaye.zza
            r5.writeInt(r3)
            goto L_0x0152
        L_0x0105:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x010c
            goto L_0x011f
        L_0x010c:
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxf
            if (r0 == 0) goto L_0x011a
            r0 = r6
            com.google.android.gms.internal.ads.zzbxf r0 = (com.google.android.gms.internal.ads.zzbxf) r0
            goto L_0x011f
        L_0x011a:
            com.google.android.gms.internal.ads.zzbxd r0 = new com.google.android.gms.internal.ads.zzbxd
            r0.<init>(r3)
        L_0x011f:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzk(r0)
            r5.writeNoException()
            goto L_0x0152
        L_0x0129:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzm> r3 = com.google.android.gms.ads.internal.client.zzm.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzm r3 = (com.google.android.gms.ads.internal.client.zzm) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0138
            goto L_0x0149
        L_0x0138:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxj
            if (r0 == 0) goto L_0x0144
            r0 = r6
            com.google.android.gms.internal.ads.zzbxj r0 = (com.google.android.gms.internal.ads.zzbxj) r0
            goto L_0x0149
        L_0x0144:
            com.google.android.gms.internal.ads.zzbxh r0 = new com.google.android.gms.internal.ads.zzbxh
            r0.<init>(r1)
        L_0x0149:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzf(r3, r0)
            r5.writeNoException()
        L_0x0152:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxb.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
