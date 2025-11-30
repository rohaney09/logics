package logics.jdbc;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class user {

    private static final String url = "jdbc:mysql://localhost:3306/user_db";
    private static final String username = "root";
    private static final String password = "Rohan@123";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

//            //Retrive Data:---------------------------------------------------------------------------------------------
//            String query1 = "SELECT * FROM STUDENTS";
//            ResultSet resultSet = statement.executeQuery(query1);
//
//            while(resultSet.next())
//            {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                Double marks = resultSet.getDouble("marks");
//
//                System.out.println("ID: "+id);
//                System.out.println("Name: "+name);
//                System.out.println("Age: "+age);
//                System.out.println("Marks: "+marks);
//            }

            //Insert Data:----------------------------------------------------------------------------------------------
            String query2 = "INSERT INTO students(id,name, age, marks) VALUES(1,'Reena',23,74.5)";
            int rowAffected1 = statement.executeUpdate(query2);
            if(rowAffected1>0){
                System.out.println("Row Inserted Sucessfully");
            }
            else{
                System.out.println("Row not inserted");
            }


            //Update Data:----------------------------------------------------------------------------------------------
            String query3 = "UPDATE students SET marks = 88.8 where id = 3";
            int rowAffected2 = statement.executeUpdate(query3);
            if(rowAffected2>0){
                System.out.println("Row Updated Sucessfully");
            }
            else{
                System.out.println("Row not Updated");
            }


            //Delete Data:----------------------------------------------------------------------------------------------
            String query4 = "DELETE FROM students WHERE id = 8";
            int rowAffected3 = statement.executeUpdate(query4);
            if(rowAffected3>0){
                System.out.println("Row Deleted Sucessfully");
            }
            else{
                System.out.println("Row Not Deleted");
            }


            //Insert Data using PreparedStatement:---------------------------------------------------------------------------
            String query5 = "INSERT INTO students(name, age, marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query5);

            preparedStatement.setString(1,"Ankita");
            preparedStatement.setInt(2,28);
            preparedStatement.setDouble(3,97.2);

            preparedStatement.setString(1,"Priya");
            preparedStatement.setInt(2,18);
            preparedStatement.setDouble(3,74.8);

            int rowAffected4 = preparedStatement.executeUpdate();
            if(rowAffected4>0){
                System.out.println("Row Inserted Sucessfully");
            }
            else{
                System.out.println("Row not inserted");
            }


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}