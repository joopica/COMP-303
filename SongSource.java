package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.List;

/**
 * Interface that represents where to get songs from.
 */
public interface SongSource
{
    /**
     * @return a list of the songs from the source
     * @pre !isEmpty()
     */
    List<Song> getSongs();

    /**
     * Get name of song or playlist
     * @return name of song or playlist
     * @pre !isEmpty
     */
    String getName();

    /**
     * @return True if there are no songs in the source.
     */
    boolean isEmpty();

}
