package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzhfi implements Iterator, Closeable, zzard {
    private static final zzarc zza = new zzhfh("eof ");
    protected zzaqz zzb;
    protected zzhfj zzc;
    zzarc zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zzhfp.zzb(zzhfi.class);
    }

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzarc zzarc = this.zzd;
        if (zzarc == zza) {
            return false;
        }
        if (zzarc != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzg.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzarc) this.zzg.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: zzc */
    public final zzarc next() {
        zzarc zzb2;
        zzarc zzarc = this.zzd;
        if (zzarc == null || zzarc == zza) {
            zzhfj zzhfj = this.zzc;
            if (zzhfj == null || this.zze >= this.zzf) {
                this.zzd = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzhfj) {
                    this.zzc.zze(this.zze);
                    zzb2 = this.zzb.zzb(this.zzc, this);
                    this.zze = this.zzc.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zzd = null;
            return zzarc;
        }
    }

    public final List zzd() {
        return (this.zzc == null || this.zzd == zza) ? this.zzg : new zzhfo(this.zzg, this);
    }

    public final void zze(zzhfj zzhfj, long j, zzaqz zzaqz) throws IOException {
        this.zzc = zzhfj;
        this.zze = zzhfj.zzb();
        zzhfj.zze(zzhfj.zzb() + j);
        this.zzf = zzhfj.zzb();
        this.zzb = zzaqz;
    }
}
