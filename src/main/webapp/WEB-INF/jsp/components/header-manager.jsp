<html>
    <head>
        <style rel="stylesheet"></style>
    </head>
    <!--<%@ taglib prefix="c" uri="jakarta.tags.core" %>-->
    <header>
    <div class="logo">
        <a href="/">Green</a>
    </div>
    <div class="links">
        <a href="/orders-manager-view">View Orders</a>
        <a href="/order-status-update">Update Order Status</a>
        <a href="/product-add">Add Product</a>
        <a href="/product-update">Update Product</a>
        <a href="/feedback-list">View Feedback</a>
        <c:choose>
            <c:when test="${isLoggedIn}">
                <a href="/logout">Logout</a>
            </c:when>
    </div>
    </header>
</html>