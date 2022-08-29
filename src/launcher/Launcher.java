package launcher;

import entities.Student;
import gui.SimplePresentationScreen;


public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	Student ValentinPistonesi = new Student(127794,"Pistonesi", "Valentin", "pistonesivalentin@gmail.com", "https://github.com/valenpistonesi", "/images/20220724_185750 (2).png");
        	SimplePresentationScreen gui = new SimplePresentationScreen(ValentinPistonesi);
            public void run() {
            	gui.setModalExclusionType(null);
            	gui.setVisible(true);
            }
        });
    }
}