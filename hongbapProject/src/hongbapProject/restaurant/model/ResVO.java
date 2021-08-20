package hongbapProject.restaurant.model;

public class ResVO {
	private int resId;
	private String resName;
	private String resAddr;
	private String resPnum;
	private String resTime;
	private String resHoliday;
	private String resHomepage;
	private String resCategory;
	
	
	public ResVO() {
		
	}
	
	
	public ResVO(int resId, String resName, String resAddr, String resPnum, String resTime, String resHoliday,
			String resHomepage, String resCategory) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddr = resAddr;
		this.resPnum = resPnum;
		this.resTime = resTime;
		this.resHoliday = resHoliday;
		this.resHomepage = resHomepage;
		this.resCategory = resCategory;
	}


	public String getResCategory() {
		return resCategory;
	}

	public void setResCategory(String resCategory) {
		this.resCategory = resCategory;
	}

	@Override
	public String toString() {
		return "ResVO [resId=" + resId + ", resName=" + resName + ", resAddr=" + resAddr + ", resPnum=" + resPnum
				+ ", resTime=" + resTime + ", resHoliday=" + resHoliday + ", resHomepage=" + resHomepage + "]";
	}
	
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResAddr() {
		return resAddr;
	}
	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}
	public String getResPnum() {
		return resPnum;
	}
	public void setResPnum(String resPnum) {
		this.resPnum = resPnum;
	}
	public String getResTime() {
		return resTime;
	}
	public void setResTime(String resTime) {
		this.resTime = resTime;
	}
	public String getResHoliday() {
		return resHoliday;
	}
	public void setResHoliday(String resHoliday) {
		this.resHoliday = resHoliday;
	}
	public String getResHomepage() {
		return resHomepage;
	}
	public void setResHomepage(String resHomepage) {
		this.resHomepage = resHomepage;
	}
	
}
