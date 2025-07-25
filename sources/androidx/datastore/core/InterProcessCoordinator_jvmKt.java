package androidx.datastore.core;

import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"createSingleProcessCoordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "file", "Ljava/io/File;", "datastore-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InterProcessCoordinator.jvm.kt */
public final class InterProcessCoordinator_jvmKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(File file) {
        Intrinsics.checkNotNullParameter(file, UtilsKt.SCHEME_FILE);
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.canonicalFile.absolutePath");
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(absolutePath);
    }
}
