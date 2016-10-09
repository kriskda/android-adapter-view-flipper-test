package switcher.view.test.myapplication;


import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ArticleView extends NestedScrollView {

    enum ScrollState {
        SCROLLING, TOP_EDGE, BOTTOM_EDGE
    }

    public ScrollState scrollState = ScrollState.SCROLLING;

    public ArticleView(Context context, String imageUrl, String webViewUrl) {
        super(context);
        initView(imageUrl, webViewUrl);
    }

    private void initView(String imageUrl, String webViewUrl) {
        inflate(getContext(), R.layout.article_view, this);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        WebView webView = (WebView) findViewById(R.id.webView);

        Glide.with(getContext())
                .load(imageUrl)
                .fitCenter()
                .into(image);

        webView.loadUrl(webViewUrl);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = getChildAt(0);

        int diff = view.getBottom() - (getHeight() + getScrollY());

        if (diff == 0) {
            Log.i("TTT", "bottom edge");
            scrollState = ScrollState.BOTTOM_EDGE;
        } else if (getScrollY() == 0) {
            Log.i("TTT", "top edge");
            scrollState = ScrollState.TOP_EDGE;
        } else {
            scrollState = ScrollState.SCROLLING;
        }

        super.onScrollChanged(l, t, oldl, oldt);
    }

}
