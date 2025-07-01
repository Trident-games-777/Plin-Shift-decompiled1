package androidx.compose.ui.res;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a1\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rR\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "path", "", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterResources.android.kt */
public final class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.ui.graphics.ImageBitmap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.painter.Painter painterResource(int r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            java.lang.String r0 = "C(painterResource)58@2487L7,61@2609L7,63@2696L7:PainterResources.android.kt#ccshc7"
            r1 = 473971343(0x1c403a8f, float:6.3603156E-22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r2 = "androidx.compose.ui.res.painterResource (PainterResources.android.kt:57)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r0, r2)
        L_0x0014:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r2)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            android.content.Context r0 = (android.content.Context) r0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r2)
            r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            android.content.res.Resources r5 = r0.getResources()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalResourceIdCache()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r2)
            java.lang.Object r1 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.res.ResourceIdCache r1 = (androidx.compose.ui.res.ResourceIdCache) r1
            android.util.TypedValue r1 = r1.resolveResourcePath(r5, r11)
            java.lang.CharSequence r2 = r1.string
            r3 = 1
            r10 = 0
            if (r2 == 0) goto L_0x008b
            java.lang.String r4 = ".xml"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r6 = 2
            r7 = 0
            boolean r4 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r4, (boolean) r10, (int) r6, (java.lang.Object) r7)
            if (r4 != r3) goto L_0x008b
            r2 = -803040357(0xffffffffd022939b, float:-1.09103299E10)
            r12.startReplaceGroup(r2)
            java.lang.String r2 = "69@2937L72,70@3018L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            android.content.res.Resources$Theme r4 = r0.getTheme()
            int r7 = r1.changingConfigurations
            int r13 = r13 << 6
            r9 = r13 & 896(0x380, float:1.256E-42)
            r6 = r11
            r8 = r12
            androidx.compose.ui.graphics.vector.ImageVector r11 = loadVectorResource(r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.graphics.vector.VectorPainter r11 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r11, r8, r10)
            r8.endReplaceGroup()
            androidx.compose.ui.graphics.painter.Painter r11 = (androidx.compose.ui.graphics.painter.Painter) r11
            goto L_0x00ed
        L_0x008b:
            r6 = r11
            r8 = r12
            r11 = -802884675(0xffffffffd024f3bd, float:-1.10697482E10)
            r8.startReplaceGroup(r11)
            java.lang.String r11 = "73@3138L96"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r11)
            android.content.res.Resources$Theme r11 = r0.getTheme()
            r12 = -1411370574(0xffffffffabe031b2, float:-1.592995E-12)
            java.lang.String r0 = "CC(remember):PainterResources.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r0)
            boolean r12 = r8.changed((java.lang.Object) r2)
            r0 = r13 & 14
            r0 = r0 ^ 6
            r1 = 4
            if (r0 <= r1) goto L_0x00b5
            boolean r0 = r8.changed((int) r6)
            if (r0 != 0) goto L_0x00bb
        L_0x00b5:
            r13 = r13 & 6
            if (r13 != r1) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r3 = r10
        L_0x00bb:
            r12 = r12 | r3
            boolean r11 = r8.changed((java.lang.Object) r11)
            r11 = r11 | r12
            java.lang.Object r12 = r8.rememberedValue()
            if (r11 != 0) goto L_0x00cf
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x00d6
        L_0x00cf:
            androidx.compose.ui.graphics.ImageBitmap r12 = loadImageBitmapResource(r2, r5, r6)
            r8.updateRememberedValue(r12)
        L_0x00d6:
            r1 = r12
            androidx.compose.ui.graphics.ImageBitmap r1 = (androidx.compose.ui.graphics.ImageBitmap) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.graphics.painter.BitmapPainter r0 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r6 = 6
            r7 = 0
            r2 = 0
            r4 = 0
            r0.<init>(r1, r2, r4, r6, r7)
            r8.endReplaceGroup()
            r11 = r0
            androidx.compose.ui.graphics.painter.Painter r11 = (androidx.compose.ui.graphics.painter.Painter) r11
        L_0x00ed:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x00f6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f6:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.res.PainterResources_androidKt.painterResource(int, androidx.compose.runtime.Composer, int):androidx.compose.ui.graphics.painter.Painter");
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i, int i2, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 21855625, "C(loadVectorResource)P(3,2,1)92@3720L7:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21855625, i3, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:91)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageVectorCache imageVectorCache = (ImageVectorCache) consume;
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i);
            if (Intrinsics.areEqual((Object) XmlVectorParser_androidKt.seekToStartTag(xml).getName(), (Object) "vector")) {
                imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml, i2);
                imageVectorCache.set(key, imageVectorEntry);
            } else {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imageVector;
    }

    private static final ImageBitmap loadImageBitmapResource(CharSequence charSequence, Resources resources, int i) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.Companion, resources, i);
        } catch (Exception e) {
            throw new ResourceResolutionException("Error attempting to load resource: " + charSequence, e);
        }
    }
}
