package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzawf {
    private static final String zzd = "zzawf";
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzavk zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzata zzm;
    private Future zzn;
    private zzavf zzo;
    private zzauw zzp;
    private final Map zzq;
    private boolean zzr;
    private zzavy zzs;

    private zzawf(Context context) {
        boolean z = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzr = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzq = new HashMap();
        if (this.zzs == null) {
            this.zzs = new zzavy(context);
        }
    }

    public static zzawf zzg(Context context, String str, String str2, boolean z, zzavf zzavf) {
        File cacheDir;
        File file;
        zzawf zzawf = new zzawf(context);
        try {
            zzawf.zze = Executors.newCachedThreadPool(new zzawb());
            zzawf.zzj = z;
            if (z) {
                zzawf.zzk = zzawf.zze.submit(new zzawc(zzawf));
            }
            zzawf.zze.execute(new zzawe(zzawf));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzawf.zzb = instance.getApkVersion(zzawf.zza) > 0;
                zzawf.zzc = instance.isGooglePlayServicesAvailable(zzawf.zza) == 0;
            } catch (Throwable unused) {
            }
            if (zzavf != null) {
                zzawf.zzo = zzavf;
            } else {
                zzawf.zzo(0, true);
            }
            if (zzawi.zzc()) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzds)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzavk zzavk = new zzavk((SecureRandom) null);
            zzawf.zzg = zzavk;
            try {
                byte[] zzb2 = zzatt.zzb("1K94VZ1tx0GyFGtgwnS0N2oMN6rD4ZLd6x9MV4dxATs=", false);
                if (zzb2.length == 32) {
                    byte[] bArr = new byte[16];
                    ByteBuffer.wrap(zzb2, 4, 16).get(bArr);
                    for (int i = 0; i < 16; i++) {
                        bArr[i] = (byte) (bArr[i] ^ 68);
                    }
                    zzawf.zzh = bArr;
                    try {
                        cacheDir = zzawf.zza.getCacheDir();
                        if (cacheDir == null) {
                            cacheDir = zzawf.zza.getDir("dex", 0);
                            if (cacheDir == null) {
                                throw new zzavv();
                            }
                        }
                        file = new File(String.format("%s/%s.jar", new Object[]{cacheDir, "1725907690450"}));
                        if (!file.exists()) {
                            byte[] zzb3 = zzawf.zzg.zzb(zzawf.zzh, "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");
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            if (Build.VERSION.SDK_INT >= 33) {
                                file.setReadOnly();
                            }
                            fileOutputStream.write(zzb3, 0, zzb3.length);
                            fileOutputStream.close();
                        }
                        zzawf.zzx(cacheDir, "1725907690450");
                        zzawf.zzf = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), (String) null, zzawf.zza.getClassLoader());
                        zzy(file);
                        zzawf.zzw(cacheDir, "1725907690450");
                        zzz(String.format("%s/%s.dex", new Object[]{cacheDir, "1725907690450"}));
                        zzawf.zzp = new zzauw(zzawf);
                        zzawf.zzr = true;
                        return zzawf;
                    } catch (SecurityException e) {
                        throw new zzavv(e);
                    } catch (FileNotFoundException e2) {
                        throw new zzavv(e2);
                    } catch (IOException e3) {
                        throw new zzavv(e3);
                    } catch (zzavj e4) {
                        throw new zzavv(e4);
                    } catch (NullPointerException e5) {
                        throw new zzavv(e5);
                    } catch (Throwable th) {
                        zzy(file);
                        zzawf.zzw(cacheDir, "1725907690450");
                        zzz(String.format("%s/%s.dex", new Object[]{cacheDir, "1725907690450"}));
                        throw th;
                    }
                } else {
                    throw new zzavj(zzavk);
                }
            } catch (IllegalArgumentException e6) {
                throw new zzavj(zzavk, e6);
            } catch (zzavj e7) {
                throw new zzavv(e7);
            }
        } catch (zzavv unused2) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00bc */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2 A[SYNTHETIC, Splitter:B:39:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d7 A[SYNTHETIC, Splitter:B:43:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A[SYNTHETIC, Splitter:B:51:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e6 A[SYNTHETIC, Splitter:B:55:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw(java.io.File r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r10 = "test"
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "1725907690450"
            java.lang.Object[] r2 = new java.lang.Object[]{r9, r1}
            java.lang.String r3 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x001b
            goto L_0x00ec
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r1}
            java.lang.String r3 = "%s/%s.dex"
            java.lang.String r9 = java.lang.String.format(r3, r9)
            r2.<init>(r9)
            boolean r9 = r2.exists()
            if (r9 == 0) goto L_0x00ec
            long r3 = r2.length()
            r5 = 0
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ec
            int r9 = (int) r3
            byte[] r9 = new byte[r9]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00cd }
            r4.<init>(r2)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00cd }
            int r5 = r4.read(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            if (r5 > 0) goto L_0x0050
            r4.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            zzy(r2)
            return
        L_0x0050:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r5.print(r10)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r5.print(r10)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r5.print(r10)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzatd r10 = com.google.android.gms.internal.ads.zzate.zza()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            byte[] r5 = r5.getBytes()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzgxp r6 = com.google.android.gms.internal.ads.zzgxp.zzb     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            int r6 = r5.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r7 = 0
            com.google.android.gms.internal.ads.zzgxp r5 = com.google.android.gms.internal.ads.zzgxp.zzv(r5, r7, r6)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r10.zzc(r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            byte[] r1 = r1.getBytes()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            int r5 = r1.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzgxp r1 = com.google.android.gms.internal.ads.zzgxp.zzv(r1, r7, r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r10.zzd(r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzavk r1 = r8.zzg     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            byte[] r5 = r8.zzh     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            java.lang.String r9 = r1.zza(r5, r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            byte[] r9 = r9.getBytes()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            int r1 = r9.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzgxp r1 = com.google.android.gms.internal.ads.zzgxp.zzv(r9, r7, r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r10.zza(r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            byte[] r9 = com.google.android.gms.internal.ads.zzaua.zzf(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            int r1 = r9.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzgxp r9 = com.google.android.gms.internal.ads.zzgxp.zzv(r9, r7, r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r10.zzb(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r0.createNewFile()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            r9.<init>(r0)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ca, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzgyx r10 = r10.zzbr()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            com.google.android.gms.internal.ads.zzate r10 = (com.google.android.gms.internal.ads.zzate) r10     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            byte[] r10 = r10.zzaV()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            int r0 = r10.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            r9.write(r10, r7, r0)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            r9.close()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c3 }
            r4.close()     // Catch:{ IOException -> 0x00bc }
        L_0x00bc:
            r9.close()     // Catch:{ IOException -> 0x00bf }
        L_0x00bf:
            zzy(r2)
            return
        L_0x00c3:
            r10 = move-exception
            goto L_0x00c8
        L_0x00c5:
            r9 = move-exception
            r10 = r9
            r9 = r3
        L_0x00c8:
            r3 = r4
            goto L_0x00d0
        L_0x00ca:
            r9 = r3
        L_0x00cb:
            r3 = r4
            goto L_0x00df
        L_0x00cd:
            r9 = move-exception
            r10 = r9
            r9 = r3
        L_0x00d0:
            if (r3 == 0) goto L_0x00d5
            r3.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            if (r9 == 0) goto L_0x00da
            r9.close()     // Catch:{ IOException -> 0x00da }
        L_0x00da:
            zzy(r2)
            throw r10
        L_0x00de:
            r9 = r3
        L_0x00df:
            if (r3 == 0) goto L_0x00e4
            r3.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            if (r9 == 0) goto L_0x00e9
            r9.close()     // Catch:{ IOException -> 0x00e9 }
        L_0x00e9:
            zzy(r2)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawf.zzw(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|32|33|34|35|36|79) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00db, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00d6 */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[ExcHandler: zzavj | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e5 A[SYNTHETIC, Splitter:B:60:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ea A[SYNTHETIC, Splitter:B:64:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f1 A[SYNTHETIC, Splitter:B:71:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f6 A[SYNTHETIC, Splitter:B:75:0x00f6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzx(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r9 = new java.io.File
            java.lang.String r0 = "1725907690450"
            java.lang.Object[] r1 = new java.lang.Object[]{r8, r0}
            java.lang.String r2 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r9.<init>(r1)
            boolean r1 = r9.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0019
            return r2
        L_0x0019:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r0}
            java.lang.String r3 = "%s/%s.dex"
            java.lang.String r8 = java.lang.String.format(r3, r8)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x00f9
            r8 = 0
            long r3 = r9.length()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x003d
            zzy(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            return r2
        L_0x003d:
            int r3 = (int) r3     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            byte[] r3 = new byte[r3]     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            r4.<init>(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00ee, all -> 0x00e1 }
            int r5 = r4.read(r3)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            if (r5 > 0) goto L_0x0059
            java.lang.String r0 = zzd     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            zzy(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r4.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            return r2
        L_0x0059:
            com.google.android.gms.internal.ads.zzgyh r5 = com.google.android.gms.internal.ads.zzgyh.zza()     // Catch:{ NullPointerException -> 0x00d6, zzavj | IOException | NoSuchAlgorithmException -> 0x00de, zzavj | IOException | NoSuchAlgorithmException -> 0x00de }
            com.google.android.gms.internal.ads.zzate r3 = com.google.android.gms.internal.ads.zzate.zzc(r3, r5)     // Catch:{ NullPointerException -> 0x00d6, zzavj | IOException | NoSuchAlgorithmException -> 0x00de, zzavj | IOException | NoSuchAlgorithmException -> 0x00de }
            java.lang.String r5 = new java.lang.String     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            com.google.android.gms.internal.ads.zzgxp r6 = r3.zzh()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r6 = r6.zzA()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r5.<init>(r6)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            boolean r0 = r0.equals(r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            if (r0 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzgxp r0 = r3.zzf()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r0 = r0.zzA()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            com.google.android.gms.internal.ads.zzgxp r5 = r3.zzd()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r5 = r5.zzA()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r5 = com.google.android.gms.internal.ads.zzaua.zzf(r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            boolean r0 = java.util.Arrays.equals(r0, r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            if (r0 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzgxp r0 = r3.zzg()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r0 = r0.zzA()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r5 = r5.getBytes()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            boolean r0 = java.util.Arrays.equals(r0, r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            if (r0 != 0) goto L_0x00a3
            goto L_0x00cf
        L_0x00a3:
            com.google.android.gms.internal.ads.zzavk r9 = r7.zzg     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r0 = r7.zzh     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            java.lang.String r5 = new java.lang.String     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            com.google.android.gms.internal.ads.zzgxp r3 = r3.zzd()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r3 = r3.zzA()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r5.<init>(r3)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            byte[] r9 = r9.zzb(r0, r5)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r1.createNewFile()     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r0.<init>(r1)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            int r8 = r9.length     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r0.write(r9, r2, r8)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00df, all -> 0x00cc }
            r4.close()     // Catch:{ IOException -> 0x00c7 }
        L_0x00c7:
            r0.close()     // Catch:{ IOException -> 0x00ca }
        L_0x00ca:
            r8 = 1
            return r8
        L_0x00cc:
            r8 = move-exception
            r9 = r8
            goto L_0x00dc
        L_0x00cf:
            zzy(r9)     // Catch:{ zzavj | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00da }
            r4.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            return r2
        L_0x00d6:
            r4.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00d9:
            return r2
        L_0x00da:
            r9 = move-exception
            r0 = r8
        L_0x00dc:
            r8 = r4
            goto L_0x00e3
        L_0x00de:
            r0 = r8
        L_0x00df:
            r8 = r4
            goto L_0x00ef
        L_0x00e1:
            r9 = move-exception
            r0 = r8
        L_0x00e3:
            if (r8 == 0) goto L_0x00e8
            r8.close()     // Catch:{ IOException -> 0x00e8 }
        L_0x00e8:
            if (r0 == 0) goto L_0x00ed
            r0.close()     // Catch:{ IOException -> 0x00ed }
        L_0x00ed:
            throw r9
        L_0x00ee:
            r0 = r8
        L_0x00ef:
            if (r8 == 0) goto L_0x00f4
            r8.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            if (r0 == 0) goto L_0x00f9
            r0.close()     // Catch:{ IOException -> 0x00f9 }
        L_0x00f9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawf.zzx(java.io.File, java.lang.String):boolean");
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
        } else {
            file.delete();
        }
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzp != null) {
            return zzauw.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzata zzc() {
        zzavf zzavf = this.zzo;
        if (zzavf == null) {
            return this.zzm;
        }
        if (zzavf.zza() == null || !zzavf.zza().isDone()) {
            return zzata.zzc();
        }
        try {
            return (zzata) this.zzo.zza().get();
        } catch (InterruptedException | ExecutionException unused) {
            return zzata.zzc();
        }
    }

    public final zzauw zzd() {
        return this.zzp;
    }

    public final zzavk zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final zzavy zzf() {
        return this.zzs;
    }

    public final AdvertisingIdClient zzh() {
        Future future;
        if (!this.zzj) {
            return null;
        }
        if (this.zzi == null && (future = this.zzk) != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzaxs zzaxs = (zzaxs) this.zzq.get(new Pair(str, str2));
        if (zzaxs == null) {
            return null;
        }
        return zzaxs.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        zzavf zzavf = this.zzo;
        return zzavf != null ? zzavf.zza() : this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzawd(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzr;
    }

    public final boolean zzs() {
        return this.zzs.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzq.containsKey(pair)) {
            return false;
        }
        this.zzq.put(pair, new zzaxs(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
