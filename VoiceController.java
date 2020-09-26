package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Iterator;

class VoiceController implements Controller
{
	private Iterator<Song> iter;
	private Queue aQueue;
	private PlayOrderContext currentPlayState;
	
	/**
	 * @param pQueue The model observed by this controller.
	 */
	VoiceController(Queue pQueue)
	{
		this.aQueue = pQueue;
		this.iter = aQueue.iterator();
		aQueue.addObserver(this);
	}

	@Override
	public void next()
	{
		assert iter.hasNext();
		System.out.println("Command received. Playing next song.");
		System.out.println(iter.next().getName());
	}

	@Override
	public void update(Queue pQueue)
	{
		this.aQueue = pQueue;
		this.iter = pQueue.iterator();
		System.out.println("Queue was updated.");
	}
}