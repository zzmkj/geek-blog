const api = {
    api_url: "",

    category_add(data) {
        let url = "/category";
        return ajax(url, "POST", data, true);
    },
    form_add(data) {
        let url = "/form/add";
        return ajax(url, "POST", data, true);
    },
    form_item_name(name, id) {
        let url = "/formItem/name/" + id + "/" + name;
        return ajax(url, "GET");
    },
    form_item_type(type, id) {
        let url = "/formItem/type/" + id + "/" + type;
        return ajax(url, "GET");
    },
    form_item_sort(sortArr) {
        let url = "/formItem/sort?ids=" + sortArr;
        return ajax(url, "GET");
    }
};


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