let initPage = () => {
    let temp = new URLSearchParams(window.location.search).get("pageNo");
    let data;
    if (temp == null) {
        data = {"pageNo": 1}
    } else {
        data = {"pageNo": temp}
    }
    $.ajax({
        url: "/board/printList",
        method: "GET",
        data: data,
        success: (message) => {
            let result = JSON.parse(message);
            let array = result.data;
            console.log(array);
        }
    });
}
