import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FermeDeLEst {

	public static void main(String[] args) 
	{

		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fermedelest", "postgres", "informatique");
			
			Statement requeteListeMoutons = connection.createStatement();
			ResultSet curseurMouton = requeteListeMoutons.executeQuery("SELECT * FROM mouton");
			
			System.out.println("avant");
			while(curseurMouton.next())
			{
				String nom = curseurMouton.getString("nom");
				String description = curseurMouton.getString("description");
				System.out.println("Mouton : " + nom + " " + description);
			}
			
			System.out.println("apres");
			
			connection.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
