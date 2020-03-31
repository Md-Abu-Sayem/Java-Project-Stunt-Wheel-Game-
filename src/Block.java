/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Block extends Pane {
    Image blocksImg = new Image(getClass().getResourceAsStream("1.png"));
    ImageView block;
    public enum BlockType {
        PLATFORM, BRICK, BONUS, PIPE_TOP, PIPE_BOTTOM, INVISIBLE_BLOCK, STONE ,SOIL, GRASS ,GREEN, UP, DOWN, ROOT, TOP;
    }
    public Block(BlockType blockType, int x, int y) {
        block = new ImageView(blocksImg);
        block.setFitWidth(Game.BLOCK_SIZE);
        block.setFitHeight(Game.BLOCK_SIZE);
        setTranslateX(x);
        setTranslateY(y);

        switch (blockType) {
            case PLATFORM:
                block.setViewport(new Rectangle2D(0, 0, 16, 16));
                break;
            case BRICK:
                block.setViewport(new Rectangle2D(16, 0, 16, 16));
                break;
            case GREEN:
            	block.setViewport(new Rectangle2D(0, 96, 16, 16));
            	break;
            case BONUS:
            //    block.setViewport(new Rectangle2D(384, 0, 16, 16));
                break;
            case PIPE_TOP:
            //    block.setViewport(new Rectangle2D(0, 128, 32, 16));
            //    block.setFitWidth(Game.BLOCK_SIZE * 2);
                break;
            case PIPE_BOTTOM:
             //   block.setViewport(new Rectangle2D(0, 145, 32, 14));
            //    block.setFitWidth(Game.BLOCK_SIZE * 2);
            case ROOT:
            	block.setViewport(new Rectangle2D(0, 210, 32, 14));
                block.setFitWidth(Game.BLOCK_SIZE * 0.5);
                break;
            case INVISIBLE_BLOCK:
            //    block.setViewport(new Rectangle2D(0, 0, 16, 16));
            //    block.setOpacity(0);
                break;
            case STONE:
              //  block.setViewport(new Rectangle2D(0, 16, 16, 16));
                break;
            case SOIL:
            	block.setViewport(new Rectangle2D(80, 208, 48, 16));
            	break;
            case GRASS:
            	block.setViewport(new Rectangle2D(272, 160, 48, 16));
            	break;
            case UP:
            	block.setViewport(new Rectangle2D(272, 144+1, 24, 32));
            	break;
            case DOWN:
            	block.setViewport(new Rectangle2D(296-1, 144+1, 24, 32));
            	break;
            case TOP:
            	block.setViewport(new Rectangle2D(272, 144+1, 48, 16));
            	break;
            	
        }
        getChildren().add(block);
        Game.platforms.add(this);
        Game.gameRoot.getChildren().add(this);
    }
}
