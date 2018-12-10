
import javafx.scene.control.TextArea;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorAmazonia  {
	@FXML
	TextArea Alimentos;
	@FXML
	Pane mainPane;
	@FXML
	ListView listaElectronica, listaAlimentos, listaLibros, listaModa, listaProductos;
	@FXML
	Button registrarUsuario;
	//GridPane gp=(GridPane)mainPane;
	static User usuario;
	static Users usuarios;
	static boolean usuarioRegistrado;
	static Categorías amazonia;
	@FXML
    public void initialize(){
		//Alimentos.setText("Colacao");
		/*Label label1 = new Label("Categoria 1");
		label1.setTranslateX(300);
		mainPane.getChildren().add(label1);*/
		usuarioRegistrado=false;
		//System.out.println("Bienvenido a nuestra web, again");
		leerPropiedades();
		usuarios=new Users();
		if(usuarios.verificar(usuario)==false) {
			//System.out.println("Usuario no registrado");
			registrarUsuario.setVisible(true);
		}
		else {
			usuarioRegistrado=true;
			
		}
		amazonia=new Categorías(true);
		//usuarios=new Users();
		List<String> electro=new ArrayList<String>();
		//electro.add("uno");
		//electro.add("dos");
		//Collections.copy(electro,);
		listaElectronica.getItems().addAll(amazonia.nombresCategorias[2].getSubCategorias());
		listaAlimentos.getItems().addAll(amazonia.nombresCategorias[0].getSubCategorias());
		listaLibros.getItems().addAll(amazonia.nombresCategorias[3].getSubCategorias());
		listaModa.getItems().addAll(amazonia.nombresCategorias[1].getSubCategorias());
	}
	@FXML
	  public void listarProductosEl(MouseEvent event) {
		//Alimentos.setText("hola");
		Alimentos.setText(listaElectronica.getSelectionModel().getSelectedItem().toString());
	}
	@FXML
	  public void listarProductosAl(MouseEvent event) {
		//Alimentos.setText("hola");
		Alimentos.setText(listaAlimentos.getSelectionModel().getSelectedItem().toString());
	}
	@FXML
	  public void listarProductosLib(MouseEvent event) {
		//Alimentos.setText("hola");
		Alimentos.setText(listaLibros.getSelectionModel().getSelectedItem().toString());
	}
	@FXML
	  public void listarProductosMod(MouseEvent event) {
		//Alimentos.setText("hola");
		Alimentos.setText(listaModa.getSelectionModel().getSelectedItem().toString());
	}
	@FXML
		public void regUsuario(ActionEvent event) {
		 try {
			 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro.fxml"));
			 Parent root = fxmlLoader.load();
			 Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			 stage.setOpacity(1);
			 stage.setTitle("My New Stage Title");
			 stage.setScene(new Scene(root, 850,850));
			 stage.showAndWait();
			 }
			 catch(IOException ioe) {
				 ioe.printStackTrace();
			 }
	}
	@FXML
	public void botonizado(ActionEvent e) {
		
	}
	public static void leerPropiedades() {
		String email="", username="", password="";
	
		try(FileReader reader =  new FileReader("config")) {
	        Properties properties = new Properties();
	        properties.load(reader);
	        email = properties.getProperty("email");
	        username = properties.getProperty("username");
	        password = properties.getProperty("password");
		}
	        catch (Exception e) {
	       e.printStackTrace();
	       }
		
	        if(email!=null && username!=null && password!=null) {
	        	usuario=new User(username, email, password);
	        	/*@FXML
	        	try {
	        		FXMLLoader fxmlLoader = new FXMLLoader(ControladorAmazonia.class.getClass().getClassLoader().getResource("registro.fxml"));
		        	 Parent root = fxmlLoader.load();
		       		 Stage stage = new Stage();
		       		 stage.initModality(Modality.APPLICATION_MODAL);
		       		 stage.setOpacity(1);
		       		 stage.setTitle("My New Stage Title");
		       		 stage.setScene(new Scene(root, 850,850));
		       		 stage.showAndWait();
	        	}
	       		 catch(IOException ioe) {
	       			 ioe.printStackTrace();
	       		 
	        	System.out.println(usuario.email);
		        System.out.println(usuario.name);
		        System.out.println(usuario.password);
	       		 }*/
	        }
	        
	}

}