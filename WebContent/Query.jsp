
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Query</title>
    </head>
    <body>
        <h3>Mysql_query: </h3>
        <s:form action="ShowDatas" namespace="/" >
            <s:submit value="展示数据库" />
        </s:form>
        <h3>-------------------------------------------- </h3>
        <s:form action="QueryBook" namespace="/" >
            请输入作者: <s:textfield name="name" />
            <s:submit value="提交" />
        </s:form>
        
        
         
        <h3>-------------------------------------------- </h3>
        <s:form action="ShowBookDatas" namespace="/" >
            请输入书名: <s:textfield name="name" />
            <s:submit value="提交" />
        </s:form>
        
      <h3>--------------------------------------------- </h3>
        <s:form action="DeleteBook " namespace="/" >
            请输入要删掉的书名: <s:textfield name="name" />
            <s:submit value="提交" />
        </s:form> 
        
        <h3>------------------------------------------- </h3>
         <s:form action="InsertBook" namespace="/" >
          请输入要添加书的信息：
        <table>
            <tr>
                <td><s:text name="Book.ISBN"/></td>
                <td><s:textfield name="book.ISBN"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.Title"/></td>
                <td><s:textfield name="book.Title"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.AuthorID"/></td>
                <td><s:textfield name="book.AuthorID"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.Publisher"/></td>
                <td><s:textfield name="book.Publisher"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.PublishDate"/></td>
                <td><s:textfield name="book.PublishDate"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.Price"/></td>
                <td><s:textfield name="book.Price"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.AuName"/></td>
                <td><s:textfield name="book.AuName"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.AuAge"/></td>
                <td><s:textfield name="book.AuAge"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.AuCountry"/></td>
                <td><s:textfield name="book.AuCountry"/></td>
            </tr>
            <s:submit value="添加" />
        </table>
</s:form>


          <h3>------------------------------------------- </h3>
         <s:form action="UpdateBook" namespace="/" >
          请输入要修改书的信息：
        <table>
           
            <tr>
                <td><s:text name="Book.Title"/></td>
                <td><s:textfield name="book.Title"/></td>
            </tr>
             <tr>
                <td><s:text name="Book.item"/></td>
                <td><s:textfield name="book.ISBN"/></td>
            </tr>
            <tr>
                <td><s:text name="Book.itemvalue"/></td>
                <td><s:textfield name="name"/></td>
            </tr>
           
            <s:submit value="提交" />
        </table>
</s:form>
    </body>
</html>
