

import javafx.animation.AnimationTimer;
import  javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Game  {
    public static ArrayList<Block> platforms = new ArrayList<>();    
   // private HashMap<KeyCode,Boolean> keys = new HashMap<>();

    Image backgroundImg = new Image(getClass().getResourceAsStream("background.png"));
    public static final int BLOCK_SIZE = 45;
    public static final int CAR_SIZE = 80;

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

   // public Character player;
    int levelNumber = 0;
    static int levelWidth;

    void initContent(){
        ImageView backgroundIV = new ImageView(backgroundImg);
        backgroundIV.setFitHeight(14*BLOCK_SIZE);
        backgroundIV.setFitWidth(212*BLOCK_SIZE);

        levelWidth = LevelData.levels[levelNumber][0].length()*BLOCK_SIZE;
        for(int i = 0; i < LevelData.levels[levelNumber].length; i++){
            String line = LevelData.levels[levelNumber][i];
            for(int j = 0; j < line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Block platformFloor = new Block(Block.BlockType.PLATFORM, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        Block brick = new Block(Block.BlockType.BRICK,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '3':
                     //   Block bonus = new Block(Block.BlockType.BONUS,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '4':
                     //   Block stone = new Block(Block.BlockType.STONE,j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '5':
                     //   Block PipeTopBlock = new Block(Block.BlockType.PIPE_TOP,j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '6':
                     //   Block PipeBottomBlock = new Block(Block.BlockType.PIPE_BOTTOM,j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '7':
                    	  Block green = new Block(Block.BlockType.GREEN ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case '*':
                     //   Block InvisibleBlock = new Block(Block.BlockType.INVISIBLE_BLOCK,j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '8':
                    	Block soil = new Block(Block.BlockType.SOIL ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case 'G':
                    	Block grass = new Block(Block.BlockType.GRASS ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case 'U':
                    	Block up = new Block(Block.BlockType.UP ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case 'D':
                    	Block down = new Block(Block.BlockType.DOWN ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case 'R':
                    	Block root=	new Block(Block.BlockType.ROOT ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                    case 'T':
                    	Block top=	new Block(Block.BlockType.TOP ,j*BLOCK_SIZE, i*BLOCK_SIZE);
                    	break;
                }
            }

        }
        Movement.player =new Character();
        Movement.player.setTranslateX(100);
        Movement.player.setTranslateY(400);
        Movement.player.translateXProperty().addListener((obs,old,newValue)->{
            int offset = newValue.intValue();
            if(offset>640 && offset<levelWidth-640){
                gameRoot.setLayoutX(-(offset-640));
                backgroundIV.setLayoutX(-(offset-640));
            }
        });
        
        Button back=new Button("BACK");
        
        back.setOnAction(e->{
        	Main.ps.setScene(Main.sn);
        	Main.ps.show() ;
        });
        
        gameRoot.getChildren().add(Movement.player);
        appRoot.getChildren().addAll(backgroundIV,gameRoot,back);
    }


}