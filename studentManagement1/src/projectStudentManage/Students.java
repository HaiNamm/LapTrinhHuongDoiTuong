package projectStudentManage;

public class Students {
	int stt;
	String IDLop, TenLop, KhoaHoc;
	public Students(int stt, String iDLop, String tenLop, String khoaHoc) {
		super();
		this.stt = stt;
		IDLop = iDLop;
		TenLop = tenLop;
		KhoaHoc = khoaHoc;
	}
	public Students(String iDLop, String tenLop, String khoaHoc) {
		super();
		IDLop = iDLop;
		TenLop = tenLop;
		KhoaHoc = khoaHoc;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getIDLop() {
		return IDLop;
	}
	public void setIDLop(String iDLop) {
		IDLop = iDLop;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	public String getKhoaHoc() {
		return KhoaHoc;
	}
	public void setKhoaHoc(String khoaHoc) {
		KhoaHoc = khoaHoc;
	}

	
}