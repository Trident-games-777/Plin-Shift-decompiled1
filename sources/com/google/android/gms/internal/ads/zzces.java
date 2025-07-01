package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzces extends zzcbw implements zzhd, zzlz {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzced zzc;
    private final zzyb zzd;
    private final zzcce zze;
    private final WeakReference zzf;
    private final zzvv zzg;
    private zzir zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcbv zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private final Object zzq = new Object();
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcef zzt;
    private final Set zzu = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e3, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzbW)).booleanValue() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e7, code lost:
        if (r5.zzi == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e9, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ec, code lost:
        if (r5.zzl == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ee, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcej(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        if (r5.zzh <= 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcek(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcel(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0105, code lost:
        if (r5.zzi == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        r5 = new com.google.android.gms.internal.ads.zzcem(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x010e, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010f, code lost:
        r4 = r3.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r4 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r4.limit() <= 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        r4 = new byte[r3.zzi.limit()];
        r3.zzi.get(r4);
        r5 = new com.google.android.gms.internal.ads.zzcen(r5, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzces(android.content.Context r4, com.google.android.gms.internal.ads.zzcce r5, com.google.android.gms.internal.ads.zzccf r6, java.lang.Integer r7) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.zzq = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.zzu = r0
            r3.zzb = r4
            r3.zze = r5
            r3.zzr = r7
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            r7.<init>(r6)
            r3.zzf = r7
            com.google.android.gms.internal.ads.zzced r7 = new com.google.android.gms.internal.ads.zzced
            r7.<init>()
            r3.zzc = r7
            com.google.android.gms.internal.ads.zzyb r0 = new com.google.android.gms.internal.ads.zzyb
            r0.<init>(r4)
            r3.zzd = r0
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "SimpleExoPlayerAdapter initialize "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r1)
        L_0x003f:
            java.util.concurrent.atomic.AtomicInteger r1 = zzD()
            r1.incrementAndGet()
            com.google.android.gms.internal.ads.zzlt r1 = new com.google.android.gms.internal.ads.zzlt
            com.google.android.gms.internal.ads.zzcep r2 = new com.google.android.gms.internal.ads.zzcep
            r2.<init>(r3)
            r1.<init>(r4, r2)
            r1.zzb(r0)
            r1.zza(r7)
            com.google.android.gms.internal.ads.zzlu r7 = r1.zzc()
            r3.zzh = r7
            r7.zzy(r3)
            r7 = 0
            r3.zzl = r7
            r0 = 0
            r3.zzn = r0
            r3.zzm = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.zzs = r0
            r0 = 0
            r3.zzt = r0
            if (r6 == 0) goto L_0x0078
            java.lang.String r0 = r6.zzr()
        L_0x0078:
            com.google.android.gms.internal.ads.zzfwo r0 = com.google.android.gms.internal.ads.zzfwo.zzd(r0)
            java.lang.String r1 = ""
            java.lang.Object r0 = r0.zzb(r1)
            java.lang.String r0 = (java.lang.String) r0
            r3.zzo = r0
            if (r6 == 0) goto L_0x008d
            int r0 = r6.zzf()
            goto L_0x008e
        L_0x008d:
            r0 = r7
        L_0x008e:
            r3.zzp = r0
            com.google.android.gms.internal.ads.zzvv r0 = new com.google.android.gms.internal.ads.zzvv
            com.google.android.gms.ads.internal.util.zzs r1 = com.google.android.gms.ads.internal.zzv.zzq()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r6 = r6.zzn()
            java.lang.String r6 = r6.afmaVersion
            java.lang.String r4 = r1.zzc(r4, r6)
            boolean r6 = r3.zzj
            if (r6 == 0) goto L_0x00c0
            java.nio.ByteBuffer r6 = r3.zzi
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x00c0
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r5 = r3.zzi
            r5.get(r4)
            com.google.android.gms.internal.ads.zzceh r5 = new com.google.android.gms.internal.ads.zzceh
            r5.<init>(r4)
            goto L_0x012c
        L_0x00c0:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzce
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r1.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1 = 1
            if (r6 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzbW
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r2.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00e9
        L_0x00e5:
            boolean r6 = r5.zzi
            if (r6 != 0) goto L_0x00ea
        L_0x00e9:
            r7 = r1
        L_0x00ea:
            boolean r6 = r5.zzl
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzcej r6 = new com.google.android.gms.internal.ads.zzcej
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00f4:
            int r6 = r5.zzh
            if (r6 <= 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzcek r6 = new com.google.android.gms.internal.ads.zzcek
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.internal.ads.zzcel r6 = new com.google.android.gms.internal.ads.zzcel
            r6.<init>(r3, r4, r7)
        L_0x0103:
            boolean r4 = r5.zzi
            if (r4 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzcem r4 = new com.google.android.gms.internal.ads.zzcem
            r4.<init>(r3, r6)
            r5 = r4
            goto L_0x010f
        L_0x010e:
            r5 = r6
        L_0x010f:
            java.nio.ByteBuffer r4 = r3.zzi
            if (r4 == 0) goto L_0x012c
            int r4 = r4.limit()
            if (r4 <= 0) goto L_0x012c
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r6 = r3.zzi
            r6.get(r4)
            com.google.android.gms.internal.ads.zzcen r6 = new com.google.android.gms.internal.ads.zzcen
            r6.<init>(r5, r4)
            r5 = r6
        L_0x012c:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzl
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r6.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0144
            com.google.android.gms.internal.ads.zzcer r4 = new com.google.android.gms.internal.ads.zzcer
            r4.<init>()
            goto L_0x0149
        L_0x0144:
            com.google.android.gms.internal.ads.zzcei r4 = new com.google.android.gms.internal.ads.zzcei
            r4.<init>()
        L_0x0149:
            com.google.android.gms.internal.ads.zzvu r6 = new com.google.android.gms.internal.ads.zzvu
            r6.<init>(r4)
            r0.<init>(r5, r6)
            r3.zzg = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzces.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcce, com.google.android.gms.internal.ads.zzccf, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (zze.zzc()) {
            zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzad()) {
            return (long) this.zzl;
        }
        return 0;
    }

    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map zze2 = ((zzgy) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfwa.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    public final Integer zzC() {
        return this.zzr;
    }

    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzH() {
        zzir zzir = this.zzh;
        if (zzir != null) {
            zzir.zzA(this);
            this.zzh.zzz();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    public final void zzI(long j) {
        zzi zzi2 = (zzi) this.zzh;
        zzi2.zza(zzi2.zzd(), j, 5, false);
    }

    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    public final void zzL(zzcbv zzcbv) {
        this.zzk = zzcbv;
    }

    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    public final void zzO(boolean z) {
        this.zzh.zzq(z);
    }

    public final void zzP(Integer num) {
        this.zzr = num;
    }

    public final void zzQ(boolean z) {
        if (this.zzh != null) {
            int i = 0;
            while (true) {
                this.zzh.zzx();
                if (i < 2) {
                    zzyb zzyb = this.zzd;
                    zzxo zzc2 = zzyb.zzf().zzc();
                    zzc2.zzp(i, !z);
                    zzyb.zzl(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzR(int i) {
        for (WeakReference weakReference : this.zzu) {
            zzcec zzcec = (zzcec) weakReference.get();
            if (zzcec != null) {
                zzcec.zzm(i);
            }
        }
    }

    public final void zzS(Surface surface, boolean z) {
        zzir zzir = this.zzh;
        if (zzir != null) {
            zzir.zzr(surface);
        }
    }

    public final void zzT(float f, boolean z) {
        zzir zzir = this.zzh;
        if (zzir != null) {
            zzir.zzs(f);
        }
    }

    public final void zzU() {
        this.zzh.zzt();
    }

    public final boolean zzV() {
        return this.zzh != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgd zzW(String str, boolean z) {
        zzces zzces = true != z ? null : this;
        zzcce zzcce = this.zze;
        return new zzcev(str, zzces, zzcce.zzd, zzcce.zze, zzcce.zzm, zzcce.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgd zzX(String str, boolean z) {
        zzces zzces = true != z ? null : this;
        zzcce zzcce = this.zze;
        zzcec zzcec = new zzcec(str, zzces, zzcce.zzd, zzcce.zze, zzcce.zzh);
        this.zzu.add(new WeakReference(zzcec));
        return zzcec;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgd zzY(String str, boolean z) {
        zzgl zzgl = new zzgl();
        zzgl.zzf(str);
        zzgl.zze(true != z ? null : this);
        zzgl.zzc(this.zze.zzd);
        zzgl.zzd(this.zze.zze);
        zzgl.zzb(true);
        return zzgl.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgd zzZ(zzgc zzgc) {
        zzgd zza2 = zzgc.zza();
        zzceq zzceq = new zzceq(this);
        return new zzcef(this.zzb, zza2, this.zzo, this.zzp, this, zzceq);
    }

    public final void zza(zzgd zzgd, zzgi zzgi, boolean z, int i) {
        this.zzl += i;
    }

    /* access modifiers changed from: package-private */
    public final zzut zzaa(Uri uri) {
        zzak zzak = new zzak();
        zzak.zzb(uri);
        zzaw zzc2 = zzak.zzc();
        zzvv zzvv = this.zzg;
        zzvv.zza(this.zze.zzf);
        return zzvv.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(boolean z, long j) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv != null) {
            zzcbv.zzi(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzln[] zzac(Handler handler, zzabg zzabg, zzpn zzpn, zzwu zzwu, zztp zztp) {
        zzta zzta = zzta.zza;
        Context context = this.zzb;
        zzqw zzc2 = new zzqk(context).zzc();
        zzrc zzrc = new zzrc(context, new zzsf(context), zzta, false, handler, zzpn, zzc2);
        zzta zzta2 = zzta.zza;
        Context context2 = this.zzb;
        return new zzln[]{zzrc, new zzaai(context2, new zzsf(context2), zzta2, 0, false, handler, zzabg, -1, 30.0f)};
    }

    public final void zzb(zzgd zzgd, zzgi zzgi, boolean z) {
    }

    public final void zzc(zzgd zzgd, zzgi zzgi, boolean z) {
    }

    public final void zzd(zzgd zzgd, zzgi zzgi, boolean z) {
        if (zzgd instanceof zzgy) {
            synchronized (this.zzq) {
                this.zzs.add((zzgy) zzgd);
            }
        } else if (zzgd instanceof zzcef) {
            this.zzt = (zzcef) zzgd;
            zzccf zzccf = (zzccf) this.zzf.get();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue() && zzccf != null && this.zzt.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                zzs.zza.post(new zzceo(zzccf, hashMap));
            }
        }
    }

    public final void zze(zzlx zzlx, zzad zzad, zzhy zzhy) {
        zzccf zzccf = (zzccf) this.zzf.get();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue() && zzccf != null) {
            HashMap hashMap = new HashMap();
            String str = zzad.zzn;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzad.zzo;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzad.zzk;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzccf.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzlx zzlx, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzg(zzlx zzlx, zzun zzun) {
    }

    public final void zzh(zzlx zzlx, int i, long j) {
        this.zzm += i;
    }

    public final /* synthetic */ void zzi(zzbp zzbp, zzly zzly) {
    }

    public final void zzj(zzlx zzlx, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv == null) {
            return;
        }
        if (this.zze.zzj) {
            zzcbv.zzl("onLoadException", iOException);
        } else {
            zzcbv.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzlx zzlx, int i) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv != null) {
            zzcbv.zzm(i);
        }
    }

    public final void zzl(zzlx zzlx, zzbi zzbi) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv != null) {
            zzcbv.zzk("onPlayerError", zzbi);
        }
    }

    public final /* synthetic */ void zzm(zzlx zzlx, zzbn zzbn, zzbn zzbn2, int i) {
    }

    public final void zzn(zzlx zzlx, Object obj, long j) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv != null) {
            zzcbv.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzlx zzlx, zzhx zzhx) {
    }

    public final void zzp(zzlx zzlx, zzad zzad, zzhy zzhy) {
        zzccf zzccf = (zzccf) this.zzf.get();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue() && zzccf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzad.zzw));
            hashMap.put("bitRate", String.valueOf(zzad.zzj));
            int i = zzad.zzu;
            int i2 = zzad.zzv;
            hashMap.put("resolution", i + "x" + i2);
            String str = zzad.zzn;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzad.zzo;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzad.zzk;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzccf.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzlx zzlx, zzci zzci) {
        zzcbv zzcbv = this.zzk;
        if (zzcbv != null) {
            zzcbv.zzD(zzci.zzb, zzci.zzc);
        }
    }

    public final int zzr() {
        return this.zzm;
    }

    public final int zzt() {
        return this.zzh.zzf();
    }

    public final long zzv() {
        return this.zzh.zzi();
    }

    public final long zzw() {
        return (long) this.zzl;
    }

    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min((long) this.zzl, this.zzt.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzh.zzk();
    }

    public final long zzz() {
        return this.zzh.zzl();
    }

    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzut zzut;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzut = zzaa(uriArr[0]);
            } else {
                zzut[] zzutArr = new zzut[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzutArr[i] = zzaa(uriArr[i]);
                }
                zzut = new zzvg(false, false, new zzuc(), zzutArr);
            }
            this.zzh.zzB(zzut);
            this.zzh.zzp();
            zzE().incrementAndGet();
        }
    }
}
