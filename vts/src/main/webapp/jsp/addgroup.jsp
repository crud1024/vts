<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加队伍</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form class="layui-form" action="${pageContext.request.contextPath }/insertgroup">
		<div class="layui-form-item">
			<label class="layui-form-label">队伍名</label>
			<div class="layui-input-block">
				<input type="text" name="gname" lay-verify="title"
					autocomplete="off" placeholder="请输入标题" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">url</label>
			<div class="layui-input-block">
				<input type="text" name="gurl" lay-verify="title"
					autocomplete="off" placeholder="请输入内容" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		//Demo
		layui
				.use(
						'form',
						function() {
							var form = layui.form;

							//监听提交
							form
									.on(
											'submit(formDemo)',
											function(data) {
												//window.location.replace("${pageContext.request.contextPath }/jsp/group?g_id="+gid+"&cid="+cid);
												//window.location
														//.replace("${pageContext.request.contextPath }/jsp/addgroup?gname="+);
												return true;
											});
						});
	</script>
</body>