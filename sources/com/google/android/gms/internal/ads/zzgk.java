package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import coil3.util.UtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgk implements zzgd {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzgd zzc;
    private zzgd zzd;
    private zzgd zze;
    private zzgd zzf;
    private zzgd zzg;
    private zzgd zzh;
    private zzgd zzi;
    private zzgd zzj;
    private zzgd zzk;

    public zzgk(Context context, zzgd zzgd) {
        this.zza = context.getApplicationContext();
        zzgd zzgd2 = zzgd;
        this.zzc = zzgd;
    }

    private final zzgd zzg() {
        if (this.zze == null) {
            zzfv zzfv = new zzfv(this.zza);
            this.zze = zzfv;
            zzh(zzfv);
        }
        return this.zze;
    }

    private final void zzh(zzgd zzgd) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzgd.zzf((zzhd) this.zzb.get(i));
        }
    }

    private static final void zzi(zzgd zzgd, zzhd zzhd) {
        if (zzgd != null) {
            zzgd.zzf(zzhd);
        }
    }

    public final long zzb(zzgi zzgi) throws IOException {
        zzgd zzgd;
        zzdb.zzf(this.zzk == null);
        String scheme = zzgi.zza.getScheme();
        Uri uri = zzgi.zza;
        int i = zzen.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || UtilsKt.SCHEME_FILE.equals(scheme2)) {
            String path = zzgi.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgs zzgs = new zzgs();
                    this.zzd = zzgs;
                    zzh(zzgs);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (this.zzf == null) {
                zzga zzga = new zzga(this.zza);
                this.zzf = zzga;
                zzh(zzga);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzgd zzgd2 = (zzgd) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzgd2;
                    zzh(zzgd2);
                } catch (ClassNotFoundException unused) {
                    zzdt.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzhf zzhf = new zzhf(2000);
                this.zzh = zzhf;
                zzh(zzhf);
            }
            this.zzk = this.zzh;
        } else if (Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(scheme)) {
            if (this.zzi == null) {
                zzgb zzgb = new zzgb();
                this.zzi = zzgb;
                zzh(zzgb);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzhb zzhb = new zzhb(this.zza);
                    this.zzj = zzhb;
                    zzh(zzhb);
                }
                zzgd = this.zzj;
            } else {
                zzgd = this.zzc;
            }
            this.zzk = zzgd;
        }
        return this.zzk.zzb(zzgi);
    }

    public final Uri zzc() {
        zzgd zzgd = this.zzk;
        if (zzgd == null) {
            return null;
        }
        return zzgd.zzc();
    }

    public final void zzd() throws IOException {
        zzgd zzgd = this.zzk;
        if (zzgd != null) {
            try {
                zzgd.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzgd zzgd = this.zzk;
        return zzgd == null ? Collections.emptyMap() : zzgd.zze();
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzgd zzgd = this.zzk;
        zzgd.getClass();
        zzgd zzgd2 = zzgd;
        return zzgd.zza(bArr, i, i2);
    }

    public final void zzf(zzhd zzhd) {
        zzhd.getClass();
        this.zzc.zzf(zzhd);
        this.zzb.add(zzhd);
        zzi(this.zzd, zzhd);
        zzi(this.zze, zzhd);
        zzi(this.zzf, zzhd);
        zzi(this.zzg, zzhd);
        zzi(this.zzh, zzhd);
        zzi(this.zzi, zzhd);
        zzi(this.zzj, zzhd);
    }
}
