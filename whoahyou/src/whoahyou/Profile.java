package whoahyou;
import java.util.ArrayList;

import javax.servlet.ServletException;

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
	String Gender;
	String Hobbies;
	int Height;
	int Weight;
	String HairColor;
	Date CreationDate;
	Date LastModDate;
	String picPath;
	ArrayList<Profile> possibleMatches = new ArrayList<Profile>();
	public Profile() {
		
	}
	public String getPicPath() {
		return this.picPath;
	}
	public String getProfileID() {
		return this.ProfileID;
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
				newProfile.Gender = pR.getString("M_F");
				newProfile.Hobbies = pR.getString("Hobbies");
				newProfile.Height = Integer.parseInt(pR.getString("Height"));
				newProfile.Weight = Integer.parseInt(pR.getString("Weight"));
				newProfile.HairColor = pR.getString("HairColor");
				newProfile.CreationDate = pR.getDate("CreationDate");
				newProfile.LastModDate = pR.getDate("LastModDate");
			}
			System.out.println(this.possibleMatches);
		}
			
	}
}

