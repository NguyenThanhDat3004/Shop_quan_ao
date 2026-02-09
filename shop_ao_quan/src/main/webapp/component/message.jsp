<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

<% if (error != null) { %>
    <div style="
        background: #e53935;
        color: #ffffff;
        border: 2px solid #b71c1c;
        padding: 10px;
        margin-bottom: 12px;
        text-align: center;
        font-weight: bold;
        border-radius: 8px;
    ">
        <%= error %>
    </div>
<% } %>

<% if (success != null) { %>
    <div style="
        background: #43a047;
        color: #ffffff;
        border: 2px solid #1b5e20;
        padding: 10px;
        margin-bottom: 12px;
        text-align: center;
        font-weight: bold;
        border-radius: 8px;
    ">
        <%= success %>
    </div>
<% } %>
