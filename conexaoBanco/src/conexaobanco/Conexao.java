/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexao {
    
    private static Connection conn;
    private final static String driver = "org.postgresql.Driver";// sempre assim para posteger  se for outro banco tem qui trocar
    private final static String ip = "localhost/";//endreço  de nossa banco dados 
    public static String dataBase = "base_dados_aula";//nome de nossa banco de dados 
    public static String user = "postgres";//usario do banco dados 
    public static String password = "postgres";//senha para o usario

    public Conexao(Connection conn) {
        this.conn = conn;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {//se existe conexao return ele mesmo em vez de criar outro nova
            return conn;
        }

        Class.forName(driver);//se nao existe cria e returne a conexao
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password);// e padronizado nao mexer (e definicao de posteger conexao)
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
