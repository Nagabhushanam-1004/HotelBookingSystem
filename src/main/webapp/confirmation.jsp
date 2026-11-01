<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Status</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <div class="result-card">
        <h1>Hello, <%= request.getAttribute("name") %>!</h1>
        <p class="status-text"><%= request.getAttribute("msg") %></p>
        <a href="index.html" class="back-btn">Back to Form</a>
    </div>
</body>
</html>
