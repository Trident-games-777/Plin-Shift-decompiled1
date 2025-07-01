package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\\\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010;\u001aH\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001am\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u00052\u0019\b\u0002\u0010?\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020&0@¢\u0006\u0002\bBH\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a0\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a:\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001aD\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a8\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aB\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010M\u001a6\u0010N\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a&\u0010U\u001a\u00020&*\u00020A2\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a6\u0010X\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010T\u001a>\u0010Z\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a>\u0010]\u001a\u00020&*\u00020A2\u0006\u0010^\u001a\u00020\u00012\u0006\u0010_\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b`\u0010a\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006b"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", "progress", "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "gapSize", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m7111constructorimpl(ProgressIndicatorTokens.INSTANCE.m3487getSizeD9Ej5fM() - Dp.m7111constructorimpl(ProgressIndicatorTokens.INSTANCE.m3490getTrackThicknessD9Ej5fM() * ((float) 2)));
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final Modifier IncreaseSemanticsBounds;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = ProgressIndicatorTokens.INSTANCE.m3490getTrackThicknessD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m7111constructorimpl((float) 240);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    /* access modifiers changed from: private */
    public static final float SemanticsBoundsPadding;
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2356LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0 r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = -1796992155(0xffffffff94e41365, float:-2.3029766E-26)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)96@4380L11,97@4443L16,100@4539L192:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            r9 = r21
            goto L_0x002b
        L_0x0019:
            r2 = r8 & 6
            r9 = r21
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changedInstance(r9)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r8
            goto L_0x002b
        L_0x002a:
            r2 = r8
        L_0x002b:
            r3 = r30 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r22
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r22
        L_0x0047:
            r5 = r8 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r30 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r23
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r23
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r7
            goto L_0x0062
        L_0x0060:
            r5 = r23
        L_0x0062:
            r7 = r8 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0079
            r7 = r30 & 8
            r10 = r25
            if (r7 != 0) goto L_0x0075
            boolean r7 = r1.changed((long) r10)
            if (r7 == 0) goto L_0x0075
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r2 = r2 | r7
            goto L_0x007b
        L_0x0079:
            r10 = r25
        L_0x007b:
            r7 = r30 & 16
            if (r7 == 0) goto L_0x0082
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0082:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r27
            boolean r13 = r1.changed((int) r12)
            if (r13 == 0) goto L_0x0091
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r2 = r2 | r13
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r13 = r2 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00af
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x00a4
            goto L_0x00af
        L_0x00a4:
            r1.skipToGroupEnd()
            r18 = r1
            r2 = r4
            r3 = r5
            r5 = r10
            r7 = r12
            goto L_0x0142
        L_0x00af:
            r1.startDefaults()
            r13 = r8 & 1
            if (r13 == 0) goto L_0x00d1
            boolean r13 = r1.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00bd
            goto L_0x00d1
        L_0x00bd:
            r1.skipToGroupEnd()
            r3 = r30 & 4
            if (r3 == 0) goto L_0x00c6
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c6:
            r3 = r30 & 8
            if (r3 == 0) goto L_0x00cc
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cc:
            r13 = r10
            r15 = r12
            r10 = r4
            r11 = r5
            goto L_0x0103
        L_0x00d1:
            if (r3 == 0) goto L_0x00d8
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00d9
        L_0x00d8:
            r3 = r4
        L_0x00d9:
            r4 = r30 & 4
            r13 = 6
            if (r4 == 0) goto L_0x00e7
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r4 = r4.getLinearColor(r1, r13)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00e8
        L_0x00e7:
            r4 = r5
        L_0x00e8:
            r6 = r30 & 8
            if (r6 == 0) goto L_0x00f4
            androidx.compose.material3.ProgressIndicatorDefaults r6 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r6.getLinearTrackColor(r1, r13)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00f4:
            if (r7 == 0) goto L_0x00ff
            androidx.compose.material3.ProgressIndicatorDefaults r6 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r6 = r6.m2344getLinearStrokeCapKaPHkGw()
            r15 = r6
            r13 = r10
            goto L_0x0101
        L_0x00ff:
            r13 = r10
            r15 = r12
        L_0x0101:
            r10 = r3
            r11 = r4
        L_0x0103:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0112
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:99)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x0112:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r16 = r0.m2343getLinearIndicatorTrackGapSizeD9Ej5fM()
            r0 = r2 & 14
            r3 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r19 = r0 | r2
            r20 = 64
            r17 = 0
            r18 = r1
            m2353LinearProgressIndicatorGJbTh5U(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013e:
            r2 = r10
            r3 = r11
            r5 = r13
            r7 = r15
        L_0x0142:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x0156
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1
            r1 = r21
            r9 = r30
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2356LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e9  */
    /* renamed from: LinearProgressIndicator-GJbTh5U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2353LinearProgressIndicatorGJbTh5U(kotlin.jvm.functions.Function0<java.lang.Float> r30, androidx.compose.ui.Modifier r31, long r32, long r34, int r36, float r37, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r1 = r30
            r10 = r40
            r0 = -339970038(0xffffffffebbc780a, float:-4.5568985E26)
            r2 = r39
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LinearProgressIndicator)P(4,3,0:c#ui.graphics.Color,6:c#ui.graphics.Color,5:c#ui.graphics.StrokeCap,2:c#ui.unit.Dp)140@6419L11,141@6482L16,144@6689L214,153@6935L31,157@7087L102,161@7259L806,154@6971L1094:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r41 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r5 = r41 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0043
            r6 = r31
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r31
        L_0x0045:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005c
            r7 = r41 & 4
            r11 = r32
            if (r7 != 0) goto L_0x0058
            boolean r7 = r2.changed((long) r11)
            if (r7 == 0) goto L_0x0058
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r3 = r3 | r7
            goto L_0x005e
        L_0x005c:
            r11 = r32
        L_0x005e:
            r7 = r10 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0075
            r7 = r41 & 8
            r13 = r34
            if (r7 != 0) goto L_0x0071
            boolean r7 = r2.changed((long) r13)
            if (r7 == 0) goto L_0x0071
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r3 = r3 | r7
            goto L_0x0077
        L_0x0075:
            r13 = r34
        L_0x0077:
            r7 = r41 & 16
            if (r7 == 0) goto L_0x007e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x007e:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0092
            r9 = r36
            boolean r16 = r2.changed((int) r9)
            if (r16 == 0) goto L_0x008d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r3 = r3 | r16
            goto L_0x0094
        L_0x0092:
            r9 = r36
        L_0x0094:
            r16 = r41 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x009f
            r3 = r3 | r17
            r4 = r37
            goto L_0x00b2
        L_0x009f:
            r17 = r10 & r17
            r4 = r37
            if (r17 != 0) goto L_0x00b2
            boolean r18 = r2.changed((float) r4)
            if (r18 == 0) goto L_0x00ae
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r18
        L_0x00b2:
            r18 = 1572864(0x180000, float:2.204052E-39)
            r19 = r10 & r18
            if (r19 != 0) goto L_0x00cc
            r19 = r41 & 64
            r0 = r38
            if (r19 != 0) goto L_0x00c7
            boolean r20 = r2.changedInstance(r0)
            if (r20 == 0) goto L_0x00c7
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c9
        L_0x00c7:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00c9:
            r3 = r3 | r20
            goto L_0x00ce
        L_0x00cc:
            r0 = r38
        L_0x00ce:
            r20 = 599187(0x92493, float:8.3964E-40)
            r15 = r3 & r20
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r8) goto L_0x00e9
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x00df
            goto L_0x00e9
        L_0x00df:
            r2.skipToGroupEnd()
            r8 = r4
            r5 = r6
            r7 = r9
            r3 = r11
            r9 = r0
            goto L_0x02c3
        L_0x00e9:
            r2.startDefaults()
            r8 = r10 & 1
            java.lang.String r15 = "CC(remember):ProgressIndicator.kt#9igjgp"
            r0 = 1
            if (r8 == 0) goto L_0x011a
            boolean r8 = r2.getDefaultsInvalid()
            if (r8 == 0) goto L_0x00fa
            goto L_0x011a
        L_0x00fa:
            r2.skipToGroupEnd()
            r5 = r41 & 4
            if (r5 == 0) goto L_0x0103
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0103:
            r5 = r41 & 8
            if (r5 == 0) goto L_0x0109
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0109:
            r5 = r41 & 64
            if (r5 == 0) goto L_0x0111
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r5
        L_0x0111:
            r7 = r38
            r23 = r4
            r5 = r6
            r22 = r9
            goto L_0x01a2
        L_0x011a:
            if (r5 == 0) goto L_0x0121
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0122
        L_0x0121:
            r5 = r6
        L_0x0122:
            r6 = r41 & 4
            r8 = 6
            if (r6 == 0) goto L_0x012f
            androidx.compose.material3.ProgressIndicatorDefaults r6 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r11 = r6.getLinearColor(r2, r8)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012f:
            r6 = r41 & 8
            if (r6 == 0) goto L_0x013b
            androidx.compose.material3.ProgressIndicatorDefaults r6 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r13 = r6.getLinearTrackColor(r2, r8)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x013b:
            if (r7 == 0) goto L_0x0144
            androidx.compose.material3.ProgressIndicatorDefaults r6 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r6 = r6.m2344getLinearStrokeCapKaPHkGw()
            goto L_0x0145
        L_0x0144:
            r6 = r9
        L_0x0145:
            if (r16 == 0) goto L_0x014d
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r4 = r4.m2343getLinearIndicatorTrackGapSizeD9Ej5fM()
        L_0x014d:
            r7 = r41 & 64
            if (r7 == 0) goto L_0x019c
            r7 = 1144997616(0x443f46f0, float:765.1084)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r15)
            r7 = r3 & 896(0x380, float:1.256E-42)
            r7 = r7 ^ 384(0x180, float:5.38E-43)
            r8 = 256(0x100, float:3.59E-43)
            if (r7 <= r8) goto L_0x0165
            boolean r7 = r2.changed((long) r11)
            if (r7 != 0) goto L_0x0169
        L_0x0165:
            r7 = r3 & 384(0x180, float:5.38E-43)
            if (r7 != r8) goto L_0x016b
        L_0x0169:
            r7 = r0
            goto L_0x016c
        L_0x016b:
            r7 = 0
        L_0x016c:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r3
            r9 = 16384(0x4000, float:2.2959E-41)
            if (r8 != r9) goto L_0x0176
            r8 = r0
            goto L_0x0177
        L_0x0176:
            r8 = 0
        L_0x0177:
            r7 = r7 | r8
            java.lang.Object r8 = r2.rememberedValue()
            if (r7 != 0) goto L_0x0186
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x0191
        L_0x0186:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1 r7 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
            r7.<init>(r11, r6)
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r2.updateRememberedValue(r8)
        L_0x0191:
            r7 = r8
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r8 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r8
            goto L_0x019e
        L_0x019c:
            r7 = r38
        L_0x019e:
            r23 = r4
            r22 = r6
        L_0x01a2:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01b4
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:152)"
            r8 = -339970038(0xffffffffebbc780a, float:-4.5568985E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r3, r4, r6)
        L_0x01b4:
            r4 = 1145005305(0x443f64f9, float:765.5777)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r15)
            r4 = r3 & 14
            r6 = 4
            if (r4 != r6) goto L_0x01c1
            r4 = r0
            goto L_0x01c2
        L_0x01c1:
            r4 = 0
        L_0x01c2:
            java.lang.Object r6 = r2.rememberedValue()
            if (r4 != 0) goto L_0x01d0
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x01db
        L_0x01d0:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1 r4 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
            r4.<init>(r1)
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r2.updateRememberedValue(r6)
        L_0x01db:
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.Modifier r4 = IncreaseSemanticsBounds
            androidx.compose.ui.Modifier r4 = r5.then(r4)
            r8 = 1145010240(0x443f7840, float:765.8789)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r15)
            boolean r8 = r2.changed((java.lang.Object) r6)
            java.lang.Object r9 = r2.rememberedValue()
            if (r8 != 0) goto L_0x01fe
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x0209
        L_0x01fe:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1 r8 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
            r8.<init>(r6)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r2.updateRememberedValue(r9)
        L_0x0209:
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r4, r0, r9)
            float r8 = LinearIndicatorWidth
            float r9 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r4, r8, r9)
            r8 = 1145016448(0x443f9080, float:766.2578)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r15)
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r3
            r9 = 16384(0x4000, float:2.2959E-41)
            if (r8 != r9) goto L_0x022a
            r8 = r0
            goto L_0x022b
        L_0x022a:
            r8 = 0
        L_0x022b:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r3
            r15 = 131072(0x20000, float:1.83671E-40)
            if (r9 != r15) goto L_0x0234
            r9 = r0
            goto L_0x0235
        L_0x0234:
            r9 = 0
        L_0x0235:
            r8 = r8 | r9
            boolean r9 = r2.changed((java.lang.Object) r6)
            r8 = r8 | r9
            r9 = r3 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 ^ 3072(0xc00, float:4.305E-42)
            r15 = 2048(0x800, float:2.87E-42)
            if (r9 <= r15) goto L_0x0249
            boolean r9 = r2.changed((long) r13)
            if (r9 != 0) goto L_0x024d
        L_0x0249:
            r9 = r3 & 3072(0xc00, float:4.305E-42)
            if (r9 != r15) goto L_0x024f
        L_0x024d:
            r9 = r0
            goto L_0x0250
        L_0x024f:
            r9 = 0
        L_0x0250:
            r8 = r8 | r9
            r9 = r3 & 896(0x380, float:1.256E-42)
            r9 = r9 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r9 <= r15) goto L_0x025f
            boolean r9 = r2.changed((long) r11)
            if (r9 != 0) goto L_0x0263
        L_0x025f:
            r9 = r3 & 384(0x180, float:5.38E-43)
            if (r9 != r15) goto L_0x0265
        L_0x0263:
            r9 = r0
            goto L_0x0266
        L_0x0265:
            r9 = 0
        L_0x0266:
            r8 = r8 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r3
            r9 = r9 ^ r18
            r15 = 1048576(0x100000, float:1.469368E-39)
            if (r9 <= r15) goto L_0x0276
            boolean r9 = r2.changed((java.lang.Object) r7)
            if (r9 != 0) goto L_0x027c
        L_0x0276:
            r3 = r3 & r18
            if (r3 != r15) goto L_0x027b
            goto L_0x027c
        L_0x027b:
            r0 = 0
        L_0x027c:
            r0 = r0 | r8
            java.lang.Object r3 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0293
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x028c
            goto L_0x0293
        L_0x028c:
            r29 = r7
            r27 = r11
            r25 = r13
            goto L_0x02a7
        L_0x0293:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1 r21 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
            r24 = r6
            r29 = r7
            r27 = r11
            r25 = r13
            r21.<init>(r22, r23, r24, r25, r27, r29)
            r3 = r21
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.updateRememberedValue(r3)
        L_0x02a7:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r4, r3, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b9:
            r7 = r22
            r8 = r23
            r13 = r25
            r3 = r27
            r9 = r29
        L_0x02c3:
            androidx.compose.runtime.ScopeUpdateScope r12 = r2.endRestartGroup()
            if (r12 == 0) goto L_0x02d7
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
            r11 = r41
            r2 = r5
            r5 = r13
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2353LinearProgressIndicatorGJbTh5U(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* renamed from: LinearProgressIndicator-2cYBFYY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2352LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier r18, long r19, long r21, int r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r25
            r0 = -476865359(0xffffffffe3939cb1, float:-5.4459244E21)
            r1 = r24
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)214@9497L11,215@9560L16,218@9656L175:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r26 & 1
            if (r1 == 0) goto L_0x001a
            r2 = r7 | 6
            r3 = r2
            r2 = r18
            goto L_0x002e
        L_0x001a:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r18
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r7
            goto L_0x002e
        L_0x002b:
            r2 = r18
            r3 = r7
        L_0x002e:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r26 & 2
            if (r4 != 0) goto L_0x0041
            r4 = r19
            boolean r6 = r15.changed((long) r4)
            if (r6 == 0) goto L_0x0043
            r6 = 32
            goto L_0x0045
        L_0x0041:
            r4 = r19
        L_0x0043:
            r6 = 16
        L_0x0045:
            r3 = r3 | r6
            goto L_0x0049
        L_0x0047:
            r4 = r19
        L_0x0049:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0060
            r6 = r26 & 4
            r8 = r21
            if (r6 != 0) goto L_0x005c
            boolean r6 = r15.changed((long) r8)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r6
            goto L_0x0062
        L_0x0060:
            r8 = r21
        L_0x0062:
            r6 = r26 & 8
            if (r6 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r10 = r7 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007c
            r10 = r23
            boolean r11 = r15.changed((int) r10)
            if (r11 == 0) goto L_0x0078
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r11
            goto L_0x007e
        L_0x007c:
            r10 = r23
        L_0x007e:
            r11 = r3 & 1171(0x493, float:1.641E-42)
            r12 = 1170(0x492, float:1.64E-42)
            if (r11 != r12) goto L_0x0094
            boolean r11 = r15.getSkipping()
            if (r11 != 0) goto L_0x008b
            goto L_0x0094
        L_0x008b:
            r15.skipToGroupEnd()
            r1 = r2
            r2 = r4
            r4 = r8
            r6 = r10
            goto L_0x011c
        L_0x0094:
            r15.startDefaults()
            r11 = r7 & 1
            if (r11 == 0) goto L_0x00b6
            boolean r11 = r15.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00a2
            goto L_0x00b6
        L_0x00a2:
            r15.skipToGroupEnd()
            r1 = r26 & 2
            if (r1 == 0) goto L_0x00ab
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ab:
            r1 = r26 & 4
            if (r1 == 0) goto L_0x00b1
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b1:
            r11 = r8
            r13 = r10
            r8 = r2
        L_0x00b4:
            r9 = r4
            goto L_0x00e7
        L_0x00b6:
            if (r1 == 0) goto L_0x00bd
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00be
        L_0x00bd:
            r1 = r2
        L_0x00be:
            r2 = r26 & 2
            r11 = 6
            if (r2 == 0) goto L_0x00cb
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r4 = r2.getLinearColor(r15, r11)
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00cb:
            r2 = r26 & 4
            if (r2 == 0) goto L_0x00d8
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r8 = r2.getLinearTrackColor(r15, r11)
            r2 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r3 = r2
        L_0x00d8:
            if (r6 == 0) goto L_0x00e3
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r2 = r2.m2344getLinearStrokeCapKaPHkGw()
            r13 = r2
            r11 = r8
            goto L_0x00e5
        L_0x00e3:
            r11 = r8
            r13 = r10
        L_0x00e5:
            r8 = r1
            goto L_0x00b4
        L_0x00e7:
            r15.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00f6
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:217)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x00f6:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r14 = r0.m2343getLinearIndicatorTrackGapSizeD9Ej5fM()
            r0 = r3 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r3 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r1
            r17 = 0
            m2358LinearProgressIndicatorrIrjwxo(r8, r9, r11, r13, r14, r15, r16, r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0118
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0118:
            r1 = r8
            r2 = r9
            r4 = r11
            r6 = r13
        L_0x011c:
            androidx.compose.runtime.ScopeUpdateScope r9 = r15.endRestartGroup()
            if (r9 == 0) goto L_0x012e
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6
            r8 = r26
            r0.<init>(r1, r2, r4, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2352LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0260  */
    /* renamed from: LinearProgressIndicator-rIrjwxo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2358LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier r28, long r29, long r31, int r33, float r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r8 = r36
            r0 = 567589233(0x21d4b971, float:1.4414765E-18)
            r1 = r35
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LinearProgressIndicator)P(2,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)249@11000L11,250@11063L16,254@11257L28,259@11547L396,272@11995L396,285@12444L400,298@12897L400,315@13472L1839,310@13302L2009:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r37 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r8 | 6
            r4 = r3
            r3 = r28
            goto L_0x002e
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r28
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r8
            goto L_0x002e
        L_0x002b:
            r3 = r28
            r4 = r8
        L_0x002e:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r37 & 2
            r9 = r29
            if (r5 != 0) goto L_0x0041
            boolean r5 = r1.changed((long) r9)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
            goto L_0x0047
        L_0x0045:
            r9 = r29
        L_0x0047:
            r5 = r8 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005e
            r5 = r37 & 4
            r11 = r31
            if (r5 != 0) goto L_0x005a
            boolean r5 = r1.changed((long) r11)
            if (r5 == 0) goto L_0x005a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r5
            goto L_0x0060
        L_0x005e:
            r11 = r31
        L_0x0060:
            r5 = r37 & 8
            if (r5 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r14 = r8 & 3072(0xc00, float:4.305E-42)
            if (r14 != 0) goto L_0x007a
            r14 = r33
            boolean r15 = r1.changed((int) r14)
            if (r15 == 0) goto L_0x0076
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r15
            goto L_0x007c
        L_0x007a:
            r14 = r33
        L_0x007c:
            r15 = r37 & 16
            if (r15 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0083:
            r7 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0097
            r7 = r34
            boolean r16 = r1.changed((float) r7)
            if (r16 == 0) goto L_0x0092
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r16
            goto L_0x0099
        L_0x0097:
            r7 = r34
        L_0x0099:
            r6 = r4 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r6 != r13) goto L_0x00b0
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x00a6
            goto L_0x00b0
        L_0x00a6:
            r1.skipToGroupEnd()
            r13 = r1
            r1 = r3
            r2 = r9
            r4 = r11
            r6 = r14
            goto L_0x02e9
        L_0x00b0:
            r1.startDefaults()
            r6 = r8 & 1
            if (r6 == 0) goto L_0x00d3
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x00be
            goto L_0x00d3
        L_0x00be:
            r1.skipToGroupEnd()
            r2 = r37 & 2
            if (r2 == 0) goto L_0x00c7
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c7:
            r2 = r37 & 4
            if (r2 == 0) goto L_0x00cd
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00cd:
            r2 = r3
        L_0x00ce:
            r19 = r7
        L_0x00d0:
            r18 = r14
            goto L_0x0109
        L_0x00d3:
            if (r2 == 0) goto L_0x00da
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00db
        L_0x00da:
            r2 = r3
        L_0x00db:
            r3 = r37 & 2
            r6 = 6
            if (r3 == 0) goto L_0x00e8
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r9 = r3.getLinearColor(r1, r6)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00e8:
            r3 = r37 & 4
            if (r3 == 0) goto L_0x00f5
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r11 = r3.getLinearTrackColor(r1, r6)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x00f5:
            if (r5 == 0) goto L_0x00fe
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r3 = r3.m2344getLinearStrokeCapKaPHkGw()
            r14 = r3
        L_0x00fe:
            if (r15 == 0) goto L_0x00ce
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r3 = r3.m2343getLinearIndicatorTrackGapSizeD9Ej5fM()
            r19 = r3
            goto L_0x00d0
        L_0x0109:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0118
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:253)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r3, r5)
        L_0x0118:
            r0 = 0
            r3 = 0
            r5 = 1
            androidx.compose.animation.core.InfiniteTransition r0 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r1, r3, r5)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1 r6 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.animation.core.KeyframesSpec r6 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            androidx.compose.animation.core.DurationBasedAnimationSpec r6 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r6
            r7 = 6
            r13 = 0
            r14 = 0
            r20 = 0
            r28 = r6
            r32 = r7
            r33 = r13
            r29 = r14
            r30 = r20
            androidx.compose.animation.core.InfiniteRepeatableSpec r6 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r28, r29, r30, r32, r33)
            int r7 = androidx.compose.animation.core.InfiniteTransition.$stable
            r7 = r7 | 432(0x1b0, float:6.05E-43)
            int r13 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r13 = r13 << 9
            r7 = r7 | r13
            r13 = 8
            r14 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            r17 = 0
            r28 = r0
            r33 = r1
            r31 = r6
            r34 = r7
            r35 = r13
            r29 = r14
            r30 = r15
            r32 = r17
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r28, r29, r30, r31, r32, r33, r34, r35)
            r6 = r28
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1 r7 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.animation.core.KeyframesSpec r7 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r7)
            androidx.compose.animation.core.DurationBasedAnimationSpec r7 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r7
            r13 = 6
            r14 = 0
            r15 = 0
            r28 = r7
            r32 = r13
            r33 = r14
            r29 = r15
            r30 = r20
            androidx.compose.animation.core.InfiniteRepeatableSpec r7 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r28, r29, r30, r32, r33)
            int r13 = androidx.compose.animation.core.InfiniteTransition.$stable
            r13 = r13 | 432(0x1b0, float:6.05E-43)
            int r14 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r14 = r14 << 9
            r13 = r13 | r14
            r14 = 8
            r15 = 0
            r17 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r33 = r1
            r28 = r6
            r31 = r7
            r34 = r13
            r35 = r14
            r29 = r15
            r30 = r17
            r32 = r20
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r28, r29, r30, r31, r32, r33, r34, r35)
            r7 = r28
            r6 = r33
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1 r13 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1.INSTANCE
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.animation.core.KeyframesSpec r13 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r13)
            androidx.compose.animation.core.DurationBasedAnimationSpec r13 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r13
            r14 = 6
            r15 = 0
            r17 = 0
            r20 = 0
            r28 = r13
            r32 = r14
            r33 = r15
            r29 = r17
            r30 = r20
            androidx.compose.animation.core.InfiniteRepeatableSpec r13 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r28, r29, r30, r32, r33)
            int r14 = androidx.compose.animation.core.InfiniteTransition.$stable
            r14 = r14 | 432(0x1b0, float:6.05E-43)
            int r15 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r15 = r15 << 9
            r14 = r14 | r15
            r15 = 8
            r17 = 0
            r20 = 1065353216(0x3f800000, float:1.0)
            r21 = 0
            r33 = r6
            r28 = r7
            r31 = r13
            r34 = r14
            r35 = r15
            r29 = r17
            r30 = r20
            r32 = r21
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r28, r29, r30, r31, r32, r33, r34, r35)
            r13 = r28
            r7 = r33
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1 r14 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.animation.core.KeyframesSpec r14 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r14)
            androidx.compose.animation.core.DurationBasedAnimationSpec r14 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r14
            r15 = 6
            r17 = 0
            r20 = 0
            r21 = 0
            r28 = r14
            r32 = r15
            r33 = r17
            r29 = r20
            r30 = r21
            androidx.compose.animation.core.InfiniteRepeatableSpec r14 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r28, r29, r30, r32, r33)
            int r15 = androidx.compose.animation.core.InfiniteTransition.$stable
            r15 = r15 | 432(0x1b0, float:6.05E-43)
            int r17 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r17 = r17 << 9
            r15 = r15 | r17
            r17 = 8
            r20 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            r22 = 0
            r33 = r7
            r28 = r13
            r31 = r14
            r34 = r15
            r35 = r17
            r29 = r20
            r30 = r21
            r32 = r22
            androidx.compose.runtime.State r7 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r28, r29, r30, r31, r32, r33, r34, r35)
            r13 = r33
            androidx.compose.ui.Modifier r14 = IncreaseSemanticsBounds
            androidx.compose.ui.Modifier r14 = r2.then(r14)
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r14)
            float r15 = LinearIndicatorWidth
            float r5 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r14, r15, r5)
            r14 = 1145216297(0x44429d29, float:778.4556)
            java.lang.String r15 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r14, r15)
            r14 = r4 & 7168(0x1c00, float:1.0045E-41)
            r15 = 2048(0x800, float:2.87E-42)
            if (r14 != r15) goto L_0x0255
            r14 = 1
            goto L_0x0256
        L_0x0255:
            r14 = r3
        L_0x0256:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r4
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r15 != r3) goto L_0x0260
            r3 = 1
            goto L_0x0261
        L_0x0260:
            r3 = 0
        L_0x0261:
            r3 = r3 | r14
            boolean r14 = r13.changed((java.lang.Object) r0)
            r3 = r3 | r14
            r14 = r4 & 896(0x380, float:1.256E-42)
            r14 = r14 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r14 <= r15) goto L_0x0275
            boolean r14 = r13.changed((long) r11)
            if (r14 != 0) goto L_0x0279
        L_0x0275:
            r14 = r4 & 384(0x180, float:5.38E-43)
            if (r14 != r15) goto L_0x027b
        L_0x0279:
            r14 = 1
            goto L_0x027c
        L_0x027b:
            r14 = 0
        L_0x027c:
            r3 = r3 | r14
            boolean r14 = r13.changed((java.lang.Object) r1)
            r3 = r3 | r14
            r14 = r4 & 112(0x70, float:1.57E-43)
            r14 = r14 ^ 48
            r15 = 32
            if (r14 <= r15) goto L_0x0290
            boolean r14 = r13.changed((long) r9)
            if (r14 != 0) goto L_0x0294
        L_0x0290:
            r4 = r4 & 48
            if (r4 != r15) goto L_0x0296
        L_0x0294:
            r4 = 1
            goto L_0x0297
        L_0x0296:
            r4 = 0
        L_0x0297:
            r3 = r3 | r4
            boolean r4 = r13.changed((java.lang.Object) r6)
            r3 = r3 | r4
            boolean r4 = r13.changed((java.lang.Object) r7)
            r3 = r3 | r4
            java.lang.Object r4 = r13.rememberedValue()
            if (r3 != 0) goto L_0x02b6
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02b1
            goto L_0x02b6
        L_0x02b1:
            r24 = r9
            r21 = r11
            goto L_0x02ce
        L_0x02b6:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7$1 r17 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7$1
            r20 = r0
            r23 = r1
            r26 = r6
            r27 = r7
            r24 = r9
            r21 = r11
            r17.<init>(r18, r19, r20, r21, r23, r24, r26, r27)
            r4 = r17
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13.updateRememberedValue(r4)
        L_0x02ce:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r4, r13, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e0:
            r1 = r2
            r6 = r18
            r7 = r19
            r4 = r21
            r2 = r24
        L_0x02e9:
            androidx.compose.runtime.ScopeUpdateScope r10 = r13.endRestartGroup()
            if (r10 == 0) goto L_0x02fb
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8
            r9 = r37
            r0.<init>(r1, r2, r4, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2358LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier, long, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2355LinearProgressIndicator_5eSRE(float r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r1 = r21
            r8 = r29
            r0 = 905419617(0x35f79b61, float:1.8448155E-6)
            r2 = r28
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)385@15871L11,386@15934L16,390@16074L12,389@16030L179:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r30 & 1
            r4 = 4
            if (r3 == 0) goto L_0x001a
            r3 = r8 | 6
            goto L_0x002a
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x0029
            boolean r3 = r2.changed((float) r1)
            if (r3 == 0) goto L_0x0026
            r3 = r4
            goto L_0x0027
        L_0x0026:
            r3 = 2
        L_0x0027:
            r3 = r3 | r8
            goto L_0x002a
        L_0x0029:
            r3 = r8
        L_0x002a:
            r5 = r30 & 2
            if (r5 == 0) goto L_0x0031
            r3 = r3 | 48
            goto L_0x0044
        L_0x0031:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0044
            r6 = r22
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0040
            r7 = 32
            goto L_0x0042
        L_0x0040:
            r7 = 16
        L_0x0042:
            r3 = r3 | r7
            goto L_0x0046
        L_0x0044:
            r6 = r22
        L_0x0046:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005d
            r7 = r30 & 4
            r9 = r23
            if (r7 != 0) goto L_0x0059
            boolean r7 = r2.changed((long) r9)
            if (r7 == 0) goto L_0x0059
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r7
            goto L_0x005f
        L_0x005d:
            r9 = r23
        L_0x005f:
            r7 = r8 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0076
            r7 = r30 & 8
            r11 = r25
            if (r7 != 0) goto L_0x0072
            boolean r7 = r2.changed((long) r11)
            if (r7 == 0) goto L_0x0072
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r3 = r3 | r7
            goto L_0x0078
        L_0x0076:
            r11 = r25
        L_0x0078:
            r7 = r30 & 16
            if (r7 == 0) goto L_0x007f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x007f:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0092
            r13 = r27
            boolean r14 = r2.changed((int) r13)
            if (r14 == 0) goto L_0x008e
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0090
        L_0x008e:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0090:
            r3 = r3 | r14
            goto L_0x0094
        L_0x0092:
            r13 = r27
        L_0x0094:
            r14 = r3 & 9363(0x2493, float:1.312E-41)
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r14 != r15) goto L_0x00ac
            boolean r14 = r2.getSkipping()
            if (r14 != 0) goto L_0x00a1
            goto L_0x00ac
        L_0x00a1:
            r2.skipToGroupEnd()
            r18 = r2
            r2 = r6
            r3 = r9
            r5 = r11
            r7 = r13
            goto L_0x0152
        L_0x00ac:
            r2.startDefaults()
            r14 = r8 & 1
            if (r14 == 0) goto L_0x00ce
            boolean r14 = r2.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00ba
            goto L_0x00ce
        L_0x00ba:
            r2.skipToGroupEnd()
            r5 = r30 & 4
            if (r5 == 0) goto L_0x00c3
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c3:
            r5 = r30 & 8
            if (r5 == 0) goto L_0x00c9
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c9:
            r15 = r13
        L_0x00ca:
            r13 = r11
            r11 = r9
            r10 = r6
            goto L_0x00f8
        L_0x00ce:
            if (r5 == 0) goto L_0x00d5
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r5
        L_0x00d5:
            r5 = r30 & 4
            r14 = 6
            if (r5 == 0) goto L_0x00e2
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r9 = r5.getLinearColor(r2, r14)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e2:
            r5 = r30 & 8
            if (r5 == 0) goto L_0x00ee
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r11 = r5.getLinearTrackColor(r2, r14)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00ee:
            if (r7 == 0) goto L_0x00c9
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r5 = r5.m2344getLinearStrokeCapKaPHkGw()
            r15 = r5
            goto L_0x00ca
        L_0x00f8:
            r2.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0107
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:389)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r6)
        L_0x0107:
            r0 = 1145297734(0x4443db46, float:783.42615)
            java.lang.String r5 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r5)
            r0 = r3 & 14
            if (r0 != r4) goto L_0x0115
            r0 = 1
            goto L_0x0116
        L_0x0115:
            r0 = 0
        L_0x0116:
            java.lang.Object r4 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0124
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x012f
        L_0x0124:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$9$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$9$1
            r0.<init>(r1)
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.updateRememberedValue(r4)
        L_0x012f:
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = 65520(0xfff0, float:9.1813E-41)
            r19 = r3 & r0
            r20 = 96
            r16 = 0
            r17 = 0
            r18 = r2
            m2353LinearProgressIndicatorGJbTh5U(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x014e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x014e:
            r2 = r10
            r3 = r11
            r5 = r13
            r7 = r15
        L_0x0152:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x0164
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$10 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$10
            r9 = r30
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2355LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2357LinearProgressIndicatoreaDK9VM(float r18, androidx.compose.ui.Modifier r19, long r20, long r22, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r25
            r0 = -372717133(0xffffffffe9c8c9b3, float:-3.0342208E25)
            r1 = r24
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)403@16462L11,404@16525L16,406@16551L164:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r26 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r7 | 6
            r8 = r18
            goto L_0x002b
        L_0x0019:
            r1 = r7 & 6
            r8 = r18
            if (r1 != 0) goto L_0x002a
            boolean r1 = r15.changed((float) r8)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r7
            goto L_0x002b
        L_0x002a:
            r1 = r7
        L_0x002b:
            r2 = r26 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r7 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r19
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r19
        L_0x0047:
            r4 = r7 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r26 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r20
            boolean r6 = r15.changed((long) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r20
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r20
        L_0x0062:
            r6 = r7 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0079
            r6 = r26 & 8
            r9 = r22
            if (r6 != 0) goto L_0x0075
            boolean r6 = r15.changed((long) r9)
            if (r6 == 0) goto L_0x0075
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r6
            goto L_0x007b
        L_0x0079:
            r9 = r22
        L_0x007b:
            r6 = r1 & 1171(0x493, float:1.641E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r6 != r11) goto L_0x0090
            boolean r6 = r15.getSkipping()
            if (r6 != 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r15.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r5 = r9
            goto L_0x010f
        L_0x0090:
            r15.startDefaults()
            r6 = r7 & 1
            if (r6 == 0) goto L_0x00b1
            boolean r6 = r15.getDefaultsInvalid()
            if (r6 == 0) goto L_0x009e
            goto L_0x00b1
        L_0x009e:
            r15.skipToGroupEnd()
            r2 = r26 & 4
            if (r2 == 0) goto L_0x00a7
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a7:
            r2 = r26 & 8
            if (r2 == 0) goto L_0x00ad
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00ad:
            r12 = r9
            r9 = r3
            r10 = r4
            goto L_0x00db
        L_0x00b1:
            if (r2 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00b9
        L_0x00b8:
            r2 = r3
        L_0x00b9:
            r3 = r26 & 4
            r6 = 6
            if (r3 == 0) goto L_0x00c7
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r3 = r3.getLinearColor(r15, r6)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00c8
        L_0x00c7:
            r3 = r4
        L_0x00c8:
            r5 = r26 & 8
            if (r5 == 0) goto L_0x00d8
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r5.getLinearTrackColor(r15, r6)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r2
            r10 = r3
            r12 = r5
            goto L_0x00db
        L_0x00d8:
            r12 = r9
            r9 = r2
            r10 = r3
        L_0x00db:
            r15.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ea
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:406)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00ea:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r14 = r0.m2344getLinearStrokeCapKaPHkGw()
            r0 = r1 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r1
            r17 = 0
            m2355LinearProgressIndicator_5eSRE((float) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (long) r12, (int) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010c:
            r2 = r9
            r3 = r10
            r5 = r12
        L_0x010f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r15.endRestartGroup()
            if (r9 == 0) goto L_0x0123
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$11 r0 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$11
            r1 = r18
            r8 = r26
            r0.<init>(r1, r2, r3, r5, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2357LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ void m2354LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        long j5;
        long j6;
        Modifier modifier3;
        long j7;
        Modifier modifier4;
        int i4;
        int i5;
        int i6 = i;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)418@16922L11,419@16985L16,421@17011L146:ProgressIndicator.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i3 = i6;
        }
        if ((i6 & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i6 & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i6 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i7 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
                j7 = j4;
                modifier4 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j7 = j4;
                modifier4 = modifier2;
            }
            long j8 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:421)");
            }
            m2358LinearProgressIndicatorrIrjwxo(modifier4, j8, j7, ProgressIndicatorDefaults.INSTANCE.m2344getLinearStrokeCapKaPHkGw(), 0.0f, startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j6 = j8;
            j5 = j7;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j6 = j3;
            j5 = j4;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$12(modifier3, j6, j5, i6, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g  reason: not valid java name */
    public static final void m2368drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float r0 = Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc());
        float r1 = Size.m4053getHeightimpl(drawScope.m4865getSizeNHjbRc());
        float f4 = (float) 2;
        float f5 = r1 / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * r0;
        float f7 = (z ? f2 : 1.0f - f) * r0;
        int i2 = i;
        if (StrokeCap.m4630equalsimpl0(i2, StrokeCap.Companion.m4634getButtKaPHkGw()) || r1 > r0) {
            DrawScope.m4832drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(f8, r0 - f8);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m4832drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f3, i2, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d1  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2347CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0 r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r9 = r31
            r0 = -761680467(0xffffffffd299adad, float:-3.30021896E11)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)529@21735L13,531@21869L29,534@21991L217:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r9 | 6
            r10 = r22
            goto L_0x002b
        L_0x0019:
            r2 = r9 & 6
            r10 = r22
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changedInstance(r10)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r9
            goto L_0x002b
        L_0x002a:
            r2 = r9
        L_0x002b:
            r3 = r32 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r23
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r23
        L_0x0047:
            r5 = r9 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r32 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r24
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r24
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r7
            goto L_0x0062
        L_0x0060:
            r5 = r24
        L_0x0062:
            r7 = r32 & 8
            if (r7 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r26
            boolean r11 = r1.changed((float) r8)
            if (r11 == 0) goto L_0x0078
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r11
            goto L_0x007e
        L_0x007c:
            r8 = r26
        L_0x007e:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0097
            r11 = r32 & 16
            if (r11 != 0) goto L_0x0091
            r11 = r27
            boolean r13 = r1.changed((long) r11)
            if (r13 == 0) goto L_0x0093
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r11 = r27
        L_0x0093:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r13
            goto L_0x0099
        L_0x0097:
            r11 = r27
        L_0x0099:
            r13 = r32 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a1
            r2 = r2 | r14
            goto L_0x00b3
        L_0x00a1:
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00b3
            r14 = r29
            boolean r15 = r1.changed((int) r14)
            if (r15 == 0) goto L_0x00af
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r15
            goto L_0x00b5
        L_0x00b3:
            r14 = r29
        L_0x00b5:
            r15 = 74899(0x12493, float:1.04956E-40)
            r15 = r15 & r2
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r0) goto L_0x00d1
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00c5
            goto L_0x00d1
        L_0x00c5:
            r1.skipToGroupEnd()
            r19 = r1
            r2 = r4
            r3 = r5
            r5 = r8
            r6 = r11
            r8 = r14
            goto L_0x017f
        L_0x00d1:
            r1.startDefaults()
            r0 = r9 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x00fa
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00e2
            goto L_0x00fa
        L_0x00e2:
            r1.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x00eb
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00eb:
            r0 = r32 & 16
            if (r0 == 0) goto L_0x00f0
            r2 = r2 & r15
        L_0x00f0:
            r15 = r11
            r17 = r14
            r0 = -761680467(0xffffffffd299adad, float:-3.30021896E11)
            r11 = r4
            r12 = r5
            r14 = r8
            goto L_0x013c
        L_0x00fa:
            if (r3 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0102
        L_0x0101:
            r0 = r4
        L_0x0102:
            r3 = r32 & 4
            r4 = 6
            if (r3 == 0) goto L_0x010f
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r3.getCircularColor(r1, r4)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010f:
            if (r7 == 0) goto L_0x0118
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r3 = r3.m2342getCircularStrokeWidthD9Ej5fM()
            r8 = r3
        L_0x0118:
            r3 = r32 & 16
            if (r3 == 0) goto L_0x0124
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r3 = r3.getCircularDeterminateTrackColor(r1, r4)
            r2 = r2 & r15
            r11 = r3
        L_0x0124:
            if (r13 == 0) goto L_0x0133
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r3 = r3.m2339getCircularDeterminateStrokeCapKaPHkGw()
            r17 = r3
            r14 = r8
            r15 = r11
            r11 = r0
            r12 = r5
            goto L_0x0139
        L_0x0133:
            r15 = r11
            r17 = r14
            r11 = r0
            r12 = r5
            r14 = r8
        L_0x0139:
            r0 = -761680467(0xffffffffd299adad, float:-3.30021896E11)
        L_0x013c:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x014b
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:533)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x014b:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r18 = r0.m2341getCircularIndicatorTrackGapSizeD9Ej5fM()
            r0 = r2 & 14
            r3 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r20 = r0 | r2
            r21 = 0
            r19 = r1
            m2348CircularProgressIndicatorIyT6zlY(r10, r11, r12, r14, r15, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0179
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0179:
            r2 = r11
            r3 = r12
            r5 = r14
            r6 = r15
            r8 = r17
        L_0x017f:
            androidx.compose.runtime.ScopeUpdateScope r11 = r19.endRestartGroup()
            if (r11 == 0) goto L_0x0193
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
            r1 = r22
            r10 = r32
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0193:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2347CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ec  */
    /* renamed from: CircularProgressIndicator-IyT6zlY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2348CircularProgressIndicatorIyT6zlY(kotlin.jvm.functions.Function0<java.lang.Float> r32, androidx.compose.ui.Modifier r33, long r34, float r36, long r37, int r39, float r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r32
            r10 = r42
            r0 = -1798883595(0xffffffff94c736f5, float:-2.0115542E-26)
            r2 = r41
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(CircularProgressIndicator)P(3,2,0:c#ui.graphics.Color,5:c#ui.unit.Dp,6:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)575@23884L13,577@24018L29,581@24237L31,*582@24304L7,585@24446L102,589@24600L709,583@24373L936:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r43 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r5 = r43 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0043
            r6 = r33
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r33
        L_0x0045:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005c
            r7 = r43 & 4
            r11 = r34
            if (r7 != 0) goto L_0x0058
            boolean r7 = r2.changed((long) r11)
            if (r7 == 0) goto L_0x0058
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r3 = r3 | r7
            goto L_0x005e
        L_0x005c:
            r11 = r34
        L_0x005e:
            r7 = r43 & 8
            if (r7 == 0) goto L_0x0065
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r13 = r10 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x0078
            r13 = r36
            boolean r14 = r2.changed((float) r13)
            if (r14 == 0) goto L_0x0074
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r3 = r3 | r14
            goto L_0x007a
        L_0x0078:
            r13 = r36
        L_0x007a:
            r14 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x0092
            r14 = r43 & 16
            r8 = r37
            if (r14 != 0) goto L_0x008d
            boolean r16 = r2.changed((long) r8)
            if (r16 == 0) goto L_0x008d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r3 = r3 | r16
            goto L_0x0094
        L_0x0092:
            r8 = r37
        L_0x0094:
            r16 = r43 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x009f
            r3 = r3 | r17
            r15 = r39
            goto L_0x00b2
        L_0x009f:
            r17 = r10 & r17
            r15 = r39
            if (r17 != 0) goto L_0x00b2
            boolean r18 = r2.changed((int) r15)
            if (r18 == 0) goto L_0x00ae
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r18
        L_0x00b2:
            r18 = r43 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00bd
            r3 = r3 | r19
            r14 = r40
            goto L_0x00d0
        L_0x00bd:
            r19 = r10 & r19
            r14 = r40
            if (r19 != 0) goto L_0x00d0
            boolean r20 = r2.changed((float) r14)
            if (r20 == 0) goto L_0x00cc
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r3 = r3 | r20
        L_0x00d0:
            r20 = 599187(0x92493, float:8.3964E-40)
            r4 = r3 & r20
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r4 != r0) goto L_0x00ec
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e1
            goto L_0x00ec
        L_0x00e1:
            r2.skipToGroupEnd()
            r3 = r11
            r5 = r13
            r25 = r14
            r24 = r15
            goto L_0x02a1
        L_0x00ec:
            r2.startDefaults()
            r0 = r10 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0111
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fd
            goto L_0x0111
        L_0x00fd:
            r2.skipToGroupEnd()
            r0 = r43 & 4
            if (r0 == 0) goto L_0x0106
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0106:
            r0 = r43 & 16
            if (r0 == 0) goto L_0x010b
            r3 = r3 & r4
        L_0x010b:
            r7 = r8
        L_0x010c:
            r25 = r14
        L_0x010e:
            r24 = r15
            goto L_0x0151
        L_0x0111:
            if (r5 == 0) goto L_0x0118
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0118:
            r0 = r43 & 4
            r5 = 6
            if (r0 == 0) goto L_0x0125
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r11 = r0.getCircularColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0125:
            if (r7 == 0) goto L_0x012e
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r0 = r0.m2342getCircularStrokeWidthD9Ej5fM()
            r13 = r0
        L_0x012e:
            r0 = r43 & 16
            if (r0 == 0) goto L_0x013c
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r0.getCircularDeterminateTrackColor(r2, r5)
            r0 = r3 & r4
            r3 = r0
            goto L_0x013d
        L_0x013c:
            r7 = r8
        L_0x013d:
            if (r16 == 0) goto L_0x0146
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r0 = r0.m2339getCircularDeterminateStrokeCapKaPHkGw()
            r15 = r0
        L_0x0146:
            if (r18 == 0) goto L_0x010c
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r0 = r0.m2341getCircularIndicatorTrackGapSizeD9Ej5fM()
            r25 = r0
            goto L_0x010e
        L_0x0151:
            r2.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0163
            r0 = -1
            java.lang.String r4 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:580)"
            r5 = -1798883595(0xffffffff94c736f5, float:-2.0115542E-26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r0, r4)
        L_0x0163:
            r0 = -291619137(0xffffffffee9e3ebf, float:-2.4487243E28)
            java.lang.String r4 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r4)
            r0 = r3 & 14
            r9 = 1
            r14 = 4
            if (r0 != r14) goto L_0x0173
            r0 = r9
            goto L_0x0174
        L_0x0173:
            r0 = 0
        L_0x0174:
            java.lang.Object r14 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0182
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r14 != r0) goto L_0x018d
        L_0x0182:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
            r0.<init>(r1)
            r14 = r0
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r2.updateRememberedValue(r14)
        L_0x018d:
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r5)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r29 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r0 = r0.m7091toPx0680j_4(r13)
            r5 = 26
            r15 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r34 = r0
            r39 = r5
            r40 = r15
            r35 = r18
            r37 = r20
            r38 = r21
            r36 = r24
            r33 = r29
            r33.<init>(r34, r35, r36, r37, r38, r39, r40)
            r0 = r33
            r5 = -291612378(0xffffffffee9e5926, float:-2.4503203E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r4)
            boolean r5 = r2.changed((java.lang.Object) r14)
            java.lang.Object r15 = r2.rememberedValue()
            if (r5 != 0) goto L_0x01e5
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r15 != r5) goto L_0x01f0
        L_0x01e5:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1 r5 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
            r5.<init>(r14)
            r15 = r5
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r2.updateRememberedValue(r15)
        L_0x01f0:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r6, r9, r15)
            float r15 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r5, r15)
            r15 = -291606843(0xffffffffee9e6ec5, float:-2.4516272E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r4)
            boolean r4 = r2.changed((java.lang.Object) r14)
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r3
            r9 = 131072(0x20000, float:1.83671E-40)
            if (r15 != r9) goto L_0x0212
            r9 = 1
            goto L_0x0213
        L_0x0212:
            r9 = 0
        L_0x0213:
            r4 = r4 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r3
            r15 = 1048576(0x100000, float:1.469368E-39)
            if (r9 != r15) goto L_0x021d
            r9 = 1
            goto L_0x021e
        L_0x021d:
            r9 = 0
        L_0x021e:
            r4 = r4 | r9
            r9 = r3 & 7168(0x1c00, float:1.0045E-41)
            r15 = 2048(0x800, float:2.87E-42)
            if (r9 != r15) goto L_0x0227
            r9 = 1
            goto L_0x0228
        L_0x0227:
            r9 = 0
        L_0x0228:
            r4 = r4 | r9
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r3
            r9 = r9 ^ 24576(0x6000, float:3.4438E-41)
            r15 = 16384(0x4000, float:2.2959E-41)
            if (r9 <= r15) goto L_0x0239
            boolean r9 = r2.changed((long) r7)
            if (r9 != 0) goto L_0x023d
        L_0x0239:
            r9 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r9 != r15) goto L_0x023f
        L_0x023d:
            r9 = 1
            goto L_0x0240
        L_0x023f:
            r9 = 0
        L_0x0240:
            r4 = r4 | r9
            boolean r9 = r2.changedInstance(r0)
            r4 = r4 | r9
            r9 = r3 & 896(0x380, float:1.256E-42)
            r9 = r9 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r9 <= r15) goto L_0x0254
            boolean r9 = r2.changed((long) r11)
            if (r9 != 0) goto L_0x0258
        L_0x0254:
            r3 = r3 & 384(0x180, float:5.38E-43)
            if (r3 != r15) goto L_0x025a
        L_0x0258:
            r9 = 1
            goto L_0x025b
        L_0x025a:
            r9 = 0
        L_0x025b:
            r3 = r4 | r9
            java.lang.Object r4 = r2.rememberedValue()
            if (r3 != 0) goto L_0x0273
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x026c
            goto L_0x0273
        L_0x026c:
            r27 = r7
            r30 = r11
            r26 = r13
            goto L_0x0289
        L_0x0273:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3$1 r22 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3$1
            r29 = r0
            r27 = r7
            r30 = r11
            r26 = r13
            r23 = r14
            r22.<init>(r23, r24, r25, r26, r27, r29, r30)
            r4 = r22
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.updateRememberedValue(r4)
        L_0x0289:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r4, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x029b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x029b:
            r5 = r26
            r8 = r27
            r3 = r30
        L_0x02a1:
            androidx.compose.runtime.ScopeUpdateScope r12 = r2.endRestartGroup()
            if (r12 == 0) goto L_0x02b9
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4
            r11 = r43
            r2 = r6
            r6 = r8
            r8 = r24
            r9 = r25
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2348CircularProgressIndicatorIyT6zlY(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02b9  */
    /* renamed from: CircularProgressIndicator-LxG7B9w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2349CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier r32, long r33, float r35, long r36, int r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r8 = r40
            r0 = -115871647(0xfffffffff917f061, float:-4.930702E34)
            r1 = r39
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)633@26429L13,635@26563L31,*638@26720L7,640@26807L28,643@26972L350,657@27444L208,666@27777L422,679@28240L431,691@28745L628,691@28676L697:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r41 & 1
            if (r1 == 0) goto L_0x001a
            r3 = r8 | 6
            r4 = r3
            r3 = r32
            goto L_0x002e
        L_0x001a:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r32
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r8
            goto L_0x002e
        L_0x002b:
            r3 = r32
            r4 = r8
        L_0x002e:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r41 & 2
            r9 = r33
            if (r5 != 0) goto L_0x0041
            boolean r5 = r15.changed((long) r9)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
            goto L_0x0047
        L_0x0045:
            r9 = r33
        L_0x0047:
            r5 = r41 & 4
            if (r5 == 0) goto L_0x004e
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r11 = r8 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0061
            r11 = r35
            boolean r12 = r15.changed((float) r11)
            if (r12 == 0) goto L_0x005d
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r12 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r4 = r4 | r12
            goto L_0x0063
        L_0x0061:
            r11 = r35
        L_0x0063:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007a
            r12 = r41 & 8
            r13 = r36
            if (r12 != 0) goto L_0x0076
            boolean r12 = r15.changed((long) r13)
            if (r12 == 0) goto L_0x0076
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r12
            goto L_0x007c
        L_0x007a:
            r13 = r36
        L_0x007c:
            r12 = r41 & 16
            if (r12 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0083:
            r6 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0097
            r6 = r38
            boolean r16 = r15.changed((int) r6)
            if (r16 == 0) goto L_0x0092
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r16
            goto L_0x0099
        L_0x0097:
            r6 = r38
        L_0x0099:
            r7 = r4 & 9363(0x2493, float:1.312E-41)
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r2) goto L_0x00b0
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x00a6
            goto L_0x00b0
        L_0x00a6:
            r15.skipToGroupEnd()
            r1 = r3
            r7 = r6
            r2 = r9
            r4 = r11
            r5 = r13
            goto L_0x031c
        L_0x00b0:
            r15.startDefaults()
            r2 = r8 & 1
            if (r2 == 0) goto L_0x00d5
            boolean r2 = r15.getDefaultsInvalid()
            if (r2 == 0) goto L_0x00be
            goto L_0x00d5
        L_0x00be:
            r15.skipToGroupEnd()
            r1 = r41 & 2
            if (r1 == 0) goto L_0x00c7
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c7:
            r1 = r41 & 8
            if (r1 == 0) goto L_0x00cd
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cd:
            r1 = r3
        L_0x00ce:
            r7 = r4
            r22 = r6
        L_0x00d1:
            r2 = r9
            r4 = r11
            r5 = r13
            goto L_0x010c
        L_0x00d5:
            if (r1 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00dd
        L_0x00dc:
            r1 = r3
        L_0x00dd:
            r2 = r41 & 2
            r3 = 6
            if (r2 == 0) goto L_0x00ea
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r9 = r2.getCircularColor(r15, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ea:
            if (r5 == 0) goto L_0x00f3
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r2 = r2.m2342getCircularStrokeWidthD9Ej5fM()
            r11 = r2
        L_0x00f3:
            r2 = r41 & 8
            if (r2 == 0) goto L_0x0100
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r2 = r2.getCircularIndeterminateTrackColor(r15, r3)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r13 = r2
        L_0x0100:
            if (r12 == 0) goto L_0x00ce
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r2 = r2.m2340getCircularIndeterminateStrokeCapKaPHkGw()
            r22 = r2
            r7 = r4
            goto L_0x00d1
        L_0x010c:
            r15.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x011b
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:637)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r9, r10)
        L_0x011b:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r9, r10)
            java.lang.Object r0 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r19 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r20 = r0.m7091toPx0680j_4(r4)
            r25 = 26
            r26 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            r0 = r19
            r30 = r22
            r9 = 0
            r10 = 0
            r11 = 1
            androidx.compose.animation.core.InfiniteTransition r12 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r9, r15, r10, r11)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r14 = 5
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            kotlin.jvm.internal.IntCompanionObject r16 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.IntCompanionObject) r16)
            r11 = 6660(0x1a04, float:9.333E-42)
            r31 = r1
            androidx.compose.animation.core.Easing r1 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r27 = r4
            r4 = 2
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r11, r10, r1, r4, r9)
            androidx.compose.animation.core.DurationBasedAnimationSpec r1 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r1
            r4 = 6
            r11 = 0
            r17 = 0
            r19 = 0
            r33 = r1
            r37 = r4
            r38 = r11
            r34 = r17
            r35 = r19
            androidx.compose.animation.core.InfiniteRepeatableSpec r1 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r33, r34, r35, r37, r38)
            int r4 = androidx.compose.animation.core.InfiniteTransition.$stable
            r4 = r4 | 432(0x1b0, float:6.05E-43)
            int r11 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r11 = r11 << 12
            r4 = r4 | r11
            r17 = 16
            r11 = r14
            r14 = 0
            r19 = r13
            r13 = r1
            r1 = r10
            r10 = r19
            r19 = r16
            r16 = r4
            r4 = r9
            r9 = r12
            r12 = r19
            r19 = 1
            androidx.compose.runtime.State r10 = androidx.compose.animation.core.InfiniteTransitionKt.animateValue(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r11 = 1332(0x534, float:1.867E-42)
            androidx.compose.animation.core.Easing r12 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r13 = 2
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r11, r1, r12, r13, r4)
            androidx.compose.animation.core.DurationBasedAnimationSpec r4 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r4
            r11 = 6
            r12 = 0
            r13 = 0
            r16 = 0
            r32 = r4
            r36 = r11
            r37 = r12
            r33 = r13
            r34 = r16
            androidx.compose.animation.core.InfiniteRepeatableSpec r4 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r32, r33, r34, r36, r37)
            int r11 = androidx.compose.animation.core.InfiniteTransition.$stable
            r11 = r11 | 432(0x1b0, float:6.05E-43)
            int r12 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r12 = r12 << 9
            r11 = r11 | r12
            r12 = 8
            r13 = 0
            r14 = 1133445120(0x438f0000, float:286.0)
            r16 = 0
            r35 = r4
            r32 = r9
            r38 = r11
            r39 = r12
            r33 = r13
            r34 = r14
            r37 = r15
            r36 = r16
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r32, r33, r34, r35, r36, r37, r38, r39)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1 r11 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.animation.core.KeyframesSpec r11 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r11)
            androidx.compose.animation.core.DurationBasedAnimationSpec r11 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r11
            r12 = 6
            r13 = 0
            r14 = 0
            r16 = 0
            r32 = r11
            r36 = r12
            r37 = r13
            r33 = r14
            r34 = r16
            androidx.compose.animation.core.InfiniteRepeatableSpec r11 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r32, r33, r34, r36, r37)
            int r12 = androidx.compose.animation.core.InfiniteTransition.$stable
            r12 = r12 | 432(0x1b0, float:6.05E-43)
            int r13 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r13 = r13 << 9
            r12 = r12 | r13
            r13 = 8
            r14 = 0
            r16 = 1133576192(0x43910000, float:290.0)
            r17 = 0
            r32 = r9
            r35 = r11
            r38 = r12
            r39 = r13
            r33 = r14
            r37 = r15
            r34 = r16
            r36 = r17
            androidx.compose.runtime.State r9 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r32, r33, r34, r35, r36, r37, r38, r39)
            r11 = r32
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1 r12 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1.INSTANCE
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            androidx.compose.animation.core.KeyframesSpec r12 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r12)
            androidx.compose.animation.core.DurationBasedAnimationSpec r12 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r12
            r13 = 6
            r14 = 0
            r16 = 0
            r20 = 0
            r32 = r12
            r36 = r13
            r37 = r14
            r33 = r16
            r34 = r20
            androidx.compose.animation.core.InfiniteRepeatableSpec r12 = androidx.compose.animation.core.AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(r32, r33, r34, r36, r37)
            int r13 = androidx.compose.animation.core.InfiniteTransition.$stable
            r13 = r13 | 432(0x1b0, float:6.05E-43)
            int r14 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r14 = r14 << 9
            r13 = r13 | r14
            r14 = 8
            r16 = 0
            r17 = 1133576192(0x43910000, float:290.0)
            r18 = 0
            r32 = r11
            r35 = r12
            r38 = r13
            r39 = r14
            r37 = r15
            r33 = r16
            r34 = r17
            r36 = r18
            androidx.compose.runtime.State r11 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r32, r33, r34, r35, r36, r37, r38, r39)
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r31)
            float r13 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m845size3ABfNKs(r12, r13)
            r13 = -291474284(0xffffffffeea07494, float:-2.4829268E28)
            java.lang.String r14 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r13, r14)
            r13 = r7 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 ^ 3072(0xc00, float:4.305E-42)
            r14 = 2048(0x800, float:2.87E-42)
            if (r13 <= r14) goto L_0x028f
            boolean r13 = r15.changed((long) r5)
            if (r13 != 0) goto L_0x0293
        L_0x028f:
            r13 = r7 & 3072(0xc00, float:4.305E-42)
            if (r13 != r14) goto L_0x0296
        L_0x0293:
            r13 = r19
            goto L_0x0297
        L_0x0296:
            r13 = r1
        L_0x0297:
            boolean r14 = r15.changedInstance(r0)
            r13 = r13 | r14
            boolean r14 = r15.changed((java.lang.Object) r10)
            r13 = r13 | r14
            boolean r14 = r15.changed((java.lang.Object) r9)
            r13 = r13 | r14
            boolean r14 = r15.changed((java.lang.Object) r11)
            r13 = r13 | r14
            boolean r14 = r15.changed((java.lang.Object) r4)
            r13 = r13 | r14
            r14 = r7 & 896(0x380, float:1.256E-42)
            r1 = 256(0x100, float:3.59E-43)
            if (r14 != r1) goto L_0x02b9
            r1 = r19
            goto L_0x02ba
        L_0x02b9:
            r1 = 0
        L_0x02ba:
            r1 = r1 | r13
            r13 = r7 & 112(0x70, float:1.57E-43)
            r13 = r13 ^ 48
            r14 = 32
            if (r13 <= r14) goto L_0x02c9
            boolean r13 = r15.changed((long) r2)
            if (r13 != 0) goto L_0x02d0
        L_0x02c9:
            r7 = r7 & 48
            if (r7 != r14) goto L_0x02ce
            goto L_0x02d0
        L_0x02ce:
            r19 = 0
        L_0x02d0:
            r1 = r1 | r19
            java.lang.Object r7 = r15.rememberedValue()
            if (r1 != 0) goto L_0x02e6
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r7 != r1) goto L_0x02e1
            goto L_0x02e6
        L_0x02e1:
            r28 = r2
            r20 = r5
            goto L_0x0300
        L_0x02e6:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5$1 r19 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5$1
            r22 = r0
            r28 = r2
            r26 = r4
            r20 = r5
            r24 = r9
            r23 = r10
            r25 = r11
            r19.<init>(r20, r22, r23, r24, r25, r26, r27, r28)
            r7 = r19
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r15.updateRememberedValue(r7)
        L_0x0300:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r12, r7, r15, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0312
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0312:
            r5 = r20
            r4 = r27
            r2 = r28
            r7 = r30
            r1 = r31
        L_0x031c:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x032e
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6
            r9 = r41
            r0.<init>(r1, r2, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2349CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013e  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2346CircularProgressIndicatorDUhRLBM(float r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r1 = r22
            r9 = r31
            r0 = -1472321743(0xffffffffa83e2731, float:-1.0555617E-14)
            r2 = r30
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)730@30011L13,732@30145L18,736@30302L12,735@30256L216:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r32 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r9 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((float) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r9
            goto L_0x0029
        L_0x0028:
            r3 = r9
        L_0x0029:
            r5 = r32 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r9 & 48
            if (r6 != 0) goto L_0x0043
            r6 = r23
            boolean r7 = r2.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r23
        L_0x0045:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005e
            r7 = r32 & 4
            if (r7 != 0) goto L_0x0058
            r7 = r24
            boolean r10 = r2.changed((long) r7)
            if (r10 == 0) goto L_0x005a
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r7 = r24
        L_0x005a:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r10
            goto L_0x0060
        L_0x005e:
            r7 = r24
        L_0x0060:
            r10 = r32 & 8
            if (r10 == 0) goto L_0x0067
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r11 = r9 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007a
            r11 = r26
            boolean r12 = r2.changed((float) r11)
            if (r12 == 0) goto L_0x0076
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r12
            goto L_0x007c
        L_0x007a:
            r11 = r26
        L_0x007c:
            r12 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0095
            r12 = r32 & 16
            if (r12 != 0) goto L_0x008f
            r12 = r27
            boolean r14 = r2.changed((long) r12)
            if (r14 == 0) goto L_0x0091
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r12 = r27
        L_0x0091:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r3 = r3 | r14
            goto L_0x0097
        L_0x0095:
            r12 = r27
        L_0x0097:
            r14 = r32 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x009f
            r3 = r3 | r15
            goto L_0x00b2
        L_0x009f:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00b2
            r15 = r29
            boolean r16 = r2.changed((int) r15)
            if (r16 == 0) goto L_0x00ad
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ad:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r3 = r3 | r16
            goto L_0x00b4
        L_0x00b2:
            r15 = r29
        L_0x00b4:
            r16 = 74899(0x12493, float:1.04956E-40)
            r4 = r3 & r16
            r0 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r0) goto L_0x00d1
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00c5
            goto L_0x00d1
        L_0x00c5:
            r2.skipToGroupEnd()
            r19 = r2
            r2 = r6
            r3 = r7
            r5 = r11
            r6 = r12
            r8 = r15
            goto L_0x0190
        L_0x00d1:
            r2.startDefaults()
            r0 = r9 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x00fa
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00e2
            goto L_0x00fa
        L_0x00e2:
            r2.skipToGroupEnd()
            r0 = r32 & 4
            if (r0 == 0) goto L_0x00eb
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00eb:
            r0 = r32 & 16
            if (r0 == 0) goto L_0x00f0
            r3 = r3 & r4
        L_0x00f0:
            r14 = r11
            r17 = r15
            r0 = -1472321743(0xffffffffa83e2731, float:-1.0555617E-14)
            r11 = r6
            r15 = r12
        L_0x00f8:
            r12 = r7
            goto L_0x0135
        L_0x00fa:
            if (r5 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0101:
            r0 = r32 & 4
            r5 = 6
            if (r0 == 0) goto L_0x010e
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r0.getCircularColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010e:
            if (r10 == 0) goto L_0x0117
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r0 = r0.m2342getCircularStrokeWidthD9Ej5fM()
            r11 = r0
        L_0x0117:
            r0 = r32 & 16
            if (r0 == 0) goto L_0x0124
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r12 = r0.getCircularTrackColor(r2, r5)
            r0 = r3 & r4
            r3 = r0
        L_0x0124:
            if (r14 == 0) goto L_0x00f0
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r0 = r0.m2339getCircularDeterminateStrokeCapKaPHkGw()
            r17 = r0
            r14 = r11
            r15 = r12
            r0 = -1472321743(0xffffffffa83e2731, float:-1.0555617E-14)
            r11 = r6
            goto L_0x00f8
        L_0x0135:
            r2.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0144
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:735)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r4, r5)
        L_0x0144:
            r0 = -291425076(0xffffffffeea134cc, float:-2.4945457E28)
            java.lang.String r4 = "CC(remember):ProgressIndicator.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r4)
            r0 = r3 & 14
            r4 = 4
            if (r0 != r4) goto L_0x0153
            r0 = 1
            goto L_0x0154
        L_0x0153:
            r0 = 0
        L_0x0154:
            java.lang.Object r4 = r2.rememberedValue()
            if (r0 != 0) goto L_0x0162
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x016d
        L_0x0162:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7$1 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7$1
            r0.<init>(r1)
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.updateRememberedValue(r4)
        L_0x016d:
            r10 = r4
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r0 = 524272(0x7fff0, float:7.34662E-40)
            r20 = r3 & r0
            r21 = 64
            r18 = 0
            r19 = r2
            m2348CircularProgressIndicatorIyT6zlY(r10, r11, r12, r14, r15, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x018a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x018a:
            r2 = r11
            r3 = r12
            r5 = r14
            r6 = r15
            r8 = r17
        L_0x0190:
            androidx.compose.runtime.ScopeUpdateScope r11 = r19.endRestartGroup()
            if (r11 == 0) goto L_0x01a2
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8
            r10 = r32
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2346CircularProgressIndicatorDUhRLBM(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2350CircularProgressIndicatorMBs18nI(float r20, androidx.compose.ui.Modifier r21, long r22, float r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r6 = r26
            r0 = 402841196(0x1802de6c, float:1.69144E-24)
            r1 = r25
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)750@30727L13,758@30964L18,753@30818L247:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r27 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r6 | 6
            r2 = r1
            r1 = r20
            goto L_0x002e
        L_0x001a:
            r1 = r6 & 6
            if (r1 != 0) goto L_0x002b
            r1 = r20
            boolean r2 = r15.changed((float) r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r6
            goto L_0x002e
        L_0x002b:
            r1 = r20
            r2 = r6
        L_0x002e:
            r3 = r27 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r6 & 48
            if (r4 != 0) goto L_0x0048
            r4 = r21
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r2 = r2 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r21
        L_0x004a:
            r5 = r6 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0061
            r5 = r27 & 4
            r7 = r22
            if (r5 != 0) goto L_0x005d
            boolean r5 = r15.changed((long) r7)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r5
            goto L_0x0063
        L_0x0061:
            r7 = r22
        L_0x0063:
            r5 = r27 & 8
            if (r5 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r6 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007d
            r9 = r24
            boolean r10 = r15.changed((float) r9)
            if (r10 == 0) goto L_0x0079
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r10
            goto L_0x007f
        L_0x007d:
            r9 = r24
        L_0x007f:
            r10 = r2 & 1171(0x493, float:1.641E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r10 != r11) goto L_0x0094
            boolean r10 = r15.getSkipping()
            if (r10 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            r15.skipToGroupEnd()
            r2 = r4
            r3 = r7
            r5 = r9
            goto L_0x0110
        L_0x0094:
            r15.startDefaults()
            r10 = r6 & 1
            r11 = 6
            if (r10 == 0) goto L_0x00b3
            boolean r10 = r15.getDefaultsInvalid()
            if (r10 == 0) goto L_0x00a3
            goto L_0x00b3
        L_0x00a3:
            r15.skipToGroupEnd()
            r3 = r27 & 4
            if (r3 == 0) goto L_0x00ac
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ac:
            r18 = r7
            r8 = r4
            r4 = r9
            r9 = r18
            goto L_0x00d3
        L_0x00b3:
            if (r3 == 0) goto L_0x00ba
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00bb
        L_0x00ba:
            r3 = r4
        L_0x00bb:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x00c7
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r4.getCircularColor(r15, r11)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c7:
            if (r5 == 0) goto L_0x00d0
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r4 = r4.m2342getCircularStrokeWidthD9Ej5fM()
            goto L_0x00d1
        L_0x00d0:
            r4 = r9
        L_0x00d1:
            r9 = r7
            r8 = r3
        L_0x00d3:
            r15.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00e2
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:753)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r5)
        L_0x00e2:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r12 = r0.getCircularTrackColor(r15, r11)
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r14 = r0.m2339getCircularDeterminateStrokeCapKaPHkGw()
            r0 = r2 & 14
            r3 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r2
            r17 = 0
            r7 = r1
            r11 = r4
            m2346CircularProgressIndicatorDUhRLBM((float) r7, (androidx.compose.ui.Modifier) r8, (long) r9, (float) r11, (long) r12, (int) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010d:
            r2 = r8
            r3 = r9
            r5 = r11
        L_0x0110:
            androidx.compose.runtime.ScopeUpdateScope r8 = r15.endRestartGroup()
            if (r8 == 0) goto L_0x0124
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9
            r1 = r20
            r7 = r27
            r0.<init>(r1, r2, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2350CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2351CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r16, long r17, float r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r5 = r21
            r0 = 947193756(0x3875079c, float:5.841964E-5)
            r1 = r20
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)767@31299L13,774@31518L18,770@31390L231:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x001a
            r2 = r5 | 6
            r3 = r2
            r2 = r16
            goto L_0x002e
        L_0x001a:
            r2 = r5 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r16
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r5
            goto L_0x002e
        L_0x002b:
            r2 = r16
            r3 = r5
        L_0x002e:
            r4 = r5 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r22 & 2
            r6 = r17
            if (r4 != 0) goto L_0x0041
            boolean r4 = r13.changed((long) r6)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r3 = r3 | r4
            goto L_0x0047
        L_0x0045:
            r6 = r17
        L_0x0047:
            r4 = r22 & 4
            if (r4 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0061
            r8 = r19
            boolean r9 = r13.changed((float) r8)
            if (r9 == 0) goto L_0x005d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r9
            goto L_0x0063
        L_0x0061:
            r8 = r19
        L_0x0063:
            r9 = r3 & 147(0x93, float:2.06E-43)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0078
            boolean r9 = r13.getSkipping()
            if (r9 != 0) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            r13.skipToGroupEnd()
            r1 = r2
            r2 = r6
            r4 = r8
            goto L_0x00eb
        L_0x0078:
            r13.startDefaults()
            r9 = r5 & 1
            r10 = 6
            if (r9 == 0) goto L_0x0094
            boolean r9 = r13.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0087
            goto L_0x0094
        L_0x0087:
            r13.skipToGroupEnd()
            r1 = r22 & 2
            if (r1 == 0) goto L_0x0090
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0090:
            r9 = r8
            r7 = r6
            r6 = r2
            goto L_0x00b5
        L_0x0094:
            if (r1 == 0) goto L_0x009b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x009c
        L_0x009b:
            r1 = r2
        L_0x009c:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x00a8
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r6 = r2.getCircularColor(r13, r10)
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00a8:
            if (r4 == 0) goto L_0x00b2
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r2 = r2.m2342getCircularStrokeWidthD9Ej5fM()
            r9 = r2
            goto L_0x00b3
        L_0x00b2:
            r9 = r8
        L_0x00b3:
            r7 = r6
            r6 = r1
        L_0x00b5:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00c4
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:770)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x00c4:
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r0.getCircularTrackColor(r13, r10)
            androidx.compose.material3.ProgressIndicatorDefaults r0 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r12 = r0.m2340getCircularIndeterminateStrokeCapKaPHkGw()
            r0 = r3 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r3 & 896(0x380, float:1.256E-42)
            r14 = r0 | r1
            r15 = 0
            m2349CircularProgressIndicatorLxG7B9w(r6, r7, r9, r10, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00e8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00e8:
            r1 = r6
            r2 = r7
            r4 = r9
        L_0x00eb:
            androidx.compose.runtime.ScopeUpdateScope r7 = r13.endRestartGroup()
            if (r7 == 0) goto L_0x00fd
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$10 r0 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$10
            r6 = r22
            r0.<init>(r1, r2, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2351CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m2364drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = (float) 2;
        float width = stroke.getWidth() / f3;
        float r2 = Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc()) - (f3 * width);
        long j2 = j;
        DrawScope.m4825drawArcyD3GUKo$default(drawScope, j2, f, f2, false, OffsetKt.Offset(width, width), SizeKt.Size(r2, r2), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU  reason: not valid java name */
    public static final void m2365drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m2364drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m2366drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2364drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m2367drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        float f4;
        if (StrokeCap.m4630equalsimpl0(stroke.m4951getCapKaPHkGw(), StrokeCap.Companion.m4634getButtKaPHkGw())) {
            f4 = 0.0f;
        } else {
            f4 = ((f2 / Dp.m7111constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f;
        }
        m2364drawCircularIndicator42QJj7c(drawScope, f + f4, Math.max(f3, 0.1f), j, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 10);
        SemanticsBoundsPadding = r0;
        IncreaseSemanticsBounds = PaddingKt.m777paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.Companion, ProgressIndicatorKt$IncreaseSemanticsBounds$1.INSTANCE), true, ProgressIndicatorKt$IncreaseSemanticsBounds$2.INSTANCE), 0.0f, r0, 1, (Object) null);
    }
}
