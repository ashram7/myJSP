package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con;
	//private Statement stmt;
	private PreparedStatement pstmt;
	
	public List listMembers() {
		List list = new ArrayList();
		try {
			connDB();
			String query = "select * from t_member ";
			//System.out.println(query);
			System.out.println("prepareStatememt: " + query);
			// SQL 문으로 회원 정보를 조회 while 문을 돌리기 위해서...
			//ResultSet rs = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();			
			while (rs.next()) {
				// 조회한 레코드의 각 컬럼 값을 받아 온다
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				// 설정된 MemberVO 객체를 다시 ArrayList에 저장
				list.add(vo);				
			}
			rs.close();
			pstmt.close();
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 조회한 레코드의 개수만큼 MemberVO 객체를 저장한 ArrayList에 반환
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			//stmt = con.createStatement();
			//System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}


















