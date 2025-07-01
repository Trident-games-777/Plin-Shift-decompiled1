package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzch extends zzayd implements zzci {
    public zzch() {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            switch(r3) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0074;
                case 3: goto L_0x0062;
                case 4: goto L_0x0050;
                case 5: goto L_0x003e;
                case 6: goto L_0x002b;
                case 7: goto L_0x0018;
                case 8: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r3 = 0
            return r3
        L_0x0005:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbpg r3 = com.google.android.gms.internal.ads.zzbpf.zzf(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzh(r3)
            r5.writeNoException()
            goto L_0x00b1
        L_0x0018:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            com.google.android.gms.ads.internal.client.zzby r3 = r2.zzf(r3)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x00b1
        L_0x002b:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            boolean r3 = r2.zzk(r3)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x00b1
        L_0x003e:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            com.google.android.gms.internal.ads.zzbaf r3 = r2.zze(r3)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x00b1
        L_0x0050:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            boolean r3 = r2.zzj(r3)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x00b1
        L_0x0062:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            com.google.android.gms.internal.ads.zzbxc r3 = r2.zzg(r3)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x00b1
        L_0x0074:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            boolean r3 = r2.zzl(r3)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x00b1
        L_0x0086:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzft> r3 = com.google.android.gms.ads.internal.client.zzft.CREATOR
            java.util.ArrayList r3 = r4.createTypedArrayList(r3)
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x0094
            r6 = 0
            goto L_0x00a8
        L_0x0094:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdPreloadCallback"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.ads.internal.client.zzcf
            if (r1 == 0) goto L_0x00a2
            r6 = r0
            com.google.android.gms.ads.internal.client.zzcf r6 = (com.google.android.gms.ads.internal.client.zzcf) r6
            goto L_0x00a8
        L_0x00a2:
            com.google.android.gms.ads.internal.client.zzcd r0 = new com.google.android.gms.ads.internal.client.zzcd
            r0.<init>(r6)
            r6 = r0
        L_0x00a8:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzi(r3, r6)
            r5.writeNoException()
        L_0x00b1:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzch.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
