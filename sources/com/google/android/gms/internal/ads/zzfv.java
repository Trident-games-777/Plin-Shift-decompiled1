package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfv extends zzfw {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzfv(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfu {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzd;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzfu(e, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i3 = zzen.zza;
        InputStream inputStream2 = inputStream;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zzd;
        if (j2 != -1) {
            this.zzd = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    public final long zzb(zzgi zzgi) throws zzfu {
        try {
            Uri uri = zzgi.zza;
            this.zzb = uri;
            String path = uri.getPath();
            if (path != null) {
                String str = path;
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    path = path.substring(1);
                }
                zzi(zzgi);
                InputStream open = this.zza.open(path, 1);
                this.zzc = open;
                if (open.skip(zzgi.zze) >= zzgi.zze) {
                    long j = zzgi.zzf;
                    if (j != -1) {
                        this.zzd = j;
                    } else {
                        long available = (long) this.zzc.available();
                        this.zzd = available;
                        if (available == 2147483647L) {
                            this.zzd = -1;
                        }
                    }
                    this.zze = true;
                    zzj(zzgi);
                    return this.zzd;
                }
                throw new zzfu((Throwable) null, 2008);
            }
            throw null;
        } catch (zzfu e) {
            throw e;
        } catch (IOException e2) {
            throw new zzfu(e2, true != (e2 instanceof FileNotFoundException) ? 2000 : 2005);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzfu {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzfu(e, 2000);
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
