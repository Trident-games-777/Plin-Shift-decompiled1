package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdg implements zzbjr {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzccf zzccf = (zzccf) obj;
        zzcgm zzq = zzccf.zzq();
        if (zzq == null) {
            try {
                zzcgm zzcgm = new zzcgm(zzccf, Float.parseFloat((String) map.get("duration")), DiskLruCache.VERSION.equals(map.get("customControlsAllowed")), DiskLruCache.VERSION.equals(map.get("clickToExpandAllowed")));
                zzccf.zzC(zzcgm);
                zzq = zzcgm;
            } catch (NullPointerException e) {
                e = e;
                Throwable th = e;
                zzm.zzh("Unable to parse videoMeta message.", th);
                zzv.zzp().zzw(th, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                Throwable th2 = e;
                zzm.zzh("Unable to parse videoMeta message.", th2);
                zzv.zzp().zzw(th2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = DiskLruCache.VERSION.equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || parseInt > 3) {
            parseInt = 0;
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zze.zzm(3)) {
            zzm.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + parseInt + " , aspectRatio : " + str);
        }
        zzq.zzc(parseFloat2, parseFloat, parseInt, equals, parseFloat3);
    }
}
