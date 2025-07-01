package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzof implements zzlz, zzog {
    private final Context zza;
    private final zzoh zzb;
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzbu zze = new zzbu();
    private final zzbt zzf = new zzbt();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzbi zzn;
    private zzoe zzo;
    private zzoe zzp;
    private zzoe zzq;
    private zzad zzr;
    private zzad zzs;
    private zzad zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzof(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zzod zzod = new zzod(zzod.zza);
        this.zzb = zzod;
        zzod.zzh(this);
    }

    public static zzof zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzof(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzen.zzl(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(j2);
            this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzad zzad, int i) {
        if (!Objects.equals(this.zzs, zzad)) {
            int i2 = this.zzs == null ? 1 : 0;
            this.zzs = zzad;
            zzx(0, j, zzad, i2);
        }
    }

    private final void zzu(long j, zzad zzad, int i) {
        if (!Objects.equals(this.zzt, zzad)) {
            int i2 = this.zzt == null ? 1 : 0;
            this.zzt = zzad;
            zzx(2, j, zzad, i2);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzbv zzbv, zzur zzur) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzur != null && (zza2 = zzbv.zza(zzur.zza)) != -1) {
            int i = 0;
            zzbv.zzd(zza2, this.zzf, false);
            zzbv.zze(this.zzf.zzc, this.zze, 0);
            zzar zzar = this.zze.zzd.zzb;
            int i2 = 2;
            if (zzar != null) {
                int zzo2 = zzen.zzo(zzar.zza);
                i = zzo2 != 0 ? zzo2 != 1 ? zzo2 != 2 ? 1 : 4 : 5 : 3;
            }
            builder.setStreamType(i);
            zzbu zzbu = this.zze;
            long j = zzbu.zzm;
            if (j != -9223372036854775807L && !zzbu.zzk && !zzbu.zzi && !zzbu.zzb()) {
                builder.setMediaDurationMillis(zzen.zzv(j));
            }
            if (true != this.zze.zzb()) {
                i2 = 1;
            }
            builder.setPlaybackType(i2);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzad zzad, int i) {
        if (!Objects.equals(this.zzr, zzad)) {
            int i2 = this.zzr == null ? 1 : 0;
            this.zzr = zzad;
            zzx(1, j, zzad, i2);
        }
    }

    private final void zzx(int i, long j, zzad zzad, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzad != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzad.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzad.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzad.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzad.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzad.zzu;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzad.zzv;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzad.zzC;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzad.zzD;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzad.zzd;
            if (str4 != null) {
                int i8 = zzen.zza;
                String[] split = str4.split("-", -1);
                Pair create = Pair.create(split[0], split.length >= 2 ? split[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                if (create.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) create.second);
                }
            }
            float f = zzad.zzw;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzoe zzoe) {
        if (zzoe == null) {
            return false;
        }
        return zzoe.zzc.equals(this.zzb.zze());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzlx zzlx, String str) {
        zzur zzur = zzlx.zzd;
        if (zzur == null || !zzur.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.5.0-alpha01");
            zzv(zzlx.zzb, zzlx.zzd);
        }
    }

    public final void zzd(zzlx zzlx, String str, boolean z) {
        zzur zzur = zzlx.zzd;
        if ((zzur == null || !zzur.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzlx zzlx, zzad zzad, zzhy zzhy) {
    }

    public final void zzf(zzlx zzlx, int i, long j, long j2) {
        long j3;
        zzur zzur = zzlx.zzd;
        if (zzur != null) {
            zzur zzur2 = zzur;
            String zzf2 = this.zzb.zzf(zzlx.zzb, zzur);
            Long l = (Long) this.zzh.get(zzf2);
            Long l2 = (Long) this.zzg.get(zzf2);
            HashMap hashMap = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap.put(zzf2, Long.valueOf(j3 + j));
            HashMap hashMap2 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap2.put(zzf2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzlx zzlx, zzun zzun) {
        zzur zzur = zzlx.zzd;
        if (zzur != null) {
            zzad zzad = zzun.zzb;
            zzad.getClass();
            zzad zzad2 = zzad;
            zzur zzur2 = zzur;
            zzoe zzoe = new zzoe(zzad, 0, this.zzb.zzf(zzlx.zzb, zzur));
            int i = zzun.zza;
            if (i != 0) {
                if (i == 1) {
                    this.zzp = zzoe;
                    return;
                } else if (i != 2) {
                    if (i == 3) {
                        this.zzq = zzoe;
                        return;
                    }
                    return;
                }
            }
            this.zzo = zzoe;
        }
    }

    public final /* synthetic */ void zzh(zzlx zzlx, int i, long j) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01f5, code lost:
        if (r8 != 1) goto L_0x01f9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzbp r20, com.google.android.gms.internal.ads.zzly r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            int r2 = r1.zzb()
            if (r2 != 0) goto L_0x000c
            goto L_0x03d3
        L_0x000c:
            r2 = 0
            r3 = r2
        L_0x000e:
            int r4 = r1.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0038
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzlx r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzoh r4 = r0.zzb
            r4.zzk(r6)
            goto L_0x0035
        L_0x0026:
            if (r4 != r5) goto L_0x0030
            com.google.android.gms.internal.ads.zzoh r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzj(r6, r5)
            goto L_0x0035
        L_0x0030:
            com.google.android.gms.internal.ads.zzoh r4 = r0.zzb
            r4.zzi(r6)
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0038:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzlx r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzbv r7 = r6.zzb
            com.google.android.gms.internal.ads.zzur r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x0051:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00cc
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzcd r7 = r20.zzo()
            com.google.android.gms.internal.ads.zzfzo r7 = r7.zza()
            int r12 = r7.size()
            r13 = r2
        L_0x006c:
            if (r13 >= r12) goto L_0x0092
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzcc r14 = (com.google.android.gms.internal.ads.zzcc) r14
            r15 = r2
        L_0x0075:
            int r5 = r14.zza
            int r16 = r13 + 1
            if (r15 >= r5) goto L_0x008d
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzad r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzw r5 = r5.zzs
            if (r5 == 0) goto L_0x008a
            goto L_0x0093
        L_0x008a:
            int r15 = r15 + 1
            goto L_0x0075
        L_0x008d:
            r13 = r16
            r5 = 11
            goto L_0x006c
        L_0x0092:
            r5 = r10
        L_0x0093:
            if (r5 == 0) goto L_0x00cc
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzen.zza
            r12 = r7
            android.media.metrics.PlaybackMetrics$Builder r12 = (android.media.metrics.PlaybackMetrics.Builder) r12
            r12 = r2
        L_0x009d:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c8
            com.google.android.gms.internal.ads.zzv r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzj.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b1
            r5 = r9
            goto L_0x00c9
        L_0x00b1:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzj.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00bb
            r5 = r6
            goto L_0x00c9
        L_0x00bb:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzj.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00c5
            r5 = 6
            goto L_0x00c9
        L_0x00c5:
            int r12 = r12 + 1
            goto L_0x009d
        L_0x00c8:
            r5 = r11
        L_0x00c9:
            r7.setDrmType(r5)
        L_0x00cc:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d9
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d9:
            com.google.android.gms.internal.ads.zzbi r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00e1
            goto L_0x027e
        L_0x00e1:
            android.content.Context r7 = r0.zza
            int r8 = r5.zza
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00ee
            r7 = 20
        L_0x00eb:
            r8 = r2
            goto L_0x0258
        L_0x00ee:
            r8 = r5
            com.google.android.gms.internal.ads.zzig r8 = (com.google.android.gms.internal.ads.zzig) r8
            int r12 = r8.zzc
            if (r12 != r11) goto L_0x00f7
            r12 = r11
            goto L_0x00f8
        L_0x00f7:
            r12 = r2
        L_0x00f8:
            int r8 = r8.zzg
            java.lang.Throwable r13 = r5.getCause()
            r13.getClass()
            r17 = r13
            java.lang.Throwable r17 = (java.lang.Throwable) r17
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01ef
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgw
            if (r8 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzgw r13 = (com.google.android.gms.internal.ads.zzgw) r13
            int r7 = r13.zzc
            r8 = r7
            r7 = 5
            goto L_0x0258
        L_0x0117:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgv
            if (r8 != 0) goto L_0x01ea
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzbh
            if (r8 == 0) goto L_0x0121
            goto L_0x01ea
        L_0x0121:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgu
            if (r8 != 0) goto L_0x01b7
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzhe
            if (r12 == 0) goto L_0x012b
            goto L_0x01b7
        L_0x012b:
            int r7 = r5.zza
            r8 = 1002(0x3ea, float:1.404E-42)
            if (r7 != r8) goto L_0x0134
            r7 = 21
            goto L_0x00eb
        L_0x0134:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzri
            if (r7 == 0) goto L_0x0182
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            r8 = r7
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r8 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r8 == 0) goto L_0x0156
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzen.zzm(r7)
            int r8 = zzr(r7)
            goto L_0x0222
        L_0x0156:
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 < r15) goto L_0x0161
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0161
            r7 = 27
            goto L_0x00eb
        L_0x0161:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x0168
            r7 = 24
            goto L_0x00eb
        L_0x0168:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0170
            r7 = 29
            goto L_0x00eb
        L_0x0170:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzrs
            if (r8 == 0) goto L_0x0176
            goto L_0x0205
        L_0x0176:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzrh
            if (r7 == 0) goto L_0x017e
            r7 = 28
            goto L_0x00eb
        L_0x017e:
            r7 = 30
            goto L_0x00eb
        L_0x0182:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzgr
            if (r7 == 0) goto L_0x01b2
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01b2
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            r8 = r7
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Throwable r7 = r7.getCause()
            boolean r8 = r7 instanceof android.system.ErrnoException
            r12 = 31
            if (r8 == 0) goto L_0x01ae
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01ae
            r7 = 32
            goto L_0x00eb
        L_0x01ae:
            r8 = r2
            r7 = r12
            goto L_0x0258
        L_0x01b2:
            r8 = r2
            r7 = r16
            goto L_0x0258
        L_0x01b7:
            com.google.android.gms.internal.ads.zzeb r7 = com.google.android.gms.internal.ads.zzeb.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01c5
            r8 = r2
            r7 = r9
            goto L_0x0258
        L_0x01c5:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01d1
            r8 = r2
            r7 = 6
            goto L_0x0258
        L_0x01d1:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01d9
            r8 = r2
            r7 = 7
            goto L_0x0258
        L_0x01d9:
            if (r8 == 0) goto L_0x01e5
            com.google.android.gms.internal.ads.zzgu r13 = (com.google.android.gms.internal.ads.zzgu) r13
            int r7 = r13.zzb
            if (r7 != r11) goto L_0x01e5
            r8 = r2
            r7 = 4
            goto L_0x0258
        L_0x01e5:
            r8 = r2
            r7 = 8
            goto L_0x0258
        L_0x01ea:
            r8 = r2
            r7 = 11
            goto L_0x0258
        L_0x01ef:
            if (r12 == 0) goto L_0x01f9
            r7 = 35
            if (r8 == 0) goto L_0x00eb
            if (r8 != r11) goto L_0x01f9
            goto L_0x00eb
        L_0x01f9:
            if (r12 == 0) goto L_0x0201
            if (r8 != r9) goto L_0x0201
            r7 = 15
            goto L_0x00eb
        L_0x0201:
            if (r12 == 0) goto L_0x0208
            if (r8 != r6) goto L_0x0208
        L_0x0205:
            r8 = r2
            r7 = r15
            goto L_0x0258
        L_0x0208:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzsu
            if (r7 == 0) goto L_0x0218
            com.google.android.gms.internal.ads.zzsu r13 = (com.google.android.gms.internal.ads.zzsu) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzen.zzm(r7)
            r8 = r7
            r7 = 13
            goto L_0x0258
        L_0x0218:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzsp
            r8 = 14
            if (r7 == 0) goto L_0x0228
            com.google.android.gms.internal.ads.zzsp r13 = (com.google.android.gms.internal.ads.zzsp) r13
            int r7 = r13.zzb
        L_0x0222:
            r18 = r8
            r8 = r7
            r7 = r18
            goto L_0x0258
        L_0x0228:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x022f
            r7 = r8
            goto L_0x00eb
        L_0x022f:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzpq
            if (r7 == 0) goto L_0x023a
            com.google.android.gms.internal.ads.zzpq r13 = (com.google.android.gms.internal.ads.zzpq) r13
            int r7 = r13.zza
            r8 = 17
            goto L_0x0222
        L_0x023a:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzpt
            if (r7 == 0) goto L_0x0245
            com.google.android.gms.internal.ads.zzpt r13 = (com.google.android.gms.internal.ads.zzpt) r13
            int r7 = r13.zza
            r8 = 18
            goto L_0x0222
        L_0x0245:
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x0254
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
            goto L_0x0222
        L_0x0254:
            r7 = 22
            goto L_0x00eb
        L_0x0258:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = new android.media.metrics.PlaybackErrorEvent$Builder
            r13.<init>()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x027e:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02aa
            com.google.android.gms.internal.ads.zzcd r5 = r20.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x029b
            if (r8 != 0) goto L_0x029b
            if (r5 == 0) goto L_0x02aa
            r5 = r11
        L_0x029b:
            if (r7 != 0) goto L_0x02a0
            r0.zzw(r3, r10, r2)
        L_0x02a0:
            if (r8 != 0) goto L_0x02a5
            r0.zzt(r3, r10, r2)
        L_0x02a5:
            if (r5 != 0) goto L_0x02aa
            r0.zzu(r3, r10, r2)
        L_0x02aa:
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02c2
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzo
            com.google.android.gms.internal.ads.zzad r7 = r5.zza
            int r8 = r7.zzv
            r12 = -1
            if (r8 == r12) goto L_0x02c2
            int r5 = r5.zzb
            r0.zzw(r3, r7, r2)
            r0.zzo = r10
        L_0x02c2:
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02d5
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzp
            com.google.android.gms.internal.ads.zzad r7 = r5.zza
            int r5 = r5.zzb
            r0.zzt(r3, r7, r2)
            r0.zzp = r10
        L_0x02d5:
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02e8
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzq
            com.google.android.gms.internal.ads.zzad r7 = r5.zza
            int r5 = r5.zzb
            r0.zzu(r3, r7, r2)
            r0.zzq = r10
        L_0x02e8:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzeb r5 = com.google.android.gms.internal.ads.zzeb.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0309;
                case 1: goto L_0x0306;
                case 2: goto L_0x0304;
                case 3: goto L_0x0302;
                case 4: goto L_0x0300;
                case 5: goto L_0x02fe;
                case 6: goto L_0x02f5;
                case 7: goto L_0x02fc;
                case 8: goto L_0x02f5;
                case 9: goto L_0x02f9;
                case 10: goto L_0x02f7;
                default: goto L_0x02f5;
            }
        L_0x02f5:
            r13 = r11
            goto L_0x030a
        L_0x02f7:
            r13 = 7
            goto L_0x030a
        L_0x02f9:
            r13 = 8
            goto L_0x030a
        L_0x02fc:
            r13 = r9
            goto L_0x030a
        L_0x02fe:
            r13 = 6
            goto L_0x030a
        L_0x0300:
            r13 = 5
            goto L_0x030a
        L_0x0302:
            r13 = 4
            goto L_0x030a
        L_0x0304:
            r13 = r6
            goto L_0x030a
        L_0x0306:
            r13 = r16
            goto L_0x030a
        L_0x0309:
            r13 = r2
        L_0x030a:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x032a
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x032a:
            int r5 = r20.zzf()
            if (r5 == r6) goto L_0x0332
            r0.zzu = r2
        L_0x0332:
            r5 = r20
            com.google.android.gms.internal.ads.zzlu r5 = (com.google.android.gms.internal.ads.zzlu) r5
            com.google.android.gms.internal.ads.zzig r5 = r5.zzC()
            r7 = 10
            if (r5 != 0) goto L_0x0341
            r0.zzv = r2
            goto L_0x0349
        L_0x0341:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0349
            r0.zzv = r11
        L_0x0349:
            int r2 = r20.zzf()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x0353
            r5 = 5
            goto L_0x039f
        L_0x0353:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x035a
            r5 = 13
            goto L_0x039f
        L_0x035a:
            r5 = 4
            if (r2 != r5) goto L_0x0360
            r5 = 11
            goto L_0x039f
        L_0x0360:
            r8 = 12
            if (r2 != r6) goto L_0x0381
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x037f
            if (r2 == r6) goto L_0x037f
            if (r2 != r8) goto L_0x036d
            goto L_0x037f
        L_0x036d:
            boolean r2 = r20.zzu()
            if (r2 != 0) goto L_0x0375
            r5 = 7
            goto L_0x039f
        L_0x0375:
            int r2 = r20.zzg()
            if (r2 == 0) goto L_0x037d
            r5 = r7
            goto L_0x039f
        L_0x037d:
            r5 = 6
            goto L_0x039f
        L_0x037f:
            r5 = r6
            goto L_0x039f
        L_0x0381:
            if (r2 != r9) goto L_0x0395
            boolean r2 = r20.zzu()
            if (r2 != 0) goto L_0x038a
            goto L_0x039f
        L_0x038a:
            int r2 = r20.zzg()
            if (r2 == 0) goto L_0x0393
            r5 = r16
            goto L_0x039f
        L_0x0393:
            r5 = r9
            goto L_0x039f
        L_0x0395:
            if (r2 != r11) goto L_0x039d
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x039d
            r5 = r8
            goto L_0x039f
        L_0x039d:
            int r5 = r0.zzl
        L_0x039f:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03c2
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03c2:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03d3
            com.google.android.gms.internal.ads.zzoh r3 = r0.zzb
            com.google.android.gms.internal.ads.zzlx r1 = r1.zzc(r2)
            r3.zzg(r1)
        L_0x03d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.zzi(com.google.android.gms.internal.ads.zzbp, com.google.android.gms.internal.ads.zzly):void");
    }

    public final void zzj(zzlx zzlx, zzui zzui, zzun zzun, IOException iOException, boolean z) {
    }

    public final /* synthetic */ void zzk(zzlx zzlx, int i) {
    }

    public final void zzl(zzlx zzlx, zzbi zzbi) {
        this.zzn = zzbi;
    }

    public final void zzm(zzlx zzlx, zzbn zzbn, zzbn zzbn2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    public final /* synthetic */ void zzn(zzlx zzlx, Object obj, long j) {
    }

    public final void zzo(zzlx zzlx, zzhx zzhx) {
        this.zzw += zzhx.zzg;
        this.zzx += zzhx.zze;
    }

    public final /* synthetic */ void zzp(zzlx zzlx, zzad zzad, zzhy zzhy) {
    }

    public final void zzq(zzlx zzlx, zzci zzci) {
        zzoe zzoe = this.zzo;
        if (zzoe != null) {
            zzad zzad = zzoe.zza;
            if (zzad.zzv == -1) {
                zzab zzb2 = zzad.zzb();
                zzb2.zzae(zzci.zzb);
                zzb2.zzJ(zzci.zzc);
                this.zzo = new zzoe(zzb2.zzaf(), 0, zzoe.zzc);
            }
        }
    }
}
