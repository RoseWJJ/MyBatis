package com.et.lesson03.returnMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
	@Results({
		@Result(column="gid",property="grade",one=@One(select="com.et.lesson03.returnMap.anno.GradeMapper.queryGradeByGradeId")),
		
	})
	@Select("select * from student where studentid=#{0}")
	public abstract Student queryStudent(int studentId);
	
	@Select("select * from student where gid=#{0}")
	public abstract List<Student> queryStudentByGid(int gid);
}
