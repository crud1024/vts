<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>排球赛事系统</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">排球赛事系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">暂无</a></dd>
          <dd><a href="">暂无</a></dd>
          <dd><a href="">暂无</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="layui/crud1024.png" class="layui-nav-img">
          ${user.username}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">队伍管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/jsp/grouplist" target="demoAdmin">队伍信息</a></dd>
            <dd><a href="${pageContext.request.contextPath }/jsp/addgroup" target="demoAdmin">队伍添加</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">队员管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/jsp/personlist" target="demoAdmin">成员列表</a></dd>
            <dd><a href="${pageContext.request.contextPath }/jsp/addperson" target="demoAdmin">成员添加</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
         <a href="javascript:;">得分管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/jsp/scorelist" target="demoAdmin">得分信息</a></dd>
		</dl>
		</li>
        <li class="layui-nav-item">
          <a href="javascript:;">赛事信息</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/jsp/choosegroup" target="demoAdmin">场次得分</a></dd>
            <dd><a href="${pageContext.request.contextPath }/jsp/choosegroupandnum" target="demoAdmin">单轮得分</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
        <a href="javascript:;">赛事录入</a>
     	<dl class="layui-nav-child">
            <dd><a href="javascript:;" target="demoAdmin">赛事分组</a></dd>
            <dd><a href="${pageContext.request.contextPath }/jsp/choosenum" target="demoAdmin">比分录入</a></dd>
          </dl>
         </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
   <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    
    	<iframe src="" frameborder="0" name="demoAdmin" style="width: 100%; height: 600px;"></iframe> 
    
    
    
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © crud1024.xyz - 计应202第五组
  </div>
</div>
<script src="layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>