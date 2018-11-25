package edu.iastate.cplata.client_applicationa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * This class is used to "adapt" the song information (data in the Song constructor)
 * to View objects in ListView
 */
public class SongListAdapter extends BaseAdapter {

    /**
     * The list of songs from device's media to be displayed in ListView
     */
    private ArrayList<Song> songs;

    /**
     *The layout inflater associated with parent context
     */
    private LayoutInflater songInflater;

    /**
     * Constructor for SongListAdapter
     * @param context   The Activity context ArrayAdapter is being used in
     * @param songData  Song objects to be displayed in ListView
     */
    public SongListAdapter(Context context, ArrayList<Song> songData){
        songs = songData;
        songInflater = LayoutInflater.from(context);
    }

    /**
     * Get how many songs retrieved from device's media and put into songs ArrayList
     * @return number of songs in ArrayList
     */
    @Override
    public int getCount() {
        return songs.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position ) {
        return 0;
    }

    /**
     * Get a View that displays data at specified position in data set
     *
     * @param position      Position of item within data set of item whose view user wants
     * @param convertView   Old view
     * @param parent        Parent view will attach to
     * @return A view corresponding to the data at the specified position
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            // convertView being null means new View should be inflated from specified layout
            // for this case, our layout should be row_layout.xml
            LinearLayout mySongLayout = (LinearLayout)songInflater.inflate(R.layout.row_layout, parent, false);

            // get id for song's name and artist in ListView and assign to created TextViews
            TextView songTextView = (TextView)mySongLayout.findViewById(R.id.songList_name);
            TextView artistTextView = (TextView)mySongLayout.findViewById(R.id.songList_artist);

            //Retrieve Song details
            Song thisSong = songs.get(position);
            songTextView.setText(thisSong.getTitle());
            artistTextView.setText(thisSong.getArtist());

            //Set position
            mySongLayout.setTag(position);
            return mySongLayout;
        }
        return null;
    }
}
