function getcode() {
        var tele = $("#telephone").val();
        $.post("/message/getCode", {telephone: tele}, function (data) {
            var result = JSON.parse(data);
            if (result.code == 1) {
                alert(result.msg);
            } else if (result.code == 0) {
                alert(result.msg);
            }
        });
    }
function codeLogin() {
    var code = $("#inputCode").val();
    var regex = /^[0-9]{6}$/
    if (code.match(regex)) {
        alert("验证成功");
        $.post("/message/login", {inputCode: code}, function (data) {
            alert(data);
            if (data == "订单提交成功") {
                alert(data);
                window.location.href = "/success.html"
            }
            if (data == "订单提交失败") {
                alert(data);
            }
        });
    } else {
        alert("请输入正确的验证码");
        $("#inputCode").val("");
    }
}
function acquireFocus() {
    $("#teleSpan").text("");
}
function checkTele() {
    var tele = $("#telephone").val();
    var patrn = /^[1]([3]|[5]|[8]){1}[0-9]{9}$/;
    if (tele != "") {
        if (tele.match(patrn)) {
            $("#codeButton").attr("disabled", false);
        } else {
            $("#teleSpan").text("手机号格式错误");
            $("#codeButton").attr("disabled", true);
        }
    } else {
        /*$("#teleSpan").text("请输入手机号");*/
        $("#codeButton").attr("disabled", true);
    }
}
var count = 0;
$(".checkbox").click(function () {
    if (this.checked) {
        count++;
        var price = parseFloat($("#originprice").text());
        var sumprice = count * price;
        $("#sumprice").text(sumprice);
        var val = $(this).val();
        var setfirst = $(".set").eq(0).text();
        if (setfirst == "还未选择座位") {
            $(".set").eq(0).text("");
        }
        /*alert(val);*/
        var len = $(".set").length;
        for (var i = 0; i < len; i++) {
            var text = $(".set").eq(i).text();
            if (text == "") {
                $(".set").eq(i).text(val);
                break;
            }
        }
    } else {
        count--;
        var price = parseFloat($("#originprice").text());
        var sumprice = count * price;
        $("#sumprice").text(sumprice);
        var dd = $(this).val();
        /* alert(dd + "被撤销了");*/
        var len = $(".set").length;
        for (var i = 0; i < len; i++) {
            var text = $(".set").eq(i).text();
            if (text == dd) {
                $(".set").eq(i).text("");
                break;
            }
        }
    }
});
function bookingset() {
    var len = $(".set").length;
    alert("订单提交");
    var orderlist = ",";
    for (var i = 0; i < len; i++) {
        var text = $(".set").eq(i).text();
        if (text != "") {
            orderlist = orderlist + text + ","
        }
    }
    var sum = $("#sumprice").text();
    /* alert("总价：" + sum);*/
    $.post("/order/saveOrder", {sum: sum, orderlist: orderlist},
        function (data) {
            if (data == "success") {
                window.location.href = "/countdown.html"
            }
        }
    );
}