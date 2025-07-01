package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.compose.runtime.ComposerKt;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzdw;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zzpb;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.measurement.internal.zzje;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
public class zznv implements zzjc {
    private static volatile zznv zza;
    private List<Long> zzaa;
    private long zzab;
    private final Map<String, zzje> zzac;
    private final Map<String, zzax> zzad;
    private final Map<String, zzb> zzae;
    private zzlk zzaf;
    private String zzag;
    private final zzor zzah;
    private zzhl zzb;
    private zzgr zzc;
    private zzal zzd;
    private zzgy zze;
    private zznq zzf;
    private zzt zzg;
    private final zzoo zzh;
    private zzli zzi;
    private zzmw zzj;
    private final zznu zzk;
    private zzhf zzl;
    /* access modifiers changed from: private */
    public final zzhy zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;
    private List<Runnable> zzq;
    private final Set<String> zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List<Long> zzz;

    /* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
    private class zza implements zzas {
        zzfy.zzk zza;
        List<Long> zzb;
        List<zzfy.zzf> zzc;
        private long zzd;

        private static long zza(zzfy.zzf zzf) {
            return ((zzf.zzd() / 1000) / 60) / 60;
        }

        private zza() {
        }

        public final void zza(zzfy.zzk zzk) {
            Preconditions.checkNotNull(zzk);
            this.zza = zzk;
        }

        public final boolean zza(long j, zzfy.zzf zzf) {
            Preconditions.checkNotNull(zzf);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (!this.zzc.isEmpty() && zza(this.zzc.get(0)) != zza(zzf)) {
                return false;
            }
            long zzcb = this.zzd + ((long) zzf.zzcb());
            zznv.this.zze();
            if (zzcb >= ((long) Math.max(0, zzbh.zzi.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzcb;
            this.zzc.add(zzf);
            this.zzb.add(Long.valueOf(j));
            int size = this.zzc.size();
            zznv.this.zze();
            if (size >= Math.max(1, zzbh.zzj.zza(null).intValue())) {
                return false;
            }
            return true;
        }
    }

    private final int zza(String str, zzah zzah2) {
        zzjh zza2;
        if (this.zzb.zzb(str) == null) {
            zzah2.zza(zzje.zza.AD_PERSONALIZATION, zzak.FAILSAFE);
            return 1;
        }
        zzg zze2 = zzf().zze(str);
        if (zze2 == null || zzf.zza(zze2.zzak()).zza() != zzjh.POLICY || (zza2 = this.zzb.zza(str, zzje.zza.AD_PERSONALIZATION)) == zzjh.UNINITIALIZED) {
            zzah2.zza(zzje.zza.AD_PERSONALIZATION, zzak.REMOTE_DEFAULT);
            if (this.zzb.zzc(str, zzje.zza.AD_PERSONALIZATION)) {
                return 0;
            }
            return 1;
        }
        zzah2.zza(zzje.zza.AD_PERSONALIZATION, zzak.REMOTE_ENFORCED_DEFAULT);
        if (zza2 == zzjh.GRANTED) {
            return 0;
        }
        return 1;
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
    private class zzb {
        final String zza;
        long zzb;

        private zzb(zznv zznv) {
            this(zznv, zznv.zzq().zzp());
        }

        private zzb(zznv zznv, String str) {
            this.zza = str;
            this.zzb = zznv.zzb().elapsedRealtime();
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzl().zzt();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    zzj().zzu().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final long zzx() {
        long currentTimeMillis = zzb().currentTimeMillis();
        zzmw zzmw = this.zzj;
        zzmw.zzal();
        zzmw.zzt();
        long zza2 = zzmw.zzf.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzmw.zzq().zzv().nextInt(86400000)) + 1;
            zzmw.zzf.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zza() {
        return this.zzm.zza();
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(String str) {
        int i;
        zzl().zzt();
        zzs();
        if (zzi().zzb(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzje zzb2 = zzb(str);
        bundle.putAll(zzb2.zzb());
        bundle.putAll(zza(str, zzd(str), zzb2, new zzah()).zzb());
        zzop zze2 = zzf().zze(str, "_npa");
        if (zze2 != null) {
            i = zze2.zze.equals(1L);
        } else {
            i = zza(str, new zzah());
        }
        bundle.putString("ad_personalization", i == 1 ? "denied" : "granted");
        return bundle;
    }

    public final Clock zzb() {
        return ((zzhy) Preconditions.checkNotNull(this.zzm)).zzb();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x024d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzo r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzhv r0 = r12.zzl()
            r0.zzt()
            r12.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            java.lang.String r0 = r13.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            java.lang.String r0 = r13.zzu
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.Map<java.lang.String, com.google.android.gms.measurement.internal.zznv$zzb> r0 = r12.zzae
            java.lang.String r2 = r13.zza
            com.google.android.gms.measurement.internal.zznv$zzb r3 = new com.google.android.gms.measurement.internal.zznv$zzb
            java.lang.String r4 = r13.zzu
            r3.<init>(r4)
            r0.put(r2, r3)
        L_0x0029:
            com.google.android.gms.measurement.internal.zzal r0 = r12.zzf()
            java.lang.String r2 = r13.zza
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r2)
            java.lang.String r2 = r13.zza
            com.google.android.gms.measurement.internal.zzje r2 = r12.zzb((java.lang.String) r2)
            java.lang.String r3 = r13.zzt
            com.google.android.gms.measurement.internal.zzje r3 = com.google.android.gms.measurement.internal.zzje.zzb((java.lang.String) r3)
            com.google.android.gms.measurement.internal.zzje r2 = r2.zza((com.google.android.gms.measurement.internal.zzje) r3)
            boolean r3 = r2.zzg()
            if (r3 == 0) goto L_0x0054
            com.google.android.gms.measurement.internal.zzmw r3 = r12.zzj
            java.lang.String r4 = r13.zza
            boolean r5 = r13.zzn
            java.lang.String r3 = r3.zza((java.lang.String) r4, (boolean) r5)
            goto L_0x0056
        L_0x0054:
            java.lang.String r3 = ""
        L_0x0056:
            r4 = 0
            if (r0 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzhy r5 = r12.zzm
            java.lang.String r6 = r13.zza
            r0.<init>(r5, r6)
            boolean r5 = r2.zzh()
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = r12.zza((com.google.android.gms.measurement.internal.zzje) r2)
            r0.zzb((java.lang.String) r5)
        L_0x006f:
            boolean r2 = r2.zzg()
            if (r2 == 0) goto L_0x013d
            r0.zzh((java.lang.String) r3)
            goto L_0x013d
        L_0x007a:
            boolean r5 = r2.zzg()
            if (r5 == 0) goto L_0x0126
            if (r3 == 0) goto L_0x0126
            java.lang.String r5 = r0.zzaj()
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0126
            java.lang.String r5 = r0.zzaj()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r0.zzh((java.lang.String) r3)
            boolean r3 = r13.zzn
            if (r3 == 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzmw r3 = r12.zzj
            java.lang.String r6 = r13.zza
            android.util.Pair r3 = r3.zza((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzje) r2)
            java.lang.Object r3 = r3.first
            java.lang.String r6 = "00000000-0000-0000-0000-000000000000"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x010e
            if (r5 != 0) goto L_0x010e
            boolean r3 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r3 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzag r3 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzcy
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x00c9
            boolean r3 = r2.zzh()
            if (r3 != 0) goto L_0x00c9
            r2 = 1
            goto L_0x00d1
        L_0x00c9:
            java.lang.String r2 = r12.zza((com.google.android.gms.measurement.internal.zzje) r2)
            r0.zzb((java.lang.String) r2)
            r2 = r4
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzal r3 = r12.zzf()
            java.lang.String r5 = r13.zza
            java.lang.String r6 = "_id"
            com.google.android.gms.measurement.internal.zzop r3 = r3.zze(r5, r6)
            if (r3 == 0) goto L_0x013e
            com.google.android.gms.measurement.internal.zzal r3 = r12.zzf()
            java.lang.String r5 = r13.zza
            java.lang.String r6 = "_lair"
            com.google.android.gms.measurement.internal.zzop r3 = r3.zze(r5, r6)
            if (r3 != 0) goto L_0x013e
            com.google.android.gms.common.util.Clock r3 = r12.zzb()
            long r9 = r3.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzop r5 = new com.google.android.gms.measurement.internal.zzop
            java.lang.String r6 = r13.zza
            r7 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r7)
            java.lang.String r7 = "auto"
            java.lang.String r8 = "_lair"
            r5.<init>(r6, r7, r8, r9, r11)
            com.google.android.gms.measurement.internal.zzal r3 = r12.zzf()
            r3.zza((com.google.android.gms.measurement.internal.zzop) r5)
            goto L_0x013e
        L_0x010e:
            java.lang.String r3 = r0.zzad()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x013d
            boolean r3 = r2.zzh()
            if (r3 == 0) goto L_0x013d
            java.lang.String r2 = r12.zza((com.google.android.gms.measurement.internal.zzje) r2)
            r0.zzb((java.lang.String) r2)
            goto L_0x013d
        L_0x0126:
            java.lang.String r3 = r0.zzad()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x013d
            boolean r3 = r2.zzh()
            if (r3 == 0) goto L_0x013d
            java.lang.String r2 = r12.zza((com.google.android.gms.measurement.internal.zzje) r2)
            r0.zzb((java.lang.String) r2)
        L_0x013d:
            r2 = r4
        L_0x013e:
            java.lang.String r3 = r13.zzb
            r0.zzf((java.lang.String) r3)
            java.lang.String r3 = r13.zzp
            r0.zza((java.lang.String) r3)
            java.lang.String r3 = r13.zzk
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0155
            java.lang.String r3 = r13.zzk
            r0.zze((java.lang.String) r3)
        L_0x0155:
            long r5 = r13.zze
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0162
            long r5 = r13.zze
            r0.zzn(r5)
        L_0x0162:
            java.lang.String r3 = r13.zzc
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = r13.zzc
            r0.zzd((java.lang.String) r3)
        L_0x016f:
            long r5 = r13.zzj
            r0.zzb((long) r5)
            java.lang.String r3 = r13.zzd
            if (r3 == 0) goto L_0x017d
            java.lang.String r3 = r13.zzd
            r0.zzc((java.lang.String) r3)
        L_0x017d:
            long r5 = r13.zzf
            r0.zzk((long) r5)
            boolean r3 = r13.zzh
            r0.zzb((boolean) r3)
            java.lang.String r3 = r13.zzg
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0194
            java.lang.String r3 = r13.zzg
            r0.zzg((java.lang.String) r3)
        L_0x0194:
            boolean r3 = r13.zzn
            r0.zza((boolean) r3)
            java.lang.Boolean r3 = r13.zzq
            r0.zza((java.lang.Boolean) r3)
            long r5 = r13.zzr
            r0.zzl(r5)
            java.lang.String r3 = r13.zzv
            r0.zzj((java.lang.String) r3)
            boolean r3 = com.google.android.gms.internal.measurement.zzny.zza()
            if (r3 == 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzag r3 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzbv
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x01c0
            java.util.List<java.lang.String> r1 = r13.zzs
            r0.zza((java.util.List<java.lang.String>) r1)
            goto L_0x01d5
        L_0x01c0:
            boolean r3 = com.google.android.gms.internal.measurement.zzny.zza()
            if (r3 == 0) goto L_0x01d5
            com.google.android.gms.measurement.internal.zzag r3 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzbu
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x01d5
            r0.zza((java.util.List<java.lang.String>) r1)
        L_0x01d5:
            boolean r1 = com.google.android.gms.internal.measurement.zzpu.zza()
            if (r1 == 0) goto L_0x020a
            com.google.android.gms.measurement.internal.zzag r1 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzbx
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x020a
            r12.zzq()
            java.lang.String r1 = r0.zzac()
            boolean r1 = com.google.android.gms.measurement.internal.zzos.zzf(r1)
            if (r1 == 0) goto L_0x020a
            boolean r1 = r13.zzw
            r0.zzc((boolean) r1)
            com.google.android.gms.measurement.internal.zzag r1 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzby
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x020a
            java.lang.String r1 = r13.zzac
            r0.zzk((java.lang.String) r1)
        L_0x020a:
            boolean r1 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r1 == 0) goto L_0x0221
            com.google.android.gms.measurement.internal.zzag r1 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzch
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x0221
            int r1 = r13.zzaa
            r0.zza((int) r1)
        L_0x0221:
            long r5 = r13.zzx
            r0.zzt(r5)
            java.lang.String r13 = r13.zzad
            r0.zzi((java.lang.String) r13)
            boolean r13 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r13 == 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzag r13 = r12.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbh.zzcy
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r1)
            if (r13 == 0) goto L_0x024d
            boolean r13 = r0.zzas()
            if (r13 != 0) goto L_0x0245
            if (r2 == 0) goto L_0x025a
        L_0x0245:
            com.google.android.gms.measurement.internal.zzal r13 = r12.zzf()
            r13.zza((com.google.android.gms.measurement.internal.zzg) r0, (boolean) r2, (boolean) r4)
            return r0
        L_0x024d:
            boolean r13 = r0.zzas()
            if (r13 == 0) goto L_0x025a
            com.google.android.gms.measurement.internal.zzal r13 = r12.zzf()
            r13.zza((com.google.android.gms.measurement.internal.zzg) r0, (boolean) r4, (boolean) r4)
        L_0x025a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zza(com.google.android.gms.measurement.internal.zzo):com.google.android.gms.measurement.internal.zzg");
    }

    private final zzo zzc(String str) {
        String str2 = str;
        zzg zze2 = zzf().zze(str2);
        if (zze2 == null || TextUtils.isEmpty(zze2.zzaf())) {
            zzj().zzc().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zza2 = zza(zze2);
        if (zza2 == null || zza2.booleanValue()) {
            zzg zzg2 = zze2;
            zzg zzg3 = zzg2;
            zzg zzg4 = zzg3;
            zzg zzg5 = zzg4;
            zzg zzg6 = zzg5;
            return new zzo(str2, zzg2.zzah(), zzg2.zzaf(), zzg3.zze(), zzg4.zzae(), zzg5.zzq(), zzg6.zzn(), (String) null, zzg6.zzar(), false, zzg6.zzag(), zzg6.zzd(), 0, 0, zzg6.zzaq(), false, zzg6.zzaa(), zzg6.zzx(), zzg6.zzo(), zzg6.zzan(), (String) null, zzb(str).zzf(), "", (String) null, zzg6.zzat(), zzg6.zzw(), zzb(str).zza(), zzd(str).zzf(), zzg6.zza(), zzg6.zzf(), zzg6.zzam(), zzg6.zzak());
        }
        zzj().zzg().zza("App version does not match; dropping. appId", zzgo.zza(str2));
        return null;
    }

    public final zzt zzc() {
        return (zzt) zza((zznr) this.zzg);
    }

    public final zzab zzd() {
        return this.zzm.zzd();
    }

    public final zzag zze() {
        return ((zzhy) Preconditions.checkNotNull(this.zzm)).zzf();
    }

    public final zzal zzf() {
        return (zzal) zza((zznr) this.zzd);
    }

    private final zzax zza(String str, zzax zzax, zzje zzje, zzah zzah2) {
        zzjh zzjh;
        int i = 90;
        boolean z = true;
        if (zzi().zzb(str) == null) {
            if (zzax.zzc() == zzjh.DENIED) {
                i = zzax.zza();
                zzah2.zza(zzje.zza.AD_USER_DATA, i);
            } else {
                zzah2.zza(zzje.zza.AD_USER_DATA, zzak.FAILSAFE);
            }
            return new zzax((Boolean) false, i, (Boolean) true, "-");
        }
        zzjh zzc2 = zzax.zzc();
        if (zzc2 == zzjh.GRANTED || zzc2 == zzjh.DENIED) {
            i = zzax.zza();
            zzah2.zza(zzje.zza.AD_USER_DATA, i);
        } else {
            if (zzc2 != zzjh.POLICY || (zzjh = this.zzb.zza(str, zzje.zza.AD_USER_DATA)) == zzjh.UNINITIALIZED) {
                zzje.zza zzb2 = this.zzb.zzb(str, zzje.zza.AD_USER_DATA);
                zzjh zzc3 = zzje.zzc();
                if (!(zzc3 == zzjh.GRANTED || zzc3 == zzjh.DENIED)) {
                    z = false;
                }
                if (zzb2 != zzje.zza.AD_STORAGE || !z) {
                    zzah2.zza(zzje.zza.AD_USER_DATA, zzak.REMOTE_DEFAULT);
                    if (this.zzb.zzc(str, zzje.zza.AD_USER_DATA)) {
                        zzjh = zzjh.GRANTED;
                    } else {
                        zzjh = zzjh.DENIED;
                    }
                } else {
                    zzah2.zza(zzje.zza.AD_USER_DATA, zzak.REMOTE_DELEGATION);
                    zzc2 = zzc3;
                }
            } else {
                zzah2.zza(zzje.zza.AD_USER_DATA, zzak.REMOTE_ENFORCED_DEFAULT);
            }
            zzc2 = zzjh;
        }
        boolean zzm2 = this.zzb.zzm(str);
        SortedSet<String> zzh2 = zzi().zzh(str);
        if (zzc2 == zzjh.DENIED || zzh2.isEmpty()) {
            return new zzax((Boolean) false, i, Boolean.valueOf(zzm2), "-");
        }
        Boolean valueOf = Boolean.valueOf(zzm2);
        String str2 = "";
        if (zzm2) {
            str2 = TextUtils.join(str2, zzh2);
        }
        return new zzax((Boolean) true, i, valueOf, str2);
    }

    private final zzax zzd(String str) {
        zzl().zzt();
        zzs();
        zzax zzax = this.zzad.get(str);
        if (zzax != null) {
            return zzax;
        }
        zzax zzg2 = zzf().zzg(str);
        this.zzad.put(str, zzg2);
        return zzg2;
    }

    public final zzgh zzg() {
        return this.zzm.zzk();
    }

    public final zzgo zzj() {
        return ((zzhy) Preconditions.checkNotNull(this.zzm)).zzj();
    }

    public final zzgr zzh() {
        return (zzgr) zza((zznr) this.zzc);
    }

    private final zzgy zzy() {
        zzgy zzgy = this.zze;
        if (zzgy != null) {
            return zzgy;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzhl zzi() {
        return (zzhl) zza((zznr) this.zzb);
    }

    public final zzhv zzl() {
        return ((zzhy) Preconditions.checkNotNull(this.zzm)).zzl();
    }

    /* access modifiers changed from: package-private */
    public final zzhy zzk() {
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    public final zzje zzb(String str) {
        zzl().zzt();
        zzs();
        zzje zzje = this.zzac.get(str);
        if (zzje == null) {
            zzje = zzf().zzi(str);
            if (zzje == null) {
                zzje = zzje.zza;
            }
            zza(str, zzje);
        }
        return zzje;
    }

    public final zzli zzm() {
        return (zzli) zza((zznr) this.zzi);
    }

    public final zzmw zzn() {
        return this.zzj;
    }

    private final zznq zzz() {
        return (zznq) zza((zznr) this.zzf);
    }

    private static zznr zza(zznr zznr) {
        if (zznr == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zznr.zzan()) {
            return zznr;
        } else {
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zznr.getClass()));
        }
    }

    public final zznu zzo() {
        return this.zzk;
    }

    public static zznv zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zznv.class) {
                if (zza == null) {
                    zza = new zznv((zzok) Preconditions.checkNotNull(new zzok(context)));
                }
            }
        }
        return zza;
    }

    public final zzoo zzp() {
        return (zzoo) zza((zznr) this.zzh);
    }

    public final zzos zzq() {
        return ((zzhy) Preconditions.checkNotNull(this.zzm)).zzt();
    }

    private final Boolean zza(zzg zzg2) {
        try {
            if (zzg2.zze() != -2147483648L) {
                if (zzg2.zze() == ((long) Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzg2.zzac(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzg2.zzac(), 0).versionName;
                String zzaf2 = zzg2.zzaf();
                if (zzaf2 != null && zzaf2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static Boolean zzh(zzo zzo2) {
        Boolean bool = zzo2.zzq;
        if (!TextUtils.isEmpty(zzo2.zzad)) {
            int i = zzoa.zza[zzf.zza(zzo2.zzad).zza().ordinal()];
            if (i == 1) {
                return null;
            }
            if (i == 2) {
                return false;
            }
            if (i == 3) {
                return true;
            }
            if (i != 4) {
                return bool;
            }
            return null;
        }
        return bool;
    }

    private final String zza(zzje zzje) {
        if (!zzje.zzh()) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzq().zzv().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzb(zzo zzo2) {
        try {
            return (String) zzl().zza(new zzog(this, zzo2)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzj().zzg().zza("Failed to get app instance id. appId", zzgo.zza(zzo2.zza), e);
            return null;
        }
    }

    private static String zza(Map<String, List<String>> map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry next : map.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                if (((List) next.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) next.getValue()).get(0);
            }
        }
        return null;
    }

    static /* synthetic */ void zza(zznv zznv, zzok zzok) {
        zznv.zzl().zzt();
        zznv.zzl = new zzhf(zznv);
        zzal zzal = new zzal(zznv);
        zzal.zzam();
        zznv.zzd = zzal;
        zznv.zze().zza((zzai) Preconditions.checkNotNull(zznv.zzb));
        zzmw zzmw = new zzmw(zznv);
        zzmw.zzam();
        zznv.zzj = zzmw;
        zzt zzt2 = new zzt(zznv);
        zzt2.zzam();
        zznv.zzg = zzt2;
        zzli zzli = new zzli(zznv);
        zzli.zzam();
        zznv.zzi = zzli;
        zznq zznq = new zznq(zznv);
        zznq.zzam();
        zznv.zzf = zznq;
        zznv.zze = new zzgy(zznv);
        if (zznv.zzs != zznv.zzt) {
            zznv.zzj().zzg().zza("Not all upload components initialized", Integer.valueOf(zznv.zzs), Integer.valueOf(zznv.zzt));
        }
        zznv.zzn = true;
    }

    private zznv(zzok zzok) {
        this(zzok, (zzhy) null);
    }

    private zznv(zzok zzok, zzhy zzhy) {
        this.zzn = false;
        this.zzr = new HashSet();
        this.zzah = new zzof(this);
        Preconditions.checkNotNull(zzok);
        this.zzm = zzhy.zza(zzok.zza, (zzdw) null, (Long) null);
        this.zzab = -1;
        this.zzk = new zznu(this);
        zzoo zzoo = new zzoo(this);
        zzoo.zzam();
        this.zzh = zzoo;
        zzgr zzgr = new zzgr(this);
        zzgr.zzam();
        this.zzc = zzgr;
        zzhl zzhl = new zzhl(this);
        zzhl.zzam();
        this.zzb = zzhl;
        this.zzac = new HashMap();
        this.zzad = new HashMap();
        this.zzae = new HashMap();
        zzl().zzb((Runnable) new zznx(this, zzok));
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzl().zzt();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzl().zzt();
        zzs();
        if (!this.zzo) {
            this.zzo = true;
            if (zzae()) {
                int zza2 = zza(this.zzy);
                int zzab2 = this.zzm.zzh().zzab();
                zzl().zzt();
                if (zza2 > zzab2) {
                    zzj().zzg().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                } else if (zza2 >= zzab2) {
                } else {
                    if (zza(zzab2, this.zzy)) {
                        zzj().zzp().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                    } else {
                        zzj().zzg().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs() {
        if (!this.zzn) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private final void zzaa() {
        zzl().zzt();
        if (this.zzu || this.zzv || this.zzw) {
            zzj().zzp().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzj().zzp().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzfy.zzk.zza zza2) {
        int zza3;
        int indexOf;
        Set<String> zzg2 = zzi().zzg(str);
        if (zzg2 != null) {
            zza2.zzd((Iterable<String>) zzg2);
        }
        if (zzi().zzp(str)) {
            zza2.zzj();
        }
        if (zzi().zzs(str)) {
            String zzy2 = zza2.zzy();
            if (!TextUtils.isEmpty(zzy2) && (indexOf = zzy2.indexOf(".")) != -1) {
                zza2.zzo(zzy2.substring(0, indexOf));
            }
        }
        if (zzi().zzt(str) && (zza3 = zzoo.zza(zza2, "_id")) != -1) {
            zza2.zzc(zza3);
        }
        if (zzi().zzr(str)) {
            zza2.zzk();
        }
        if (zzi().zzo(str)) {
            zza2.zzh();
            if (!zznm.zza() || !zze().zza(zzbh.zzcy) || zzb(str).zzh()) {
                zzb zzb2 = this.zzae.get(str);
                if (zzb2 == null || zzb2.zzb + zze().zzc(str, zzbh.zzaw) < zzb().elapsedRealtime()) {
                    zzb2 = new zzb();
                    this.zzae.put(str, zzb2);
                }
                zza2.zzk(zzb2.zza);
            }
        }
        if (zzi().zzq(str)) {
            zza2.zzr();
        }
    }

    private final void zzb(zzg zzg2) {
        zzg zzg3 = zzg2;
        zzl().zzt();
        if (!TextUtils.isEmpty(zzg3.zzah()) || !TextUtils.isEmpty(zzg3.zzaa())) {
            ArrayMap arrayMap = null;
            if (!zzpb.zza() || !zze().zza(zzbh.zzcf)) {
                String zza2 = this.zzk.zza(zzg3);
                try {
                    String str = (String) Preconditions.checkNotNull(zzg3.zzac());
                    URL url = new URL(zza2);
                    zzj().zzp().zza("Fetching remote configuration", str);
                    zzfr.zzd zzc2 = zzi().zzc(str);
                    String zze2 = zzi().zze(str);
                    if (zzc2 != null) {
                        if (!TextUtils.isEmpty(zze2)) {
                            arrayMap = new ArrayMap();
                            arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zze2);
                        }
                        String zzd2 = zzi().zzd(str);
                        if (!TextUtils.isEmpty(zzd2)) {
                            if (arrayMap == null) {
                                arrayMap = new ArrayMap();
                            }
                            arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzd2);
                        }
                    }
                    this.zzu = true;
                    zzgr zzh2 = zzh();
                    zzod zzod = new zzod(this);
                    zzh2.zzt();
                    zzh2.zzal();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(zzod);
                    zzh2.zzl().zza((Runnable) new zzgw(zzh2, str, url, (byte[]) null, arrayMap, zzod));
                } catch (MalformedURLException unused) {
                    zzj().zzg().zza("Failed to parse config URL. Not fetching. appId", zzgo.zza(zzg3.zzac()), zza2);
                }
            } else {
                String str2 = (String) Preconditions.checkNotNull(zzg3.zzac());
                zzj().zzp().zza("Fetching remote configuration", str2);
                zzfr.zzd zzc3 = zzi().zzc(str2);
                String zze3 = zzi().zze(str2);
                if (zzc3 != null) {
                    if (!TextUtils.isEmpty(zze3)) {
                        arrayMap = new ArrayMap();
                        arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zze3);
                    }
                    String zzd3 = zzi().zzd(str2);
                    if (!TextUtils.isEmpty(zzd3)) {
                        if (arrayMap == null) {
                            arrayMap = new ArrayMap();
                        }
                        arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzd3);
                    }
                }
                ArrayMap arrayMap2 = arrayMap;
                this.zzu = true;
                zzgr zzh3 = zzh();
                zzny zzny = new zzny(this);
                zzh3.zzt();
                zzh3.zzal();
                Preconditions.checkNotNull(zzg3);
                Preconditions.checkNotNull(zzny);
                String zza3 = zzh3.zzo().zza(zzg3);
                try {
                    zzh3.zzl().zza((Runnable) new zzgw(zzh3, zzg3.zzac(), new URI(zza3).toURL(), (byte[]) null, arrayMap2, zzny));
                } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
                    zzh3.zzj().zzg().zza("Failed to parse config URL. Not fetching. appId", zzgo.zza(zzg3.zzac()), zza3);
                }
            }
        } else {
            zza((String) Preconditions.checkNotNull(zzg3.zzac()), ComposerKt.providerMapsKey, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzg zzg2, zzfy.zzk.zza zza2) {
        zzfy.zzo zzo2;
        zzl().zzt();
        zzs();
        zzah zza3 = zzah.zza(zza2.zzv());
        String zzac2 = zzg2.zzac();
        zzl().zzt();
        zzs();
        zzje zzb2 = zzb(zzac2);
        int i = zzoa.zza[zzb2.zzc().ordinal()];
        if (i == 1) {
            zza3.zza(zzje.zza.AD_STORAGE, zzak.REMOTE_ENFORCED_DEFAULT);
        } else if (i == 2 || i == 3) {
            zza3.zza(zzje.zza.AD_STORAGE, zzb2.zza());
        } else {
            zza3.zza(zzje.zza.AD_STORAGE, zzak.FAILSAFE);
        }
        int i2 = zzoa.zza[zzb2.zzd().ordinal()];
        if (i2 == 1) {
            zza3.zza(zzje.zza.ANALYTICS_STORAGE, zzak.REMOTE_ENFORCED_DEFAULT);
        } else if (i2 == 2 || i2 == 3) {
            zza3.zza(zzje.zza.ANALYTICS_STORAGE, zzb2.zza());
        } else {
            zza3.zza(zzje.zza.ANALYTICS_STORAGE, zzak.FAILSAFE);
        }
        String zzac3 = zzg2.zzac();
        zzl().zzt();
        zzs();
        zzax zza4 = zza(zzac3, zzd(zzac3), zzb(zzac3), zza3);
        zza2.zzb(((Boolean) Preconditions.checkNotNull(zza4.zzd())).booleanValue());
        if (!TextUtils.isEmpty(zza4.zze())) {
            zza2.zzh(zza4.zze());
        }
        zzl().zzt();
        zzs();
        Iterator<zzfy.zzo> it = zza2.zzab().iterator();
        while (true) {
            if (!it.hasNext()) {
                zzo2 = null;
                break;
            }
            zzo2 = it.next();
            if ("_npa".equals(zzo2.zzg())) {
                break;
            }
        }
        if (zzo2 == null) {
            int zza5 = zza(zzg2.zzac(), zza3);
            zza2.zza((zzfy.zzo) ((zzjt) zzfy.zzo.zze().zza("_npa").zzb(zzb().currentTimeMillis()).zza((long) zza5).zzai()));
            zzj().zzp().zza("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zza5));
        } else if (zza3.zza(zzje.zza.AD_PERSONALIZATION) == zzak.UNSET) {
            zzop zze2 = zzf().zze(zzg2.zzac(), "_npa");
            if (zze2 == null) {
                Boolean zzx2 = zzg2.zzx();
                if (zzx2 == null || ((zzx2 == Boolean.TRUE && zzo2.zzc() != 1) || (zzx2 == Boolean.FALSE && zzo2.zzc() != 0))) {
                    zza3.zza(zzje.zza.AD_PERSONALIZATION, zzak.API);
                } else {
                    zza3.zza(zzje.zza.AD_PERSONALIZATION, zzak.MANIFEST);
                }
            } else if ("tcf".equals(zze2.zzb)) {
                zza3.zza(zzje.zza.AD_PERSONALIZATION, zzak.TCF);
            } else if ("app".equals(zze2.zzb)) {
                zza3.zza(zzje.zza.AD_PERSONALIZATION, zzak.API);
            } else {
                zza3.zza(zzje.zza.AD_PERSONALIZATION, zzak.MANIFEST);
            }
        }
        zza2.zzf(zza3.toString());
        boolean zzm2 = this.zzb.zzm(zzg2.zzac());
        List<zzfy.zzf> zzaa2 = zza2.zzaa();
        int i3 = 0;
        for (int i4 = 0; i4 < zzaa2.size(); i4++) {
            if ("_tcf".equals(zzaa2.get(i4).zzg())) {
                zzjt.zzb zzcd = zzaa2.get(i4).zzcd();
                zzjt.zzb zzb3 = zzcd;
                zzfy.zzf.zza zza6 = (zzfy.zzf.zza) zzcd;
                List<zzfy.zzh> zzf2 = zza6.zzf();
                while (true) {
                    if (i3 >= zzf2.size()) {
                        break;
                    } else if ("_tcfd".equals(zzf2.get(i3).zzg())) {
                        zza6.zza(i3, zzfy.zzh.zze().zza("_tcfd").zzb(zznm.zza(zzf2.get(i3).zzh(), zzm2)));
                        break;
                    } else {
                        i3++;
                    }
                }
                zza2.zza(i4, zza6);
                return;
            }
        }
    }

    private static void zza(zzfy.zzf.zza zza2, int i, String str) {
        List<zzfy.zzh> zzf2 = zza2.zzf();
        int i2 = 0;
        while (i2 < zzf2.size()) {
            if (!"_err".equals(zzf2.get(i2).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzfy.zzh) ((zzjt) zzfy.zzh.zze().zza("_err").zza(Long.valueOf((long) i).longValue()).zzai())).zza((zzfy.zzh) ((zzjt) zzfy.zzh.zze().zza("_ev").zzb(str).zzai()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002b, code lost:
        r4 = r1.zzag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzbf r21, com.google.android.gms.measurement.internal.zzo r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r2 = r0.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            com.google.android.gms.measurement.internal.zzhv r2 = r1.zzl()
            r2.zzt()
            r1.zzs()
            java.lang.String r2 = r0.zza
            r3 = r21
            long r7 = r3.zzd
            com.google.android.gms.measurement.internal.zzgs r3 = com.google.android.gms.measurement.internal.zzgs.zza(r3)
            com.google.android.gms.measurement.internal.zzhv r4 = r1.zzl()
            r4.zzt()
            com.google.android.gms.measurement.internal.zzlk r4 = r1.zzaf
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = r1.zzag
            if (r4 == 0) goto L_0x0039
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            com.google.android.gms.measurement.internal.zzlk r4 = r1.zzaf
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            android.os.Bundle r5 = r3.zzc
            r10 = 0
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzlk) r4, (android.os.Bundle) r5, (boolean) r10)
            com.google.android.gms.measurement.internal.zzbf r3 = r3.zza()
            r1.zzp()
            boolean r4 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.measurement.internal.zzbf) r3, (com.google.android.gms.measurement.internal.zzo) r0)
            if (r4 != 0) goto L_0x004e
            return
        L_0x004e:
            boolean r4 = r0.zzh
            if (r4 != 0) goto L_0x0056
            r1.zza((com.google.android.gms.measurement.internal.zzo) r0)
            return
        L_0x0056:
            java.util.List<java.lang.String> r4 = r0.zzs
            if (r4 == 0) goto L_0x0098
            java.util.List<java.lang.String> r4 = r0.zzs
            java.lang.String r5 = r3.zza
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0086
            com.google.android.gms.measurement.internal.zzbe r4 = r3.zzb
            android.os.Bundle r4 = r4.zzb()
            java.lang.String r5 = "ga_safelisted"
            r11 = 1
            r4.putLong(r5, r11)
            com.google.android.gms.measurement.internal.zzbf r13 = new com.google.android.gms.measurement.internal.zzbf
            java.lang.String r14 = r3.zza
            com.google.android.gms.measurement.internal.zzbe r15 = new com.google.android.gms.measurement.internal.zzbe
            r15.<init>(r4)
            java.lang.String r4 = r3.zzc
            long r5 = r3.zzd
            r16 = r4
            r17 = r5
            r13.<init>(r14, r15, r16, r17)
            goto L_0x0099
        L_0x0086:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzc()
            java.lang.String r4 = r3.zza
            java.lang.String r3 = r3.zzc
            java.lang.String r5 = "Dropping non-safelisted event. appId, event name, origin"
            r0.zza(r5, r2, r4, r3)
            return
        L_0x0098:
            r13 = r3
        L_0x0099:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()
            r3.zzp()
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0307 }
            r3.zzt()     // Catch:{ all -> 0x0307 }
            r3.zzal()     // Catch:{ all -> 0x0307 }
            r4 = 0
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r5 = 2
            r11 = 1
            if (r4 >= 0) goto L_0x00cf
            com.google.android.gms.measurement.internal.zzgo r3 = r3.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzu()     // Catch:{ all -> 0x0307 }
            java.lang.String r6 = "Invalid time querying timed out conditional properties"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ all -> 0x0307 }
            java.lang.Long r12 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r3.zza(r6, r9, r12)     // Catch:{ all -> 0x0307 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0307 }
            goto L_0x00df
        L_0x00cf:
            java.lang.String r6 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"
            java.lang.String[] r9 = new java.lang.String[r5]     // Catch:{ all -> 0x0307 }
            r9[r10] = r2     // Catch:{ all -> 0x0307 }
            java.lang.String r12 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r9[r11] = r12     // Catch:{ all -> 0x0307 }
            java.util.List r3 = r3.zza((java.lang.String) r6, (java.lang.String[]) r9)     // Catch:{ all -> 0x0307 }
        L_0x00df:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0307 }
        L_0x00e3:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x0307 }
            if (r6 == 0) goto L_0x0132
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzae r6 = (com.google.android.gms.measurement.internal.zzae) r6     // Catch:{ all -> 0x0307 }
            if (r6 == 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzp()     // Catch:{ all -> 0x0307 }
            java.lang.String r12 = "User property timed out"
            java.lang.String r14 = r6.zza     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzhy r15 = r1.zzm     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgh r15 = r15.zzk()     // Catch:{ all -> 0x0307 }
            r21 = r10
            com.google.android.gms.measurement.internal.zzon r10 = r6.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r10 = r10.zza     // Catch:{ all -> 0x0307 }
            java.lang.String r10 = r15.zzc(r10)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzon r15 = r6.zzc     // Catch:{ all -> 0x0307 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x0307 }
            r9.zza(r12, r14, r10, r15)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzbf r9 = r6.zzg     // Catch:{ all -> 0x0307 }
            if (r9 == 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzbf r9 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzbf r10 = r6.zzg     // Catch:{ all -> 0x0307 }
            r9.<init>(r10, r7)     // Catch:{ all -> 0x0307 }
            r1.zzc(r9, r0)     // Catch:{ all -> 0x0307 }
        L_0x0124:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zzf()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzon r6 = r6.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r6 = r6.zza     // Catch:{ all -> 0x0307 }
            r9.zza((java.lang.String) r2, (java.lang.String) r6)     // Catch:{ all -> 0x0307 }
            r10 = r21
            goto L_0x00e3
        L_0x0132:
            r21 = r10
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0307 }
            r3.zzt()     // Catch:{ all -> 0x0307 }
            r3.zzal()     // Catch:{ all -> 0x0307 }
            if (r4 >= 0) goto L_0x015d
            com.google.android.gms.measurement.internal.zzgo r3 = r3.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzu()     // Catch:{ all -> 0x0307 }
            java.lang.String r6 = "Invalid time querying expired conditional properties"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ all -> 0x0307 }
            java.lang.Long r10 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r3.zza(r6, r9, r10)     // Catch:{ all -> 0x0307 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0307 }
            goto L_0x016d
        L_0x015d:
            java.lang.String r6 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"
            java.lang.String[] r9 = new java.lang.String[r5]     // Catch:{ all -> 0x0307 }
            r9[r21] = r2     // Catch:{ all -> 0x0307 }
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r9[r11] = r10     // Catch:{ all -> 0x0307 }
            java.util.List r3 = r3.zza((java.lang.String) r6, (java.lang.String[]) r9)     // Catch:{ all -> 0x0307 }
        L_0x016d:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0307 }
            int r9 = r3.size()     // Catch:{ all -> 0x0307 }
            r6.<init>(r9)     // Catch:{ all -> 0x0307 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0307 }
        L_0x017a:
            boolean r9 = r3.hasNext()     // Catch:{ all -> 0x0307 }
            if (r9 == 0) goto L_0x01cf
            java.lang.Object r9 = r3.next()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzae r9 = (com.google.android.gms.measurement.internal.zzae) r9     // Catch:{ all -> 0x0307 }
            if (r9 == 0) goto L_0x017a
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzp()     // Catch:{ all -> 0x0307 }
            java.lang.String r12 = "User property expired"
            java.lang.String r14 = r9.zza     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzhy r15 = r1.zzm     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgh r15 = r15.zzk()     // Catch:{ all -> 0x0307 }
            r16 = r5
            com.google.android.gms.measurement.internal.zzon r5 = r9.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = r15.zzc(r5)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzon r15 = r9.zzc     // Catch:{ all -> 0x0307 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x0307 }
            r10.zza(r12, r14, r5, r15)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzal r5 = r1.zzf()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzon r10 = r9.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r10 = r10.zza     // Catch:{ all -> 0x0307 }
            r5.zzh(r2, r10)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzbf r5 = r9.zzk     // Catch:{ all -> 0x0307 }
            if (r5 == 0) goto L_0x01c1
            com.google.android.gms.measurement.internal.zzbf r5 = r9.zzk     // Catch:{ all -> 0x0307 }
            r6.add(r5)     // Catch:{ all -> 0x0307 }
        L_0x01c1:
            com.google.android.gms.measurement.internal.zzal r5 = r1.zzf()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzon r9 = r9.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r9 = r9.zza     // Catch:{ all -> 0x0307 }
            r5.zza((java.lang.String) r2, (java.lang.String) r9)     // Catch:{ all -> 0x0307 }
            r5 = r16
            goto L_0x017a
        L_0x01cf:
            r16 = r5
            r3 = r6
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x0307 }
            int r3 = r6.size()     // Catch:{ all -> 0x0307 }
            r5 = r21
        L_0x01da:
            if (r5 >= r3) goto L_0x01ed
            java.lang.Object r9 = r6.get(r5)     // Catch:{ all -> 0x0307 }
            int r5 = r5 + 1
            com.google.android.gms.measurement.internal.zzbf r9 = (com.google.android.gms.measurement.internal.zzbf) r9     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzbf r10 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x0307 }
            r10.<init>(r9, r7)     // Catch:{ all -> 0x0307 }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x0307 }
            goto L_0x01da
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = r13.zza     // Catch:{ all -> 0x0307 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x0307 }
            r3.zzt()     // Catch:{ all -> 0x0307 }
            r3.zzal()     // Catch:{ all -> 0x0307 }
            if (r4 >= 0) goto L_0x0223
            com.google.android.gms.measurement.internal.zzgo r4 = r3.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzu()     // Catch:{ all -> 0x0307 }
            java.lang.String r6 = "Invalid time querying triggered conditional properties"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r2)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgh r3 = r3.zzi()     // Catch:{ all -> 0x0307 }
            java.lang.String r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x0307 }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r4.zza(r6, r2, r3, r5)     // Catch:{ all -> 0x0307 }
            java.util.List r2 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0307 }
            goto L_0x0236
        L_0x0223:
            java.lang.String r4 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0307 }
            r6[r21] = r2     // Catch:{ all -> 0x0307 }
            r6[r11] = r5     // Catch:{ all -> 0x0307 }
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0307 }
            r6[r16] = r2     // Catch:{ all -> 0x0307 }
            java.util.List r2 = r3.zza((java.lang.String) r4, (java.lang.String[]) r6)     // Catch:{ all -> 0x0307 }
        L_0x0236:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0307 }
            int r3 = r2.size()     // Catch:{ all -> 0x0307 }
            r10.<init>(r3)     // Catch:{ all -> 0x0307 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0307 }
        L_0x0243:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0307 }
            if (r3 == 0) goto L_0x02d9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0307 }
            r12 = r3
            com.google.android.gms.measurement.internal.zzae r12 = (com.google.android.gms.measurement.internal.zzae) r12     // Catch:{ all -> 0x0307 }
            if (r12 == 0) goto L_0x0243
            com.google.android.gms.measurement.internal.zzon r3 = r12.zzc     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzop r4 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = r12.zza     // Catch:{ all -> 0x0307 }
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0307 }
            r6 = r4
            r4 = r5
            java.lang.String r5 = r12.zzb     // Catch:{ all -> 0x0307 }
            r9 = r6
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0307 }
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x0307 }
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0307 }
            r19 = r9
            r9 = r3
            r3 = r19
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzal r4 = r1.zzf()     // Catch:{ all -> 0x0307 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzop) r3)     // Catch:{ all -> 0x0307 }
            if (r4 == 0) goto L_0x029d
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzp()     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = "User property triggered"
            java.lang.String r6 = r12.zza     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzhy r9 = r1.zzm     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgh r9 = r9.zzk()     // Catch:{ all -> 0x0307 }
            java.lang.String r14 = r3.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r9 = r9.zzc(r14)     // Catch:{ all -> 0x0307 }
            java.lang.Object r14 = r3.zze     // Catch:{ all -> 0x0307 }
            r4.zza(r5, r6, r9, r14)     // Catch:{ all -> 0x0307 }
            goto L_0x02be
        L_0x029d:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = "Too many active user properties, ignoring"
            java.lang.String r6 = r12.zza     // Catch:{ all -> 0x0307 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzhy r9 = r1.zzm     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgh r9 = r9.zzk()     // Catch:{ all -> 0x0307 }
            java.lang.String r14 = r3.zzc     // Catch:{ all -> 0x0307 }
            java.lang.String r9 = r9.zzc(r14)     // Catch:{ all -> 0x0307 }
            java.lang.Object r14 = r3.zze     // Catch:{ all -> 0x0307 }
            r4.zza(r5, r6, r9, r14)     // Catch:{ all -> 0x0307 }
        L_0x02be:
            com.google.android.gms.measurement.internal.zzbf r4 = r12.zzi     // Catch:{ all -> 0x0307 }
            if (r4 == 0) goto L_0x02c7
            com.google.android.gms.measurement.internal.zzbf r4 = r12.zzi     // Catch:{ all -> 0x0307 }
            r10.add(r4)     // Catch:{ all -> 0x0307 }
        L_0x02c7:
            com.google.android.gms.measurement.internal.zzon r4 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ all -> 0x0307 }
            r4.<init>(r3)     // Catch:{ all -> 0x0307 }
            r12.zzc = r4     // Catch:{ all -> 0x0307 }
            r12.zze = r11     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()     // Catch:{ all -> 0x0307 }
            r3.zza((com.google.android.gms.measurement.internal.zzae) r12)     // Catch:{ all -> 0x0307 }
            goto L_0x0243
        L_0x02d9:
            r1.zzc(r13, r0)     // Catch:{ all -> 0x0307 }
            r2 = r10
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0307 }
            int r2 = r10.size()     // Catch:{ all -> 0x0307 }
            r3 = r21
        L_0x02e5:
            if (r3 >= r2) goto L_0x02f8
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0307 }
            int r3 = r3 + 1
            com.google.android.gms.measurement.internal.zzbf r4 = (com.google.android.gms.measurement.internal.zzbf) r4     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzbf r5 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x0307 }
            r5.<init>(r4, r7)     // Catch:{ all -> 0x0307 }
            r1.zzc(r5, r0)     // Catch:{ all -> 0x0307 }
            goto L_0x02e5
        L_0x02f8:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0307 }
            r0.zzw()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x0307:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzf()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zza(com.google.android.gms.measurement.internal.zzbf, com.google.android.gms.measurement.internal.zzo):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbf zzbf, String str) {
        zzbf zzbf2 = zzbf;
        String str2 = str;
        zzg zze2 = zzf().zze(str2);
        if (zze2 == null || TextUtils.isEmpty(zze2.zzaf())) {
            zzj().zzc().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zza2 = zza(zze2);
        if (zza2 == null) {
            if (!"_ui".equals(zzbf2.zza)) {
                zzj().zzu().zza("Could not find package. appId", zzgo.zza(str2));
            }
        } else if (!zza2.booleanValue()) {
            zzj().zzg().zza("App version does not match; dropping event. appId", zzgo.zza(str2));
            return;
        }
        zzg zzg2 = zze2;
        zzg zzg3 = zzg2;
        zzg zzg4 = zzg3;
        zzg zzg5 = zzg4;
        zzg zzg6 = zzg5;
        zzg zzg7 = zzg6;
        zzb(zzbf2, new zzo(str2, zzg2.zzah(), zzg3.zzaf(), zzg4.zze(), zzg5.zzae(), zzg6.zzq(), zzg7.zzn(), (String) null, zzg7.zzar(), false, zzg7.zzag(), zzg7.zzd(), 0, 0, zzg7.zzaq(), false, zzg7.zzaa(), zzg7.zzx(), zzg7.zzo(), zzg7.zzan(), (String) null, zzb(str2).zzf(), "", (String) null, zzg7.zzat(), zzg7.zzw(), zzb(str2).zza(), zzd(str2).zzf(), zzg7.zza(), zzg7.zzf(), zzg7.zzam(), zzg7.zzak()));
    }

    private final void zzb(zzbf zzbf, zzo zzo2) {
        Preconditions.checkNotEmpty(zzo2.zza);
        zzgs zza2 = zzgs.zza(zzbf);
        zzq().zza(zza2.zzc, zzf().zzd(zzo2.zza));
        zzq().zza(zza2, zze().zzb(zzo2.zza));
        zzbf zza3 = zza2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza3.zza) && "referrer API v2".equals(zza3.zzb.zzd("_cis"))) {
            String zzd2 = zza3.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzon("_lgclid", zza3.zzd, zzd2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzo2);
            }
        }
        zza(zza3, zzo2);
    }

    private final void zza(zzfy.zzk.zza zza2, long j, boolean z) {
        String str;
        zzop zzop;
        String str2;
        if (z) {
            str = "_se";
        } else {
            str = "_lte";
        }
        String str3 = str;
        zzop zze2 = zzf().zze(zza2.zzt(), str3);
        if (zze2 == null || zze2.zze == null) {
            zzop = new zzop(zza2.zzt(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str3, zzb().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzop = new zzop(zza2.zzt(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str3, zzb().currentTimeMillis(), Long.valueOf(((Long) zze2.zze).longValue() + j));
        }
        zzfy.zzo zzo2 = (zzfy.zzo) ((zzjt) zzfy.zzo.zze().zza(str3).zzb(zzb().currentTimeMillis()).zza(((Long) zzop.zze).longValue()).zzai());
        int zza3 = zzoo.zza(zza2, str3);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzo2);
        } else {
            zza2.zza(zzo2);
        }
        if (j > 0) {
            zzf().zza(zzop);
            if (z) {
                str2 = "session-scoped";
            } else {
                str2 = "lifetime";
            }
            zzj().zzp().zza("Updated engagement user property. scope, value", str2, zzop.zze);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt() {
        this.zzt++;
    }

    private final void zzab() {
        zzl().zzt();
        for (String next : this.zzr) {
            if (zzpn.zza() && zze().zze(next, zzbh.zzch)) {
                zzj().zzc().zza("Notifying app that trigger URIs are available. App ID", next);
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intent.setPackage(next);
                this.zzm.zza().sendBroadcast(intent);
            }
        }
        this.zzr.clear();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b A[Catch:{ all -> 0x01d5, all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015a A[Catch:{ all -> 0x01d5, all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0168 A[Catch:{ all -> 0x01d5, all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018e A[Catch:{ all -> 0x01d5, all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0192 A[Catch:{ all -> 0x01d5, all -> 0x01de }] */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzhv r0 = r8.zzl()
            r0.zzt()
            r8.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x01de }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzgo r1 = r8.zzj()     // Catch:{ all -> 0x01de }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzp()     // Catch:{ all -> 0x01de }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r12.length     // Catch:{ all -> 0x01de }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01de }
            r1.zza(r2, r3)     // Catch:{ all -> 0x01de }
            com.google.android.gms.measurement.internal.zzal r1 = r8.zzf()     // Catch:{ all -> 0x01de }
            r1.zzp()     // Catch:{ all -> 0x01de }
            com.google.android.gms.measurement.internal.zzal r1 = r8.zzf()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zze(r9)     // Catch:{ all -> 0x01d5 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            if (r10 == r2) goto L_0x003f
            r2 = 204(0xcc, float:2.86E-43)
            if (r10 == r2) goto L_0x003f
            if (r10 != r3) goto L_0x0043
        L_0x003f:
            if (r11 != 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x0043:
            r2 = r0
        L_0x0044:
            if (r1 != 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzgo r10 = r8.zzj()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzu()     // Catch:{ all -> 0x01d5 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x01d5 }
            r10.zza(r11, r9)     // Catch:{ all -> 0x01d5 }
            goto L_0x01c1
        L_0x0059:
            r4 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00b5
            if (r10 != r4) goto L_0x0060
            goto L_0x00b5
        L_0x0060:
            com.google.android.gms.common.util.Clock r12 = r8.zzb()     // Catch:{ all -> 0x01d5 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x01d5 }
            r1.zzm(r12)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzal r12 = r8.zzf()     // Catch:{ all -> 0x01d5 }
            r12.zza((com.google.android.gms.measurement.internal.zzg) r1, (boolean) r0, (boolean) r0)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzgo r12 = r8.zzj()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzp()     // Catch:{ all -> 0x01d5 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x01d5 }
            r12.zza(r13, r1, r11)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzhl r11 = r8.zzi()     // Catch:{ all -> 0x01d5 }
            r11.zzi(r9)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzmw r9 = r8.zzj     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzhb r9 = r9.zze     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.common.util.Clock r11 = r8.zzb()     // Catch:{ all -> 0x01d5 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x01d5 }
            r9.zza(r11)     // Catch:{ all -> 0x01d5 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a1
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b0
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzmw r9 = r8.zzj     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzhb r9 = r9.zzc     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.common.util.Clock r10 = r8.zzb()     // Catch:{ all -> 0x01d5 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x01d5 }
            r9.zza(r10)     // Catch:{ all -> 0x01d5 }
        L_0x00b0:
            r8.zzac()     // Catch:{ all -> 0x01d5 }
            goto L_0x01c1
        L_0x00b5:
            boolean r11 = com.google.android.gms.internal.measurement.zzpb.zza()     // Catch:{ all -> 0x01d5 }
            java.lang.String r2 = "ETag"
            java.lang.String r5 = "Last-Modified"
            r6 = 0
            if (r11 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzag r11 = r8.zze()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcf     // Catch:{ all -> 0x01d5 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ all -> 0x01d5 }
            if (r11 == 0) goto L_0x00d5
            java.lang.String r11 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r13, (java.lang.String) r5)     // Catch:{ all -> 0x01d5 }
            java.lang.String r13 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r13, (java.lang.String) r2)     // Catch:{ all -> 0x01d5 }
            goto L_0x0109
        L_0x00d5:
            if (r13 == 0) goto L_0x00de
            java.lang.Object r11 = r13.get(r5)     // Catch:{ all -> 0x01d5 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x01d5 }
            goto L_0x00df
        L_0x00de:
            r11 = r6
        L_0x00df:
            if (r11 == 0) goto L_0x00ee
            boolean r5 = r11.isEmpty()     // Catch:{ all -> 0x01d5 }
            if (r5 != 0) goto L_0x00ee
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x01d5 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01d5 }
            goto L_0x00ef
        L_0x00ee:
            r11 = r6
        L_0x00ef:
            if (r13 == 0) goto L_0x00f8
            java.lang.Object r13 = r13.get(r2)     // Catch:{ all -> 0x01d5 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x01d5 }
            goto L_0x00f9
        L_0x00f8:
            r13 = r6
        L_0x00f9:
            if (r13 == 0) goto L_0x0108
            boolean r2 = r13.isEmpty()     // Catch:{ all -> 0x01d5 }
            if (r2 != 0) goto L_0x0108
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x01d5 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x01d5 }
            goto L_0x0109
        L_0x0108:
            r13 = r6
        L_0x0109:
            if (r10 == r4) goto L_0x0125
            if (r10 != r3) goto L_0x010e
            goto L_0x0125
        L_0x010e:
            com.google.android.gms.measurement.internal.zzhl r2 = r8.zzi()     // Catch:{ all -> 0x01d5 }
            boolean r11 = r2.zza(r9, r12, r11, r13)     // Catch:{ all -> 0x01d5 }
            if (r11 != 0) goto L_0x0146
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01de }
            r9.zzu()     // Catch:{ all -> 0x01de }
            r8.zzu = r0
            r8.zzaa()
            return
        L_0x0125:
            com.google.android.gms.measurement.internal.zzhl r11 = r8.zzi()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.measurement.zzfr$zzd r11 = r11.zzc(r9)     // Catch:{ all -> 0x01d5 }
            if (r11 != 0) goto L_0x0146
            com.google.android.gms.measurement.internal.zzhl r11 = r8.zzi()     // Catch:{ all -> 0x01d5 }
            boolean r11 = r11.zza(r9, r6, r6, r6)     // Catch:{ all -> 0x01d5 }
            if (r11 != 0) goto L_0x0146
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01de }
            r9.zzu()     // Catch:{ all -> 0x01de }
            r8.zzu = r0
            r8.zzaa()
            return
        L_0x0146:
            com.google.android.gms.common.util.Clock r11 = r8.zzb()     // Catch:{ all -> 0x01d5 }
            long r2 = r11.currentTimeMillis()     // Catch:{ all -> 0x01d5 }
            r1.zzd((long) r2)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzal r11 = r8.zzf()     // Catch:{ all -> 0x01d5 }
            r11.zza((com.google.android.gms.measurement.internal.zzg) r1, (boolean) r0, (boolean) r0)     // Catch:{ all -> 0x01d5 }
            if (r10 != r4) goto L_0x0168
            com.google.android.gms.measurement.internal.zzgo r10 = r8.zzj()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzv()     // Catch:{ all -> 0x01d5 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zza(r11, r9)     // Catch:{ all -> 0x01d5 }
            goto L_0x017e
        L_0x0168:
            com.google.android.gms.measurement.internal.zzgo r9 = r8.zzj()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzp()     // Catch:{ all -> 0x01d5 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x01d5 }
            int r12 = r12.length     // Catch:{ all -> 0x01d5 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x01d5 }
            r9.zza(r11, r10, r12)     // Catch:{ all -> 0x01d5 }
        L_0x017e:
            com.google.android.gms.measurement.internal.zzgr r9 = r8.zzh()     // Catch:{ all -> 0x01d5 }
            boolean r9 = r9.zzu()     // Catch:{ all -> 0x01d5 }
            if (r9 == 0) goto L_0x0192
            boolean r9 = r8.zzad()     // Catch:{ all -> 0x01d5 }
            if (r9 == 0) goto L_0x0192
            r8.zzw()     // Catch:{ all -> 0x01d5 }
            goto L_0x01c1
        L_0x0192:
            com.google.android.gms.measurement.internal.zzag r9 = r8.zze()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzbh.zzcb     // Catch:{ all -> 0x01d5 }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r10)     // Catch:{ all -> 0x01d5 }
            if (r9 == 0) goto L_0x01be
            com.google.android.gms.measurement.internal.zzgr r9 = r8.zzh()     // Catch:{ all -> 0x01d5 }
            boolean r9 = r9.zzu()     // Catch:{ all -> 0x01d5 }
            if (r9 == 0) goto L_0x01be
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01d5 }
            java.lang.String r10 = r1.zzac()     // Catch:{ all -> 0x01d5 }
            boolean r9 = r9.zzs(r10)     // Catch:{ all -> 0x01d5 }
            if (r9 == 0) goto L_0x01be
            java.lang.String r9 = r1.zzac()     // Catch:{ all -> 0x01d5 }
            r8.zze((java.lang.String) r9)     // Catch:{ all -> 0x01d5 }
            goto L_0x01c1
        L_0x01be:
            r8.zzac()     // Catch:{ all -> 0x01d5 }
        L_0x01c1:
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01d5 }
            r9.zzw()     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01de }
            r9.zzu()     // Catch:{ all -> 0x01de }
            r8.zzu = r0
            r8.zzaa()
            return
        L_0x01d5:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzal r10 = r8.zzf()     // Catch:{ all -> 0x01de }
            r10.zzu()     // Catch:{ all -> 0x01de }
            throw r9     // Catch:{ all -> 0x01de }
        L_0x01de:
            r9 = move-exception
            r8.zzu = r0
            r8.zzaa()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzac();
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z, int i, Throwable th, byte[] bArr, String str, List<Pair<zzfy.zzj, zznw>> list) {
        byte[] bArr2;
        zzal zzf2;
        zzl().zzt();
        zzs();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                Throwable th3 = th2;
                this.zzv = false;
                zzaa();
                throw th3;
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        if (z) {
            if ((i != 200 && i != 204) || th != null) {
                if (zzpb.zza()) {
                    if (zze().zza(zzbh.zzcf)) {
                        String str2 = new String(bArr2, StandardCharsets.UTF_8);
                        zzj().zzv().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th, str2.substring(0, Math.min(32, str2.length())));
                        this.zzj.zze.zza(zzb().currentTimeMillis());
                        if (i == 503 || i == 429) {
                            this.zzj.zzc.zza(zzb().currentTimeMillis());
                        }
                        zzf().zza(list2);
                        zzac();
                        this.zzv = false;
                        zzaa();
                    }
                }
                zzj().zzp().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
                this.zzj.zze.zza(zzb().currentTimeMillis());
                this.zzj.zzc.zza(zzb().currentTimeMillis());
                zzf().zza(list2);
                zzac();
                this.zzv = false;
                zzaa();
            }
        }
        zzj().zzp().zza("Network upload successful with code", Integer.valueOf(i));
        if (z) {
            try {
                this.zzj.zzd.zza(zzb().currentTimeMillis());
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error while trying to delete uploaded bundles", e);
                this.zzp = zzb().elapsedRealtime();
                zzj().zzp().zza("Disable upload, time", Long.valueOf(this.zzp));
            }
        }
        this.zzj.zze.zza(0);
        zzac();
        if (z) {
            zzj().zzp().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr2.length));
        } else {
            zzj().zzp().zza("Purged empty bundles");
        }
        zzf().zzp();
        try {
            if (zze().zza(zzbh.zzcb)) {
                for (Pair next : list) {
                    zznw zznw = (zznw) next.second;
                    zzf().zza(str, (zzfy.zzj) next.first, zznw.zzb(), zznw.zzc(), zznw.zza());
                }
            }
            String str3 = str;
            for (Long l : list2) {
                try {
                    zzf2 = zzf();
                    long longValue = l.longValue();
                    zzf2.zzt();
                    zzf2.zzal();
                    if (zzf2.e_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                    }
                } catch (SQLiteException e2) {
                    zzf2.zzj().zzg().zza("Failed to delete a bundle in a queue table", e2);
                    throw e2;
                } catch (SQLiteException e3) {
                    List<Long> list3 = this.zzaa;
                    if (list3 == null || !list3.contains(l)) {
                        throw e3;
                    }
                }
            }
            zzf().zzw();
            zzf().zzu();
            this.zzaa = null;
            if (zzh().zzu() && zzad()) {
                zzw();
            } else if (!zze().zza(zzbh.zzcb) || !zzh().zzu() || !zzf().zzs(str3)) {
                this.zzab = -1;
                zzac();
            } else {
                zze(str3);
            }
            this.zzp = 0;
            this.zzv = false;
            zzaa();
        } catch (Throwable th4) {
            Throwable th5 = th4;
            zzf().zzu();
            throw th5;
        }
    }

    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.String] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r5, int r6, java.lang.Throwable r7, byte[] r8, com.google.android.gms.measurement.internal.zzoj r9) {
        /*
            r4 = this;
            com.google.android.gms.measurement.internal.zzhv r0 = r4.zzl()
            r0.zzt()
            r4.zzs()
            r0 = 0
            if (r8 != 0) goto L_0x0013
            byte[] r8 = new byte[r0]     // Catch:{ all -> 0x0010 }
            goto L_0x0013
        L_0x0010:
            r5 = move-exception
            goto L_0x00f6
        L_0x0013:
            r1 = 200(0xc8, float:2.8E-43)
            if (r6 == r1) goto L_0x001b
            r1 = 204(0xcc, float:2.86E-43)
            if (r6 != r1) goto L_0x00b3
        L_0x001b:
            if (r7 != 0) goto L_0x00b3
            if (r9 == 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzal r7 = r4.zzf()     // Catch:{ all -> 0x0010 }
            long r8 = r9.zza()     // Catch:{ all -> 0x0010 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0010 }
            r7.zzt()     // Catch:{ all -> 0x0010 }
            r7.zzal()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0010 }
            boolean r9 = com.google.android.gms.internal.measurement.zzpu.zza()     // Catch:{ all -> 0x0010 }
            if (r9 == 0) goto L_0x0046
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbh.zzcb     // Catch:{ all -> 0x0010 }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r1)     // Catch:{ all -> 0x0010 }
            if (r9 == 0) goto L_0x007a
        L_0x0046:
            android.database.sqlite.SQLiteDatabase r9 = r7.e_()     // Catch:{ all -> 0x0010 }
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0010 }
            r2[r0] = r8     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = "upload_queue"
            java.lang.String r3 = "rowid=?"
            int r8 = r9.delete(r8, r3, r2)     // Catch:{ SQLiteException -> 0x006b }
            if (r8 == r1) goto L_0x007a
            com.google.android.gms.measurement.internal.zzgo r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x006b }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzu()     // Catch:{ SQLiteException -> 0x006b }
            java.lang.String r9 = "Deleted fewer rows from upload_queue than expected"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x006b }
            goto L_0x007a
        L_0x006b:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzgo r6 = r7.zzj()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzg()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = "Failed to delete a MeasurementBatch in a upload_queue table"
            r6.zza(r7, r5)     // Catch:{ all -> 0x0010 }
            throw r5     // Catch:{ all -> 0x0010 }
        L_0x007a:
            com.google.android.gms.measurement.internal.zzgo r7 = r4.zzj()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0010 }
            r7.zza(r8, r5, r6)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzag r6 = r4.zze()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcb     // Catch:{ all -> 0x0010 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ all -> 0x0010 }
            if (r6 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzgr r6 = r4.zzh()     // Catch:{ all -> 0x0010 }
            boolean r6 = r6.zzu()     // Catch:{ all -> 0x0010 }
            if (r6 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzal r6 = r4.zzf()     // Catch:{ all -> 0x0010 }
            boolean r6 = r6.zzs(r5)     // Catch:{ all -> 0x0010 }
            if (r6 == 0) goto L_0x00af
            r4.zze((java.lang.String) r5)     // Catch:{ all -> 0x0010 }
            goto L_0x00f0
        L_0x00af:
            r4.zzac()     // Catch:{ all -> 0x0010 }
            goto L_0x00f0
        L_0x00b3:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0010 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0010 }
            r1.<init>(r8, r2)     // Catch:{ all -> 0x0010 }
            int r8 = r1.length()     // Catch:{ all -> 0x0010 }
            r2 = 32
            int r8 = java.lang.Math.min(r2, r8)     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = r1.substring(r0, r8)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgo r1 = r4.zzj()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzv()     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0010 }
            if (r7 != 0) goto L_0x00d9
            r7 = r8
        L_0x00d9:
            r1.zza(r2, r5, r6, r7)     // Catch:{ all -> 0x0010 }
            if (r9 == 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzal r5 = r4.zzf()     // Catch:{ all -> 0x0010 }
            long r6 = r9.zza()     // Catch:{ all -> 0x0010 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0010 }
            r5.zza((java.lang.Long) r6)     // Catch:{ all -> 0x0010 }
        L_0x00ed:
            r4.zzac()     // Catch:{ all -> 0x0010 }
        L_0x00f0:
            r4.zzv = r0
            r4.zzaa()
            return
        L_0x00f6:
            r4.zzv = r0
            r4.zzaa()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zza(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.zzoj):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzg zzg2, zzfy.zzk.zza zza2) {
        zzl().zzt();
        zzs();
        zzfy.zza.C0011zza zzc2 = zzfy.zza.zzc();
        byte[] zzav = zzg2.zzav();
        if (zzav != null) {
            try {
                zzc2 = (zzfy.zza.C0011zza) zzoo.zza(zzc2, zzav);
            } catch (zzkb unused) {
                zzj().zzu().zza("Failed to parse locally stored ad campaign info. appId", zzgo.zza(zzg2.zzac()));
            }
        }
        for (zzfy.zzf next : zza2.zzaa()) {
            if (next.zzg().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzoo.zza(next, "gclid", (Object) "");
                String str2 = (String) zzoo.zza(next, "gbraid", (Object) "");
                String str3 = (String) zzoo.zza(next, "gad_source", (Object) "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long longValue = ((Long) zzoo.zza(next, "click_timestamp", (Object) 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = next.zzd();
                    }
                    if ("referrer API v2".equals(zzoo.zzb(next, "_cis"))) {
                        if (longValue > zzc2.zzb()) {
                            if (str.isEmpty()) {
                                zzc2.zzh();
                            } else {
                                zzc2.zzf(str);
                            }
                            if (str2.isEmpty()) {
                                zzc2.zzg();
                            } else {
                                zzc2.zze(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc2.zzf();
                            } else {
                                zzc2.zzd(str3);
                            }
                            zzc2.zzb(longValue);
                        }
                    } else if (longValue > zzc2.zza()) {
                        if (str.isEmpty()) {
                            zzc2.zze();
                        } else {
                            zzc2.zzc(str);
                        }
                        if (str2.isEmpty()) {
                            zzc2.zzd();
                        } else {
                            zzc2.zzb(str2);
                        }
                        if (str3.isEmpty()) {
                            zzc2.zzc();
                        } else {
                            zzc2.zza(str3);
                        }
                        zzc2.zza(longValue);
                    }
                }
            }
        }
        if (!((zzfy.zza) ((zzjt) zzc2.zzai())).equals(zzfy.zza.zze())) {
            zza2.zza((zzfy.zza) ((zzjt) zzc2.zzai()));
        }
        zzg2.zza(((zzfy.zza) ((zzjt) zzc2.zzai())).zzca());
        if (zzg2.zzas()) {
            zzf().zza(zzg2, false, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzo zzo2) {
        zzl().zzt();
        zzs();
        Preconditions.checkNotNull(zzo2);
        Preconditions.checkNotEmpty(zzo2.zza);
        if (zze().zza(zzbh.zzdc)) {
            int i = 0;
            if (zze().zza(zzbh.zzbj)) {
                long currentTimeMillis = zzb().currentTimeMillis();
                int zzb2 = zze().zzb((String) null, zzbh.zzau);
                zze();
                long zzg2 = currentTimeMillis - zzag.zzg();
                while (i < zzb2 && zza((String) null, zzg2)) {
                    i++;
                }
            } else {
                zze();
                long zzh2 = zzag.zzh();
                while (((long) i) < zzh2 && zza(zzo2.zza, 0)) {
                    i++;
                }
            }
            if (zze().zza(zzbh.zzbk)) {
                zzab();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03a9 A[Catch:{ SQLiteException -> 0x01af, all -> 0x052c }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03d4 A[Catch:{ SQLiteException -> 0x01af, all -> 0x052c }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03e9 A[SYNTHETIC, Splitter:B:125:0x03e9] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x049a A[Catch:{ SQLiteException -> 0x01af, all -> 0x052c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01fc A[Catch:{ SQLiteException -> 0x01af, all -> 0x052c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.measurement.internal.zzo r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "com.android.vending"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.zzhv r9 = r1.zzl()
            r9.zzt()
            r1.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            java.lang.String r9 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            boolean r9 = zzi(r2)
            if (r9 != 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zzf()
            java.lang.String r10 = r2.zza
            com.google.android.gms.measurement.internal.zzg r9 = r9.zze(r10)
            r10 = 0
            r11 = 0
            if (r9 == 0) goto L_0x005f
            java.lang.String r13 = r9.zzah()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x005f
            java.lang.String r13 = r2.zzb
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x005f
            r9.zzd((long) r11)
            com.google.android.gms.measurement.internal.zzal r13 = r1.zzf()
            r13.zza((com.google.android.gms.measurement.internal.zzg) r9, (boolean) r10, (boolean) r10)
            com.google.android.gms.measurement.internal.zzhl r9 = r1.zzi()
            java.lang.String r13 = r2.zza
            r9.zzj(r13)
        L_0x005f:
            boolean r9 = r2.zzh
            if (r9 != 0) goto L_0x0067
            r26.zza((com.google.android.gms.measurement.internal.zzo) r27)
            return
        L_0x0067:
            long r13 = r2.zzl
            int r9 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0075
            com.google.android.gms.common.util.Clock r9 = r1.zzb()
            long r13 = r9.currentTimeMillis()
        L_0x0075:
            r17 = r13
            com.google.android.gms.measurement.internal.zzhy r9 = r1.zzm
            com.google.android.gms.measurement.internal.zzaz r9 = r9.zzg()
            r9.zzt()
            int r9 = r2.zzm
            r13 = 1
            if (r9 == 0) goto L_0x009f
            if (r9 == r13) goto L_0x009f
            com.google.android.gms.measurement.internal.zzgo r14 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzu()
            java.lang.String r15 = r2.zza
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r15)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.zza(r11, r15, r9)
            r9 = r10
        L_0x009f:
            com.google.android.gms.measurement.internal.zzal r11 = r1.zzf()
            r11.zzp()
            com.google.android.gms.measurement.internal.zzal r11 = r1.zzf()     // Catch:{ all -> 0x052c }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzop r11 = r11.zze(r12, r0)     // Catch:{ all -> 0x052c }
            java.lang.Boolean r12 = zzh(r2)     // Catch:{ all -> 0x052c }
            if (r11 == 0) goto L_0x00c0
            java.lang.String r14 = "auto"
            java.lang.String r15 = r11.zzb     // Catch:{ all -> 0x052c }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x052c }
            if (r14 == 0) goto L_0x00f3
        L_0x00c0:
            if (r12 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzon r15 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_npa"
            boolean r0 = r12.booleanValue()     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x00cf
            r23 = 1
            goto L_0x00d1
        L_0x00cf:
            r23 = 0
        L_0x00d1:
            java.lang.Long r0 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x052c }
            r23 = 1
            java.lang.String r20 = "auto"
            r19 = r0
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052c }
            if (r11 == 0) goto L_0x00ea
            java.lang.Object r0 = r11.zze     // Catch:{ all -> 0x052c }
            java.lang.Long r11 = r15.zzc     // Catch:{ all -> 0x052c }
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x052c }
            if (r0 != 0) goto L_0x00f3
        L_0x00ea:
            r1.zza((com.google.android.gms.measurement.internal.zzon) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
            goto L_0x00f3
        L_0x00ee:
            if (r11 == 0) goto L_0x00f3
            r1.zza((java.lang.String) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
        L_0x00f3:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x052c }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x052c }
            java.lang.Object r11 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x052c }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r11)     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x01c2
            r1.zzq()     // Catch:{ all -> 0x052c }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x052c }
            java.lang.String r14 = r0.zzah()     // Catch:{ all -> 0x052c }
            java.lang.String r15 = r2.zzp     // Catch:{ all -> 0x052c }
            java.lang.String r11 = r0.zzaa()     // Catch:{ all -> 0x052c }
            boolean r11 = com.google.android.gms.measurement.internal.zzos.zza((java.lang.String) r12, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r11)     // Catch:{ all -> 0x052c }
            if (r11 == 0) goto L_0x01c2
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r11 = r11.zzu()     // Catch:{ all -> 0x052c }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r0.zzac()     // Catch:{ all -> 0x052c }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r14)     // Catch:{ all -> 0x052c }
            r11.zza(r12, r14)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzal r11 = r1.zzf()     // Catch:{ all -> 0x052c }
            java.lang.String r12 = r0.zzac()     // Catch:{ all -> 0x052c }
            r11.zzal()     // Catch:{ all -> 0x052c }
            r11.zzt()     // Catch:{ all -> 0x052c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x052c }
            android.database.sqlite.SQLiteDatabase r0 = r11.e_()     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x01af }
            r14[r10] = r12     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String r15 = "events"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String r10 = "user_attributes"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "conditional_properties"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "apps"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "raw_events"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "raw_events_metadata"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "event_filters"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "property_filters"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "audience_filter_values"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "consent_settings"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "default_event_params"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r10
            java.lang.String r10 = "trigger_uris"
            int r0 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01af }
            int r15 = r15 + r0
            if (r15 <= 0) goto L_0x01c1
            com.google.android.gms.measurement.internal.zzgo r0 = r11.zzj()     // Catch:{ SQLiteException -> 0x01af }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x01af }
            r0.zza(r8, r12, r10)     // Catch:{ SQLiteException -> 0x01af }
            goto L_0x01c1
        L_0x01af:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r8 = r11.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()     // Catch:{ all -> 0x052c }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r12)     // Catch:{ all -> 0x052c }
            r8.zza(r10, r11, r0)     // Catch:{ all -> 0x052c }
        L_0x01c1:
            r0 = 0
        L_0x01c2:
            if (r0 == 0) goto L_0x021d
            long r10 = r0.zze()     // Catch:{ all -> 0x052c }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01dd
            long r10 = r0.zze()     // Catch:{ all -> 0x052c }
            r19 = r14
            long r14 = r2.zzj     // Catch:{ all -> 0x052c }
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01df
            r8 = r13
            goto L_0x01e0
        L_0x01dd:
            r19 = r14
        L_0x01df:
            r8 = 0
        L_0x01e0:
            java.lang.String r10 = r0.zzaf()     // Catch:{ all -> 0x052c }
            long r11 = r0.zze()     // Catch:{ all -> 0x052c }
            int r0 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x01f8
            if (r10 == 0) goto L_0x01f8
            java.lang.String r0 = r2.zzc     // Catch:{ all -> 0x052c }
            boolean r0 = r10.equals(r0)     // Catch:{ all -> 0x052c }
            if (r0 != 0) goto L_0x01f8
            r0 = r13
            goto L_0x01f9
        L_0x01f8:
            r0 = 0
        L_0x01f9:
            r0 = r0 | r8
            if (r0 == 0) goto L_0x021d
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052c }
            r0.<init>()     // Catch:{ all -> 0x052c }
            java.lang.String r8 = "_pv"
            r0.putString(r8, r10)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzbf r15 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_au"
            com.google.android.gms.measurement.internal.zzbe r8 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x052c }
            r8.<init>(r0)     // Catch:{ all -> 0x052c }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r8
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052c }
            r17 = r19
            r1.zza((com.google.android.gms.measurement.internal.zzbf) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
        L_0x021d:
            r26.zza((com.google.android.gms.measurement.internal.zzo) r27)     // Catch:{ all -> 0x052c }
            if (r9 != 0) goto L_0x022f
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x052c }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x052c }
            java.lang.String r10 = "_f"
            com.google.android.gms.measurement.internal.zzbb r0 = r0.zzd(r8, r10)     // Catch:{ all -> 0x052c }
            goto L_0x023f
        L_0x022f:
            if (r9 != r13) goto L_0x023e
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x052c }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x052c }
            java.lang.String r10 = "_v"
            com.google.android.gms.measurement.internal.zzbb r0 = r0.zzd(r8, r10)     // Catch:{ all -> 0x052c }
            goto L_0x023f
        L_0x023e:
            r0 = 0
        L_0x023f:
            if (r0 != 0) goto L_0x04ff
            r10 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = r17 / r10
            r19 = r10
            r10 = 1
            long r14 = r14 + r10
            long r14 = r14 * r19
            java.lang.String r8 = "_dac"
            java.lang.String r12 = "_et"
            java.lang.String r10 = "_r"
            java.lang.String r11 = "_c"
            if (r9 != 0) goto L_0x04b3
            r19 = r14
            com.google.android.gms.measurement.internal.zzon r15 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_fot"
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x052c }
            java.lang.String r20 = "auto"
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052c }
            r1.zza((com.google.android.gms.measurement.internal.zzon) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhv r0 = r1.zzl()     // Catch:{ all -> 0x052c }
            r0.zzt()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhf r0 = r1.zzl     // Catch:{ all -> 0x052c }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x052c }
            r9 = r0
            com.google.android.gms.measurement.internal.zzhf r9 = (com.google.android.gms.measurement.internal.zzhf) r9     // Catch:{ all -> 0x052c }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x036e
            boolean r14 = r0.isEmpty()     // Catch:{ all -> 0x052c }
            if (r14 == 0) goto L_0x0285
            goto L_0x036e
        L_0x0285:
            com.google.android.gms.measurement.internal.zzhy r14 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhv r14 = r14.zzl()     // Catch:{ all -> 0x052c }
            r14.zzt()     // Catch:{ all -> 0x052c }
            boolean r14 = r9.zza()     // Catch:{ all -> 0x052c }
            if (r14 != 0) goto L_0x02a5
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzo()     // Catch:{ all -> 0x052c }
            java.lang.String r6 = "Install Referrer Reporter is not available"
            r0.zza(r6)     // Catch:{ all -> 0x052c }
            goto L_0x037d
        L_0x02a5:
            com.google.android.gms.measurement.internal.zzhi r14 = new com.google.android.gms.measurement.internal.zzhi     // Catch:{ all -> 0x052c }
            r14.<init>(r9, r0)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzl()     // Catch:{ all -> 0x052c }
            r0.zzt()     // Catch:{ all -> 0x052c }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x052c }
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch:{ all -> 0x052c }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x052c }
            java.lang.String r13 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r6, r13)     // Catch:{ all -> 0x052c }
            r0.setComponent(r15)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhy r13 = r9.zza     // Catch:{ all -> 0x052c }
            android.content.Context r13 = r13.zza()     // Catch:{ all -> 0x052c }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x052c }
            if (r13 != 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzw()     // Catch:{ all -> 0x052c }
            java.lang.String r6 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x052c }
            goto L_0x037d
        L_0x02e1:
            r15 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r15)     // Catch:{ all -> 0x052c }
            if (r13 == 0) goto L_0x035e
            boolean r16 = r13.isEmpty()     // Catch:{ all -> 0x052c }
            if (r16 != 0) goto L_0x035e
            java.lang.Object r13 = r13.get(r15)     // Catch:{ all -> 0x052c }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x052c }
            android.content.pm.ServiceInfo r15 = r13.serviceInfo     // Catch:{ all -> 0x052c }
            if (r15 == 0) goto L_0x037d
            android.content.pm.ServiceInfo r15 = r13.serviceInfo     // Catch:{ all -> 0x052c }
            java.lang.String r15 = r15.packageName     // Catch:{ all -> 0x052c }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x052c }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x052c }
            if (r13 == 0) goto L_0x034e
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x052c }
            if (r6 == 0) goto L_0x034e
            boolean r6 = r9.zza()     // Catch:{ all -> 0x052c }
            if (r6 == 0) goto L_0x034e
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x052c }
            r6.<init>(r0)     // Catch:{ all -> 0x052c }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0339 }
            com.google.android.gms.measurement.internal.zzhy r13 = r9.zza     // Catch:{ RuntimeException -> 0x0339 }
            android.content.Context r13 = r13.zza()     // Catch:{ RuntimeException -> 0x0339 }
            r15 = 1
            boolean r0 = r0.bindService(r13, r6, r14, r15)     // Catch:{ RuntimeException -> 0x0339 }
            com.google.android.gms.measurement.internal.zzhy r6 = r9.zza     // Catch:{ RuntimeException -> 0x0339 }
            com.google.android.gms.measurement.internal.zzgo r6 = r6.zzj()     // Catch:{ RuntimeException -> 0x0339 }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch:{ RuntimeException -> 0x0339 }
            java.lang.String r13 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0333
            java.lang.String r0 = "available"
            goto L_0x0335
        L_0x0333:
            java.lang.String r0 = "not available"
        L_0x0335:
            r6.zza(r13, r0)     // Catch:{ RuntimeException -> 0x0339 }
            goto L_0x037d
        L_0x0339:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhy r6 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r6 = r6.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzg()     // Catch:{ all -> 0x052c }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x052c }
            r6.zza(r9, r0)     // Catch:{ all -> 0x052c }
            goto L_0x037d
        L_0x034e:
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()     // Catch:{ all -> 0x052c }
            java.lang.String r6 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x052c }
            goto L_0x037d
        L_0x035e:
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzo()     // Catch:{ all -> 0x052c }
            java.lang.String r6 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r6)     // Catch:{ all -> 0x052c }
            goto L_0x037d
        L_0x036e:
            com.google.android.gms.measurement.internal.zzhy r0 = r9.zza     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzw()     // Catch:{ all -> 0x052c }
            java.lang.String r6 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r6)     // Catch:{ all -> 0x052c }
        L_0x037d:
            com.google.android.gms.measurement.internal.zzhv r0 = r1.zzl()     // Catch:{ all -> 0x052c }
            r0.zzt()     // Catch:{ all -> 0x052c }
            r1.zzs()     // Catch:{ all -> 0x052c }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x052c }
            r6.<init>()     // Catch:{ all -> 0x052c }
            r13 = 1
            r6.putLong(r11, r13)     // Catch:{ all -> 0x052c }
            r6.putLong(r10, r13)     // Catch:{ all -> 0x052c }
            r9 = 0
            r6.putLong(r7, r9)     // Catch:{ all -> 0x052c }
            r6.putLong(r5, r9)     // Catch:{ all -> 0x052c }
            r6.putLong(r4, r9)     // Catch:{ all -> 0x052c }
            r6.putLong(r3, r9)     // Catch:{ all -> 0x052c }
            r6.putLong(r12, r13)     // Catch:{ all -> 0x052c }
            boolean r0 = r2.zzo     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x03ac
            r6.putLong(r8, r13)     // Catch:{ all -> 0x052c }
        L_0x03ac:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x052c }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x052c }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x052c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x052c }
            r0.zzt()     // Catch:{ all -> 0x052c }
            r0.zzal()     // Catch:{ all -> 0x052c }
            java.lang.String r9 = "first_open_count"
            long r9 = r0.zzb((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzm     // Catch:{ all -> 0x052c }
            android.content.Context r0 = r0.zza()     // Catch:{ all -> 0x052c }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x052c }
            if (r0 != 0) goto L_0x03e9
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ all -> 0x052c }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r8)     // Catch:{ all -> 0x052c }
            r0.zza(r3, r4)     // Catch:{ all -> 0x052c }
        L_0x03e5:
            r21 = 0
            goto L_0x0496
        L_0x03e9:
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x03f9 }
            android.content.Context r0 = r0.zza()     // Catch:{ NameNotFoundException -> 0x03f9 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03f9 }
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r8, r15)     // Catch:{ NameNotFoundException -> 0x03f9 }
            goto L_0x040c
        L_0x03f9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r11 = r11.zzg()     // Catch:{ all -> 0x052c }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r8)     // Catch:{ all -> 0x052c }
            r11.zza(r12, r13, r0)     // Catch:{ all -> 0x052c }
            r0 = 0
        L_0x040c:
            if (r0 == 0) goto L_0x0456
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x052c }
            r21 = 0
            int r11 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r11 == 0) goto L_0x0456
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x052c }
            long r13 = r0.lastUpdateTime     // Catch:{ all -> 0x052c }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x043d
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbh.zzbs     // Catch:{ all -> 0x052c }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r11)     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x0436
            r21 = 0
            int r0 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x043b
            r13 = 1
            r6.putLong(r7, r13)     // Catch:{ all -> 0x052c }
            goto L_0x043b
        L_0x0436:
            r13 = 1
            r6.putLong(r7, r13)     // Catch:{ all -> 0x052c }
        L_0x043b:
            r15 = 0
            goto L_0x043e
        L_0x043d:
            r15 = 1
        L_0x043e:
            com.google.android.gms.measurement.internal.zzon r0 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_fi"
            if (r15 == 0) goto L_0x0447
            r14 = 1
            goto L_0x0449
        L_0x0447:
            r14 = 0
        L_0x0449:
            java.lang.Long r19 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x052c }
            java.lang.String r20 = "auto"
            r15 = r0
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052c }
            r1.zza((com.google.android.gms.measurement.internal.zzon) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
        L_0x0456:
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x0466 }
            android.content.Context r0 = r0.zza()     // Catch:{ NameNotFoundException -> 0x0466 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0466 }
            r15 = 0
            android.content.pm.ApplicationInfo r11 = r0.getApplicationInfo(r8, r15)     // Catch:{ NameNotFoundException -> 0x0466 }
            goto L_0x0479
        L_0x0466:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()     // Catch:{ all -> 0x052c }
            java.lang.String r11 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r8)     // Catch:{ all -> 0x052c }
            r7.zza(r11, r8, r0)     // Catch:{ all -> 0x052c }
            r11 = 0
        L_0x0479:
            if (r11 == 0) goto L_0x03e5
            int r0 = r11.flags     // Catch:{ all -> 0x052c }
            r25 = 1
            r0 = r0 & 1
            if (r0 == 0) goto L_0x0489
            r13 = 1
            r6.putLong(r4, r13)     // Catch:{ all -> 0x052c }
            goto L_0x048b
        L_0x0489:
            r13 = 1
        L_0x048b:
            int r0 = r11.flags     // Catch:{ all -> 0x052c }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e5
            r6.putLong(r3, r13)     // Catch:{ all -> 0x052c }
            goto L_0x03e5
        L_0x0496:
            int r0 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r0 < 0) goto L_0x049d
            r6.putLong(r5, r9)     // Catch:{ all -> 0x052c }
        L_0x049d:
            com.google.android.gms.measurement.internal.zzbf r15 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_f"
            com.google.android.gms.measurement.internal.zzbe r0 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x052c }
            r0.<init>(r6)     // Catch:{ all -> 0x052c }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r0
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052c }
            r1.zzb((com.google.android.gms.measurement.internal.zzbf) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
            goto L_0x051d
        L_0x04b3:
            r19 = r14
            r15 = r13
            if (r9 != r15) goto L_0x051d
            com.google.android.gms.measurement.internal.zzon r15 = new com.google.android.gms.measurement.internal.zzon     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_fvt"
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x052c }
            java.lang.String r20 = "auto"
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052c }
            r1.zza((com.google.android.gms.measurement.internal.zzon) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzhv r0 = r1.zzl()     // Catch:{ all -> 0x052c }
            r0.zzt()     // Catch:{ all -> 0x052c }
            r1.zzs()     // Catch:{ all -> 0x052c }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052c }
            r0.<init>()     // Catch:{ all -> 0x052c }
            r13 = 1
            r0.putLong(r11, r13)     // Catch:{ all -> 0x052c }
            r0.putLong(r10, r13)     // Catch:{ all -> 0x052c }
            r0.putLong(r12, r13)     // Catch:{ all -> 0x052c }
            boolean r3 = r2.zzo     // Catch:{ all -> 0x052c }
            if (r3 == 0) goto L_0x04e9
            r0.putLong(r8, r13)     // Catch:{ all -> 0x052c }
        L_0x04e9:
            com.google.android.gms.measurement.internal.zzbf r15 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_v"
            com.google.android.gms.measurement.internal.zzbe r3 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x052c }
            r3.<init>(r0)     // Catch:{ all -> 0x052c }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052c }
            r1.zzb((com.google.android.gms.measurement.internal.zzbf) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
            goto L_0x051d
        L_0x04ff:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x052c }
            if (r0 == 0) goto L_0x051d
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052c }
            r0.<init>()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzbf r15 = new com.google.android.gms.measurement.internal.zzbf     // Catch:{ all -> 0x052c }
            java.lang.String r16 = "_cd"
            com.google.android.gms.measurement.internal.zzbe r3 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x052c }
            r3.<init>(r0)     // Catch:{ all -> 0x052c }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052c }
            r1.zzb((com.google.android.gms.measurement.internal.zzbf) r15, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052c }
        L_0x051d:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x052c }
            r0.zzw()     // Catch:{ all -> 0x052c }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x052c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzf()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zzd(com.google.android.gms.measurement.internal.zzo):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzae zzae2) {
        zzo zzc2 = zzc((String) Preconditions.checkNotNull(zzae2.zza));
        if (zzc2 != null) {
            zza(zzae2, zzc2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzae zzae2, zzo zzo2) {
        Preconditions.checkNotNull(zzae2);
        Preconditions.checkNotEmpty(zzae2.zza);
        Preconditions.checkNotNull(zzae2.zzc);
        Preconditions.checkNotEmpty(zzae2.zzc.zza);
        zzl().zzt();
        zzs();
        if (zzi(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            zzf().zzp();
            try {
                zza(zzo2);
                String str = (String) Preconditions.checkNotNull(zzae2.zza);
                zzae zzc2 = zzf().zzc(str, zzae2.zzc.zza);
                if (zzc2 != null) {
                    zzj().zzc().zza("Removing conditional user property", zzae2.zza, this.zzm.zzk().zzc(zzae2.zzc.zza));
                    zzf().zza(str, zzae2.zzc.zza);
                    if (zzc2.zze) {
                        zzf().zzh(str, zzae2.zzc.zza);
                    }
                    if (zzae2.zzk != null) {
                        zzc((zzbf) Preconditions.checkNotNull(zzq().zza(str, ((zzbf) Preconditions.checkNotNull(zzae2.zzk)).zza, zzae2.zzk.zzb != null ? zzae2.zzk.zzb.zzb() : null, zzc2.zzb, zzae2.zzk.zzd, true, true)), zzo2);
                    }
                } else {
                    zzj().zzu().zza("Conditional user property doesn't exist", zzgo.zza(zzae2.zza), this.zzm.zzk().zzc(zzae2.zzc.zza));
                }
                zzf().zzw();
                zzf().zzu();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzf().zzu();
                throw th2;
            }
        }
    }

    private static void zza(zzfy.zzf.zza zza2, String str) {
        List<zzfy.zzh> zzf2 = zza2.zzf();
        for (int i = 0; i < zzf2.size(); i++) {
            if (str.equals(zzf2.get(i).zzg())) {
                zza2.zza(i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzo zzo2) {
        zzl().zzt();
        zzs();
        if (zzi(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            Boolean zzh2 = zzh(zzo2);
            if (!"_npa".equals(str) || zzh2 == null) {
                zzj().zzc().zza("Removing user property", this.zzm.zzk().zzc(str));
                zzf().zzp();
                try {
                    zza(zzo2);
                    if ("_id".equals(str)) {
                        zzf().zzh((String) Preconditions.checkNotNull(zzo2.zza), "_lair");
                    }
                    zzf().zzh((String) Preconditions.checkNotNull(zzo2.zza), str);
                    zzf().zzw();
                    zzj().zzc().zza("User property removed", this.zzm.zzk().zzc(str));
                    zzf().zzu();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    zzf().zzu();
                    throw th2;
                }
            } else {
                zzj().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzon("_npa", zzb().currentTimeMillis(), Long.valueOf(zzh2.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzo2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzo zzo2) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzaa = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzal zzf2 = zzf();
        String str = (String) Preconditions.checkNotNull(zzo2.zza);
        Preconditions.checkNotEmpty(str);
        zzf2.zzt();
        zzf2.zzal();
        try {
            SQLiteDatabase e_ = zzf2.e_();
            String[] strArr = {str};
            int delete = e_.delete("apps", "app_id=?", strArr) + e_.delete("events", "app_id=?", strArr) + e_.delete("events_snapshot", "app_id=?", strArr) + e_.delete("user_attributes", "app_id=?", strArr) + e_.delete("conditional_properties", "app_id=?", strArr) + e_.delete("raw_events", "app_id=?", strArr) + e_.delete("raw_events_metadata", "app_id=?", strArr) + e_.delete("queue", "app_id=?", strArr) + e_.delete("audience_filter_values", "app_id=?", strArr) + e_.delete("main_event_params", "app_id=?", strArr) + e_.delete("default_event_params", "app_id=?", strArr) + e_.delete("trigger_uris", "app_id=?", strArr) + e_.delete("upload_queue", "app_id=?", strArr);
            if (delete > 0) {
                zzf2.zzj().zzp().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzf2.zzj().zzg().zza("Error resetting analytics data. appId, error", zzgo.zza(str), e);
        }
        if (zzo2.zzh) {
            zzd(zzo2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzo zzo2) {
        zzo zzo3 = zzo2;
        zzl().zzt();
        zzs();
        Preconditions.checkNotEmpty(zzo3.zza);
        zzax zza2 = zzax.zza(zzo3.zzz);
        zzj().zzp().zza("Setting DMA consent for package", zzo3.zza, zza2);
        String str = zzo3.zza;
        zzl().zzt();
        zzs();
        zzjh zzc2 = zzax.zza(zza(str), 100).zzc();
        this.zzad.put(str, zza2);
        zzf().zza(str, zza2);
        zzjh zzc3 = zzax.zza(zza(str), 100).zzc();
        zzl().zzt();
        zzs();
        boolean z = true;
        boolean z2 = zzc2 == zzjh.DENIED && zzc3 == zzjh.GRANTED;
        boolean z3 = zzc2 == zzjh.GRANTED && zzc3 == zzjh.DENIED;
        if (zze().zza(zzbh.zzcq)) {
            if (!z2 && !z3) {
                z = false;
            }
            z2 = z;
        }
        if (z2) {
            zzj().zzp().zza("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzf().zza(zzx(), str, false, false, false, false, false, false, false).zzf < ((long) zze().zzb(str, zzbh.zzay))) {
                bundle.putLong("_r", 1);
                zzj().zzp().zza("_dcu realtime event count", str, Long.valueOf(zzf().zza(zzx(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzah.zza(str, "_dcu", bundle);
        }
    }

    public final void zza(String str, zzlk zzlk) {
        zzl().zzt();
        String str2 = this.zzag;
        if (str2 == null || str2.equals(str) || zzlk != null) {
            this.zzag = str;
            this.zzaf = zzlk;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzo zzo2) {
        zzl().zzt();
        zzs();
        Preconditions.checkNotEmpty(zzo2.zza);
        zzje zza2 = zzje.zza(zzo2.zzt, zzo2.zzy);
        zzje zzb2 = zzb(zzo2.zza);
        zzj().zzp().zza("Setting storage consent for package", zzo2.zza, zza2);
        zza(zzo2.zza, zza2);
        if ((!zznm.zza() || !zze().zza(zzbh.zzcy)) && zza2.zzc(zzb2)) {
            zze(zzo2);
        }
    }

    private final void zza(List<Long> list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzj().zzg().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        int delete;
        zzl().zzt();
        zzf().zzv();
        zzal zzf2 = zzf();
        zzf2.zzt();
        zzf2.zzal();
        if (zzf2.zzaa() && zzbh.zzbh.zza(null).longValue() != 0 && (delete = zzf2.e_().delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzf2.zzb().currentTimeMillis()), String.valueOf(zzbh.zzbh.zza(null))})) > 0) {
            zzf2.zzj().zzp().zza("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
        }
        if (this.zzj.zzd.zza() == 0) {
            this.zzj.zzd.zza(zzb().currentTimeMillis());
        }
        zzac();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzae zzae2) {
        zzo zzc2 = zzc((String) Preconditions.checkNotNull(zzae2.zza));
        if (zzc2 != null) {
            zzb(zzae2, zzc2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzae zzae2, zzo zzo2) {
        Preconditions.checkNotNull(zzae2);
        Preconditions.checkNotEmpty(zzae2.zza);
        Preconditions.checkNotNull(zzae2.zzb);
        Preconditions.checkNotNull(zzae2.zzc);
        Preconditions.checkNotEmpty(zzae2.zzc.zza);
        zzl().zzt();
        zzs();
        if (zzi(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            zzae zzae3 = new zzae(zzae2);
            boolean z = false;
            zzae3.zze = false;
            zzf().zzp();
            try {
                zzae zzc2 = zzf().zzc((String) Preconditions.checkNotNull(zzae3.zza), zzae3.zzc.zza);
                if (zzc2 != null && !zzc2.zzb.equals(zzae3.zzb)) {
                    zzj().zzu().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzb, zzc2.zzb);
                }
                if (zzc2 != null && zzc2.zze) {
                    zzae3.zzb = zzc2.zzb;
                    zzae3.zzd = zzc2.zzd;
                    zzae3.zzh = zzc2.zzh;
                    zzae3.zzf = zzc2.zzf;
                    zzae3.zzi = zzc2.zzi;
                    zzae3.zze = zzc2.zze;
                    zzae3.zzc = new zzon(zzae3.zzc.zza, zzc2.zzc.zzb, zzae3.zzc.zza(), zzc2.zzc.zze);
                } else if (TextUtils.isEmpty(zzae3.zzf)) {
                    zzae3.zzc = new zzon(zzae3.zzc.zza, zzae3.zzd, zzae3.zzc.zza(), zzae3.zzc.zze);
                    z = true;
                    zzae3.zze = true;
                }
                if (zzae3.zze) {
                    zzon zzon = zzae3.zzc;
                    zzop zzop = new zzop((String) Preconditions.checkNotNull(zzae3.zza), zzae3.zzb, zzon.zza, zzon.zzb, Preconditions.checkNotNull(zzon.zza()));
                    if (zzf().zza(zzop)) {
                        zzj().zzc().zza("User property updated immediately", zzae3.zza, this.zzm.zzk().zzc(zzop.zzc), zzop.zze);
                    } else {
                        zzj().zzg().zza("(2)Too many active user properties, ignoring", zzgo.zza(zzae3.zza), this.zzm.zzk().zzc(zzop.zzc), zzop.zze);
                    }
                    if (z && zzae3.zzi != null) {
                        zzc(new zzbf(zzae3.zzi, zzae3.zzd), zzo2);
                    }
                }
                if (zzf().zza(zzae3)) {
                    zzj().zzc().zza("Conditional property added", zzae3.zza, this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzc.zza());
                } else {
                    zzj().zzg().zza("Too many conditional properties, ignoring", zzgo.zza(zzae3.zza), this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzc.zza());
                }
                zzf().zzw();
                zzf().zzu();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzf().zzu();
                throw th2;
            }
        }
    }

    private final void zzac() {
        long j;
        long j2;
        zzl().zzt();
        zzs();
        if (this.zzp > 0) {
            long abs = 3600000 - Math.abs(zzb().elapsedRealtime() - this.zzp);
            if (abs > 0) {
                zzj().zzp().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzy().zzb();
                zzz().zzu();
                return;
            }
            this.zzp = 0;
        }
        if (!this.zzm.zzaf() || !zzad()) {
            zzj().zzp().zza("Nothing to upload or uploading impossible");
            zzy().zzb();
            zzz().zzu();
            return;
        }
        long currentTimeMillis = zzb().currentTimeMillis();
        zze();
        long max = Math.max(0, zzbh.zzab.zza(null).longValue());
        boolean z = zzf().zzz() || zzf().zzy();
        if (z) {
            String zzo2 = zze().zzo();
            if (TextUtils.isEmpty(zzo2) || ".none.".equals(zzo2)) {
                zze();
                j = Math.max(0, zzbh.zzv.zza(null).longValue());
            } else {
                zze();
                j = Math.max(0, zzbh.zzw.zza(null).longValue());
            }
        } else {
            zze();
            j = Math.max(0, zzbh.zzu.zza(null).longValue());
        }
        long zza2 = this.zzj.zzd.zza();
        long zza3 = this.zzj.zze.zza();
        long j3 = 0;
        long j4 = max;
        long max2 = Math.max(zzf().c_(), zzf().d_());
        if (max2 == 0) {
            j2 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            long j5 = abs2 + j4;
            if (z && max3 > 0) {
                j5 = Math.min(abs2, max3) + j;
            }
            j2 = !zzp().zza(max3, j) ? max3 + j : j5;
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    zze();
                    if (i >= Math.min(20, Math.max(0, zzbh.zzad.zza(null).intValue()))) {
                        j2 = 0;
                        break;
                    }
                    zze();
                    j2 += Math.max(j3, zzbh.zzac.zza(null).longValue()) * (1 << i);
                    if (j2 > abs4) {
                        break;
                    }
                    i++;
                    j3 = 0;
                }
            }
            j3 = 0;
        }
        if (j2 == j3) {
            zzj().zzp().zza("Next upload time is 0");
            zzy().zzb();
            zzz().zzu();
        } else if (!zzh().zzu()) {
            zzj().zzp().zza("No network");
            zzy().zza();
            zzz().zzu();
        } else {
            long zza4 = this.zzj.zzc.zza();
            zze();
            long max4 = Math.max(0, zzbh.zzs.zza(null).longValue());
            if (!zzp().zza(zza4, max4)) {
                j2 = Math.max(j2, zza4 + max4);
            }
            zzy().zzb();
            long currentTimeMillis2 = j2 - zzb().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                zze();
                currentTimeMillis2 = Math.max(0, zzbh.zzx.zza(null).longValue());
                this.zzj.zzd.zza(zzb().currentTimeMillis());
            }
            zzj().zzp().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzz().zza(currentTimeMillis2);
        }
    }

    private final void zza(String str, zzje zzje) {
        zzl().zzt();
        zzs();
        this.zzac.put(str, zzje);
        zzf().zzb(str, zzje);
    }

    private final void zza(String str, boolean z, Long l, Long l2) {
        zzg zze2 = zzf().zze(str);
        if (zze2 != null) {
            zze2.zzd(z);
            zze2.zza(l);
            zze2.zzb(l2);
            if (zze2.zzas()) {
                zzf().zza(zze2, false, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzon zzon, zzo zzo2) {
        zzop zze2;
        long j;
        zzon zzon2 = zzon;
        zzo zzo3 = zzo2;
        zzl().zzt();
        zzs();
        if (zzi(zzo3)) {
            if (!zzo3.zzh) {
                zza(zzo3);
                return;
            }
            int zzb2 = zzq().zzb(zzon2.zza);
            int i = 0;
            if (zzb2 != 0) {
                zzq();
                String str = zzon2.zza;
                zze();
                String zza2 = zzos.zza(str, 24, true);
                if (zzon2.zza != null) {
                    i = zzon2.zza.length();
                }
                zzq();
                zzos.zza(this.zzah, zzo3.zza, zzb2, "_ev", zza2, i);
                return;
            }
            int zza3 = zzq().zza(zzon2.zza, zzon2.zza());
            if (zza3 != 0) {
                zzq();
                String str2 = zzon2.zza;
                zze();
                String zza4 = zzos.zza(str2, 24, true);
                Object zza5 = zzon2.zza();
                if (zza5 != null && ((zza5 instanceof String) || (zza5 instanceof CharSequence))) {
                    i = String.valueOf(zza5).length();
                }
                zzq();
                zzos.zza(this.zzah, zzo3.zza, zza3, "_ev", zza4, i);
                return;
            }
            Object zzc2 = zzq().zzc(zzon2.zza, zzon2.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzon2.zza)) {
                    long j2 = zzon2.zzb;
                    String str3 = zzon2.zze;
                    String str4 = (String) Preconditions.checkNotNull(zzo3.zza);
                    zzop zze3 = zzf().zze(str4, "_sno");
                    if (zze3 == null || !(zze3.zze instanceof Long)) {
                        if (zze3 != null) {
                            zzj().zzu().zza("Retrieved last session number from database does not contain a valid (long) value", zze3.zze);
                        }
                        zzbb zzd2 = zzf().zzd(str4, "_s");
                        if (zzd2 != null) {
                            j = zzd2.zzc;
                            zzj().zzp().zza("Backfill the session number. Last used session number", Long.valueOf(j));
                        } else {
                            j = 0;
                        }
                    } else {
                        j = ((Long) zze3.zze).longValue();
                    }
                    zza(new zzon("_sno", j2, Long.valueOf(j + 1), str3), zzo3);
                }
                zzop zzop = new zzop((String) Preconditions.checkNotNull(zzo3.zza), (String) Preconditions.checkNotNull(zzon2.zze), zzon2.zza, zzon2.zzb, zzc2);
                zzj().zzp().zza("Setting user property", this.zzm.zzk().zzc(zzop.zzc), zzc2);
                zzf().zzp();
                try {
                    if ("_id".equals(zzop.zzc) && (zze2 = zzf().zze(zzo3.zza, "_id")) != null && !zzop.zze.equals(zze2.zze)) {
                        zzf().zzh(zzo3.zza, "_lair");
                    }
                    zza(zzo3);
                    boolean zza6 = zzf().zza(zzop);
                    if ("_sid".equals(zzon2.zza)) {
                        long zza7 = zzp().zza(zzo3.zzv);
                        zzg zze4 = zzf().zze(zzo3.zza);
                        if (zze4 != null) {
                            zze4.zzs(zza7);
                            if (zze4.zzas()) {
                                zzf().zza(zze4, false, false);
                            }
                        }
                    }
                    zzf().zzw();
                    if (!zza6) {
                        zzj().zzg().zza("Too many unique user properties are set. Ignoring user property", this.zzm.zzk().zzc(zzop.zzc), zzop.zze);
                        zzq();
                        zzos.zza(this.zzah, zzo3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzf().zzu();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        zzj().zzg().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzgo.zza(r6), r0.zzb());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:242:0x05e6 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d0 A[SYNTHETIC, Splitter:B:100:0x01d0] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01e8 A[Catch:{ all -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0319 A[Catch:{ all -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0355 A[Catch:{ all -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x036b A[SYNTHETIC, Splitter:B:165:0x036b] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0542 A[Catch:{ all -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x054b A[Catch:{ all -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x055d A[SYNTHETIC, Splitter:B:220:0x055d] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x05ab A[Catch:{ MalformedURLException -> 0x05e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x033f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw() {
        /*
            r24 = this;
            r1 = r24
            com.google.android.gms.measurement.internal.zzhv r0 = r1.zzl()
            r0.zzt()
            r1.zzs()
            r0 = 1
            r1.zzw = r0
            r8 = 0
            com.google.android.gms.measurement.internal.zzhy r2 = r1.zzm     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzls r2 = r2.zzr()     // Catch:{ all -> 0x0628 }
            java.lang.Boolean r2 = r2.zzab()     // Catch:{ all -> 0x0628 }
            if (r2 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x002f }
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x002f:
            r0 = move-exception
            r2 = r8
            goto L_0x062a
        L_0x0033:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0628 }
            if (r2 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x002f }
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x004c:
            long r2 = r1.zzp     // Catch:{ all -> 0x0628 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x005d
            r1.zzac()     // Catch:{ all -> 0x002f }
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x005d:
            com.google.android.gms.measurement.internal.zzhv r2 = r1.zzl()     // Catch:{ all -> 0x0628 }
            r2.zzt()     // Catch:{ all -> 0x0628 }
            java.util.List<java.lang.Long> r2 = r1.zzz     // Catch:{ all -> 0x0628 }
            if (r2 == 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x002f }
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.zzgr r2 = r1.zzh()     // Catch:{ all -> 0x0628 }
            boolean r2 = r2.zzu()     // Catch:{ all -> 0x0628 }
            if (r2 != 0) goto L_0x009b
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x002f }
            r1.zzac()     // Catch:{ all -> 0x002f }
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x009b:
            com.google.android.gms.common.util.Clock r2 = r1.zzb()     // Catch:{ all -> 0x0628 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzag r6 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzbh.zzau     // Catch:{ all -> 0x0628 }
            r9 = 0
            int r6 = r6.zzb((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r7)     // Catch:{ all -> 0x0628 }
            r1.zze()     // Catch:{ all -> 0x0628 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzg()     // Catch:{ all -> 0x0628 }
            long r10 = r2 - r10
            r7 = r8
        L_0x00b8:
            if (r7 >= r6) goto L_0x00c3
            boolean r12 = r1.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x002f }
            if (r12 == 0) goto L_0x00c3
            int r7 = r7 + 1
            goto L_0x00b8
        L_0x00c3:
            boolean r6 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x0628 }
            if (r6 == 0) goto L_0x00cc
            r1.zzab()     // Catch:{ all -> 0x002f }
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzmw r6 = r1.zzj     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzhb r6 = r6.zzd     // Catch:{ all -> 0x0628 }
            long r6 = r6.zza()     // Catch:{ all -> 0x0628 }
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzc()     // Catch:{ all -> 0x002f }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r6 = r2 - r6
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x002f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x002f }
            r4.zza(r5, r6)     // Catch:{ all -> 0x002f }
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzal r4 = r1.zzf()     // Catch:{ all -> 0x0628 }
            java.lang.String r6 = r4.f_()     // Catch:{ all -> 0x0628 }
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0628 }
            r10 = -1
            if (r4 != 0) goto L_0x05fc
            long r4 = r1.zzab     // Catch:{ all -> 0x0628 }
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzal r4 = r1.zzf()     // Catch:{ all -> 0x002f }
            long r4 = r4.b_()     // Catch:{ all -> 0x002f }
            r1.zzab = r4     // Catch:{ all -> 0x002f }
        L_0x010f:
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzbh.zzg     // Catch:{ all -> 0x0628 }
            int r4 = r4.zzb((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r5)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzag r5 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzbh.zzh     // Catch:{ all -> 0x0628 }
            int r5 = r5.zzb((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r7)     // Catch:{ all -> 0x0628 }
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x0628 }
            java.util.List r4 = r7.zza((java.lang.String) r6, (int) r4, (int) r5)     // Catch:{ all -> 0x0628 }
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x0628 }
            if (r5 != 0) goto L_0x0621
            com.google.android.gms.measurement.internal.zzje r5 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x0628 }
            boolean r5 = r5.zzg()     // Catch:{ all -> 0x0628 }
            if (r5 == 0) goto L_0x0192
            java.util.Iterator r5 = r4.iterator()     // Catch:{ all -> 0x002f }
        L_0x0143:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0162
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x002f }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ all -> 0x002f }
            java.lang.Object r7 = r7.first     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = (com.google.android.gms.internal.measurement.zzfy.zzk) r7     // Catch:{ all -> 0x002f }
            java.lang.String r10 = r7.zzan()     // Catch:{ all -> 0x002f }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x002f }
            if (r10 != 0) goto L_0x0143
            java.lang.String r5 = r7.zzan()     // Catch:{ all -> 0x002f }
            goto L_0x0163
        L_0x0162:
            r5 = r9
        L_0x0163:
            if (r5 == 0) goto L_0x0192
            r7 = r8
        L_0x0166:
            int r10 = r4.size()     // Catch:{ all -> 0x002f }
            if (r7 >= r10) goto L_0x0192
            java.lang.Object r10 = r4.get(r7)     // Catch:{ all -> 0x002f }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x002f }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = (com.google.android.gms.internal.measurement.zzfy.zzk) r10     // Catch:{ all -> 0x002f }
            java.lang.String r11 = r10.zzan()     // Catch:{ all -> 0x002f }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x002f }
            if (r11 != 0) goto L_0x018f
            java.lang.String r10 = r10.zzan()     // Catch:{ all -> 0x002f }
            boolean r10 = r10.equals(r5)     // Catch:{ all -> 0x002f }
            if (r10 != 0) goto L_0x018f
            java.util.List r4 = r4.subList(r8, r7)     // Catch:{ all -> 0x002f }
            goto L_0x0192
        L_0x018f:
            int r7 = r7 + 1
            goto L_0x0166
        L_0x0192:
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r5 = com.google.android.gms.internal.measurement.zzfy.zzj.zzb()     // Catch:{ all -> 0x0628 }
            int r7 = r4.size()     // Catch:{ all -> 0x0628 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0628 }
            int r11 = r4.size()     // Catch:{ all -> 0x0628 }
            r10.<init>(r11)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzag r11 = r1.zze()     // Catch:{ all -> 0x0628 }
            boolean r11 = r11.zzj(r6)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x01b9
            com.google.android.gms.measurement.internal.zzje r11 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x002f }
            boolean r11 = r11.zzg()     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x01b9
            r11 = r0
            goto L_0x01ba
        L_0x01b9:
            r11 = r8
        L_0x01ba:
            com.google.android.gms.measurement.internal.zzje r12 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x0628 }
            boolean r12 = r12.zzg()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzje r13 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x0628 }
            boolean r13 = r13.zzh()     // Catch:{ all -> 0x0628 }
            boolean r14 = com.google.android.gms.internal.measurement.zzpo.zza()     // Catch:{ all -> 0x0628 }
            if (r14 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzag r14 = r1.zze()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzbh.zzbw     // Catch:{ all -> 0x002f }
            boolean r14 = r14.zze(r6, r15)     // Catch:{ all -> 0x002f }
            if (r14 == 0) goto L_0x01de
            r14 = r0
            goto L_0x01df
        L_0x01de:
            r14 = r8
        L_0x01df:
            com.google.android.gms.measurement.internal.zznu r15 = r1.zzk     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznw r15 = r15.zza((java.lang.String) r6)     // Catch:{ all -> 0x0628 }
            r9 = r8
        L_0x01e6:
            if (r9 >= r7) goto L_0x034d
            java.lang.Object r16 = r4.get(r9)     // Catch:{ all -> 0x0628 }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x0628 }
            java.lang.Object r0 = r0.first     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r0 = (com.google.android.gms.internal.measurement.zzfy.zzk) r0     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt$zzb r0 = r0.zzcd()     // Catch:{ all -> 0x0628 }
            r16 = r0
            com.google.android.gms.internal.measurement.zzjt$zzb r16 = (com.google.android.gms.internal.measurement.zzjt.zzb) r16     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0     // Catch:{ all -> 0x0628 }
            java.lang.Object r16 = r4.get(r9)     // Catch:{ all -> 0x0628 }
            r8 = r16
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0628 }
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x0628 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0628 }
            r10.add(r8)     // Catch:{ all -> 0x0628 }
            r1.zze()     // Catch:{ all -> 0x0628 }
            r16 = r7
            r7 = 106000(0x19e10, double:5.2371E-319)
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r7 = r0.zzl((long) r7)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r7 = r7.zzk((long) r2)     // Catch:{ all -> 0x0628 }
            r8 = 0
            r7.zzd((boolean) r8)     // Catch:{ all -> 0x0628 }
            if (r11 != 0) goto L_0x0226
            r0.zzk()     // Catch:{ all -> 0x0628 }
        L_0x0226:
            if (r12 != 0) goto L_0x022e
            r0.zzq()     // Catch:{ all -> 0x0628 }
            r0.zzn()     // Catch:{ all -> 0x0628 }
        L_0x022e:
            if (r13 != 0) goto L_0x0233
            r0.zzh()     // Catch:{ all -> 0x0628 }
        L_0x0233:
            r1.zza((java.lang.String) r6, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0)     // Catch:{ all -> 0x0628 }
            if (r14 != 0) goto L_0x023b
            r0.zzr()     // Catch:{ all -> 0x0628 }
        L_0x023b:
            boolean r7 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x0252
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbh.zzcz     // Catch:{ all -> 0x0628 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x0252
            if (r13 != 0) goto L_0x0252
            r0.zzi()     // Catch:{ all -> 0x0628 }
        L_0x0252:
            java.lang.String r7 = r0.zzz()     // Catch:{ all -> 0x0628 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0628 }
            if (r8 != 0) goto L_0x026f
            java.lang.String r8 = "00000000-0000-0000-0000-000000000000"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x0265
            goto L_0x026f
        L_0x0265:
            r17 = r4
            r22 = r9
            r21 = r11
            r23 = r12
            goto L_0x0313
        L_0x026f:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0628 }
            java.util.List r8 = r0.zzaa()     // Catch:{ all -> 0x0628 }
            r7.<init>(r8)     // Catch:{ all -> 0x0628 }
            java.util.Iterator r8 = r7.iterator()     // Catch:{ all -> 0x0628 }
            r17 = r4
            r18 = r8
            r4 = 0
            r8 = 0
            r19 = 0
            r20 = 0
        L_0x0286:
            boolean r21 = r18.hasNext()     // Catch:{ all -> 0x0628 }
            if (r21 == 0) goto L_0x02fb
            java.lang.Object r21 = r18.next()     // Catch:{ all -> 0x0628 }
            r22 = r9
            r9 = r21
            com.google.android.gms.internal.measurement.zzfy$zzf r9 = (com.google.android.gms.internal.measurement.zzfy.zzf) r9     // Catch:{ all -> 0x0628 }
            r21 = r11
            java.lang.String r11 = "_fx"
            r23 = r12
            java.lang.String r12 = r9.zzg()     // Catch:{ all -> 0x0628 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x02b4
            r18.remove()     // Catch:{ all -> 0x0628 }
            r11 = r21
            r9 = r22
            r12 = r23
            r19 = 1
            r20 = 1
            goto L_0x0286
        L_0x02b4:
            java.lang.String r11 = "_f"
            java.lang.String r12 = r9.zzg()     // Catch:{ all -> 0x0628 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x02f4
            com.google.android.gms.measurement.internal.zzag r11 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzbh.zzcw     // Catch:{ all -> 0x0628 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r12)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x02f2
            r1.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r11 = "_pfo"
            com.google.android.gms.internal.measurement.zzfy$zzh r11 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r9, (java.lang.String) r11)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x02df
            long r11 = r11.zzd()     // Catch:{ all -> 0x0628 }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0628 }
        L_0x02df:
            r1.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r11 = "_uwa"
            com.google.android.gms.internal.measurement.zzfy$zzh r9 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r9, (java.lang.String) r11)     // Catch:{ all -> 0x0628 }
            if (r9 == 0) goto L_0x02f2
            long r8 = r9.zzd()     // Catch:{ all -> 0x0628 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0628 }
        L_0x02f2:
            r20 = 1
        L_0x02f4:
            r11 = r21
            r9 = r22
            r12 = r23
            goto L_0x0286
        L_0x02fb:
            r22 = r9
            r21 = r11
            r23 = r12
            if (r19 == 0) goto L_0x0309
            r0.zzl()     // Catch:{ all -> 0x0628 }
            r0.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzf>) r7)     // Catch:{ all -> 0x0628 }
        L_0x0309:
            if (r20 == 0) goto L_0x0313
            java.lang.String r7 = r0.zzt()     // Catch:{ all -> 0x0628 }
            r9 = 1
            r1.zza((java.lang.String) r7, (boolean) r9, (java.lang.Long) r4, (java.lang.Long) r8)     // Catch:{ all -> 0x0628 }
        L_0x0313:
            int r4 = r0.zzc()     // Catch:{ all -> 0x0628 }
            if (r4 == 0) goto L_0x033f
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzbm     // Catch:{ all -> 0x0628 }
            boolean r4 = r4.zze(r6, r7)     // Catch:{ all -> 0x0628 }
            if (r4 == 0) goto L_0x033c
            com.google.android.gms.internal.measurement.zzlc r4 = r0.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r4 = (com.google.android.gms.internal.measurement.zzjt) r4     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r4 = (com.google.android.gms.internal.measurement.zzfy.zzk) r4     // Catch:{ all -> 0x0628 }
            byte[] r4 = r4.zzca()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzoo r7 = r1.zzp()     // Catch:{ all -> 0x0628 }
            long r7 = r7.zza((byte[]) r4)     // Catch:{ all -> 0x0628 }
            r0.zza((long) r7)     // Catch:{ all -> 0x0628 }
        L_0x033c:
            r5.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0)     // Catch:{ all -> 0x0628 }
        L_0x033f:
            int r9 = r22 + 1
            r7 = r16
            r4 = r17
            r11 = r21
            r12 = r23
            r0 = 1
            r8 = 0
            goto L_0x01e6
        L_0x034d:
            r16 = r7
            int r0 = r5.zza()     // Catch:{ all -> 0x0628 }
            if (r0 != 0) goto L_0x036b
            r1.zza((java.util.List<java.lang.Long>) r10)     // Catch:{ all -> 0x0628 }
            java.util.List r7 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0628 }
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r5 = 0
            r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0628 }
            r8 = 0
            r1.zzw = r8
            r1.zzaa()
            return
        L_0x036b:
            com.google.android.gms.internal.measurement.zzlc r0 = r5.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r0 = (com.google.android.gms.internal.measurement.zzfy.zzj) r0     // Catch:{ all -> 0x0628 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0628 }
            r4.<init>()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbh.zzbx     // Catch:{ all -> 0x0628 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x0536
            r1.zzq()     // Catch:{ all -> 0x0628 }
            boolean r7 = com.google.android.gms.measurement.internal.zzos.zzf(r6)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x0536
            com.google.android.gms.measurement.internal.zznt r7 = r15.zza()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznt r8 = com.google.android.gms.measurement.internal.zznt.SGTM     // Catch:{ all -> 0x0628 }
            if (r7 != r8) goto L_0x0536
            com.google.android.gms.internal.measurement.zzlc r0 = r5.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r0 = (com.google.android.gms.internal.measurement.zzfy.zzj) r0     // Catch:{ all -> 0x0628 }
            java.util.List r0 = r0.zzf()     // Catch:{ all -> 0x0628 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0628 }
        L_0x03a5:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x03c0
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = (com.google.android.gms.internal.measurement.zzfy.zzk) r7     // Catch:{ all -> 0x0628 }
            boolean r7 = r7.zzbh()     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x03a5
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0628 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0628 }
            goto L_0x03c1
        L_0x03c0:
            r0 = 0
        L_0x03c1:
            com.google.android.gms.internal.measurement.zzlc r7 = r5.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r7 = (com.google.android.gms.internal.measurement.zzjt) r7     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r7 = (com.google.android.gms.internal.measurement.zzfy.zzj) r7     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzhv r8 = r1.zzl()     // Catch:{ all -> 0x0628 }
            r8.zzt()     // Catch:{ all -> 0x0628 }
            r1.zzs()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r8 = com.google.android.gms.internal.measurement.zzfy.zzj.zza((com.google.android.gms.internal.measurement.zzfy.zzj) r7)     // Catch:{ all -> 0x0628 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0628 }
            if (r9 != 0) goto L_0x03e0
            r8.zza((java.lang.String) r0)     // Catch:{ all -> 0x0628 }
        L_0x03e0:
            com.google.android.gms.measurement.internal.zzhl r9 = r1.zzi()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = r9.zzf(r6)     // Catch:{ all -> 0x0628 }
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0628 }
            if (r11 != 0) goto L_0x03f1
            r8.zzb(r9)     // Catch:{ all -> 0x0628 }
        L_0x03f1:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0628 }
            r9.<init>()     // Catch:{ all -> 0x0628 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x0628 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0628 }
        L_0x03fe:
            boolean r11 = r7.hasNext()     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x041d
            java.lang.Object r11 = r7.next()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = (com.google.android.gms.internal.measurement.zzfy.zzk) r11     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r11 = com.google.android.gms.internal.measurement.zzfy.zzk.zza((com.google.android.gms.internal.measurement.zzfy.zzk) r11)     // Catch:{ all -> 0x0628 }
            r11.zzk()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzlc r11 = r11.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r11 = (com.google.android.gms.internal.measurement.zzjt) r11     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = (com.google.android.gms.internal.measurement.zzfy.zzk) r11     // Catch:{ all -> 0x0628 }
            r9.add(r11)     // Catch:{ all -> 0x0628 }
            goto L_0x03fe
        L_0x041d:
            r8.zzb()     // Catch:{ all -> 0x0628 }
            r8.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzk>) r9)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbh.zzcc     // Catch:{ all -> 0x0628 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x044a
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = "Processed MeasurementBatch for sGTM with sgtmJoinId: "
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0628 }
            if (r11 == 0) goto L_0x0442
            java.lang.String r11 = "null"
            goto L_0x0446
        L_0x0442:
            java.lang.String r11 = r8.zzc()     // Catch:{ all -> 0x0628 }
        L_0x0446:
            r7.zza(r9, r11)     // Catch:{ all -> 0x0628 }
            goto L_0x0457
        L_0x044a:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = "Processed MeasurementBatch for sGTM."
            r7.zza(r9)     // Catch:{ all -> 0x0628 }
        L_0x0457:
            com.google.android.gms.internal.measurement.zzlc r7 = r8.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r7 = (com.google.android.gms.internal.measurement.zzjt) r7     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r7 = (com.google.android.gms.internal.measurement.zzfy.zzj) r7     // Catch:{ all -> 0x0628 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0628 }
            if (r8 != 0) goto L_0x0533
            com.google.android.gms.measurement.internal.zzag r8 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbh.zzcc     // Catch:{ all -> 0x0628 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0628 }
            if (r8 == 0) goto L_0x0533
            com.google.android.gms.internal.measurement.zzlc r8 = r5.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r8 = (com.google.android.gms.internal.measurement.zzjt) r8     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r8 = (com.google.android.gms.internal.measurement.zzfy.zzj) r8     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzhv r9 = r1.zzl()     // Catch:{ all -> 0x0628 }
            r9.zzt()     // Catch:{ all -> 0x0628 }
            r1.zzs()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj$zza r9 = com.google.android.gms.internal.measurement.zzfy.zzj.zzb()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgq r11 = r11.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r12 = "Processing Google Signal, sgtmJoinId:"
            r11.zza(r12, r0)     // Catch:{ all -> 0x0628 }
            r9.zza((java.lang.String) r0)     // Catch:{ all -> 0x0628 }
            java.util.List r0 = r8.zzf()     // Catch:{ all -> 0x0628 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0628 }
        L_0x049f:
            boolean r8 = r0.hasNext()     // Catch:{ all -> 0x0628 }
            if (r8 == 0) goto L_0x04c3
            java.lang.Object r8 = r0.next()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = (com.google.android.gms.internal.measurement.zzfy.zzk) r8     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r11 = com.google.android.gms.internal.measurement.zzfy.zzk.zzw()     // Catch:{ all -> 0x0628 }
            java.lang.String r12 = r8.zzah()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r11 = r11.zzj((java.lang.String) r12)     // Catch:{ all -> 0x0628 }
            int r8 = r8.zzd()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r8 = r11.zzg((int) r8)     // Catch:{ all -> 0x0628 }
            r9.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r8)     // Catch:{ all -> 0x0628 }
            goto L_0x049f
        L_0x04c3:
            com.google.android.gms.internal.measurement.zzlc r0 = r9.zzai()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ all -> 0x0628 }
            com.google.android.gms.internal.measurement.zzfy$zzj r0 = (com.google.android.gms.internal.measurement.zzfy.zzj) r0     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznu r8 = r1.zzk     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzhl r8 = r8.zzm()     // Catch:{ all -> 0x0628 }
            java.lang.String r8 = r8.zzf(r6)     // Catch:{ all -> 0x0628 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0628 }
            if (r9 != 0) goto L_0x051b
            com.google.android.gms.measurement.internal.zzfz<java.lang.String> r9 = com.google.android.gms.measurement.internal.zzbh.zzr     // Catch:{ all -> 0x0628 }
            r11 = 0
            java.lang.Object r9 = r9.zza(r11)     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0628 }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x0628 }
            android.net.Uri$Builder r11 = r9.buildUpon()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = r9.getAuthority()     // Catch:{ all -> 0x0628 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0628 }
            r12.<init>()     // Catch:{ all -> 0x0628 }
            java.lang.StringBuilder r8 = r12.append(r8)     // Catch:{ all -> 0x0628 }
            java.lang.String r12 = "."
            java.lang.StringBuilder r8 = r8.append(r12)     // Catch:{ all -> 0x0628 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0628 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0628 }
            r11.authority(r8)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznw r8 = new com.google.android.gms.measurement.internal.zznw     // Catch:{ all -> 0x0628 }
            android.net.Uri r9 = r11.build()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznt r11 = com.google.android.gms.measurement.internal.zznt.GOOGLE_SIGNAL     // Catch:{ all -> 0x0628 }
            r8.<init>(r9, r11)     // Catch:{ all -> 0x0628 }
            r11 = 0
            goto L_0x052b
        L_0x051b:
            com.google.android.gms.measurement.internal.zznw r8 = new com.google.android.gms.measurement.internal.zznw     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.String> r9 = com.google.android.gms.measurement.internal.zzbh.zzr     // Catch:{ all -> 0x0628 }
            r11 = 0
            java.lang.Object r9 = r9.zza(r11)     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznt r12 = com.google.android.gms.measurement.internal.zznt.GOOGLE_SIGNAL     // Catch:{ all -> 0x0628 }
            r8.<init>(r9, r12)     // Catch:{ all -> 0x0628 }
        L_0x052b:
            android.util.Pair r0 = android.util.Pair.create(r0, r8)     // Catch:{ all -> 0x0628 }
            r4.add(r0)     // Catch:{ all -> 0x0628 }
            goto L_0x0534
        L_0x0533:
            r11 = 0
        L_0x0534:
            r0 = r7
            goto L_0x0537
        L_0x0536:
            r11 = 0
        L_0x0537:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x0628 }
            r8 = 2
            boolean r7 = r7.zza((int) r8)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x054b
            com.google.android.gms.measurement.internal.zzoo r7 = r1.zzp()     // Catch:{ all -> 0x0628 }
            java.lang.String r9 = r7.zza((com.google.android.gms.internal.measurement.zzfy.zzj) r0)     // Catch:{ all -> 0x0628 }
            goto L_0x054c
        L_0x054b:
            r9 = r11
        L_0x054c:
            r1.zzp()     // Catch:{ all -> 0x0628 }
            byte[] r13 = r0.zzca()     // Catch:{ all -> 0x0628 }
            boolean r7 = com.google.android.gms.internal.measurement.zzpb.zza()     // Catch:{ all -> 0x0628 }
            java.lang.String r8 = "Uploading data. app, uncompressed size, data"
            java.lang.String r11 = "?"
            if (r7 == 0) goto L_0x059f
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzbh.zzcf     // Catch:{ all -> 0x0628 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r12)     // Catch:{ all -> 0x0628 }
            if (r7 == 0) goto L_0x059f
            r1.zza((java.util.List<java.lang.Long>) r10)     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzmw r7 = r1.zzj     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzhb r7 = r7.zze     // Catch:{ all -> 0x0628 }
            r7.zza(r2)     // Catch:{ all -> 0x0628 }
            if (r16 <= 0) goto L_0x057e
            r2 = 0
            com.google.android.gms.internal.measurement.zzfy$zzk r3 = r5.zza((int) r2)     // Catch:{ all -> 0x0628 }
            java.lang.String r11 = r3.zzz()     // Catch:{ all -> 0x0628 }
        L_0x057e:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzp()     // Catch:{ all -> 0x0628 }
            int r3 = r13.length     // Catch:{ all -> 0x0628 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0628 }
            r2.zza(r8, r11, r3, r9)     // Catch:{ all -> 0x0628 }
            r9 = 1
            r1.zzv = r9     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgr r2 = r1.zzh()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zznz r3 = new com.google.android.gms.measurement.internal.zznz     // Catch:{ all -> 0x0628 }
            r3.<init>(r1, r6, r4)     // Catch:{ all -> 0x0628 }
            r2.zza(r6, r15, r0, r3)     // Catch:{ all -> 0x0628 }
            goto L_0x0621
        L_0x059f:
            r1.zza((java.util.List<java.lang.Long>) r10)     // Catch:{ MalformedURLException -> 0x05e5 }
            com.google.android.gms.measurement.internal.zzmw r0 = r1.zzj     // Catch:{ MalformedURLException -> 0x05e5 }
            com.google.android.gms.measurement.internal.zzhb r0 = r0.zze     // Catch:{ MalformedURLException -> 0x05e5 }
            r0.zza(r2)     // Catch:{ MalformedURLException -> 0x05e5 }
            if (r16 <= 0) goto L_0x05b4
            r2 = 0
            com.google.android.gms.internal.measurement.zzfy$zzk r0 = r5.zza((int) r2)     // Catch:{ MalformedURLException -> 0x05e5 }
            java.lang.String r11 = r0.zzz()     // Catch:{ MalformedURLException -> 0x05e5 }
        L_0x05b4:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ MalformedURLException -> 0x05e5 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()     // Catch:{ MalformedURLException -> 0x05e5 }
            int r2 = r13.length     // Catch:{ MalformedURLException -> 0x05e5 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ MalformedURLException -> 0x05e5 }
            r0.zza(r8, r11, r2, r9)     // Catch:{ MalformedURLException -> 0x05e5 }
            r9 = 1
            r1.zzv = r9     // Catch:{ MalformedURLException -> 0x05e5 }
            com.google.android.gms.measurement.internal.zzgr r10 = r1.zzh()     // Catch:{ MalformedURLException -> 0x05e5 }
            java.net.URL r12 = new java.net.URL     // Catch:{ MalformedURLException -> 0x05e5 }
            java.lang.String r0 = r15.zzb()     // Catch:{ MalformedURLException -> 0x05e5 }
            r12.<init>(r0)     // Catch:{ MalformedURLException -> 0x05e5 }
            java.util.Map r14 = r15.zzc()     // Catch:{ MalformedURLException -> 0x05e5 }
            r0 = r15
            com.google.android.gms.measurement.internal.zzoc r15 = new com.google.android.gms.measurement.internal.zzoc     // Catch:{ MalformedURLException -> 0x05e6 }
            r15.<init>(r1, r6, r4)     // Catch:{ MalformedURLException -> 0x05e6 }
            r11 = r6
            r10.zza(r11, r12, r13, r14, r15)     // Catch:{ MalformedURLException -> 0x05e3 }
            goto L_0x0621
        L_0x05e3:
            r6 = r11
            goto L_0x05e6
        L_0x05e5:
            r0 = r15
        L_0x05e6:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0628 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ all -> 0x0628 }
            java.lang.String r0 = r0.zzb()     // Catch:{ all -> 0x0628 }
            r2.zza(r3, r4, r0)     // Catch:{ all -> 0x0628 }
            goto L_0x0621
        L_0x05fc:
            r1.zzab = r10     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0628 }
            r1.zze()     // Catch:{ all -> 0x0628 }
            long r4 = com.google.android.gms.measurement.internal.zzag.zzg()     // Catch:{ all -> 0x0628 }
            long r2 = r2 - r4
            java.lang.String r0 = r0.zza((long) r2)     // Catch:{ all -> 0x0628 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0628 }
            if (r2 != 0) goto L_0x0621
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzf()     // Catch:{ all -> 0x0628 }
            com.google.android.gms.measurement.internal.zzg r0 = r2.zze(r0)     // Catch:{ all -> 0x0628 }
            if (r0 == 0) goto L_0x0621
            r1.zzb((com.google.android.gms.measurement.internal.zzg) r0)     // Catch:{ all -> 0x0628 }
        L_0x0621:
            r2 = 0
            r1.zzw = r2
            r1.zzaa()
            return
        L_0x0628:
            r0 = move-exception
            r2 = 0
        L_0x062a:
            r1.zzw = r2
            r1.zzaa()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zzw():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:47|48|49|50|51|54|55) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0111 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzhv r0 = r11.zzl()
            r0.zzt()
            r11.zzs()
            r0 = 1
            r11.zzw = r0
            r1 = 0
            com.google.android.gms.measurement.internal.zzhy r2 = r11.zzm     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzls r2 = r2.zzr()     // Catch:{ all -> 0x012c }
            java.lang.Boolean r2 = r2.zzab()     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzu()     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "Upload data called on the client side before use of service was decided"
            r12.zza(r0)     // Catch:{ all -> 0x012c }
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x002d:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x0046
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzg()     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "Upload called in the client side when service should be used"
            r12.zza(r0)     // Catch:{ all -> 0x012c }
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x0046:
            long r2 = r11.zzp     // Catch:{ all -> 0x012c }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0057
            r11.zzac()     // Catch:{ all -> 0x012c }
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x0057:
            com.google.android.gms.measurement.internal.zzgr r2 = r11.zzh()     // Catch:{ all -> 0x012c }
            boolean r2 = r2.zzu()     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzp()     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "Network not connected, ignoring upload request"
            r12.zza(r0)     // Catch:{ all -> 0x012c }
            r11.zzac()     // Catch:{ all -> 0x012c }
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x0077:
            com.google.android.gms.measurement.internal.zzal r2 = r11.zzf()     // Catch:{ all -> 0x012c }
            boolean r2 = r2.zzs(r12)     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x0094
            com.google.android.gms.measurement.internal.zzgo r0 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = "Upload queue has no batches for appId"
            r0.zza(r2, r12)     // Catch:{ all -> 0x012c }
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x0094:
            com.google.android.gms.measurement.internal.zzal r2 = r11.zzf()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzoj r2 = r2.zzj(r12)     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x00a4
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x00a4:
            com.google.android.gms.internal.measurement.zzfy$zzj r3 = r2.zzc()     // Catch:{ all -> 0x012c }
            if (r3 != 0) goto L_0x00b0
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzoo r4 = r11.zzp()     // Catch:{ all -> 0x012c }
            java.lang.String r4 = r4.zza((com.google.android.gms.internal.measurement.zzfy.zzj) r3)     // Catch:{ all -> 0x012c }
            byte[] r8 = r3.zzca()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgo r5 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzp()     // Catch:{ all -> 0x012c }
            java.lang.String r6 = "Uploading data from upload queue. appId, uncompressed size, data"
            int r7 = r8.length     // Catch:{ all -> 0x012c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x012c }
            r5.zza(r6, r12, r7, r4)     // Catch:{ all -> 0x012c }
            boolean r4 = com.google.android.gms.internal.measurement.zzpb.zza()     // Catch:{ all -> 0x012c }
            if (r4 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzag r4 = r11.zze()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzcf     // Catch:{ all -> 0x012c }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)     // Catch:{ all -> 0x012c }
            if (r4 == 0) goto L_0x00f3
            r11.zzv = r0     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgr r0 = r11.zzh()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zznw r4 = r2.zzb()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzob r5 = new com.google.android.gms.measurement.internal.zzob     // Catch:{ all -> 0x012c }
            r5.<init>(r11, r12, r2)     // Catch:{ all -> 0x012c }
            r0.zza(r12, r4, r3, r5)     // Catch:{ all -> 0x012c }
            goto L_0x0126
        L_0x00f3:
            r11.zzv = r0     // Catch:{ MalformedURLException -> 0x0110 }
            com.google.android.gms.measurement.internal.zzgr r5 = r11.zzh()     // Catch:{ MalformedURLException -> 0x0110 }
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0110 }
            java.lang.String r0 = r2.zzd()     // Catch:{ MalformedURLException -> 0x0110 }
            r7.<init>(r0)     // Catch:{ MalformedURLException -> 0x0110 }
            java.util.Map r9 = r2.zze()     // Catch:{ MalformedURLException -> 0x0110 }
            com.google.android.gms.measurement.internal.zzoe r10 = new com.google.android.gms.measurement.internal.zzoe     // Catch:{ MalformedURLException -> 0x0110 }
            r10.<init>(r11, r12, r2)     // Catch:{ MalformedURLException -> 0x0110 }
            r6 = r12
            r5.zza(r6, r7, r8, r9, r10)     // Catch:{ MalformedURLException -> 0x0111 }
            goto L_0x0126
        L_0x0110:
            r6 = r12
        L_0x0111:
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzg()     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "Failed to parse URL. Not uploading MeasurementBatch. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r6)     // Catch:{ all -> 0x012c }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x012c }
            r12.zza(r0, r3, r2)     // Catch:{ all -> 0x012c }
        L_0x0126:
            r11.zzw = r1
            r11.zzaa()
            return
        L_0x012c:
            r0 = move-exception
            r12 = r0
            r11.zzw = r1
            r11.zzaa()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zze(java.lang.String):void");
    }

    private final void zza(String str, zzfy.zzh.zza zza2, Bundle bundle, String str2) {
        int i;
        List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzos.zzg(zza2.zzf()) || zzos.zzg(str)) {
            i = zze().zzb(str2, true);
        } else {
            i = zze().zza(str2, true);
        }
        long j = (long) i;
        long codePointCount = (long) zza2.zzg().codePointCount(0, zza2.zzg().length());
        zzq();
        String zzf2 = zza2.zzf();
        zze();
        String zza3 = zzos.zza(zzf2, 40, true);
        if (codePointCount > j && !listOf.contains(zza2.zzf())) {
            if ("_ev".equals(zza2.zzf())) {
                zzq();
                bundle.putString("_ev", zzos.zza(zza2.zzg(), zze().zzb(str2, true), true));
                return;
            }
            zzj().zzv().zza("Param value is too long; discarded. Name, value length", zza3, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", zza3);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(zza2.zzf());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x04e9: MOVE  (r15v5 java.lang.String) = (r38v1 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:155:0x0501 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x039f A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x050d A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0547 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x05b5 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0606 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0613 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0620 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x062d A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x063b A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x064e A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x06a6 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x073a A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x074e A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0794 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x07df A[SYNTHETIC, Splitter:B:269:0x07df] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0800 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0872 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x088b A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x08ed A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0915 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0933 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x09a9 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0a07 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b4 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022d A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0314 A[Catch:{ SQLiteException -> 0x02e3, all -> 0x0a51 }] */
    private final void zzc(com.google.android.gms.measurement.internal.zzbf r38, com.google.android.gms.measurement.internal.zzo r39) {
        /*
            r37 = this;
            r1 = r37
            r0 = r38
            r2 = r39
            java.lang.String r3 = "_fx"
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            java.lang.String r5 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzhv r7 = r1.zzl()
            r7.zzt()
            r1.zzs()
            java.lang.String r9 = r2.zza
            r1.zzp()
            boolean r7 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.measurement.internal.zzbf) r38, (com.google.android.gms.measurement.internal.zzo) r39)
            if (r7 != 0) goto L_0x002d
            goto L_0x00db
        L_0x002d:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x0035
            r1.zza((com.google.android.gms.measurement.internal.zzo) r2)
            return
        L_0x0035:
            com.google.android.gms.measurement.internal.zzhl r7 = r1.zzi()
            java.lang.String r8 = r0.zza
            boolean r7 = r7.zzd(r9, r8)
            java.lang.String r15 = "_err"
            r14 = 0
            r10 = 0
            if (r7 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzhy r4 = r1.zzm
            com.google.android.gms.measurement.internal.zzgh r4 = r4.zzk()
            java.lang.String r5 = r0.zza
            java.lang.String r4 = r4.zza((java.lang.String) r5)
            java.lang.String r5 = "Dropping blocked event. appId"
            r2.zza(r5, r3, r4)
            com.google.android.gms.measurement.internal.zzhl r2 = r1.zzi()
            boolean r2 = r2.zzl(r9)
            if (r2 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzhl r2 = r1.zzi()
            boolean r2 = r2.zzn(r9)
            if (r2 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r2 = r10
            goto L_0x007a
        L_0x0079:
            r2 = 1
        L_0x007a:
            if (r2 != 0) goto L_0x0093
            java.lang.String r3 = r0.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x0093
            r1.zzq()
            com.google.android.gms.measurement.internal.zzor r8 = r1.zzah
            java.lang.String r12 = r0.zza
            r13 = 0
            r10 = 11
            java.lang.String r11 = "_ev"
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)
        L_0x0093:
            if (r2 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r9)
            if (r0 == 0) goto L_0x00db
            long r2 = r0.zzp()
            long r4 = r0.zzg()
            long r2 = java.lang.Math.max(r2, r4)
            com.google.android.gms.common.util.Clock r4 = r1.zzb()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            r1.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Long> r4 = com.google.android.gms.measurement.internal.zzbh.zzaa
            java.lang.Object r4 = r4.zza(r14)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzc()
            java.lang.String r3 = "Fetching config for blocked app"
            r2.zza(r3)
            r1.zzb((com.google.android.gms.measurement.internal.zzg) r0)
        L_0x00db:
            return
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzgs r0 = com.google.android.gms.measurement.internal.zzgs.zza(r0)
            com.google.android.gms.measurement.internal.zzos r7 = r1.zzq()
            com.google.android.gms.measurement.internal.zzag r11 = r1.zze()
            int r11 = r11.zzb(r9)
            r7.zza((com.google.android.gms.measurement.internal.zzgs) r0, (int) r11)
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzbh.zzas
            r12 = 10
            r13 = 35
            int r7 = r7.zza(r9, r11, r12, r13)
            java.util.TreeSet r11 = new java.util.TreeSet
            android.os.Bundle r12 = r0.zzc
            java.util.Set r12 = r12.keySet()
            r11.<init>(r12)
            java.util.Iterator r11 = r11.iterator()
        L_0x010c:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x012e
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "items"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzos r13 = r1.zzq()
            android.os.Bundle r8 = r0.zzc
            android.os.Parcelable[] r8 = r8.getParcelableArray(r12)
            r13.zza((android.os.Parcelable[]) r8, (int) r7)
            goto L_0x010c
        L_0x012e:
            com.google.android.gms.measurement.internal.zzbf r7 = r0.zza()
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            r8 = 2
            boolean r0 = r0.zza((int) r8)
            if (r0 == 0) goto L_0x0154
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            com.google.android.gms.measurement.internal.zzhy r11 = r1.zzm
            com.google.android.gms.measurement.internal.zzgh r11 = r11.zzk()
            java.lang.String r11 = r11.zza((com.google.android.gms.measurement.internal.zzbf) r7)
            java.lang.String r12 = "Logging event"
            r0.zza(r12, r11)
        L_0x0154:
            boolean r0 = com.google.android.gms.internal.measurement.zzow.zza()
            if (r0 == 0) goto L_0x0163
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbh.zzcd
            r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r11)
        L_0x0163:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzp()
            r1.zza((com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = "ecommerce_purchase"
            java.lang.String r11 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "refund"
            if (r0 != 0) goto L_0x018e
            java.lang.String r0 = "purchase"
            java.lang.String r12 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r0 = r0.equals(r12)     // Catch:{ all -> 0x0a51 }
            if (r0 != 0) goto L_0x018e
            java.lang.String r0 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r0 = r11.equals(r0)     // Catch:{ all -> 0x0a51 }
            if (r0 == 0) goto L_0x018c
            goto L_0x018e
        L_0x018c:
            r0 = r10
            goto L_0x018f
        L_0x018e:
            r0 = 1
        L_0x018f:
            java.lang.String r12 = "_iap"
            java.lang.String r13 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0a51 }
            java.lang.String r13 = "value"
            if (r12 != 0) goto L_0x01a8
            if (r0 == 0) goto L_0x019e
            goto L_0x01a8
        L_0x019e:
            r23 = r5
            r19 = r10
            r6 = r13
            r21 = r15
        L_0x01a5:
            r5 = 1
            goto L_0x0348
        L_0x01a8:
            com.google.android.gms.measurement.internal.zzbe r12 = r7.zzb     // Catch:{ all -> 0x0a51 }
            r38 = r8
            java.lang.String r8 = "currency"
            java.lang.String r8 = r12.zzd(r8)     // Catch:{ all -> 0x0a51 }
            if (r0 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzbe r0 = r7.zzb     // Catch:{ all -> 0x0a51 }
            java.lang.Double r0 = r0.zza((java.lang.String) r13)     // Catch:{ all -> 0x0a51 }
            double r17 = r0.doubleValue()     // Catch:{ all -> 0x0a51 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r0 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzbe r0 = r7.zzb     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = r0.zzb(r13)     // Catch:{ all -> 0x0a51 }
            r21 = r15
            long r14 = r0.longValue()     // Catch:{ all -> 0x0a51 }
            double r14 = (double) r14     // Catch:{ all -> 0x0a51 }
            double r17 = r14 * r19
            goto L_0x01dd
        L_0x01db:
            r21 = r15
        L_0x01dd:
            r14 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r0 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x01f7
            r14 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r0 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x01f7
            long r14 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r0 = r11.equals(r0)     // Catch:{ all -> 0x0a51 }
            if (r0 == 0) goto L_0x0227
            long r14 = -r14
            goto L_0x0227
        L_0x01f7:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()     // Catch:{ all -> 0x0a51 }
            java.lang.String r2 = "Data lost. Currency value is too big. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.Double r4 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a51 }
            r0.zza(r2, r3, r4)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r0.zzw()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x021b:
            r21 = r15
            com.google.android.gms.measurement.internal.zzbe r0 = r7.zzb     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = r0.zzb(r13)     // Catch:{ all -> 0x0a51 }
            long r14 = r0.longValue()     // Catch:{ all -> 0x0a51 }
        L_0x0227:
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a51 }
            if (r0 != 0) goto L_0x0341
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = r8.toUpperCase(r0)     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r0.matches(r8)     // Catch:{ all -> 0x0a51 }
            if (r8 == 0) goto L_0x0341
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "_ltv_"
            r8.<init>(r11)     // Catch:{ all -> 0x0a51 }
            java.lang.StringBuilder r0 = r8.append(r0)     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r0 = r0.zze(r9, r11)     // Catch:{ all -> 0x0a51 }
            if (r0 == 0) goto L_0x0287
            java.lang.Object r8 = r0.zze     // Catch:{ all -> 0x0a51 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0a51 }
            if (r8 != 0) goto L_0x025b
            goto L_0x0287
        L_0x025b:
            java.lang.Object r0 = r0.zze     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0a51 }
            long r17 = r0.longValue()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r8 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ all -> 0x0a51 }
            r19 = r10
            java.lang.String r10 = r7.zzc     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.util.Clock r0 = r1.zzb()     // Catch:{ all -> 0x0a51 }
            long r22 = r0.currentTimeMillis()     // Catch:{ all -> 0x0a51 }
            long r17 = r17 + r14
            java.lang.Long r14 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0a51 }
            r15 = r13
            r12 = r22
            r16 = 1
            r23 = r5
            r5 = 0
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0a51 }
            r6 = r15
            r5 = r16
            goto L_0x030a
        L_0x0287:
            r23 = r5
            r19 = r10
            r6 = r13
            r5 = 0
            r16 = 1
            com.google.android.gms.measurement.internal.zzal r8 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r0 = r1.zze()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzbh.zzag     // Catch:{ all -> 0x0a51 }
            int r0 = r0.zzb((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r10)     // Catch:{ all -> 0x0a51 }
            int r0 = r0 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x0a51 }
            r8.zzt()     // Catch:{ all -> 0x0a51 }
            r8.zzal()     // Catch:{ all -> 0x0a51 }
            android.database.sqlite.SQLiteDatabase r10 = r8.e_()     // Catch:{ SQLiteException -> 0x02e3 }
            com.google.android.gms.measurement.internal.zzag r12 = r8.zze()     // Catch:{ SQLiteException -> 0x02e3 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzbh.zzdl     // Catch:{ SQLiteException -> 0x02e3 }
            boolean r12 = r12.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r13)     // Catch:{ SQLiteException -> 0x02e3 }
            if (r12 == 0) goto L_0x02bb
            java.lang.String r12 = "and name like '!_ltv!_%' escape '!'"
            goto L_0x02bd
        L_0x02bb:
            java.lang.String r12 = "and name like '_ltv_%' "
        L_0x02bd:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x02e3 }
            java.lang.String r5 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? "
            r13.<init>(r5)     // Catch:{ SQLiteException -> 0x02e3 }
            java.lang.StringBuilder r5 = r13.append(r12)     // Catch:{ SQLiteException -> 0x02e3 }
            java.lang.String r12 = "order by set_timestamp desc limit ?,10);"
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ SQLiteException -> 0x02e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x02e3 }
            r12 = 3
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x02e3 }
            r12[r19] = r9     // Catch:{ SQLiteException -> 0x02e3 }
            r12[r16] = r9     // Catch:{ SQLiteException -> 0x02e3 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x02e3 }
            r12[r38] = r0     // Catch:{ SQLiteException -> 0x02e3 }
            r10.execSQL(r5, r12)     // Catch:{ SQLiteException -> 0x02e3 }
            goto L_0x02f5
        L_0x02e3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r5 = r8.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            r5.zza(r8, r10, r0)     // Catch:{ all -> 0x0a51 }
        L_0x02f5:
            com.google.android.gms.measurement.internal.zzop r8 = new com.google.android.gms.measurement.internal.zzop     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r7.zzc     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.util.Clock r0 = r1.zzb()     // Catch:{ all -> 0x0a51 }
            long r12 = r0.currentTimeMillis()     // Catch:{ all -> 0x0a51 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0a51 }
            r5 = r16
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0a51 }
        L_0x030a:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzop) r8)     // Catch:{ all -> 0x0a51 }
            if (r0 != 0) goto L_0x0348
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r12 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgh r12 = r12.zzk()     // Catch:{ all -> 0x0a51 }
            java.lang.String r13 = r8.zzc     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r12.zzc(r13)     // Catch:{ all -> 0x0a51 }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a51 }
            r0.zza(r10, r11, r12, r8)     // Catch:{ all -> 0x0a51 }
            r1.zzq()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzor r8 = r1.zzah     // Catch:{ all -> 0x0a51 }
            r12 = 0
            r13 = 0
            r10 = 9
            r11 = 0
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x0a51 }
            goto L_0x0348
        L_0x0341:
            r23 = r5
            r19 = r10
            r6 = r13
            goto L_0x01a5
        L_0x0348:
            java.lang.String r0 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r15 = com.google.android.gms.measurement.internal.zzos.zzh(r0)     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = r7.zza     // Catch:{ all -> 0x0a51 }
            r8 = r21
            boolean r17 = r8.equals(r0)     // Catch:{ all -> 0x0a51 }
            r1.zzq()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzbe r0 = r7.zzb     // Catch:{ all -> 0x0a51 }
            long r10 = com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzbe) r0)     // Catch:{ all -> 0x0a51 }
            r12 = 1
            long r10 = r10 + r12
            com.google.android.gms.measurement.internal.zzal r8 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r20 = r12
            r12 = r10
            r11 = r9
            long r9 = r1.zzx()     // Catch:{ all -> 0x0a51 }
            r14 = r19
            r19 = 0
            r21 = r20
            r20 = 0
            r16 = r14
            r14 = 1
            r18 = r16
            r16 = 0
            r26 = r18
            r18 = 0
            r38 = r6
            r28 = r21
            r5 = r26
            com.google.android.gms.measurement.internal.zzaq r0 = r8.zza(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0a51 }
            r9 = r11
            r6 = r15
            long r10 = r0.zzb     // Catch:{ all -> 0x0a51 }
            r1.zze()     // Catch:{ all -> 0x0a51 }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzh()     // Catch:{ all -> 0x0a51 }
            long r10 = r10 - r12
            r12 = 0
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r14 = 1000(0x3e8, double:4.94E-321)
            if (r8 <= 0) goto L_0x03ca
            long r10 = r10 % r14
            int r2 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r2 != 0) goto L_0x03bb
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            long r5 = r0.zzb     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a51 }
            r2.zza(r3, r4, r0)     // Catch:{ all -> 0x0a51 }
        L_0x03bb:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r0.zzw()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x03ca:
            if (r6 == 0) goto L_0x0420
            long r10 = r0.zza     // Catch:{ all -> 0x0a51 }
            r1.zze()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzbh.zzm     // Catch:{ all -> 0x0a51 }
            r18 = r12
            r12 = 0
            java.lang.Object r8 = r8.zza(r12)     // Catch:{ all -> 0x0a51 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0a51 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0a51 }
            long r12 = (long) r8     // Catch:{ all -> 0x0a51 }
            long r10 = r10 - r12
            int r8 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r8 <= 0) goto L_0x0422
            long r10 = r10 % r14
            int r2 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r2 != 0) goto L_0x0402
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            long r5 = r0.zza     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a51 }
            r2.zza(r3, r4, r0)     // Catch:{ all -> 0x0a51 }
        L_0x0402:
            r1.zzq()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzor r8 = r1.zzah     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "_ev"
            java.lang.String r12 = r7.zza     // Catch:{ all -> 0x0a51 }
            r13 = 0
            r10 = 16
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r0.zzw()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x0420:
            r18 = r12
        L_0x0422:
            if (r17 == 0) goto L_0x046d
            long r10 = r0.zzd     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r8 = r1.zze()     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzbh.zzl     // Catch:{ all -> 0x0a51 }
            int r8 = r8.zzb((java.lang.String) r12, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r13)     // Catch:{ all -> 0x0a51 }
            r12 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r12, r8)     // Catch:{ all -> 0x0a51 }
            int r8 = java.lang.Math.max(r5, r8)     // Catch:{ all -> 0x0a51 }
            long r12 = (long) r8     // Catch:{ all -> 0x0a51 }
            long r10 = r10 - r12
            int r8 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r8 <= 0) goto L_0x046d
            int r2 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r2 != 0) goto L_0x045e
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            long r5 = r0.zzd     // Catch:{ all -> 0x0a51 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a51 }
            r2.zza(r3, r4, r0)     // Catch:{ all -> 0x0a51 }
        L_0x045e:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r0.zzw()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x046d:
            com.google.android.gms.measurement.internal.zzbe r0 = r7.zzb     // Catch:{ all -> 0x0a51 }
            android.os.Bundle r0 = r0.zzb()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzos r8 = r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = "_o"
            java.lang.String r11 = r7.zzc     // Catch:{ all -> 0x0a51 }
            r8.zza((android.os.Bundle) r0, (java.lang.String) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzos r8 = r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzac     // Catch:{ all -> 0x0a51 }
            boolean r8 = r8.zzd(r9, r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = "_r"
            if (r8 == 0) goto L_0x04a4
            com.google.android.gms.measurement.internal.zzos r8 = r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "_dbg"
            java.lang.Long r12 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x0a51 }
            r8.zza((android.os.Bundle) r0, (java.lang.String) r11, (java.lang.Object) r12)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzos r8 = r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.Long r11 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x0a51 }
            r8.zza((android.os.Bundle) r0, (java.lang.String) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0a51 }
        L_0x04a4:
            java.lang.String r8 = "_s"
            java.lang.String r11 = r7.zza     // Catch:{ all -> 0x0a51 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a51 }
            if (r8 == 0) goto L_0x04c9
            com.google.android.gms.measurement.internal.zzal r8 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r8 = r8.zze(r11, r4)     // Catch:{ all -> 0x0a51 }
            if (r8 == 0) goto L_0x04c9
            java.lang.Object r11 = r8.zze     // Catch:{ all -> 0x0a51 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a51 }
            if (r11 == 0) goto L_0x04c9
            com.google.android.gms.measurement.internal.zzos r11 = r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a51 }
            r11.zza((android.os.Bundle) r0, (java.lang.String) r4, (java.lang.Object) r8)     // Catch:{ all -> 0x0a51 }
        L_0x04c9:
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbh.zzdj     // Catch:{ all -> 0x0a51 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0a51 }
            if (r4 == 0) goto L_0x0501
            java.lang.String r4 = r7.zzc     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = "am"
            boolean r4 = java.util.Objects.equals(r4, r8)     // Catch:{ all -> 0x0a51 }
            if (r4 == 0) goto L_0x0501
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = "_ai"
            boolean r4 = java.util.Objects.equals(r4, r8)     // Catch:{ all -> 0x0a51 }
            if (r4 == 0) goto L_0x0501
            r15 = r38
            java.lang.Object r4 = r0.get(r15)     // Catch:{ all -> 0x0a51 }
            if (r4 == 0) goto L_0x0501
            boolean r8 = r4 instanceof java.lang.String     // Catch:{ all -> 0x0a51 }
            if (r8 == 0) goto L_0x0501
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ NumberFormatException -> 0x0501 }
            double r11 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException -> 0x0501 }
            r0.remove(r15)     // Catch:{ NumberFormatException -> 0x0501 }
            r0.putDouble(r15, r11)     // Catch:{ NumberFormatException -> 0x0501 }
        L_0x0501:
            com.google.android.gms.measurement.internal.zzal r4 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            long r11 = r4.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            int r4 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r4 <= 0) goto L_0x0522
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzu()     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a51 }
            r4.zza(r8, r13, r11)     // Catch:{ all -> 0x0a51 }
        L_0x0522:
            com.google.android.gms.measurement.internal.zzbc r8 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x0a51 }
            r11 = r9
            com.google.android.gms.measurement.internal.zzhy r9 = r1.zzm     // Catch:{ all -> 0x0a51 }
            r4 = r10
            java.lang.String r10 = r7.zzc     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r7.zza     // Catch:{ all -> 0x0a51 }
            long r13 = r7.zzd     // Catch:{ all -> 0x0a51 }
            r15 = 0
            r17 = r0
            r38 = r6
            r5 = r18
            r8.<init>((com.google.android.gms.measurement.internal.zzhy) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (long) r13, (long) r15, (android.os.Bundle) r17)     // Catch:{ all -> 0x0a51 }
            r0 = r8
            r9 = r11
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = r0.zzb     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzbb r7 = r7.zzd(r9, r8)     // Catch:{ all -> 0x0a51 }
            if (r7 != 0) goto L_0x05b5
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            long r7 = r7.zzc(r9)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x0a51 }
            int r10 = r10.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            long r10 = (long) r10     // Catch:{ all -> 0x0a51 }
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x059c
            if (r38 == 0) goto L_0x059c
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r5 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgh r5 = r5.zzk()     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x0a51 }
            java.lang.String r0 = r5.zza((java.lang.String) r0)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r5 = r1.zze()     // Catch:{ all -> 0x0a51 }
            int r5 = r5.zza((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0a51 }
            r2.zza(r3, r4, r0, r5)     // Catch:{ all -> 0x0a51 }
            r1.zzq()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzor r8 = r1.zzah     // Catch:{ all -> 0x0a51 }
            r12 = 0
            r13 = 0
            r10 = 8
            r11 = 0
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            return
        L_0x059c:
            com.google.android.gms.measurement.internal.zzbb r8 = new com.google.android.gms.measurement.internal.zzbb     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r0.zzb     // Catch:{ all -> 0x0a51 }
            long r11 = r0.zzd     // Catch:{ all -> 0x0a51 }
            r21 = 0
            r22 = 0
            r15 = r11
            r11 = 0
            r13 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)     // Catch:{ all -> 0x0a51 }
            goto L_0x05c8
        L_0x05b5:
            com.google.android.gms.measurement.internal.zzhy r8 = r1.zzm     // Catch:{ all -> 0x0a51 }
            long r9 = r7.zzf     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzbc r8 = r0.zza(r8, r9)     // Catch:{ all -> 0x0a51 }
            long r9 = r8.zzd     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzbb r0 = r7.zza(r9)     // Catch:{ all -> 0x0a51 }
            r36 = r8
            r8 = r0
            r0 = r36
        L_0x05c8:
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r7.zza((com.google.android.gms.measurement.internal.zzbb) r8)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhv r7 = r1.zzl()     // Catch:{ all -> 0x0a51 }
            r7.zzt()     // Catch:{ all -> 0x0a51 }
            r1.zzs()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0a51 }
            java.lang.String r7 = r0.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x0a51 }
            java.lang.String r7 = r0.zza     // Catch:{ all -> 0x0a51 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a51 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r7 = com.google.android.gms.internal.measurement.zzfy.zzk.zzw()     // Catch:{ all -> 0x0a51 }
            r8 = 1
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r7 = r7.zzh((int) r8)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = "android"
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r7 = r7.zzp(r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x060b
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a51 }
            r7.zzb((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
        L_0x060b:
            java.lang.String r9 = r2.zzd     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x0618
            java.lang.String r9 = r2.zzd     // Catch:{ all -> 0x0a51 }
            r7.zzd((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0618:
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x0625
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a51 }
            r7.zze((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0625:
            java.lang.String r9 = r2.zzv     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x0632
            java.lang.String r9 = r2.zzv     // Catch:{ all -> 0x0a51 }
            r7.zzr(r9)     // Catch:{ all -> 0x0a51 }
        L_0x0632:
            long r9 = r2.zzj     // Catch:{ all -> 0x0a51 }
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0641
            long r9 = r2.zzj     // Catch:{ all -> 0x0a51 }
            int r9 = (int) r9     // Catch:{ all -> 0x0a51 }
            r7.zze((int) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0641:
            long r9 = r2.zze     // Catch:{ all -> 0x0a51 }
            r7.zzf((long) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = r2.zzb     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x0653
            java.lang.String r9 = r2.zzb     // Catch:{ all -> 0x0a51 }
            r7.zzm(r9)     // Catch:{ all -> 0x0a51 }
        L_0x0653:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a51 }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r9 = r1.zzb((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzt     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r10 = com.google.android.gms.measurement.internal.zzje.zzb((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r9 = r9.zza((com.google.android.gms.measurement.internal.zzje) r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r9.zze()     // Catch:{ all -> 0x0a51 }
            r7.zzg((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r7.zzx()     // Catch:{ all -> 0x0a51 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x0687
            java.lang.String r10 = r2.zzp     // Catch:{ all -> 0x0a51 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a51 }
            if (r10 != 0) goto L_0x0687
            java.lang.String r10 = r2.zzp     // Catch:{ all -> 0x0a51 }
            r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
        L_0x0687:
            boolean r10 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x0734
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzbh.zzch     // Catch:{ all -> 0x0a51 }
            boolean r10 = r10.zze(r11, r12)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x0734
            r1.zzq()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0a51 }
            boolean r10 = com.google.android.gms.measurement.internal.zzos.zzd(r10)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x0734
            int r10 = r2.zzaa     // Catch:{ all -> 0x0a51 }
            r7.zzd((int) r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zzab     // Catch:{ all -> 0x0a51 }
            boolean r9 = r9.zzg()     // Catch:{ all -> 0x0a51 }
            r12 = 32
            if (r9 != 0) goto L_0x06bf
            int r9 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x06bf
            r14 = -2
            long r9 = r10 & r14
            long r10 = r9 | r12
        L_0x06bf:
            int r9 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r9 != 0) goto L_0x06c5
            r9 = r8
            goto L_0x06c6
        L_0x06c5:
            r9 = 0
        L_0x06c6:
            r7.zza((boolean) r9)     // Catch:{ all -> 0x0a51 }
            int r9 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0734
            com.google.android.gms.internal.measurement.zzfy$zzc$zza r9 = com.google.android.gms.internal.measurement.zzfy.zzc.zza()     // Catch:{ all -> 0x0a51 }
            long r14 = r10 & r28
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x06d9
            r14 = r8
            goto L_0x06da
        L_0x06d9:
            r14 = 0
        L_0x06da:
            r9.zzc(r14)     // Catch:{ all -> 0x0a51 }
            r14 = 2
            long r14 = r14 & r10
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x06e6
            r14 = r8
            goto L_0x06e7
        L_0x06e6:
            r14 = 0
        L_0x06e7:
            r9.zze(r14)     // Catch:{ all -> 0x0a51 }
            r14 = 4
            long r14 = r14 & r10
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x06f3
            r14 = r8
            goto L_0x06f4
        L_0x06f3:
            r14 = 0
        L_0x06f4:
            r9.zzf(r14)     // Catch:{ all -> 0x0a51 }
            r14 = 8
            long r14 = r14 & r10
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x0700
            r14 = r8
            goto L_0x0701
        L_0x0700:
            r14 = 0
        L_0x0701:
            r9.zzg(r14)     // Catch:{ all -> 0x0a51 }
            r14 = 16
            long r14 = r14 & r10
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x070d
            r14 = r8
            goto L_0x070e
        L_0x070d:
            r14 = 0
        L_0x070e:
            r9.zzb(r14)     // Catch:{ all -> 0x0a51 }
            long r12 = r12 & r10
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 == 0) goto L_0x0718
            r12 = r8
            goto L_0x0719
        L_0x0718:
            r12 = 0
        L_0x0719:
            r9.zza(r12)     // Catch:{ all -> 0x0a51 }
            r12 = 64
            long r10 = r10 & r12
            int r10 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0725
            r10 = r8
            goto L_0x0726
        L_0x0725:
            r10 = 0
        L_0x0726:
            r9.zzd(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzlc r9 = r9.zzai()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzjt r9 = (com.google.android.gms.internal.measurement.zzjt) r9     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzc r9 = (com.google.android.gms.internal.measurement.zzfy.zzc) r9     // Catch:{ all -> 0x0a51 }
            r7.zza((com.google.android.gms.internal.measurement.zzfy.zzc) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0734:
            long r9 = r2.zzf     // Catch:{ all -> 0x0a51 }
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x073f
            long r9 = r2.zzf     // Catch:{ all -> 0x0a51 }
            r7.zzc((long) r9)     // Catch:{ all -> 0x0a51 }
        L_0x073f:
            long r9 = r2.zzr     // Catch:{ all -> 0x0a51 }
            r7.zzd((long) r9)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzoo r9 = r1.zzp()     // Catch:{ all -> 0x0a51 }
            java.util.List r9 = r9.zzu()     // Catch:{ all -> 0x0a51 }
            if (r9 == 0) goto L_0x0751
            r7.zzc((java.lang.Iterable<? extends java.lang.Integer>) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0751:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a51 }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r9 = r1.zzb((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzt     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r10 = com.google.android.gms.measurement.internal.zzje.zzb((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzje r9 = r9.zza((com.google.android.gms.measurement.internal.zzje) r10)     // Catch:{ all -> 0x0a51 }
            boolean r10 = r9.zzg()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x082b
            boolean r10 = r2.zzn     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x082b
            com.google.android.gms.measurement.internal.zzmw r10 = r1.zzj     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            android.util.Pair r10 = r10.zza((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzje) r9)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x082b
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x0a51 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x0a51 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a51 }
            if (r11 != 0) goto L_0x082b
            boolean r11 = r2.zzn     // Catch:{ all -> 0x0a51 }
            if (r11 == 0) goto L_0x082b
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0a51 }
            r7.zzq(r11)     // Catch:{ all -> 0x0a51 }
            java.lang.Object r11 = r10.second     // Catch:{ all -> 0x0a51 }
            if (r11 == 0) goto L_0x079f
            java.lang.Object r11 = r10.second     // Catch:{ all -> 0x0a51 }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0a51 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0a51 }
            r7.zzc((boolean) r11)     // Catch:{ all -> 0x0a51 }
        L_0x079f:
            java.lang.String r11 = r0.zzb     // Catch:{ all -> 0x0a51 }
            boolean r11 = r11.equals(r3)     // Catch:{ all -> 0x0a51 }
            if (r11 != 0) goto L_0x082b
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "00000000-0000-0000-0000-000000000000"
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x0a51 }
            if (r10 != 0) goto L_0x082b
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzg r10 = r10.zze(r11)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x082b
            boolean r11 = r10.zzau()     // Catch:{ all -> 0x0a51 }
            if (r11 == 0) goto L_0x082b
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            r12 = 0
            r14 = 0
            r1.zza((java.lang.String) r11, (boolean) r14, (java.lang.Long) r12, (java.lang.Long) r12)     // Catch:{ all -> 0x0a51 }
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x0a51 }
            r11.<init>()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r12 = r1.zze()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzbh.zzcw     // Catch:{ all -> 0x0a51 }
            boolean r12 = r12.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r13)     // Catch:{ all -> 0x0a51 }
            java.lang.String r13 = "_pfo"
            if (r12 == 0) goto L_0x0800
            java.lang.Long r12 = r10.zzy()     // Catch:{ all -> 0x0a51 }
            if (r12 == 0) goto L_0x07f0
            long r14 = r12.longValue()     // Catch:{ all -> 0x0a51 }
            long r14 = java.lang.Math.max(r5, r14)     // Catch:{ all -> 0x0a51 }
            r11.putLong(r13, r14)     // Catch:{ all -> 0x0a51 }
        L_0x07f0:
            java.lang.Long r10 = r10.zzz()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x081f
            java.lang.String r12 = "_uwa"
            long r13 = r10.longValue()     // Catch:{ all -> 0x0a51 }
            r11.putLong(r12, r13)     // Catch:{ all -> 0x0a51 }
            goto L_0x081f
        L_0x0800:
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzbh.zzcv     // Catch:{ all -> 0x0a51 }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r12)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x081f
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a51 }
            long r14 = r10.zzb(r12)     // Catch:{ all -> 0x0a51 }
            long r14 = r14 - r28
            long r14 = java.lang.Math.max(r5, r14)     // Catch:{ all -> 0x0a51 }
            r11.putLong(r13, r14)     // Catch:{ all -> 0x0a51 }
        L_0x081f:
            r12 = r28
            r11.putLong(r4, r12)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzor r10 = r1.zzah     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a51 }
            r10.zza(r12, r3, r11)     // Catch:{ all -> 0x0a51 }
        L_0x082b:
            com.google.android.gms.measurement.internal.zzhy r3 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzaz r3 = r3.zzg()     // Catch:{ all -> 0x0a51 }
            r3.zzac()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r3 = r7.zzi((java.lang.String) r3)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r10 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzaz r10 = r10.zzg()     // Catch:{ all -> 0x0a51 }
            r10.zzac()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r3 = r3.zzo(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r10 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzaz r10 = r10.zzg()     // Catch:{ all -> 0x0a51 }
            long r10 = r10.zzc()     // Catch:{ all -> 0x0a51 }
            int r10 = (int) r10     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r3 = r3.zzj((int) r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r10 = r1.zzm     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzaz r10 = r10.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r10.zzg()     // Catch:{ all -> 0x0a51 }
            r3.zzs(r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zzx     // Catch:{ all -> 0x0a51 }
            r7.zzj((long) r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r3 = r1.zzm     // Catch:{ all -> 0x0a51 }
            boolean r3 = r3.zzac()     // Catch:{ all -> 0x0a51 }
            if (r3 == 0) goto L_0x087f
            r7.zzt()     // Catch:{ all -> 0x0a51 }
            r12 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0a51 }
            if (r3 != 0) goto L_0x087f
            r7.zzj((java.lang.String) r12)     // Catch:{ all -> 0x0a51 }
        L_0x087f:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zze(r10)     // Catch:{ all -> 0x0a51 }
            if (r3 != 0) goto L_0x08ed
            com.google.android.gms.measurement.internal.zzg r3 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzhy r10 = r1.zzm     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            r3.<init>(r10, r11)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r1.zza((com.google.android.gms.measurement.internal.zzje) r9)     // Catch:{ all -> 0x0a51 }
            r3.zzb((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzk     // Catch:{ all -> 0x0a51 }
            r3.zze((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzb     // Catch:{ all -> 0x0a51 }
            r3.zzf((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            boolean r10 = r9.zzg()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x08b8
            com.google.android.gms.measurement.internal.zzmw r10 = r1.zzj     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a51 }
            boolean r12 = r2.zzn     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r10.zza((java.lang.String) r11, (boolean) r12)     // Catch:{ all -> 0x0a51 }
            r3.zzh((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
        L_0x08b8:
            r3.zzq(r5)     // Catch:{ all -> 0x0a51 }
            r3.zzr(r5)     // Catch:{ all -> 0x0a51 }
            r3.zzp(r5)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzc     // Catch:{ all -> 0x0a51 }
            r3.zzd((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zzj     // Catch:{ all -> 0x0a51 }
            r3.zzb((long) r10)     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zzd     // Catch:{ all -> 0x0a51 }
            r3.zzc((java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zze     // Catch:{ all -> 0x0a51 }
            r3.zzn(r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zzf     // Catch:{ all -> 0x0a51 }
            r3.zzk((long) r10)     // Catch:{ all -> 0x0a51 }
            boolean r10 = r2.zzh     // Catch:{ all -> 0x0a51 }
            r3.zzb((boolean) r10)     // Catch:{ all -> 0x0a51 }
            long r10 = r2.zzr     // Catch:{ all -> 0x0a51 }
            r3.zzl(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r14 = 0
            r10.zza((com.google.android.gms.measurement.internal.zzg) r3, (boolean) r14, (boolean) r14)     // Catch:{ all -> 0x0a51 }
            goto L_0x08ee
        L_0x08ed:
            r14 = 0
        L_0x08ee:
            boolean r9 = r9.zzh()     // Catch:{ all -> 0x0a51 }
            if (r9 == 0) goto L_0x090b
            java.lang.String r9 = r3.zzad()     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x090b
            java.lang.String r9 = r3.zzad()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a51 }
            r7.zzc((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
        L_0x090b:
            java.lang.String r9 = r3.zzag()     // Catch:{ all -> 0x0a51 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a51 }
            if (r9 != 0) goto L_0x0922
            java.lang.String r9 = r3.zzag()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a51 }
            r7.zzl((java.lang.String) r9)     // Catch:{ all -> 0x0a51 }
        L_0x0922:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0a51 }
            java.util.List r9 = r9.zzl(r10)     // Catch:{ all -> 0x0a51 }
            r10 = r14
        L_0x092d:
            int r11 = r9.size()     // Catch:{ all -> 0x0a51 }
            if (r10 >= r11) goto L_0x0991
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = com.google.android.gms.internal.measurement.zzfy.zzo.zze()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x0a51 }
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x0a51 }
            long r12 = r12.zzd     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.internal.measurement.zzfy$zzo$zza r11 = r11.zzb((long) r12)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzoo r12 = r1.zzp()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r13 = r9.get(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r13 = (com.google.android.gms.measurement.internal.zzop) r13     // Catch:{ all -> 0x0a51 }
            java.lang.Object r13 = r13.zze     // Catch:{ all -> 0x0a51 }
            r12.zza((com.google.android.gms.internal.measurement.zzfy.zzo.zza) r11, (java.lang.Object) r13)     // Catch:{ all -> 0x0a51 }
            r7.zza((com.google.android.gms.internal.measurement.zzfy.zzo.zza) r11)     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = "_sid"
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzop r12 = (com.google.android.gms.measurement.internal.zzop) r12     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x0a51 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a51 }
            if (r11 == 0) goto L_0x098e
            long r11 = r3.zzv()     // Catch:{ all -> 0x0a51 }
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 == 0) goto L_0x098e
            com.google.android.gms.measurement.internal.zzoo r11 = r1.zzp()     // Catch:{ all -> 0x0a51 }
            java.lang.String r12 = r2.zzv     // Catch:{ all -> 0x0a51 }
            long r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x0a51 }
            long r15 = r3.zzv()     // Catch:{ all -> 0x0a51 }
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x098e
            r7.zzr()     // Catch:{ all -> 0x0a51 }
        L_0x098e:
            int r10 = r10 + 1
            goto L_0x092d
        L_0x0991:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzf()     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.zzlc r3 = r7.zzai()     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.zzjt r3 = (com.google.android.gms.internal.measurement.zzjt) r3     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.zzfy$zzk r3 = (com.google.android.gms.internal.measurement.zzfy.zzk) r3     // Catch:{ IOException -> 0x0a0a }
            long r2 = r2.zza((com.google.android.gms.internal.measurement.zzfy.zzk) r3)     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzbe r9 = r0.zzf     // Catch:{ all -> 0x0a51 }
            if (r9 == 0) goto L_0x0a00
            com.google.android.gms.measurement.internal.zzbe r9 = r0.zzf     // Catch:{ all -> 0x0a51 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a51 }
        L_0x09af:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x09c2
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a51 }
            boolean r10 = r4.equals(r10)     // Catch:{ all -> 0x0a51 }
            if (r10 == 0) goto L_0x09af
            goto L_0x0a01
        L_0x09c2:
            com.google.android.gms.measurement.internal.zzhl r4 = r1.zzi()     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = r0.zza     // Catch:{ all -> 0x0a51 }
            java.lang.String r10 = r0.zzb     // Catch:{ all -> 0x0a51 }
            boolean r4 = r4.zzc((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r25 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            long r26 = r1.zzx()     // Catch:{ all -> 0x0a51 }
            java.lang.String r9 = r0.zza     // Catch:{ all -> 0x0a51 }
            r34 = 0
            r35 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r28 = r9
            com.google.android.gms.measurement.internal.zzaq r9 = r25.zza(r26, r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x0a51 }
            if (r4 == 0) goto L_0x0a00
            long r9 = r9.zze     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzag r4 = r1.zze()     // Catch:{ all -> 0x0a51 }
            java.lang.String r11 = r0.zza     // Catch:{ all -> 0x0a51 }
            int r4 = r4.zzc(r11)     // Catch:{ all -> 0x0a51 }
            long r11 = (long) r4     // Catch:{ all -> 0x0a51 }
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a00
            goto L_0x0a01
        L_0x0a00:
            r8 = r14
        L_0x0a01:
            boolean r0 = r7.zza((com.google.android.gms.measurement.internal.zzbc) r0, (long) r2, (boolean) r8)     // Catch:{ all -> 0x0a51 }
            if (r0 == 0) goto L_0x0a20
            r1.zzp = r5     // Catch:{ all -> 0x0a51 }
            goto L_0x0a20
        L_0x0a0a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x0a51 }
            java.lang.String r3 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r7.zzt()     // Catch:{ all -> 0x0a51 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r4)     // Catch:{ all -> 0x0a51 }
            r2.zza(r3, r4, r0)     // Catch:{ all -> 0x0a51 }
        L_0x0a20:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()     // Catch:{ all -> 0x0a51 }
            r0.zzw()     // Catch:{ all -> 0x0a51 }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzu()
            r1.zzac()
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r23
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r0.zza(r3, r2)
            return
        L_0x0a51:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzf()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zzc(com.google.android.gms.measurement.internal.zzbf, com.google.android.gms.measurement.internal.zzo):void");
    }

    private static boolean zzi(zzo zzo2) {
        return !TextUtils.isEmpty(zzo2.zzb) || !TextUtils.isEmpty(zzo2.zzp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0218, code lost:
        if (r5 == null) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x023e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x023f, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0242, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0243, code lost:
        r24 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01fa, code lost:
        if (r5 == null) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x023e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x025b A[SYNTHETIC, Splitter:B:120:0x025b] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0262 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03fa A[SYNTHETIC, Splitter:B:176:0x03fa] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x049f A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0501 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0505 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x056b A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x05a7 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x05c6 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x06b0 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x06f1 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x074d A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0864 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x10df A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:570:0x10e3 A[Catch:{ IOException -> 0x0222, all -> 0x1208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:610:0x1204 A[SYNTHETIC, Splitter:B:610:0x1204] */
    /* JADX WARNING: Removed duplicated region for block: B:624:0x0464 A[EDGE_INSN: B:624:0x0464->B:185:0x0464 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r47, long r48) {
        /*
            r46 = this;
            r1 = r46
            java.lang.String r2 = "_ai"
            java.lang.String r3 = "items"
            com.google.android.gms.measurement.internal.zzal r0 = r1.zzf()
            r0.zzp()
            com.google.android.gms.measurement.internal.zznv$zza r4 = new com.google.android.gms.measurement.internal.zznv$zza     // Catch:{ all -> 0x1208 }
            r5 = 0
            r4.<init>()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r6 = r1.zzf()     // Catch:{ all -> 0x1208 }
            long r7 = r1.zzab     // Catch:{ all -> 0x1208 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x1208 }
            r6.zzt()     // Catch:{ all -> 0x1208 }
            r6.zzal()     // Catch:{ all -> 0x1208 }
            r9 = 3
            r10 = -1
            r12 = 2
            r13 = 1
            r14 = 0
            android.database.sqlite.SQLiteDatabase r15 = r6.e_()     // Catch:{ SQLiteException -> 0x0242, all -> 0x023e }
            boolean r0 = android.text.TextUtils.isEmpty(r47)     // Catch:{ SQLiteException -> 0x0242, all -> 0x023e }
            java.lang.String r16 = ""
            if (r0 == 0) goto L_0x0090
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x004e
            r24 = r10
            java.lang.String[] r10 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0049 }
            java.lang.String r11 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0049 }
            r10[r14] = r11     // Catch:{ SQLiteException -> 0x0049 }
            java.lang.String r11 = java.lang.String.valueOf(r48)     // Catch:{ SQLiteException -> 0x0049 }
            r10[r13] = r11     // Catch:{ SQLiteException -> 0x0049 }
            goto L_0x0058
        L_0x0049:
            r0 = move-exception
            r10 = r47
            goto L_0x0248
        L_0x004e:
            r24 = r10
            java.lang.String[] r10 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r11 = java.lang.String.valueOf(r48)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            r10[r14] = r11     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
        L_0x0058:
            if (r0 == 0) goto L_0x005c
            java.lang.String r16 = "rowid <= ? and "
        L_0x005c:
            r0 = r16
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r11.<init>(r5)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.StringBuilder r0 = r11.append(r0)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            android.database.Cursor r5 = r15.rawQuery(r0, r10)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0049 }
            if (r0 != 0) goto L_0x0084
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x0084:
            java.lang.String r10 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x0049 }
            java.lang.String r0 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x023a }
            r5.close()     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x00da
        L_0x0090:
            r24 = r10
            int r0 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x00a1
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            r5[r14] = r47     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            r5[r13] = r10     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            goto L_0x00a5
        L_0x00a1:
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            r5[r14] = r47     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
        L_0x00a5:
            if (r0 == 0) goto L_0x00a9
            java.lang.String r16 = " and rowid <= ?"
        L_0x00a9:
            r0 = r16
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r11 = "select metadata_fingerprint from raw_events where app_id = ?"
            r10.<init>(r11)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.StringBuilder r0 = r10.append(r0)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r10 = " order by rowid limit 1;"
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            android.database.Cursor r5 = r15.rawQuery(r0, r5)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023e }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0049 }
            if (r0 != 0) goto L_0x00d1
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x00d1:
            java.lang.String r0 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x0049 }
            r5.close()     // Catch:{ SQLiteException -> 0x0049 }
            r10 = r47
        L_0x00da:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String[] r11 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r17 = "metadata"
            r11[r14] = r17     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r26 = r13
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x023a }
            r13[r14] = r10     // Catch:{ SQLiteException -> 0x023a }
            r13[r26] = r0     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r20 = 0
            r21 = 0
            r17 = r11
            r19 = r13
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x023a }
            boolean r11 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023a }
            if (r11 != 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzgo r0 = r6.zzj()     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "Raw event metadata record is missing. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ SQLiteException -> 0x023a }
            r0.zza(r7, r8)     // Catch:{ SQLiteException -> 0x023a }
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x011a:
            byte[] r11 = r5.getBlob(r14)     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r13 = com.google.android.gms.internal.measurement.zzfy.zzk.zzw()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzlb r11 = com.google.android.gms.measurement.internal.zzoo.zza(r13, (byte[]) r11)     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r11 = (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r11     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzlc r11 = r11.zzai()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzjt r11 = (com.google.android.gms.internal.measurement.zzjt) r11     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = (com.google.android.gms.internal.measurement.zzfy.zzk) r11     // Catch:{ IOException -> 0x0222 }
            boolean r13 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x023a }
            if (r13 == 0) goto L_0x0158
            com.google.android.gms.measurement.internal.zzgo r13 = r6.zzj()     // Catch:{ SQLiteException -> 0x0151 }
            com.google.android.gms.measurement.internal.zzgq r13 = r13.zzu()     // Catch:{ SQLiteException -> 0x0151 }
            r27 = r14
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            r28 = r12
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ SQLiteException -> 0x023a }
            r13.zza(r14, r12)     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x015c
        L_0x014c:
            r0 = move-exception
            r28 = r12
            goto L_0x0248
        L_0x0151:
            r0 = move-exception
            r28 = r12
            r27 = r14
            goto L_0x0248
        L_0x0158:
            r28 = r12
            r27 = r14
        L_0x015c:
            r5.close()     // Catch:{ SQLiteException -> 0x023a }
            r4.zza(r11)     // Catch:{ SQLiteException -> 0x023a }
            int r11 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r11 == 0) goto L_0x0175
            java.lang.String r11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x023a }
            r12[r27] = r10     // Catch:{ SQLiteException -> 0x023a }
            r12[r26] = r0     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r0 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x023a }
            r12[r28] = r0     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x017f
        L_0x0175:
            java.lang.String r11 = "app_id = ? and metadata_fingerprint = ?"
            r7 = r28
            java.lang.String[] r12 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x023a }
            r12[r27] = r10     // Catch:{ SQLiteException -> 0x023a }
            r12[r26] = r0     // Catch:{ SQLiteException -> 0x023a }
        L_0x017f:
            r18 = r11
            r19 = r12
            java.lang.String r16 = "raw_events"
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "rowid"
            r0[r27] = r7     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "name"
            r0[r26] = r7     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "timestamp"
            r28 = 2
            r0[r28] = r7     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "data"
            r0[r9] = r7     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r22 = "rowid"
            r23 = 0
            r20 = 0
            r21 = 0
            r17 = r0
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x023a }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x023a }
            if (r0 != 0) goto L_0x01c6
            com.google.android.gms.measurement.internal.zzgo r0 = r6.zzj()     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ SQLiteException -> 0x023a }
            r0.zza(r7, r8)     // Catch:{ SQLiteException -> 0x023a }
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x01c6:
            r7 = r27
        L_0x01c8:
            long r11 = r5.getLong(r7)     // Catch:{ SQLiteException -> 0x023a }
            byte[] r0 = r5.getBlob(r9)     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r7 = com.google.android.gms.internal.measurement.zzfy.zzf.zze()     // Catch:{ IOException -> 0x0200 }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzoo.zza(r7, (byte[]) r0)     // Catch:{ IOException -> 0x0200 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r0 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r0     // Catch:{ IOException -> 0x0200 }
            r7 = r26
            java.lang.String r8 = r5.getString(r7)     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r7 = r0.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023a }
            r8 = 2
            long r13 = r5.getLong(r8)     // Catch:{ SQLiteException -> 0x023a }
            r7.zzb((long) r13)     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzlc r0 = r0.zzai()     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.internal.measurement.zzfy$zzf r0 = (com.google.android.gms.internal.measurement.zzfy.zzf) r0     // Catch:{ SQLiteException -> 0x023a }
            boolean r0 = r4.zza(r11, r0)     // Catch:{ SQLiteException -> 0x023a }
            if (r0 != 0) goto L_0x0212
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x0200:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj()     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r8 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ SQLiteException -> 0x023a }
            r7.zza(r8, r11, r0)     // Catch:{ SQLiteException -> 0x023a }
        L_0x0212:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x023a }
            if (r0 != 0) goto L_0x021e
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x021e:
            r7 = 0
            r26 = 1
            goto L_0x01c8
        L_0x0222:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj()     // Catch:{ SQLiteException -> 0x023a }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r8 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ SQLiteException -> 0x023a }
            r7.zza(r8, r11, r0)     // Catch:{ SQLiteException -> 0x023a }
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
            goto L_0x025e
        L_0x023a:
            r0 = move-exception
            goto L_0x0248
        L_0x023c:
            r0 = move-exception
            goto L_0x0245
        L_0x023e:
            r0 = move-exception
            r5 = 0
            goto L_0x1202
        L_0x0242:
            r0 = move-exception
            r24 = r10
        L_0x0245:
            r10 = r47
            r5 = 0
        L_0x0248:
            com.google.android.gms.measurement.internal.zzgo r6 = r6.zzj()     // Catch:{ all -> 0x1201 }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzg()     // Catch:{ all -> 0x1201 }
            java.lang.String r7 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r10)     // Catch:{ all -> 0x1201 }
            r6.zza(r7, r8, r0)     // Catch:{ all -> 0x1201 }
            if (r5 == 0) goto L_0x025e
            r5.close()     // Catch:{ all -> 0x1208 }
        L_0x025e:
            java.util.List<com.google.android.gms.internal.measurement.zzfy$zzf> r0 = r4.zzc     // Catch:{ all -> 0x1208 }
            if (r0 == 0) goto L_0x11f0
            java.util.List<com.google.android.gms.internal.measurement.zzfy$zzf> r0 = r4.zzc     // Catch:{ all -> 0x1208 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x1208 }
            if (r0 == 0) goto L_0x026c
            goto L_0x11f0
        L_0x026c:
            com.google.android.gms.internal.measurement.zzfy$zzk r0 = r4.zza     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r0 = r0.zzcd()     // Catch:{ all -> 0x1208 }
            r5 = r0
            com.google.android.gms.internal.measurement.zzjt$zzb r5 = (com.google.android.gms.internal.measurement.zzjt.zzb) r5     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r0 = r0.zzl()     // Catch:{ all -> 0x1208 }
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x0282:
            java.util.List<com.google.android.gms.internal.measurement.zzfy$zzf> r14 = r4.zzc     // Catch:{ all -> 0x1208 }
            int r14 = r14.size()     // Catch:{ all -> 0x1208 }
            java.lang.String r15 = "_fr"
            java.lang.String r9 = "_et"
            java.lang.String r5 = "_e"
            r48 = r6
            java.lang.String r6 = "_c"
            r17 = r10
            r49 = r11
            if (r8 >= r14) goto L_0x0886
            java.util.List<com.google.android.gms.internal.measurement.zzfy$zzf> r14 = r4.zzc     // Catch:{ all -> 0x1208 }
            java.lang.Object r14 = r14.get(r8)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r14 = (com.google.android.gms.internal.measurement.zzfy.zzf) r14     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r14 = r14.zzcd()     // Catch:{ all -> 0x1208 }
            r18 = r14
            com.google.android.gms.internal.measurement.zzjt$zzb r18 = (com.google.android.gms.internal.measurement.zzjt.zzb) r18     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r14 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzhl r10 = r1.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            r20 = r7
            java.lang.String r7 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r7 = r10.zzd(r11, r7)     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = "_err"
            if (r7 == 0) goto L_0x033a
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzhy r9 = r1.zzm     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgh r9 = r9.zzk()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r14.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r9 = r9.zza((java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            r5.zza(r6, r7, r9)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzhl r5 = r1.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r6 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1208 }
            boolean r5 = r5.zzl(r6)     // Catch:{ all -> 0x1208 }
            if (r5 != 0) goto L_0x032c
            com.google.android.gms.measurement.internal.zzhl r5 = r1.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r6 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1208 }
            boolean r5 = r5.zzn(r6)     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x0308
            goto L_0x032c
        L_0x0308:
            java.lang.String r5 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r5 = r10.equals(r5)     // Catch:{ all -> 0x1208 }
            if (r5 != 0) goto L_0x032c
            r1.zzq()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzor r5 = r1.zzah     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r6 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r30 = r6.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r32 = "_ev"
            java.lang.String r33 = r14.zze()     // Catch:{ all -> 0x1208 }
            r34 = 0
            r31 = 11
            r29 = r5
            com.google.android.gms.measurement.internal.zzos.zza((com.google.android.gms.measurement.internal.zzor) r29, (java.lang.String) r30, (int) r31, (java.lang.String) r32, (java.lang.String) r33, (int) r34)     // Catch:{ all -> 0x1208 }
        L_0x032c:
            r11 = r49
            r22 = r2
            r9 = r3
            r5 = r8
        L_0x0332:
            r6 = r48
            r10 = r17
            r7 = r20
            goto L_0x087e
        L_0x033a:
            java.lang.String r7 = r14.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = com.google.android.gms.measurement.internal.zzji.zza(r2)     // Catch:{ all -> 0x1208 }
            boolean r7 = r7.equals(r11)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x03ac
            r14.zza((java.lang.String) r2)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "Renaming ad_impression to _ai"
            r7.zza(r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x1208 }
            r11 = 5
            boolean r7 = r7.zza((int) r11)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x03ac
            r7 = 0
        L_0x0364:
            int r11 = r14.zza()     // Catch:{ all -> 0x1208 }
            if (r7 >= r11) goto L_0x03ac
            java.lang.String r11 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfy$zzh r21 = r14.zzb((int) r7)     // Catch:{ all -> 0x1208 }
            r22 = r2
            java.lang.String r2 = r21.zzg()     // Catch:{ all -> 0x1208 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x03a7
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = r14.zzb((int) r7)     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x03a7
            java.lang.String r2 = "admob"
            com.google.android.gms.internal.measurement.zzfy$zzh r11 = r14.zzb((int) r7)     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzh()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.equalsIgnoreCase(r11)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x03a7
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzv()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "AdMob ad impression logged from app. Potentially duplicative."
            r2.zza(r11)     // Catch:{ all -> 0x1208 }
        L_0x03a7:
            int r7 = r7 + 1
            r2 = r22
            goto L_0x0364
        L_0x03ac:
            r22 = r2
            com.google.android.gms.measurement.internal.zzhl r2 = r1.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.zzc((java.lang.String) r7, (java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x03ea
            r1.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r14.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x1208 }
            int r11 = r7.hashCode()     // Catch:{ all -> 0x1208 }
            r21 = r2
            r2 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r2) goto L_0x03d8
            goto L_0x03e1
        L_0x03d8:
            java.lang.String r2 = "_ui"
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x03e1
            goto L_0x03ec
        L_0x03e1:
            r23 = r3
            r30 = r8
            r8 = r12
        L_0x03e6:
            r10 = r17
            goto L_0x05df
        L_0x03ea:
            r21 = r2
        L_0x03ec:
            r7 = 0
            r11 = 0
            r23 = 0
        L_0x03f0:
            int r2 = r14.zza()     // Catch:{ all -> 0x1208 }
            r29 = r7
            java.lang.String r7 = "_r"
            if (r11 >= r2) goto L_0x0464
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = r14.zzb((int) r11)     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzg()     // Catch:{ all -> 0x1208 }
            boolean r2 = r6.equals(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x042d
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = r14.zzb((int) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = r2.zzcd()     // Catch:{ all -> 0x1208 }
            r7 = r2
            com.google.android.gms.internal.measurement.zzjt$zzb r7 = (com.google.android.gms.internal.measurement.zzjt.zzb) r7     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r2     // Catch:{ all -> 0x1208 }
            r30 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((long) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = (com.google.android.gms.internal.measurement.zzfy.zzh) r2     // Catch:{ all -> 0x1208 }
            r14.zza((int) r11, (com.google.android.gms.internal.measurement.zzfy.zzh) r2)     // Catch:{ all -> 0x1208 }
            r7 = r29
            r23 = 1
            goto L_0x045f
        L_0x042d:
            r30 = r8
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = r14.zzb((int) r11)     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzg()     // Catch:{ all -> 0x1208 }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x045d
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = r14.zzb((int) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = r2.zzcd()     // Catch:{ all -> 0x1208 }
            r7 = r2
            com.google.android.gms.internal.measurement.zzjt$zzb r7 = (com.google.android.gms.internal.measurement.zzjt.zzb) r7     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r2     // Catch:{ all -> 0x1208 }
            r7 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((long) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r2 = r2.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = (com.google.android.gms.internal.measurement.zzfy.zzh) r2     // Catch:{ all -> 0x1208 }
            r14.zza((int) r11, (com.google.android.gms.internal.measurement.zzfy.zzh) r2)     // Catch:{ all -> 0x1208 }
            r7 = 1
            goto L_0x045f
        L_0x045d:
            r7 = r29
        L_0x045f:
            int r11 = r11 + 1
            r8 = r30
            goto L_0x03f0
        L_0x0464:
            r30 = r8
            if (r23 != 0) goto L_0x049a
            if (r21 == 0) goto L_0x049a
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzhy r11 = r1.zzm     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgh r11 = r11.zzk()     // Catch:{ all -> 0x1208 }
            r23 = r3
            java.lang.String r3 = r14.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r11.zza((java.lang.String) r3)     // Catch:{ all -> 0x1208 }
            r2.zza(r8, r3)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((java.lang.String) r6)     // Catch:{ all -> 0x1208 }
            r3 = r12
            r11 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((long) r11)     // Catch:{ all -> 0x1208 }
            r14.zza((com.google.android.gms.internal.measurement.zzfy.zzh.zza) r2)     // Catch:{ all -> 0x1208 }
            goto L_0x049d
        L_0x049a:
            r23 = r3
            r3 = r12
        L_0x049d:
            if (r29 != 0) goto L_0x04cb
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzhy r11 = r1.zzm     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgh r11 = r11.zzk()     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = r14.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x1208 }
            r2.zza(r8, r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = r2.zza((long) r11)     // Catch:{ all -> 0x1208 }
            r14.zza((com.google.android.gms.internal.measurement.zzfy.zzh.zza) r2)     // Catch:{ all -> 0x1208 }
        L_0x04cb:
            com.google.android.gms.measurement.internal.zzal r31 = r1.zzf()     // Catch:{ all -> 0x1208 }
            long r32 = r1.zzx()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r2 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r34 = r2.zzz()     // Catch:{ all -> 0x1208 }
            r40 = 0
            r41 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 1
            com.google.android.gms.measurement.internal.zzaq r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1208 }
            long r11 = r2.zze     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzag r2 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            int r2 = r2.zzc(r8)     // Catch:{ all -> 0x1208 }
            r8 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x1208 }
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0505
            zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            goto L_0x0507
        L_0x0505:
            r17 = 1
        L_0x0507:
            java.lang.String r2 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r2 = com.google.android.gms.measurement.internal.zzos.zzh(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x03e6
            if (r21 == 0) goto L_0x03e6
            com.google.android.gms.measurement.internal.zzal r31 = r1.zzf()     // Catch:{ all -> 0x1208 }
            long r32 = r1.zzx()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r2 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r34 = r2.zzz()     // Catch:{ all -> 0x1208 }
            r40 = 0
            r41 = 0
            r35 = 0
            r36 = 0
            r37 = 1
            r38 = 0
            r39 = 0
            com.google.android.gms.measurement.internal.zzaq r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1208 }
            long r2 = r2.zzc     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzbh.zzn     // Catch:{ all -> 0x1208 }
            int r7 = r7.zzb((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r12)     // Catch:{ all -> 0x1208 }
            long r11 = (long) r7     // Catch:{ all -> 0x1208 }
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e6
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r7)     // Catch:{ all -> 0x1208 }
            r2 = -1
            r3 = 0
            r7 = 0
            r11 = 0
        L_0x0565:
            int r12 = r14.zza()     // Catch:{ all -> 0x1208 }
            if (r11 >= r12) goto L_0x059a
            com.google.android.gms.internal.measurement.zzfy$zzh r12 = r14.zzb((int) r11)     // Catch:{ all -> 0x1208 }
            r18 = r3
            java.lang.String r3 = r12.zzg()     // Catch:{ all -> 0x1208 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x0587
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = r12.zzcd()     // Catch:{ all -> 0x1208 }
            r3 = r2
            com.google.android.gms.internal.measurement.zzjt$zzb r3 = (com.google.android.gms.internal.measurement.zzjt.zzb) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r2     // Catch:{ all -> 0x1208 }
            r3 = r2
            r2 = r11
            goto L_0x0597
        L_0x0587:
            java.lang.String r3 = r12.zzg()     // Catch:{ all -> 0x1208 }
            boolean r3 = r10.equals(r3)     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x0595
            r3 = r18
            r7 = 1
            goto L_0x0597
        L_0x0595:
            r3 = r18
        L_0x0597:
            int r11 = r11 + 1
            goto L_0x0565
        L_0x059a:
            r18 = r3
            if (r7 == 0) goto L_0x05a5
            if (r18 == 0) goto L_0x05a5
            r14.zza((int) r2)     // Catch:{ all -> 0x1208 }
            goto L_0x03e6
        L_0x05a5:
            if (r18 == 0) goto L_0x05c6
            java.lang.Object r3 = r18.clone()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r3 = (com.google.android.gms.internal.measurement.zzjt.zzb) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r3 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r3 = r3.zza((java.lang.String) r10)     // Catch:{ all -> 0x1208 }
            r10 = 10
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r3 = r3.zza((long) r10)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r3 = r3.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r3 = (com.google.android.gms.internal.measurement.zzjt) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r3 = (com.google.android.gms.internal.measurement.zzfy.zzh) r3     // Catch:{ all -> 0x1208 }
            r14.zza((int) r2, (com.google.android.gms.internal.measurement.zzfy.zzh) r3)     // Catch:{ all -> 0x1208 }
            goto L_0x03e6
        L_0x05c6:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r7)     // Catch:{ all -> 0x1208 }
            goto L_0x03e6
        L_0x05df:
            if (r21 == 0) goto L_0x06a0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x1208 }
            java.util.List r3 = r14.zzf()     // Catch:{ all -> 0x1208 }
            r2.<init>(r3)     // Catch:{ all -> 0x1208 }
            r3 = 0
            r7 = -1
            r11 = -1
        L_0x05ed:
            int r12 = r2.size()     // Catch:{ all -> 0x1208 }
            r18 = r8
            java.lang.String r8 = "currency"
            r17 = r10
            java.lang.String r10 = "value"
            if (r3 >= r12) goto L_0x0625
            java.lang.Object r12 = r2.get(r3)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r12 = (com.google.android.gms.internal.measurement.zzfy.zzh) r12     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x1208 }
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x060d
            r7 = r3
            goto L_0x061e
        L_0x060d:
            java.lang.Object r10 = r2.get(r3)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzg()     // Catch:{ all -> 0x1208 }
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x1208 }
            if (r8 == 0) goto L_0x061e
            r11 = r3
        L_0x061e:
            int r3 = r3 + 1
            r10 = r17
            r8 = r18
            goto L_0x05ed
        L_0x0625:
            r3 = -1
            if (r7 == r3) goto L_0x06a5
            java.lang.Object r3 = r2.get(r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r3 = (com.google.android.gms.internal.measurement.zzfy.zzh) r3     // Catch:{ all -> 0x1208 }
            boolean r3 = r3.zzl()     // Catch:{ all -> 0x1208 }
            if (r3 != 0) goto L_0x0659
            java.lang.Object r3 = r2.get(r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r3 = (com.google.android.gms.internal.measurement.zzfy.zzh) r3     // Catch:{ all -> 0x1208 }
            boolean r3 = r3.zzj()     // Catch:{ all -> 0x1208 }
            if (r3 != 0) goto L_0x0659
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzv()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x1208 }
            r14.zza((int) r7)     // Catch:{ all -> 0x1208 }
            zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (java.lang.String) r6)     // Catch:{ all -> 0x1208 }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (int) r2, (java.lang.String) r10)     // Catch:{ all -> 0x1208 }
            goto L_0x06a4
        L_0x0659:
            r3 = -1
            if (r11 != r3) goto L_0x065e
            r11 = 3
            goto L_0x0681
        L_0x065e:
            java.lang.Object r2 = r2.get(r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = (com.google.android.gms.internal.measurement.zzfy.zzh) r2     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x1208 }
            int r10 = r2.length()     // Catch:{ all -> 0x1208 }
            r11 = 3
            if (r10 == r11) goto L_0x0670
            goto L_0x0681
        L_0x0670:
            r10 = 0
        L_0x0671:
            int r12 = r2.length()     // Catch:{ all -> 0x1208 }
            if (r10 >= r12) goto L_0x06a6
            int r12 = r2.codePointAt(r10)     // Catch:{ all -> 0x1208 }
            boolean r16 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x1208 }
            if (r16 != 0) goto L_0x069a
        L_0x0681:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzv()     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r10)     // Catch:{ all -> 0x1208 }
            r14.zza((int) r7)     // Catch:{ all -> 0x1208 }
            zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (java.lang.String) r6)     // Catch:{ all -> 0x1208 }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (int) r2, (java.lang.String) r8)     // Catch:{ all -> 0x1208 }
            goto L_0x06a6
        L_0x069a:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x1208 }
            int r10 = r10 + r12
            goto L_0x0671
        L_0x06a0:
            r18 = r8
            r17 = r10
        L_0x06a4:
            r3 = -1
        L_0x06a5:
            r11 = 3
        L_0x06a6:
            java.lang.String r2 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x06f1
            r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r2 = r14.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r2, (java.lang.String) r15)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x0742
            if (r20 == 0) goto L_0x06ed
            long r5 = r20.zzc()     // Catch:{ all -> 0x1208 }
            long r7 = r14.zzc()     // Catch:{ all -> 0x1208 }
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x1208 }
            r7 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x06ed
            java.lang.Object r2 = r20.clone()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = (com.google.android.gms.internal.measurement.zzjt.zzb) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch:{ all -> 0x1208 }
            boolean r5 = r1.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2)     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x06ed
            r0.zza((int) r13, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2)     // Catch:{ all -> 0x1208 }
            r12 = r18
        L_0x06e9:
            r2 = 0
            r20 = 0
            goto L_0x0747
        L_0x06ed:
            r12 = r49
            r2 = r14
            goto L_0x0747
        L_0x06f1:
            java.lang.String r2 = "_vs"
            java.lang.String r5 = r14.zze()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x0742
            r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r2 = r14.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r2 = (com.google.android.gms.internal.measurement.zzfy.zzf) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r2 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r2, (java.lang.String) r9)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x0742
            if (r48 == 0) goto L_0x0738
            long r5 = r48.zzc()     // Catch:{ all -> 0x1208 }
            long r7 = r14.zzc()     // Catch:{ all -> 0x1208 }
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x1208 }
            r7 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0738
            java.lang.Object r2 = r48.clone()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r2 = (com.google.android.gms.internal.measurement.zzjt.zzb) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2     // Catch:{ all -> 0x1208 }
            boolean r5 = r1.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14)     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x0738
            r8 = r18
            r0.zza((int) r8, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r2)     // Catch:{ all -> 0x1208 }
            r12 = r8
            goto L_0x06e9
        L_0x0738:
            r8 = r18
            r2 = r48
            r13 = r49
            r12 = r8
            r20 = r14
            goto L_0x0747
        L_0x0742:
            r8 = r18
            r2 = r48
            r12 = r8
        L_0x0747:
            int r5 = r14.zza()     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x0864
            r1.zzp()     // Catch:{ all -> 0x1208 }
            java.util.List r5 = r14.zzf()     // Catch:{ all -> 0x1208 }
            android.os.Bundle r5 = com.google.android.gms.measurement.internal.zzoo.zza((java.util.List<com.google.android.gms.internal.measurement.zzfy.zzh>) r5)     // Catch:{ all -> 0x1208 }
            r6 = 0
        L_0x0759:
            int r7 = r14.zza()     // Catch:{ all -> 0x1208 }
            if (r6 >= r7) goto L_0x080d
            com.google.android.gms.internal.measurement.zzfy$zzh r7 = r14.zzb((int) r6)     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r7.zzg()     // Catch:{ all -> 0x1208 }
            r9 = r23
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x1208 }
            if (r8 == 0) goto L_0x07e1
            java.util.List r8 = r7.zzi()     // Catch:{ all -> 0x1208 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x1208 }
            if (r8 != 0) goto L_0x07e1
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            java.util.List r7 = r7.zzi()     // Catch:{ all -> 0x1208 }
            int r10 = r7.size()     // Catch:{ all -> 0x1208 }
            android.os.Bundle[] r10 = new android.os.Bundle[r10]     // Catch:{ all -> 0x1208 }
            r15 = 0
        L_0x078a:
            int r3 = r7.size()     // Catch:{ all -> 0x1208 }
            if (r15 >= r3) goto L_0x07db
            java.lang.Object r3 = r7.get(r15)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r3 = (com.google.android.gms.internal.measurement.zzfy.zzh) r3     // Catch:{ all -> 0x1208 }
            r1.zzp()     // Catch:{ all -> 0x1208 }
            java.util.List r16 = r3.zzi()     // Catch:{ all -> 0x1208 }
            android.os.Bundle r11 = com.google.android.gms.measurement.internal.zzoo.zza((java.util.List<com.google.android.gms.internal.measurement.zzfy.zzh>) r16)     // Catch:{ all -> 0x1208 }
            java.util.List r3 = r3.zzi()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x1208 }
        L_0x07a9:
            boolean r16 = r3.hasNext()     // Catch:{ all -> 0x1208 }
            if (r16 == 0) goto L_0x07d1
            java.lang.Object r16 = r3.next()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r16 = (com.google.android.gms.internal.measurement.zzfy.zzh) r16     // Catch:{ all -> 0x1208 }
            r48 = r2
            java.lang.String r2 = r14.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r16 = r16.zzcd()     // Catch:{ all -> 0x1208 }
            r19 = r16
            com.google.android.gms.internal.measurement.zzjt$zzb r19 = (com.google.android.gms.internal.measurement.zzjt.zzb) r19     // Catch:{ all -> 0x1208 }
            r19 = r3
            r3 = r16
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r3 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r3     // Catch:{ all -> 0x1208 }
            r1.zza((java.lang.String) r2, (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r3, (android.os.Bundle) r11, (java.lang.String) r8)     // Catch:{ all -> 0x1208 }
            r2 = r48
            r3 = r19
            goto L_0x07a9
        L_0x07d1:
            r48 = r2
            r10[r15] = r11     // Catch:{ all -> 0x1208 }
            int r15 = r15 + 1
            r2 = r48
            r11 = 3
            goto L_0x078a
        L_0x07db:
            r48 = r2
            r5.putParcelableArray(r9, r10)     // Catch:{ all -> 0x1208 }
            goto L_0x0803
        L_0x07e1:
            r48 = r2
            java.lang.String r2 = r7.zzg()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x0803
            java.lang.String r2 = r14.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r3 = r7.zzcd()     // Catch:{ all -> 0x1208 }
            r7 = r3
            com.google.android.gms.internal.measurement.zzjt$zzb r7 = (com.google.android.gms.internal.measurement.zzjt.zzb) r7     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r3 = (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            r1.zza((java.lang.String) r2, (com.google.android.gms.internal.measurement.zzfy.zzh.zza) r3, (android.os.Bundle) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1208 }
        L_0x0803:
            int r6 = r6 + 1
            r2 = r48
            r23 = r9
            r3 = -1
            r11 = 3
            goto L_0x0759
        L_0x080d:
            r48 = r2
            r9 = r23
            r14.zzd()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo r2 = r1.zzp()     // Catch:{ all -> 0x1208 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x1208 }
            r3.<init>()     // Catch:{ all -> 0x1208 }
            java.util.Set r6 = r5.keySet()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x1208 }
        L_0x0825:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x084e
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r8 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r8 = r8.zza((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0825
            r2.zza((com.google.android.gms.internal.measurement.zzfy.zzh.zza) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r7 = r8.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r7 = (com.google.android.gms.internal.measurement.zzjt) r7     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r7 = (com.google.android.gms.internal.measurement.zzfy.zzh) r7     // Catch:{ all -> 0x1208 }
            r3.add(r7)     // Catch:{ all -> 0x1208 }
            goto L_0x0825
        L_0x084e:
            r2 = r3
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x1208 }
            int r2 = r3.size()     // Catch:{ all -> 0x1208 }
            r5 = 0
        L_0x0856:
            if (r5 >= r2) goto L_0x0868
            java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x1208 }
            int r5 = r5 + 1
            com.google.android.gms.internal.measurement.zzfy$zzh r6 = (com.google.android.gms.internal.measurement.zzfy.zzh) r6     // Catch:{ all -> 0x1208 }
            r14.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r6)     // Catch:{ all -> 0x1208 }
            goto L_0x0856
        L_0x0864:
            r48 = r2
            r9 = r23
        L_0x0868:
            java.util.List<com.google.android.gms.internal.measurement.zzfy$zzf> r2 = r4.zzc     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r3 = r14.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r3 = (com.google.android.gms.internal.measurement.zzjt) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r3 = (com.google.android.gms.internal.measurement.zzfy.zzf) r3     // Catch:{ all -> 0x1208 }
            r5 = r30
            r2.set(r5, r3)     // Catch:{ all -> 0x1208 }
            int r11 = r49 + 1
            r0.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r14)     // Catch:{ all -> 0x1208 }
            goto L_0x0332
        L_0x087e:
            int r8 = r5 + 1
            r3 = r9
            r2 = r22
            r9 = 3
            goto L_0x0282
        L_0x0886:
            r2 = 0
            r11 = r49
            r12 = r2
            r7 = 0
        L_0x088c:
            if (r7 >= r11) goto L_0x08db
            com.google.android.gms.internal.measurement.zzfy$zzf r8 = r0.zza((int) r7)     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r8.zzg()     // Catch:{ all -> 0x1208 }
            boolean r10 = r5.equals(r10)     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x08ad
            r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r8, (java.lang.String) r15)     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x08ad
            r0.zzb((int) r7)     // Catch:{ all -> 0x1208 }
            int r11 = r11 + -1
            int r7 = r7 + -1
            goto L_0x08d6
        L_0x08ad:
            r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r8 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf) r8, (java.lang.String) r9)     // Catch:{ all -> 0x1208 }
            if (r8 == 0) goto L_0x08d6
            boolean r10 = r8.zzl()     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x08c5
            long r20 = r8.zzd()     // Catch:{ all -> 0x1208 }
            java.lang.Long r8 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x1208 }
            goto L_0x08c6
        L_0x08c5:
            r8 = 0
        L_0x08c6:
            if (r8 == 0) goto L_0x08d6
            long r20 = r8.longValue()     // Catch:{ all -> 0x1208 }
            int r10 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x08d6
            long r20 = r8.longValue()     // Catch:{ all -> 0x1208 }
            long r12 = r12 + r20
        L_0x08d6:
            r26 = 1
            int r7 = r7 + 1
            goto L_0x088c
        L_0x08db:
            r7 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (long) r12, (boolean) r7)     // Catch:{ all -> 0x1208 }
            java.util.List r5 = r0.zzaa()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x1208 }
        L_0x08e7:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = "_se"
            if (r7 == 0) goto L_0x090c
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r7 = (com.google.android.gms.internal.measurement.zzfy.zzf) r7     // Catch:{ all -> 0x1208 }
            java.lang.String r9 = "_s"
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x1208 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x08e7
            com.google.android.gms.measurement.internal.zzal r5 = r1.zzf()     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r0.zzt()     // Catch:{ all -> 0x1208 }
            r5.zzh(r7, r8)     // Catch:{ all -> 0x1208 }
        L_0x090c:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            if (r5 < 0) goto L_0x0919
            r7 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (long) r12, (boolean) r7)     // Catch:{ all -> 0x1208 }
            goto L_0x0939
        L_0x0919:
            int r5 = com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (java.lang.String) r8)     // Catch:{ all -> 0x1208 }
            if (r5 < 0) goto L_0x0939
            r0.zzc((int) r5)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r8)     // Catch:{ all -> 0x1208 }
            r5.zza(r7, r8)     // Catch:{ all -> 0x1208 }
        L_0x0939:
            com.google.android.gms.internal.measurement.zzfy$zzk r5 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzhv r7 = r1.zzl()     // Catch:{ all -> 0x1208 }
            r7.zzt()     // Catch:{ all -> 0x1208 }
            r1.zzs()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zze(r5)     // Catch:{ all -> 0x1208 }
            if (r7 != 0) goto L_0x0965
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = "Cannot fix consent fields without appInfo. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            r7.zza(r8, r5)     // Catch:{ all -> 0x1208 }
            goto L_0x0968
        L_0x0965:
            r1.zza((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0)     // Catch:{ all -> 0x1208 }
        L_0x0968:
            boolean r5 = com.google.android.gms.internal.measurement.zzov.zza()     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x09a9
            com.google.android.gms.measurement.internal.zzag r5 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcu     // Catch:{ all -> 0x1208 }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x09a9
            com.google.android.gms.internal.measurement.zzfy$zzk r5 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzhv r7 = r1.zzl()     // Catch:{ all -> 0x1208 }
            r7.zzt()     // Catch:{ all -> 0x1208 }
            r1.zzs()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zze(r5)     // Catch:{ all -> 0x1208 }
            if (r7 != 0) goto L_0x09a6
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = "Cannot populate ad_campaign_info without appInfo. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            r7.zza(r8, r5)     // Catch:{ all -> 0x1208 }
            goto L_0x09a9
        L_0x09a6:
            r1.zzb((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0)     // Catch:{ all -> 0x1208 }
        L_0x09a9:
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r5 = r0.zzi((long) r7)     // Catch:{ all -> 0x1208 }
            r7 = -9223372036854775808
            r5.zze((long) r7)     // Catch:{ all -> 0x1208 }
            r5 = 0
        L_0x09b8:
            int r7 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r5 >= r7) goto L_0x09eb
            com.google.android.gms.internal.measurement.zzfy$zzf r7 = r0.zza((int) r5)     // Catch:{ all -> 0x1208 }
            long r8 = r7.zzd()     // Catch:{ all -> 0x1208 }
            long r10 = r0.zzf()     // Catch:{ all -> 0x1208 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 >= 0) goto L_0x09d5
            long r8 = r7.zzd()     // Catch:{ all -> 0x1208 }
            r0.zzi((long) r8)     // Catch:{ all -> 0x1208 }
        L_0x09d5:
            long r8 = r7.zzd()     // Catch:{ all -> 0x1208 }
            long r10 = r0.zze()     // Catch:{ all -> 0x1208 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x09e8
            long r7 = r7.zzd()     // Catch:{ all -> 0x1208 }
            r0.zze((long) r7)     // Catch:{ all -> 0x1208 }
        L_0x09e8:
            int r5 = r5 + 1
            goto L_0x09b8
        L_0x09eb:
            r0.zzs()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r5 = com.google.android.gms.measurement.internal.zzje.zza     // Catch:{ all -> 0x1208 }
            boolean r7 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0a83
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbh.zzcy     // Catch:{ all -> 0x1208 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r8)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0a83
            com.google.android.gms.internal.measurement.zzfy$zzk r5 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r5 = r1.zzb((java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzae()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r7 = com.google.android.gms.measurement.internal.zzje.zzb((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r5 = r5.zza((com.google.android.gms.measurement.internal.zzje) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r7 = r7.zzh(r8)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r8 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r9 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r9 = r9.zzz()     // Catch:{ all -> 0x1208 }
            r8.zza((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzje) r5)     // Catch:{ all -> 0x1208 }
            boolean r8 = r5.zzh()     // Catch:{ all -> 0x1208 }
            if (r8 != 0) goto L_0x0a4f
            boolean r8 = r7.zzh()     // Catch:{ all -> 0x1208 }
            if (r8 == 0) goto L_0x0a4f
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            r7.zzq(r8)     // Catch:{ all -> 0x1208 }
            goto L_0x0a68
        L_0x0a4f:
            boolean r8 = r5.zzh()     // Catch:{ all -> 0x1208 }
            if (r8 == 0) goto L_0x0a68
            boolean r7 = r7.zzh()     // Catch:{ all -> 0x1208 }
            if (r7 != 0) goto L_0x0a68
            com.google.android.gms.measurement.internal.zzal r7 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            r7.zzr(r8)     // Catch:{ all -> 0x1208 }
        L_0x0a68:
            boolean r7 = r5.zzg()     // Catch:{ all -> 0x1208 }
            if (r7 != 0) goto L_0x0a77
            r0.zzq()     // Catch:{ all -> 0x1208 }
            r0.zzn()     // Catch:{ all -> 0x1208 }
            r0.zzk()     // Catch:{ all -> 0x1208 }
        L_0x0a77:
            boolean r7 = r5.zzh()     // Catch:{ all -> 0x1208 }
            if (r7 != 0) goto L_0x0a83
            r0.zzh()     // Catch:{ all -> 0x1208 }
            r0.zzr()     // Catch:{ all -> 0x1208 }
        L_0x0a83:
            boolean r7 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0c8d
            com.google.android.gms.measurement.internal.zzag r7 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r8 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbh.zzch     // Catch:{ all -> 0x1208 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0c8d
            r1.zzq()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            boolean r7 = com.google.android.gms.measurement.internal.zzos.zzd(r7)     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0c8d
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzje r7 = r1.zzb((java.lang.String) r7)     // Catch:{ all -> 0x1208 }
            boolean r7 = r7.zzg()     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0c8d
            com.google.android.gms.internal.measurement.zzfy$zzk r7 = r4.zza     // Catch:{ all -> 0x1208 }
            boolean r7 = r7.zzat()     // Catch:{ all -> 0x1208 }
            if (r7 == 0) goto L_0x0c8d
            r7 = 0
        L_0x0ac3:
            int r8 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r7 >= r8) goto L_0x0c8d
            com.google.android.gms.internal.measurement.zzfy$zzf r8 = r0.zza((int) r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r8 = r8.zzcd()     // Catch:{ all -> 0x1208 }
            r9 = r8
            com.google.android.gms.internal.measurement.zzjt$zzb r9 = (com.google.android.gms.internal.measurement.zzjt.zzb) r9     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r8 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r8     // Catch:{ all -> 0x1208 }
            java.util.List r9 = r8.zzf()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x1208 }
        L_0x0ade:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x0c89
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzg()     // Catch:{ all -> 0x1208 }
            boolean r10 = r6.equals(r10)     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x0ade
            com.google.android.gms.internal.measurement.zzfy$zzk r9 = r4.zza     // Catch:{ all -> 0x1208 }
            int r9 = r9.zza()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzag r10 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzbh.zzax     // Catch:{ all -> 0x1208 }
            int r10 = r10.zzb((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r12)     // Catch:{ all -> 0x1208 }
            if (r9 < r10) goto L_0x0c7e
            com.google.android.gms.measurement.internal.zzag r9 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzbh.zzbi     // Catch:{ all -> 0x1208 }
            int r9 = r9.zzb((java.lang.String) r10, (com.google.android.gms.measurement.internal.zzfz<java.lang.Integer>) r11)     // Catch:{ all -> 0x1208 }
            if (r9 <= 0) goto L_0x0bf1
            com.google.android.gms.measurement.internal.zzal r29 = r1.zzf()     // Catch:{ all -> 0x1208 }
            long r30 = r1.zzx()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r32 = r10.zzz()     // Catch:{ all -> 0x1208 }
            r38 = 0
            r39 = 1
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            com.google.android.gms.measurement.internal.zzaq r10 = r29.zza(r30, r32, r33, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x1208 }
            long r10 = r10.zzg     // Catch:{ all -> 0x1208 }
            long r12 = (long) r9     // Catch:{ all -> 0x1208 }
            int r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x0b62
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r9 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = "_tnr"
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r9 = r9.zza((java.lang.String) r10)     // Catch:{ all -> 0x1208 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r9 = r9.zza((long) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r9 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r9 = (com.google.android.gms.internal.measurement.zzjt) r9     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r9 = (com.google.android.gms.internal.measurement.zzfy.zzh) r9     // Catch:{ all -> 0x1208 }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r9)     // Catch:{ all -> 0x1208 }
            goto L_0x0c7e
        L_0x0b62:
            com.google.android.gms.measurement.internal.zzag r9 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbh.zzcj     // Catch:{ all -> 0x1208 }
            boolean r9 = r9.zze(r10, r11)     // Catch:{ all -> 0x1208 }
            if (r9 == 0) goto L_0x0b96
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x1208 }
            java.lang.String r9 = r9.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_tu"
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zzb(r9)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r10.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r10)     // Catch:{ all -> 0x1208 }
            goto L_0x0b97
        L_0x0b96:
            r9 = 0
        L_0x0b97:
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_tr"
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((long) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r10.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r10)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo r10 = r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzno r9 = r10.zza((java.lang.String) r11, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r8, (java.lang.String) r9)     // Catch:{ all -> 0x1208 }
            if (r9 == 0) goto L_0x0c7e
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "Generated trigger URI. appId, uri"
            com.google.android.gms.internal.measurement.zzfy$zzk r12 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r13 = r9.zza     // Catch:{ all -> 0x1208 }
            r10.zza(r11, r12, r13)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            r10.zza((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzno) r9)     // Catch:{ all -> 0x1208 }
            java.util.Set<java.lang.String> r9 = r1.zzr     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            r9.add(r10)     // Catch:{ all -> 0x1208 }
            goto L_0x0c7e
        L_0x0bf1:
            com.google.android.gms.measurement.internal.zzag r9 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbh.zzcj     // Catch:{ all -> 0x1208 }
            boolean r9 = r9.zze(r10, r11)     // Catch:{ all -> 0x1208 }
            if (r9 == 0) goto L_0x0c25
            com.google.android.gms.measurement.internal.zzos r9 = r1.zzq()     // Catch:{ all -> 0x1208 }
            java.lang.String r9 = r9.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_tu"
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zzb(r9)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r10.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r10)     // Catch:{ all -> 0x1208 }
            goto L_0x0c26
        L_0x0c25:
            r9 = 0
        L_0x0c26:
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfy.zzh.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_tr"
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((java.lang.String) r11)     // Catch:{ all -> 0x1208 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzfy$zzh$zza r10 = r10.zza((long) r11)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r10.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r10 = (com.google.android.gms.internal.measurement.zzfy.zzh) r10     // Catch:{ all -> 0x1208 }
            r8.zza((com.google.android.gms.internal.measurement.zzfy.zzh) r10)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo r10 = r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzno r9 = r10.zza((java.lang.String) r11, (com.google.android.gms.internal.measurement.zzfy.zzk.zza) r0, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r8, (java.lang.String) r9)     // Catch:{ all -> 0x1208 }
            if (r9 == 0) goto L_0x0c7e
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "Generated trigger URI. appId, uri"
            com.google.android.gms.internal.measurement.zzfy$zzk r12 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r13 = r9.zza     // Catch:{ all -> 0x1208 }
            r10.zza(r11, r12, r13)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r10 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r11 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1208 }
            r10.zza((java.lang.String) r11, (com.google.android.gms.measurement.internal.zzno) r9)     // Catch:{ all -> 0x1208 }
            java.util.Set<java.lang.String> r9 = r1.zzr     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            r9.add(r10)     // Catch:{ all -> 0x1208 }
        L_0x0c7e:
            com.google.android.gms.internal.measurement.zzlc r8 = r8.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r8 = (com.google.android.gms.internal.measurement.zzjt) r8     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r8 = (com.google.android.gms.internal.measurement.zzfy.zzf) r8     // Catch:{ all -> 0x1208 }
            r0.zza((int) r7, (com.google.android.gms.internal.measurement.zzfy.zzf) r8)     // Catch:{ all -> 0x1208 }
        L_0x0c89:
            int r7 = r7 + 1
            goto L_0x0ac3
        L_0x0c8d:
            boolean r6 = com.google.android.gms.internal.measurement.zznm.zza()     // Catch:{ all -> 0x1208 }
            if (r6 == 0) goto L_0x0cd3
            com.google.android.gms.measurement.internal.zzag r6 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbh.zzcy     // Catch:{ all -> 0x1208 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r7)     // Catch:{ all -> 0x1208 }
            if (r6 == 0) goto L_0x0cd3
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r6 = r0.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzt r7 = r1.zzc()     // Catch:{ all -> 0x1208 }
            java.lang.String r8 = r0.zzt()     // Catch:{ all -> 0x1208 }
            java.util.List r9 = r0.zzaa()     // Catch:{ all -> 0x1208 }
            java.util.List r10 = r0.zzab()     // Catch:{ all -> 0x1208 }
            long r11 = r0.zzf()     // Catch:{ all -> 0x1208 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1208 }
            long r12 = r0.zze()     // Catch:{ all -> 0x1208 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1208 }
            boolean r5 = r5.zzh()     // Catch:{ all -> 0x1208 }
            r26 = 1
            r13 = r5 ^ 1
            java.util.List r5 = r7.zza(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x1208 }
            r6.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzd>) r5)     // Catch:{ all -> 0x1208 }
            goto L_0x0cfe
        L_0x0cd3:
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r5 = r0.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzt r6 = r1.zzc()     // Catch:{ all -> 0x1208 }
            java.lang.String r7 = r0.zzt()     // Catch:{ all -> 0x1208 }
            java.util.List r8 = r0.zzaa()     // Catch:{ all -> 0x1208 }
            java.util.List r9 = r0.zzab()     // Catch:{ all -> 0x1208 }
            long r10 = r0.zzf()     // Catch:{ all -> 0x1208 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1208 }
            long r11 = r0.zze()     // Catch:{ all -> 0x1208 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1208 }
            java.util.List r6 = r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x1208 }
            r5.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzd>) r6)     // Catch:{ all -> 0x1208 }
        L_0x0cfe:
            com.google.android.gms.measurement.internal.zzag r5 = r1.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r6 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1208 }
            boolean r5 = r5.zzk(r6)     // Catch:{ all -> 0x1208 }
            if (r5 == 0) goto L_0x103b
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x1208 }
            r5.<init>()     // Catch:{ all -> 0x1208 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x1208 }
            r6.<init>()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzos r7 = r1.zzq()     // Catch:{ all -> 0x1208 }
            java.security.SecureRandom r7 = r7.zzv()     // Catch:{ all -> 0x1208 }
            r8 = 0
        L_0x0d21:
            int r9 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r8 >= r9) goto L_0x1006
            com.google.android.gms.internal.measurement.zzfy$zzf r9 = r0.zza((int) r8)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt$zzb r9 = r9.zzcd()     // Catch:{ all -> 0x1208 }
            r10 = r9
            com.google.android.gms.internal.measurement.zzjt$zzb r10 = (com.google.android.gms.internal.measurement.zzjt.zzb) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf$zza r9 = (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r9.zze()     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_ep"
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x1208 }
            java.lang.String r11 = "_sr"
            if (r10 == 0) goto L_0x0dc5
            r1.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r10 = (com.google.android.gms.internal.measurement.zzfy.zzf) r10     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = "_en"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzoo.zzb(r10, r12)     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x1208 }
            java.lang.Object r12 = r5.get(r10)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r12 = (com.google.android.gms.measurement.internal.zzbb) r12     // Catch:{ all -> 0x1208 }
            if (r12 != 0) goto L_0x0d76
            com.google.android.gms.measurement.internal.zzal r12 = r1.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r13 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r13 = r13.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r14 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x1208 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r12 = r12.zzd(r13, r14)     // Catch:{ all -> 0x1208 }
            if (r12 == 0) goto L_0x0d76
            r5.put(r10, r12)     // Catch:{ all -> 0x1208 }
        L_0x0d76:
            if (r12 == 0) goto L_0x0db9
            java.lang.Long r10 = r12.zzi     // Catch:{ all -> 0x1208 }
            if (r10 != 0) goto L_0x0db9
            java.lang.Long r10 = r12.zzj     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x0d94
            java.lang.Long r10 = r12.zzj     // Catch:{ all -> 0x1208 }
            long r13 = r10.longValue()     // Catch:{ all -> 0x1208 }
            r18 = 1
            int r10 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r10 <= 0) goto L_0x0d94
            r1.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.Long r10 = r12.zzj     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9, (java.lang.String) r11, (java.lang.Object) r10)     // Catch:{ all -> 0x1208 }
        L_0x0d94:
            java.lang.Boolean r10 = r12.zzk     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x0dae
            java.lang.Boolean r10 = r12.zzk     // Catch:{ all -> 0x1208 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x1208 }
            if (r10 == 0) goto L_0x0dae
            r1.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = "_efs"
            r18 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9, (java.lang.String) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x1208 }
        L_0x0dae:
            com.google.android.gms.internal.measurement.zzlc r10 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r10 = (com.google.android.gms.internal.measurement.zzfy.zzf) r10     // Catch:{ all -> 0x1208 }
            r6.add(r10)     // Catch:{ all -> 0x1208 }
        L_0x0db9:
            r0.zza((int) r8, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9)     // Catch:{ all -> 0x1208 }
            r47 = r2
        L_0x0dbe:
            r49 = r7
            r1 = r8
            r18 = 1
            goto L_0x0ffc
        L_0x0dc5:
            com.google.android.gms.measurement.internal.zzhl r10 = r1.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r12 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1208 }
            long r12 = r10.zza((java.lang.String) r12)     // Catch:{ all -> 0x1208 }
            r1.zzq()     // Catch:{ all -> 0x1208 }
            long r14 = r9.zzc()     // Catch:{ all -> 0x1208 }
            long r14 = com.google.android.gms.measurement.internal.zzos.zza((long) r14, (long) r12)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r10 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r10 = (com.google.android.gms.internal.measurement.zzjt) r10     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r10 = (com.google.android.gms.internal.measurement.zzfy.zzf) r10     // Catch:{ all -> 0x1208 }
            r47 = r2
            java.lang.String r2 = "_dbg"
            r18 = 1
            java.lang.Long r3 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x1208 }
            boolean r16 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x1208 }
            if (r16 != 0) goto L_0x0e4e
            if (r3 != 0) goto L_0x0df9
            goto L_0x0e4e
        L_0x0df9:
            java.util.List r10 = r10.zzh()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x1208 }
        L_0x0e01:
            boolean r16 = r10.hasNext()     // Catch:{ all -> 0x1208 }
            if (r16 == 0) goto L_0x0e4e
            java.lang.Object r16 = r10.next()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzh r16 = (com.google.android.gms.internal.measurement.zzfy.zzh) r16     // Catch:{ all -> 0x1208 }
            java.lang.String r1 = r16.zzg()     // Catch:{ all -> 0x1208 }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0e4b
            boolean r1 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0e29
            long r1 = r16.zzd()     // Catch:{ all -> 0x1208 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x1208 }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x1208 }
            if (r1 != 0) goto L_0x0e49
        L_0x0e29:
            boolean r1 = r3 instanceof java.lang.String     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0e37
            java.lang.String r1 = r16.zzh()     // Catch:{ all -> 0x1208 }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x1208 }
            if (r1 != 0) goto L_0x0e49
        L_0x0e37:
            boolean r1 = r3 instanceof java.lang.Double     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0e4e
            double r1 = r16.zza()     // Catch:{ all -> 0x1208 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x1208 }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0e4e
        L_0x0e49:
            r1 = 1
            goto L_0x0e60
        L_0x0e4b:
            r1 = r46
            goto L_0x0e01
        L_0x0e4e:
            com.google.android.gms.measurement.internal.zzhl r1 = r46.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r2 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r9.zze()     // Catch:{ all -> 0x1208 }
            int r1 = r1.zzb((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x1208 }
        L_0x0e60:
            if (r1 > 0) goto L_0x0e87
            com.google.android.gms.measurement.internal.zzgo r2 = r46.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            java.lang.String r10 = r9.zze()     // Catch:{ all -> 0x1208 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r10, r1)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r1 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r1 = (com.google.android.gms.internal.measurement.zzjt) r1     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r1 = (com.google.android.gms.internal.measurement.zzfy.zzf) r1     // Catch:{ all -> 0x1208 }
            r6.add(r1)     // Catch:{ all -> 0x1208 }
            r0.zza((int) r8, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9)     // Catch:{ all -> 0x1208 }
            goto L_0x0dbe
        L_0x0e87:
            java.lang.String r2 = r9.zze()     // Catch:{ all -> 0x1208 }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r2 = (com.google.android.gms.measurement.internal.zzbb) r2     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x0ee6
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r3 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r3.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r9.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zzd(r3, r10)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x0ee6
            com.google.android.gms.measurement.internal.zzgo r2 = r46.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzfy$zzk r10 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1208 }
            r20 = r12
            java.lang.String r12 = r9.zze()     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r10, r12)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r29 = new com.google.android.gms.measurement.internal.zzbb     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r2 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r30 = r2.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.String r31 = r9.zze()     // Catch:{ all -> 0x1208 }
            long r38 = r9.zzc()     // Catch:{ all -> 0x1208 }
            r44 = 0
            r45 = 0
            r32 = 1
            r34 = 1
            r36 = 1
            r40 = 0
            r42 = 0
            r43 = 0
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)     // Catch:{ all -> 0x1208 }
            r2 = r29
            goto L_0x0ee8
        L_0x0ee6:
            r20 = r12
        L_0x0ee8:
            r46.zzp()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r3 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r3 = (com.google.android.gms.internal.measurement.zzjt) r3     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r3 = (com.google.android.gms.internal.measurement.zzfy.zzf) r3     // Catch:{ all -> 0x1208 }
            java.lang.String r10 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzoo.zzb(r3, r10)     // Catch:{ all -> 0x1208 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x0eff
            r10 = 1
            goto L_0x0f00
        L_0x0eff:
            r10 = 0
        L_0x0f00:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x1208 }
            r12 = 1
            if (r1 != r12) goto L_0x0f35
            com.google.android.gms.internal.measurement.zzlc r1 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r1 = (com.google.android.gms.internal.measurement.zzjt) r1     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r1 = (com.google.android.gms.internal.measurement.zzfy.zzf) r1     // Catch:{ all -> 0x1208 }
            r6.add(r1)     // Catch:{ all -> 0x1208 }
            boolean r1 = r10.booleanValue()     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0f30
            java.lang.Long r1 = r2.zzi     // Catch:{ all -> 0x1208 }
            if (r1 != 0) goto L_0x0f24
            java.lang.Long r1 = r2.zzj     // Catch:{ all -> 0x1208 }
            if (r1 != 0) goto L_0x0f24
            java.lang.Boolean r1 = r2.zzk     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0f30
        L_0x0f24:
            r1 = 0
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r1, r1, r1)     // Catch:{ all -> 0x1208 }
            java.lang.String r1 = r9.zze()     // Catch:{ all -> 0x1208 }
            r5.put(r1, r2)     // Catch:{ all -> 0x1208 }
        L_0x0f30:
            r0.zza((int) r8, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9)     // Catch:{ all -> 0x1208 }
            goto L_0x0dbe
        L_0x0f35:
            int r12 = r7.nextInt(r1)     // Catch:{ all -> 0x1208 }
            if (r12 != 0) goto L_0x0f76
            r46.zzp()     // Catch:{ all -> 0x1208 }
            long r12 = (long) r1     // Catch:{ all -> 0x1208 }
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9, (java.lang.String) r11, (java.lang.Object) r1)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r1 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r1 = (com.google.android.gms.internal.measurement.zzjt) r1     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r1 = (com.google.android.gms.internal.measurement.zzfy.zzf) r1     // Catch:{ all -> 0x1208 }
            r6.add(r1)     // Catch:{ all -> 0x1208 }
            boolean r1 = r10.booleanValue()     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0f60
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1208 }
            r3 = 0
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r3, r1, r3)     // Catch:{ all -> 0x1208 }
        L_0x0f60:
            java.lang.String r1 = r9.zze()     // Catch:{ all -> 0x1208 }
            long r10 = r9.zzc()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r10, r14)     // Catch:{ all -> 0x1208 }
            r5.put(r1, r2)     // Catch:{ all -> 0x1208 }
            r49 = r7
            r1 = r8
            r18 = 1
            goto L_0x0ff9
        L_0x0f76:
            java.lang.Long r12 = r2.zzh     // Catch:{ all -> 0x1208 }
            if (r12 == 0) goto L_0x0f85
            java.lang.Long r12 = r2.zzh     // Catch:{ all -> 0x1208 }
            long r12 = r12.longValue()     // Catch:{ all -> 0x1208 }
            r49 = r7
            r16 = r8
            goto L_0x0f96
        L_0x0f85:
            r46.zzq()     // Catch:{ all -> 0x1208 }
            long r12 = r9.zzb()     // Catch:{ all -> 0x1208 }
            r49 = r7
            r16 = r8
            r7 = r20
            long r12 = com.google.android.gms.measurement.internal.zzos.zza((long) r12, (long) r7)     // Catch:{ all -> 0x1208 }
        L_0x0f96:
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 == 0) goto L_0x0fe3
            r46.zzp()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "_efs"
            r18 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9, (java.lang.String) r3, (java.lang.Object) r7)     // Catch:{ all -> 0x1208 }
            r46.zzp()     // Catch:{ all -> 0x1208 }
            long r7 = (long) r1     // Catch:{ all -> 0x1208 }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzoo.zza((com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9, (java.lang.String) r11, (java.lang.Object) r1)     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r1 = r9.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r1 = (com.google.android.gms.internal.measurement.zzjt) r1     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzf r1 = (com.google.android.gms.internal.measurement.zzfy.zzf) r1     // Catch:{ all -> 0x1208 }
            r6.add(r1)     // Catch:{ all -> 0x1208 }
            boolean r1 = r10.booleanValue()     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0fd3
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x1208 }
            r26 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r26)     // Catch:{ all -> 0x1208 }
            r7 = 0
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r7, r1, r3)     // Catch:{ all -> 0x1208 }
        L_0x0fd3:
            java.lang.String r1 = r9.zze()     // Catch:{ all -> 0x1208 }
            long r7 = r9.zzc()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r7, r14)     // Catch:{ all -> 0x1208 }
            r5.put(r1, r2)     // Catch:{ all -> 0x1208 }
            goto L_0x0ff7
        L_0x0fe3:
            r18 = 1
            boolean r1 = r10.booleanValue()     // Catch:{ all -> 0x1208 }
            if (r1 == 0) goto L_0x0ff7
            java.lang.String r1 = r9.zze()     // Catch:{ all -> 0x1208 }
            r7 = 0
            com.google.android.gms.measurement.internal.zzbb r2 = r2.zza(r3, r7, r7)     // Catch:{ all -> 0x1208 }
            r5.put(r1, r2)     // Catch:{ all -> 0x1208 }
        L_0x0ff7:
            r1 = r16
        L_0x0ff9:
            r0.zza((int) r1, (com.google.android.gms.internal.measurement.zzfy.zzf.zza) r9)     // Catch:{ all -> 0x1208 }
        L_0x0ffc:
            int r8 = r1 + 1
            r1 = r46
            r2 = r47
            r7 = r49
            goto L_0x0d21
        L_0x1006:
            r47 = r2
            int r1 = r6.size()     // Catch:{ all -> 0x1208 }
            int r2 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r1 >= r2) goto L_0x1019
            com.google.android.gms.internal.measurement.zzfy$zzk$zza r1 = r0.zzl()     // Catch:{ all -> 0x1208 }
            r1.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfy.zzf>) r6)     // Catch:{ all -> 0x1208 }
        L_0x1019:
            java.util.Set r1 = r5.entrySet()     // Catch:{ all -> 0x1208 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x1208 }
        L_0x1021:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x103d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x1208 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r3 = r46.zzf()     // Catch:{ all -> 0x1208 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzbb r2 = (com.google.android.gms.measurement.internal.zzbb) r2     // Catch:{ all -> 0x1208 }
            r3.zza((com.google.android.gms.measurement.internal.zzbb) r2)     // Catch:{ all -> 0x1208 }
            goto L_0x1021
        L_0x103b:
            r47 = r2
        L_0x103d:
            com.google.android.gms.internal.measurement.zzfy$zzk r1 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r1 = r1.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzg r2 = r2.zze(r1)     // Catch:{ all -> 0x1208 }
            if (r2 != 0) goto L_0x1066
            com.google.android.gms.measurement.internal.zzgo r2 = r46.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r5 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x1208 }
            goto L_0x10ee
        L_0x1066:
            int r3 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r3 <= 0) goto L_0x10ee
            long r5 = r2.zzs()     // Catch:{ all -> 0x1208 }
            int r3 = (r5 > r47 ? 1 : (r5 == r47 ? 0 : -1))
            if (r3 == 0) goto L_0x1078
            r0.zzg((long) r5)     // Catch:{ all -> 0x1208 }
            goto L_0x107b
        L_0x1078:
            r0.zzo()     // Catch:{ all -> 0x1208 }
        L_0x107b:
            long r7 = r2.zzu()     // Catch:{ all -> 0x1208 }
            int r3 = (r7 > r47 ? 1 : (r7 == r47 ? 0 : -1))
            if (r3 != 0) goto L_0x1084
            goto L_0x1085
        L_0x1084:
            r5 = r7
        L_0x1085:
            int r3 = (r5 > r47 ? 1 : (r5 == r47 ? 0 : -1))
            if (r3 == 0) goto L_0x108d
            r0.zzh((long) r5)     // Catch:{ all -> 0x1208 }
            goto L_0x1090
        L_0x108d:
            r0.zzp()     // Catch:{ all -> 0x1208 }
        L_0x1090:
            boolean r3 = com.google.android.gms.internal.measurement.zzpu.zza()     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x10c0
            com.google.android.gms.measurement.internal.zzag r3 = r46.zze()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbh.zzbx     // Catch:{ all -> 0x1208 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r5)     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x10c0
            r46.zzq()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r2.zzac()     // Catch:{ all -> 0x1208 }
            boolean r3 = com.google.android.gms.measurement.internal.zzos.zzf(r3)     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x10c0
            int r3 = r0.zzc()     // Catch:{ all -> 0x1208 }
            long r5 = (long) r3     // Catch:{ all -> 0x1208 }
            r2.zza((long) r5)     // Catch:{ all -> 0x1208 }
            long r5 = r2.zzr()     // Catch:{ all -> 0x1208 }
            int r3 = (int) r5     // Catch:{ all -> 0x1208 }
            r0.zzg((int) r3)     // Catch:{ all -> 0x1208 }
            goto L_0x10c3
        L_0x10c0:
            r2.zzap()     // Catch:{ all -> 0x1208 }
        L_0x10c3:
            long r5 = r2.zzt()     // Catch:{ all -> 0x1208 }
            int r3 = (int) r5     // Catch:{ all -> 0x1208 }
            r0.zzf((int) r3)     // Catch:{ all -> 0x1208 }
            long r5 = r0.zzf()     // Catch:{ all -> 0x1208 }
            r2.zzr(r5)     // Catch:{ all -> 0x1208 }
            long r5 = r0.zze()     // Catch:{ all -> 0x1208 }
            r2.zzp(r5)     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r2.zzab()     // Catch:{ all -> 0x1208 }
            if (r3 == 0) goto L_0x10e3
            r0.zzn(r3)     // Catch:{ all -> 0x1208 }
            goto L_0x10e6
        L_0x10e3:
            r0.zzm()     // Catch:{ all -> 0x1208 }
        L_0x10e6:
            com.google.android.gms.measurement.internal.zzal r3 = r46.zzf()     // Catch:{ all -> 0x1208 }
            r7 = 0
            r3.zza((com.google.android.gms.measurement.internal.zzg) r2, (boolean) r7, (boolean) r7)     // Catch:{ all -> 0x1208 }
        L_0x10ee:
            int r2 = r0.zzc()     // Catch:{ all -> 0x1208 }
            if (r2 <= 0) goto L_0x114d
            com.google.android.gms.measurement.internal.zzhl r2 = r46.zzi()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r3 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = r3.zzz()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfr$zzd r2 = r2.zzc(r3)     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x1113
            boolean r3 = r2.zzr()     // Catch:{ all -> 0x1208 }
            if (r3 != 0) goto L_0x110b
            goto L_0x1113
        L_0x110b:
            long r2 = r2.zzc()     // Catch:{ all -> 0x1208 }
            r0.zzb((long) r2)     // Catch:{ all -> 0x1208 }
            goto L_0x113c
        L_0x1113:
            com.google.android.gms.internal.measurement.zzfy$zzk r2 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r2 = r2.zzaj()     // Catch:{ all -> 0x1208 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x1208 }
            if (r2 == 0) goto L_0x1125
            r2 = r24
            r0.zzb((long) r2)     // Catch:{ all -> 0x1208 }
            goto L_0x113c
        L_0x1125:
            com.google.android.gms.measurement.internal.zzgo r2 = r46.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzu()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzfy$zzk r5 = r4.zza     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1208 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x1208 }
        L_0x113c:
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzf()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzlc r0 = r0.zzai()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0     // Catch:{ all -> 0x1208 }
            com.google.android.gms.internal.measurement.zzfy$zzk r0 = (com.google.android.gms.internal.measurement.zzfy.zzk) r0     // Catch:{ all -> 0x1208 }
            r10 = r17
            r2.zza((com.google.android.gms.internal.measurement.zzfy.zzk) r0, (boolean) r10)     // Catch:{ all -> 0x1208 }
        L_0x114d:
            com.google.android.gms.measurement.internal.zzal r0 = r46.zzf()     // Catch:{ all -> 0x1208 }
            java.util.List<java.lang.Long> r2 = r4.zzb     // Catch:{ all -> 0x1208 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x1208 }
            r0.zzt()     // Catch:{ all -> 0x1208 }
            r0.zzal()     // Catch:{ all -> 0x1208 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x1208 }
            java.lang.String r4 = "rowid in ("
            r3.<init>(r4)     // Catch:{ all -> 0x1208 }
            r4 = 0
        L_0x1164:
            int r5 = r2.size()     // Catch:{ all -> 0x1208 }
            if (r4 >= r5) goto L_0x1181
            if (r4 == 0) goto L_0x1171
            java.lang.String r5 = ","
            r3.append(r5)     // Catch:{ all -> 0x1208 }
        L_0x1171:
            java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x1208 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x1208 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x1208 }
            r3.append(r5)     // Catch:{ all -> 0x1208 }
            int r4 = r4 + 1
            goto L_0x1164
        L_0x1181:
            java.lang.String r4 = ")"
            r3.append(r4)     // Catch:{ all -> 0x1208 }
            android.database.sqlite.SQLiteDatabase r4 = r0.e_()     // Catch:{ all -> 0x1208 }
            java.lang.String r5 = "raw_events"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x1208 }
            r7 = 0
            int r3 = r4.delete(r5, r3, r7)     // Catch:{ all -> 0x1208 }
            int r4 = r2.size()     // Catch:{ all -> 0x1208 }
            if (r3 == r4) goto L_0x11b4
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r4 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x1208 }
            int r2 = r2.size()     // Catch:{ all -> 0x1208 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x1208 }
            r0.zza(r4, r3, r2)     // Catch:{ all -> 0x1208 }
        L_0x11b4:
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzf()     // Catch:{ all -> 0x1208 }
            android.database.sqlite.SQLiteDatabase r0 = r2.e_()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r7 = 2
            java.lang.String[] r4 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x11cd }
            r27 = 0
            r4[r27] = r1     // Catch:{ SQLiteException -> 0x11cd }
            r26 = 1
            r4[r26] = r1     // Catch:{ SQLiteException -> 0x11cd }
            r0.execSQL(r3, r4)     // Catch:{ SQLiteException -> 0x11cd }
            goto L_0x11df
        L_0x11cd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r2 = r2.zzj()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch:{ all -> 0x1208 }
            java.lang.String r3 = "Failed to remove unused event metadata. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r1)     // Catch:{ all -> 0x1208 }
            r2.zza(r3, r1, r0)     // Catch:{ all -> 0x1208 }
        L_0x11df:
            com.google.android.gms.measurement.internal.zzal r0 = r46.zzf()     // Catch:{ all -> 0x1208 }
            r0.zzw()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r0 = r46.zzf()
            r0.zzu()
            r26 = 1
            return r26
        L_0x11f0:
            com.google.android.gms.measurement.internal.zzal r0 = r46.zzf()     // Catch:{ all -> 0x1208 }
            r0.zzw()     // Catch:{ all -> 0x1208 }
            com.google.android.gms.measurement.internal.zzal r0 = r46.zzf()
            r0.zzu()
            r27 = 0
            return r27
        L_0x1201:
            r0 = move-exception
        L_0x1202:
            if (r5 == 0) goto L_0x1207
            r5.close()     // Catch:{ all -> 0x1208 }
        L_0x1207:
            throw r0     // Catch:{ all -> 0x1208 }
        L_0x1208:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r1 = r46.zzf()
            r1.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.zza(java.lang.String, long):boolean");
    }

    private final boolean zzad() {
        zzl().zzt();
        zzs();
        return zzf().zzx() || !TextUtils.isEmpty(zzf().f_());
    }

    private final boolean zzae() {
        zzl().zzt();
        FileLock fileLock = this.zzx;
        if (fileLock == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(zzcf.zza().zza(this.zzm.zza().getFilesDir(), "google_app_measurement.db")), "rw").getChannel();
                this.zzy = channel;
                FileLock tryLock = channel.tryLock();
                this.zzx = tryLock;
                if (tryLock != null) {
                    zzj().zzp().zza("Storage concurrent access okay");
                    return true;
                }
                zzj().zzg().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzj().zzg().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzj().zzg().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzj().zzu().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzj().zzp().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final boolean zza(zzfy.zzf.zza zza2, zzfy.zzf.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zze()));
        zzp();
        zzfy.zzh zza4 = zzoo.zza((zzfy.zzf) ((zzjt) zza2.zzai()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzh();
        }
        zzp();
        zzfy.zzh zza5 = zzoo.zza((zzfy.zzf) ((zzjt) zza3.zzai()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zza2.zze()));
        zzp();
        zzfy.zzh zza6 = zzoo.zza((zzfy.zzf) ((zzjt) zza2.zzai()), "_et");
        if (zza6 == null || !zza6.zzl() || zza6.zzd() <= 0) {
            return true;
        }
        long zzd2 = zza6.zzd();
        zzp();
        zzfy.zzh zza7 = zzoo.zza((zzfy.zzf) ((zzjt) zza3.zzai()), "_et");
        if (zza7 != null && zza7.zzd() > 0) {
            zzd2 += zza7.zzd();
        }
        zzp();
        zzoo.zza(zza3, "_et", (Object) Long.valueOf(zzd2));
        zzp();
        zzoo.zza(zza2, "_fr", (Object) 1L);
        return true;
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzl().zzt();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzj().zzg().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            zzj().zzg().zza("Failed to write to channel", e);
            return false;
        }
    }
}
