
import processing.core.PApplet;
import processing.core.PImage;


/*
 * INSTRUCTIONS: You are taking a bath, but you just realized you lost your rubber ducky. Oh, no! 
 * Find your rubber ducky by moving the bubbles, using your mouse. Retrieve your ducky in ten seconds 
 * and you get a special message. If not... the ducky may get impatient and make fun of you.
 */

public class MyGame extends PApplet {
	public static void main (String args []){
		PApplet.main (new String [] {"MyGame"});
	}

	// start timer
	Bubble[] theBubbles;
	Duck duck;
	public boolean gameOver = false;
	private long start = System.currentTimeMillis();
	private long end = start + 10* 1000;

	public void setup()						{ 
		duck = new Duck(this);
		// creates new duck
		size (900, 900);
		background (118, 204, 247); // blue background
		Bubble.width = 900;
		Bubble.height = 900;
		this.theBubbles = new Bubble [900];// create an array of bubble objects
		for (int i = 0; i < this.theBubbles.length; i++) {
			this.theBubbles[i] = new Bubble(random(0, width), random(0, height));
		}// for
	}// if

	public void draw() {
		// erase the background
		if (!gameOver){
			background(118, 204, 247);
			long currentTime = System.currentTimeMillis();
			duck.display();
			for (int i = 0; i < this.theBubbles.length; i++) {
				this.theBubbles[i].move();
				ellipse(this.theBubbles[i].x, this.theBubbles[i].y, 90, 90); // size of ellipses
			}// for}
			drawCursor();
			if (currentTime > end){
				background(118, 204, 247);
				duck.display();
				PImage loser = loadImage("loserscreen.png");
				image(loser, 130, 140); // you ran out of time
				return;
			}
			if (gameOver == true){
				// you won!
				background(118, 204, 247);
				duck.display();
				PImage winner = loadImage("winnerscreen.png");
				image(winner, 130, 140);
			}
		}
	}
	// draw
	public void drawCursor(){
		if (this.mousePressed){
			// bubbles in click area need to move!
			int mouserange;
			mouserange = 70;
			for (int q = 0; q <theBubbles.length; q++){ //for each bubble in ze array
				if (dist(mouseX,mouseY,theBubbles[q].x,theBubbles[q].y) < mouserange){
					theBubbles[q].setSpeed((float)((theBubbles[q].x - this.mouseX)),
							(float)((theBubbles[q].y - this.mouseY)));
				}// if loop

			}
			if ((mouseX >= duck.x && mouseX <= duck.x + 225) && (mouseY >= duck.y && mouseY <= duck.y + 215)){
				// if it fits within the png coordinate parameters
				this.gameOver = true;
			}
		}
	}

}//drawCursor//



