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
	String Height;
	int Weight;
	String HairColor;
	Date CreationDate;
	Date LastModDate;
	String picPath;
	ArrayList<Profile> possibleMatches = new ArrayList<Profile>();
	ArrayList<like> likers = new ArrayList<like>(); // key = email
	
	public Profile() {
		
	}
	public String getPicPath() {
		return this.picPath;
	}
	public String getProfileID() {
		return this.ProfileID;
	}
	public int getAge() {
		return Age;
	}
	public String getGender() {
		return Gender;
	}
	public String getHeight() {
		return Height;
	}
	public String getHobbies() {
		return Hobbies;
	}
	public int getWeight() {
		return Weight;
	}
	public String getColor() {
		return HairColor;
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
				Profile matchProfile = new Profile();
				matchProfile.ProfileID = pR.getString("ProfileID");
				matchProfile.OwnerSSN = pR.getString("OwnerSSN");
				matchProfile.DatingRangeStart = Integer.parseInt(pR.getString("DatingAgeRangeStart"));
				matchProfile.DatingRangeEnd = Integer.parseInt(pR.getString("DatingAgeRangeEnd"));
				matchProfile.DatinGeoRange = Integer.parseInt(pR.getString("DatinGeoRange"));
				matchProfile.Age = Integer.parseInt(pR.getString("Age"));
				matchProfile.Gender = pR.getString("M_F");
				matchProfile.Hobbies = pR.getString("Hobbies");
				matchProfile.Height =pR.getString("Height");
				matchProfile.Weight = Integer.parseInt(pR.getString("Weight"));
				matchProfile.HairColor = pR.getString("HairColor");
				matchProfile.LastModDate = pR.getDate("LastModDate");
			}
			System.out.println(this.possibleMatches);
		}
			
	}
}

