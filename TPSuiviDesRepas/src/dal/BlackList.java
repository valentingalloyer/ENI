package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlackList {
	private String SELECT_ALL_FROM_TYPE = "  USE BRASSERIE_DB SELECT * FROM BlackList WHERE typeBlackList = ? ";

	public List<String> getBlackListTypeof(String type) throws DALException {
		List<String> blackList = new ArrayList<String>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL_FROM_TYPE);
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String value = rs.getString("valueBlackList");

				blackList.add(value.trim());

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème lors de la récupération de la liste noire de "+ type);
		}
		return blackList;
	}
}
