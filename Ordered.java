package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ordered implements PlayOrder, Iterable<Song>
{
	private List<Song> order;
	private Iterator<Song> iter;
	private int i;

	public Ordered(List<Song> aSongElements)
	{
		this.order = aSongElements;
		this.iter = aSongElements.iterator();
		this.i = 0;
	}

	@Override
	public Iterator<Song> iterator() {
		return this.iter;
	}

	@Override
	public void update(List<Song> newSongElements)
	{
		this.order = newSongElements;
		this.iter = newSongElements.iterator();
	}

	/**	
	 * Return the index of the next element in the collection
	 * based on the ordered traversing method.
	 * @return the index of the next element in the collection
	 */
	@Override
	public int getNext()
	{
		System.out.println(i);
		i++;
		if (!hasNext()) throw new AssertionError();
		return i;
	}

	/**
	 * Check if all elements in the collection has been traversed.
	 * @return true if the collection has more elements to traverse
	 */
	@Override
	public boolean hasNext()
	{
		return (i < order.size());
	}
}