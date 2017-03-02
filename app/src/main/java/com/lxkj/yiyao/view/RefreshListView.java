package com.lxkj.yiyao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lxkj.yiyao.R;

import java.text.SimpleDateFormat;

public class RefreshListView extends ListView implements OnScrollListener {

    /**
     * 下拉刷新部分
     */
    private static final String TAG = "RefreshListView";
    private int firstVisibleItemPosition;//listview中第一个可见item所在的位置position
    private int downY;//手指在Y轴下拉滑动的距离
    private int headerViewHeight;//下拉刷新view的高度
    private View headerView; //下拉刷新的view
    private final int DOWN_PULL_REFERESH = 0;//“下拉刷新”状态
    private final int RELEASE_REFRESH = 1;//“放开刷新”状态
    private final int REFRESHING = 2;//“正在刷新”状态
    private int currentState = DOWN_PULL_REFERESH;//listView当前的状态，默认为”下拉刷新“状态
    private Animation upAnimation; //下拉箭头变为向上箭头的动画
    private Animation downAnimation; //上拉箭头变为向下箭头的动画
    private ImageView ivArrow; //下拉箭头
    private ProgressBar mProgressBar; //进度条
    private TextView tvState; //显示状态的文本
    private TextView tvLastUpdateTimes; //显示最后更新的时间

    /**
     * 底部加载更多部分
     */
    private boolean isScrollToBottom;//判断是不是滑到了底部
    private View footerView; //底部的footer   view
    private int footerViewHeight; //底部view的高度
    private boolean isLoadingMore = false; //判断是不是"加载更多"

