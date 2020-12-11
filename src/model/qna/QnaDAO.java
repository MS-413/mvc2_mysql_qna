package model.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;

public class QnaDAO {
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	public QnaDAO() throws SQLException {
		cn = DBManager.getConn();
	}
	public int insert(QnaVO qvo) {
		String sql = "insert into qna(writer, title, imgfile, content, thumbnail) values(?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, qvo.getWriter());
			pst.setString(2, qvo.getTitle());
			pst.setString(3, qvo.getImgfile());
			pst.setString(4, qvo.getContent());
			pst.setString(5, qvo.getImgfile());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<QnaVO> selectAll() {
		String sql = "select * from qna";
		ArrayList<QnaVO> aqvo = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				int qno = rs.getInt("qno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				int readcount = rs.getInt("readcount");
				String regdate = rs.getString("regdate");
				String thumbnail = rs.getString("thumbnail");
				aqvo.add(new QnaVO(qno, writer, title, readcount, regdate, thumbnail));
			}
			return aqvo;
		} catch (SQLException e) {
			System.out.println("ㅇㄹ");
			e.printStackTrace();
		}
		return null;
	}
	
	public QnaVO selectOne(int qno) {
		String sql = "Select * from qna where qno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, qno);
			rs = pst.executeQuery();
			QnaVO qvo = new QnaVO();
			while(rs.next()) {
				qvo.setQno(rs.getInt("qno"));
				qvo.setWriter(rs.getString("writer"));
				qvo.setTitle(rs.getString("title"));
				qvo.setImgfile(rs.getString("imgfile"));
				qvo.setContent(rs.getString("content"));
				qvo.setReadcount(rs.getInt("readcount"));
				qvo.setRegdate(rs.getString("regdate"));
			}
			return qvo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(QnaVO qvo) {
		String sql = "update qna set title=?, imgfile=?, content=?, thumbnail=? where qno = ?";
		System.out.println("Modified ::: "+qvo.getQno()+" / "+qvo.getTitle()+" / "+qvo.getContent());
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, qvo.getTitle());
			pst.setString(2, qvo.getImgfile());
			pst.setString(3, qvo.getContent());
			pst.setString(4, qvo.getImgfile());
			pst.setInt(5, qvo.getQno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(int qno) {
		String sql = "delete from qna where qno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, qno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
