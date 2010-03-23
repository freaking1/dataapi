$(document).ready(function(){
    $("#button").click(function(){
        if($("#suburb").val()==""&&$("#postal").val()==""){
            alert("Please at least input either suburb name or postal code you want to query!");
        } else {
            $("form:first").submit();
        }
    })
})
