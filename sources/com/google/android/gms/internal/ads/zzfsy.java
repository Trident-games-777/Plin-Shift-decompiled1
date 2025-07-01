package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfsy extends zzfsm {
    private zzfxg<Integer> zza;
    private zzfxg<Integer> zzb;
    private zzfsx zzc;
    private HttpURLConnection zzd;

    zzfsy() {
        this(new zzfso(), new zzfsp(), (zzfsx) null);
    }

    zzfsy(zzfxg<Integer> zzfxg, zzfxg<Integer> zzfxg2, zzfsx zzfsx) {
        this.zza = zzfxg;
        this.zzb = zzfxg2;
        this.zzc = zzfsx;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfsn.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfsn.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfsx zzfsx = this.zzc;
        zzfsx.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfsx.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfsx zzfsx, int i, int i2) throws IOException {
        this.zza = new zzfsq(i);
        this.zzb = new zzfsr(i2);
        this.zzc = zzfsx;
        return zzm();
    }

    public HttpURLConnection zzo(Network network, URL url, int i, int i2) throws IOException {
        this.zza = new zzfss(i);
        this.zzb = new zzfst(i2);
        this.zzc = new zzfsu(network, url);
        return zzm();
    }

    public URLConnection zzr(URL url, int i) throws IOException {
        this.zza = new zzfsv(i);
        this.zzc = new zzfsw(url);
        return zzm();
    }
}
