package tech.zxuuu.server.teaching;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import tech.zxuuu.dao.IClassMapper;
import tech.zxuuu.dao.ITeacherMapper;
import tech.zxuuu.server.main.App;
import tech.zxuuu.entity.*;

/**
 * 教务老师相关后端
 * 
 * @author z0gSh1u
 * @author 王志华
 */
public class CourseManagerSide {

	public static String getTeacherNameById(String academy, String idInAcademy) {
		String result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = App.sqlSessionFactory.openSession();
			ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
			Map<String, String> map = new HashMap<>();
			map.put("academy", academy);
			map.put("idInAcademy", idInAcademy);
			result = teacherMapper.getTeacherNameById(map);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Boolean insertNewCourse(ClassInfo classInfo) {
		SqlSession sqlSession = null;
		try {
			sqlSession = App.sqlSessionFactory.openSession();
			IClassMapper classMapper = sqlSession.getMapper(IClassMapper.class);
			classMapper.insertNewCourse(classInfo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
