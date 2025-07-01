package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a¨\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a»\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a¨\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a°\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001a\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a°\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001aÇ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010C\u001aÐ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\b\u0010\u001f\u001a\u0004\u0018\u00010;2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    /* access modifiers changed from: private */
    public static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX WARNING: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AssistChip(kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r12 = r47
            r14 = r49
            r0 = 313450168(0x12aedeb8, float:1.1035848E-27)
            r1 = r46
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AssistChip)P(8,5,7,3,6,10,9,1,2)126@6277L5,127@6328L18,128@6399L21,129@6469L25,137@6729L5,132@6561L541:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r11 = r35
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r11 = r35
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r36
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r13 = r36
            if (r4 != 0) goto L_0x0048
            boolean r4 = r8.changedInstance(r13)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r37
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r37
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r38
            boolean r9 = r8.changed((boolean) r7)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r9
            goto L_0x0080
        L_0x007e:
            r7 = r38
        L_0x0080:
            r9 = r14 & 16
            if (r9 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r39
            boolean r15 = r8.changedInstance(r10)
            if (r15 == 0) goto L_0x0096
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r15
            goto L_0x009c
        L_0x009a:
            r10 = r39
        L_0x009c:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r40
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r40
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r8.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r41
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r8.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r41
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r42
            boolean r18 = r8.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r42
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r42
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r43
            boolean r18 = r8.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r43
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r43
        L_0x0112:
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x012e
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0127
            r0 = r44
            boolean r18 = r8.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0129
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0127:
            r0 = r44
        L_0x0129:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r1 = r1 | r18
            goto L_0x0130
        L_0x012e:
            r0 = r44
        L_0x0130:
            r2 = r14 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x013d
            r18 = r48 | 6
            r34 = r18
            r18 = r2
            r2 = r34
            goto L_0x015b
        L_0x013d:
            r18 = r48 & 6
            if (r18 != 0) goto L_0x0155
            r18 = r2
            r2 = r45
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x014e
            r19 = 4
            goto L_0x0150
        L_0x014e:
            r19 = 2
        L_0x0150:
            r19 = r48 | r19
            r2 = r19
            goto L_0x015b
        L_0x0155:
            r18 = r2
            r2 = r45
            r2 = r48
        L_0x015b:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r46 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0188
            r0 = r2 & 3
            r1 = 2
            if (r0 != r1) goto L_0x0188
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0173
            goto L_0x0188
        L_0x0173:
            r8.skipToGroupEnd()
            r6 = r40
            r9 = r43
            r11 = r45
            r4 = r7
            r31 = r8
            r7 = r41
            r8 = r3
            r3 = r5
            r5 = r10
            r10 = r44
            goto L_0x030b
        L_0x0188:
            r8.startDefaults()
            r0 = r12 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = r2
            r2 = 6
            if (r0 == 0) goto L_0x01d4
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x019f
            goto L_0x01d4
        L_0x019f:
            r8.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01a9
            r0 = r46 & r17
            goto L_0x01ab
        L_0x01a9:
            r0 = r46
        L_0x01ab:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01b0
            r0 = r0 & r1
        L_0x01b0:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01b8
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x01b8:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x01c0
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
        L_0x01c0:
            r23 = r40
            r24 = r41
            r26 = r43
            r27 = r44
            r30 = r45
            r1 = r0
            r11 = r2
            r15 = r5
            r2 = r7
            r22 = r10
            r0 = r19
            goto L_0x0286
        L_0x01d4:
            if (r4 == 0) goto L_0x01db
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01dc
        L_0x01db:
            r0 = r5
        L_0x01dc:
            if (r6 == 0) goto L_0x01e2
            r4 = 1
            r20 = r4
            goto L_0x01e4
        L_0x01e2:
            r20 = r7
        L_0x01e4:
            r21 = 0
            if (r9 == 0) goto L_0x01eb
            r22 = r21
            goto L_0x01ed
        L_0x01eb:
            r22 = r10
        L_0x01ed:
            if (r15 == 0) goto L_0x01f2
            r15 = r21
            goto L_0x01f4
        L_0x01f2:
            r15 = r40
        L_0x01f4:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x0203
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r8, r2)
            r5 = r46 & r17
            r17 = r4
            goto L_0x0207
        L_0x0203:
            r17 = r41
            r5 = r46
        L_0x0207:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0212
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.assistChipColors(r8, r2)
            r5 = r5 & r1
        L_0x0212:
            r23 = r3
            r24 = r5
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x023f
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r25 = r7
            r7 = 0
            r37 = r0
            r0 = r19
            r11 = r25
            androidx.compose.material3.ChipElevation r1 = r1.m1734assistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r24 = r24 & r2
            r19 = r1
            goto L_0x0246
        L_0x023f:
            r37 = r0
            r11 = r2
            r0 = r19
            r19 = r43
        L_0x0246:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0265
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            int r2 = r24 >> 9
            r2 = r2 & 14
            r9 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = 14
            r3 = 0
            r5 = 0
            r7 = 0
            r2 = r20
            androidx.compose.foundation.BorderStroke r1 = r1.m1732assistChipBorderh1eTWw(r2, r3, r5, r7, r8, r9, r10)
            r3 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r3 = r24 & r3
            goto L_0x026b
        L_0x0265:
            r2 = r20
            r1 = r44
            r3 = r24
        L_0x026b:
            if (r18 == 0) goto L_0x0277
            r27 = r1
            r1 = r3
            r24 = r17
            r26 = r19
            r30 = r21
            goto L_0x0280
        L_0x0277:
            r30 = r45
            r27 = r1
            r1 = r3
            r24 = r17
            r26 = r19
        L_0x0280:
            r3 = r23
            r23 = r15
            r15 = r37
        L_0x0286:
            r8.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0297
            java.lang.String r4 = "androidx.compose.material3.AssistChip (Chip.kt:132)"
            r5 = 313450168(0x12aedeb8, float:1.1035848E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r0, r4)
        L_0x0297:
            androidx.compose.material3.tokens.AssistChipTokens r4 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.getValue(r4, r8, r11)
            long r20 = r3.m1818labelColorvNxB06k$material3_release(r2)
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r4.m1737getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r4 = r1 >> 6
            r4 = r4 & 14
            int r5 = r1 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r1 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r1 << 6
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r6
            r32 = r4 | r5
            int r1 = r1 >> 24
            r4 = r1 & 14
            r4 = r4 | 3456(0xd80, float:4.843E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            int r0 = r0 << 12
            r4 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r4
            r33 = r1 | r0
            r16 = r35
            r17 = r2
            r25 = r3
            r31 = r8
            r18 = r13
            m1827ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02f8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02f8:
            r31 = r8
            r3 = r15
            r4 = r17
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r30
        L_0x030b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r31.endRestartGroup()
            if (r15 == 0) goto L_0x0321
            androidx.compose.material3.ChipKt$AssistChip$1 r0 = new androidx.compose.material3.ChipKt$AssistChip$1
            r1 = r35
            r2 = r36
            r13 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0321:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void AssistChip(kotlin.jvm.functions.Function0 r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r12 = r47
            r14 = r49
            r0 = -1932300596(0xffffffff8cd36ecc, float:-3.257638E-31)
            r1 = r46
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AssistChip)P(8,5,7,3,6,10,9,1,2)213@10395L5,214@10446L18,215@10517L21,216@10585L18,217@10655L39,224@10872L5,219@10704L571:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r11 = r35
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r11 = r35
            if (r1 != 0) goto L_0x002c
            boolean r1 = r7.changedInstance(r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r36
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r13 = r36
            if (r4 != 0) goto L_0x0048
            boolean r4 = r7.changedInstance(r13)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r37
            boolean r6 = r7.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r37
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007e
            r8 = r38
            boolean r9 = r7.changed((boolean) r8)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r9
            goto L_0x0080
        L_0x007e:
            r8 = r38
        L_0x0080:
            r9 = r14 & 16
            if (r9 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r39
            boolean r15 = r7.changedInstance(r10)
            if (r15 == 0) goto L_0x0096
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r15
            goto L_0x009c
        L_0x009a:
            r10 = r39
        L_0x009c:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r40
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r40
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r7.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r41
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r41
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r42
            boolean r18 = r7.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r42
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r42
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r43
            boolean r18 = r7.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r43
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r43
        L_0x0112:
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x012e
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0127
            r0 = r44
            boolean r18 = r7.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0129
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0127:
            r0 = r44
        L_0x0129:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r1 = r1 | r18
            goto L_0x0130
        L_0x012e:
            r0 = r44
        L_0x0130:
            r2 = r14 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x013d
            r18 = r48 | 6
            r34 = r18
            r18 = r2
            r2 = r34
            goto L_0x015b
        L_0x013d:
            r18 = r48 & 6
            if (r18 != 0) goto L_0x0155
            r18 = r2
            r2 = r45
            boolean r19 = r7.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x014e
            r19 = 4
            goto L_0x0150
        L_0x014e:
            r19 = 2
        L_0x0150:
            r19 = r48 | r19
            r2 = r19
            goto L_0x015b
        L_0x0155:
            r18 = r2
            r2 = r45
            r2 = r48
        L_0x015b:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r46 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0188
            r0 = r2 & 3
            r1 = 2
            if (r0 != r1) goto L_0x0188
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x0173
            goto L_0x0188
        L_0x0173:
            r7.skipToGroupEnd()
            r6 = r40
            r9 = r43
            r11 = r45
            r31 = r7
            r4 = r8
            r7 = r41
            r8 = r3
            r3 = r5
            r5 = r10
            r10 = r44
            goto L_0x0347
        L_0x0188:
            r7.startDefaults()
            r0 = r12 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = 0
            r20 = r2
            r2 = 6
            if (r0 == 0) goto L_0x01d5
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a1
            goto L_0x01d5
        L_0x01a1:
            r7.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01ab
            r0 = r46 & r17
            goto L_0x01ad
        L_0x01ab:
            r0 = r46
        L_0x01ad:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01b2
            r0 = r0 & r1
        L_0x01b2:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01ba
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x01ba:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x01c2
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
        L_0x01c2:
            r23 = r40
            r24 = r41
            r26 = r43
            r1 = r44
            r30 = r45
            r11 = r2
            r15 = r5
            r22 = r10
            r2 = r0
            r0 = r20
            goto L_0x029a
        L_0x01d5:
            if (r4 == 0) goto L_0x01dc
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01dd
        L_0x01dc:
            r0 = r5
        L_0x01dd:
            if (r6 == 0) goto L_0x01e3
            r4 = 1
            r21 = r4
            goto L_0x01e5
        L_0x01e3:
            r21 = r8
        L_0x01e5:
            if (r9 == 0) goto L_0x01ea
            r22 = r19
            goto L_0x01ec
        L_0x01ea:
            r22 = r10
        L_0x01ec:
            if (r15 == 0) goto L_0x01f1
            r15 = r19
            goto L_0x01f3
        L_0x01f1:
            r15 = r40
        L_0x01f3:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x0202
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r7, r2)
            r5 = r46 & r17
            r17 = r4
            goto L_0x0206
        L_0x0202:
            r17 = r41
            r5 = r46
        L_0x0206:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0211
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.assistChipColors(r7, r2)
            r5 = r5 & r1
        L_0x0211:
            r23 = r3
            r24 = r5
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x023e
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r8 = r6
            r6 = 0
            r31 = r7
            r7 = 0
            r37 = r0
            r11 = r8
            r0 = r20
            r8 = r31
            androidx.compose.material3.ChipElevation r1 = r1.m1734assistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r24 = r24 & r2
            r10 = r1
            goto L_0x0247
        L_0x023e:
            r37 = r0
            r11 = r2
            r31 = r7
            r0 = r20
            r10 = r43
        L_0x0247:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0261
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r8 = 3072(0xc00, float:4.305E-42)
            r9 = 7
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = r31
            androidx.compose.material3.ChipBorder r1 = r1.m1731assistChipBorderd_3_b6Q(r2, r4, r6, r7, r8, r9)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r24 & r2
            goto L_0x0267
        L_0x0261:
            r7 = r31
            r1 = r44
            r2 = r24
        L_0x0267:
            if (r18 == 0) goto L_0x028c
            r3 = 267303551(0xfeeba7f, float:2.3540448E-29)
            java.lang.String r4 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r4)
            java.lang.Object r3 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0284
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r3)
        L_0x0284:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r30 = r3
            goto L_0x028e
        L_0x028c:
            r30 = r45
        L_0x028e:
            r26 = r10
            r24 = r17
            r8 = r21
            r3 = r23
            r23 = r15
            r15 = r37
        L_0x029a:
            r7.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x02ab
            java.lang.String r4 = "androidx.compose.material3.AssistChip (Chip.kt:219)"
            r5 = -1932300596(0xffffffff8cd36ecc, float:-3.257638E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r0, r4)
        L_0x02ab:
            androidx.compose.material3.tokens.AssistChipTokens r4 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.material3.TypographyKt.getValue(r4, r7, r11)
            long r20 = r3.m1818labelColorvNxB06k$material3_release(r8)
            r5 = 267317901(0xfeef28d, float:2.3562039E-29)
            r7.startReplaceGroup(r5)
            java.lang.String r5 = "231@11104L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            if (r1 != 0) goto L_0x02c9
            r5 = r19
            goto L_0x02d6
        L_0x02c9:
            int r5 = r2 >> 9
            r5 = r5 & 14
            int r6 = r2 >> 24
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.runtime.State r5 = r1.borderStroke$material3_release(r8, r7, r5)
        L_0x02d6:
            r7.endReplaceGroup()
            if (r5 == 0) goto L_0x02e3
            java.lang.Object r5 = r5.getValue()
            r19 = r5
            androidx.compose.foundation.BorderStroke r19 = (androidx.compose.foundation.BorderStroke) r19
        L_0x02e3:
            r27 = r19
            androidx.compose.material3.AssistChipDefaults r5 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r5.m1737getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r5 = r2 >> 6
            r5 = r5 & 14
            int r6 = r2 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            int r6 = r2 >> 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            int r6 = r2 << 6
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r6
            r5 = r5 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r6
            r5 = r5 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r6
            r5 = r5 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r9
            r32 = r5 | r6
            int r2 = r2 >> 24
            r2 = r2 & 14
            r2 = r2 | 3456(0xd80, float:4.843E-42)
            int r0 = r0 << 12
            r5 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r5
            r33 = r2 | r0
            r16 = r35
            r25 = r3
            r19 = r4
            r31 = r7
            r17 = r8
            r18 = r13
            m1827ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0337
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0337:
            r10 = r1
            r3 = r15
            r4 = r17
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r11 = r30
        L_0x0347:
            androidx.compose.runtime.ScopeUpdateScope r15 = r31.endRestartGroup()
            if (r15 == 0) goto L_0x035d
            androidx.compose.material3.ChipKt$AssistChip$3 r0 = new androidx.compose.material3.ChipKt$AssistChip$3
            r1 = r35
            r2 = r36
            r13 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x035d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedAssistChip(kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.foundation.BorderStroke r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r12 = r47
            r14 = r49
            r0 = 1594789934(0x5f0e902e, float:1.0272761E19)
            r1 = r46
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)289@14186L5,290@14237L26,291@14316L29,300@14613L5,295@14445L541:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r11 = r35
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r11 = r35
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r36
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r13 = r36
            if (r4 != 0) goto L_0x0048
            boolean r4 = r8.changedInstance(r13)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r37
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r37
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r38
            boolean r9 = r8.changed((boolean) r7)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r9
            goto L_0x0080
        L_0x007e:
            r7 = r38
        L_0x0080:
            r9 = r14 & 16
            if (r9 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r39
            boolean r15 = r8.changedInstance(r10)
            if (r15 == 0) goto L_0x0096
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r15
            goto L_0x009c
        L_0x009a:
            r10 = r39
        L_0x009c:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r40
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r40
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r8.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r41
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r8.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r41
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r42
            boolean r18 = r8.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r42
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r42
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r43
            boolean r18 = r8.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r43
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r43
        L_0x0112:
            r2 = r14 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x011b
            r1 = r1 | r18
            goto L_0x0131
        L_0x011b:
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0131
            r18 = r2
            r2 = r44
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x012c
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012e
        L_0x012c:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012e:
            r1 = r1 | r19
            goto L_0x0135
        L_0x0131:
            r18 = r2
            r2 = r44
        L_0x0135:
            r2 = r14 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0142
            r19 = r48 | 6
            r34 = r19
            r19 = r2
            r2 = r34
            goto L_0x0160
        L_0x0142:
            r19 = r48 & 6
            if (r19 != 0) goto L_0x015a
            r19 = r2
            r2 = r45
            boolean r20 = r8.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x0153
            r20 = 4
            goto L_0x0155
        L_0x0153:
            r20 = 2
        L_0x0155:
            r20 = r48 | r20
            r2 = r20
            goto L_0x0160
        L_0x015a:
            r19 = r2
            r2 = r45
            r2 = r48
        L_0x0160:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r20
            r46 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x018d
            r0 = r2 & 3
            r1 = 2
            if (r0 != r1) goto L_0x018d
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0178
            goto L_0x018d
        L_0x0178:
            r8.skipToGroupEnd()
            r6 = r40
            r9 = r43
            r11 = r45
            r4 = r7
            r31 = r8
            r7 = r41
            r8 = r3
            r3 = r5
            r5 = r10
            r10 = r44
            goto L_0x02f3
        L_0x018d:
            r8.startDefaults()
            r0 = r12 & 1
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = -3670017(0xffffffffffc7ffff, float:NaN)
            r21 = r2
            r2 = 6
            if (r0 == 0) goto L_0x01d1
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a7
            goto L_0x01d1
        L_0x01a7:
            r8.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01b1
            r0 = r46 & r20
            goto L_0x01b3
        L_0x01b1:
            r0 = r46
        L_0x01b3:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01b8
            r0 = r0 & r1
        L_0x01b8:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01be
            r0 = r0 & r17
        L_0x01be:
            r23 = r40
            r24 = r41
            r26 = r43
            r27 = r44
            r30 = r45
            r11 = r2
            r15 = r5
            r22 = r10
            r2 = r0
            r0 = r21
            goto L_0x026e
        L_0x01d1:
            if (r4 == 0) goto L_0x01d8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d9
        L_0x01d8:
            r0 = r5
        L_0x01d9:
            if (r6 == 0) goto L_0x01df
            r4 = 1
            r22 = r4
            goto L_0x01e1
        L_0x01df:
            r22 = r7
        L_0x01e1:
            r23 = 0
            if (r9 == 0) goto L_0x01e8
            r24 = r23
            goto L_0x01ea
        L_0x01e8:
            r24 = r10
        L_0x01ea:
            if (r15 == 0) goto L_0x01ef
            r15 = r23
            goto L_0x01f1
        L_0x01ef:
            r15 = r40
        L_0x01f1:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x0200
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r8, r2)
            r5 = r46 & r20
            r20 = r4
            goto L_0x0204
        L_0x0200:
            r20 = r41
            r5 = r46
        L_0x0204:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x020f
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedAssistChipColors(r8, r2)
            r5 = r5 & r1
        L_0x020f:
            r25 = r3
            r26 = r5
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0237
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r27 = r7
            r7 = 0
            r37 = r0
            r0 = r21
            r11 = r27
            androidx.compose.material3.ChipElevation r1 = r1.m1736elevatedAssistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r26 & r17
            goto L_0x0240
        L_0x0237:
            r37 = r0
            r11 = r2
            r0 = r21
            r1 = r43
            r2 = r26
        L_0x0240:
            if (r18 == 0) goto L_0x0245
            r3 = r23
            goto L_0x0247
        L_0x0245:
            r3 = r44
        L_0x0247:
            if (r19 == 0) goto L_0x025c
            r26 = r1
            r27 = r3
            r7 = r22
            r30 = r23
            r22 = r24
            r3 = r25
            r23 = r15
            r24 = r20
            r15 = r37
            goto L_0x026e
        L_0x025c:
            r30 = r45
            r26 = r1
            r27 = r3
            r23 = r15
            r7 = r22
            r22 = r24
            r3 = r25
            r15 = r37
            r24 = r20
        L_0x026e:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x027f
            java.lang.String r1 = "androidx.compose.material3.ElevatedAssistChip (Chip.kt:295)"
            r4 = 1594789934(0x5f0e902e, float:1.0272761E19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r2, r0, r1)
        L_0x027f:
            androidx.compose.material3.tokens.AssistChipTokens r1 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.getValue(r1, r8, r11)
            long r20 = r3.m1818labelColorvNxB06k$material3_release(r7)
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r1.m1737getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r1 = r2 >> 6
            r1 = r1 & 14
            int r4 = r2 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            int r4 = r2 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r1 = r1 | r4
            int r4 = r2 << 6
            r5 = r4 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r5
            r32 = r1 | r4
            int r1 = r2 >> 24
            r2 = r1 & 14
            r2 = r2 | 3456(0xd80, float:4.843E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r0 = r0 << 12
            r2 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r2
            r33 = r1 | r0
            r16 = r35
            r25 = r3
            r17 = r7
            r31 = r8
            r18 = r13
            m1827ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e0:
            r31 = r8
            r3 = r15
            r4 = r17
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r30
        L_0x02f3:
            androidx.compose.runtime.ScopeUpdateScope r15 = r31.endRestartGroup()
            if (r15 == 0) goto L_0x0309
            androidx.compose.material3.ChipKt$ElevatedAssistChip$1 r0 = new androidx.compose.material3.ChipKt$ElevatedAssistChip$1
            r1 = r35
            r2 = r36
            r13 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0309:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void ElevatedAssistChip(kotlin.jvm.functions.Function0 r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, boolean r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.material3.ChipColors r42, androidx.compose.material3.ChipElevation r43, androidx.compose.material3.ChipBorder r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r12 = r47
            r14 = r49
            r0 = 1295844802(0x4d3d05c2, float:1.98204448E8)
            r1 = r46
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)375@18287L5,376@18338L26,377@18417L29,379@18530L39,386@18746L5,381@18578L571:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r11 = r35
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r11 = r35
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r36
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r13 = r36
            if (r4 != 0) goto L_0x0048
            boolean r4 = r8.changedInstance(r13)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r37
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r37
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r38
            boolean r9 = r8.changed((boolean) r7)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r9
            goto L_0x0080
        L_0x007e:
            r7 = r38
        L_0x0080:
            r9 = r14 & 16
            if (r9 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r39
            boolean r15 = r8.changedInstance(r10)
            if (r15 == 0) goto L_0x0096
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r15
            goto L_0x009c
        L_0x009a:
            r10 = r39
        L_0x009c:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r40
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r40
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r8.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r41
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r8.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r41
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r42
            boolean r18 = r8.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r42
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r42
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r43
            boolean r18 = r8.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r43
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r43
        L_0x0112:
            r2 = r14 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x011b
            r1 = r1 | r18
            goto L_0x0131
        L_0x011b:
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0131
            r18 = r2
            r2 = r44
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x012c
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012e
        L_0x012c:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012e:
            r1 = r1 | r19
            goto L_0x0135
        L_0x0131:
            r18 = r2
            r2 = r44
        L_0x0135:
            r2 = r14 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0142
            r19 = r48 | 6
            r34 = r19
            r19 = r2
            r2 = r34
            goto L_0x0160
        L_0x0142:
            r19 = r48 & 6
            if (r19 != 0) goto L_0x015a
            r19 = r2
            r2 = r45
            boolean r20 = r8.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x0153
            r20 = 4
            goto L_0x0155
        L_0x0153:
            r20 = 2
        L_0x0155:
            r20 = r48 | r20
            r2 = r20
            goto L_0x0160
        L_0x015a:
            r19 = r2
            r2 = r45
            r2 = r48
        L_0x0160:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r20
            r46 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x018d
            r0 = r2 & 3
            r1 = 2
            if (r0 != r1) goto L_0x018d
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0178
            goto L_0x018d
        L_0x0178:
            r8.skipToGroupEnd()
            r6 = r40
            r9 = r43
            r11 = r45
            r4 = r7
            r31 = r8
            r7 = r41
            r8 = r3
            r3 = r5
            r5 = r10
            r10 = r44
            goto L_0x032e
        L_0x018d:
            r8.startDefaults()
            r0 = r12 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = 0
            r21 = r2
            r2 = 6
            if (r0 == 0) goto L_0x01d2
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a6
            goto L_0x01d2
        L_0x01a6:
            r8.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01b0
            r0 = r46 & r17
            goto L_0x01b2
        L_0x01b0:
            r0 = r46
        L_0x01b2:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01b7
            r0 = r0 & r1
        L_0x01b7:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01bf
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x01bf:
            r23 = r40
            r24 = r41
            r26 = r43
            r1 = r44
            r30 = r45
            r11 = r2
            r15 = r5
            r22 = r10
            r2 = r0
            r0 = r21
            goto L_0x0282
        L_0x01d2:
            if (r4 == 0) goto L_0x01d9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01da
        L_0x01d9:
            r0 = r5
        L_0x01da:
            if (r6 == 0) goto L_0x01e0
            r4 = 1
            r22 = r4
            goto L_0x01e2
        L_0x01e0:
            r22 = r7
        L_0x01e2:
            if (r9 == 0) goto L_0x01e7
            r23 = r20
            goto L_0x01e9
        L_0x01e7:
            r23 = r10
        L_0x01e9:
            if (r15 == 0) goto L_0x01ee
            r15 = r20
            goto L_0x01f0
        L_0x01ee:
            r15 = r40
        L_0x01f0:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x01ff
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r8, r2)
            r5 = r46 & r17
            r17 = r4
            goto L_0x0203
        L_0x01ff:
            r17 = r41
            r5 = r46
        L_0x0203:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x020e
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedAssistChipColors(r8, r2)
            r5 = r5 & r1
        L_0x020e:
            r24 = r3
            r25 = r5
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0239
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r26 = r7
            r7 = 0
            r37 = r0
            r0 = r21
            r11 = r26
            androidx.compose.material3.ChipElevation r1 = r1.m1736elevatedAssistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r25 & r2
            goto L_0x0242
        L_0x0239:
            r37 = r0
            r11 = r2
            r0 = r21
            r1 = r43
            r2 = r25
        L_0x0242:
            if (r18 == 0) goto L_0x0247
            r3 = r20
            goto L_0x0249
        L_0x0247:
            r3 = r44
        L_0x0249:
            if (r19 == 0) goto L_0x0271
            r4 = 1551989929(0x5c817ca9, float:2.91578698E17)
            java.lang.String r5 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r4 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0266
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r4)
        L_0x0266:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r26 = r1
            r1 = r3
            r30 = r4
            goto L_0x0276
        L_0x0271:
            r30 = r45
            r26 = r1
            r1 = r3
        L_0x0276:
            r7 = r22
            r22 = r23
            r3 = r24
            r23 = r15
            r24 = r17
            r15 = r37
        L_0x0282:
            r8.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0293
            java.lang.String r4 = "androidx.compose.material3.ElevatedAssistChip (Chip.kt:381)"
            r5 = 1295844802(0x4d3d05c2, float:1.98204448E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r0, r4)
        L_0x0293:
            androidx.compose.material3.tokens.AssistChipTokens r4 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.getValue(r4, r8, r11)
            r4 = r20
            long r20 = r3.m1818labelColorvNxB06k$material3_release(r7)
            androidx.compose.material3.AssistChipDefaults r5 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r5.m1737getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            r5 = 1552007127(0x5c81bfd7, float:2.92169617E17)
            r8.startReplaceGroup(r5)
            java.lang.String r5 = "395@19068L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            if (r1 != 0) goto L_0x02ba
            r5 = r4
            goto L_0x02c7
        L_0x02ba:
            int r5 = r2 >> 9
            r5 = r5 & 14
            int r6 = r2 >> 24
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.runtime.State r5 = r1.borderStroke$material3_release(r7, r8, r5)
        L_0x02c7:
            r8.endReplaceGroup()
            if (r5 == 0) goto L_0x02d2
            java.lang.Object r4 = r5.getValue()
            androidx.compose.foundation.BorderStroke r4 = (androidx.compose.foundation.BorderStroke) r4
        L_0x02d2:
            r27 = r4
            int r4 = r2 >> 6
            r4 = r4 & 14
            int r5 = r2 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r2 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r2 << 6
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r6
            r32 = r4 | r5
            int r2 = r2 >> 24
            r2 = r2 & 14
            r2 = r2 | 3456(0xd80, float:4.843E-42)
            int r0 = r0 << 12
            r4 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r4
            r33 = r2 | r0
            r16 = r35
            r25 = r3
            r17 = r7
            r31 = r8
            r18 = r13
            m1827ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x031c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031c:
            r10 = r1
            r31 = r8
            r3 = r15
            r4 = r17
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r11 = r30
        L_0x032e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r31.endRestartGroup()
            if (r15 == 0) goto L_0x0344
            androidx.compose.material3.ChipKt$ElevatedAssistChip$3 r0 = new androidx.compose.material3.ChipKt$ElevatedAssistChip$3
            r1 = r35
            r2 = r36
            r13 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0344:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FilterChip(boolean r41, kotlin.jvm.functions.Function0<kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.Modifier r44, boolean r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.material3.SelectableChipColors r49, androidx.compose.material3.SelectableChipElevation r50, androidx.compose.foundation.BorderStroke r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r13 = r54
            r15 = r56
            r0 = -1711985619(0xffffffff99f52c2d, float:-2.5350249E-23)
            r1 = r53
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)462@22511L5,463@22572L18,464@22653L21,465@22723L35,474@23031L5,468@22824L554:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r13 | 6
            r11 = r41
            goto L_0x002d
        L_0x001b:
            r1 = r13 & 6
            r11 = r41
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changed((boolean) r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r13
            goto L_0x002d
        L_0x002c:
            r1 = r13
        L_0x002d:
            r4 = r15 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r12 = r42
            goto L_0x0048
        L_0x0036:
            r4 = r13 & 48
            r12 = r42
            if (r4 != 0) goto L_0x0048
            boolean r4 = r8.changedInstance(r12)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r14 = r43
            goto L_0x0063
        L_0x0051:
            r4 = r13 & 384(0x180, float:5.38E-43)
            r14 = r43
            if (r4 != 0) goto L_0x0063
            boolean r4 = r8.changedInstance(r14)
            if (r4 == 0) goto L_0x0060
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r4
        L_0x0063:
            r4 = r15 & 8
            if (r4 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r7 = r13 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r44
            boolean r9 = r8.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r9
            goto L_0x007f
        L_0x007d:
            r7 = r44
        L_0x007f:
            r9 = r15 & 16
            if (r9 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r10 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r45
            boolean r16 = r8.changed((boolean) r10)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r16
            goto L_0x009c
        L_0x009a:
            r10 = r45
        L_0x009c:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r1 = r1 | r17
            r2 = r46
            goto L_0x00ba
        L_0x00a7:
            r17 = r13 & r17
            r2 = r46
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r8.changedInstance(r2)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c5
            r1 = r1 | r18
            r3 = r47
            goto L_0x00d8
        L_0x00c5:
            r18 = r13 & r18
            r3 = r47
            if (r18 != 0) goto L_0x00d8
            boolean r19 = r8.changedInstance(r3)
            if (r19 == 0) goto L_0x00d4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r1 = r1 | r19
        L_0x00d8:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r13 & r19
            if (r19 != 0) goto L_0x00f4
            r5 = r15 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00ed
            r5 = r48
            boolean r20 = r8.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00ef
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r5 = r48
        L_0x00ef:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r1 = r1 | r20
            goto L_0x00f6
        L_0x00f4:
            r5 = r48
        L_0x00f6:
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r20 = r13 & r20
            if (r20 != 0) goto L_0x0112
            r6 = r15 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x010b
            r6 = r49
            boolean r21 = r8.changed((java.lang.Object) r6)
            if (r21 == 0) goto L_0x010d
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r6 = r49
        L_0x010d:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r21
            goto L_0x0114
        L_0x0112:
            r6 = r49
        L_0x0114:
            r21 = 805306368(0x30000000, float:4.656613E-10)
            r21 = r13 & r21
            if (r21 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r50
            boolean r21 = r8.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x012b
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r50
        L_0x012b:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r1 = r1 | r21
            goto L_0x0132
        L_0x0130:
            r0 = r50
        L_0x0132:
            r21 = r55 & 6
            if (r21 != 0) goto L_0x014c
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0145
            r0 = r51
            boolean r21 = r8.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x0147
            r18 = 4
            goto L_0x0149
        L_0x0145:
            r0 = r51
        L_0x0147:
            r18 = 2
        L_0x0149:
            r18 = r55 | r18
            goto L_0x0150
        L_0x014c:
            r0 = r51
            r18 = r55
        L_0x0150:
            r2 = r15 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x015d
            r18 = r18 | 48
            r21 = r2
            r33 = r18
            r2 = r52
            goto L_0x0179
        L_0x015d:
            r21 = r55 & 48
            if (r21 != 0) goto L_0x0173
            r21 = r2
            r2 = r52
            boolean r22 = r8.changed((java.lang.Object) r2)
            if (r22 == 0) goto L_0x016e
            r19 = 32
            goto L_0x0170
        L_0x016e:
            r19 = 16
        L_0x0170:
            r18 = r18 | r19
            goto L_0x0177
        L_0x0173:
            r21 = r2
            r2 = r52
        L_0x0177:
            r33 = r18
        L_0x0179:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r18
            r53 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x01a5
            r0 = r33 & 19
            r1 = 18
            if (r0 != r1) goto L_0x01a5
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0192
            goto L_0x01a5
        L_0x0192:
            r8.skipToGroupEnd()
            r11 = r51
            r12 = r2
            r9 = r6
            r4 = r7
            r32 = r8
            r6 = r46
            r7 = r3
            r8 = r5
            r5 = r10
            r10 = r50
            goto L_0x0349
        L_0x01a5:
            r8.startDefaults()
            r0 = r13 & 1
            r1 = 6
            if (r0 == 0) goto L_0x01f1
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01b4
            goto L_0x01f1
        L_0x01b4:
            r8.skipToGroupEnd()
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01c1
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r53 & r0
            goto L_0x01c3
        L_0x01c1:
            r0 = r53
        L_0x01c3:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x01cb
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r4
        L_0x01cb:
            r4 = r15 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x01d3
            r4 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r4
        L_0x01d3:
            r4 = r15 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x01d9
            r33 = r33 & -15
        L_0x01d9:
            r22 = r46
            r27 = r50
            r28 = r51
            r31 = r2
            r24 = r3
            r25 = r5
            r26 = r6
            r17 = r7
            r19 = r10
            r2 = r0
            r0 = r1
            r1 = r33
            goto L_0x02bf
        L_0x01f1:
            if (r4 == 0) goto L_0x01f8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01f9
        L_0x01f8:
            r0 = r7
        L_0x01f9:
            if (r9 == 0) goto L_0x01ff
            r4 = 1
            r18 = r4
            goto L_0x0201
        L_0x01ff:
            r18 = r10
        L_0x0201:
            r34 = 0
            if (r16 == 0) goto L_0x0208
            r35 = r34
            goto L_0x020a
        L_0x0208:
            r35 = r46
        L_0x020a:
            if (r17 == 0) goto L_0x020f
            r36 = r34
            goto L_0x0211
        L_0x020f:
            r36 = r3
        L_0x0211:
            r3 = r15 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0223
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r1)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r4 = r53 & r4
            r37 = r3
            goto L_0x0227
        L_0x0223:
            r4 = r53
            r37 = r5
        L_0x0227:
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0238
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r3 = r3.filterChipColors(r8, r1)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r4 = r4 & r5
            r38 = r3
            goto L_0x023a
        L_0x0238:
            r38 = r6
        L_0x023a:
            r16 = r4
            r3 = r15 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0263
            r3 = r1
            androidx.compose.material3.FilterChipDefaults r1 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r17 = r7
            r7 = 0
            r44 = r0
            r0 = r17
            r39 = r21
            androidx.compose.material3.SelectableChipElevation r1 = r1.m2086filterChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r16 & r2
            goto L_0x026c
        L_0x0263:
            r44 = r0
            r0 = r1
            r39 = r21
            r1 = r50
            r2 = r16
        L_0x026c:
            r3 = r15 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x029a
            androidx.compose.material3.FilterChipDefaults r16 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            int r3 = r2 >> 12
            r3 = r3 & 14
            r4 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r4
            int r4 = r2 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r30 = r3 | r4
            r31 = 252(0xfc, float:3.53E-43)
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = r8
            r17 = r18
            r18 = r11
            androidx.compose.foundation.BorderStroke r3 = r16.m2084filterChipBorder_7El2pE(r17, r18, r19, r21, r23, r25, r27, r28, r29, r30, r31)
            r33 = r33 & -15
            goto L_0x029e
        L_0x029a:
            r17 = r18
            r3 = r51
        L_0x029e:
            if (r39 == 0) goto L_0x02ab
            r27 = r1
            r28 = r3
            r19 = r17
            r1 = r33
            r31 = r34
            goto L_0x02b5
        L_0x02ab:
            r31 = r52
            r27 = r1
            r28 = r3
            r19 = r17
            r1 = r33
        L_0x02b5:
            r22 = r35
            r24 = r36
            r25 = r37
            r26 = r38
            r17 = r44
        L_0x02bf:
            r8.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02d0
            java.lang.String r3 = "androidx.compose.material3.FilterChip (Chip.kt:468)"
            r4 = -1711985619(0xffffffff99f52c2d, float:-2.5350249E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r2, r1, r3)
        L_0x02d0:
            androidx.compose.material3.tokens.FilterChipTokens r3 = androidx.compose.material3.tokens.FilterChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.getValue(r3, r8, r0)
            androidx.compose.material3.FilterChipDefaults r0 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            float r29 = r0.m2087getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r30 = FilterChipPadding
            r0 = r2 & 14
            r3 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r3
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r3 = r2 << 3
            r4 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r4
            int r4 = r2 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            int r4 = r2 << 6
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r4
            r0 = r0 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r0 = r0 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r33 = r0 | r3
            int r0 = r2 >> 24
            r2 = r0 & 14
            r2 = r2 | 27648(0x6c00, float:3.8743E-41)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r1 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r1 = r1 << 12
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r34 = r0 | r1
            r23 = 0
            r16 = r41
            r32 = r8
            r18 = r12
            r20 = r14
            m1829SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0335
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0335:
            r32 = r8
            r4 = r17
            r5 = r19
            r6 = r22
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r31
        L_0x0349:
            androidx.compose.runtime.ScopeUpdateScope r0 = r32.endRestartGroup()
            if (r0 == 0) goto L_0x0366
            r1 = r0
            androidx.compose.material3.ChipKt$FilterChip$1 r0 = new androidx.compose.material3.ChipKt$FilterChip$1
            r2 = r42
            r3 = r43
            r14 = r55
            r40 = r1
            r1 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x0366:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedFilterChip(boolean r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.graphics.Shape r43, androidx.compose.material3.SelectableChipColors r44, androidx.compose.material3.SelectableChipElevation r45, androidx.compose.foundation.BorderStroke r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r13 = r49
            r15 = r51
            r0 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            r1 = r48
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)546@26622L5,547@26683L26,548@26772L29,558@27108L5,552@26901L554:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r13 | 6
            r11 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r13 & 6
            r11 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changed((boolean) r11)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r13
            goto L_0x002d
        L_0x002c:
            r1 = r13
        L_0x002d:
            r4 = r15 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r12 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r13 & 48
            r12 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r8.changedInstance(r12)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r14 = r38
            goto L_0x0063
        L_0x0051:
            r4 = r13 & 384(0x180, float:5.38E-43)
            r14 = r38
            if (r4 != 0) goto L_0x0063
            boolean r4 = r8.changedInstance(r14)
            if (r4 == 0) goto L_0x0060
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r4
        L_0x0063:
            r4 = r15 & 8
            if (r4 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r7 = r13 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r39
            boolean r9 = r8.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r9
            goto L_0x007f
        L_0x007d:
            r7 = r39
        L_0x007f:
            r9 = r15 & 16
            if (r9 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r10 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r40
            boolean r16 = r8.changed((boolean) r10)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r16
            goto L_0x009c
        L_0x009a:
            r10 = r40
        L_0x009c:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r1 = r1 | r17
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r17 = r13 & r17
            r2 = r41
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r8.changedInstance(r2)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c5
            r1 = r1 | r18
            r3 = r42
            goto L_0x00d8
        L_0x00c5:
            r18 = r13 & r18
            r3 = r42
            if (r18 != 0) goto L_0x00d8
            boolean r19 = r8.changedInstance(r3)
            if (r19 == 0) goto L_0x00d4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r1 = r1 | r19
        L_0x00d8:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r20 = r13 & r19
            if (r20 != 0) goto L_0x00f4
            r5 = r15 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00ed
            r5 = r43
            boolean r21 = r8.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x00ef
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r5 = r43
        L_0x00ef:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r1 = r1 | r21
            goto L_0x00f6
        L_0x00f4:
            r5 = r43
        L_0x00f6:
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r21 = r13 & r21
            if (r21 != 0) goto L_0x0112
            r6 = r15 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x010b
            r6 = r44
            boolean r22 = r8.changed((java.lang.Object) r6)
            if (r22 == 0) goto L_0x010d
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r6 = r44
        L_0x010d:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r22
            goto L_0x0114
        L_0x0112:
            r6 = r44
        L_0x0114:
            r22 = 805306368(0x30000000, float:4.656613E-10)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r45
            boolean r23 = r8.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x012b
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r45
        L_0x012b:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r1 = r1 | r23
            goto L_0x0132
        L_0x0130:
            r0 = r45
        L_0x0132:
            r2 = r15 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x013d
            r18 = r50 | 6
            r23 = r2
            r2 = r46
            goto L_0x0159
        L_0x013d:
            r23 = r50 & 6
            if (r23 != 0) goto L_0x0153
            r23 = r2
            r2 = r46
            boolean r24 = r8.changed((java.lang.Object) r2)
            if (r24 == 0) goto L_0x014e
            r18 = 4
            goto L_0x0150
        L_0x014e:
            r18 = 2
        L_0x0150:
            r18 = r50 | r18
            goto L_0x0159
        L_0x0153:
            r23 = r2
            r2 = r46
            r18 = r50
        L_0x0159:
            r2 = r15 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0162
            r18 = r18 | 48
            r24 = r2
            goto L_0x017c
        L_0x0162:
            r24 = r50 & 48
            if (r24 != 0) goto L_0x0178
            r24 = r2
            r2 = r47
            boolean r25 = r8.changed((java.lang.Object) r2)
            if (r25 == 0) goto L_0x0173
            r20 = 32
            goto L_0x0175
        L_0x0173:
            r20 = 16
        L_0x0175:
            r18 = r18 | r20
            goto L_0x017c
        L_0x0178:
            r24 = r2
            r2 = r47
        L_0x017c:
            r2 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r18
            r48 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x01ab
            r0 = r2 & 19
            r1 = 18
            if (r0 != r1) goto L_0x01ab
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0197
            goto L_0x01ab
        L_0x0197:
            r8.skipToGroupEnd()
            r11 = r46
            r12 = r47
            r9 = r6
            r4 = r7
            r32 = r8
            r6 = r41
            r7 = r3
            r8 = r5
            r5 = r10
            r10 = r45
            goto L_0x0326
        L_0x01ab:
            r8.startDefaults()
            r0 = r13 & 1
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = r2
            r2 = 6
            if (r0 == 0) goto L_0x01f8
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01c2
            goto L_0x01f8
        L_0x01c2:
            r8.skipToGroupEnd()
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01cc
            r0 = r48 & r18
            goto L_0x01ce
        L_0x01cc:
            r0 = r48
        L_0x01ce:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x01d3
            r0 = r0 & r1
        L_0x01d3:
            r1 = r15 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x01db
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
        L_0x01db:
            r22 = r41
            r27 = r45
            r28 = r46
            r31 = r47
            r11 = r2
            r24 = r3
            r25 = r5
            r26 = r6
            r17 = r7
            r1 = r19
            r3 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            r2 = r0
            r19 = r10
            r0 = r20
            goto L_0x02a1
        L_0x01f8:
            if (r4 == 0) goto L_0x01ff
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0200
        L_0x01ff:
            r0 = r7
        L_0x0200:
            if (r9 == 0) goto L_0x0206
            r4 = 1
            r21 = r4
            goto L_0x0208
        L_0x0206:
            r21 = r10
        L_0x0208:
            r25 = 0
            if (r16 == 0) goto L_0x020f
            r16 = r25
            goto L_0x0211
        L_0x020f:
            r16 = r41
        L_0x0211:
            if (r17 == 0) goto L_0x0216
            r17 = r25
            goto L_0x0218
        L_0x0216:
            r17 = r3
        L_0x0218:
            r3 = r15 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0227
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r2)
            r4 = r48 & r18
            r18 = r3
            goto L_0x022b
        L_0x0227:
            r4 = r48
            r18 = r5
        L_0x022b:
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0239
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r3 = r3.elevatedFilterChipColors(r8, r2)
            r4 = r4 & r1
            r26 = r3
            goto L_0x023b
        L_0x0239:
            r26 = r6
        L_0x023b:
            r27 = r4
            r1 = r15 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0264
            androidx.compose.material3.FilterChipDefaults r1 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r28 = r7
            r7 = 0
            r39 = r0
            r0 = r20
            r11 = r28
            androidx.compose.material3.SelectableChipElevation r1 = r1.m2083elevatedFilterChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r27 & r2
            goto L_0x026d
        L_0x0264:
            r39 = r0
            r11 = r2
            r0 = r20
            r1 = r45
            r2 = r27
        L_0x026d:
            if (r23 == 0) goto L_0x0272
            r3 = r25
            goto L_0x0274
        L_0x0272:
            r3 = r46
        L_0x0274:
            if (r24 == 0) goto L_0x028c
            r27 = r1
            r28 = r3
            r22 = r16
            r24 = r17
            r1 = r19
            r19 = r21
            r31 = r25
            r3 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            r17 = r39
            r25 = r18
            goto L_0x02a1
        L_0x028c:
            r31 = r47
            r27 = r1
            r28 = r3
            r22 = r16
            r24 = r17
            r25 = r18
            r1 = r19
            r19 = r21
            r3 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            r17 = r39
        L_0x02a1:
            r8.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x02af
            java.lang.String r4 = "androidx.compose.material3.ElevatedFilterChip (Chip.kt:552)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r0, r4)
        L_0x02af:
            androidx.compose.material3.tokens.FilterChipTokens r3 = androidx.compose.material3.tokens.FilterChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.getValue(r3, r8, r11)
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            float r29 = r3.m2087getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r30 = FilterChipPadding
            r3 = r2 & 14
            r1 = r1 | r3
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r2 << 3
            r4 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r4
            int r4 = r2 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r4
            int r4 = r2 << 6
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r1 = r1 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r33 = r1 | r3
            int r1 = r2 >> 24
            r2 = r1 & 14
            r2 = r2 | 27648(0x6c00, float:3.8743E-41)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r0 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r0 = r0 << 12
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r34 = r1 | r0
            r23 = 0
            r16 = r36
            r32 = r8
            r18 = r12
            r20 = r14
            m1829SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0312
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0312:
            r32 = r8
            r4 = r17
            r5 = r19
            r6 = r22
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r31
        L_0x0326:
            androidx.compose.runtime.ScopeUpdateScope r0 = r32.endRestartGroup()
            if (r0 == 0) goto L_0x0343
            r1 = r0
            androidx.compose.material3.ChipKt$ElevatedFilterChip$1 r0 = new androidx.compose.material3.ChipKt$ElevatedFilterChip$1
            r2 = r37
            r3 = r38
            r14 = r50
            r35 = r1
            r1 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0343:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedFilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void InputChip(boolean r42, kotlin.jvm.functions.Function0<kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.SelectableChipColors r51, androidx.compose.material3.SelectableChipElevation r52, androidx.compose.foundation.BorderStroke r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r14 = r56
            r15 = r57
            r0 = r58
            r1 = 1658928131(0x62e13c03, float:2.0774209E21)
            r2 = r55
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)638@30882L5,639@30942L17,640@31021L20,641@31089L34,671@32220L5,665@32014L745:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r0 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r14 | 6
            r12 = r42
            goto L_0x002f
        L_0x001d:
            r2 = r14 & 6
            r12 = r42
            if (r2 != 0) goto L_0x002e
            boolean r2 = r9.changed((boolean) r12)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r14
            goto L_0x002f
        L_0x002e:
            r2 = r14
        L_0x002f:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0038
            r2 = r2 | 48
            r13 = r43
            goto L_0x004a
        L_0x0038:
            r5 = r14 & 48
            r13 = r43
            if (r5 != 0) goto L_0x004a
            boolean r5 = r9.changedInstance(r13)
            if (r5 == 0) goto L_0x0047
            r5 = 32
            goto L_0x0049
        L_0x0047:
            r5 = 16
        L_0x0049:
            r2 = r2 | r5
        L_0x004a:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0064
            r5 = r44
            boolean r11 = r9.changedInstance(r5)
            if (r11 == 0) goto L_0x0060
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r11
            goto L_0x0066
        L_0x0064:
            r5 = r44
        L_0x0066:
            r11 = r0 & 8
            if (r11 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006d:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0081
            r3 = r45
            boolean r16 = r9.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x007c
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r16
            goto L_0x0083
        L_0x0081:
            r3 = r45
        L_0x0083:
            r16 = r0 & 16
            if (r16 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008a:
            r4 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x009e
            r4 = r46
            boolean r18 = r9.changed((boolean) r4)
            if (r18 == 0) goto L_0x0099
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r18
            goto L_0x00a0
        L_0x009e:
            r4 = r46
        L_0x00a0:
            r18 = r0 & 32
            r19 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00ab
            r2 = r2 | r19
            r6 = r47
            goto L_0x00be
        L_0x00ab:
            r19 = r14 & r19
            r6 = r47
            if (r19 != 0) goto L_0x00be
            boolean r20 = r9.changedInstance(r6)
            if (r20 == 0) goto L_0x00ba
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r2 = r2 | r20
        L_0x00be:
            r20 = r0 & 64
            r21 = 1572864(0x180000, float:2.204052E-39)
            if (r20 == 0) goto L_0x00c9
            r2 = r2 | r21
            r7 = r48
            goto L_0x00dc
        L_0x00c9:
            r21 = r14 & r21
            r7 = r48
            if (r21 != 0) goto L_0x00dc
            boolean r22 = r9.changedInstance(r7)
            if (r22 == 0) goto L_0x00d8
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r2 = r2 | r22
        L_0x00dc:
            r8 = r0 & 128(0x80, float:1.794E-43)
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00e7
            r2 = r2 | r23
            r10 = r49
            goto L_0x00fa
        L_0x00e7:
            r23 = r14 & r23
            r10 = r49
            if (r23 != 0) goto L_0x00fa
            boolean r24 = r9.changedInstance(r10)
            if (r24 == 0) goto L_0x00f6
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r2 = r2 | r24
        L_0x00fa:
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r24 = r14 & r24
            if (r24 != 0) goto L_0x0116
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x010f
            r1 = r50
            boolean r24 = r9.changed((java.lang.Object) r1)
            if (r24 == 0) goto L_0x0111
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x010f:
            r1 = r50
        L_0x0111:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r2 = r2 | r24
            goto L_0x0118
        L_0x0116:
            r1 = r50
        L_0x0118:
            r24 = 805306368(0x30000000, float:4.656613E-10)
            r24 = r14 & r24
            if (r24 != 0) goto L_0x0134
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x012d
            r1 = r51
            boolean r24 = r9.changed((java.lang.Object) r1)
            if (r24 == 0) goto L_0x012f
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0131
        L_0x012d:
            r1 = r51
        L_0x012f:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0131:
            r2 = r2 | r24
            goto L_0x0136
        L_0x0134:
            r1 = r51
        L_0x0136:
            r24 = r15 & 6
            if (r24 != 0) goto L_0x0150
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0149
            r1 = r52
            boolean r24 = r9.changed((java.lang.Object) r1)
            if (r24 == 0) goto L_0x014b
            r17 = 4
            goto L_0x014d
        L_0x0149:
            r1 = r52
        L_0x014b:
            r17 = 2
        L_0x014d:
            r17 = r15 | r17
            goto L_0x0154
        L_0x0150:
            r1 = r52
            r17 = r15
        L_0x0154:
            r24 = r15 & 48
            if (r24 != 0) goto L_0x016e
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 != 0) goto L_0x0167
            r1 = r53
            boolean r24 = r9.changed((java.lang.Object) r1)
            if (r24 == 0) goto L_0x0169
            r19 = 32
            goto L_0x016b
        L_0x0167:
            r1 = r53
        L_0x0169:
            r19 = 16
        L_0x016b:
            r17 = r17 | r19
            goto L_0x0170
        L_0x016e:
            r1 = r53
        L_0x0170:
            r1 = r17
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x017e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r19 = r3
            r3 = r1
            r1 = r54
            goto L_0x019a
        L_0x017e:
            r17 = r1
            r1 = r15 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L_0x0194
            r1 = r54
            boolean r19 = r9.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x018f
            r22 = 256(0x100, float:3.59E-43)
            goto L_0x0191
        L_0x018f:
            r22 = 128(0x80, float:1.794E-43)
        L_0x0191:
            r17 = r17 | r22
            goto L_0x0196
        L_0x0194:
            r1 = r54
        L_0x0196:
            r19 = r3
            r3 = r17
        L_0x019a:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r2 & r17
            r55 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01c8
            r1 = r3 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x01c8
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x01b3
            goto L_0x01c8
        L_0x01b3:
            r9.skipToGroupEnd()
            r11 = r52
            r12 = r53
            r13 = r54
            r5 = r4
            r32 = r9
            r8 = r10
            r4 = r45
            r9 = r50
            r10 = r51
            goto L_0x03b7
        L_0x01c8:
            r9.startDefaults()
            r1 = r14 & 1
            r33 = 0
            r2 = 6
            r17 = r3
            r3 = 1
            if (r1 == 0) goto L_0x021a
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01dc
            goto L_0x021a
        L_0x01dc:
            r9.skipToGroupEnd()
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01e9
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r55 & r1
            goto L_0x01eb
        L_0x01e9:
            r1 = r55
        L_0x01eb:
            r8 = r0 & 512(0x200, float:7.175E-43)
            if (r8 == 0) goto L_0x01f3
            r8 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r8
        L_0x01f3:
            r8 = r0 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x01fb
            r8 = r17 & -15
            r17 = r8
        L_0x01fb:
            r8 = r0 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0201
            r17 = r17 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0201:
            r3 = r2
            r2 = r1
            r1 = r3
            r25 = r50
            r26 = r51
            r27 = r52
            r28 = r53
            r31 = r54
            r19 = r4
            r22 = r6
            r24 = r10
            r3 = r17
        L_0x0216:
            r17 = r45
            goto L_0x02e9
        L_0x021a:
            if (r11 == 0) goto L_0x0221
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0223
        L_0x0221:
            r1 = r45
        L_0x0223:
            if (r16 == 0) goto L_0x0228
            r16 = r3
            goto L_0x022a
        L_0x0228:
            r16 = r4
        L_0x022a:
            if (r18 == 0) goto L_0x022f
            r34 = r33
            goto L_0x0231
        L_0x022f:
            r34 = r6
        L_0x0231:
            if (r20 == 0) goto L_0x0236
            r35 = r33
            goto L_0x0238
        L_0x0236:
            r35 = r7
        L_0x0238:
            if (r8 == 0) goto L_0x023d
            r36 = r33
            goto L_0x023f
        L_0x023d:
            r36 = r10
        L_0x023f:
            r4 = r0 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0251
            androidx.compose.material3.InputChipDefaults r4 = androidx.compose.material3.InputChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r9, r2)
            r6 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r55 & r6
            r37 = r4
            goto L_0x0255
        L_0x0251:
            r37 = r50
            r6 = r55
        L_0x0255:
            r4 = r0 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0266
            androidx.compose.material3.InputChipDefaults r4 = androidx.compose.material3.InputChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r4 = r4.inputChipColors(r9, r2)
            r7 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r7
            r38 = r4
            goto L_0x0268
        L_0x0266:
            r38 = r51
        L_0x0268:
            r39 = r6
            r4 = r0 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x028f
            r4 = r2
            androidx.compose.material3.InputChipDefaults r2 = androidx.compose.material3.InputChipDefaults.INSTANCE
            r10 = 1572864(0x180000, float:2.204052E-39)
            r11 = 63
            r6 = r3
            r3 = 0
            r7 = r4
            r4 = 0
            r5 = 0
            r8 = r6
            r6 = 0
            r18 = r7
            r7 = 0
            r20 = r8
            r8 = 0
            r45 = r1
            r1 = r18
            r40 = r19
            androidx.compose.material3.SelectableChipElevation r2 = r2.m2140inputChipElevationaqJV_2Y(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = r17 & -15
            goto L_0x0298
        L_0x028f:
            r45 = r1
            r1 = r2
            r40 = r19
            r2 = r52
            r3 = r17
        L_0x0298:
            r4 = r0 & 2048(0x800, float:2.87E-42)
            r17 = r16
            if (r4 == 0) goto L_0x02c6
            androidx.compose.material3.InputChipDefaults r16 = androidx.compose.material3.InputChipDefaults.INSTANCE
            int r4 = r39 >> 12
            r4 = r4 & 14
            r5 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r5
            int r5 = r39 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r30 = r4 | r5
            r31 = 252(0xfc, float:3.53E-43)
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = r9
            r18 = r12
            androidx.compose.foundation.BorderStroke r4 = r16.m2138inputChipBorder_7El2pE(r17, r18, r19, r21, r23, r25, r27, r28, r29, r30, r31)
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02c8
        L_0x02c6:
            r4 = r53
        L_0x02c8:
            if (r40 == 0) goto L_0x02d3
            r27 = r2
            r28 = r4
            r19 = r17
            r31 = r33
            goto L_0x02db
        L_0x02d3:
            r31 = r54
            r27 = r2
            r28 = r4
            r19 = r17
        L_0x02db:
            r22 = r34
            r7 = r35
            r24 = r36
            r25 = r37
            r26 = r38
            r2 = r39
            goto L_0x0216
        L_0x02e9:
            r9.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x02fa
            java.lang.String r4 = "androidx.compose.material3.InputChip (Chip.kt:643)"
            r5 = 1658928131(0x62e13c03, float:2.0774209E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x02fa:
            r4 = 417920884(0x18e8f774, float:6.022046E-24)
            r9.startReplaceGroup(r4)
            java.lang.String r4 = "649@31531L5,651@31584L419"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            if (r7 == 0) goto L_0x032d
            if (r19 == 0) goto L_0x030c
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x030f
        L_0x030c:
            r4 = 1052938076(0x3ec28f5c, float:0.38)
        L_0x030f:
            androidx.compose.material3.tokens.InputChipTokens r5 = androidx.compose.material3.tokens.InputChipTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r5 = r5.getAvatarShape()
            androidx.compose.ui.graphics.Shape r5 = androidx.compose.material3.ShapesKt.getValue(r5, r9, r1)
            androidx.compose.material3.ChipKt$InputChip$1 r6 = new androidx.compose.material3.ChipKt$InputChip$1
            r6.<init>(r4, r5, r7)
            r4 = 54
            r5 = 1154227507(0x44cc1d33, float:1632.9125)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r5, r8, r6, r9, r4)
            r33 = r4
            kotlin.jvm.functions.Function2 r33 = (kotlin.jvm.functions.Function2) r33
            goto L_0x032e
        L_0x032d:
            r8 = 1
        L_0x032e:
            r23 = r33
            r9.endReplaceGroup()
            androidx.compose.material3.tokens.InputChipTokens r4 = androidx.compose.material3.tokens.InputChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.getValue(r4, r9, r1)
            androidx.compose.material3.InputChipDefaults r1 = androidx.compose.material3.InputChipDefaults.INSTANCE
            float r29 = r1.m2136getHeightD9Ej5fM()
            r1 = 0
            if (r23 == 0) goto L_0x0348
            r4 = r8
            goto L_0x0349
        L_0x0348:
            r4 = r1
        L_0x0349:
            if (r22 == 0) goto L_0x034d
            r5 = r8
            goto L_0x034e
        L_0x034d:
            r5 = r1
        L_0x034e:
            if (r24 == 0) goto L_0x0351
            r1 = r8
        L_0x0351:
            androidx.compose.foundation.layout.PaddingValues r30 = inputChipPadding(r4, r5, r1)
            r1 = r2 & 14
            int r4 = r2 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            int r4 = r2 << 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r1 = r1 | r5
            int r5 = r2 >> 3
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r5
            int r5 = r2 << 6
            r6 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r6
            r1 = r1 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r4
            r1 = r1 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r5
            r33 = r1 | r4
            int r1 = r2 >> 27
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            int r2 = r3 << 3
            r4 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r3 << 9
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r34 = r1 | r2
            r16 = r42
            r20 = r44
            r32 = r9
            r18 = r13
            m1829SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03a3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03a3:
            r32 = r9
            r4 = r17
            r5 = r19
            r6 = r22
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r31
        L_0x03b7:
            androidx.compose.runtime.ScopeUpdateScope r1 = r32.endRestartGroup()
            if (r1 == 0) goto L_0x03d3
            androidx.compose.material3.ChipKt$InputChip$2 r0 = new androidx.compose.material3.ChipKt$InputChip$2
            r2 = r43
            r3 = r44
            r16 = r58
            r41 = r1
            r1 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x03d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.InputChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SuggestionChip(kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = -1700130831(0xffffffff9aaa0ff1, float:-7.0336107E-23)
            r1 = r42
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SuggestionChip)P(8,6,7,3,4,9,1,2)740@35497L5,741@35552L22,742@35631L25,743@35709L29,751@35977L5,746@35805L538:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r8.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r8.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r9 = r8.changedInstance(r7)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b6
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00b0
            r9 = r37
            boolean r10 = r8.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00b2
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r9 = r37
        L_0x00b2:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r10
            goto L_0x00b8
        L_0x00b6:
            r9 = r37
        L_0x00b8:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r11
            if (r10 != 0) goto L_0x00d2
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00cc
            r10 = r38
            boolean r15 = r8.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r10 = r38
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r15
            goto L_0x00d4
        L_0x00d2:
            r10 = r38
        L_0x00d4:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00f2
            r42 = r15
            r15 = r12 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00eb
            r15 = r39
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r15 = r39
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r16
            goto L_0x00f6
        L_0x00f2:
            r42 = r15
            r15 = r39
        L_0x00f6:
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x0112
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010b
            r0 = r40
            boolean r17 = r8.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x010d
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r0 = r40
        L_0x010d:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r17
            goto L_0x0114
        L_0x0112:
            r0 = r40
        L_0x0114:
            r17 = r2
            r2 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x011f
            r1 = r1 | r18
            goto L_0x0135
        L_0x011f:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0135
            r18 = r2
            r2 = r41
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0130
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r1 = r1 | r19
            goto L_0x0139
        L_0x0135:
            r18 = r2
            r2 = r41
        L_0x0139:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r19 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x015b
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x015b
        L_0x014c:
            r8.skipToGroupEnd()
            r4 = r5
            r5 = r7
            r29 = r8
            r6 = r9
            r7 = r10
            r8 = r15
            r9 = r40
            r10 = r2
            goto L_0x02c8
        L_0x015b:
            r8.startDefaults()
            r0 = r11 & 1
            r20 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r22 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x01a3
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0176
            goto L_0x01a3
        L_0x0176:
            r8.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0181
            r0 = r19 & r22
            r19 = r0
        L_0x0181:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0187
            r19 = r19 & r1
        L_0x0187:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018d
            r19 = r19 & r21
        L_0x018d:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0193
            r19 = r19 & r20
        L_0x0193:
            r25 = r40
            r28 = r41
            r0 = r2
            r20 = r7
            r22 = r9
            r24 = r15
            r1 = r19
            r15 = r5
            goto L_0x0246
        L_0x01a3:
            if (r17 == 0) goto L_0x01aa
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01ab
        L_0x01aa:
            r0 = r3
        L_0x01ab:
            if (r4 == 0) goto L_0x01b1
            r3 = 1
            r17 = r3
            goto L_0x01b3
        L_0x01b1:
            r17 = r5
        L_0x01b3:
            r23 = 0
            if (r6 == 0) goto L_0x01ba
            r24 = r23
            goto L_0x01bc
        L_0x01ba:
            r24 = r7
        L_0x01bc:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01cb
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r2)
            r4 = r19 & r22
            r19 = r3
            goto L_0x01cf
        L_0x01cb:
            r4 = r19
            r19 = r9
        L_0x01cf:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01dd
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.suggestionChipColors(r8, r2)
            r4 = r4 & r1
            r22 = r3
            goto L_0x01df
        L_0x01dd:
            r22 = r10
        L_0x01df:
            r25 = r4
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0200
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r15 = r7
            r7 = 0
            androidx.compose.material3.ChipElevation r1 = r1.m2535suggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r25 = r25 & r21
            r3 = r15
            r15 = r1
            goto L_0x0201
        L_0x0200:
            r3 = r2
        L_0x0201:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0223
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            int r2 = r25 >> 9
            r2 = r2 & 14
            r9 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = 14
            r5 = r3
            r3 = 0
            r7 = r5
            r5 = 0
            r2 = r7
            r7 = 0
            r34 = r0
            r0 = r2
            r2 = r17
            androidx.compose.foundation.BorderStroke r1 = r1.m2533suggestionChipBorderh1eTWw(r2, r3, r5, r7, r8, r9, r10)
            r3 = r25 & r20
            goto L_0x022c
        L_0x0223:
            r34 = r0
            r0 = r3
            r2 = r17
            r1 = r40
            r3 = r25
        L_0x022c:
            if (r18 == 0) goto L_0x0236
            r25 = r1
            r1 = r3
            r10 = r22
            r28 = r23
            goto L_0x023d
        L_0x0236:
            r28 = r41
            r25 = r1
            r1 = r3
            r10 = r22
        L_0x023d:
            r20 = r24
            r3 = r34
            r24 = r15
            r22 = r19
            r15 = r2
        L_0x0246:
            r8.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0258
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.SuggestionChip (Chip.kt:746)"
            r5 = -1700130831(0xffffffff9aaa0ff1, float:-7.0336107E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x0258:
            androidx.compose.material3.tokens.SuggestionChipTokens r2 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r2, r8, r0)
            long r18 = r10.m1818labelColorvNxB06k$material3_release(r15)
            androidx.compose.material3.SuggestionChipDefaults r0 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r0.m2530getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r0 = r1 >> 6
            r0 = r0 & 14
            r0 = r0 | r42
            int r2 = r1 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r2 = r1 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r1 << 6
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r4
            r0 = r0 | r2
            int r2 = r1 << 9
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r2
            r0 = r0 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r4
            r30 = r0 | r2
            int r0 = r1 >> 21
            r2 = r0 & 14
            r2 = r2 | 3456(0xd80, float:4.843E-42)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            int r1 = r1 >> 15
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r31 = r0 | r1
            r21 = 0
            r29 = r8
            r23 = r10
            r16 = r13
            r13 = r3
            m1827ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b8:
            r29 = r8
            r3 = r13
            r4 = r15
            r5 = r20
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r28
        L_0x02c8:
            androidx.compose.runtime.ScopeUpdateScope r13 = r29.endRestartGroup()
            if (r13 == 0) goto L_0x02dc
            androidx.compose.material3.ChipKt$SuggestionChip$1 r0 = new androidx.compose.material3.ChipKt$SuggestionChip$1
            r1 = r32
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0112  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void SuggestionChip(kotlin.jvm.functions.Function0 r32, kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = 170629701(0xa2b9a45, float:8.2623654E-33)
            r1 = r42
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SuggestionChip)P(8,6,7,3,4,9,1,2)824@39441L5,825@39496L22,826@39575L25,827@39651L22,828@39725L39,835@39946L5,830@39774L568:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r7.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r7.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r7.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r7.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r8 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009a
            r8 = r36
            boolean r9 = r7.changedInstance(r8)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r8 = r36
        L_0x009c:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b6
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00b0
            r9 = r37
            boolean r10 = r7.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00b2
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r9 = r37
        L_0x00b2:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r10
            goto L_0x00b8
        L_0x00b6:
            r9 = r37
        L_0x00b8:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r11
            if (r10 != 0) goto L_0x00d2
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00cc
            r10 = r38
            boolean r15 = r7.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r10 = r38
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r15
            goto L_0x00d4
        L_0x00d2:
            r10 = r38
        L_0x00d4:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00f2
            r42 = r15
            r15 = r12 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00eb
            r15 = r39
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r15 = r39
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r16
            goto L_0x00f6
        L_0x00f2:
            r42 = r15
            r15 = r39
        L_0x00f6:
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x0112
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010b
            r0 = r40
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x010d
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r0 = r40
        L_0x010d:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r17
            goto L_0x0114
        L_0x0112:
            r0 = r40
        L_0x0114:
            r17 = r2
            r2 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x011f
            r1 = r1 | r18
            goto L_0x0135
        L_0x011f:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0135
            r18 = r2
            r2 = r41
            boolean r19 = r7.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0130
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r1 = r1 | r19
            goto L_0x0139
        L_0x0135:
            r18 = r2
            r2 = r41
        L_0x0139:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r19 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x015b
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x015b
        L_0x014c:
            r7.skipToGroupEnd()
            r4 = r5
            r29 = r7
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r15
            r9 = r40
            r10 = r2
            goto L_0x0302
        L_0x015b:
            r7.startDefaults()
            r0 = r11 & 1
            r20 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r22 = -458753(0xfffffffffff8ffff, float:NaN)
            r23 = 0
            r2 = 6
            if (r0 == 0) goto L_0x01a6
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0178
            goto L_0x01a6
        L_0x0178:
            r7.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0183
            r0 = r19 & r22
            r19 = r0
        L_0x0183:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0189
            r19 = r19 & r1
        L_0x0189:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018f
            r19 = r19 & r21
        L_0x018f:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0195
            r19 = r19 & r20
        L_0x0195:
            r1 = r40
            r28 = r41
            r20 = r8
            r22 = r9
            r0 = r10
            r24 = r15
            r10 = r2
            r15 = r5
            r2 = r19
            goto L_0x025a
        L_0x01a6:
            if (r17 == 0) goto L_0x01ad
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01ae
        L_0x01ad:
            r0 = r3
        L_0x01ae:
            if (r4 == 0) goto L_0x01b4
            r3 = 1
            r17 = r3
            goto L_0x01b6
        L_0x01b4:
            r17 = r5
        L_0x01b6:
            if (r6 == 0) goto L_0x01bb
            r24 = r23
            goto L_0x01bd
        L_0x01bb:
            r24 = r8
        L_0x01bd:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01cc
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r7, r2)
            r4 = r19 & r22
            r19 = r3
            goto L_0x01d0
        L_0x01cc:
            r4 = r19
            r19 = r9
        L_0x01d0:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01de
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.suggestionChipColors(r7, r2)
            r4 = r4 & r1
            r22 = r3
            goto L_0x01e0
        L_0x01de:
            r22 = r10
        L_0x01e0:
            r25 = r4
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0205
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r8 = r6
            r6 = 0
            r29 = r7
            r7 = 0
            r15 = r8
            r8 = r29
            androidx.compose.material3.ChipElevation r1 = r1.m2535suggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r25 = r25 & r21
            r10 = r15
            r15 = r1
            goto L_0x0208
        L_0x0205:
            r10 = r2
            r29 = r7
        L_0x0208:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0221
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r8 = 3072(0xc00, float:4.305E-42)
            r9 = 7
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = r29
            androidx.compose.material3.ChipBorder r1 = r1.m2532suggestionChipBorderd_3_b6Q(r2, r4, r6, r7, r8, r9)
            r2 = r25 & r20
            r25 = r2
            goto L_0x0225
        L_0x0221:
            r7 = r29
            r1 = r40
        L_0x0225:
            if (r18 == 0) goto L_0x024b
            r2 = 1248029210(0x4a636a1a, float:3725958.5)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r3)
            java.lang.Object r2 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0242
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r2)
        L_0x0242:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r3 = r0
            r28 = r2
            goto L_0x024e
        L_0x024b:
            r28 = r41
            r3 = r0
        L_0x024e:
            r0 = r22
            r20 = r24
            r2 = r25
            r24 = r15
            r15 = r17
            r22 = r19
        L_0x025a:
            r7.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x026c
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.SuggestionChip (Chip.kt:830)"
            r6 = 170629701(0xa2b9a45, float:8.2623654E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r4, r5)
        L_0x026c:
            androidx.compose.material3.tokens.SuggestionChipTokens r4 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r4, r7, r10)
            long r18 = r0.m1818labelColorvNxB06k$material3_release(r15)
            r4 = 1248043208(0x4a63a0c8, float:3729458.0)
            r7.startReplaceGroup(r4)
            java.lang.String r4 = "842@40163L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            if (r1 != 0) goto L_0x028a
            r4 = r23
            goto L_0x0297
        L_0x028a:
            int r4 = r2 >> 9
            r4 = r4 & 14
            int r5 = r2 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            androidx.compose.runtime.State r4 = r1.borderStroke$material3_release(r15, r7, r4)
        L_0x0297:
            r7.endReplaceGroup()
            if (r4 == 0) goto L_0x02a4
            java.lang.Object r4 = r4.getValue()
            r23 = r4
            androidx.compose.foundation.BorderStroke r23 = (androidx.compose.foundation.BorderStroke) r23
        L_0x02a4:
            r25 = r23
            androidx.compose.material3.SuggestionChipDefaults r4 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r4.m2530getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r4 = r2 >> 6
            r4 = r4 & 14
            r4 = r4 | r42
            int r5 = r2 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r2 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r2 << 6
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r6
            r4 = r4 | r5
            int r5 = r2 << 9
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r5
            r4 = r4 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r6
            r30 = r4 | r5
            int r4 = r2 >> 21
            r4 = r4 & 14
            r4 = r4 | 3456(0xd80, float:4.843E-42)
            int r2 = r2 >> 15
            r5 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r5
            r31 = r4 | r2
            r21 = 0
            r23 = r0
            r29 = r7
            r16 = r13
            r13 = r3
            m1827ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02f5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02f5:
            r9 = r1
            r3 = r13
            r4 = r15
            r5 = r20
            r6 = r22
            r7 = r23
            r8 = r24
            r10 = r28
        L_0x0302:
            androidx.compose.runtime.ScopeUpdateScope r13 = r29.endRestartGroup()
            if (r13 == 0) goto L_0x0316
            androidx.compose.material3.ChipKt$SuggestionChip$3 r0 = new androidx.compose.material3.ChipKt$SuggestionChip$3
            r1 = r32
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0316:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedSuggestionChip(kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = -818834969(0xffffffffcf3191e7, float:-2.97912909E9)
            r1 = r42
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)897@43055L5,898@43110L30,899@43197L33,908@43503L5,903@43331L538:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r8.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r8.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r9 = r8.changedInstance(r7)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b6
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00b0
            r9 = r37
            boolean r10 = r8.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00b2
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r9 = r37
        L_0x00b2:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r10
            goto L_0x00b8
        L_0x00b6:
            r9 = r37
        L_0x00b8:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r11
            if (r10 != 0) goto L_0x00d2
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00cc
            r10 = r38
            boolean r15 = r8.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r10 = r38
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r15
            goto L_0x00d4
        L_0x00d2:
            r10 = r38
        L_0x00d4:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00f2
            r42 = r15
            r15 = r12 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00eb
            r15 = r39
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r15 = r39
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r16
            goto L_0x00f6
        L_0x00f2:
            r42 = r15
            r15 = r39
        L_0x00f6:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00ff
            r1 = r1 | r17
            goto L_0x0115
        L_0x00ff:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0115
            r17 = r2
            r2 = r40
            boolean r18 = r8.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0110
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0110:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r1 = r1 | r18
            goto L_0x0119
        L_0x0115:
            r17 = r2
            r2 = r40
        L_0x0119:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0122
            r1 = r1 | r18
            goto L_0x0138
        L_0x0122:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0138
            r18 = r2
            r2 = r41
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0133
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0135
        L_0x0133:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0135:
            r1 = r1 | r19
            goto L_0x013c
        L_0x0138:
            r18 = r2
            r2 = r41
        L_0x013c:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r20 = r0
            r0 = r1 & r19
            r19 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0160
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0151
            goto L_0x0160
        L_0x0151:
            r8.skipToGroupEnd()
            r4 = r5
            r5 = r7
            r29 = r8
            r6 = r9
            r7 = r10
            r8 = r15
            r9 = r40
            r10 = r2
            goto L_0x02a1
        L_0x0160:
            r8.startDefaults()
            r0 = r11 & 1
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r22 = -458753(0xfffffffffff8ffff, float:NaN)
            r2 = 6
            if (r0 == 0) goto L_0x01a0
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0178
            goto L_0x01a0
        L_0x0178:
            r8.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0183
            r0 = r19 & r22
            r19 = r0
        L_0x0183:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0189
            r19 = r19 & r1
        L_0x0189:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018f
            r19 = r19 & r21
        L_0x018f:
            r25 = r40
            r28 = r41
            r0 = r3
            r20 = r7
            r22 = r9
            r24 = r15
            r1 = r19
            r3 = r2
            r15 = r5
            goto L_0x021f
        L_0x01a0:
            if (r17 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a8
        L_0x01a7:
            r0 = r3
        L_0x01a8:
            if (r4 == 0) goto L_0x01ae
            r3 = 1
            r17 = r3
            goto L_0x01b0
        L_0x01ae:
            r17 = r5
        L_0x01b0:
            r23 = 0
            if (r6 == 0) goto L_0x01b7
            r24 = r23
            goto L_0x01b9
        L_0x01b7:
            r24 = r7
        L_0x01b9:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01c8
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r2)
            r4 = r19 & r22
            r19 = r3
            goto L_0x01cc
        L_0x01c8:
            r4 = r19
            r19 = r9
        L_0x01cc:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01da
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedSuggestionChipColors(r8, r2)
            r4 = r4 & r1
            r22 = r3
            goto L_0x01dc
        L_0x01da:
            r22 = r10
        L_0x01dc:
            r25 = r4
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ff
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r15 = r7
            r7 = 0
            androidx.compose.material3.ChipElevation r1 = r1.m2529elevatedSuggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r25 & r21
            r25 = r2
            r3 = r15
            r15 = r1
            goto L_0x0200
        L_0x01ff:
            r3 = r2
        L_0x0200:
            if (r20 == 0) goto L_0x0205
            r1 = r23
            goto L_0x0207
        L_0x0205:
            r1 = r40
        L_0x0207:
            r10 = r25
            r25 = r1
            r1 = r10
            if (r18 == 0) goto L_0x0213
            r10 = r22
            r28 = r23
            goto L_0x0217
        L_0x0213:
            r28 = r41
            r10 = r22
        L_0x0217:
            r20 = r24
            r24 = r15
            r15 = r17
            r22 = r19
        L_0x021f:
            r8.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0231
            r2 = -1
            java.lang.String r4 = "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:903)"
            r5 = -818834969(0xffffffffcf3191e7, float:-2.97912909E9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r1, r2, r4)
        L_0x0231:
            androidx.compose.material3.tokens.SuggestionChipTokens r2 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r2, r8, r3)
            long r18 = r10.m1818labelColorvNxB06k$material3_release(r15)
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r2.m2530getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r2 = r1 >> 6
            r2 = r2 & 14
            r2 = r2 | r42
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r1 >> 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 << 6
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 << 9
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r3
            r2 = r2 | r4
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r30 = r2 | r3
            int r2 = r1 >> 21
            r3 = r2 & 14
            r3 = r3 | 3456(0xd80, float:4.843E-42)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r1 = r1 >> 15
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r31 = r2 | r1
            r21 = 0
            r29 = r8
            r23 = r10
            r16 = r13
            r13 = r0
            m1827ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0291
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0291:
            r29 = r8
            r3 = r13
            r4 = r15
            r5 = r20
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r28
        L_0x02a1:
            androidx.compose.runtime.ScopeUpdateScope r13 = r29.endRestartGroup()
            if (r13 == 0) goto L_0x02b5
            androidx.compose.material3.ChipKt$ElevatedSuggestionChip$1 r0 = new androidx.compose.material3.ChipKt$ElevatedSuggestionChip$1
            r1 = r32
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void ElevatedSuggestionChip(kotlin.jvm.functions.Function0 r32, kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = 1668751803(0x637721bb, float:4.5587763E21)
            r1 = r42
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)980@46960L5,981@47015L30,982@47102L33,984@47219L39,991@47440L5,986@47268L568:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r8.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r8.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r8.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r9 = r8.changedInstance(r7)
            if (r9 == 0) goto L_0x0096
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r9
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b6
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00b0
            r9 = r37
            boolean r10 = r8.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00b2
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r9 = r37
        L_0x00b2:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r10
            goto L_0x00b8
        L_0x00b6:
            r9 = r37
        L_0x00b8:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r11
            if (r10 != 0) goto L_0x00d2
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00cc
            r10 = r38
            boolean r15 = r8.changed((java.lang.Object) r10)
            if (r15 == 0) goto L_0x00ce
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r10 = r38
        L_0x00ce:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r15
            goto L_0x00d4
        L_0x00d2:
            r10 = r38
        L_0x00d4:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r11 & r15
            if (r16 != 0) goto L_0x00f2
            r42 = r15
            r15 = r12 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00eb
            r15 = r39
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r15 = r39
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r16
            goto L_0x00f6
        L_0x00f2:
            r42 = r15
            r15 = r39
        L_0x00f6:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00ff
            r1 = r1 | r17
            goto L_0x0115
        L_0x00ff:
            r17 = r11 & r17
            if (r17 != 0) goto L_0x0115
            r17 = r2
            r2 = r40
            boolean r18 = r8.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0110
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0110:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r1 = r1 | r18
            goto L_0x0119
        L_0x0115:
            r17 = r2
            r2 = r40
        L_0x0119:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0122
            r1 = r1 | r18
            goto L_0x0138
        L_0x0122:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x0138
            r18 = r2
            r2 = r41
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0133
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0135
        L_0x0133:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0135:
            r1 = r1 | r19
            goto L_0x013c
        L_0x0138:
            r18 = r2
            r2 = r41
        L_0x013c:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r20 = r0
            r0 = r1 & r19
            r19 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0160
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0151
            goto L_0x0160
        L_0x0151:
            r8.skipToGroupEnd()
            r4 = r5
            r5 = r7
            r29 = r8
            r6 = r9
            r7 = r10
            r8 = r15
            r9 = r40
            r10 = r2
            goto L_0x02e4
        L_0x0160:
            r8.startDefaults()
            r0 = r11 & 1
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r22 = -458753(0xfffffffffff8ffff, float:NaN)
            r23 = 0
            r2 = 6
            if (r0 == 0) goto L_0x01a2
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x017a
            goto L_0x01a2
        L_0x017a:
            r8.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0185
            r0 = r19 & r22
            r19 = r0
        L_0x0185:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x018b
            r19 = r19 & r1
        L_0x018b:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0191
            r19 = r19 & r21
        L_0x0191:
            r1 = r40
            r28 = r41
            r0 = r3
            r20 = r7
            r22 = r9
            r24 = r15
            r3 = r2
            r15 = r5
            r2 = r19
            goto L_0x023a
        L_0x01a2:
            if (r17 == 0) goto L_0x01a9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01aa
        L_0x01a9:
            r0 = r3
        L_0x01aa:
            if (r4 == 0) goto L_0x01b0
            r3 = 1
            r17 = r3
            goto L_0x01b2
        L_0x01b0:
            r17 = r5
        L_0x01b2:
            if (r6 == 0) goto L_0x01b7
            r24 = r23
            goto L_0x01b9
        L_0x01b7:
            r24 = r7
        L_0x01b9:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x01c8
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r8, r2)
            r4 = r19 & r22
            r19 = r3
            goto L_0x01cc
        L_0x01c8:
            r4 = r19
            r19 = r9
        L_0x01cc:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01da
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedSuggestionChipColors(r8, r2)
            r4 = r4 & r1
            r22 = r3
            goto L_0x01dc
        L_0x01da:
            r22 = r10
        L_0x01dc:
            r25 = r4
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ff
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r10 = 63
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r15 = r7
            r7 = 0
            androidx.compose.material3.ChipElevation r1 = r1.m2529elevatedSuggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r25 & r21
            r25 = r2
            r3 = r15
            r15 = r1
            goto L_0x0200
        L_0x01ff:
            r3 = r2
        L_0x0200:
            if (r20 == 0) goto L_0x0205
            r1 = r23
            goto L_0x0207
        L_0x0205:
            r1 = r40
        L_0x0207:
            if (r18 == 0) goto L_0x022c
            r2 = 2121795492(0x7e7807a4, float:8.2422054E37)
            java.lang.String r4 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r4)
            java.lang.Object r2 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0224
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r2)
        L_0x0224:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r28 = r2
            goto L_0x022e
        L_0x022c:
            r28 = r41
        L_0x022e:
            r10 = r22
            r20 = r24
            r2 = r25
            r24 = r15
            r15 = r17
            r22 = r19
        L_0x023a:
            r8.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x024c
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:986)"
            r6 = 1668751803(0x637721bb, float:4.5587763E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r4, r5)
        L_0x024c:
            androidx.compose.material3.tokens.SuggestionChipTokens r4 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r4 = r4.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.getValue(r4, r8, r3)
            long r18 = r10.m1818labelColorvNxB06k$material3_release(r15)
            androidx.compose.material3.SuggestionChipDefaults r3 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r3.m2530getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            r3 = 2121812626(0x7e784a92, float:8.2508934E37)
            r8.startReplaceGroup(r3)
            java.lang.String r3 = "1000@47755L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            if (r1 != 0) goto L_0x0272
            r3 = r23
            goto L_0x027f
        L_0x0272:
            int r3 = r2 >> 9
            r3 = r3 & 14
            int r4 = r2 >> 21
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r3 = r1.borderStroke$material3_release(r15, r8, r3)
        L_0x027f:
            r8.endReplaceGroup()
            if (r3 == 0) goto L_0x028c
            java.lang.Object r3 = r3.getValue()
            r23 = r3
            androidx.compose.foundation.BorderStroke r23 = (androidx.compose.foundation.BorderStroke) r23
        L_0x028c:
            r25 = r23
            int r3 = r2 >> 6
            r3 = r3 & 14
            r3 = r3 | r42
            int r4 = r2 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            int r4 = r2 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            int r4 = r2 << 6
            r5 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r5
            r3 = r3 | r4
            int r4 = r2 << 9
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r4
            r3 = r3 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r5
            r30 = r3 | r4
            int r3 = r2 >> 21
            r3 = r3 & 14
            r3 = r3 | 3456(0xd80, float:4.843E-42)
            int r2 = r2 >> 15
            r4 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r4
            r31 = r3 | r2
            r21 = 0
            r29 = r8
            r23 = r10
            r16 = r13
            r13 = r0
            m1827ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d5:
            r9 = r1
            r29 = r8
            r3 = r13
            r4 = r15
            r5 = r20
            r6 = r22
            r7 = r23
            r8 = r24
            r10 = r28
        L_0x02e4:
            androidx.compose.runtime.ScopeUpdateScope r13 = r29.endRestartGroup()
            if (r13 == 0) goto L_0x02f8
            androidx.compose.material3.ChipKt$ElevatedSuggestionChip$3 r0 = new androidx.compose.material3.ChipKt$ElevatedSuggestionChip$3
            r1 = r32
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x02f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs  reason: not valid java name */
    public static final void m1827ChipnkUnTEs(Modifier modifier, Function0<Unit> function0, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Composer composer2;
        Modifier modifier2 = modifier;
        boolean z2 = z;
        ChipColors chipColors2 = chipColors;
        ChipElevation chipElevation2 = chipElevation;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        int i5 = i;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1975@97230L477,1966@96860L847:Chip.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        } else {
            Function0<Unit> function02 = function0;
        }
        int i7 = 256;
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        int i8 = 2048;
        if ((i5 & 3072) == 0) {
            function24 = function2;
            i3 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        int i9 = 16384;
        if ((i5 & 24576) == 0) {
            i3 |= startRestartGroup.changed((Object) textStyle) ? 16384 : 8192;
        } else {
            TextStyle textStyle2 = textStyle;
        }
        long j2 = j;
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        Shape shape2 = shape;
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i3 |= startRestartGroup.changed((Object) chipColors2) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i4 = i6 | (startRestartGroup.changed((Object) chipElevation2) ? 4 : 2);
        } else {
            i4 = i6;
        }
        BorderStroke borderStroke2 = borderStroke;
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) borderStroke2) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            if (!startRestartGroup.changed(f)) {
                i7 = 128;
            }
            i4 |= i7;
        } else {
            float f2 = f;
        }
        if ((i6 & 3072) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues)) {
                i8 = 1024;
            }
            i4 |= i8;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i6 & 24576) == 0) {
            if (!startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i9 = 8192;
            }
            i4 |= i9;
        }
        int i10 = i4;
        if ((i3 & 306783379) == 306783378 && (i10 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, i3, i10, "androidx.compose.material3.Chip (Chip.kt:1963)");
            }
            startRestartGroup.startReplaceGroup(1985614987);
            ComposerKt.sourceInformation(startRestartGroup, "1965@96816L39");
            if (mutableInteractionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1985615638, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            }
            startRestartGroup.endReplaceGroup();
            int i11 = i10;
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$Chip$1.INSTANCE, 1, (Object) null);
            long r18 = chipColors2.m1808containerColorvNxB06k$material3_release(z2);
            startRestartGroup.startReplaceGroup(1985624506);
            ComposerKt.sourceInformation(startRestartGroup, "1972@97093L43");
            if (chipElevation2 != null) {
                state = chipElevation2.shadowElevation$material3_release(z2, mutableInteractionSource2, startRestartGroup, ((i3 >> 6) & 14) | ((i11 << 6) & 896));
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            int i12 = i3;
            SurfaceKt.m2539Surfaceo_FOJdg(function0, semantics$default, z, shape, r18, 0, 0.0f, state != null ? state.getValue().m7125unboximpl() : Dp.m7111constructorimpl((float) 0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-1985962652, true, new ChipKt$Chip$2(function24, textStyle, j, function25, function26, chipColors2, z2, f, paddingValues), composer2, 54), composer2, ((i12 >> 15) & 7168) | ((i12 >> 3) & 14) | (i12 & 896) | ((i11 << 21) & 234881024), 6, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$Chip$3(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE  reason: not valid java name */
    public static final void m1829SelectableChipu0RnIRE(boolean z, Modifier modifier, Function0<Unit> function0, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        boolean z3 = z;
        Modifier modifier2 = modifier;
        boolean z4 = z2;
        SelectableChipColors selectableChipColors2 = selectableChipColors;
        SelectableChipElevation selectableChipElevation2 = selectableChipElevation;
        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
        int i5 = i;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)2023@98879L525,2013@98468L936:Chip.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier2) ? 32 : 16;
        }
        int i7 = 256;
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        } else {
            Function0<Unit> function02 = function0;
        }
        int i8 = 2048;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        int i9 = 16384;
        if ((i5 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        }
        int i10 = 131072;
        TextStyle textStyle2 = textStyle;
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changed((Object) textStyle2) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i5 & 805306368;
        Shape shape2 = shape;
        if (i11 == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i4 = i6 | (startRestartGroup.changed((Object) selectableChipColors2) ? 4 : 2);
        } else {
            i4 = i6;
        }
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) selectableChipElevation2) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            if (!startRestartGroup.changed((Object) borderStroke)) {
                i7 = 128;
            }
            i4 |= i7;
        } else {
            BorderStroke borderStroke2 = borderStroke;
        }
        if ((i6 & 3072) == 0) {
            if (!startRestartGroup.changed(f)) {
                i8 = 1024;
            }
            i4 |= i8;
        } else {
            float f2 = f;
        }
        if ((i6 & 24576) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues)) {
                i9 = 8192;
            }
            i4 |= i9;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i6 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (!startRestartGroup.changed((Object) mutableInteractionSource3)) {
                i10 = 65536;
            }
            i4 |= i10;
        }
        int i12 = i4;
        if ((i3 & 306783379) == 306783378 && (74899 & i12) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i3, i12, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
            }
            startRestartGroup.startReplaceGroup(2072749057);
            ComposerKt.sourceInformation(startRestartGroup, "2011@98346L39");
            if (mutableInteractionSource == null) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2072749708, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
            }
            startRestartGroup.endReplaceGroup();
            int i13 = i12;
            int i14 = i3;
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$SelectableChip$1.INSTANCE, 1, (Object) null);
            long r19 = selectableChipColors2.m2444containerColorWaAFU9c$material3_release(z4, z3);
            startRestartGroup.startReplaceGroup(2072762384);
            ComposerKt.sourceInformation(startRestartGroup, "2020@98742L43");
            if (selectableChipElevation2 != null) {
                state = selectableChipElevation2.shadowElevation$material3_release(z4, mutableInteractionSource2, startRestartGroup, ((i14 >> 9) & 14) | ((i13 << 3) & 896));
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            int i15 = i14;
            SurfaceKt.m2537Surfaced85dljk(z, function0, semantics$default, z2, shape, r19, 0, 0.0f, state != null ? state.getValue().m7125unboximpl() : Dp.m7111constructorimpl((float) 0), borderStroke, mutableInteractionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-577614814, true, new ChipKt$SelectableChip$2(selectableChipColors2, z4, z, function2, textStyle2, function26, function27, function24, f, paddingValues), composer2, 54), composer2, (i15 & 14) | ((i15 >> 3) & 112) | (i15 & 7168) | ((i15 >> 15) & 57344) | ((i13 << 21) & 1879048192), 48, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$SelectableChip$3(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1828ChipContentfe0OD_I(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j2, long j3, float f, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        long j4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j5;
        int i3;
        TextStyle textStyle2 = textStyle;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)2055@99907L3519,2052@99781L3645:Chip.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i4;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = function2;
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            j4 = j;
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i4 & 3072) == 0) {
            function25 = function22;
            i2 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i4 & 24576) == 0) {
            function26 = function23;
            i2 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i4) == 0) {
            function27 = function24;
            i2 |= startRestartGroup.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & i4) == 0) {
            j5 = j2;
            i2 |= startRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i4) == 0) {
            i3 = i2 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
            long j6 = j3;
        }
        if ((100663296 & i4) == 0) {
            i3 |= startRestartGroup.changed(f) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            float f2 = f;
        }
        PaddingValues paddingValues2 = paddingValues;
        if ((i4 & 805306368) == 0) {
            i3 |= startRestartGroup.changed((Object) paddingValues2) ? 536870912 : 268435456;
        }
        if ((i3 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle2)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1748799148, true, new ChipKt$ChipContent$1(f, paddingValues, function26, function25, function27, j5, function2, j3), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$ChipContent$2(function2, textStyle2, j4, function22, function23, function24, j2, j3, f, paddingValues, i4));
        }
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ChipColors defaultSuggestionChipColorsCached$material3_release = colorScheme2.getDefaultSuggestionChipColorsCached$material3_release();
        if (defaultSuggestionChipColorsCached$material3_release != null) {
            return defaultSuggestionChipColorsCached$material3_release;
        }
        ChipColors chipColors = new ChipColors(Color.Companion.m4274getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.m4275getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultSuggestionChipColorsCached$material3_release(chipColors);
        return chipColors;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m772PaddingValuesa9UjIt4$default(Dp.m7111constructorimpl((z || !z2) ? (float) 4 : (float) 8), 0.0f, Dp.m7111constructorimpl(z3 ? (float) 8 : (float) 4), 0.0f, 10, (Object) null);
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 8);
        HorizontalElementsPadding = r0;
        AssistChipPadding = PaddingKt.m770PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        FilterChipPadding = PaddingKt.m770PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        SuggestionChipPadding = PaddingKt.m770PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
    }
}
