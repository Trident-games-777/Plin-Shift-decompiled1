package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010?\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010?\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010A\u001a\u0001\u0010D\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010=\u001a£\u0001\u0010M\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u0002012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001aµ\u0001\u0010]\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010X\u001a\u00020\u00012\u0011\u0010^\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010_\u001a\u00020F2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010?\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a+\u0010b\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010c\u001a+\u0010d\u001a\u00020e2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010f\u001a>\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020e2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH@¢\u0006\u0002\u0010o\u001a>\u0010p\u001a\u00020h2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH@¢\u0006\u0002\u0010q\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006r²\u0006\n\u0010s\u001a\u000201X\u0002²\u0006\n\u0010t\u001a\u00020\u001cX\u0002"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "CenterAlignedTopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "collapsedHeight", "LargeTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "MediumTopAppBar-oKE7A98", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "SingleRowTopAppBar-cJHQLPU", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "TopAppBar-GHTll3U", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/ScrolledOffset;", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ScrolledOffset;JJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "TwoRowsTopAppBar-nS6u9G4", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "colorTransitionFraction", "appBarContainerColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    /* access modifiers changed from: private */
    public static final float FABHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding = Dp.m7111constructorimpl((float) 28);
    private static final float MediumTitleBottomPadding = Dp.m7111constructorimpl((float) 24);
    private static final float TopAppBarHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ef  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void TopAppBar(kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r8 = r28
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
            r1 = r27
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(TopAppBar)P(5,2,3!1,6)142@6819L12,143@6881L17,146@6960L306:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            r9 = r20
            goto L_0x002b
        L_0x0019:
            r2 = r8 & 6
            r9 = r20
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
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r21
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
            r4 = r21
        L_0x0047:
            r5 = r29 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r22
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r22
        L_0x0063:
            r7 = r29 & 8
            if (r7 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007d
            r10 = r23
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r23
        L_0x007f:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0098
            r11 = r29 & 16
            if (r11 != 0) goto L_0x0092
            r11 = r24
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r11 = r24
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r12
            goto L_0x009a
        L_0x0098:
            r11 = r24
        L_0x009a:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b4
            r12 = r29 & 32
            if (r12 != 0) goto L_0x00ae
            r12 = r25
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r12 = r25
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r13
            goto L_0x00b6
        L_0x00b4:
            r12 = r25
        L_0x00b6:
            r13 = r29 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00be
            r2 = r2 | r14
            goto L_0x00d0
        L_0x00be:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d0
            r14 = r26
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r14 = r26
        L_0x00d2:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r2
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ef
        L_0x00e2:
            r1.skipToGroupEnd()
            r17 = r1
            r2 = r4
            r3 = r6
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            goto L_0x01ad
        L_0x00ef:
            r1.startDefaults()
            r0 = r8 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x011c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0103
            goto L_0x011c
        L_0x0103:
            r1.skipToGroupEnd()
            r0 = r29 & 16
            if (r0 == 0) goto L_0x010c
            r2 = r2 & r17
        L_0x010c:
            r0 = r29 & 32
            if (r0 == 0) goto L_0x0111
            r2 = r2 & r15
        L_0x0111:
            r15 = r12
            r16 = r14
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
            r12 = r10
            r14 = r11
            r10 = r4
            r11 = r6
            goto L_0x0165
        L_0x011c:
            if (r3 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0124
        L_0x0123:
            r0 = r4
        L_0x0124:
            if (r5 == 0) goto L_0x012d
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1897getLambda1$material3_release()
            r6 = r3
        L_0x012d:
            if (r7 == 0) goto L_0x0136
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1907getLambda2$material3_release()
            r10 = r3
        L_0x0136:
            r3 = r29 & 16
            r4 = 6
            if (r3 == 0) goto L_0x0144
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r4)
            r2 = r2 & r17
            r11 = r3
        L_0x0144:
            r3 = r29 & 32
            if (r3 == 0) goto L_0x0150
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.topAppBarColors(r1, r4)
            r2 = r2 & r15
            r12 = r3
        L_0x0150:
            if (r13 == 0) goto L_0x015b
            r3 = 0
            r16 = r3
            r14 = r11
            r15 = r12
            r11 = r6
            r12 = r10
            r10 = r0
            goto L_0x0162
        L_0x015b:
            r15 = r12
            r16 = r14
            r12 = r10
            r14 = r11
            r10 = r0
            r11 = r6
        L_0x0162:
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
        L_0x0165:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0174
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.TopAppBar (AppBar.kt:146)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x0174:
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r13 = r0.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r0 = r2 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            int r2 = r2 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r18 = r0 | r2
            r19 = 0
            r17 = r1
            m1722TopAppBarGHTll3U(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a6:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r14
            r6 = r15
            r7 = r16
        L_0x01ad:
            androidx.compose.runtime.ScopeUpdateScope r10 = r17.endRestartGroup()
            if (r10 == 0) goto L_0x01c1
            androidx.compose.material3.AppBarKt$TopAppBar$1 r0 = new androidx.compose.material3.AppBarKt$TopAppBar$1
            r1 = r20
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011b  */
    /* renamed from: TopAppBar-GHTll3U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1722TopAppBarGHTll3U(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, float r28, androidx.compose.foundation.layout.WindowInsets r29, androidx.compose.material3.TopAppBarColors r30, androidx.compose.material3.TopAppBarScrollBehavior r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r33
            r10 = r34
            r0 = 226148675(0xd7ac143, float:7.726983E-31)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(TopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)204@9890L12,205@9952L17,211@10162L5,208@10031L579:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r12 = r24
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r12 = r24
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r25
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r25
        L_0x0049:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r9 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r26
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r26
        L_0x0065:
            r7 = r10 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r27
            boolean r11 = r1.changedInstance(r8)
            if (r11 == 0) goto L_0x007b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r11
            goto L_0x0081
        L_0x007f:
            r8 = r27
        L_0x0081:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r28
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r28
        L_0x009d:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00b7
            r14 = r10 & 32
            if (r14 != 0) goto L_0x00b1
            r14 = r29
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r14 = r29
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r15
            goto L_0x00b9
        L_0x00b7:
            r14 = r29
        L_0x00b9:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00d4
            r15 = r10 & 64
            if (r15 != 0) goto L_0x00cd
            r15 = r30
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cf
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cd:
            r15 = r30
        L_0x00cf:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r16
            goto L_0x00d6
        L_0x00d4:
            r15 = r30
        L_0x00d6:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r2 = r2 | r17
            goto L_0x00f5
        L_0x00df:
            r17 = r9 & r17
            if (r17 != 0) goto L_0x00f5
            r17 = r0
            r0 = r31
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r2 = r2 | r18
            goto L_0x00f9
        L_0x00f5:
            r17 = r0
            r0 = r31
        L_0x00f9:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r18
            r32 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011b
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x010c
            goto L_0x011b
        L_0x010c:
            r1.skipToGroupEnd()
            r21 = r1
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r31
            goto L_0x0223
        L_0x011b:
            r1.startDefaults()
            r0 = r9 & 1
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x0152
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0130
            goto L_0x0152
        L_0x0130:
            r1.skipToGroupEnd()
            r0 = r10 & 32
            if (r0 == 0) goto L_0x013a
            r0 = r32 & r18
            goto L_0x013c
        L_0x013a:
            r0 = r32
        L_0x013c:
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0142
            r0 = r0 & r19
        L_0x0142:
            r20 = r31
            r11 = r4
            r16 = r8
            r18 = r14
            r19 = r15
            r3 = 226148675(0xd7ac143, float:7.726983E-31)
            r4 = r0
            r15 = r6
            r0 = r13
            goto L_0x01a7
        L_0x0152:
            if (r3 == 0) goto L_0x0159
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x015a
        L_0x0159:
            r0 = r4
        L_0x015a:
            if (r5 == 0) goto L_0x0163
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1908getLambda3$material3_release()
            r6 = r3
        L_0x0163:
            if (r7 == 0) goto L_0x016c
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1909getLambda4$material3_release()
            r8 = r3
        L_0x016c:
            if (r11 == 0) goto L_0x0175
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r3 = r3.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r13 = r3
        L_0x0175:
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0183
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r2)
            r4 = r32 & r18
            r14 = r3
            goto L_0x0185
        L_0x0183:
            r4 = r32
        L_0x0185:
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0192
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.topAppBarColors(r1, r2)
            r4 = r4 & r19
            r15 = r3
        L_0x0192:
            if (r17 == 0) goto L_0x0199
            r3 = 0
            r11 = r0
            r20 = r3
            goto L_0x019c
        L_0x0199:
            r20 = r31
            r11 = r0
        L_0x019c:
            r16 = r8
            r0 = r13
            r18 = r14
            r19 = r15
            r3 = 226148675(0xd7ac143, float:7.726983E-31)
            r15 = r6
        L_0x01a7:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01b6
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.TopAppBar (AppBar.kt:208)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r5, r6)
        L_0x01b6:
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r13 = androidx.compose.material3.TypographyKt.getValue(r3, r1, r2)
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m7131getUnspecifiedD9Ej5fM()
            boolean r3 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r3)
            if (r3 != 0) goto L_0x01dc
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m7130getInfinityD9Ej5fM()
            boolean r3 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r3)
            if (r3 == 0) goto L_0x01d9
            goto L_0x01dc
        L_0x01d9:
            r17 = r0
            goto L_0x01e4
        L_0x01dc:
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r3 = r3.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r17 = r3
        L_0x01e4:
            int r3 = r4 >> 3
            r3 = r3 & 14
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            int r5 = r4 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r3 = r3 | r5
            int r2 = r4 << 6
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r4
            r22 = r3 | r2
            r23 = 0
            r14 = 0
            r21 = r1
            m1721SingleRowTopAppBarcJHQLPU(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0218
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0218:
            r5 = r0
            r2 = r11
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r20
        L_0x0223:
            androidx.compose.runtime.ScopeUpdateScope r11 = r21.endRestartGroup()
            if (r11 == 0) goto L_0x0235
            androidx.compose.material3.AppBarKt$TopAppBar$2 r0 = new androidx.compose.material3.AppBarKt$TopAppBar$2
            r1 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1722TopAppBarGHTll3U(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ef  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void CenterAlignedTopAppBar(kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r8 = r28
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            r1 = r27
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CenterAlignedTopAppBar)P(5,2,3!1,6)269@12968L12,270@13030L30,273@13122L319:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            r9 = r20
            goto L_0x002b
        L_0x0019:
            r2 = r8 & 6
            r9 = r20
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
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r21
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
            r4 = r21
        L_0x0047:
            r5 = r29 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r22
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r22
        L_0x0063:
            r7 = r29 & 8
            if (r7 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007d
            r10 = r23
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r23
        L_0x007f:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0098
            r11 = r29 & 16
            if (r11 != 0) goto L_0x0092
            r11 = r24
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r11 = r24
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r12
            goto L_0x009a
        L_0x0098:
            r11 = r24
        L_0x009a:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b4
            r12 = r29 & 32
            if (r12 != 0) goto L_0x00ae
            r12 = r25
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r12 = r25
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r13
            goto L_0x00b6
        L_0x00b4:
            r12 = r25
        L_0x00b6:
            r13 = r29 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00be
            r2 = r2 | r14
            goto L_0x00d0
        L_0x00be:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d0
            r14 = r26
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r14 = r26
        L_0x00d2:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r2
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ef
        L_0x00e2:
            r1.skipToGroupEnd()
            r17 = r1
            r2 = r4
            r3 = r6
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            goto L_0x01ad
        L_0x00ef:
            r1.startDefaults()
            r0 = r8 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x011c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0103
            goto L_0x011c
        L_0x0103:
            r1.skipToGroupEnd()
            r0 = r29 & 16
            if (r0 == 0) goto L_0x010c
            r2 = r2 & r17
        L_0x010c:
            r0 = r29 & 32
            if (r0 == 0) goto L_0x0111
            r2 = r2 & r15
        L_0x0111:
            r15 = r12
            r16 = r14
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            r12 = r10
            r14 = r11
            r10 = r4
            r11 = r6
            goto L_0x0165
        L_0x011c:
            if (r3 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0124
        L_0x0123:
            r0 = r4
        L_0x0124:
            if (r5 == 0) goto L_0x012d
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1910getLambda5$material3_release()
            r6 = r3
        L_0x012d:
            if (r7 == 0) goto L_0x0136
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1911getLambda6$material3_release()
            r10 = r3
        L_0x0136:
            r3 = r29 & 16
            r4 = 6
            if (r3 == 0) goto L_0x0144
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r4)
            r2 = r2 & r17
            r11 = r3
        L_0x0144:
            r3 = r29 & 32
            if (r3 == 0) goto L_0x0150
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.centerAlignedTopAppBarColors(r1, r4)
            r2 = r2 & r15
            r12 = r3
        L_0x0150:
            if (r13 == 0) goto L_0x015b
            r3 = 0
            r16 = r3
            r14 = r11
            r15 = r12
            r11 = r6
            r12 = r10
            r10 = r0
            goto L_0x0162
        L_0x015b:
            r15 = r12
            r16 = r14
            r12 = r10
            r14 = r11
            r10 = r0
            r11 = r6
        L_0x0162:
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
        L_0x0165:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0174
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:273)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x0174:
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r13 = r0.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r0 = r2 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            int r2 = r2 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r18 = r0 | r2
            r19 = 0
            r17 = r1
            m1718CenterAlignedTopAppBarGHTll3U(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a6:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r14
            r6 = r15
            r7 = r16
        L_0x01ad:
            androidx.compose.runtime.ScopeUpdateScope r10 = r17.endRestartGroup()
            if (r10 == 0) goto L_0x01c1
            androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1 r0 = new androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
            r1 = r20
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011b  */
    /* renamed from: CenterAlignedTopAppBar-GHTll3U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1718CenterAlignedTopAppBarGHTll3U(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, float r28, androidx.compose.foundation.layout.WindowInsets r29, androidx.compose.material3.TopAppBarColors r30, androidx.compose.material3.TopAppBarScrollBehavior r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r33
            r10 = r34
            r0 = 1952988048(0x74683b90, float:7.359747E31)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(CenterAlignedTopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)328@16080L12,329@16142L30,335@16365L5,332@16234L578:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r12 = r24
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r12 = r24
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r25
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r25
        L_0x0049:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r9 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r26
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r26
        L_0x0065:
            r7 = r10 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r27
            boolean r11 = r1.changedInstance(r8)
            if (r11 == 0) goto L_0x007b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r11
            goto L_0x0081
        L_0x007f:
            r8 = r27
        L_0x0081:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r28
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r28
        L_0x009d:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00b7
            r14 = r10 & 32
            if (r14 != 0) goto L_0x00b1
            r14 = r29
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r14 = r29
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r15
            goto L_0x00b9
        L_0x00b7:
            r14 = r29
        L_0x00b9:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00d4
            r15 = r10 & 64
            if (r15 != 0) goto L_0x00cd
            r15 = r30
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cf
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cd:
            r15 = r30
        L_0x00cf:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r16
            goto L_0x00d6
        L_0x00d4:
            r15 = r30
        L_0x00d6:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r2 = r2 | r17
            goto L_0x00f5
        L_0x00df:
            r17 = r9 & r17
            if (r17 != 0) goto L_0x00f5
            r17 = r0
            r0 = r31
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r2 = r2 | r18
            goto L_0x00f9
        L_0x00f5:
            r17 = r0
            r0 = r31
        L_0x00f9:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r18
            r32 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011b
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x010c
            goto L_0x011b
        L_0x010c:
            r1.skipToGroupEnd()
            r21 = r1
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r31
            goto L_0x0223
        L_0x011b:
            r1.startDefaults()
            r0 = r9 & 1
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x0152
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0130
            goto L_0x0152
        L_0x0130:
            r1.skipToGroupEnd()
            r0 = r10 & 32
            if (r0 == 0) goto L_0x013a
            r0 = r32 & r18
            goto L_0x013c
        L_0x013a:
            r0 = r32
        L_0x013c:
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0142
            r0 = r0 & r19
        L_0x0142:
            r20 = r31
            r11 = r4
            r16 = r8
            r18 = r14
            r19 = r15
            r3 = 1952988048(0x74683b90, float:7.359747E31)
            r4 = r0
            r15 = r6
            r0 = r13
            goto L_0x01a7
        L_0x0152:
            if (r3 == 0) goto L_0x0159
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x015a
        L_0x0159:
            r0 = r4
        L_0x015a:
            if (r5 == 0) goto L_0x0163
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1912getLambda7$material3_release()
            r6 = r3
        L_0x0163:
            if (r7 == 0) goto L_0x016c
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1913getLambda8$material3_release()
            r8 = r3
        L_0x016c:
            if (r11 == 0) goto L_0x0175
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r3 = r3.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r13 = r3
        L_0x0175:
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0183
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r2)
            r4 = r32 & r18
            r14 = r3
            goto L_0x0185
        L_0x0183:
            r4 = r32
        L_0x0185:
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0192
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.centerAlignedTopAppBarColors(r1, r2)
            r4 = r4 & r19
            r15 = r3
        L_0x0192:
            if (r17 == 0) goto L_0x0199
            r3 = 0
            r11 = r0
            r20 = r3
            goto L_0x019c
        L_0x0199:
            r20 = r31
            r11 = r0
        L_0x019c:
            r16 = r8
            r0 = r13
            r18 = r14
            r19 = r15
            r3 = 1952988048(0x74683b90, float:7.359747E31)
            r15 = r6
        L_0x01a7:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01b6
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:332)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r5, r6)
        L_0x01b6:
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r13 = androidx.compose.material3.TypographyKt.getValue(r3, r1, r2)
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m7131getUnspecifiedD9Ej5fM()
            boolean r3 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r3)
            if (r3 != 0) goto L_0x01dc
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m7130getInfinityD9Ej5fM()
            boolean r3 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r3)
            if (r3 == 0) goto L_0x01d9
            goto L_0x01dc
        L_0x01d9:
            r17 = r0
            goto L_0x01e4
        L_0x01dc:
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r3 = r3.m2870getTopAppBarExpandedHeightD9Ej5fM()
            r17 = r3
        L_0x01e4:
            int r3 = r4 >> 3
            r3 = r3 & 14
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            int r5 = r4 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r3 = r3 | r5
            int r2 = r4 << 6
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r4
            r22 = r3 | r2
            r23 = 0
            r14 = 1
            r21 = r1
            m1721SingleRowTopAppBarcJHQLPU(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0218
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0218:
            r5 = r0
            r2 = r11
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r8 = r20
        L_0x0223:
            androidx.compose.runtime.ScopeUpdateScope r11 = r21.endRestartGroup()
            if (r11 == 0) goto L_0x0235
            androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$2 r0 = new androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$2
            r1 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1718CenterAlignedTopAppBarGHTll3U(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ef  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void MediumTopAppBar(kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(MediumTopAppBar)P(5,2,3!1,6)396@19336L12,397@19398L23,400@19483L388:AppBar.kt#uh7d8r"
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
            r5 = r30 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r23
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r23
        L_0x0063:
            r7 = r30 & 8
            if (r7 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007d
            r10 = r24
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r24
        L_0x007f:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0098
            r11 = r30 & 16
            if (r11 != 0) goto L_0x0092
            r11 = r25
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r11 = r25
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r12
            goto L_0x009a
        L_0x0098:
            r11 = r25
        L_0x009a:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b4
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00ae
            r12 = r26
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r12 = r26
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r13
            goto L_0x00b6
        L_0x00b4:
            r12 = r26
        L_0x00b6:
            r13 = r30 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00be
            r2 = r2 | r14
            goto L_0x00d0
        L_0x00be:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d0
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r14 = r27
        L_0x00d2:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r2
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ef
        L_0x00e2:
            r1.skipToGroupEnd()
            r18 = r1
            r2 = r4
            r3 = r6
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            goto L_0x01b9
        L_0x00ef:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r28 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0120
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0104
            goto L_0x0120
        L_0x0104:
            r1.skipToGroupEnd()
            r0 = r30 & 16
            if (r0 == 0) goto L_0x010d
            r2 = r2 & r17
        L_0x010d:
            r0 = r30 & 32
            if (r0 == 0) goto L_0x0113
            r2 = r2 & r28
        L_0x0113:
            r16 = r12
            r17 = r14
            r0 = r15
            r3 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r12 = r10
            r15 = r11
            r10 = r4
        L_0x011e:
            r11 = r6
            goto L_0x0168
        L_0x0120:
            if (r3 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0128
        L_0x0127:
            r0 = r4
        L_0x0128:
            if (r5 == 0) goto L_0x0131
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1914getLambda9$material3_release()
            r6 = r3
        L_0x0131:
            if (r7 == 0) goto L_0x013a
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1898getLambda10$material3_release()
            r10 = r3
        L_0x013a:
            r3 = r30 & 16
            if (r3 == 0) goto L_0x0147
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r15)
            r2 = r2 & r17
            r11 = r3
        L_0x0147:
            r3 = r30 & 32
            if (r3 == 0) goto L_0x0154
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.mediumTopAppBarColors(r1, r15)
            r2 = r2 & r28
            r12 = r3
        L_0x0154:
            if (r13 == 0) goto L_0x015c
            r3 = 0
            r17 = r3
            r16 = r12
            goto L_0x0160
        L_0x015c:
            r16 = r12
            r17 = r14
        L_0x0160:
            r3 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r12 = r10
            r10 = r0
            r0 = r15
            r15 = r11
            goto L_0x011e
        L_0x0168:
            r1.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0177
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.MediumTopAppBar (AppBar.kt:400)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r4, r5)
        L_0x0177:
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r13 = r3.m2868getMediumAppBarCollapsedHeightD9Ej5fM()
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r14 = r3.m2869getMediumAppBarExpandedHeightD9Ej5fM()
            r3 = r2 & 14
            r4 = 221184(0x36000, float:3.09945E-40)
            r3 = r3 | r4
            r4 = r2 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            int r0 = r2 << 6
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r0
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r3
            r19 = r2 | r0
            r20 = 0
            r18 = r1
            m1720MediumTopAppBaroKE7A98(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b1:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r15
            r6 = r16
            r7 = r17
        L_0x01b9:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x01cd
            androidx.compose.material3.AppBarKt$MediumTopAppBar$1 r0 = new androidx.compose.material3.AppBarKt$MediumTopAppBar$1
            r1 = r21
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fd  */
    /* renamed from: MediumTopAppBar-oKE7A98  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1720MediumTopAppBaroKE7A98(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, float r33, float r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r10 = r39
            r11 = r40
            r0 = 1879191686(0x70023086, float:1.6116685E29)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(MediumTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)465@23246L12,466@23308L23,472@23523L5,473@23594L5,469@23393L947:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r13 = r29
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r13 = r29
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r13)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r10
            goto L_0x002d
        L_0x002c:
            r2 = r10
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r10 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r30
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r30
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r31
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r31
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r32
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r32
        L_0x0081:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009b
            r12 = r33
            boolean r14 = r1.changed((float) r12)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r12 = r33
        L_0x009d:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b8
            r15 = r34
            boolean r16 = r1.changed((float) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r34
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r11 & 64
            r0 = r35
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r35
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00f2
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00eb
            r0 = r36
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ed
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r0 = r36
        L_0x00ed:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r2 = r2 | r17
            goto L_0x00f4
        L_0x00f2:
            r0 = r36
        L_0x00f4:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fd
            r2 = r2 | r17
            goto L_0x0113
        L_0x00fd:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x0113
            r17 = r0
            r0 = r37
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010e
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r2 = r2 | r18
            goto L_0x0117
        L_0x0113:
            r17 = r0
            r0 = r37
        L_0x0117:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r18
            r38 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x013c
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x012a
            goto L_0x013c
        L_0x012a:
            r1.skipToGroupEnd()
            r7 = r35
            r9 = r37
            r25 = r1
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r12
            r6 = r15
            r8 = r36
            goto L_0x0289
        L_0x013c:
            r1.startDefaults()
            r0 = r10 & 1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 6
            if (r0 == 0) goto L_0x0174
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0151
            goto L_0x0174
        L_0x0151:
            r1.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x015b
            r0 = r38 & r18
            goto L_0x015d
        L_0x015b:
            r0 = r38
        L_0x015d:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0163
            r0 = r0 & r19
        L_0x0163:
            r3 = r4
            r4 = r0
            r0 = r12
            r12 = r3
            r22 = r35
            r23 = r36
            r24 = r37
            r18 = r6
            r19 = r8
        L_0x0171:
            r3 = r15
            goto L_0x01d9
        L_0x0174:
            if (r3 == 0) goto L_0x017b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x017b:
            if (r5 == 0) goto L_0x0184
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1899getLambda11$material3_release()
            r6 = r0
        L_0x0184:
            if (r7 == 0) goto L_0x018d
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m1900getLambda12$material3_release()
            r8 = r0
        L_0x018d:
            if (r9 == 0) goto L_0x0196
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r0 = r0.m2868getMediumAppBarCollapsedHeightD9Ej5fM()
            r12 = r0
        L_0x0196:
            if (r14 == 0) goto L_0x019f
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r0 = r0.m2869getMediumAppBarExpandedHeightD9Ej5fM()
            r15 = r0
        L_0x019f:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x01ac
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r1, r2)
            r3 = r38 & r18
            goto L_0x01b0
        L_0x01ac:
            r0 = r35
            r3 = r38
        L_0x01b0:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x01bd
            androidx.compose.material3.TopAppBarDefaults r5 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r5 = r5.mediumTopAppBarColors(r1, r2)
            r3 = r3 & r19
            goto L_0x01bf
        L_0x01bd:
            r5 = r36
        L_0x01bf:
            if (r17 == 0) goto L_0x01cb
            r7 = 0
            r22 = r0
            r23 = r5
            r18 = r6
            r24 = r7
            goto L_0x01d3
        L_0x01cb:
            r24 = r37
            r22 = r0
            r23 = r5
            r18 = r6
        L_0x01d3:
            r19 = r8
            r0 = r12
            r12 = r4
            r4 = r3
            goto L_0x0171
        L_0x01d9:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01eb
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.MediumTopAppBar (AppBar.kt:469)"
            r7 = 1879191686(0x70023086, float:1.6116685E29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r5, r6)
        L_0x01eb:
            androidx.compose.material3.tokens.TopAppBarMediumTokens r5 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r2)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r5 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r2)
            float r15 = MediumTitleBottomPadding
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7131getUnspecifiedD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r2)
            if (r2 != 0) goto L_0x021d
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7130getInfinityD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r2)
            if (r2 == 0) goto L_0x021a
            goto L_0x021d
        L_0x021a:
            r20 = r0
            goto L_0x0225
        L_0x021d:
            androidx.compose.material3.TopAppBarDefaults r2 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r2 = r2.m2868getMediumAppBarCollapsedHeightD9Ej5fM()
            r20 = r2
        L_0x0225:
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7131getUnspecifiedD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r3, r2)
            if (r2 != 0) goto L_0x0241
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7130getInfinityD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r3, r2)
            if (r2 == 0) goto L_0x023e
            goto L_0x0241
        L_0x023e:
            r21 = r3
            goto L_0x0249
        L_0x0241:
            androidx.compose.material3.TopAppBarDefaults r2 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r2 = r2.m2869getMediumAppBarExpandedHeightD9Ej5fM()
            r21 = r2
        L_0x0249:
            int r2 = r4 >> 3
            r2 = r2 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            int r5 = r4 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r5 = r4 << 12
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r6
            r26 = r2 | r5
            int r2 = r4 >> 18
            r2 = r2 & 1022(0x3fe, float:1.432E-42)
            r28 = 0
            r16 = r29
            r25 = r1
            r27 = r2
            m1724TwoRowsTopAppBarnS6u9G4(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x027c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027c:
            r5 = r0
            r6 = r3
            r2 = r12
            r3 = r18
            r4 = r19
            r7 = r22
            r8 = r23
            r9 = r24
        L_0x0289:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 == 0) goto L_0x029b
            androidx.compose.material3.AppBarKt$MediumTopAppBar$2 r0 = new androidx.compose.material3.AppBarKt$MediumTopAppBar$2
            r1 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1720MediumTopAppBaroKE7A98(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ef  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void LargeTopAppBar(kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LargeTopAppBar)P(5,2,3!1,6)541@26855L12,542@26917L22,545@27001L385:AppBar.kt#uh7d8r"
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
            r5 = r30 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r23
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r23
        L_0x0063:
            r7 = r30 & 8
            if (r7 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007d
            r10 = r24
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r24
        L_0x007f:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0098
            r11 = r30 & 16
            if (r11 != 0) goto L_0x0092
            r11 = r25
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r11 = r25
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r12
            goto L_0x009a
        L_0x0098:
            r11 = r25
        L_0x009a:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b4
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00ae
            r12 = r26
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r12 = r26
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r13
            goto L_0x00b6
        L_0x00b4:
            r12 = r26
        L_0x00b6:
            r13 = r30 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00be
            r2 = r2 | r14
            goto L_0x00d0
        L_0x00be:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d0
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r14 = r27
        L_0x00d2:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r2
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r0) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00ef
        L_0x00e2:
            r1.skipToGroupEnd()
            r18 = r1
            r2 = r4
            r3 = r6
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            goto L_0x01b9
        L_0x00ef:
            r1.startDefaults()
            r0 = r8 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r28 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = 6
            if (r0 == 0) goto L_0x0120
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0104
            goto L_0x0120
        L_0x0104:
            r1.skipToGroupEnd()
            r0 = r30 & 16
            if (r0 == 0) goto L_0x010d
            r2 = r2 & r17
        L_0x010d:
            r0 = r30 & 32
            if (r0 == 0) goto L_0x0113
            r2 = r2 & r28
        L_0x0113:
            r16 = r12
            r17 = r14
            r0 = r15
            r3 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r12 = r10
            r15 = r11
            r10 = r4
        L_0x011e:
            r11 = r6
            goto L_0x0168
        L_0x0120:
            if (r3 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0128
        L_0x0127:
            r0 = r4
        L_0x0128:
            if (r5 == 0) goto L_0x0131
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1901getLambda13$material3_release()
            r6 = r3
        L_0x0131:
            if (r7 == 0) goto L_0x013a
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1902getLambda14$material3_release()
            r10 = r3
        L_0x013a:
            r3 = r30 & 16
            if (r3 == 0) goto L_0x0147
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r3 = r3.getWindowInsets(r1, r15)
            r2 = r2 & r17
            r11 = r3
        L_0x0147:
            r3 = r30 & 32
            if (r3 == 0) goto L_0x0154
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r3 = r3.largeTopAppBarColors(r1, r15)
            r2 = r2 & r28
            r12 = r3
        L_0x0154:
            if (r13 == 0) goto L_0x015c
            r3 = 0
            r17 = r3
            r16 = r12
            goto L_0x0160
        L_0x015c:
            r16 = r12
            r17 = r14
        L_0x0160:
            r3 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r12 = r10
            r10 = r0
            r0 = r15
            r15 = r11
            goto L_0x011e
        L_0x0168:
            r1.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0177
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.LargeTopAppBar (AppBar.kt:545)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r4, r5)
        L_0x0177:
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r13 = r3.m2866getLargeAppBarCollapsedHeightD9Ej5fM()
            androidx.compose.material3.TopAppBarDefaults r3 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r14 = r3.m2867getLargeAppBarExpandedHeightD9Ej5fM()
            r3 = r2 & 14
            r4 = 221184(0x36000, float:3.09945E-40)
            r3 = r3 | r4
            r4 = r2 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            int r0 = r2 << 6
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r0
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r3
            r19 = r2 | r0
            r20 = 0
            r18 = r1
            m1719LargeTopAppBaroKE7A98(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b1:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r15
            r6 = r16
            r7 = r17
        L_0x01b9:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x01cd
            androidx.compose.material3.AppBarKt$LargeTopAppBar$1 r0 = new androidx.compose.material3.AppBarKt$LargeTopAppBar$1
            r1 = r21
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fd  */
    /* renamed from: LargeTopAppBar-oKE7A98  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1719LargeTopAppBaroKE7A98(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, float r33, float r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r10 = r39
            r11 = r40
            r0 = -630005584(0xffffffffda72e0b0, float:-1.70909977E16)
            r1 = r38
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(LargeTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)610@30747L12,611@30809L22,616@30993L5,617@31064L5,614@30893L943:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r13 = r29
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r13 = r29
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r13)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r10
            goto L_0x002d
        L_0x002c:
            r2 = r10
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r10 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r30
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r30
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r31
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r31
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r32
            boolean r9 = r1.changedInstance(r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r32
        L_0x0081:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009b
            r12 = r33
            boolean r14 = r1.changed((float) r12)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r12 = r33
        L_0x009d:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b8
            r15 = r34
            boolean r16 = r1.changed((float) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r34
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r11 & 64
            r0 = r35
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r35
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00f2
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00eb
            r0 = r36
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00ed
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r0 = r36
        L_0x00ed:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r2 = r2 | r17
            goto L_0x00f4
        L_0x00f2:
            r0 = r36
        L_0x00f4:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fd
            r2 = r2 | r17
            goto L_0x0113
        L_0x00fd:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x0113
            r17 = r0
            r0 = r37
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010e
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r2 = r2 | r18
            goto L_0x0117
        L_0x0113:
            r17 = r0
            r0 = r37
        L_0x0117:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r18
            r38 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x013c
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x012a
            goto L_0x013c
        L_0x012a:
            r1.skipToGroupEnd()
            r7 = r35
            r9 = r37
            r25 = r1
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r12
            r6 = r15
            r8 = r36
            goto L_0x0289
        L_0x013c:
            r1.startDefaults()
            r0 = r10 & 1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 6
            if (r0 == 0) goto L_0x0174
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0151
            goto L_0x0174
        L_0x0151:
            r1.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x015b
            r0 = r38 & r18
            goto L_0x015d
        L_0x015b:
            r0 = r38
        L_0x015d:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0163
            r0 = r0 & r19
        L_0x0163:
            r3 = r4
            r4 = r0
            r0 = r12
            r12 = r3
            r22 = r35
            r23 = r36
            r24 = r37
            r18 = r6
            r19 = r8
        L_0x0171:
            r3 = r15
            goto L_0x01d9
        L_0x0174:
            if (r3 == 0) goto L_0x017b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x017b:
            if (r5 == 0) goto L_0x0184
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1903getLambda15$material3_release()
            r6 = r0
        L_0x0184:
            if (r7 == 0) goto L_0x018d
            androidx.compose.material3.ComposableSingletons$AppBarKt r0 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m1904getLambda16$material3_release()
            r8 = r0
        L_0x018d:
            if (r9 == 0) goto L_0x0196
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r0 = r0.m2866getLargeAppBarCollapsedHeightD9Ej5fM()
            r12 = r0
        L_0x0196:
            if (r14 == 0) goto L_0x019f
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r0 = r0.m2867getLargeAppBarExpandedHeightD9Ej5fM()
            r15 = r0
        L_0x019f:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x01ac
            androidx.compose.material3.TopAppBarDefaults r0 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r1, r2)
            r3 = r38 & r18
            goto L_0x01b0
        L_0x01ac:
            r0 = r35
            r3 = r38
        L_0x01b0:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x01bd
            androidx.compose.material3.TopAppBarDefaults r5 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.material3.TopAppBarColors r5 = r5.largeTopAppBarColors(r1, r2)
            r3 = r3 & r19
            goto L_0x01bf
        L_0x01bd:
            r5 = r36
        L_0x01bf:
            if (r17 == 0) goto L_0x01cb
            r7 = 0
            r22 = r0
            r23 = r5
            r18 = r6
            r24 = r7
            goto L_0x01d3
        L_0x01cb:
            r24 = r37
            r22 = r0
            r23 = r5
            r18 = r6
        L_0x01d3:
            r19 = r8
            r0 = r12
            r12 = r4
            r4 = r3
            goto L_0x0171
        L_0x01d9:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01eb
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.LargeTopAppBar (AppBar.kt:614)"
            r7 = -630005584(0xffffffffda72e0b0, float:-1.70909977E16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r5, r6)
        L_0x01eb:
            androidx.compose.material3.tokens.TopAppBarLargeTokens r5 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r2)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r5 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r2)
            float r15 = LargeTitleBottomPadding
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7131getUnspecifiedD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r2)
            if (r2 != 0) goto L_0x021d
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7130getInfinityD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r0, r2)
            if (r2 == 0) goto L_0x021a
            goto L_0x021d
        L_0x021a:
            r20 = r0
            goto L_0x0225
        L_0x021d:
            androidx.compose.material3.TopAppBarDefaults r2 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r2 = r2.m2866getLargeAppBarCollapsedHeightD9Ej5fM()
            r20 = r2
        L_0x0225:
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7131getUnspecifiedD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r3, r2)
            if (r2 != 0) goto L_0x0241
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m7130getInfinityD9Ej5fM()
            boolean r2 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r3, r2)
            if (r2 == 0) goto L_0x023e
            goto L_0x0241
        L_0x023e:
            r21 = r3
            goto L_0x0249
        L_0x0241:
            androidx.compose.material3.TopAppBarDefaults r2 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            float r2 = r2.m2867getLargeAppBarExpandedHeightD9Ej5fM()
            r21 = r2
        L_0x0249:
            int r2 = r4 >> 3
            r2 = r2 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            int r5 = r4 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r5 = r4 << 12
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r2 = r2 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r6
            r26 = r2 | r5
            int r2 = r4 >> 18
            r2 = r2 & 1022(0x3fe, float:1.432E-42)
            r28 = 0
            r16 = r29
            r25 = r1
            r27 = r2
            m1724TwoRowsTopAppBarnS6u9G4(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x027c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027c:
            r5 = r0
            r6 = r3
            r2 = r12
            r3 = r18
            r4 = r19
            r7 = r22
            r8 = r23
            r9 = r24
        L_0x0289:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 == 0) goto L_0x029b
            androidx.compose.material3.AppBarKt$LargeTopAppBar$2 r0 = new androidx.compose.material3.AppBarKt$LargeTopAppBar$2
            r1 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1719LargeTopAppBaroKE7A98(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0117  */
    /* renamed from: BottomAppBar-Snr_uVM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1715BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r11 = r38
            r12 = r39
            r0 = 2141738945(0x7fa857c1, float:NaN)
            r1 = r37
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)678@33855L14,679@33897L31,682@34123L12,684@34145L355:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r11 | 6
            r13 = r27
            goto L_0x002d
        L_0x001b:
            r2 = r11 & 6
            r13 = r27
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r13)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r11
            goto L_0x002d
        L_0x002c:
            r2 = r11
        L_0x002d:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r11 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r28
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r28
        L_0x0049:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r29
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r29
        L_0x0065:
            r7 = r11 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r12 & 8
            if (r7 != 0) goto L_0x0078
            r7 = r30
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x0078:
            r7 = r30
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r9
            goto L_0x0080
        L_0x007e:
            r7 = r30
        L_0x0080:
            r9 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0099
            r9 = r12 & 16
            if (r9 != 0) goto L_0x0093
            r9 = r32
            boolean r14 = r1.changed((long) r9)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r9 = r32
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r14
            goto L_0x009b
        L_0x0099:
            r9 = r32
        L_0x009b:
            r14 = r12 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r2 = r2 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00b6
            r15 = r34
            boolean r16 = r1.changed((float) r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r34
        L_0x00b8:
            r16 = r12 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c3
            r2 = r2 | r17
            r0 = r35
            goto L_0x00d6
        L_0x00c3:
            r17 = r11 & r17
            r0 = r35
            if (r17 != 0) goto L_0x00d6
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d2
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r2 = r2 | r18
        L_0x00d6:
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x00f2
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00eb
            r0 = r36
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r0 = r36
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r2 = r2 | r18
            goto L_0x00f4
        L_0x00f2:
            r0 = r36
        L_0x00f4:
            r18 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r18
            r37 = r3
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0117
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0107
            goto L_0x0117
        L_0x0107:
            r1.skipToGroupEnd()
            r24 = r1
            r2 = r4
            r3 = r6
            r4 = r7
            r6 = r9
            r8 = r15
            r9 = r35
            r10 = r36
            goto L_0x01ed
        L_0x0117:
            r1.startDefaults()
            r0 = r11 & 1
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x014f
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x014f
        L_0x012b:
            r1.skipToGroupEnd()
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0134
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x013a
            r2 = r2 & r18
        L_0x013a:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x013f
            r2 = r2 & r3
        L_0x013f:
            r21 = r35
            r22 = r36
        L_0x0143:
            r14 = r4
        L_0x0144:
            r16 = r7
            r18 = r9
            r20 = r15
            r0 = 2141738945(0x7fa857c1, float:NaN)
            r15 = r6
            goto L_0x01a0
        L_0x014f:
            if (r37 == 0) goto L_0x0156
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0156:
            if (r5 == 0) goto L_0x015a
            r0 = 0
            r6 = r0
        L_0x015a:
            r0 = r12 & 8
            r5 = 6
            if (r0 == 0) goto L_0x0167
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r7 = r0.getContainerColor(r1, r5)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0167:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0176
            int r0 = r2 >> 9
            r0 = r0 & 14
            long r9 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r7, r1, r0)
            r0 = r2 & r18
            r2 = r0
        L_0x0176:
            if (r14 == 0) goto L_0x017f
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r0 = r0.m1741getContainerElevationD9Ej5fM()
            r15 = r0
        L_0x017f:
            if (r16 == 0) goto L_0x0188
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getContentPadding()
            goto L_0x018a
        L_0x0188:
            r0 = r35
        L_0x018a:
            r14 = r12 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x019b
            androidx.compose.material3.BottomAppBarDefaults r14 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r5 = r14.getWindowInsets(r1, r5)
            r2 = r2 & r3
            r21 = r0
            r14 = r4
            r22 = r5
            goto L_0x0144
        L_0x019b:
            r22 = r36
            r21 = r0
            goto L_0x0143
        L_0x01a0:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01af
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.BottomAppBar (AppBar.kt:684)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x01af:
            r0 = r2 & 14
            r3 = 100663296(0x6000000, float:2.4074124E-35)
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
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r3
            r25 = r0 | r2
            r26 = 0
            r23 = 0
            r24 = r1
            m1717BottomAppBarqhFBPw4(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e1:
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r18
            r8 = r20
            r9 = r21
            r10 = r22
        L_0x01ed:
            androidx.compose.runtime.ScopeUpdateScope r13 = r24.endRestartGroup()
            if (r13 == 0) goto L_0x01ff
            androidx.compose.material3.AppBarKt$BottomAppBar$1 r0 = new androidx.compose.material3.AppBarKt$BottomAppBar$1
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1715BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fb  */
    /* renamed from: BottomAppBar-qhFBPw4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1717BottomAppBarqhFBPw4(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.material3.BottomAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r27
            r12 = r39
            r13 = r40
            r0 = -1044837119(0xffffffffc1b90d01, float:-23.13135)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)743@37109L14,744@37151L31,747@37377L12,758@37741L539,750@37455L825:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r12 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r12 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r12
            goto L_0x002b
        L_0x002a:
            r3 = r12
        L_0x002b:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r28
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r28
        L_0x0047:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r12 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r29
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r29
        L_0x0063:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r13 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r30
            boolean r10 = r2.changed((long) r8)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r30
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r10
            goto L_0x007e
        L_0x007c:
            r8 = r30
        L_0x007e:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0097
            r10 = r13 & 16
            if (r10 != 0) goto L_0x0091
            r10 = r32
            boolean r14 = r2.changed((long) r10)
            if (r14 == 0) goto L_0x0093
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r10 = r32
        L_0x0093:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r14
            goto L_0x0099
        L_0x0097:
            r10 = r32
        L_0x0099:
            r14 = r13 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a1
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a1:
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00b4
            r15 = r34
            boolean r16 = r2.changed((float) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r34
        L_0x00b6:
            r16 = r13 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c1
            r3 = r3 | r17
            r0 = r35
            goto L_0x00d4
        L_0x00c1:
            r17 = r12 & r17
            r0 = r35
            if (r17 != 0) goto L_0x00d4
            boolean r18 = r2.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r3 = r3 | r18
        L_0x00d4:
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r12 & r18
            if (r19 != 0) goto L_0x00f0
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r36
            boolean r19 = r2.changed((java.lang.Object) r0)
            if (r19 == 0) goto L_0x00eb
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r36
        L_0x00eb:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r3 = r3 | r19
            goto L_0x00f2
        L_0x00f0:
            r0 = r36
        L_0x00f2:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fb
            r3 = r3 | r19
            goto L_0x0111
        L_0x00fb:
            r19 = r12 & r19
            if (r19 != 0) goto L_0x0111
            r19 = r0
            r0 = r37
            boolean r20 = r2.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x010c
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r3 = r3 | r20
            goto L_0x0115
        L_0x0111:
            r19 = r0
            r0 = r37
        L_0x0115:
            r20 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r20
            r38 = r4
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r4) goto L_0x013a
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0128
            goto L_0x013a
        L_0x0128:
            r2.skipToGroupEnd()
            r24 = r2
            r2 = r5
            r3 = r7
            r4 = r8
            r6 = r10
            r8 = r15
            r9 = r35
            r10 = r36
            r11 = r37
            goto L_0x0232
        L_0x013a:
            r2.startDefaults()
            r0 = r12 & 1
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r4 = 6
            if (r0 == 0) goto L_0x0177
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014f
            goto L_0x0177
        L_0x014f:
            r2.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0158
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0158:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x015e
            r3 = r3 & r20
        L_0x015e:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0164
            r3 = r3 & r21
        L_0x0164:
            r20 = r35
            r21 = r36
            r22 = r37
            r14 = r5
            r19 = r15
            r0 = r18
            r5 = -1044837119(0xffffffffc1b90d01, float:-23.13135)
            r15 = r8
            r17 = r10
            goto L_0x01d6
        L_0x0177:
            if (r38 == 0) goto L_0x017e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x017e:
            r0 = 0
            if (r6 == 0) goto L_0x0182
            r7 = r0
        L_0x0182:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x018e
            androidx.compose.material3.BottomAppBarDefaults r6 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r8 = r6.getContainerColor(r2, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x018e:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x019c
            int r6 = r3 >> 9
            r6 = r6 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r8, r2, r6)
            r3 = r3 & r20
        L_0x019c:
            if (r14 == 0) goto L_0x01a5
            androidx.compose.material3.BottomAppBarDefaults r6 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r6 = r6.m1741getContainerElevationD9Ej5fM()
            goto L_0x01a6
        L_0x01a5:
            r6 = r15
        L_0x01a6:
            if (r16 == 0) goto L_0x01af
            androidx.compose.material3.BottomAppBarDefaults r14 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r14 = r14.getContentPadding()
            goto L_0x01b1
        L_0x01af:
            r14 = r35
        L_0x01b1:
            r15 = r13 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x01be
            androidx.compose.material3.BottomAppBarDefaults r15 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r15 = r15.getWindowInsets(r2, r4)
            r3 = r3 & r21
            goto L_0x01c0
        L_0x01be:
            r15 = r36
        L_0x01c0:
            if (r19 == 0) goto L_0x01c5
            r22 = r0
            goto L_0x01c7
        L_0x01c5:
            r22 = r37
        L_0x01c7:
            r19 = r6
            r20 = r14
            r21 = r15
            r0 = r18
            r14 = r5
            r15 = r8
            r17 = r10
            r5 = -1044837119(0xffffffffc1b90d01, float:-23.13135)
        L_0x01d6:
            r2.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01e5
            r6 = -1
            java.lang.String r8 = "androidx.compose.material3.BottomAppBar (AppBar.kt:750)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r6, r8)
        L_0x01e5:
            androidx.compose.material3.AppBarKt$BottomAppBar$2 r5 = new androidx.compose.material3.AppBarKt$BottomAppBar$2
            r5.<init>(r1, r7)
            r6 = 54
            r8 = 1566394874(0x5d5d49fa, float:9.9659693E17)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r5, r2, r6)
            r23 = r5
            kotlin.jvm.functions.Function3 r23 = (kotlin.jvm.functions.Function3) r23
            int r5 = r3 >> 3
            r5 = r5 & 14
            r0 = r0 | r5
            int r3 = r3 >> r4
            r4 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            r4 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r4
            r25 = r0 | r3
            r26 = 0
            r24 = r2
            m1716BottomAppBare3WI5M(r14, r15, r17, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0225
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0225:
            r3 = r7
            r2 = r14
            r4 = r15
            r6 = r17
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
        L_0x0232:
            androidx.compose.runtime.ScopeUpdateScope r14 = r24.endRestartGroup()
            if (r14 == 0) goto L_0x0242
            androidx.compose.material3.AppBarKt$BottomAppBar$3 r0 = new androidx.compose.material3.AppBarKt$BottomAppBar$3
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0242:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1717BottomAppBarqhFBPw4(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f7  */
    /* renamed from: BottomAppBar-1oL4kX8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1714BottomAppBar1oL4kX8(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.layout.WindowInsets r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r0 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)807@39959L14,808@40001L31,811@40227L12,814@40294L302:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x002e
        L_0x001a:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r10
            goto L_0x002e
        L_0x002b:
            r3 = r24
            r4 = r10
        L_0x002e:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0047
            r5 = r35 & 2
            if (r5 != 0) goto L_0x0041
            r5 = r25
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0041:
            r5 = r25
        L_0x0043:
            r7 = 16
        L_0x0045:
            r4 = r4 | r7
            goto L_0x0049
        L_0x0047:
            r5 = r25
        L_0x0049:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r35 & 4
            if (r7 != 0) goto L_0x005c
            r7 = r27
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r7 = r27
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r9
            goto L_0x0064
        L_0x0062:
            r7 = r27
        L_0x0064:
            r9 = r35 & 8
            if (r9 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r11 = r10 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007e
            r11 = r29
            boolean r12 = r1.changed((float) r11)
            if (r12 == 0) goto L_0x007a
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r12
            goto L_0x0080
        L_0x007e:
            r11 = r29
        L_0x0080:
            r12 = r35 & 16
            if (r12 == 0) goto L_0x0087
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009a
            r13 = r30
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0096
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r4 = r4 | r14
            goto L_0x009c
        L_0x009a:
            r13 = r30
        L_0x009c:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r35 & 32
            if (r14 != 0) goto L_0x00b0
            r14 = r31
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r14 = r31
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r4 = r4 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r31
        L_0x00b8:
            r15 = r35 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c1
            r4 = r4 | r16
            goto L_0x00d5
        L_0x00c1:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00d5
            r15 = r32
            boolean r17 = r1.changedInstance(r15)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r4 = r4 | r17
            goto L_0x00d7
        L_0x00d5:
            r15 = r32
        L_0x00d7:
            r17 = 599187(0x92493, float:8.3964E-40)
            r0 = r4 & r17
            r33 = r2
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00f7
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00ea
            goto L_0x00f7
        L_0x00ea:
            r1.skipToGroupEnd()
            r21 = r1
            r1 = r3
            r2 = r5
            r4 = r7
            r6 = r11
            r7 = r13
            r8 = r14
            goto L_0x01d7
        L_0x00f7:
            r1.startDefaults()
            r0 = r10 & 1
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x012c
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0108
            goto L_0x012c
        L_0x0108:
            r1.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0111
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0111:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0117
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0117:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x011c
            r4 = r4 & r2
        L_0x011c:
            r17 = r13
            r18 = r14
            r0 = r16
            r2 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r12 = r5
            r14 = r7
            r16 = r11
            r11 = r3
            goto L_0x018f
        L_0x012c:
            if (r33 == 0) goto L_0x0133
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0134
        L_0x0133:
            r0 = r3
        L_0x0134:
            r3 = r35 & 2
            r33 = r2
            r2 = 6
            if (r3 == 0) goto L_0x0143
            androidx.compose.material3.BottomAppBarDefaults r3 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r5 = r3.getContainerColor(r1, r2)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0143:
            r3 = r35 & 4
            if (r3 == 0) goto L_0x0152
            int r3 = r4 >> 3
            r3 = r3 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r5, r1, r3)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x0152:
            if (r9 == 0) goto L_0x015b
            androidx.compose.material3.BottomAppBarDefaults r3 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r3 = r3.m1741getContainerElevationD9Ej5fM()
            r11 = r3
        L_0x015b:
            if (r12 == 0) goto L_0x0164
            androidx.compose.material3.BottomAppBarDefaults r3 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r3 = r3.getContentPadding()
            r13 = r3
        L_0x0164:
            r3 = r35 & 32
            if (r3 == 0) goto L_0x0180
            androidx.compose.material3.BottomAppBarDefaults r3 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r3.getWindowInsets(r1, r2)
            r4 = r4 & r33
            r12 = r11
            r11 = r0
            r0 = r16
            r16 = r12
            r18 = r2
            r14 = r7
            r17 = r13
            r2 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r12 = r5
            goto L_0x018f
        L_0x0180:
            r2 = r11
            r11 = r0
            r0 = r16
            r16 = r2
            r17 = r13
            r18 = r14
            r2 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r12 = r5
            r14 = r7
        L_0x018f:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x019e
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.BottomAppBar (AppBar.kt:814)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r3, r5)
        L_0x019e:
            r2 = r4 & 14
            r0 = r0 | r2
            r2 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r4 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r4 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r4
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r4
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            int r3 = r4 << 3
            r2 = r2 & r3
            r22 = r0 | r2
            r23 = 0
            r19 = 0
            r20 = r32
            r21 = r1
            m1716BottomAppBare3WI5M(r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ce
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ce:
            r1 = r11
            r2 = r12
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
        L_0x01d7:
            androidx.compose.runtime.ScopeUpdateScope r12 = r21.endRestartGroup()
            if (r12 == 0) goto L_0x01eb
            androidx.compose.material3.AppBarKt$BottomAppBar$4 r0 = new androidx.compose.material3.AppBarKt$BottomAppBar$4
            r9 = r32
            r11 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1714BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0116  */
    /* renamed from: BottomAppBar-e-3WI5M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1716BottomAppBare3WI5M(androidx.compose.ui.Modifier r35, long r36, long r38, float r40, androidx.compose.foundation.layout.PaddingValues r41, androidx.compose.foundation.layout.WindowInsets r42, androidx.compose.material3.BottomAppBarScrollBehavior r43, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r10 = r44
            r11 = r46
            r12 = r47
            r0 = 422438773(0x192de775, float:8.990633E-24)
            r1 = r45
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)860@42630L14,861@42672L31,864@42898L12,896@44292L5,899@44363L596,911@45008L364,891@44025L1347:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001e
            r3 = r11 | 6
            r4 = r3
            r3 = r35
            goto L_0x0032
        L_0x001e:
            r3 = r11 & 6
            if (r3 != 0) goto L_0x002f
            r3 = r35
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r11
            goto L_0x0032
        L_0x002f:
            r3 = r35
            r4 = r11
        L_0x0032:
            r5 = r11 & 48
            if (r5 != 0) goto L_0x004b
            r5 = r12 & 2
            if (r5 != 0) goto L_0x0045
            r5 = r36
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0047
            r7 = 32
            goto L_0x0049
        L_0x0045:
            r5 = r36
        L_0x0047:
            r7 = 16
        L_0x0049:
            r4 = r4 | r7
            goto L_0x004d
        L_0x004b:
            r5 = r36
        L_0x004d:
            r7 = r11 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r12 & 4
            if (r7 != 0) goto L_0x0060
            r7 = r38
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x0062
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0060:
            r7 = r38
        L_0x0062:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r9
            goto L_0x0068
        L_0x0066:
            r7 = r38
        L_0x0068:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r13 = r11 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x0082
            r13 = r40
            boolean r14 = r1.changed((float) r13)
            if (r14 == 0) goto L_0x007e
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r4 = r4 | r14
            goto L_0x0084
        L_0x0082:
            r13 = r40
        L_0x0084:
            r14 = r12 & 16
            if (r14 == 0) goto L_0x008b
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008b:
            r15 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009f
            r15 = r41
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x009a
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r4 = r4 | r16
            goto L_0x00a1
        L_0x009f:
            r15 = r41
        L_0x00a1:
            r16 = 196608(0x30000, float:2.75506E-40)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00bb
            r16 = r12 & 32
            r0 = r42
            if (r16 != 0) goto L_0x00b6
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r4 = r4 | r17
            goto L_0x00bd
        L_0x00bb:
            r0 = r42
        L_0x00bd:
            r17 = r12 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c8
            r4 = r4 | r18
            r0 = r43
            goto L_0x00db
        L_0x00c8:
            r18 = r11 & r18
            r0 = r43
            if (r18 != 0) goto L_0x00db
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d7
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r4 = r4 | r18
        L_0x00db:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e4
            r4 = r4 | r18
            goto L_0x00f4
        L_0x00e4:
            r0 = r11 & r18
            if (r0 != 0) goto L_0x00f4
            boolean r0 = r1.changedInstance(r10)
            if (r0 == 0) goto L_0x00f1
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r4 = r4 | r0
        L_0x00f4:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r4
            r19 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0116
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0106
            goto L_0x0116
        L_0x0106:
            r1.skipToGroupEnd()
            r9 = r43
            r23 = r1
            r1 = r3
            r2 = r5
            r4 = r7
            r6 = r13
            r7 = r15
            r8 = r42
            goto L_0x02e5
        L_0x0116:
            r1.startDefaults()
            r0 = r11 & 1
            r20 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x0151
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0128
            goto L_0x0151
        L_0x0128:
            r1.skipToGroupEnd()
            r0 = r12 & 2
            if (r0 == 0) goto L_0x0131
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0131:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0137
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0137:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013d
            r4 = r4 & r20
        L_0x013d:
            r33 = r7
            r7 = r18
            r17 = r33
            r19 = r13
            r0 = r15
            r8 = 422438773(0x192de775, float:8.990633E-24)
            r15 = r5
            r5 = r43
            r6 = r4
            r4 = r42
            goto L_0x01ba
        L_0x0151:
            if (r19 == 0) goto L_0x0158
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = r0
        L_0x0158:
            r0 = r12 & 2
            if (r0 == 0) goto L_0x0164
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r5 = r0.getContainerColor(r1, r2)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0164:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0172
            int r0 = r4 >> 3
            r0 = r0 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r5, r1, r0)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0172:
            if (r9 == 0) goto L_0x017b
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r0 = r0.m1741getContainerElevationD9Ej5fM()
            r13 = r0
        L_0x017b:
            if (r14 == 0) goto L_0x0184
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getContentPadding()
            r15 = r0
        L_0x0184:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0191
            androidx.compose.material3.BottomAppBarDefaults r0 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r0 = r0.getWindowInsets(r1, r2)
            r4 = r4 & r20
            goto L_0x0193
        L_0x0191:
            r0 = r42
        L_0x0193:
            if (r17 == 0) goto L_0x01a6
            r17 = r4
            r4 = r0
            r0 = r15
            r15 = r5
            r6 = r17
            r33 = r7
            r7 = r18
            r17 = r33
            r19 = r13
            r5 = 0
            goto L_0x01b7
        L_0x01a6:
            r17 = r4
            r4 = r0
            r0 = r15
            r15 = r5
            r6 = r17
            r33 = r7
            r7 = r18
            r17 = r33
            r5 = r43
            r19 = r13
        L_0x01b7:
            r8 = 422438773(0x192de775, float:8.990633E-24)
        L_0x01ba:
            r1.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01c9
            r9 = -1
            java.lang.String r13 = "androidx.compose.material3.BottomAppBar (AppBar.kt:867)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r6, r9, r13)
        L_0x01c9:
            r8 = 1393560009(0x531009c9, float:6.1863946E11)
            r1.startReplaceGroup(r8)
            java.lang.String r8 = "874@43358L55,874@43335L78,875@43447L289"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            r8 = 3670016(0x380000, float:5.142788E-39)
            java.lang.String r9 = "CC(remember):AppBar.kt#9igjgp"
            r13 = 0
            if (r5 == 0) goto L_0x025f
            boolean r20 = r5.isPinned()
            if (r20 != 0) goto L_0x025f
            androidx.compose.ui.Modifier$Companion r20 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r24 = androidx.compose.foundation.gestures.Orientation.Vertical
            r35 = r7
            r7 = 1393566103(0x53102197, float:6.1903883E11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r9)
            r7 = r6 & r8
            r36 = r8
            r8 = 1048576(0x100000, float:1.469368E-39)
            if (r7 != r8) goto L_0x01f7
            r8 = 1
            goto L_0x01f8
        L_0x01f7:
            r8 = r13
        L_0x01f8:
            java.lang.Object r14 = r1.rememberedValue()
            if (r8 != 0) goto L_0x0206
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r14 != r8) goto L_0x0211
        L_0x0206:
            androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1 r8 = new androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
            r8.<init>(r5)
            r14 = r8
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1.updateRememberedValue(r14)
        L_0x0211:
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.foundation.gestures.DraggableState r23 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r14, r1, r13)
            r22 = r20
            androidx.compose.ui.Modifier r22 = (androidx.compose.ui.Modifier) r22
            r8 = 1393569185(0x53102da1, float:6.1924082E11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r9)
            r8 = 1048576(0x100000, float:1.469368E-39)
            if (r7 != r8) goto L_0x022a
            r7 = 1
            goto L_0x022b
        L_0x022a:
            r7 = r13
        L_0x022b:
            java.lang.Object r8 = r1.rememberedValue()
            if (r7 != 0) goto L_0x0239
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x0245
        L_0x0239:
            androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$2$1 r7 = new androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$2$1
            r8 = 0
            r7.<init>(r5, r8)
            r8 = r7
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            r1.updateRememberedValue(r8)
        L_0x0245:
            r29 = r8
            kotlin.jvm.functions.Function3 r29 = (kotlin.jvm.functions.Function3) r29
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r31 = 188(0xbc, float:2.63E-43)
            r32 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            goto L_0x0267
        L_0x025f:
            r35 = r7
            r36 = r8
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
        L_0x0267:
            r1.endReplaceGroup()
            androidx.compose.material3.tokens.BottomAppBarTokens r8 = androidx.compose.material3.tokens.BottomAppBarTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r8 = r8.getContainerShape()
            androidx.compose.ui.graphics.Shape r14 = androidx.compose.material3.ShapesKt.getValue(r8, r1, r2)
            r2 = 1393598804(0x5310a154, float:6.2118193E11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r9)
            r2 = r6 & r36
            r8 = 1048576(0x100000, float:1.469368E-39)
            if (r2 != r8) goto L_0x0281
            r13 = 1
        L_0x0281:
            java.lang.Object r2 = r1.rememberedValue()
            if (r13 != 0) goto L_0x028f
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r2 != r8) goto L_0x0299
        L_0x028f:
            androidx.compose.material3.AppBarKt$BottomAppBar$5$1 r2 = new androidx.compose.material3.AppBarKt$BottomAppBar$5$1
            r2.<init>(r5)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r1.updateRememberedValue(r2)
        L_0x0299:
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutModifierKt.layout(r3, r2)
            androidx.compose.ui.Modifier r13 = r2.then(r7)
            androidx.compose.material3.AppBarKt$BottomAppBar$6 r2 = new androidx.compose.material3.AppBarKt$BottomAppBar$6
            r2.<init>(r4, r0, r10)
            r7 = 54
            r8 = 1243053520(0x4a177dd0, float:2482036.0)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r2, r1, r7)
            r22 = r2
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            int r2 = r6 << 3
            r6 = r2 & 896(0x380, float:1.256E-42)
            r6 = r6 | r35
            r7 = r2 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            r24 = r6 | r2
            r25 = 96
            r20 = 0
            r21 = 0
            r23 = r1
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02dc:
            r7 = r0
            r1 = r3
            r8 = r4
            r9 = r5
            r2 = r15
            r4 = r17
            r6 = r19
        L_0x02e5:
            androidx.compose.runtime.ScopeUpdateScope r13 = r23.endRestartGroup()
            if (r13 == 0) goto L_0x02f5
            androidx.compose.material3.AppBarKt$BottomAppBar$7 r0 = new androidx.compose.material3.AppBarKt$BottomAppBar$7
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1716BottomAppBare3WI5M(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float r8, float r9, float r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            java.lang.String r0 = "C(rememberTopAppBarState)P(2,1)1292@62790L99,1292@62743L146:AppBar.kt#uh7d8r"
            r1 = 1801969826(0x6b67e0a2, float:2.8032266E26)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x000f
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x000f:
            r0 = r13 & 2
            r2 = 0
            if (r0 == 0) goto L_0x0015
            r9 = r2
        L_0x0015:
            r0 = 4
            r13 = r13 & r0
            if (r13 == 0) goto L_0x001a
            r10 = r2
        L_0x001a:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0026
            r13 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1291)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r12, r13, r2)
        L_0x0026:
            r13 = 0
            java.lang.Object[] r1 = new java.lang.Object[r13]
            androidx.compose.material3.TopAppBarState$Companion r2 = androidx.compose.material3.TopAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r2 = r2.getSaver()
            r3 = 1949255933(0x742f48fd, float:5.555007E31)
            java.lang.String r4 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            r3 = r12 & 14
            r3 = r3 ^ 6
            r4 = 1
            if (r3 <= r0) goto L_0x0044
            boolean r3 = r11.changed((float) r8)
            if (r3 != 0) goto L_0x0048
        L_0x0044:
            r3 = r12 & 6
            if (r3 != r0) goto L_0x004a
        L_0x0048:
            r0 = r4
            goto L_0x004b
        L_0x004a:
            r0 = r13
        L_0x004b:
            r3 = r12 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r5 = 32
            if (r3 <= r5) goto L_0x0059
            boolean r3 = r11.changed((float) r9)
            if (r3 != 0) goto L_0x005d
        L_0x0059:
            r3 = r12 & 48
            if (r3 != r5) goto L_0x005f
        L_0x005d:
            r3 = r4
            goto L_0x0060
        L_0x005f:
            r3 = r13
        L_0x0060:
            r0 = r0 | r3
            r3 = r12 & 896(0x380, float:1.256E-42)
            r3 = r3 ^ 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r3 <= r5) goto L_0x006f
            boolean r3 = r11.changed((float) r10)
            if (r3 != 0) goto L_0x0073
        L_0x006f:
            r12 = r12 & 384(0x180, float:5.38E-43)
            if (r12 != r5) goto L_0x0074
        L_0x0073:
            r13 = r4
        L_0x0074:
            r12 = r0 | r13
            java.lang.Object r13 = r11.rememberedValue()
            if (r12 != 0) goto L_0x0084
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x008f
        L_0x0084:
            androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1 r12 = new androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
            r12.<init>(r8, r9, r10)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.updateRememberedValue(r13)
        L_0x008f:
            r4 = r13
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r6 = 0
            r7 = 4
            r3 = 0
            r5 = r11
            java.lang.Object r8 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.compose.material3.TopAppBarState r8 = (androidx.compose.material3.TopAppBarState) r8
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x00a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00a8:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberTopAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TopAppBarState");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.BottomAppBarState rememberBottomAppBarState(float r8, float r9, float r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            java.lang.String r0 = "C(rememberBottomAppBarState)P(2,1)1611@75546L102,1611@75496L152:AppBar.kt#uh7d8r"
            r1 = 1420874240(0x54b0d200, float:6.0754997E12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x000f
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x000f:
            r0 = r13 & 2
            r2 = 0
            if (r0 == 0) goto L_0x0015
            r9 = r2
        L_0x0015:
            r0 = 4
            r13 = r13 & r0
            if (r13 == 0) goto L_0x001a
            r10 = r2
        L_0x001a:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0026
            r13 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1610)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r12, r13, r2)
        L_0x0026:
            r13 = 0
            java.lang.Object[] r1 = new java.lang.Object[r13]
            androidx.compose.material3.BottomAppBarState$Companion r2 = androidx.compose.material3.BottomAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r2 = r2.getSaver()
            r3 = -1399214710(0xffffffffac99ad8a, float:-4.3677882E-12)
            java.lang.String r4 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            r3 = r12 & 14
            r3 = r3 ^ 6
            r4 = 1
            if (r3 <= r0) goto L_0x0044
            boolean r3 = r11.changed((float) r8)
            if (r3 != 0) goto L_0x0048
        L_0x0044:
            r3 = r12 & 6
            if (r3 != r0) goto L_0x004a
        L_0x0048:
            r0 = r4
            goto L_0x004b
        L_0x004a:
            r0 = r13
        L_0x004b:
            r3 = r12 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r5 = 32
            if (r3 <= r5) goto L_0x0059
            boolean r3 = r11.changed((float) r9)
            if (r3 != 0) goto L_0x005d
        L_0x0059:
            r3 = r12 & 48
            if (r3 != r5) goto L_0x005f
        L_0x005d:
            r3 = r4
            goto L_0x0060
        L_0x005f:
            r3 = r13
        L_0x0060:
            r0 = r0 | r3
            r3 = r12 & 896(0x380, float:1.256E-42)
            r3 = r3 ^ 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r3 <= r5) goto L_0x006f
            boolean r3 = r11.changed((float) r10)
            if (r3 != 0) goto L_0x0073
        L_0x006f:
            r12 = r12 & 384(0x180, float:5.38E-43)
            if (r12 != r5) goto L_0x0074
        L_0x0073:
            r13 = r4
        L_0x0074:
            r12 = r0 | r13
            java.lang.Object r13 = r11.rememberedValue()
            if (r12 != 0) goto L_0x0084
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x008f
        L_0x0084:
            androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1 r12 = new androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
            r12.<init>(r8, r9, r10)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.updateRememberedValue(r13)
        L_0x008f:
            r4 = r13
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r6 = 0
            r7 = 4
            r3 = 0
            r5 = r11
            java.lang.Object r8 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.compose.material3.BottomAppBarState r8 = (androidx.compose.material3.BottomAppBarState) r8
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x00a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00a8:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberBottomAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.BottomAppBarState");
    }

    public static final BottomAppBarState BottomAppBarState(float f, float f2, float f3) {
        return new BottomAppBarStateImpl(f, f2, f3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, new androidx.compose.material3.AppBarKt$settleAppBarBottom$2(r3, r0, r1), r7, 2, (java.lang.Object) null) == r2) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBarBottom(androidx.compose.material3.BottomAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r23, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r25) {
        /*
            r0 = r21
            r1 = r25
            boolean r2 = r1 instanceof androidx.compose.material3.AppBarKt$settleAppBarBottom$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.material3.AppBarKt$settleAppBarBottom$1 r2 = (androidx.compose.material3.AppBarKt$settleAppBarBottom$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.AppBarKt$settleAppBarBottom$1 r2 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$1
            r2.<init>(r1)
        L_0x001d:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r7.label
            r10 = 2
            r4 = 1
            r11 = 0
            if (r3 == 0) goto L_0x0053
            if (r3 == r4) goto L_0x0040
            if (r3 != r10) goto L_0x0038
            java.lang.Object r0 = r7.L$0
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0111
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            java.lang.Object r0 = r7.L$2
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            java.lang.Object r3 = r7.L$1
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            java.lang.Object r4 = r7.L$0
            androidx.compose.material3.BottomAppBarState r4 = (androidx.compose.material3.BottomAppBarState) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r12 = r3
            r0 = r4
            goto L_0x00b2
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = r0.getCollapsedFraction()
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x011d
            float r1 = r0.getCollapsedFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x006d
            goto L_0x011d
        L_0x006d:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r13 = r22
            r1.element = r13
            if (r23 == 0) goto L_0x00b4
            float r5 = java.lang.Math.abs(r13)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b4
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r19 = 28
            r20 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)
            androidx.compose.material3.AppBarKt$settleAppBarBottom$2 r6 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$2
            r6.<init>(r3, r0, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7.L$0 = r0
            r12 = r24
            r7.L$1 = r12
            r7.L$2 = r1
            r7.label = r4
            r3 = r5
            r5 = 0
            r8 = 2
            r9 = 0
            r4 = r23
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r2) goto L_0x00b2
            goto L_0x010f
        L_0x00b2:
            r5 = r12
            goto L_0x00b7
        L_0x00b4:
            r12 = r24
            goto L_0x00b2
        L_0x00b7:
            if (r5 == 0) goto L_0x0112
            float r3 = r0.getHeightOffset()
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0112
            float r3 = r0.getHeightOffset()
            float r4 = r0.getHeightOffsetLimit()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0112
            float r12 = r0.getHeightOffset()
            r19 = 30
            r20 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)
            float r4 = r0.getCollapsedFraction()
            r6 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ec
            r4 = r11
            goto L_0x00f0
        L_0x00ec:
            float r4 = r0.getHeightOffsetLimit()
        L_0x00f0:
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.material3.AppBarKt$settleAppBarBottom$3 r6 = new androidx.compose.material3.AppBarKt$settleAppBarBottom$3
            r6.<init>(r0)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7.L$0 = r1
            r0 = 0
            r7.L$1 = r0
            r7.L$2 = r0
            r7.label = r10
            r8 = r7
            r7 = r6
            r6 = 0
            r9 = 4
            r10 = 0
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r2) goto L_0x0110
        L_0x010f:
            return r2
        L_0x0110:
            r0 = r1
        L_0x0111:
            r1 = r0
        L_0x0112:
            float r0 = r1.element
            long r0 = androidx.compose.ui.unit.VelocityKt.Velocity(r11, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m7341boximpl(r0)
            return r0
        L_0x011d:
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m7361getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m7341boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBarBottom(androidx.compose.material3.BottomAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    /* renamed from: SingleRowTopAppBar-cJHQLPU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1721SingleRowTopAppBarcJHQLPU(androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.text.TextStyle r33, boolean r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, float r37, androidx.compose.foundation.layout.WindowInsets r38, androidx.compose.material3.TopAppBarColors r39, androidx.compose.material3.TopAppBarScrollBehavior r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r6 = r36
            r7 = r37
            r9 = r39
            r10 = r40
            r0 = r42
            r1 = r43
            r2 = -342194911(0xffffffffeb9a8521, float:-3.7360652E26)
            r3 = r41
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(SingleRowTopAppBar)P(4,7,8,1,5!1,3:c#ui.unit.Dp,9)*1865@85622L7,1866@85690L284,1866@85679L295,1879@86382L321,1887@86744L178,1894@87005L197,1926@88369L1014,1926@88285L1098:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r1 & 1
            if (r4 == 0) goto L_0x0024
            r5 = r0 | 6
            r8 = r5
            r5 = r31
            goto L_0x0038
        L_0x0024:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x0035
            r5 = r31
            boolean r8 = r3.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0032
            r8 = 4
            goto L_0x0033
        L_0x0032:
            r8 = 2
        L_0x0033:
            r8 = r8 | r0
            goto L_0x0038
        L_0x0035:
            r5 = r31
            r8 = r0
        L_0x0038:
            r11 = r1 & 2
            if (r11 == 0) goto L_0x003f
            r8 = r8 | 48
            goto L_0x0052
        L_0x003f:
            r11 = r0 & 48
            if (r11 != 0) goto L_0x0052
            r11 = r32
            boolean r12 = r3.changedInstance(r11)
            if (r12 == 0) goto L_0x004e
            r12 = 32
            goto L_0x0050
        L_0x004e:
            r12 = 16
        L_0x0050:
            r8 = r8 | r12
            goto L_0x0054
        L_0x0052:
            r11 = r32
        L_0x0054:
            r12 = r1 & 4
            if (r12 == 0) goto L_0x005b
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x006e
        L_0x005b:
            r12 = r0 & 384(0x180, float:5.38E-43)
            if (r12 != 0) goto L_0x006e
            r12 = r33
            boolean r13 = r3.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x006a
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r13 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r8 = r8 | r13
            goto L_0x0070
        L_0x006e:
            r12 = r33
        L_0x0070:
            r13 = r1 & 8
            if (r13 == 0) goto L_0x0077
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0077:
            r13 = r0 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x008a
            r13 = r34
            boolean r14 = r3.changed((boolean) r13)
            if (r14 == 0) goto L_0x0086
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r8 = r8 | r14
            goto L_0x008c
        L_0x008a:
            r13 = r34
        L_0x008c:
            r14 = r1 & 16
            if (r14 == 0) goto L_0x0093
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0093:
            r14 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x00a6
            r14 = r35
            boolean r15 = r3.changedInstance(r14)
            if (r15 == 0) goto L_0x00a2
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r8 = r8 | r15
            goto L_0x00a8
        L_0x00a6:
            r14 = r35
        L_0x00a8:
            r15 = r1 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00b1
            r8 = r8 | r16
            goto L_0x00c1
        L_0x00b1:
            r15 = r0 & r16
            if (r15 != 0) goto L_0x00c1
            boolean r15 = r3.changedInstance(r6)
            if (r15 == 0) goto L_0x00be
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r8 = r8 | r15
        L_0x00c1:
            r15 = r1 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00ca
            r8 = r8 | r16
            goto L_0x00da
        L_0x00ca:
            r15 = r0 & r16
            if (r15 != 0) goto L_0x00da
            boolean r15 = r3.changed((float) r7)
            if (r15 == 0) goto L_0x00d7
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r8 = r8 | r15
        L_0x00da:
            r15 = r1 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00e3
            r8 = r8 | r16
            goto L_0x00f7
        L_0x00e3:
            r15 = r0 & r16
            if (r15 != 0) goto L_0x00f7
            r15 = r38
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00f2
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r8 = r8 | r16
            goto L_0x00f9
        L_0x00f7:
            r15 = r38
        L_0x00f9:
            r2 = r1 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r2 == 0) goto L_0x0102
            r8 = r8 | r17
            goto L_0x0112
        L_0x0102:
            r2 = r0 & r17
            if (r2 != 0) goto L_0x0112
            boolean r2 = r3.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x010f
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0111
        L_0x010f:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0111:
            r8 = r8 | r2
        L_0x0112:
            r2 = r1 & 512(0x200, float:7.175E-43)
            r17 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x011b
            r8 = r8 | r17
            goto L_0x012b
        L_0x011b:
            r2 = r0 & r17
            if (r2 != 0) goto L_0x012b
            boolean r2 = r3.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0128
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x0128:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012a:
            r8 = r8 | r2
        L_0x012b:
            r2 = 306783379(0x12492493, float:6.34695E-28)
            r2 = r2 & r8
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r14) goto L_0x0142
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x013b
            goto L_0x0142
        L_0x013b:
            r3.skipToGroupEnd()
            r12 = r3
        L_0x013f:
            r1 = r5
            goto L_0x0300
        L_0x0142:
            if (r4 == 0) goto L_0x0149
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = r2
        L_0x0149:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0158
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1861)"
            r14 = -342194911(0xffffffffeb9a8521, float:-3.7360652E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r8, r2, r4)
        L_0x0158:
            boolean r2 = java.lang.Float.isNaN(r7)
            if (r2 != 0) goto L_0x0325
            r2 = 2139095040(0x7f800000, float:Infinity)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0166
            r2 = 1
            goto L_0x0167
        L_0x0166:
            r2 = 0
        L_0x0167:
            if (r2 != 0) goto L_0x0325
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r14, r4)
            java.lang.Object r2 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            float r2 = r2.m7091toPx0680j_4(r7)
            r4 = 0
            float r2 = kotlin.ranges.RangesKt.coerceAtLeast((float) r2, (float) r4)
            r4 = -1193658092(0xffffffffb8da3914, float:-1.0405682E-4)
            java.lang.String r14 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r14)
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r8
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            if (r4 != r8) goto L_0x019a
            r8 = 1
            goto L_0x019b
        L_0x019a:
            r8 = 0
        L_0x019b:
            boolean r16 = r3.changed((float) r2)
            r8 = r8 | r16
            java.lang.Object r0 = r3.rememberedValue()
            if (r8 != 0) goto L_0x01af
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r0 != r8) goto L_0x01b9
        L_0x01af:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1 r0 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1
            r0.<init>(r10, r2)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.updateRememberedValue(r0)
        L_0x01b9:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r3, r2)
            r0 = -1193635911(0xffffffffb8da8fb9, float:-1.04218205E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r14)
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            if (r4 != r8) goto L_0x01ce
            r2 = 1
            goto L_0x01cf
        L_0x01ce:
            r2 = 0
        L_0x01cf:
            java.lang.Object r0 = r3.rememberedValue()
            if (r2 != 0) goto L_0x01dd
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x01eb
        L_0x01dd:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1 r0 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1
            r0.<init>(r10)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r3.updateRememberedValue(r0)
        L_0x01eb:
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            float r0 = SingleRowTopAppBar_cJHQLPU$lambda$9(r0)
            long r16 = r9.m2858containerColorvNxB06k$material3_release(r0)
            r0 = 1137180672(0x43c80000, float:400.0)
            r2 = 5
            r8 = 0
            r18 = r14
            r14 = 0
            androidx.compose.animation.core.SpringSpec r0 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r8, r0, r14, r2, r14)
            androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
            r11 = r16
            r17 = 48
            r2 = r18
            r18 = 12
            r8 = r14
            r15 = 0
            r13 = r0
            r16 = r3
            r0 = 1
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            androidx.compose.runtime.State r11 = androidx.compose.animation.SingleValueAnimationKt.m123animateColorAsStateeuL9pac(r11, r13, r14, r15, r16, r17, r18)
            r12 = r16
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1 r13 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
            r13.<init>(r6)
            r14 = 54
            r15 = 1370231018(0x51ac10ea, float:9.2377268E10)
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r0, r13, r12, r14)
            r16 = r13
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r13 = -1193605157(0xffffffffb8db07db, float:-1.0444197E-4)
            r12.startReplaceGroup(r13)
            java.lang.String r13 = "1908@87542L55,1908@87519L78,1909@87631L283"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            if (r10 == 0) goto L_0x02b3
            boolean r13 = r10.isPinned()
            if (r13 != 0) goto L_0x02b3
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r22 = androidx.compose.foundation.gestures.Orientation.Vertical
            r14 = -1193599057(0xffffffffb8db1faf, float:-1.0448635E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r14, r2)
            if (r4 != r3) goto L_0x024e
            r14 = r0
            goto L_0x024f
        L_0x024e:
            r14 = 0
        L_0x024f:
            java.lang.Object r15 = r12.rememberedValue()
            if (r14 != 0) goto L_0x025d
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x0268
        L_0x025d:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1 r14 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
            r14.<init>(r10)
            r15 = r14
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r12.updateRememberedValue(r15)
        L_0x0268:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r14 = 0
            androidx.compose.foundation.gestures.DraggableState r21 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r15, r12, r14)
            r20 = r13
            androidx.compose.ui.Modifier r20 = (androidx.compose.ui.Modifier) r20
            r13 = -1193595981(0xffffffffb8db2bb3, float:-1.04508734E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r2)
            if (r4 != r3) goto L_0x0280
            r4 = r0
            goto L_0x0281
        L_0x0280:
            r4 = r14
        L_0x0281:
            java.lang.Object r2 = r12.rememberedValue()
            if (r4 != 0) goto L_0x028f
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0299
        L_0x028f:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 r2 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1
            r2.<init>(r10, r8)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r12.updateRememberedValue(r2)
        L_0x0299:
            r27 = r2
            kotlin.jvm.functions.Function3 r27 = (kotlin.jvm.functions.Function3) r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r29 = 188(0xbc, float:2.63E-43)
            r30 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            goto L_0x02b7
        L_0x02b3:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x02b7:
            r12.endReplaceGroup()
            androidx.compose.ui.Modifier r2 = r5.then(r2)
            long r3 = SingleRowTopAppBar_cJHQLPU$lambda$10(r11)
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3 r7 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
            r13 = r33
            r14 = r34
            r15 = r35
            r8 = r38
            r11 = r9
            r1 = r12
            r12 = r32
            r9 = r37
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r8 = 54
            r9 = -1943739546(0xffffffff8c24e366, float:-1.2702531E-31)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r0, r7, r1, r8)
            r16 = r0
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = 122(0x7a, float:1.71E-43)
            r8 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = r1
            r7 = r2
            r9 = r3
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            r12 = r17
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x013f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x013f
        L_0x0300:
            androidx.compose.runtime.ScopeUpdateScope r13 = r12.endRestartGroup()
            if (r13 == 0) goto L_0x0324
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$4 r0 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$4
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r7 = r37
            r8 = r38
            r9 = r39
            r10 = r40
            r11 = r42
            r12 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0324:
            return
        L_0x0325:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The expandedHeight is expected to be specified and finite"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1721SingleRowTopAppBarcJHQLPU(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0128  */
    /* renamed from: TwoRowsTopAppBar-nS6u9G4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1724TwoRowsTopAppBarnS6u9G4(androidx.compose.ui.Modifier r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.text.TextStyle r42, float r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.text.TextStyle r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, float r48, float r49, androidx.compose.foundation.layout.WindowInsets r50, androidx.compose.material3.TopAppBarColors r51, androidx.compose.material3.TopAppBarScrollBehavior r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r4 = r43
            r8 = r47
            r9 = r48
            r10 = r49
            r12 = r51
            r13 = r52
            r0 = r54
            r1 = r55
            r2 = r56
            r3 = 1169193376(0x45b079a0, float:5647.203)
            r5 = r53
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r3)
            java.lang.String r6 = "C(TwoRowsTopAppBar)P(4,9,11,10:c#ui.unit.Dp,7,8,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,12)*1984@90586L7,1992@90915L205,1992@90904L216,2008@91751L197,2042@93233L2309,2042@93149L2393:AppBar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r2 & 1
            if (r6 == 0) goto L_0x002a
            r14 = r0 | 6
            r15 = r14
            r14 = r40
            goto L_0x003e
        L_0x002a:
            r14 = r0 & 6
            if (r14 != 0) goto L_0x003b
            r14 = r40
            boolean r15 = r5.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0038
            r15 = 4
            goto L_0x0039
        L_0x0038:
            r15 = 2
        L_0x0039:
            r15 = r15 | r0
            goto L_0x003e
        L_0x003b:
            r14 = r40
            r15 = r0
        L_0x003e:
            r16 = r2 & 2
            r17 = 32
            r18 = 16
            if (r16 == 0) goto L_0x004b
            r15 = r15 | 48
            r7 = r41
            goto L_0x005e
        L_0x004b:
            r16 = r0 & 48
            r7 = r41
            if (r16 != 0) goto L_0x005e
            boolean r16 = r5.changedInstance(r7)
            if (r16 == 0) goto L_0x005a
            r16 = r17
            goto L_0x005c
        L_0x005a:
            r16 = r18
        L_0x005c:
            r15 = r15 | r16
        L_0x005e:
            r16 = r2 & 4
            r19 = 128(0x80, float:1.794E-43)
            if (r16 == 0) goto L_0x0067
            r15 = r15 | 384(0x180, float:5.38E-43)
            goto L_0x007b
        L_0x0067:
            r11 = r0 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x007b
            r11 = r42
            boolean r21 = r5.changed((java.lang.Object) r11)
            if (r21 == 0) goto L_0x0076
            r21 = 256(0x100, float:3.59E-43)
            goto L_0x0078
        L_0x0076:
            r21 = r19
        L_0x0078:
            r15 = r15 | r21
            goto L_0x007d
        L_0x007b:
            r11 = r42
        L_0x007d:
            r21 = r2 & 8
            if (r21 == 0) goto L_0x0084
            r15 = r15 | 3072(0xc00, float:4.305E-42)
            goto L_0x0094
        L_0x0084:
            r3 = r0 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0094
            boolean r3 = r5.changed((float) r4)
            if (r3 == 0) goto L_0x0091
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0093
        L_0x0091:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0093:
            r15 = r15 | r3
        L_0x0094:
            r3 = r2 & 16
            if (r3 == 0) goto L_0x009b
            r15 = r15 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00af
        L_0x009b:
            r3 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00af
            r3 = r44
            boolean r22 = r5.changedInstance(r3)
            if (r22 == 0) goto L_0x00aa
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r15 = r15 | r22
            goto L_0x00b1
        L_0x00af:
            r3 = r44
        L_0x00b1:
            r22 = r2 & 32
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r22 == 0) goto L_0x00bc
            r15 = r15 | r23
            r0 = r45
            goto L_0x00cf
        L_0x00bc:
            r22 = r0 & r23
            r0 = r45
            if (r22 != 0) goto L_0x00cf
            boolean r22 = r5.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x00cb
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00cb:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x00cd:
            r15 = r15 | r22
        L_0x00cf:
            r22 = r2 & 64
            r23 = 1572864(0x180000, float:2.204052E-39)
            if (r22 == 0) goto L_0x00da
            r15 = r15 | r23
            r0 = r46
            goto L_0x00ed
        L_0x00da:
            r22 = r54 & r23
            r0 = r46
            if (r22 != 0) goto L_0x00ed
            boolean r22 = r5.changedInstance(r0)
            if (r22 == 0) goto L_0x00e9
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r15 = r15 | r22
        L_0x00ed:
            r0 = r2 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00f6
            r15 = r15 | r22
            goto L_0x0106
        L_0x00f6:
            r0 = r54 & r22
            if (r0 != 0) goto L_0x0106
            boolean r0 = r5.changedInstance(r8)
            if (r0 == 0) goto L_0x0103
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r15 = r15 | r0
        L_0x0106:
            r0 = r2 & 256(0x100, float:3.59E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x010f
            r15 = r15 | r22
            goto L_0x011f
        L_0x010f:
            r0 = r54 & r22
            if (r0 != 0) goto L_0x011f
            boolean r0 = r5.changed((float) r9)
            if (r0 == 0) goto L_0x011c
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011e
        L_0x011c:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011e:
            r15 = r15 | r0
        L_0x011f:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0128
            r15 = r15 | r22
            goto L_0x0138
        L_0x0128:
            r0 = r54 & r22
            if (r0 != 0) goto L_0x0138
            boolean r0 = r5.changed((float) r10)
            if (r0 == 0) goto L_0x0135
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0137
        L_0x0135:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0137:
            r15 = r15 | r0
        L_0x0138:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0143
            r0 = r1 | 6
            r20 = r0
            r0 = r50
            goto L_0x015b
        L_0x0143:
            r0 = r1 & 6
            if (r0 != 0) goto L_0x0157
            r0 = r50
            boolean r22 = r5.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0152
            r20 = 4
            goto L_0x0154
        L_0x0152:
            r20 = 2
        L_0x0154:
            r20 = r1 | r20
            goto L_0x015b
        L_0x0157:
            r0 = r50
            r20 = r1
        L_0x015b:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0162
            r20 = r20 | 48
            goto L_0x0171
        L_0x0162:
            r0 = r1 & 48
            if (r0 != 0) goto L_0x0171
            boolean r0 = r5.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r17 = r18
        L_0x016f:
            r20 = r20 | r17
        L_0x0171:
            r0 = r20
            r3 = r2 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x017a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0188
        L_0x017a:
            r3 = r1 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0188
            boolean r3 = r5.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x0186
            r19 = 256(0x100, float:3.59E-43)
        L_0x0186:
            r0 = r0 | r19
        L_0x0188:
            r3 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r3 & r15
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r1) goto L_0x01a6
            r1 = r0 & 147(0x93, float:2.06E-43)
            r3 = 146(0x92, float:2.05E-43)
            if (r1 != r3) goto L_0x01a6
            boolean r1 = r5.getSkipping()
            if (r1 != 0) goto L_0x019e
            goto L_0x01a6
        L_0x019e:
            r5.skipToGroupEnd()
            r19 = r5
            r1 = r14
            goto L_0x0376
        L_0x01a6:
            if (r6 == 0) goto L_0x01ad
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01ae
        L_0x01ad:
            r1 = r14
        L_0x01ae:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01bc
            java.lang.String r3 = "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1971)"
            r6 = 1169193376(0x45b079a0, float:5647.203)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r15, r0, r3)
        L_0x01bc:
            boolean r3 = java.lang.Float.isNaN(r9)
            if (r3 != 0) goto L_0x03c0
            r3 = 2139095040(0x7f800000, float:Infinity)
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x01ca
            r3 = 1
            goto L_0x01cb
        L_0x01ca:
            r3 = 0
        L_0x01cb:
            if (r3 != 0) goto L_0x03c0
            boolean r3 = java.lang.Float.isNaN(r10)
            if (r3 != 0) goto L_0x03b4
            r3 = 2139095040(0x7f800000, float:Infinity)
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x01db
            r3 = 1
            goto L_0x01dc
        L_0x01db:
            r3 = 0
        L_0x01dc:
            if (r3 != 0) goto L_0x03b4
            int r3 = androidx.compose.ui.unit.Dp.m7110compareTo0680j_4(r10, r9)
            if (r3 < 0) goto L_0x03a8
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            kotlin.jvm.internal.Ref$FloatRef r15 = new kotlin.jvm.internal.Ref$FloatRef
            r15.<init>()
            kotlin.jvm.internal.Ref$IntRef r14 = new kotlin.jvm.internal.Ref$IntRef
            r14.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r6 = r17
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r7)
            java.lang.Object r2 = r5.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            float r6 = r2.m7091toPx0680j_4(r10)
            r3.element = r6
            float r6 = r2.m7091toPx0680j_4(r9)
            r15.element = r6
            int r2 = r2.m7086roundToPx0680j_4(r4)
            r14.element = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r2 = 1641215730(0x61d2f6f2, float:4.864513E20)
            java.lang.String r6 = "CC(remember):AppBar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r6)
            r0 = r0 & 896(0x380, float:1.256E-42)
            r2 = 256(0x100, float:3.59E-43)
            if (r0 != r2) goto L_0x0230
            r2 = 1
            goto L_0x0231
        L_0x0230:
            r2 = 0
        L_0x0231:
            float r7 = r15.element
            boolean r7 = r5.changed((float) r7)
            r2 = r2 | r7
            float r7 = r3.element
            boolean r7 = r5.changed((float) r7)
            r2 = r2 | r7
            java.lang.Object r7 = r5.rememberedValue()
            if (r2 != 0) goto L_0x024d
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r7 != r2) goto L_0x0258
        L_0x024d:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$5$1 r2 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$5$1
            r2.<init>(r13, r15, r3)
            r7 = r2
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r5.updateRememberedValue(r7)
        L_0x0258:
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r7, r5, r2)
            if (r13 == 0) goto L_0x026e
            androidx.compose.material3.TopAppBarState r2 = r13.getState()
            if (r2 == 0) goto L_0x026e
            float r2 = r2.getCollapsedFraction()
            goto L_0x026f
        L_0x026e:
            r2 = 0
        L_0x026f:
            long r26 = r12.m2858containerColorvNxB06k$material3_release(r2)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1 r3 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
            r3.<init>(r8)
            r7 = 54
            r15 = -89435287(0xfffffffffaab5369, float:-4.4478726E35)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r4, r3, r5, r7)
            r18 = r3
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            androidx.compose.animation.core.CubicBezierEasing r3 = TopTitleAlphaEasing
            float r15 = r3.transform(r2)
            r3 = 1065353216(0x3f800000, float:1.0)
            float r23 = r3 - r2
            r3 = 1056964608(0x3f000000, float:0.5)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0298
            r2 = r4
            goto L_0x0299
        L_0x0298:
            r2 = 0
        L_0x0299:
            r25 = r2 ^ 1
            r3 = 1641266888(0x61d3bec8, float:4.8825128E20)
            r5.startReplaceGroup(r3)
            java.lang.String r3 = "2028@92709L55,2028@92686L78,2029@92798L283"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            if (r13 == 0) goto L_0x0325
            boolean r3 = r13.isPinned()
            if (r3 != 0) goto L_0x0325
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r30 = androidx.compose.foundation.gestures.Orientation.Vertical
            r7 = 1641272988(0x61d3d69c, float:4.884659E20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r6)
            r7 = 256(0x100, float:3.59E-43)
            if (r0 != r7) goto L_0x02be
            r7 = r4
            goto L_0x02bf
        L_0x02be:
            r7 = 0
        L_0x02bf:
            java.lang.Object r4 = r5.rememberedValue()
            if (r7 != 0) goto L_0x02cd
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r4 != r7) goto L_0x02d7
        L_0x02cd:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1 r4 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
            r4.<init>(r13)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5.updateRememberedValue(r4)
        L_0x02d7:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r7 = 0
            androidx.compose.foundation.gestures.DraggableState r29 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r4, r5, r7)
            r28 = r3
            androidx.compose.ui.Modifier r28 = (androidx.compose.ui.Modifier) r28
            r3 = 1641276064(0x61d3e2a0, float:4.8857413E20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r6)
            r3 = 256(0x100, float:3.59E-43)
            if (r0 != r3) goto L_0x02f1
            r6 = 1
            goto L_0x02f2
        L_0x02f1:
            r6 = r7
        L_0x02f2:
            java.lang.Object r0 = r5.rememberedValue()
            if (r6 != 0) goto L_0x0300
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x030b
        L_0x0300:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 r0 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1
            r3 = 0
            r0.<init>(r13, r3)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r5.updateRememberedValue(r0)
        L_0x030b:
            r35 = r0
            kotlin.jvm.functions.Function3 r35 = (kotlin.jvm.functions.Function3) r35
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r37 = 188(0xbc, float:2.63E-43)
            r38 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            goto L_0x0329
        L_0x0325:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0329:
            r5.endReplaceGroup()
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6 r9 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$6
            r21 = r41
            r17 = r46
            r16 = r2
            r19 = r10
            r22 = r11
            r20 = r13
            r24 = r14
            r4 = 1
            r13 = r44
            r14 = r45
            r11 = r48
            r10 = r50
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r2 = 54
            r3 = -1350062619(0xffffffffaf87ade5, float:-2.4679916E-10)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r4, r9, r5, r2)
            r18 = r2
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r21 = 122(0x7a, float:1.71E-43)
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r9 = r0
            r19 = r5
            r11 = r26
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0376
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0376:
            androidx.compose.runtime.ScopeUpdateScope r0 = r19.endRestartGroup()
            if (r0 == 0) goto L_0x03a7
            r2 = r0
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$7 r0 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$7
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r7 = r46
            r9 = r48
            r10 = r49
            r11 = r50
            r12 = r51
            r13 = r52
            r14 = r54
            r15 = r55
            r16 = r56
            r39 = r2
            r2 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = r39
            r2.updateScope(r0)
        L_0x03a7:
            return
        L_0x03a8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The expandedHeight is expected to be greater or equal to the collapsedHeight"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03b4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The expandedHeight is expected to be specified and finite"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03c0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The collapsedHeight is expected to be specified and finite"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1724TwoRowsTopAppBarnS6u9G4(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE  reason: not valid java name */
    public static final void m1723TopAppBarLayoutkXwM9vE(Modifier modifier, ScrolledOffset scrolledOffset, long j, long j2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        Composer composer2;
        Modifier modifier2 = modifier;
        ScrolledOffset scrolledOffset2 = scrolledOffset;
        Arrangement.Vertical vertical2 = vertical;
        Arrangement.Horizontal horizontal2 = horizontal;
        int i6 = i;
        boolean z2 = z;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        Function2<? super Composer, ? super Integer, Unit> function25 = function23;
        int i7 = i2;
        int i8 = i3;
        Composer startRestartGroup = composer.startRestartGroup(-742442296);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBarLayout)P(3,6,5:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,2,4)2163@98873L5882,2135@97725L7030:AppBar.kt#uh7d8r");
        if ((i7 & 6) == 0) {
            i4 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i7;
        } else {
            i4 = i7;
        }
        if ((i7 & 48) == 0) {
            i4 |= (i7 & 64) == 0 ? startRestartGroup.changed((Object) scrolledOffset2) : startRestartGroup.changedInstance(scrolledOffset2) ? 32 : 16;
        }
        int i9 = 256;
        long j4 = j;
        if ((i7 & 384) == 0) {
            i4 |= startRestartGroup.changed(j4) ? 256 : 128;
        }
        int i10 = i4;
        long j5 = j2;
        if ((i7 & 3072) == 0) {
            i10 |= startRestartGroup.changed(j5) ? 2048 : 1024;
        }
        long j6 = j3;
        if ((i7 & 24576) == 0) {
            i10 |= startRestartGroup.changed(j6) ? 16384 : 8192;
        }
        if ((196608 & i7) == 0) {
            i10 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        }
        TextStyle textStyle2 = textStyle;
        if ((i7 & 1572864) == 0) {
            i10 |= startRestartGroup.changed((Object) textStyle2) ? 1048576 : 524288;
        }
        int i11 = i7 & 12582912;
        float f2 = f;
        if (i11 == 0) {
            i10 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i10 |= startRestartGroup.changed((Object) vertical2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i10 |= startRestartGroup.changed((Object) horizontal2) ? 536870912 : 268435456;
        }
        if ((i8 & 6) == 0) {
            i5 = i8 | (startRestartGroup.changed(i6) ? 4 : 2);
        } else {
            i5 = i8;
        }
        if ((i8 & 48) == 0) {
            i5 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i8 & 384) == 0) {
            if (!startRestartGroup.changedInstance(function24)) {
                i9 = 128;
            }
            i5 |= i9;
        }
        if ((i8 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
        }
        int i12 = i5;
        if ((i10 & 306783379) == 306783378 && (i12 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-742442296, i10, i12, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1539011656, "CC(remember):AppBar.kt#9igjgp");
            int i13 = i12;
            boolean z3 = ((1879048192 & i10) == 536870912) | ((i10 & 112) == 32 || ((i10 & 64) != 0 && startRestartGroup.changedInstance(scrolledOffset2))) | ((234881024 & i10) == 67108864) | ((i13 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AppBarKt$TopAppBarLayout$2$1(scrolledOffset2, horizontal2, vertical2, i6);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r1 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r1, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 9049318, "C2137@97755L280,2143@98048L502,2155@98563L264:AppBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "navigationIcon");
            float f3 = TopAppBarHorizontalPadding;
            Modifier r12 = PaddingKt.m779paddingqDBjuR0$default(layoutId, f3, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            float f4 = f3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            int i14 = i10;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r12);
            int i15 = currentCompositeKeyHash2;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(i15))) {
                r10.updateRememberedValue(Integer.valueOf(i15));
                r10.apply(Integer.valueOf(i15), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 249765716, "C2138@97858L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j)), function24, startRestartGroup, ProvidedValue.$stable | ((i13 >> 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier r13 = PaddingKt.m777paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), f4, 0.0f, 2, (Object) null);
            Modifier modifier3 = Modifier.Companion;
            if (z2) {
                modifier3 = SemanticsModifierKt.clearAndSetSemantics(modifier3, AppBarKt$TopAppBarLayout$1$2.INSTANCE);
            }
            Modifier r14 = GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r13.then(modifier3), 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131067, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, r14);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            float f5 = f4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer r0 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r0, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r0, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r0.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r0, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 250255454, "C2149@98351L185:AppBar.kt#uh7d8r");
            int i16 = i14 >> 9;
            Composer composer3 = startRestartGroup;
            ProvideContentColorTextStyleKt.m2920ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, composer3, (i16 & 14) | ((i14 >> 15) & 112) | (i16 & 896));
            composer2 = composer3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier r15 = PaddingKt.m779paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.Companion, "actionIcons"), 0.0f, 0.0f, f5, 0.0f, 11, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, r15);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer r7 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r7, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r7.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3682setimpl(r7, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 250561951, "C2156@98661L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j3)), function25, composer2, ProvidedValue.$stable | ((i13 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AppBarKt$TopAppBarLayout$3(modifier, scrolledOffset, j, j2, j3, function2, textStyle, f, vertical2, horizontal2, i6, z2, function22, function25, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, new androidx.compose.material3.AppBarKt$settleAppBar$2(r3, r0, r1), r7, 2, (java.lang.Object) null) == r2) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r23, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r25) {
        /*
            r0 = r21
            r1 = r25
            boolean r2 = r1 instanceof androidx.compose.material3.AppBarKt$settleAppBar$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = (androidx.compose.material3.AppBarKt$settleAppBar$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = new androidx.compose.material3.AppBarKt$settleAppBar$1
            r2.<init>(r1)
        L_0x001d:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r7.label
            r10 = 2
            r4 = 1
            r11 = 0
            if (r3 == 0) goto L_0x0053
            if (r3 == r4) goto L_0x0040
            if (r3 != r10) goto L_0x0038
            java.lang.Object r0 = r7.L$0
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0111
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            java.lang.Object r0 = r7.L$2
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            java.lang.Object r3 = r7.L$1
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            java.lang.Object r4 = r7.L$0
            androidx.compose.material3.TopAppBarState r4 = (androidx.compose.material3.TopAppBarState) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r12 = r3
            r0 = r4
            goto L_0x00b2
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = r0.getCollapsedFraction()
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x011d
            float r1 = r0.getCollapsedFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x006d
            goto L_0x011d
        L_0x006d:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r13 = r22
            r1.element = r13
            if (r23 == 0) goto L_0x00b4
            float r5 = java.lang.Math.abs(r13)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b4
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r19 = 28
            r20 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)
            androidx.compose.material3.AppBarKt$settleAppBar$2 r6 = new androidx.compose.material3.AppBarKt$settleAppBar$2
            r6.<init>(r3, r0, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7.L$0 = r0
            r12 = r24
            r7.L$1 = r12
            r7.L$2 = r1
            r7.label = r4
            r3 = r5
            r5 = 0
            r8 = 2
            r9 = 0
            r4 = r23
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r2) goto L_0x00b2
            goto L_0x010f
        L_0x00b2:
            r5 = r12
            goto L_0x00b7
        L_0x00b4:
            r12 = r24
            goto L_0x00b2
        L_0x00b7:
            if (r5 == 0) goto L_0x0112
            float r3 = r0.getHeightOffset()
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0112
            float r3 = r0.getHeightOffset()
            float r4 = r0.getHeightOffsetLimit()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0112
            float r12 = r0.getHeightOffset()
            r19 = 30
            r20 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)
            float r4 = r0.getCollapsedFraction()
            r6 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ec
            r4 = r11
            goto L_0x00f0
        L_0x00ec:
            float r4 = r0.getHeightOffsetLimit()
        L_0x00f0:
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.material3.AppBarKt$settleAppBar$3 r6 = new androidx.compose.material3.AppBarKt$settleAppBar$3
            r6.<init>(r0)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7.L$0 = r1
            r0 = 0
            r7.L$1 = r0
            r7.L$2 = r0
            r7.label = r10
            r8 = r7
            r7 = r6
            r6 = 0
            r9 = 4
            r10 = 0
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r2) goto L_0x0110
        L_0x010f:
            return r2
        L_0x0110:
            r0 = r1
        L_0x0111:
            r1 = r0
        L_0x0112:
            float r0 = r1.element
            long r0 = androidx.compose.ui.unit.VelocityKt.Velocity(r11, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m7341boximpl(r0)
            return r0
        L_0x011d:
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m7361getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m7341boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final float SingleRowTopAppBar_cJHQLPU$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long SingleRowTopAppBar_cJHQLPU$lambda$10(State<Color> state) {
        return state.getValue().m4249unboximpl();
    }

    static {
        float f = (float) 16;
        float f2 = (float) 12;
        float r1 = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f) - Dp.m7111constructorimpl(f2));
        BottomAppBarHorizontalPadding = r1;
        float r3 = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f) - Dp.m7111constructorimpl(f2));
        BottomAppBarVerticalPadding = r3;
        FABHorizontalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f) - r1);
        FABVerticalPadding = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f2) - r3);
        float r12 = Dp.m7111constructorimpl((float) 4);
        TopAppBarHorizontalPadding = r12;
        TopAppBarTitleInset = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f) - r12);
    }
}
