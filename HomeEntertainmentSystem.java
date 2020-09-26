package ca.mcgill.cs.swdesign.finalCodeBase;

import java.util.Iterator;

/**
 *
 * Class representing the client code of the MusicPlayer app.
 *
 */
public class HomeEntertainmentSystem {

	/**
	 * Creating songs to work with
	 */
    private static final Song SONG1 = new Song("Smells like teen spirit", "Nirvana", 4);
	private static final Song SONG2 = new Song("I got a feeling", "Black-eyed Peas", 3);
	private static final Song SONG3 = new Song("September", "Greenday", 5);
	private static final Song SONG4 = new Song("Somewhere only we know", "Lily Allen", 4);
	private static final Song SONG5 = new Song("Symphony no. 9", "Beethoven", 10);
	private static final Song SONG6 = new Song("Sleep", "Eric Whitacre", 6);

    public static void main(String[] args) {
    	MusicPlayer app = new MusicPlayer();

    	app.addSong(SONG1);
		app.addSong(SONG2);
		app.addSong(SONG3);
		app.addSong(SONG4);
		app.addSong(SONG5);
		app.addSong(SONG6);

//    	Iterator<Song> iter = app.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next().getName());
//		}

		String playlist = "i like to eat salsa";
		app.createPlaylist(playlist);
		app.addSongToPlaylist(playlist, SONG1);
		app.addSongToPlaylist(playlist, SONG5);
		app.addSongToPlaylist(playlist, SONG6);

		app.addPlaylistToQueue(playlist); //156 44 1563 1
		app.addSongToQueue(SONG4.getName());
		app.addSongToQueue(SONG4.getName());

		app.addSongToPlaylist(playlist, SONG3);
		app.addPlaylistToQueue(playlist);
		app.addSongToQueue(SONG1.getName());

		app.setQueueOrder("shuffle");

		VoiceController vc = new VoiceController(app.getQueue());

		int i = 0;
		while(i<app.getQueueSize())
		{
			vc.next();
		}

//		Iterator<Song> iter = app.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next().getName());
//		}

    }
//
//    public void play()
//	{
//
//	}

//	public static void main (String[] args)
//	{
//		try
//		{
//			MusicPlayer obj = new MusicPlayer ();
//			obj.run (args);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace ();
//		}
//	}
//
//// instance variables here
//
//	public void run (String[] args) throws Exception
//	{
//		// put your code here
//	}
}
