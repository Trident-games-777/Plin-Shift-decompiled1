package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.core.os.HandlerCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager;", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "(Landroidx/compose/ui/graphics/CanvasHolder;)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "handler", "Landroid/os/Handler;", "imageReader", "Landroid/media/ImageReader;", "layerSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "persistenceIterationInProgress", "", "postponedReleaseRequests", "Landroidx/collection/MutableObjectList;", "destroy", "", "hasImageReader", "persist", "layer", "persistLayers", "layers", "Landroidx/collection/ScatterSet;", "release", "updateLayerPersistence", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayerManager.android.kt */
public final class LayerManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean isRobolectric;
    private final CanvasHolder canvasHolder;
    private final Handler handler = HandlerCompat.createAsync(Looper.getMainLooper(), new LayerManager$$ExternalSyntheticLambda1(this));
    private ImageReader imageReader;
    private final MutableScatterSet<GraphicsLayer> layerSet = ScatterSetKt.mutableScatterSetOf();
    private boolean persistenceIterationInProgress;
    private MutableObjectList<GraphicsLayer> postponedReleaseRequests;

    public LayerManager(CanvasHolder canvasHolder2) {
        this.canvasHolder = canvasHolder2;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    /* access modifiers changed from: private */
    public static final boolean handler$lambda$0(LayerManager layerManager, Message message) {
        layerManager.persistLayers(layerManager.layerSet);
        return true;
    }

    public final void persist(GraphicsLayer graphicsLayer) {
        this.layerSet.add(graphicsLayer);
        if (!this.handler.hasMessages(0)) {
            this.handler.sendMessageAtFrontOfQueue(Message.obtain());
        }
    }

    public final void release(GraphicsLayer graphicsLayer) {
        if (this.persistenceIterationInProgress) {
            MutableObjectList<GraphicsLayer> mutableObjectList = this.postponedReleaseRequests;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(0, 1, (DefaultConstructorMarker) null);
                this.postponedReleaseRequests = mutableObjectList;
            }
            mutableObjectList.add(graphicsLayer);
        } else if (this.layerSet.remove(graphicsLayer)) {
            graphicsLayer.discardDisplayList$ui_graphics_release();
        }
    }

    private final void persistLayers(ScatterSet<GraphicsLayer> scatterSet) {
        ScatterSet<GraphicsLayer> scatterSet2 = scatterSet;
        if (scatterSet2.isNotEmpty() && !isRobolectric) {
            ImageReader imageReader2 = this.imageReader;
            if (imageReader2 == null) {
                imageReader2 = ImageReader.newInstance(1, 1, 1, 3);
                imageReader2.setOnImageAvailableListener(new LayerManager$$ExternalSyntheticLambda0(), this.handler);
                this.imageReader = imageReader2;
            }
            Surface surface = imageReader2.getSurface();
            Canvas lockHardwareCanvas = LockHardwareCanvasHelper.INSTANCE.lockHardwareCanvas(surface);
            this.persistenceIterationInProgress = true;
            CanvasHolder canvasHolder2 = this.canvasHolder;
            Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
            canvasHolder2.getAndroidCanvas().setInternalCanvas(lockHardwareCanvas);
            androidx.compose.ui.graphics.Canvas androidCanvas = canvasHolder2.getAndroidCanvas();
            lockHardwareCanvas.save();
            int i = 0;
            lockHardwareCanvas.clipRect(0, 0, 1, 1);
            Object[] objArr = scatterSet2.elements;
            long[] jArr = scatterSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = i; i4 < i3; i4++) {
                            if ((j & 255) < 128) {
                                ((GraphicsLayer) objArr[(i2 << 3) + i4]).drawForPersistence$ui_graphics_release(androidCanvas);
                            }
                            j >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        }
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    i = 0;
                }
            }
            lockHardwareCanvas.restore();
            canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.persistenceIterationInProgress = false;
            MutableObjectList<GraphicsLayer> mutableObjectList = this.postponedReleaseRequests;
            if (mutableObjectList != null && mutableObjectList.isNotEmpty()) {
                ObjectList objectList = mutableObjectList;
                Object[] objArr2 = objectList.content;
                int i5 = objectList._size;
                for (int i6 = 0; i6 < i5; i6++) {
                    release((GraphicsLayer) objArr2[i6]);
                }
                mutableObjectList.clear();
            }
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    /* access modifiers changed from: private */
    public static final void persistLayers$lambda$3$lambda$2(ImageReader imageReader2) {
        Image acquireLatestImage;
        if (imageReader2 != null && (acquireLatestImage = imageReader2.acquireLatestImage()) != null) {
            acquireLatestImage.close();
        }
    }

    public final void destroy() {
        ImageReader imageReader2 = this.imageReader;
        if (imageReader2 != null) {
            imageReader2.close();
        }
        this.imageReader = null;
    }

    public final boolean hasImageReader() {
        return this.imageReader != null;
    }

    public final void updateLayerPersistence() {
        destroy();
        persistLayers(this.layerSet);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager$Companion;", "", "()V", "isRobolectric", "", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayerManager.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRobolectric() {
            return LayerManager.isRobolectric;
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        isRobolectric = Intrinsics.areEqual((Object) lowerCase, (Object) "robolectric");
    }
}
