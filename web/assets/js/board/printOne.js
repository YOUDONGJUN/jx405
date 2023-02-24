let initPage = () => {
    let temp = new URLSearchParams(window.location.search).get("id");
    let data;
    data = {"id": temp}

    $.ajax({
        url: "/board/printOne",
        method: "GET",
        data: data,
        success: (message) => {
            let result = JSON.parse(message);
            if (result.status == 'success') {
                let data = JSON.parse(result.data);
                console.log(data);
            } else {
                Swal.fire({
                    title: "!!! ERROR !!!",
                    text: result.message,
                    icon: "error"
                }).then(() => {
                    location.href = "/board/printList.jsp?pageNo=1";
                })
            }
        }
    });
}