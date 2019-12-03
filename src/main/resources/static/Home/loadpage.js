$(document).ready(function () {
    $("#manufacturer-detail").on("click", function (event) {
        $('.content').load("Manufacturer/html/manufacturer.html");
        loadManuEvent();
    });

    $("#catalog-detail").on("click", function (event) {
        $('.content').load("Catalog/html/catalog.html");
        loadCatalogEvent();
    });

    $("#user-detail").on("click", function (event) {
        $('.content').load("Profile/html/user.html");
        loadUserEvent();
    });

    $("#product-detail").on("click", function (event) {
        $('.content').load("Products/html/products.html");
        loadProductEvent();
    });

    $("#comment-detail").on("click", function (event) {
        $('.content').load("Comment/html/comment.html");
        loadCommentEvent();
    });

});

