package co.froogal.froogal.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import co.froogal.froogal.R;
import co.froogal.froogal.adapter.ExpandableHeightGridView;
import co.froogal.froogal.adapter.ImageAdapter;
import co.froogal.froogal.library.NotifyingScrollView;
import co.froogal.froogal.view.ScrollViewFragment;

/**
 * Created by akhil on 17/6/15.
 */
public class AboutScrollViewFragmentTemp extends ScrollViewFragment {


    public static final String TAG = AboutScrollViewFragmentTemp.class.getSimpleName();

    public static Fragment newInstance(int position) {
        AboutScrollViewFragmentTemp fragment = new AboutScrollViewFragmentTemp();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public AboutScrollViewFragmentTemp() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPosition = getArguments().getInt(ARG_POSITION);

        View view = inflater.inflate(R.layout.fragment_about_scroll_view_temp, container, false);
        mScrollView = (NotifyingScrollView) view.findViewById(R.id.scrollview);
        setScrollViewOnScrollListener();

        ExpandableHeightGridView mAppsGrid;
        LinearLayout imagesLayout = (LinearLayout) view.findViewById(R.id.imagesLayout);
        mAppsGrid = (ExpandableHeightGridView) view.findViewById(R.id.myId);
        mAppsGrid.setExpanded(true);
        ImageAdapter madapter = new ImageAdapter(getActivity());
        if(madapter.getCount() == 0){
            imagesLayout.setVisibility(View.GONE);
        }
        mAppsGrid.setAdapter(madapter);



        return view;
    }



}
