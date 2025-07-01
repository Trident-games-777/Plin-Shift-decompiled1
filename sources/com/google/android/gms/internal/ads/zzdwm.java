package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdwm extends zzftg {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdwl zzf;
    private boolean zzg;

    zzdwm(Context context) {
        super("ShakeDetector", "ads");
        this.zza = context;
    }

    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziD)).booleanValue()) {
            float f = sensorEvent.values[0];
            float f2 = f / 9.80665f;
            float f3 = sensorEvent.values[1] / 9.80665f;
            float f4 = sensorEvent.values[2] / 9.80665f;
            if (((float) Math.sqrt((double) ((f2 * f2) + (f3 * f3) + (f4 * f4)))) >= ((Float) zzbe.zzc().zza(zzbcn.zziE)).floatValue()) {
                long currentTimeMillis = zzv.zzC().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzbe.zzc().zza(zzbcn.zziF)).intValue()) <= currentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzbe.zzc().zza(zzbcn.zziG)).intValue()) < currentTimeMillis) {
                        this.zze = 0;
                    }
                    zze.zza("Shake detected.");
                    this.zzd = currentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzdwl zzdwl = this.zzf;
                    if (zzdwl != null) {
                        if (i == ((Integer) zzbe.zzc().zza(zzbcn.zziH)).intValue()) {
                            zzdvk zzdvk = (zzdvk) zzdwl;
                            zzdvk.zzh(new zzdvh(zzdvk), zzdvj.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zziD     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x0015:
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006a }
            r1 = 1
            if (r0 != 0) goto L_0x0035
            android.content.Context r0 = r6.zza     // Catch:{ all -> 0x006a }
            java.lang.String r2 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x006a }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x006a }
            r6.zzb = r0     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = "Shake detection failed to initialize. Failed to obtain accelerometer."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x006a }
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x002f:
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x006a }
            r6.zzc = r0     // Catch:{ all -> 0x006a }
        L_0x0035:
            boolean r0 = r6.zzg     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0068
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0068
            android.hardware.Sensor r2 = r6.zzc     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0068
            r3 = 2
            r0.registerListener(r6, r2, r3)     // Catch:{ all -> 0x006a }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x006a }
            long r2 = r0.currentTimeMillis()     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zziF     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r4.zza(r0)     // Catch:{ all -> 0x006a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006a }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006a }
            long r4 = (long) r0     // Catch:{ all -> 0x006a }
            long r2 = r2 - r4
            r6.zzd = r2     // Catch:{ all -> 0x006a }
            r6.zzg = r1     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "Listening for shake gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwm.zzc():void");
    }

    public final void zzd(zzdwl zzdwl) {
        this.zzf = zzdwl;
    }
}
