package co.froogal.froogal.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.AbsListView;
import android.widget.ListView;

public class ExpandableListViewFragment extends ScrollTabHolderFragment {
    protected static final String ARG_POSITION = "position";

    protected AnimatedExpandableListView mListView;
    protected int mPosition;

    @Override
    public void adjustScroll(int scrollHeight, int headerHeight) {
        if (mListView == null) return;

        if (scrollHeight == 0 && mListView.getFirstVisiblePosition() >= 1) {
            return;
        }

        mListView.setSelectionFromTop(1, scrollHeight);

    }


    protected void setListViewOnScrollListener() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (mScrollTabHolder != null) {
                    mScrollTabHolder.onListViewScroll(
                            view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
                }
            }
        });
    }
}
