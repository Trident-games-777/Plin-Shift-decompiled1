package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ8\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u0011\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "nodeData", "", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "addPathNodes", "", "clear", "", "parsePathString", "pathData", "", "pathStringToNodes", "resizeNodeData", "dataCount", "", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", "target", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParser {
    private float[] nodeData = new float[64];
    private ArrayList<PathNode> nodes;

    public final void clear() {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final PathParser parsePathString(String str) {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.nodes = arrayList;
        } else {
            arrayList.clear();
        }
        pathStringToNodes(str, arrayList);
        return this;
    }

    public static /* synthetic */ ArrayList pathStringToNodes$default(PathParser pathParser, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = new ArrayList();
        }
        return pathParser.pathStringToNodes(str, arrayList);
    }

    public final ArrayList<PathNode> pathStringToNodes(String str, ArrayList<PathNode> arrayList) {
        int i;
        char charAt;
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length && Intrinsics.compare((int) str.charAt(i3), 32) <= 0) {
            i3++;
        }
        while (length > i3 && Intrinsics.compare((int) str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i4 = 0;
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                charAt = str.charAt(i3);
                char c = charAt | ' ';
                if ((c - 'a') * (c - 'z') <= 0 && c != 'e') {
                    break;
                } else if (i >= length) {
                    charAt = 0;
                    break;
                } else {
                    i3 = i;
                }
            }
            if (charAt != 0) {
                if ((charAt | ' ') != 'z') {
                    i4 = 0;
                    while (true) {
                        if (i >= length || Intrinsics.compare((int) str.charAt(i), 32) > 0) {
                            long nextFloat = FastFloatParserKt.nextFloat(str, i, length);
                            i2 = (int) (nextFloat >>> 32);
                            float intBitsToFloat = Float.intBitsToFloat((int) (nextFloat & 4294967295L));
                            if (!Float.isNaN(intBitsToFloat)) {
                                float[] fArr = this.nodeData;
                                int i5 = i4 + 1;
                                fArr[i4] = intBitsToFloat;
                                if (i5 >= fArr.length) {
                                    float[] fArr2 = new float[(i5 * 2)];
                                    this.nodeData = fArr2;
                                    ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i4 = i5;
                            }
                            while (i2 < length && str.charAt(i2) == ',') {
                                i2++;
                            }
                            if (i2 >= length || Float.isNaN(intBitsToFloat)) {
                                i = i2;
                            } else {
                                i = i2;
                            }
                        } else {
                            i++;
                        }
                    }
                    i = i2;
                }
                PathNodeKt.addPathNodes(charAt, arrayList, this.nodeData, i4);
            }
            i3 = i;
        }
        return arrayList;
    }

    private final void resizeNodeData(int i) {
        float[] fArr = this.nodeData;
        if (i >= fArr.length) {
            float[] fArr2 = new float[(i * 2)];
            this.nodeData = fArr2;
            ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
        }
    }

    public final PathParser addPathNodes(List<? extends PathNode> list) {
        ArrayList<PathNode> arrayList = this.nodes;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.nodes = arrayList;
        }
        arrayList.addAll(list);
        return this;
    }

    public final List<PathNode> toNodes() {
        ArrayList<PathNode> arrayList = this.nodes;
        return arrayList != null ? arrayList : CollectionsKt.emptyList();
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = androidx.compose.ui.graphics.vector.PathParserKt.toPath(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.graphics.Path toPath(androidx.compose.ui.graphics.Path r2) {
        /*
            r1 = this;
            java.util.ArrayList<androidx.compose.ui.graphics.vector.PathNode> r0 = r1.nodes
            if (r0 == 0) goto L_0x000e
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.graphics.Path r2 = androidx.compose.ui.graphics.vector.PathParserKt.toPath(r0, r2)
            if (r2 != 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            return r2
        L_0x000e:
            androidx.compose.ui.graphics.Path r2 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser.toPath(androidx.compose.ui.graphics.Path):androidx.compose.ui.graphics.Path");
    }
}
