package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzftk {
    static final String zza = new UUID(0, 0).toString();
    final zzftj zzb;
    final zzfti zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    zzftk(Context context, String str, String str2, String str3) {
        this.zzb = zzftj.zzb(context);
        this.zzc = zzfti.zza(context);
        this.zzd = str;
        this.zze = str.concat("_3p");
        this.zzf = str2;
        this.zzg = str2.concat("_3p");
        this.zzh = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 == null || str3 == null) {
            String str4 = this.zzh;
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
            String str5 = "null";
            sb.append(str2 == null ? str5 : "not null");
            sb.append(", hashKey is ");
            if (str3 != null) {
                str5 = "not null";
            }
            sb.append(str5);
            throw new IllegalArgumentException(sb.toString());
        }
        return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
    }

    /* access modifiers changed from: package-private */
    public final long zza(boolean z) {
        return this.zzb.zza(z ? this.zzg : this.zzf, -1);
    }

    /* access modifiers changed from: package-private */
    public final zzfth zzb(String str, String str2, long j, boolean z) throws IOException {
        String str3;
        boolean z2 = true;
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String zze2 = zze(true);
                    String zzc2 = this.zzb.zzc("paid_3p_hash_key", (String) null);
                    if (!(zze2 == null || zzc2 == null || zze2.equals(zzh(str, str2, zzc2)))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfth();
        }
        if (str == null) {
            z2 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            long zza2 = zza(z2);
            if (zza2 != -1) {
                if (currentTimeMillis < zza2) {
                    zzftj zzftj = this.zzb;
                    if (z2) {
                        str3 = this.zzg;
                    } else {
                        str3 = this.zzf;
                    }
                    zzftj.zzd(str3, Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis >= zza2 + j) {
                    return zzc(str, str2);
                }
            }
            String zze3 = zze(z2);
            if (zze3 != null || z) {
                return new zzfth(zze3, Instant.ofEpochMilli(zza(z2)));
            }
            return zzc(str, str2);
        }
        throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final zzfth zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String uuid = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", uuid);
        return zzd(zzh(str, str2, uuid), true);
    }

    /* access modifiers changed from: package-private */
    public final zzfth zzd(String str, boolean z) throws IOException {
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            zzftj zzftj = this.zzb;
            if (z) {
                str2 = this.zzg;
            } else {
                str2 = this.zzf;
            }
            zzftj.zzd(str2, Long.valueOf(currentTimeMillis));
            zzftj zzftj2 = this.zzb;
            if (z) {
                str3 = this.zze;
            } else {
                str3 = this.zzd;
            }
            zzftj2.zzd(str3, str);
            return new zzfth(str, Instant.ofEpochMilli(currentTimeMillis));
        }
        throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    /* access modifiers changed from: package-private */
    public final String zze(boolean z) {
        return this.zzb.zzc(z ? this.zze : this.zzd, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z) throws IOException {
        String str;
        String str2;
        if (z) {
            str = this.zzg;
        } else {
            str = this.zzf;
        }
        this.zzb.zze(str);
        zzftj zzftj = this.zzb;
        if (z) {
            str2 = this.zze;
        } else {
            str2 = this.zzd;
        }
        zzftj.zze(str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(boolean z) {
        return this.zzb.zzg(this.zzd);
    }
}
