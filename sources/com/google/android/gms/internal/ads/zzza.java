package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzza extends Handler implements Runnable {
    final /* synthetic */ zzzg zza;
    private final zzzb zzb;
    private final long zzc;
    private zzyy zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzza(zzzg zzzg, Looper looper, zzzb zzzb, zzyy zzyy, int i, long j) {
        super(looper);
        this.zza = zzzg;
        this.zzb = zzzb;
        this.zzd = zzyy;
        this.zzc = j;
    }

    private final void zzd() {
        SystemClock.elapsedRealtime();
        zzyy zzyy = this.zzd;
        zzyy.getClass();
        zzyy zzyy2 = zzyy;
        this.zze = null;
        zzzg zzzg = this.zza;
        Executor zzd2 = zzzg.zzc;
        zzza zzc2 = zzzg.zze;
        zzc2.getClass();
        zzd2.execute(zzc2);
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            if (message.what == 1) {
                zzd();
            } else if (message.what != 4) {
                this.zza.zze = null;
                long j2 = this.zzc;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - j2;
                zzyy zzyy = this.zzd;
                zzyy.getClass();
                zzyy zzyy2 = zzyy;
                if (this.zzh) {
                    zzyy.zzJ(this.zzb, elapsedRealtime, j3, false);
                    return;
                }
                int i = message.what;
                if (i == 2) {
                    try {
                        zzyy.zzK(this.zzb, elapsedRealtime, j3);
                    } catch (RuntimeException e) {
                        RuntimeException runtimeException = e;
                        zzdt.zzd("LoadTask", "Unexpected exception handling load completed", runtimeException);
                        this.zza.zzf = new zzze(runtimeException);
                    }
                } else if (i == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i2 = this.zzf + 1;
                    this.zzf = i2;
                    zzyz zzu = zzyy.zzu(this.zzb, elapsedRealtime, j3, iOException, i2);
                    if (zzu.zza == 3) {
                        this.zza.zzf = this.zze;
                    } else if (zzu.zza != 2) {
                        if (zzu.zza == 1) {
                            this.zzf = 1;
                        }
                        if (zzu.zzb != -9223372036854775807L) {
                            j = zzu.zzb;
                        } else {
                            j = (long) Math.min((this.zzf - 1) * 1000, 5000);
                        }
                        zzc(j);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                String simpleName = this.zzb.getClass().getSimpleName();
                Trace.beginSection("load:" + simpleName);
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzdt.zzd("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(3, new zzze(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzdt.zzd("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(3, new zzze(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzdt.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzg();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        if (z) {
            this.zza.zze = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzyy zzyy = this.zzd;
            zzyy.getClass();
            zzyy zzyy2 = zzyy;
            zzyy.zzJ(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzdb.zzf(this.zza.zze == null);
        this.zza.zze = this;
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }
}
