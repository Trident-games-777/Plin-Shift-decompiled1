package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfgd {
    public zzfgd() {
        try {
            zzggr.zza();
        } catch (GeneralSecurityException e) {
            zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            zzv.zzp().zzw(e, "CryptoUtils.registerAead");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        throw new java.security.GeneralSecurityException("Serialize keyset failed");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String zza() {
        /*
            java.lang.String r0 = "AES128_GCM"
            com.google.android.gms.internal.ads.zzgnv r1 = com.google.android.gms.internal.ads.zzgnv.zzb()     // Catch:{ GeneralSecurityException -> 0x002b }
            com.google.android.gms.internal.ads.zzggj r0 = r1.zza(r0)     // Catch:{ GeneralSecurityException -> 0x002b }
            com.google.android.gms.internal.ads.zzggj r0 = com.google.android.gms.internal.ads.zzgfz.zza(r0)     // Catch:{ GeneralSecurityException -> 0x002b }
            com.google.android.gms.internal.ads.zzggf r0 = com.google.android.gms.internal.ads.zzggf.zzb(r0)     // Catch:{ GeneralSecurityException -> 0x002b }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0023 }
            r1.<init>()     // Catch:{ IOException -> 0x0023 }
            com.google.android.gms.internal.ads.zzgfo r2 = com.google.android.gms.internal.ads.zzgfo.zzb(r1)     // Catch:{ IOException -> 0x0023 }
            com.google.android.gms.internal.ads.zzgfp.zzb(r0, r2)     // Catch:{ IOException -> 0x0023 }
            byte[] r0 = r1.toByteArray()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0045
        L_0x0023:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ GeneralSecurityException -> 0x002b }
            java.lang.String r1 = "Serialize keyset failed"
            r0.<init>(r1)     // Catch:{ GeneralSecurityException -> 0x002b }
            throw r0     // Catch:{ GeneralSecurityException -> 0x002b }
        L_0x002b:
            r0 = move-exception
            java.lang.String r1 = "Failed to generate key"
            java.lang.String r2 = r0.toString()
            java.lang.String r1 = r1.concat(r2)
            com.google.android.gms.ads.internal.util.zze.zza(r1)
            java.lang.String r1 = "CryptoUtils.generateKey"
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()
            r2.zzw(r0, r1)
            r0 = 0
            byte[] r0 = new byte[r0]
        L_0x0045:
            r1 = 11
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgd.zza():java.lang.String");
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsh zzdsh) {
        zzggf zzc = zzc(str);
        if (zzc != null) {
            try {
                byte[] zza = ((zzgfm) zzc.zzd(zzgpa.zzd(), zzgfm.class)).zza(bArr, bArr2);
                zzdsh.zzb().put("ds", DiskLruCache.VERSION);
                return new String(zza, "UTF-8");
            } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
                zze.zza("Failed to decrypt ".concat(e.toString()));
                zzv.zzp().zzw(e, "CryptoUtils.decrypt");
                zzdsh.zzb().put("dsf", e.toString());
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        throw new java.security.GeneralSecurityException("Parse keyset failed");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.google.android.gms.internal.ads.zzggf zzc(java.lang.String r2) {
        /*
            r0 = 11
            byte[] r2 = android.util.Base64.decode(r2, r0)     // Catch:{ GeneralSecurityException -> 0x0017 }
            com.google.android.gms.internal.ads.zzgfn r2 = com.google.android.gms.internal.ads.zzgfn.zzb(r2)     // Catch:{ IOException -> 0x000f }
            com.google.android.gms.internal.ads.zzggf r2 = com.google.android.gms.internal.ads.zzgfp.zza(r2)     // Catch:{ IOException -> 0x000f }
            return r2
        L_0x000f:
            java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException     // Catch:{ GeneralSecurityException -> 0x0017 }
            java.lang.String r0 = "Parse keyset failed"
            r2.<init>(r0)     // Catch:{ GeneralSecurityException -> 0x0017 }
            throw r2     // Catch:{ GeneralSecurityException -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            java.lang.String r0 = "Failed to get keysethandle"
            java.lang.String r1 = r2.toString()
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            java.lang.String r0 = "CryptoUtils.getHandle"
            com.google.android.gms.internal.ads.zzbzz r1 = com.google.android.gms.ads.internal.zzv.zzp()
            r1.zzw(r2, r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgd.zzc(java.lang.String):com.google.android.gms.internal.ads.zzggf");
    }
}
