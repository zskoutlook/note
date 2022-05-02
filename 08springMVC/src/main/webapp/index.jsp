
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
index页面


<a href="${pageContext.request.contextPath}/one/demo.action">访问服务器1</a>
<a href="${pageContext.request.contextPath}/two/demo.action">访问服务器2</a>


<h3>测试不同的请求连接方式，不同接受参数方式一：接受形参为参数名</h3>
<form action="${pageContext.request.contextPath}/three1.action" method="get">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="get提交、接受形参为参数名">
</form>
<form action="${pageContext.request.contextPath}/three1.action" method="post">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="post提交、接受形参为参数名">
</form>


<h3>测试不同的请求连接方式，不同接受参数方式二：接受形参为对象</h3>
<form action="${pageContext.request.contextPath}/three2.action" method="get">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="get提交、接受形参为对象">
</form>
<form action="${pageContext.request.contextPath}/three2.action" method="post">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="post提交、接受形参为对象">
</form>


<h3>测试不同的请求连接方式，不同接受参数方式三：动态占位符</h3>
<a href="${pageContext.request.contextPath}/three3/张三/22.action">动态占位符</a>


<h3>测试不同的请求连接方式，不同接受参数方式四：参数与形参名不一致</h3>
<form action="${pageContext.request.contextPath}/three4.action" method="get">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="get提交、参数与形参名不一致">
</form>
<form action="${pageContext.request.contextPath}/three4.action" method="post">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="post提交、参数与形参名不一致">
</form>


<h3>测试不同的请求连接方式，不同接受参数方式五：手工提取数据</h3>
<form action="${pageContext.request.contextPath}/three5.action" method="get">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="get提交、参数与形参名不一致">
</form>
<form action="${pageContext.request.contextPath}/three5.action" method="post">
    姓名：<input name="name">
    年龄：<input name="age">
    <input type="submit" value="post提交、参数与形参名不一致">
</form>

<h4>ajax请求</h4>

<a href="javascript:showStu()" >访问服务返回学生集合</a>
<script type="text/javascript">
    function showStu(){
        $.ajax({
            url:"${pageContext.request.contextPath}/list.action",
            type:"get",
            dataType:"json",
            success:function (stuList){
                console.log("Ajax、List返回值开始")
                console.log(stuList)
                $.each(stuList,function (i,stu){
                    console.log("姓名：" +stu.name+"年龄："+stu.age);
                })
                console.log("Ajax、List返回值结束")
            }
        })
    }
</script>


<hr>
<a href="${pageContext.request.contextPath}/fore1.action" >请求转发页面</a>        地址：fore1.action           <br>
<a href="${pageContext.request.contextPath}/fore2.action" >请求转发action</a>     地址：fore2.action            <br>
<a href="${pageContext.request.contextPath}/fore3.action" >重定向页面</a>        地址：main页面地址             <br>
<a href="${pageContext.request.contextPath}/fore4.action" >重定向action</a>      地址：other.action地址         <br>

<hr>
<a href="${pageContext.request.contextPath}/five1.action?id=100" >进行数据携带跳转，不只可以处理器方法中添加参数，还可以把该连接的参数同时传过去</a><br>
<a href="${pageContext.request.contextPath}/five2.action?id=100" >进行数据携带跳转，不只可以处理器方法中添加参数，还可以把该连接的参数同时传过去</a>

<hr>
<form action="${pageContext.request.contextPath}/six1.action">
    日期：<input type="date" name="mydate">
    <input type="submit" value="单个日期的提交处理">
</form>
<form action="${pageContext.request.contextPath}/six2.action">
    日期：<input type="date" name="mydate">
    <input type="submit" value="类中全局日期的提交处理">
</form>

</body>
</html>
