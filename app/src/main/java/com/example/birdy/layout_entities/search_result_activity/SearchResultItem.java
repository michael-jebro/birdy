package com.example.birdy.layout_entities.search_result_activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.birdy.R;

public class SearchResultItem {
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    private LinearLayout layout;
    private TextView title;
    private LinearLayout childLayout;
    private ImageView cover;

    public SearchResultItem(Context context, String artistName,
                            String mediaItemName, int coverImage) {
        layout = new LinearLayout(context);
        title = new TextView(context);
        childLayout = new LinearLayout(context);
        cover = new ImageView(context);

        setupCover(context.getResources());
        setCoverImage(coverImage);

        setupChildLayout(context.getResources());

        setupTitle(context.getResources());
        setTitleString(artistName, mediaItemName);

        setupLayout(context.getResources());
    }

    private void setupCover(Resources resources) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.searchresitem_cover_width),
                resources.getDimensionPixelSize(R.dimen.searchresitem_cover_height)
        );
        cover.setLayoutParams(params);
    }

    private void setCoverImage(int resource) {
        cover.setImageResource(resource);
    }

    private void setupChildLayout(Resources resources) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.searchresitem_child_layout_height)
        );

        childLayout.setLayoutParams(params);
        childLayout.setOrientation(LinearLayout.HORIZONTAL);
        childLayout.addView(cover);
    }

    private void setupTitle(Resources resources) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.searchresitem_title_height)
        );

        title.setLayoutParams(params);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(resources
                .getDimension(R.dimen.searchresitem_title_font_size));
    }

    private void setTitleString(String artistName, String mediaItemName) {
        title.setText(artistName + " - " + mediaItemName);
    }

    private void setupLayout(Resources resources) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.searchresitem_layout_height)
        );

        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(childLayout);
        layout.addView(title);
    }

    public LinearLayout getLayout() {
        return layout;
    }

}
