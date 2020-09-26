package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing the Queue in the Music Player App.
 * It contains a list of songs that the Music Player can play
 * using different playing strategy.
 * It can contain repeated songs.
 */
public class Queue implements Iterable<Song> {
    private List<Song> aSongElements = new ArrayList<>();
    private PlayOrder playorder = new Ordered(this.aSongElements);
    private PlayOrderContext currentPlayState = new PlayOrderContext(this.playorder);

    private List<Controller> aObservers = new ArrayList<Controller>();

    public void addObserver(Controller pObserver)
    {
        aObservers.add(pObserver);
    }
    
    private void notifyObservers()
    {
        assert !aObservers.isEmpty();
        for (Controller observer : aObservers) {
            observer.update(this);
        }
    }

    /**
     * Obtain the number of songs in the queue
     * @return the number of songs in the queue
     */
    public int size() {
        return aSongElements.size();
    }

    /**
     * Obtain the song using its index in the queue.
     * @param index the position of the song in the queue
     * @return the song in the queue at the position of the input index
     * @pre index >=0 && index < aSongElements.size()
     */
    public Song get(int index) {
        assert index >=0 && index < aSongElements.size();
        return aSongElements.get(index);
    }

    /**
     * Add a single song to the queue.
     * @param pItem the Song to be added to the queue
     * @pre pItem!=null
     */
    public void add(Song pItem) {
        assert pItem!=null;
        aSongElements.add(pItem);
        this.updateQueueState();
    }

    /**
     * Add a single song from the queue if it can be found.
     * If it appears more than once in the queue, the first occurrence will be removed.
     * @param pItem the Song to be removed to the queue if presented
     * @pre pItem!=null
     */
    public void remove(Song pItem) {
        assert pItem!=null;
        if (aSongElements.contains(pItem))
        {
            aSongElements.remove(pItem);
            this.updateQueueState();
        }
    }

    /**
     * Sets the Play Order state of the current queue using command from user
     * @param namePlayOrder String passed from user to musicplayer specifying playorder
     * @pre namePlayOrder != null
    */
    public void setQueueState(String namePlayOrder)
    {
        if(namePlayOrder.equalsIgnoreCase("ordered"))
        { 
            this.playorder = new Ordered(aSongElements);
            this.currentPlayState = new PlayOrderContext(playorder);
            updateQueueState(); }
        else if (namePlayOrder.equalsIgnoreCase("shuffle"))
        { 
            this.playorder = new Shuffle(aSongElements);
            this.currentPlayState = new PlayOrderContext(playorder);
            this.updateQueueState(); }
        else 
        { throw new IllegalArgumentException("Please enter 'ordered' or 'shuffle'."); }
    }

    /**
    * Reinitializes the order of play according to what it is already.
    * Does not change the play state.
    */
    public void updateQueueState()
    {
        currentPlayState.update(aSongElements);
        this.notifyObservers();
    }

    /**
    * returns the iterator for the Queue
     * @return
     */
    @Override
    public Iterator<Song> iterator()
    {
        this.currentPlayState = new PlayOrderContext(playorder);
        return new QIterator(currentPlayState);
    }

    /**
    * private class that implements iteration over the queue
    */
    class QIterator implements Iterator<Song> {
        PlayOrderContext innerPlayState = Queue.this.currentPlayState;

        public QIterator(PlayOrderContext passedPlayState)
        {
            this.innerPlayState = passedPlayState;
        }

        // return true if there are songs that
        // have not been iterated over.
        @Override
        public boolean hasNext() {
            System.out.println(currentPlayState.hasNext());
            return currentPlayState.hasNext();
        }

        // return the next song  of the iteration
        @Override
        public Song next() {
            assert hasNext();
            return aSongElements.get(currentPlayState.getNext());

        }
    }
}
