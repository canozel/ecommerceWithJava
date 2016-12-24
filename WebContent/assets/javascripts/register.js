/** @author: Salih Can ÖZEL
 * 
 */

$(document).ready(function(){
	   $("form[name='login']").validate({
	    rules: {
	      email: {
	        required: true,
	        email: true
	      },
	      password: {
	        required: true,
	        minlength: 5
	      }
	    },
	    messages: {
	      password: {
	        required: "Lütfen bir şifre girin.",
	        minlength: "Şifre en az 5 karakter olmak zorunda"
	      },
	      email: "Lütfen geçerli bir mail adresi girin."
	    },
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	   
	   //FIX
	   
	    $("input[name=email]").change(function(){
	    	$("#err").remove();
	    	$("#success").remove();
	    	
	    	 $.ajax({
   	        url: "/loginWithValidationJquery/register",
   	        type: "post",
   	        data: {email: $("input[name=email]").val()} ,
   	        success: function (data, status) {
   	        	console.log(data)
   	        	if (data == "true"){
   	        		$("input[name=email]").after('<label id="err" style="color:#ff5b5b">Bu email zaten kullanılmaktadır. </label>');
   	        	} else {
   	        		$("input[name=email]").after('<label id="success" style="color:#78e878">Bu email kullanılabilir.</label>');
   	        	}
   	        },
   	        error: function(jqXHR, textStatus, errorThrown) {
   	           console.log(textStatus, errorThrown);
   	        }
   	    });
	    });	
	});