package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcev extends zzfw implements zzgy {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgx zze = new zzgx();
    private zzgi zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    zzcev(String str, zzhd zzhd, int i, int i2, long j, long j2) {
        super(true);
        zzdb.zzc(str);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzh = new ArrayDeque();
        this.zzq = j;
        this.zzr = j2;
        if (zzhd != null) {
            zzf(zzhd);
        }
    }

    private final void zzl() {
        while (!this.zzh.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzh.remove()).disconnect();
            } catch (Exception e) {
                zzm.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzg = null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgu {
        int i3 = i2;
        if (i3 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            long j2 = this.zzm;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzn + j2;
            long j4 = (long) i3;
            long j5 = this.zzr;
            long j6 = this.zzp;
            long j7 = j3 + j4 + j5;
            long j8 = j6 + 1;
            if (j7 > j8) {
                long j9 = this.zzo;
                if (j6 < j9) {
                    long min = Math.min(j9, Math.max(((this.zzq + j8) - j5) - 1, (j8 + j4) - 1));
                    zzk(j8, min, 2);
                    this.zzp = min;
                    j6 = min;
                }
            }
            int read = this.zzi.read(bArr, i, (int) Math.min(j4, ((j6 + 1) - this.zzn) - this.zzm));
            if (read != -1) {
                this.zzm += (long) read;
                zzg(read);
                return read;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzgu(e, this.zzf, 2000, 2);
        }
    }

    public final long zzb(zzgi zzgi) throws zzgu {
        long j;
        this.zzf = zzgi;
        this.zzm = 0;
        long j2 = zzgi.zze;
        long j3 = zzgi.zzf;
        if (j3 == -1) {
            j = this.zzq;
        } else {
            j = Math.min(this.zzq, j3);
        }
        this.zzn = j2;
        HttpURLConnection zzk2 = zzk(j2, (j + j2) - 1, 1);
        this.zzg = zzk2;
        String headerField = zzk2.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzgi.zzf;
                    if (j4 != -1) {
                        this.zzl = j4;
                        this.zzo = Math.max(parseLong, (this.zzn + j4) - 1);
                    } else {
                        this.zzl = parseLong2 - this.zzn;
                        this.zzo = parseLong2 - 1;
                    }
                    this.zzp = parseLong;
                    this.zzj = true;
                    zzj(zzgi);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    zzm.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcet(headerField, zzgi);
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
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
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzgu(e, this.zzf, 2000, 3);
        } catch (Throwable th) {
            this.zzi = null;
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzk(long j, long j2, int i) throws zzgu {
        int i2;
        IOException iOException;
        String uri = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                try {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } catch (IOException e) {
                    iOException = e;
                    i2 = i;
                }
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zzd);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String uri2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzceu(this.zzk, headerFields, this.zzf, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e2) {
                    zzl();
                    throw new zzgu(e2, this.zzf, 2000, i);
                }
            } catch (IOException e3) {
                zzl();
                String valueOf = String.valueOf(uri2);
                zzgi zzgi = this.zzf;
                throw new zzgu("Unable to connect to ".concat(valueOf), e3, zzgi, 2000, i);
            }
        } catch (IOException e4) {
            i2 = i;
            iOException = e4;
            String valueOf2 = String.valueOf(uri);
            throw new zzgu("Unable to connect to ".concat(valueOf2), iOException, this.zzf, 2000, i2);
        }
    }
}
