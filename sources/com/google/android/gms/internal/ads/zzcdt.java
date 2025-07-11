package com.google.android.gms.internal.ads;

import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcdt implements zzfsx {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzcdt(String str) {
        this.zza = str;
    }

    public final URLConnection zza() {
        int i = zzcdu.zzd;
        zzv.zzx();
        int intValue = ((Integer) zzbe.zzc().zza(zzbcn.zzJ)).intValue();
        URL url = new URL(this.zza);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(intValue);
                openConnection.setReadTimeout(intValue);
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    zzl zzl = new zzl((String) null);
                    zzl.zzc(httpURLConnection, (byte[]) null);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzl.zze(httpURLConnection, responseCode);
                    if (responseCode / 100 != 3) {
                        return httpURLConnection;
                    }
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField != null) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            throw new IOException("Protocol is null");
                        } else if (protocol.equals(ProxyConfig.MATCH_HTTP) || protocol.equals(ProxyConfig.MATCH_HTTPS)) {
                            zzm.zze("Redirecting to ".concat(headerField));
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            throw new IOException("Unsupported scheme: ".concat(protocol));
                        }
                    } else {
                        throw new IOException("Missing Location header in redirect");
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
    }
}
