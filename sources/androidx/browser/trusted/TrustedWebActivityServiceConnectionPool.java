package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class TrustedWebActivityServiceConnectionPool {
    private static final String TAG = "TWAConnectionPool";
    private final Map<Uri, ConnectionHolder> mConnections = new HashMap();
    private final Context mContext;

    private TrustedWebActivityServiceConnectionPool(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static TrustedWebActivityServiceConnectionPool create(Context context) {
        return new TrustedWebActivityServiceConnectionPool(context);
    }

    public ListenableFuture<TrustedWebActivityServiceConnection> connect(Uri uri, Set<Token> set, Executor executor) {
        ConnectionHolder connectionHolder = this.mConnections.get(uri);
        if (connectionHolder != null) {
            return connectionHolder.getServiceWrapper();
        }
        Intent createServiceIntent = createServiceIntent(this.mContext, uri, set, true);
        if (createServiceIntent == null) {
            return FutureUtils.immediateFailedFuture(new IllegalArgumentException("No service exists for scope"));
        }
        ConnectionHolder connectionHolder2 = new ConnectionHolder(new TrustedWebActivityServiceConnectionPool$$ExternalSyntheticLambda0(this, uri));
        this.mConnections.put(uri, connectionHolder2);
        new BindToServiceAsyncTask(this.mContext, createServiceIntent, connectionHolder2).executeOnExecutor(executor, new Void[0]);
        return connectionHolder2.getServiceWrapper();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$connect$0$androidx-browser-trusted-TrustedWebActivityServiceConnectionPool  reason: not valid java name */
    public /* synthetic */ void m13lambda$connect$0$androidxbrowsertrustedTrustedWebActivityServiceConnectionPool(Uri uri) {
        this.mConnections.remove(uri);
    }

    static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {
        private final Context mAppContext;
        private final ConnectionHolder mConnection;
        private final Intent mIntent;

        BindToServiceAsyncTask(Context context, Intent intent, ConnectionHolder connectionHolder) {
            this.mAppContext = context.getApplicationContext();
            this.mIntent = intent;
            this.mConnection = connectionHolder;
        }

        /* access modifiers changed from: protected */
        public Exception doInBackground(Void... voidArr) {
            try {
                if (this.mAppContext.bindService(this.mIntent, this.mConnection, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)) {
                    return null;
                }
                this.mAppContext.unbindService(this.mConnection);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                Log.w(TrustedWebActivityServiceConnectionPool.TAG, "SecurityException while binding.", e);
                return e;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Exception exc) {
            if (exc != null) {
                this.mConnection.cancel(exc);
            }
        }
    }

    public boolean serviceExistsForScope(Uri uri, Set<Token> set) {
        if (this.mConnections.get(uri) == null && createServiceIntent(this.mContext, uri, set, false) == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void unbindAllConnections() {
        for (ConnectionHolder unbindService : this.mConnections.values()) {
            this.mContext.unbindService(unbindService);
        }
        this.mConnections.clear();
    }

    private Intent createServiceIntent(Context context, Uri uri, Set<Token> set, boolean z) {
        if (set == null || set.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        String str = null;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            String str2 = resolveInfo.activityInfo.packageName;
            Iterator<Token> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().matches(str2, context.getPackageManager())) {
                        str = str2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (str == null) {
            if (z) {
                Log.w(TAG, "No TWA candidates for " + uri + " have been registered.");
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str);
        intent2.setAction(TrustedWebActivityService.ACTION_TRUSTED_WEB_ACTIVITY_SERVICE);
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 131072);
        if (resolveService == null) {
            if (z) {
                Log.w(TAG, "Could not find TWAService for " + str);
            }
            return null;
        }
        if (z) {
            Log.i(TAG, "Found " + resolveService.serviceInfo.name + " to handle request for " + uri);
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str, resolveService.serviceInfo.name));
        return intent3;
    }
}
