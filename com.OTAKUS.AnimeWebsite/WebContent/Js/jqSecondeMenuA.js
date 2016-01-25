$( document ).ready(function() {
		
				$("#sec2").hide();
				$("#sec3").hide();
				//$(".episodeN").hide();
				$("#a1").click(function(){
					// $(".episodeN").hide();
					 $("#sec1").show();
					 $("#sec3").hide();
					 $("#sec2").hide();
				//	 $("#sec1 h2").text('Add Episode');
					// $("#sec1 form input[name='addepisode']").val('Add Episode');
					 
				});
					$("#a2").click(function(){
					// $(".episodeN").show();
					 $("#sec2").show();
					 $("#sec3").hide();
					 $("#sec1").hide();
				//	 $("#sec1 h2").text('Update Episode');
					// $("#sec1 form input[name='addepisode']").val('Update Episode');
					 
					 
					 
				});
				$("#a3").click(function(){
					 $("#sec1").hide();
					 $("#sec2").hide();
					 $("#sec3").show();
					 
				});
		
		
		});