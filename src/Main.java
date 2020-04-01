

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
		Game field=new Game();
		public static Scene sn;
		static Parent root;
		public static Stage ps;

	 @Override
	    public void start(Stage primaryStage) throws Exception {
		 

		
		 	root = FXMLLoader.load(getClass().getResource("UI.fxml"));
			
//			par=root;
				
			sn= new Scene(root,700,500);
//			primaryStage.setTitle("Welcome");
			primaryStage.setScene(sn);
			ps=primaryStage;
			ps.show();
		 
		 
			/*
		 
	        field.initContent();
	        Scene scene = new Scene(field.appRoot,1200,620);
	        scene.setOnKeyPressed(event-> Movement.keys.put(event.getCode(), true));
	        scene.setOnKeyReleased(event -> {
	            Movement.keys.put(event.getCode(), false);
	             Movement.player.animation.stop();
	        });
	        primaryStage.setTitle("Mini Mario");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	                Movement.update();
	            }
	        };
	        timer.start();
	        
	        */
	    }
	    public static void main(String[] args) {
	        launch(args);
	    }

}
