package com.google.android.gms.internal.base;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
public final class zak extends Drawable implements Drawable.Callback {
    private int zaa;
    private long zab;
    private int zac;
    private int zad;
    private int zae;
    private int zaf;
    private boolean zag;
    private boolean zah;
    private zaj zai;
    private Drawable zaj;
    private Drawable zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private int zao;

    public zak(Drawable drawable, Drawable drawable2) {
        this((zaj) null);
        drawable = drawable == null ? zai.zaa : drawable;
        this.zaj = drawable;
        drawable.setCallback(this);
        zaj zaj2 = this.zai;
        zaj2.zab = drawable.getChangingConfigurations() | zaj2.zab;
        drawable2 = drawable2 == null ? zai.zaa : drawable2;
        this.zak = drawable2;
        drawable2.setCallback(this);
        zaj zaj3 = this.zai;
        zaj3.zab = drawable2.getChangingConfigurations() | zaj3.zab;
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zaj zaj2 = this.zai;
        return changingConfigurations | zaj2.zaa | zaj2.zab;
    }

    public final Drawable.ConstantState getConstantState() {
        if (!zac()) {
            return null;
        }
        this.zai.zaa = getChangingConfigurations();
        return this.zai;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zaj.getIntrinsicHeight(), this.zak.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zaj.getIntrinsicWidth(), this.zak.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zan) {
            this.zao = Drawable.resolveOpacity(this.zaj.getOpacity(), this.zak.getOpacity());
            this.zan = true;
        }
        return this.zao;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (this.zah || super.mutate() != this) {
            return this;
        }
        if (zac()) {
            this.zaj.mutate();
            this.zak.mutate();
            this.zah = true;
            return this;
        }
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.zaj.setBounds(rect);
        this.zak.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.zaf == this.zad) {
            this.zaf = i;
        }
        this.zad = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zaj.setColorFilter(colorFilter);
        this.zak.setColorFilter(colorFilter);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.zak;
    }

    public final void zab(int i) {
        this.zac = this.zad;
        this.zaf = 0;
        this.zae = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.zaa = 1;
        invalidateSelf();
    }

    public final boolean zac() {
        if (!this.zal) {
            boolean z = false;
            if (!(this.zaj.getConstantState() == null || this.zak.getConstantState() == null)) {
                z = true;
            }
            this.zam = z;
            this.zal = true;
        }
        return this.zam;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (r0 == 0) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            int r0 = r7.zaa
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L_0x003a
            if (r0 == r1) goto L_0x000b
        L_0x0009:
            r4 = r3
            goto L_0x0043
        L_0x000b:
            long r0 = r7.zab
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0009
            long r0 = android.os.SystemClock.uptimeMillis()
            long r4 = r7.zab
            long r0 = r0 - r4
            int r4 = r7.zae
            float r4 = (float) r4
            float r0 = (float) r0
            float r0 = r0 / r4
            r1 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 < 0) goto L_0x0027
            r4 = r3
            goto L_0x0028
        L_0x0027:
            r4 = r2
        L_0x0028:
            if (r4 == 0) goto L_0x002c
            r7.zaa = r2
        L_0x002c:
            float r0 = java.lang.Math.min(r0, r1)
            int r1 = r7.zac
            float r1 = (float) r1
            float r1 = r1 * r0
            r0 = 0
            float r1 = r1 + r0
            int r0 = (int) r1
            r7.zaf = r0
            goto L_0x0043
        L_0x003a:
            long r4 = android.os.SystemClock.uptimeMillis()
            r7.zab = r4
            r7.zaa = r1
            r4 = r2
        L_0x0043:
            int r0 = r7.zaf
            boolean r1 = r7.zag
            android.graphics.drawable.Drawable r5 = r7.zaj
            android.graphics.drawable.Drawable r6 = r7.zak
            if (r4 == 0) goto L_0x0062
            if (r1 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0057
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            r5.draw(r8)
            r0 = r2
        L_0x0057:
            int r1 = r7.zad
            if (r0 != r1) goto L_0x0061
            r6.setAlpha(r1)
            r6.draw(r8)
        L_0x0061:
            return
        L_0x0062:
            if (r1 == 0) goto L_0x006b
            int r1 = r7.zad
            int r1 = r1 - r0
            r5.setAlpha(r1)
            r2 = r3
        L_0x006b:
            r5.draw(r8)
            if (r2 == 0) goto L_0x0075
            int r1 = r7.zad
            r5.setAlpha(r1)
        L_0x0075:
            if (r0 <= 0) goto L_0x0082
            r6.setAlpha(r0)
            r6.draw(r8)
            int r8 = r7.zad
            r6.setAlpha(r8)
        L_0x0082:
            r7.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.base.zak.draw(android.graphics.Canvas):void");
    }

    zak(zaj zaj2) {
        this.zaa = 0;
        this.zad = 255;
        this.zaf = 0;
        this.zag = true;
        this.zai = new zaj(zaj2);
    }
}
