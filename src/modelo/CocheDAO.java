package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//DAO

public interface CocheDAO {

    public List<CocheDTO> mostrarLista();
    public CocheDTO mostrarCochePorNB(String numeroBastidor);
    public void anadirListaCoches(ArrayList<CocheDTO> lista) throws SQLException;
    public void anadirCoche(CocheDTO coche) throws SQLException;
    public void borrarCoche(String numeroBastidor);
    public void updateCoche(CocheDTO coche, String numeroBastidor);
    //public void crearBaseDatos() throws SQLException;
}