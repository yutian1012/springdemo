package spittr.db;

import spittr.domain.Spitter;

public interface SpitterExtentionRepository {
	
	/**
	 * 提供一个spring data jpa扩展方法，Gmail并发Spitter的属性
	 * @param gMail
	 * @return
	 */
	public Spitter getSpitterByGmail(String gMail);
}
