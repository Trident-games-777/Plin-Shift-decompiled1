package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeit implements zzgee {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfew zzb;
    final /* synthetic */ zzfet zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfln zze;
    final /* synthetic */ zzfff zzf;
    final /* synthetic */ zzeiv zzg;

    zzeit(zzeiv zzeiv, long j, zzfew zzfew, zzfet zzfet, String str, zzfln zzfln, zzfff zzfff) {
        this.zza = j;
        this.zzb = zzfew;
        this.zzc = zzfet;
        this.zzd = str;
        this.zze = zzfln;
        this.zzf = zzfff;
        this.zzg = zzeiv;
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void zza(java.lang.Throwable r13) {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzeiv r0 = r12.zzg
            com.google.android.gms.common.util.Clock r0 = r0.zza
            long r0 = r0.elapsedRealtime()
            long r2 = r12.zza
            long r8 = r0 - r2
            boolean r0 = r13 instanceof java.util.concurrent.TimeoutException
            r1 = 3
            r2 = 0
            if (r0 == 0) goto L_0x0018
            r0 = 2
        L_0x0015:
            r7 = r0
        L_0x0016:
            r3 = r2
            goto L_0x0063
        L_0x0018:
            boolean r0 = r13 instanceof com.google.android.gms.internal.ads.zzeid
            if (r0 == 0) goto L_0x001e
            r7 = r1
            goto L_0x0016
        L_0x001e:
            boolean r0 = r13 instanceof java.util.concurrent.CancellationException
            if (r0 == 0) goto L_0x0024
            r0 = 4
            goto L_0x0015
        L_0x0024:
            boolean r0 = r13 instanceof com.google.android.gms.internal.ads.zzffv
            if (r0 == 0) goto L_0x002a
            r0 = 5
            goto L_0x0015
        L_0x002a:
            boolean r0 = r13 instanceof com.google.android.gms.internal.ads.zzdwn
            r3 = 6
            if (r0 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgq.zza(r13)
            int r0 = r0.zza
            if (r0 != r1) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = r3
        L_0x003a:
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzbI
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0015
            boolean r3 = r13 instanceof com.google.android.gms.internal.ads.zzeff
            if (r3 == 0) goto L_0x0015
            r3 = r13
            com.google.android.gms.internal.ads.zzeff r3 = (com.google.android.gms.internal.ads.zzeff) r3
            com.google.android.gms.ads.internal.client.zze r3 = r3.zzb()
            if (r3 == 0) goto L_0x0015
            int r3 = r3.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7 = r0
            goto L_0x0063
        L_0x0061:
            r7 = r3
            goto L_0x0016
        L_0x0063:
            com.google.android.gms.internal.ads.zzeiv r11 = r12.zzg
            monitor-enter(r11)
            com.google.android.gms.internal.ads.zzeiv r0 = r12.zzg     // Catch:{ all -> 0x00f9 }
            boolean r4 = r0.zze     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzeix r4 = r0.zzb     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfew r5 = r12.zzb     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfet r6 = r12.zzc     // Catch:{ all -> 0x00f9 }
            boolean r0 = r13 instanceof com.google.android.gms.internal.ads.zzeff     // Catch:{ all -> 0x00f9 }
            if (r0 == 0) goto L_0x007d
            r2 = r13
            com.google.android.gms.internal.ads.zzeff r2 = (com.google.android.gms.internal.ads.zzeff) r2     // Catch:{ all -> 0x00f9 }
        L_0x007d:
            r9 = r8
            r8 = r2
            r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f9 }
            r8 = r9
        L_0x0083:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzhY     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00f9 }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f9 }
            if (r0 == 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzeiv r0 = r12.zzg     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzflr r0 = r0.zzc     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfln r2 = r12.zze     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfff r4 = r12.zzf     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfet r5 = r12.zzc     // Catch:{ all -> 0x00f9 }
            java.util.List r6 = r5.zzn     // Catch:{ all -> 0x00f9 }
            java.util.List r2 = r2.zzc(r4, r5, r6)     // Catch:{ all -> 0x00f9 }
            r0.zzd(r2)     // Catch:{ all -> 0x00f9 }
        L_0x00aa:
            com.google.android.gms.internal.ads.zzeiv r0 = r12.zzg     // Catch:{ all -> 0x00f9 }
            boolean r2 = r0.zzg     // Catch:{ all -> 0x00f9 }
            if (r2 == 0) goto L_0x00b4
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            return
        L_0x00b4:
            java.util.LinkedHashMap r0 = r0.zzd     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfet r2 = r12.zzc     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzeiu r4 = new com.google.android.gms.internal.ads.zzeiu     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = r12.zzd     // Catch:{ all -> 0x00f9 }
            java.lang.String r6 = r2.zzaf     // Catch:{ all -> 0x00f9 }
            r10 = r3
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ all -> 0x00f9 }
            r0.put(r2, r4)     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.ads.internal.client.zze r13 = com.google.android.gms.internal.ads.zzfgq.zza(r13)     // Catch:{ all -> 0x00f9 }
            int r0 = r13.zza     // Catch:{ all -> 0x00f9 }
            if (r0 == r1) goto L_0x00d1
            if (r0 != 0) goto L_0x00ec
        L_0x00d1:
            com.google.android.gms.ads.internal.client.zze r0 = r13.zzd     // Catch:{ all -> 0x00f9 }
            if (r0 == 0) goto L_0x00ec
            java.lang.String r0 = r0.zzc     // Catch:{ all -> 0x00f9 }
            java.lang.String r1 = "com.google.android.gms.ads"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00f9 }
            if (r0 != 0) goto L_0x00ec
            com.google.android.gms.internal.ads.zzeff r0 = new com.google.android.gms.internal.ads.zzeff     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.ads.internal.client.zze r13 = r13.zzd     // Catch:{ all -> 0x00f9 }
            r1 = 13
            r0.<init>(r1, r13)     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.ads.internal.client.zze r13 = com.google.android.gms.internal.ads.zzfgq.zza(r0)     // Catch:{ all -> 0x00f9 }
        L_0x00ec:
            com.google.android.gms.internal.ads.zzeiv r0 = r12.zzg     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzefg r0 = r0.zzf     // Catch:{ all -> 0x00f9 }
            com.google.android.gms.internal.ads.zzfet r1 = r12.zzc     // Catch:{ all -> 0x00f9 }
            r0.zzf(r1, r8, r13)     // Catch:{ all -> 0x00f9 }
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            return
        L_0x00f9:
            r0 = move-exception
            r13 = r0
            monitor-exit(r11)     // Catch:{ all -> 0x00f9 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeit.zza(java.lang.Throwable):void");
    }

    public final void zzb(Object obj) {
        long j;
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzeiv zzeiv = this.zzg;
            if (zzeiv.zze) {
                j = elapsedRealtime;
                zzeiv.zzb.zza(this.zzb, this.zzc, 0, (zzeff) null, j);
            } else {
                j = elapsedRealtime;
            }
            zzeiv zzeiv2 = this.zzg;
            if (!zzeiv2.zzg) {
                if (zzeiv2.zzq(this.zzc)) {
                    ((zzeiu) this.zzg.zzd.get(this.zzc)).zzd = j;
                } else {
                    LinkedHashMap zzh = this.zzg.zzd;
                    zzfet zzfet = this.zzc;
                    long j2 = j;
                    j = j2;
                    zzh.put(zzfet, new zzeiu(this.zzd, zzfet.zzaf, 0, j2, (Integer) null));
                }
                this.zzg.zzf.zzg(this.zzc, j, (zze) null);
            }
        }
    }
}
