<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>选择队伍轮次</title>
  <link rel="stylesheet" href="layui/css/layui.css">
  <script src="layui/layui.js"></script>
  <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
	<body>
		<form class="layui-form" action="${pageContext.request.contextPath }/jsp/group">
			<div class="layui-form-item">
			  <label class="layui-form-label">选择队伍</label>
			  <div class="layui-input-block">
			    <select name="g_id" lay-verify="required" id="group" lay-filter="status">
			      <option value=""></option>
			    </select>
			  </div>
			</div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">选择轮次</label>
		    <div class="layui-input-block">
		      <select name="cid" lay-verify="required" id="num">
		        <option value=""></option>
		        <option value="1">第一轮</option>
		        <option value="2">第二轮</option>
		        <option value="3">第三轮</option>
		        <option value="4">第四轮</option>
		        <option value="5">第五轮</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		  </div>
		</form>
		
		<script>
		//加载就立即显示队伍
		window.onload = function() {
			var url = "${pageContext.request.contextPath }/getGroups";
			$.get(url, function(groups) {
				//将处理器返回的队伍信息中添加到列表中
				for (var i = 0; i < groups.length; i++) {
					$("#group").append(
							"<option value ='" + groups[i].gid + "'>"
									+ groups[i].gname + "</option>")
				}
				layui.use('form',function(){
					var form=layui.form;
					form.render("select");
				})
			})
		}
		//Demo
		layui.use('form', function(){
		  var form = layui.form;
		  
		  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    return true;
		  });
		});
		</script>
	</body>
</html>