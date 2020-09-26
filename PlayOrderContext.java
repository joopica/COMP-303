package ca.mcgill.cs.swdesign.finalCodeBase;

// wrapper class to implement strategy pattern
import java.util.List;

public class PlayOrderContext
{
	private PlayOrder playorder;

	public PlayOrderContext(PlayOrder aPlayOrder)
	{
		this.playorder = aPlayOrder;
	}

	public void update(List<Song> newSongElements)
	{
		playorder.update(newSongElements);
	}

	public int getNext()
	{
		return playorder.getNext();
	}

	public boolean hasNext()
	{
		return playorder.hasNext();
	}
}
