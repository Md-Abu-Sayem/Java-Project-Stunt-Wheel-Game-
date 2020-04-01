

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SoundController implements Initializable{

	
   String path = new File("src/Sleigh-ride-song.mp3").getAbsolutePath();
//	String path = "C:\\Users\\User\\eclipse-workspace\\Javafx1\\src\\Sound\\Sleigh-ride-song.mp3" ;
	@FXML
	 public Media me = new Media(new File(path).toURI().toString());
	 public MediaPlayer mp= new MediaPlayer(me);

	@Override
	public void initialize(URL location , ResourceBundle resources) {
		// TODO Auto-generated method stub
			;;;

	}
	
	@FXML
	public void Play(ActionEvent event) {
		mp.play();
	}
	
	@FXML
	public void Pause(ActionEvent event) {
		mp.pause();
	}
	
//	public SoundController sc = new SoundController();


}

