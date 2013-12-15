/**
 * marksRoutesTracks.js
 *
 * Define the actions for the submenu marksRoutesTracks.
 * 
 */
 
$(document).ready(function() {    
    var lastSearch = {};
    var active = "#marks";
    var method = {};
    
    
    method["#marks"] = function(search) {
        console.log("Search in marks "+search);
    };
    
    method["#routes"] = function(search) {
        console.log("Search in routes "+search);
    };
    
    method["#tracks"] = function(search) {
        console.log("Search in tracks "+search);
    };

    menu.addCallback('leftclick', 'marksRoutesTracks', function (self) {
        self.button('toggle');
        $('.active-marksRoutesTracks').removeClass('active-marksRoutesTracks').addClass('inactive-marksRoutesTracks');
        $(self.data('name')).removeClass('inactive-marksRoutesTracks').addClass('active-marksRoutesTracks');
        
        lastSearch[active] = $('#search-marksRoutesTracks').val();
        active = self.data('name');
        $('#search-marksRoutesTracks').val(lastSearch[active]);  
    });
    
    $("#search-marksRoutesTracks").keyup( function(event) {
        method[active]($('#search-marksRoutesTracks').val());
        event.stopPropagation();
        event.preventDefault();
    });
    
    menu.addCallback('leftclick', 'icon-selectedMark', function (self) {
        self.removeClass('icon-selectedMark').addClass('icon-notSelectedMark');
        map.hideMark(self.data('id'));
    });
    
    menu.addCallback('leftclick', 'icon-notSelectedMark', function (self) {
        self.removeClass('icon-notSelectedMark').addClass('icon-selectedMark');
        map.visibleMark(self.data('id'));
    });
    
    menu.addCallback('leftclick', 'icon-selectedRoute', function (self) {
        self.removeClass('icon-selectedRoute').addClass('icon-notSelectedRoute');
        map.hideRoute(self.data('id'));
    });
    
    menu.addCallback('leftclick', 'icon-notSelectedRoute', function (self) {
        $('.icon-selectedRoute').removeClass('icon-selectedRoute').addClass('icon-notSelectedRoute');
        self.removeClass('icon-notSelectedRoute').addClass('icon-selectedRoute');
        map.visibleRoute(self.data('id'));
    });
});