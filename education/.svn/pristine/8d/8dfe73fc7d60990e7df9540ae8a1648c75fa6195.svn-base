<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript" >
$(document).ajaxStart(onStart)
               .ajaxComplete(onComplete)
               .ajaxError(onError)
               .ajaxSuccess(onSuccess);
   
    function onStart(event) {
    	//alert("start");
    }
    function onComplete(event, xhr, settings) {
        //alert("onComplete");
    }
    function onSuccess(event, xhr, settings) {
        //alert("onSuccess");
    }
    function onError(XMLHttpRequest, textStatus, errorThrown) {
        if(textStatus.status == 900){
        	window.location.href = textStatus.responseText;
        } else if(textStatus.status == 500) {
        	window.location.href = eduHostPath + "/page/error/500.htm";
        }
    }
</script>
