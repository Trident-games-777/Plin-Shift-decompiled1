package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdh;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public interface zzdjg {
    boolean zzA();

    boolean zzB();

    boolean zzC(Bundle bundle);

    int zza();

    JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType);

    JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType);

    void zzg();

    void zzh();

    void zzi();

    void zzj(zzdh zzdh);

    void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType);

    void zzl(String str);

    void zzm(Bundle bundle);

    void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i);

    void zzp();

    void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType);

    void zzr();

    void zzs(View view, MotionEvent motionEvent, View view2);

    void zzt(Bundle bundle);

    void zzu(View view);

    void zzv();

    void zzw(zzdd zzdd);

    void zzx(zzbhs zzbhs);

    void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void zzz(View view, Map map);
}
