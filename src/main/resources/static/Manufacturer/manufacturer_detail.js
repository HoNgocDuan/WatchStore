function loadSearchEvent() {
    console.log('Init serach event');

    var name =
    $.ajax({
        url: '/manu/search/ + name',
        type: 'GET',
    })
}
function listEmployeeByPageNumber(numberPage) {
    $.ajax({
        url: '/manufacturer/paging',
        type: 'GET',
        data:{"numberPage":numberPage},
        dataType: 'json',
        success: function (data) {
            var html = '';
            var keys = Object.keys(data);
            var values = Object.values(data);
            var pageNumberHtml = "";
            if(keys>1) {
                for (var page = 0; page < keys; page++) {
                    if (keys > 1) {
                        pageNumberHtml+=" <li class=\"page-item\"><a class=\"page-link\">"+page+"</a></li>";
                    }

                }
                $("#page-manu").html(pageNumberHtml);
            }
            $.each(data,function (index,item) {
                $.each(item,function (j,val) {
                    html += "<tr><td>" + val.id + "</td><td>" + val.name + "</td>" +
                        "<td><a class='detail-id' data-id='" + val.id + "' href='#'>Xem chi tiet</a> |" +
                        "<a class='delete' data-id='" + val.id + "' href='#'>Xoa</a> " +
                        "| <a class='update' href='?id=" + val.id + "'>Sua</a></td></tr>"

                });
                $('.page-link').on("click",function (event) {
                    event.preventDefault();
                    listEmployeeByPageNumber($(this).text());
                });

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
function loadManuEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/manufacturer/paging',
        type: 'GET',
        data:{"numberPage":0},
        dataType: 'json',
        success: function (data) {
            var html = '';
            var keys = Object.keys(data);
            var values = Object.values(data);
            var pageNumberHtml = "";
            if(keys>1) {
                for (var page = 0; page < keys; page++) {
                    if (keys > 1) {
                        pageNumberHtml+=" <li class=\"page-item\"><a class=\"page-link\">"+page+"</a></li>";
                    }

                }
                $("#page-manu").html(pageNumberHtml);
            }
            $.each(data,function (index,item) {
                $.each(item,function (j,val) {
                    html += "<tr><td>" + val.id + "</td><td>" + val.name + "</td>" +
                        "<td><a class='detail-id' data-id='" + val.id + "' href='#'>Xem chi tiet</a> |" +
                        "<a class='delete' data-id='" + val.id + "' href='#'>Xoa</a> " +
                        "| <a class='update' href='?id=" + val.id + "'>Sua</a></td></tr>"

                });
                $('.page-link').on("click",function (event) {
                    event.preventDefault();
                    listEmployeeByPageNumber($(this).text());
                });

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
                    '<button type="submit" class="btn btn-primary pull-right" id="manufacturer-detail">Back</button>'+
                    ' </div>'
                $('#form-detail-manu').html(html);
            }

        })
    })


}


