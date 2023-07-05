<header>

    <div class="container-fluid">

        <div class="navb-logo">
            <img src="images/image.png" alt="Logo">
        </div>

        <div class="navb-items d-none d-xl-flex">

            <div class="item">
                <a href="${pageContext.request.contextPath}/shop?command=shop_redirect">Home</a>
            </div>

            <div class="item">
                <a href="${pageContext.request.contextPath}/shop?command=redirect_to_cart">Cart
                    <div class="circle">${sessionScope.cart.getTotalSize()}</div>
                </a>
            </div>

            <div class="item">
                <a href="${pageContext.request.contextPath}/shop?command=redirect_to_account">Account</a>
            </div>

            <div class="item">
                <a href="#">About</a>
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
                        <img src="images/image.png" alt="Logo">
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