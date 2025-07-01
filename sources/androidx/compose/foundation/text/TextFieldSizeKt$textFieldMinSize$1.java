package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSizeKt$textFieldMinSize$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        super(3);
        this.$style = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: androidx.compose.runtime.State} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r8, androidx.compose.runtime.Composer r9, int r10) {
        /*
            r7 = this;
            r8 = 1582736677(0x5e56a525, float:3.86670229E18)
            r9.startReplaceGroup(r8)
            java.lang.String r0 = "C37@1534L7,38@1595L7,39@1650L7,41@1683L88,44@1792L312,53@2129L101,59@2348L483:TextFieldSize.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0017
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r10, r0, r1)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r0)
            java.lang.Object r8 = r9.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r3 = r8
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r0)
            java.lang.Object r8 = r9.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r4 = r8
            androidx.compose.ui.text.font.FontFamily$Resolver r4 = (androidx.compose.ui.text.font.FontFamily.Resolver) r4
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r0)
            java.lang.Object r8 = r9.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2 = r8
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            r8 = 979653572(0x3a6453c4, float:8.709992E-4)
            java.lang.String r10 = "CC(remember):TextFieldSize.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r10)
            androidx.compose.ui.text.TextStyle r8 = r7.$style
            boolean r8 = r9.changed((java.lang.Object) r8)
            boolean r0 = r9.changed((java.lang.Object) r2)
            r8 = r8 | r0
            androidx.compose.ui.text.TextStyle r0 = r7.$style
            java.lang.Object r1 = r9.rememberedValue()
            if (r8 != 0) goto L_0x0078
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r1 != r8) goto L_0x007f
        L_0x0078:
            androidx.compose.ui.text.TextStyle r1 = androidx.compose.ui.text.TextStyleKt.resolveDefaults(r0, r2)
            r9.updateRememberedValue(r1)
        L_0x007f:
            r8 = r1
            androidx.compose.ui.text.TextStyle r8 = (androidx.compose.ui.text.TextStyle) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = 979657284(0x3a646244, float:8.7121525E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r10)
            boolean r0 = r9.changed((java.lang.Object) r4)
            boolean r1 = r9.changed((java.lang.Object) r8)
            r0 = r0 | r1
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x00a2
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00db
        L_0x00a2:
            androidx.compose.ui.text.font.FontFamily r0 = r8.getFontFamily()
            androidx.compose.ui.text.font.FontWeight r1 = r8.getFontWeight()
            if (r1 != 0) goto L_0x00b2
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r1 = r1.getNormal()
        L_0x00b2:
            androidx.compose.ui.text.font.FontStyle r5 = r8.m6596getFontStyle4Lr2A7w()
            if (r5 == 0) goto L_0x00bd
            int r5 = r5.m6681unboximpl()
            goto L_0x00c3
        L_0x00bd:
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m6685getNormal_LCdwA()
        L_0x00c3:
            androidx.compose.ui.text.font.FontSynthesis r6 = r8.m6597getFontSynthesisZQGJjVo()
            if (r6 == 0) goto L_0x00ce
            int r6 = r6.m6694unboximpl()
            goto L_0x00d4
        L_0x00ce:
            androidx.compose.ui.text.font.FontSynthesis$Companion r6 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r6 = r6.m6695getAllGVVA2EU()
        L_0x00d4:
            androidx.compose.runtime.State r1 = r4.m6652resolveDPcqOEQ(r0, r1, r5, r6)
            r9.updateRememberedValue(r1)
        L_0x00db:
            r0 = r1
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r1 = 979667857(0x3a648b91, float:8.718307E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r10)
            androidx.compose.ui.text.TextStyle r5 = r7.$style
            java.lang.Object r1 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r1 != r6) goto L_0x0101
            androidx.compose.foundation.text.TextFieldSize r1 = new androidx.compose.foundation.text.TextFieldSize
            java.lang.Object r6 = invoke$lambda$2(r0)
            r1.<init>(r2, r3, r4, r5, r6)
            r9.updateRememberedValue(r1)
        L_0x0101:
            androidx.compose.foundation.text.TextFieldSize r1 = (androidx.compose.foundation.text.TextFieldSize) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            java.lang.Object r6 = invoke$lambda$2(r0)
            r5 = r8
            r1.update(r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r0 = 979675247(0x3a64a86f, float:8.7226083E-4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r10)
            boolean r10 = r9.changedInstance(r1)
            java.lang.Object r0 = r9.rememberedValue()
            if (r10 != 0) goto L_0x012a
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r0 != r10) goto L_0x0135
        L_0x012a:
            androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1 r10 = new androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1
            r10.<init>(r1)
            r0 = r10
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r9.updateRememberedValue(r0)
        L_0x0135:
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutModifierKt.layout(r8, r0)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0147
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0147:
            r9.endReplaceGroup()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    private static final Object invoke$lambda$2(State<? extends Object> state) {
        return state.getValue();
    }
}
