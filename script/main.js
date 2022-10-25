$(document).ready(function() {
    
});

let animateInterval;

$("#switch").change(function() {
    if ($('#switch').prop('checked') == true) {
        $("img").on("hover", () => {
            alert("Virus detected!! Download free nordic vpnfor delete");
        });
        function colorChange() {
            let r = Math.floor(Math.random()*256);
            let g = Math.floor(Math.random()*256);
            let b = Math.floor(Math.random()*256);
            let color = rgbToHex(r,g,b);
            $("body").css("background-color", color);
            }
        $("body").on("mousemove", colorChange);
        function componentToHex(c) {
            var hex = c.toString(16);
            return hex.length == 1 ? "0" + hex : hex;
        }
        
        function rgbToHex(r, g, b) {
            return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
        }
        $("img").animate({width: '400'}, "slow");
        $("img").animate({width: '200'}, "slow");
        animateInterval = setInterval(() => {
            $("img").animate({width: '400'}, "slow");
            $("img").animate({width: '200'}, "slow");
        }, 1000);
    } else if ($('#switch').prop('checked') == false) {
        //$("html").remove();
        clearInterval(animateInterval);
        $("body").off("mousemove", colorChange);
        $("img").off("hover", () => {
            alert("Virus detected!! Download free nordic vpnfor delete");
        });
        $("body").css("background-color", "#181818");
    }
});