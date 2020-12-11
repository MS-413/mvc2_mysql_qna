package model.qna;

public class QnaVO {
	private int qno;
	private String writer;
	private String title;
	private String content;
	private int readcount;
	private String regdate;
	private String imgfile;
	private String thumbnail;
	
	public QnaVO() {
	}
	
	// for Create
	public QnaVO(String writer, String title, String content, String imgfile) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.imgfile = imgfile;
	}
	
	// for List
	public QnaVO(int qno, String writer, String title, int readcount, String regdate, String thumbnail) {
		this.qno = qno;
		this.writer = writer;
		this.title = title;
		this.readcount = readcount;
		this.regdate = regdate;
		this.thumbnail = thumbnail;
	}

	// for update 
	public QnaVO(int qno, String writer, String title, String content, String imgfile) {
		this(writer, title, content, imgfile);
		this.qno = qno;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
