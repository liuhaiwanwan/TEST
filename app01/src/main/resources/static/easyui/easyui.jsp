<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath()+"/";
out.println("<link href='"+path+"easyui/jquery-easyui-1.5.1/themes/default/easyui.css' rel='stylesheet' type='text/css'/>");
out.println("<link href='"+path+"easyui/jquery-easyui-1.5.1/themes/icon.css' rel='stylesheet' type='text/css'/>");
out.println("<link href='"+path+"easyui/jquery-easyui-1.5.1/demo/demo.css' rel='stylesheet' type='text/css'/>");
out.println("<script type='text/javascript' src='"+path+"easyui/jquery-easyui-1.5.1/jquery.min.js'></script>");
out.println("<script type='text/javascript' src='"+path+"easyui/jquery-easyui-1.5.1/jquery.easyui.min.js'></script>");
out.println("<script type='text/javascript' src='"+path+"easyui/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js'></script>");
%>