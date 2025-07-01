package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcec extends zzfw implements zzgy {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc = new zzceb(this);
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzgx zzg;
    private zzgi zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    /* access modifiers changed from: private */
    public int zzq;
    private final Set zzr = new HashSet();

    zzcec(String str, zzhd zzhd, int i, int i2, int i3) {
        super(true);
        zzdb.zzc(str);
        this.zzf = str;
        this.zzg = new zzgx();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzhd != null) {
            zzf(zzhd);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzm.zzh("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0105, code lost:
        if (r2 == r16) goto L_0x0107;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x00ed A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bf A[Catch:{ IOException -> 0x0286 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb A[Catch:{ IOException -> 0x0286 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzgi r21) throws com.google.android.gms.internal.ads.zzgu {
        /*
            r20 = this;
            r1 = r20
            r5 = r21
            java.lang.String r2 = "Unable to connect to "
            r1.zzh = r5
            r3 = 0
            r1.zzp = r3
            r1.zzo = r3
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0286 }
            android.net.Uri r6 = r5.zza     // Catch:{ IOException -> 0x0286 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0286 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0286 }
            byte[] r6 = r5.zzc     // Catch:{ IOException -> 0x0286 }
            long r6 = r5.zze     // Catch:{ IOException -> 0x0286 }
            long r8 = r5.zzf     // Catch:{ IOException -> 0x0286 }
            r10 = 1
            boolean r11 = r5.zzb(r10)     // Catch:{ IOException -> 0x0286 }
            r12 = 0
            r13 = r12
        L_0x0026:
            int r14 = r13 + 1
            r15 = 20
            if (r13 > r15) goto L_0x026f
            java.net.URLConnection r13 = r0.openConnection()     // Catch:{ IOException -> 0x0286 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x0286 }
            boolean r15 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x0286 }
            if (r15 == 0) goto L_0x0041
            r15 = r13
            javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15     // Catch:{ IOException -> 0x0286 }
            r16 = r3
            javax.net.ssl.SSLSocketFactory r3 = r1.zzc     // Catch:{ IOException -> 0x0286 }
            r15.setSSLSocketFactory(r3)     // Catch:{ IOException -> 0x0286 }
            goto L_0x0043
        L_0x0041:
            r16 = r3
        L_0x0043:
            int r3 = r1.zzd     // Catch:{ IOException -> 0x0286 }
            r13.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0286 }
            int r3 = r1.zze     // Catch:{ IOException -> 0x0286 }
            r13.setReadTimeout(r3)     // Catch:{ IOException -> 0x0286 }
            com.google.android.gms.internal.ads.zzgx r3 = r1.zzg     // Catch:{ IOException -> 0x0286 }
            java.util.Map r3 = r3.zza()     // Catch:{ IOException -> 0x0286 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ IOException -> 0x0286 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0286 }
        L_0x005b:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0286 }
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0286 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ IOException -> 0x0286 }
            java.lang.Object r15 = r4.getKey()     // Catch:{ IOException -> 0x0286 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x0286 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ IOException -> 0x0286 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0286 }
            r13.setRequestProperty(r15, r4)     // Catch:{ IOException -> 0x0286 }
            goto L_0x005b
        L_0x0077:
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            r18 = -1
            if (r3 != 0) goto L_0x0084
            int r3 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r3 == 0) goto L_0x00b6
            r3 = r16
            goto L_0x0085
        L_0x0084:
            r3 = r6
        L_0x0085:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0286 }
            r15.<init>()     // Catch:{ IOException -> 0x0286 }
            java.lang.String r10 = "bytes="
            r15.append(r10)     // Catch:{ IOException -> 0x0286 }
            r15.append(r3)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r10 = "-"
            r15.append(r10)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r10 = r15.toString()     // Catch:{ IOException -> 0x0286 }
            int r15 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r15 == 0) goto L_0x00b1
            long r3 = r3 + r8
            long r3 = r3 + r18
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0286 }
            r15.<init>()     // Catch:{ IOException -> 0x0286 }
            r15.append(r10)     // Catch:{ IOException -> 0x0286 }
            r15.append(r3)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r10 = r15.toString()     // Catch:{ IOException -> 0x0286 }
        L_0x00b1:
            java.lang.String r3 = "Range"
            r13.setRequestProperty(r3, r10)     // Catch:{ IOException -> 0x0286 }
        L_0x00b6:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzf     // Catch:{ IOException -> 0x0286 }
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0286 }
            if (r11 != 0) goto L_0x00c6
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0286 }
        L_0x00c6:
            r13.setInstanceFollowRedirects(r12)     // Catch:{ IOException -> 0x0286 }
            r13.setDoOutput(r12)     // Catch:{ IOException -> 0x0286 }
            r13.connect()     // Catch:{ IOException -> 0x0286 }
            int r3 = r13.getResponseCode()     // Catch:{ IOException -> 0x0286 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 == r4) goto L_0x022b
            r4 = 301(0x12d, float:4.22E-43)
            if (r3 == r4) goto L_0x022b
            r4 = 302(0x12e, float:4.23E-43)
            if (r3 == r4) goto L_0x022b
            r4 = 303(0x12f, float:4.25E-43)
            if (r3 == r4) goto L_0x022b
            r4 = 307(0x133, float:4.3E-43)
            if (r3 == r4) goto L_0x022b
            r4 = 308(0x134, float:4.32E-43)
            if (r3 != r4) goto L_0x00ed
            goto L_0x022b
        L_0x00ed:
            r1.zzi = r13     // Catch:{ IOException -> 0x0286 }
            int r0 = r13.getResponseCode()     // Catch:{ IOException -> 0x020e }
            r1.zzl = r0     // Catch:{ IOException -> 0x020e }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x01e7
            r3 = 299(0x12b, float:4.19E-43)
            if (r0 <= r3) goto L_0x00ff
            goto L_0x01e7
        L_0x00ff:
            if (r0 != r2) goto L_0x0107
            long r2 = r5.zze
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0109
        L_0x0107:
            r2 = r16
        L_0x0109:
            r1.zzm = r2
            r2 = 1
            boolean r0 = r5.zzb(r2)
            if (r0 != 0) goto L_0x01c5
            long r2 = r5.zzf
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x011c
            r1.zzn = r2
            goto L_0x01c9
        L_0x011c:
            java.net.HttpURLConnection r0 = r1.zzi
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r0.getHeaderField(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "]"
            if (r3 != 0) goto L_0x0145
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0131 }
            goto L_0x0147
        L_0x0131:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "Unexpected Content-Length ["
            r3.<init>(r6)
            r3.append(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r3)
        L_0x0145:
            r6 = r18
        L_0x0147:
            java.lang.String r3 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01b8
            java.util.regex.Pattern r3 = zza
            java.util.regex.Matcher r3 = r3.matcher(r0)
            boolean r8 = r3.find()
            if (r8 == 0) goto L_0x01b8
            r8 = 2
            java.lang.String r8 = r3.group(r8)     // Catch:{ NumberFormatException -> 0x01a4 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x01a4 }
            r10 = 1
            java.lang.String r3 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01a4 }
            long r10 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x01a4 }
            long r8 = r8 - r10
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            r10 = 1
            long r8 = r8 + r10
            if (r3 >= 0) goto L_0x017b
            r6 = r8
            goto L_0x01b8
        L_0x017b:
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x01b8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01a4 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x01a4 }
            java.lang.String r10 = "Inconsistent headers ["
            r3.append(r10)     // Catch:{ NumberFormatException -> 0x01a4 }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x01a4 }
            java.lang.String r2 = "] ["
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x01a4 }
            r3.append(r0)     // Catch:{ NumberFormatException -> 0x01a4 }
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x01a4 }
            java.lang.String r2 = r3.toString()     // Catch:{ NumberFormatException -> 0x01a4 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)     // Catch:{ NumberFormatException -> 0x01a4 }
            long r2 = java.lang.Math.max(r6, r8)     // Catch:{ NumberFormatException -> 0x01a4 }
            r6 = r2
            goto L_0x01b8
        L_0x01a4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected Content-Range ["
            r2.<init>(r3)
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
        L_0x01b8:
            int r0 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x01c0
            long r2 = r1.zzm
            long r18 = r6 - r2
        L_0x01c0:
            r2 = r18
            r1.zzn = r2
            goto L_0x01c9
        L_0x01c5:
            long r2 = r5.zzf
            r1.zzn = r2
        L_0x01c9:
            java.net.HttpURLConnection r0 = r1.zzi     // Catch:{ IOException -> 0x01da }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01da }
            r1.zzj = r0     // Catch:{ IOException -> 0x01da }
            r2 = 1
            r1.zzk = r2
            r20.zzj(r21)
            long r2 = r1.zzn
            return r2
        L_0x01da:
            r0 = move-exception
            r1.zzn()
            com.google.android.gms.internal.ads.zzgu r2 = new com.google.android.gms.internal.ads.zzgu
            r3 = 2000(0x7d0, float:2.803E-42)
            r10 = 1
            r2.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzgi) r5, (int) r3, (int) r10)
            throw r2
        L_0x01e7:
            java.net.HttpURLConnection r0 = r1.zzi
            java.util.Map r6 = r0.getHeaderFields()
            r1.zzn()
            com.google.android.gms.internal.ads.zzgw r2 = new com.google.android.gms.internal.ads.zzgw
            int r3 = r1.zzl
            r5 = 0
            byte[] r8 = com.google.android.gms.internal.ads.zzen.zzf
            r4 = 0
            r7 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8)
            int r0 = r1.zzl
            r3 = 416(0x1a0, float:5.83E-43)
            if (r0 != r3) goto L_0x020d
            com.google.android.gms.internal.ads.zzge r0 = new com.google.android.gms.internal.ads.zzge
            r3 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r3)
            r2.initCause(r0)
        L_0x020d:
            throw r2
        L_0x020e:
            r0 = move-exception
            r4 = r0
            r1.zzn()
            com.google.android.gms.internal.ads.zzgu r0 = new com.google.android.gms.internal.ads.zzgu
            android.net.Uri r3 = r5.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r7 = 1
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            throw r2
        L_0x022b:
            r10 = 1
            java.lang.String r3 = "Location"
            java.lang.String r3 = r13.getHeaderField(r3)     // Catch:{ IOException -> 0x0286 }
            r13.disconnect()     // Catch:{ IOException -> 0x0286 }
            if (r3 == 0) goto L_0x0267
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0286 }
            r4.<init>(r0, r3)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r0 = r4.getProtocol()     // Catch:{ IOException -> 0x0286 }
            java.lang.String r3 = "https"
            boolean r3 = r3.equals(r0)     // Catch:{ IOException -> 0x0286 }
            if (r3 != 0) goto L_0x0261
            java.lang.String r3 = "http"
            boolean r3 = r3.equals(r0)     // Catch:{ IOException -> 0x0286 }
            if (r3 == 0) goto L_0x0251
            goto L_0x0261
        L_0x0251:
            java.net.ProtocolException r3 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0286 }
            java.lang.String r4 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x0286 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0286 }
            throw r3     // Catch:{ IOException -> 0x0286 }
        L_0x0261:
            r0 = r4
            r13 = r14
            r3 = r16
            goto L_0x0026
        L_0x0267:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0286 }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0286 }
            throw r0     // Catch:{ IOException -> 0x0286 }
        L_0x026f:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0286 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0286 }
            r3.<init>()     // Catch:{ IOException -> 0x0286 }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x0286 }
            r3.append(r14)     // Catch:{ IOException -> 0x0286 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0286 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0286 }
            throw r0     // Catch:{ IOException -> 0x0286 }
        L_0x0286:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.internal.ads.zzgu r0 = new com.google.android.gms.internal.ads.zzgu
            android.net.Uri r3 = r5.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r7 = 1
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcec.zzb(com.google.android.gms.internal.ads.zzgi):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzgu {
        try {
            if (this.zzj != null) {
                int i = zzen.zza;
                this.zzj.close();
            }
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
        } catch (IOException e) {
            throw new zzgu(e, this.zzh, 2000, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final void zzm(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    zzm.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgu {
        try {
            if (this.zzo != this.zzm) {
                byte[] bArr2 = (byte[]) zzb.getAndSet((Object) null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzb.set(bArr2);
                        break;
                    }
                    int read = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzo += (long) read;
                        zzg(read);
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j4);
            }
            int read2 = this.zzj.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzp += (long) read2;
                zzg(read2);
                return read2;
            } else if (this.zzn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzgu(e, this.zzh, 2000, 2);
        }
    }
}
