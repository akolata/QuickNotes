(function ($) {

    $(document).ready(function () {


        function add_tootle_to_cards() {

            cards = $('.card');

            if(cards.length > 3){
                for(var i = 3; i < cards.length; i++){
                    var card = cards[i];

                    $(card).on('click', function () {
                       var currect_card = $(this);
                       currect_card.children('.card-block').toggle();
                    });
                }
            }
        }

        add_tootle_to_cards();

    });

})(jQuery);