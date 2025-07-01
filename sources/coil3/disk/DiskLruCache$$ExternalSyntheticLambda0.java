package coil3.disk;

import java.io.IOException;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DiskLruCache$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ DiskLruCache f$0;

    public /* synthetic */ DiskLruCache$$ExternalSyntheticLambda0(DiskLruCache diskLruCache) {
        this.f$0 = diskLruCache;
    }

    public final Object invoke(Object obj) {
        return DiskLruCache.newJournalWriter$lambda$4(this.f$0, (IOException) obj);
    }
}
