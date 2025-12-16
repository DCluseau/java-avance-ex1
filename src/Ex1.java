import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex1 {

	public Ex1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Article> tabArt = new ArrayList<Article>();
			// Connexion à la BDD
			String url = "jdbc:mariadb://localhost:3306/shop";
			String login = "root";
			String pwd = "fms2025";
			
			Connection  connection = DriverManager.getConnection(url, login, pwd);
			
			// Création du statement
			Statement stmt = connection.createStatement();
			// Exécution de la requête SELECT
			ResultSet result = stmt.executeQuery("SELECT * FROM T_Articles");
			// Récupération et affichage des résultats
			while(result.next()) {
				Article art = new Article(result.getInt("IdArticle"), result.getString("Description"),result.getString("Brand"), result.getFloat("UnitaryPrice"));
				tabArt.add(art);
				
			}
			// Fermeture du statement
			stmt.close();
			
			for(Article art : tabArt) {
				System.out.println(art);
			}
			
			// Requête INSERT avec prepared statement
			Article newArt = new Article();
			newArt.setDescription("Epée");
			newArt.setBrand("Durandil");
			newArt.setUnitPrice(2000);
			String sql = "INSERT INTO T_Articles (IdArticle, Description, Brand, UnitaryPrice) VALUES (NULL, ?, ?, ?);";
			try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				ps.setString(1, newArt.getDescription());
				ps.setString(2, newArt.getBrand());
				ps.setDouble(3, newArt.getUnitPrice());
				if(ps.executeUpdate() == 1) {
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next()) {
						newArt.setId(rs.getInt("IdArticle"));
					}
					System.out.println(newArt);
				}
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Requête UPDATE
			sql = "UPDATE T_Articles SET description = ? WHERE IdArticle = ?";
			newArt.setDescription("Casque");
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, newArt.getDescription());
				ps.setInt(2, newArt.getId());
				if(ps.executeUpdate() == 1) {
					System.out.println("Update ok");
				}
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Requête DELETE
			sql = "DELETE FROM T_Articles WHERE IdArticle = ?";
			newArt.setDescription("Casque");
			try(PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setInt(1, newArt.getId());
				if(ps.executeUpdate() == 1) {
					System.out.println("Delete ok");
				}
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Fermeture de la connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
