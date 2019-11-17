$(document).ready(function () {
    $("#manufacturer-detail").on("click", function (event) {
        $('.content').load("Manufacturer/html/manufacturer.html");
        loadManuEvent();
    });

    $("#catalog-detail").on("click", function (event) {
        $('.content').load("Catalog/html/catalogdetail.html");
        loadCatalogEvent();
    });

    $("#user-detail").on("click", function (event) {
        $('.content').load("Profile/html/user.html");
        loadUserEvent();
    });
});

