<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>计分</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script src="layui/layui.js"></script>
</head>
<style type="text/css">
#box1 {
	background-color: rgba(112, 128, 144, 0.5);
	width: 90%;
	height: 250px;
	border-radius: 20px;
	position: absolute;
	top: 10%;
	left: 5%;
}

#box2 {
	width: 40%;
	height: 80%;
	position: absolute;
	top: 10%;
	left: 5%;
}

#box3 {
	width: 40%;
	height: 80%;
	position: absolute;
	top: 10%;
	left: 65%;
}

#box2_1 {
	width: 150px;
	height: 150px;
	position: absolute;
	top: 20%;
	left: 25%;
	background-image: url(layui/crud1024.png);
}
#box3_1 {
	width: 150px;
	height: 150px;
	position: absolute;
	top: 20%;
	left: 85%;
	background-image: url(layui/crud1024.png);
}


.in_vs {
	text-align: center;
}
</style>
<body>
	
	<h1>第${cid}轮比赛计分:</h1>
	<div id="box1">
		<!-- 队伍1区域 -->
		<div id="box2">

			<div class="box2_3" id="se1">
				<label>对局队伍:</label> <select name="gid" size="" id="gname1">

				</select>
			</div>

			<div class="box2_1">
				<label class="a">对局得分</label> <input type="text" name="vs1"
					placeholder="0" class="in_vs" id="vs1"/>
			</div>

			<div class="box2_2" id="pname">
				<label>选择得分队员</label> <br />
			</div>
			<div class="box2_4">
				<input type="button" value="加分" onclick="addScore1()" id="add1"/><input type="button" value="恢复" id="re1"/>
			</div>


		</div>
		<!-- 队伍2区域 -->
		<div id="box3">
			
			<div class="box2_3" id="se2">
				<label>对局队伍:</label> <select name="gid" size="" id="gname2">

				</select>
			</div>

			<div class="box2_1">
				<label class="a">对局得分</label> <input type="text" name="vs2"
					placeholder="0" class="in_vs" id="vs2"/>
			</div>

			<div class="box2_2" id="pname2">
				<label>选择加分队员</label> <br />
			</div>


			<div class="box2_4">
				<input type="button" value="加分" onclick="addScore2()" id="add2"/><input type="button" value="恢复" id="re2"/>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//加载就立即显示队伍
		window.onload = function() {
			var url = "${pageContext.request.contextPath }/getGroups";
			$.get(url, function(groups) {
				//将处理器返回的队伍信息中添加到列表中
				//队伍1-----------------------------------------------
				$("#gname1").append(
						"<option value ='0'  selected>选择队伍</option>")
				for (var i = 0; i < groups.length; i++) {
					$("#gname1").append(
							"<option value ='" + groups[i].gid + "'>"
									+ groups[i].gname + "</option>")
				}
				$("#se1").append(
				"<input type='button' value='确定' onclick='selected1()' id='que1'/>")
				
				
				
				//队伍2-----------------------------------------------
				$("#gname2").append(
						"<option value ='0'  selected>选择队伍</option>")
				for (var i = 0; i < groups.length; i++) {
					$("#gname2").append(
							"<option value ='" + groups[i].gid + "'>"
									+ groups[i].gname + "</option>")
				}
				$("#se2").append(
				"<input type='button' value='确定' onclick='selected2()' id='que2'/>")
			})
			
		}
		function selected1(){
			$("#que1").hide();
			<!-- 队伍1图标 -->
			$("#box1").append(
			"<input type='image' id='box2_1' src='layui/crud1024.png'>")
			inGroupOutPerson1($("#gname1").val());
		}
		function selected2(){
			$("#que2").hide();
			<!-- 队伍2图标 -->
			$("#box1").append(
			"<input type='image' id='box3_1' src='layui/crud1024.png'>")
			inGroupOutPerson2($("#gname2").val());
		}
		function inGroupOutPerson1 (gid) {
			//加载就立即显示队员
					var url2 = "${pageContext.request.contextPath }/getPersons?g_id="+gid;
						$.get(url2,function(persons){
							//将处理器返回的队伍信息中添加到列表中
							for (var i = 0; i < persons.length; i++) {
								$("#pname").append(persons[i].pname+"<input type='radio' name='person1' value='"+persons[i].pid+"' title='"+persons[i].pname+"'>")
								if ((i+1)%2==0) {
									$("#pname").append("<br />")
								}
							}
						})
		}
		function inGroupOutPerson2 (gid) {
			//加载就立即显示队员
					var url2 = "${pageContext.request.contextPath }/getPersons?g_id="+gid;
						$.get(url2,function(persons){
							//将处理器返回的队伍信息中添加到列表中
							for (var i = 0; i < persons.length; i++) {
								$("#pname2").append(persons[i].pname+"<input type='radio' name='person2' value='"+persons[i].pid+"' title='"+persons[i].pname+"'>")
								if ((i+1)%2==0) {
									$("#pname2").append("<br />")
								}
							}
						})
		}
		
		//加分操作
		//队伍1加分操作
		function addScore1(){
			var pid = $("input[name='person1']:checked").val();
			var gid = $("#gname1").val();
			var cid = ${cid};
			//显示当前分数
			showvs1(gid);
			var vs1 = $("#vs1").val();
			var vs2 = $("#vs2").val();
			if (vs1==7||vs1==15) {
				alert('技术暂停抽签，确定发球权和双方厂区!');
			}
			if (${cid}<=4) {//前4局比赛采用25分制，每个队只有赢得至少25分，并同时超过对方2分时 ，才胜1局。
				if(vs1>=24&&(vs1-vs2)>2){
					alert('该局已有队伍获胜，请更换场次录入！');
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath }/getScore",
						type:"post",
						data:JSON.stringify({s_pid:pid,s_gid:gid,s_cid:cid}),
						contentType:"application/json;charset=UTF-8",
						dataType:"json",
						success:function(response){
							alert(response);
						}
					})
				}	
			}else if(${cid}==5){//在决胜局(第五局)之比赛，先获15分并领先对方2分为胜。
				if(vs1>=14&&(vs1-vs2)>2){
					alert('该局已有队伍获胜，请更换场次录入！');
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath }/getScore",
						type:"post",
						data:JSON.stringify({s_pid:pid,s_gid:gid,s_cid:cid}),
						contentType:"application/json;charset=UTF-8",
						dataType:"json",
						success:function(response){
							alert(response);
						}
					})
				}	
			}				
		}
		//队伍2加分操作
		function addScore2(){
			var pid = $("input[name='person2']:checked").val();
			var gid = $("#gname2").val();
			var cid = ${cid};
			//显示当前分数
			showvs2(gid);
			var vs1 = $("#vs1").val();
			var vs2 = $("#vs2").val();
			if (vs2==7||vs2==15) {
				alert('技术暂停抽签，确定发球权和双方厂区!');
			}
			if (${cid}<=4) {//前4局比赛采用25分制，每个队只有赢得至少25分，并同时超过对方2分时 ，才胜1局。
				if(vs2>=24&&(vs2-vs1)>2){
					alert('该局已有队伍获胜，请更换场次录入！');
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath }/getScore",
						type:"post",
						data:JSON.stringify({s_pid:pid,s_gid:gid,s_cid:cid}),
						contentType:"application/json;charset=UTF-8",
						dataType:"json",
						success:function(response){
							alert(response);
						}
					})
				}	
			}else if(${cid}==5){//在决胜局(第五局)之比赛，先获15分并领先对方2分为胜。
				if(vs2>=14&&(vs2-vs1)>2){
					alert('该局已有队伍获胜，请更换场次录入！');
				}else{
					$.ajax({
						url:"${pageContext.request.contextPath }/getScore",
						type:"post",
						data:JSON.stringify({s_pid:pid,s_gid:gid,s_cid:cid}),
						contentType:"application/json;charset=UTF-8",
						dataType:"json",
						success:function(response){
							alert(response);
						}
					})
				}
			}
		}
		
		//得分返回显示-需要分组拿组得分
		//队伍一的得分数据
		function showvs1(p_gid){
			var url = "${pageContext.request.contextPath }/getGroupScore?p_gid="+p_gid+"&cid="+${cid};
			$.get(url,function(groupscore){
				//将处理器返回的队伍总分添加到分数显示框中
				$("#vs1").val(groupscore.length+1);
			})
		}
		//队伍二的得分数据
		function showvs2(p_gid){
			var url = "${pageContext.request.contextPath }/getGroupScore?p_gid="+p_gid+"&cid="+${cid};
			$.get(url,function(groupscore){
				//将处理器返回的队伍总分添加到分数显示框中
				$("#vs2").val(groupscore.length+1);
			})
		}
		
	</script>
</body>

</html>