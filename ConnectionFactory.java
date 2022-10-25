\\A seguinte classe foi criada para realizar controle de conexão com banco de dados MySQL, é usada em um projeto que estou desenvolvendo.
\\Repare que também utilizo statement para preparo de scripts que serão usados no banco e também resultSet, que basicamente carrega os resultados de pesquisa e armazena dataTables.
\\Qualquer erro, dúvida ou sugestão, fique a vontade!

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	
	  //O seguinte atributo, é criado uma instância que fará a conexão entre minha aplicação e o banco de dados;
    //É citado o driver de qual banco será utilizado;
    //A titulação "public static final" induz que minha instância é imutável entre as classes do meu projeto e que pode ser acessada por outros locais.
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    //No seguinte atributo, é citado qual banco será usado, sobre qual servidor, porta e qual database/banco de dados;
    //De uma forma mais simples: o caminho do meu banco de dados. Se meu banco estivesse em um server, seria colocado o endereço IP.
    public static final String URL = "jdbc:mysql://localhost:3306/DoItApp";
    
    //Nos próximos atributos, é citado qual usuário e senha devo utilizar para me conectar ao banco.
    public static final String USER = "root";
    public static final String PASS = "";
    
    //O seguinte método, me retornará uma conexão, por isso "public static Connection";
    //O static diz que posso chamar esse método, sem precisar criar uma instância/objeto da minha classe;
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados");
        }
    }
    
    public static void closeConnection (Connection connection){
        try {
            if (connection != null) { //Aqui é feito uma validação se existe de fato uma conexão, caso exista, connection.close abaixo.
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão");
        }
            
    }
    
    public static void closeConnection (Connection connection, PreparedStatement statement){
        try {
            if (connection != null) { //Novamente é feito uma validação se existe de fato uma conexão, caso exista, connection.close abaixo.
                connection.close();
            }
            if (statement != null) { //Incrementado o statement também, pois quando tiver um parametro "statement" ele fecha junto com a connection e não preciso fechar lá nos métodos
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão e statement");
        } 
    }
    
    public static void closeConnection (Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null) { //Aqui é feito uma validação se existe de fato uma conexão, caso exista, connection.close abaixo.
                connection.close();
            }
            if (statement != null) { //Incrementado o statement também, pois quando tiver um parametro "statement" ele fecha junto com a connection e não preciso fechar lá nos métodos
                statement.close();
            }
            if (resultSet != null) { //Incrementado o resultSet também, pois quando tiver um parametro "resultSet" ele fecha junto com a connection e o statement e não preciso fechar lá nos métodos
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão, statement e resultSet");
        }            
    }
}
