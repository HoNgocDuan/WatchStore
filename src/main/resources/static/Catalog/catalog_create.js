function loadCreatCataEvent() {
    $("#form-create-cata").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

    });
    $("#catalog-create").on("click", function (event) {
        event.preventDefault();
        $('.content').load("Catalog/html/catalog_create.html");
        setTimeout(function () {
            createCata();
        }, 200)

    });


}


function createCata() {
    $('#form-create-cata').submit(function (e) {
        e.preventDefault();

        var cata = {};
        cata.catalogName = $('#cata-name').val();
        cata.catalogDescription = $('#cata-description').val();
        cata.catalogTitle = $('#cata-title').val();
        cata.status = $('#status').val();
        var cataObjSon = JSON.stringify(cata);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/cata/",
            data: cataObjSon,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $('.content').load("Catalog/html/catalogdetail.html");
                setTimeout(function () {
                    loadCatalogEvent();
                }, 200);
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });
        return false;
    });
}