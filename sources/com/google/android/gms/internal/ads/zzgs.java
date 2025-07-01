package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgs extends zzfw {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzgs() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgr {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzc == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i3 = zzen.zza;
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            int read = randomAccessFile.read(bArr, i, (int) Math.min(this.zzc, (long) i2));
            if (read > 0) {
                this.zzc -= (long) read;
                zzg(read);
            }
            return read;
        } catch (IOException e) {
            throw new zzgr(e, 2000);
        }
    }

    public final long zzb(zzgi zzgi) throws zzgr {
        Uri uri = zzgi.zza;
        this.zzb = uri;
        zzi(zzgi);
        int i = 2006;
        try {
            String path = uri.getPath();
            if (path != null) {
                String str = path;
                RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
                this.zza = randomAccessFile;
                try {
                    randomAccessFile.seek(zzgi.zze);
                    long j = zzgi.zzf;
                    if (j == -1) {
                        j = this.zza.length() - zzgi.zze;
                    }
                    this.zzc = j;
                    if (j >= 0) {
                        this.zzd = true;
                        zzj(zzgi);
                        return this.zzc;
                    }
                    throw new zzgr((String) null, (Throwable) null, 2008);
                } catch (IOException e) {
                    throw new zzgr(e, 2000);
                }
            } else {
                throw null;
            }
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzgr(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, PointerIconCompat.TYPE_WAIT);
            }
            if (!(e2.getCause() instanceof ErrnoException) || ((ErrnoException) e2.getCause()).errno != OsConstants.EACCES) {
                i = 2005;
            }
            throw new zzgr(e2, i);
        } catch (SecurityException e3) {
            throw new zzgr(e3, 2006);
        } catch (RuntimeException e4) {
            throw new zzgr(e4, 2000);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzgr {
        this.zzb = null;
        try {
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzgr(e, 2000);
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th;
        }
    }
}
