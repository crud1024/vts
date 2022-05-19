<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="layui/css/layui.css">
  <script src="layui/layui.js"></script>
</head>
	<body>
		<form class="layui-form" action="${pageContext.request.contextPath }/jsp/vts">
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
		//Demo
		layui.use('form', function(){
		  var form = layui.form;
		  var cid = $("#num").val();
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		   window.location.replace("${pageContext.request.contextPath }/jsp/vts?cid="+cid);
		    return false;
		  });
		});
		</script>
	</body>
</html>