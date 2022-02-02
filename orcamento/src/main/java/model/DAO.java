package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	//módulo de conexão
	 private String driver = "com.mysql.cj.jdbc.Driver";
	 
 	/** The url. */
 	private String url = "jdbc:mysql://127.0.0.1:3306/dborca?useTimezone=true&serverTimezone=UTC";
	 
 	/** The user. */
 	private String user = "root";
	 
 	/** The password. */
 	private String password = "root";
	
	 /**
 	 * Conectar.
 	 *
 	 * @return the connection
 	 */
 	//método de conexão
	 private Connection conectar() {
		 Connection con = null;
		 try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	 }
	 //testando a conexão
	 /*public void testeConexao() {
		 try {
			 Connection con = conectar();
			 System.out.println(con);
			 con.close();		
		} catch (Exception e) {
			System.out.println(e);
		}
	 }*/
	 
	 /**
 	 * Insere orca.
 	 *
 	 * @param orcamento the orcamento
 	 */
 	/*CRUD create */
	 public void insereOrca(JavaBeans orcamento) {
		 String create = "insert into coleta (disjprot) values (?)";
		 
		 try {
			
			 Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(create);
			 pst.setString(1, orcamento.getDisjprot());
			 
			 pst.executeUpdate();
			 con.close();
			 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
	 /**
 	 * Listar orca.
 	 *
 	 * @return the array list
 	 */
 	/*CRUD read */
	 public ArrayList<JavaBeans> listarOrca(){

		 //Criando um objeto que irá acessar a classe JavaBeans
		  ArrayList<JavaBeans> orca = new ArrayList<>();
		  
		 String read = "select * from coleta";
		 try {
			 Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(read);
			 ResultSet rs = pst.executeQuery();			 
			 
			 //laço de repetição para exibiir os orçamentos
			 while (rs.next()) {
				//variaveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String disjprot = rs.getString(2);
				
				//populando o ArrayList
				orca.add(new JavaBeans(id, disjprot));
			}			 
			 con.close();
			 return orca; 
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}		 
	 }
	 
	 /**
 	 * Seleciona orca.
 	 *
 	 * @param orcamento the orcamento
 	 */
 	/*CRUD Selecionar*/
	 public void selecionaOrca(JavaBeans orcamento) {
		 String sele = "select * from coleta where id = ?";
		 
		 try {
			
			 Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(sele);
			 pst.setString(1, orcamento.getId());
			 ResultSet rs = pst.executeQuery();
			 
			 //laço de repetição para exibiir os orçamentos
			 while (rs.next()) {
				 //Setando as variáveis JavaBeans
				 orcamento.setId(rs.getString(1));
				 orcamento.setDisjprot(rs.getString(2));
			 }
			 con.close();			 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
	 /**
 	 * Alterar orca.
 	 *
 	 * @param orcamento the orcamento
 	 */
 	/*CRUD update */
	 public void alterarOrca(JavaBeans orcamento) {
		 String update = "update coleta set disjprot = ? where id = ?";
		 
		 try {			 
			 Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(update);
			 pst.setString(1, orcamento.getDisjprot());
			 pst.setString(2, orcamento.getId());
			 pst.executeUpdate();
			 con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	 }
	 
	 /**
 	 * Deletar orca.
 	 *
 	 * @param orcamento the orcamento
 	 */
 	/*CRUD delete */
	 public void deletarOrca(JavaBeans orcamento) {
		 String delete = "delete from coleta where id = ?";
		 
		 try {			 
			 Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(delete);
			 pst.setString(1, orcamento.getId());
			 pst.executeUpdate();
			 con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	 }
	 
}
