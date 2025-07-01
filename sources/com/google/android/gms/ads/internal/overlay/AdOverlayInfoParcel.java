package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcwz;
import com.google.android.gms.internal.ads.zzdel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    private static final AtomicLong zzy = new AtomicLong(0);
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap zzz = new ConcurrentHashMap();
    public final zzc zza;
    public final zza zzb;
    public final zzr zzc;
    public final zzcfk zzd;
    public final zzbij zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzac zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final VersionInfoParcel zzm;
    public final String zzn;
    public final zzl zzo;
    public final zzbih zzp;
    public final String zzq;
    public final String zzr;
    public final String zzs;
    public final zzcwz zzt;
    public final zzdel zzu;
    public final zzbsz zzv;
    public final boolean zzw;
    public final long zzx;

    public AdOverlayInfoParcel(zza zza2, zzr zzr2, zzbih zzbih, zzbij zzbij, zzac zzac, zzcfk zzcfk, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdel zzdel, zzbsz zzbsz, boolean z2) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzp = zzbih;
        this.zze = zzbij;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzac;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdel;
        this.zzv = zzbsz;
        this.zzw = z2;
        this.zzx = zzy.getAndIncrement();
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmC)).booleanValue()) {
                return null;
            }
            zzv.zzp().zzw(e, "AdOverlayInfoParcel.getFromIntent");
            return null;
        }
    }

    private static final IBinder zzc(Object obj) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmC)).booleanValue()) {
            return null;
        }
        return ObjectWrapper.wrap(obj).asBinder();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel2);
        SafeParcelWriter.writeParcelable(parcel2, 2, this.zza, i2, false);
        SafeParcelWriter.writeIBinder(parcel2, 3, zzc(this.zzb), false);
        SafeParcelWriter.writeIBinder(parcel2, 4, zzc(this.zzc), false);
        SafeParcelWriter.writeIBinder(parcel2, 5, zzc(this.zzd), false);
        SafeParcelWriter.writeIBinder(parcel2, 6, zzc(this.zze), false);
        SafeParcelWriter.writeString(parcel2, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel2, 8, this.zzg);
        SafeParcelWriter.writeString(parcel2, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel2, 10, zzc(this.zzi), false);
        SafeParcelWriter.writeInt(parcel2, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel2, 12, this.zzk);
        SafeParcelWriter.writeString(parcel2, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel2, 14, this.zzm, i2, false);
        SafeParcelWriter.writeString(parcel2, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel2, 17, this.zzo, i2, false);
        SafeParcelWriter.writeIBinder(parcel2, 18, zzc(this.zzp), false);
        SafeParcelWriter.writeString(parcel2, 19, this.zzq, false);
        SafeParcelWriter.writeString(parcel2, 24, this.zzr, false);
        SafeParcelWriter.writeString(parcel2, 25, this.zzs, false);
        SafeParcelWriter.writeIBinder(parcel2, 26, zzc(this.zzt), false);
        SafeParcelWriter.writeIBinder(parcel2, 27, zzc(this.zzu), false);
        SafeParcelWriter.writeIBinder(parcel2, 28, zzc(this.zzv), false);
        SafeParcelWriter.writeBoolean(parcel2, 29, this.zzw);
        SafeParcelWriter.writeLong(parcel2, 30, this.zzx);
        SafeParcelWriter.finishObjectHeader(parcel2, beginObjectHeader);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmC)).booleanValue()) {
            long j = this.zzx;
            ScheduledFuture schedule = zzcaj.zzd.schedule(new zzq(j), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzmE)).intValue(), TimeUnit.SECONDS);
            zzz.put(Long.valueOf(this.zzx), new zzp(this.zzb, this.zzc, this.zzd, this.zzp, this.zze, this.zzi, this.zzt, this.zzu, this.zzv, schedule));
        }
    }

    public AdOverlayInfoParcel(zza zza2, zzr zzr2, zzbih zzbih, zzbij zzbij, zzac zzac, zzcfk zzcfk, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdel zzdel, zzbsz zzbsz) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzp = zzbih;
        this.zze = zzbij;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzac;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdel;
        this.zzv = zzbsz;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zza zza2, zzr zzr2, zzac zzac, zzcfk zzcfk, int i, VersionInfoParcel versionInfoParcel, String str, zzl zzl2, String str2, String str3, String str4, zzcwz zzcwz, zzbsz zzbsz) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzaQ)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = str;
        this.zzo = zzl2;
        this.zzq = null;
        this.zzr = null;
        this.zzs = str4;
        this.zzt = zzcwz;
        this.zzu = null;
        this.zzv = zzbsz;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zza zza2, zzr zzr2, zzac zzac, zzcfk zzcfk, boolean z, int i, VersionInfoParcel versionInfoParcel, zzdel zzdel, zzbsz zzbsz) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzac;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdel;
        this.zzv = zzbsz;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    AdOverlayInfoParcel(zzc zzc2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, VersionInfoParcel versionInfoParcel, String str4, zzl zzl2, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z2, long j) {
        this.zza = zzc2;
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = versionInfoParcel;
        this.zzn = str4;
        this.zzo = zzl2;
        this.zzq = str5;
        this.zzr = str6;
        this.zzs = str7;
        this.zzw = z2;
        long j2 = j;
        this.zzx = j2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmC)).booleanValue()) {
            zzp zzp2 = (zzp) zzz.remove(Long.valueOf(j2));
            if (zzp2 != null) {
                this.zzb = zzp2.zza;
                this.zzc = zzp2.zzb;
                this.zzd = zzp2.zzc;
                this.zzp = zzp2.zzd;
                this.zze = zzp2.zze;
                this.zzt = zzp2.zzg;
                this.zzu = zzp2.zzh;
                this.zzv = zzp2.zzi;
                this.zzi = zzp2.zzf;
                zzp2.zzj.cancel(false);
                return;
            }
            throw new NullPointerException("AdOverlayObjects is null");
        }
        this.zzb = (zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcfk) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbih) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbij) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzi = (zzac) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzt = (zzcwz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzu = (zzdel) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzv = (zzbsz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
    }

    public AdOverlayInfoParcel(zzc zzc2, zza zza2, zzr zzr2, zzac zzac, VersionInfoParcel versionInfoParcel, zzcfk zzcfk, zzdel zzdel) {
        this.zza = zzc2;
        this.zzb = zza2;
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzac;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdel;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzr zzr2, zzcfk zzcfk, int i, VersionInfoParcel versionInfoParcel) {
        this.zzc = zzr2;
        this.zzd = zzcfk;
        this.zzj = 1;
        this.zzm = versionInfoParcel;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzcfk zzcfk, VersionInfoParcel versionInfoParcel, String str, String str2, int i, zzbsz zzbsz) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcfk;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = str2;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzbsz;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }
}
