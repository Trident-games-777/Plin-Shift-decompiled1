package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"androidx/compose/runtime/ParcelableSnapshotMutableLongState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParcelableSnapshotMutableLongState.android.kt */
public final class ParcelableSnapshotMutableLongState$Companion$CREATOR$1 implements Parcelable.Creator<ParcelableSnapshotMutableLongState> {
    ParcelableSnapshotMutableLongState$Companion$CREATOR$1() {
    }

    public ParcelableSnapshotMutableLongState createFromParcel(Parcel parcel) {
        return new ParcelableSnapshotMutableLongState(parcel.readLong());
    }

    public ParcelableSnapshotMutableLongState[] newArray(int i) {
        return new ParcelableSnapshotMutableLongState[i];
    }
}
