
package conexaobanco.controler;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControler {
    
    public boolean inserir() throws SQLException{
       
        String sql = "INSERT INTO cliente(nome,codigo) VALUES ('Zolet',7)";
        PreparedStatement ps;
        try{
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.execute();
                return true;
        }catch (SQLException | ClassNotFoundException ex){
                Logger.getLogger(ClienteControler.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    
         public static void main(String[] args) throws SQLException {
        ClienteControler  p = new ClienteControler ();
            p.inserir();
             System.out.println(""+p);
         }

}
