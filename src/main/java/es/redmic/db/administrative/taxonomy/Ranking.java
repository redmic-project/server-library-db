package es.redmic.db.administrative.taxonomy;

public class Ranking {
	private Long code;
	private String back;

	public Ranking(Long code, String back) {
		this.code = code;
		this.back = back;
	}

	public Long getCode() {
		return code;
	}

	public String getBack() {
		return back;
	}

}