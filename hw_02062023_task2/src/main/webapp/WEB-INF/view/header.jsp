<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="container-fluid">

        <div class="navb-logo">
            <img src="${contextPath}/images/logo.png" alt="Logo">
        </div>

        <div class="navb-items d-none d-xl-flex">

            <div class="item">
                <a href="${contextPath}/sneakersShop/catalog">Home</a>
            </div>

            <div class="item">
                <a href="${contextPath}/sneakersShop/cart">Cart</a>
                <div class="circle">
                    <c:choose>
                        <c:when test="${empty sessionScope.cart}">0</c:when>
                        <c:otherwise>${sessionScope.cart.totalSize}</c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="item">
                <a href="${contextPath}/sneakersShop/account">Account</a>
            </div>

            <div class="item">
                <a href="${contextPath}/sneakersShop/search">Search</a>
            </div>

            <div class="item-button">
                <a href="#" type="button">Sales</a>
            </div>
        </div>

        <!-- Button trigger modal -->
        <div class="mobile-toggler d-lg-none">
            <a href="#" data-bs-toggle="modal" data-bs-target="#navbModal">
                <i class="fa-solid fa-bars"></i>
            </a>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="navbModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <img src="../../images/logo.png" alt="Logo">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i
                                class="fa-solid fa-xmark"></i></button>
                    </div>

                    <div class="modal-body">

                        <div class="modal-line">
                            <i class="fa-solid fa-house"></i><a href="#">Home</a>
                        </div>

                        <div class="modal-line">
                            <i class="fa-solid fa-bell-concierge"></i><a href="#">Cart</a>
                        </div>

                        <div class="modal-line">
                            <i class="fa-solid fa-file-lines"></i> <a href="#">Account</a>
                        </div>

                        <div class="modal-line">
                            <i class="fa-solid fa-circle-info"></i><a href="#">About</a>
                        </div>

                        <a href="#" class="navb-button" type="button">Sales</a>
                    </div>

                    <div class="mobile-modal-footer">

                        <a target="_blank" href="#"><i class="fa-brands fa-instagram"></i></a>
                        <a target="_blank" href="#"><i class="fa-brands fa-linkedin-in"></i></a>
                        <a target="_blank" href="#"><i class="fa-brands fa-youtube"></i></a>
                        <a target="_blank" href="#"><i class="fa-brands fa-facebook"></i></a>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js
    "></script>
</header>