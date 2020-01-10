package src;

//import java.awt.*;
//import java.sql.*;
//import javax.swing.*;
//import javax.swing.table.*;

public class HighScore /*extends JFrame*/ {

//    private int highScore = 0;
//    private HUD currentScore;
//
//    private String DB_URL = "jdbc:derby://localhost:1527/DODGE_HIGH_SCORE;create=true;user=root;password=user123";
//
//    private DefaultTableModel model = new DefaultTableModel();
//    private Container cnt = this.getContentPane();
//    private JTable jtbl = new JTable(model);
//
//    public void getHighScore() {
//
//        if (currentScore.getScore() > highScore) {
//            highScore = currentScore.getScore();
//            try {
//                //highscoreDB
//                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//                System.out.println("DRIVER CONNECTED");
//
//                Connection conn = DriverManager.getConnection(DB_URL);
//                Statement stmt = conn.createStatement();
//
//                String sqlStatement = "INSERT VALUES(highScore) INTO HIGHSCOREDB score";
//                ResultSet Rs = stmt.executeQuery(sqlStatement);
//
//                System.out.println("HIGH SCORE:");
//                System.out.println("------------------------");
//                while (Rs.next()) {
//                    System.out.println(Rs.getString(1));
//                    model.addRow(new Object[]{Rs.getString(1), Rs.getDouble(2)});
//                }
//            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
//                System.out.println("ERROR: " + ex.getMessage());
//            }
//        }
//    }

}
