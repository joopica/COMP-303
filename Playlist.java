package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * Composite playlist class with list of SongSources
 */

public class Playlist implements SongSource
{
    private List<SongSource> aSongs = new ArrayList<SongSource>();
    private String aName;

    private List<Song> justSongs = new ArrayList<Song>();

    /**
     * Creates a new empty playlist with the given name.
     */
    public Playlist(String pName)
    {
        this.aName = pName;
    }

    /**
     * Gets the name of the playlist
     * @return Name of the playlist.
     */
    @Override
    public String getName()
    {
        return this.aName;
    }

    /**
     * Adds pSong to the playlist
     * @param pItem the song or playlist to add to the playlist
     * @pre pItem !=null
     */
    public void addItem(SongSource pItem)
    {
        assert pItem != null;
        aSongs.add(pItem);
    }

    /**
     * Gets the songs in the playlist as a List<Song>
     * @return Collection of songs in this playlist
     * @pre !isEmpty()
     */
    @Override
    public List<Song> getSongs()
    {
        assert !isEmpty();
        for (SongSource source : aSongs)
        {
            justSongs.addAll(source.getSongs());
        }
        return justSongs;
    }

    /**
     * @return True if there are no SongSources in the Playlist.
     */
    @Override
    public boolean isEmpty() {
        return aSongs.isEmpty();
    }

}
