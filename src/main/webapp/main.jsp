<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>index.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">

</head>

<body style="text-align: center;">
当前用户：${user.username}
<div style="text-align: center;">
<table border="1px"  style="margin: auto">
    <%--表头开始--%>
 <thead >
  <tr>
      <th>文件id</th>
      <th>文件用户</th>
      <th>原始名称</th>
      <th>新文件名称</th>
      <th>文件后缀名</th>
      <th>存储路径</th>
      <th>大小</th>
      <th>文件类型</th>
      <th>是否是图片</th>
      <th>下载次数</th>
      <th>操作</th>
  </tr>
 </thead>
        <%--表头结束--%>
  <tbody>
  <c:forEach items="${files}" var="c">
  <tr>
      <td>${c.id}</td>
      <td>${c.user_id}</td>
      <td>${c.primeval_name}</td>
      <td>${c.new_name}</td>
      <td>${c.suffix}</td>
      <td>${c.path}</td>
      <td>${c.size}</td>
      <td>${c.type}</td>
      <td>${c.whether_img}</td>
      <td>${c.download_number}</td>
      <td><a href="">下载</a>|<a href="">预览</a>|<a href="">删除</a>/td>


  </tr>
  </c:forEach>


  </tbody>
</table>


</div>
上传用户文件：
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data" >

    <input type="file" name="fileName">
    <input type="submit" value="上传"/>

</form>


</body>
</html>