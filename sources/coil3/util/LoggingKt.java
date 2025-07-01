package coil3.util;

import coil3.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\b¨\u0006\u000b"}, d2 = {"log", "", "Lcoil3/util/Logger;", "tag", "", "throwable", "", "level", "Lcoil3/util/Logger$Level;", "message", "Lkotlin/Function0;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: logging.kt */
public final class LoggingKt {
    public static final void log(Logger logger, String str, Throwable th) {
        if (logger.getMinLevel().compareTo(Logger.Level.Error) <= 0) {
            logger.log(str, Logger.Level.Error, (String) null, th);
        }
    }

    public static final void log(Logger logger, String str, Logger.Level level, Function0<String> function0) {
        if (logger.getMinLevel().compareTo(level) <= 0) {
            logger.log(str, level, function0.invoke(), (Throwable) null);
        }
    }
}
