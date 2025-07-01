package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgq extends zzfw implements zzgy {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgx zze;
    private final zzgx zzf = new zzgx();
    private zzgi zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzgq(String str, int i, int i2, boolean z, boolean z2, zzgx zzgx, zzfwr zzfwr, boolean z3, zzgp zzgp) {
        super(true);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
        this.zze = zzgx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzb
            r3.setConnectTimeout(r4)
            int r4 = r2.zzc
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzgx r5 = r2.zze
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzgx r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0032:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L_0x0032
        L_0x004e:
            r4 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r0 = -1
            if (r12 != 0) goto L_0x005d
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x005c
            r4 = 0
            goto L_0x0079
        L_0x005c:
            r6 = r4
        L_0x005d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "bytes="
            r4.<init>(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0075
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L_0x0075:
            java.lang.String r4 = r4.toString()
        L_0x0079:
            if (r4 == 0) goto L_0x0080
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L_0x0080:
            java.lang.String r4 = r2.zzd
            if (r4 == 0) goto L_0x0089
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L_0x0089:
            r4 = 1
            if (r4 == r10) goto L_0x008f
            java.lang.String r4 = "identity"
            goto L_0x0091
        L_0x008f:
            java.lang.String r4 = "gzip"
        L_0x0091:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzgi.zzh
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgq.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzgi zzgi) throws zzgu {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!ProxyConfig.MATCH_HTTPS.equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                    throw new zzgu("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgi, 2001, 1);
                } else if (this.zza || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    String protocol2 = url.getProtocol();
                    throw new zzgu("Disallowed cross-protocol redirect (" + protocol2 + " to " + protocol + ")", zzgi, 2001, 1);
                }
            } catch (MalformedURLException e) {
                throw new zzgu((IOException) e, zzgi, 2001, 1);
            }
        } else {
            throw new zzgu("Null location redirect", zzgi, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzdt.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzh = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgu {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            if (j != -1) {
                long j2 = j - this.zzm;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j2);
            }
            InputStream inputStream = this.zzi;
            int i3 = zzen.zza;
            InputStream inputStream2 = inputStream;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.zzm += (long) read;
            zzg(read);
            return read;
        } catch (IOException e) {
            zzgi zzgi = this.zzg;
            int i4 = zzen.zza;
            zzgi zzgi2 = zzgi;
            throw zzgu.zza(e, zzgi, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        if (r10 == r16) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzgi r21) throws com.google.android.gms.internal.ads.zzgu {
        /*
            r20 = this;
            r1 = r20
            r12 = r21
            r1.zzg = r12
            r13 = 0
            r1.zzm = r13
            r1.zzl = r13
            r20.zzi(r21)
            r15 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x01d8 }
            android.net.Uri r0 = r12.zza     // Catch:{ IOException -> 0x01d8 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01d8 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01d8 }
            int r0 = r12.zzb     // Catch:{ IOException -> 0x01d8 }
            byte[] r0 = r12.zzc     // Catch:{ IOException -> 0x01d8 }
            long r5 = r12.zze     // Catch:{ IOException -> 0x01d8 }
            long r7 = r12.zzf     // Catch:{ IOException -> 0x01d8 }
            boolean r9 = r12.zzb(r15)     // Catch:{ IOException -> 0x01d8 }
            boolean r0 = r1.zza     // Catch:{ IOException -> 0x01d8 }
            r3 = 0
            if (r0 != 0) goto L_0x0040
            java.util.Map r11 = r12.zzd     // Catch:{ IOException -> 0x003b }
            r0 = r3
            r3 = 1
            r4 = 0
            r10 = 1
            java.net.HttpURLConnection r2 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x003b }
            r7 = r20
            r16 = r13
            goto L_0x0080
        L_0x003b:
            r0 = move-exception
            r7 = r20
            goto L_0x01da
        L_0x0040:
            r0 = r3
        L_0x0041:
            int r1 = r3 + 1
            r4 = 20
            if (r3 > r4) goto L_0x01b5
            java.util.Map r11 = r12.zzd     // Catch:{ IOException -> 0x003b }
            r3 = 1
            r4 = 0
            r10 = 0
            r16 = r13
            r13 = r1
            r1 = r20
            java.net.HttpURLConnection r3 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x01d8 }
            r4 = r2
            r18 = r7
            r7 = r1
            r1 = r18
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x01d6 }
            java.lang.String r10 = "Location"
            java.lang.String r10 = r3.getHeaderField(r10)     // Catch:{ IOException -> 0x01d6 }
            r11 = 300(0x12c, float:4.2E-43)
            if (r8 == r11) goto L_0x01a7
            r11 = 301(0x12d, float:4.22E-43)
            if (r8 == r11) goto L_0x01a7
            r11 = 302(0x12e, float:4.23E-43)
            if (r8 == r11) goto L_0x01a7
            r11 = 303(0x12f, float:4.25E-43)
            if (r8 == r11) goto L_0x01a7
            r11 = 307(0x133, float:4.3E-43)
            if (r8 == r11) goto L_0x01a7
            r11 = 308(0x134, float:4.32E-43)
            if (r8 != r11) goto L_0x007f
            goto L_0x01a7
        L_0x007f:
            r2 = r3
        L_0x0080:
            r7.zzh = r2     // Catch:{ IOException -> 0x01d6 }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x01d6 }
            r7.zzk = r1     // Catch:{ IOException -> 0x01d6 }
            java.lang.String r1 = r2.getResponseMessage()     // Catch:{ IOException -> 0x01d6 }
            int r3 = r7.zzk
            r4 = 2008(0x7d8, float:2.814E-42)
            java.lang.String r5 = "Content-Range"
            r6 = 200(0xc8, float:2.8E-43)
            r8 = -1
            if (r3 < r6) goto L_0x0158
            r10 = 299(0x12b, float:4.19E-43)
            if (r3 <= r10) goto L_0x009e
            goto L_0x0158
        L_0x009e:
            r2.getContentType()
            int r1 = r7.zzk
            if (r1 != r6) goto L_0x00ab
            long r10 = r12.zze
            int r1 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x00ad
        L_0x00ab:
            r10 = r16
        L_0x00ad:
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r1 = r2.getHeaderField(r1)
            java.lang.String r3 = "gzip"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00db
            long r13 = r12.zzf
            int r3 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00c4
            r7.zzl = r13
            goto L_0x00df
        L_0x00c4:
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r2.getHeaderField(r3)
            java.lang.String r5 = r2.getHeaderField(r5)
            long r5 = com.google.android.gms.internal.ads.zzgz.zza(r3, r5)
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00d8
            long r8 = r5 - r10
        L_0x00d8:
            r7.zzl = r8
            goto L_0x00df
        L_0x00db:
            long r5 = r12.zzf
            r7.zzl = r5
        L_0x00df:
            r3 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x014e }
            r7.zzi = r2     // Catch:{ IOException -> 0x014e }
            if (r1 == 0) goto L_0x00f2
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x014e }
            java.io.InputStream r2 = r7.zzi     // Catch:{ IOException -> 0x014e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x014e }
            r7.zzi = r1     // Catch:{ IOException -> 0x014e }
        L_0x00f2:
            r7.zzj = r15
            r20.zzj(r21)
            int r1 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x00fc
            goto L_0x013a
        L_0x00fc:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x013d }
        L_0x0100:
            int r2 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r2 <= 0) goto L_0x013a
            r5 = 4096(0x1000, double:2.0237E-320)
            long r5 = java.lang.Math.min(r10, r5)     // Catch:{ IOException -> 0x013d }
            int r2 = (int) r5     // Catch:{ IOException -> 0x013d }
            java.io.InputStream r5 = r7.zzi     // Catch:{ IOException -> 0x013d }
            int r6 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IOException -> 0x013d }
            r6 = r5
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ IOException -> 0x013d }
            int r2 = r5.read(r1, r0, r2)     // Catch:{ IOException -> 0x013d }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x013d }
            boolean r5 = r5.isInterrupted()     // Catch:{ IOException -> 0x013d }
            if (r5 != 0) goto L_0x012f
            r5 = -1
            if (r2 == r5) goto L_0x0129
            long r5 = (long) r2     // Catch:{ IOException -> 0x013d }
            long r10 = r10 - r5
            r7.zzg(r2)     // Catch:{ IOException -> 0x013d }
            goto L_0x0100
        L_0x0129:
            com.google.android.gms.internal.ads.zzgu r0 = new com.google.android.gms.internal.ads.zzgu     // Catch:{ IOException -> 0x013d }
            r0.<init>(r12, r4, r15)     // Catch:{ IOException -> 0x013d }
            throw r0     // Catch:{ IOException -> 0x013d }
        L_0x012f:
            com.google.android.gms.internal.ads.zzgu r0 = new com.google.android.gms.internal.ads.zzgu     // Catch:{ IOException -> 0x013d }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ IOException -> 0x013d }
            r1.<init>()     // Catch:{ IOException -> 0x013d }
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzgi) r12, (int) r3, (int) r15)     // Catch:{ IOException -> 0x013d }
            throw r0     // Catch:{ IOException -> 0x013d }
        L_0x013a:
            long r0 = r7.zzl
            return r0
        L_0x013d:
            r0 = move-exception
            r7.zzm()
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgu
            if (r1 == 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzgu r0 = (com.google.android.gms.internal.ads.zzgu) r0
            throw r0
        L_0x0148:
            com.google.android.gms.internal.ads.zzgu r1 = new com.google.android.gms.internal.ads.zzgu
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzgi) r12, (int) r3, (int) r15)
            throw r1
        L_0x014e:
            r0 = move-exception
            r7.zzm()
            com.google.android.gms.internal.ads.zzgu r1 = new com.google.android.gms.internal.ads.zzgu
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzgi) r12, (int) r3, (int) r15)
            throw r1
        L_0x0158:
            java.util.Map r0 = r2.getHeaderFields()
            int r3 = r7.zzk
            r6 = 416(0x1a0, float:5.83E-43)
            if (r3 != r6) goto L_0x017d
            java.lang.String r3 = r2.getHeaderField(r5)
            long r10 = com.google.android.gms.internal.ads.zzgz.zzb(r3)
            long r13 = r12.zze
            int r3 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x017d
            r7.zzj = r15
            r20.zzj(r21)
            long r0 = r12.zzf
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x017c
            return r0
        L_0x017c:
            return r16
        L_0x017d:
            java.io.InputStream r2 = r2.getErrorStream()
            if (r2 == 0) goto L_0x0188
            byte[] r2 = com.google.android.gms.internal.ads.zzgce.zzb(r2)     // Catch:{ IOException -> 0x018b }
            goto L_0x018d
        L_0x0188:
            byte[] r2 = com.google.android.gms.internal.ads.zzen.zzf     // Catch:{ IOException -> 0x018b }
            goto L_0x018d
        L_0x018b:
            byte[] r2 = com.google.android.gms.internal.ads.zzen.zzf
        L_0x018d:
            r7.zzm()
            int r3 = r7.zzk
            if (r3 != r6) goto L_0x019a
            com.google.android.gms.internal.ads.zzge r3 = new com.google.android.gms.internal.ads.zzge
            r3.<init>(r4)
            goto L_0x019b
        L_0x019a:
            r3 = 0
        L_0x019b:
            r4 = r0
            com.google.android.gms.internal.ads.zzgw r0 = new com.google.android.gms.internal.ads.zzgw
            r6 = r2
            r2 = r1
            int r1 = r7.zzk
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            throw r0
        L_0x01a7:
            r3.disconnect()     // Catch:{ IOException -> 0x01d6 }
            java.net.URL r3 = r7.zzl(r4, r10, r12)     // Catch:{ IOException -> 0x01d6 }
            r7 = r1
            r2 = r3
            r3 = r13
            r13 = r16
            goto L_0x0041
        L_0x01b5:
            r7 = r20
            r13 = r1
            com.google.android.gms.internal.ads.zzgu r0 = new com.google.android.gms.internal.ads.zzgu     // Catch:{ IOException -> 0x01d6 }
            java.net.NoRouteToHostException r1 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x01d6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01d6 }
            r2.<init>()     // Catch:{ IOException -> 0x01d6 }
            java.lang.String r3 = "Too many redirects: "
            r2.append(r3)     // Catch:{ IOException -> 0x01d6 }
            r2.append(r13)     // Catch:{ IOException -> 0x01d6 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01d6 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x01d6 }
            r2 = 2001(0x7d1, float:2.804E-42)
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzgi) r12, (int) r2, (int) r15)     // Catch:{ IOException -> 0x01d6 }
            throw r0     // Catch:{ IOException -> 0x01d6 }
        L_0x01d6:
            r0 = move-exception
            goto L_0x01da
        L_0x01d8:
            r0 = move-exception
            r7 = r1
        L_0x01da:
            r7.zzm()
            com.google.android.gms.internal.ads.zzgu r0 = com.google.android.gms.internal.ads.zzgu.zza(r0, r12, r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgq.zzb(com.google.android.gms.internal.ads.zzgi):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzgu {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
        } catch (IOException e) {
            zzgi zzgi = this.zzg;
            int i = zzen.zza;
            zzgi zzgi2 = zzgi;
            throw new zzgu(e, zzgi, 2000, 3);
        } catch (Throwable th) {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzfzr.zzd() : new zzgo(httpURLConnection.getHeaderFields());
    }
}
