define(["jquery","bootstrap","bootstrap-newsbox"],function($){
	
	  
			$('#myCarousel').carousel({
				  interval: 2000
				})
	
		    $(".demand_new").bootstrapNews({
	            newsPerPage: 5,
	            autoplay: true,
				pauseOnHover:true,
	            direction: 'up',
	            newsTickerInterval: 4000,
	            onToDo: function () {
	            }
	        });
			
			$(".demand_hot").bootstrapNews({
	            newsPerPage: 4,
	            autoplay: true,
				pauseOnHover: true,
				navigation: true,
	            direction: 'down',
	            newsTickerInterval: 2500,
	            onToDo: function () {
	            }
	        });

	        $("#news").bootstrapNews({
	            newsPerPage: 3,
	            autoplay: false,	            
	            onToDo: function () {
	            }
	        });
});