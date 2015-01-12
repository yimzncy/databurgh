<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" isELIgnored="false" errorPage="" %>

<html>

<head>
<title>Databurgh</title>
</head>

<body>

<form id="rss" method="post" action="/databurgh/rss">
<input type="submit" value="refresh"><br/>
${rss_content}
</form>

</body>

</html>
