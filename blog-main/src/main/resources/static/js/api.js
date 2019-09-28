const api = {
    api_url: "",

    category_add(data) {
        let url = "/category";
        return ajax(url, "POST", data, true);
    }

}


const deleteAlert = {
    title: '确认删除嘛?',
    text: '删除后，您将无法恢复此数据！',
    icon: 'warning',
    buttons: {
        cancel: "取消",
        confirm: "确定"
    },
    dangerMode: true,
};