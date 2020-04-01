

import java.util.HashMap;

import javafx.scene.input.KeyCode;

public class Movement {
	public static HashMap<KeyCode,Boolean> keys = new HashMap<>();
	public static Character player = new Character();
	public  static void update(){
	        if(isPressed(KeyCode.UP) && player.getTranslateY()>=300){
	            player.jumpPlayer();
	        }
	        if(isPressed(KeyCode.LEFT) && player.getTranslateX()>=5){
	        	player.setScaleX(-1);
	     //   	player.animation.play();
	        	player.moveX(-5);
	        }
	        if(isPressed(KeyCode.RIGHT) && player.getTranslateX()+40 <=Game.levelWidth-5){
	        	player.setScaleX(1);
	        //	player.animation.play();
	        	player.moveX(5);
	        }
	        if(player.playerVelocity.getY()<10){                         
	        	player.playerVelocity = player.playerVelocity.add(0,1);
	        }
	        player.moveY((int)player.playerVelocity.getY());
	    }
	    private static boolean isPressed(KeyCode key){
	        return keys.getOrDefault(key,false);
	    }

}
