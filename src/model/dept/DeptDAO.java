package model.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;

public class DeptDAO {
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	public DeptDAO() throws SQLException {
		cn = DBManager.getConn();
	}
	
	public int insert(DeptVO dvo) {
		String sql = "insert into dept values(?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dvo.getDeptno());
			pst.setString(2, dvo.getDname());
			pst.setString(3, dvo.getLoc());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("부서 정보 입력 오류 ");
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		return 0;
	}
	
	public ArrayList<DeptVO> selectList(){
		String sql = "Select * from dept";
		ArrayList<DeptVO> deptList = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				DeptVO dvo = new DeptVO(
						rs.getInt("deptno"),rs.getString("dname"),
						rs.getString("loc")
						);
				deptList.add(dvo);
			}
			return deptList;
		} catch (SQLException e) {
			System.out.println("부서목록 SQL 에러 ");
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		return null;
	}
	
	public int update(DeptVO dvo) {
		System.out.println("DNAME :: " + dvo.getDname());
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dvo.getDname());
			pst.setString(2, dvo.getLoc());
			pst.setInt(3, dvo.getDeptno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error Occurred when update Dept");
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		return 0;
	}
	
	public int delete(int deptno) {
		String sql = "delete from dept where  deptno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, deptno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
			
		}
		return 0;
	}

	public DeptVO selectOne(int deptno) {
		String sql = "Select * from dept where deptno = ?";
		DeptVO dvo= new DeptVO();
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, deptno);
			rs = pst.executeQuery();
			while(rs.next()) {
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("Loc"));
			}
			System.out.println("DBCONNECT :: dname is - "+dvo.getDname());
			return dvo;
		} catch (SQLException e) {
			System.out.println("Detail 부르는 도중 에러 발생 ");
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
				
		return null;
	}

	public ArrayList<Integer> getDeptnoList() {
		String sql = "select deptno from dept";
		ArrayList<Integer> adno = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				adno.add(rs.getInt("deptno"));
			}
			return adno;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		return null;
	}
}
