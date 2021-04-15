<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Yesterday</title>
        <style type="text/css">
            body {
                background: ${bean.backgroundColor};
                color: ${bean.foregroundColor}
            }
        </style>
    </head>
    <body>
        <h2>Yesterday</h2>

        Yesterday,<br/>
        All my troubles seemed so far away,<br/>
        Now it looks as though they're here to stay,<br/>
        Oh, I believe in yesterday.<br/>
        <br/>
        Suddenly,<br/>
        I'm not half the man I used to be,<br/>
        There's a shadow hanging over me,<br/>
        Oh, yesterday came suddenly.<br/>
        <br/>
        Why she<br/>
        Had to go I don't know, she wouldn't say.<br/>
        I said,<br/>
        Something wrong, now I long for yesterday.<br/>

        <p>
            <!-- Released: <c:out value="${releaseDate}" /> -->
            Released: [default] <fmt:formatDate value="${releaseDate}" type="date" dateStyle="default"/> <br />
            Released: [short] <fmt:formatDate value="${releaseDate}" type="date" dateStyle="short"/> <br />
            Released: [medium] <fmt:formatDate value="${releaseDate}" type="date" dateStyle="medium"/> <br />
            Released: [long] <fmt:formatDate value="${releaseDate}" type="date" dateStyle="long"/> <br />
            Released: [full] <fmt:formatDate value="${releaseDate}" type="date" dateStyle="full"/> <br />
        </p>
        <c:if test="${!empty members}">
            <c:choose>
                <c:when test="${bean.border}"><table border></c:when>
                <c:otherwise><table></c:otherwise>
            </c:choose>
                <tr><th>The Beatles</th></tr>
                <c:forEach var="member" items="${members}">
                    <tr><td>${member}</td></tr>
                </c:forEach>
            </table>
        </c:if>
                    
        <a href="yesterday.html">powrót</a>
    </body>
</html>
