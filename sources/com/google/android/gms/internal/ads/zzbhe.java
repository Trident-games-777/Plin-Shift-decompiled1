package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbhe extends zzayd implements zzbhf {
    public zzbhe() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzbhf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        return queryLocalInterface instanceof zzbhf ? (zzbhf) queryLocalInterface : new zzbhd(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 != r6) goto L_0x0029
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x000b
            r3 = 0
            goto L_0x001f
        L_0x000b:
            java.lang.String r0 = "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbgs
            if (r1 == 0) goto L_0x0019
            r3 = r0
            com.google.android.gms.internal.ads.zzbgs r3 = (com.google.android.gms.internal.ads.zzbgs) r3
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.ads.zzbgq r0 = new com.google.android.gms.internal.ads.zzbgq
            r0.<init>(r3)
            r3 = r0
        L_0x001f:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zze(r3)
            r5.writeNoException()
            return r6
        L_0x0029:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhe.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
