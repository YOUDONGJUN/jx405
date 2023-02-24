let writeReply = () => {
    let formData = {
        "content": $('#input-reply').val(),
        "boardId": new URLSearchParams(window.location.search).get("id"),
    };

    $.ajax({
        url: "/reply/write",
        method: "post",
        data: formData,
        success: (message) => {
            let response = JSON.parse(message);
            if (response.status == "fail") {
                Swal.fire({
                    title: "!!! ERROR !!!",
                    text: "에러가 발생하였습니다.",
                    icon: "error"
                })
            }
            location.reload();
        }
    })
}

function printReply(boardId) {
    let sendData = {
        "boardId": boardId
    }
    $.ajax({
        url: "/reply/selectAll",
        method: "get",
        data: sendData,
        success: (message) => {
            let response = JSON.parse(message);
            console.log(response);
            let replyArray = JSON.parse(response.list);
            console.log(replyArray);
        }
    })
}















