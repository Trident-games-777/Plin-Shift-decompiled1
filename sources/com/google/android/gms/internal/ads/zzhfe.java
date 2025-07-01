package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzhfe implements zzarc {
    private static final zzhfp zzg = zzhfp.zzb(zzhfe.class);
    protected final String zza;
    boolean zzb;
    boolean zzc;
    long zzd;
    long zze = -1;
    zzhfj zzf;
    private ByteBuffer zzh;

    protected zzhfe(String str) {
        this.zza = str;
        this.zzc = true;
        this.zzb = true;
    }

    private final synchronized void zzc() {
        String str;
        if (!this.zzc) {
            try {
                zzhfp zzhfp = zzg;
                String str2 = this.zza;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzhfp.zza(str);
                this.zzh = this.zzf.zzd(this.zzd, this.zze);
                this.zzc = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String zza() {
        return this.zza;
    }

    public final void zzb(zzhfj zzhfj, ByteBuffer byteBuffer, long j, zzaqz zzaqz) throws IOException {
        this.zzd = zzhfj.zzb();
        byteBuffer.remaining();
        this.zze = j;
        this.zzf = zzhfj;
        zzhfj.zze(zzhfj.zzb() + j);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    /* access modifiers changed from: protected */
    public abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        String str;
        zzc();
        zzhfp zzhfp = zzg;
        String str2 = this.zza;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzhfp.zza(str);
        ByteBuffer byteBuffer = this.zzh;
        if (byteBuffer != null) {
            this.zzb = true;
            byteBuffer.rewind();
            zze(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.zzh = null;
        }
    }
}