    /**
     * listview的接口，监听listview的下来刷新和上拉加载更多
     */
    private OnRefreshListener mOnRefreshListener;

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHeaderView();
        initFooterView();
        this.setOnScrollListener(this);
    }

    /**
     * 初始化底部view
     */
    private void initFooterView() {
        footerView = View.inflate(getContext(), R.layout.footer_layout, null);
        //设置（0，0）以便系统测量footerView的宽高
        footerView.measure(0, 0);
        footerViewHeight = footerView.getMeasuredHeight();
        footerView.setPadding(0, -footerViewHeight, 0, 0);
        this.addFooterView(footerView);
    }

    /**
     * 初始化顶部view
     */
    private void initHeaderView() {
        headerView = View.inflate(getContext(), R.layout.header_layout, null);
        ivArrow = (ImageView) headerView.findViewById(R.id.pull_to_refresh_icon);
        mProgressBar = (ProgressBar) headerView.findViewById(R.id.refresh_progressbar);
        tvState = (TextView) headerView.findViewById(R.id.hint_text);
        tvLastUpdateTimes = (TextView) headerView.findViewById(R.id.refresh_time);

        //最近更新
        tvLastUpdateTimes.setText("最近更新:" + getLastUpdateTime());
        //设置（0，0）以便系统测量footerView的宽高
        headerView.measure(0, 0);
        headerViewHeight = headerView.getMeasuredHeight();
        headerView.setPadding(0, -headerViewHeight, 0, 0);
        this.addHeaderView(headerView);
        initAnimation();
    }

    /**
     * 获取最近更新时间
     */
    private String getLastUpdateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        upAnimation = new RotateAnimation(0f, -180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        upAnimation.setDuration(500);
        upAnimation.setFillAfter(true);//设为true,表示动画完成后，保持动画后的状态

        downAnimation = new RotateAnimation(-180f, -360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        downAnimation.setDuration(500);
        downAnimation.setFillAfter(true);//设为true,表示动画完成后，保持动画后的状态

    }

    /**
     * listView的touche事件，通过判断手指在listview上面的，按下、滑动、抬起等一套手指动作，来实现
     * 下拉刷新和上拉加载更多
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();
                //获取滑动距离一半长度，以便手指在屏幕上面滑动了很长一段距离，headerview也不是很高，
                //主要为了美观，你可以不用除2，看你自己的设计，不过除2显示效果要好点
                int diff = (moveY - downY) / 2;
                //设置顶部view距离顶部的padding距离
                int paddingTop = -headerViewHeight + diff;

                //如果当前可见的第一个position为0，
                if (firstVisibleItemPosition == 0 && -headerViewHeight < paddingTop) {
                    //paddingTop>0说明headerView完全拉出了顶部，并且当前状态为”下拉刷新“
                    //则把当前状态改为”放开刷新“，并且调用refeshHeaderView（）更新界面
                    if (paddingTop > 10 && currentState == DOWN_PULL_REFERESH) {
                        currentState = RELEASE_REFRESH;
                        refreshHeaderView();
                    } //paddingTop<0说明headerView没有完全拉出了顶部，并且当前状态为”放开刷新“
                    //则把当前状态改为”下拉刷新“，并且调用refeshHeaderView（）更新界面；
                    //这种情况就是，当完全拉出来之后，手指没有抬起，然后往又回到顶部
                    else if (paddingTop < 10 && currentState == RELEASE_REFRESH) {
                        currentState = DOWN_PULL_REFERESH;
                        refreshHeaderView();
                    }
                    //动态刷新headerView的顶部padding，这样lisview就在动态的变化
                    headerView.setPadding(0, paddingTop, 0, 0);
                    return true;
                }
                break;
            //手指抬起时，判断listview当前的状态
            case MotionEvent.ACTION_UP:
                //判断当前的状态
                if (currentState == RELEASE_REFRESH) {
                    //如果是”放开刷新“，让headerView的padding都为0
                    headerView.setPadding(0, 0, 0, 0);
                    // 把当前的状态设为”正在刷新“
                    currentState = REFRESHING;
                    refreshHeaderView();

                    //判断外面外面有没有设置刷新的接口
                    if (mOnRefreshListener != null) {
                        //如果设置了接口，就调用接口中的下拉刷新的方法
                        mOnRefreshListener.onDownPullRefresh();
                    }
                } else if (currentState == DOWN_PULL_REFERESH) {
                    //如果当前状态是”下拉刷新“状态，则将headerView隐藏掉
                    headerView.setPadding(0, -headerViewHeight, 0, 0);
                }
                break;
            default:
                break;
        }

        return super.onTouchEvent(ev);
    }

    /**
     * 根据当前状态currentState来更新下拉刷新view界面的控件显示内容̬
     */
    private void refreshHeaderView() {
        switch (currentState) {
            case DOWN_PULL_REFERESH:
                tvState.setText("下拉刷新");
                ivArrow.startAnimation(downAnimation);
                break;
            case RELEASE_REFRESH:
                tvState.setText("放开刷新");
                ivArrow.startAnimation(upAnimation);
                break;
            case REFRESHING:
                ivArrow.clearAnimation();
                ivArrow.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
                tvState.setText("正在刷新...");
                break;
            default:
                break;
        }

    }

    /**
     * 监听listview滚动的状态变化，如果滑到了底部，就“加载更多..."
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_FLING) {
            if (isScrollToBottom && !isLoadingMore) {
                isLoadingMore = true;
                footerView.setPadding(0, 0, 0, 0);
                this.setSelection(this.getCount());

                if (mOnRefreshListener != null) {
                    mOnRefreshListener.onLoadingMore();
                }
            }
        }
    }

    /**
     * 监听listview滚动的状态变化，判断当前是不是滑到了底部
     *
     * @param view
     * @param firstVisibleItem
     * @param visibleItemCount
     * @param totalItemCount
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        firstVisibleItemPosition = firstVisibleItem;
        if (getLastVisiblePosition() == (totalItemCount - 1)) {
            isScrollToBottom = true;
        } else {
            isScrollToBottom = false;
        }

    }

    /**
     * 设置监听接口，当为
     *
     * @param listener
     */
    public void setOnRefreshListener(OnRefreshListener listener) {
        mOnRefreshListener = listener;
    }

    /**
     * 为外界提供的方法，当Activity中的数据加载完后，就调用这个方法来隐藏顶部的headerView
     */
    public void onRefreshComplete() {
        headerView.setPadding(0, -headerViewHeight, 0, 0);
        ivArrow.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        tvState.setText("下拉刷新");
        tvLastUpdateTimes.setText("最近更新时间:" + getLastUpdateTime());
        currentState = DOWN_PULL_REFERESH;
    }

    /**
     * 为外界提供的方法，当Activity中的加载更多数据加载完后，就调用这个方法来隐藏底部的footerView
     */
    public void loadMoreComplete() {
        footerView.setPadding(0, -headerViewHeight, 0, 0);

        isLoadingMore = false;
    }

    /**
     * 设置接口，供外界实现，监听listview的刷新和加载更多的状态
     */
    public interface OnRefreshListener {
        /**
         * 下拉刷新
         */
        void onDownPullRefresh();

        /**
         * 上拉加载更多
         */
        void onLoadingMore();
    }
}
