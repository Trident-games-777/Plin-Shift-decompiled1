package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002JB\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 HH¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PathTreeWalk.kt */
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    /* access modifiers changed from: private */
    public final Path start;

    public PathTreeWalk(Path path, PathWalkOption[] pathWalkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "start");
        Intrinsics.checkNotNullParameter(pathWalkOptionArr, "options");
        this.start = path;
        this.options = pathWalkOptionArr;
    }

    /* access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt.contains((T[]) this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    /* access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt.contains((T[]) this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final boolean isBFS() {
        return ArraysKt.contains((T[]) this.options, PathWalkOption.BREADTH_FIRST);
    }

    public Iterator<Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) {
        Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            PathsKt.checkFileName(path);
        }
        LinkOption[] access$getLinkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions, access$getLinkOptions.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                sequenceScope.yield(path, continuation);
                return Unit.INSTANCE;
            }
        } else if (!PathTreeWalkKt.createsCycle(pathNode)) {
            if (getIncludeDirectories()) {
                sequenceScope.yield(path, continuation);
            }
            LinkOption[] access$getLinkOptions2 = getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions2, access$getLinkOptions2.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                function1.invoke(directoryEntriesReader.readEntries(pathNode));
            }
        } else {
            throw new FileSystemLoopException(path.toString());
        }
        return Unit.INSTANCE;
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new PathTreeWalk$dfsIterator$1(this, (Continuation<? super PathTreeWalk$dfsIterator$1>) null));
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new PathTreeWalk$bfsIterator$1(this, (Continuation<? super PathTreeWalk$bfsIterator$1>) null));
    }
}
