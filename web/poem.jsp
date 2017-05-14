<%--
  Created by IntelliJ IDEA.
  User: mudzso
  Date: 2017.05.14.
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>

<div id="text">
    
</div>
<script>
    $(document).ready(function () {
        var data = getUrlParameter('title');
        console.log(data);
        $.ajax({
            url: '/MainServlet',
            type: 'POST',
            Data: {
                title: data
            },
            success:function (data) {
                console.log(data);
            }
            }
        )

        function getUrlParameter(sParam) {
            var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;

            for (i = 0; i < sURLVariables.length; i++) {
                sParameterName = sURLVariables[i].split('=');

                if (sParameterName[0] === sParam) {
                    return sParameterName[1] === undefined ? true : sParameterName[1];
                }
            }
        };

        function wordCount( val ){
            var wom = val.match(/\S+/g);
            return {
                words : wom ? wom.length : 0
            };
        }

    })
</script>
</body>
</html>
