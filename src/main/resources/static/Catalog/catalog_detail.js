function deleteCataEvent() {
    console.log('init delete event!');

    $('#cata_list .delete').click(function (e) {
        e.preventDefault();
        if (!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: 'cata/delete/' + id,
            type: 'DELETE',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                currentRow.remove();
            },
            error: function (err) {
                console.log('error when delete', err);
            }
        });
    });
}

function loadCatalogDetailEvent() {
    console.log('Init detail by id');
    $('#cata_list .detail-id').click(function (e) {
        e.preventDefault();
        $('.content').load("Catalog/html/catalog_detail.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/cata/' + id,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                var html = ' <div class="row">\n' +
                    '            <div class="col-md-6">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Id: ' + data.id + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Name: ' + data.catalogName + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Title: ' + data.catalogTitle + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Description ' + data.catalogDescription + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Status ' + data.status + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '<button type="submit" class="btn btn-primary pull-right" id="manufacturer-detail">Back</button>'
                $('#form-detail-catalog').html(html);
            }

        })
    })


}

function loadCatalogEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/cata',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var html = '';
            data.forEach(function (item, index) {
                html += "<tr><td>" + item.id + "</td>" +
                    "<td>" + item.catalogName + "</td>" +
                    "<td>" + item.catalogDescription + "</td>" +
                    "<td>" + item.catalogTitle + "</td>" +
                    "<td>" + item.status + "</td>" +
                    "<td><a class='detail-id' data-id='" + item.id + "' href='#'>Xem chi tiet</a> |" +
                    "<a class='delete' data-id='" + item.id + "' href='#'>Xoa</a> " +
                    "| <a class='update' href='?id=" + item.id + "'>Sua</a></td></tr>"
            });

            $('#cata_list tbody').html(html);
            deleteCataEvent();
            loadCreatCataEvent();
            loadCatalogDetailEvent();
        },
        error: function (err) {
            console.log(err);
        }
    })
}

