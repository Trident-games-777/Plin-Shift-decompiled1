package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzfz;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzeb zzb;
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public final zzeb zza() {
        zzeb zzeb;
        synchronized (this.zza) {
            zzeb = this.zzb;
        }
        return zzeb;
    }

    public final void zzb(zzeb zzeb) {
        synchronized (this.zza) {
            this.zzb = zzeb;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb == null) {
                return 0;
            }
            try {
                int zzh = zzeb.zzh();
                return zzh;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb == null) {
                return false;
            }
            try {
                boolean zzo = zzeb.zzo();
                return zzo;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb == null) {
                return false;
            }
            try {
                boolean zzp = zzeb.zzp();
                return zzp;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb == null) {
                return true;
            }
            try {
                boolean zzq = zzeb.zzq();
                return zzq;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                try {
                    zzeb.zzj(z);
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                try {
                    zzeb.zzk();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                try {
                    zzeb.zzl();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                try {
                    zzeb.zzn();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfz zzfz;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                if (videoLifecycleCallbacks == null) {
                    zzfz = null;
                } else {
                    try {
                        zzfz = new zzfz(videoLifecycleCallbacks);
                    } catch (RemoteException e) {
                        zzm.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                        return;
                    }
                }
                zzeb.zzm(zzfz);
            }
        }
    }
}
