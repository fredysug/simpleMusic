package simplemusic.com.simplemusic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by ITAsset on 5/22/17.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private Field[] fields;
    private ArrayList<Music> musicList;

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;

        public MusicViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txtTitleMusic);
            desc = (TextView) view.findViewById(R.id.txtDescMusic);
        }
    }

    public MusicAdapter(ArrayList<Music> musicList) {
        this.musicList = musicList;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_music, parent, false);

        return new MusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.title.setText(musicList.get(position).getTitle());
        holder.desc.setText(musicList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

}
