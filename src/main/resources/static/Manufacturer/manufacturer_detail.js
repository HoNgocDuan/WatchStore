function loadManuEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/manu',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var html = '';
            data.forEach(function (item, index) {
                html += "<tr><td>" + item.id + "</td><td>" + item.name + "</td>" +
                    "<td><a class='detail-id' data-id='" + item.id + "' href='#'>Xem chi tiet</a> |" +
                    "<a class='delete' data-id='" + item.id + "' href='#'>Xoa</a> " +
                    "| <a class='update' href='?id=" + item.id + "'>Sua</a></td></tr>"
            });

            $('#manu_list tbody').html(html);
            updateEvent();
            loadManuDetailEvent();
            deleteEvent();
            loadCreatEvent();

        },
        error: function (err) {
            console.log(err);
        }
    })
}

function updateEvent() {
    console.log('Init update by id');
    $('#manu_list .update').click(function (e) {
        e.preventDefault();
        $('.content').load("Manufacturer/html/manufacturer_detail.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/manu/' + id,
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
                    '                    <label class="bmd-label-floating">Manufacturer name: ' + data.name + '</label>\n' +

                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>'
                $('#form-detail-manu').html(html);
            }

        })
    })

}

function deleteEvent() {
    console.log('init delete event!');

    $('#manu_list .delete').click(function (e) {
        e.preventDefault();
        if (!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: '/delete/' + id,
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

function loadManuDetailEvent() {
    console.log('Init detail by id');
    $('#manu_list .detail-id').click(function (e) {
        e.preventDefault();
        $('.content').load("Manufacturer/html/manufacturer_detail.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/manu/' + id,
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
                    '                    <label class="bmd-label-floating">Manufacturer name: ' + data.name + '</label>\n' +

                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>'
                $('#form-detail-manu').html(html);
            }

        })
    })


}



// $(document).ready(function () {
//     $("#manufacturer-detail").on("click",function (event) {
//         $('.content').load("Manufacturer/html/manufacturer.html");
//         loadManuEvent();
//     });
// });

