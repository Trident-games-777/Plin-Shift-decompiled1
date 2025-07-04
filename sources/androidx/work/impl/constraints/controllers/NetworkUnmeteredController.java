package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    public NetworkUnmeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getNetworkStateTracker());
    }

    /* access modifiers changed from: package-private */
    public boolean hasConstraint(WorkSpec workSpec) {
        if (workSpec.constraints.getRequiredNetworkType() != NetworkType.UNMETERED) {
            return Build.VERSION.SDK_INT >= 30 && workSpec.constraints.getRequiredNetworkType() == NetworkType.TEMPORARILY_UNMETERED;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstrained(NetworkState networkState) {
        return !networkState.isConnected() || networkState.isMetered();
    }
}
