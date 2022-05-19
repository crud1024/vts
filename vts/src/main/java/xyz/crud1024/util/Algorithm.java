package xyz.crud1024.util;
/**
 * 排球比赛规则类
 * @author 王智锋
 *
 */
public class Algorithm {
	/*
	 * 排球比赛采用五局三胜制，每局比赛先得到25分，并领先对方至少两分的一方获胜，
	 * 决胜局先得15分，并领先对手至少两分的一方获胜。
	 * 正常局大于25分即获胜，判断是否满足获胜条件
	 */
	public boolean isWinConditions(int num) {
		if (num>=25) {
			return true;
		}
		return false;
	}
	/*
	 * 每局比赛中，双方各有六次换人的机会，
	 * 领先的球队得分到达八分，第16分进入技术暂停抽签，
	 * 确定发球权和双方厂区后，比赛正式开始，裁判员哨声响后获得发球权
	 * 提示技术暂停抽签
	 */
	public boolean Determine(int num) {
		if ((num==8)||(num==16)) {
			return true;
		}
		return false;
	}
}
