package xyz.crud1024.util;
/**
 * �������������
 * @author ���Ƿ�
 *
 */
public class Algorithm {
	/*
	 * ����������������ʤ�ƣ�ÿ�ֱ����ȵõ�25�֣������ȶԷ��������ֵ�һ����ʤ��
	 * ��ʤ���ȵ�15�֣������ȶ����������ֵ�һ����ʤ��
	 * �����ִ���25�ּ���ʤ���ж��Ƿ������ʤ����
	 */
	public boolean isWinConditions(int num) {
		if (num>=25) {
			return true;
		}
		return false;
	}
	/*
	 * ÿ�ֱ����У�˫���������λ��˵Ļ��ᣬ
	 * ���ȵ���ӵ÷ֵ���˷֣���16�ֽ��뼼����ͣ��ǩ��
	 * ȷ������Ȩ��˫�������󣬱�����ʽ��ʼ������Ա��������÷���Ȩ
	 * ��ʾ������ͣ��ǩ
	 */
	public boolean Determine(int num) {
		if ((num==8)||(num==16)) {
			return true;
		}
		return false;
	}
}
