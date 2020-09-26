package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Iterator;

class RemoteController implements Controller
{	
	private Iterator<Song> iter;

	private Queue aQueue;
	private PlayOrderContext currentPlayState;
	
	/**
	 * @param pQueue The model observed by this controller.
	 */
	RemoteController(Queue pQueue)
	{
		this.aQueue = pQueue;
		this.iter = aQueue.iterator();
		aQueue.addObserver(this);
	}

	@Override
	public void next()
	{
		System.out.println(iter.next().getName());
	}

	@Override
	public void update(Queue pQueue)
	{
		this.aQueue = pQueue;
		System.out.println("Queue was updated.");
	}
}