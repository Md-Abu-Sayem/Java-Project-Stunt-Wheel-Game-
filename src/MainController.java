

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
	
	Game field=new Game();
	static SoundController tune = new SoundController();
	public void Start(ActionEvent event) throws Exception {
		System.out.println("Game Started");
		field.initContent();
		Stage primaryStage = (Stage) ( ((Node) event.getSource()).getScene().getWindow() );
        Scene scene = new Scene(field.appRoot,1200,700);
        scene.setOnKeyPressed(e-> Movement.keys.put( e.getCode(), true));
        
        
        scene.setOnKeyReleased(e -> {
            Movement.keys.put(e.getCode(), false);
           //  Movement.player.animation.stop();
        });
        primaryStage.setTitle("Stunt Wheel Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Movement.update();
            }
		
        };
        
        timer.start();
	}
	/*
	 	Parent lpg = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scn = new Scene(lpg);
	//	Scene scn = MainLogin.getSn();
		Stage window1 = (Stage) ( ((Node) event.getSource()).getScene().getWindow() );
	//	Stage window2=window1; 
		window1.setScene(scn);
		window1.show();
		 mp.pause();
	 
	 */
	public void goOption(ActionEvent event) throws Exception {
		
		
	}
	public void goSettings(ActionEvent event) throws Exception {
		//	tune.mp.pause();
			Parent music = FXMLLoader.load(getClass().getResource("Sound.fxml"));
			Scene scn = new Scene(music);
		//	Scene scn = MainLogin.getSn();
			Stage window1 = (Stage) ( ((Node) event.getSource()).getScene().getWindow() );
		//	Stage window2=window1; 
			window1.setScene(scn);
			window1.show();
			// mp.pause();
	}
	public void On(ActionEvent event) {
		//System.out.println("Sound is on");
		tune.mp.play();
		
	}
	
	
	public void Off(ActionEvent event) {
		//System.out.println("Sound is off");
		tune.mp.pause();
		
	}
	public void goExit(ActionEvent event) throws Exception {
		Parent bye = FXMLLoader.load(getClass().getResource("close.fxml"));
		Scene scn = new Scene(bye);
	//	Scene scn = MainLogin.getSn();
		Stage window1 = (Stage) ( ((Node) event.getSource()).getScene().getWindow() );
	//	Stage window2=window1; 
		window1.setScene(scn);
		window1.show();
		
		
	}
	public void close(ActionEvent event) {
		System.out.println("Your Score is " + (int)Character.score);
		System.exit(0);
	}
	public void goBack(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
		Scene scn = new Scene(root);
	//	Scene scn = MainLogin.getSn();
		Stage window1 = (Stage) ( ((Node) event.getSource()).getScene().getWindow() );
	//	Stage window2=window1; 
		window1.setScene(scn);
		window1.show();
		
		// mp.pause();
		
		
	}

	

}
