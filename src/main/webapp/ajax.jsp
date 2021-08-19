<%--
  Created by IntelliJ IDEA.
  User: xuxx
  Date: 2021/8/17
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#ajaxbtn").click(function (){
                $.ajax({
                    url:"student.do",
                    type:"get",
                    dataType:"json",
                    success:function (data){
                        $("#id1").html(data.id)
                        $("#username").html(data.username)
                        $("#sex").html(data.sex)
                        $("#password").html(data.password)
                    }
                })
            })

        })
    </script>
</head>
<body>
<button id="ajaxbtn">点击显示</button><br>
id:       <span id="id"></span><br>
username:  <span id="username"></span><br>
sex        <span id="sex"></span><br>
passeword: <span id="password"></span><br>
</body>
</html>
