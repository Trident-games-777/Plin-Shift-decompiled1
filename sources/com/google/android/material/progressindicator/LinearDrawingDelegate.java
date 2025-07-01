package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float totalTrackLengthFraction;
    private float trackLength = 300.0f;
    private boolean useStrokeCap;

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return -1;
    }

    LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        this.trackLength = (float) rect.width();
        float f2 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(((float) rect.left) + (((float) rect.width()) / 2.0f), ((float) rect.top) + (((float) rect.height()) / 2.0f) + Math.max(0.0f, (((float) rect.height()) - f2) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f3 = this.trackLength / 2.0f;
        float f4 = f2 / 2.0f;
        canvas.clipRect(-f3, -f4, f3, f4);
        this.useStrokeCap = ((LinearProgressIndicatorSpec) this.spec).trackThickness / 2 == ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * f;
        this.displayedCornerRadius = ((float) Math.min(((LinearProgressIndicatorSpec) this.spec).trackThickness / 2, ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius)) * f;
        if (z || z2) {
            if ((z && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (1.0f - f)) / 2.0f);
            }
        }
        if (!z2 || ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f;
        }
    }

    /* access modifiers changed from: package-private */
    public void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        drawLine(canvas2, paint2, activeIndicator.startFraction, activeIndicator.endFraction, MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i), activeIndicator.gapSize, activeIndicator.gapSize);
    }

    /* access modifiers changed from: package-private */
    public void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        drawLine(canvas, paint, f, f2, MaterialColors.compositeARGBWithAlpha(i, i2), i3, i3);
    }

    private void drawLine(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        float f3;
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        float clamp2 = MathUtils.clamp(f2, 0.0f, 1.0f);
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp2);
        float f4 = this.trackLength;
        int clamp3 = (int) ((lerp * f4) + ((float) ((int) ((((float) i2) * MathUtils.clamp(lerp, 0.0f, 0.01f)) / 0.01f))));
        int clamp4 = (int) ((lerp2 * f4) - ((float) ((int) ((((float) i3) * (1.0f - MathUtils.clamp(lerp2, 0.99f, 1.0f))) / 0.01f))));
        float f5 = (-f4) / 2.0f;
        if (clamp3 <= clamp4) {
            float f6 = this.displayedCornerRadius;
            float f7 = ((float) clamp3) + f6;
            float f8 = ((float) clamp4) - f6;
            float f9 = f6 * 2.0f;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (f7 >= f8) {
                drawRoundedBlock(canvas, paint, new PointF(f7 + f5, 0.0f), new PointF(f8 + f5, 0.0f), f9, this.displayedTrackThickness);
                return;
            }
            float f10 = f9;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f11 = f7 + f5;
            float f12 = f8 + f5;
            canvas.drawLine(f11, 0.0f, f12, 0.0f, paint);
            float f13 = f11;
            float f14 = f12;
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                if (f7 > 0.0f) {
                    f3 = f10;
                    drawRoundedBlock(canvas, paint, new PointF(f13, 0.0f), f3, this.displayedTrackThickness);
                } else {
                    f3 = f10;
                }
                if (f8 < this.trackLength) {
                    drawRoundedBlock(canvas, paint, new PointF(f14, 0.0f), f3, this.displayedTrackThickness);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && compositeARGBWithAlpha != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(compositeARGBWithAlpha);
            drawRoundedBlock(canvas, paint, new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f), (float) ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize, (float) ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize);
        }
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF pointF, float f, float f2) {
        drawRoundedBlock(canvas, paint, pointF, (PointF) null, f, f2);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f, float f2) {
        float min = Math.min(f2, this.displayedTrackThickness);
        float f3 = f / 2.0f;
        float min2 = Math.min(f3, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-min) / 2.0f, f3, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
