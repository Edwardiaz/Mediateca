
package desafio02.mediateca;

import datos.MaterialesJDBC;
import datos.SociosJDBC;
import entidades.Materiales;
import entidades.Socios;
import java.util.List;

/**
 *
 * @author Jorge Diaz
 */
public class Desafio02Mediateca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaterialesJDBC material = new MaterialesJDBC();
        
        List<Materiales> materialesList = material.select();
        for (Materiales ma : materialesList) {
            System.out.print(ma.getTitulo());
            System.out.println(ma.getCodigoTipoMaterial());
            System.out.println(ma.getCodigoAutor());
            System.out.println(ma.getNumeroDePaginas());
            System.out.println("");
        }
        
        //mostrarSocio();
    }
    
    /*public static void mostrarSocio(){
        SociosJDBC socio = new SociosJDBC();
        
        List<Socios> sociosLista = socio.select();
        for(Socios so : sociosLista){
            System.out.println(so.getNombre());
            System.out.println(so.getId());
            System.out.println(so.getDocumento());
            System.out.println("-----");
        }*/
        
    }
    

