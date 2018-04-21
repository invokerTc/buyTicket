maxtime = 4 * 60 + 59 //半个小时，按秒计算，自己调整!
function getcode() {
    var tele = $("#telephone").val();
    var selectSets = $(".ticket");
    if (selectSets.length != 0) {
        $("#codeButton").attr("disabled", true);
        timer = setInterval("CountDown()", 1000);
        $.post("/message/getCode", {telephone: tele}, function (data) {
            var result = JSON.parse(data);
            if (result.code == 1) {
                alert(result.msg);
            } else if (result.code == 0) {
                alert(result.msg);
            }
        });
    } else {
        alert("请先选择座位");
    }

}
function CountDown() {
    if (maxtime >= 0) {
        $("#codeButton").css("color", "red");
        $("#codeButton").val("重新获取(" + maxtime + ")");
        var val = $("#codeButton").val();
        --maxtime;
    }
    else {
        $("#codeButton").val("获取验证码");
        $("#codeButton").attr("disabled", false);
        clearInterval(timer);
        maxtime = 4 * 60 + 59;
    }
}
function conmmitCart() {
    var tele = $("#telephone").val();
    var watchingTime = $("#watchingTime").text();
    var filmName = $("#filmName").text();
    var theaterName = $("#theaterName").text();
    var hallName = $("#hallName").text();
    var hallMovieId = $("#hallMovieId").text();
    var selectSeat = $(".selected");
    var length = selectSeat.length;
    var seatsIds = "";
    for (var i = 0; i < length; i++) {
        var dataId = selectSeat.eq(i).attr("data-id");
        seatsIds += dataId + ",";
    }
    var selectSets = $(".ticket");
    var sets = "";
    for (var i = 0; i < selectSets.length; i++) {
        sets += selectSets.eq(i).text() + ",";
    }
    var sumPrice = $("#sumPrice").text();
    alert(seatsIds + "====" + hallMovieId);
    alert(filmName + "---" + watchingTime + "---" + theaterName + "----" + hallName + "----" + sumPrice + "----" + sets);
    $.post("/cart/conmmit",
        {
            telephone: tele,
            movieName: filmName,
            watchingTime: watchingTime,
            cinemaName: theaterName,
            hallName: hallName,
            totalPrice: sumPrice,
            selectedSets: sets,
            seatsIds: seatsIds,
            hallMovieId: hallMovieId
        },
        function (data) {
            if (data == "success") {
                alert("订单提交成功");
            } else {
                alert(data + "已经被预订");
            }
        });
}
function codeCheck() {
    var code = $("#inputCode").val();
    var regex = /^[0-9]{6}$/;
    if (code.match(regex)) {
        $.post("/message/check",
            {inputCode: code},
            function (data) {
                if (data == "验证码错误") {
                    alert("请输入正确的验证码");
                    $("#inputCode").val("");
                    /*window.location.href = '/cart/showBooking?tele='+tele+'&hallName='+hallName+'&watchingTime='+watchingTime;*/
                }
            });
    } else {
        alert("验证码格式不正确");
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
            $.post("/user/queryByTel", {tele: tele}, function (data) {
                var parse = JSON.parse(data);
                if (parse.code == 0) {
                    $("#codeButton").attr("disabled", false);
                } else {
                    alert("请您先注册");
                }
            });
        } else {
            /!*$("#teleSpan").text("手机号格式错误");*!/
            $("#codeButton").attr("disabled", true);
        }
    } else {
        /!*$("#teleSpan").text("请输入手机号");*!/
        $("#codeButton").attr("disabled", true);
    }
}

