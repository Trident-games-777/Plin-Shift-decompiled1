package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B[\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011BQ\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014Bu\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u0006\u0010<\u001a\u00020=Jt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010FJl\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010HJt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJj\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010LJz\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR&\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00138\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010#R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188GX\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b*\u0010,R\"\u0010\u001a\u001a\u00020\u0007X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b-\u0010(\"\u0004\b.\u0010/R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b0\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b4\u0010(R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b7\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "get_historical$annotations", "()V", "<set-?>", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "getPosition-F1C5BW0", "getPressed", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.kt */
public final class PointerInputChange {
    public static final int $stable = 0;
    private List<HistoricalChange> _historical;
    private ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, (List<HistoricalChange>) list, j6, j7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, j6);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    public static /* synthetic */ void getHistorical$annotations() {
    }

    private static /* synthetic */ void get_historical$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.type = i;
        this.scrollDelta = j6;
        this.originalEventPosition = Offset.Companion.m4003getZeroF1C5BW0();
        this.consumed = new ConsumedData(z3, z3);
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m5585getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m5587getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getPreviousPosition-F1C5BW0  reason: not valid java name */
    public final long m5588getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r22, long r24, long r26, boolean r28, float r29, long r30, long r32, boolean r34, boolean r35, int r36, long r37, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m5669getTouchT8wyACA()
            r17 = r1
            goto L_0x0011
        L_0x000f:
            r17 = r36
        L_0x0011:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m4003getZeroF1C5BW0()
            r18 = r0
            goto L_0x0020
        L_0x001e:
            r18 = r37
        L_0x0020:
            r20 = 0
            r2 = r21
            r3 = r22
            r5 = r24
            r7 = r26
            r9 = r28
            r10 = r29
            r11 = r30
            r13 = r32
            r15 = r34
            r16 = r35
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (float) r10, (long) r11, (long) r13, (boolean) r15, (boolean) r16, (int) r17, (long) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, float, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m5590getTypeT8wyACA() {
        return this.type;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m5589getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r21, long r23, long r25, boolean r27, long r28, long r30, boolean r32, boolean r33, int r34, long r35, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m5669getTouchT8wyACA()
            r16 = r1
            goto L_0x0011
        L_0x000f:
            r16 = r34
        L_0x0011:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m4003getZeroF1C5BW0()
            r17 = r0
            goto L_0x0020
        L_0x001e:
            r17 = r35
        L_0x0020:
            r19 = 0
            r2 = r20
            r3 = r21
            r5 = r23
            r7 = r25
            r9 = r27
            r10 = r28
            r12 = r30
            r14 = r32
            r15 = r33
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (long) r10, (long) r12, (boolean) r14, (boolean) r15, (int) r16, (long) r17, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this(j, j2, j3, z, 1.0f, j4, j5, z2, z3, i, j6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, (i2 & 256) != 0 ? PointerType.Companion.m5669getTouchT8wyACA() : i, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        this(j, j2, j3, z, 1.0f, j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, Offset.Companion.m4003getZeroF1C5BW0(), (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List<HistoricalChange> list, long j6, long j7) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6, (DefaultConstructorMarker) null);
        this._historical = list;
        this.originalEventPosition = j7;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0$ui_release  reason: not valid java name */
    public final long m5586getOriginalEventPositionF1C5BW0$ui_release() {
        return this.originalEventPosition;
    }

    /* renamed from: setOriginalEventPosition-k-4lQ0M$ui_release  reason: not valid java name */
    public final void m5591setOriginalEventPositionk4lQ0M$ui_release(long j) {
        this.originalEventPosition = j;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    /* renamed from: copy-Ezr-O64$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5574copyEzrO64$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, Object obj) {
        int i3;
        int i4 = i2;
        long j6 = (i4 & 1) != 0 ? pointerInputChange.id : j;
        long j7 = (i4 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j8 = (i4 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i4 & 8) != 0 ? pointerInputChange.pressed : z;
        long j9 = (i4 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j10 = (i4 & 32) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i4 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        ConsumedData consumedData2 = (i4 & 128) != 0 ? pointerInputChange.consumed : consumedData;
        if ((i4 & 256) != 0) {
            i3 = pointerInputChange.type;
        } else {
            i3 = i;
        }
        return pointerInputChange.m5580copyEzrO64(j6, j7, j8, z3, j9, j10, z4, consumedData2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* renamed from: copy-Ezr-O64  reason: not valid java name */
    public final /* synthetic */ PointerInputChange m5580copyEzrO64(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, this.pressure, j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, getHistorical(), this.scrollDelta, this.originalEventPosition, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    /* renamed from: copy-JKmWfYY$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5575copyJKmWfYY$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long j9 = (i3 & 1) != 0 ? pointerInputChange2.id : j;
        long j10 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long j11 = (i3 & 4) != 0 ? pointerInputChange2.position : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j12 = (i3 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        long j13 = (i3 & 32) != 0 ? pointerInputChange2.previousPosition : j5;
        boolean z4 = (i3 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        int i4 = (i3 & 128) != 0 ? pointerInputChange2.type : i;
        if ((i3 & 256) != 0) {
            j7 = pointerInputChange2.scrollDelta;
            j8 = j9;
        } else {
            j7 = j6;
            j8 = j9;
        }
        return pointerInputChange2.m5581copyJKmWfYY(j8, j10, j11, z3, j12, j13, z4, i4, j7);
    }

    /* renamed from: copy-JKmWfYY  reason: not valid java name */
    public final PointerInputChange m5581copyJKmWfYY(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, long j6) {
        return m5584copywbzehF4(j, j2, j3, z, this.pressure, j4, j5, z2, i, getHistorical(), j6);
    }

    /* renamed from: copy-0GkPj7c$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5573copy0GkPj7c$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, long j6, int i2, Object obj) {
        long j7;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long j8 = (i3 & 1) != 0 ? pointerInputChange2.id : j;
        long j9 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long j10 = (i3 & 4) != 0 ? pointerInputChange2.position : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j11 = (i3 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        long j12 = (i3 & 32) != 0 ? pointerInputChange2.previousPosition : j5;
        boolean z4 = (i3 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        int i4 = (i3 & 256) != 0 ? pointerInputChange2.type : i;
        if ((i3 & 512) != 0) {
            j7 = pointerInputChange2.scrollDelta;
            j8 = j8;
        } else {
            j7 = j6;
        }
        return pointerInputChange2.m5579copy0GkPj7c(j8, j9, j10, z3, j11, j12, z4, consumedData, i4, j7);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    /* renamed from: copy-0GkPj7c  reason: not valid java name */
    public final PointerInputChange m5579copy0GkPj7c(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, long j6) {
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, this.pressure, j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, getHistorical(), j6, this.originalEventPosition, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    /* renamed from: copy-Tn9QgHE$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5577copyTn9QgHE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long j9 = (i3 & 1) != 0 ? pointerInputChange2.id : j;
        long j10 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long j11 = (i3 & 4) != 0 ? pointerInputChange2.position : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        float f2 = (i3 & 16) != 0 ? pointerInputChange2.pressure : f;
        long j12 = (i3 & 32) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        long j13 = (i3 & 64) != 0 ? pointerInputChange2.previousPosition : j5;
        boolean z4 = (i3 & 128) != 0 ? pointerInputChange2.previousPressed : z2;
        int i4 = (i3 & 256) != 0 ? pointerInputChange2.type : i;
        if ((i3 & 512) != 0) {
            j7 = pointerInputChange2.scrollDelta;
            j8 = j9;
        } else {
            j7 = j6;
            j8 = j9;
        }
        return pointerInputChange2.m5583copyTn9QgHE(j8, j10, j11, z3, f2, j12, j13, z4, i4, j7);
    }

    /* renamed from: copy-Tn9QgHE  reason: not valid java name */
    public final PointerInputChange m5583copyTn9QgHE(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, long j6) {
        long j7 = j;
        PointerInputChange pointerInputChange = new PointerInputChange(j7, j2, j3, z, f, j4, j5, z2, false, i, getHistorical(), j6, this.originalEventPosition, (DefaultConstructorMarker) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    /* renamed from: copy-OHpmEuE$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5576copyOHpmEuE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long j8 = (i3 & 1) != 0 ? pointerInputChange2.id : j;
        long j9 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long j10 = (i3 & 4) != 0 ? pointerInputChange2.position : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j11 = (i3 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        long j12 = (i3 & 32) != 0 ? pointerInputChange2.previousPosition : j5;
        boolean z4 = (i3 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        int i4 = (i3 & 128) != 0 ? pointerInputChange2.type : i;
        if ((i3 & 512) != 0) {
            j7 = pointerInputChange2.scrollDelta;
            j8 = j8;
        } else {
            j7 = j6;
        }
        return pointerInputChange2.m5582copyOHpmEuE(j8, j9, j10, z3, j11, j12, z4, i4, list, j7);
    }

    /* renamed from: copy-OHpmEuE  reason: not valid java name */
    public final PointerInputChange m5582copyOHpmEuE(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List<HistoricalChange> list, long j6) {
        return m5584copywbzehF4(j, j2, j3, z, this.pressure, j4, j5, z2, i, list, j6);
    }

    /* renamed from: copy-wbzehF4$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5578copywbzehF4$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        List list2;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long j8 = (i3 & 1) != 0 ? pointerInputChange2.id : j;
        long j9 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long j10 = (i3 & 4) != 0 ? pointerInputChange2.position : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        float f2 = (i3 & 16) != 0 ? pointerInputChange2.pressure : f;
        long j11 = (i3 & 32) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        long j12 = (i3 & 64) != 0 ? pointerInputChange2.previousPosition : j5;
        boolean z4 = (i3 & 128) != 0 ? pointerInputChange2.previousPressed : z2;
        int i4 = (i3 & 256) != 0 ? pointerInputChange2.type : i;
        long j13 = j8;
        List historical = (i3 & 512) != 0 ? pointerInputChange2.getHistorical() : list;
        if ((i3 & 1024) != 0) {
            list2 = historical;
            j7 = pointerInputChange2.scrollDelta;
        } else {
            j7 = j6;
            list2 = historical;
        }
        return pointerInputChange2.m5584copywbzehF4(j13, j9, j10, z3, f2, j11, j12, z4, i4, list2, j7);
    }

    /* renamed from: copy-wbzehF4  reason: not valid java name */
    public final PointerInputChange m5584copywbzehF4(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List<HistoricalChange> list, long j6) {
        long j7 = j;
        PointerInputChange pointerInputChange = new PointerInputChange(j7, j2, j3, z, f, j4, j5, z2, false, i, list, j6, this.originalEventPosition, (DefaultConstructorMarker) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointerInputChange(id=");
        sb.append(PointerId.m5571toStringimpl(this.id)).append(", uptimeMillis=").append(this.uptimeMillis).append(", position=").append(Offset.m3995toStringimpl(this.position)).append(", pressed=").append(this.pressed).append(", pressure=").append(this.pressure).append(", previousUptimeMillis=").append(this.previousUptimeMillis).append(", previousPosition=").append(Offset.m3995toStringimpl(this.previousPosition)).append(", previousPressed=").append(this.previousPressed).append(", isConsumed=").append(isConsumed()).append(", type=").append(PointerType.m5664toStringimpl(this.type)).append(", historical=").append(getHistorical()).append(",scrollDelta=");
        sb.append(Offset.m3995toStringimpl(this.scrollDelta)).append(')');
        return sb.toString();
    }
}
