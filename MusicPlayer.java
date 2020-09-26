package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Collections;

/**
 * A class representing a Music Player App.
 * It contains a pool of songs that allow the user to traverse and add to the queue to play.
 */
public class MusicPlayer implements Iterable<Song> {
    private Map<String, Song> aItems = new LinkedHashMap<>(); // Make sure a predictable iteration order.
    private Queue aQueue = new Queue(); //

    private Map<String, Playlist> aPlaylists = new LinkedHashMap<>(); // storage for the playlists

    MusicPlayer(){}

    /**
     * aItems.values() returns a Collection view of Songs in the linked hashmap which is iterable.
     * @return iterator for the songs in the pool
     */
    @Override
    public Iterator<Song> iterator()
    {
        return aItems.values().iterator();
    }

    /**
    * Creates a new empty playlist and adds it to the storage HashMap if there is none other with the same name.
    * Throws an exception and prints a message if there is 
    */
    public void createPlaylist(String pName)
    {
        assert pName != null;
        if (aPlaylists.containsKey(pName))
            { 
                throw new IllegalArgumentException("This playlist name is in use. Please try again.");
            }
        Playlist aPlaylist = new Playlist(pName);
        aPlaylists.put(pName, aPlaylist);
    }

    /**
     * Adds a given song to the specified playlist and adds it to the library if it is not already in it.
     * @param pPlaylist playlist we are adding to
     * @param pSong song we are adding to pPlaylist
     * @pre pPlaylist !null && pSong !null
    */    
    public void addSongToPlaylist(String playlist, Song pSong)
    {
        assert playlist != null;
        assert pSong != null;
        if(aPlaylists.containsKey(playlist))
        {
            aPlaylists.get(playlist).addItem(new SongWrapper(pSong));
            aItems.putIfAbsent(pSong.getName(), pSong);
        }
    }

    /**
     * Adds playlist1 to playlist2 if they both exist in aPlaylists.
     * @param playlist1 Playlist we are adding to playlist2
     * @param playlist2 Playlist we are adding into
     * @pre playlist1 !null && playlist2 !null
    */    
    public void addPlaylistToPlaylist(Playlist playlist1, Playlist playlist2)
    {
        assert playlist1 != null;
        assert playlist2 != null;
        if(aPlaylists.containsValue(playlist1) && aPlaylists.containsValue(playlist2))
        {
            playlist2.addItem(playlist1);
        }
    }

    /**
     * Add a single song to the music pool if a song with the same name is not already in the pool.
     * @param pSong Song the song to be added in the pool
     * @pre pSong !=null
     */
    public void addSong(Song pSong) {
        assert pSong != null;
        aItems.putIfAbsent(pSong.getName(), pSong);
        aQueue.updateQueueState();
    }

    /**
     * Add a single song to the queue if that song can be found in the music pool.
     * @param songName String the name of the song
     * @pre songName !=null
     */
    public void addSongToQueue(String songName) {
        assert songName!= null;
        if (aItems.containsKey(songName))
            { aQueue.add(aItems.get(songName));
              aQueue.updateQueueState(); }
    }

    /**
     * Add songs from a playlist to the queue if that playlist exists.
     * @param playlistName the name of the playlist
     * @pre playlistName !=null
     */
    public void addPlaylistToQueue(String playlistName) {
        assert playlistName != null;
        if (aPlaylists.containsKey(playlistName)) {
            for (Song song : aPlaylists.get(playlistName).getSongs()) {
                aQueue.add(song);
            }
            aQueue.updateQueueState();
        }
    }

    /**
     * Sets the playorder of the aQueue to shuffle or ordered
     * @param order String command that specifies what order to play the Queue in
     * @pre order != null
     */
    public void setQueueOrder(String order)
    {
        assert order != null;
        aQueue.setQueueState(order);
    }

    /**
     * Obtain the number of songs in the queue
     * @return the number of songs in the queue
     */
    public int getQueueSize() {
        return aQueue.size();
    }

    public Queue getQueue()
    {
        return this.aQueue;
    }


}
