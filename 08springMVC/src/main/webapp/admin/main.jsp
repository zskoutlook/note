<%--
  Created by IntelliJ IDEA.
  User: zong
  Date: 2022/4/24
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--导入JSTL核心标签库--%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--导入JSTL格式化标签库--%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
main页面

<h2>显示数据</h2>
<div>HttpServletRequest传递数据：${student1} </div><br>
<div>HttpSession传递数据：       ${student2} </div><br>
<div>Model传递数据：             ${student3} </div><br>
<div>Map传递数据：               ${student4} </div><br>
<div>ModelMap传递数据：          ${student5} </div><br>
<div>从index.jsp传递的参数       ${param.id} </div><br>

<hr>
<div>1.单个日期显示(后台传的就是String，不Date)：${dateStr}</div>
<div>2.直接传Date类型数据:       ${mydate}</div>
<div>2.直接传Date类型数据并使用JSTL格式:       <fmt:formatDate value="${mydate}" pattern="yyyy-MM-dd"></fmt:formatDate>   </div>


<div>2.list中的实体类对象的成员变量是日期格式，必须使用JSTL才能得到想要的格式：
    <c:forEach items="${list}" var="stu">
        <div>${stu.name}</div>
        <div>${stu.birthday}</div>
        <fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>
    </c:forEach>
</div>


</body>
</html>
