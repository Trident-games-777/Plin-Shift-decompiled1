package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazq {
    private final int zza;
    private final zzazn zzb = new zzazs();

    public zzazq(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(((String) arrayList.get(i)).toLowerCase(Locale.US));
            sb.append(10);
        }
        String[] split = sb.toString().split("\n");
        if (split.length == 0) {
            return "";
        }
        zzazp zzazp = new zzazp();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzazo(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzazr.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzazv.zzc(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzazp.zzb.write(this.zzb.zzb(((zzazu) it.next()).zzb));
            } catch (IOException e) {
                zzm.zzh("Error while writing hash to byteStream", e);
            }
        }
        return zzazp.toString();
    }
}
