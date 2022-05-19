package xyz.crud1024.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.experimental.theories.Theories;
import org.junit.validator.ValidateWith;
/**
 * sqlsessionfactory���̰߳�ȫ�ģ�һ��������������Ӧ�ó���ִ���ڼ䶼�����--ʹ�õ���ģʽ�ɽ��
 * @author ���Ƿ�
 *
 */
public class GetOfSqlSession {
	private String xml = "mybatis-config.xml";//Ĭ��·��
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
	 * ��ȡsqlsession����
	 */
	public SqlSession getSqlSession() {
		try {
			if (sessionFactory==null) {
				// ͨ��ʹ��Resource���ߴ������·���¼���ָ�������ļ���"mybatis-config.xml";����SqlSessionFactory��ͨ��Opensesson���sqlSesson����
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
