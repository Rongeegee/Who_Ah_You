package whoahyou;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {
	Connection conn;
	String ProfileID;
	String OwnerSSN;
	int DatingRangeStart;
	int DatingRangeEnd;
	int DatinGeoRange;
	int Age;
	String gender;
	String Hobbies;
	int height;
	int weight;
	String haircolor;
	Date creationDate;
	Date lastModDate;
	ArrayList<Profile> possibleMatches = new ArrayList<Profile>();
	public Profile() {
		
	}
	
	protected void getMatches() throws ServletException, IOException, SQLException{
			DBConnectionManager DBcon = new DBConnectionManager();
			String sql = "select * from profile where Age >= ? or Age <= ?";
			PreparedStatement st = DBcon.conn.prepareStatement(sql);
			st.setString(1, Integer.toString(this.DatingRangeStart));
			st.setString(2, Integer.toString(this.DatingRangeEnd));
			ResultSet result = st.executeQuery();
			if(result.next()) {
				// pulling up corresponding profiles based on the user.
				sql = "select * from profile where Age >= ? or Age <= ?";
				PreparedStatement st1 = DBcon.conn.prepareStatement(sql);
				st.setString(1, Integer.toString(this.DatingRangeStart));
				st.setString(2, Integer.toString(this.DatingRangeEnd));
				ResultSet pR = st1.executeQuery();
			while(pR.next()) {
				Profile newProfile = new Profile();
				newProfile.ProfileID = pR.getString("ProfileID");
				newProfile.OwnerSSN = pR.getString("OwnerSSN");
				newProfile.DatingRangeStart = Integer.parseInt(pR.getString("DatingAgeRangeStart"));
				newProfile.DatingRangeEnd = Integer.parseInt(pR.getString("DatingAgeRangeEnd"));
				newProfile.DatinGeoRange = Integer.parseInt(pR.getString("DatinGeoRange"));
				newProfile.Age = Integer.parseInt(pR.getString("Age"));
				newProfile.ProfileID = pR.getString("M_F");
				newProfile.ProfileID = pR.getString("Hobbies");
				newProfile.height = Integer.parseInt(pR.getString("Height"));
				newProfile.weight = Integer.parseInt(pR.getString("Weight"));
				newProfile.ProfileID = pR.getString("HairColor");
				newProfile.ProfileID = pR.getString("CreationDate");
				newProfile.ProfileID = pR.getString("LastModDate");
			}
			System.out.println(this.possibleMatches);
		}
			
	}
}

