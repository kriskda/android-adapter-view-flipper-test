package switcher.view.test.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


public class ArticleSliderAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private List<String> data = new ArrayList<>();
    private ArticleView articleView;

    public ArticleSliderAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        articleView = new ArticleView(
                mainActivity,
                data.get(position),
                "http://blog.stackoverflow.com/2009/06/attribution-required/");
        return articleView;
    }

    public ArticleView.ScrollState getScrollState() {
        return articleView.scrollState;
    }

}
