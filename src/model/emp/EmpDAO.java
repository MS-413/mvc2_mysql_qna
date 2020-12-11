package model.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;

public class EmpDAO {
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	public EmpDAO() throws SQLException {
		cn = DBManager.getConn();
	}
	
	public int insert(EmpVO evo) {
		int empno = evo.getEmpno();
		String ename = evo.getEname();
		String job = evo.getJob();
		String hiredate = evo.getHiredate();
		int sal = evo.getSal();
		System.out.println(empno+" / "+ename+" / "+job+" / "+hiredate+" / "+sal);
		String sql = "insert into emp(empno, ename, job, hiredate, sal) values(?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			pst.setString(2, ename);
			pst.setString(3, job);
			pst.setString(4, hiredate);
			pst.setInt(5, sal);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("저장도중 에러 발생");
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		
		return 0;
	}
	
	public ArrayList<EmpVO> selectList(){
		ArrayList<EmpVO> aevo = new ArrayList<EmpVO>();
		String sql = "Select * from emp";
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				String hiredate = rs.getString(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				EmpVO evo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				aevo.add(evo);
			}
			return aevo;
		} catch (SQLException e) {
			System.out.println("사원 리스트 부르는중 에러 발생");
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return null;
	}
	public EmpVO selectOne(int empno) {
		String sql = "Select * from emp where empno = ?";
		EmpVO evo = new EmpVO();
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			rs = pst.executeQuery();
			while(rs.next()) {
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setJob(rs.getString("job"));
				evo.setMgr(rs.getInt("mgr"));
				evo.setHiredate(rs.getString("hiredate"));
				evo.setSal(rs.getInt("sal"));
				evo.setComm(rs.getInt("comm"));
				evo.setDeptno(rs.getInt("deptno"));
			}
			return evo;
		} catch (SQLException e) {
			System.out.println("Detail 부르는 도중 에러 발생 ");
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
		}
		return null;
	}

	public int update(EmpVO evo) {
		String sql = "update emp set ename = ?, "
				+ "job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? "
				+ "where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, evo.getEname());
			pst.setString(2, evo.getJob());
			pst.setInt(3, evo.getMgr());
			pst.setString(4, evo.getHiredate());
			pst.setInt(5, evo.getSal());
			pst.setInt(6, evo.getComm());
			pst.setInt(7, evo.getDeptno());
			pst.setInt(8, evo.getEmpno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
			System.out.println("파이널리 실행 !!!");
		}
		return 0;
	}

	public int delete(int empno) {
		String sql = "delete from emp where empno = ? ";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {try {rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pst!=null) {try {pst.close();}catch(SQLException e){e.printStackTrace();}}
			if(cn!=null) {try {cn.close();}catch(SQLException e){e.printStackTrace();}}
			System.out.println("파이널리 실행 !!!");
		}
		return 0;
	}
}
