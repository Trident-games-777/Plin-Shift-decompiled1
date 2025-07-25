package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    public int describeContents() {
        return 0;
    }

    BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.mFragments = list;
        this.mTransactions = list2;
    }

    BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    /* access modifiers changed from: package-private */
    public List<BackStackRecord> instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap hashMap = new HashMap(this.mFragments.size());
        for (String next : this.mFragments) {
            Fragment fragment = map.get(next);
            if (fragment != null) {
                hashMap.put(fragment.mWho, fragment);
            } else {
                Bundle savedState = fragmentManager.getFragmentStore().setSavedState(next, (Bundle) null);
                if (savedState != null) {
                    ClassLoader classLoader = fragmentManager.getHost().getContext().getClassLoader();
                    Fragment instantiate = ((FragmentState) savedState.getParcelable("state")).instantiate(fragmentManager.getFragmentFactory(), classLoader);
                    instantiate.mSavedFragmentState = savedState;
                    if (instantiate.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                        instantiate.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = savedState.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    instantiate.setArguments(bundle);
                    hashMap.put(instantiate.mWho, instantiate);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (BackStackRecordState instantiate2 : this.mTransactions) {
            arrayList.add(instantiate2.instantiate(fragmentManager, hashMap));
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }
}
