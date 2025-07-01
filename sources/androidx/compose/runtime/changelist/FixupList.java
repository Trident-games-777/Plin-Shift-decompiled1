package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J>\u0010!\u001a\u00020\u000b\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010#2\u0006\u0010$\u001a\u0002H\"2\u001d\u0010%\u001a\u0019\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u000b0&¢\u0006\u0002\b'¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"Landroidx/compose/runtime/changelist/FixupList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "operations", "Landroidx/compose/runtime/changelist/Operations;", "pendingOperations", "size", "", "getSize", "()I", "clear", "", "createAndInsertNode", "factory", "Lkotlin/Function0;", "", "insertIndex", "groupAnchor", "Landroidx/compose/runtime/Anchor;", "endNodeInsert", "executeAndFlushAllPendingFixups", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "isEmpty", "", "isNotEmpty", "toDebugString", "", "linePrefix", "updateNode", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FixupList.kt */
public final class FixupList extends OperationsDebugStringFormattable {
    public static final int $stable = 8;
    private final Operations operations = new Operations();
    private final Operations pendingOperations = new Operations();

    public final int getSize() {
        return this.operations.getSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingFixups(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slotWriter, rememberManager);
    }

    public final void createAndInsertNode(Function0<? extends Object> function0, int i, Anchor anchor) {
        int i2;
        int i3;
        Operations operations2;
        int i4;
        int i5;
        Operations operations3 = this.operations;
        Operation operation = Operation.InsertNodeFixup.INSTANCE;
        operations3.pushOp(operation);
        Operations r5 = Operations.WriteScope.m3789constructorimpl(operations3);
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        Operations.WriteScope.m3795setObjectDKhxnng(r5, Operation.ObjectParameter.m3741constructorimpl(0), function0);
        Operation.InsertNodeFixup insertNodeFixup2 = Operation.InsertNodeFixup.INSTANCE;
        Operations.WriteScope.m3794setIntA6tL2VI(r5, Operation.IntParameter.m3728constructorimpl(0), i);
        Operation.InsertNodeFixup insertNodeFixup3 = Operation.InsertNodeFixup.INSTANCE;
        Operations.WriteScope.m3795setObjectDKhxnng(r5, Operation.ObjectParameter.m3741constructorimpl(1), anchor);
        if (!(operations3.pushedIntMask == operations3.createExpectedArgMask(operation.getInts()) && operations3.pushedObjectMask == operations3.createExpectedArgMask(operation.getObjects()))) {
            StringBuilder sb = new StringBuilder();
            i3 = 0;
            int ints = operation.getInts();
            Operations operations4 = operations3;
            i2 = 1;
            int i6 = 0;
            int i7 = 0;
            while (i7 < ints) {
                if (((1 << i7) & operations4.pushedIntMask) != 0) {
                    if (i6 > 0) {
                        sb.append(", ");
                    }
                    i5 = ints;
                    sb.append(operation.m3687intParamNamew8GmfQM(Operation.IntParameter.m3728constructorimpl(i7)));
                    i6++;
                } else {
                    i5 = ints;
                }
                i7++;
                ints = i5;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i8 = 0;
            int i9 = 0;
            while (i9 < objects) {
                if (((1 << i9) & operations4.pushedObjectMask) != 0) {
                    if (i6 > 0) {
                        sb3.append(", ");
                    }
                    i4 = i9;
                    sb3.append(operation.m3688objectParamName31yXWZQ(Operation.ObjectParameter.m3741constructorimpl(i4)));
                    i8++;
                } else {
                    i4 = i9;
                }
                i9 = i4 + 1;
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i6 + " int arguments (" + sb2 + ") and " + i8 + " object arguments (" + sb4 + ").");
        } else {
            i3 = 0;
            i2 = 1;
        }
        Operations operations5 = this.pendingOperations;
        Operation operation2 = Operation.PostInsertNodeFixup.INSTANCE;
        operations5.pushOp(operation2);
        Operations r3 = Operations.WriteScope.m3789constructorimpl(operations5);
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        Operations.WriteScope.m3794setIntA6tL2VI(r3, Operation.IntParameter.m3728constructorimpl(i3), i);
        Operation.PostInsertNodeFixup postInsertNodeFixup2 = Operation.PostInsertNodeFixup.INSTANCE;
        Operations.WriteScope.m3795setObjectDKhxnng(r3, Operation.ObjectParameter.m3741constructorimpl(i3), anchor);
        if (((operations5.pushedIntMask == operations5.createExpectedArgMask(operation2.getInts()) && operations5.pushedObjectMask == operations5.createExpectedArgMask(operation2.getObjects())) ? i2 : i3) == 0) {
            StringBuilder sb5 = new StringBuilder();
            int ints2 = operation2.getInts();
            int i10 = i3;
            int i11 = i10;
            while (i10 < ints2) {
                if (((i2 << i10) & operations5.pushedIntMask) != 0) {
                    if (i11 > 0) {
                        sb5.append(", ");
                    }
                    sb5.append(operation2.m3687intParamNamew8GmfQM(Operation.IntParameter.m3728constructorimpl(i10)));
                    i11++;
                }
                i10++;
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb7 = new StringBuilder();
            int objects2 = operation2.getObjects();
            int i12 = i3;
            int i13 = i12;
            while (i13 < objects2) {
                if (((i2 << i13) & operations5.pushedObjectMask) != 0) {
                    if (i11 > 0) {
                        sb7.append(", ");
                    }
                    operations2 = operations5;
                    sb7.append(operation2.m3688objectParamName31yXWZQ(Operation.ObjectParameter.m3741constructorimpl(i13)));
                    i12++;
                } else {
                    operations2 = operations5;
                }
                i13++;
                operations5 = operations2;
            }
            String sb8 = sb7.toString();
            Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + operation2 + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb6 + ") and " + i12 + " object arguments (" + sb8 + ").");
        }
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final <V, T> void updateNode(V v, Function2<? super T, ? super V, Unit> function2) {
        Operations operations2 = this.operations;
        Operation operation = Operation.UpdateNode.INSTANCE;
        operations2.pushOp(operation);
        Operations r2 = Operations.WriteScope.m3789constructorimpl(operations2);
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        Operations.WriteScope.m3795setObjectDKhxnng(r2, Operation.ObjectParameter.m3741constructorimpl(0), v);
        Operation.UpdateNode updateNode2 = Operation.UpdateNode.INSTANCE;
        int r4 = Operation.ObjectParameter.m3741constructorimpl(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m3795setObjectDKhxnng(r2, r4, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
        if (!(operations2.pushedIntMask == operations2.createExpectedArgMask(operation.getInts()) && operations2.pushedObjectMask == operations2.createExpectedArgMask(operation.getObjects()))) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & operations2.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3687intParamNamew8GmfQM(Operation.IntParameter.m3728constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & operations2.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3688objectParamName31yXWZQ(Operation.ObjectParameter.m3741constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").");
        }
    }

    public String toDebugString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("FixupList instance containing " + getSize() + " operations");
        if (sb.length() > 0) {
            sb.append(":\n" + this.operations.toDebugString(str));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
