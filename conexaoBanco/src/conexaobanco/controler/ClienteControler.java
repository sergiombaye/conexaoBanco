
package conexaobanco.controler;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteControler {
    
    public boolean inserir(int codigo , String nome ) {
       
        String sql = "INSERT INTO cliente(codigo,nome) VALUES (?,?)";
        PreparedStatement ps;//esta preparando o comando 
        try{
                ps = Conexao.getConexao().prepareStatement(sql);//esta preparando para excutar o SQL pra nos da false 
                ps.setInt(1, codigo);
                ps.setString(2, nome);
                ps.execute();//excute o comado SQL
                return true;
        }catch (SQLException | ClassNotFoundException ex){
                Logger.getLogger(ClienteControler.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    
         public static void main(String[] args) {
        ClienteControler  p = new ClienteControler ();
        Scanner l = new Scanner(System.in);
             for (int i = 0; i < 3; i++) {
             String f = JOptionPane.showInputDialog("DIGITE O NOME");
            int n =l.nextInt() ;
            p.inserir(n, f);
           }
            
         }

}
