import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1 {

	public Ex1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Connexion à la BDD
			String url = "jdbc:mariadb://localhost:3306/shop";
			String login = "root";
			String pwd = "fms2025";
			
			Connection  connection = DriverManager.getConnection(url, login, pwd);
			
			// Création du statement
			Statement stmt = connection.createStatement();
			// Exécution de la requête
			ResultSet result = stmt.executeQuery("SELECT * FROM T_Articles");
			// Récupération et affichage des résultats
			while(result.next()) {
				Article art = new Article(result.getInt("IdArticle"), result.getString("Description"),result.getString("Brand"), result.getFloat("UnitaryPrice"));
				System.out.println(art);
			}
			// Fermeture du statement
			stmt.close();
			// Fermeture de la connection
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
