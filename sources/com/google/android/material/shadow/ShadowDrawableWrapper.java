package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners = true;
    final RectF contentBounds;
    float cornerRadius;
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty = true;
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public int getOpacity() {
        return -3;
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private static int toEven(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.addPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.cornerShadowPaint.setAlpha(i);
        this.edgeShadowPaint.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f);
        float even2 = (float) toEven(f2);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * SHADOW_MULTIPLIER);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.rawMaxShadowSize);
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f2))) : f * SHADOW_MULTIPLIER;
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - COS_45) * ((double) f2))) : f;
    }

    public void setCornerRadius(float f) {
        float round = (float) Math.round(f);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public final void setRotation(float f) {
        if (this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    private void drawShadow(Canvas canvas) {
        float f;
        int i;
        Canvas canvas2 = canvas;
        int save = canvas2.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f2 = this.cornerRadius;
        float f3 = (-f2) - this.shadowSize;
        float f4 = f2 * 2.0f;
        boolean z = this.contentBounds.width() - f4 > 0.0f;
        boolean z2 = this.contentBounds.height() - f4 > 0.0f;
        float f5 = this.rawShadowSize;
        float f6 = f2 / ((f5 - (0.5f * f5)) + f2);
        float f7 = f2 / ((f5 - (SHADOW_TOP_SCALE * f5)) + f2);
        float f8 = f2 / ((f5 - (f5 * 1.0f)) + f2);
        int save2 = canvas2.save();
        canvas2.translate(this.contentBounds.left + f2, this.contentBounds.top + f2);
        canvas2.scale(f6, f7);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f6, 1.0f);
            f = 1.0f;
            i = save2;
            canvas2.drawRect(0.0f, f3, this.contentBounds.width() - f4, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            f = 1.0f;
            i = save2;
        }
        canvas2.restoreToCount(i);
        int save3 = canvas2.save();
        canvas2.translate(this.contentBounds.right - f2, this.contentBounds.bottom - f2);
        canvas2.scale(f6, f8);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(f / f6, f);
            canvas2.drawRect(0.0f, f3, this.contentBounds.width() - f4, this.shadowSize + (-this.cornerRadius), this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas2.save();
        canvas2.translate(this.contentBounds.left + f2, this.contentBounds.bottom - f2);
        canvas2.scale(f6, f8);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f8, 1.0f);
            canvas2.drawRect(0.0f, f3, this.contentBounds.height() - f4, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas2.save();
        canvas2.translate(this.contentBounds.right - f2, this.contentBounds.top + f2);
        canvas2.scale(f6, f7);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f7, 1.0f);
            canvas2.drawRect(0.0f, f3, this.contentBounds.height() - f4, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(save);
    }

    private void buildShadowCorners() {
        float f = this.cornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.shadowSize;
        rectF2.inset(-f2, -f2);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.cornerRadius / f3;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.rawMaxShadowSize * SHADOW_MULTIPLIER;
        this.contentBounds.set(((float) rect.left) + this.rawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.rawMaxShadowSize, ((float) rect.bottom) - f);
        getDrawable().setBounds((int) this.contentBounds.left, (int) this.contentBounds.top, (int) this.contentBounds.right, (int) this.contentBounds.bottom);
        buildShadowCorners();
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.rawShadowSize, f);
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinWidth() {
        float f = this.rawMaxShadowSize;
        return (Math.max(f, this.cornerRadius + (f / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public float getMinHeight() {
        float f = this.rawMaxShadowSize;
        return (Math.max(f, this.cornerRadius + ((f * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f);
    }
}
