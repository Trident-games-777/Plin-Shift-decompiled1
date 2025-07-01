package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/SpanStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        if ((r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0122, code lost:
        if ((r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0148, code lost:
        if ((r2 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0174, code lost:
        if ((r5 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L_0x0182;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.SpanStyle invoke(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r25
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.text.SpanStyle r1 = new androidx.compose.ui.text.SpanStyle
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            androidx.compose.runtime.saveable.Saver r4 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.graphics.Color.Companion) r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x0025
            boolean r5 = r4 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r5 != 0) goto L_0x0025
            goto L_0x002e
        L_0x0025:
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r4.restore(r2)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r4 = r2.m4249unboximpl()
            r2 = 1
            java.lang.Object r2 = r0.get(r2)
            androidx.compose.ui.unit.TextUnit$Companion r7 = androidx.compose.ui.unit.TextUnit.Companion
            androidx.compose.runtime.saveable.Saver r7 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.unit.TextUnit.Companion) r7)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r8 == 0) goto L_0x004c
            boolean r8 = r7 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r8 != 0) goto L_0x004c
            goto L_0x0055
        L_0x004c:
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r7.restore(r2)
            androidx.compose.ui.unit.TextUnit r2 = (androidx.compose.ui.unit.TextUnit) r2
            goto L_0x0056
        L_0x0055:
            r2 = 0
        L_0x0056:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r7 = r2.m7315unboximpl()
            r2 = 2
            java.lang.Object r2 = r0.get(r2)
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.runtime.saveable.Saver r9 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.text.font.FontWeight.Companion) r9)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r10 == 0) goto L_0x0073
            boolean r10 = r9 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r10 != 0) goto L_0x0073
            goto L_0x007c
        L_0x0073:
            if (r2 == 0) goto L_0x007c
            java.lang.Object r2 = r9.restore(r2)
            androidx.compose.ui.text.font.FontWeight r2 = (androidx.compose.ui.text.font.FontWeight) r2
            goto L_0x007d
        L_0x007c:
            r2 = 0
        L_0x007d:
            r9 = 3
            java.lang.Object r9 = r0.get(r9)
            if (r9 == 0) goto L_0x0087
            androidx.compose.ui.text.font.FontStyle r9 = (androidx.compose.ui.text.font.FontStyle) r9
            goto L_0x0088
        L_0x0087:
            r9 = 0
        L_0x0088:
            r10 = 4
            java.lang.Object r10 = r0.get(r10)
            if (r10 == 0) goto L_0x0092
            androidx.compose.ui.text.font.FontSynthesis r10 = (androidx.compose.ui.text.font.FontSynthesis) r10
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            r11 = 6
            java.lang.Object r11 = r0.get(r11)
            if (r11 == 0) goto L_0x009d
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x009e
        L_0x009d:
            r11 = 0
        L_0x009e:
            r12 = 7
            java.lang.Object r12 = r0.get(r12)
            androidx.compose.ui.unit.TextUnit$Companion r13 = androidx.compose.ui.unit.TextUnit.Companion
            androidx.compose.runtime.saveable.Saver r13 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.unit.TextUnit.Companion) r13)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
            if (r14 == 0) goto L_0x00b4
            boolean r14 = r13 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r14 != 0) goto L_0x00b4
            goto L_0x00bd
        L_0x00b4:
            if (r12 == 0) goto L_0x00bd
            java.lang.Object r12 = r13.restore(r12)
            androidx.compose.ui.unit.TextUnit r12 = (androidx.compose.ui.unit.TextUnit) r12
            goto L_0x00be
        L_0x00bd:
            r12 = 0
        L_0x00be:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            long r12 = r12.m7315unboximpl()
            r14 = 8
            java.lang.Object r14 = r0.get(r14)
            androidx.compose.ui.text.style.BaselineShift$Companion r15 = androidx.compose.ui.text.style.BaselineShift.Companion
            androidx.compose.runtime.saveable.Saver r15 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.text.style.BaselineShift.Companion) r15)
            boolean r16 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r16 == 0) goto L_0x00dc
            boolean r6 = r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r6 != 0) goto L_0x00dc
            goto L_0x00e5
        L_0x00dc:
            if (r14 == 0) goto L_0x00e5
            java.lang.Object r6 = r15.restore(r14)
            androidx.compose.ui.text.style.BaselineShift r6 = (androidx.compose.ui.text.style.BaselineShift) r6
            goto L_0x00e6
        L_0x00e5:
            r6 = 0
        L_0x00e6:
            r14 = 9
            java.lang.Object r14 = r0.get(r14)
            androidx.compose.ui.text.style.TextGeometricTransform$Companion r15 = androidx.compose.ui.text.style.TextGeometricTransform.Companion
            androidx.compose.runtime.saveable.Saver r15 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.text.style.TextGeometricTransform.Companion) r15)
            boolean r16 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)
            if (r16 == 0) goto L_0x00ff
            r16 = r1
            boolean r1 = r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r1 != 0) goto L_0x0101
            goto L_0x010b
        L_0x00ff:
            r16 = r1
        L_0x0101:
            if (r14 == 0) goto L_0x010b
            java.lang.Object r1 = r15.restore(r14)
            androidx.compose.ui.text.style.TextGeometricTransform r1 = (androidx.compose.ui.text.style.TextGeometricTransform) r1
            r14 = r1
            goto L_0x010c
        L_0x010b:
            r14 = 0
        L_0x010c:
            r1 = 10
            java.lang.Object r1 = r0.get(r1)
            androidx.compose.ui.text.intl.LocaleList$Companion r15 = androidx.compose.ui.text.intl.LocaleList.Companion
            androidx.compose.runtime.saveable.Saver r15 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.text.intl.LocaleList.Companion) r15)
            boolean r17 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r17 == 0) goto L_0x0125
            r17 = r2
            boolean r2 = r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r2 != 0) goto L_0x0127
            goto L_0x0131
        L_0x0125:
            r17 = r2
        L_0x0127:
            if (r1 == 0) goto L_0x0131
            java.lang.Object r1 = r15.restore(r1)
            androidx.compose.ui.text.intl.LocaleList r1 = (androidx.compose.ui.text.intl.LocaleList) r1
            r15 = r1
            goto L_0x0132
        L_0x0131:
            r15 = 0
        L_0x0132:
            r1 = 11
            java.lang.Object r1 = r0.get(r1)
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            androidx.compose.runtime.saveable.Saver r2 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.graphics.Color.Companion) r2)
            boolean r18 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r18 == 0) goto L_0x014b
            r18 = r4
            boolean r4 = r2 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r4 != 0) goto L_0x014d
            goto L_0x0156
        L_0x014b:
            r18 = r4
        L_0x014d:
            if (r1 == 0) goto L_0x0156
            java.lang.Object r1 = r2.restore(r1)
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            goto L_0x0157
        L_0x0156:
            r1 = 0
        L_0x0157:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            long r1 = r1.m4249unboximpl()
            r4 = 12
            java.lang.Object r4 = r0.get(r4)
            androidx.compose.ui.text.style.TextDecoration$Companion r5 = androidx.compose.ui.text.style.TextDecoration.Companion
            androidx.compose.runtime.saveable.Saver r5 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.text.style.TextDecoration.Companion) r5)
            boolean r20 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r20 == 0) goto L_0x0177
            r20 = r1
            boolean r1 = r5 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r1 != 0) goto L_0x0179
            goto L_0x0182
        L_0x0177:
            r20 = r1
        L_0x0179:
            if (r4 == 0) goto L_0x0182
            java.lang.Object r1 = r5.restore(r4)
            androidx.compose.ui.text.style.TextDecoration r1 = (androidx.compose.ui.text.style.TextDecoration) r1
            goto L_0x0183
        L_0x0182:
            r1 = 0
        L_0x0183:
            r2 = 13
            java.lang.Object r0 = r0.get(r2)
            androidx.compose.ui.graphics.Shadow$Companion r2 = androidx.compose.ui.graphics.Shadow.Companion
            androidx.compose.runtime.saveable.Saver r2 = androidx.compose.ui.text.SaversKt.getSaver((androidx.compose.ui.graphics.Shadow.Companion) r2)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x019a
            boolean r3 = r2 instanceof androidx.compose.ui.text.NonNullValueClassSaver
            if (r3 != 0) goto L_0x019a
            goto L_0x01a3
        L_0x019a:
            if (r0 == 0) goto L_0x01a3
            java.lang.Object r0 = r2.restore(r0)
            androidx.compose.ui.graphics.Shadow r0 = (androidx.compose.ui.graphics.Shadow) r0
            goto L_0x01a4
        L_0x01a3:
            r0 = 0
        L_0x01a4:
            r22 = 49184(0xc020, float:6.8921E-41)
            r23 = 0
            r4 = r7
            r7 = r9
            r9 = 0
            r8 = r10
            r10 = r11
            r11 = r12
            r2 = r18
            r18 = r1
            r13 = r6
            r1 = r16
            r6 = r17
            r16 = r20
            r20 = 0
            r21 = 0
            r19 = r0
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2.invoke(java.lang.Object):androidx.compose.ui.text.SpanStyle");
    }
}
