package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgyr;
import com.google.android.gms.internal.ads.zzgyx;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public class zzgyr<MessageType extends zzgyx<MessageType, BuilderType>, BuilderType extends zzgyr<MessageType, BuilderType>> extends zzgwx<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    protected zzgyr(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = zza();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private MessageType zza() {
        return this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzhas.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ zzgwx zzaD(zzgwy zzgwy) {
        zzbi((zzgyx) zzgwy);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgwx zzaK(zzgxv zzgxv, zzgyh zzgyh) throws IOException {
        zzbk(zzgxv, zzgyh);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgwx zzaN(byte[] bArr, int i, int i2) throws zzgzm {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgwx zzaO(byte[] bArr, int i, int i2, zzgyh zzgyh) throws zzgzm {
        zzbm(bArr, i, i2, zzgyh);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzaW(zzgxv zzgxv, zzgyh zzgyh) throws IOException {
        zzbk(zzgxv, zzgyh);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzaZ(byte[] bArr, int i, int i2) throws zzgzm {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzba(byte[] bArr, int i, int i2, zzgyh zzgyh) throws zzgzm {
        zzbm(bArr, i, i2, zzgyh);
        return this;
    }

    public final BuilderType zzbg() {
        if (!this.zzb.zzcf()) {
            this.zza = zza();
            return this;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    /* renamed from: zzbh */
    public BuilderType zzaP() {
        BuilderType zzbb = zzbt().zzcZ();
        zzbb.zza = zzbs();
        return zzbb;
    }

    /* access modifiers changed from: protected */
    public BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgxv zzgxv, zzgyh zzgyh) throws IOException {
        zzbu();
        try {
            zzhas.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgxw.zzq(zzgxv), zzgyh);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzgzm {
        int i3 = zzgyh.zzb;
        int i4 = zzhas.zza;
        zzbm(bArr, i, i2, zzgyh.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgyh zzgyh) throws zzgzm {
        zzbu();
        try {
            zzhas.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgxd(zzgyh));
            return this;
        } catch (zzgzm e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* renamed from: zzbn */
    public final MessageType zzbr() {
        MessageType zzbo = zzbs();
        if (zzbo.zzbw()) {
            return zzbo;
        }
        throw zzbb(zzbo);
    }

    /* renamed from: zzbo */
    public MessageType zzbs() {
        if (!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzbW();
        return this.zza;
    }

    /* renamed from: zzbp */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzhah zzbq() {
        zzbg();
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzbu() {
        if (!this.zza.zzcf()) {
            zzbv();
        }
    }

    /* access modifiers changed from: protected */
    public void zzbv() {
        MessageType zza2 = zza();
        zzb(zza2, this.zza);
        this.zza = zza2;
    }

    public final boolean zzbw() {
        return zzgyx.zzce(this.zza, false);
    }
}
