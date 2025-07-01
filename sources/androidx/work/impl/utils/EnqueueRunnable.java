package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean z2 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z2 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.getIds())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r16, java.util.List<? extends androidx.work.WorkRequest> r17, java.lang.String[] r18, java.lang.String r19, androidx.work.ExistingWorkPolicy r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            long r3 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r16.getWorkDatabase()
            r7 = 0
            if (r0 == 0) goto L_0x0016
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0016
            r8 = 1
            goto L_0x0017
        L_0x0016:
            r8 = r7
        L_0x0017:
            if (r8 == 0) goto L_0x005a
            int r9 = r0.length
            r10 = r7
            r12 = r10
            r13 = r12
            r11 = 1
        L_0x001e:
            if (r10 >= r9) goto L_0x005d
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x0042
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.String r2 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.Object[] r3 = new java.lang.Object[]{r14}
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r7]
            r0.error(r1, r2, r3)
            return r7
        L_0x0042:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x004a
            r15 = 1
            goto L_0x004b
        L_0x004a:
            r15 = r7
        L_0x004b:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x0052
            r13 = 1
            goto L_0x0057
        L_0x0052:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0057
            r12 = 1
        L_0x0057:
            int r10 = r10 + 1
            goto L_0x001e
        L_0x005a:
            r12 = r7
            r13 = r12
            r11 = 1
        L_0x005d:
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x013d
            if (r8 != 0) goto L_0x013d
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x013d
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x00c3
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x007c
            goto L_0x00c3
        L_0x007c:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x009d
            java.util.Iterator r2 = r10.iterator()
        L_0x0084:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x009d
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r15 = r14.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r6) goto L_0x009c
            androidx.work.WorkInfo$State r6 = r14.state
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.RUNNING
            if (r6 != r14) goto L_0x0084
        L_0x009c:
            return r7
        L_0x009d:
            r2 = r16
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.forName(r1, r2, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r6 = r10.iterator()
        L_0x00ae:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x00c0
            java.lang.Object r10 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r10 = (androidx.work.impl.model.WorkSpec.IdAndState) r10
            java.lang.String r10 = r10.id
            r2.delete(r10)
            goto L_0x00ae
        L_0x00c0:
            r2 = 1
            goto L_0x013e
        L_0x00c3:
            androidx.work.impl.model.DependencyDao r6 = r5.dependencyDao()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d0:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x0105
            java.lang.Object r14 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            java.lang.String r15 = r14.id
            boolean r15 = r6.hasDependents(r15)
            if (r15 != 0) goto L_0x0103
            androidx.work.WorkInfo$State r15 = r14.state
            androidx.work.WorkInfo$State r7 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r15 != r7) goto L_0x00ec
            r7 = 1
            goto L_0x00ed
        L_0x00ec:
            r7 = 0
        L_0x00ed:
            r7 = r7 & r11
            androidx.work.WorkInfo$State r11 = r14.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r11 != r15) goto L_0x00f6
            r13 = 1
            goto L_0x00fd
        L_0x00f6:
            androidx.work.WorkInfo$State r11 = r14.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r11 != r15) goto L_0x00fd
            r12 = 1
        L_0x00fd:
            java.lang.String r11 = r14.id
            r8.add(r11)
            r11 = r7
        L_0x0103:
            r7 = 0
            goto L_0x00d0
        L_0x0105:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x0131
            if (r12 != 0) goto L_0x010d
            if (r13 == 0) goto L_0x0131
        L_0x010d:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r6 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0119:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x012b
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.id
            r2.delete(r7)
            goto L_0x0119
        L_0x012b:
            java.util.List r8 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x0131:
            java.lang.Object[] r0 = r8.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x013c
            r8 = 1
            goto L_0x013d
        L_0x013c:
            r8 = 0
        L_0x013d:
            r2 = 0
        L_0x013e:
            java.util.Iterator r6 = r17.iterator()
        L_0x0142:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01e8
            java.lang.Object r7 = r6.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.getWorkSpec()
            if (r8 == 0) goto L_0x0169
            if (r11 != 0) goto L_0x0169
            if (r13 == 0) goto L_0x015d
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.FAILED
            r10.state = r14
            goto L_0x0176
        L_0x015d:
            if (r12 == 0) goto L_0x0164
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.CANCELLED
            r10.state = r14
            goto L_0x0176
        L_0x0164:
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.BLOCKED
            r10.state = r14
            goto L_0x0176
        L_0x0169:
            boolean r14 = r10.isPeriodic()
            if (r14 != 0) goto L_0x0172
            r10.periodStartTime = r3
            goto L_0x0176
        L_0x0172:
            r14 = 0
            r10.periodStartTime = r14
        L_0x0176:
            androidx.work.WorkInfo$State r14 = r10.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 != r15) goto L_0x017d
            r2 = 1
        L_0x017d:
            androidx.work.impl.model.WorkSpecDao r14 = r5.workSpecDao()
            r14.insertWorkSpec(r10)
            if (r8 == 0) goto L_0x01a7
            int r10 = r0.length
            r14 = 0
        L_0x0188:
            if (r14 >= r10) goto L_0x01a7
            r15 = r0[r14]
            r16 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r17 = r2
            java.lang.String r2 = r7.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.dependencyDao()
            r2.insertDependency(r0)
            int r14 = r14 + 1
            r0 = r16
            r2 = r17
            goto L_0x0188
        L_0x01a7:
            r16 = r0
            r17 = r2
            java.util.Set r0 = r7.getTags()
            java.util.Iterator r0 = r0.iterator()
        L_0x01b3:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01d0
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            androidx.work.impl.model.WorkTagDao r10 = r5.workTagDao()
            androidx.work.impl.model.WorkTag r14 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r7.getStringId()
            r14.<init>(r2, r15)
            r10.insert(r14)
            goto L_0x01b3
        L_0x01d0:
            if (r9 != 0) goto L_0x01e2
            androidx.work.impl.model.WorkNameDao r0 = r5.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.getStringId()
            r2.<init>(r1, r7)
            r0.insert(r2)
        L_0x01e2:
            r0 = r16
            r2 = r17
            goto L_0x0142
        L_0x01e8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
