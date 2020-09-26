package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Wrapper class for song to be used as a source for composite class playlist
 */

public class SongWrapper implements SongSource
{
    private Song aSong;

    public SongWrapper(Song pSong)
    {
        this.aSong = pSong;
    }

    @Override
    public List<Song> getSongs()
    {
        return Collections.singletonList(this.aSong);
    }

    @Override
    public String getName()
    {
        return this.aSong.getName();
    }

    @Override
    public boolean isEmpty()
    {
        return (this.aSong == null || this.aSong.getName() == null);
    }
}
