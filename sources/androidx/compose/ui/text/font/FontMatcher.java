package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000fJ4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0011JF\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\b\u0017\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontMatcher.kt */
public final class FontMatcher {
    public static final int $stable = 0;

    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3, int i, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i & 8) != 0) {
            fontWeight3 = null;
        }
        int size = list.size();
        int i2 = 0;
        FontWeight fontWeight5 = null;
        while (true) {
            if (i2 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i2)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i2++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Object obj2 = list.get(i3);
            if (Intrinsics.areEqual((Object) ((Font) obj2).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public final List<Font> filterByClosestWeight$ui_text_release(List<? extends Font> list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3) {
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = list.get(i2);
            if (Intrinsics.areEqual((Object) ((Font) obj).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m6672matchFontRetOiIg(FontFamily fontFamily, FontWeight fontWeight, int i) {
        if (fontFamily instanceof FontListFontFamily) {
            return m6673matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m6673matchFontRetOiIg(FontListFontFamily fontListFontFamily, FontWeight fontWeight, int i) {
        return m6674matchFontRetOiIg((List<? extends Font>) fontListFontFamily.getFonts(), fontWeight, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.util.List<? extends androidx.compose.ui.text.font.Font>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.util.List<? extends androidx.compose.ui.text.font.Font>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.font.Font> m6674matchFontRetOiIg(java.util.List<? extends androidx.compose.ui.text.font.Font> r9, androidx.compose.ui.text.font.FontWeight r10, int r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.size()
            r0.<init>(r1)
            int r1 = r9.size()
            r2 = 0
            r3 = r2
        L_0x000f:
            if (r3 >= r1) goto L_0x0035
            java.lang.Object r4 = r9.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r6 = r5.getWeight()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r6 == 0) goto L_0x0032
            int r5 = r5.m6650getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m6678equalsimpl0(r5, r11)
            if (r5 == 0) goto L_0x0032
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            r5.add(r4)
        L_0x0032:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0035:
            java.util.List r0 = (java.util.List) r0
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0041
            return r0
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.size()
            r0.<init>(r1)
            int r1 = r9.size()
            r3 = r2
        L_0x004f:
            if (r3 >= r1) goto L_0x006b
            java.lang.Object r4 = r9.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.m6650getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m6678equalsimpl0(r5, r11)
            if (r5 == 0) goto L_0x0068
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            r5.add(r4)
        L_0x0068:
            int r3 = r3 + 1
            goto L_0x004f
        L_0x006b:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r9 = r0
        L_0x0077:
            java.util.List r9 = (java.util.List) r9
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW400()
            int r11 = r10.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            r0 = 0
            if (r11 >= 0) goto L_0x00eb
            int r11 = r9.size()
            r1 = r0
            r3 = r2
        L_0x008c:
            if (r3 >= r11) goto L_0x00bc
            java.lang.Object r4 = r9.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.FontWeight r4 = r4.getWeight()
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 >= 0) goto L_0x00a8
            if (r0 == 0) goto L_0x00a6
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r5 <= 0) goto L_0x00b7
        L_0x00a6:
            r0 = r4
            goto L_0x00b7
        L_0x00a8:
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 <= 0) goto L_0x00ba
            if (r1 == 0) goto L_0x00b6
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r1)
            if (r5 >= 0) goto L_0x00b7
        L_0x00b6:
            r1 = r4
        L_0x00b7:
            int r3 = r3 + 1
            goto L_0x008c
        L_0x00ba:
            r0 = r4
            r1 = r0
        L_0x00bc:
            if (r0 != 0) goto L_0x00bf
            r0 = r1
        L_0x00bf:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x00cc:
            if (r2 >= r11) goto L_0x00e8
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x00e5
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x00e5:
            int r2 = r2 + 1
            goto L_0x00cc
        L_0x00e8:
            java.util.List r10 = (java.util.List) r10
            return r10
        L_0x00eb:
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r11 = r10.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r11 <= 0) goto L_0x015d
            int r11 = r9.size()
            r1 = r0
            r3 = r2
        L_0x00fd:
            if (r3 >= r11) goto L_0x012d
            java.lang.Object r4 = r9.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.FontWeight r4 = r4.getWeight()
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 >= 0) goto L_0x0119
            if (r0 == 0) goto L_0x0117
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r5 <= 0) goto L_0x0128
        L_0x0117:
            r0 = r4
            goto L_0x0128
        L_0x0119:
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 <= 0) goto L_0x012b
            if (r1 == 0) goto L_0x0127
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r1)
            if (r5 >= 0) goto L_0x0128
        L_0x0127:
            r1 = r4
        L_0x0128:
            int r3 = r3 + 1
            goto L_0x00fd
        L_0x012b:
            r0 = r4
            r1 = r0
        L_0x012d:
            if (r1 != 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r0 = r1
        L_0x0131:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x013e:
            if (r2 >= r11) goto L_0x015a
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0157
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x0157:
            int r2 = r2 + 1
            goto L_0x013e
        L_0x015a:
            java.util.List r10 = (java.util.List) r10
            return r10
        L_0x015d:
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r1 = r9.size()
            r4 = r0
            r5 = r4
            r3 = r2
        L_0x016a:
            if (r3 >= r1) goto L_0x01a2
            java.lang.Object r6 = r9.get(r3)
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            androidx.compose.ui.text.font.FontWeight r6 = r6.getWeight()
            if (r11 == 0) goto L_0x017e
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r7 > 0) goto L_0x019d
        L_0x017e:
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r7 >= 0) goto L_0x018e
            if (r4 == 0) goto L_0x018c
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r4)
            if (r7 <= 0) goto L_0x019d
        L_0x018c:
            r4 = r6
            goto L_0x019d
        L_0x018e:
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r7 <= 0) goto L_0x01a0
            if (r5 == 0) goto L_0x019c
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r5)
            if (r7 >= 0) goto L_0x019d
        L_0x019c:
            r5 = r6
        L_0x019d:
            int r3 = r3 + 1
            goto L_0x016a
        L_0x01a0:
            r4 = r6
            r5 = r4
        L_0x01a2:
            if (r5 != 0) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            r4 = r5
        L_0x01a6:
            java.util.ArrayList r11 = new java.util.ArrayList
            int r1 = r9.size()
            r11.<init>(r1)
            int r1 = r9.size()
            r3 = r2
        L_0x01b4:
            if (r3 >= r1) goto L_0x01d0
            java.lang.Object r5 = r9.get(r3)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            androidx.compose.ui.text.font.FontWeight r6 = r6.getWeight()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x01cd
            r6 = r11
            java.util.Collection r6 = (java.util.Collection) r6
            r6.add(r5)
        L_0x01cd:
            int r3 = r3 + 1
            goto L_0x01b4
        L_0x01d0:
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x024e
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r1 = r9.size()
            r3 = r0
            r4 = r2
        L_0x01e6:
            if (r4 >= r1) goto L_0x021e
            java.lang.Object r5 = r9.get(r4)
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            if (r11 == 0) goto L_0x01fa
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r6 < 0) goto L_0x0219
        L_0x01fa:
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r6 >= 0) goto L_0x020a
            if (r0 == 0) goto L_0x0208
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r6 <= 0) goto L_0x0219
        L_0x0208:
            r0 = r5
            goto L_0x0219
        L_0x020a:
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r6 <= 0) goto L_0x021c
            if (r3 == 0) goto L_0x0218
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r3)
            if (r6 >= 0) goto L_0x0219
        L_0x0218:
            r3 = r5
        L_0x0219:
            int r4 = r4 + 1
            goto L_0x01e6
        L_0x021c:
            r0 = r5
            r3 = r0
        L_0x021e:
            if (r3 != 0) goto L_0x0221
            goto L_0x0222
        L_0x0221:
            r0 = r3
        L_0x0222:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x022f:
            if (r2 >= r11) goto L_0x024b
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0248
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x0248:
            int r2 = r2 + 1
            goto L_0x022f
        L_0x024b:
            r11 = r10
            java.util.List r11 = (java.util.List) r11
        L_0x024e:
            java.util.List r11 = (java.util.List) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontMatcher.m6674matchFontRetOiIg(java.util.List, androidx.compose.ui.text.font.FontWeight, int):java.util.List");
    }
}
