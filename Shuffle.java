package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A playorder strategy that returns a shuffled version of the iterator
 * Iterator object is shuffled, but the index of next() is the original placement of the Song in the ordered list
 */

public class Shuffle implements PlayOrder, Iterable<Song>
{
    private List<Song> newOrder;
    private List<Song> oldOrder;
    private Iterator<Song> iter;
    int i;

    public Shuffle(List<Song> aSongElements)
    {
        this.newOrder = new ArrayList<>(aSongElements); //clone first and then shuffle
        Collections.shuffle(newOrder); // they are the same size
        this.iter = newOrder.iterator();
        this.i = 0;
    }

    @Override
    public Iterator<Song> iterator() {
        this.iter = newOrder.iterator();
        return iter;
    }


    @Override
    public void update(List<Song> newSongElements)
    {
        this.newOrder = new ArrayList<>(newSongElements);
        Collections.shuffle(newOrder);
        this.iter = this.iterator();
    }

    /**
     * Return the index of the next element in the collection
     * based on the shuffled traversing method.
     * @return the index of the next element in the collection
     */
    @Override
    public int getNext()
    {
    	assert hasNext();
    	i++;
        return this.newOrder.indexOf(iter.next());
    }  
    
    /**
     * Check if all element in the collection has been traversed.
     * @return true if the collection has more element to traverse
     */
    @Override
    public boolean hasNext()
    {
        return (i < oldOrder.size());
    }
}