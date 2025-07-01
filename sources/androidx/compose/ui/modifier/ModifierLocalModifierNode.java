package androidx.compose.ui.modifier;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalModifierNode.kt */
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    <T> void provide(ModifierLocal<T> modifierLocal, T t) {
        if (!(getProvidedValues() != EmptyMap.INSTANCE)) {
            InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
        }
        if (!getProvidedValues().contains$ui_release(modifierLocal)) {
            InlineClassHelperKt.throwIllegalArgumentException("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + modifierLocal + " was not found.");
        }
        getProvidedValues().set$ui_release(modifierLocal, t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ba, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> r12) {
        /*
            r11 = this;
            androidx.compose.ui.Modifier$Node r0 = r11.getNode()
            boolean r0 = r0.isAttached()
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "ModifierLocal accessed from an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalArgumentException(r0)
        L_0x000f:
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 32
            int r1 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00d2
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x002e:
            if (r0 == 0) goto L_0x00c9
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r1
            r4 = 0
            if (r3 == 0) goto L_0x00b4
        L_0x0040:
            if (r2 == 0) goto L_0x00b4
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x00af
            r3 = r2
            r5 = r4
        L_0x004b:
            if (r3 == 0) goto L_0x00af
            boolean r6 = r3 instanceof androidx.compose.ui.modifier.ModifierLocalModifierNode
            if (r6 == 0) goto L_0x0066
            androidx.compose.ui.modifier.ModifierLocalModifierNode r3 = (androidx.compose.ui.modifier.ModifierLocalModifierNode) r3
            androidx.compose.ui.modifier.ModifierLocalMap r6 = r3.getProvidedValues()
            boolean r6 = r6.contains$ui_release(r12)
            if (r6 == 0) goto L_0x00aa
            androidx.compose.ui.modifier.ModifierLocalMap r0 = r3.getProvidedValues()
            java.lang.Object r12 = r0.get$ui_release(r12)
            return r12
        L_0x0066:
            int r6 = r3.getKindSet$ui_release()
            r6 = r6 & r1
            if (r6 == 0) goto L_0x00aa
            boolean r6 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x00aa
            r6 = r3
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r7 = 0
            r8 = r7
        L_0x007a:
            r9 = 1
            if (r6 == 0) goto L_0x00a7
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r1
            if (r10 == 0) goto L_0x00a2
            int r8 = r8 + 1
            if (r8 != r9) goto L_0x008a
            r3 = r6
            goto L_0x00a2
        L_0x008a:
            if (r5 != 0) goto L_0x0095
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
        L_0x0095:
            if (r3 == 0) goto L_0x009d
            if (r5 == 0) goto L_0x009c
            r5.add(r3)
        L_0x009c:
            r3 = r4
        L_0x009d:
            if (r5 == 0) goto L_0x00a2
            r5.add(r6)
        L_0x00a2:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x007a
        L_0x00a7:
            if (r8 != r9) goto L_0x00aa
            goto L_0x004b
        L_0x00aa:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x004b
        L_0x00af:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0040
        L_0x00b4:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00c6
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x00c6
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x002e
        L_0x00c6:
            r2 = r4
            goto L_0x002e
        L_0x00c9:
            kotlin.jvm.functions.Function0 r12 = r12.getDefaultFactory$ui_release()
            java.lang.Object r12 = r12.invoke()
            return r12
        L_0x00d2:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.modifier.ModifierLocalModifierNode.getCurrent(androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
    }
}
