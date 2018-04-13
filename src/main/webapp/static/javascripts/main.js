
// console.log("test");
var sortCheckbox = false;
var totalElements = 0;
var count = 0;
var productPages = 0;
var elements = 0;

function showPages(pages) {
    for (let i = 0; i < pages.length; i++){
        $('<a href="page-' + pages[i] + '">   ' + pages[i] + '   </a>', {text: pages[i]}).appendTo("#showPages");

    }
}

function check() {
    if(sortCheckbox){
        document.getElementById("sortPrice").checked = true;
    } else {
        document.getElementById("sortPrice").checked = false;
    }
}

$("#apply").click(function () {
    var sort = document.getElementById('sortPrice').checked;
    if(sort){
        sort = ""+sort;
        $.ajax({
            url:'/sortPrice',
            type:'post',
            data:sort,
            contentType:'text/plain',
            success:function (responce) {
                sortCheckbox = responce;

                $.ajax({
                    url:'/allProducts',
                    type:'get',
                    success:function (product) {
                        $("#showAll").empty();
                        check();
                        productPars(product[1]);

                    },
                    error:function () {
                        console.log("error");
                    }
                });

            },
            error:function () {
                console.log("error");
            }
        });
    } else {
        sort = ""+sort;
        $.ajax({
            url:'/sortPrice',
            type:'post',
            data:sort,
            contentType:'text/plain',
            success:function (responce) {
                sortCheckbox = responce;

                $.ajax({
                    url:'/allProducts',
                    type:'get',
                    success:function (product) {
                        $("#showAll").empty();
                        check();
                        productPars(product[1]);

                    },
                    error:function () {
                        console.log("error");
                    }
                });

            },
            error:function () {
                console.log("error");
            }
        });
    }

});

function productPars(product) {
    for (let i = 0; i < product.length; i++){
        $('<img src="' + product[i].image + '" height="100px">', {text: product[i].laptopModel}).appendTo("#showAll");
        $('<p><a href="' + product[i].laptopModel + '">' + product[i].laptopModel + '</a></p>', {text: product[i].laptopModel}).appendTo("#showAll");
        $('<p>Price: ' + product[i].price + '</p>', {text: product[i].price}).appendTo("#showAll");
        $('<p>CPU: ' + product[i].processor + '</p>', {text: product[i].processor}).appendTo("#showAll");
        $('<p>Screen Diagonal: ' + product[i].screenDiagonal + '"</p>', {text: product[i].screenDiagonal}).appendTo("#showAll");
        $('<p>RAM: ' + product[i].amountOfRAM + '</p>', {text: product[i].amountOfRAM}).appendTo("#showAll");
        $('<p>HDD: ' + product[i].driveCapacity + ' Gb</p>', {text: product[i].driveCapacity}).appendTo("#showAll");
        $('<p>GPU: ' + product[i].graphicAdapter + '</p>', {text: product[i].graphicAdapter}).appendTo("#showAll");
        $('<p>Description: ' + product[i].briefCharacteristics + '</p>', {text: product[i].briefCharacteristics}).appendTo("#showAll");
        $('<hr />').appendTo("#showAll");
    }
}

$(document).ready(function(){

    $.ajax({
        url:'/allProducts',
        type:'get',
        success:function (product) {
            $("#showAll").empty();
            elements = product[3];
            productPages = product[2].length;
            totalElements = productPages * elements;
            count+=elements;
            sortCheckbox = product[4];
            check();
            productPars(product[1]);
        },
        error:function () {
            console.log("error");
        }
    });



});

$("#prev").click(function () {
    $.ajax({
        url:'/prev',
        type:'get',
        success:function (product) {
            $("#showAll").empty();
            check();
            productPars(product[1]);

        },
        error:function () {
            console.log("error: prev");
        }
    });
});

$("#next").click(function () {
    $.ajax({
        url:'/next',
        type:'get',
        success:function (product) {
            $("#showAll").empty();
            check();
            productPars(product[1]);
        },
        error:function () {
            console.log("error: next");
        }
    });
});


$("#more").click(function () {

    if(count != totalElements) {
        $.ajax({
            url: '/more',
            type: 'get',
            success: function (product) {
                count+=elements;
                check();
                productPars(product[1]);
            },
            error: function () {
                console.log("error: next");
            }
        });
    } else {
        $("#showMore").empty();
        $('<button type="button" disabled>show more</button>').appendTo("#showMore");
    }

});

// $("#sort").click(function () {
//     $.ajax({
//         url:'/sort',
//         type:'get',
//         success:function (product) {
//             $("#showAll").empty();
//             check();
//             productPars(product[1]);
//         },
//         error:function () {
//             console.log("error");
//         }
//     });
// });
//
// $("#reset").click(function () {
//     $.ajax({
//         url:'/allProducts',
//         type:'get',
//         success:function (product) {
//             $("#showAll").empty();
//             check();
//             productPars(product[1]);
//         },
//         error:function () {
//             console.log("error");
//         }
//     });
// });
