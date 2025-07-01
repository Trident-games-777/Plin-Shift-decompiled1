package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaed {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzbd zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzen.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzdt.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafr.zzb(new zzed(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzdt.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzahi(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbd((List) arrayList);
    }

    public static zzaea zzc(zzed zzed, boolean z, boolean z2) throws zzbh {
        if (z) {
            zzd(3, zzed, false);
        }
        String zzB = zzed.zzB((int) zzed.zzs(), StandardCharsets.UTF_8);
        int length = zzB.length();
        long zzs = zzed.zzs();
        String[] strArr = new String[((int) zzs)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < zzs; i2++) {
            String zzB2 = zzed.zzB((int) zzed.zzs(), StandardCharsets.UTF_8);
            strArr[i2] = zzB2;
            i = i + 4 + zzB2.length();
        }
        if (!z2 || (zzed.zzm() & 1) != 0) {
            return new zzaea(zzB, strArr, i + 1);
        }
        throw zzbh.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i, zzed zzed, boolean z) throws zzbh {
        if (zzed.zzb() < 7) {
            if (z) {
                return false;
            }
            int zzb = zzed.zzb();
            throw zzbh.zza("too short header: " + zzb, (Throwable) null);
        } else if (zzed.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzbh.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), (Throwable) null);
        } else if (zzed.zzm() == 118 && zzed.zzm() == 111 && zzed.zzm() == 114 && zzed.zzm() == 98 && zzed.zzm() == 105 && zzed.zzm() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw zzbh.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
