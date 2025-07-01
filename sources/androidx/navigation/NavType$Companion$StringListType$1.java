package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016J(\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J(\u0010\u0012\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"androidx/navigation/NavType$Companion$StringListType$1", "Landroidx/navigation/CollectionNavType;", "", "", "name", "getName", "()Ljava/lang/String;", "emptyCollection", "get", "bundle", "Landroid/os/Bundle;", "key", "parseValue", "value", "previousValue", "put", "", "serializeAsValues", "valueEquals", "", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavType.kt */
public final class NavType$Companion$StringListType$1 extends CollectionNavType<List<? extends String>> {
    NavType$Companion$StringListType$1() {
        super(true);
    }

    public String getName() {
        return "List<String>";
    }

    public void put(Bundle bundle, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putStringArray(str, list != null ? (String[]) list.toArray(new String[0]) : null);
    }

    public List<String> get(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        String[] strArr = (String[]) bundle.get(str);
        if (strArr != null) {
            return ArraysKt.toList((T[]) strArr);
        }
        return null;
    }

    public List<String> parseValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return CollectionsKt.listOf(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.CollectionsKt.plus(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> parseValue(java.lang.String r2, java.util.List<java.lang.String> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0017
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r0 = r1.parseValue((java.lang.String) r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r3 = kotlin.collections.CollectionsKt.plus(r3, r0)
            if (r3 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            return r3
        L_0x0017:
            java.util.List r2 = r1.parseValue((java.lang.String) r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$StringListType$1.parseValue(java.lang.String, java.util.List):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean valueEquals(java.util.List<java.lang.String> r4, java.util.List<java.lang.String> r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x000f
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.Object[] r4 = r4.toArray(r2)
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L_0x0010
        L_0x000f:
            r4 = r1
        L_0x0010:
            if (r5 == 0) goto L_0x001d
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r5 = r5.toArray(r0)
            r1 = r5
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x001d:
            boolean r4 = kotlin.collections.ArraysKt.contentDeepEquals(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$StringListType$1.valueEquals(java.util.List, java.util.List):boolean");
    }

    public List<String> serializeAsValues(List<String> list) {
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String encode : iterable) {
            arrayList.add(Uri.encode(encode));
        }
        return (List) arrayList;
    }

    public List<String> emptyCollection() {
        return CollectionsKt.emptyList();
    }
}
