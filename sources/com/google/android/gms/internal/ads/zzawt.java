package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzbe;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawt extends zzaxt {
    private static final zzaxu zzh = new zzaxu();
    private final zzasb zzi;
    private final Context zzj;
    private final zzatx zzk;

    public zzawt(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, Context context, zzars zzars, zzasb zzasb, zzatx zzatx) {
        super(zzawf, "C5H7nTBN4nltmNau+/MNt6CSB0fOzxeNv8MDz6xiw5iQrv1d68C/G+ooekFvBfaF", "+RUwiCqrIcStaeiSXRFEyI1zJGWpibshqhmF48hI+GU=", zzasf, i, 27);
        this.zzj = context;
        this.zzi = zzasb;
        this.zzk = zzatx;
    }

    private final zzatu zzc() throws IllegalAccessException, InvocationTargetException {
        int i;
        String str;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcM)).booleanValue()) {
            i = ((Integer) zzbe.zzc().zza(zzbcn.zzcR)).intValue();
        } else {
            i = this.zzi.zza();
        }
        zzatu zzatu = new zzatu((String) this.zze.invoke((Object) null, new Object[]{this.zzj, false, ""}));
        zzatx zzatx = this.zzk;
        if (!(zzatx == null || zzatx.zza() == null)) {
            try {
                str = (String) zzatx.zza().get((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            }
            zzatu.zza = str;
            return zzatu;
        }
        str = ExifInterface.LONGITUDE_EAST;
        zzatu.zza = str;
        return zzatu;
    }

    private final String zzd() {
        try {
            if (this.zza.zzl() != null) {
                this.zza.zzl().get();
            }
            zzata zzc = this.zza.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzatu zzatu;
        int i;
        zzatu zzatu2;
        Boolean bool;
        AtomicReference zza = zzh.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzatu zzatu3 = (zzatu) zza.get();
            if (zzatu3 == null || zzawi.zzd(zzatu3.zza) || zzatu3.zza.equals(ExifInterface.LONGITUDE_EAST) || zzatu3.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (!zzawi.zzd((String) null)) {
                    i = 5;
                } else {
                    if (!zzawi.zzd((String) null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    bool.booleanValue();
                    i = 3;
                }
                if (this.zzk != null) {
                    zzatu2 = zzc();
                } else {
                    if (i == 3 && !this.zzi.zzd()) {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    Boolean bool2 = (Boolean) zzbe.zzc().zza(zzbcn.zzcA);
                    String zzb = ((Boolean) zzbe.zzc().zza(zzbcn.zzcz)).booleanValue() ? zzb() : null;
                    if (bool2.booleanValue() && this.zza.zzp() && zzawi.zzd(zzb)) {
                        zzb = zzd();
                    }
                    zzatu zzatu4 = new zzatu((String) this.zze.invoke((Object) null, new Object[]{this.zzj, valueOf, zzb}));
                    if (zzawi.zzd(zzatu4.zza) || zzatu4.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String zzd = zzd();
                            if (!zzawi.zzd(zzd)) {
                                zzatu4.zza = zzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzatu2 = zzatu4;
                }
                zza.set(zzatu2);
            }
            zzatu = (zzatu) zza.get();
        }
        synchronized (this.zzd) {
            if (zzatu != null) {
                this.zzd.zzx(zzatu.zza);
                this.zzd.zzX(zzatu.zzb);
                this.zzd.zzZ(zzatu.zzc);
                this.zzd.zzi(zzatu.zzd);
                this.zzd.zzw(zzatu.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzawi.zzf((String) zzbe.zzc().zza(zzbcn.zzcB));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzawi.zzf((String) zzbe.zzc().zza(zzbcn.zzcC)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zza.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            zzgfa zze = zzgfa.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzaxv(zze));
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
