import processing.core.PApplet;
public class Bubble {
		    // store my position
		  // all balls should keep track of their x and y positions
		  public float x;
		  public float y;

		  // all balls should have an x speed and y speed
		  private float xSpeed;
		  private float ySpeed;

		  public void setSpeed(float x, float y) {
			  
			  if (x < -6) {
				  xSpeed = -6;
			  } else if (x > 6) {
				  xSpeed = 6;
			  } else {
				  xSpeed = x;
			  }
			  
			  if (y < -6) {
				  ySpeed = -6;
			  } else if (y > 6) {
				  ySpeed = 6; 
			  } else {
				  ySpeed = y;
			  }
			  
		  }
		  
		  // the Ball class should keep track of the size of the world the balls live in
		  public static int width;
		  public static int height;
		  // constructor
		  public Bubble (float x, float y){
			// store my position
			    this.x = x;
			    this.y = y;

			    // give me a random speed
			    this.xSpeed = (float) (Math.random() * 4) - 3;
			    this.ySpeed = (float) (Math.random() * 4) - 3;
			  }

			  // move a ball
			  public void move() {
			    this.x += this.xSpeed;
			    this.y += this.ySpeed;

			    // bounce!
			    if (this.x > width) {
			      this.x = width;
			      this.xSpeed *= -1;
			    }
			    if (this.x < 0) {
			      this.x = 0;
			      this.xSpeed *= -1;
			    }
			    if (this.y > height) {
			      this.y = height;
			      this.ySpeed *= -1;
			    }
			    if (this.y < 0) {
			      this.y = 0;
			      this.ySpeed *= -1;
			    }
		  }
}
		 