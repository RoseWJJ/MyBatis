package com.et.lesson03.returnMap.anno;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface GradeMapper {
	/**
	 *  crud
	 * @param foodname
	 * @return
	 */
	
	
	//通过班级查学生
	@Results(
				{
					@Result(property="gname1" ,column="gname"),
					@Result(column="gid",property="studentList",javaType=ArrayList.class,many=@Many(select="com.et.lesson03.returnMap.anno.StudentMapper.queryStudentByGid"))
				}
			)
	@Select("select * from grade where gid=#{0}")
	public abstract Grade queryGrade(int gid);
	
	
	
	
	//通过学生查班级
	@Results(
			@Result(property="gname1" ,column="gname")
	)
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeByGradeId(int gid);
	
}
