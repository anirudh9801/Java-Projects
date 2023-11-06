<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Issue Books</title>
</head>
<body>
    <div class="container">
        <jsp:include page="Menu.jsp" />
        <h1>Issue Books</h1>
        
        <!-- Search Book by ID Form -->
        <form action="IssueBooksServlet" method="post">
            <h2>Search Book by ID</h2>
            <label for="bookId">Book ID:</label>
            <input type="text" id="bookId" name="bookId" required>
            <input type="submit" value="Search Book">
        </form>
        
        <!-- Display Search Results -->
        <c:if test="${searchResult ne null}">
            <p>${searchResult}</p>
        </c:if>

        <!-- Issue Books Form -->
        <form action="IssueBooksServlet" method="post">
            <table border="3" align="center">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Department</th>
                    <th>Total Books</th>
                    <th>Select</th>
                </tr>
                <c:forEach var="book" items="${booksList}">
                    <tr>
                        <td>${book.getId()}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getEdition()}</td>
                        <td>${book.getDept()}</td>
                        <td>${book.getNoOfBooks()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${book.getNoOfBooks() > 0}">
                                    <input type="checkbox" name="selectedBooks" value="${book.getId()}" />
                                </c:when>
                                <c:otherwise>
                                    <span>Out of stock</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br />
            <input type="submit" value="Issue Selected Books" />
        </form>
    </div>
</body>
</html>
