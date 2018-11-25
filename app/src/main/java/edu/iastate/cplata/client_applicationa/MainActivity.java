package edu.iastate.cplata.client_applicationa;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Messenger;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private Messenger mServiceMessenger = null;
    public ArrayList<Song> songs; //Array list of Songs
    public ListView songList; //View of Songs List

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<Song>();
        songList = (ListView)findViewById(R.id.SongList);

        //populate ListView with Songs
        getSongList();

        //Present List in organized row_layout format
        SongListAdapter mySongAdapter = new SongListAdapter(this, songs);
        songList.setAdapter(mySongAdapter);
    }

    public void getSongList(){

        //Populate list of songs from device
        ContentResolver myResolver = getContentResolver();
        Uri myUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor myCursor = myResolver.query(myUri, null, null, null, null);
        if(myCursor == null){
            //query failed, handle error
        }
        else if(!myCursor.moveToFirst()){
            //no media on the device
            Toast.makeText(this, "No media found", Toast.LENGTH_SHORT).show();
        }
        else{
            int titleColumn = myCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = myCursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = myCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do{
                //Get Info on audio media to be loaded
                long thisId = myCursor.getLong(idColumn);
                String thisTitle = myCursor.getString(titleColumn);
                String thisArtist = myCursor.getString(artistColumn);

                //add to songs list
                songs.add(new Song(thisId, thisTitle, thisArtist));
            }
            while (myCursor.moveToNext());
        }
    }

    public void onPlayClick(View v){

    }

    public void onPauseClick(View v){

    }

    public void onStopClick(View v){

    }
}
