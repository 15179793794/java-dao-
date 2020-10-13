<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()
            +"/";
%>
<base href=<%=basePath%>>
<html>
<head>
    <beta charset="UTF-8"></beta>
    <title>登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/expthree.css" />
</head>
<body>
<h2 align="center">Hello World!</h2>
<p class="text-danger d-inline-block text-center"><c:out value="${sessionScope.msg}"> </c:out></p>

<div class="Login">
    <aside></aside>
    <div class="row down">
        <div class="col-3 touxiang">
            <a href="#"></a>
            <dl>
                <dt><a href="#"><span class="online"></span></a></dt>
                <dd></dd>
            </dl>
            <i class="people"></i>
        </div>
        <div class="col-6 login-box">
            <form action="login" method="post">
                <input type="text" placeholder="用户名" name="name"> <span class="first"></span>
                <input type="password" placeholder="密码" name="password"/> <span class="second"></span>
                <label><input type="checkbox" class="three" checked="checked" name="isStoreCookie">&nbsp;十天内免登录</label>
                <button class="btn">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                <label text-align="right"><a> 忘记会员名 </a><a> 忘记密码 </a> <a href="register.jsp"> 免费注册 </a></label>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    function flashCode() {
        const img = document.getElementById("verifyCode");
        img.src="verifyCode.do?"+Math.floor(Math.random()*10000);
    }
</script>
<footer>
    <p>作者：吴仁杨</p>
    <%=request.getRequestURL()%>
    <br>
    <%=request.getRequestURI()%>
    <br>
    <%=request.getHeader("REFERER")%>
    <%
        Object o = new String();
    %>
</footer>
</body>
</html>
