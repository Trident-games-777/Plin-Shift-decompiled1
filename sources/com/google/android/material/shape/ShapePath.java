package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public ShapePath(float f, float f2) {
        reset(f, f2);
    }

    public void reset(float f, float f2) {
        reset(f, f2, ANGLE_UP, 0.0f);
    }

    public void reset(float f, float f2, float f3, float f4) {
        setStartX(f);
        setStartY(f2);
        setEndX(f);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.x = f;
        float unused2 = pathLineOperation.y = f2;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f);
        setEndY(f2);
    }

    public void lineTo(float f, float f2, float f3, float f4) {
        if ((Math.abs(f - getEndX()) >= 0.001f || Math.abs(f2 - getEndY()) >= 0.001f) && (Math.abs(f - f3) >= 0.001f || Math.abs(f2 - f4) >= 0.001f)) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            float unused = pathLineOperation.x = f;
            float unused2 = pathLineOperation.y = f2;
            this.operations.add(pathLineOperation);
            PathLineOperation pathLineOperation2 = new PathLineOperation();
            float unused3 = pathLineOperation2.x = f3;
            float unused4 = pathLineOperation2.y = f4;
            this.operations.add(pathLineOperation2);
            InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
            if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
                lineTo(f, f2);
                lineTo(f3, f4);
                return;
            }
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f3);
            setEndY(f4);
            return;
        }
        lineTo(f3, f4);
    }

    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f);
        pathQuadOperation.setControlY(f2);
        pathQuadOperation.setEndX(f3);
        pathQuadOperation.setEndY(f4);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5;
        float f8 = f6;
        this.operations.add(new PathCubicOperation(f, f2, f3, f4, f7, f8));
        this.containsIncompatibleShadowOp = true;
        setEndX(f7);
        setEndY(f8);
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.setStartAngle(f5);
        pathArcOperation.setSweepAngle(f6);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f5, z ? (ANGLE_LEFT + f7) % 360.0f : f7);
        double d = (double) f7;
        setEndX(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))));
        setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() {
            public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                for (ShadowCompatOperation draw : arrayList) {
                    draw.draw(matrix2, shadowRenderer, i, canvas);
                }
            }
        };
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f, float f2) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f2);
    }

    /* access modifiers changed from: package-private */
    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    private void addConnectingShadowIfNecessary(float f) {
        if (getCurrentShadowAngle() != f) {
            float currentShadowAngle2 = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= ANGLE_LEFT) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                setCurrentShadowAngle(f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.startX;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.startY;
    }

    /* access modifiers changed from: package-private */
    public float getEndX() {
        return this.endX;
    }

    /* access modifiers changed from: package-private */
    public float getEndY() {
        return this.endY;
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setStartX(float f) {
        this.startX = f;
    }

    private void setStartY(float f) {
        this.startY = f;
    }

    private void setEndX(float f) {
        this.endX = f;
    }

    private void setEndY(float f) {
        this.endY = f;
    }

    private void setCurrentShadowAngle(float f) {
        this.currentShadowAngle = f;
    }

    private void setEndShadowAngle(float f) {
        this.endShadowAngle = f;
    }

    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);

        ShadowCompatOperation() {
        }

        public final void draw(ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i, canvas);
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.operation.y - this.startY), (double) (this.operation.x - this.startX)), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i);
        }

        /* access modifiers changed from: package-private */
        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation.y - this.startY) / (this.operation.x - this.startX))));
        }
    }

    static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f, float f2) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f;
            this.startY = f2;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            int i2;
            Matrix matrix2 = matrix;
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            int i3 = i;
            Canvas canvas2 = canvas;
            float sweepAngle = getSweepAngle();
            if (sweepAngle <= 0.0f) {
                double hypot = Math.hypot((double) (this.operation1.x - this.startX), (double) (this.operation1.y - this.startY));
                double hypot2 = Math.hypot((double) (this.operation2.x - this.operation1.x), (double) (this.operation2.y - this.operation1.y));
                float min = (float) Math.min((double) i3, Math.min(hypot, hypot2));
                double d = (double) min;
                double tan = Math.tan(Math.toRadians((double) ((-sweepAngle) / 2.0f))) * d;
                if (hypot > tan) {
                    RectF rectF = new RectF(0.0f, 0.0f, (float) (hypot - tan), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.startX, this.startY);
                    this.renderMatrix.preRotate(getStartAngle());
                    i2 = i;
                    shadowRenderer2.drawEdgeShadow(canvas2, this.renderMatrix, rectF, i2);
                } else {
                    i2 = i;
                }
                float f = min * 2.0f;
                RectF rectF2 = new RectF(0.0f, 0.0f, f, f);
                this.renderMatrix.set(matrix2);
                this.renderMatrix.preTranslate(this.operation1.x, this.operation1.y);
                this.renderMatrix.preRotate(getStartAngle());
                this.renderMatrix.preTranslate((float) ((-tan) - d), -2.0f * min);
                float[] fArr = {(float) (d + tan), f};
                ShadowRenderer shadowRenderer3 = shadowRenderer;
                double d2 = tan;
                float[] fArr2 = fArr;
                Canvas canvas3 = canvas;
                shadowRenderer3.drawInnerCornerShadow(canvas3, this.renderMatrix, rectF2, (int) min, 450.0f, sweepAngle, fArr2);
                if (hypot2 > d2) {
                    RectF rectF3 = new RectF(0.0f, 0.0f, (float) (hypot2 - d2), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.operation1.x, this.operation1.y);
                    this.renderMatrix.preRotate(getEndAngle());
                    this.renderMatrix.preTranslate((float) d2, 0.0f);
                    shadowRenderer3.drawEdgeShadow(canvas3, this.renderMatrix, rectF3, i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation1.y - this.startY) / (this.operation1.x - this.startX))));
        }

        /* access modifiers changed from: package-private */
        public float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation2.y - this.operation1.y) / (this.operation2.x - this.operation1.x))));
        }

        /* access modifiers changed from: package-private */
        public float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            return endAngle <= ShapePath.ANGLE_LEFT ? endAngle : endAngle - 360.0f;
        }
    }

    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            float access$800 = this.operation.getStartAngle();
            float access$900 = this.operation.getSweepAngle();
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            Canvas canvas2 = canvas;
            shadowRenderer2.drawCornerShadow(canvas2, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i, access$800, access$900);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */
        public float x;
        /* access modifiers changed from: private */
        public float y;

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }

        private float getEndX() {
            return this.endX;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f) {
            this.endX = f;
        }

        private float getControlY() {
            return this.controlY;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f) {
            this.controlY = f;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f) {
            this.endY = f;
        }

        private float getControlX() {
            return this.controlX;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f) {
            this.controlX = f;
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f, float f2, float f3, float f4) {
            setLeft(f);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        private void setLeft(float f) {
            this.left = f;
        }

        private void setTop(float f) {
            this.top = f;
        }

        private void setRight(float f) {
            this.right = f;
        }

        private void setBottom(float f) {
            this.bottom = f;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f) {
            this.startAngle = f;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f) {
            this.sweepAngle = f;
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
            setControlX1(f);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            Path path2 = path;
            path2.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path2.transform(matrix);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private void setControlX1(float f) {
            this.controlX1 = f;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private void setControlY1(float f) {
            this.controlY1 = f;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private void setControlX2(float f) {
            this.controlX2 = f;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private void setControlY2(float f) {
            this.controlY2 = f;
        }

        private float getEndX() {
            return this.endX;
        }

        private void setEndX(float f) {
            this.endX = f;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setEndY(float f) {
            this.endY = f;
        }
    }
}
