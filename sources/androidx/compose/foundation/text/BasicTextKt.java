package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010!\u001a°\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001a\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207062\b\u00108\u001a\u0004\u0018\u000109H\u0002\u001aÂ\u0001\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0014\u0010;\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010-2\u001c\u0010>\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010?0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0003X\u0002"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v2, resolved type: androidx.compose.runtime.saveable.Saver<java.lang.Long, java.lang.Long>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0428  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1166BasicTextVhcvRP8(java.lang.String r44, androidx.compose.ui.Modifier r45, androidx.compose.ui.text.TextStyle r46, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r47, int r48, boolean r49, int r50, int r51, androidx.compose.ui.graphics.ColorProducer r52, androidx.compose.runtime.Composer r53, int r54, int r55) {
        /*
            r10 = r54
            r11 = r55
            r0 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            r1 = r53
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)101@5004L7,151@6858L41:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r13 = r44
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r13 = r44
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((java.lang.Object) r13)
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
            r4 = r45
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
            r4 = r45
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r46
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r46
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r47
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
            r8 = r47
        L_0x0081:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009b
            r12 = r48
            boolean r14 = r1.changed((int) r12)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r12 = r48
        L_0x009d:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b8
            r15 = r49
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r49
        L_0x00ba:
            r16 = r11 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c5
            r2 = r2 | r17
            r0 = r50
            goto L_0x00d8
        L_0x00c5:
            r17 = r10 & r17
            r0 = r50
            if (r17 != 0) goto L_0x00d8
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00d4
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r18
        L_0x00d8:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r2 = r2 | r18
            goto L_0x00f7
        L_0x00e1:
            r18 = r10 & r18
            if (r18 != 0) goto L_0x00f7
            r18 = r0
            r0 = r51
            boolean r19 = r1.changed((int) r0)
            if (r19 == 0) goto L_0x00f2
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r19
            goto L_0x00fb
        L_0x00f7:
            r18 = r0
            r0 = r51
        L_0x00fb:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r2 = r2 | r19
            goto L_0x011a
        L_0x0104:
            r19 = r10 & r19
            if (r19 != 0) goto L_0x011a
            r19 = r0
            r0 = r52
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x0115
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r2 = r2 | r20
            goto L_0x011e
        L_0x011a:
            r19 = r0
            r0 = r52
        L_0x011e:
            r20 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r20
            r53 = r3
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x0142
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0131
            goto L_0x0142
        L_0x0131:
            r1.skipToGroupEnd()
            r7 = r50
            r9 = r52
            r0 = r1
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r12
            r6 = r15
            r8 = r51
            goto L_0x0422
        L_0x0142:
            if (r53 == 0) goto L_0x014b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r20 = r0
            goto L_0x014d
        L_0x014b:
            r20 = r4
        L_0x014d:
            if (r5 == 0) goto L_0x0156
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r6 = r0
        L_0x0156:
            r0 = 0
            if (r7 == 0) goto L_0x015a
            r8 = r0
        L_0x015a:
            if (r9 == 0) goto L_0x0163
            androidx.compose.ui.text.style.TextOverflow$Companion r3 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r3 = r3.m7037getClipgIe3tQ8()
            r12 = r3
        L_0x0163:
            r3 = 1
            if (r14 == 0) goto L_0x0167
            r15 = r3
        L_0x0167:
            if (r16 == 0) goto L_0x016d
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x016f
        L_0x016d:
            r4 = r50
        L_0x016f:
            if (r18 == 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r3 = r51
        L_0x0174:
            if (r19 == 0) goto L_0x0178
            r5 = r0
            goto L_0x017a
        L_0x0178:
            r5 = r52
        L_0x017a:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0189
            r7 = -1
            java.lang.String r9 = "androidx.compose.foundation.text.BasicText (BasicText.kt:96)"
            r14 = -1186827822(0xffffffffb94271d2, float:-1.8543683E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r2, r7, r9)
        L_0x0189:
            androidx.compose.foundation.text.HeightInLinesModifierKt.validateMinMaxLines(r3, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r9)
            java.lang.Object r2 = r1.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.foundation.text.selection.SelectionRegistrar r2 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r2
            if (r2 == 0) goto L_0x0267
            r0 = -1589202404(0xffffffffa146b21c, float:-6.7320735E-19)
            r1.startReplaceGroup(r0)
            java.lang.String r0 = "103@5140L7,105@5286L69,105@5203L152,108@5364L234"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r9)
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            r43 = r8
            long r7 = r0.m1672getBackgroundColor0d7_KjU()
            java.lang.Object[] r0 = new java.lang.Object[]{r2}
            androidx.compose.runtime.saveable.Saver r16 = selectionIdSaver(r2)
            r14 = -328352935(0xffffffffec6dbb59, float:-1.1496006E27)
            r45 = r0
            java.lang.String r0 = "CC(remember):BasicText.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r0)
            boolean r14 = r1.changedInstance(r2)
            r19 = r3
            java.lang.Object r3 = r1.rememberedValue()
            if (r14 != 0) goto L_0x01ee
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r3 != r14) goto L_0x01f8
        L_0x01ee:
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1 r3 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
            r3.<init>(r2)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r1.updateRememberedValue(r3)
        L_0x01f8:
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r14 = 0
            r18 = 4
            r21 = 0
            r49 = r1
            r48 = r3
            r50 = r14
            r46 = r16
            r51 = r18
            r47 = r21
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r45, r46, (java.lang.String) r47, r48, (androidx.compose.runtime.Composer) r49, (int) r50, (int) r51)
            r3 = r49
            java.lang.Number r1 = (java.lang.Number) r1
            r18 = r4
            r14 = r5
            long r4 = r1.longValue()
            r1 = -328350274(0xffffffffec6dc5be, float:-1.1497969E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r0)
            boolean r0 = r3.changed((long) r4)
            boolean r1 = r3.changed((java.lang.Object) r2)
            r0 = r0 | r1
            boolean r1 = r3.changed((long) r7)
            r0 = r0 | r1
            java.lang.Object r1 = r3.rememberedValue()
            if (r0 != 0) goto L_0x023f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x025d
        L_0x023f:
            androidx.compose.foundation.text.modifiers.SelectionController r0 = new androidx.compose.foundation.text.modifiers.SelectionController
            r1 = 8
            r16 = 0
            r21 = 0
            r45 = r0
            r52 = r1
            r48 = r2
            r46 = r4
            r49 = r7
            r53 = r16
            r51 = r21
            r45.<init>(r46, r48, r49, r51, r52, r53)
            r1 = r45
            r3.updateRememberedValue(r1)
        L_0x025d:
            r0 = r1
            androidx.compose.foundation.text.modifiers.SelectionController r0 = (androidx.compose.foundation.text.modifiers.SelectionController) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endReplaceGroup()
            goto L_0x0278
        L_0x0267:
            r19 = r3
            r18 = r4
            r14 = r5
            r43 = r8
            r3 = r1
            r1 = -1588686502(0xffffffffa14e915a, float:-6.9987886E-19)
            r3.startReplaceGroup(r1)
            r3.endReplaceGroup()
        L_0x0278:
            if (r0 != 0) goto L_0x02ee
            if (r43 == 0) goto L_0x027e
            goto L_0x02ee
        L_0x027e:
            r0 = -1587866335(0xffffffffa15b1521, float:-7.422805E-19)
            r3.startReplaceGroup(r0)
            java.lang.String r0 = "143@6671L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            r41 = 131071(0x1ffff, float:1.8367E-40)
            r42 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34, r35, r36, r38, r40, r41, r42)
            r25 = r12
            r4 = r20
            androidx.compose.foundation.text.modifiers.TextStringSimpleElement r12 = new androidx.compose.foundation.text.modifiers.TextStringSimpleElement
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r9)
            java.lang.Object r1 = r3.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.text.font.FontFamily$Resolver r1 = (androidx.compose.ui.text.font.FontFamily.Resolver) r1
            r21 = 0
            r20 = r14
            r17 = r15
            r16 = r25
            r15 = r1
            r14 = r6
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r1 = r20
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            androidx.compose.ui.Modifier r0 = r0.then(r12)
            r3.endReplaceGroup()
            r14 = r1
            r20 = r4
            r24 = r43
            goto L_0x0378
        L_0x02ee:
            r16 = r12
            r1 = r14
            r17 = r15
            r4 = r20
            r2 = -1588564052(0xffffffffa1506fac, float:-7.062094E-19)
            r3.startReplaceGroup(r2)
            java.lang.String r2 = "130@6178L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r2)
            r41 = 131071(0x1ffff, float:1.8367E-40)
            r42 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r20 = r4
            androidx.compose.ui.Modifier r21 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34, r35, r36, r38, r40, r41, r42)
            androidx.compose.ui.text.AnnotatedString r22 = new androidx.compose.ui.text.AnnotatedString
            r2 = 6
            r4 = 0
            r5 = 0
            r7 = 0
            r46 = r44
            r49 = r2
            r50 = r4
            r47 = r5
            r48 = r7
            r45 = r22
            r45.<init>(r46, r47, r48, r49, r50)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r14, r9)
            java.lang.Object r2 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r29 = r2
            androidx.compose.ui.text.font.FontFamily$Resolver r29 = (androidx.compose.ui.text.font.FontFamily.Resolver) r29
            r31 = 0
            r34 = 0
            r30 = 0
            r32 = r0
            r33 = r1
            r23 = r6
            r25 = r16
            r26 = r17
            r27 = r18
            r28 = r19
            r24 = r43
            androidx.compose.ui.Modifier r0 = m1169textModifiercFh6CEA(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r14 = r33
            r3.endReplaceGroup()
        L_0x0378:
            androidx.compose.foundation.text.EmptyMeasurePolicy r1 = androidx.compose.foundation.text.EmptyMeasurePolicy.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            r2 = 544976794(0x207baf9a, float:2.1318629E-19)
            java.lang.String r4 = "CC(Layout)P(1)125@4862L23,128@5013L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r2, r4)
            r2 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r2)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r3, r0)
            androidx.compose.runtime.CompositionLocalMap r4 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r7 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            java.lang.String r8 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r8)
            androidx.compose.runtime.Applier r7 = r3.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x03aa
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03aa:
            r3.startReusableNode()
            boolean r7 = r3.getInserting()
            if (r7 == 0) goto L_0x03b7
            r3.createNode(r5)
            goto L_0x03ba
        L_0x03b7:
            r3.useNode()
        L_0x03ba:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r1 = r5.getInserting()
            if (r1 != 0) goto L_0x03f3
            java.lang.Object r1 = r5.rememberedValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x0401
        L_0x03f3:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r5.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r5.apply(r1, r0)
        L_0x0401:
            r3.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0413
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0413:
            r0 = r3
            r3 = r6
            r9 = r14
            r6 = r17
            r7 = r18
            r8 = r19
            r2 = r20
            r4 = r24
            r5 = r25
        L_0x0422:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x0434
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$1
            r1 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0434:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1166BasicTextVhcvRP8(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v2, resolved type: androidx.compose.runtime.saveable.Saver<java.lang.Long, java.lang.Long>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v4, resolved type: androidx.compose.foundation.text.modifiers.SelectionController} */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0219, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0271, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0276;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0124  */
    /* renamed from: BasicText-RWo7tUw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1164BasicTextRWo7tUw(androidx.compose.ui.text.AnnotatedString r47, androidx.compose.ui.Modifier r48, androidx.compose.ui.text.TextStyle r49, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r50, int r51, boolean r52, int r53, int r54, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r55, androidx.compose.ui.graphics.ColorProducer r56, androidx.compose.runtime.Composer r57, int r58, int r59) {
        /*
            r1 = r47
            r14 = r58
            r15 = r59
            r0 = -1064305212(0xffffffffc08ffdc4, float:-4.4997272)
            r2 = r57
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)196@9257L7:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r15 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r14 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r14 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r14
            goto L_0x002b
        L_0x002a:
            r3 = r14
        L_0x002b:
            r6 = r15 & 2
            if (r6 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r14 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r48
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r3 = r3 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r48
        L_0x0047:
            r8 = r15 & 4
            if (r8 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r9 = r14 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0061
            r9 = r49
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x005d
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r10
            goto L_0x0063
        L_0x0061:
            r9 = r49
        L_0x0063:
            r10 = r15 & 8
            if (r10 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r50
            boolean r12 = r2.changedInstance(r11)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r12
            goto L_0x007f
        L_0x007d:
            r11 = r50
        L_0x007f:
            r12 = r15 & 16
            if (r12 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r13 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009a
            r13 = r51
            boolean r16 = r2.changed((int) r13)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r3 = r3 | r16
            goto L_0x009c
        L_0x009a:
            r13 = r51
        L_0x009c:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r3 = r3 | r17
            r5 = r52
            goto L_0x00ba
        L_0x00a7:
            r17 = r14 & r17
            r5 = r52
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r2.changed((boolean) r5)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r3 = r3 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c5
            r3 = r3 | r18
            r4 = r53
            goto L_0x00d8
        L_0x00c5:
            r18 = r14 & r18
            r4 = r53
            if (r18 != 0) goto L_0x00d8
            boolean r19 = r2.changed((int) r4)
            if (r19 == 0) goto L_0x00d4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r19
        L_0x00d8:
            r0 = r15 & 128(0x80, float:1.794E-43)
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r3 = r3 | r20
            goto L_0x00f7
        L_0x00e1:
            r20 = r14 & r20
            if (r20 != 0) goto L_0x00f7
            r20 = r0
            r0 = r54
            boolean r21 = r2.changed((int) r0)
            if (r21 == 0) goto L_0x00f2
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r3 = r3 | r21
            goto L_0x00fb
        L_0x00f7:
            r20 = r0
            r0 = r54
        L_0x00fb:
            r0 = r15 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r3 = r3 | r21
            goto L_0x011a
        L_0x0104:
            r21 = r14 & r21
            if (r21 != 0) goto L_0x011a
            r21 = r0
            r0 = r55
            boolean r22 = r2.changedInstance(r0)
            if (r22 == 0) goto L_0x0115
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r3 = r3 | r22
            goto L_0x011e
        L_0x011a:
            r21 = r0
            r0 = r55
        L_0x011e:
            r0 = r15 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0127
            r3 = r3 | r22
            goto L_0x013d
        L_0x0127:
            r22 = r14 & r22
            if (r22 != 0) goto L_0x013d
            r22 = r0
            r0 = r56
            boolean r23 = r2.changedInstance(r0)
            if (r23 == 0) goto L_0x0138
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013a
        L_0x0138:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013a:
            r3 = r3 | r23
            goto L_0x0141
        L_0x013d:
            r22 = r0
            r0 = r56
        L_0x0141:
            r23 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r3 & r23
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0165
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0152
            goto L_0x0165
        L_0x0152:
            r2.skipToGroupEnd()
            r8 = r54
            r10 = r56
            r14 = r2
            r0 = r4
            r6 = r5
            r3 = r9
            r4 = r11
            r5 = r13
            r2 = r47
            r9 = r55
            goto L_0x0494
        L_0x0165:
            if (r6 == 0) goto L_0x016e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r23 = r0
            goto L_0x0170
        L_0x016e:
            r23 = r7
        L_0x0170:
            if (r8 == 0) goto L_0x0179
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r9 = r0
        L_0x0179:
            if (r10 == 0) goto L_0x017c
            r11 = 0
        L_0x017c:
            if (r12 == 0) goto L_0x0185
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m7037getClipgIe3tQ8()
            r13 = r1
        L_0x0185:
            if (r16 == 0) goto L_0x0188
            r5 = 1
        L_0x0188:
            if (r17 == 0) goto L_0x018d
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x018d:
            r6 = r4
            if (r20 == 0) goto L_0x0192
            r7 = 1
            goto L_0x0194
        L_0x0192:
            r7 = r54
        L_0x0194:
            if (r21 == 0) goto L_0x019d
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            r20 = r4
            goto L_0x019f
        L_0x019d:
            r20 = r55
        L_0x019f:
            if (r22 == 0) goto L_0x01a3
            r12 = 0
            goto L_0x01a5
        L_0x01a3:
            r12 = r56
        L_0x01a5:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x01b4
            r4 = -1
            java.lang.String r8 = "androidx.compose.foundation.text.BasicText (BasicText.kt:191)"
            r10 = -1064305212(0xffffffffc08ffdc4, float:-4.4997272)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r3, r4, r8)
        L_0x01b4:
            androidx.compose.foundation.text.HeightInLinesModifierKt.validateMinMaxLines(r7, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            java.lang.Object r4 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.foundation.text.selection.SelectionRegistrar r4 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r4
            java.lang.String r1 = "CC(remember):BasicText.kt#9igjgp"
            if (r4 == 0) goto L_0x029b
            r0 = -1584983428(0xffffffffa187127c, float:-9.152849E-19)
            r2.startReplaceGroup(r0)
            java.lang.String r0 = "198@9393L7,200@9539L69,200@9456L152,203@9617L234"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            r21 = r9
            long r8 = r0.m1672getBackgroundColor0d7_KjU()
            java.lang.Object[] r0 = new java.lang.Object[]{r4}
            androidx.compose.runtime.saveable.Saver r22 = selectionIdSaver(r4)
            r48 = r0
            r0 = -328216839(0xffffffffec6fcef9, float:-1.1596427E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            boolean r0 = r2.changedInstance(r4)
            r49 = r0
            java.lang.Object r0 = r2.rememberedValue()
            if (r49 != 0) goto L_0x021c
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r3
            java.lang.Object r3 = r24.getEmpty()
            if (r0 != r3) goto L_0x0228
            goto L_0x021e
        L_0x021c:
            r25 = r3
        L_0x021e:
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1
            r0.<init>(r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r2.updateRememberedValue(r0)
        L_0x0228:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r3 = 0
            r24 = 4
            r26 = 0
            r51 = r0
            r52 = r2
            r53 = r3
            r49 = r22
            r54 = r24
            r50 = r26
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r48, r49, (java.lang.String) r50, r51, (androidx.compose.runtime.Composer) r52, (int) r53, (int) r54)
            java.lang.Number r0 = (java.lang.Number) r0
            r3 = r5
            r22 = r6
            long r5 = r0.longValue()
            r0 = -328214178(0xffffffffec6fd95e, float:-1.159839E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            boolean r0 = r2.changed((long) r5)
            boolean r24 = r2.changed((java.lang.Object) r4)
            r0 = r0 | r24
            boolean r24 = r2.changed((long) r8)
            r0 = r0 | r24
            r48 = r0
            java.lang.Object r0 = r2.rememberedValue()
            if (r48 != 0) goto L_0x0274
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r46 = r3
            java.lang.Object r3 = r24.getEmpty()
            if (r0 != r3) goto L_0x0292
            goto L_0x0276
        L_0x0274:
            r46 = r3
        L_0x0276:
            androidx.compose.foundation.text.modifiers.SelectionController r0 = new androidx.compose.foundation.text.modifiers.SelectionController
            r3 = 8
            r24 = 0
            r26 = 0
            r48 = r0
            r55 = r3
            r51 = r4
            r49 = r5
            r52 = r8
            r56 = r24
            r54 = r26
            r48.<init>(r49, r51, r52, r54, r55, r56)
            r2.updateRememberedValue(r0)
        L_0x0292:
            androidx.compose.foundation.text.modifiers.SelectionController r0 = (androidx.compose.foundation.text.modifiers.SelectionController) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceGroup()
            goto L_0x02ad
        L_0x029b:
            r25 = r3
            r46 = r5
            r22 = r6
            r21 = r9
            r0 = -1584467526(0xffffffffa18ef1ba, float:-9.686279E-19)
            r2.startReplaceGroup(r0)
            r2.endReplaceGroup()
            r0 = 0
        L_0x02ad:
            boolean r3 = androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.hasInlineContent(r47)
            boolean r4 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt.hasLinks(r47)
            if (r3 != 0) goto L_0x03b3
            if (r4 != 0) goto L_0x03b3
            r1 = -1584294453(0xffffffffa19195cb, float:-9.865232E-19)
            r2.startReplaceGroup(r1)
            java.lang.String r1 = "229@10603L7,217@10089L814"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r44 = 131071(0x1ffff, float:1.8367E-40)
            r45 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r37, r38, r39, r41, r43, r44, r45)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r10)
            java.lang.Object r3 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r8 = r3
            androidx.compose.ui.text.font.FontFamily$Resolver r8 = (androidx.compose.ui.text.font.FontFamily.Resolver) r8
            r10 = 0
            r4 = r13
            r13 = 0
            r9 = 0
            r14 = r2
            r3 = r11
            r2 = r21
            r6 = r22
            r5 = r46
            r11 = r0
            r0 = r1
            r1 = r47
            androidx.compose.ui.Modifier r0 = m1169textModifiercFh6CEA(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r11 = r3
            r2 = r1
            androidx.compose.foundation.text.EmptyMeasurePolicy r1 = androidx.compose.foundation.text.EmptyMeasurePolicy.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            r3 = 544976794(0x207baf9a, float:2.1318629E-19)
            java.lang.String r8 = "CC(Layout)P(1)125@4862L23,128@5013L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r8)
            r3 = 0
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r3)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r0)
            androidx.compose.runtime.CompositionLocalMap r8 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r10 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            java.lang.String r13 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r13)
            androidx.compose.runtime.Applier r10 = r14.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x034d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x034d:
            r14.startReusableNode()
            boolean r10 = r14.getInserting()
            if (r10 == 0) goto L_0x035a
            r14.createNode(r9)
            goto L_0x035d
        L_0x035a:
            r14.useNode()
        L_0x035d:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r1, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r8, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r0, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r1 = r9.getInserting()
            if (r1 != 0) goto L_0x0396
            java.lang.Object r1 = r9.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r8)
            if (r1 != 0) goto L_0x03a4
        L_0x0396:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r9.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r9.apply(r1, r0)
        L_0x03a4:
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endReplaceGroup()
            r3 = r11
            goto L_0x047f
        L_0x03b3:
            r27 = r0
            r14 = r2
            r4 = r13
            r6 = r22
            r5 = r46
            r2 = r47
            r0 = -1583391888(0xffffffffa19f5b70, float:-1.0798462E-18)
            r14.startReplaceGroup(r0)
            java.lang.String r0 = "241@11076L39,254@11574L7,257@11697L256,243@11125L838"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = -328167685(0xffffffffec708efb, float:-1.1632696E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
            r0 = r25 & 14
            r8 = 4
            if (r0 != r8) goto L_0x03d5
            r0 = 1
            goto L_0x03d6
        L_0x03d5:
            r0 = 0
        L_0x03d6:
            java.lang.Object r8 = r14.rememberedValue()
            if (r0 != 0) goto L_0x03e4
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x03ed
        L_0x03e4:
            r0 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r8, r0, r8)
            r14.updateRememberedValue(r8)
        L_0x03ed:
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.text.AnnotatedString r17 = BasicText_RWo7tUw$lambda$5(r8)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r9, r10)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r26 = r0
            androidx.compose.ui.text.font.FontFamily$Resolver r26 = (androidx.compose.ui.text.font.FontFamily.Resolver) r26
            r0 = -328147596(0xffffffffec70dd74, float:-1.1647519E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
            boolean r0 = r14.changed((java.lang.Object) r8)
            java.lang.Object r1 = r14.rememberedValue()
            if (r0 != 0) goto L_0x0425
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0430
        L_0x0425:
            androidx.compose.foundation.text.BasicTextKt$BasicText$2$1 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
            r0.<init>(r8)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r14.updateRememberedValue(r1)
        L_0x0430:
            r29 = r1
            kotlin.jvm.functions.Function1 r29 = (kotlin.jvm.functions.Function1) r29
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r0 = r25 >> 3
            r0 = r0 & 910(0x38e, float:1.275E-42)
            int r1 = r25 >> 12
            r8 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r8
            r0 = r0 | r1
            int r1 = r25 << 9
            r8 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r8
            r0 = r0 | r1
            int r1 = r25 << 6
            r8 = 3670016(0x380000, float:5.142788E-39)
            r8 = r8 & r1
            r0 = r0 | r8
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r1
            r0 = r0 | r8
            r8 = 234881024(0xe000000, float:1.5777218E-30)
            r8 = r8 & r1
            r0 = r0 | r8
            r8 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r8
            r31 = r0 | r1
            int r0 = r25 >> 21
            r0 = r0 & 896(0x380, float:1.256E-42)
            r33 = 0
            r32 = r0
            r19 = r3
            r22 = r4
            r24 = r6
            r25 = r7
            r18 = r11
            r28 = r12
            r30 = r14
            r16 = r23
            r23 = r5
            m1167LayoutWithLinksAndInlineContentvOo2fZY(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r3 = r18
            r23 = r16
            r14.endReplaceGroup()
        L_0x047f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0488
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0488:
            r0 = r6
            r8 = r7
            r10 = r12
            r9 = r20
            r7 = r23
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r21
        L_0x0494:
            androidx.compose.runtime.ScopeUpdateScope r13 = r14.endRestartGroup()
            if (r13 == 0) goto L_0x04ab
            r2 = r7
            r7 = r0
            androidx.compose.foundation.text.BasicTextKt$BasicText$3 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$3
            r1 = r47
            r11 = r58
            r12 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x04ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1164BasicTextRWo7tUw(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> mutableState) {
        return (AnnotatedString) mutableState.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f4  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1163BasicTextBpD7jsM(java.lang.String r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.text.TextStyle r23, kotlin.jvm.functions.Function1 r24, int r25, boolean r26, int r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r8 = r29
            r0 = 1022429478(0x3cf10926, float:0.029423308)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)279@12355L234:BasicText.kt#423gt5"
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
            boolean r2 = r1.changed((java.lang.Object) r9)
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
            boolean r7 = r1.changed((java.lang.Object) r6)
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
            r11 = r30 & 16
            if (r11 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0099
            r12 = r25
            boolean r13 = r1.changed((int) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r25
        L_0x009b:
            r13 = r30 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a3
            r2 = r2 | r14
            goto L_0x00b5
        L_0x00a3:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00b5
            r14 = r26
            boolean r15 = r1.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b1
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r15
            goto L_0x00b7
        L_0x00b5:
            r14 = r26
        L_0x00b7:
            r15 = r30 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c2
            r2 = r2 | r16
            r0 = r27
            goto L_0x00d5
        L_0x00c2:
            r16 = r8 & r16
            r0 = r27
            if (r16 != 0) goto L_0x00d5
            boolean r17 = r1.changed((int) r0)
            if (r17 == 0) goto L_0x00d1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r2 = r2 | r17
        L_0x00d5:
            r17 = 599187(0x92493, float:8.3964E-40)
            r0 = r2 & r17
            r18 = r1
            r1 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r1) goto L_0x00f4
            boolean r0 = r18.getSkipping()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00f4
        L_0x00e8:
            r18.skipToGroupEnd()
            r7 = r27
            r2 = r4
            r3 = r6
            r4 = r10
            r5 = r12
        L_0x00f1:
            r6 = r14
            goto L_0x0166
        L_0x00f4:
            if (r3 == 0) goto L_0x00fb
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x00fc
        L_0x00fb:
            r0 = r4
        L_0x00fc:
            if (r5 == 0) goto L_0x0105
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r6 = r1
        L_0x0105:
            if (r7 == 0) goto L_0x0109
            r1 = 0
            r10 = r1
        L_0x0109:
            if (r11 == 0) goto L_0x0112
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m7037getClipgIe3tQ8()
            r12 = r1
        L_0x0112:
            if (r13 == 0) goto L_0x0116
            r1 = 1
            r14 = r1
        L_0x0116:
            if (r15 == 0) goto L_0x011d
            r1 = 2147483647(0x7fffffff, float:NaN)
            r15 = r1
            goto L_0x011f
        L_0x011d:
            r15 = r27
        L_0x011f:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x012e
            r1 = -1
            java.lang.String r3 = "androidx.compose.foundation.text.BasicText (BasicText.kt:278)"
            r4 = 1022429478(0x3cf10926, float:0.029423308)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r2, r1, r3)
        L_0x012e:
            r1 = r2 & 14
            r3 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r1 = r1 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r19 = r1 | r2
            r20 = 256(0x100, float:3.59E-43)
            r16 = 1
            r17 = 0
            r11 = r6
            r13 = r12
            r12 = r10
            r10 = r0
            m1166BasicTextVhcvRP8((java.lang.String) r9, (androidx.compose.ui.Modifier) r10, (androidx.compose.ui.text.TextStyle) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (int) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.ui.graphics.ColorProducer) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0160
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0160:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r15
            goto L_0x00f1
        L_0x0166:
            androidx.compose.runtime.ScopeUpdateScope r10 = r18.endRestartGroup()
            if (r10 == 0) goto L_0x017a
            androidx.compose.foundation.text.BasicTextKt$BasicText$4 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$4
            r1 = r21
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1163BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1161BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.text.TextStyle r26, kotlin.jvm.functions.Function1 r27, int r28, boolean r29, int r30, java.util.Map r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r33
            r10 = r34
            r0 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)303@13046L273:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r11 = r24
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r11 = r24
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((java.lang.Object) r11)
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
            boolean r7 = r1.changed((java.lang.Object) r6)
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
            boolean r12 = r1.changedInstance(r8)
            if (r12 == 0) goto L_0x007b
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r12
            goto L_0x0081
        L_0x007f:
            r8 = r27
        L_0x0081:
            r12 = r10 & 16
            if (r12 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r28
            boolean r14 = r1.changed((int) r13)
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
            r14 = r10 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00b8
            r15 = r29
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r29
        L_0x00ba:
            r16 = r10 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c5
            r2 = r2 | r17
            r0 = r30
            goto L_0x00d8
        L_0x00c5:
            r17 = r9 & r17
            r0 = r30
            if (r17 != 0) goto L_0x00d8
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00d4
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r18
        L_0x00d8:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r2 = r2 | r18
            goto L_0x00f7
        L_0x00e1:
            r19 = r9 & r18
            if (r19 != 0) goto L_0x00f7
            r19 = r0
            r0 = r31
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x00f2
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r20
            goto L_0x00fb
        L_0x00f7:
            r19 = r0
            r0 = r31
        L_0x00fb:
            r20 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r20
            r21 = r1
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x011c
            boolean r0 = r21.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x011c
        L_0x010e:
            r21.skipToGroupEnd()
            r7 = r30
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            r6 = r15
            r8 = r31
            goto L_0x01a5
        L_0x011c:
            if (r3 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0124
        L_0x0123:
            r0 = r4
        L_0x0124:
            if (r5 == 0) goto L_0x012d
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r6 = r1
        L_0x012d:
            if (r7 == 0) goto L_0x0131
            r1 = 0
            r8 = r1
        L_0x0131:
            if (r12 == 0) goto L_0x013a
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m7037getClipgIe3tQ8()
            r13 = r1
        L_0x013a:
            if (r14 == 0) goto L_0x013e
            r1 = 1
            r15 = r1
        L_0x013e:
            if (r16 == 0) goto L_0x0144
            r1 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0146
        L_0x0144:
            r1 = r30
        L_0x0146:
            if (r19 == 0) goto L_0x014f
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            r19 = r3
            goto L_0x0151
        L_0x014f:
            r19 = r31
        L_0x0151:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0160
            r3 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.BasicText (BasicText.kt:302)"
            r5 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r3, r4)
        L_0x0160:
            r3 = r2 & 14
            r3 = r3 | r18
            r4 = r2 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r2
            r3 = r3 | r4
            int r2 = r2 << 3
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r4
            r22 = r3 | r2
            r23 = 512(0x200, float:7.175E-43)
            r18 = 1
            r20 = 0
            r12 = r0
            r17 = r1
            r14 = r8
            r16 = r15
            r15 = r13
            r13 = r6
            m1164BasicTextRWo7tUw(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x019b:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r19
        L_0x01a5:
            androidx.compose.runtime.ScopeUpdateScope r11 = r21.endRestartGroup()
            if (r11 == 0) goto L_0x01b7
            androidx.compose.foundation.text.BasicTextKt$BasicText$5 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$5
            r1 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1161BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1162BasicText4YKlhWE(java.lang.String r23, androidx.compose.ui.Modifier r24, androidx.compose.ui.text.TextStyle r25, kotlin.jvm.functions.Function1 r26, int r27, boolean r28, int r29, int r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r32
            r10 = r33
            r0 = 1542716361(0x5bf3fbc9, float:1.3735052E17)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)327@13717L86:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r11 = r23
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r11 = r23
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((java.lang.Object) r11)
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
            r4 = r24
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
            r4 = r24
        L_0x0049:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r9 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r25
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r25
        L_0x0065:
            r7 = r10 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r26
            boolean r12 = r1.changedInstance(r8)
            if (r12 == 0) goto L_0x007b
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r12
            goto L_0x0081
        L_0x007f:
            r8 = r26
        L_0x0081:
            r12 = r10 & 16
            if (r12 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r27
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r27
        L_0x009d:
            r14 = r10 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00b8
            r15 = r28
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r28
        L_0x00ba:
            r16 = r10 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c5
            r2 = r2 | r17
            r0 = r29
            goto L_0x00d8
        L_0x00c5:
            r17 = r9 & r17
            r0 = r29
            if (r17 != 0) goto L_0x00d8
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00d4
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r18
        L_0x00d8:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r2 = r2 | r18
            goto L_0x00f7
        L_0x00e1:
            r18 = r9 & r18
            if (r18 != 0) goto L_0x00f7
            r18 = r0
            r0 = r30
            boolean r19 = r1.changed((int) r0)
            if (r19 == 0) goto L_0x00f2
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r19
            goto L_0x00fb
        L_0x00f7:
            r18 = r0
            r0 = r30
        L_0x00fb:
            r19 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r19
            r20 = r1
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x011c
            boolean r0 = r20.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x011c
        L_0x010e:
            r20.skipToGroupEnd()
            r7 = r29
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            r6 = r15
            r8 = r30
            goto L_0x0183
        L_0x011c:
            if (r3 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0124
        L_0x0123:
            r0 = r4
        L_0x0124:
            if (r5 == 0) goto L_0x012d
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r6 = r1
        L_0x012d:
            if (r7 == 0) goto L_0x0131
            r1 = 0
            r8 = r1
        L_0x0131:
            if (r12 == 0) goto L_0x013a
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m7037getClipgIe3tQ8()
            r13 = r1
        L_0x013a:
            r1 = 1
            if (r14 == 0) goto L_0x013e
            r15 = r1
        L_0x013e:
            if (r16 == 0) goto L_0x0144
            r3 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0146
        L_0x0144:
            r3 = r29
        L_0x0146:
            if (r18 == 0) goto L_0x014b
            r18 = r1
            goto L_0x014d
        L_0x014b:
            r18 = r30
        L_0x014d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x015c
            r1 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.BasicText (BasicText.kt:327)"
            r5 = 1542716361(0x5bf3fbc9, float:1.3735052E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r1, r4)
        L_0x015c:
            r1 = 33554430(0x1fffffe, float:9.4039537E-38)
            r21 = r2 & r1
            r22 = 256(0x100, float:3.59E-43)
            r19 = 0
            r12 = r0
            r17 = r3
            r14 = r8
            r16 = r15
            r15 = r13
            r13 = r6
            m1166BasicTextVhcvRP8((java.lang.String) r11, (androidx.compose.ui.Modifier) r12, (androidx.compose.ui.text.TextStyle) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r14, (int) r15, (boolean) r16, (int) r17, (int) r18, (androidx.compose.ui.graphics.ColorProducer) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0179
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0179:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
        L_0x0183:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 == 0) goto L_0x0195
            androidx.compose.foundation.text.BasicTextKt$BasicText$6 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$6
            r1 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1162BasicText4YKlhWE(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m1165BasicTextVhcvRP8(androidx.compose.ui.text.AnnotatedString r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.text.TextStyle r27, kotlin.jvm.functions.Function1 r28, int r29, boolean r30, int r31, int r32, java.util.Map r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r10 = r35
            r11 = r36
            r0 = 851408699(0x32bf773b, float:2.2289546E-8)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)341@14269L240:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r12 = r25
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r12 = r25
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((java.lang.Object) r12)
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
            r4 = r26
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
            r4 = r26
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r27
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r27
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007f
            r8 = r28
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
            r8 = r28
        L_0x0081:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0088
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009b
            r13 = r29
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r29
        L_0x009d:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a5
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00a5:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b8
            r15 = r30
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r30
        L_0x00ba:
            r16 = r11 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c5
            r2 = r2 | r17
            r0 = r31
            goto L_0x00d8
        L_0x00c5:
            r17 = r10 & r17
            r0 = r31
            if (r17 != 0) goto L_0x00d8
            boolean r18 = r1.changed((int) r0)
            if (r18 == 0) goto L_0x00d4
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r18
        L_0x00d8:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e1
            r2 = r2 | r18
            goto L_0x00f7
        L_0x00e1:
            r18 = r10 & r18
            if (r18 != 0) goto L_0x00f7
            r18 = r0
            r0 = r32
            boolean r19 = r1.changed((int) r0)
            if (r19 == 0) goto L_0x00f2
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r19
            goto L_0x00fb
        L_0x00f7:
            r18 = r0
            r0 = r32
        L_0x00fb:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r2 = r2 | r19
            goto L_0x011a
        L_0x0104:
            r19 = r10 & r19
            if (r19 != 0) goto L_0x011a
            r19 = r0
            r0 = r33
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x0115
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r2 = r2 | r20
            goto L_0x011e
        L_0x011a:
            r19 = r0
            r0 = r33
        L_0x011e:
            r20 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r20
            r22 = r1
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r1) goto L_0x0141
            boolean r0 = r22.getSkipping()
            if (r0 != 0) goto L_0x0131
            goto L_0x0141
        L_0x0131:
            r22.skipToGroupEnd()
            r7 = r31
            r9 = r33
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            r6 = r15
            r8 = r32
            goto L_0x01b6
        L_0x0141:
            if (r3 == 0) goto L_0x0148
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0148:
            if (r5 == 0) goto L_0x0151
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r6 = r0
        L_0x0151:
            if (r7 == 0) goto L_0x0155
            r0 = 0
            r8 = r0
        L_0x0155:
            if (r9 == 0) goto L_0x015e
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m7037getClipgIe3tQ8()
            r13 = r0
        L_0x015e:
            r0 = 1
            if (r14 == 0) goto L_0x0162
            r15 = r0
        L_0x0162:
            if (r16 == 0) goto L_0x0168
            r1 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x016a
        L_0x0168:
            r1 = r31
        L_0x016a:
            if (r18 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r0 = r32
        L_0x016f:
            if (r19 == 0) goto L_0x0178
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            r20 = r3
            goto L_0x017a
        L_0x0178:
            r20 = r33
        L_0x017a:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0189
            r3 = -1
            java.lang.String r5 = "androidx.compose.foundation.text.BasicText (BasicText.kt:341)"
            r7 = 851408699(0x32bf773b, float:2.2289546E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r3, r5)
        L_0x0189:
            r3 = 268435454(0xffffffe, float:2.5243546E-29)
            r23 = r2 & r3
            r24 = 512(0x200, float:7.175E-43)
            r21 = 0
            r19 = r0
            r18 = r1
            r14 = r6
            r16 = r13
            r17 = r15
            r13 = r4
            r15 = r8
            m1164BasicTextRWo7tUw(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
        L_0x01b6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r22.endRestartGroup()
            if (r12 == 0) goto L_0x01c8
            androidx.compose.foundation.text.BasicTextKt$BasicText$7 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$7
            r1 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1165BasicTextVhcvRP8(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            return null;
        }
        TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list.get(i);
            Object parentData = measurable.getParentData();
            Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
            TextRangeLayoutMeasureResult measure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
            arrayList.add(new Pair(measurable.m5848measureBRTryo0(Constraints.Companion.m7061fitPrioritizingWidthZbe2FdA(measure.getWidth(), measure.getWidth(), measure.getHeight(), measure.getHeight())), measure.getPlace()));
        }
        return arrayList;
    }

    /* renamed from: textModifier-cFh6CEA  reason: not valid java name */
    private static final Modifier m1169textModifiercFh6CEA(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13) {
        Modifier modifier2 = modifier;
        if (selectionController == null) {
            return modifier2.then(Modifier.Companion).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, (SelectionController) null, colorProducer, function13, (DefaultConstructorMarker) null));
        }
        return modifier2.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, (DefaultConstructorMarker) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0120  */
    /* renamed from: LayoutWithLinksAndInlineContent-vOo2fZY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1167LayoutWithLinksAndInlineContentvOo2fZY(androidx.compose.ui.Modifier r43, androidx.compose.ui.text.AnnotatedString r44, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r45, boolean r46, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r47, androidx.compose.ui.text.TextStyle r48, int r49, boolean r50, int r51, int r52, androidx.compose.ui.text.font.FontFamily.Resolver r53, androidx.compose.foundation.text.modifiers.SelectionController r54, androidx.compose.ui.graphics.ColorProducer r55, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.TextSubstitutionValue, kotlin.Unit> r56, androidx.compose.runtime.Composer r57, int r58, int r59, int r60) {
        /*
            r2 = r44
            r3 = r45
            r4 = r46
            r15 = r58
            r0 = r59
            r1 = r60
            r5 = 645129368(0x2673e498, float:8.4617363E-16)
            r6 = r57
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r7 = "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)578@22283L117,565@21843L1459:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = r1 & 1
            if (r7 == 0) goto L_0x0024
            r7 = r15 | 6
            r10 = r7
            r7 = r43
            goto L_0x0038
        L_0x0024:
            r7 = r15 & 6
            if (r7 != 0) goto L_0x0035
            r7 = r43
            boolean r10 = r6.changed((java.lang.Object) r7)
            if (r10 == 0) goto L_0x0032
            r10 = 4
            goto L_0x0033
        L_0x0032:
            r10 = 2
        L_0x0033:
            r10 = r10 | r15
            goto L_0x0038
        L_0x0035:
            r7 = r43
            r10 = r15
        L_0x0038:
            r11 = r1 & 2
            if (r11 == 0) goto L_0x003f
            r10 = r10 | 48
            goto L_0x004f
        L_0x003f:
            r11 = r15 & 48
            if (r11 != 0) goto L_0x004f
            boolean r11 = r6.changed((java.lang.Object) r2)
            if (r11 == 0) goto L_0x004c
            r11 = 32
            goto L_0x004e
        L_0x004c:
            r11 = 16
        L_0x004e:
            r10 = r10 | r11
        L_0x004f:
            r11 = r1 & 4
            if (r11 == 0) goto L_0x0056
            r10 = r10 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0056:
            r11 = r15 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0066
            boolean r11 = r6.changedInstance(r3)
            if (r11 == 0) goto L_0x0063
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r10 = r10 | r11
        L_0x0066:
            r11 = r1 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0071
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r11 = r15 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0081
            boolean r11 = r6.changed((boolean) r4)
            if (r11 == 0) goto L_0x007e
            r11 = r16
            goto L_0x0080
        L_0x007e:
            r11 = r17
        L_0x0080:
            r10 = r10 | r11
        L_0x0081:
            r11 = r1 & 16
            if (r11 == 0) goto L_0x0088
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0088:
            r12 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009c
            r12 = r47
            boolean r19 = r6.changedInstance(r12)
            if (r19 == 0) goto L_0x0097
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r10 = r10 | r19
            goto L_0x009e
        L_0x009c:
            r12 = r47
        L_0x009e:
            r19 = r1 & 32
            r20 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00a9
            r10 = r10 | r20
            r14 = r48
            goto L_0x00bc
        L_0x00a9:
            r19 = r15 & r20
            r14 = r48
            if (r19 != 0) goto L_0x00bc
            boolean r20 = r6.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x00b8
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r10 = r10 | r20
        L_0x00bc:
            r20 = r1 & 64
            r21 = 1572864(0x180000, float:2.204052E-39)
            if (r20 == 0) goto L_0x00c7
            r10 = r10 | r21
            r8 = r49
            goto L_0x00da
        L_0x00c7:
            r20 = r15 & r21
            r8 = r49
            if (r20 != 0) goto L_0x00da
            boolean r20 = r6.changed((int) r8)
            if (r20 == 0) goto L_0x00d6
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r10 = r10 | r20
        L_0x00da:
            r9 = r1 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x00e2
            r9 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r10 | r9
            goto L_0x00f7
        L_0x00e2:
            r9 = 12582912(0xc00000, float:1.7632415E-38)
            r9 = r9 & r15
            if (r9 != 0) goto L_0x00f7
            r9 = r50
            boolean r21 = r6.changed((boolean) r9)
            if (r21 == 0) goto L_0x00f2
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r10 = r10 | r21
            goto L_0x00f9
        L_0x00f7:
            r9 = r50
        L_0x00f9:
            r13 = r1 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0101
            r13 = 100663296(0x6000000, float:2.4074124E-35)
            r10 = r10 | r13
            goto L_0x0116
        L_0x0101:
            r13 = 100663296(0x6000000, float:2.4074124E-35)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x0116
            r13 = r51
            boolean r22 = r6.changed((int) r13)
            if (r22 == 0) goto L_0x0111
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r10 = r10 | r22
            goto L_0x0118
        L_0x0116:
            r13 = r51
        L_0x0118:
            r5 = r1 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0120
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r10 = r10 | r5
            goto L_0x0135
        L_0x0120:
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 & r15
            if (r5 != 0) goto L_0x0135
            r5 = r52
            boolean r23 = r6.changed((int) r5)
            if (r23 == 0) goto L_0x0130
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r10 = r10 | r23
            goto L_0x0137
        L_0x0135:
            r5 = r52
        L_0x0137:
            r4 = r1 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0142
            r4 = r0 | 6
            r23 = r4
            r4 = r53
            goto L_0x015a
        L_0x0142:
            r4 = r0 & 6
            if (r4 != 0) goto L_0x0156
            r4 = r53
            boolean r23 = r6.changedInstance(r4)
            if (r23 == 0) goto L_0x0151
            r23 = 4
            goto L_0x0153
        L_0x0151:
            r23 = 2
        L_0x0153:
            r23 = r0 | r23
            goto L_0x015a
        L_0x0156:
            r4 = r53
            r23 = r0
        L_0x015a:
            r4 = r1 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0161
            r23 = r23 | 48
            goto L_0x0177
        L_0x0161:
            r4 = r0 & 48
            if (r4 != 0) goto L_0x0175
            r4 = r54
            boolean r24 = r6.changedInstance(r4)
            if (r24 == 0) goto L_0x0170
            r18 = 32
            goto L_0x0172
        L_0x0170:
            r18 = 16
        L_0x0172:
            r23 = r23 | r18
            goto L_0x0177
        L_0x0175:
            r4 = r54
        L_0x0177:
            r4 = r23
            r5 = r1 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0180
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0194
        L_0x0180:
            r5 = r0 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0194
            r5 = r55
            boolean r18 = r6.changedInstance(r5)
            if (r18 == 0) goto L_0x018f
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x0191
        L_0x018f:
            r19 = 128(0x80, float:1.794E-43)
        L_0x0191:
            r4 = r4 | r19
            goto L_0x0196
        L_0x0194:
            r5 = r55
        L_0x0196:
            r5 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x019d
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x01af
        L_0x019d:
            r5 = r0 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x01af
            r5 = r56
            boolean r18 = r6.changedInstance(r5)
            if (r18 == 0) goto L_0x01aa
            goto L_0x01ac
        L_0x01aa:
            r16 = r17
        L_0x01ac:
            r4 = r4 | r16
            goto L_0x01b1
        L_0x01af:
            r5 = r56
        L_0x01b1:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r10 & r16
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x01ce
            r0 = r4 & 1171(0x493, float:1.641E-42)
            r1 = 1170(0x492, float:1.64E-42)
            if (r0 != r1) goto L_0x01ce
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x01c8
            goto L_0x01ce
        L_0x01c8:
            r6.skipToGroupEnd()
            r5 = r12
            goto L_0x056c
        L_0x01ce:
            if (r11 == 0) goto L_0x01d5
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x01d6
        L_0x01d5:
            r0 = r12
        L_0x01d6:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01e4
            java.lang.String r1 = "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)"
            r11 = 645129368(0x2673e498, float:8.4617363E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r10, r4, r1)
        L_0x01e4:
            boolean r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt.hasLinks(r2)
            java.lang.String r12 = "CC(remember):BasicText.kt#9igjgp"
            r39 = 1
            if (r1 == 0) goto L_0x0228
            r1 = -619323167(0xffffffffdb15e0e1, float:-4.2187029E16)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "539@20954L38"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = -297072527(0xffffffffee4b0871, float:-1.5708916E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r12)
            r1 = r10 & 112(0x70, float:1.57E-43)
            r4 = 32
            if (r1 != r4) goto L_0x0208
            r1 = r39
            goto L_0x0209
        L_0x0208:
            r1 = 0
        L_0x0209:
            java.lang.Object r4 = r6.rememberedValue()
            if (r1 != 0) goto L_0x0217
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x021f
        L_0x0217:
            androidx.compose.foundation.text.TextLinkScope r4 = new androidx.compose.foundation.text.TextLinkScope
            r4.<init>(r2)
            r6.updateRememberedValue(r4)
        L_0x021f:
            androidx.compose.foundation.text.TextLinkScope r4 = (androidx.compose.foundation.text.TextLinkScope) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endReplaceGroup()
            goto L_0x0232
        L_0x0228:
            r1 = -619265198(0xffffffffdb16c352, float:-4.2436003E16)
            r6.startReplaceGroup(r1)
            r6.endReplaceGroup()
            r4 = 0
        L_0x0232:
            boolean r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt.hasLinks(r2)
            if (r1 == 0) goto L_0x027a
            r1 = -619074547(0xffffffffdb19ac0d, float:-4.3254843E16)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "545@21203L90"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = -297064507(0xffffffffee4b27c5, float:-1.5718384E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r12)
            r1 = r10 & 112(0x70, float:1.57E-43)
            r11 = 32
            if (r1 != r11) goto L_0x0252
            r1 = r39
            goto L_0x0253
        L_0x0252:
            r1 = 0
        L_0x0253:
            boolean r11 = r6.changed((java.lang.Object) r4)
            r1 = r1 | r11
            java.lang.Object r11 = r6.rememberedValue()
            if (r1 != 0) goto L_0x0266
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r11 != r1) goto L_0x0271
        L_0x0266:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1 r1 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1
            r1.<init>(r4, r2)
            r11 = r1
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r6.updateRememberedValue(r11)
        L_0x0271:
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endReplaceGroup()
            goto L_0x02b6
        L_0x027a:
            r1 = -618966357(0xffffffffdb1b52ab, float:-4.3719516E16)
            r6.startReplaceGroup(r1)
            java.lang.String r1 = "548@21307L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = -297061261(0xffffffffee4b3473, float:-1.5722216E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r12)
            r1 = r10 & 112(0x70, float:1.57E-43)
            r11 = 32
            if (r1 != r11) goto L_0x0294
            r1 = r39
            goto L_0x0295
        L_0x0294:
            r1 = 0
        L_0x0295:
            java.lang.Object r11 = r6.rememberedValue()
            if (r1 != 0) goto L_0x02a3
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r11 != r1) goto L_0x02ae
        L_0x02a3:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1 r1 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1
            r1.<init>(r2)
            r11 = r1
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r6.updateRememberedValue(r11)
        L_0x02ae:
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endReplaceGroup()
        L_0x02b6:
            if (r46 == 0) goto L_0x02bf
            kotlin.Pair r1 = androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.resolveInlineContent(r2, r0)
            r40 = r0
            goto L_0x02c7
        L_0x02bf:
            kotlin.Pair r1 = new kotlin.Pair
            r40 = r0
            r0 = 0
            r1.<init>(r0, r0)
        L_0x02c7:
            java.lang.Object r0 = r1.component1()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r1.component2()
            java.util.List r1 = (java.util.List) r1
            if (r46 == 0) goto L_0x030a
            r41 = r0
            r0 = -618671702(0xffffffffdb1fd1aa, float:-4.4985049E16)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "558@21610L61"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = -297051512(0xffffffffee4b5a88, float:-1.5733726E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r12)
            java.lang.Object r0 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r16.getEmpty()
            if (r0 != r5) goto L_0x02fe
            r0 = 2
            r5 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r0, r5)
            r6.updateRememberedValue(r0)
            goto L_0x0301
        L_0x02fe:
            r57 = r0
            r5 = 0
        L_0x0301:
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endReplaceGroup()
            goto L_0x0317
        L_0x030a:
            r41 = r0
            r5 = 0
            r0 = -618591630(0xffffffffdb210a72, float:-4.5328956E16)
            r6.startReplaceGroup(r0)
            r6.endReplaceGroup()
            r0 = r5
        L_0x0317:
            if (r46 == 0) goto L_0x0351
            r5 = -618506565(0xffffffffdb2256bb, float:-4.5694307E16)
            r6.startReplaceGroup(r5)
            java.lang.String r5 = "562@21777L44"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            r5 = -297046185(0xffffffffee4b6f57, float:-1.5740015E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r5, r12)
            boolean r5 = r6.changed((java.lang.Object) r0)
            r57 = r5
            java.lang.Object r5 = r6.rememberedValue()
            if (r57 != 0) goto L_0x033e
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r16.getEmpty()
            if (r5 != r7) goto L_0x0348
        L_0x033e:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1 r5 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
            r5.<init>(r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6.updateRememberedValue(r5)
        L_0x0348:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endReplaceGroup()
            goto L_0x035a
        L_0x0351:
            r7 = -618442830(0xffffffffdb234fb2, float:-4.5968047E16)
            r6.startReplaceGroup(r7)
            r6.endReplaceGroup()
        L_0x035a:
            r37 = 131071(0x1ffff, float:1.8367E-40)
            r38 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r16 = r43
            androidx.compose.ui.Modifier r20 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r36, r37, r38)
            java.lang.Object r7 = r11.invoke()
            r21 = r7
            androidx.compose.ui.text.AnnotatedString r21 = (androidx.compose.ui.text.AnnotatedString) r21
            r7 = -297029920(0xffffffffee4baee0, float:-1.5759217E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r12)
            boolean r7 = r6.changedInstance(r4)
            r11 = r10 & 896(0x380, float:1.256E-42)
            r30 = r5
            r5 = 256(0x100, float:3.59E-43)
            if (r11 != r5) goto L_0x03a2
            goto L_0x03a4
        L_0x03a2:
            r39 = 0
        L_0x03a4:
            r5 = r7 | r39
            java.lang.Object r7 = r6.rememberedValue()
            if (r5 != 0) goto L_0x03b4
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x03bf
        L_0x03b4:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1 r5 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
            r5.<init>(r4, r3)
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r6.updateRememberedValue(r7)
        L_0x03bf:
            r23 = r7
            kotlin.jvm.functions.Function1 r23 = (kotlin.jvm.functions.Function1) r23
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r27 = r52
            r28 = r53
            r31 = r54
            r32 = r55
            r33 = r56
            r24 = r8
            r25 = r9
            r26 = r13
            r22 = r14
            r29 = r41
            androidx.compose.ui.Modifier r5 = m1169textModifiercFh6CEA(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            if (r46 != 0) goto L_0x041e
            r0 = -617362851(0xffffffffdb33ca5d, float:-5.0606522E16)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "595@22992L55"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = -297007294(0xffffffffee4c0742, float:-1.5785929E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r12)
            boolean r0 = r6.changedInstance(r4)
            java.lang.Object r7 = r6.rememberedValue()
            if (r0 != 0) goto L_0x0403
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r7 != r0) goto L_0x040e
        L_0x0403:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1 r0 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
            r0.<init>(r4)
            r7 = r0
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r6.updateRememberedValue(r7)
        L_0x040e:
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.foundation.text.LinksTextMeasurePolicy r0 = new androidx.compose.foundation.text.LinksTextMeasurePolicy
            r0.<init>(r7)
            r6.endReplaceGroup()
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
            goto L_0x0483
        L_0x041e:
            r7 = -617202116(0xffffffffdb363e3c, float:-5.1296873E16)
            r6.startReplaceGroup(r7)
            java.lang.String r7 = "599@23147L55,600@23233L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r7)
            r7 = -297002334(0xffffffffee4c1aa2, float:-1.5791785E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r12)
            boolean r7 = r6.changedInstance(r4)
            java.lang.Object r8 = r6.rememberedValue()
            if (r7 != 0) goto L_0x0441
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x044c
        L_0x0441:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1 r7 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
            r7.<init>(r4)
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r6.updateRememberedValue(r8)
        L_0x044c:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r7 = -296999598(0xffffffffee4c2552, float:-1.5795015E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r12)
            boolean r7 = r6.changed((java.lang.Object) r0)
            java.lang.Object r9 = r6.rememberedValue()
            if (r7 != 0) goto L_0x0469
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0474
        L_0x0469:
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1 r7 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
            r7.<init>(r0)
            r9 = r7
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r6.updateRememberedValue(r9)
        L_0x0474:
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.foundation.text.TextMeasurePolicy r0 = new androidx.compose.foundation.text.TextMeasurePolicy
            r0.<init>(r8, r9)
            r6.endReplaceGroup()
            androidx.compose.ui.layout.MeasurePolicy r0 = (androidx.compose.ui.layout.MeasurePolicy) r0
        L_0x0483:
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r8 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r8)
            r7 = 0
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r7)
            androidx.compose.runtime.CompositionLocalMap r7 = r6.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r12 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r11, r12)
            androidx.compose.runtime.Applier r11 = r6.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x04b1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04b1:
            r6.startReusableNode()
            boolean r11 = r6.getInserting()
            if (r11 == 0) goto L_0x04be
            r6.createNode(r9)
            goto L_0x04c1
        L_0x04be:
            r6.useNode()
        L_0x04c1:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3675constructorimpl(r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r0, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r7, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r7 = r9.getInserting()
            if (r7 != 0) goto L_0x04f1
            java.lang.Object r7 = r9.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r11)
            if (r7 != 0) goto L_0x04ff
        L_0x04f1:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r9.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r9.apply(r7, r0)
        L_0x04ff:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r9, r5, r0)
            r0 = -515487512(0xffffffffe14648e8, float:-2.286068E20)
            java.lang.String r5 = "C:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r5)
            if (r4 != 0) goto L_0x051c
            r0 = -515480539(0xffffffffe1466425, float:-2.2872947E20)
            r6.startReplaceGroup(r0)
            r6.endReplaceGroup()
            goto L_0x0530
        L_0x051c:
            r0 = 537560924(0x200a875c, float:1.1733841E-19)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "567@21894L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r7 = 0
            r4.LinksComposables(r6, r7)
            r6.endReplaceGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0530:
            if (r1 != 0) goto L_0x053c
            r0 = -515428893(0xffffffffe1472de3, float:-2.2963803E20)
            r6.startReplaceGroup(r0)
            r6.endReplaceGroup()
            goto L_0x0555
        L_0x053c:
            r0 = -515428892(0xffffffffe1472de4, float:-2.2963805E20)
            r6.startReplaceGroup(r0)
            java.lang.String r0 = "*569@21966L48"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            int r0 = r10 >> 3
            r0 = r0 & 14
            androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.InlineChildren(r2, r1, r6, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r6.endReplaceGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0555:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r6.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x056a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x056a:
            r5 = r40
        L_0x056c:
            androidx.compose.runtime.ScopeUpdateScope r0 = r6.endRestartGroup()
            if (r0 == 0) goto L_0x059b
            r1 = r0
            androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6 r0 = new androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
            r4 = r46
            r6 = r48
            r7 = r49
            r8 = r50
            r9 = r51
            r10 = r52
            r11 = r53
            r12 = r54
            r13 = r55
            r14 = r56
            r16 = r59
            r17 = r60
            r42 = r1
            r1 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r42
            r1.updateScope(r0)
        L_0x059b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m1167LayoutWithLinksAndInlineContentvOo2fZY(androidx.compose.ui.Modifier, androidx.compose.ui.text.AnnotatedString, kotlin.jvm.functions.Function1, boolean, java.util.Map, androidx.compose.ui.text.TextStyle, int, boolean, int, int, androidx.compose.ui.text.font.FontFamily$Resolver, androidx.compose.foundation.text.modifiers.SelectionController, androidx.compose.ui.graphics.ColorProducer, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void BasicText_RWo7tUw$lambda$6(MutableState<AnnotatedString> mutableState, AnnotatedString annotatedString) {
        mutableState.setValue(annotatedString);
    }
}
