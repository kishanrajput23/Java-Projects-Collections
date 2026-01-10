import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class PlayGameWithMusic 
{
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		File file = new File("Marvel's Avengers Game - Main Theme.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		Introduction i=new Introduction();		
	}
}
