package com.et.lesson04.anno;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface StudentMapper {
	class StudentProvier {
		public String queryStudentSql(Map map){
			Student student = (Student)map.get("stu");
			String sql = "select * from student where 1=1";
			if(student.getsName()!=null &&!"".equals(student.getsName())){
				student.setsName("%"+student.getsName()+"%");
				sql+=" and sname like #{stu.sName}";
			}
			if(student.getAddress()!= null &&!"".equals(student.getAddress())){
				student.setAddress("%"+student.getAddress()+"%");
				sql+=" and address like #{stu.address}";
			}
			return sql;
		}
	}
	@SelectProvider(type=StudentProvier.class,method="queryStudentSql")
	public List<Student> queryStudent(@Param("stu")Student student); 
		
	
	@Select("<script>select * from student where 1=1 "+
			"<choose>"+
			"<when test =\"sex!=null\">"+
			" and sex=#{sex}"+
			"</when>"+
			" <otherwise>"+
			"  and sex=1"+
			"</otherwise>"+
		    "</choose></script>"
	)
	public abstract List<Student> queryStudentBySex(@Param("sex")Integer sexNum);
}
