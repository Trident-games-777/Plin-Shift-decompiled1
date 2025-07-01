package coil3.request;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"requestManager", "Lcoil3/request/ViewTargetRequestManager;", "Landroid/view/View;", "getRequestManager", "(Landroid/view/View;)Lcoil3/request/ViewTargetRequestManager;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ViewTargetRequestManager.kt */
public final class ViewTargetRequestManagerKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: coil3.request.ViewTargetRequestManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final coil3.request.ViewTargetRequestManager getRequestManager(android.view.View r3) {
        /*
            int r0 = coil3.core.R.id.coil3_request_manager
            java.lang.Object r0 = r3.getTag(r0)
            boolean r1 = r0 instanceof coil3.request.ViewTargetRequestManager
            r2 = 0
            if (r1 == 0) goto L_0x000e
            coil3.request.ViewTargetRequestManager r0 = (coil3.request.ViewTargetRequestManager) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 != 0) goto L_0x0037
            monitor-enter(r3)
            int r0 = coil3.core.R.id.coil3_request_manager     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r3.getTag(r0)     // Catch:{ all -> 0x0034 }
            boolean r1 = r0 instanceof coil3.request.ViewTargetRequestManager     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x001f
            r2 = r0
            coil3.request.ViewTargetRequestManager r2 = (coil3.request.ViewTargetRequestManager) r2     // Catch:{ all -> 0x0034 }
        L_0x001f:
            if (r2 == 0) goto L_0x0022
            goto L_0x0032
        L_0x0022:
            coil3.request.ViewTargetRequestManager r2 = new coil3.request.ViewTargetRequestManager     // Catch:{ all -> 0x0034 }
            r2.<init>(r3)     // Catch:{ all -> 0x0034 }
            r0 = r2
            android.view.View$OnAttachStateChangeListener r0 = (android.view.View.OnAttachStateChangeListener) r0     // Catch:{ all -> 0x0034 }
            r3.addOnAttachStateChangeListener(r0)     // Catch:{ all -> 0x0034 }
            int r0 = coil3.core.R.id.coil3_request_manager     // Catch:{ all -> 0x0034 }
            r3.setTag(r0, r2)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)
            return r2
        L_0x0034:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.request.ViewTargetRequestManagerKt.getRequestManager(android.view.View):coil3.request.ViewTargetRequestManager");
    }
}
