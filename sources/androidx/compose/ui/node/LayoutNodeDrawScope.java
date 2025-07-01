package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J<\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)Jq\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jq\u0010*\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>JY\u0010?\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJY\u0010?\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020 H\u0016J<\u0010F\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\bG\u0010HJO\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJm\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020O2\b\b\u0002\u0010S\u001a\u00020Q2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJw\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020O2\b\b\u0002\u0010S\u001a\u00020Q2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010V\u001a\u00020WH\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJk\u0010Z\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010cJk\u0010Z\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJY\u0010f\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJY\u0010f\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bi\u0010jJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010+\u001a\u00020,2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010oJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010;\u001a\u00020<2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qJq\u0010r\u001a\u00020 2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010xJq\u0010r\u001a\u00020 2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010zJY\u0010{\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\b|\u0010hJY\u0010{\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010jJf\u0010~\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\t\b\u0002\u0010\u001a\u00030\u00012\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001Jf\u0010~\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\t\b\u0002\u0010\u001a\u00030\u00012\b\b\u0002\u00103\u001a\u0002042\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00020 *\u00020\u00152\u0006\u0010!\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'J@\u0010\u0001\u001a\u00020 *\u00020'2\b\b\u0002\u0010\u001c\u001a\u00020Q2\u001a\u0010\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0\u0001¢\u0006\u0003\b\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u0001*\u00020\u001dH\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\r*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\r*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u0001J\u0010\u0010¡\u0001\u001a\u00030¢\u0001*\u00030£\u0001H\u0001J\u001b\u0010¤\u0001\u001a\u00020\u001d*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010\u0001J\u001c\u0010¦\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001e\u0010¦\u0001\u001a\u00030\u0001*\u00020\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010¨\u0001J\u001f\u0010¦\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8VX\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\r8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0012\u0010\u0018\u001a\u00020\u0019X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006«\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "record", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeDrawScope.kt */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope() {
        this((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m6006drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4741drawArcillE91I(brush, f, f2, z, j, j2, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m6007drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4742drawArcyD3GUKo(j, f, f2, z, j2, j3, f3, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m6008drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4743drawCircleV9BoPsw(brush, f, j, f2, drawStyle, colorFilter, i);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m6009drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4744drawCircleVaOC9Bg(j, f, j2, f2, drawStyle, colorFilter, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m6011drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4745drawImage9jGpkUE(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m6012drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        this.canvasDrawScope.m4746drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m6013drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4747drawImagegbVJVH8(imageBitmap, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m6014drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m4748drawLine1RTmtNc(brush, j, j2, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m6015drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m4749drawLineNGM6Ib0(j, j2, j3, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m6016drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4750drawOvalAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m6017drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4751drawOvalnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m6018drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4752drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m6019drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4753drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m6020drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        this.canvasDrawScope.m4754drawPointsF8ZwMP8(list, i, j, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m6021drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        this.canvasDrawScope.m4755drawPointsGsft0Ws(list, i, brush, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m6022drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4756drawRectAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m6023drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4757drawRectnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m6024drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4758drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m6025drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        this.canvasDrawScope.m4759drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle, f, colorFilter, i);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m6026getCenterF1C5BW0() {
        return this.canvasDrawScope.m4864getCenterF1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m6027getSizeNHjbRc() {
        return this.canvasDrawScope.m4865getSizeNHjbRc();
    }

    /* renamed from: record-JVtK1S4  reason: not valid java name */
    public void m6028recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1<? super DrawScope, Unit> function1) {
        this.canvasDrawScope.m4866recordJVtK1S4(graphicsLayer, j, function1);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m6029roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.m7085roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m6030roundToPx0680j_4(float f) {
        return this.canvasDrawScope.m7086roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m6031toDpGaN1DYA(long j) {
        return this.canvasDrawScope.m7222toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m6032toDpu2uoSUM(float f) {
        return this.canvasDrawScope.m7087toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m6033toDpu2uoSUM(int i) {
        return this.canvasDrawScope.m7088toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m6034toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.m7089toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m6035toPxR2X_6o(long j) {
        return this.canvasDrawScope.m7090toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m6036toPx0680j_4(float f) {
        return this.canvasDrawScope.m7091toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m6037toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.m7092toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m6038toSp0xMU5do(float f) {
        return this.canvasDrawScope.m7223toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m6039toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.m7093toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m6040toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.m7094toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2) {
        this.canvasDrawScope = canvasDrawScope2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        DelegatableNode delegatableNode = drawModifierNode;
        Modifier.Node access$nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(delegatableNode);
        if (access$nextDrawNode != null) {
            int r1 = NodeKind.m6139constructorimpl(4);
            MutableVector mutableVector = null;
            while (access$nextDrawNode != null) {
                if (access$nextDrawNode instanceof DrawModifierNode) {
                    performDraw((DrawModifierNode) access$nextDrawNode, canvas, getDrawContext().getGraphicsLayer());
                } else if ((access$nextDrawNode.getKindSet$ui_release() & r1) != 0 && (access$nextDrawNode instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) access$nextDrawNode).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                            i++;
                            if (i == 1) {
                                access$nextDrawNode = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (access$nextDrawNode != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(access$nextDrawNode);
                                    }
                                    access$nextDrawNode = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                access$nextDrawNode = DelegatableNodeKt.pop(mutableVector);
            }
            return;
        }
        NodeCoordinator r2 = DelegatableNodeKt.m5954requireCoordinator64DMado(delegatableNode, NodeKind.m6139constructorimpl(4));
        if (r2.getTail() == drawModifierNode.getNode()) {
            r2 = r2.getWrapped$ui_release();
            Intrinsics.checkNotNull(r2);
        }
        r2.performDraw(canvas, getDrawContext().getGraphicsLayer());
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator r6 = DelegatableNodeKt.m5954requireCoordinator64DMado(drawModifierNode, NodeKind.m6139constructorimpl(4));
        Canvas canvas2 = canvas;
        r6.getLayoutNode().getMDrawScope$ui_release().m6010drawDirecteZhPAX0$ui_release(canvas2, IntSizeKt.m7295toSizeozmzZPI(r6.m6108getSizeYbymL2g()), r6, drawModifierNode, graphicsLayer);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: drawDirect-eZhPAX0$ui_release  reason: not valid java name */
    public final void m6010drawDirecteZhPAX0$ui_release(Canvas canvas, long j, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode, GraphicsLayer graphicsLayer) {
        DrawModifierNode drawModifierNode2 = drawModifierNode;
        DrawModifierNode drawModifierNode3 = this.drawNode;
        this.drawNode = drawModifierNode2;
        DrawScope drawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        Density density = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long r7 = drawScope.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(nodeCoordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.m4807setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            drawModifierNode2.draw(this);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.m4807setSizeuvyYCjk(r7);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            this.drawNode = drawModifierNode3;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = drawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.m4807setSizeuvyYCjk(r7);
            drawContext3.setGraphicsLayer(graphicsLayer2);
            throw th;
        }
    }

    /* renamed from: draw-eZhPAX0$ui_release  reason: not valid java name */
    public final void m6005draweZhPAX0$ui_release(Canvas canvas, long j, NodeCoordinator nodeCoordinator, Modifier.Node node, GraphicsLayer graphicsLayer) {
        int r0 = NodeKind.m6139constructorimpl(4);
        Modifier.Node node2 = node;
        MutableVector mutableVector = null;
        while (node2 != null) {
            if (node2 instanceof DrawModifierNode) {
                m6010drawDirecteZhPAX0$ui_release(canvas, j, nodeCoordinator, (DrawModifierNode) node2, graphicsLayer);
            } else if ((node2.getKindSet$ui_release() & r0) != 0 && (node2 instanceof DelegatingNode)) {
                int i = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                        i++;
                        if (i == 1) {
                            node2 = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
