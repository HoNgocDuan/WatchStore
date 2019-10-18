function updateEvent() {
    console.log('init update event');
    $('#manu_list .update').click(function (e) {
        event.preventDefault();
        $('.content').load("Manufacturer/html/manufacturer_create.html");

    })
    // console.log('Init list event');
    // $.ajax({
    //     url: '/manu',
    //     type: 'GET',
    //     dataType: 'json',
    //     success: function(data) {
    //         var html = '';
    //         data.forEach(function(item, index) {
    //             html += "<tr><td>"+ item.id + "</td><td>" + item.name + "</td>" +
    //                 "<td><a class='delete' data-id='"+item.id+"' href='#'>Xoa</a> " +
    //                 "| <a class='update' href='?id="+item.id+"'>Sua</a></td></tr>"
    //         });
    //
    //         $('#manu_list tbody').html(html);
    //         deleteEvent();
    //         loadCreatEvent();
    //     },
    //     error: function(err) {
    //         console.log(err);
    //     }
    // })
}

function deleteEvent() {
    console.log('init delete event!');

    $('#manu_list .delete').click(function(e) {
        e.preventDefault();
        if(!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: '/delete/'+id,
            type: 'DELETE',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                currentRow.remove();
            },
            error: function(err) {
                console.log('error when delete', err);
            }
        });
    });
}

function loadManuDetailEvent() {
    console.log('Init detail by id');
    $('#manu_list .detail-id').click(function (e) {
        e.preventDefault();
        $('.content').load("Manufacturer/html/manufacturer_create.html");

        console.log('call to detail id');
        var id = $(this).attr('data-id');

        $.ajax({
            url: '/manu/'+id,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                var html = '';

            }
        })
    })


}

function loadManuEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/manu',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var html = '';
            data.forEach(function(item, index) {
                html += "<tr><td>"+ item.id + "</td><td>" + item.name + "</td>" +
                    "<td><a class='detail-id' data-id='"+item.id+"' href='#'>Xem chi tiet</a> |" +
                    "<a class='delete' data-id='"+item.id+"' href='#'>Xoa</a> " +
                    "| <a class='update' href='?id="+item.id+"'>Sua</a></td></tr>"
            });

            $('#manu_list tbody').html(html);
            loadManuDetailEvent();
            deleteEvent();
            loadCreatEvent();
        },
        error: function(err) {
            console.log(err);
        }
    })
}

// $(document).ready(function () {
//     $("#manufacturer-detail").on("click",function (event) {
//         $('.content').load("Manufacturer/html/manufacturer.html");
//         loadManuEvent();
//     });
// });

