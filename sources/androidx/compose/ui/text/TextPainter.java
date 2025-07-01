package androidx.compose.ui.text;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPainter.kt */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void paint(androidx.compose.ui.graphics.Canvas r14, androidx.compose.ui.text.TextLayoutResult r15) {
        /*
            r13 = this;
            boolean r0 = r15.getHasVisualOverflow()
            r1 = 0
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.text.TextLayoutInput r0 = r15.getLayoutInput()
            int r0 = r0.m6533getOverflowgIe3tQ8()
            androidx.compose.ui.text.style.TextOverflow$Companion r2 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r2 = r2.m7039getVisiblegIe3tQ8()
            boolean r0 = androidx.compose.ui.text.style.TextOverflow.m7030equalsimpl0(r0, r2)
            if (r0 != 0) goto L_0x001e
            r0 = 1
            r2 = r0
            goto L_0x001f
        L_0x001e:
            r2 = r1
        L_0x001f:
            if (r2 == 0) goto L_0x0049
            long r3 = r15.m6537getSizeYbymL2g()
            int r0 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r3)
            float r0 = (float) r0
            long r3 = r15.m6537getSizeYbymL2g()
            int r3 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r3)
            float r3 = (float) r3
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m4003getZeroF1C5BW0()
            long r6 = androidx.compose.ui.geometry.SizeKt.Size(r0, r3)
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.geometry.RectKt.m4027Recttz77jQw(r4, r6)
            r14.save()
            r3 = 2
            r4 = 0
            androidx.compose.ui.graphics.Canvas.m4202clipRectmtrdDE$default(r14, r0, r1, r3, r4)
        L_0x0049:
            androidx.compose.ui.text.TextLayoutInput r0 = r15.getLayoutInput()
            androidx.compose.ui.text.TextStyle r0 = r0.getStyle()
            androidx.compose.ui.text.SpanStyle r0 = r0.getSpanStyle$ui_text_release()
            androidx.compose.ui.text.style.TextDecoration r1 = r0.getTextDecoration()
            if (r1 != 0) goto L_0x0061
            androidx.compose.ui.text.style.TextDecoration$Companion r1 = androidx.compose.ui.text.style.TextDecoration.Companion
            androidx.compose.ui.text.style.TextDecoration r1 = r1.getNone()
        L_0x0061:
            r8 = r1
            androidx.compose.ui.graphics.Shadow r1 = r0.getShadow()
            if (r1 != 0) goto L_0x006e
            androidx.compose.ui.graphics.Shadow$Companion r1 = androidx.compose.ui.graphics.Shadow.Companion
            androidx.compose.ui.graphics.Shadow r1 = r1.getNone()
        L_0x006e:
            r7 = r1
            androidx.compose.ui.graphics.drawscope.DrawStyle r1 = r0.getDrawStyle()
            if (r1 != 0) goto L_0x0079
            androidx.compose.ui.graphics.drawscope.Fill r1 = androidx.compose.ui.graphics.drawscope.Fill.INSTANCE
            androidx.compose.ui.graphics.drawscope.DrawStyle r1 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r1
        L_0x0079:
            r9 = r1
            androidx.compose.ui.graphics.Brush r5 = r0.getBrush()     // Catch:{ all -> 0x00d1 }
            if (r5 == 0) goto L_0x00a5
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r0.getTextForegroundStyle$ui_text_release()     // Catch:{ all -> 0x00d1 }
            androidx.compose.ui.text.style.TextForegroundStyle$Unspecified r3 = androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.INSTANCE     // Catch:{ all -> 0x00d1 }
            if (r1 == r3) goto L_0x0095
            androidx.compose.ui.text.style.TextForegroundStyle r0 = r0.getTextForegroundStyle$ui_text_release()     // Catch:{ all -> 0x0091 }
            float r0 = r0.getAlpha()     // Catch:{ all -> 0x0091 }
            goto L_0x0097
        L_0x0091:
            r0 = move-exception
            r15 = r0
            r4 = r14
            goto L_0x00d4
        L_0x0095:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x0097:
            r6 = r0
            androidx.compose.ui.text.MultiParagraph r3 = r15.getMultiParagraph()     // Catch:{ all -> 0x00d1 }
            r11 = 64
            r12 = 0
            r10 = 0
            r4 = r14
            androidx.compose.ui.text.MultiParagraph.m6421painthn5TExg$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00cf }
            goto L_0x00c9
        L_0x00a5:
            r4 = r14
            androidx.compose.ui.text.style.TextForegroundStyle r14 = r0.getTextForegroundStyle$ui_text_release()     // Catch:{ all -> 0x00cf }
            androidx.compose.ui.text.style.TextForegroundStyle$Unspecified r1 = androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.INSTANCE     // Catch:{ all -> 0x00cf }
            if (r14 == r1) goto L_0x00b7
            androidx.compose.ui.text.style.TextForegroundStyle r14 = r0.getTextForegroundStyle$ui_text_release()     // Catch:{ all -> 0x00cf }
            long r0 = r14.m7007getColor0d7_KjU()     // Catch:{ all -> 0x00cf }
            goto L_0x00bd
        L_0x00b7:
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x00cf }
            long r0 = r14.m4265getBlack0d7_KjU()     // Catch:{ all -> 0x00cf }
        L_0x00bd:
            r5 = r0
            androidx.compose.ui.text.MultiParagraph r3 = r15.getMultiParagraph()     // Catch:{ all -> 0x00cf }
            r11 = 32
            r12 = 0
            r10 = 0
            androidx.compose.ui.text.MultiParagraph.m6419paintLG529CI$default(r3, r4, r5, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00cf }
        L_0x00c9:
            if (r2 == 0) goto L_0x00ce
            r4.restore()
        L_0x00ce:
            return
        L_0x00cf:
            r0 = move-exception
            goto L_0x00d3
        L_0x00d1:
            r0 = move-exception
            r4 = r14
        L_0x00d3:
            r15 = r0
        L_0x00d4:
            if (r2 == 0) goto L_0x00d9
            r4.restore()
        L_0x00d9:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextPainter.paint(androidx.compose.ui.graphics.Canvas, androidx.compose.ui.text.TextLayoutResult):void");
    }
}
