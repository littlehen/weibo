package com.nit.weibo.dto;

public class FunctionsDto {

	private int fid;
	
	private int bcfPl;

    private int yp;

    private int jx;

    private int hd;

    private int sy;

    private String yz;

    public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}


	private int plZhushou;


	public int getPlZhushou() {
		return plZhushou;
	}

	public void setPlZhushou(int plZhushou) {
		this.plZhushou = plZhushou;
	}

	public int getBcfPl() {
		return bcfPl;
	}

	public void setBcfPl(int bcfPl) {
		this.bcfPl = bcfPl;
	}

	public FunctionsDto() {
		super();
	}

	public FunctionsDto(int fid,int plZhushou, int bcfPl, int yp, int jx, int hd, int sy, String yz) {
		super();
		this.fid = fid;
		this.plZhushou = plZhushou;
		this.bcfPl = bcfPl;
		this.yp = yp;
		this.jx = jx;
		this.hd = hd;
		this.sy = sy;
		this.yz = yz;
	}

	public int getYp() {
		return yp;
	}

	public void setYp(int yp) {
		this.yp = yp;
	}

	public int getJx() {
		return jx;
	}

	public void setJx(int jx) {
		this.jx = jx;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public String getYz() {
		return yz;
	}

	public void setYz(String yz) {
		this.yz = yz;
	}



    

}
