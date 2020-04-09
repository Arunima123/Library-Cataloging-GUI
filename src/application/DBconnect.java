package application;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBconnect {

	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521/ARUNIMA";
	private static final String DATABASE_USERNAME = "hr";
	private static final String DATABASE_PASSWORD = "**";

	private static final String SELECT_QUERY = "SELECT count(*) as count FROM admin WHERE admin_name = ? and admin_password = ?";
	private static final String SELECT_QUERY1 = "SELECT * FROM admin WHERE admin_name = ? and admin_password = ?";
	private static final String SELECT_QUERY2 = "SELECT count(*) as count FROM userr where user_id=?";
	private static final String SELECT_QUERY3 = "SELECT count(*) as count FROM staff WHERE staff_name = ? and staff_id = ?";
	private static final String SELECT_QUERY4 = "SELECT staff_mobile from staff_mobile where staff_id=?";
	private static final String SELECT_QUERY5 = "SELECT * from staff where staff_name =? and staff_id=? ";
	private static final String SELECT_QUERY6 = "SELECT count(*) as count FROM userr WHERE user_name = ? and user_id = ?";
	private static final String SELECT_QUERY7 = "SELECT user_mobile from user_mobile where user_id=?";
	private static final String SELECT_QUERY8 = "SELECT * from userr where user_name =? and user_id=? ";
	//private static final String SELECT_QUERY9 = "SELECT * from articles where artcle_id =?,article_title=?,article_pages=? and article_year=? ";
	//private static final String SELECT_QUERY10 = "SELECT count(*) as count FROM articles WHERE article_id =? and article_title=? and article_pages=? and article_year=?";



	public boolean validate(String name, String password) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(password));

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String count = resultSet.getString("count");

				if (Integer.parseInt(count) == 1) {
					return true;
				}
			}

			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	public void fill_admin_detail(String name, String password) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY1)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(password));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String id = resultSet.getString("admin_id");
				String name2 = resultSet.getString("admin_name");
				String password2 = resultSet.getString("admin_password");

				Constants.ID = id;
				Constants.name1 = name2;
				Constants.password = password2;

			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public boolean validateFB(String id) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY2)) {
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String count = resultSet.getString("count");
				if (Integer.parseInt(count) == 1) {

					Constants.IDfb = id;
			
					return true;
				}
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}

	public void FBinDB(String text,String title) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement stmt = connection
						.prepareStatement("update feedback set feedback_description=?, feedback_title=? where user_id=?")) {
			
			stmt.setString(1, text);
			stmt.setString(2, title);
			stmt.setString(3, Constants.IDfb);
		   
			stmt.executeUpdate();

			connection.commit();
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public boolean validateStaff(String name, String id) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY3)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String count = resultSet.getString("count");
				if (Integer.parseInt(count) == 1) {
					return true;
				}
			}

			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public void fill_staff_detail(String name, String id) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY5)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String id2 = resultSet.getString("staff_id");
				String name2 = resultSet.getString("staff_name");
				String email = resultSet.getString("staff_email");
				String designation = resultSet.getString("staff_designation");
				String address = resultSet.getString("staff_addresss");

				Constants.ID = id2;
				Constants.name1 = name2;
				Constants.email1 = email;
				Constants.desig = designation;
				Constants.add = address;
				Constants.mob = "'------' ";
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public void fill_staff_detail2(String id) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY4)) {
			preparedStatement.setInt(1, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String mobile = resultSet.getString("staff_mobile");

				Constants.mob = mobile;
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public boolean validateUser(String name, String id) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY6)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String count = resultSet.getString("count");
				if (Integer.parseInt(count) == 1) {
					return true;
				}
			}

			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}


	public void fill_User_detail(String name, String id) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY8)) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String id2 = resultSet.getString("user_id");
				String name2 = resultSet.getString("user_name");
				String email = resultSet.getString("user_email");
				String address = resultSet.getString("user_addresss");

				Constants.ID = id2;
				Constants.name1 = name2;
				Constants.email1 = email;
				Constants.add = address;
				Constants.mob = "-------";
				
				//System.out.println(Constants.name1);
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public void fill_User_detail2(String id) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY7)) {
			preparedStatement.setInt(1, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String mobile = resultSet.getString("user_mobile");

				Constants.mob = mobile;
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public void UserInDB(String name,String id,String email,String address) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement stmt = connection
						.prepareStatement("insert into userr values(?,?,?,?)")) {
			
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, address);
		   
			stmt.executeUpdate();

			connection.commit();
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public void UserInDB2(String id,String mobile) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

				PreparedStatement stmt = connection
						.prepareStatement("insert into user_mobile values(?,?)")) {
			
			stmt.setString(1, id);
			stmt.setString(2, mobile);

			stmt.executeUpdate();

			connection.commit();
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}

	}
	
	public boolean validateArticle(String title,String id,String pages,String year,int a1,int a2,int a3,int a4) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text)) {

			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,title);
			if(a3!=0)
				preparedStatement.setString(a3,pages);
			if(a4!=0)
				preparedStatement.setString(a4,year);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				
				String count = resultSet.getString("count");
				
				
				
				if (Integer.parseInt(count) >= 1) {
					return true;
				}
				
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public String[][] showArticles(String title,String id,String pages,String year,int a1,int a2,int a3,int a4) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text2)) {
			
			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,title);
			if(a3!=0)
				preparedStatement.setString(a3,pages);
			if(a4!=0)
				preparedStatement.setString(a4,year);
			

		   
			
			ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 	List<String> resultEntity = new ArrayList<String>();
				 	resultEntity.add(resultSet.getString("article_id"));
				 	resultEntity.add(resultSet.getString("article_title"));
				 	resultEntity.add(resultSet.getString("article_pages"));
				 	resultEntity.add(resultSet.getString("article_year"));
				 	result.add(resultEntity);
			}
		
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		if(result.size()==0)
			return new String[][] {{"Empty"}};
		int row = result.size();
		int col = result.get(0).size();
		String[][] resultArray = new String[result.size()][result.get(0).size()];
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				resultArray[i][j] = result.get(i).get(j);
		return resultArray;
	}
	
	
	public boolean validateAuthor(String name,String id,String email,String dept,String add,String inst,int a1,int a2,int a3,int a4,int a5,int a6) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text)) {

			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,name);
			if(a3!=0)
				preparedStatement.setString(a3,email);
			if(a4!=0)
				preparedStatement.setString(a4,dept);
			if(a5!=0)
				preparedStatement.setString(a5,add);
			if(a6!=0)
				preparedStatement.setString(a6,inst);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				
				String count = resultSet.getString("count");
				
				
				
				if (Integer.parseInt(count) >= 1) {
					return true;
				}
				
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public String[][] showArticlesAuthor(String name,String id,String email,String dept,String add,String inst,int a1,int a2,int a3,int a4,int a5,int a6) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text2)) {
			
			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,name);
			if(a3!=0)
				preparedStatement.setString(a3,email);
			if(a4!=0)
				preparedStatement.setString(a4,dept);
			if(a5!=0)
				preparedStatement.setString(a5,add);
			if(a6!=0)
				preparedStatement.setString(a6,inst);
			
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 	List<String> resultEntity = new ArrayList<String>();
				 	resultEntity.add(resultSet.getString("article_id"));
				 	resultEntity.add(resultSet.getString("article_title"));
				 	resultEntity.add(resultSet.getString("article_pages"));
				 	resultEntity.add(resultSet.getString("article_year"));
				 	result.add(resultEntity);
			}
		
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		if(result.size()==0)
			return new String[][] {{"Empty"}};
		int row = result.size();
		int col = result.get(0).size();
		String[][] resultArray = new String[result.size()][result.get(0).size()];
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				resultArray[i][j] = result.get(i).get(j);
		return resultArray;
	}
	
	
	public boolean validateJournal(String title,String id,String pages,String year,String pub,int a1,int a2,int a3,int a4,int a5) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text)) {

			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,title);
			if(a3!=0)
				preparedStatement.setString(a3,pages);
			if(a4!=0)
				preparedStatement.setString(a4,year);
			if(a5!=0)
				preparedStatement.setString(a5,pub);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				
				String count = resultSet.getString("count");
				
				
				
				if (Integer.parseInt(count) >= 1) {
					return true;
				}
				
			}
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public String[][] showArticlesJournal(String title,String id,String pages,String year,String pub,int a1,int a2,int a3,int a4,int a5) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			PreparedStatement preparedStatement = connection.prepareStatement(Constants.text2)) {
			
			if(a1!=0)
				preparedStatement.setInt(a1, Integer.parseInt(id));
			if(a2!=0)
				preparedStatement.setString(a2,title);
			if(a3!=0)
				preparedStatement.setString(a3,pages);
			if(a4!=0)
				preparedStatement.setString(a4,year);
			if(a5!=0)
				preparedStatement.setString(a5,pub);

		     ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 	List<String> resultEntity = new ArrayList<String>();
				 	resultEntity.add(resultSet.getString("article_id"));
				 	resultEntity.add(resultSet.getString("article_title"));
				 	resultEntity.add(resultSet.getString("article_pages"));
				 	resultEntity.add(resultSet.getString("article_year"));
				 	result.add(resultEntity);
			}
		
			connection.close();

		} catch (SQLException e) {
			printSQLException(e);
		}
		if(result.size()==0)
			return new String[][] {{"Empty"}};
		int row = result.size();
		int col = result.get(0).size();
		String[][] resultArray = new String[result.size()][result.get(0).size()];
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				resultArray[i][j] = result.get(i).get(j);
		return resultArray;
	}
	
	
	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}