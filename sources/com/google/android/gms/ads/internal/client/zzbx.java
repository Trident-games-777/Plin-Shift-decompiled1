package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzbx extends zzayd implements zzby {
    public zzbx() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzby zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzby ? (zzby) queryLocalInterface : new zzbw(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: com.google.android.gms.ads.internal.client.zzcq} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [com.google.android.gms.ads.internal.client.zzbl] */
    /* JADX WARNING: type inference failed for: r6v7, types: [com.google.android.gms.ads.internal.client.zzcm] */
    /* JADX WARNING: type inference failed for: r6v13, types: [com.google.android.gms.ads.internal.client.zzbi] */
    /* JADX WARNING: type inference failed for: r6v23, types: [com.google.android.gms.ads.internal.client.zzcc] */
    /* JADX WARNING: type inference failed for: r6v28, types: [com.google.android.gms.ads.internal.client.zzdr] */
    /* JADX WARNING: type inference failed for: r6v33, types: [com.google.android.gms.ads.internal.client.zzbo] */
    /* JADX WARNING: type inference failed for: r6v38, types: [com.google.android.gms.ads.internal.client.zzct] */
    /* JADX WARNING: type inference failed for: r6v43 */
    /* JADX WARNING: type inference failed for: r6v44 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v48 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 0
            switch(r3) {
                case 1: goto L_0x02ff;
                case 2: goto L_0x02f8;
                case 3: goto L_0x02eb;
                case 4: goto L_0x02d5;
                case 5: goto L_0x02ce;
                case 6: goto L_0x02c7;
                case 7: goto L_0x02a4;
                case 8: goto L_0x0281;
                case 9: goto L_0x0279;
                case 10: goto L_0x0274;
                case 11: goto L_0x026c;
                case 12: goto L_0x0260;
                case 13: goto L_0x024d;
                case 14: goto L_0x023a;
                case 15: goto L_0x0223;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0217;
                case 19: goto L_0x0204;
                case 20: goto L_0x01e0;
                case 21: goto L_0x01bc;
                case 22: goto L_0x01ad;
                case 23: goto L_0x019f;
                case 24: goto L_0x018c;
                case 25: goto L_0x017d;
                case 26: goto L_0x0171;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x015e;
                case 30: goto L_0x014b;
                case 31: goto L_0x013f;
                case 32: goto L_0x0133;
                case 33: goto L_0x0127;
                case 34: goto L_0x0118;
                case 35: goto L_0x010c;
                case 36: goto L_0x00e8;
                case 37: goto L_0x00dc;
                case 38: goto L_0x00cd;
                case 39: goto L_0x00ba;
                case 40: goto L_0x00a7;
                case 41: goto L_0x009b;
                case 42: goto L_0x0077;
                case 43: goto L_0x004b;
                case 44: goto L_0x0038;
                case 45: goto L_0x0014;
                case 46: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r3 = 0
            return r3
        L_0x0006:
            boolean r3 = r2.zzY()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzaye.zza
            r5.writeInt(r3)
            goto L_0x0309
        L_0x0014:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x001b
            goto L_0x002d
        L_0x001b:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzct
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.ads.internal.client.zzct r6 = (com.google.android.gms.ads.internal.client.zzct) r6
            goto L_0x002d
        L_0x0028:
            com.google.android.gms.ads.internal.client.zzcr r6 = new com.google.android.gms.ads.internal.client.zzcr
            r6.<init>(r3)
        L_0x002d:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzJ(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x0038:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzW(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzm> r3 = com.google.android.gms.ads.internal.client.zzm.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzm r3 = (com.google.android.gms.ads.internal.client.zzm) r3
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x005a
            goto L_0x006c
        L_0x005a:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r6 = r0.queryLocalInterface(r6)
            boolean r1 = r6 instanceof com.google.android.gms.ads.internal.client.zzbo
            if (r1 == 0) goto L_0x0067
            com.google.android.gms.ads.internal.client.zzbo r6 = (com.google.android.gms.ads.internal.client.zzbo) r6
            goto L_0x006c
        L_0x0067:
            com.google.android.gms.ads.internal.client.zzbm r6 = new com.google.android.gms.ads.internal.client.zzbm
            r6.<init>(r0)
        L_0x006c:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzy(r3, r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x0077:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x007e
            goto L_0x0090
        L_0x007e:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzdr
            if (r0 == 0) goto L_0x008b
            com.google.android.gms.ads.internal.client.zzdr r6 = (com.google.android.gms.ads.internal.client.zzdr) r6
            goto L_0x0090
        L_0x008b:
            com.google.android.gms.ads.internal.client.zzdp r6 = new com.google.android.gms.ads.internal.client.zzdp
            r6.<init>(r3)
        L_0x0090:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzP(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x009b:
            com.google.android.gms.ads.internal.client.zzdy r3 = r2.zzk()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0309
        L_0x00a7:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbai r3 = com.google.android.gms.internal.ads.zzbah.zze(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzH(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x00ba:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzy> r3 = com.google.android.gms.ads.internal.client.zzy.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzy r3 = (com.google.android.gms.ads.internal.client.zzy) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzI(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x00cd:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzR(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x00dc:
            android.os.Bundle r3 = r2.zzd()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zze(r5, r3)
            goto L_0x0309
        L_0x00e8:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00ef
            goto L_0x0101
        L_0x00ef:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcc
            if (r0 == 0) goto L_0x00fc
            com.google.android.gms.ads.internal.client.zzcc r6 = (com.google.android.gms.ads.internal.client.zzcc) r6
            goto L_0x0101
        L_0x00fc:
            com.google.android.gms.ads.internal.client.zzca r6 = new com.google.android.gms.ads.internal.client.zzca
            r6.<init>(r3)
        L_0x0101:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzE(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x010c:
            java.lang.String r3 = r2.zzt()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0309
        L_0x0118:
            boolean r3 = com.google.android.gms.internal.ads.zzaye.zzg(r4)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzL(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x0127:
            com.google.android.gms.ads.internal.client.zzbl r3 = r2.zzi()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0309
        L_0x0133:
            com.google.android.gms.ads.internal.client.zzcm r3 = r2.zzj()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0309
        L_0x013f:
            java.lang.String r3 = r2.zzr()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0309
        L_0x014b:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzef> r3 = com.google.android.gms.ads.internal.client.zzef.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzef r3 = (com.google.android.gms.ads.internal.client.zzef) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzK(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x015e:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzga> r3 = com.google.android.gms.ads.internal.client.zzga.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzga r3 = (com.google.android.gms.ads.internal.client.zzga) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzU(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x0171:
            com.google.android.gms.ads.internal.client.zzeb r3 = r2.zzl()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
            goto L_0x0309
        L_0x017d:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzT(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x018c:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbwp r3 = com.google.android.gms.internal.ads.zzbwo.zzb(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzS(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x019f:
            boolean r3 = r2.zzZ()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzaye.zza
            r5.writeInt(r3)
            goto L_0x0309
        L_0x01ad:
            boolean r3 = com.google.android.gms.internal.ads.zzaye.zzg(r4)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzN(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x01bc:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01c3
            goto L_0x01d5
        L_0x01c3:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcq
            if (r0 == 0) goto L_0x01d0
            com.google.android.gms.ads.internal.client.zzcq r6 = (com.google.android.gms.ads.internal.client.zzcq) r6
            goto L_0x01d5
        L_0x01d0:
            com.google.android.gms.ads.internal.client.zzcq r6 = new com.google.android.gms.ads.internal.client.zzcq
            r6.<init>(r3)
        L_0x01d5:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzac(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x01e0:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01e7
            goto L_0x01f9
        L_0x01e7:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbi
            if (r0 == 0) goto L_0x01f4
            com.google.android.gms.ads.internal.client.zzbi r6 = (com.google.android.gms.ads.internal.client.zzbi) r6
            goto L_0x01f9
        L_0x01f4:
            com.google.android.gms.ads.internal.client.zzbg r6 = new com.google.android.gms.ads.internal.client.zzbg
            r6.<init>(r3)
        L_0x01f9:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzC(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x0204:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbdi r3 = com.google.android.gms.internal.ads.zzbdh.zzb(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzO(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x0217:
            java.lang.String r3 = r2.zzs()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0309
        L_0x0223:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbts r3 = com.google.android.gms.internal.ads.zzbtr.zzb(r3)
            java.lang.String r6 = r4.readString()
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzQ(r3, r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x023a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbtp r3 = com.google.android.gms.internal.ads.zzbto.zzb(r3)
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzM(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x024d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzs> r3 = com.google.android.gms.ads.internal.client.zzs.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzs r3 = (com.google.android.gms.ads.internal.client.zzs) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzF(r3)
            r5.writeNoException()
            goto L_0x0309
        L_0x0260:
            com.google.android.gms.ads.internal.client.zzs r3 = r2.zzg()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zze(r5, r3)
            goto L_0x0309
        L_0x026c:
            r2.zzA()
            r5.writeNoException()
            goto L_0x0309
        L_0x0274:
            r5.writeNoException()
            goto L_0x0309
        L_0x0279:
            r2.zzX()
            r5.writeNoException()
            goto L_0x0309
        L_0x0281:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0288
            goto L_0x029a
        L_0x0288:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcm
            if (r0 == 0) goto L_0x0295
            com.google.android.gms.ads.internal.client.zzcm r6 = (com.google.android.gms.ads.internal.client.zzcm) r6
            goto L_0x029a
        L_0x0295:
            com.google.android.gms.ads.internal.client.zzck r6 = new com.google.android.gms.ads.internal.client.zzck
            r6.<init>(r3)
        L_0x029a:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzG(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x02a4:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x02ab
            goto L_0x02bd
        L_0x02ab:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbl
            if (r0 == 0) goto L_0x02b8
            com.google.android.gms.ads.internal.client.zzbl r6 = (com.google.android.gms.ads.internal.client.zzbl) r6
            goto L_0x02bd
        L_0x02b8:
            com.google.android.gms.ads.internal.client.zzbj r6 = new com.google.android.gms.ads.internal.client.zzbj
            r6.<init>(r3)
        L_0x02bd:
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            r2.zzD(r6)
            r5.writeNoException()
            goto L_0x0309
        L_0x02c7:
            r2.zzB()
            r5.writeNoException()
            goto L_0x0309
        L_0x02ce:
            r2.zzz()
            r5.writeNoException()
            goto L_0x0309
        L_0x02d5:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzm> r3 = com.google.android.gms.ads.internal.client.zzm.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzaye.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzm r3 = (com.google.android.gms.ads.internal.client.zzm) r3
            com.google.android.gms.internal.ads.zzaye.zzc(r4)
            boolean r3 = r2.zzab(r3)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x0309
        L_0x02eb:
            boolean r3 = r2.zzaa()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzaye.zza
            r5.writeInt(r3)
            goto L_0x0309
        L_0x02f8:
            r2.zzx()
            r5.writeNoException()
            goto L_0x0309
        L_0x02ff:
            com.google.android.gms.dynamic.IObjectWrapper r3 = r2.zzn()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzaye.zzf(r5, r3)
        L_0x0309:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbx.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
