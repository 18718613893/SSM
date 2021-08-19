<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
  <script type="text/javascript">
    $(function (){
      $("#bot").click(function (){
        $.ajax({
          url:"selectStudent.do",
          type:"get",
          dataType:"json",
          success:function (data){
            ///清楚旧数据
            $("#tbody").html("");
            $.each(data,function (i,n){

              $("#tbody").append("<tr>")
              .append("<td>"+n.id+"</td>")
              .append("<td>"+n.username+"</td>")
              .append("<td>"+n.sex+"</td>")
              .append("<td>"+n.password+"</td>")
              .append("</tr>")

            })
          }
        })
      })
    })
  </script>
</head>
<body>

<center>
<button id="bot">查询数据</button>
<br>
  <form action="insertStudent.do">
    <table>
      <tr>
        <td>username</td>
        <td><input type="text" name="username" ></td>
      </tr>
      <tr>
        <td>sex</td>
        <td><input type="radio" name="sex" value="男">男
          <input type="radio" name="sex" value="女">女</td>
      </tr>
      <tr>
        <td>password</td>
        <td><input type="text" name="password" ></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交"></td>
        <td><input type="reset" value="重置" ></td>
      </tr>
    </table>
  </form>
  <br>
  <br>
  <form action="login.do">
    <table>
      <tr>
        <td>ID</td>
        <td><input type="text" name="id" ></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="text" name="password" ></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交"></td>
        <td><input type="reset" value="重置" ></td>
      </tr>
    </table>
  </form>
  <a href="logout.do">退出</a>
</center>
<table border="2">
  <thead>
  <tr>
    <td>学号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>密码</td>
  </tr>
  </thead>
  <tbody id="tbody">

  </tbody>
</table>
</body>
</html>