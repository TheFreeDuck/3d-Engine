$(document).ready(function() {
    
});

$("#crazyMode").click(function() {
    $("img").hover(function() {
        alert("Virus detected!! Download free nordic vpnfor delete");
    });
    $("body").mousemove(function() {
    let r = Math.floor(Math.random()*256);
    let g = Math.floor(Math.random()*256);
    let b = Math.floor(Math.random()*256);
    let color = rgbToHex(r,g,b);
        $("body").css("background-color", color);
    });
    function componentToHex(c) {
        var hex = c.toString(16);
        return hex.length == 1 ? "0" + hex : hex;
    }
    
    function rgbToHex(r, g, b) {
        return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
    }
    function animate() {
        $("img").animate({width: '400'}, "slow");
	    $("img").animate({width: '200'}, "slow");
        animate();
    }
    animate();
});