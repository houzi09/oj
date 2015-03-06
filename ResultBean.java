package huawei;

public class ResultBean 
{
	/**
	 * 返回码，0成功，-1失败
	 */
	private int ret;
	
	/**
	 * 最短路线条数;
	 */
	private int pPathNum;
	
	/**
	 * 最短路线长度
	 */
	private int pPathLen;
	
	/**
	 * 存储最短路线;
	 */
	private int[][] ppPathes;

	public int getpPathNum() {
		return pPathNum;
	}

	public void setpPathNum(int pPathNum) {
		this.pPathNum = pPathNum;
	}

	public int getpPathLen() {
		return pPathLen;
	}

	public void setpPathLen(int pPathLen) {
		this.pPathLen = pPathLen;
	}

	public int[][] getPpPathes() {
		return ppPathes;
	}

	public void setPpPathes(int[][] ppPathes) {
		this.ppPathes = ppPathes;
	}
	
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
}
