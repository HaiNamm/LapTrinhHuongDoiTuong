package projectStudentManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import projectStudentManage.Students;
//import projectStudentManage.StudentsModify;

public class StudentsModify {
	public static List<Students> findAll() {
        List<Students> studentList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //select * from
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lophoc", "root", "");
            
            //query
            String sql = "select * from studentmanage";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Students std = new Students(
                		resultSet.getInt("stt"),
                        resultSet.getString("IDLop"), 
                        resultSet.getString("TenLop"),  
                        resultSet.getString("KhoaHoc"));
                		
                
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //end.
        
        return studentList;
    }
	
	public static void insert(Students std) {
		Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //select * from
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lophoc", "root", "");
            
            //query
            String sql = "insert into studentmanage(IDLop, TenLop, KhoaHoc) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getIDLop());
            statement.setString(2, std.getTenLop());
            statement.setString(3, std.getKhoaHoc());
    ;
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
	} 
	
	public static void update(Students std) {
		Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //select * from
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lophoc", "root", "");
            
            //query
            String sql = "update studentmanage set IDLop=?, TenLop=?, KhoaHoc=? where stt=?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getIDLop());
            statement.setString(2, std.getTenLop());
            statement.setString(3, std.getKhoaHoc());
      

            statement.setInt(12, std.getStt());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        }
        
       
	public static void delete(int stt) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        // establish database connection
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lophoc", "root", "");

	        // create the SQL query with a placeholder for the STT parameter
	        String sql = "DELETE FROM studentmanage WHERE stt = ?";
	        statement = connection.prepareStatement(sql);

	        // set the value of the STT parameter to the provided argument
	        statement.setInt(1, stt);

	        // execute the query
	        statement.executeUpdate();

	    } catch (SQLException ex) {
	        Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	        // close the statement and connection, if they were successfully opened
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	}

    public static List<Students> findIDLop(String IDLop) {
         List<Students> studentList = new ArrayList<>();
         
         Connection connection = null;
         PreparedStatement statement = null;
         
         try {
             //select * from
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lophoc", "root", "");
             
             //query
             String sql = "SELECT * FROM studentmanage WHERE mssv LIKE ?";
             statement = connection.prepareStatement(sql);
             statement.setString(1, "%" + IDLop + "%");

             ResultSet resultSet = statement.executeQuery();
             
             while (resultSet.next()) {                
                 Students std = new Students( 
                		 resultSet.getInt("stt"),
                		 resultSet.getString("IDLop"), 
                         resultSet.getString("TenLop"),  
                         resultSet.getString("KhoaHoc"));
                 studentList.add(std);
             }
         } catch (SQLException ex) {
             Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if(statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(StudentsModify.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         //end.
         
         return studentList;
     }
	
}
