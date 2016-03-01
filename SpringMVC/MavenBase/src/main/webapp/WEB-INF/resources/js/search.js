$(document).ready(function(){
   
    $('#search').click(function(){

        var data = {
            
            teach_id:$('#teach_id').val(),
            course_id:$('#course_id').val(),
        };
        
        data = JSON.stringify(data);
        var token = $("input[name='_csrf']").val();

        $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
            jqXHR.setRequestHeader('X-CSRF-Token', token);
            jqXHR.setRequestHeader('Accept', 'application/json');
        });
        
        $.ajax({
            url:"/admin/search",
            method:'POST',
            data:data,
            contentType: 'application/json',
            dataType: 'json',
            success:function(data){
                buildCourseInfo(data);
            },
            error:function(data){
                console.log(data);
            }
        });
    });
});

function buildCourseInfo(data){
    $('.result').empty();
    if(data.teach.length > 0){
        
        $('.result').append('<h2>' + data.teach[0] + ' course ' + data.course[0] + '</h2>');
        $('.result').append('<h3>Has next students:</h3>');
        for(var i = 0; i < data.stud.length; i++){
            
            $('.result').append('<h3>' + data.stud[i] +'</h3>');
        }
        
        
    }
}


