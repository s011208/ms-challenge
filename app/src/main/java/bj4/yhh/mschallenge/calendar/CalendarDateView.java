package bj4.yhh.mschallenge.calendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.lang.ref.WeakReference;
import java.util.Date;

import bj4.yhh.mschallenge.R;
import bj4.yhh.mschallenge.Utilities;
import bj4.yhh.mschallenge.views.FullyExpandedGridView;

/**
 * Created by User on 2016/6/3.
 */
public class CalendarDateView extends FullyExpandedGridView {
    private static final String TAG = "CalendarDateView";
    private static final boolean DEBUG = Utilities.DEBUG;

    private WeakReference<Callback> mCallback;
    private CalendarDateViewAdapter mCalendarDateViewAdapter;
    private Context mContext;

    public CalendarDateView(Context context) {
        this(context, null);
    }

    public CalendarDateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarDateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setNumColumns(7);
        setDrawSelectorOnTop(true);
        setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        setVerticalSpacing(mContext.getResources().getDimensionPixelSize(R.dimen.calendar_view_vertical_spacing));
        setSelector(new ColorDrawable(Color.TRANSPARENT));
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (DEBUG) {
                    Log.d(TAG, "onItemClick, position: " + position);
                }
                if (!mCalendarDateViewAdapter.getItem(position).isClickable()) return;
                mCalendarDateViewAdapter.setPressedPosition(position);
                mCalendarDateViewAdapter.notifyDataSetInvalidated();
                if (mCallback.get() != null) {
                    mCallback.get().onDaySelected(
                            ((CalendarDate) mCalendarDateViewAdapter.getItem(position)).getDate());
                }
            }
        });
    }

    public void setArguments(int year, int month, Callback cb) {
        mCallback = new WeakReference<>(cb);
        mCalendarDateViewAdapter = new CalendarDateViewAdapter(mContext, year, month, cb.getSelectedDate());
        setAdapter(mCalendarDateViewAdapter);
    }

    public int getYear() {
        return mCalendarDateViewAdapter.getYear();
    }

    public int getMonth() {
        return mCalendarDateViewAdapter.getMonth();
    }

    public void onDestroy() {
        mCallback = null;
    }

    public void updateSelectedDate(Date selectedDate) {
        int pressedPosition = -1;
        for (int i = 0; i < mCalendarDateViewAdapter.getCount(); ++i) {
            CalendarItem item = mCalendarDateViewAdapter.getItem(i);
            if (item instanceof CalendarDate) {
                if (((CalendarDate) item).getDate().equals(selectedDate)) {
                    pressedPosition = i;
                }
            }
        }
        mCalendarDateViewAdapter.setPressedPosition(pressedPosition);
        mCalendarDateViewAdapter.notifyDataSetInvalidated();
    }

    public interface Callback {
        void onDaySelected(Date date);

        Date getSelectedDate();
    }
}
