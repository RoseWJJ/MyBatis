package com.et.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
	public abstract List<Student> queryStudent(Student student);
	public abstract List<Student> queryStudentBySex(@Param("sex")Integer sexNum);
	public abstract void updateStudent(Student student);
	public abstract List<Student> querySudentByGrade(@Param("gradeList")List<String>gradeList);
}
