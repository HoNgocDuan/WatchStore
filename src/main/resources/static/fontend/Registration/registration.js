function createEmployee() {
    $('#content').load("templates/login.html", function (response, status, http) {
        $("#button-list-employee").on("click",function (event) {

            //stop submit the form, we will post it manually.
            event.preventDefault();
            createEmployee();

        });

    //    if(status=="success") {
            $('button-submit-employee').on("click",function (event) {
                event.preventDefault();
                var user = {};
                user.username = $('#username').val();
                user.firstname = $('#firstname').val();
                user.lastname = $('#lastname').val();
                user.birtDate = $('#birth-date').val();
                user.address = $('#address').val();
                user.phoneNumber = $('#phoneNumber').val();
                user.facebookUrl = $('#facebook-url').val();
                user.occupation = $('#occupation').val();
                user.interests = $('#interests').val();
                user.active = $("input[name='activeradio']:checked").val();
                user.roleName = $( "#roleName option:selected" ).val();
                user.gender = $( "#gender option:selected" ).val();
                user.username = $('#username').val();
                var userJonObj = JSON.stringify(user);
                $.ajax({
                    url: "/user/create",
                    type: "POST",
                    dataType: "json",
                    data: userJonObj,
                    contentType: 'application/json',
                    cache: false,
                    success: function (data) {
                        // Handle upload success
                        // ...

                        alert(data);

                    },
                    error: function (xhr, status, error) {
                        var err = eval("(" + xhr.responseText + ")");
                        alert(err.message);
                    }
                });
            });

       // }

        if(status=="error"){

            alert("Error: " + http.status + " " + http.statusText);
        }
    });

}