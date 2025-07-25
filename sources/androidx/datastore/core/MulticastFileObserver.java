package androidx.datastore.core;

import android.os.FileObserver;
import coil3.util.UtilsKt;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016R&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/MulticastFileObserver;", "Landroid/os/FileObserver;", "path", "", "(Ljava/lang/String;)V", "delegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "Landroidx/datastore/core/FileMoveObserver;", "getPath", "()Ljava/lang/String;", "onEvent", "event", "", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MulticastFileObserver.android.kt */
public final class MulticastFileObserver extends FileObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Object LOCK = new Object();
    /* access modifiers changed from: private */
    public static final Map<String, MulticastFileObserver> fileObservers = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<Function1<String, Unit>> delegates;
    private final String path;

    public /* synthetic */ MulticastFileObserver(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getPath() {
        return this.path;
    }

    private MulticastFileObserver(String str) {
        super(str, 128);
        this.path = str;
        this.delegates = new CopyOnWriteArrayList<>();
    }

    public void onEvent(int i, String str) {
        for (Function1 invoke : this.delegates) {
            invoke.invoke(str);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J*\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\r0\u0013j\u0002`\u0014H\u0003J\r\u0010\u0015\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/MulticastFileObserver$Companion;", "", "()V", "LOCK", "fileObservers", "", "", "Landroidx/datastore/core/MulticastFileObserver;", "getFileObservers$datastore_core_release$annotations", "getFileObservers$datastore_core_release", "()Ljava/util/Map;", "observe", "Lkotlinx/coroutines/flow/Flow;", "", "file", "Ljava/io/File;", "Lkotlinx/coroutines/DisposableHandle;", "parent", "observer", "Lkotlin/Function1;", "Landroidx/datastore/core/FileMoveObserver;", "removeAllObservers", "removeAllObservers$datastore_core_release", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MulticastFileObserver.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getFileObservers$datastore_core_release$annotations() {
        }

        private Companion() {
        }

        public final Map<String, MulticastFileObserver> getFileObservers$datastore_core_release() {
            return MulticastFileObserver.fileObservers;
        }

        public final Flow<Unit> observe(File file) {
            Intrinsics.checkNotNullParameter(file, UtilsKt.SCHEME_FILE);
            return FlowKt.channelFlow(new MulticastFileObserver$Companion$observe$1(file, (Continuation<? super MulticastFileObserver$Companion$observe$1>) null));
        }

        /* access modifiers changed from: private */
        public final DisposableHandle observe(File file, Function1<? super String, Unit> function1) {
            String path = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.LOCK) {
                Map<String, MulticastFileObserver> fileObservers$datastore_core_release = MulticastFileObserver.Companion.getFileObservers$datastore_core_release();
                Intrinsics.checkNotNullExpressionValue(path, "key");
                MulticastFileObserver multicastFileObserver = fileObservers$datastore_core_release.get(path);
                if (multicastFileObserver == null) {
                    multicastFileObserver = new MulticastFileObserver(path, (DefaultConstructorMarker) null);
                    fileObservers$datastore_core_release.put(path, multicastFileObserver);
                }
                MulticastFileObserver multicastFileObserver2 = multicastFileObserver;
                multicastFileObserver2.delegates.add(function1);
                if (multicastFileObserver2.delegates.size() == 1) {
                    multicastFileObserver2.startWatching();
                }
                Unit unit = Unit.INSTANCE;
            }
            return new MulticastFileObserver$Companion$$ExternalSyntheticLambda0(path, function1);
        }

        /* access modifiers changed from: private */
        public static final void observe$lambda$4(String str, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "$observer");
            synchronized (MulticastFileObserver.LOCK) {
                MulticastFileObserver multicastFileObserver = MulticastFileObserver.Companion.getFileObservers$datastore_core_release().get(str);
                if (multicastFileObserver != null) {
                    multicastFileObserver.delegates.remove(function1);
                    if (multicastFileObserver.delegates.isEmpty()) {
                        MulticastFileObserver.Companion.getFileObservers$datastore_core_release().remove(str);
                        multicastFileObserver.stopWatching();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void removeAllObservers$datastore_core_release() {
            synchronized (MulticastFileObserver.LOCK) {
                for (MulticastFileObserver stopWatching : MulticastFileObserver.Companion.getFileObservers$datastore_core_release().values()) {
                    stopWatching.stopWatching();
                }
                MulticastFileObserver.Companion.getFileObservers$datastore_core_release().clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
