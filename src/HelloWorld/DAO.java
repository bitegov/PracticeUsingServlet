package HelloWorld;


import com.mysql.jdbc.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Boo on 2016-11-11.
 */
public class DAO {
    public String[] jay() throws ClassNotFoundException {
        Connection conn = null; // null로 초기화 한다.
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        String [] returnArray = new String[3];

        try {
            String url = "jdbc:mysql://localhost:3306/e-gov?characterEncoding=UTF-8&useSSL=false"; // 사용하려는 데이터베이스명을 포함한 URL 기술
            String userid = "root"; // 사용자 계정
            String userpw = "q1w2e3r4"; // 사용자 계정의 패스워드

            Class.forName("com.mysql.jdbc.Driver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
            conn = (Connection) DriverManager.getConnection(url, userid, userpw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
            System.out.println("##########1111############");

            String sql = "SELECT * from calender;"; // sql 쿼리
            ps1 = (PreparedStatement) conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
            //ps1tmt.setString(1,"1");
            System.out.println("##########22222############");
            rs = ps1.executeQuery(); // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
            System.out.println("##########333############");
            while(rs.next()) {
                String id = rs.getString(1);
                String title = rs.getString(2);
                String urlName = rs.getString(3);
                System.out.println(id+title+urlName);
                returnArray[0] = id;
                returnArray[1] = title;
                returnArray[2] = urlName;
            }


        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }

        return returnArray;

    }
}
