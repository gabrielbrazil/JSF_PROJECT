$(document).ready(function() {

	$("#formProduct\\:price").maskMoney({
		prefix : 'R$',
		suffix : '',
		affixesStay : true,
		thousands : '.',
		decimal : ',',
		precision : 2,
		allowZero : false,
		allowNegative : false
	});
	
	$("#formProduct\\:price").maskMoney('unmasked');

});