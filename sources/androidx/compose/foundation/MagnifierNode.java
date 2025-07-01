package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\b\u0010R\u001a\u00020\u000eH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020/H\u0016J\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0002J\u0001\u0010X\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\b\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020\u000eH\u0002J\f\u0010]\u001a\u00020\u000e*\u00020^H\u0016J\f\u0010_\u001a\u00020\u000e*\u00020`H\u0016R\u001a\u0010\u001b\u001a\u00020\t8BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0014\u001a\u00020\u0015X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u00020\u0015X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010/8B@BX\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u00020\rX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010GR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\u0016\u0010K\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010HR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", "F", "density", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "getElevation-D9Ej5fM", "setElevation-0680j_4", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "(J)V", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "onObservedReadsChanged", "recreateMagnifier", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    /* access modifiers changed from: private */
    public Channel<Unit> drawSignalChannel;
    private float elevation;
    private final MutableState layoutCoordinates$delegate;
    /* access modifiers changed from: private */
    public PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    /* access modifiers changed from: private */
    public long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory2);
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MagnifierNode(kotlin.jvm.functions.Function1 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, androidx.compose.foundation.PlatformMagnifierFactory r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r16 = this;
            r0 = r28
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r18
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r19
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001b
            r1 = 2143289344(0x7fc00000, float:NaN)
            r7 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r20
        L_0x001d:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0024
            r1 = 0
            r8 = r1
            goto L_0x0026
        L_0x0024:
            r8 = r21
        L_0x0026:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            androidx.compose.ui.unit.DpSize$Companion r1 = androidx.compose.ui.unit.DpSize.Companion
            long r1 = r1.m7218getUnspecifiedMYxV2XQ()
            r9 = r1
            goto L_0x0034
        L_0x0032:
            r9 = r22
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0040
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m7131getUnspecifiedD9Ej5fM()
            r11 = r1
            goto L_0x0042
        L_0x0040:
            r11 = r24
        L_0x0042:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r1.m7131getUnspecifiedD9Ej5fM()
            r12 = r1
            goto L_0x0050
        L_0x004e:
            r12 = r25
        L_0x0050:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0057
            r1 = 1
            r13 = r1
            goto L_0x0059
        L_0x0057:
            r13 = r26
        L_0x0059:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0065
            androidx.compose.foundation.PlatformMagnifierFactory$Companion r0 = androidx.compose.foundation.PlatformMagnifierFactory.Companion
            androidx.compose.foundation.PlatformMagnifierFactory r0 = r0.getForCurrentPlatform()
            r14 = r0
            goto L_0x0067
        L_0x0065:
            r14 = r27
        L_0x0067:
            r15 = 0
            r3 = r16
            r4 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.<init>(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, boolean, long, float, float, boolean, androidx.compose.foundation.PlatformMagnifierFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    public final long m312getSizeMYxV2XQ() {
        return this.size;
    }

    /* renamed from: setSize-EaSLcWc  reason: not valid java name */
    public final void m315setSizeEaSLcWc(long j) {
        this.size = j;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m310getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    /* renamed from: setCornerRadius-0680j_4  reason: not valid java name */
    public final void m313setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m311getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* renamed from: setElevation-0680j_4  reason: not valid java name */
    public final void m314setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory2) {
        this.platformMagnifierFactory = platformMagnifierFactory2;
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory2) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory2;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.Companion.m4002getUnspecifiedF1C5BW0();
    }

    /* access modifiers changed from: private */
    public final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates$delegate.getValue();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0  reason: not valid java name */
    private final long m309getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new MagnifierNode$anchorPositionInRoot$1(this));
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().m3997unboximpl() : Offset.Companion.m4002getUnspecifiedF1C5BW0();
    }

    /* renamed from: update-5F03MCQ  reason: not valid java name */
    public final void m316update5F03MCQ(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, boolean z, long j, float f2, float f3, boolean z2, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory2) {
        float f4 = f;
        boolean z3 = z;
        long j2 = j;
        float f5 = f2;
        float f6 = f3;
        boolean z4 = z2;
        PlatformMagnifierFactory platformMagnifierFactory3 = platformMagnifierFactory2;
        float f7 = this.zoom;
        long j3 = this.size;
        float f8 = this.cornerRadius;
        boolean z5 = this.useTextDefault;
        float f9 = this.elevation;
        boolean z6 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory4 = this.platformMagnifierFactory;
        View view2 = this.view;
        Density density2 = this.density;
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.zoom = f4;
        this.useTextDefault = z3;
        this.size = j2;
        this.cornerRadius = f5;
        this.elevation = f6;
        this.clippingEnabled = z4;
        this.onSizeChanged = function13;
        this.platformMagnifierFactory = platformMagnifierFactory3;
        DelegatableNode delegatableNode = this;
        View requireView = DelegatableNode_androidKt.requireView(delegatableNode);
        Density requireDensity = DelegatableNodeKt.requireDensity(delegatableNode);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(f4, f7) && !platformMagnifierFactory3.getCanUpdateZoom()) || !DpSize.m7206equalsimpl0(j2, j3) || !Dp.m7116equalsimpl0(f5, f8) || !Dp.m7116equalsimpl0(f6, f9) || z3 != z5 || z4 != z6 || !Intrinsics.areEqual((Object) platformMagnifierFactory3, (Object) platformMagnifierFactory4) || !Intrinsics.areEqual((Object) requireView, (Object) view2) || !Intrinsics.areEqual((Object) requireDensity, (Object) density2))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new MagnifierNode$onAttach$1(this, (Continuation<? super MagnifierNode$onAttach$1>) null), 3, (Object) null);
    }

    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new MagnifierNode$onObservedReadsChanged$1(this));
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View view2 = this.view;
        if (view2 == null) {
            view2 = DelegatableNode_androidKt.requireView(this);
        }
        View view3 = view2;
        this.view = view3;
        Density density2 = this.density;
        if (density2 == null) {
            density2 = DelegatableNodeKt.requireDensity(this);
        }
        Density density3 = density2;
        this.density = density3;
        this.magnifier = this.platformMagnifierFactory.m348createnHHXs2Y(view3, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density3, this.zoom);
        updateSizeIfNecessary();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateMagnifier() {
        /*
            r8 = this;
            androidx.compose.ui.unit.Density r0 = r8.density
            if (r0 != 0) goto L_0x000d
            r0 = r8
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            androidx.compose.ui.unit.Density r0 = androidx.compose.ui.node.DelegatableNodeKt.requireDensity(r0)
            r8.density = r0
        L_0x000d:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset> r1 = r8.sourceCenter
            java.lang.Object r1 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r1 = (androidx.compose.ui.geometry.Offset) r1
            long r1 = r1.m3997unboximpl()
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m4006isSpecifiedk4lQ0M(r1)
            if (r3 == 0) goto L_0x007d
            long r3 = r8.m309getAnchorPositionInRootF1C5BW0()
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m4006isSpecifiedk4lQ0M(r3)
            if (r3 == 0) goto L_0x007d
            long r3 = r8.m309getAnchorPositionInRootF1C5BW0()
            long r1 = androidx.compose.ui.geometry.Offset.m3992plusMKHz9U(r3, r1)
            r8.sourceCenterInRoot = r1
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset> r1 = r8.magnifierCenter
            if (r1 == 0) goto L_0x0060
            java.lang.Object r0 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r0 = (androidx.compose.ui.geometry.Offset) r0
            long r0 = r0.m3997unboximpl()
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3976boximpl(r0)
            long r1 = r0.m3997unboximpl()
            boolean r1 = androidx.compose.ui.geometry.OffsetKt.m4006isSpecifiedk4lQ0M(r1)
            if (r1 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            if (r0 == 0) goto L_0x0060
            long r0 = r0.m3997unboximpl()
            long r2 = r8.m309getAnchorPositionInRootF1C5BW0()
            long r0 = androidx.compose.ui.geometry.Offset.m3992plusMKHz9U(r2, r0)
            goto L_0x0066
        L_0x0060:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m4002getUnspecifiedF1C5BW0()
        L_0x0066:
            r5 = r0
            androidx.compose.foundation.PlatformMagnifier r0 = r8.magnifier
            if (r0 != 0) goto L_0x006e
            r8.recreateMagnifier()
        L_0x006e:
            androidx.compose.foundation.PlatformMagnifier r2 = r8.magnifier
            if (r2 == 0) goto L_0x0079
            long r3 = r8.sourceCenterInRoot
            float r7 = r8.zoom
            r2.m347updateWko1d7g(r3, r5, r7)
        L_0x0079:
            r8.updateSizeIfNecessary()
            return
        L_0x007d:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m4002getUnspecifiedF1C5BW0()
            r8.sourceCenterInRoot = r0
            androidx.compose.foundation.PlatformMagnifier r0 = r8.magnifier
            if (r0 == 0) goto L_0x008c
            r0.dismiss()
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.updateMagnifier():void");
    }

    private final void updateSizeIfNecessary() {
        Density density2;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null && (density2 = this.density) != null && !IntSize.m7280equalsimpl(platformMagnifier.m346getSizeYbymL2g(), this.previousSize)) {
            Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
            if (function1 != null) {
                function1.invoke(DpSize.m7197boximpl(density2.m7089toDpSizekrfVVM(IntSizeKt.m7295toSizeozmzZPI(platformMagnifier.m346getSizeYbymL2g()))));
            }
            this.previousSize = IntSize.m7275boximpl(platformMagnifier.m346getSizeYbymL2g());
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Channel<Unit> channel = this.drawSignalChannel;
        if (channel != null) {
            ChannelResult.m9357boximpl(channel.m9382trySendJP2dKIU(Unit.INSTANCE));
        }
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        setLayoutCoordinates(layoutCoordinates);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new MagnifierNode$applySemantics$1(this));
    }
}
