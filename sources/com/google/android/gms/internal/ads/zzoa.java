package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzoa implements zzlw {
    private final zzdc zza;
    private final zzbt zzb;
    private final zzbu zzc = new zzbu();
    private final zznz zzd;
    private final SparseArray zze;
    private zzds zzf;
    private zzbp zzg;
    private zzdm zzh;
    private boolean zzi;

    public static /* synthetic */ void zzW(zzoa zzoa) {
        zzlx zzU = zzoa.zzU();
        zzoa.zzZ(zzU, 1028, new zzmb(zzU));
        zzoa.zzf.zze();
    }

    private final zzlx zzab(int i, zzur zzur) {
        zzbp zzbp = this.zzg;
        zzbp.getClass();
        if (zzur == null) {
            zzbv zzn = zzbp.zzn();
            if (i >= zzn.zzc()) {
                zzn = zzbv.zza;
            }
            return zzV(zzn, i, (zzur) null);
        } else if (this.zzd.zza(zzur) != null) {
            return zzaa(zzur);
        } else {
            return zzV(zzbv.zza, i, zzur);
        }
    }

    private final zzlx zzac() {
        return zzaa(this.zzd.zzd());
    }

    private final zzlx zzad() {
        return zzaa(this.zzd.zze());
    }

    private final zzlx zzae(zzbi zzbi) {
        zzur zzur;
        if (!(zzbi instanceof zzig) || (zzur = ((zzig) zzbi).zzh) == null) {
            return zzU();
        }
        return zzaa(zzur);
    }

    public final void zzA(zzad zzad, zzhy zzhy) {
        zzlx zzad2 = zzad();
        zzZ(zzad2, PointerIconCompat.TYPE_VERTICAL_TEXT, new zzno(zzad2, zzad, zzhy));
    }

    public final void zzB(long j) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_ALIAS, new zzmr(zzad, j));
    }

    public final void zzC(Exception exc) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zznw(zzad, exc));
    }

    public final void zzD(zzpo zzpo) {
        zzlx zzad = zzad();
        zzZ(zzad, 1031, new zznl(zzad, zzpo));
    }

    public final void zzE(zzpo zzpo) {
        zzlx zzad = zzad();
        zzZ(zzad, 1032, new zznv(zzad, zzpo));
    }

    public final void zzF(int i, long j, long j2) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_COPY, new zzmn(zzad, i, j, j2));
    }

    public final void zzG(int i, long j) {
        zzlx zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_ZOOM_IN, new zzmx(zzac, i, j));
    }

    public final void zzH(Object obj, long j) {
        zzlx zzad = zzad();
        zzZ(zzad, 26, new zzns(zzad, obj, j));
    }

    public final void zzI(int i, int i2, boolean z) {
        zzlx zzad = zzad();
        zzZ(zzad, 1033, new zzna(zzad, i, i2, z));
    }

    public final void zzJ(Exception exc) {
        zzlx zzad = zzad();
        zzZ(zzad, 1030, new zzmm(zzad, exc));
    }

    public final void zzK(String str, long j, long j2) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new zznu(zzad, str, j2, j));
    }

    public final void zzL(String str) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_ZOOM_OUT, new zzmw(zzad, str));
    }

    public final void zzM(zzhx zzhx) {
        zzlx zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_GRAB, new zznj(zzac, zzhx));
    }

    public final void zzN(zzhx zzhx) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new zznq(zzad, zzhx));
    }

    public final void zzO(long j, int i) {
        zzlx zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_GRABBING, new zznd(zzac, j, i));
    }

    public final void zzP(zzad zzad, zzhy zzhy) {
        zzlx zzad2 = zzad();
        zzZ(zzad2, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zznk(zzad2, zzad, zzhy));
    }

    public final void zzQ() {
        zzdm zzdm = this.zzh;
        zzdb.zzb(zzdm);
        zzdm zzdm2 = zzdm;
        zzdm.zzh(new zznr(this));
    }

    public final void zzR(zzlz zzlz) {
        this.zzf.zzf(zzlz);
    }

    public final void zzS(zzbp zzbp, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzdb.zzf(z);
        zzbp.getClass();
        zzbp zzbp2 = zzbp;
        this.zzg = zzbp;
        this.zzh = this.zza.zzd(looper, (Handler.Callback) null);
        this.zzf = this.zzf.zza(looper, new zzmp(this, zzbp));
    }

    /* access modifiers changed from: protected */
    public final zzlx zzU() {
        return zzaa(this.zzd.zzb());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final zzlx zzV(zzbv zzbv, int i, zzur zzur) {
        zzbv zzbv2 = zzbv;
        int i2 = i;
        boolean z = true;
        zzur zzur2 = true == zzbv2.zzo() ? null : zzur;
        long zzb2 = this.zza.zzb();
        if (!zzbv2.equals(this.zzg.zzn()) || i2 != this.zzg.zzd()) {
            z = false;
        }
        long j = 0;
        if (zzur2 == null || !zzur2.zzb()) {
            if (z) {
                j = this.zzg.zzj();
            } else if (!zzbv2.zzo()) {
                long j2 = zzbv2.zze(i2, this.zzc, 0).zzl;
                j = zzen.zzv(0);
            }
        } else if (z && this.zzg.zzb() == zzur2.zzb && this.zzg.zzc() == zzur2.zzc) {
            j = this.zzg.zzk();
        }
        return new zzlx(zzb2, zzbv2, i2, zzur2, j, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzX(zzbp zzbp, zzlz zzlz, zzz zzz) {
        zzlz.zzi(zzbp, new zzly(zzz, this.zze));
    }

    public final void zzY(int i, long j, long j2) {
        zzlx zzaa = zzaa(this.zzd.zzc());
        zzZ(zzaa, PointerIconCompat.TYPE_CELL, new zzmk(zzaa, i, j, j2));
    }

    /* access modifiers changed from: protected */
    public final void zzZ(zzlx zzlx, int i, zzdp zzdp) {
        this.zze.put(i, zzlx);
        zzds zzds = this.zzf;
        zzds.zzd(i, zzdp);
        zzds.zzc();
    }

    public final void zza(zzbl zzbl) {
        zzlx zzU = zzU();
        zzZ(zzU, 13, new zzmg(zzU, zzbl));
    }

    public final void zzaf(int i, zzur zzur, zzun zzun) {
        zzlx zzab = zzab(i, zzur);
        zzZ(zzab, PointerIconCompat.TYPE_WAIT, new zznc(zzab, zzun));
    }

    public final void zzag(int i, zzur zzur, zzui zzui, zzun zzun) {
        zzlx zzab = zzab(i, zzur);
        zzZ(zzab, PointerIconCompat.TYPE_HAND, new zzne(zzab, zzui, zzun));
    }

    public final void zzah(int i, zzur zzur, zzui zzui, zzun zzun) {
        zzlx zzab = zzab(i, zzur);
        zzZ(zzab, 1001, new zzni(zzab, zzui, zzun));
    }

    public final void zzai(int i, zzur zzur, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        zzlx zzab = zzab(i, zzur);
        zzZ(zzab, PointerIconCompat.TYPE_HELP, new zzmo(zzab, zzui, zzun, iOException, z));
    }

    public final void zzaj(int i, zzur zzur, zzui zzui, zzun zzun) {
        zzlx zzab = zzab(i, zzur);
        zzZ(zzab, 1000, new zzmf(zzab, zzui, zzun));
    }

    public final void zzb(boolean z) {
        zzlx zzU = zzU();
        zzZ(zzU, 3, new zzmd(zzU, z));
    }

    public final void zzc(boolean z) {
        zzlx zzU = zzU();
        zzZ(zzU, 7, new zzms(zzU, z));
    }

    public final void zzd(zzaw zzaw, int i) {
        zzlx zzU = zzU();
        zzZ(zzU, 1, new zzmi(zzU, zzaw, i));
    }

    public final void zze(zzba zzba) {
        zzlx zzU = zzU();
        zzZ(zzU, 14, new zznx(zzU, zzba));
    }

    public final void zzf(boolean z, int i) {
        zzlx zzU = zzU();
        zzZ(zzU, 5, new zzmz(zzU, z, i));
    }

    public final void zzg(zzbj zzbj) {
        zzlx zzU = zzU();
        zzZ(zzU, 12, new zzma(zzU, zzbj));
    }

    public final void zzh(int i) {
        zzlx zzU = zzU();
        zzZ(zzU, 4, new zznh(zzU, i));
    }

    public final void zzi(int i) {
        zzlx zzU = zzU();
        zzZ(zzU, 6, new zzmv(zzU, i));
    }

    public final void zzj(zzbi zzbi) {
        zzlx zzae = zzae(zzbi);
        zzZ(zzae, 10, new zznf(zzae, zzbi));
    }

    public final void zzk(zzbi zzbi) {
        zzlx zzae = zzae(zzbi);
        zzZ(zzae, 10, new zzmy(zzae, zzbi));
    }

    public final void zzl(boolean z, int i) {
        zzlx zzU = zzU();
        zzZ(zzU, -1, new zzmq(zzU, z, i));
    }

    public final void zzn(boolean z) {
        zzlx zzad = zzad();
        zzZ(zzad, 23, new zzmj(zzad, z));
    }

    public final void zzo(int i, int i2) {
        zzlx zzad = zzad();
        zzZ(zzad, 24, new zzny(zzad, i, i2));
    }

    public final void zzq(zzcd zzcd) {
        zzlx zzU = zzU();
        zzZ(zzU, 2, new zzmt(zzU, zzcd));
    }

    public final void zzr(zzci zzci) {
        zzlx zzad = zzad();
        zzZ(zzad, 25, new zznm(zzad, zzci));
    }

    public final void zzs(float f) {
        zzlx zzad = zzad();
        zzZ(zzad, 22, new zzml(zzad, f));
    }

    public final void zzt(zzlz zzlz) {
        this.zzf.zzb(zzlz);
    }

    public final void zzu() {
        if (!this.zzi) {
            zzlx zzU = zzU();
            this.zzi = true;
            zzZ(zzU, -1, new zznn(zzU));
        }
    }

    public final void zzv(Exception exc) {
        zzlx zzad = zzad();
        zzZ(zzad, 1029, new zznt(zzad, exc));
    }

    public final void zzw(String str, long j, long j2) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_TEXT, new zzmu(zzad, str, j2, j));
    }

    public final void zzx(String str) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_NO_DROP, new zzme(zzad, str));
    }

    public final void zzy(zzhx zzhx) {
        zzlx zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_ALL_SCROLL, new zzng(zzac, zzhx));
    }

    public final void zzz(zzhx zzhx) {
        zzlx zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_CROSSHAIR, new zzmc(zzad, zzhx));
    }

    private final zzlx zzaa(zzur zzur) {
        this.zzg.getClass();
        zzbv zza2 = zzur == null ? null : this.zzd.zza(zzur);
        if (zzur == null || zza2 == null) {
            int zzd2 = this.zzg.zzd();
            zzbv zzn = this.zzg.zzn();
            if (zzd2 >= zzn.zzc()) {
                zzn = zzbv.zza;
            }
            return zzV(zzn, zzd2, (zzur) null);
        }
        return zzV(zza2, zza2.zzn(zzur.zza, this.zzb).zzc, zzur);
    }

    public final void zzT(List list, zzur zzur) {
        zzbp zzbp = this.zzg;
        zzbp.getClass();
        zzbp zzbp2 = zzbp;
        this.zzd.zzh(list, zzur, zzbp);
    }

    public final void zzm(zzbn zzbn, zzbn zzbn2, int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zznz zznz = this.zzd;
        zzbp zzbp = this.zzg;
        zzbp.getClass();
        zzbp zzbp2 = zzbp;
        zznz.zzg(zzbp);
        zzlx zzU = zzU();
        zzZ(zzU, 11, new zznp(zzU, i, zzbn, zzbn2));
    }

    public final void zzp(zzbv zzbv, int i) {
        zzbp zzbp = this.zzg;
        zzbp.getClass();
        zzbp zzbp2 = zzbp;
        this.zzd.zzi(zzbp);
        zzlx zzU = zzU();
        zzZ(zzU, 0, new zzmh(zzU, i));
    }

    public zzoa(zzdc zzdc) {
        zzdc.getClass();
        zzdc zzdc2 = zzdc;
        this.zza = zzdc;
        this.zzf = new zzds(zzen.zzz(), zzdc, new zznb());
        zzbt zzbt = new zzbt();
        this.zzb = zzbt;
        this.zzd = new zznz(zzbt);
        this.zze = new SparseArray();
    }
}
