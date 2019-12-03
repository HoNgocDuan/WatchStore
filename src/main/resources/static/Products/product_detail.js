function loadProductEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/product',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var html = '';
            data.forEach(function (item, index) {
                html += "<tr><td>" + item.id + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.price + "</td>" +
                    "<td>" + item.createDate + "</td>" +
                    "<td>" + item.description + "</td>" +
                    "<td><a class='detail-id' data-id='" + item.id + "' href='#'>Xem chi tiet</a> |" +
                    "<a class='delete' data-id='" + item.id + "' href='#'>Xoa</a> " +
                    "| <a class='update' href='?id=" + item.id + "'>Sua</a></td></tr>"
            });

            $('#pro_list tbody').html(html);
            loadProductDetailEvent();
            deleteProductEvent();
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function loadProductDetailEvent() {
    console.log('Init detail by id');
    $('#pro_list .detail-id').click(function (e) {
        e.preventDefault();
        $('.content').load("Products/html/product_detail.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/product/' + id,
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
                    '                    <label class="bmd-label-floating">Name: ' + data.name + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Catalog: ' + data.catalogs + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Price: ' + data.price + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Discount: ' + data.discount + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Title: ' + data.title + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Description: ' + data.description + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Image: ' + data.image + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Manufacturer: ' + data.manufacturers + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">View: ' + data.view + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Create Date: ' + data.createDate + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">UpdateDate: ' + data.updateDate + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '        <div class="row">\n' +
                    '            <div class="col-md-12">\n' +
                    '                <div class="form-group">\n' +
                    '                    <label class="bmd-label-floating">Status: ' + data.status + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '<button type="submit" class="btn btn-primary pull-right" id="manufacturer-detail">Back</button>'
                $('#form-detail-pro').html(html);
            }

        })
    })


}

function deleteProductEvent() {
    console.log('init delete event!');

    $('#pro_list .delete').click(function (e) {
        e.preventDefault();
        if (!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: 'product/delete/' + id,
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