package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.NotificationManagerCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzrc extends zzsy implements zzkp {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzpm zzc;
    private final zzpu zzd;
    private final zzsj zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzad zzi;
    private zzad zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    /* access modifiers changed from: private */
    public boolean zzn;
    private int zzo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzrc(Context context, zzsl zzsl, zzta zzta, boolean z, Handler handler, zzpn zzpn, zzpu zzpu) {
        super(1, zzsl, zzta, false, 44100.0f);
        zzsj zzsj = zzen.zza >= 35 ? new zzsj(zzsi.zza) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzpu;
        this.zze = zzsj;
        this.zzo = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        this.zzc = new zzpm(handler, zzpn);
        zzpu.zzq(new zzra(this, (zzrb) null));
    }

    private final int zzaQ(zzsq zzsq, zzad zzad) {
        if (!"OMX.google.raw.decoder".equals(zzsq.zza) || zzen.zza >= 24 || (zzen.zza == 23 && zzen.zzM(this.zzb))) {
            return zzad.zzp;
        }
        return -1;
    }

    private static List zzaR(zzta zzta, zzad zzad, boolean z, zzpu zzpu) throws zztf {
        zzsq zza;
        if (zzad.zzo == null) {
            return zzfzo.zzn();
        }
        if (!zzpu.zzA(zzad) || (zza = zztl.zza()) == null) {
            return zztl.zze(zzta, zzad, false, false);
        }
        return zzfzo.zzo(zza);
    }

    private final void zzaS() {
        long zzb2 = this.zzd.zzb(zzW());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzl) {
                zzb2 = Math.max(this.zzk, zzb2);
            }
            this.zzk = zzb2;
            this.zzl = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        zzsj zzsj;
        this.zzd.zzk();
        if (zzen.zza >= 35 && (zzsj = this.zze) != null) {
            zzsj.zzb();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        this.zzn = false;
        try {
            super.zzC();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzd.zzi();
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        zzaS();
        this.zzd.zzh();
    }

    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzW() {
        return super.zzW() && this.zzd.zzz();
    }

    public final boolean zzX() {
        return this.zzd.zzy() || super.zzX();
    }

    /* access modifiers changed from: protected */
    public final float zzZ(float f, zzad zzad, zzad[] zzadArr) {
        int i = -1;
        for (zzad zzad2 : zzadArr) {
            int i2 = zzad2.zzD;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public final long zza() {
        if (zzcV() == 2) {
            zzaS();
        }
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public final int zzaa(zzta zzta, zzad zzad) throws zztf {
        int i;
        boolean z;
        int i2 = 128;
        if (!zzbg.zzg(zzad.zzo)) {
            return 128;
        }
        int i3 = zzad.zzJ;
        boolean zzaP = zzaP(zzad);
        int i4 = 1;
        if (!zzaP || (i3 != 0 && zztl.zza() == null)) {
            i = 0;
        } else {
            zzoz zzd2 = this.zzd.zzd(zzad);
            if (!zzd2.zzb) {
                i = 0;
            } else {
                i = true != zzd2.zzc ? 512 : 1536;
                if (zzd2.zzd) {
                    i |= 2048;
                }
            }
            if (this.zzd.zzA(zzad)) {
                return i | 172;
            }
        }
        if ((!"audio/raw".equals(zzad.zzo) || this.zzd.zzA(zzad)) && this.zzd.zzA(zzen.zzA(2, zzad.zzC, zzad.zzD))) {
            List zzaR = zzaR(zzta, zzad, false, this.zzd);
            if (!zzaR.isEmpty()) {
                if (!zzaP) {
                    i4 = 2;
                } else {
                    zzsq zzsq = (zzsq) zzaR.get(0);
                    boolean zze2 = zzsq.zze(zzad);
                    if (!zze2) {
                        int i5 = 1;
                        while (true) {
                            if (i5 >= zzaR.size()) {
                                break;
                            }
                            zzsq zzsq2 = (zzsq) zzaR.get(i5);
                            if (zzsq2.zze(zzad)) {
                                z = false;
                                zze2 = true;
                                zzsq = zzsq2;
                                break;
                            }
                            i5++;
                        }
                    }
                    z = true;
                    int i6 = true != zze2 ? 3 : 4;
                    int i7 = 8;
                    if (zze2 && zzsq.zzf(zzad)) {
                        i7 = 16;
                    }
                    int i8 = true != zzsq.zzg ? 0 : 64;
                    if (true != z) {
                        i2 = 0;
                    }
                    return i6 | i7 | 32 | i8 | i2 | i;
                }
            }
        }
        return i4 | 128;
    }

    /* access modifiers changed from: protected */
    public final zzhy zzab(zzsq zzsq, zzad zzad, zzad zzad2) {
        int i;
        int i2;
        zzhy zzb2 = zzsq.zzb(zzad, zzad2);
        int i3 = zzb2.zze;
        if (zzaM(zzad2)) {
            i3 |= 32768;
        }
        if (zzaQ(zzsq, zzad2) > this.zzf) {
            i3 |= 64;
        }
        String str = zzsq.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzb2.zzd;
        }
        return new zzhy(str, zzad, zzad2, i2, i);
    }

    /* access modifiers changed from: protected */
    public final zzsk zzaf(zzsq zzsq, zzad zzad, MediaCrypto mediaCrypto, float f) {
        int zzaQ = zzaQ(zzsq, zzad);
        if (r0 != 1) {
            for (zzad zzad2 : zzT()) {
                if (zzsq.zzb(zzad, zzad2).zzd != 0) {
                    zzaQ = Math.max(zzaQ, zzaQ(zzsq, zzad2));
                }
            }
        }
        this.zzf = zzaQ;
        this.zzg = zzen.zza < 24 && "OMX.SEC.aac.dec".equals(zzsq.zza) && "samsung".equals(zzen.zzc) && (zzen.zzb.startsWith("zeroflte") || zzen.zzb.startsWith("herolte") || zzen.zzb.startsWith("heroqlte"));
        String str = zzsq.zza;
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzsq.zzc;
        int i = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        mediaFormat.setInteger("channel-count", zzad.zzC);
        mediaFormat.setInteger("sample-rate", zzad.zzD);
        zzdw.zzb(mediaFormat, zzad.zzr);
        zzdw.zza(mediaFormat, "max-input-size", i);
        if (zzen.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzen.zza != 23 || (!"ZTE B2017G".equals(zzen.zzd) && !"AXON 7 mini".equals(zzen.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzen.zza <= 28 && "audio/ac4".equals(zzad.zzo)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzen.zza >= 24 && this.zzd.zza(zzen.zzA(4, zzad.zzC, zzad.zzD)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (zzen.zza >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (zzen.zza >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzo));
        }
        this.zzj = (!"audio/raw".equals(zzsq.zzb) || "audio/raw".equals(zzad.zzo)) ? null : zzad;
        return zzsk.zza(zzsq, mediaFormat, zzad, (MediaCrypto) null, this.zze);
    }

    /* access modifiers changed from: protected */
    public final List zzag(zzta zzta, zzad zzad, boolean z) throws zztf {
        return zztl.zzf(zzaR(zzta, zzad, false, this.zzd), zzad);
    }

    /* access modifiers changed from: protected */
    public final void zzaj(zzhm zzhm) {
        zzad zzad;
        if (zzen.zza >= 29 && (zzad = zzhm.zza) != null && Objects.equals(zzad.zzo, "audio/opus") && zzaL()) {
            ByteBuffer byteBuffer = zzhm.zzf;
            byteBuffer.getClass();
            ByteBuffer byteBuffer2 = byteBuffer;
            zzad zzad2 = zzhm.zza;
            zzad2.getClass();
            zzad zzad3 = zzad2;
            int i = zzad2.zzF;
            if (byteBuffer.remaining() == 8) {
                this.zzd.zzr(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzak(Exception exc) {
        zzdt.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str, zzsk zzsk, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    /* access modifiers changed from: protected */
    public final void zzao() {
        this.zzl = true;
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        this.zzd.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzaq() throws zzig {
        try {
            this.zzd.zzj();
        } catch (zzpt e) {
            throw zzcY(e, e.zzc, e.zzb, true != zzaL() ? 5002 : 5003);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzas(zzad zzad) {
        zzn();
        return this.zzd.zzA(zzad);
    }

    public final zzbj zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzbj zzbj) {
        this.zzd.zzs(zzbj);
    }

    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    public final zzkp zzl() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzm = true;
        this.zzi = null;
        try {
            this.zzd.zzf();
            super.zzx();
        } catch (Throwable th) {
            super.zzx();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzy(boolean z, boolean z2) throws zzig {
        super.zzy(z, z2);
        this.zzc.zzh(this.zza);
        zzn();
        this.zzd.zzt(zzo());
        this.zzd.zzp(zzi());
    }

    /* access modifiers changed from: protected */
    public final void zzz(long j, boolean z) throws zzig {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzk = j;
        this.zzn = false;
        this.zzl = true;
    }

    /* access modifiers changed from: protected */
    public final zzhy zzac(zzkj zzkj) throws zzig {
        zzad zzad = zzkj.zza;
        zzad.getClass();
        zzad zzad2 = zzad;
        this.zzi = zzad;
        zzhy zzac = super.zzac(zzkj);
        this.zzc.zzi(zzad, zzac);
        return zzac;
    }

    /* access modifiers changed from: protected */
    public final boolean zzar(long j, long j2, zzsn zzsn, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzad zzad) throws zzig {
        byteBuffer.getClass();
        if (this.zzj != null && (i2 & 2) != 0) {
            zzsn.getClass();
            zzsn zzsn2 = zzsn;
            zzsn.zzo(i, false);
            return true;
        } else if (z) {
            if (zzsn != null) {
                zzsn.zzo(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        } else {
            try {
                if (!this.zzd.zzx(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zzsn != null) {
                    zzsn.zzo(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zzpq e) {
                zzad zzad2 = this.zzi;
                if (zzaL()) {
                    zzn();
                }
                throw zzcY(e, zzad2, e.zzb, 5001);
            } catch (zzpt e2) {
                if (zzaL()) {
                    zzn();
                }
                throw zzcY(e2, zzad, e2.zzb, 5002);
            }
        }
    }

    public final void zzu(int i, Object obj) throws zzig {
        zzsj zzsj;
        if (i == 2) {
            zzpu zzpu = this.zzd;
            obj.getClass();
            zzpu.zzw(((Float) obj).floatValue());
        } else if (i == 3) {
            zzg zzg2 = (zzg) obj;
            zzpu zzpu2 = this.zzd;
            zzg2.getClass();
            zzg zzg3 = zzg2;
            zzpu2.zzm(zzg2);
        } else if (i == 6) {
            zzh zzh2 = (zzh) obj;
            zzpu zzpu3 = this.zzd;
            zzh2.getClass();
            zzh zzh3 = zzh2;
            zzpu3.zzo(zzh2);
        } else if (i != 12) {
            if (i == 16) {
                obj.getClass();
                this.zzo = ((Integer) obj).intValue();
                zzsn zzaz = zzaz();
                if (zzaz != null && zzen.zza >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzo));
                    zzaz.zzq(bundle);
                }
            } else if (i == 9) {
                zzpu zzpu4 = this.zzd;
                obj.getClass();
                zzpu4.zzv(((Boolean) obj).booleanValue());
            } else if (i != 10) {
                super.zzu(i, obj);
            } else {
                obj.getClass();
                int intValue = ((Integer) obj).intValue();
                this.zzd.zzn(intValue);
                if (zzen.zza >= 35 && (zzsj = this.zze) != null) {
                    zzsj.zzd(intValue);
                }
            }
        } else if (zzen.zza >= 23) {
            zzqz.zza(this.zzd, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzan(zzad zzad, MediaFormat mediaFormat) throws zzig {
        int i;
        int[] iArr;
        int i2;
        zzad zzad2 = this.zzj;
        int[] iArr2 = null;
        boolean z = true;
        if (zzad2 != null) {
            zzad = zzad2;
        } else if (zzaz() != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(zzad.zzo)) {
                i = zzad.zzE;
            } else if (zzen.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.containsKey("v-bits-per-sample") ? zzen.zzn(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                i = mediaFormat.getInteger("pcm-encoding");
            }
            zzab zzab = new zzab();
            zzab.zzZ("audio/raw");
            zzab.zzT(i);
            zzab.zzG(zzad.zzF);
            zzab.zzH(zzad.zzG);
            zzab.zzS(zzad.zzl);
            Object obj = zzad.zzm;
            zzab.zzL(zzad.zza);
            zzab.zzN(zzad.zzb);
            zzab.zzO(zzad.zzc);
            zzab.zzP(zzad.zzd);
            zzab.zzab(zzad.zze);
            zzab.zzX(zzad.zzf);
            zzab.zzz(mediaFormat.getInteger("channel-count"));
            zzab.zzaa(mediaFormat.getInteger("sample-rate"));
            zzad zzaf = zzab.zzaf();
            if (this.zzg && zzaf.zzC == 6 && (i2 = zzad.zzC) < 6) {
                iArr2 = new int[i2];
                for (int i3 = 0; i3 < zzad.zzC; i3++) {
                    iArr2[i3] = i3;
                }
            } else if (this.zzh) {
                int i4 = zzaf.zzC;
                if (i4 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i4 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i4 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i4 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i4 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzad = zzaf;
        }
        try {
            if (zzen.zza >= 29) {
                if (zzaL()) {
                    zzn();
                }
                if (zzen.zza < 29) {
                    z = false;
                }
                zzdb.zzf(z);
            }
            this.zzd.zze(zzad, 0, iArr2);
        } catch (zzpp e) {
            throw zzcY(e, e.zza, false, 5001);
        }
    }
}
