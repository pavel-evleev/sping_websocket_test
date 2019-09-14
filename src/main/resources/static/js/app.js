var stompClient = null;

function connect() {
    var socket = new SockJS('/api/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe("/topic", function (greeting) {
            showGreeting(greeting);
        });
    });
}

function notified() {
    stompClient.send("/api/websocket/message", {}, JSON.stringify({message: "message client"}));
}

function showGreeting(message) {
    console.log(message);
}

$(function () {
    $("#connect").click(function () {
        connect();
    });
});

$(function () {
    $("#notified").click(function () {
        notified();
    });
});
