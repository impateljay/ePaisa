package jay.com.epaisa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jay on 31-05-2016.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<SongItem> songItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<SongItem> feedItemList) {
        this.songItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        SongItem songItem = songItemList.get(i);

        //Download image using picasso library
        Picasso.with(mContext).load(songItem.getArtworkUrl100())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);

        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(songItem.getTrackName()));
    }

    @Override
    public int getItemCount() {
        return (null != songItemList ? songItemList.size() : 0);
    }
}