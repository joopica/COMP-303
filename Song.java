package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Collections;
import java.util.List;

public class Song
{
    private final String aName;
    private final String aArtist;
    private final int aLength;

    public Song(String pName, String pArtist, int pLength) {
        assert pName!=null && pArtist!=null && pLength >0;
        aName = pName;
        aArtist = pArtist;
        aLength = pLength;
    }

    public String getName() {
        return this.aName;
    }

    public String getArtist() {
        return this.aArtist;
    }

    public int getLength() {
        return this.aLength;
    }
}
