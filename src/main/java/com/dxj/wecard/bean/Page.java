package com.dxj.wecard.bean;

public class Page {
	private int num = 0;
	private int size = 10;
	private int page = 1;
	private int maxPage = 0;
	private int start = 0;
	private int end = 0;

	public Page() {

	}

	public Page(int num) {
		if (num >= 0) {
			this.num = num;
			cal();
		}
	}

	public Page(int num, int page) {
		if (num >= 0 && page > 0) {
			this.num = num;
			this.page = page;
			cal();
		}
	}

	public Page(int size, int num, int page) {
		if (num >= 0 && size > 0 && page > 0) {
			this.size = size;
			this.num = num;
			this.page = page;
			cal();
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if (num >= 0) {
			this.num = num;
			cal();
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size > 0) {
			this.size = size;
			cal();
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
			cal();
		}
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private void cal() {
		if (num >= 0 && size > 0 && page > 0) {
			maxPage = num / size;
			if (num % size > 0)
				maxPage++;
			if (page <= maxPage) {
				start = (page - 1) * size;
				if (start < 0)
					start = 0;
				end = page * size - 1;
				if (end >= num)
					end = num - 1;
			}
		}
	}
}