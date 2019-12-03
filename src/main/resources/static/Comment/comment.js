function loadCommentEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/comment',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var html = '';
            $.each(data,function (index, item) {
                html += "<tr><td>" + item.id + "</td>" +
                    "<td>" + item.content + "</td>" +
                    "<td>" + item.status + "</td>" +
                    "<td><a class='detail-id' data-id='" + item.id + "' href='#'>Xem chi tiet</a> |" +
                    "<a class='delete' data-id='" + item.id + "' href='#'>Xoa</a> " +
                    "| <a class='update' href='?id=" + item.id + "'>Sua</a></td></tr>"
            });

            $('#comment_list tbody').html(html);
            loadCommentDetailEvent();
            deleteCommentEvent();
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function loadCommentDetailEvent() {
    console.log('Init detail by id');
    $('#comment_list .detail-id').click(function (e) {
        e.preventDefault();
        $('.content').load("Comment/html/comment_detail.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/comment/' + id,
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
                    '                    <label class="bmd-label-floating">Content: ' + data.content + '</label>\n' +
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
                    '                    <label class="bmd-label-floating">Status ' + data.status + '</label>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '       </div>'+
                    '<button type="submit" class="btn btn-primary pull-right" id="manufacturer-detail">Back</button>'
                $('#form-detail-comment').html(html);
            }

        })
    })


}

function deleteCommentEvent() {
    console.log('init delete event!');

    $('#comment_list .delete').click(function (e) {
        e.preventDefault();
        if (!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: 'comment/delete/' + id,
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