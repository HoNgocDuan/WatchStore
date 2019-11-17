function loadCreatEvent() {
    $("#form-create-manu").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

    });
    $("#manu-create").on("click", function (event) {
        event.preventDefault();
        $('.content').load("Manufacturer/html/manufacturer_create.html");
        setTimeout(function () {
            createManu();
        }, 200)

    });


}


function createManu() {
    $('#form-create-manu').submit(function (e) {
        e.preventDefault();

        var manu = {};
        manu.name = $('#manu-name').val();
        var manuObjSon = JSON.stringify(manu);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/manu/",
            data: manuObjSon,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $('.content').load("Manufacturer/html/manufacturer.html");
                setTimeout(function () {
                    loadManuEvent();
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