package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.ads.internal.util.zze;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdf implements zzbjr {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                zzbc.zzb();
                i = zzf.zzy(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                zzm.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (zze.zzc()) {
            zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i + ".");
        }
        return i;
    }

    private static void zzc(zzcbt zzcbt, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcbt.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzm.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzcbt.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcbt.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcbt.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcbt.zzD(Integer.parseInt(str5));
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i;
        int i2;
        Map map2 = map;
        zzccf zzccf = (zzccf) obj;
        String str = (String) map2.get("action");
        if (str == null) {
            zzm.zzj("Action missing from video GMSG.");
            return;
        }
        Integer num = null;
        Integer valueOf = map2.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map2.get("playerId"))) : null;
        Integer zzb = zzccf.zzo() != null ? zzccf.zzo().zzb() : null;
        if (valueOf == null || zzb == null || valueOf.equals(zzb) || str.equals("load")) {
            if (zze.zzm(3)) {
                JSONObject jSONObject = new JSONObject(map2);
                jSONObject.remove("google.afma.Notify_dt");
                zzm.zze("Video GMSG: " + str + " " + jSONObject.toString());
            }
            if (str.equals("background")) {
                String str2 = (String) map2.get("color");
                if (TextUtils.isEmpty(str2)) {
                    zzm.zzj("Color parameter missing from background video GMSG.");
                    return;
                }
                try {
                    zzccf.setBackgroundColor(Color.parseColor(str2));
                } catch (IllegalArgumentException unused) {
                    zzm.zzj("Invalid color parameter in background video GMSG.");
                }
            } else if (str.equals("playerBackground")) {
                String str3 = (String) map2.get("color");
                if (TextUtils.isEmpty(str3)) {
                    zzm.zzj("Color parameter missing from playerBackground video GMSG.");
                    return;
                }
                try {
                    zzccf.zzB(Color.parseColor(str3));
                } catch (IllegalArgumentException unused2) {
                    zzm.zzj("Invalid color parameter in playerBackground video GMSG.");
                }
            } else {
                int i3 = 0;
                if (str.equals("decoderProps")) {
                    String str4 = (String) map2.get("mimeTypes");
                    if (str4 == null) {
                        zzm.zzj("No MIME types specified for decoder properties inspection.");
                        HashMap hashMap = new HashMap();
                        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                        hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "missingMimeTypes");
                        zzccf.zzd("onVideoEvent", hashMap);
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    String[] split = str4.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str5 = split[i3];
                        hashMap2.put(str5, zzci.zza(str5.trim()));
                        i3++;
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                    hashMap3.put("mimeTypes", hashMap2);
                    zzccf.zzd("onVideoEvent", hashMap3);
                    return;
                }
                zzcbu zzo = zzccf.zzo();
                if (zzo == null) {
                    zzm.zzj("Could not get underlay container for a video GMSG.");
                    return;
                }
                boolean equals = str.equals("new");
                boolean equals2 = str.equals("position");
                if (equals || equals2) {
                    Context context = zzccf.getContext();
                    int zzb2 = zzb(context, map2, "x", 0);
                    int zzb3 = zzb(context, map2, "y", 0);
                    int zzb4 = zzb(context, map2, "w", -1);
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzdV)).booleanValue()) {
                        i = zzb4 == -1 ? zzccf.zzh() : Math.min(zzb4, zzccf.zzh());
                    } else {
                        if (zze.zzc()) {
                            zze.zza("Calculate width with original width " + zzb4 + ", videoHost.getVideoBoundingWidth() " + zzccf.zzh() + ", x " + zzb2 + ".");
                        }
                        i = Math.min(zzb4, zzccf.zzh() - zzb2);
                    }
                    int i4 = i;
                    int zzb5 = zzb(context, map2, "h", -1);
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzdV)).booleanValue()) {
                        i2 = zzb5 == -1 ? zzccf.zzg() : Math.min(zzb5, zzccf.zzg());
                    } else {
                        if (zze.zzc()) {
                            zze.zza("Calculate height with original height " + zzb5 + ", videoHost.getVideoBoundingHeight() " + zzccf.zzg() + ", y " + zzb3 + ".");
                        }
                        i2 = Math.min(zzb5, zzccf.zzg() - zzb3);
                    }
                    int i5 = i2;
                    try {
                        i3 = Integer.parseInt((String) map2.get("player"));
                    } catch (NumberFormatException unused3) {
                    }
                    int i6 = i3;
                    boolean parseBoolean = Boolean.parseBoolean((String) map2.get("spherical"));
                    if (!equals || zzo.zza() != null) {
                        zzo.zzc(zzb2, zzb3, i4, i5);
                        return;
                    }
                    zzcbu zzcbu = zzo;
                    zzcbu.zzd(zzb2, zzb3, i4, i5, i6, parseBoolean, new zzcce((String) map2.get("flags")));
                    zzcbt zza2 = zzcbu.zza();
                    if (zza2 != null) {
                        zzc(zza2, map2);
                        return;
                    }
                    return;
                }
                zzcgm zzq = zzccf.zzq();
                if (zzq != null) {
                    if (str.equals("timeupdate")) {
                        String str6 = (String) map2.get("currentTime");
                        if (str6 == null) {
                            zzm.zzj("currentTime parameter missing from timeupdate video GMSG.");
                            return;
                        }
                        try {
                            zzq.zzt(Float.parseFloat(str6));
                            return;
                        } catch (NumberFormatException unused4) {
                            zzm.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                            return;
                        }
                    } else if (str.equals("skip")) {
                        zzq.zzu();
                        return;
                    }
                }
                zzcbt zza3 = zzo.zza();
                if (zza3 == null) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
                    zzccf.zzd("onVideoEvent", hashMap4);
                } else if (str.equals("click")) {
                    Context context2 = zzccf.getContext();
                    int zzb6 = zzb(context2, map2, "x", 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zzb6, (float) zzb(context2, map2, "y", 0), 0);
                    zza3.zzx(obtain);
                    obtain.recycle();
                } else if (str.equals("currentTime")) {
                    String str7 = (String) map2.get("time");
                    if (str7 == null) {
                        zzm.zzj("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        zza3.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                    } catch (NumberFormatException unused5) {
                        zzm.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                    }
                } else if (str.equals("hide")) {
                    zza3.setVisibility(4);
                } else if (str.equals("remove")) {
                    zza3.setVisibility(8);
                } else if (str.equals("load")) {
                    zza3.zzr(valueOf);
                } else if (str.equals("loadControl")) {
                    zzc(zza3, map2);
                } else if (str.equals("muted")) {
                    if (Boolean.parseBoolean((String) map2.get("muted"))) {
                        zza3.zzs();
                    } else {
                        zza3.zzI();
                    }
                } else if (str.equals("pause")) {
                    zza3.zzu();
                } else if (str.equals("play")) {
                    zza3.zzv();
                } else if (str.equals("show")) {
                    zza3.setVisibility(0);
                } else if (str.equals("src")) {
                    String str8 = (String) map2.get("src");
                    if (map2.containsKey("periodicReportIntervalMs")) {
                        try {
                            num = Integer.valueOf(Integer.parseInt((String) map2.get("periodicReportIntervalMs")));
                        } catch (NumberFormatException unused6) {
                            zzm.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map2.get("periodicReportIntervalMs"))));
                        }
                    }
                    String[] strArr = {str8};
                    String str9 = (String) map2.get("demuxed");
                    if (str9 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(str9);
                            String[] strArr2 = new String[jSONArray.length()];
                            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                strArr2[i7] = jSONArray.getString(i7);
                            }
                            strArr = strArr2;
                        } catch (JSONException unused7) {
                            zzm.zzj("Malformed demuxed URL list for playback: ".concat(str9));
                            strArr = new String[]{str8};
                        }
                    }
                    if (num != null) {
                        zzccf.zzA(num.intValue());
                    }
                    zza3.zzE(str8, strArr);
                } else if (str.equals("touchMove")) {
                    Context context3 = zzccf.getContext();
                    zza3.zzH((float) zzb(context3, map2, "dx", 0), (float) zzb(context3, map2, "dy", 0));
                    if (!this.zza) {
                        zzccf.zzu();
                        this.zza = true;
                    }
                } else if (str.equals("volume")) {
                    String str10 = (String) map2.get("volume");
                    if (str10 == null) {
                        zzm.zzj("Level parameter missing from volume video GMSG.");
                        return;
                    }
                    try {
                        zza3.zzG(Float.parseFloat(str10));
                    } catch (NumberFormatException unused8) {
                        zzm.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str10));
                    }
                } else if (str.equals("watermark")) {
                    zza3.zzn();
                } else {
                    zzm.zzj("Unknown video action: ".concat(str));
                }
            }
        } else {
            zzm.zzi(String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", new Object[]{valueOf, zzb}));
        }
    }
}
