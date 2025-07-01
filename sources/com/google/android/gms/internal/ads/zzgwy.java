package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgwx;
import com.google.android.gms.internal.ads.zzgwy;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzgwy<MessageType extends zzgwy<MessageType, BuilderType>, BuilderType extends zzgwx<MessageType, BuilderType>> implements zzhai {
    protected int zzq = 0;

    protected static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgwx.zzbd(iterable, list);
    }

    protected static void zzaR(zzgxp zzgxp) throws IllegalArgumentException {
        if (!zzgxp.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdI(String str) {
        String name = getClass().getName();
        return "Serializing " + name + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int zzaL() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzaM(zzhbb zzhbb) {
        return zzaL();
    }

    public zzgxp zzaN() {
        try {
            int zzaY = zzaY();
            zzgxp zzgxp = zzgxp.zzb;
            byte[] bArr = new byte[zzaY];
            zzgxy zzgxy = new zzgxy(bArr, 0, zzaY);
            zzda(zzgxy);
            zzgxy.zzF();
            return new zzgxm(bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdI("ByteString"), e);
        }
    }

    public zzhan zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    /* access modifiers changed from: package-private */
    public zzhbm zzaP() {
        return new zzhbm(this);
    }

    /* access modifiers changed from: package-private */
    public void zzaS(int i) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) throws IOException {
        int zzaY = zzaY();
        zzgya zzgya = new zzgya(outputStream, zzgyc.zzB(zzgyc.zzD(zzaY) + zzaY));
        zzgya.zzu(zzaY);
        zzda(zzgya);
        zzgya.zzK();
    }

    public void zzaU(OutputStream outputStream) throws IOException {
        zzgya zzgya = new zzgya(outputStream, zzgyc.zzB(zzaY()));
        zzda(zzgya);
        zzgya.zzK();
    }

    public byte[] zzaV() {
        try {
            int zzaY = zzaY();
            byte[] bArr = new byte[zzaY];
            zzgxy zzgxy = new zzgxy(bArr, 0, zzaY);
            zzda(zzgxy);
            zzgxy.zzF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdI("byte array"), e);
        }
    }
}
