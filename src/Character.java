

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Character extends Pane{
	public static double score=0.0;
    Image carImg = new Image(getClass().getResourceAsStream("bmw.png"));
    ImageView imageView = new ImageView(carImg);
  //  int count = 3;
  //  int columns = 3;
    int offsetX = 2;
    int offsetY = 10;
    int width = 562;
    int height = 200;
   // public SpriteAnimation animation;
    public Point2D playerVelocity = new Point2D(0,0);
    private boolean canJump = true;

    public Character(){
        imageView.setFitHeight(80);
        imageView.setFitWidth(150);
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
     //   animation = new SpriteAnimation(this.imageView,Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int value){
    	score+=0.2;
        boolean movingRight = value > 0;
        for(int i = 0; i<Math.abs(value); i++) {
            for (Node platform : Game.platforms) {
                if(this.getBoundsInParent().intersects(platform.getBoundsInParent())) { //if car touches one of the blocks from left or right side
                    if (movingRight) {
                        if (this.getTranslateX() + Game.CAR_SIZE == platform.getTranslateX()){ 
                            this.setTranslateX(this.getTranslateX() - 1);           // moving it little back.at last we will move it same amount front
                            return;
                        }
                    }
                    else {
                        if (this.getTranslateX() == platform.getTranslateX() + Game.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }
    public void moveY(int value){
        boolean movingDown = value >0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Block platform :Game.platforms){            //for(auto i=platforms.begin(); i<platforms.begin(); i++) x=platforms[i];
                if(getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY()+ Game.CAR_SIZE >= platform.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{   //movingUp
                        if(this.getTranslateY() == platform.getTranslateY()+ Game.BLOCK_SIZE){
                            this.setTranslateY(this.getTranslateY()+1);   //push the car down
                            playerVelocity = new Point2D(0,10); 
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
            if(this.getTranslateY()>640 || this.getTranslateX()>9400){
                this.setTranslateX(0);
                this.setTranslateY(350);    //if player dies it will start from beggining
                Game.gameRoot.setLayoutX(0);
              //  Game.gameRoot.setLayoutY(500);
            }
        }
    }
    public void jumpPlayer(){
        if(canJump){
            playerVelocity = playerVelocity.add(0,-30);
            canJump = false;
        }
    }
}