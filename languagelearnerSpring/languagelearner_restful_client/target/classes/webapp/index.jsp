<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.RestUtil" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
       String resp =  RestUtil.getResp("http://localhost:8085/languagelearnerwebapp/rest/users");
       JSONArray arr = new JSONArray(resp);
%>
Users
<div >
    <table style="text-align: left">
        <thead>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        </thead>
        <tbody id="container">
            <%
                for(int i=0;i<arr.length();i++) {
                    JSONObject obj = arr.getJSONObject(i);
             %>
            <tr>
                <td><%=obj.getInt("id")%></td>
                <td><%=obj.getString("name")%></td>
                <td><%=obj.getString("surname")%></td>
            </tr>
            <% } %>

        </tbody>
    </table>
</div>
</body>
</html>
