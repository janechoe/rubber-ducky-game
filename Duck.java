import processing.core.PApplet;

import processing.core.PImage;
public class Duck extends PApplet {
	public float x, y;
	private PApplet canvas;
	private PImage duck;

	public Duck(PApplet canvas) {
		this.canvas = canvas;
		// figure out our starting position
		this.x = random (100, 600);
		this.y = random (100, 600);
		// load in our artwork
		this.duck = this.canvas.loadImage("duck.png");

	}
	public void display() {
		this.canvas.image(this.duck, this.x, this.y);
	}
}
