$(document).ready(function(){

    
    var demo2 = $('.students').bootstrapDualListbox();
    demo2.trigger('bootstrapDualListbox.refresh' , true);
    
    $('#send').click(function(){

        var data = {
            
            teach_id:$('#teach_id').val(),
            course_id:$('#course_id').val(),
            students:$('.students').val()
        };
        
        data = JSON.stringify(data);
        var token = $("input[name='_csrf']").val();
        console.log("TOKEN" + token);
        $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
            jqXHR.setRequestHeader('X-CSRF-Token', token);
            jqXHR.setRequestHeader('Accept', 'application/json');
        });
        $.ajax({
            url:"/add",
            method:'POST',
            data:data,
            contentType: 'application/json',
            dataType: 'json',
            success:function(data){
                console.log(data);
            },
            error:function(data){
                console.log(data);
            }
        });
    });
});


