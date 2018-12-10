import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Producto {
	//public static void main (String[] arg){
		public String nombreProducto ,categoria, subCategoria;
		float precio, valoracion;
		
public Producto(String nombreProd, String categoria, String subCategoria) {
	
	try(FileReader reader =  new FileReader(nombreProd)) {
		//System.out.println(nombreProd);
        Properties properties = new Properties();
        properties.load(reader);
        this.categoria=categoria;
        this.subCategoria=subCategoria;
        nombreProducto = properties.getProperty("nombreProducto");
        //System.out.println(nombreProducto);
        precio =Float.valueOf( properties.getProperty("precio"));
        //System.out.println(precio);
        valoracion = Float.valueOf(properties.getProperty("valoracion"));
        //System.out.println(valoracion);
        reader.close();
        //System.out.println("Producto creado");
        
       }catch (Exception e) {
    	   System.out.println(e.getMessage());
       }
	/*catch(IOException ioe) {
		System.out.println(e.getMessage());
	}*/

	}
}
