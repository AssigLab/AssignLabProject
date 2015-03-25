$(document).ready(function () {
    $("a.new_window").attr("target", "_blank");
});


$('#popup_upload').click(function () {
    var uploadpath = $('#FileUploadExcel').val();
    var fileExtension = uploadpath.substring(uploadpath.lastIndexOf(".") + 1, uploadpath.length);

    if ($('#FileUploadExcel').val().length == 0) {
        // write error message
        return false;
    }

    if (fileExtension == "xls" || fileExtension == "xlsx") {
        //write code for success
    }
    else {
        //error code - select only excel files
        return false;
    }

});



