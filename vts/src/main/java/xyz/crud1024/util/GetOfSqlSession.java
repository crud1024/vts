package xyz.crud1024.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.experimental.theories.Theories;
import org.junit.validator.ValidateWith;
/**
 * sqlsessionfactory是线程安全的，一旦被创建在整个应用程序执行期间都会存在--使用单例模式可解决
 * @author 王智锋
 *
 */
public class GetOfSqlSession {
	private String xml = "mybatis-config.xml";//默认路径
	private SqlSession sqlSession = null;
	private SqlSessionFactory sessionFactory = null;
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	
	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * 获取sqlsession对象
	 */
	public SqlSession getSqlSession() {
		try {
			if (sessionFactory==null) {
				// 通过使用Resource工具从类加载路径下加载指定配置文件如"mybatis-config.xml";构建SqlSessionFactory；通过Opensesson获得sqlSesson对象
				sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(xml));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactory.openSession();
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
