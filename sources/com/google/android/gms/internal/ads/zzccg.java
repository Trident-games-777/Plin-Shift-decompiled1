package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzccg {
    private static final boolean zza = (zzbc.zze().nextInt(100) < ((Integer) zzbe.zzc().zza(zzbcn.zzmr)).intValue());
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbcz zze;
    private final zzbdc zzf;
    private final zzbg zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn;
    private zzcbl zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr = -1;

    public zzccg(Context context, VersionInfoParcel versionInfoParcel, String str, zzbdc zzbdc, zzbcz zzbcz) {
        com.google.android.gms.ads.internal.util.zzbe zzbe = new com.google.android.gms.ads.internal.util.zzbe();
        zzbe.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbe.zza("1_5", 1.0d, 5.0d);
        zzbe.zza("5_10", 5.0d, 10.0d);
        zzbe.zza("10_20", 10.0d, 20.0d);
        zzbe.zza("20_30", 20.0d, 30.0d);
        zzbe.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbe.zzb();
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbdc;
        this.zze = zzbcz;
        String str2 = (String) zzbe.zzc().zza(zzbcn.zzK);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse frame hash target time number.", e);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcbl zzcbl) {
        zzbcu.zza(this.zzf, this.zze, "vpc2");
        this.zzj = true;
        this.zzf.zzd("vpn", zzcbl.zzj());
        this.zzo = zzcbl;
    }

    public final void zzb() {
        if (this.zzj && !this.zzk) {
            zzbcu.zza(this.zzf, this.zze, "vfr2");
            this.zzk = true;
        }
    }

    public final void zzc() {
        this.zzn = true;
        if (this.zzk && !this.zzl) {
            zzbcu.zza(this.zzf, this.zze, "vfp2");
            this.zzl = true;
        }
    }

    public final void zzd() {
        if (zza && !this.zzp) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzc);
            bundle.putString("player", this.zzo.zzj());
            for (zzbd zzbd : this.zzg.zza()) {
                String valueOf = String.valueOf(zzbd.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbd.zze));
                String valueOf2 = String.valueOf(zzbd.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbd.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzh;
                if (i < jArr.length) {
                    String str = this.zzi[i];
                    if (str != null) {
                        Long valueOf3 = Long.valueOf(jArr[i]);
                        new StringBuilder("fh_").append(valueOf3);
                        bundle.putString("fh_".concat(valueOf3.toString()), str);
                    }
                    i++;
                } else {
                    zzv.zzq().zzh(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundle, true);
                    this.zzp = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcbl zzcbl) {
        int i = 0;
        if (this.zzl && !this.zzm) {
            if (zze.zzc() && !this.zzm) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbcu.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long nanoTime = zzv.zzC().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzr)));
        }
        this.zzq = this.zzn;
        this.zzr = nanoTime;
        long longValue = ((Long) zzbe.zzc().zza(zzbcn.zzL)).longValue();
        long zza2 = (long) zzcbl.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(zza2 - this.zzh[i2])) {
                String[] strArr2 = this.zzi;
                int i3 = 8;
                Bitmap bitmap = zzcbl.getBitmap(8, 8);
                long j = 63;
                int i4 = i;
                long j2 = 0;
                while (i4 < i3) {
                    while (i < i3) {
                        int pixel = bitmap.getPixel(i, i4);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j);
                        j--;
                        i++;
                        i3 = 8;
                    }
                    i4++;
                    i = 0;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
            zzcbl zzcbl2 = zzcbl;
            i2++;
            i = 0;
        }
    }
}
