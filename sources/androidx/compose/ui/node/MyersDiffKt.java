package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0015\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aZ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0000\u001aZ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u0014\u001aR\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00122\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"applyDiff", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "oldSize", "newSize", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MyersDiff.kt */
public final class MyersDiffKt {
    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = ((i + i2) + 1) / 2;
        IntStack intStack = new IntStack(i3 * 3);
        IntStack intStack2 = new IntStack(i3 * 4);
        intStack2.pushRange(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] r10 = CenteredArray.m5941constructorimpl(new int[i4]);
        int[] r11 = CenteredArray.m5941constructorimpl(new int[i4]);
        int[] r12 = Snake.m6204constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int pop = intStack2.pop();
            int pop2 = intStack2.pop();
            int pop3 = intStack2.pop();
            int pop4 = intStack2.pop();
            DiffCallback diffCallback2 = diffCallback;
            if (m6080midPointq5eDKzI(pop4, pop3, pop2, pop, diffCallback2, r10, r11, r12)) {
                if (Snake.m6207getDiagonalSizeimpl(r12) > 0) {
                    Snake.m6202addDiagonalToStackimpl(r12, intStack);
                }
                intStack2.pushRange(pop4, Snake.m6212getStartXimpl(r12), pop2, Snake.m6213getStartYimpl(r12));
                intStack2.pushRange(Snake.m6208getEndXimpl(r12), pop3, Snake.m6209getEndYimpl(r12), pop);
            }
            diffCallback = diffCallback2;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i2, 0);
        return intStack;
    }

    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < intStack.getSize()) {
            int i4 = i + 2;
            int i5 = intStack.get(i) - intStack.get(i4);
            int i6 = intStack.get(i + 1) - intStack.get(i4);
            int i7 = intStack.get(i4);
            i += 3;
            while (i2 < i5) {
                diffCallback.remove(i3, i2);
                i2++;
            }
            while (i3 < i6) {
                diffCallback.insert(i3);
                i3++;
            }
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    diffCallback.same(i2, i3);
                    i2++;
                    i3++;
                    i7 = i8;
                }
            }
        }
    }

    public static final void executeDiff(int i, int i2, DiffCallback diffCallback) {
        applyDiff(calculateDiff(i, i2, diffCallback), diffCallback);
    }

    /* renamed from: midPoint-q5eDKzI  reason: not valid java name */
    private static final boolean m6080midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            int[] iArr4 = iArr;
            CenteredArray.m5947setimpl(iArr4, 1, i);
            int[] iArr5 = iArr2;
            CenteredArray.m5947setimpl(iArr5, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                if (m6079forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr4, iArr5, i8, iArr3) || m6078backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i8, iArr3)) {
                    return true;
                }
                i8++;
                iArr4 = iArr;
                iArr5 = iArr2;
            }
        }
        return false;
    }

    /* renamed from: forward-4l5_RBY  reason: not valid java name */
    private static final boolean m6079forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int i6;
        int i7;
        int i8 = i2;
        int i9 = i4;
        int[] iArr4 = iArr;
        int i10 = i5;
        int i11 = (i8 - i) - (i9 - i3);
        boolean z = Math.abs(i11) % 2 == 1;
        int i12 = -i10;
        for (int i13 = i12; i13 <= i10; i13 += 2) {
            if (i13 == i12 || (i13 != i10 && CenteredArray.m5944getimpl(iArr4, i13 + 1) > CenteredArray.m5944getimpl(iArr4, i13 - 1))) {
                i7 = CenteredArray.m5944getimpl(iArr4, i13 + 1);
                i6 = i7;
            } else {
                i7 = CenteredArray.m5944getimpl(iArr4, i13 - 1);
                i6 = i7 + 1;
            }
            int i14 = (i3 + (i6 - i)) - i13;
            int i15 = (i10 == 0 || i6 != i7) ? i14 : i14 - 1;
            while (true) {
                if (i6 < i8 && i14 < i9) {
                    if (!diffCallback.areItemsTheSame(i6, i14)) {
                        break;
                    }
                    i6++;
                    i14++;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m5947setimpl(iArr4, i13, i6);
            if (z) {
                int i16 = i11 - i13;
                if (i16 < i12 + 1 || i16 > i10 - 1) {
                    int[] iArr5 = iArr2;
                } else if (CenteredArray.m5944getimpl(iArr2, i16) <= i6) {
                    fillSnake(i7, i15, i6, i14, false, iArr3);
                    return true;
                }
            } else {
                int[] iArr6 = iArr2;
            }
        }
        return false;
    }

    /* renamed from: backward-4l5_RBY  reason: not valid java name */
    private static final boolean m6078backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i3;
        int[] iArr4 = iArr2;
        int i11 = i5;
        int i12 = (i2 - i9) - (i4 - i10);
        boolean z = i12 % 2 == 0;
        int i13 = -i11;
        for (int i14 = i13; i14 <= i11; i14 += 2) {
            if (i14 == i13 || (i14 != i11 && CenteredArray.m5944getimpl(iArr4, i14 + 1) < CenteredArray.m5944getimpl(iArr4, i14 - 1))) {
                i7 = CenteredArray.m5944getimpl(iArr4, i14 + 1);
                i6 = i7;
            } else {
                i7 = CenteredArray.m5944getimpl(iArr4, i14 - 1);
                i6 = i7 - 1;
            }
            int i15 = i4 - ((i2 - i6) - i14);
            int i16 = (i11 == 0 || i6 != i7) ? i15 : i15 + 1;
            while (true) {
                if (i6 > i9 && i15 > i10) {
                    if (!diffCallback.areItemsTheSame(i6 - 1, i15 - 1)) {
                        break;
                    }
                    i6--;
                    i15--;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m5947setimpl(iArr4, i14, i6);
            if (!z || (i8 = i12 - i14) < i13 || i8 > i11) {
                int[] iArr5 = iArr;
            } else if (CenteredArray.m5944getimpl(iArr, i8) >= i6) {
                fillSnake(i6, i15, i7, i16, true, iArr3);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v0, types: [int[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fillSnake(int r1, int r2, int r3, int r4, boolean r5, int[] r6) {
        /*
            r0 = 0
            r6[r0] = r1
            r1 = 1
            r6[r1] = r2
            r1 = 2
            r6[r1] = r3
            r1 = 3
            r6[r1] = r4
            r1 = 4
            r6[r1] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MyersDiffKt.fillSnake(int, int, int, int, boolean, int[]):void");
    }

    /* access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
