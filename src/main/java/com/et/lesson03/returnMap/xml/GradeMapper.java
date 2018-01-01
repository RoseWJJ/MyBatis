package com.et.lesson03.returnMap.xml;

import java.util.List;


public interface GradeMapper {
	/**
	 *  crud
	 * @param foodname
	 * @return
	 */
	public abstract List<Grade> queryAllGrade();
	
	//通过gid查班级
	public abstract Grade queryGrade(int gid);
	
}
