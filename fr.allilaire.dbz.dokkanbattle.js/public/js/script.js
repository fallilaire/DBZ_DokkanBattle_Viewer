$('#cardModal').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget); // Button that triggered the modal
	var cardId = button.data('a_cardid'); // Extract info from data-* attributes
	var cardUrl = "http://localhost:1337/api/card/" + cardId;
	// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	var modal = $(this);

	$.ajax({
    	type: 'GET',
        url: cardUrl,
        success: function(result) {
			modal.find('#card_name').text(result.name);
			modal.find('#card_maxLvl').text(result.maxLvl);
			modal.find('#card_minRarity').text(result.minRarity);
			modal.find('#card_type').text(result.type);
			modal.find('#card_minCost').text(result.minCost);
			modal.find('#card_leaderSkill').text(result.leaderSkill);
			modal.find('#card_superAtk').text(result.superAtk);
			modal.find('#card_passiveSkill').text(result.passiveSkill);
			modal.find('#card_linkSkill').text(result.linkSkill);
			modal.find('#card_obtain').text(result.obtain);
			modal.find('#card_addInfo').text(result.addInfo);
			modal.find('#card_icon').attr("src", result.icon);
			modal.find('#card_kiMeter').attr("src", result.kiMeter);
			modal.find('#card_img').attr("src", result.img);
        }
    });
});

$('.notowned').on('click', function (event) {
	var cardId = $( this ).attr('data-btn_cardid');
	var cardUrl = "http://localhost:1337/api/card/" + cardId;
	$.ajax({
        type: 'GET',
        url: cardUrl,
        success: function(result) {
	    	result.owned = true;
		    $.ajax({
        	    type: 'PUT',
        	    url: cardUrl,
			    data: result,
  			    success: function(data) {
    			    console.log('The card is now owned : ' + cardId);
				    let currentBtn = $("[data-btn_cardid='" + cardId + "']");
				    currentBtn.removeClass('notowned').addClass('owned').html('O');
					reloadButton(currentBtn, cardId);
  			    }
		    });
        }
    });
});

$('.owned').on('click', function (event) {
    var cardId = $( this ).attr('data-btn_cardid');
	var cardUrl = "http://localhost:1337/api/card/" + cardId;
	$.ajax({
        type: 'GET',
        url: cardUrl,
        success: function(result) {
			result.owned = false;
			$.ajax({
        		type: 'PUT',
        		url: cardUrl,
				data: result,
  				success: function(data) {
    				console.log('The card is no longer owned');
					let currentBtn = $("[data-btn_cardid='" + cardId + "']");
					currentBtn.removeClass('owned').addClass('notowned').html('X');
					reloadButton(currentBtn, cardId);
  				}
			});
        }
    });
});

function reloadButton(button, buttonId) {
	console.log('reload');
	button.off('click');
	button.on('click', function() {
		var cardUrl = "http://localhost:1337/api/card/" + buttonId;
		$.ajax({
       		type: 'GET',
       		url: cardUrl,
        	success: function(result) {
				result.owned = !result.owned;
				$.ajax({
        			type: 'PUT',
        			url: cardUrl,
					data: result,
  					success: function(data) {
						if (result.owned) {
							console.log('Reloaded - The card is now owned');
							button.removeClass('notowned').addClass('owned').html('O');
						}
						else {
							console.log('Reloaded - The card is no longer owned');
							button.removeClass('owned').addClass('notowned').html('X');
						}
  					}
				});
        	}
    	});
  	});
}
