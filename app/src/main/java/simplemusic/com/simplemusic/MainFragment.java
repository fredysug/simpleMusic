package simplemusic.com.simplemusic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ITAsset on 5/22/17.
 */

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private ArrayList<Music> musics = null;
    private View myInflaterView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myInflaterView = inflater.inflate(R.layout.fragment_main, container, false);
        setMusics();
        prepareMusicData();

        ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());

//        for (int i = 0 ; i < mySongs.size() ; i ++){
//            Log.v("My Song", mySongs.get(i).getName());
//        }

        return myInflaterView;
    }

    private ArrayList<File> findSongs(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();
        Log.v("Log", root.getPath());
        Log.v("Log", root.listFiles().toString());
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findSongs(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    al.add(singleFile);
                }
            }
        }

        return al;
    }

    private void setMusics(){
        musics = new ArrayList<Music>();
        for (int i = 0 ; i < 10 ; i++){
            Music music = new Music("title " + i, "desc " + i, i);
            musics.add(music);
        }
    }

    private void prepareMusicData() {
        recyclerView = (RecyclerView) myInflaterView.findViewById(R.id.listMusic);
        musicAdapter = new MusicAdapter(musics);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(myInflaterView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(musicAdapter);

        musicAdapter.notifyDataSetChanged();
        musicAdapter.notifyDataSetChanged();
    }
}
