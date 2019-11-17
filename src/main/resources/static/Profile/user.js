function loadUserEvent() {
    $("#user-detail").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/profile",
        cache: false,
        success: function (data) {
            $('#content').load('Profile/html/user.html',function (response,status,http) {
                if(status == "success"){
                    $('#name-current-user').html(data.username);
                    $('.profile-usertitle-job').html(data.roleNameVietNamese);
                    $('.img-responsive').attr('src',"data:image/png;base64,"+data.imageBase64+"");
                    $('#avatar-header').attr('src',"data:image/png;base64,"+data.imageBase64+"");
                    $('#firstname').val(data.firstname);
                    $('#lastname').val(data.lastname);
                    $('#facebook-url').val(data.facebookUrl);
                    $('#occupation').val(data.occupation);
                    $('#interests').val(data.interests);
                    $('#phoneNumber').val(data.phoneNumber);
                    $('#description').val(data.description);
                    // $('#home').on("click", function() {
                    //     loadhomepage();
                    // });
                    // $('#edit_profile').on("click", function() {
                    //     employee_edit();
                    // });
                    // $('#update-avatar-button').on("click", function() {
                    //     upDateAvatar();
                    //
                    // });
                    // $('#button-update-profile').on("click", function() {
                    //     updateInforUser();
                    //
                    // });
                    // $('#button-change-password').on("click", function(event) {
                    //     event.preventDefault();
                    //     updatePassword();
                    //
                    // });
                    $("#user-detail").prop("disabled", false);
                }

                if(status == "error"){
                    alert("Error: " + http.status + " " + http.statusText);
                }
            });

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#content').html(json);
            $("#edit_profile").prop("disabled", false);
            console.log("ERROR : ", e);
        }
    });

}