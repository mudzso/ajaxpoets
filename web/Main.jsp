<%--
  Created by IntelliJ IDEA.
  User: mudzso
  Date: 2017.04.10.
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <title>Mainpage</title>
</head>
<body>
<%
    String name = (String)session.getAttribute("name");
%>
<h1><%=name%></h1>
<div id="poets">

</div>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "/MainServlet",
            type: "GET",
            success: function (data) {
                for (var i = 0; i< data.length; i++){
                    var title = data[i].title;
                    var year = data[i].year;
                    var htmlString = "";
                    htmlString += "<a href='poem.jsp?title=\""+title+ "\"' style = \"float: left;margin: 10px\"  value=\"" + title + " " + year + "\">"+title+": " + year +"</a>";
                    $("#poets").append(htmlString);

                }
            }
        })

    })
</script>
</body>
</html>
