function deleteCataEvent() {
    console.log('init delete event!');

    $('#cata_list .delete').click(function(e) {
        e.preventDefault();
        if(!confirm('Do you want to delete this item?')) {
            return;
        }

        console.log('call to delete!');
        var id = $(this).attr('data-id');
        var currentRow = $(this).parent().parent();

        $.ajax({
            url: 'cata/delete/'+id,
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

function loadCatalogEvent() {
    console.log('Init list event');
    $.ajax({
        url: '/cata',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var html = '';
            data.forEach(function(item, index) {
                html += "<tr><td>"+ item.id + "</td>" +
                    "<td>" + item.catalogName + "</td>" +
                    "<td>"+ item.catalogDescription +"</td>" +
                    "<td>"+ item.catalogTitle +"</td>" +
                    "<td>"+ item.status +"</td>" +
                    "<td><a class='delete' data-id='"+item.id+"' href='#'>Xoa</a> | <a class='update' href='?id="+item.id+"'>Sua</a></td></tr>"
            });

            $('#cata_list tbody').html(html);
            deleteCataEvent();
            loadCreatCataEvent();
        },
        error: function(err) {
            console.log(err);
        }
    })
}

